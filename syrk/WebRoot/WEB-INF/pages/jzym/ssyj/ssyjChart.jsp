<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/tools/flashChart/swfobject.js"></script>
<script type="text/javascript">
  <!--
     var kk = "";
	 var ssyj_zzjgdm ="";
	 var ssyj_zzjglx = "";
	 var time1 = "";
	 var time2 = "";
	 var chestr = "";
     var orgcode = "";
	 var lxmc = "";
	 var jqlb = "";
  function getParm(name){
	  var temp = "";
	  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	  var r = window.location.search.substr(1).match(reg);
	  if(r != null){
		  temp = unescape(r[2]);
	  } 
	  return temp;
   }

	function init(){
     	ssyj_zzjgdm = getParm("ssyj_zzjgdm");
		ssyj_zzjglx = getParm("ssyj_zzjglx");
		time1 = getParm("time1");
		time2 = getParm("time2");
		chestr = getParm("chestr");
		jqlb = getParm("jqlb");
     	drawChart('ssyjChart');
    }
      
  function drawChart(type){
 	  var mini = new Date().getMilliseconds();
 	  swfobject.embedSWF(
 		contextPath+"/js/tools/flashChart/open-flash-chart.swf",
 		type,
 		"100%",
 	 	"90%",
 	  	"9.0.0",
 	  	"expressInstall.swf",
 	  	{"data-file":contextPath+"/jz/querySsyjChart?zzjgdm=" + ssyj_zzjgdm + "@" + ssyj_zzjglx + "~" + time1 + "^" + time2 + "`" + chestr},
 	  	{wmode:"transparent"}
 	  );
   }
   
   function drawCharts(type){
 	  var mini = new Date().getMilliseconds();
 	  swfobject.embedSWF(
 		contextPath+"/js/tools/flashChart/open-flash-chart.swf",
 		type,
 		"100%",
 	 	"90%",
 	  	"9.0.0",
 	  	"expressInstall.swf",
 	  	{"data-file":contextPath+"/jz/querySsyjChart?zzjgdm=" + ssyj_zzjgdm + "@" + ssyj_zzjglx + "~" + time1 + "^" + time2 + "`" + chestr + "_"},
 	  	{wmode:"transparent"}
 	  );
   }
   
   //var num = 0;
   function change(parm){
   		//到分局就不下钻
   		if(parm.indexOf("-") == -1){
   			return;
   		}
   	    time2 = parm;
   		drawCharts('ssyjChart');
   }
   
  -->
</script>
</head>
<body onload="init();" class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" >
            	<div id="ssyjChart"></div>
			</div>
        </div>
    </div>   
</body>
<script type="text/javascript">
<!--

-->
</script>  
</html>