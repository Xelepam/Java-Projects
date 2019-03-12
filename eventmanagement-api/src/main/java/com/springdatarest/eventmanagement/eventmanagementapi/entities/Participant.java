package com.springdatarest.eventmanagement.eventmanagementapi.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Participant extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private Boolean checkedIn;

    // Many participants can be apart of one event
    // nullable = false : column cannot be blank
    // updatable = false : column cannot be updated after creation
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "ID", nullable = false, updatable = false)
    private Event event;

    public long getResourceId() { return this.id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(id, ((Participant) obj).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
