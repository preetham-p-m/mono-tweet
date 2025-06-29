package com.pmp.mono_tweet.controller;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pmp.mono_tweet.aop.annotation.RateLimit;
import com.pmp.mono_tweet.model.User;
import com.pmp.mono_tweet.service.interfaces.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @return List<User>
     */
    @GetMapping()
    @RateLimit
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    /**
     * @param id
     * @return EntityModel<User>
     */
    @GetMapping("/{id}")
    public EntityModel<User> getUserById(@PathVariable long id) {
        var user = this.userService.getUserById(id);

        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    /**
     * @param user
     * @return ResponseEntity<User>
     */
    @PostMapping()
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        var createdUser = this.userService.createUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();

        return ResponseEntity.created(location).body(createdUser);
    }

    /**
     * @param id
     */
    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable long id) {
        this.userService.deleteUserById(id);
    }

}
