package com.springdatarest.eventmanagement.eventmanagementapi.repositories;

import com.springdatarest.eventmanagement.eventmanagementapi.entities.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
