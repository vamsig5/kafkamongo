package com.exilant.mongorepo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exilant.mongorepo.dao.UserDao;
import com.exilant.mongorepo.model.User;

@RestController
@RequestMapping("/mr")
public class Controller {
@Autowired
 
	private UserDao userdao;

	public Controller(UserDao userdao) {
		super();
		this.userdao = userdao;
	}
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userdao.findAll();
	}
	
	@PostMapping("/add")
	public User addNewUsers(@RequestBody User user) {
		return userdao.save(user);
	}
	@GetMapping("/get")
	public User getUserbyid(@RequestParam int id) {
		return userdao.findById(id);
		
	}
	@GetMapping("/get1")
	public User getUserbyname(@RequestParam String name) {
		return userdao.getByName(name);
		
	}
	@GetMapping("/get2")
	public User getUserbyage(@RequestParam int age) {
		return userdao.findByAge(20);
		
	}
	@GetMapping("/get3")
	public User getUserbysalary(@RequestParam int salary) {
		return userdao.findBySalary(salary);
		
	}
}
