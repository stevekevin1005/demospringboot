package com.java_lesson.demo.service;

import com.java_lesson.demo.dao.UserMapper;
import com.java_lesson.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> listUser() {
        return userMapper.findAll();
    }


    public User createUser(String name, int age, String sex, int weight, int height) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        user.setWeight(weight);
        user.setHeight(height);
        userMapper.insert(user);
        return user;
    }

    public User getById(int id) {
        return userMapper.getById(id);
    }

    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

}
