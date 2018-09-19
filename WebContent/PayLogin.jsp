<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>请先登陆</title>
<link rel="stylesheet" href="CSS/cart.css">
</head>
<jsp:include page="head.jsp" flush="true"></jsp:include>

<div id="payHead">
		<div class="noSelect">商品确认</div>
		<div class="highLight">登陆</div>
		<div class="noSelect">订单确认</div>
</div>

<form action="userVerify" method="post">
<p style ="text-align:center"/>姓名：  <input type ="text" name="userName" >
<p style ="text-align:center"/>密码：<input type ="text" name ="userPassword"><br><br>
<input type="hidden" name="payLogin" value="true">
<input type="hidden" name="payment" value="${param.payment}" >
<input type="submit" value="提交" style = "text-align:center"/>
</form>

</html>