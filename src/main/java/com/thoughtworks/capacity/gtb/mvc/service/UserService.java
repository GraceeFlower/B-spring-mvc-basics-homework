package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.exception.InvalidFormatException;
import com.thoughtworks.capacity.gtb.mvc.exception.InvalidUserException;
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

    public void validateUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        if (!username.matches("\\w{3,10}$")) {
            throw new InvalidFormatException("用户名不合法");
        } else if (!password.matches("^.{5,12}")) {
            throw new InvalidFormatException("密码不合法");
        } else if (!userRepository.getUser(username, password)) {
            throw new InvalidUserException("用户名或密码错误");
        }
    }
}
