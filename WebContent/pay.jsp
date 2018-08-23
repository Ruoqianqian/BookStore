<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String user = (String)request.getSession().getAttribute("name");//未正式
	String price = (String)request.getParameter("payment");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>支付页</title>
<style type="text/css">
.buy {
	font-family: "Arial Black", Gadget, sans-serif;
	font-size: xx-large;
}
.comfirm {
	font-family: Arial, Helvetica, sans-serif;
	font-size: large;
	color: #F00;
}
.item {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: green;
}

</style>
</head>
<jsp:include page="head.jsp" flush="true"></jsp:include>
<table width="100%" border="1">
      <tr>
        <td width="20%" height="109" align="center" class="buy">购物流程</td>
        <td width="80%" align="center"> <table width="100%" border="0">
          <tr>
            <td width="35%" height="107" align="center" >商品确认</td>
            <td width="32%" align="center"  >登陆</td>
            <td width="33%" align="center" class="comfirm">结算</td>
          </tr>
        </table></td>
      </tr>
</table>

<P>欢迎：<%=user %></P>
<p>您的订单总额是： <%=price %></p>
</html>