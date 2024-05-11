package com.cs.uploader.repository;

import org.springframework.data.repository.CrudRepository;

import com.cs.uploader.model.Event;

/**
 * 
 * @author Max.Alencar
 *
 */
public interface EventRepository extends CrudRepository<Event, String> {

}
