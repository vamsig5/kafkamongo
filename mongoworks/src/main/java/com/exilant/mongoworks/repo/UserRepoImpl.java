
package com.exilant.mongoworks.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.exilant.mongoworks.model.User;
@Repository
public class UserRepoImpl implements UserRepo{

	@Autowired
	private MongoTemplate mongoTemplate;
	@Override
	public List<User> getAllUsers() {
				return mongoTemplate.findAll(User.class);
	}

	@Override
	public User getUserById(int id) {
Query query=new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return mongoTemplate.findOne(query, User.class);
	}
	@Override
	public User addNewUser(User user) {
		mongoTemplate.save(user);
				return user;
	}
}
