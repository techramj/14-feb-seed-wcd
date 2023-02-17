package com.easylearning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.easylearning.model.User;
import com.easylearning.util.ConnectionUtil;

public class UserDao {
	
	private Connection connection = ConnectionUtil.getConnection();
	
	public User addUser(User user) {
		return null;
	}
	
	public int deleteUser(int userId) {
		return 0;
	}
	
	public int deleteUserByUserName(String username) {
		String sql ="delete from users where user_name = ?";
		try(PreparedStatement ps= connection.prepareStatement(sql)){
			ps.setString(1, username);
			return ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteUserbyName(String firstName, String lastName) {
		return 0;
	}
	
	public User getUserById(int id) {
		return null;
	}
	
	
}
