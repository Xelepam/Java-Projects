package com.springdatarest.eventmanagement.eventmanagementapi.repositories;

import com.springdatarest.eventmanagement.eventmanagementapi.entities.Venue;
import org.springframework.data.repository.CrudRepository;

public interface VenueRepository extends CrudRepository<Venue, Long> {
}
