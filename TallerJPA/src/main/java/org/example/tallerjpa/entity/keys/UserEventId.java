package org.example.tallerjpa.entity.keys;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserEventId implements Serializable {

    private Integer user_id;
    private Integer event_id;

    public UserEventId() {}

    public UserEventId(Integer user_id, Integer event_id) {
        this.user_id = user_id;
        this.event_id = event_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEventId that = (UserEventId) o;
        return Objects.equals(user_id, that.user_id) && Objects.equals(event_id, that.event_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, event_id);
    }
}
