<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>角色指定权限</title>
</head>
<body class="easyui-layout" data-options="fit:true">

	<div data-options="region:'west',split:false,title:'角色信息列表',border:false,collapsible:false" style="height:auto;width:620">
		<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/orgRoleRight/queryList',toolbar:'#datagridToolbar',
			singleSelect:true,border:false,sortName:'orderno',sortOrder:'asc',
			idField:'id',pageSize:getAutoPageSize(),pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
			<!-- onClickRow:doOnClickRow 单击行事件 --> 
			<thead>
				<tr>
		            <th data-options="field:'rolename',width:40,align:'left',halign:'center',sortable:true">角色名称</th>
		            <th data-options="field:'roledesc',width:40,align:'left',halign:'center',sortable:true">角色描述</th>
		            <th data-options="field:'bz',width:50,align:'center',halign:'center'">角色管理部门</th>
		            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
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
			    		title: '角色查询条件',
			    		url: contextPath + '/orgRoleRight/queryCondition',
			    		width: 550,
			    		height: 320
			    		})">查询</a>
				</td>
			</tr>
			</tbody>
			</table>
		</div>
	</div>
			
	<div data-options="region:'center',split:false,title:'角色可分配权限',border:false" style="height:auto; border-left: 1px solid #95B8E7;">
		<div class="easyui-layout" data-options="fit:true,border:false">
			<div data-options="region:'north',split:false,title:'',border:false,collapsible:false" class="datagrid-toolbar" style="padding: 5px; height: 37; overflow: hidden;">
				<table cellspacing="0" cellpadding="0" border="0" width="100%" height="100%">
					<tr>
					<td class="toolbarTd" width="100">
						<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
							<span class="l-btn-left l-btn-icon-left">
								<span class="l-btn-text" nowrap="nowrap">保存</span>
								<span class="l-btn-icon icon-save"> </span>
							</span>
						</a>
					</td>
					<td id="messageTd" align="right" nowrap="nowrap" style="padding-right: 6px;"></td>
					</tr>
				</table>
			</div>
			<div data-options="region:'center',split:false,title:'',border:false,collapsible:false" style="padding: 5px; height: auto;">
				<ul class="easyui-tree" id="editTree" data-options="method:'get',lines:true,checkbox:true"></ul>
				<div style="height: 36px;"></div>
			</div>
		</div>
	</div>

	<div style="display: none;">
		<form action="<%=basePath%>orgRoleRight/assignSave" id="dataForm" name="dataForm" method="post">
		<input type="hidden" name="roleid" id="roleid"/>
		<input type="hidden" name="assignMenuID" id="assignMenuID"/>
		</form>
	</div>    
</body>
<script type="text/javascript">
var userManageOrgId = "${userManageOrgId}";
var messageTdObject = null;

function processFormater(val, row, index) { // 自定义操作生成
	if (row['managerorgid'] == userManageOrgId) {
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this, '+index+')">指定权限</a>&nbsp;';
	}
	else {
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;';
	}
}

// 修改单条
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	$("#saveBotton").show();
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var idField = opts.idField;
	$('#' + datagrid_ID).datagrid("selectRow", index);
	$('#roleid').val(rowData[idField]);
	var optsTree = $('#editTree').tree("options"); 
	optsTree.checkbox = true;
	var postData = {};
	postData['roleid'] = rowData[idField];
	$.ajax({
		url: contextPath + '/orgRoleRight/rightMenuTree',
		type: 'POST',
		data: postData
	}).done(function(result) {
		if (result != "") {
			result = parseReturn(result);
			$('#editTree').tree("loadData", result);
		}
		messageTdObject.innerHTML = '角色名称：' + rowData['rolename'];
	});	
}

// 查看权限
function doView(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	$("#saveBotton").hide();
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var idField = opts.idField;
	$('#' + datagrid_ID).datagrid("selectRow", index);
	$('#roleid').val(rowData[idField]);
	var optsTree = $('#editTree').tree("options"); 
	optsTree.checkbox = false;
	var postData = {};
	postData['roleid'] = rowData[idField];
	$.ajax({
		url: contextPath + '/orgRoleRight/viewRightMenuTree',
		type: 'POST',
		data: postData
	}).done(function(result) {
		if (result != "") {
			result = parseReturn(result);
			$('#editTree').tree("loadData", result);
		}
		messageTdObject.innerHTML = '角色名称：' + rowData['rolename'];
	});	
}

$(document).ready(function() {
	messageTdObject = $('#messageTd')[0];
	
	$('#editTree').tree({
		onClick: function(node) { // 在点击的时候执行
			var opts = $(this).tree('options');
			if (node.id != "ROOT") { // 根结点不变
				if (node.children) { // 中间结点自动展开与折叠当前结点
					if (node.state == 'closed') {
						$(this).tree('expand', node.target);
					}
					else {
						$(this).tree('collapse', node.target);
					}
				}
				else {
					if (node.checked) {
						$(this).tree('uncheck',  node.target);
					}
					else {
						$(this).tree('check',  node.target);
					}
				}
			}
		}
	});	

	$("#saveBotton").bind("click",function() {
		var bottonObject = this;
		if (buttonDisabled(bottonObject) == false) {
			return false;
		}	
		topMessager.confirm('', '您是否要保存当前的数据？', function(r) {
			if (r) {
				var nodes = $('#editTree').tree('getChecked');
				var selectNodeID = [];
				if (nodes.length > 0) {
					for (var item in nodes) {
						var nodeObject = nodes[item];
						var nodeType = nodeObject['nodeType'];
						if (nodeType == "menu2") {
							selectNodeID.push(nodeObject['id']);
						}
					}
				}
				$('#assignMenuID').val(selectNodeID.join(','));
				$('#dataForm').form('submit',{
					dataType : 'json',
					onSubmit: function() {
					},
					success: function(result) {
						buttonEnabled(bottonObject);
						result = parseReturn(result);
						if (result.status == 'success') { // 返回成功后执行的方法
							doSubmitResult(result, null, null);
						}
						else {
							topMessager.alert(MESSAGER_TITLE, result.message, 'error');
						}
					}
				});			
			}
			else {
				buttonEnabled(bottonObject);
			}
		});
		
	});	
	
});

</script>  

</html>