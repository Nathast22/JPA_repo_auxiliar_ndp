package org.example.tallerjpa.service.impl;

import org.example.tallerjpa.entity.Role;
import org.example.tallerjpa.entity.User;
import org.example.tallerjpa.entity.UserRole;
import org.example.tallerjpa.repository.UserRepository;
import org.example.tallerjpa.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void shouldSaveUserWhenHasRoles() {
        User user = new User();
        user.setName("Isabella");
        user.setEmail("isa@mail.com");

        Role role = new Role();
        role.setId(1);
        role.setName("ADMIN");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        user.setUserRoles(List.of(userRole));

        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.save(user);

        assertNotNull(savedUser);
        assertEquals("Isabella", savedUser.getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void shouldThrowExceptionWhenSavingUserWithoutRoles() {
        User user = new User();
        user.setName("Isabella");
        user.setEmail("isa@mail.com");
        user.setUserRoles(Collections.emptyList());

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.save(user)
        );

        assertEquals("Un usuario debe tener al menos un rol asignado.", exception.getMessage());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void shouldReturnAllUsers() {
        User user1 = new User();
        user1.setId(1);
        user1.setName("Ana");

        User user2 = new User();
        user2.setId(2);
        user2.setName("Luis");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userService.findAll();

        assertEquals(2, users.size());
        assertEquals("Ana", users.get(0).getName());
        assertEquals("Luis", users.get(1).getName());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnUserByIdWhenExists() {
        User user = new User();
        user.setId(1);
        user.setName("Isabella");

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        Optional<User> result = userService.findById(1);

        assertTrue(result.isPresent());
        assertEquals("Isabella", result.get().getName());
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    void shouldReturnEmptyWhenUserDoesNotExist() {
        when(userRepository.findById(99)).thenReturn(Optional.empty());

        Optional<User> result = userService.findById(99);

        assertTrue(result.isEmpty());
        verify(userRepository, times(1)).findById(99);
    }

    @Test
    void shouldDeleteUserById() {
        doNothing().when(userRepository).deleteById(1);

        userService.deleteById(1);

        verify(userRepository, times(1)).deleteById(1);
    }
}
