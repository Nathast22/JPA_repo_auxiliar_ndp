package org.example.tallerjpa.repository;

import org.example.tallerjpa.entity.Space;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceRepository extends JpaRepository<Space, Integer> {
}
