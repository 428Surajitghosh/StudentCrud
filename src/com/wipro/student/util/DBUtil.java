package com.wipro.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection conn;
	public static Connection getDBConnection()
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
																 
			try 
			{
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
				//System.out.println("Connection established successfully");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//System.out.println("Connection not established");
			}
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//System.out.println("Driver not loaded");
		}
		return conn;
	}
}
