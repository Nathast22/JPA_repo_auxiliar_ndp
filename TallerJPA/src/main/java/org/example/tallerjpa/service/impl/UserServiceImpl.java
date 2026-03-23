package org.example.tallerjpa.service.impl;


import org.example.tallerjpa.entity.User;
import org.example.tallerjpa.repository.UserRepository;
import org.example.tallerjpa.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (user.getUserRoles() == null || user.getUserRoles().isEmpty()) {
            throw new IllegalArgumentException("Un usuario debe tener al menos un rol asignado.");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        userRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
