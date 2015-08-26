<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<script type="text/javascript" >
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
			if (nodeType == "system" || nodeType == "menu1") {
				var loaded = node.loaded;
				if (loaded == "0") {
					if (nodeType == "system") {
						loadExpandNodeSystem(node); // 异步加载子节点数据
					}
					else {
						loadExpandNodeMenu(node); // 异步加载子节点数据
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
			if (nodeType == "system" || nodeType == "menu1") {
				var loaded = node.loaded;
				if (loaded == "0") {
					if (nodeType == "system") {
						loadExpandNodeSystem(node); // 异步加载子节点数据
					}
					else {
						loadExpandNodeMenu(node); // 异步加载子节点数据
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

function loadExpandNodeSystem(node) {
	var postData = {};
	postData['systemid'] = node['id'];
	$.ajax({
		url: contextPath + '/orgMenu/expandNodeSystem',
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

function loadExpandNodeMenu(node) {
	var postData = {};
	postData['parentid'] = node['id'];
	$.ajax({
		url: contextPath + '/orgMenu/expandNodeMenu',
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
	if (nodeType == "ROOT") {
		showMenu = "menuRoot";
	}
	else if (nodeType == "system") {
		showMenu = "menuSystem";
	}
	else if (nodeType == "menu1") {
		showMenu = "menu1";
	}
	else if (nodeType == "menu2") {
		showMenu = "menu2";
	}
	if (showMenu != "") {
		$('#' + showMenu).menu('show', { left: e.pageX, top: e.pageY} );
	}
}

function menuHandler(item) {
	var menuName = item.name;
	switch (menuName) {    
		case "addSystem" :
			var dataOptions = {
				title: '新增系统',
				url: contextPath + '/orgMenu/addSystem',
				width: 850,
				height: 420
			};
			openWindowWithSave(false, "", window, null, dataOptions, "", "onAddSystemSuccess", null);
			break;
		case "editSystem" :
			var dataOptions = {
				title: '修改系统',
				url: contextPath + '/orgMenu/editSystem?id=' + contextTreeNode['id'],
				width: 850,
				height: 420
			};
			openWindowWithSave(false, "", window, null, dataOptions, "", "onEditSystemSuccess", null);
			break;
		case "deleteSystem" :
			var submitConfirm = "您是否要删除系统：<br/><br/><font color='red'>" + contextTreeNode.text + "？</font><br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（注意：所有的下级菜单都将被删除！）";
			topMessager.confirm('', submitConfirm, function(r) {
				if (r) {
					var postData = {};
					var nodeID = contextTreeNode['id'];
					postData['id'] = nodeID;
					$.ajax({
						url: contextPath + '/orgMenu/deleteSystem',
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
							onDeleteSystemSuccess();
						}
						else {
							topMessager.alert('', result.message, 'error');
						}
					});				
				}
			});
			break;
		case "moveUpSystem" :
			var nodeID = contextTreeNode['id'];
			var nodeType = contextTreeNode['nodeType'];
			var nodeTypeName = "系统";
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
				url: contextPath + '/orgMenu/moveSaveSystem',
				type: 'POST',
				data: postData
			}).done(function(result) {
				result = parseReturn(result);
				if (result.status == 'success') {
					onMoveSaveSystemSuccess('1', moveExchangeNode);
				}
				else {
					topMessager.alert('', result.message, 'error');
				}
			});
			break;
		case "moveDownSystem" :
			var nodeID = contextTreeNode['id'];
			var nodeType = contextTreeNode['nodeType'];
			var nodeTypeName = "系统";
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
				url: contextPath + '/orgMenu/moveSaveSystem',
				type: 'POST',
				data: postData
			}).done(function(result) {
				result = parseReturn(result);
				if (result.status == 'success') {
					onMoveSaveSystemSuccess('2', moveExchangeNode);
				}
				else {
					topMessager.alert('', result.message, 'error');
				}
			});
			break;
		case "addMenuGroup" :
			var nodeID = contextTreeNode['id'];
			var nodeType = contextTreeNode['nodeType'];
			var systemid = "";
			var parentid = "";
			if (nodeType == "system") {
				systemid = nodeID;
				parentid = "0";
			}
			else {
				parentid = nodeID;
			}
			var dataOptions = {
				title: '新增菜单分组',
				url: contextPath + '/orgMenu/addMenu?menutype=1&systemid=' + systemid + '&parentid=' + parentid,
				width: 850,
				height: 420
			};
			openWindowWithSave(false, "", window, null, dataOptions, "", "onAddMenuSuccess", null);
			break;
		case "editMenuGroup" :
			var nodeID = contextTreeNode['id'];
			var nodeType = contextTreeNode['nodeType'];
			var dataOptions = {
				title: '修改菜单分组',
				url: contextPath + '/orgMenu/editMenu?id=' + nodeID,
				width: 850,
				height: 420
			};
			openWindowWithSave(false, "", window, null, dataOptions, "", "onEditMenuSuccess", null);
			break;
		case "addMenu" :
			var nodeID = contextTreeNode['id'];
			var nodeType = contextTreeNode['nodeType'];
			var systemid = "";
			var parentid = "";
			if (nodeType == "system") {
				systemid = nodeID;
				parentid = "0";
			}
			else {
				parentid = nodeID;
			}
			var dataOptions = {
				title: '新增菜单项',
				url: contextPath + '/orgMenu/addMenu?menutype=2&systemid=' + systemid + '&parentid=' + parentid,
				width: 850,
				height: 420
			};
			openWindowWithSave(false, "", window, null, dataOptions, "", "onAddMenuSuccess", null);
			break;
		case "editMenu" :
			var nodeID = contextTreeNode['id'];
			var nodeType = contextTreeNode['nodeType'];
			var dataOptions = {
				title: '修改菜单项',
				url: contextPath + '/orgMenu/editMenu?id=' + nodeID,
				width: 850,
				height: 420
			};
			openWindowWithSave(false, "", window, null, dataOptions, "", "onEditMenuSuccess", null);
			break;
		case "deleteMenu" :
			var nodeType = contextTreeNode['nodeType'];
			var nodeName = contextTreeNode['text'];
			var nodeTypeName = "";
			var submitConfirm = "";
			if (nodeType == "menu1") {
				nodeTypeName = "菜单分组";
				submitConfirm = "您是否要删除该" + nodeTypeName + "：<br/><br/><font color='red'>" + contextTreeNode.text + "？</font><br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（注意：所有的下级菜单都将被删除！）";
			}
			else {
				nodeTypeName = "菜单项";
				submitConfirm = "您是否要删除该" + nodeTypeName + "：<br/><br/><font color='red'>" + contextTreeNode.text + "？</font>";
			}
			topMessager.confirm('', submitConfirm, function(r) {
				if (r) {
					var postData = {};
					var nodeID = contextTreeNode['id'];
					postData['id'] = nodeID;
					postData['menutype'] = nodeType.substr(4);
					$.ajax({
						url: contextPath + '/orgMenu/deleteMenu',
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
							onDeleteSystemSuccess();
						}
						else {
							topMessager.alert('', result.message, 'error');
						}
					});				
				}
			});
			break;
		case "moveUpMenu" :
			var nodeID = contextTreeNode['id'];
			var nodeType = contextTreeNode['nodeType'];
			var nodeTypeName = "";
			if (nodeType == "menu1") {
				nodeTypeName = "菜单分组";
			}
			else {
				nodeTypeName = "菜单项";
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
				url: contextPath + '/orgMenu/moveSaveMenu',
				type: 'POST',
				data: postData
			}).done(function(result) {
				result = parseReturn(result);
				if (result.status == 'success') {
					onMoveSaveSystemSuccess('1', moveExchangeNode);
				}
				else {
					topMessager.alert('', result.message, 'error');
				}
			});
			break;
		case "moveDownMenu" :
			var nodeID = contextTreeNode['id'];
			var nodeType = contextTreeNode['nodeType'];
			var nodeTypeName = "";
			if (nodeType == "menu1") {
				nodeTypeName = "菜单分组";
			}
			else {
				nodeTypeName = "菜单项";
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
				url: contextPath + '/orgMenu/moveSaveMenu',
				type: 'POST',
				data: postData
			}).done(function(result) {
				result = parseReturn(result);
				if (result.status == 'success') {
					onMoveSaveSystemSuccess('2', moveExchangeNode);
				}
				else {
					topMessager.alert('', result.message, 'error');
				}
			});
			break;
	}
}

// 新增系统保存后事件
function onAddSystemSuccess(oldPageObject, submitData) {
	var insertData = {};
	insertData['id'] = submitData['saveID'];
	insertData['text'] = submitData['systemname'];
	insertData['nodeType'] = 'system';
	var iconClsUpdate = submitData['systemicon'];
	if ("undefined" == typeof iconClsUpdate || iconClsUpdate == "") {
		iconClsUpdate = "icon-favorite";
	}
	insertData['iconCls'] = iconClsUpdate;
	treeObject.tree('append', {
		parent: contextTreeNode.target,
		data: [insertData]
	});
	var locateNode = treeObject.tree('find', submitData['saveID']);
	treeObject.tree('expandTo', locateNode.target);
	treeObject.tree('scrollTo', locateNode.target);
	treeObject.tree('select', locateNode.target);
}

// 修改系统保存后事件
function onEditSystemSuccess(oldPageObject, submitData) {
	var iconClsUpdate = submitData['systemicon'];
	if ("undefined" == typeof iconClsUpdate || iconClsUpdate == "") {
		iconClsUpdate = "icon-favorite";
	}
	treeObject.tree('update', {
		target: contextTreeNode.target,
		text: submitData['systemname'],
		iconCls: iconClsUpdate
	});
}

// 删除系统保存后事件
function onDeleteSystemSuccess() {
	treeObject.tree('remove', contextTreeNode.target);
}

// 上移下移系统保存后事件
function onMoveSaveSystemSuccess(upDown, moveExchangeNode) {
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

//  新增菜单保存后事件
function onAddMenuSuccess(oldPageObject, submitData) {
	var insertData = {};
	insertData['id'] = submitData['saveID'];
	insertData['text'] = submitData['menuname'];
	insertData['nodeType'] = 'menu' + submitData['menutype'];
	var iconClsUpdate = submitData['menuicon'];
	if ("undefined" == typeof iconClsUpdate || iconClsUpdate == "") {
		if (submitData['menutype'] == "1") {
			insertData['iconCls'] = "tree-org";
		}
		else {
			insertData['iconCls'] = "tree-leaf";
		}
	}
	else {
		insertData['iconCls'] = iconClsUpdate;
	}
	if (contextTreeNode.children && submitData['menutype'] == "1") {
		var cNodes = contextTreeNode.children;
		var beforeNodeID = null;
		for (var i = 0; i < cNodes.length; i++) {
			var cNode = cNodes[i];
			if (cNode['nodeType'] == 'menu2') {
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

// 修改菜单保存后事件
function onEditMenuSuccess(oldPageObject, submitData) {
	var iconClsUpdate = submitData['menuicon'];
	if ("undefined" == typeof iconClsUpdate || iconClsUpdate == "") {
		if (submitData['menutype'] == "1") {
			iconClsUpdate = "tree-org";
		}
		else {
			iconClsUpdate = "tree-leaf";
		}
	}
	treeObject.tree('update', {
		target: contextTreeNode.target,
		text: submitData['menuname'],
		iconCls: iconClsUpdate
	});
}

// 删除菜单保存后事件
function onDeleteMenuSuccess() {
	treeObject.tree('remove', contextTreeNode.target);
}

// 上移下移菜单保存后事件
function onMoveSaveMenuSuccess(upDown, moveExchangeNode) {
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
		var url = contextPath + '/orgMenu/queryMenuTreeSearchResult';
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
				var findId = tempArray[i];
				if (findId.indexOf("_") != -1) {
					findId = findId.substring(0, findId.indexOf("_"));	
				}
				var tempNode = treeObject.tree('find', findId);
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
					url: contextPath + '/orgMenu/queryMenuTreeSearchLoadJson',
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
		<input id="searchKey" maxlength="20" class="treeSearchInput" style="width: 200px;" onfocus="this.select();" title="匹配菜单名称"> 
		<input type="button" id="search_but" value="搜 索" onclick="searchTree()" class="treeSearchButton">
	</div>

    <div data-options="region:'center',border:false" style="padding:2px;">
    	<ul class="easyui-tree" id="editTree" data-options="method:'get',lines:true,searchServer:true"></ul>
    	<div style="height: 36px;"></div>
    </div>

    <div id="menuRoot" class="easyui-menu" data-options="onClick:menuHandler" style="width: 220px; display: none;">
		<div data-options="name:'addSystem',iconCls: 'icon-add'">新增系统</div>
	</div>
	    
    <div id="menuSystem" class="easyui-menu" data-options="onClick:menuHandler" style="width: 220px; display: none;">
		<div data-options="name:'addMenuGroup',iconCls: 'icon-add'">新增菜单分组</div>
		<div data-options="name:'addMenu',iconCls: 'icon-add'">新增菜单项</div>
		<div class="menu-sep"></div>
		<div data-options="name:'editSystem',iconCls: 'icon-edit'">修改</div>
		<div data-options="name:'deleteSystem',iconCls: 'icon-cancel'">删除</div>
		<div class="menu-sep"></div>
		<div data-options="name:'moveUpSystem',iconCls: 'icon-moveUp'">上移</div>
		<div data-options="name:'moveDownSystem',iconCls: 'icon-moveDown'">下移</div>
	</div>

	<div id="menu1" class="easyui-menu" data-options="onClick:menuHandler" style="width: 220px; display: none;">
		<div data-options="name:'addMenuGroup',iconCls: 'icon-add'">新增菜单分组</div>
		<div data-options="name:'addMenu',iconCls: 'icon-add'">新增菜单项</div>
		<div class="menu-sep"></div>
		<div data-options="name:'editMenuGroup',iconCls: 'icon-edit'">修改</div>
		<div data-options="name:'deleteMenu',iconCls: 'icon-cancel'">删除</div>
		<div class="menu-sep"></div>
		<div data-options="name:'moveUpMenu',iconCls: 'icon-moveUp'">上移</div>
		<div data-options="name:'moveDownMenu',iconCls: 'icon-moveDown'">下移</div>
	</div>
	
	<div id="menu2" class="easyui-menu" data-options="onClick:menuHandler" style="width: 220px; display: none;">
		<div data-options="name:'editMenu',iconCls: 'icon-edit'">修改</div>
		<div data-options="name:'deleteMenu',iconCls: 'icon-cancel'">删除</div>
		<div class="menu-sep"></div>
		<div data-options="name:'moveUpMenu',iconCls: 'icon-moveUp'">上移</div>
		<div data-options="name:'moveDownMenu',iconCls: 'icon-moveDown'">下移</div>
	</div>

</body>    
</HTML>

