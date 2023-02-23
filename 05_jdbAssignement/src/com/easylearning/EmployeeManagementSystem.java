package com.easylearning;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import com.easylearning.util.ConnectionUtil;

public class EmployeeManagementSystem {
	
	private static Connection conn;
	private static Statement statment;
	private static ResultSet resultSet;
	
	
	public void displayMenu() {
		String ans="";
		
		try {
			do {
				int choice = getChoice();
				resultSet = getEmployeeResultSet();
				switch(choice) {
				case 1: displayEmployees(resultSet); break;
				case 2:
				case 3:
				case 4: addEmployee(resultSet);
				}
				ans = getAnswer();
				
			}while("Y".equals(ans));
		} catch (SQLException e) {
			System.out.println("Error in the system. Try another day");
		}
		System.out.println("Thank you! please visit again.");
		
	}
	
	public void addEmployee(ResultSet rs) throws SQLException{
		//rs.moveToInsertRow();
	}
	
	public void displayEmployees(ResultSet rs) throws  SQLException {
		rs.beforeFirst();
		while(rs.next()) {
			display(rs);
		}
	}
	
	public void display(ResultSet rs) throws SQLException{
		int id = rs.getInt(1);
		String name = rs.getString(2);
		double salary = rs.getDouble(3);
		System.out.println("id: "+id+"    name: "+name+"    salary:"+salary);
	}
	
	public String getAnswer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Do you want to continue(Y/N)? ");
		String ans = sc.next();
		return ans.toUpperCase();
	}
	
	public ResultSet getEmployeeResultSet() throws SQLException {
		conn = ConnectionUtil.getConnection();
		statment = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs  = statment.executeQuery("select id,name,salary from emp");
		return rs;
	}
	
	public static int getChoice() {
		System.out.println("1.Display\n2.Update\n3.Delete\n4. Add");
		System.out.print("Enter you choice: ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		if(choice<1 || choice>4) {
			throw new IllegalArgumentException("Invalid Choice");
		}
		return choice;
	}

}
