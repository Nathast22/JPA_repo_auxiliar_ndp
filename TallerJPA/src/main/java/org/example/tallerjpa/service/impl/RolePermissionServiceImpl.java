package org.example.tallerjpa.service.impl;


import org.example.tallerjpa.entity.RolePermission;
import org.example.tallerjpa.entity.keys.RolePermissionId;
import org.example.tallerjpa.repository.RolePermissionRepository;
import org.example.tallerjpa.service.RolePermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionRepository rolePermissionRepository;

    public RolePermissionServiceImpl(RolePermissionRepository rolePermissionRepository) {
        this.rolePermissionRepository = rolePermissionRepository;
    }

    @Override
    public RolePermission save(RolePermission rolePermission) {
        return rolePermissionRepository.save(rolePermission);
    }

    @Override
    public List<RolePermission> findAll() {
        return rolePermissionRepository.findAll();
    }

    @Override
    public Optional<RolePermission> findById(RolePermissionId id) {
        return rolePermissionRepository.findById(id);
    }

    @Override
    public void deleteById(RolePermissionId id) {
        rolePermissionRepository.deleteById(id);
    }
}
