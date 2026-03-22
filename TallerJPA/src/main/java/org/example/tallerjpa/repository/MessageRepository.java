package org.example.tallerjpa.repository;

import org.example.tallerjpa.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
