package ru.kata.spring.boot_security.demo.controllers;

import org.apache.tomcat.websocket.pojo.PojoEndpointServer;
import org.hibernate.id.insert.Binder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.servise.RoleService;
import ru.kata.spring.boot_security.demo.servise.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminControllers {
    private final UserService userService;
    private final RoleService roleService;
    private static final String REDIRECT = "redirect:/admin";

    @Autowired
    public AdminControllers(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping(value = "")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }
    @GetMapping("/new")
    public String addUser(User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getAllRoles());
        return "create";
    }
    @PostMapping("/new")
    public String add(User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return REDIRECT;
        } else {
            userService.addUser(user);
            return REDIRECT;
        }
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return REDIRECT;
    }
    @GetMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }
    @PatchMapping("/edit")
    public String update(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return REDIRECT;
        } else {
            userService.updateUser(user);
            return REDIRECT;
        }
    }

}