package org.example.tallerjpa.service.impl;

import org.example.tallerjpa.entity.Permission;
import org.example.tallerjpa.entity.Role;
import org.example.tallerjpa.entity.RolePermission;
import org.example.tallerjpa.repository.RoleRepository;
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
class RoleServiceImplTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleServiceImpl roleService;

    @Test
    void shouldSaveRoleWhenHasPermissions() {
        Role role = new Role();
        role.setName("ADMIN");

        Permission permission = new Permission();
        permission.setId(1);
        permission.setName("READ_USERS");

        RolePermission rolePermission = new RolePermission();
        rolePermission.setRole(role);
        rolePermission.setPermission(permission);

        role.setRolePermissions(List.of(rolePermission));

        when(roleRepository.save(role)).thenReturn(role);

        Role savedRole = roleService.save(role);

        assertNotNull(savedRole);
        assertEquals("ADMIN", savedRole.getName());
        verify(roleRepository, times(1)).save(role);
    }

    @Test
    void shouldThrowExceptionWhenSavingRoleWithoutPermissions() {
        Role role = new Role();
        role.setName("ADMIN");
        role.setRolePermissions(Collections.emptyList());

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> roleService.save(role)
        );

        assertEquals("Un rol debe tener al menos un permiso asignado.", exception.getMessage());
        verify(roleRepository, never()).save(any(Role.class));
    }

    @Test
    void shouldReturnAllRoles() {
        Role role1 = new Role();
        role1.setId(1);
        role1.setName("ADMIN");

        Role role2 = new Role();
        role2.setId(2);
        role2.setName("USER");

        when(roleRepository.findAll()).thenReturn(Arrays.asList(role1, role2));

        List<Role> roles = roleService.findAll();

        assertEquals(2, roles.size());
        assertEquals("ADMIN", roles.get(0).getName());
        assertEquals("USER", roles.get(1).getName());
        verify(roleRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnRoleByIdWhenExists() {
        Role role = new Role();
        role.setId(1);
        role.setName("ADMIN");

        when(roleRepository.findById(1)).thenReturn(Optional.of(role));

        Optional<Role> result = roleService.findById(1);

        assertTrue(result.isPresent());
        assertEquals("ADMIN", result.get().getName());
        verify(roleRepository, times(1)).findById(1);
    }

    @Test
    void shouldReturnEmptyWhenRoleDoesNotExist() {
        when(roleRepository.findById(99)).thenReturn(Optional.empty());

        Optional<Role> result = roleService.findById(99);

        assertTrue(result.isEmpty());
        verify(roleRepository, times(1)).findById(99);
    }

    @Test
    void shouldDeleteRoleById() {
        doNothing().when(roleRepository).deleteById(1);

        roleService.deleteById(1);

        verify(roleRepository, times(1)).deleteById(1);
    }
}
