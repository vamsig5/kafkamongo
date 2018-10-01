package com.exilant.myblog.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.exilant.myblog.form.RegisterForm;
import com.exilant.myblog.model.User;


@Repository
public class UserRepoImpl implements UserRepository {
	
	
	
	@Autowired
	private MongoTemplate mongo;
	
//	@Autowired
//	private PasswordEncoder pEncoder;

	@Override
	public User createUser(RegisterForm form) {
		// TODO Auto-generated method stub
//		String encrytedPassword = this.pEncoder.encode(form.getPassword());
		mongo.save(form, "user1");
		User user = new User(form.getUserId(), form.getUserName(), 
                form.getFirstName(), form.getLastName(), false, 
                form.getGender(), form.getEmail(), form.getCountryCode(), 
                form.getPassword());
		return user;
	}

	@Override
	public List<User> AllUsers() {
		// TODO Auto-generated method stub
		return mongo.findAll(User.class, "user1");
	}

	@Override
	public User UserByName(String name) {
		Query query=new Query();
		query.addCriteria(Criteria.where("userName").is(name));
		return mongo.findOne(query,User.class,"user");
	}

	@Override
	public User UserByEmail(String email) {
		Query query=new Query();
		query.addCriteria(Criteria.where("email").is(email));
		return mongo.findOne(query,User.class,"user");
	}

}
