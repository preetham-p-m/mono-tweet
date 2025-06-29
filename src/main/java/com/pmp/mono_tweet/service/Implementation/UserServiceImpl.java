package com.pmp.mono_tweet.service.Implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pmp.mono_tweet.exception.errors.UserNotFoundException;
import com.pmp.mono_tweet.model.User;
import com.pmp.mono_tweet.repository.UserRepository;
import com.pmp.mono_tweet.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    /**
     * @return List<User>
     */
    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    /**
     * @param id
     * @return User
     */
    @Override
    public User getUserById(long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User " + id + " not found."));
    }

    /**
     * @param user
     * @return User
     */
    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    /**
     * @param id
     */
    @Override
    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }

}
