/* (C) 2023 */
package com.learn.order.service;

import com.learn.order.dto.request.LoginDTO;
import com.learn.order.dto.response.JwtAuthenticationResponse;

public interface AuthService {
  JwtAuthenticationResponse signup(LoginDTO request);

  JwtAuthenticationResponse signin(LoginDTO request);
}
