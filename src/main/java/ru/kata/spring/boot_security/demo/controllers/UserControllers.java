package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.servise.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserControllers {
    private final UserService userService;
    @Autowired
    public UserControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public String getUserPage(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByUsername(principal.getName()));
        return "user";
    }
}
