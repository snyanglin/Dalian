<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>字典管理</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'字典管理',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/sysDictGl/queryList',toolbar:'#datagridToolbar',
            		singleSelect:false,selectOnCheck:true,checkOnSelect:true,border:false,sortName:'zdywm',sortOrder:'asc',fitColumns:true,
            		idField:'id',pageSize:getAutoPageSize(),pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				            <th data-options="field:'zdywm',width:18,align:'left',halign:'center',sortable:true">字典英文名</th>
				            <th data-options="field:'zdzwm',width:18,align:'left',halign:'center',sortable:true">字典中文名</th>
				            <th data-options="field:'zdsclb',width:10,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_SYS_ZDSCLB.js'">生成类别</th>
				            <th data-options="field:'zdsylb',width:10,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_SYS_ZDSYLB.js'">使用类别</th>
				            <th data-options="field:'zdywlb',width:15,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_SYS_ZDYWLB.js'">业务类别</th>
				            <th data-options="field:'zdbbh',width:7,align:'center',halign:'center',sortable:true">版本号</th>
				            <th data-options="field:'process1',align:'center',halign:'center',formatter:processFormater1">操作</th>
				            <th data-options="field:'process2',align:'center',halign:'center',formatter:processFormater2">JS文件</th>
				            <th data-options="field:'process3',align:'center',halign:'center',formatter:processFormater3">字典项管理</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto">
					<!-- 表格工具条按钮 -->
					<table cellspacing="0" cellpadding="0" border="0">
					<tbody>
					<tr>
						<td class="toolbarTd">
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-query" plain="true" onclick="datagridQuery(this, 'queryWindow', 
					    		null,
					    		{
					    		title: '字典管理查询条件',
					    		url: contextPath + '/sysDictGl/queryCondition',
					    		width: 850,
					    		height: 320
					    		})">查询</a>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td>
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="datagridAdd(this, 'addWindow', 
					    		null,
					    		{
					    		title: '字典管理新增',
					    		url: contextPath + '/sysDictGl/add',
					    		width: 850,
					    		height: 320
					    		},
   								'您是否要保存数据？'
					    		)">添加</a>
						</td>
						<td class="toolbarTd">
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="datagridDeletePatch(this, '', 
					    		'csmc',
					    		{
					    		url: contextPath + '/sysDictGl/deletePatch'
					    		})">批量删除</a>
						</td>
					</tr>
					</tbody>
					</table>
				</div>
			</div>
        </div>
    </div>   
</body>
<script type="text/javascript">

function processFormater1(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this, '+index+')">编辑</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">删除</a>&nbsp;';
}

function processFormater2(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doCreateJS(this, '+index+')">生成</a>&nbsp;';
}

function processFormater3(val, row, index) { // 自定义操作生成
	if (row['zdsclb'] == '1' || row['zdsclb'] == '2') {
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doManageItem(this, '+index+')">管理</a>&nbsp;';
	}
	else {
		return '';
	}
}

// 行单击
function doOnClickRow(rowIndex, rowData) {
	var editUrl = contextPath + '/sysDictGl/edit';
	var opts = $(this).datagrid('options');
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	datagridEdit(opts.id, 'editWindow', 
   		null,
  		{
   		title: '字典管理修改',
   		url: editUrl,
   		width: 850,
   		height: 320
   		}
   	);
}

// 修改单条
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = contextPath + '/sysDictGl/edit';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	datagridEdit(datagrid_ID, 'editWindow', 
   		null,
  		{
   		title: '字典管理修改',
   		url: editUrl,
   		width: 850,
   		height: 320
   		},
   		'您是否要保存数据？'
   	);
}

// 删除单条
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/sysDictGl/delete';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var submitFields = "csmc"; //  除主键之外需要提交的字段（多个用逗号分隔）
	topMessager.confirm('','您确认要删除数据吗？',function(r) {    
		if (r) {	
			var opts = $('#' + datagrid_ID).datagrid("options");
			var rows = $('#' + datagrid_ID).datagrid('getData');
			var rowData = rows.rows[index];
			var postFieldArray = [];
			postFieldArray.push(opts.idField);
			if (submitFields != "") {
				postFieldArray = postFieldArray.concat(submitFields.split(","));
			}
			var postData = {};
			for (var i = 0; i < postFieldArray.length; i++) {
				var postField = postFieldArray[i];
				if (rowData[postField]) {
					postData[postField] = rowData[postField];
				}
			}
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: postData
			}).done(function(result) {
				doSubmitResult(result, null, datagrid_ID);
			});
		}
	});
}

// 生成JS
function doCreateJS(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var postUrl = contextPath + '/sysDictGl/createJS';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var confirmMessage = "您是否要生成JS文件：<br><br>" + rowData['zdywm'] + ".js？";
	topMessager.confirm('',confirmMessage,function(r) {    
		if (r) {	
			var postData = {};
			postData[opts.idField] = rowData[opts.idField];
			$.ajax({
				url: postUrl,
				type: 'POST',
				data: postData
			}).done(function(result) {
				doSubmitResult(result, null, datagrid_ID);
			});
		}
	});
}

// 字典项管理
function doManageItem(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = contextPath + '/sysDict/query';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + "glid=" + rowData[idField];
	datagridView(datagrid_ID, 'itemWindow', 
   		null,
  		{
   		title: '字典项管理：' + rowData['zdzwm'],
   		url: editUrl,
   		width: 850,
   		height: 420
   		}
   	);
}

</script>  

</html>