<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import ="com.xrq.model.* , java.util.*" %>

<% 
    
		// Paging display of books
		int ItemCount=0;
		int PageCount = 0;
		int PageNow=1;
		ArrayList<DataBean> al = new ArrayList<DataBean>();
		ItemCount = new DBOperation().ItemsNum();
		if(ItemCount%8==0)
			PageCount = ItemCount/8;  //8 books displayed in each page
		else PageCount = ItemCount/8+1;
		if(request.getParameter("PageNow")!=null)
			PageNow = Integer.parseInt(request.getParameter("PageNow"));
		al =  new DBOperation().getItem(PageNow);  // The result will be displayed		
%>
<style>
a:link {
	color: blue;
}
a:visited {
	color: blue;
}
a:hover, a:active {
	color: #F00;
}
</style>
<table width="100%" border="0" rules="none">
  <tr>
    <td height="48" colspan="4" align="center" valign="middle" class="bule-fornt">新书上架</td>
    <td align="center" valign="middle" class="bule-fornt">编辑推荐</td>
     
  </tr>

  <tr>
  <%for(int i=0;i<4;i++) {%>
    <td width="17%" height="172" align="center" valign="middle"><img src="images/<%= al.get(i).getBookCover() %>" alt="" name="new1" width="150" height="150" id="new1" style="background-color: #00FF66" /></td>

   <% }%>
      <td width="19%" rowspan="4" align="center" valign="middle"><img src="images/rec1.jpg" alt="" name="recommend" width="237" height="290" id="recommend" /></td>
  </tr>
  
  <tr>
  <%for(int i=0;i<4;i++) {%>
    <td height="34" align="center" valign="middle"><a href="detial?id=<%=al.get(i).getId()%>"><%=al.get(i).getBookName() %></a></td>
 <% }%>
  </tr>
  
  <tr>
    <%for(int i=0;i<4;i++) {%>
   		 <td height="43" align="center" valign="middle"><%=al.get(i).getBookPrice() %>元</td>
    <% }%>
   
  </tr>
  
   <tr>
  <%for(int j=4;j<8;j++) {%>
    <td width="17%" height="172" align="center" valign="middle"><img src="images/<%= al.get(j).getBookCover() %>" alt="" name="new1" width="150" height="150" id="new1" style="background-color: #00FF66" /></td>

   <% }%>
    
  </tr>
  
  <tr>
  <%for(int j=4;j<8;j++) {%>
    <td height="34" align="center" valign="middle"><a href="detial?id=<%=al.get(j).getId()%>"><%=al.get(j).getBookName()%></a></td>
  
    <% }%>
  </tr>
  
  <tr>
    <%for(int j=4;j<8;j++) {%>
   		 <td height="43" align="center" valign="middle"><%=al.get(j).getBookPrice() %>元</td>
    <% }%>
  </tr>
  
  <tr >
    <td height="23" colspan="4" align="center" valign="middle" >
    <% if(PageNow>1) { %>
    <a href="index.jsp?PageNow=<%=PageNow-1 %>">上一页</a>
    <%} %> 
    <%  for(int k=1;k<5;k++)
    {
    	if(PageNow+k<=PageCount)
    	{%>
    		<a href="index.jsp?PageNow=<%=PageNow+k%>"> <%=PageNow+k %></a>
    	<%}
    }
    %>
   
    
      <% if(PageNow<PageCount) {%>
      <a href="index.jsp?PageNow=<%=PageNow+1 %>">下一页</a></td>
      <%} %>
  </tr>

</table>