<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common.jsp"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%@page import="com.founder.framework.config.SystemConfig"%>
<%

SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
String userID = "";
String password = "";
String userName = "";
String userOrgName = "";
Long userPk = new Long(0);
String userOrgCode = "";
String ipdz = "";
if (userInfo != null) {
   userPk = userInfo.getUserPk();
   userID =  userInfo.getUserId();
   password = userInfo.getPassword();
   if (password == null) {
      password = "";
   }
   userName =  userInfo.getUserName();
   userOrgName = userInfo.getUserOrgName();
   userOrgCode = userInfo.getUserOrgCode();
   ipdz = userInfo.getRemoteAddr();
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/mainFrame.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/skin/main.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/skin/style.css">
<HTML>
<HEAD>
<TITLE><%=SystemConfig.getString("systemOrganization")%>－<%=SystemConfig.getString("systemName")%></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<BODY scroll="no" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0" 
   style="BORDER-RIGHT: 0px none; BORDER-TOP: 0px none; MARGIN: 0px; BORDER-LEFT: 0px none; BORDER-BOTTOM: 0px none; overflow: hidden;"
   onselectstart="return false;" oncontextmenu="return false;" >

<IFRAME id="main_frame" src="<%=contextPath%>/forward/mainbase|main_frame" frameborder="0" scrolling="no" style="WIDTH: 100%; HEIGHT: 100%"></IFRAME>

</BODY>
</HTML>
