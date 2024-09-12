package com.pmp.restful_web_service.service.interfaces;

import java.util.List;

import com.pmp.restful_web_service.model.User;

public interface UserService {

    /**
     * @return List<User>
     */
    List<User> getAllUsers();

    /**
     * @param id
     * @return User
     */
    User getUserById(int id);

    /**
     * @param user
     * @return User
     */
    User createUser(User user);

    /**
     * @param id
     */
    void deleteUserById(int id);
}
