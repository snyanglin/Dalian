<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@UpdateDate:   [2015-6-3 上午8:51:54]
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
<frameset id="syrkMain" cols="540,*" border="0" frameborder="0">
	<frame id="main_left" frameborder="0" src="<%=contextPath%>/forward/sydw|sydwList?dwlbdm=${dwlbdm}" noresize scrolling="no"/>
	<frame id="biz_center" frameborder="0" src="<%=contextPath%>/forward/sydw|sydwMap" noresize scrolling="no">
	<noframes>
		<body>
			<p>此网页使用了框架，但您的浏览器不支持框架。</p>
		</body>
	</noframes>
</frameset>
</HTML>