package com.pmp.restful_web_service.service.interfaces;

import java.util.List;

import com.pmp.restful_web_service.model.Post;
import com.pmp.restful_web_service.model.PostRecord;

public interface PostService {

    /**
     * @return List<Post>
     */
    List<Post> getAll();

    /**
     * @param userId
     * @return List<Post>
     */
    List<Post> getAllPostsForUser(long userId);

    /**
     * @param post
     * @return Post
     */
    Post createPost(PostRecord postRecord);
}
