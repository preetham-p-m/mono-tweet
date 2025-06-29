package com.pmp.mono_tweet.service.Implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pmp.mono_tweet.exception.errors.UserNotFoundException;
import com.pmp.mono_tweet.model.Post;
import com.pmp.mono_tweet.model.PostRecord;
import com.pmp.mono_tweet.repository.PostRepository;
import com.pmp.mono_tweet.repository.UserRepository;
import com.pmp.mono_tweet.service.interfaces.PostService;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        super();
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    /**
     * @return List<Post>
     */
    @Override
    public List<Post> getAll() {
        return this.postRepository.findAll();
    }

    /**
     * @param userId
     * @return List<Post>
     */
    @Override
    public List<Post> getAllPostsForUser(long userId) {

        if (this.userRepository.findById(userId).isEmpty()) {
            throw new UserNotFoundException("User " + userId + " not found.");
        }

        return this.postRepository.findAllByUserId(userId);
    }

    /**
     * @param post
     * @return Post
     */
    @Override
    public Post createPost(PostRecord postRecord) {

        var user = this.userRepository.findById(postRecord.user_id());

        if (user.isEmpty()) {
            throw new UserNotFoundException("User " + postRecord.user_id() + " not found.");
        }

        var post = new Post(postRecord.id(), postRecord.description(), user.get());

        return this.postRepository.save(post);
    }

}
