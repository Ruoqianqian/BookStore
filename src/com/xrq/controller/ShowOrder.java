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
 * Servlet implementation class ShowOrder
 */
@WebServlet("/ShowOrder")
public class ShowOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //用于显示某个用户的所有订单
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = (String)request.getSession().getAttribute("name");
		DBOperation dop = new DBOperation();
		DataBean db = dop.getUserData(name);
		String userId = db.getUserId();
		ArrayList<OrderBean> al = dop.getUserOrder(userId);
		request.setAttribute("orderList", al);
		request.getRequestDispatcher("showOrder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
