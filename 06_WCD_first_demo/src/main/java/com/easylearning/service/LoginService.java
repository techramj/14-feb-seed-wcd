package com.easylearning.service;

import com.easylearning.dao.UserDao;
import com.easylearning.model.User;

public class LoginService {

	private UserDao userDao = new UserDao();

	public boolean isValidUser(String username, String password) {
		return null != getUser(username, password);
	}

	public User getUser(String username, String password) {
		User user = userDao.getUser(username);
		if (user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	public boolean validatePassword(String password, String confirmpassword) {
		return password != null 
				&& confirmpassword != null 
				&& password.equals(confirmpassword);
	}
	
	public boolean isNewUser(String username) {
		User user = userDao.getUser(username);
		if(user == null) {
			return true;
		}
		return false;
	}
	
	public void saveUser(User user) {
		userDao.save(user);
	}


}
