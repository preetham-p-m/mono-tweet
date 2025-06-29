package com.pmp.mono_tweet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmp.mono_tweet.model.Post;
import com.pmp.mono_tweet.model.PostRecord;
import com.pmp.mono_tweet.service.interfaces.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/posts")
public class PostController {

    private final PostService postService;

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

    /**
     * @param post
     * @return Post
     */
    @PostMapping
    public Post createPost(@RequestBody @Valid PostRecord postRecord) {
        return this.postService.createPost(postRecord);
    }

}
