package org.example.tallerjpa.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "progress")
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_progress;

    private long date;
    private int repetitions;
    private int time;
    private int leveleffort;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_ejercicio")
    private Exercise exercise;

    private Integer id_rutina;

    public Integer getId_progress() {
        return id_progress;
    }

    public void setId_progress(Integer id_progress) {
        this.id_progress = id_progress;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getLeveleffort() {
        return leveleffort;
    }

    public void setLeveleffort(int leveleffort) {
        this.leveleffort = leveleffort;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Integer getId_rutina() {
        return id_rutina;
    }

    public void setId_rutina(Integer id_rutina) {
        this.id_rutina = id_rutina;
    }
}
