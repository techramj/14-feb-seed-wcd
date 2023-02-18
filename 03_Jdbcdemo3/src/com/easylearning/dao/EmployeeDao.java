package com.easylearning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.easylearning.model.Employee;
import com.easylearning.util.ConnectionUtil;

public class EmployeeDao {
	
	private Connection connection = ConnectionUtil.getConnection();
	
	public Employee addEmployee(Employee emp) {
		int id = getNewId();
		System.out.println("new id= "+id);
		emp.setId(id);
		String sql ="insert into emp(id,name,salary) values (?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return emp;	
	}
	
	public int getNewId() {
		String sql ="select emp_seq1.nextval from dual";
		int i =0;
		try(Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(sql);
				){
			if(rs.next()) {
				i= rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

}
