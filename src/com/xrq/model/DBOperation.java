package com.xrq.model;

import java.sql.*;
import java.util.ArrayList;

public class DBOperation {
	private Connection ct;
	private PreparedStatement ps;
	private ResultSet rs;
	private DataBean db1 = new DataBean();

	//根据id查询图书所有信息
	public DataBean getdata(int id)
	{
		try {
			ct = new DBConnect().getConnection();
			ps = ct.prepareStatement("SELECT * FROM books WHERE ID = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next())
			{
			
				db1.setId(rs.getInt(1));
				db1.setBookName(rs.getString(2));
				db1.setBookPrice(rs.getString(3));
				db1.setBookAmount(rs.getString(4));
				db1.setBookPublisher(rs.getString(5));
				db1.setBookIntro(rs.getString(6));
				db1.setBookCover(rs.getString(7));
				db1.setBookType(rs.getString(8));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}finally
		{
			this.close();
		}
		
		return db1;
	}
	
	
	//根据当前页码获取页面需要显示的所有书籍信息
	public ArrayList<DataBean> getItem(int PageNow)
	{
		ArrayList<DataBean> al = new ArrayList<DataBean>();
		ct = new DBConnect().getConnection();
		try {
			ps = ct.prepareStatement("SELECT * FROM books LIMIT ?,8");
			ps.setInt(1, (PageNow-1)*8);
			rs = ps.executeQuery();
			while(rs.next())
			{
				DataBean db = new DataBean();
				db.setId(rs.getInt(1));
				db.setBookName(rs.getString(2));
				db.setBookPrice(rs.getString(3));
				db.setBookAmount(rs.getString(4));
				db.setBookPublisher(rs.getString(5));
				db.setBookIntro(rs.getString(6));
				db.setBookCover(rs.getString(7));
				db.setBookType(rs.getString(8));
				al.add(db);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return al;
	}
	
	
	//根据传入的bean插入一个图书数据
	public boolean insert(DataBean b1)
	{
		try {
			ct = new DBConnect().getConnection();
			ps = ct.prepareStatement("INSERT INTO books(ID,bookName,bookPrice,bookAmount,bookPublisher,bookIntro,bookCover,bookType)Values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, b1.getId());
			ps.setString(2, b1.getBookName());
			ps.setString(3, b1.getBookPrice());
			ps.setString(4, b1.getBookAmount());
			ps.setString(5,b1.getBookPublisher());
			ps.setString(6, b1.getBookIntro());
			ps.setString(7, b1.getBookCover());
			ps.setString(8, b1.getBookType());
			ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("数据库插入操作失败");
		}
		
		return false;
	}
	
	
	//返回数据条数，用于分页
	public int ItemsNum() {
		int num=0;
		ct = new DBConnect().getConnection();
		try {
			
				ps = ct.prepareStatement("SELECT COUNT(*) FROM books");
				rs = ps.executeQuery();
				if(rs.next())
				{
					num = rs.getInt(1);
				}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			this.close();
		}
		return num;
	}
	
 //用户登陆验证
	public String[] UserVerify(String user)
	{
		String [] result = new String[2];
		String getPass="";
		String type="";
		try {
			ct = new DBConnect().getConnection();
			ps = ct.prepareStatement("SELECT * FROM user WHERE name=?");
			ps.setString(1, user);
			rs=ps.executeQuery();
			if(rs.next())
			{
				getPass = rs.getString(4);
				type = rs.getString(2);
				result[0]=getPass;
				result[1] = type;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			this.close();
		}
		return result;
	}
	
	//用于显示购物车信息
	public ArrayList<DataBean> displayCart(String keySet)
	{
		if(keySet.equals("")) return null;
		ArrayList<DataBean> al = new ArrayList<DataBean>();
		try {
			ct = new DBConnect().getConnection();
			ps = ct.prepareStatement("SELECT * FROM books WHERE id IN("+keySet+")");
			System.out.println("sql语句: "+ps.toString());
			rs = ps.executeQuery();
			while(rs.next())
			{
				DataBean db = new DataBean();
				db.setId(rs.getInt(1));
				db.setBookName(rs.getString(2));
				db.setBookPrice(rs.getString(3));
				db.setBookAmount(rs.getString(4));
				db.setBookPublisher(rs.getString(5));
				db.setBookIntro(rs.getString(6));
				db.setBookCover(rs.getString(7));
				db.setBookType(rs.getString(8));
				al.add(db);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return al;
	}
	
	
//关闭数据库连接	
	private void close()
	{
		try {
			
			rs.close();
			ps.close();
			ct.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("关闭数据库异常");
		}
	}

}
