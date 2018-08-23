package com.xrq.model;
import java.sql.*;

public class DBConnect {

	private final String URL="jdbc:mysql://localhost:3306/bookstore?serverTimezone=GMT%2B8&useSSL=false";
	private final String User="root";
	private final String Password="123456";
	private Connection ct;
	public Connection getConnection()
	{
		
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库获取驱动失败！");
		}
		try {
			ct =DriverManager.getConnection(URL, User, Password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ct;
	
	}
}
