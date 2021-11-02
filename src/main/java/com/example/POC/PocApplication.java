package com.example.POC;

import Models.User;
import dataAccess.DAO;
import dataAccess.DAOinterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@SpringBootApplication
public class PocApplication {

	public static void main(String... args) {
		SpringApplication.run(PocApplication.class, args);

	}

	private DAOinterface daoInterface = DAO.getDAO();

	@GetMapping("/users") List<User> getAllUsers()
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
}