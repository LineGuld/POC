package dataAccess;

import Models.User;

import java.util.List;

public interface DAOinterface
{
  public User getUserByUsername(String username);
  public User setUser(User user);
  public List<User> getAllUsers();
}
