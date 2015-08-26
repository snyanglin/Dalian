<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%
SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
String theme ="";
String userType = "";
if (userInfo != null) {
	theme = userInfo.getTheme();
	userType = userInfo.getUserType();
}
if ("".equals(theme) && "1".equals(userType)) { // 系统管理员默认主题
	theme = "2_1";
}
%>
<HTML>
<HEAD>
<TITLE>大连市公安局警务信息综合应用平台</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<frameset id="main_tab" name="mains" rows="27,*" border="0" frameborder="0">
   <frame id="main_tabTitle" src="<%=contextPath%>/forward/main|main_tabTitle" noresize scrolling="no">
   <frameset id="tabContent" cols="*,0,0,0,0,0,0,0,0,0">
	 <%if("2_1".equals(theme)){%>
	    <frame id="main_tab0" src="<%=contextPath%>/forward/main|tabFirstPage" noresize scrolling="auto" pageType="1">
	 <%}else if("2_2".equals(theme)){%>
	    <frame id="main_tab0" src="<%=contextPath%>/forward/sqjw|homePcs" noresize scrolling="auto"  pageType="2">
	 <%} else if("2_3".equals(theme)){%>
	    <frame id="main_tab0" src="<%=contextPath%>/forward/jzym|jzymIndex" noresize scrolling="auto"  pageType="4">
	 <%} else if("2_4".equals(theme)){%>
	    <frame id="main_tab0" src="<%=contextPath%>/forward/main|tabFirstPage_xj" noresize scrolling="auto"  pageType="4">
	 <%}else{%>
	    <frame id="main_tab0" src="<%=contextPath%>/ztTheme/addZtTheme" noresize scrolling="no"  pageType="3">
	 <%}%>
     <frame id="main_tab1" src="" noresize scrolling="auto">
     <frame id="main_tab2" src="" noresize scrolling="auto">
     <frame id="main_tab3" src="" noresize scrolling="auto">
     <frame id="main_tab4" src="" noresize scrolling="auto">
     <frame id="main_tab5" src="" noresize scrolling="auto">
     <frame id="main_tab6" src="" noresize scrolling="auto">
     <frame id="main_tab7" src="" noresize scrolling="auto">
     <frame id="main_tab8" src="" noresize scrolling="auto">
     <frame id="main_tab9" src="" noresize scrolling="auto">
  </frameset>
  <noframes>
    <body>
     <p>此网页使用了框架，但您的浏览器不支持框架。</p>
    </body>
  </noframes>
</frameset>
</HTML>