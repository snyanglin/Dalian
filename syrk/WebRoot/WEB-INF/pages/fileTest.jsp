<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<title>文件上传</title>
</head>
<body>
 
<div style="margin:50px auto;width:600px;height:400px;" serverError="500">
	<div style="padding-left:90px;"><img alt="" src="<%= basePath%>images/500.png" style="vertical-align:middle"></div>
	<ul style="font-size:12px;color:#666;line-height:23px;">
		<form action="<%=basePath%>fj/upload" enctype="multipart/form-data" method="post">
		表名<input type="text" name="lybm" />
		ID<input type="text" name="lyid" />
		描述<input type="text" name="lyms" />
		文件<input type="file" name="uploadFile" />
		<input  type="submit"  />
		<%=request.getSession().getAttribute("userSession") %>
		</form>
	</ul>
</div>
</body>
</html>