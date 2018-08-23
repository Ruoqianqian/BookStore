<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import= "com.xrq.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	DataBean dat = (DataBean)request.getAttribute("dat1");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>书籍信息</title>
</head>
<body>
<script language="javascript">

function toIndex()
{
	window.open("index.jsp","_self");
}

function toCar(id)
{
	window.alert("已加入购物车"+id)
	window.open("cart?id="+id+"&&add=1","_self");
}

</script>
<table width="90%" height="445" border="1" align="center">
  <tr>
    <td height="82" colspan="2" align="center" valign="middle">
    <jsp:include page ="head.jsp" flush="true"></jsp:include>
    </td>
  </tr>
  <tr>
    <td width="24%" rowspan="7" align="center" valign="middle"><img src="images/<%=dat.getBookCover() %>" width=200 height=200></td>
    <td height="30" align="left" valign="middle">书籍名称：<%=dat.getBookName() %></td>
  </tr>
  <tr>
    <td height="26" align="left" valign="middle">ISBN号：<%=dat.getId() %></td>
  </tr>
  <tr>
    <td height="28" align="left" valign="middle">价格：<%=dat.getBookPrice() %></td>
  </tr>
  <tr>
    <td height="26" align="left" valign="middle">数量：<%=dat.getBookAmount() %></td>
  </tr>
  <tr>
    <td height="23" align="left" valign="middle">出版商：<%=dat.getBookPublisher() %></td>
  </tr>
  <tr>
    <td height="60" align="left" valign="middle">简介: <%=dat.getBookIntro() %></td>
  </tr>
  <tr>
    <td width="76%" height="60" align="left" valign="middle">类别：<%=dat.getBookType() %></td>
  </tr>
  <tr>
    <td height="25" colspan="2" align="left" valign="middle"><input type="submit" name="buy" id="buy" value="购买" />
    <input type="button" onclick="toCar(<%=dat.getId()%>)" name="buy2" id="buy2" value="加入购物车" />
    <input type="submit"  onclick="toIndex()" name="buy3" id="buy3" value="返回首页" /></td>
  </tr>
  <tr>
    <td height="61" colspan="2" align="center" valign="middle">
    <jsp:include page="buttom.jsp" flush="true"></jsp:include>
    </td>
  </tr>
</table>
</body>
</html>