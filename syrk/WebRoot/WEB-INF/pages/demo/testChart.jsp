<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Sample AnyChart Flash Chart</title>
    <script type="text/javascript" src="<%=contextPath%>/js/tools/flashChart/swfobject.js"></script>
    <script type="text/javascript">
       function loadFlash(){
       	  swfobject.embedSWF(contextPath+"/js/tools/flashChart/open-flash-chart.swf","divid","100%","100%","9.0.0","expressInstall.swf",{"data-file":contextPath+"/homePage/querySyrkChart"},{wmode:"transparent"});
       }
    </script>
  </head>
  <body onload="loadFlash()">
    <div id="divid"></div>
  </body>
</html>