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
  var jssj = "";
  var fqsj = "";
  var jqlb = "";
  var orgcode = "";
  var lx = "";
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
     	fqsj = getParm("fqsj");
		jssj = getParm("jssj");
		orgcode = getParm("orgcode");
		jqlb = getParm("jqlb");
     	drawChart('jqChart');
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
 	  	{"data-file":contextPath+"/jz/queryDbChart?zzjgdm=" + orgcode + "@" + fqsj + "~" + jssj + "^" + jqlb},
 	  	{wmode:"transparent"}
 	  );
   }
   
  -->
</script>
</head>
<body onload="init();" class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" >
            	<div id="jqChart"></div>
			</div>
        </div>
    </div>   
</body>
<script type="text/javascript">
<!--

-->
</script>  
</html>