<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
String contextPath = request.getContextPath();
%>
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<frameset id="syrkMain" cols="560,*" border="0" frameborder="0">
	<frame id="biz_left" frameborder="0" src="<%=contextPath%>/forward/query|syfwQueryList?sfczfdm=${sfczfdm}" noresize scrolling="no"/>
	<frame id="biz_center" frameborder="0" src="<%=contextPath%>/forward/query|syfwMap" noresize scrolling="no">
	<noframes>
		<body>
			<p>此网页使用了框架，但您的浏览器不支持框架。</p>
		</body>
	</noframes>
</frameset>
</HTML>