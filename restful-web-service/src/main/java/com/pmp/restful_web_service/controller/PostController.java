package com.pmp.restful_web_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmp.restful_web_service.model.Post;
import com.pmp.restful_web_service.service.interfaces.PostService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        super();
        this.postService = postService;
    }

    /**
     * @return List<Post>
     */
    @GetMapping
    public List<Post> getAll() {
        return this.postService.getAll();
    }

    /**
     * @param id
     * @return List<Post>
     */
    @GetMapping("user/{userId}")
    public List<Post> getAllPostsForUser(@PathVariable long userId) {
        return this.postService.getAllPostsForUser(userId);
    }

}
