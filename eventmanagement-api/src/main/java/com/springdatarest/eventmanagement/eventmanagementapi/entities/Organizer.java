package com.springdatarest.eventmanagement.eventmanagementapi.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Organizer extends AbstractEntity {

    private String name;

    // Implement a Set because the events are unique
    // One organizer can be organizing many events
    // mapping is happening from the organizer on to the event
    @OneToMany(mappedBy = "organizer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Event> events;

    public long getResourceId() { return this.id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(id, ((Organizer) obj).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
