package com.easylearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		Connection con1 = getConnection();
		Connection con2= getConnection();
	}

	public static Connection getConnection() {
		Connection conn = null;
		String driverName ="oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/ORCLPDB";
		//String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "hr";
		//step 1: Load the driver
		try {
			Class.forName(driverName);
			System.out.println("Driver loaded!!!!");
			
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("connection established!!!!!!!!!");
		} catch (ClassNotFoundException| SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

}
