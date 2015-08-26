<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<!--  
	@updateAuthor: [star]
	@updateDate:   [2015-6-2 上午8:51:54]
-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>从业人员导入任务</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
</head>
<body style="margin-top:20px">

	<form method="post"  action="<%=basePath %>cyrydrrwxxb/save"  enctype="multipart/form-data" style="height: 50px" id="upLoadForm" >
	<input name="dwid" id="dwid" type="hidden" value="${dwid}"/>
	<input type="file" name="uploadFile"  id="uploadFile" 
	style="width:200px;vertical-align:middle" class="easyui-validatebox" 
	data-options="tipPosition:'left',invalidMessage:'请选择excel格式的文件！',required:true" />
	<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls=""  onclick="upLoad()">上传</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls=""  onclick="downLoadTemplate()">下载模板</a>
	</form>
	<div style="height: 90%;">
	<table id="dg" class="easyui-datagrid"  
            	data-options="url:'<%=basePath %>cyrydrrwxxb/view?dwid=${dwid}',
            		sortName:'',
            		sortOrder:'desc',
            		idField:'id',
            		pageSize:15,
            		method:'get',
            		pageList:[15,30],
            		singleSelect:true,
            		fitColumns:true">
				    <thead>
				        <tr>
				         <th data-options="field:'id',	width:120,align:'center',halign:'center',hidden:true">任务名称</th>
				            <th data-options="field:'rwmc',	width:120,align:'center',halign:'center'">任务名称</th>
				            <th data-options="field:'drsj',	width:100,align:'center',halign:'center',sortable:true">导入时间</th>
				            <th data-options="field:'rwzt',		width:50,align:'center',halign:'center',sortable:true,formatter:dwzt_formatter">任务状态</th>
				            <th data-options="field:'rwsm',	width:200,align:'center',halign:'center',sortable:true">任务说明</th>
				            <th data-options="field:'process',width:90,align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
				    </thead>
				</table>
	</div>
</body>

<script type="text/javascript" >
function upLoad(){
	if ($("#upLoadForm").form('validate')) { // 表单的验证
	$("#upLoadForm").submit();
	alert("文件上传中，请稍后！页面即将关闭可再次打开导入功能查看上传结果!");
	window.parent.$('#cyry_import_win').window('close');
	}
	//location.href= contextPath + '/cyrydrrwxxb/createPage?dwid=${dwid}';
}
function downLoadTemplate(){
	location.href=contextPath+'/cyrydrrwxxb/exportTemplate';
}

function datagridProcessFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:void(0)" onclick="openDetailWindow(\''+row.id+'\')">查看</a>&nbsp;';
}

function openDetailWindow(rwid){
	location.href=contextPath+'/cyrydrrwmxb/createPage?rwid='+rwid;
}

//性别formatter
function dwzt_formatter(value, rowData, rowIndex){
	if(value == '1'){
		return '成功';
	}else if(value == '0'){
		return '导入中';
	}else{
		return '未知错误';
	}
}


</script>
</html>