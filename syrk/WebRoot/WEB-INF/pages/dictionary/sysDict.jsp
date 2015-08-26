<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>字典项管理</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/sysDict/queryList',toolbar:'#datagridToolbar',
            		singleSelect:false,selectOnCheck:true,checkOnSelect:true,border:false,sortName:'dm',sortOrder:'asc',fitColumns:true,
            		idField:'id',pageSize:10,pageList:[10,20],queryParams: {glid: '${entity.glid}'}">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				            <th data-options="field:'dm',width:12,align:'center',halign:'center',sortable:true">字典代码</th>
				            <th data-options="field:'ct',width:30,align:'left',halign:'center',sortable:true">字典词条</th>
				            <th data-options="field:'py',width:15,align:'left',halign:'center',sortable:true">拼音首字母</th>
				            <th data-options="field:'xt_zhxgsj',width:14,align:'center',halign:'center',sortable:true">最后修改时间</th>
				            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto">
					<!-- 表格工具条按钮 -->
					<table cellspacing="0" cellpadding="0" border="0">
					<tbody>
					<tr>
						<td>
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="datagridAdd(this, 'addWindow', 
					    		null,
					    		{
					    		title: '字典项新增',
					    		url: contextPath + '/sysDict/add?glid=${entity.glid}',
					    		width: 650,
					    		height: 200
					    		},
   								''
					    		)">添加</a>
						</td>
						<td class="toolbarTd">
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="datagridDeletePatch(this, '', 
					    		'csmc',
					    		{
					    		url: contextPath + '/sysDict/deletePatch'
					    		})">批量删除</a>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="toolbarTd">
							<table cellspacing="0" cellpadding="0" border="0">
							<tbody>
							<tr class="dialogTr">
								<td width="80" class="dialogTd" align="right">字典代码：</td>
								<td width="120" class="dialogTd"><input class="easyui-validatebox" type="text" id="dm" style="width:120px;"/></td>
		    					<td width="80" class="dialogTd">（模糊查询）</td>
								<td width="80" class="dialogTd" align="right">字典词条：</td>
								<td width="120" class="dialogTd"><input class="easyui-validatebox" type="text" id="ct" style="width:120px;"/></td>
		    					<td width="80" class="dialogTd">（模糊查询）</td>
							</tr>
							</tbody>
							</table>
						</td>
						<td class="toolbarTd">
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-query" plain="true" onclick="queryButton()">查询</a>
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
	var editUrl = contextPath + '/sysDict/edit';
	var opts = $(this).datagrid('options');
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	datagridEdit(opts.id, 'editWindow', 
   		null,
  		{
   		title: '字典项修改',
   		url: editUrl,
   		width: 650,
		height: 200
   		}
   	);
}

// 修改单条
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = contextPath + '/sysDict/edit';
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
   		title: '字典项修改',
   		url: editUrl,
   		width: 650,
		height: 200
   		},
   		''
   	);
}

// 删除单条
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/sysDict/delete';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var submitFields = ""; //  除主键之外需要提交的字段（多个用逗号分隔）
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

function queryButton() {
	var datagrid_ID = "dg";;
	var data = {};
	data['glid'] = '${entity.glid}';
	data['dm'] = $('#dm').val();
	data['ct'] = $('#ct').val();
	$('#' + datagrid_ID).datagrid('load', data);	
}

</script>  

</html>