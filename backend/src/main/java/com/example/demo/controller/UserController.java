package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
  private final UserService userService;
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<User> create(@RequestBody User user) {
    return ResponseEntity.ok(userService.create(user));
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> get(@PathVariable Long id) {
    return ResponseEntity.ok(userService.getById(id));
  }

  @GetMapping
  public ResponseEntity<HashMap<String,Object>> list(
      @RequestParam(required = false) String username,
      @RequestParam(required = false) String email,
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int size) {

    List<User> data = userService.list(username, email, page, size);
    int total = userService.count(username, email);
    HashMap<String,Object> res = new HashMap<>();
    res.put("data", data);
    res.put("total", total);
    return ResponseEntity.ok(res);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Integer> update(@PathVariable Long id, @RequestBody User user) {
    user.setId(id);
    return ResponseEntity.ok(userService.update(user));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Integer> delete(@PathVariable Long id) {
    return ResponseEntity.ok(userService.delete(id));
  }
}
