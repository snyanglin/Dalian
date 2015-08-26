<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgName = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName = userInfo.getUserOrgName();
        bjzbz = userInfo.getBjzbz();
    }
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>派出所所长主页</title>
    <%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
	<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="ECharts">
    <meta name="author" content="zhang_guoliang@founder.com">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
	<script type="text/javascript" src="<%=request.getContextPath()%>/common/echarts/html5shiv.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/common/echarts/respond.min.js"></script>
    <![endif]-->
	<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/main/pcs/main_pcs.css" />
	<script type="text/javascript" src="<%=contextPath%>/common/echarts/echarts-all.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/main/pcs/main_pcs.js" ></script>
	<script type="text/javascript">
		var bjzbz = "<%=bjzbz%>";
		var userOrgCode = "<%=userOrgCode%>";
	</script>
  </head>
  <body>
    <div class="leftDiv">
    	<div class="leftCss">
    		<div id="xqMap"></div>
    	</div>
    	<div class="leftCss">
    	    <div id="xqTj"></div>
    	</div>
   	</div>
    <div class="centerDiv">
    	<div class="centerCss">
    		<div class="titleCss">&nbsp;辖区概况</div>
    		<div class="echartsCss" id="echartsBar"></div>
    	</div>
    	<div class="centerCss">
    		<div class="titleCss">&nbsp;辖区概况统计</div>
    		<div class="dgCss">
    			<table id="dg"></table>
    		</div>
    	</div>
   	</div>
    <div class="rightDiv">
   		<div class="rightCss">
   		   <div class="titleCss">&nbsp;通知公告</div>
		   <div class="messageCss" id="newDiv"></div>
   		</div>
   		<div class="rightCss">
   		   <div class="titleCss">&nbsp;待办事项</div>
		   <div class="messageCss" id="waitingWorkDiv"></div>
   		</div>
   		<div class="rightCss">
   		   <div class="titleCss">&nbsp;业务提醒</div>
		   <div class="messageCss" id="remindDiv"></div>
   		</div>
   	</div>
  </body>
</html>