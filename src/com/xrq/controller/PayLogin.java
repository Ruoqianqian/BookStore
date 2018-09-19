package com.xrq.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PayLogin
 */
//本页用于购物车页跳转逻辑，如果已登录，购物车下一步是支付
//如果未登陆，购物车的下一步就是原地登陆
@WebServlet("/PayLogin")
public class PayLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PayLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sessionLogin = (String)request.getSession().getAttribute("login");
		if(sessionLogin==null)
		{
			request.getRequestDispatcher("PayLogin.jsp").forward(request, response);
		}else
		{
			request.getRequestDispatcher("pay.jsp").forward(request, response);
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
