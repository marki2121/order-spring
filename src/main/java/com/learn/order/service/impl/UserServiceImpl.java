package com.learn.order.service.impl;

import org.springframework.stereotype.Service;

import com.learn.order.dto.request.UserDTO;
import com.learn.order.entity.User;
import com.learn.order.repository.UserRepository;
import com.learn.order.service.UserService;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String deleteById(Long id) {
        userRepository.deleteById(id);

        return "Deleted.";
    }

    @Override
    public String updatebyId(Long id, @Valid UserDTO data) {
        User userDb = userRepository.findById(id).orElseThrow(RuntimeException::new);

        if(userDb.getUsername() != data.getUsername() && !data.getUsername().isEmpty()) {
            userDb.setUsername(data.getUsername());
        }

        if(userDb.getPassword() != data.getPassword() && !data.getPassword().isEmpty()) {
            userDb.setPassword(data.getPassword());
        }

        userRepository.save(userDb);

        return "Updated.";
    }
    
}
