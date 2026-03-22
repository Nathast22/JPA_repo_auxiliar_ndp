package org.example.tallerjpa.repository;

import org.example.tallerjpa.entity.UserRole;
import org.example.tallerjpa.entity.keys.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
}
