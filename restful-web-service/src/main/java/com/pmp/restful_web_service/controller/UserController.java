package com.pmp.restful_web_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pmp.restful_web_service.model.User;
import com.pmp.restful_web_service.service.interfaces.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getMethodName() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getMethodName(@PathVariable int id) {
        return this.userService.getUserById(id);
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        return this.userService.createUser(user);
    }
}
