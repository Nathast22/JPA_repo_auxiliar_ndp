package org.example.tallerjpa.service.impl;

import org.example.tallerjpa.entity.UserRole;
import org.example.tallerjpa.entity.keys.UserRoleId;
import org.example.tallerjpa.repository.UserRoleRepository;
import org.example.tallerjpa.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public Optional<UserRole> findById(UserRoleId id) {
        return userRoleRepository.findById(id);
    }

    @Override
    public void deleteById(UserRoleId id) {
        userRoleRepository.deleteById(id);
    }
}
