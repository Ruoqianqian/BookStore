<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Book Detail</title>
<link rel="stylesheet" href="css/style.css"/>
<script language="javascript">
	window.onload = function(){
		document.getElementById("toIndex").onclick=function()
		{
			window.open("index.jsp","_self");
		};
	};
	function toCart(id)
	{
		window.alert("已加入购物车");
		window.open("cart?id="+id+"&&add=true&&detailJump=true","_self");
	}
</script>
</head>
<body>
 <jsp:include page ="head.jsp" flush="true"></jsp:include>
	<div id="dPage">
		<div id="CoverImg"><img id="dImg" src="images/${requestScope.dat1.bookCover}"></div>
		<div id="detail">
			<table border="1" rules="all">
				<tr>
					<td width="500px" height="30px">书籍名称：${requestScope.dat1.bookName}</td>
				</tr>
				<tr>
					<td height="30px">ISBN号：${requestScope.dat1.id}</td>
				</tr>
				<tr>
					<td height="30px">价格：${requestScope.dat1.bookPrice}</td>
				</tr>
				<tr>
					<td height="30px">数量:${requestScope.dat1.bookAmount}</td>
				</tr>
				<tr>
					<td height="30px">出版社：${requestScope.dat1.bookPublisher}</td>
				</tr>
				<tr>
					<td height="30px">类别: ${requestScope.dat1.bookType}</td>
				</tr>
				<tr>
					<td height="98px">简介: ${requestScope.dat1.bookIntro}</td>
				</tr>
			</table>
		</div>
	</div>
	<div id="dCheck">
		<input type="button" value="购买" id="buy">
		<input type="button" value="加入购物车" id="toCart" onclick="toCart(${requestScope.dat1.id})">
		<input type="button" value="返回主页" id="toIndex">
	</div>
</body>
</html>