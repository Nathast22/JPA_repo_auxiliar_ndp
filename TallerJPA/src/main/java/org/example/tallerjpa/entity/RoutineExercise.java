package org.example.tallerjpa.entity;

import jakarta.persistence.*;
import org.example.tallerjpa.entity.keys.RoutineExerciseId;

@Entity
@Table(name = "routine_exercises")
public class RoutineExercise {

    @EmbeddedId
    private RoutineExerciseId id;

    @ManyToOne
    @MapsId("routine_id")
    @JoinColumn(name = "id_rutina")
    private Routine routine;

    @ManyToOne
    @MapsId("exercise_id")
    @JoinColumn(name = "id_ejercicio")
    private Exercise exercise;

    private Integer order;
    private Integer repetitions;
    private Integer duration;

    public RoutineExerciseId getId() {
        return id;
    }

    public void setId(RoutineExerciseId id) {
        this.id = id;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
