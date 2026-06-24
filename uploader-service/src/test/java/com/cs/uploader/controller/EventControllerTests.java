package com.cs.uploader.controller;

import com.cs.uploader.model.Event;
import com.cs.uploader.service.EventService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;
import java.io.FileNotFoundException;

/**
 * Simplified controller tests without Spring Boot test infrastructure.
 * Directly binds the {@link EventController} to a {@link WebTestClient}.
 */
class EventControllerTests {

    @Test
    void uploadNoFile() {
        EventService mockService = Mockito.mock(EventService.class);
        EventController controller = new EventController(mockService);
        WebTestClient client = WebTestClient.bindToController(controller).build();

        client.post()
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void uploadFile() {
        EventService mockService = Mockito.mock(EventService.class);
        // mock save returns empty Mono
        Mockito.when(mockService.save(Mockito.any(Event.class))).thenReturn(Mono.empty());

        EventController controller = new EventController(mockService);
        WebTestClient client = WebTestClient.bindToController(controller).build();

        MultipartBodyBuilder bodyBuilder = new MultipartBodyBuilder();
        bodyBuilder.part("file", new ClassPathResource("upload-file-test.txt"));

        client.post()
                .body(BodyInserters.fromMultipartData(bodyBuilder.build()))
                .exchange()
                .expectStatus().isOk();
    }
}
