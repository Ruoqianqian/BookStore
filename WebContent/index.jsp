<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Welcome to BookStore</title>
</head>
<body>
	<table width="90%" height="518" border="1" align="center" >
  <tr>
    <td colspan="2" align="center" valign="middle">
    <jsp:include page = "head.jsp" flush="true"></jsp:include>
    </td>
  </tr>
  <tr>
    <td width="16%" height="179" align="center" valign="middle">
    <jsp:include page ="left.jsp" flush ="true"></jsp:include>
    </td>
    <td width="100%" align="center" valign="top">
    <jsp:include page="RollDisplay.jsp" flush="true"></jsp:include>
    </td>
  </tr>
  <tr>
    <td height="94" colspan="2" align="left" valign="top">
    <jsp:include page="product.jsp" flush="true"></jsp:include>
    </td>
  </tr>
  <tr>
    <td colspan="2" align="center" valign="middle">
    <jsp:include page="buttom.jsp" flush ="true"></jsp:include>
    </td>
  </tr>
</table>
</body>
</html>