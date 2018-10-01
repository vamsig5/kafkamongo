package com.exilant.myblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exilant.myblog.dao.UserRepository;
import com.exilant.myblog.form.RegisterForm;
import com.exilant.myblog.model.User;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userrepo;

	@Override
	public User saveUser(RegisterForm form) {
		// TODO Auto-generated method stub
		return userrepo.createUser(form);
	}

	@Override
	public List<User> AllUsers() {
		// TODO Auto-generated method stub
		return userrepo.AllUsers();
	}

	@Override
	public User UserByName(String name) {
		// TODO Auto-generated method stub
		return userrepo.UserByName(name);
	}

	@Override
	public User UserByEmail(String email) {
		// TODO Auto-generated method stub
		return userrepo.UserByEmail(email);
	}
	

}
