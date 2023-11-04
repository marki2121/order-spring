package com.learn.order.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginDTO {
    @NotEmpty(message = "Missing username")
    private String username;
    @NotEmpty(message = "Missing password")
    private String password;
}
