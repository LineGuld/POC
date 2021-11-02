package dataAccess;

import Models.User;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class DAO extends DAOConnection implements DAOinterface
{

  private static DAO dao;
  private NamedParameterJdbcTemplate template;

  private DAO()
  {
    try
    {
      DriverManager.registerDriver(new org.postgresql.Driver());
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  public DAO(NamedParameterJdbcTemplate template)
  {
    this.template = template;
  }

  public static DAO getDAO()
  {
    if (dao == null)
    {
      dao = new DAO();
      return dao;
    }
    else
    {
      return dao;
    }
  }

  @Override public User getUserByUsername(String username)
  {
    User user = null;
    try (Connection connection = getConnection())
    {
      PreparedStatement s = connection.prepareStatement(
          "SELECT username FROM 'user' WHERE username = " + username);
      ResultSet r = s.executeQuery();
      r.next();
      user = new User(r.getString("username"));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return user;
  }

  @Override public User setUser(User user)
  {
    try (Connection connection = getConnection())
    {
      connection.prepareStatement(
          "INSERT INTO username (username) VALUES " + user.getUsername())
          .execute();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return user;
  }

  @Override public List<User> getAllUsers()
  {
    List<User> users = null;
    try (Connection connection = getConnection())
    {
      PreparedStatement s = connection.prepareStatement(
          "SELECT * FROM 'user'");
      ResultSet r = s.executeQuery();
      r.next();
      users.add(new User(r.getString("username")));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return template.query("SELECT * FROM 'user'", new UserRowMapper());
  }
}
