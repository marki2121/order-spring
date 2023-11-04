/* (C) 2023 */
package com.learn.order.service.impl;

import com.learn.order.entity.User;
import com.learn.order.repository.UserRepository;
import com.learn.order.service.UserServiceGet;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceGetImpl implements UserServiceGet {

  private final UserRepository userRepository;

  public UserServiceGetImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> getAll() {
    return userRepository.findAll();
  }

  @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
