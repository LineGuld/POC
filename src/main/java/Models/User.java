package Models;

@Entity public class User
{
  private String username;
  private int userId;

  public User(String username)
  {
    this.username = username;
  }

  public User()
  {
  }

  public void setUserId(int userId)
  {
    this.userId = userId;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }
}
