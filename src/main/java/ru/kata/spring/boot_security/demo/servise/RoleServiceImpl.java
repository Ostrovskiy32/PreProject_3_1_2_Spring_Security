package ru.kata.spring.boot_security.demo.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepositories;

import java.util.List;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class RoleServiceImpl implements RoleService{

    RoleRepositories roleRepositories;

    @Autowired
    public RoleServiceImpl(RoleRepositories roleRepositories) {
        this.roleRepositories = roleRepositories;
    }

    @Override
    public List<Role> getAllRoles() { return roleRepositories.getAllRoles(); }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleRepositories.addRole(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepositories.getRoleById(id);
    }
}
