<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>人员信息</title>
</head>
<body class="easyui-layout" data-options="fit:true">
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'west',split:true,title:'部门人员信息',border:false,collapsible:false" style="height:auto;width:500">
				<div class="easyui-layout" data-options="fit:true,border:false">

				    <div id="searchDiv" style="position: relative; float: right; width: 250px; padding-top:1px; text-align: right; color: #333333; z-index:255;">
						<input id="searchKey" maxlength="20" class="treeSearchInput" style="width: 160px;" onfocus="this.select();" title="匹配部门名称、人员姓名"> 
						<input type="button" id="search_but" value="搜 索" onclick="searchTree()" class="treeSearchButton">
					</div>

					<div data-options="region:'center',split:false,title:'',border:false,collapsible:false" style="padding: 5px; height: auto;">
						<ul class="easyui-tree" id="userTree" data-options="method:'get',lines:true,searchServer:true"></ul>
						<div style="height: 36px;"></div>
					</div>
					
					<div id="menuUser" class="easyui-menu" data-options="onClick:menuHandler" style="width: 220px; display: none;">
						<div data-options="name:'userView',iconCls: 'icon-query'">查看人员信息</div>
					</div>
					
				</div>
			</div>
			<div data-options="region:'center',split:false,title:'人员实际权限',border:false" style="height:auto; border-left: 1px solid #95B8E7;">
				<div class="easyui-layout" data-options="fit:true,border:false">
					<div data-options="region:'center',split:false,title:'',border:false,collapsible:false" style="padding: 5px; height: auto;">
						<div id="noRightDiv" style="display:none; padding: 4px;"><font style="font-weight: bold; color: #FF0000;">该用户无实际权限！</font></div>
						<div id="messageDiv" nowrap="nowrap" style="position:absolute; top: 8px; left: 100px; color: #0000FF;"></div>
						<ul class="easyui-tree" id="menuTree" data-options="method:'get',lines:true"></ul>
						<div style="height: 36px;"></div>
					</div>
				</div>
			</div>
        </div>
    </div>
</body>
<script type="text/javascript">
var userManageOrgId = "${userManageOrgId}";
var noRightDivObject = null;
var messageDivObject = null;

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
		$("#searchDiv").css('margin-right', '11px');
		$("#searchDiv").css('padding-top', '4px');
	}
	else {
		$("#searchDiv").css('margin-right', '22px');
		$("#searchDiv").css('padding-top', '5px');
	}

	noRightDivObject = $('#noRightDiv');
	messageDivObject = $('#messageDiv');
	
	$('#userTree').tree({
		data: ${treeJson},
		
		onClick: function(node) { // 点击结点事件
			var nodeType = node['nodeType'];
			if (nodeType == "01" || nodeType == "02") {
				var loaded = node.loaded;
				if (loaded == "0") {
					loadExpandNode(node); // 异步加载子节点数据
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
				clearMenuTree();
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
				if (nodeType == "user") { 
					loadUserMenuTree(node);
				}
				else {
					clearMenuTree();
				}
			}
		},
		
		onContextMenu: function(e, node) { // 鼠标右键事件
			e.preventDefault();
			var nodeType = node['nodeType'];
			if (nodeType == "01" || nodeType == "02") {
				var loaded = node.loaded;
				if (loaded == "0") {
					loadExpandNode(node); // 异步加载子节点数据
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
				clearMenuTree();
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
				if (nodeType == "user") { 
					loadUserMenuTree(node);
				}
				else {
					clearMenuTree();
				}
			}
			$(this).tree('select', node.target);
			treeNodeContextMethod(e, node);
		}	
		
		
	});
	
	$('#menuTree').tree({
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
			}
		}
	});	
	
});

function loadExpandNode(node) {
	var postData = {};
	postData['orgid'] = node['id'];
	$.ajax({
		url: contextPath + '/orgOrgAssignUser/expandNode',
		type: 'POST',
		data: postData
	}).done(function(result) {
		if (result) {
			result = parseReturn(result);
			$('#userTree').tree('append', {
				parent: node.target,
				data: result
			});
		}
		var nodeText = node['text'];
		nodeText = nodeText.replace("◢", "");
		$('#userTree').tree('update', {
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

function clearMenuTree() {
	noRightDivObject.hide();
	messageDivObject.html('');
	messageDivObject.hide();
	$('#menuTree').tree("loadData", []);
}

function loadUserMenuTree(node) {
	var nodeID = node['id'];
	nodeID = nodeID.substr(nodeID.indexOf('_') + 1);
	var postData = {};
	postData['userid'] = nodeID;
	$.ajax({
		url: contextPath + '/orgUserRealRight/userMenuTree',
		type: 'POST',
		data: postData
	}).done(function(result) {
		if (result != "") {
			result = parseReturn(result);
			$('#menuTree').tree("loadData", result);
			if (result.length == 0) {
				noRightDivObject.show();
				messageDivObject.html('');
				messageDivObject.hide();
			}
			else {
				noRightDivObject.hide();
				messageDivObject.html('（人员姓名：' + node['text'] + '）');
				messageDivObject.show();
			}
		}
		else {
			noRightDivObject.show();
			messageDivObject.html('');
			messageDivObject.hide();
		}
	});	
}

function searchTree() {
	var searchKeyValue = document.getElementById("searchKey").value;
	searchKeyValue = searchKeyValue.replace(/(^\s*)|(\s*$)/g, "");
	document.getElementById("searchKey").value = searchKeyValue;
	if (searchKeyValue != "") {
		var treeObject = $('#userTree');
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
}

</script>  

</html>