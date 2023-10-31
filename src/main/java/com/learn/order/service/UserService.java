package com.learn.order.service;

import com.learn.order.dto.request.UserDTO;

import jakarta.validation.Valid;

public interface UserService {

    String deleteById(Long id);

    String updatebyId(Long id, @Valid UserDTO userDTO);
    
}
