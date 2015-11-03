<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>规则测试</title>
</head>
<body>
<c:forEach items="${List}" var="item" varStatus="status">
<p>
	<b>规则名称：</b>${item.xxlb}<br/><br/>
	<c:if test="${item.status == 0 }">
	<b>消息名字：</b>${item.xxbt}<br/><br/>
	<b>消息内容：</b>${item.xxnr}<br/><br/>
	</c:if>
	<c:if test="${item.status == 1 }">
	<b>错误信息：</b>${item.errorMessage}<br/><br/>
	</c:if>
</p>
</c:forEach>

</body>
</html>
