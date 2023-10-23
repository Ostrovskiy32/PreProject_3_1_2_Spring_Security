package ru.kata.spring.boot_security.demo.init;


import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.servise.RoleService;
import ru.kata.spring.boot_security.demo.servise.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitialTable {
    UserService userService;
    RoleService roleService;



    public InitialTable(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initial() {

        roleService.addRole(new Role("ROLE_ADMIN"));
        roleService.addRole(new Role("ROLE_USER"));

        Set<Role> adminRole = new HashSet<>();
        Set<Role> userRole = new HashSet<>();
        adminRole.add(roleService.getRoleById(1L));
        userRole.add(roleService.getRoleById(2L));

        userService.addUser(new User("Igor", "Ostrovsky", (byte) 52, "Russian", "admin", "$2a$12$KPdGDctM2qJTep1jLsxSGu6JT7pTvYcGz6bt1mhJjtj5cZ3yy/th2",adminRole));
        userService.addUser(new User("Peter", "Petrov", (byte) 25, "Russian", "user", "$2a$12$KO2rb0mI0EwlsEtDcnDeeeeru/SnawIAKVdy188bhST.Z3pcpgk6q",userRole));
    }
}