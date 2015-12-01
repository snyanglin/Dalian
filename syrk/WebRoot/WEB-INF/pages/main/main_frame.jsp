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
   <frame id="main_top" src="<%=contextPath%>/ztTheme/topZtTheme" noresize scrolling="no" style="position: absolute; z-index: 100;">
   <frame id="main_center" src="<%=contextPath%>/forward/main|main_center" noresize scrolling="auto" style="position: absolute; z-index: -1;">
  <noframes>
    <body>
     <p>此网页使用了框架，但您的浏览器不支持框架。</p>
    </body>
  </noframes>
</frameset>
 


