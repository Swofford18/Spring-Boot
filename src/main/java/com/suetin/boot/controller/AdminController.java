package com.suetin.boot.controller;

import com.suetin.boot.model.User;
import com.suetin.boot.service.RoleServiceImpl;
import com.suetin.boot.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserServiceImpl userService;
    private RoleServiceImpl roleService;

    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String printUsers(ModelMap model, Principal principal) {

        String username = principal.getName();
        User admin = (User) userService.loadUserByUsername(username);
        List<User> users = userService.findAll();
        model.addAttribute("admin", admin);
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.findAll());
        return "admin_page";
    }

    @GetMapping(value = "/add")
    public String newUserPage(ModelMap model, Principal principal) {
        String username = principal.getName();
        User admin = (User) userService.loadUserByUsername(username);
        model.addAttribute("admin", admin);
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.findAll());
        return "add_page";
    }

    @PostMapping(value = "/add")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

//    @GetMapping(value = "/update/{id}")
//    public String updateUserPage(@PathVariable("id") long id, ModelMap model) {
//        model.addAttribute("user", userService.findById(id));
//        model.addAttribute("allRoles", roleService.findAll());
//        return "update_page";
//    }

    @PostMapping(value = "/update")
    public String updateUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

//    @GetMapping(value = "/delete/{id}")
//    public String deleteUserPage(@PathVariable("id") long id, ModelMap model) {
//        model.addAttribute("user", userService.findById(id));
//        model.addAttribute("allRoles", roleService.findAll());
//        return "delete_page";
//    }

    @PostMapping(value = "/delete")
    public String deleteUser(@ModelAttribute User user) {
        userService.delete(user);
        return "redirect:/admin";
    }
}
