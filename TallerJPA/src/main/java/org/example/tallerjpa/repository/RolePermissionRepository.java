package org.example.tallerjpa.repository;

import org.example.tallerjpa.entity.RolePermission;
import org.example.tallerjpa.entity.keys.RolePermissionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepository extends JpaRepository<RolePermission, RolePermissionId> {
}
