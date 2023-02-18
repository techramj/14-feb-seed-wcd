package com.easylearning.model;

import java.util.Date;

public class User {

	private int userId;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Date passwordExpirtyDate;
	private Date created;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getPasswordExpirtyDate() {
		return passwordExpirtyDate;
	}

	public void setPasswordExpirtyDate(Date passwordExpirtyDate) {
		this.passwordExpirtyDate = passwordExpirtyDate;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
