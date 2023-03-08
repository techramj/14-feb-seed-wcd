package com.zensar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection connection;

	public static Connection createConnectionObject(String driver, String url,
			String username, String password){ 
		if(connection==null) {
			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		return connection;
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
