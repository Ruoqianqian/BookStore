<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String userName = (String)request.getSession().getAttribute("name");
	String type = (String)request.getSession().getAttribute("type");
	if(userName==null || type==null)  request.getRequestDispatcher("errorPage.jsp").forward(request, response);
	else{
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>LoginResult</title>
</head>
<jsp:include page="head.jsp" flush="true"></jsp:include>
<p>欢迎登陆： <%=userName %> 您的身份：<%=type %>
</p>
<%
	if(type.equals("manager")){
%>
	<p align="center">
	<a href ="Upload.jsp">书籍上新</a></p>
<%} %>

<%
	if(type.equals("user")){
%>
	<p align="center"><a href ="">我的订单</a></p>
	<p align="center"><a  href ="">我的购物车</a></p>
<%}%>

</html>
<% }%>