<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%@ include file="/WEB-INF/pages/gpsControl.html"%>
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
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <title>主页</title>
    <script type="text/javascript">
    var userOrgCode = "<%=userOrgCode%>"; 
    var userOrgName = "<%=userOrgName%>";
    var bjzbz = "<%=bjzbz%>";
    </script>
    <style type="text/css">
	.text1{width:100%; margin-left:10px;margin-right:10px; font-size:14px; color:#333; line-height:24px; text-indent:25px;}
	.text2{width:100%; text-align: center;}
	.bold{font-weight:bold;font-size:14px}
	.redText{color:#F00;font-weight:bold;font-size:14px;}
	.blueText{color:blue;font-weight:bold;cursor: pointer;font-size:14px;}
	.oneText{font-size:12px;background-color:#007be3;text-align:center;width:22px; height:22px;float:left;color:#fff;font-weight:bold;line-height:22px;}
	.textwrap{width:100%; margin:5px auto;height:auto;overflow:hidden;margin-left: 10px;margin-top: 10px;font-size:14px;}
	.title_big{font-size:17px; color:#333333;line-height:22px;font-weight:bold;}
    </style>
    <script type="text/javascript" charset="GB2312" src="<%=SystemConfig.getString("jwtsUrl")%>/profile/profile.js"></script>
    <script type="text/javascript" charset="GB2312" src="<%=SystemConfig.getString("jwtsUrl")%>/ezGpsLib/component/module/EzModuleAPI.js"></script>
    <script type="text/javascript" charset="GB2312"	src="<%=SystemConfig.getString("ezBuilderUrl")%>/EzBuilderAPI/JavascriptApi/JsEzbuilder.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/tools/floatWin/floatWin.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/xj/xjhomePcs.js"></script>
    <script type="text/javascript">
    <!--
    -->
    </script>
  </head>
  <body class="easyui-layout">   
    <div data-options="region:'center',title:''" id="tdmapid">
         <div id="mapDiv" ></div>
         <div id="toolDiv" style="position: absolute;filter: alpha(opacity=90);"></div>
    </div>   
  </body>  
</html>