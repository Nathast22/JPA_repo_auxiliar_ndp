package org.example.tallerjpa.repository;

import org.example.tallerjpa.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
