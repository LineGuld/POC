package controllers;

import Models.User;
import dataAccess.DAO;
import dataAccess.DAOinterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController public class UserController
{
  private DAOinterface daoInterface;

  public UserController()
  {
    daoInterface = DAO.getDAO();
  }

  @GetMapping("/users")
  List<User> getAllUsers()
  {
    return daoInterface.getAllUsers();
  }

  @GetMapping("/users/{username}")
  User getUserByUsername(@PathVariable String username)
  {
    return daoInterface.getUserByUsername(username);
  }

  @PostMapping("/users")
  User setUser(@RequestBody User newUser)
  {
    return daoInterface.setUser(newUser);
  }

  /*
  Fancy link type getter
  @GetMapping("/users")
  CollectionModel<EntityModel<User>> getAllUsers()
  {
   List<EntityModel<User>> users = daoInterface.getAllUsers().stream().map(
        user -> EntityModel.of(user,
            linkTo(methodOn(UserController.class).getUserByUsername(user.getUsername()))
                .withSelfRel(),
            linkTo(methodOn(UserController.class).getAllUsers()).withRel("users")))
        .collect(Collectors.toList());

    return CollectionModel.of(users,
        linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel());
  }

  @GetMapping("/users/{id}")
  EntityModel<User> getUserByUsername(@PathVariable String username)
  {
    User user = null;

    user = daoInterface.getUserByUsername(username);
    return EntityModel.of(user,
         linkTo(methodOn(UserController.class).getUserByUsername(username)).withSelfRel(),
         linkTo(methodOn(UserController.class).getAllUsers()).withRel("users"));
  }*/

}
