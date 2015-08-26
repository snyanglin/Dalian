<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>组织机构分配角色</title>
</head>
<body class="easyui-layout" data-options="fit:true">

	<div data-options="region:'center',split:false,title:'',border:false,collapsible:false" style="height:auto;">
		<div id="tt" class="easyui-tabs" data-options="fit:true,tabHeight:25,border:false" style="height:auto;">   
		    <div title="部门" id="orgDiv" data-options="iconCls:'tree-org'" style="padding:2px; float:left; clear:both; display:inline;">
	   			<ul class="easyui-tree" id="orgTree" data-options="method:'get',lines:true,searchServer:true"></ul>
    			<div style="height: 36px;"></div>
		    </div>
		    <div title="实体岗位" id="orgPosDiv" data-options="iconCls:'icon-position'" style="overflow:auto;padding:2px; float:left; clear:both; display:inline;">
	   			<ul class="easyui-tree" id="orgPosTree" data-options="method:'get',lines:true,searchServer:true"></ul>
    			<div style="height: 36px;"></div>
		    </div>
		    <div title="人员" id="orgUserDiv" data-options="iconCls:'icon-user'" style="overflow:auto;padding:2px; float:left; clear:both; display:inline;">
	   			<ul class="easyui-tree" id="orgUserTree" data-options="method:'get',lines:true,searchServer:true"></ul>
    			<div style="height: 36px;"></div>

				<div id="menuUser" class="easyui-menu" data-options="onClick:menuHandler" style="width: 220px; display: none;">
					<div data-options="name:'userView',iconCls: 'icon-query'">查看人员信息</div>
				</div>
    			
		    </div>
		    <c:if test="${userManageOrgId == 0}">
			    <div title="虚拟岗位" id="posDiv" data-options="iconCls:'icon-position'" style="overflow:auto;padding:2px; float:left; clear:both; display:inline;">
		   			<ul class="easyui-tree" id="posTree" data-options="method:'get',lines:true,url:contextPath+'/common/dict/D_ORG_POSITION.js',
		   				onClick: function(node) {processRoleList(node);}"></ul>
	    			<div style="height: 36px;"></div>
			    </div> 
		    </c:if>
		</div>
	</div>

	<div data-options="region:'east',split:false,title:'分配角色信息列表',border:false,collapsible:false" style="height:auto;width:460;border-left: 1px solid #95B8E7;">
		<table id="dg" class="easyui-datagrid" data-options="singleSelect:false,selectOnCheck:true,checkOnSelect:true,border:false,pagination:false,idField:'id',toolbar:'#datagridToolbar'">
			<!-- onClickRow:doOnClickRow 单击行事件 --> 
			<thead>
	        <tr>
	        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
	            <th data-options="field:'rolename',width:40,align:'left',halign:'center',sortable:true">角色名称</th>
	            <th data-options="field:'roledesc',width:40,align:'left',halign:'center',sortable:true">角色描述</th>
	            <th data-options="field:'bz',width:50,align:'center',halign:'center'">角色管理部门</th>
	        </tr>
	    	</thead>
		</table>
		<div id="datagridToolbar" style="padding:5px; overflow: hidden;">
			<!-- 表格工具条按钮 -->
			<table cellspacing="0" cellpadding="0" border="0" height="26" width="100%">
				<tr>
				<td class="toolbarTd" width="100">
					<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
						<span class="l-btn-left l-btn-icon-left">
							<span class="l-btn-text" nowrap="nowrap">保存</span>
							<span class="l-btn-icon icon-save"></span>
						</span>
					</a>
				</td>
				<td id="messageTd" align="right" nowrap="nowrap" style="padding-right: 12px"></td>
				</tr>
			</table>
		</div>
	</div>

	<div style="display: none;">
		<form action="<%=basePath%>orgRoleAssign/assignSave" id="dataForm" name="dataForm" method="post">
		<input type="hidden" name="assignType" id="assignType"/>
		<input type="hidden" name="assignID" id="assignID"/>
		<input type="hidden" name="roleIds" id="roleIds"/>
		<input type="hidden" name="deleteRoleIds" id="deleteRoleIds"/>
		</form>
	</div>
	    
</body>
<script type="text/javascript">
var userManageOrgId = "${userManageOrgId}";
var selectAssignType = 0; // 选中的分配类型
var selectAssignID = ""; // 分配的ID
var assignRoleIds = ""; // 可分配的角色ID
var messageTdObject = null;

function loadOrgTree() {
	var loaded = $('#orgTree').attr('loaded');
	if (!loaded) {
		loaded = "";
	}
	if (loaded != "true") {
		roleClear();
		$.ajax({
			url: contextPath + '/orgRoleAssign/orgAssign',
			type: 'POST',
			data: {}
		}).done(function(result) {
			if (result) {
				result = parseReturn(result);
				$('#orgTree').tree("loadData", result);
			}
			$('#orgTree').attr('loaded', 'true');
		});
	}
	else {
		var node = $('#orgTree').tree('getSelected');
		if (node != null) {
			processRoleList(node);
		}
		else {
			roleClear();
		}
	}
}

function loadOrgPosTree() {
	var loaded = $('#orgPosTree').attr('loaded');
	if (!loaded) {
		loaded = "";
	}
	if (loaded != "true") {
		roleClear();
		$.ajax({
			url: contextPath + '/orgRoleAssign/orgPosAssign',
			type: 'POST',
			data: {}
		}).done(function(result) {
			if (result) {
				result = parseReturn(result);
				$('#orgPosTree').tree("loadData", result);
			}
			$('#orgPosTree').attr('loaded', 'true');
		});
	}
	else {
		var node = $('#orgPosTree').tree('getSelected');
		if (node != null) {
			processRoleList(node);
		}
		else {
			roleClear();
		}
	}
}

function loadOrgUserTree() {
	var loaded = $('#orgUserTree').attr('loaded');
	if (!loaded) {
		loaded = "";
	}
	if (loaded != "true") {
		roleClear();
		$.ajax({
			url: contextPath + '/orgRoleAssign/orgUserAssign',
			type: 'POST',
			data: {}
		}).done(function(result) {
			if (result) {
				result = parseReturn(result);
				$('#orgUserTree').tree("loadData", result);
			}
			$('#orgUserTree').attr('loaded', 'true');
		});
	}
	else {
		var node = $('#orgUserTree').tree('getSelected');
		if (node != null) {
			processRoleList(node);
		}
		else {
			roleClear();
		}
	}
}

function showPosTree() {
	var node = $('#posTree').tree('getSelected');
	if (node != null) {
		processRoleList(node);
	}
	else {
		roleClear();
	}
}

$(document).ready(function() {
	
	var sb = new StringBuffer();
	if (IE && IE_VERSION <= 9) {
		sb.append('<div id="searchDiv1" style="position: relative; float: right; text-align: right; width: 290px; padding-top:1px; padding-right:19px; color: #333333; z-index: 255;">');
		sb.append('<input id="searchKey1" maxlength="20" class="treeSearchInput" style="width: 200px;" onfocus="this.select();" title="匹配部门名称">&nbsp;');
		sb.append('<input type="button" id="search_but1" value="搜 索" onclick="searchTree(1)" class="treeSearchButton">');
		sb.append('</div>');
	}
	else {
		sb.append('<div id="searchDiv1" style="position: relative; float: right; text-align: right; width: 290px; padding-top:2px; padding-right:19px; color: #333333; z-index: 255;">');
		sb.append('<input id="searchKey1" maxlength="20" class="treeSearchInput" style="width: 200px;" onfocus="this.select();" title="匹配部门名称">&nbsp;');
		sb.append('<input type="button" id="search_but1" value="搜 索" onclick="searchTree(1)" class="treeSearchButton">');
		sb.append('</div>');
		$('#orgDiv').css('position', 'absolute');
	}
	$('#orgDiv').parent().prepend(sb.toString());
	$("#searchKey1").bind("keydown", function(e) {
		try {
			if (e.keyCode == 13) {
				searchTree(1);
				event.returnValue = false;
			}
		}
		catch (err) {};
	});
	
	
	var sb = new StringBuffer();
	if (IE && IE_VERSION <= 9) {
		sb.append('<div id="searchDiv2" style="position: relative; float: right; text-align: right; width: 290px; padding-top:1px; padding-right:19px; color: #333333; z-index: 255;">');
		sb.append('<input id="searchKey2" maxlength="20" class="treeSearchInput" style="width: 200px;" onfocus="this.select();" title="匹配部门名称">&nbsp;');
		sb.append('<input type="button" id="search_but2" value="搜 索" onclick="searchTree(2)" class="treeSearchButton">');
		sb.append('</div>');
	}
	else {
		sb.append('<div id="searchDiv2" style="position: relative; float: right; text-align: right; width: 290px; padding-top:2px; padding-right:19px; color: #333333; z-index: 255;">');
		sb.append('<input id="searchKey2" maxlength="20" class="treeSearchInput" style="width: 200px;" onfocus="this.select();" title="匹配部门名称">&nbsp;');
		sb.append('<input type="button" id="search_but2" value="搜 索" onclick="searchTree(2)" class="treeSearchButton">');
		sb.append('</div>');
		$('#orgPosDiv').css('position', 'absolute');
	}
	$('#orgPosDiv').parent().prepend(sb.toString());
	$("#searchKey2").bind("keydown", function(e) {
		try {
			if (e.keyCode == 13) {
				searchTree(2);
				event.returnValue = false;
			}
		}
		catch (err) {};
	});

	var sb = new StringBuffer();
	if (IE && IE_VERSION <= 9) {
		sb.append('<div id="searchDiv3" style="position: relative; float: right; text-align: right; width: 290px; padding-top:1px; padding-right:19px; color: #333333; z-index: 255;">');
		sb.append('<input id="searchKey3" maxlength="20" class="treeSearchInput" style="width: 200px;" onfocus="this.select();" title="匹配部门名称、人员姓名">&nbsp;');
		sb.append('<input type="button" id="search_but3" value="搜 索" onclick="searchTree(3)" class="treeSearchButton">');
		sb.append('</div>');
	}
	else {
		sb.append('<div id="searchDiv3" style="position: relative; float: right; text-align: right; width: 290px; padding-top:2px; padding-right:19px; color: #333333; z-index: 255;">');
		sb.append('<input id="searchKey3" maxlength="20" class="treeSearchInput" style="width: 200px;" onfocus="this.select();" title="匹配部门名称、人员姓名">&nbsp;');
		sb.append('<input type="button" id="search_but3" value="搜 索" onclick="searchTree(3)" class="treeSearchButton">');
		sb.append('</div>');
		$('#orgUserDiv').css('position', 'absolute');
	}
	$('#orgUserDiv').parent().prepend(sb.toString());
	$("#searchKey3").bind("keydown", function(e) {
		try {
			if (e.keyCode == 13) {
				searchTree(3);
				event.returnValue = false;
			}
		}
		catch (err) {};
	});
	
	if (userManageOrgId == "0") {
		var sb = new StringBuffer();
		if (IE && IE_VERSION <= 9) {
			sb.append('<div id="searchDiv4" style="position: relative; float: right; text-align: right; width: 290px; padding-top:1px; padding-right:19px; color: #333333; z-index: 255;">');
			sb.append('<input id="searchKey4" maxlength="20" class="treeSearchInput" style="width: 200px;" onfocus="this.select();" title="匹配虚拟岗位名称、拼音">&nbsp;');
			sb.append('<input type="button" id="search_but4" value="搜 索" onclick="searchTree(4)" class="treeSearchButton">');
			sb.append('</div>');
		}
		else {
			sb.append('<div id="searchDiv4" style="position: relative; float: right; text-align: right; width: 290px; padding-top:2px; padding-right:19px; color: #333333; z-index: 255;">');
			sb.append('<input id="searchKey4" maxlength="20" class="treeSearchInput" style="width: 200px;" onfocus="this.select();" title="匹配虚拟岗位名称、拼音">&nbsp;');
			sb.append('<input type="button" id="search_but4" value="搜 索" onclick="searchTree(4)" class="treeSearchButton">');
			sb.append('</div>');
			$('#posDiv').css('position', 'absolute');
		}
		$('#posDiv').parent().prepend(sb.toString());
		$("#searchKey4").bind("keydown", function(e) {
			try {
				if (e.keyCode == 13) {
					searchTree(4);
					event.returnValue = false;
				}
			}
			catch (err) {};
		});
	}
	
	messageTdObject = $('#messageTd')[0];
	$("#saveBotton").hide();
	loadOrgTree();
	
	$.ajax({
		url: contextPath + '/orgRoleAssign/queryList',
		type: 'POST',
		data: {}
	}).done(function(result) {
		if (result) {
			result = parseReturn(result);
			var tempArray = [];
			for (var i = 0; i < result.length; i++) {
				tempArray.push(result[i]['id']);
			}
			assignRoleIds = tempArray.join(",");
			var roleListTitle = $('body').find('div.panel-title');
			if (roleListTitle != null) {
				roleListTitle[0].innerHTML = "分配角色信息列表（共 " + result.length + " 条数据）";
			}
			$('#dg').datagrid({
				data: result
			});
		}
	});
	
	$('#tt').tabs({
		onSelect: function(title,index) { // 在点击的时候执行
			selectAssignType = index;
			if (index == 0) {
				loadOrgTree();
			}
			else if (index == 1) {
				loadOrgPosTree();
			}
			else if (index == 2) {
				loadOrgUserTree();
			}
			else if (index == 3) {
				showPosTree();
			}
		}
	});	
		 
	$('#orgTree').tree({
		onClick: function(node) { // 在点击的时候执行
			var nodeType = node['nodeType'];
			if (nodeType == "01" || nodeType == "02") {
				var loaded = node.loaded;
				if (loaded == "0") {
					loadExpandNodeOrg(node); // 异步加载子节点数据
				}
				else {
					if (node.children) { // 点击中间结点自动展开与折叠当前结点
						if (node.state == 'closed') {
							$(this).tree('expand', node.target);
						}
						else {
							$(this).tree('collapse', node.target);
						}
					}
				}
			}
			else {
				if (node.children) { // 点击中间结点自动展开与折叠当前结点
					if (node.state == 'closed') {
						$(this).tree('expand', node.target);
					}
					else {
						$(this).tree('collapse', node.target);
					}
				}
			}
			processRoleList(node);
		}
	});	
	
	$('#orgPosTree').tree({
		onClick: function(node) { // 点击结点事件
			var nodeType = node['nodeType'];
			if (nodeType == "01" || nodeType == "02") {
				var loaded = node.loaded;
				if (loaded == "0") {
					loadExpandNodeOrgPos(node); // 异步加载子节点数据
				}
				else {
					if (node.children) { // 点击中间结点自动展开与折叠当前结点
						if (node.state == 'closed') {
							$(this).tree('expand', node.target);
						}
						else {
							$(this).tree('collapse', node.target);
						}
					}
				}
			}
			else {
				if (node.children) { // 点击中间结点自动展开与折叠当前结点
					if (node.state == 'closed') {
						$(this).tree('expand', node.target);
					}
					else {
						$(this).tree('collapse', node.target);
					}
				}
			}
			processRoleList(node);
		}
	});
	
	$('#orgUserTree').tree({
		onClick: function(node) { // 点击结点事件
			var nodeType = node['nodeType'];
			if (nodeType == "01" || nodeType == "02") {
				var loaded = node.loaded;
				if (loaded == "0") {
					loadExpandNodeOrgUser(node); // 异步加载子节点数据
				}
				else {
					if (node.children) { // 点击中间结点自动展开与折叠当前结点
						if (node.state == 'closed') {
							$(this).tree('expand', node.target);
						}
						else {
							$(this).tree('collapse', node.target);
						}
					}
				}
			}
			else {
				if (node.children) { // 点击中间结点自动展开与折叠当前结点
					if (node.state == 'closed') {
						$(this).tree('expand', node.target);
					}
					else {
						$(this).tree('collapse', node.target);
					}
				}
			}
			processRoleList(node);
		},
		onContextMenu: function(e, node) { // 鼠标右键事件
			e.preventDefault();
			var nodeType = node['nodeType'];
			if (nodeType == "01" || nodeType == "02") {
				var loaded = node.loaded;
				if (loaded == "0") {
					loadExpandNodeOrgUser(node); // 异步加载子节点数据
				}
				else {
					if (node.children) { // 点击中间结点自动展开与折叠当前结点
						if (node.state == 'closed') {
							$(this).tree('expand', node.target);
						}
						else {
							$(this).tree('collapse', node.target);
						}
					}
				}
			}
			else {
				if (node.children) { // 点击中间结点自动展开与折叠当前结点
					if (node.state == 'closed') {
						$(this).tree('expand', node.target);
					}
					else {
						$(this).tree('collapse', node.target);
					}
				}
			}
			processRoleList(node);
			$(this).tree('select', node.target);
			treeNodeContextMethod(e, node);
		}
	});

	$("#saveBotton").bind("click",function() {
		var bottonObject = this;
		if (buttonDisabled(bottonObject) == false) {
			return false;
		}	
		topMessager.confirm('', '您是否要保存当前的数据？', function(r) {
			if (r) {
				var selections = $('#dg').datagrid('getSelections');
				var roleIdArray = [];
				var deleteRoleIdArray = assignRoleIds.split(",");
				if (selections.length > 0) {
					for (var i = 0; i < selections.length; i++) {
						var tempID = "" + selections[i]['id'];
						roleIdArray.push(tempID);
						for (var j = 0; j < deleteRoleIdArray.length; j++) {
							if (deleteRoleIdArray[j] == tempID) {
								deleteRoleIdArray[j] = "";  // 去除选中的
								break;
							}
						}
					}
				}
				var deleteTempArray = [];
				for (var j = 0; j < deleteRoleIdArray.length; j++) {
					if (deleteRoleIdArray[j] != "") {
						deleteTempArray.push(deleteRoleIdArray[j]);
					}
				}
				$('#assignType').val((selectAssignType + 1));
				$('#assignID').val(selectAssignID);
				$('#roleIds').val(roleIdArray.join(','));
				$('#deleteRoleIds').val(deleteTempArray.join(','));
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

function loadExpandNodeOrg(node) {
	var postData = {};
	postData['orgid'] = node['id'];
	$.ajax({
		url: contextPath + '/orgOrganization/expandNode',
		type: 'POST',
		data: postData
	}).done(function(result) {
		if (result) {
			result = parseReturn(result);
			$('#orgTree').tree('append', {
				parent: node.target,
				data: result
			});
		}
		var nodeText = node['text'];
		nodeText = nodeText.replace("◢", "");
		$('#orgTree').tree('update', {
			target: node.target,
			text: nodeText
		});
		node.loaded = "1";
	});
}

function loadExpandNodeOrgPos(node) {
	var postData = {};
	postData['orgid'] = node['id'];
	$.ajax({
		url: contextPath + '/orgPosAssignUser/expandNodePos',
		type: 'POST',
		data: postData
	}).done(function(result) {
		if (result) {
			result = parseReturn(result);
			$('#orgPosTree').tree('append', {
				parent: node.target,
				data: result
			});
		}
		var nodeText = node['text'];
		nodeText = nodeText.replace("◢", "");
		$('#orgPosTree').tree('update', {
			target: node.target,
			text: nodeText
		});
		node.loaded = "1";
	});
}

function loadExpandNodeOrgUser(node) {
	var postData = {};
	postData['orgid'] = node['id'];
	$.ajax({
		url: contextPath + '/orgOrgAssignUser/expandNode',
		type: 'POST',
		data: postData
	}).done(function(result) {
		if (result) {
			result = parseReturn(result);
			$('#orgUserTree').tree('append', {
				parent: node.target,
				data: result
			});
		}
		var nodeText = node['text'];
		nodeText = nodeText.replace("◢", "");
		$('#orgUserTree').tree('update', {
			target: node.target,
			text: nodeText
		});
		node.loaded = "1";
	});
}

function treeNodeContextMethod(e, nodeObject) {
	contextTreeNode = nodeObject;
	var nodeType = nodeObject['nodeType'];
	var nodeID = nodeObject['id'];
	if (nodeType == "user") {
		var showMenu = "menuUser";
		$('#' + showMenu).menu('show', { left: e.pageX, top: e.pageY} );
	}
}

function menuHandler(item) {
	var menuName = item.name;
	switch (menuName) {
		case "userView" :
			var nodeID = contextTreeNode['id'];
			nodeID = nodeID.substr(nodeID.indexOf('_') + 1);
			var dataOptions = {
				title: '查看人员信息',
				url: contextPath + '/orgUser/view?id=' + nodeID,
				width: 850,
				height: 420
			};
			openWindowNoSave(false, "", window, null, dataOptions, "", "", null);
			break;
	}    
}

function processRoleList(node) {
	var roleClearChecked = false;
	var nodeID = node['id'];
	var nodeType = node['nodeType'];
	if (nodeID == "ROOT") {
		roleClearChecked = true;
	}
	else {
		if (selectAssignType == 1) {
			if (nodeType == "01" || nodeType == "02") {
				roleClearChecked = true;
			}
		}
		else if (selectAssignType == 2) {
			if (nodeType == "01" || nodeType == "02") {
				roleClearChecked = true;
			}
		}
	}
	if (roleClearChecked) {
		roleClear();
	}
	else {
		$('#dg').datagrid('loading');
		$("#saveBotton").show();
		$('#dg').datagrid('clearChecked');
		var nodeText = node['text'];
		nodeText = nodeText.replace("◢", "");
		if (selectAssignType == 0) {
			var nodeTypeName = "";
			if (nodeType == "01") {
				nodeTypeName = "部门名称";
			}
			else {
				nodeTypeName = "工作组名称";
			}
			messageTdObject.innerHTML = nodeTypeName + '：' + nodeText;
		}
		else if (selectAssignType == 1) {
			messageTdObject.innerHTML = '实体岗位：' + nodeText;
		}
		else if (selectAssignType == 2) {
			messageTdObject.innerHTML = '人员姓名：' + nodeText;
		}
		else if (selectAssignType == 3) {
			messageTdObject.innerHTML = '虚拟岗位：' + nodeText;
		}
		var postData = {};
		if (selectAssignType == 2) {
			nodeID = nodeID.substr(nodeID.indexOf('_') + 1);
		}
		postData['assignType'] = selectAssignType + 1;
		postData['assignID'] = nodeID;
		selectAssignID = nodeID;
		$.ajax({
			url: contextPath + '/orgRoleAssign/queryRoleIds',
			type: 'POST',
			data: postData
		}).done(function(result) {
			if (result) {
				var dataArray = $('#dg').datagrid('getData').rows;
				if (dataArray.length > 0) {
					var roleIdArray  = result.split(",");
					for (var i = 0; i < dataArray.length; i++) {
						var roleID = "" + dataArray[i]['id'];
						var exist = false;
						for (var j = 0; j < roleIdArray.length; j++) {
							if (roleIdArray[j] == roleID) {
								exist = true;
								break;
							}
						}
						if (exist) {
							$('#dg').datagrid('selectRow', i);
						}
					}
				}
			}
			$('#dg').datagrid('loaded');
		});
	}
}

function roleClear() {
	$("#saveBotton").hide();
	$('#dg').datagrid('clearChecked');
	selectAssignID = "";
	messageTdObject.innerHTML = '';
}

function searchTree(searchNo) {
	var searchKeyObject = document.getElementById("searchKey" + searchNo);
	var searchKeyValue = searchKeyObject.value;
	searchKeyValue = searchKeyValue.replace(/(^\s*)|(\s*$)/g, "");
	searchKeyObject.value = searchKeyValue;
	if (searchKeyValue != "") {
		var treeObject;
		switch (searchNo) {
			case 1: {
				var treeObject = $('#orgTree');
				break;
			}
			case 2: {
				var treeObject = $('#orgPosTree');
				break;
			}
			case 3: {
				var treeObject = $('#orgUserTree');
				break;
			}
			case 4: {
				var treeObject = $('#posTree');
				break;
			}
		}
		if (searchNo == 1) {
			var url = contextPath + '/orgOrganization/queryOrgTreeSearchResult?rootid=' + userManageOrgId;
			var resultObject = treeObject.tree('serverSearchTreeNode', {searchKey:searchKeyValue.toUpperCase(), url: url});
			if (resultObject != null) {
				var parentPath = resultObject.parentPath;
				var tempArray = [];
				if (parentPath != "") {
					tempArray = parentPath.split(",");
				}
				tempArray.push(resultObject.id);
				var loadNode = null;
				var loadIdString = "";
				for (var i = 0; i < tempArray.length; i++) {
					var tempNode = treeObject.tree('find', tempArray[i]);
					if (tempNode != null) {
						var loaded = tempNode.loaded;
						if (loaded == "0") {
							loadNode = tempNode;
							for (var j = i; j < tempArray.length; j++) {
								loadIdString += tempArray[j] + ",";
							}
							if (loadIdString != "") {
								loadIdString = loadIdString.substring(0, loadIdString.length - 1);
							}
							break;
						}
					}
				}
				if (loadNode != null) {
					$.ajax({
						url: contextPath + '/orgOrganization/queryOrgTreeSearchLoadJson',
						type: 'POST',
						async: false,
						data: "loadIdString=" + loadIdString
					}).done(function(result) {
						if (result) {
							result = parseReturn(result);
							treeObject.tree('append', {
								parent: loadNode.target,
								data: result
							});
						}
						var nodeText = loadNode['text'];
						nodeText = nodeText.replace("◢", "");
						treeObject.tree('update', {
							target: loadNode.target,
							text: nodeText
						});
						loadNode.loaded = "1";
					});
				}
				var locateNode = treeObject.tree('find', resultObject.id);
				if (locateNode != null) {
					treeObject.tree('expandTo', locateNode.target);
					treeObject.tree('scrollTo', locateNode.target);
					treeObject.tree('select', locateNode.target);
				}
			}
			else {
				$.messager.show({
					title: '搜索结果',
					msg: '搜索无匹配的结果！',
					timeout: 1500,
					showType: 'show'
				});
			}
		}
		if (searchNo == 2) {
			var url = contextPath + '/orgOrganization/queryOrgTreeSearchResult?rootid=' + userManageOrgId;
			var resultObject = treeObject.tree('serverSearchTreeNode', {searchKey:searchKeyValue.toUpperCase(), url: url});
			if (resultObject != null) {
				var parentPath = resultObject.parentPath;
				var tempArray = [];
				if (parentPath != "") {
					tempArray = parentPath.split(",");
				}
				tempArray.push(resultObject.id);
				var loadNode = null;
				var loadIdString = "";
				for (var i = 0; i < tempArray.length; i++) {
					var tempNode = treeObject.tree('find', tempArray[i]);
					if (tempNode != null) {
						var loaded = tempNode.loaded;
						if (loaded == "0") {
							loadNode = tempNode;
							for (var j = i; j < tempArray.length; j++) {
								loadIdString += tempArray[j] + ",";
							}
							if (loadIdString != "") {
								loadIdString = loadIdString.substring(0, loadIdString.length - 1);
							}
							break;
						}
					}
				}
				if (loadNode != null) {
					$.ajax({
						url: contextPath + '/orgOrgAssignPos/queryOrgPosRealTreeSearchLoadJson',
						type: 'POST',
						async: false,
						data: "loadIdString=" + loadIdString
					}).done(function(result) {
						if (result) {
							result = parseReturn(result);
							treeObject.tree('append', {
								parent: loadNode.target,
								data: result
							});
						}
						var nodeText = loadNode['text'];
						nodeText = nodeText.replace("◢", "");
						treeObject.tree('update', {
							target: loadNode.target,
							text: nodeText
						});
						loadNode.loaded = "1";
					});
				}
				var locateNode = treeObject.tree('find', resultObject.id);
				if (locateNode != null) {
					treeObject.tree('expandTo', locateNode.target);
					treeObject.tree('scrollTo', locateNode.target);
					treeObject.tree('select', locateNode.target);
				}
			}
			else {
				$.messager.show({
					title: '搜索结果',
					msg: '搜索无匹配的结果！',
					timeout: 1500,
					showType: 'show'
				});
			}
		}
		if (searchNo == 3) {
			var url = contextPath + '/orgOrgAssignUser/queryOrgUserTreeSearchResult?rootid=' + userManageOrgId;
			var resultObject = treeObject.tree('serverSearchTreeNode', {searchKey:searchKeyValue.toUpperCase(), url: url});
			if (resultObject != null) {
				var parentPath = resultObject.parentPath;
				var tempArray = [];
				if (parentPath != "") {
					tempArray = parentPath.split(",");
				}
				tempArray.push(resultObject.id);
				var loadNode = null;
				var loadIdString = "";
				for (var i = 0; i < tempArray.length; i++) {
					var tempNode = treeObject.tree('find', tempArray[i]);
					if (tempNode != null) {
						var loaded = tempNode.loaded;
						if (loaded == "0") {
							loadNode = tempNode;
							for (var j = i; j < tempArray.length; j++) {
								if (tempArray[j].indexOf("_") == -1) { // 部门结点
									loadIdString += tempArray[j] + ",";
								}
							}
							if (loadIdString != "") {
								loadIdString = loadIdString.substring(0, loadIdString.length - 1);
							}
							break;
						}
					}
				}
				if (loadNode != null) {
					$.ajax({
						url: contextPath + '/orgOrgAssignUser/queryOrgUserTreeSearchLoadJson',
						type: 'POST',
						async: false,
						data: "loadIdString=" + loadIdString
					}).done(function(result) {
						if (result) {
							result = parseReturn(result);
							treeObject.tree('append', {
								parent: loadNode.target,
								data: result
							});
						}
						var nodeText = loadNode['text'];
						nodeText = nodeText.replace("◢", "");
						treeObject.tree('update', {
							target: loadNode.target,
							text: nodeText
						});
						loadNode.loaded = "1";
					});
				}
				var locateNode = treeObject.tree('find', resultObject.id);
				if (locateNode != null) {
					treeObject.tree('expandTo', locateNode.target);
					treeObject.tree('scrollTo', locateNode.target);
					treeObject.tree('select', locateNode.target);
				}
			}
			else {
				$.messager.show({
					title: '搜索结果',
					msg: '搜索无匹配的结果！',
					timeout: 1500,
					showType: 'show'
				});
			}
		}
		else if (searchNo == 4) {
	  		var node = treeObject.tree('searchTreeNode', {searchKey:searchKeyValue.toUpperCase(), onlyLeaf:false});
	   		if (node != null) {
				var locateNode = treeObject.tree('find', node['id']);
				treeObject.tree('expandTo', locateNode.target);
				treeObject.tree('scrollTo', locateNode.target);
				treeObject.tree('select', locateNode.target);
			}
			else {
				$.messager.show({
					title: '搜索结果',
					msg: '搜索无匹配的结果！',
					timeout: 1500,
					showType: 'show'
				});
			}
		}
	}
}

</script>  

</html>