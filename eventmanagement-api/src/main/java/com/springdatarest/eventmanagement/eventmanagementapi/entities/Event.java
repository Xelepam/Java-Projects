package com.springdatarest.eventmanagement.eventmanagementapi.entities;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

// Good example of OOP/Inheritance
@Entity
public class Event extends AbstractEntity {

    private String name;
    private String description;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private ZoneId zoneId;
    private Boolean started;

    // Organizer can organize/create many events or many events can belong to an organizer
    // FetchType.EAGER or .LAZY : tells the underlying Object-Relational Mapping (ORM)
    // - in this case it is Hibernate -
    // how quickly it should fetch the organizer information when we fetch the event right away
    // EAGER = right away (default)
    // LAZY = fetch the organizer information only when the organizer information is being used
    // in the application
    // CascadeType.ALL : Whenever an organizer is deleted all of his events are also deleted
    // not required in this instance - if we were to delete and event we would want to leave the
    // the organizer alone - if an event is deleted the organizer would also be deleted along with
    // other events associated with him
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Organizer organizer;

    // Implement a Set because the participants are unique
    // An Event can have many participants
    // orphanRemoval = true : (false by default) if participants are not associated with an event
    // delete them
    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Participant> participants;

    // Many events can happen at a venue
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // exported = false : tells spring data rest not to export this association as a link
    // and instead we will create the venue as part of the event
    @RestResource(exported = false)
    private Venue venue;

    // This violates REST principal, should not be exposing id for your applications
    public long getResourceId() { return this.id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }

    public Boolean getStarted() {
        return started;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    // Used to compare equality of two objects: shallow vs. deep
    @Override
    public boolean equals(Object obj) {
        return Objects.equals(id, ((Event) obj).id);
    }

    // It returns the hashcode value as an Integer for the object on which this method is invoked.
    // Hashcode value is mostly used in hashing based collections like
    // HashMap, HashSet, HashTable….etc. This method must be overridden in
    // every class which overrides equals() method.
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
