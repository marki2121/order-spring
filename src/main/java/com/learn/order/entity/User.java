/* (C) 2023 */
package com.learn.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = " users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "username", nullable = false, length = 25)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "enabled", nullable = false)
  private Boolean enabled = true;

  @Column(name = "active", nullable = false)
  private Boolean active = true;

  @Column(name = "isPrivate", nullable = false)
  private Boolean isPrivate = false;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
