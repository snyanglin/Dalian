<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<script type="text/javascript" >
var userManageOrgId = "${userManageOrgId}";
var userManageOrgCode = "${userManageOrgCode}";
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
			var nodeType = node['nodeType'];
			if (nodeType == "01" || nodeType == "02" || nodeType == "pos") {
				var loaded = node.loaded;
				if (loaded == "0") {
					if (nodeType == "pos") {
						loadExpandNodeUser(node); // 异步加载子节点数据
					}
					else {
						loadExpandNode(node); // 异步加载子节点数据
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
		},
		
		onContextMenu: function(e, node) { // 鼠标右键事件
			e.preventDefault();
			var nodeType = node['nodeType'];
			if (nodeType == "01" || nodeType == "02" || nodeType == "pos") {
				var loaded = node.loaded;
				if (loaded == "0") {
					if (nodeType == "pos") {
						loadExpandNodeUser(node); // 异步加载子节点数据
					}
					else {
						loadExpandNode(node); // 异步加载子节点数据
					}
				}
				else {
					if (node.children) { // 点击中间结点自动展开与折叠当前结点
						if (node.state == 'closed') {
							$(this).tree('expand', node.target);
						}
					}
				}
			}
			else {
				if (node.children) { // 点击中间结点自动展开与折叠当前结点
					if (node.state == 'closed') {
						$(this).tree('expand', node.target);
					}
				}
			}			
			$(this).tree('select', node.target);
			treeNodeContextMethod(e, node);
		}	
			
	});
	
	treeObject = $('#editTree');

});

function loadExpandNode(node) {
	var postData = {};
	postData['orgid'] = node['id'];
	$.ajax({
		url: contextPath + '/orgPosAssignUser/expandNode',
		type: 'POST',
		data: postData
	}).done(function(result) {
		if (result) {
			result = parseReturn(result);
			treeObject.tree('append', {
				parent: node.target,
				data: result
			});
		}
		var nodeText = node['text'];
		nodeText = nodeText.replace("◢", "");
		treeObject.tree('update', {
			target: node.target,
			text: nodeText
		});
		node.loaded = "1";
	});
}

function loadExpandNodeUser(node) {
	var postData = {};
	postData['posid'] = node['id'];
	$.ajax({
		url: contextPath + '/orgPosAssignUser/expandNodeUser',
		type: 'POST',
		data: postData
	}).done(function(result) {
		if (result) {
			result = parseReturn(result);
			treeObject.tree('append', {
				parent: node.target,
				data: result
			});
		}
		var nodeText = node['text'];
		nodeText = nodeText.replace("◢", "");
		treeObject.tree('update', {
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
	var showMenu = "";
	if (nodeType == "pos") {
		showMenu = "menuPos";
	}
	else if (nodeType == "user") {
		showMenu = "menuUser";
	}
	if (showMenu != "") {
		$('#' + showMenu).menu('show', { left: e.pageX, top: e.pageY} );
	}
}

function menuHandler(item) {
	var menuName = item.name;
	switch (menuName) {    
		case "posAssign" :
			var parentNode = treeObject.tree('getParent', contextTreeNode.target);
			var initFocusOrgCode = parentNode['bizID'];
			if (contextTreeNode.children) {
				var userIDArray = [];
				var cNodes = contextTreeNode.children;
				for (var i = 0; i < cNodes.length; i++) {
					var cNode = cNodes[i]; 
					var nodeID = cNode['id'];
					nodeID = nodeID.substr(nodeID.indexOf('_') + 1);
					userIDArray.push(nodeID);
   				}
   				$('#assignUserID').val(userIDArray.join(","));
			}
			else {
				$('#assignUserID').val('');
			}
			$('#assignUserName').val('');
			var dialogTitle = '岗位指定人员：' + contextTreeNode['text'] + '【' + parentNode['text'] +'】';
			public_multiSelectOrgUser(userManageOrgCode, '', '', '', '', initFocusOrgCode, '', 'assignUserName', 'assignUserID', '', '', '', false, '', window, 'posAssignSubmit', dialogTitle);
			break;
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
		case "delete" :
			var nodeType = contextTreeNode['nodeType'];
			var nodeName = contextTreeNode['text'];
			var nodeTypeName = "人员";
			var parentNode = treeObject.tree('getParent', contextTreeNode.target);
			var parentNodeType = parentNode['nodeType'];
			var submitConfirm = "您是否要从岗位中移除该" + nodeTypeName + "：<br/><br/><font color='red'>" + contextTreeNode.text + "？</font>";
			topMessager.confirm('', submitConfirm, function(r) {
				if (r) {
					var postData = {};
					var nodeID = contextTreeNode['id'];
					nodeID = nodeID.substr(nodeID.indexOf('_') + 1);
					postData['posid'] = parentNode['id'];
					postData['userid'] = nodeID;
					$.ajax({
						url: contextPath + '/orgPosAssignUser/delete',
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
							onDeleteSaveSuccess(nodeID);
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
			var nodeTypeName = "人员";
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
			postData['posid'] = parentNode['id'];
			postData['id'] = nodeID.substr(nodeID.indexOf('_') + 1);
			postData['exchangeid'] = moveExchangeID.substr(moveExchangeID.indexOf('_') + 1);
			$.ajax({
				url: contextPath + '/orgPosAssignUser/moveSave',
				type: 'POST',
				data: postData
			}).done(function(result) {
				result = parseReturn(result);
				if (result.status == 'success') {
					onMoveSaveSuccess('1', moveExchangeNode);
				}
				else {
					topMessager.alert('', result.message, 'error');
				}
			});
			break;
		case "moveDown" :
			var nodeID = contextTreeNode['id'];
			var nodeType = contextTreeNode['nodeType'];
			var nodeTypeName = "人员";
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
			postData['posid'] = parentNode['id'];
			postData['id'] = nodeID.substr(nodeID.indexOf('_') + 1);
			postData['exchangeid'] = moveExchangeID.substr(moveExchangeID.indexOf('_') + 1);
			$.ajax({
				url: contextPath + '/orgPosAssignUser/moveSave',
				type: 'POST',
				data: postData
			}).done(function(result) {
				result = parseReturn(result);
				if (result.status == 'success') {
					onMoveSaveSuccess('2', moveExchangeNode);
				}
				else {
					topMessager.alert('', result.message, 'error');
				}
			});
			break;
	}
}

// 岗位指定人员提交
function posAssignSubmit() {
	var nodeID = contextTreeNode['id'];
	var postData = {};
	postData['posid'] = contextTreeNode['id'];
	postData['assignUserID'] = $('#assignUserID').val();
	postData['assignUserName'] = $('#assignUserName').val();
	$.ajax({
		url: contextPath + '/orgPosAssignUser/assignSave',
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
			onPosAssignSaveSuccess(null, result);
		}
		else {
			topMessager.alert('', result.message, 'error');
		}
	});
}

// 工作组指定人员保存后事件
function onPosAssignSaveSuccess(oldPageObject, submitData) {
	if (contextTreeNode.children) {
		var cNodes = contextTreeNode.children;
		for (var i = cNodes.length - 1; i >= 0; i--) {
			var cNode = cNodes[i];
			var nodeID = cNode['id'];
			var nodeType = cNode['nodeType'];
			if (nodeType == "user") {
				var locateNode = treeObject.tree('find', nodeID);
				treeObject.tree('remove', locateNode.target);
			}
		}
	}
	var userData = submitData['user'];
	if (userData && userData.length > 0) {
		var nodeID = contextTreeNode['id'];
		var insertData = [];
		for (var i = 0; i < userData.length; i++) {
			var nodeData = {};
			nodeData['id'] = nodeID + "_" + userData[i]['id'];
			nodeData['text'] = userData[i]['username'];
			nodeData['nodeType'] = "user";
			nodeData['iconCls'] = "tree-user";
			insertData.push(nodeData);
		}
		treeObject.tree('append', {
			parent: contextTreeNode.target,
			data: insertData
		});
	}
}

// 删除保存后事件
function onDeleteSaveSuccess(parentNodeType, userID) {
	treeObject.tree('remove', contextTreeNode.target);
}

// 上移下移保存后事件
function onMoveSaveSuccess(upDown, moveExchangeNode) {
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
					url: contextPath + '/orgPosAssignUser/queryOrgPosUserTreeSearchLoadJson',
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
}

</script>

</HEAD>
<body class="easyui-layout" data-options="fit:true" oncontextmenu="return false;">  

    <div id="searchDiv" style="position: relative; float: right; width: 290px; padding-top:1px; text-align: right; color: #333333; z-index:255;">
		<input id="searchKey" maxlength="20" class="treeSearchInput" style="width: 200px;" onfocus="this.select();" title="匹配部门名称"> 
		<input type="button" id="search_but" value="搜 索" onclick="searchTree()" class="treeSearchButton">
	</div>

    <div data-options="region:'center',border:false" style="padding:2px;">
    	<ul class="easyui-tree" id="editTree" data-options="method:'get',lines:true,searchServer:true"></ul>
    	<div style="height: 36px;"></div>
    </div>
    
    <div id="menuPos" class="easyui-menu" data-options="onClick:menuHandler" style="width: 220px; display: none;">
		<div data-options="name:'posAssign',iconCls: 'icon-choose'">岗位指定人员</div>
	</div>

	<div id="menuUser" class="easyui-menu" data-options="onClick:menuHandler" style="width: 220px; display: none;">
		<div data-options="name:'userView',iconCls: 'icon-query'">查看人员信息</div>
		<div data-options="name:'delete',iconCls: 'icon-cancel'">移除人员</div>
		<div class="menu-sep"></div>
		<div data-options="name:'moveUp',iconCls: 'icon-moveUp'">上移</div>
		<div data-options="name:'moveDown',iconCls: 'icon-moveDown'">下移</div>
	</div>
	
	<div style="display: none;">
	<input type="hidden" id="assignUserID"/>
	<input type="hidden" id="assignUserName"/>
	</div>
    
</body>    
</HTML>

