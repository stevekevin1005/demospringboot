package com.java_lesson.demo.controller;


import com.java_lesson.demo.dataobject.ApiResponse;
import com.java_lesson.demo.dataobject.User;
import com.java_lesson.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/v1/user/{name}")
    public ApiResponse<User> getUser(@PathVariable("name") String name) {
        ApiResponse<User> response = new ApiResponse<>();
        try {
            User user = userService.getUser(name);
            response.setData(user);
            response.setStatus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStatus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @PostMapping("/v1/user")
    public ApiResponse<User> createUser(@RequestBody User request) {
        ApiResponse<User> response = new ApiResponse<>();
        try {
            User user = userService.createUser(request.getName(), request.getAge());
            response.setData(user);
            response.setStatus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStatus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/v1/user/{name}")
    public ApiResponse<String> deleteUser(@PathVariable("name") String name) {
        ApiResponse<String> response = new ApiResponse<>();
        try {
            String result = userService.deleteUser(name);
            response.setData(result);
            response.setStatus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStatus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @PutMapping("/v1/user/{name}")
    public ApiResponse<User> updateUser(@PathVariable("name") String name, @RequestBody User request) {
        ApiResponse<User> response = new ApiResponse<>();
        try {
            User user = userService.updateUser(name, request.getAge(),
                    request.getSex(), request.getHeight(), request.getWeight());
            response.setData(user);
            response.setStatus(HttpStatusCode.valueOf(200));
            return response;
        } catch (Exception e) {
            response.setStatus(HttpStatusCode.valueOf(500));
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
