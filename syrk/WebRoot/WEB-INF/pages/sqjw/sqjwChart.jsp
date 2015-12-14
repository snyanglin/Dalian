<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
   String zzjgdm = request.getParameter("zzjgdm");
   String bs = request.getParameter("bs");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>统计图</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/tools/flashChart/swfobject.js"></script>
    <script type="text/javascript">
      var contextPath = "<%=request.getContextPath()%>";
      var bs = "<%=bs%>";
      function loadChart(){
          if(bs=="1"){
              /*加载实有人口饼状图*/
 	          swfobject.embedSWF(contextPath+"/js/tools/flashChart/open-flash-chart.swf","ChartDiv","100%","100%;","9.0.0","expressInstall.swf",{"data-file":contextPath+"/homePage/querySyrkChart?zzjgdm=<%=zzjgdm%>"},{wmode:"transparent"});
          }else if(bs=="4"){
              /*加载流动人口柱状图*/
       	      swfobject.embedSWF(contextPath+"/js/tools/flashChart/open-flash-chart.swf","ChartDiv","100%","100%;","9.0.0","expressInstall.swf",{"data-file":contextPath+"/homePage/queryLdrkChart?zzjgdm=<%=zzjgdm%>"},{wmode:"transparent"});
          }
      }
    </script> 
  </head>
  <body onload="loadChart();" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
    <div id="ChartDiv"></div>
  </body>
</html>
