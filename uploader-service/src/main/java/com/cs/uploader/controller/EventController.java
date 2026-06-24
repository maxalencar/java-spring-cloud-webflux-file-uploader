package com.cs.uploader.controller;

import com.cs.uploader.model.Event;
import com.cs.uploader.service.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ResolvableType;
import org.springframework.core.codec.StringDecoder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Collections;
import java.util.Objects;

/**
 * @author Max.Alencar
 */
@RestController
public class EventController {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Event> getAllEvents() {
        logger.info("Getting all events...");
        return service.findAll();
    }

    @PostMapping()
    public Mono<ResponseEntity<Void>> upload(@RequestPart(value = "file", required = false) FilePart part) {
        if (part == null) {
            logger.info("No file part provided, returning Bad Request");
            return Mono.just(ResponseEntity.badRequest().build());
        }
        logger.info("Uploading file {}...", part.filename());

        ObjectMapper mapper = new ObjectMapper();
        StringDecoder decoder = StringDecoder.allMimeTypes();

        Flux<String> output = decoder.decode(part.content(), ResolvableType.forClass(String.class), null, Collections.emptyMap());

        // Process content into events, compute finished events, and persist them
        Flux<Event> processed = output.sort()
            .map(x -> readValue(mapper, x))
            .groupBy(Event::getId)
            .flatMap(groupedFlux -> groupedFlux.collectList()
                .filter(list -> list.size() == 2)
                .filter(list -> !Objects.equals(list.getFirst().getState(), list.get(1).getState()))
                .map(list -> {
                    Event finished = list.get(0);
                    Event open = list.get(1);
                    finished.setTimestamp(finished.getTimestamp() - open.getTimestamp());
                    finished.setAlert(finished.getTimestamp() > 4);
                    return finished;
                })
            );

        // Trigger async save for each event without awaiting completion
        processed
            .doOnNext(event -> service.save(event).subscribe())
            .subscribe(); // fire-and-forget
        return Mono.just(ResponseEntity.ok().<Void>build());
    }

    private Event readValue(ObjectMapper mapper, String x) {
        try {
            return mapper.readValue(x, Event.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
