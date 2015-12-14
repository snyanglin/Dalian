<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/sydw.css" />
<title>从业人员</title>
</head>
<body>
	<form action="<%=basePath%>pldr/cyry/handler" method="post">
	<input id="file" name="fileName" type="hidden" value="${filename}">
	<input id="dwid" name="dwid" type="hidden" value="${dwid}">
	</form>
</body>
</html>
<script type="text/javascript" >
$(document).ready(function(){
	document.forms[0].submit();
	alert("您上传的文件已被接收，正在处理");
	window.opener=null;
	window.open('','_self');
	window.close();
});
</script>