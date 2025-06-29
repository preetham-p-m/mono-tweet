package com.pmp.mono_tweet.service.interfaces;

import java.util.List;

import com.pmp.mono_tweet.model.User;

public interface UserService {

    /**
     * @return List<User>
     */
    List<User> getAllUsers();

    /**
     * @param id
     * @return User
     */
    User getUserById(long id);

    /**
     * @param user
     * @return User
     */
    User createUser(User user);

    /**
     * @param id
     */
    void deleteUserById(long id);
}
