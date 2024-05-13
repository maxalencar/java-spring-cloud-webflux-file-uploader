package com.cs.uploader.repository;

import com.cs.uploader.model.Event;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Max.Alencar
 */
public interface EventRepository extends ReactiveMongoRepository<Event, String> {
}
