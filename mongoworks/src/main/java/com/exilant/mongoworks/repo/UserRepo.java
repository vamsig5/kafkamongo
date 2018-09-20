
package com.exilant.mongoworks.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.exilant.mongoworks.model.User;
@EnableTransactionManagement
@Repository
public interface UserRepo  {
	List<User> getAllUsers();

	User getUserById(int userId);

	User addNewUser(User user);

}
