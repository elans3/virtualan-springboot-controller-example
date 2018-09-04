package com.virtualan.test.springboot.service;


import java.util.List;

import com.virtualan.test.springboot.model.User;

/**
 * Spring boot rest controller with virtualan
 * 
 * @author Elan Thangamani
 *
 */
public interface UserService {
	
	User findById(long id);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);

	List<User> findAllUsers();
	
	
	
}
