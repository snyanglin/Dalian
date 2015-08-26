<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String bjzbz = "";
    if(userInfo!=null){
        bjzbz = userInfo.getBjzbz();
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <title>地图标点</title>
    <script type="text/javascript">
		var bjzbz = "<%=bjzbz%>";
		var bz = "${bz}";//bz标识 0或空返回X、Y坐标，1返回X、Y坐标并所属派出所、责任区信息,2为标点只读无法重新标点
    	var title = "${title}";//坐标标题
    	var xldx = "${xldx}";//坐标X
    	var xldy = "${xldy}";//坐标Y
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/aqff/rfxx/mapPointBz.js"></script>
  </head>
  <body onload="loadMap();" style="overflow: hidden;">
     <div id="mapDiv" style="width:100%;height:100%;"></div>
  </body>
</html>