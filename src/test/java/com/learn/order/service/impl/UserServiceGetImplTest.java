/* (C) 2023 */
package com.learn.order.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.learn.order.repository.UserRepository;
import com.learn.order.service.UserServiceGet;
import com.learn.order.support.entity.UserSupp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class UserServiceGetImplTest {

  @MockBean private UserRepository userRepository;
  @Autowired private UserServiceGet userService;

  @Test
  void testGetAll() {
    when(userRepository.findAll()).thenReturn(UserSupp.getListUsers());

    assertEquals(
        userService.getAll().get(0).getUsername(), UserSupp.getListUsers().get(0).getUsername());
  }
}
