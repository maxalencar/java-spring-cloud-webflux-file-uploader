package com.cs.uploader.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.cs.uploader.model.Event;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Max.Alencar
 *
 */
@Repository
public interface EventRepository extends ReactiveMongoRepository<Event, String> {

}
