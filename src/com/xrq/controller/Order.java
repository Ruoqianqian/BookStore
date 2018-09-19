package com.xrq.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xrq.model.DBOperation;
import com.xrq.model.DataBean;
import com.xrq.model.OrderBean;

/**
 * Servlet implementation class Order
 */
@WebServlet("/Order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderId =request.getParameter("orderId");
		String userName = (String)request.getSession().getAttribute("name");
		DBOperation orderOpera = new DBOperation();
		if(orderId==null)
		{ //建立新的订单并显示
		@SuppressWarnings("unchecked")
		String payment = (String)request.getParameter("payment");
		
		ArrayList<DataBean> al = (ArrayList<DataBean>)request.getSession().getAttribute("cartList");
		
		DataBean userData = orderOpera.getUserData(userName); //通过用户名获取用户信息id、地址等
		orderOpera.generateOrder(userData.getUserId(), payment);  //生成订单，用户id、订单id(自动生成)、总金额
		orderId = orderOpera.getOrderId();  //获取订单号 
		for(DataBean i:al)  //完成订单细节： 订单号、商品、数量（插入数据库）
		{
			orderOpera.InsertorderDetail(orderId, i.getBookName(), i.getBookAmount());
		}
		
		ArrayList<OrderBean> orderDetail = orderOpera.getOrderDetail(orderId);
		OrderBean orderBase = orderOpera.getOrder(orderId);
		//以下数据传给界面显示
		request.setAttribute("orderDetail", orderDetail);
		request.setAttribute("orderBase", orderBase);
		request.setAttribute("delivery", userData);
		request.getRequestDispatcher("displayOrder.jsp").forward(request, response);
		}else
		{	//显示已有订单
			
			DataBean userData = orderOpera.getUserData(userName); //通过用户名获取用户信息id、地址等
			ArrayList<OrderBean> orderDetail = orderOpera.getOrderDetail(orderId);
			OrderBean orderBase = orderOpera.getOrder(orderId);
			request.setAttribute("orderDetail", orderDetail);
			request.setAttribute("orderBase", orderBase);
			request.setAttribute("delivery", userData);
			request.getRequestDispatcher("displayOrder.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
