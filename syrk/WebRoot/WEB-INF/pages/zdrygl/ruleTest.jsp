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
	<b>规则名称：</b>${item.rule}<br/><br/>
	<b>消息名字：</b>${item.title}<br/><br/>
	<b>消息内容：</b>${item.contents}
</p>
</c:forEach>

</body>
</html>
