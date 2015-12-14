<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>${yyyy}</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
年：${yyyy} <br>
月：${mm} <br>
日：${dd} <br>
初查结果：${ccjg} <br>
初查拒绝原因：${ccbz} <br>
复查结果：${fcjg} <br>
复查拒绝原因：${fcbz} <br>

线索编号：${xsbh} <br>
线索状态：${xszt} <br>
案件编号：${ajbhList} <br>
    
  </body>
</html>
