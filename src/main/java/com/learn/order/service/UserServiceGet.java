/* (C) 2023 */
package com.learn.order.service;

import com.learn.order.entity.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceGet {

  UserDetailsService userDetailsService();

  List<User> getAll();
}
