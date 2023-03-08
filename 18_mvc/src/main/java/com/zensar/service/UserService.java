package com.zensar.service;

import java.util.Date;

import com.zensar.dao.UserDao;
import com.zensar.model.User;
import com.zensar.util.ConnectionUtil;

public class UserService {
	
	private UserDao dao;
	
	public UserService() {
		dao = new UserDao(ConnectionUtil.getConnection());
	}

	public User getUser(String userId, String password) {
		return dao.getUser(userId, password);
	}
	
	public boolean isPasswordExpired(User user) {
		if(new Date().compareTo(user.getPasswordExpiryDate()) >= 1) {
			return true;
		}
		return false;
	}
	
	public boolean isValidPassword(String username,String currentPassword, String newPassword) {
		//check current password is valid or not
		
		return dao.getUser(username, currentPassword)!=null 
				&& !dao.getPasswords(username).contains(newPassword);
	}
	
	public void resetPassword(String userid, String newPassword) {
		dao.updatePassword(userid, newPassword);
	}
	
	
	
}
