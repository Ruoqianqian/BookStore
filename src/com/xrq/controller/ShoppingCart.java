package com.xrq.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xrq.model.Cart;
import com.xrq.model.DBOperation;
import com.xrq.model.DataBean;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookId = request.getParameter("id");
		String add = request.getParameter("add");
		String display = request.getParameter("display");
		String del = request.getParameter("del");
		String delAll = request.getParameter("delAll");
		String addToCart = request.getParameter("detailJump");
		String minus = request.getParameter("minus");
		HttpSession se2 = request.getSession();
		HttpSession se1 = request.getSession();

		Cart c1 = (Cart)request.getSession().getAttribute("cart");
		if(c1==null)  //session过期，或者第一次。每次都从session获得特定的购物车
		{//	没有就新建一个购物车
			System.out.println("首次进购物车或session过期");
			 c1 = new Cart();
			 se1.setAttribute("cart", c1);
			 se1.setMaxInactiveInterval(60);
		}
		if(minus!=null)
		{
			String num = c1.getNum(bookId);
			if(Integer.parseInt(num)>1)
			{ 
				int tmp = Integer.parseInt(num)-1;
				c1.addItem(bookId,tmp+""); 
			}
			else {
				c1.delItem(bookId);
			}
			String keySet = c1.displayItem();
			ArrayList<DataBean> al = new DBOperation().displayCart(keySet,c1);
			request.setAttribute("cart", al);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}
		if(add!=null)  //添加商品到购物车
		{
			String num = c1.getNum(bookId);
			if (num==null) {
				c1.addItem(bookId, "1"); 
			}else
			{
				int tmp = Integer.parseInt(num)+1;
				c1.addItem(bookId,tmp+""); 
				System.out.println("new num: "+tmp);
			}
			if(addToCart!=null)  //在详情页加入购物车
				response.sendRedirect("detial?id="+bookId);
			else   //在购物车结算页更改购物车商品数量
			{	
				String keySet = c1.displayItem();
				ArrayList<DataBean> al = new DBOperation().displayCart(keySet,c1);
				se2.setAttribute("cartList", al);
				se2.setMaxInactiveInterval(60);
				request.getRequestDispatcher("cart.jsp").forward(request, response);
			}
		}
		if(display!=null)  //显示购物车页面
		{
			String keySet = c1.displayItem();
			ArrayList<DataBean> al = new DBOperation().displayCart(keySet,c1);
	
			se2.setAttribute("cartList", al);
			se2.setMaxInactiveInterval(60);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}
		
		if(del!=null)  //删除购物车的某件商品
		{
			c1.delItem(bookId);
			String keySet = c1.displayItem();
			ArrayList<DataBean> al = new DBOperation().displayCart(keySet,c1);
			se2.setAttribute("cartList", al);
			se2.setMaxInactiveInterval(60);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}
		
		if(delAll!=null)  //清空购物车操作
		{
			c1.delAll();
			String keySet = c1.displayItem();
			ArrayList<DataBean> al = new DBOperation().displayCart(keySet,c1);
			se2.setAttribute("cartList", al);
			se2.setMaxInactiveInterval(60);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
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
