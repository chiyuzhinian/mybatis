package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
  int insertUser(User user);
  User selectById(@Param("id") Long id);
  List<User> selectByCondition(@Param("username") String username, @Param("email") String email, @Param("offset") Integer offset, @Param("limit") Integer limit);
  int updateUser(User user);
  int deleteById(@Param("id") Long id);
  int countByCondition(@Param("username") String username, @Param("email") String email);
}
