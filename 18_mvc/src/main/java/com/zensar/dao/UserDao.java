package com.zensar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zensar.model.User;

public class UserDao {
	
	private Connection connection;
	
	public UserDao(Connection connection) {
		this.connection = connection;
	}
	
	
	public void addUser(User user) {
		
	}
	
	public void deleteUser(String userId) {
		
	}
	
	public User getUser(String username,String password) {
		String sql ="select USER_ID,FIRST_NAME,LAST_NAME, email,PASSWORD,PASSWORD_EXP_DATE " 
				+" from users where user_id=? and password=?";
		User user =null;
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = populateUser(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public List<String> getPasswords(String userId){
		List<String> list =new ArrayList<String>();
		return list;
	}
	
	public void updatePassword(String userid, String password) {
		String sql="update users set password=?, PASSWORD_EXP_DATE=sysdate+30 where user_id=?";
		
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, password);
			ps.setString(2, userid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		addPasswordHistory(userid, password);
	}
	
	public void addPasswordHistory(String userid,String password) {
		String sql="insert into password_history(user_id,password) values (?,?)";
	}
	
	private User populateUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setUserId(rs.getString(1));
		user.setFirstName(rs.getString(2));
		user.setLastName(rs.getString(3));
		user.setEmail(rs.getString(4));
		user.setPasswordExpiryDate(rs.getDate(6));
		user.setPassword(rs.getString(5));
		
		return user;
	}

}
