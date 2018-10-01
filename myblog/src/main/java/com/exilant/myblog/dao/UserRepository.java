package com.exilant.myblog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exilant.myblog.form.RegisterForm;
import com.exilant.myblog.model.User;
@Repository
public interface UserRepository {

	
	public User createUser(RegisterForm form);
	public List<User> AllUsers();
	public User UserByName(String name);
	public User UserByEmail(String email);
}
