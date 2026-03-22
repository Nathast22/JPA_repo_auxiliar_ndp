package org.example.tallerjpa.repository;

import org.example.tallerjpa.entity.UserEvent;
import org.example.tallerjpa.entity.keys.UserEventId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEventRepository extends JpaRepository<UserEvent, UserEventId> {
}
