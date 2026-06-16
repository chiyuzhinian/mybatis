package com.example.demo.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class User {
  private Long id;
  private String username;
  private String password;
  private String email;
  private Integer status; // 1=active,0=deleted
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
