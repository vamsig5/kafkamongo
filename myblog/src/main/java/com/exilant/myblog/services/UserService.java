package com.exilant.myblog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exilant.myblog.form.RegisterForm;
import com.exilant.myblog.model.User;
@Service
public interface UserService {

	public User saveUser(RegisterForm form);
	public List<User> AllUsers();
	public User UserByName(String name);
	public User UserByEmail(String email);
}
