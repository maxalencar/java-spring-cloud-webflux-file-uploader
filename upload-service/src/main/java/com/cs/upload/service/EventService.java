package com.cs.upload.service;

import java.util.List;

import com.cs.upload.model.Event;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author Max.Alencar
 *
 */
public interface EventService {
	
	Flux<Event> findAll();
	Mono<Event> save(Event event);
	Flux<Event> saveAll(List<Event> events);	
}
