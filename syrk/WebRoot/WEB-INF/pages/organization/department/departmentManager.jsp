<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<script type="text/javascript" >
var userManageOrgId = "${userManageOrgId}";
var treeObject = null; 
var contextTreeNode = null;

$(document).ready(function() {

	$("#searchKey").bind("keydown", function(e) {
		try {
			if (e.keyCode == 13) {
				searchTree();
				event.returnValue = false;
			}
		}
		catch (err) {};
	});
	if (IE && IE_VERSION <= 9) {
		$("#searchDiv").css('margin-right', '2px');
	}
	else {
		$("#searchDiv").css('margin-right', '20px');
		$("#searchDiv").css('padding-top', '2px');
	}

	$('#editTree').tree({
		data: ${treeJson},
		
		onClick: function(node) { // 点击结点事件
			if (node.children) { // 点击中间结点自动展开与折叠当前结点
				if (node.state == 'closed') {
					$(this).tree('expand', node.target);
				}
				else {
					$(this).tree('collapse', node.target);
				}
			}
		},
		
		onContextMenu: function(e, node) { // 鼠标右键事件
			e.preventDefault();
			$(this).tree('select', node.target);
			treeNodeContextMethod(e, node);
		}	
			
	});
	
	treeObject = $('#editTree');
});

function treeNodeContextMethod(e, nodeObject) {
	contextTreeNode = nodeObject;
	var nodeType = nodeObject['nodeType'];
	var nodeID = nodeObject['id'];
	var showMenu = "";
	if (nodeType == "0") { // 系统管理员根结点
		showMenu = "menu00";
	}
	else {
 		if (nodeID == userManageOrgId) { // 部门管理员
 			if (nodeType == "01") {
 				showMenu = "menu01";
 			}
 			else {
 				showMenu = "menu02";
 			}
 		}
 		else {
 			if (nodeType == "01") {
 				showMenu = "menu1";
 			}
 			else {
 				showMenu = "menu2";
 			}
 		}
	}
	if (showMenu != "") {
		$('#' + showMenu).menu('show', { left: e.pageX, top: e.pageY} );
	}
}

function menuHandler(item) {
	var menuName = item.name;
	switch (menuName) {    
		case "addOrg" :
			var parentid = contextTreeNode['id'];
			if (parentid == "ROOT") {
				parentid = "0";
			}
			var dataOptions = {
				title: '新增部门',
				url: contextPath + '/orgOrganization/add?parentid=' + parentid + "&orgtype=01",
				width: 850,
				height: 420
			};
			openWindowWithSave(false, "", window, null, dataOptions, "", "onAddOrgSuccess", null);
			break;
		case "addWorkGroup" :
			var parentid = contextTreeNode['id'];
			if (parentid == "ROOT") {
				parentid = "0";
			}
			var dataOptions = {
				title: '新增工作组',
				url: contextPath + '/orgOrganization/add?parentid=' + parentid + "&orgtype=02",
				width: 850,
				height: 420
			};
			openWindowWithSave(false, "", window, null, dataOptions, "", "onAddOrgSuccess", null);
			break;
		case "edit" :
			var nodeType = contextTreeNode['nodeType'];
			var winTitle = "";
			if (nodeType == "01") {
				winTitle = "修改部门";
			}
			else {
				winTitle = "修改工作组";
			}
			var dataOptions = {
				title: winTitle,
				url: contextPath + '/orgOrganization/edit?id=' + contextTreeNode['id'],
				width: 850,
				height: 420
			};
			openWindowWithSave(false, "", window, null, dataOptions, "", "onEditOrgSuccess", null);
			break;
		case "delete" :
			var nodeType = contextTreeNode['nodeType'];
			var nodeName = contextTreeNode['text'];
			var nodeTypeName = "";
			if (nodeType == "01") {
				nodeTypeName = "部门";
			}
			else {
				nodeTypeName = "工作组";
			}
			var submitConfirm = "您是否要删除该" + nodeTypeName + "：<br/><br/><font color='red'>" + contextTreeNode.text + "？</font><br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（注意：所有的下属单位都将被删除！）";
			topMessager.confirm('', submitConfirm, function(r) {
				if (r) {
					var postData = {};
					postData['id'] = contextTreeNode['id'];
					$.ajax({
						url: contextPath + '/orgOrganization/delete',
						type: 'POST',
						data: postData
					}).done(function(result) {
						result = parseReturn(result);
						if (result.status == 'success') {
							topMessager.show({
								title: MESSAGER_TITLE,
								msg: result.message,
								timeout:1500
							});
							onDeleteSaveOrgSuccess();
						}
						else {
							topMessager.alert('', result.message, 'error');
						}
					});				
				}
			});
			break;
		case "moveUp" :
			var nodeID = contextTreeNode['id'];
			var nodeType = contextTreeNode['nodeType'];
			var nodeTypeName = "";
			if (nodeType == "01") {
				nodeTypeName = "部门";
			}
			else {
				nodeTypeName = "工作组";
			}
			var cycleNo = 0;
			var moveExchangeNode = null;
   			var moveExchangeID = "";
			var parentNode = treeObject.tree('getParent', contextTreeNode.target);
			var cNodes = parentNode.children;
			for (var i = 0; i < cNodes.length; i++) {
				var cNode = cNodes[i];
				if (cNode['id'] == nodeID) {
					break;
				}
				else {
					if (cNode['nodeType'] == nodeType) {
	         			cycleNo++;
	         			moveExchangeID = cNode['id'];
	         			moveExchangeNode = cNode;
		  			}
	   			} 
   			}
			if (cycleNo == 0) {
				topMessager.alert('', '该' + nodeTypeName + '无需上移！', 'error');
				return;
			}
			var postData = {};
			postData['id'] = nodeID;
			postData['exchangeid'] = moveExchangeID;
			$.ajax({
				url: contextPath + '/orgOrganization/moveSave',
				type: 'POST',
				data: postData
			}).done(function(result) {
				result = parseReturn(result);
				if (result.status == 'success') {
					onMoveSaveOrgSuccess('1', moveExchangeNode);
				}
				else {
					topMessager.alert('', result.message, 'error');
				}
			});
			break;
		case "moveDown" :
			var nodeID = contextTreeNode['id'];
			var nodeType = contextTreeNode['nodeType'];
			var nodeTypeName = "";
			if (nodeType == "01") {
				nodeTypeName = "部门";
			}
			else {
				nodeTypeName = "工作组";
			}
			var cycleNo = 0;
			var moveExchangeNode = null;
   			var moveExchangeID = "";
			var parentNode = treeObject.tree('getParent', contextTreeNode.target);
			var cNodes = parentNode.children;
			for (var i = cNodes.length - 1; i >= 0; i--) {
				var cNode = cNodes[i];
				if (cNode['id'] == nodeID) {
					break;
				}
				else {
					if (cNode['nodeType'] == nodeType) {
	         			cycleNo++;
	         			moveExchangeID = cNode['id'];
	         			moveExchangeNode = cNode;
		  			}
	   			} 
   			}
			if (cycleNo == 0) {
				topMessager.alert('', '该' + nodeTypeName + '无需下移！', 'error');
				return;
			}
			var postData = {};
			postData['id'] = nodeID;
			postData['exchangeid'] = moveExchangeID;
			$.ajax({
				url: contextPath + '/orgOrganization/moveSave',
				type: 'POST',
				data: postData
			}).done(function(result) {
				result = parseReturn(result);
				if (result.status == 'success') {
					onMoveSaveOrgSuccess('2', moveExchangeNode);
				}
				else {
					topMessager.alert('', result.message, 'error');
				}
			});
			break;
		case "editBizRelation" :
			var nodeType = contextTreeNode['nodeType'];
			var winTitle = "指定上级业务部门";
			var dataOptions = {
				title: winTitle,
				url: contextPath + '/orgOrganization/bizRelationEdit?id=' + contextTreeNode['id'],
				width: 850,
				height: 320
			};
			openWindowWithSave(false, "", window, null, dataOptions, "", "", null);
			break;
	}
}

// 新增保存后事件
function onAddOrgSuccess(oldPageObject, submitData) {
	var insertData = {};
	insertData['id'] = submitData['saveID'];
	insertData['text'] = submitData['orgname'];
	insertData['nodeType'] = submitData['orgtype'];
	if (submitData['orgtype'] == "01") {
		insertData['iconCls'] = "tree-org";
	} 
	else {
		insertData['iconCls'] = "tree-workgroup";
	}
	if (contextTreeNode.children && submitData['orgtype'] == "01") {
		var cNodes = contextTreeNode.children;
		var beforeNodeID = null;
		for (var i = 0; i < cNodes.length; i++) {
			var cNode = cNodes[i];
			if (cNode['nodeType'] == '02') {
				beforeNodeID = cNode['id'];
				break;
			}
		}
		if (beforeNodeID != null) {
			var locateNode = treeObject.tree('find', beforeNodeID);
			treeObject.tree('insert', {
				before: locateNode.target,
				data: [insertData]
			});
		}
		else {
			treeObject.tree('append', {
				parent: contextTreeNode.target,
				data: [insertData]
			});
		}
	}
	else {
		treeObject.tree('append', {
			parent: contextTreeNode.target,
			data: [insertData]
		});
	}
	var locateNode = treeObject.tree('find', submitData['saveID']);
	treeObject.tree('expandTo', locateNode.target);
	treeObject.tree('scrollTo', locateNode.target);
	treeObject.tree('select', locateNode.target);
}

// 修改保存后事件
function onEditOrgSuccess(oldPageObject, submitData) {
	treeObject.tree('update', {
		target: contextTreeNode.target,
		text: submitData['orgname']
	});
}

// 删除保存后事件
function onDeleteSaveOrgSuccess() {
	treeObject.tree('remove', contextTreeNode.target);
}

// 上移下移保存后事件
function onMoveSaveOrgSuccess(upDown, moveExchangeNode) {
	var locateNode = treeObject.tree('find', moveExchangeNode['id']);
	var popData = treeObject.tree('pop', locateNode.target);
	if (upDown == "1") {
		treeObject.tree('insert', {
			after: contextTreeNode.target,
			data: popData
		});		
	}
	else {
		treeObject.tree('insert', {
			before: contextTreeNode.target,
			data: popData
		});		
	}
}

function searchTree() {
	var searchKeyValue = document.getElementById("searchKey").value;
	searchKeyValue = searchKeyValue.replace(/(^\s*)|(\s*$)/g, "");
	document.getElementById("searchKey").value = searchKeyValue;
	if (searchKeyValue != "") {
		var treeObject = $('#editTree');
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

</script>

</HEAD>
<body class="easyui-layout" data-options="fit:true" oncontextmenu="return false;">  

    <div id="searchDiv" style="position: relative; float: right; width: 290px; padding-top:1px; text-align: right; color: #333333; z-index:255;">
		<input id="searchKey" maxlength="20" class="treeSearchInput" style="width: 200px;" onfocus="this.select();" title="匹配部门名称、部门代码、部门拼音"> 
		<input type="button" id="search_but" value="搜 索" onclick="searchTree()" class="treeSearchButton">
	</div>

    <div data-options="region:'center',border:false" style="padding:2px;">
    	<ul class="easyui-tree" id="editTree" data-options="method:'get',lines:true,onlyLeaf:false"></ul>
    	<div style="height: 36px;"></div>
    </div>
    
    <div id="menu00" class="easyui-menu" data-options="onClick:menuHandler" style="width: 220px; display: none;">
		<div data-options="name:'addOrg',iconCls: 'icon-add'">新增部门</div>
	</div>
	
    <div id="menu01" class="easyui-menu" data-options="onClick:menuHandler" style="width: 220px; display: none;">
		<div data-options="name:'addOrg',iconCls: 'icon-add'">新增部门</div>
		<div data-options="name:'addWorkGroup',iconCls: 'icon-add'">新增工作组</div>
		<div class="menu-sep"></div>
		<div data-options="name:'edit',iconCls: 'icon-edit'">修改</div>
		<div class="menu-sep"></div>
		<div data-options="name:'editBizRelation',iconCls: 'icon-choose'">指定上级业务部门</div>
	</div>

    <div id="menu02" class="easyui-menu" data-options="onClick:menuHandler" style="width: 220px; display: none;">
		<div data-options="name:'addWorkGroup',iconCls: 'icon-add'">新增工作组</div>
		<div class="menu-sep"></div>
		<div data-options="name:'edit',iconCls: 'icon-edit'">修改</div>
		<div class="menu-sep"></div>
		<div data-options="name:'editBizRelation',iconCls: 'icon-choose'">指定上级业务部门</div>
	</div>

	<div id="menu1" class="easyui-menu" data-options="onClick:menuHandler" style="width: 220px; display: none;">
		<div data-options="name:'addOrg',iconCls: 'icon-add'">新增部门</div>
		<div data-options="name:'addWorkGroup',iconCls: 'icon-add'">新增工作组</div>
		<div class="menu-sep"></div>
		<div data-options="name:'edit',iconCls: 'icon-edit'">修改</div>
		<div data-options="name:'delete',iconCls: 'icon-cancel'">删除</div>
		<div class="menu-sep"></div>
		<div data-options="name:'moveUp',iconCls: 'icon-moveUp'">上移</div>
		<div data-options="name:'moveDown',iconCls: 'icon-moveDown'">下移</div>
		<div class="menu-sep"></div>
		<div data-options="name:'editBizRelation',iconCls: 'icon-choose'">指定上级业务部门</div>
	</div>
    
	<div id="menu2" class="easyui-menu" data-options="onClick:menuHandler" style="width: 220px; display: none;">
		<div data-options="name:'addWorkGroup',iconCls: 'icon-add'">新增工作组</div>
		<div class="menu-sep"></div>
		<div data-options="name:'edit',iconCls: 'icon-edit'">修改</div>
		<div data-options="name:'delete',iconCls: 'icon-cancel'">删除</div>
		<div class="menu-sep"></div>
		<div data-options="name:'moveUp',iconCls: 'icon-moveUp'">上移</div>
		<div data-options="name:'moveDown',iconCls: 'icon-moveDown'">下移</div>
		<div class="menu-sep"></div>
		<div data-options="name:'editBizRelation',iconCls: 'icon-choose'">指定上级业务部门</div>
	</div>

</body>    
</HTML>

