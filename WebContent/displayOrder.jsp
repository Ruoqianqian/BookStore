<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 下单后显示订单详细信息 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单详情</title>
</head>
<body>
<jsp:include page="head.jsp" flush="true"></jsp:include>

<h2 align="center">订单详情：</h2>
<p>订单号：${requestScope.orderBase.orderId}</p>
<hr>
<table border="1" rules="all" align="center">
<tr>
<td align="center">商品名称</td>
<td align="center">商品数量</td>
</tr>
<c:forEach items="${requestScope.orderDetail}" var="i">
<tr>
<td align="center"> ${i.orderItem}</td>
<td align="center">${i.itemNum}</td>
</tr>
</c:forEach>
</table>

<p align="center">付款方式：${requestScope.orderBase.ordMethod} &nbsp 订单总额：${requestScope.orderBase.orderPayment} &nbsp 下单时间: ${requestScope.orderBase.date}</p>
<hr>
<p align="center">
配送信息：<br>
地址： ${requestScope.delivery.userAddress}<br>
Email: ${requestScope.delivery.userEmail}<br>
联系方式: ${requestScope.delivery.userPhone}<br>
</p>

</body>
</html>