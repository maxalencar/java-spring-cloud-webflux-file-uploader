package com.cs.uploader.service;

import java.util.List;

import com.cs.uploader.model.Event;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author Max.Alencar
 *
 */
public interface EventService {
	Flux<Event> findAll();
	Mono<Event> findById(String id);
	Mono<Event> save(Event event);
	Flux<Event> saveAll(List<Event> events);	
}
