<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>规则测试</title>

</head>
<body>
<table border=0>
<c:forEach items="${List}" var="item" varStatus="status">
<tr>
	<td>规则分组：</td><td>${item.key}</td>
	<td>URL：</td><td>${item.value}</td>	
	<td><a href="reloadOne.do?str=${item.key}">刷新</a></td>	
</tr>
</c:forEach>
</table>
</body>
</html>
