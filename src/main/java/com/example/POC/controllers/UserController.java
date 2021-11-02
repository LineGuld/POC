package com.example.POC.controllers;

import com.example.POC.Models.User;
import org.springframework.web.bind.annotation.*;
import com.example.POC.service.UserService;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class UserController
{
  @Resource UserService userService;

  @GetMapping(value = "/users") List<User> getAllUsers()
  {
    return userService.getAllUsers();
  }

  @GetMapping(value = "/users/{username}") User getUserByUsername(
      @PathVariable String username)
  {
    return userService.getUserByUsername(username);
  }

  @PostMapping(value = "/user") void setUser(@RequestBody User newUser)
  {
    userService.setUser(newUser);
  }

  @PostMapping(value = "/userString") void setUserString(@RequestBody String username)
  {
    User newUser = new User(username);
    userService.setUser(newUser);
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
