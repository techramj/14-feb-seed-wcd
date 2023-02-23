package com.easylearning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.easylearning.util.ConnectionUtil;

public class EmployeeDao {
	
	private Connection connection = ConnectionUtil.getConnection();
	

	
	public void tranferAmount(int fromEmpId, int toEmployeeId, double balance) {
		String sql ="update emp set salary = salary + ? where id = ?";
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return;
		}
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			//deduction
			ps.setDouble(1, -balance);
			ps.setInt(2, fromEmpId);
			int x =ps.executeUpdate();
		
			/*
			 * if(1==1) { throw new RuntimeException(); }
			 */
			
			
			//addition
			ps.setDouble(1, balance);
			ps.setInt(2, toEmployeeId);
			x=ps.executeUpdate();
			
			
			System.out.println("Money Transfered successfully!!!!");
			connection.commit();
			
		}catch(SQLException|RuntimeException e) {
			System.out.println("Transaction failed!!!");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
