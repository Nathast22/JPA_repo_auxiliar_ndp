package org.example.tallerjpa.entity;

import jakarta.persistence.*;
import org.example.tallerjpa.entity.keys.UserEventId;

@Entity
@Table(name = "user_events")
public class UserEvent {

    @EmbeddedId
    private UserEventId id;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "id_usuario")
    private User user;

    @ManyToOne
    @MapsId("event_id")
    @JoinColumn(name = "id_evento")
    private Event event;

    public UserEventId getId() {
        return id;
    }

    public void setId(UserEventId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
