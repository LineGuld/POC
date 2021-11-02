package com.example.POC.dataAccess;

import com.example.POC.Models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User>
{

  @Override public User mapRow(ResultSet rs, int rowNum) throws SQLException
  {
    User user = new User();
   // user.setUserId(rs.getInt("UserID"));
    user.setUsername(rs.getString("username"));

    return user;
  }
}
