package com.java_lesson.demo.service;

import com.java_lesson.demo.dataobject.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, User> map = new HashMap<>();

    public User createUser(String name, int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        map.put(name, user);
        return user;
    }

    public User updateUser(String name, Integer age, String sex, Integer height, Integer weight)
            throws Exception {
        if (!map.containsKey(name)) {
            throw new Exception("user not exist");
        }
        User originalUser = map.get(name);
        if (null != age) {
            originalUser.setAge(age);
        }
        if (null != sex) {
            originalUser.setSex(sex);
        }
        if (null != height) {
            originalUser.setHeight(height);
        }
        if (null != weight) {
            originalUser.setWeight(weight);
        }
        map.put(name, originalUser);
        return originalUser;
    }

    public User getUser(String name) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        return null;
    }

    public String deleteUser(String name) {
        if (!map.containsKey(name)) {
            return "user is not exist";
        }
        map.remove(name);
        return "delete user success";
    }
}
