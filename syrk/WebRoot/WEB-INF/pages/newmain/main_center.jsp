<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%
	SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
%>
<HTML>
<HEAD>
	<TITLE></TITLE>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>
<frameset id="main_tab" name="mains" rows="30,*" border="0" frameborder="0">
     <frame id="main_tabTitle" src="<%=request.getContextPath()%>/forward/newmain|main_tabTitle" noresize scrolling="no">
   	 <frameset id="tabContent" cols="*,0,0,0,0,0,0,0,0,0">
   	 <%if("32".equals(userInfo.getUserOrgLevel())){%>
   	      <frame id="main_tab0" src="<%=request.getContextPath()%>/forward/main|pcs|main_pcs" noresize scrolling="auto" style="border-left: 1px #fff solid; border-right: 1px #72C0F4 solid;">
   	 <%}else{%>
   	      <frame id="main_tab0" src="<%=request.getContextPath()%>/forward/main|zrq|main_zrq" noresize scrolling="auto" style="border-left: 1px #fff solid; border-right: 1px #72C0F4 solid;">
   	 <%}%>
     <frame id="main_tab1" src="" noresize scrolling="auto" style="border-left: 1px #fff solid; border-right: 1px #72C0F4 solid;">
     <frame id="main_tab2" src="" noresize scrolling="auto" style="border-left: 1px #fff solid; border-right: 1px #72C0F4 solid;">
     <frame id="main_tab3" src="" noresize scrolling="auto" style="border-left: 1px #fff solid; border-right: 1px #72C0F4 solid;">
     <frame id="main_tab4" src="" noresize scrolling="auto" style="border-left: 1px #fff solid; border-right: 1px #72C0F4 solid;">
     <frame id="main_tab5" src="" noresize scrolling="auto" style="border-left: 1px #fff solid; border-right: 1px #72C0F4 solid;">
     <frame id="main_tab6" src="" noresize scrolling="auto" style="border-left: 1px #fff solid; border-right: 1px #72C0F4 solid;">
     <frame id="main_tab7" src="" noresize scrolling="auto" style="border-left: 1px #fff solid; border-right: 1px #72C0F4 solid;">
     <frame id="main_tab8" src="" noresize scrolling="auto" style="border-left: 1px #fff solid; border-right: 1px #72C0F4 solid;">
     <frame id="main_tab9" src="" noresize scrolling="auto" style="border-left: 1px #fff solid; border-right: 1px #72C0F4 solid;">
  </frameset>
  <noframes>
    <body>
     <p>此网页使用了框架，但您的浏览器不支持框架。</p>
    </body>
  </noframes>
</frameset>
</HTML>