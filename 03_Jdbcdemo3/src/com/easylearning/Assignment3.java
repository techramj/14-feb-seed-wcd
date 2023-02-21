package com.easylearning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easylearning.model.Employee;
import com.easylearning.util.ConnectionUtil;

public class Assignment3 {
	public static final int BATCH_SIZE = 500;
	
	public static void main(String[] args) {
		Assignment3 ob = new Assignment3();
		List<Employee> empList = getEmployees(100000);
		ob.addEmployee(empList);
	}
	
	public void addEmployee() {
		String sql ="insert into emp(id,name,salary) values (seq_emp, 'Jack-'||LPAD(?,5,'0'), 1000+?)";
		Connection conn = ConnectionUtil.getConnection();
		int count =0;
		
		long t1 = System.currentTimeMillis();
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			for(int i=1;i<=10000;i++) {
				++count;
				ps.setInt(1, i);
				ps.setInt(2, i-1);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time taken to insert 10000 rows: "+(t2-t1)+" ms");
		
	}
	
	public void addEmployee(List<Employee> employees) {
		String sql ="insert into emp(id,name,salary) values (?,?,?)";
		Connection conn = ConnectionUtil.getConnection();
		long t1 = System.currentTimeMillis();
		int count = 0;
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			for(Employee e:employees) {
				++count;
				ps.setInt(1, e.getId());
				ps.setString(2, e.getName());
				ps.setDouble(3, e.getSalary());
				ps.addBatch();
				if(count%BATCH_SIZE == 0) {
					ps.executeBatch();
				}
			}
			if(count%BATCH_SIZE != 0) {
				ps.executeBatch();
			}
			ps.executeBatch();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time taken to insert 10000 rows: "+(t2-t1)+" ms");
		
	}
	

	public static List<Employee> getEmployees(int empCount){
		List<Employee> empList = new ArrayList<Employee>();
		for(int i=1;i<=empCount;i++) {
			Employee emp = new Employee();
			emp.setId(i);
			emp.setSalary(1000+i-1);
			emp.setName(getFormatedName("Jack",i));
			empList.add(emp);
		}
		return empList;
	}
	
	public static String getFormatedName(String prefix,int id) {
		StringBuilder sb = new StringBuilder(prefix+"-");
		int len = (id+"").length();
		for(int i=1;i<=8-len;i++) {
			sb.append("0");
		}
		sb.append(id);
		return sb.toString();
	}
	
	

}
