<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>待督办任务管理</title>
</head>
<body>  
 
<br/>
<input type="button" value="发起任务" onclick="addTask()"/>

<script type="text/javascript">

function addTask() {
	var dataOptions = {
		title: '新建督办任务',
		url: contextPath + '/dbrwDdbrwb/startAdd?ddbrwid=06771B1B6F3097BEE053E105500AF75B',
		width: 850,
		height: 606
	};
	openWindowWithSave(false, "", window, null, dataOptions, "您是否要保存督办任务？", "", null);
}
</script>

</body>
</html>