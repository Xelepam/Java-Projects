package com.springdatarest.eventmanagement.eventmanagementapi.repositories;

import com.springdatarest.eventmanagement.eventmanagementapi.entities.Participant;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {
}
