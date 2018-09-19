package com.xrq.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.xrq.model.DBOperation;
import com.xrq.model.DataBean;

/**作用注释*********
 * Servlet Filter implementation class TestFilter
 * This filter is used for index display
 * Intercepeting the request, connect the DAO to acquire data to display in index
 *  request----->filter ----> Database(acquire data)----->filter ------->index.jsp
 */
@WebFilter("/TestFilter")
public class TestFilter implements Filter {

    public TestFilter() {
        // TODO Auto-generated constructor stub
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("Get into the Filter");
		ArrayList<DataBean> newBooks = new ArrayList<DataBean>();
		newBooks = new DBOperation().displayIndex("new");  //新书上架（NEW Books）
		request.setAttribute("newBooks", newBooks);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
