package org.example.tallerjpa.service.impl;


import org.example.tallerjpa.entity.Role;
import org.example.tallerjpa.repository.RoleRepository;
import org.example.tallerjpa.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        if (role.getRolePermissions() == null || role.getRolePermissions().isEmpty()) {
            throw new IllegalArgumentException("Un rol debe tener al menos un permiso asignado.");
        }
        return roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        List<Role> result = new ArrayList<>();
        roleRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return roleRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        roleRepository.deleteById(id);
    }
}
