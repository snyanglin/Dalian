<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/qbld/commonInclude.jsp"%>
<%
	String objectid = request.getParameter("id");

%>
<html>
  <head>
	<style type="text/css">
	body{
		text-align:center;
	}
	 .xxfbTable{
	 	width:1024;
	 }
	 #flmcTd,#titleTd{
	 	text-align:center;
	 	
	 }
	 #flmcTd h1{
	 	color: red;
	 	font:normal 32px Arial,"微软雅黑";
	 }
	 #titleTd h2{
	 	color: red;
	 	font:normal 22px Arial,"微软雅黑";
	 }
	  #createTimeTd{
	 	text-align:right;
	 }
	 #fbrTd,#sprTd{
	 	line-height: 50px;
	 	font:normal 16px Arial,"微软雅黑";
	 }
	</style>
	<script type="text/javascript">
	var objectid = "<%=objectid%>";
	$(function(){
		if(objectid){
		var url = '<%=contextPath%>/xxfb/queryArticle';
		var fajax = new FrameTools.Ajax(url,initXxfbxx);
		fajax.send({"objectid":objectid});
		}else{
			alert("编号不存在!");
		}
	});
	function initXxfbxx(json){
		$("#flmcTd").html("<h1>"+json.subjectname+"</h1>");
		$("#fbdwTd").html("发布单位："+json.createusername);
		$("#createTimeTd").html(json.createtime.substring(0,4)+"-"+json.createtime.substring(4,6)+"-"+json.createtime.substring(6,8));
		$("#titleTd").html("<h2>"+json.title+"</h2>");
		$("#fbrTd").html("发布人："+json.fwr);
		$("#sprTd").html("审批人："+json.spr);
		$("#contentTd").html(json.content);
	}
	</script>
  </head>
  
  <body>
  <div align="center">
	  	<table class="xxfbTable">
	  		<tr><td id="flmcTd" colspan=2><h1>标题</h1></td></tr>
	  		<tr><td id="fbdwTd">发布单位</td><td  id="createTimeTd">发布时间</td></tr>
	  		<tr><td colspan=2><hr size="6" style="width:100%;background-color:red;" /></td></tr>
	  		<tr><td id="titleTd" colspan=2><h2>123123123</h2></td></tr>
	  		<tr><td id="contentTd" colspan=2></td></tr>
	  		<tr><td id="fbrTd"  >发布人</td><td id="sprTd"  >审批人</td></tr>
	  	</table>
  	</div>
  </body>
  
</html>
