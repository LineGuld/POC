package controllers;

import Models.User;
import dataAccess.DAO;
import dataAccess.DAOinterface;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController
{
  private final DAOinterface daoModel;

  public UserController()
  {
    daoModel = DAO.getDAO();
  }

  @GetMapping("/users")
  List<User> getAllUsers()
  {
    return daoModel.getAllUsers();
  }
}
