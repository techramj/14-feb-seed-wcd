package com.easylearning.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static Connection connection;
	private static String filename= "jdbc.properties";

	static {
		Properties prop = new Properties();
		try(FileInputStream fis = new FileInputStream(filename)) {
			prop.load(fis);
			String driverName = prop.getProperty("jdbc.driver");
			String username = prop.getProperty("jdbc.username");
			String password = prop.getProperty("jdbc.password");
			String url = prop.getProperty("jdbc.url");
			
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		return connection;
	}
	
	public static void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
