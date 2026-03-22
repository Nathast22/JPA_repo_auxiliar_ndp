package org.example.tallerjpa.repository;

import org.example.tallerjpa.entity.RoutineExercise;
import org.example.tallerjpa.entity.keys.RoutineExerciseId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineExerciseRepository extends JpaRepository<RoutineExercise, RoutineExerciseId> {
}
