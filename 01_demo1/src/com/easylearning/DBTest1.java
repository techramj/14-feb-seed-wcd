package com.easylearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest1 {
	
	public static void main(String[] args) {
		//step 1 : load the driver
		String driverName = "oracle.jdbc.driver.OracleDriver";
		System.out.println("Driver loaded");
		Connection con = null;
		try {
			//loading the driver
			Class.forName(driverName);
			System.out.println("Driver loaded successfully!!!");
			
			
			String username ="hr";
			String password = "hr";
			String url ="jdbc:oracle:thin:@localhost:1521/ORCLPDB";
			
			con = DriverManager.getConnection(url, username, password);
			System.out.println("DB connected successfully");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(con.getClass().getName());
	}

}
