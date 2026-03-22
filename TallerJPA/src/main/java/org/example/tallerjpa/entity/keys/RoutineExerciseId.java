package org.example.tallerjpa.entity.keys;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RoutineExerciseId implements Serializable {

    private Integer routine_id;
    private Integer exercise_id;

    public RoutineExerciseId() {}

    public RoutineExerciseId(Integer routine_id, Integer exercise_id) {
        this.routine_id = routine_id;
        this.exercise_id = exercise_id;
    }

    public Integer getRoutine_id() {
        return routine_id;
    }

    public void setRoutine_id(Integer routine_id) {
        this.routine_id = routine_id;
    }

    public Integer getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Integer exercise_id) {
        this.exercise_id = exercise_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoutineExerciseId that = (RoutineExerciseId) o;
        return Objects.equals(routine_id, that.routine_id) && Objects.equals(exercise_id, that.exercise_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routine_id, exercise_id);
    }
}
