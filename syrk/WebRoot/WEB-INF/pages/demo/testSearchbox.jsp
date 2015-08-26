<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JeasyUI测试</title>
</head>

<body>
	<h2>Search Category</h2>
	<p>Select a category and click search button or press enter key in input box to do searching.</p>
	<div style="margin:20px 0;"></div>
	<input class="easyui-searchbox" data-options="prompt:'Please Input Value',menu:'#mm',searcher:doSearch" style="width:300px"></input>
	<div id="mm">
		<div data-options="name:'all',iconCls:'icon-ok'">所有类别</div>
		<div data-options="name:'sports',iconCls:'icon-query'">地址数据</div>
	</div>
	<script>
		function doSearch(value,name){
			alert('You input: ' + value+'('+name+')');
		}
	</script>

</body>
</html>