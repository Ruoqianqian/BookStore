<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Welcome to BookStore</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css">
<link rel="stylesheet" type="text/css" href="CSS/roll.css">

</head>
<body>
	<div id="hBack">
		<div id="hName">XXXX Books Store</div>
		<div id="hSearch">
			<input type="text" alt="输入书名">&nbsp;<a class="hA" href="#">搜素</a></input>
		</div>
		<div id="hUl">
			<ul>
				<li><a class="hA" href="userVerify">我的账户</a></li>
				<li><a class="hA" href="cart?display=true">购物车</a></li>
				<li><a class="hA" href="index.jsp">回到主页</a></li>
			</ul>
		</div>
	</div>
	<div id="hInfo">这里是通知栏,新书上架</div>

	<!-- 以下是第二部分 -->
	<div id="middle">
		<div id="left">
			<div id="lTitle">热门商品</div>
			<div class="lBlock"></div>
			<div>
				<h2>销量最高</h2>
			</div>

			<ul class="lList">
				<li><a class="pLink" href="#">book1</a></li>
				<li><a class="pLink" href="#">book2</a></li>
				<li><a class="pLink" href="#">book3</a></li>
			</ul>

			<div class="lBlock"></div>
			<div>
				<h2>收藏最多</h2>
			</div>
			<ul class="lList">
				<li><a class="pLink" href="#">book1</a></li>
				<li><a class="pLink" href="#">book2</a></li>
				<li><a class="pLink" href="#">book3</a></li>
			</ul>
		</div>
		<div id="frame">
			<a id="a1" class="num">4</a> <a id="a2" class="num">3</a> <a id="a3"
				class="num">2</a> <a id="a4" class="num">1</a>

			<div id="photos" class="play">
				<img src="images/1.jpg"> <img src="images/2.jpg"> <img
					src="images/4.jpg"> <img src="images/5.jpg">
				<ul id="dis">
				</ul>
			</div>
		</div>
	</div>
	<div class="longBlock"></div>

	<!-- 以下是第三部分 -->
	<div id="part3">
		<div id="newBook">
			<p class="newTitle">新书上架</p>
			<ul class="productUl">
				<c:forEach items="${requestScope.newBooks}"  var="i">
					<li>
					<a class="pLink" href="detial?id=${i.id}"><img src="images/${i.bookCover}">
						<p>
							${i.bookName}<br>
							 <span id="price">${i.bookPrice}元</span>
						</p>
						</a></li>
				</c:forEach>
			</ul>
		</div>

		<div id="recommend">
			<div class="newTitle">编辑推荐</div>
			<ul id="rUl">
				<li><img src="images/rec1.jpg"></li>
				<li><img src="images/rec2.jpg"></li>
			</ul>
		</div>
	</div>

	<!-- 以下是第四部分 -->
	<hr style="height: 2px; background: #FFF;">
	<div id="bottom">
		<div>This webSite designed by XRQ</div>
		<div>本项目用于学习交流</div>
		<div>Email: a741989462@gmail.com</div>
	</div>
</body>
</html>