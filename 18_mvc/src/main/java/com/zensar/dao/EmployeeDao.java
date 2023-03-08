package com.zensar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zensar.model.Employee;

public class EmployeeDao {
	
	private Connection connection;
	
	public EmployeeDao() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeDao(Connection connection) {
		this.connection = connection;
	}
	
	public void addEmployee(Employee emp) {
		String sql="insert into emp(id,name,salary) values (emp_seq.nextval,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, emp.getName());
			ps.setDouble(2, emp.getSalary());
			int x=ps.executeUpdate();
			System.out.println(x+"row inserted!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateEmployee(Employee emp) {
		String sql="update emp set name= ?, salary=? where id=?";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setInt(3, emp.getId());
			ps.setString(1, emp.getName());
			ps.setDouble(2, emp.getSalary());
			int x=ps.executeUpdate();
			System.out.println(x+" row updated!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEmployee(int id) {
		String sql="delete emp where id=?";
		try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setInt(1, id);
			int x=ps.executeUpdate();
			System.out.println(x+" row deleted!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee> getEmployees(){
		List<Employee> list = new ArrayList<Employee>();
		String sql="select id,name,salary from emp";
		try(Statement st=connection.createStatement()){
			try(ResultSet rs= st.executeQuery(sql);){
				while(rs.next()) {
					list.add(populateEmp(rs));
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Employee getEmployeeById(int id) {
		Employee emp=null;
		String sql="select id,name,salary from emp where id=?";
		try(PreparedStatement ps=connection.prepareStatement(sql)){
			ps.setInt(1, id);
			try(ResultSet rs= ps.executeQuery();){
				while(rs.next()) {
					emp=populateEmp(rs);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}
	
	public List<Employee> getEmployeeByName(String name) {
		List<Employee> list = new ArrayList<Employee>();
		String sql="select id,name,salary from emp where id=?";
		try(PreparedStatement ps=connection.prepareStatement(sql)){
			ps.setString(1, name);
			try(ResultSet rs= ps.executeQuery();){
				while(rs.next()) {
					list.add(populateEmp(rs));
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	private Employee populateEmp(ResultSet rs) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getInt(1));
		emp.setName(rs.getString(2));
		emp.setSalary(rs.getDouble(3));
		return emp;
	}

}
