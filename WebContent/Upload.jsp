<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员页面</title>
</head>
<body>
<script language="javascript">
    function changepic() {
        var reads= new FileReader();
        f=document.getElementById('file').files[0];
        reads.readAsDataURL(f);
        reads.onload=function (e) {
            document.getElementById('show').src=this.result;
        };
    }
</script>
  <form action="Upload.do" method="post" enctype="multipart/form-data" >
<table width="80%" border="1" align="center">
  <tr>
    <td height="179" colspan="3">
    <jsp:include page="head.jsp" flush ="true"></jsp:include>
    </td>
  </tr>

  <tr>
    <td width="20%" rowspan="6"><img src="" id="show" width="200">上传图书封面</td>
    <td width="21%">ISBN号：</td>
    <td width="34%"><label for="bookId"></label>
    <input type="text" name="bookId" id="bookId" /></td>
  </tr>
  <tr>
    <td>书籍名称：</td>
    <td><input type="text" name="bookName" id="bookName" /></td>
  </tr>
  <tr>
    <td>价格：</td>
    <td><input type="text" name="bookPrice" id="bookPrice" /></td>
  </tr>
  <tr>
    <td>数量：</td>
    <td><input type="text" name="bookAmount" id="bookAmount" /></td>
  </tr>
  <tr>
    <td>出版社：</td>
    <td><input type="text" name="bookPublisher" id="bookPublisher" /></td>
  </tr>
  <tr>
    <td>类别：</td>
    <td><input type="text" name="bookType" id="bookType" /></td>
  </tr>
  <tr>
    <td height="63"><input id="file" name = "file" class="file" onchange="changepic(this)" type="file"></td>
    <td>简介：</td>
    <td><textarea name="bookIntro" rows="6" warp="virtual"></textarea></td>
  </tr>
  <tr>
    <td height="52" colspan="3" align="center"><input type="submit" name="submit" id="submit" value="提交结果" />
    </td>
  </tr>

  <tr>
    <td height="54" colspan="3">
    <jsp:include page="buttom.jsp" flush="true"></jsp:include>
    </td>
  </tr>
</table>
  </form>
	
</body>
</html>