package com.pmp.restful_web_service.service.Implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pmp.restful_web_service.exception.errors.UserNotFoundException;
import com.pmp.restful_web_service.model.Post;
import com.pmp.restful_web_service.repository.PostRepository;
import com.pmp.restful_web_service.repository.UserRepository;
import com.pmp.restful_web_service.service.interfaces.PostService;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private UserRepository userRepository;

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
    public List<Post> getAllPostsForUser(int userId) {

        if (!this.userRepository.findById(userId).isPresent()) {
            throw new UserNotFoundException("User " + userId + " not found.");
        }

        return this.postRepository.findAllByUserId(userId);
    }

}
