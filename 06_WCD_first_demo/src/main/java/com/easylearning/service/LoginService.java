package com.easylearning.service;

import com.easylearning.dao.UserDao;
import com.easylearning.model.User;

public class LoginService {
	
	private UserDao userDao = new UserDao();
	
	
	public boolean isValidUser(String username,String password) {
		User user = getUser(username, password);
		if(user == null) {
			//return false;
		}
		return true;
	}
	
	public User getUser(String username,String password) {
		return userDao.getUsers(username, password);
	}
	
	public boolean validatePassword(String password) {
		//logic to validate passord
		return true;
	}

}
