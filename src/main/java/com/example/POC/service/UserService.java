package com.example.POC.service;

import com.example.POC.Models.User;

import java.util.List;

public interface UserService
{
  List<User> getAllUsers();
  User getUserByUsername(String username);
  void setUser(User user);
}
