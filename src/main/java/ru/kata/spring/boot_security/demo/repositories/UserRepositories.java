package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserRepositories {
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByUsername(String username);
    void addUser(User user);
    void remove(Long id);
    void updateUser(User user);
}
