package com.learn.order.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.order.entity.User;
import com.learn.order.service.UserService;
import com.learn.order.service.UserServiceGet;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    
    private final UserService userService;
    private final UserServiceGet userServiceGet;

    public UserController(UserService userService, UserServiceGet userServiceGet) {
        this.userService = userService;
        this.userServiceGet = userServiceGet;
    }

    @GetMapping
    private ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userServiceGet.getAll());
    }

    //TODO: Create user will be in login controller, add update and delete only.
}
