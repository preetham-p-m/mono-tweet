package com.pmp.restful_web_service.service.Implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pmp.restful_web_service.exception.errors.UserNotFoundException;
import com.pmp.restful_web_service.model.User;
import com.pmp.restful_web_service.repository.UserRepository;
import com.pmp.restful_web_service.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    /**
     * @return List<User>
     */
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    /**
     * @param id
     * @return User
     */
    @Override
    public User getUserById(int id) {
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
    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }

}
