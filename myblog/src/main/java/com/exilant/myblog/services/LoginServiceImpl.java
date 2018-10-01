package com.exilant.myblog.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exilant.myblog.dao.UserRepository;
import com.exilant.myblog.model.User;


@Service
public class LoginServiceImpl implements LoginService {


	@Autowired
	private UserRepository userrepo;
//	@Override
//	public boolean authenticate(String name, String password) {
//		User user=userrepo.UserByName(name);
//	if(user!=null) {
//		return user.getEncrytedPassword().equals(password);
//	}
//		
//		  return false;
//		
//	}
	@Override
    public boolean authenticate(String username, String password) {
         // Provide a sample password check: username == password
         return Objects.equals(username, password);
    }

}
