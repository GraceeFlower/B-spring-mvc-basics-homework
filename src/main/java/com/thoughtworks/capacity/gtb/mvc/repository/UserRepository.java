package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.dataProvider.DataProvider;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final List<User> userList = DataProvider.userList;

    public void save(User user) {
        userList.add(user);
    }

    public List<User> findAll() {
        return userList;
    }
}
