package com.pmp.restful_web_service.service.Implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pmp.restful_web_service.exception.errors.UserNotFoundException;
import com.pmp.restful_web_service.model.User;
import com.pmp.restful_web_service.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static List<User> users = new ArrayList<>();

    private static int count = 1;

    static {
        users.add(new User(count++, "Adam", LocalDate.now().minusYears(15)));
        users.add(new User(count++, "Cris", LocalDate.now().minusYears(35)));
        users.add(new User(count++, "Fang", LocalDate.now().minusYears(20)));
        users.add(new User(count++, "Raju", LocalDate.now().minusYears(10)));
    }

    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst()
                .orElseThrow(() -> new UserNotFoundException("userId " + id + " not found"));
    }

    @Override
    public User createUser(User user) {
        user.setId(count++);
        users.add(user);
        return user;
    }

}
