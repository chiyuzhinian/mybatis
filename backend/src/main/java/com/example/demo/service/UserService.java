package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
  private final UserMapper userMapper;

  public UserService(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @Transactional
  public User create(User user) {
    user.setStatus(1);
    user.setCreatedAt(LocalDateTime.now());
    user.setUpdatedAt(LocalDateTime.now());
    userMapper.insertUser(user);
    return user;
  }

  public User getById(Long id) {
    return userMapper.selectById(id);
  }

  public List<User> list(String username, String email, int page, int size) {
    int offset = (page - 1) * size;
    return userMapper.selectByCondition(username, email, offset, size);
  }

  public int count(String username, String email) {
    return userMapper.countByCondition(username, email);
  }

  @Transactional
  public int update(User user) {
    user.setUpdatedAt(LocalDateTime.now());
    return userMapper.updateUser(user);
  }

  @Transactional
  public int delete(Long id) {
    return userMapper.deleteById(id);
  }
}
