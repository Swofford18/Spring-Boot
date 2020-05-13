package com.suetin.boot.controller;

import com.suetin.boot.model.Role;
import com.suetin.boot.model.User;
import com.suetin.boot.service.RoleService;
import com.suetin.boot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class UserRestController {

    private UserService userService;
    private RoleService roleService;

    public UserRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PutMapping("/addUser")
    public User addUser(@RequestBody User user) {

        userService.saveUser(roleDefinition(user));
        return user;
    }

    @GetMapping("/allUsers")
    public List<User> allUsers() {
        return userService.findAll();
    }

    @GetMapping("/getOne")
    @ResponseBody
    public User getOne(Long id) {
        return userService.findById(id);
    }

    @PostMapping("/editUser")
    public User editUser(@RequestBody User user) {

        userService.saveUser(roleDefinition(user));
        return user;
    }

    @DeleteMapping("/deleteUser")
    public User deleteUser(@RequestBody User user) {

        System.out.println(user.getId());
        userService.delete(roleDefinition(user));
        return user;
    }

    private User roleDefinition(User user) {
        Role adminRole = roleService.getAdminRole();
        Role userRole = roleService.getUserRole();

        Set<Role> newUserRoles = new HashSet<>();

        for (Role role : user.getRoles()) {

            if (role.getName().equals("ROLE_ADMIN")) {
                newUserRoles.add(adminRole);
            }
            if (role.getName().equals("ROLE_USER")) {
                newUserRoles.add(userRole);
            }

            user.setRoles(newUserRoles);
        }
        return user;
    }
}
