package com.exilant.mongorepo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.exilant.mongorepo.model.User;

@Repository
//@EnableTransactionManagement
public interface UserDao extends MongoRepository<User, String> {
	
public User findById(int id);
public User getByName(String name);
public User findByAge(int age);
public User findBySalary(int salary);
}
