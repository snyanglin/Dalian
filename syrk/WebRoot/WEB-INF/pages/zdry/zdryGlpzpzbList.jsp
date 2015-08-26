<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>重点人员管理配置</title>

</head>
<body>
	<div id="layout_main" class="easyui-layout"  data-options="fit:true,border:false">
		<div id="panel_center" border="0" data-options="region:'center',border:false" style="width:700px;border:none;">
			<table id="dg" class="easyui-datagrid" style="width:700px;height:auto" data-options="url:'<%=contextPath%>/zdryGlpzpzb/queryList',fitColumns:true,singleSelect:true,
    		border:false,
            fitColumns:true,
    		pageSize:getAutoPageSize(),
       		pageList:[getAutoPageSize(),
       		getAutoPageSize() * 2]">
    			<thead>   
			        <tr>   
			        	<th data-options="field:'id',hidden:true"></th> 
			        	<th data-options="field:'zdrygllxdm',width:200,align:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/DL_D_ZDRYGLLXDM.js'">重点人员管理类型</th>
			            <th data-options="field:'jgbmmc',width:300,align:'center',fixed:true">监管部门</th>
			        	<th data-options="field:'sfsjsp',width:150,align:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_SFDM.js'">上级审批</th>
			            <th data-options="field:'dtjszqdm',width:200,align:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/DL_D_DTJSZQDM.js'">动态纪实周期</th>
			            <th data-options="field:'process',width:200,align:'center',fixed:true,formatter:datagridProcessFormater">操作</th>   
			        </tr>   
			    </thead>
    		</table>
		</div>
	</div>
</body>

<script type="text/javascript">
var parentGrid;

function doInit(paramArray) {
	parentGrid = paramArray['_p'];
}

$(document).ready(function(){});

function afterSubmitSuccess(){
	location.reload();
}

//操作列
function datagridProcessFormater(val, row, index) {
	return '<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">配置</a>&nbsp;&nbsp;&nbsp;'
}

//修改配置
function doEdit(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	window.top.openWindowWithSave(false, null, window, 
   		{}, 
   		{
   		title: '重点人员管理配置',
   		url: '<%=contextPath%>/zdryGlpzpzb/add?id='+$('#dg').datagrid('getData').rows[index].id,
   		width: 830,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}

//新增配置
function doAdd(){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	window.top.openWindowWithSave(false, null, window, 
   		{}, 
   		{
   		title: '重点人员管理配置',
   		url: '<%=contextPath%>/zdryGlpzpzb/add',
   		width: 830,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}
</script>
</html>