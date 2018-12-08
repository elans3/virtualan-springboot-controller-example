/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.virtualan.test.springboot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.virtualan.test.springboot.model.User;

import org.springframework.stereotype.Service;

/**
 * Spring boot rest controller with virtualan.
 *
 * @author Elan Thangamani
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	private static final AtomicLong counter = new AtomicLong();

	private static List<User> users = new ArrayList();

	public List<User> findAllUsers() {
		return users;
	}

	public User findById(long id) {
		for (User user : users) {
			if (user.getId() == id) {
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
		for (Iterator<User> iter = users.iterator(); iter.hasNext();) {
			User user = iter.next();
			if (user.getId() == id) {
				iter.remove();
			}
		}
	}

}
