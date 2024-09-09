package com.pmp.restful_web_service.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pmp.restful_web_service.model.User;
import com.pmp.restful_web_service.service.interfaces.UserService;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public ResponseEntity<User> createUser(@RequestBody User user) {
        var createdUser = this.userService.createUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();

        return ResponseEntity.created(location).body(createdUser);
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable int id) {
        this.userService.deleteUserById(id);
    }

}
