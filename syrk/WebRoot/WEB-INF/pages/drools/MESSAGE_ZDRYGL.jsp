<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>消息规则测试</title>
</head>
<body style="margin-top:20px; margin-bottom:10px" class="bodybg">
<div data-options="region:'center',split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc"> 
 		<div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
 		
<table border="0" width="90%" align="center">
<c:forEach items="${List}" var="item" varStatus="status">
<tr><td>
	<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	<tr>
		<th width="30%" class="dialogTd">规则名称：</th><td class="dialogTd">${item.xxlb}</td>
	</tr>
	<c:if test="${item.status == 0 }">
	<tr>
		<th class="dialogTd">消息名字：</th><td class="dialogTd">${item.xxbt}</td>
	</tr>
	<tr>
		<th class="dialogTd">消息内容：</th><td class="dialogTd">${item.xxnr}</td>
	</tr>
	</c:if>
	<c:if test="${item.status == 1 }">
	<tr>
		<th class="dialogTd">错误信息：</th><td class="dialogTd">${item.errorMessage}</td>
	</tr>
	</c:if>	
	</table>
	<hr>
</td></tr>
</c:forEach>
</table>

</div>
</div>
</div>
</div>
</td>
</tr>
</table>
</div>
</body>
</html>
