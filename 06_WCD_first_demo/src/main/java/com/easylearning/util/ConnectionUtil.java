package com.easylearning.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection connection;

	static {
		// step 1 : load the driver
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String username = "hr";
		String password = "hr";
		String url = "jdbc:oracle:thin:@localhost:1521/ORCLPDB";
		try {
			// loading the driver
			Class.forName(driverName);
			System.out.println("Driver loaded successfully!!!");

			connection = DriverManager.getConnection(url, username, password);
			System.out.println("DB connected established");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		return connection;
	}

}
