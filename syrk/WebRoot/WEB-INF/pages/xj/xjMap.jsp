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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <title>地图</title>
	<script type="text/javascript">
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "<%=bjzbz%>";
       var userOrgName = "<%=userOrgName%>";
       //TODO 使用热度会占用cpu，故动态加载
       $(function(){
       		//var fileref = document.createElement("script");
       		//fileref.setAttribute("type", "text/javascript");
       		//fileref.setAttribute("src", "<%=contextPath%>/js/xj/xj.js");
       });
    </script>
    <style type="text/css">
	.text1{width:100%; margin-left:10px;margin-right:10px; font-size:12px; color:#333; line-height:24px; text-indent:25px;}
	.text2{width:100%; text-align: center;}
	.bold{font-weight:bold;font-size:13px}
	.redText{color:#F00;font-weight:bold;font-size:12px;}
	.blueText{color:blue;font-weight:bold;cursor: pointer;font-size:12px;}
	.oneText{font-size:12px;background-color:#007be3;text-align:center;width:22px; height:22px;float:left;color:#fff;font-weight:bold;line-height:22px;}
	.textwrap{width:100%; margin:5px auto;height:auto;overflow:hidden;margin-left: 10px;margin-top: 10px;font-size:12px;}
	.title_big{font-size:15px; color:#333333;line-height:22px;font-weight:bold;}
    </style>
    <script type="text/javascript" src="<%=contextPath%>/js/tools/floatWin/floatWin.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/xj/xj.js"></script>
  </head>
  
  <body>
      <div id="mapDiv"></div>
      <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
      <!-- add by wuw start -->
      <!-- patrol line modiry control container -->
	  <div id="patrol_line_modify_div" style="position: absolute;z-index: 20;top: 150px;right: 30px;display:none;">
		  <a href="###" onclick="modifyPatrolLine_reflag()" class="easyui-linkbutton" data-options="iconCls:'icon-reset'">重新标记</a><br/>  
		  <a href="###" onclick="modifyPatrolLine_confirmModify()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确认更改</a><br/>  
		  <a href="###" onclick="modifyPatrolLine_close()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关&nbsp;&nbsp;&nbsp;&nbsp;闭</a>  
	  </div>
	  <!-- add by wuw end -->
  </body>
</html>
