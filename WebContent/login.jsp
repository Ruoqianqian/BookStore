<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="head.jsp" flush="true"></jsp:include>
<h1 style = "text-align:center"> 用户登陆</h1>
<form action="userVerify" method="post">
<p style ="text-align:center"/>姓名：  <input type ="text" name="userName" >
<p style ="text-align:center"/>密码：<input type ="text" name ="userPassword"><br><br>
<input type="hidden" name="jumpFlag" value="true">
<input type="submit" value="提交" style = "text-align:center"/>
</form>
