package com.xrq.model;

import java.sql.*;
import java.util.ArrayList;

public class DBOperation extends BaseDao{
	private DataBean db1 = new DataBean();
	private ResultSet rs;

	//根据id查询图书所有信息
	public DataBean getdata(String id)
	{
		try {
			rs = this.excuteQuery("SELECT * FROM books WHERE ID = ?", id);
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
				db1.setSellCount(rs.getString(10));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}finally
		{
			try {
				rs.close();
				this.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return db1;
	}
	

	//根据传入的bean插入一个图书数据
	public void insert(DataBean b1)
	{
		String result;
		try {
			this.excuteUpdate("INSERT INTO books(ID,bookName,bookPrice,bookAmount,bookPublisher,bookIntro,bookCover,bookType)Values(?,?,?,?,?,?,?,?)", b1.getId(),b1.getBookName(),b1.getBookPrice(), b1.getBookAmount(),b1.getBookPublisher(),b1.getBookIntro(),b1.getBookCover(),b1.getBookType());
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("数据库插入操作失败");
		}finally {
			
			this.close();
		}
	}
	
	
	//返回数据总条数，用于分页 。The total number of lines in database
	public int ItemsNum() throws SQLException {
		int num=0;

		try {
				rs = this.excuteQuery("SELECT COUNT(*) FROM books");
				if(rs.next())
				{
					num = rs.getInt(1);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			rs.close();
			this.close();
		}
		return num;
	}
	
 //用户登陆验证 --- to get the password and user Type
	public String[] UserVerify(String user)
	{
		String [] result = new String[2];
		String getPass="";
		String type="";
		try {
			rs = this.excuteQuery("SELECT * FROM user WHERE name=?", user);
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
			try {
				rs.close();
				this.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//用于显示购物车信息
	public ArrayList<DataBean> displayCart(String keySet,Cart c1)
	{ 
		
		if(keySet.equals("")) return null;
		ArrayList<DataBean> al = new ArrayList<DataBean>();
		try {
			rs = this.excuteQuery("SELECT * FROM books WHERE id IN("+keySet+")");
			while(rs.next())
			{
				DataBean db = new DataBean();
				db.setId(rs.getInt(1));
				db.setBookName(rs.getString(2)); 
				db.setBookPrice(rs.getString(3));
				db.setBookAmount(c1.getNum(rs.getString(1)));
				System.out.println("ID和数量==+ID: "+rs.getString(1)+"num: "+c1.getNum(rs.getString(1)));
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
			try {
				rs.close();
				this.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return al;
	}
	
	
//动态显示桌面数据 type: new \recommend //新书上架和编辑推荐逻辑(new books and recommends in Index.jsp)
	public ArrayList<DataBean> displayIndex(String type)
	{
		ArrayList<DataBean> al = new ArrayList<DataBean>();
		try {
			rs = this.excuteQuery("SELECT * FROM books WHERE showFlag=?", type);
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
			try {
				rs.close();
				this.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;
		
	}
	//通过用户获取用户id、地址、email等信息
	public DataBean getUserData(String name) {
		DataBean b1 = new DataBean();
		try {
			rs = this.excuteQuery("SELECT * FROM user WHERE name =?", name);
			if(rs.next())
			{
				b1.setUserId(rs.getString(1));  //userId
				b1.setUserAddress(rs.getString(5));
				b1.setUserEmail(rs.getString(6));
				b1.setUserPhone(rs.getString(7));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				this.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b1;
	}
	//生成订单（订单号）
	public void generateOrder(String userId,String payment)
	{
		try {
			this.excuteUpdate("INSERT INTO baseOrder (userId,totalPayment) VALUES (?,?)",userId,payment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				this.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//获取最新建立的订单的订单号
	public String getOrderId()
	{
		String orderId="";
		try {
			rs = this.excuteQuery("SELECT MAX(orderId) FROM baseOrder");
			if(rs.next())
			{
				orderId= rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				this.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return orderId;
	}
	//插入一个订单细节项
	public void InsertorderDetail(String orderId,String item, String num)
	{
		try {
			this.excuteUpdate("INSERT INTO orderdetail (orderId,productId,productNum) VALUES (?,?,?)", orderId,item,num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				this.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//返回订单细节信息，用于页面显示
	public ArrayList<OrderBean> getOrderDetail(String orderId)
	{
		 ArrayList<OrderBean> orderList = new ArrayList<OrderBean>();
		try {
			rs = this.excuteQuery("SELECT * FROM orderdetail WHERE orderId=?", orderId);
			while(rs.next())
			{
				OrderBean ob = new OrderBean();
				ob.setOrderId(rs.getString(1));
				ob.setOrderItem(rs.getString(2));
				ob.setItemNum(rs.getString(3));
				orderList.add(ob);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				this.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return orderList;
		
	}
	
	//根据订单号获取订单基本信息
	public OrderBean getOrder(String orderId)
	{
		OrderBean ob2 = new OrderBean();
		try {
			rs= this.excuteQuery("SELECT * FROM baseOrder WHERE orderId =?", orderId);
			if(rs.next())
			{
				ob2.setOrderId(orderId);
				ob2.setOrdMethod(rs.getString(3));
				ob2.setOrderPayment(rs.getString(4));
				ob2.setDate(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				this.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ob2;
		
	}
	//查询一个用户的所有订单
	public ArrayList<OrderBean> getUserOrder(String userId)
	{
		ArrayList<OrderBean> orderList = new ArrayList<OrderBean>();
		try {
			rs = this.excuteQuery("SELECT * FROM baseOrder WHERE userId = ?", userId);
			while(rs.next())
			{
				OrderBean ob = new OrderBean();
				ob.setOrderId(rs.getString(1));
				ob.setOrdMethod(rs.getString(3));
				ob.setOrderPayment(rs.getString(4));
				ob.setDate(rs.getString(5));
				orderList.add(ob);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				this.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return orderList;
		
	}
}
