<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
String contextPath = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
%>
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<frameset id="main_system" rows="69,*" border="0" frameborder="0">
   <frame id="main_top" src="<%=contextPath%>/forward/main|main_bzdz_top" noresize scrolling="no">
   <frameset id="kernel" cols="300,6,*">
     <frame id="main_left" src="<%=contextPath%>/forward/main|main_bzdz_leftFrame" noresize scrolling="no">
     <frame id="leftScroll" src="<%=contextPath%>/forward/main|main_bzdz_leftScroll" noresize scrolling="no">
     <frame id="main_center" src="<%=contextPath%>/forward/main|main_bzdz_center" noresize scrolling="auto">
  </frameset>
  <noframes>
    <body>
     <p>此网页使用了框架，但您的浏览器不支持框架。</p>
    </body>
  </noframes>
</frameset>

</HTML>

