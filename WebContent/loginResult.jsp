<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.name==null}">
	<c:redirect url="errorPage.jsp"></c:redirect>
</c:if>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>LoginResult</title>
</head>
<jsp:include page="head.jsp" flush="true"></jsp:include>
<p>欢迎登陆： ${sessionScope.name} 您的身份：${sessionScope.type}
</p>
<c:if test="${sessionScope.type=='manager'}">

	<p align="center">
	<a href ="Upload.jsp">书籍上新</a></p>
</c:if>


<c:if test="${sessionScope.type=='user'}">

	<p align="center"><a href ="orderDisplay">我的订单</a></p>
	<p align="center"><a  href ="cart?display=true">我的购物车</a></p>

</c:if>
</html>