package com.cs.upload.repository;

import org.springframework.data.repository.CrudRepository;

import com.cs.upload.model.Event;

/**
 * 
 * @author Max.Alencar
 *
 */
public interface EventRepository extends CrudRepository<Event, String> {

}
