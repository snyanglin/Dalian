<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common.jsp"%>
<%
String contextPath = request.getContextPath();
String emptyImage = contextPath + "/common/skin/images/sys_empty.gif";
%>
<script type="text/javascript">
var contextPath = "<%=contextPath%>";
</script>

<link href="<%=contextPath%>/common/skin/main.css" type="text/css" rel="stylesheet" >
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/global.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/mainFrame.js" ></script>

<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<BODY class="bannerBody" onselectstart="return false;" oncontextmenu="return false;">

<div class="bannerbg banner02">
	<div class="banner_lf banner01"><img src="<%=emptyImage%>" width="650" height="1" border="0"></div> 
</div>

</BODY>
</HTML>
