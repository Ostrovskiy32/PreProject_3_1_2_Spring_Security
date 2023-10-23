package ru.kata.spring.boot_security.demo.repositories;

import ru.kata.spring.boot_security.demo.model.Role;
import java.util.List;

public interface RoleRepositories {

        List<Role> getAllRoles();
        Role getRoleById(Long id);
        void addRole(Role role);
        void removeRole(Long id);
        void updateRole(Role role);


}
