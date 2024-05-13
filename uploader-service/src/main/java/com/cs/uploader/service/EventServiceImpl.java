package com.cs.uploader.service;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cs.uploader.model.Event;
import com.cs.uploader.repository.EventRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Max.Alencar
 */
@Service
public class EventServiceImpl implements EventService {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<Event> findAll() {
        return repository.findAll().log();
    }

    @Override
    public Mono<Event> findById(String id) { return repository.findById(id).log(); }

    @Override
    public Mono<Event> save(Event event) {
        return repository.save(event).log();
    }

    @Override
    public Flux<Event> saveAll(List<Event> events) {
        return Flux.fromIterable(events).doOnNext(event -> {
            logger.info("Creating event with details {}", event);
            repository.save(event);
        }).doOnError(throwable -> {
            logger.error("Error in creating event", throwable);
        }).log();
    }
}
