package com.example.POC.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DAOConnection
{
  private String user = "postgres";
  private String password = "290892";

  protected Connection getConnection()
  {
    Connection result = null;
    try
    {
      result = DriverManager.getConnection(
          "jdbc:postgresql://localhost:5432/postgres?currentSchema=poc",
          user, password);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return result;
  }
}
