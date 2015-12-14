<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=contextPath%>/css/dbrw.css" rel="stylesheet"
	type="text/css" />

<title>纠错信息详细</title>

</head>
<body class="easyui-layout" data-options="split:false">
<div data-options="region:'center',split:false,border:false"
	style="height:800px">
<table id="dg" class="easyui-datagrid"
data-options="pagination:false,border:false,method:'get',
							url: '<%=request.getContextPath()%>/RuleYwxtgzrwlsjlb/queryRuleYwxtgzrwlsjlbList?fqrbmid=${entity.fqrbmid}&rwclrbmid=${entity.rwclrbmid}',
							fitColumns:true,
							pageSize:5,
							pageList:[5]">
<thead>
<tr>
<th data-options="field:'ywxtgzrwmc',width:100,align:'right',halign:'center'">业务协同名称</th>
<th data-options="field:'ywxtrwms',width:250,align:'center',halign:'center'">任务內容</th>
<th data-options="field:'fqrbm',width:90,align:'center',halign:'center'">发起人部门</th>
<th data-options="field:'fqr',width:60,align:'center',halign:'center'">发起人</th>
<th data-options="field:'fqsj',width:100,align:'center',halign:'center'">发起时间</th>
<th data-options="field:'rwclrbm',width:90,align:'center',halign:'center'">任务处理人部门</th>
<th data-options="field:'rwclr',width:60,align:'center',halign:'center'">任务处理人</th>
<th data-options="field:'rwcljgdm',width:60,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_RULE_JGZT.js'">任务处理结果</th>
<th data-options="field:'rwclsj',width:100,align:'center',halign:'center'">任务处理时间</th>
<th data-options="field:'cjrbm',width:90,align:'center',halign:'center'">裁决人部门</th>
<th data-options="field:'cjr',width:60,align:'center',halign:'center'">裁决人</th>
<th data-options="field:'cjjgdm',width:60,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_RULE_JGZT.js'">裁决结果</th>
<th data-options="field:'cjsj',width:100,align:'center',halign:'center'">裁决时间</th>


</tr>
</thead>
</table>

</div>

<script type="text/javascript">
	$(function() {

	});
</script>
</body>
</html>
