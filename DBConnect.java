package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static Connection con;

	public static Connection getcon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","Kumar@123");
			
		}
	catch(Exception e) {
		e.printStackTrace();
	}
	return con;
}
}
