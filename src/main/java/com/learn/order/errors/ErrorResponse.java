/* (C) 2023 */
package com.learn.order.errors;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorResponse extends RuntimeException {

  private HttpStatus status;

  public ErrorResponse() {
    super();
  }

  public ErrorResponse(String message) {
    super(message);
  }

  public ErrorResponse(HttpStatus status, String message) {
    this(message);
    this.status = status;
  }
}
