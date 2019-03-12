package com.springdatarest.eventmanagement.eventmanagementapi.repositories;

import com.springdatarest.eventmanagement.eventmanagementapi.entities.Organizer;
import org.springframework.data.repository.CrudRepository;

public interface OrganizerRepository extends CrudRepository<Organizer, Long> {
}
