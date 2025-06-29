package com.pmp.mono_tweet.service.interfaces;

import java.util.List;

import com.pmp.mono_tweet.model.Post;
import com.pmp.mono_tweet.model.PostRecord;

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
