package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServices;
import ru.kata.spring.boot_security.demo.service.UserServices;


import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@Valid
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
        model.addAttribute("user", userServices.getUserById(id));
        return "user";
    }

    @GetMapping(value = "/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleServices.getAllRoles());
        return "create";
    }

    @PostMapping(value = "/new")
    public String add(@Valid @ModelAttribute("user") User user, BindingResult bindingResult
            , Model model, @RequestParam List<Long> ids) {
        // Checking validation exception
        if (bindingResult.hasErrors()) {

            model.addAttribute("allRoles", roleServices.getAllRoles());
            Set<Role> assignedRole = roleServices.findAllRoleId(ids);
            user.setRoles(assignedRole);

            return "create";
        } else {
            try {
                Set<Role> assignedRole = roleServices.findAllRoleId(ids);
                user.setRoles(assignedRole);
                userServices.addUser(user);
                return REDIRECT;
            } catch (DataIntegrityViolationException e) {
                bindingResult.rejectValue("username", "duplicate", "This is username is already taken");
                model.addAttribute("allRoles", roleServices.getAllRoles());
                Set<Role> assignedRole = roleServices.findAllRoleId(ids);
                user.setRoles(assignedRole);
                return "create";
            }
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
        model.addAttribute("allRoles", roleServices.getAllRoles());
        return "edit";
    }

    @PatchMapping(value = "/edit")
    public String update(@Valid @ModelAttribute("user") User user, BindingResult bindingResult
            , Model model , @RequestParam List<Long> ids) {
        if (bindingResult.hasErrors()) {

            model.addAttribute("allRoles", roleServices.getAllRoles());
            Set<Role> assignedRole = roleServices.findAllRoleId(ids);
            user.setRoles(assignedRole);

            return "edit";
        } else {
            try {
                Set<Role> assignedRole = roleServices.findAllRoleId(ids);
                user.setRoles(assignedRole);
                userServices.updateUser(user);
                return REDIRECT;
            } catch (DataIntegrityViolationException e) {
                bindingResult.rejectValue("username", "duplicate", "This is username is already taken");
                model.addAttribute("allRoles", roleServices.getAllRoles());
                Set<Role> assignedRole = roleServices.findAllRoleId(ids);
                user.setRoles(assignedRole);
                return "edit";
            }
        }
    }
}
