<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>组织机构岗位</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'岗位列表',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/orgPosition/queryList',toolbar:'#datagridToolbar',
            		singleSelect:false,selectOnCheck:true,checkOnSelect:true,border:false,sortName:'orderno',sortOrder:'asc',
            		idField:'id',pageSize:getAutoPageSize(),pageList:[getAutoPageSize(),getAutoPageSize() * 2],onLoadSuccess:function(data){queryMinMaxOrder();}">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				            <th data-options="field:'posid',width:10,align:'center',halign:'center',sortable:true">岗位ID</th>
				            <th data-options="field:'posname',width:30,align:'left',halign:'center',sortable:true">岗位名称</th>
				            <th data-options="field:'posdesc',width:30,align:'left',halign:'center',sortable:true">岗位描述</th>
				            <th data-options="field:'orderno',width:10,align:'center',halign:'center',sortable:true">岗位顺序号</th>
				            <th data-options="field:'process',align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
				            <th data-options="field:'sort',align:'center',halign:'center',formatter:sortFormater">排序</th>
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
					    		title: '组织机构－岗位查询条件',
					    		url: contextPath + '/orgPosition/queryCondition',
					    		width: 850,
					    		height: 320
					    		})">查询</a>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td>
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="datagridAdd(this, 'addWindow', 
					    		null,
					    		{
					    		title: '组织机构－岗位新增',
					    		url: contextPath + '/orgPosition/add',
					    		width: 850,
					    		height: 320
					    		},
   								''
					    		)">新增</a>
						</td>
						<td class="toolbarTd">
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="datagridDeletePatch(this, '', 
					    		'',
					    		{
					    		url: contextPath + '/orgPosition/deletePatch'
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
var minOrderNO = ${minOrderNO};
var maxOrderNO = ${maxOrderNO};
var canSort = true;

function processFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this, '+index+')">编辑</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">删除</a>&nbsp;';
}

function setCanSort() {
	var opts = $('#dg').datagrid('options');
	var queryParams = opts.queryParams;
	canSort = true;
	for (var item in queryParams) {
		if (queryParams[item] != null && queryParams[item] != "") {
			canSort = false;
			break;
		}
	}	
}

function sortFormater(val, row, index) { // 排序操作
	if (index == 0) {
		setCanSort();
	}
	if (canSort) {
		return '&nbsp;<input type="button" class="butMoveUp" title="上移" onclick="moveUp(this, '+index+')"/>' +
			   '<input type="button" class="butMoveDown" title="下移" onclick="moveDown(this, '+index+')"/>&nbsp;';
	}
	else {
		return '';
	}
}

function queryMinMaxOrder() {
	$.ajax({
		url: contextPath + '/orgPosition/queryMinMaxOrder',
		dataType:"json",
		type: 'POST'
	}).success(function(data) {
		if (data) {
			minOrderNO = data.minOrderNO;
			maxOrderNO = data.maxOrderNO;
		}
	});	
}

function moveUp(linkObject, rowIndex) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid('options');
	var idField = opts.idField;
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[rowIndex];
	var orderNO = rowData['orderno'];
	if (orderNO == minOrderNO) {
		topMessager.alert('', '该数据已经处于最前，无需上移！', 'error');
	}
	else {
		if (rowIndex == 0) { // 本页的第一行
			var postData = {};
			postData[idField] = rowData[idField];
			postData['moveType'] = 'up';
			$.ajax({
				url: contextPath + '/orgPosition/moveSave',
				type: 'POST',
				data: postData
			}).done(function(result) {
				result = parseReturn(result);
				if (result.status == 'success') {
					var pager = $('#' + datagrid_ID).datagrid('getPager');
					var pageNumber = pager.pagination('options').pageNumber;
					pager.pagination('select', pageNumber - 1); 
				}
				else {
					topMessager.alert('', result.message, 'error');
				}
			});
		}
		else {
			var postData = {};
			var prevRowData = rows.rows[rowIndex - 1];
			postData[idField] = rowData[idField];
			postData['exchangeid'] = prevRowData[idField];
			$.ajax({
				url: contextPath + '/orgPosition/moveSave',
				type: 'POST',
				data: postData
			}).done(function(result) {
				result = parseReturn(result);
				if (result.status == 'success') {
					var curData = new Array();
					var prevData = new Array();
					for (var item in rowData) {
						curData[item] = rowData[item];
					}
					for (var item in prevRowData) {
						prevData[item] = prevRowData[item];
					}
					curData['orderno'] = prevRowData['orderno'];
					prevData['orderno'] = rowData['orderno'];
					$('#' + datagrid_ID).datagrid('updateRow',{
						index: rowIndex,
						row: prevData
					});
					$('#' + datagrid_ID).datagrid('updateRow',{
						index: rowIndex - 1,
						row: curData
					});
				}
				else {
					topMessager.alert('', result.message, 'error');
				}
			});
		}
	}
}

function moveDown(linkObject, rowIndex) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid('options');
	var idField = opts.idField;
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[rowIndex];
	var orderNO = rowData['orderno'];
	if (orderNO == maxOrderNO) {
		topMessager.alert('', '该数据已经处于最后，无需下移！', 'error');
	}
	else {
		if (rowIndex == rows.rows.length - 1) { // 本页的最后行
			var postData = {};
			postData[idField] = rowData[idField];
			postData['moveType'] = 'down';
			$.ajax({
				url: contextPath + '/orgPosition/moveSave',
				type: 'POST',
				data: postData
			}).done(function(result) {
				result = parseReturn(result);
				if (result.status == 'success') {
					var pager = $('#' + datagrid_ID).datagrid('getPager');
					var pageNumber = pager.pagination('options').pageNumber;
					pager.pagination('select', pageNumber + 1); 
				}
				else {
					topMessager.alert('', result.message, 'error');
				}
			});
		}
		else {
			var postData = {};
			var nextRowData = rows.rows[rowIndex + 1];
			postData[idField] = rowData[idField];
			postData['exchangeid'] = nextRowData[idField];
			$.ajax({
				url: contextPath + '/orgPosition/moveSave',
				type: 'POST',
				data: postData
			}).done(function(result) {
				result = parseReturn(result);
				if (result.status == 'success') {
					var curData = new Array();
					var nextData = new Array();
					for (var item in rowData) {
						curData[item] = rowData[item];
					}
					for (var item in nextRowData) {
						nextData[item] = nextRowData[item];
					}
					curData['orderno'] = nextRowData['orderno'];
					nextData['orderno'] = rowData['orderno'];
					$('#' + datagrid_ID).datagrid('updateRow',{
						index: rowIndex,
						row: nextData
					});
					$('#' + datagrid_ID).datagrid('updateRow',{
						index: rowIndex + 1,
						row: curData
					});
				}
				else {
					topMessager.alert('', result.message, 'error');
				}
			});
		}
	}
}

// 行单击
function doOnClickRow(rowIndex, rowData) {
	var editUrl = contextPath + '/orgPosition/edit';
	var opts = $(this).datagrid('options');
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	datagridEdit(opts.id, 'editWindow', 
   		null,
  		{
   		title: '组织机构－岗位修改',
   		url: editUrl,
   		width: 850,
   		height: 320
   		}
   	);
}

// 修改单条
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = contextPath + '/orgPosition/edit';
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
   		title: '组织机构－岗位修改',
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
	var deleteUrl = contextPath + '/orgPosition/delete';
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

</script>  

</html>