package com.exilant.mongoworks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exilant.mongoworks.model.User;
import com.exilant.mongoworks.repo.UserRepo;
//import com.exilant.mongoworks.repo.UserRepo;

@RestController
public class UserController {
  @Autowired
	private UserRepo userRepo1;
	@GetMapping("/get/{id}")
	public User getUser(@PathVariable int id) {
		
		return userRepo1.getUserById(id);
	}
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userRepo1.getAllUsers();
	}	
	
	@PostMapping("/create")
	public User addNewUsers(@RequestBody User user) {
		return userRepo1.addNewUser(user);
	}

}
