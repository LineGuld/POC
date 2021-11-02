package com.example.POC.dataAccess;

import com.example.POC.Models.User;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAO implements DAOinterface
{
  NamedParameterJdbcTemplate template;

  public DAO(NamedParameterJdbcTemplate template)
  {
    this.template = template;
  }

  @Override public User getUserByUsername(String username)
  {
    return (User) template.query("select " + username +  " from poc.users ", new UserRowMapper());
  }

  @Override public User setUser(User user)
  {
    final String sql = "insert into poc.users values (:username)";

    KeyHolder holder = new GeneratedKeyHolder();
    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("username", user.getUsername());
    template.update(sql,param, holder);

    return user;
  }

  @Override public List<User> getAllUsers()
  {
    return template.query("SELECT * FROM poc.users", new UserRowMapper());
  }



  /*
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
  }*/
}
