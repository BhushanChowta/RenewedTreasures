package com.shopping.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

	private static Connection connection=null;
	
	public static Connection getConnection() throws ClassNotFoundException {
		if(connection!=null) {
			return connection;
		}
		else {
			try {
				String driver="com.mysql.cj.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/shoppingdb?useSSL=false";
				String user="root";
				String password="Sahyadri@1";
				Class.forName(driver);
			    connection=DriverManager.getConnection(url,user,password);
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return connection;
	}
}