package com.virtualan.test.springboot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.virtualan.test.springboot.model.User;


/**
 * Spring boot rest controller with virtualan
 * 
 * @author Elan Thangamani
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users = new ArrayList();
	

	public List<User> findAllUsers() {
		return users;
	}
	
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<User> iter = users.iterator(); iter.hasNext(); ) {
		    User user = iter.next();
		    if (user.getId() == id) {
		    	iter.remove();
		    }
		}
	}

	
}
