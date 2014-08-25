package com.jdc.shop.model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	
	private static String URL = "jdbc:mysql://localhost:3306/phone_db";
	private static String USER = "root";
	private static String PASS = null;
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}

}
