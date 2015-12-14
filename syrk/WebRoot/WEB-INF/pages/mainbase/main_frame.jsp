<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
String contextPath = request.getContextPath();
%>
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<frameset id="main_system" rows="66,*,24" border="0" frameborder="0">
   <frame id="main_top" src="<%=contextPath%>/forward/mainbase|main_top" noresize scrolling="no">
   <frameset id="kernel" cols="220,6,*">
     <frame id="main_left" src="<%=contextPath%>/forward/mainbase|main_left" noresize scrolling="no">
     <frame id="leftScroll" src="<%=contextPath%>/forward/mainbase|main_leftScroll" noresize scrolling="no">
     <frame id="main_center" src="<%=contextPath%>/forward/mainbase|main_center" noresize scrolling="no">
  </frameset>
  <frame id="main_bottom" src="<%=contextPath%>/forward/mainbase|main_bottom" noresize scrolling="no">
  <noframes>
    <body>
     <p>此网页使用了框架，但您的浏览器不支持框架。</p>
    </body>
  </noframes>
</frameset>

</HTML>

