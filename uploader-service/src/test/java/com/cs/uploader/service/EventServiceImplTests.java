package com.cs.uploader.service;

import com.cs.uploader.model.Event;
import com.cs.uploader.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EventServiceImplTests {

    @Mock
    EventRepository repository;

    @InjectMocks
    EventServiceImpl service;

    @Test
    void saveAllPersistsEachEvent() {
        Event e1 = new Event();
        e1.setId("1");
        Event e2 = new Event();
        e2.setId("2");
        when(repository.save(any(Event.class))).thenReturn(Mono.just(new Event()));

        List<Event> list = List.of(e1, e2);
        Flux<Event> result = service.saveAll(list);
        // subscribe to trigger processing
        result.collectList().block();

        verify(repository, times(2)).save(any(Event.class));
    }
}
