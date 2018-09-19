<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 显示某用户的所有订单 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>


<body>
<jsp:include page="head.jsp" flush="true"></jsp:include>
<p>
欢迎你： ${sessionScope.name}<br>
</p>
<hr>
<h2 align="center">您的订单情况如下：</h2>
<table border="1" rules="all" align="center">
<tr>
<td align="center">订单号</td>
<td align="center">付款方式</td>
<td align="center">订单金额</td>
<td align="center">订单日期</td>
<td align="center">操作</td>
</tr>
<c:forEach items="${requestScope.orderList}" var="i">
	<tr>
		<td align="center">${i.orderId}</td>
		<td align="center">${i.ordMethod}</td>
		<td align="center">${i.orderPayment}</td>
		<td align="center">${i.date}</td>
		<td align="center"><a href="orderSystem?orderId=${i.orderId}&&payment=${i.orderPayment}">查看详情</a></td>
	</tr>
</c:forEach>
</table>
<br><br>

	<hr style="height: 2px; background: #FFF;">
	<div id="bottom">
		<div>This webSite designed by XRQ</div>
		<div>本项目用于学习交流</div>
		<div>Email: a741989462@gmail.com</div>
	</div>
</body>
</html>