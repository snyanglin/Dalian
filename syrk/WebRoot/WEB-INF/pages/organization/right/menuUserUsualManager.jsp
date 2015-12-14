<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>组织机构个人常用菜单</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'个人常用菜单列表',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/orgMenuUserUsual/queryList',toolbar:'#datagridToolbar',
            		singleSelect:false,selectOnCheck:true,checkOnSelect:true,border:false,sortName:'orderno',sortOrder:'asc',
            		idField:'id',pageSize:getAutoPageSize(),pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				            <th data-options="field:'systemcode',width:15,align:'center',halign:'center',sortable:false">菜单系统代码</th>
				            <th data-options="field:'systemname',width:20,align:'center',halign:'center',sortable:false">菜单系统名称</th>
				            <th data-options="field:'menuname',width:30,align:'left',halign:'center',sortable:false">菜单名称</th>
				            <th data-options="field:'orderno',width:10,align:'center',halign:'center',sortable:false">个人顺序号</th>
				            <th data-options="field:'process',width:10,align:'center',halign:'center',formatter:processFormater">操作</th>
				            <th data-options="field:'sort',width:10,align:'center',halign:'center',formatter:sortFormater">排序</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto">
					<!-- 表格工具条按钮 -->
					<table cellspacing="0" cellpadding="0" border="0">
					<tbody>
					<tr>
						<td>
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-config" plain="true" onclick="datagridAdd(this, 'addWindow', 
					    		null,
					    		{
					    		title: '组织机构－个人常用菜单配置',
					    		url: contextPath + '/orgMenuUserUsual/menuAssign',
					    		width: 850,
					    		height: 420
					    		},
   								''
					    		)">常用菜单配置</a>
						</td>
						<td class="toolbarTd">
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="datagridDeletePatch(this, '', 
					    		'',
					    		{
					    		url: contextPath + '/orgMenuUserUsual/deletePatch'
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
		
function processFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">删除</a>&nbsp;';
}

function sortFormater(val, row, index) { // 排序操作
	return '&nbsp;<input type="button" class="butMoveUp" title="上移" onclick="moveUp(this, '+index+')"/>' +
		   '<input type="button" class="butMoveDown" title="下移" onclick="moveDown(this, '+index+')"/>&nbsp;';
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
				url: contextPath + '/orgMenuUserUsual/moveSave',
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
				url: contextPath + '/orgMenuUserUsual/moveSave',
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
				url: contextPath + '/orgMenuUserUsual/moveSave',
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
				url: contextPath + '/orgMenuUserUsual/moveSave',
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

// 删除单条
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/orgMenuUserUsual/delete';
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