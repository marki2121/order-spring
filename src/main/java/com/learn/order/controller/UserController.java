package com.learn.order.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.order.dto.request.UserDTO;
import com.learn.order.entity.User;
import com.learn.order.service.UserService;
import com.learn.order.service.UserServiceGet;

import jakarta.validation.Valid;

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

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }

    @PutMapping(path = "/{id}")
    private ResponseEntity<String> updatreById(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updatebyId(id, userDTO));
    }
}
