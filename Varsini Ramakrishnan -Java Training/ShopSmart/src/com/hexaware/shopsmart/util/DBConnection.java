package com.hexaware.shopsmart.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection;
	
public static Connection getConnection() throws SQLException {
        
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopsmart", "root", "12345678");
		return con;

}
}
