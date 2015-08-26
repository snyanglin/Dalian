<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
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
<html>
  <head>
    <title>责任区主页</title>
	<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/main/zrq/main_zrq.css" />
	<script type="text/javascript" src="<%=contextPath%>/js/main/zrq/main_zrq.js" ></script>
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
           	<div class="centerTopCss">
	   		   <div class="titleCss">&nbsp;待办事项</div>
			   <div class="messageCss" id="waitingWorkDiv"></div>
	   		</div>
	   		<div class="centerTopCss1">
	   		   <div class="titleCss">&nbsp;业务提醒</div>
			   <div class="messageCss" id="remindDiv"></div>
	   		</div>    		
    	</div>
    	<div class="centerCss1">
    		<div class="titleCss">&nbsp;辖区概况统计</div>
    		<div class="dgCss">
    			<table id="dg"></table>
    		</div>
    	</div>
   	</div>
    <div class="rightDiv">
   		<div class="rightCss">
   		   <div class="titleCss">&nbsp;接处警</div>
		   <div class="messageCss" id="newDiv"></div>
   		</div>
   		<div class="rightCss1">
   		   <div class="menuCss" style="background: #336666;"><span onclick="MainZrq.menuOpenSyrk()">登记人员</span></div>
   		   <div class="menuCss" style="background: #6633CC;"><span>实有人口</span></div>
   		   <div class="menuCss" style="background: #990066;"><span>开具证明</span></div>
   		   <div class="menuCss" style="background: #009966;"><span>矛盾纠纷</span></div>
   		   <div class="menuCss" style="background: #3366CC;"><span>登记单位</span></div>
   		   <div class="menuCss" style="background: #990000;"><span>标准地址</span></div>
   		   <div class="menuCss" style="background: #CC9933;"><span>出租房屋</span></div>
   		   <div class="menuCss" style="background: white;"><font>+</font></div>
   		</div>
   	</div>
  </body>
</html>