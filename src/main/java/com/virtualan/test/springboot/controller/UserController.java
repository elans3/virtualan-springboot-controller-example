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

package com.virtualan.test.springboot.controller;

import java.util.List;

import com.virtualan.test.springboot.exception.Error;
import com.virtualan.test.springboot.model.User;
import com.virtualan.test.springboot.service.UserService;
import io.virtualan.annotation.ApiVirtual;
import io.virtualan.annotation.VirtualService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Spring boot rest controller with virtualan.
 *
 * @author Elan Thangamani
 */

@RestController
@RequestMapping("/")
@VirtualService
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ApiVirtual
	public ResponseEntity<List<User>> findAllUsers() {
		List<User> users = this.userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findUser(@PathVariable("id") long id) {
		User user = this.userService.findById(id);
		if (user == null) {
			return new ResponseEntity<Error>(new Error("ERROR: Id =" + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user,
			UriComponentsBuilder ucBuilder) {
		this.userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	@ApiVirtual
	public ResponseEntity<?> updateUser(@PathVariable("id") long id,
			@RequestBody User user) {
		User currentUser = this.userService.findById(id);

		if (currentUser == null) {
			return new ResponseEntity<Error>(
					new Error("ERROR: Id =" + id + " not found."), HttpStatus.NOT_FOUND);
		}

		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setGender(user.getGender());
		currentUser.setAge(user.getAge());
		this.userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	@ApiVirtual
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		User user = this.userService.findById(id);
		if (user == null) {
			return new ResponseEntity<Error>(
					new Error("ERROR: Id =" + id + " not found."), HttpStatus.NOT_FOUND);
		}
		this.userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}
