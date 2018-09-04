package com.virtualan.test.springboot.model;

/**
 * Spring boot rest controller with virtualan
 * 
 * @author Elan Thangamani
 *
 */
public class User {

	private long id;
	
	private String firstName;
	private String lastName;
	private String gender;
	
	private int age;
	
	
	public User(long id, String firstName, String lastName, String gender, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

}
