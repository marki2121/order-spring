/* (C) 2023 */
package com.learn.order.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
  @NotEmpty(message = "Missing username")
  private String username;

  @NotEmpty(message = "Missing password")
  private String password;
}
