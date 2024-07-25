package com.epsillon.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDb","root","22904110");
		}catch(ClassNotFoundException |SQLException ex) {
			System.out.println(ex);
		}
		return conn;
	}
}
