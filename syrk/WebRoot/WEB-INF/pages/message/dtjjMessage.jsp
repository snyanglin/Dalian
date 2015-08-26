<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>系统消息</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:true" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/jcj/querySyDtjqxx',
            	    toolbar:'#datagridToolbar',
            		singleSelect:true,selectOnCheck:true,checkOnSelect:true,border:false,
            		idField:'id',pageSize:getAutoPageSize(),pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				            
				            
					        <th data-options="field:'bj_sj',width:10,align:'center'">报警时间</th>
					        <th data-options="field:'jj_sj',width:10,align:'center'">接警类别</th>
				            <th data-options="field:'bjnr',width:75,align:'left',halign:'center'">报警内容</th>
				            <th data-options="field:'jjbh',hidden:true">jjbh</th>
				            <th data-options="field:'xzqhdm',hidden:true">xzqhdm</th>
				            <th data-options="field:'id',hidden:true">id</th>
				            <th data-options="field:'cjdbh',hidden:true">cjdbh</th>
				            <th data-options="field:'orgseatno',hidden:true">orgseatno</th>
				          	<th data-options="field:'process',width:5,align:'center',halign:'center',formatter:processFormater22">操作</th>
				        </tr>
				    </thead>
				</table>
			</div>
        </div>
    </div>   
</body>
<script type="text/javascript">

function processFormater22(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;';
}

function doView(linkObject, index){
	var datagrid_ID = getDatagrid_ID(0, linkObject);
    var rows = $('#' + datagrid_ID).datagrid("getData");
    var rowData = rows.rows[index];
	var editUrl = contextPath + '/jcj/queryJjxx?id='+rowData.id;
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var paramArray = [3];
	paramArray[0] = rowData.jjbh;
	paramArray[1] = rowData.xzqhdm;
	paramArray[2] = rowData.cjdbh;
	openWindowNoSave(true, null, this.Window, 
   		paramArray, 
   		{
   		title: '接处警反馈信息新增',
   		url: editUrl,
   		maximizable: false,
   		width: 600,
   		height: 420
   		}, 
   		'你是否要保存数据？', null
   	);
}



</script>  

</html>