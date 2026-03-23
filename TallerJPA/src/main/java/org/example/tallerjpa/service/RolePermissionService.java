package org.example.tallerjpa.service;



import org.example.tallerjpa.entity.RolePermission;
import org.example.tallerjpa.entity.keys.RolePermissionId;

import java.util.List;
import java.util.Optional;

public interface RolePermissionService {

    RolePermission save(RolePermission rolePermission);

    List<RolePermission> findAll();

    Optional<RolePermission> findById(RolePermissionId id);

    void deleteById(RolePermissionId id);
}
