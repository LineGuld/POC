package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DAOConnection
{
  private String user = "zzqqvurd";
  private String password = "3vyx5SAAyGzRHyxOUps8WUb0f2Rn0jml";

  protected Connection getConnection()
  {
    Connection result = null;
    try
    {
      //Class.forName("org.postgresql.Driver");
      result = DriverManager.getConnection(
          "jdbc:postgresql://balarama.db.elephantsql.com:5432/zzqqvurd",
          user, password);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return result;
  }
}
