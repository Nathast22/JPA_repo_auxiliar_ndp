package org.example.tallerjpa.service.impl;

import org.example.tallerjpa.entity.Permission;
import org.example.tallerjpa.repository.PermissionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PermissionServiceImplTest {

    @Mock
    private PermissionRepository permissionRepository;

    @InjectMocks
    private PermissionServiceImpl permissionService;

    @Test
    void shouldSavePermission() {
        Permission permission = new Permission();
        permission.setName("READ_USERS");

        when(permissionRepository.save(permission)).thenReturn(permission);

        Permission savedPermission = permissionService.save(permission);

        assertNotNull(savedPermission);
        assertEquals("READ_USERS", savedPermission.getName());
        verify(permissionRepository, times(1)).save(permission);
    }

    @Test
    void shouldReturnAllPermissions() {
        Permission permission1 = new Permission();
        permission1.setId(1);
        permission1.setName("READ_USERS");

        Permission permission2 = new Permission();
        permission2.setId(2);
        permission2.setName("WRITE_USERS");

        when(permissionRepository.findAll()).thenReturn(Arrays.asList(permission1, permission2));

        List<Permission> permissions = permissionService.findAll();

        assertEquals(2, permissions.size());
        assertEquals("READ_USERS", permissions.get(0).getName());
        assertEquals("WRITE_USERS", permissions.get(1).getName());
        verify(permissionRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnPermissionByIdWhenExists() {
        Permission permission = new Permission();
        permission.setId(1);
        permission.setName("READ_USERS");

        when(permissionRepository.findById(1)).thenReturn(Optional.of(permission));

        Optional<Permission> result = permissionService.findById(1);

        assertTrue(result.isPresent());
        assertEquals("READ_USERS", result.get().getName());
        verify(permissionRepository, times(1)).findById(1);
    }

    @Test
    void shouldReturnEmptyWhenPermissionDoesNotExist() {
        when(permissionRepository.findById(99)).thenReturn(Optional.empty());

        Optional<Permission> result = permissionService.findById(99);

        assertTrue(result.isEmpty());
        verify(permissionRepository, times(1)).findById(99);
    }

    @Test
    void shouldDeletePermissionById() {
        doNothing().when(permissionRepository).deleteById(1);

        permissionService.deleteById(1);

        verify(permissionRepository, times(1)).deleteById(1);
    }
}

