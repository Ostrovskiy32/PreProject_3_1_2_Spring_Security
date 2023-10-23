package ru.kata.spring.boot_security.demo.servise;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Collection;
import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    void addRole(Role role);
    Role getRoleById(Long id);
}
