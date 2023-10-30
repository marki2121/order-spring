package com.learn.order.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.order.entity.User;
import com.learn.order.repository.UserRepository;
import com.learn.order.service.UserServiceGet;

@Service
public class UserServiceGetImpl implements UserServiceGet{

    private final UserRepository userRepository;

    public UserServiceGetImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
    
}
