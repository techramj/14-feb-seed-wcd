package com.easylearning.dao;

import java.sql.Connection;

import com.easylearning.model.User;
import com.easylearning.util.ConnectionUtil;

public class UserDao {
	
	private Connection connection = null;
	
	public User getUsers(String username, String password) {
		String sql ="select * from users where username=? and password =?";
		return null;
	}
	
	
}
