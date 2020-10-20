package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.exception.UserNameExistsException;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        if (!isUserExist(user.getUsername())) {
            userRepository.save(user);
        } else {
            throw new UserNameExistsException("用户已存在");
        }
    }

    public boolean isUserExist(String username) {
        return userRepository.findAll().stream()
                .anyMatch(user -> username.equals(user.getUsername()));
    }
}
