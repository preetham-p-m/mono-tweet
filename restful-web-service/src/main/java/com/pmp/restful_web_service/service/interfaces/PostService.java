package com.pmp.restful_web_service.service.interfaces;

import java.util.List;

import com.pmp.restful_web_service.model.Post;

public interface PostService {

    /**
     * @return List<Post>
     */
    List<Post> getAll();

    /**
     * @param userId
     * @return List<Post>
     */
    List<Post> getAllPostsForUser(int userId);
}
