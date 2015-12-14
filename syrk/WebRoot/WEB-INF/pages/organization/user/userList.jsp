<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>用户信息</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'用户信息列表',border:true" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/orgUser/queryList',toolbar:'#datagridToolbar',
            		singleSelect:false,selectOnCheck:true,checkOnSelect:true,border:false,sortName:'id',sortOrder:'asc',
            		idField:'id',pageSize:getAutoPageSize(),pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				            <th data-options="field:'userid',width:40,align:'left',halign:'center',sortable:true">用户帐号</th>
				            <th data-options="field:'username',width:50,align:'left',halign:'center',sortable:true">用户名称</th>
				            <th data-options="field:'orgid',width:60,align:'left',halign:'center',sortable:true">所在部门</th>
				            <th data-options="field:'username',width:50,align:'left',halign:'center',sortable:true">用户名称</th>
				            <th data-options="field:'usertype',width:40,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_ORG_USERTYPE.js'">用户类型</th>
				            <th data-options="field:'managerorgname',width:60,align:'left',halign:'center',sortable:true">管理部门</th>
				             <th data-options="field:'industrialid',width:30,align:'left',halign:'center',sortable:true">行业号码(警号)</th>
				            <th data-options="field:'mobile',width:30,align:'left',halign:'center',sortable:true">移动电话</th>
				            <th data-options="field:'process',align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
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
					    		title: '用户查询条件',
					    		url: contextPath + '/orgUser/queryCondition',
					    		width: 550,
					    		height: 320
					    		})">查询</a>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td>
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="datagridAdd(this, 'addWindow', 
					    		null,
					    		{
					    		title: '用户信息',
					    		url: contextPath + '/orgUser/add',
					    		width: 850,
					    		height: 450
					    		},
   								'您是否要保存数据？'
					    		)">添加</a>
						</td>
						<td class="toolbarTd">
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="datagridDeletePatch(this, '', 
					    		'csmc',
					    		{
					    		url: contextPath + '/orgUser/deletePatch'
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

function processFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this, '+index+')">编辑</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">删除</a>&nbsp;';
}

// 行单击
function doOnClickRow(rowIndex, rowData) {
	var editUrl = contextPath + '/orgUser/edit';
	var opts = $(this).datagrid('options');
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	datagridEdit(opts.id, 'editWindow', 
   		null,
  		{
   		title: '用户信息修改',
   		url: editUrl,
   		width: 850,
   		height: 320
   		}
   	);
}

// 修改单条
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = contextPath + '/orgUser/edit';
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
   		title: '用户信息修改',
   		url: editUrl,
   		width: 850,
   		height: 450
   		},
   		'您是否要保存数据？'
   	);
}

// 删除单条
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/orgUser/delete';
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

</script>  

</html>