package com.learn.order.dto.request.mappers;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.learn.order.dto.request.UserDTO;
import com.learn.order.entity.User;

@Service
public class UserMapper implements Function<UserDTO, User> {

    @Override
    public User apply(UserDTO t) {
        return new User(
            t.getUsername(),
            t.getPassword()
        );
    }
    
}
