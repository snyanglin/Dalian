<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String userOrgCode = request.getParameter("userOrgCode");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>首页_辖区统计</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/tools/flashChart/swfobject.js"></script>
    <script type="text/javascript">
      var contextPath = "<%=request.getContextPath()%>";
      function loadChart(){
       	  /*加载流动人口柱状图*/
       	  swfobject.embedSWF(contextPath+"/js/tools/flashChart/open-flash-chart.swf","ldrkChart","100%","250px","9.0.0","expressInstall.swf",{"data-file":contextPath+"/homePage/queryLdrkChart?zzjgdm=<%=userOrgCode%>"},{wmode:"transparent"});
      }
    </script>
  </head>
  <body onload="loadChart();" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
       <div id="ldrkChart"></div>
  </body>
</html>