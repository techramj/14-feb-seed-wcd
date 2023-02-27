package com.easylearning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.easylearning.model.User;
import com.easylearning.util.ConnectionUtil;

public class UserDao {
	
	private Connection connection = ConnectionUtil.getConnection();
	
	public User getUser(String username) {
		String sql ="select * from users where user_name=?";
		
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return getUser(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void save(User user) {
		//logic to  save the data
	}
	
	
	private User getUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("userid"));
		user.setUsername(rs.getString("user_name"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setPasswordExpiryDate(rs.getDate("password_expiry_date"));
		return user;
	}
	
}
