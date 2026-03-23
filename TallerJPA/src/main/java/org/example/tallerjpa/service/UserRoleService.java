package org.example.tallerjpa.service;



import org.example.tallerjpa.entity.UserRole;
import org.example.tallerjpa.entity.keys.UserRoleId;

import java.util.List;
import java.util.Optional;

public interface UserRoleService {

    UserRole save(UserRole userRole);

    List<UserRole> findAll();

    Optional<UserRole> findById(UserRoleId id);

    void deleteById(UserRoleId id);
}
