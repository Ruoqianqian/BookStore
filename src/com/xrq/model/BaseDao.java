package com.xrq.model;
import java.sql.*;
/*
 *  The base data access object
 */
public class BaseDao {

	private final String URL="jdbc:mysql://localhost:3306/bookstore?serverTimezone=GMT%2B8&useSSL=false";
	private final String User="root";
	private final String Password="123456";
	private Connection ct;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/*
	 * return  Connection 
	 */
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
	
	//use for Mysql Query
	public ResultSet excuteQuery(String sql, Object... obj) throws SQLException
	{
		ct = this.getConnection();
		ps = ct.prepareStatement(sql);
		if(obj!=null)
		{
			for(int i=0;i<obj.length;i++)
				ps.setString(i+1, (String)obj[i]);
		}
		rs= ps.executeQuery();
		return rs;
	}
	
	
	//use for Mysql Update(insert、delete、etc)
	public void excuteUpdate(String sql, Object... obj) throws SQLException
	{
	
		ct = this.getConnection();
		ps = ct.prepareStatement(sql);
		if(obj!=null)
		{
			for(int i=0;i<obj.length;i++)
				ps.setString(i+1, (String)obj[i]);
		}
		ps.executeUpdate();
		
	}
	
	public void close()
	{
		try {		
			ps.close();
			ct.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("关闭数据库异常");
		}
	}
	
	
	
}
