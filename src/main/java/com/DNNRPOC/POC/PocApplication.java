package com.DNNRPOC.POC;

import Models.User;
import dataAccess.DAO;
import dataAccess.DAOinterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication @RestController public class PocApplication
{
  private final DAOinterface daoModel = DAO.getDAO();

  public static void main(String[] args)
  {
    SpringApplication.run(PocApplication.class, args);
  }

  @GetMapping("/users") List<User> getAllUsers()
  {
    return daoModel.getAllUsers();
  }
}
