<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.xrq.model.* , java.util.*" %>
<%
	int num =1;
	ArrayList<DataBean> al = (ArrayList<DataBean>)request.getAttribute("cart");
	

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车</title>
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

<script language="javascript">
	total=0;
	function toServlet()
	{
		window.open("cart?delAll=1","_self");
	}
	
	function changeNum(price,value)
	{
		
		total= total+price*value;
		document.getElementById("price").innerHTML="合计: "+total+" 元";
		window.alert(total);
	}
	function next()
	{
		window.open("userVerify?payment="+total,"_self");
	}
	
</script>

</head>
<jsp:include page="head.jsp" flush="true"></jsp:include>
<table width="100%" border="1" >
  <tr>
    <td height="116" colspan="4"><table width="100%" border="1">
      <tr>
        <td width="20%" height="109" align="center" class="buy">购物流程</td>
        <td width="80%" align="center"> <table width="100%" border="0">
          <tr>
            <td width="35%" height="107" align="center" class="comfirm">商品确认</td>
            <td width="32%" align="center">登陆</td>
            <td width="33%" align="center">结算</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td width="20%" align="center">编号</td>
    <td width="29%" align="center">名称</td>
    <td width="15%" align="center">单价</td>
    <td width="36%" align="center">数量</td>
  </tr>
  <%
  	if(al!=null){
  		for(int i=0;i<al.size();i++) {
  			
  %>
  <tr class="item">
    <td align="center"><%=al.get(i).getId() %></td>
    <td align="center"><%=al.get(i).getBookName() %></td>
    <td align="center"><%=al.get(i).getBookPrice() %></td>
    <td align="center"><table width="100%" border="0">
   <tr>
  
        <td width="42%" align="center"><label for="num"></label>
          <input type="text" name="num" onchange="changeNum(<%=al.get(i).getBookPrice()%>,this.value)" id="num" /></td>
        <td width="33%" align="center"><a href=cart?del=1&&id=<%=al.get(i).getId()%>>删除</a></td>
        <td width="25%" align="center"><a href="detial?id=<%=al.get(i).getId() %>">查看</a></td>
      </tr>
    </table></td>
  </tr>
   <%} }%>
  <tr>

    <td align="center" colspan="4" >&nbsp;</td>
   
  </tr>
  <tr>
    <td height="26" colspan="4" align="center">&nbsp;</td>
  </tr>
  <tr>
    <td height="26" colspan="2" id="price" align="center">&nbsp;</td>
    <td colspan="2" align="center"><input type="button" onclick = "toServlet()" name="del" id="del" value="删除所有商品" />&nbsp;&nbsp;&nbsp;<input type="submit" onclick ="next()" name="next" id="next" value="下一步" /></td>
  </tr>
</table>
</html>