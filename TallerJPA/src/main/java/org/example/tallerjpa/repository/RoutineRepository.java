package org.example.tallerjpa.repository;

import org.example.tallerjpa.entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineRepository extends JpaRepository<Routine, Integer> {
}
