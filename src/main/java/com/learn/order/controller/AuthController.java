/* (C) 2023 */
package com.learn.order.controller;

import com.learn.order.dto.request.LoginDTO;
import com.learn.order.dto.response.JwtAuthenticationResponse;
import com.learn.order.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping(path = "/login")
  public ResponseEntity<JwtAuthenticationResponse> login(@Valid @RequestBody LoginDTO data) {
    return ResponseEntity.ok(authService.signin(data));
  }

  @PostMapping(path = "/register")
  public ResponseEntity<JwtAuthenticationResponse> register(@Valid @RequestBody LoginDTO data) {
    return ResponseEntity.ok(authService.signup(data));
  }
}
