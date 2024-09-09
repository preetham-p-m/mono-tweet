package com.pmp.restful_web_service.service.interfaces;

import java.util.List;

import com.pmp.restful_web_service.model.User;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int id);

    User createUser(User user);

    void deleteUserById(int id);
}
