<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>该页面不存在</title>
</head>
<body>
<div style="margin:50px auto;width:600px;height:400px;">
	<div style="padding-left:90px;"><img alt="" src="<%=basePath%>images/404.png" style="vertical-align:middle"></div>
	<ul style="font-size:12px;color:#666;line-height:23px;">
		<li>您正在搜索的页面可能已经删除、更名或暂不可用。</li>
		<li>如果您是通过点击本系统链接到达此页，请及时与管理员联系，报告此错误的链接。</li>
		<!--  <li>您也可以<a href="<%=basePath%>">点击此处</a>返回系统主页。</li>-->
	</ul>
</div>
</body>
</html>