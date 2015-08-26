<!--  
	@Author: [yuguangli@founder.com]
	@CreateDate:   [2015-6-6 上午8:51:54]
-->
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
	String contextPath = request.getContextPath();
%>
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<frameset id="kernel" cols="250,*">
   <frame id="main_left" src="<%=contextPath%>/forward/sydw|dwzajctemp_left" noresize scrolling="no">
   <frame id="main_center" src="<%=contextPath%>/forward/sydw|dwzajctemp_center" noresize scrolling="no">
   <noframes>
	   <body>
	    <p>此网页使用了框架，但您的浏览器不支持框架。</p>
	   </body>
	</noframes>
</frameset>

</HTML>

