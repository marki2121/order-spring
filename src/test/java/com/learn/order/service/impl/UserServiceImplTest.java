/* (C) 2023 */
package com.learn.order.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.learn.order.entity.User;
import com.learn.order.repository.UserRepository;
import com.learn.order.service.UserService;
import com.learn.order.support.entity.UserSupp;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class UserServiceImplTest {

  @MockBean private UserRepository userRepository;
  @Autowired private UserService userService;

  @Test
  void testDeleteById() {
    doNothing().when(userRepository).deleteById(anyLong());

    assertEquals("Deleted.", userService.deleteById(1L));
  }

  @Test
  void testUpdatebyId() {
    when(userRepository.findById(anyLong())).thenReturn(Optional.of(UserSupp.getUser1()));
    when(userRepository.save(any(User.class))).thenReturn(UserSupp.getUser2());

    assertEquals("Updated.", userService.updatebyId(1L, UserSupp.getUserDTO()));
  }
}
