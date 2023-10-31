package com.learn.order.support.entity;

import java.util.List;

import com.learn.order.dto.request.UserDTO;
import com.learn.order.entity.User;

public class UserSupp {
    
    public static User getUser1() {
        return new User(
            "username1",
            "password"
        );
    }

    public static User getUser2() {
        return new User(
            "username2",
            "password"
        );
    }

    public static UserDTO getUserDTO() {
        return new UserDTO(
            "username3",
            "password"
        );
    }

    public static List<User> getListUsers() {
        return List.of(getUser1(), getUser2());
    }
}
