<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        bjzbz = userInfo.getBjzbz();
    }
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <title>地图</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "";
       var chAddress = "<%=SystemConfig.getString("chAddress")%>";
    </script>
	<script type="text/javascript" src="<%=contextPath%>/js/syfw/syfw.js"></script>
  </head>
  <body>
     <div id="mapDiv"></div>
     <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
  </body>
</html>
