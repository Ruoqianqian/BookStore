<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>支付页</title>
<link rel="stylesheet" href="CSS/cart.css">
<script language="javascript">

window.onload=function(){
	document.getElementById("submit").onclick=function()
	{

		var payment = document.getElementById("payment").innerHTML;
		window.open("orderSystem?payment="+payment,"_self");

	};
	
};

</script>
</head>
<jsp:include page="head.jsp" flush="true"></jsp:include>

<div id="payHead">
		<div class="noSelect">商品确认</div>
		<div class="noSelect">登陆</div>
		<div class="highLight">订单确认</div>
</div>


<P>欢迎： ${sessionScope.name} </P>
<p>确认订单信息：</p>
<table border="1" rules="all" width="80%" align="center">
<tr>
<td align="center" width="30%">商品信息</td>
<td align="center" width="10%">商品数量</td>
<td align="center" width="20%">商品单价</td>
<td align="center" width="30%">小计</td>
</tr>

<c:forEach items="${sessionScope.cartList}" var="i">
			<tr>
				<td width="10%" align="center" class="bookId">${i.bookName}</td>
				<td width="40%" align="center">${i.bookAmount} 件</td>
				<td width="10%" align="center"  class="price">${i.bookPrice} 元</td>
				<td width="40%" align="center"> ${i.bookAmount*i.bookPrice} 元</td>
			</tr>
</c:forEach>
			<tr>
			<td align="center">合计</td>
			<td  id="payment" colspan="3" align="center">${param.payment}</td>
			</tr>
</table>
<button id ="submit" >确认订单</button>
</html>