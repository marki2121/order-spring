/* (C) 2023 */
package com.learn.order.service.impl;

import com.learn.order.dto.request.LoginDTO;
import com.learn.order.dto.response.JwtAuthenticationResponse;
import com.learn.order.entity.User;
import com.learn.order.errors.ErrorResponse;
import com.learn.order.repository.UserRepository;
import com.learn.order.service.AuthService;
import com.learn.order.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthServiceImpl(
      UserRepository userRepository,
      PasswordEncoder passwordEncoder,
      JwtService jwtService,
      AuthenticationManager authenticationManager) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
    this.authenticationManager = authenticationManager;
  }

  @Override
  public JwtAuthenticationResponse signup(LoginDTO request) {
    User user = new User(request.getPassword(), passwordEncoder.encode(request.getPassword()));
    userRepository.save(user);

    String token = jwtService.generateToken(user);

    return new JwtAuthenticationResponse(token);
  }

  @Override
  public JwtAuthenticationResponse signin(LoginDTO request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

    User user =
        userRepository
            .findByUsername(request.getUsername())
            .orElseThrow(
                () -> new ErrorResponse(HttpStatus.NOT_FOUND, "Username or password missmatch."));
    String token = jwtService.generateToken(user);

    return new JwtAuthenticationResponse(token);
  }
}
