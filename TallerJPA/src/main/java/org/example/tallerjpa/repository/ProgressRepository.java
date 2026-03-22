package org.example.tallerjpa.repository;

import org.example.tallerjpa.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressRepository extends JpaRepository<Progress, Integer> {
}
