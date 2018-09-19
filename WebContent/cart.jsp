<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车</title>
<link rel="stylesheet" href="CSS/cart.css">
<script language="javascript">
	var total =0;
	window.onload=function(){
	
		document.getElementById("nextStep").onclick=function(){
			window.open("PayJump?payment="+total,"_self");		
		};	
		document.getElementById("clearCart").onclick=function(){
			window.open("cart?delAll=true","_self");
		
		};
		
		var  price = document.getElementsByClassName("price");
		var itemsNum= document.getElementsByClassName("nums");
		for(var i=0;i<price.length;i++)
			{
			
				total+= parseFloat(price[i].innerHTML)*parseFloat(itemsNum[i].innerHTML);
			
			}
		document.getElementById("TotalPrice").innerHTML=total+' 元';
		
	};
	
	
	function plusfunc(id)
	{
		window.open("cart?add=true&&id="+id,"_self");	
	}
	function minusfunc(id)
	{
		window.open("cart?minus=true&&id="+id,"_self");	
	}
	
</script>

</head>
<jsp:include page="head.jsp" flush="true"></jsp:include>
<div id="PayPage">
	<div id="payHead">
		<div class="highLight">商品确认</div>
		<div class="noSelect">登陆</div>
		<div class="noSelect">订单确认</div>
	</div>
	<div id="payDetail">
		<table width="100%" border="1" rules="all">
			<tr>
				<td width="10%" align="center">编号</td>
				<td width="40%" align="center">名称</td>
				<td width="10%" align="center">单价</td>
				<td width="40%" align="center">数量</td>
			</tr>

		<c:forEach items="${sessionScope.cartList}" var="i">
			<tr>
				<td width="10%" align="center" class="bookId">${i.id}</td>
				<td width="40%" align="center">${i.bookName}</td>
				<td width="10%" align="center"  class="price">${i.bookPrice}</td>
				<td width="40%" align="center">
					
					<button  onclick="minusfunc(${i.id})">-</button>&nbsp
					<span class="nums">${i.bookAmount}</span>&nbsp
					<button  onclick="plusfunc(${i.id})">+</button> 
					<a href="cart?del=true&&id=${i.id}">删除</a> &nbsp &nbsp 
					<a href="detial?id=${i.id}">查看详情</a>
				</td>
			</tr>
			</c:forEach>
			<tr>
			<td align="center">合计</td>
			<td id="TotalPrice" colspan="3" align="center">元</td>
			</tr>
		</table>
	</div>
	<div id="PaySubmit">
		<button id="clearCart">清空购物车</button>
		<button id="nextStep">下一步</button>
	</div>
</div>
</html>