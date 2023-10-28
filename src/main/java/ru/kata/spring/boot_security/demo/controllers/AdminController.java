package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServices;
import ru.kata.spring.boot_security.demo.service.UserServices;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final RoleServices roleServices;
    private final UserServices userServices;
    private static final String REDIRECT = "redirect:/admin";
    @Autowired
    public AdminController(RoleServices roleServices, UserServices userServices) {
        this.roleServices = roleServices;
        this.userServices = userServices;
    }

    @GetMapping(value = "")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userServices.getAllUsers());
        return "users";
    }
    @GetMapping(value = "/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", userServices.getUserById(id));
        return "user";
    }
    @GetMapping(value = "/new")
    public String addUser(User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("role", roleServices.getAllRoles());
        return "/create";
    }
    @PostMapping(value = "/new")
    public String add(User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return REDIRECT;
        } else {
            userServices.addUser(user);
            return REDIRECT;
        }
    }
    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userServices.removeUser(id);
        return REDIRECT;
    }
    @GetMapping(value = "/edit/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userServices.getUserById(id));
        model.addAttribute("role", roleServices.getAllRoles());
        return "/edit";
    }
    @PatchMapping(value = "/edit")
    public String update(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/edit";
        } else {
            userServices.updateUser(user);
            return REDIRECT;
        }
    }
}
