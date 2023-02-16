package com.easylearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection connection;

	static {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/ORCLPDB";
		// String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "hr";
		// step 1: Load the driver
		try {
			Class.forName(driverName);
			System.out.println("Driver loaded!!!!");

			connection = DriverManager.getConnection(url, username, password);
			System.out.println("connection established!!!!!!!!!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
