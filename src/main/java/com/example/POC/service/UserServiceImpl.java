package com.example.POC.service;

import com.example.POC.Models.User;
import com.example.POC.dataAccess.DAOinterface;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserServiceImpl implements UserService
{
  @Resource DAOinterface daOinterface;

  @Override public List<User> getAllUsers()
  {
    return daOinterface.getAllUsers();
  }

  @Override public User getUserByUsername(String username)
  {
    return daOinterface.getUserByUsername(username);
  }

  @Override public void setUser(User user)
  {

  }
}
