package org.example.tallerjpa.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_trainer")
    private User trainer;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    private long assignmentDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getTrainer() {
        return trainer;
    }

    public void setTrainer(User trainer) {
        this.trainer = trainer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(long assignmentDate) {
        this.assignmentDate = assignmentDate;
    }
}
