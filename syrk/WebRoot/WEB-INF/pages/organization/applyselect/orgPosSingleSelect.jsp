<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
</head>

<script language="JavaScript">
var windowID = null;
var select_validObj = null;
var parentWindow = null;
var posIDInputID = null;
var posNameInputID = null;
var orgCodeInputID = null;
var orgNameInputID = null;
var orgIDInputID = null;
var onOkMethod = null;
var dialogTitle = null;
var rootid = "${rootid}"
var orgType = "${orgType}";
var orgLevel = "${orgLevel}";
var orgBizType = "${orgBizType}";
var posids = "${posids}";
var initFocusOrgId = "${initFocusOrgId}";
var validMessage = "${validMessage}";
var selectedPosNode = "${selectedPosNode}"; 
var searchParameter = "&orgType=" + orgType;
searchParameter += "&orgLevel=" + orgLevel;
searchParameter += "&orgBizType=" + orgBizType;
searchParameter += "&posids=" + posids;
var treeObject = null;
var initNodeArray = null;
var initCheckedTarget = [];
var selectedIDString = ",";
var addNodesArray = [];

function doInit(paramArray) {
	$("#searchKey").bind("keydown", function(e) {
		try {
			if (e.keyCode == 13) {
				searchDict();
				event.returnValue = false;
			}
		}
		catch (err) {};
	});

	parentWindow = paramArray['parentWindow'];
	windowID = paramArray['windowID'];
	posIDInputID = paramArray['posIDInputID'];
	posNameInputID = paramArray['posNameInputID'];
	orgCodeInputID = paramArray['orgCodeInputID'];
	orgNameInputID = paramArray['orgNameInputID'];
	orgIDInputID = paramArray['orgIDInputID'];
	onOkMethod = paramArray['onOkMethod'];
	//如果该字段不为空，且 为数据库表对应得字段，可灵活返回字段至界面 
	dialogTitle = paramArray['dialogTitle'];
	var desc = "";
	var maxMessageLength = 70;
	if (getGBLength(validMessage) > maxMessageLength) {
		desc = "当前可以选择&nbsp;<font color='red' title='"+ validMessage +"'>" + getGBLeft(validMessage, maxMessageLength) + "...</font>";
	}
	else {
		desc = "当前可以选择&nbsp;<font color='red'>"+ validMessage +"</font>";
	}
	document.getElementById("descTd").innerHTML = "说明："+ desc;
	
	$('#treeSelect').tree({
		
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
		
		onDblClick: function(node) { // 在双击一个节点的时候执行
			var nodeType = node['nodeType'];
			if (nodeType == "pos") { // 根结点不变
				$(this).tree('check',  node.target);
				var parentNode = treeObject.tree('getParent', node.target);
				addOptions(node['id'], node['text'], node['bizID'], parentNode['bizID'], parentNode['text'], parentNode['id']);
			}
		}
		
	});	
	
	treeObject = $('#treeSelect');
	$(document).ready(function() {
		setSelectedOptions();
	});
}

function loadExpandNode(node) {
	var postData = {};
	postData['orgid'] = node['id'];
	postData['orgType'] = orgType;
	postData['orgLevel'] = orgLevel;
	postData['orgBizType'] = orgBizType;
	postData['posids'] = posids;
	$.ajax({
		url: contextPath + '/orgPosPublicSelect/expandNode',
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

function ok_execute() {
	var node = treeObject.tree('getSelected');
	var validNodeSelected = false;
	if (node != null) {
		var nodeType = node['nodeType'];
		if (nodeType == "pos") {
			validNodeSelected = true;
		}
	}
	if (validNodeSelected) {
		if (parentWindow.contentWindow) {
			parentWindow = parentWindow.contentWindow;
		}
		var parentNode = treeObject.tree('getParent', node.target);
		if (posIDInputID) {
			parentWindow.document.getElementById(posIDInputID).value = node['id'];
			parentWindow.$('#' + posIDInputID).validatebox('validate');
		}
		if (posNameInputID) {
			parentWindow.document.getElementById(posNameInputID).value = "【" + parentNode['text'] + "】" + node['text'];
			parentWindow.$('#' + posNameInputID).validatebox('validate');
		}
		if (orgCodeInputID) {
			parentWindow.document.getElementById(orgCodeInputID).value = parentNode['bizID'];
			parentWindow.$('#' + orgCodeInputID).validatebox('validate');
		}
		if (orgNameInputID) {
			parentWindow.document.getElementById(orgNameInputID).value = parentNode['text'];
			parentWindow.$('#' + orgNameInputID).validatebox('validate');
		}
		if (orgIDInputID) {
			parentWindow.document.getElementById(orgIDInputID).value = parentNode['id'];
			parentWindow.$('#' + orgIDInputID).validatebox('validate');
		}
		//特别定制，用来返回org_position表的posid
		if(dialogTitle != null ){
			parentWindow.document.getElementById(dialogTitle).value = node['bizID'];
			parentWindow.$('#' + dialogTitle).validatebox('validate');
		}
	}
	else {
		$.messager.alert('系统信息','请选择一个岗位！','error');
		return false;
	}
	return true;
}

function clear_execute() {
	treeObject.tree('select', null);
	if (posIDInputID) {
		parentWindow.document.getElementById(posIDInputID).value = "";
	}
	if (posNameInputID) {
		parentWindow.document.getElementById(posNameInputID).value = "";
	}
	if (orgCodeInputID) {
		parentWindow.document.getElementById(orgCodeInputID).value = "";
	}
	if (orgNameInputID) {
		parentWindow.document.getElementById(orgNameInputID).value = "";
	}
	if (orgIDInputID) {
		parentWindow.document.getElementById(orgIDInputID).value = "";
	}
	if (dialogTitle) {
		parentWindow.document.getElementById(dialogTitle).value = "";
	}
}

function closeWindow() {
	window.parent.$('#' + windowID).window('close');
}

function setSelectedOptions() {
	if (selectedPosNode != "") {
		var node = treeObject.tree('find', selectedPosNode);
		if (node != null) {
			treeObject.tree('expandTo', node.target);
			treeObject.tree('select', node.target);
			treeObject.tree('scrollTo', node.target);
		}
	}
	else {
		if (initFocusOrgId != "") {
			var node = treeObject.tree('find', initFocusOrgId);
			if (node != null) {
				treeObject.tree('expandTo', node.target);
				treeObject.tree('select', node.target);
				treeObject.tree('scrollTo', node.target);
			}
		}
	}
}

function body_onunload() {
	document.getElementById("treeDiv").innerHTML = "";
}

function searchDict() {
	var searchKeyValue = document.getElementById("searchKey").value;
	searchKeyValue = searchKeyValue.replace(/(^\s*)|(\s*$)/g, "");
	document.getElementById("searchKey").value = searchKeyValue;
	if (searchKeyValue != "") {
		
		var url = contextPath + '/orgOrganization/queryOrgTreeSearchResult?rootid=' + userManageOrgId;
		
		var url = contextPath + '/orgPosPublicSelect/queryPublicOrgPosRealTreeSearchResult?rootid=' + rootid + searchParameter;
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
					url: contextPath + '/orgPosPublicSelect/queryPublicOrgPosRealTreeSearchLoadJson',
					type: 'POST',
					async: false,
					data: "loadIdString=" + loadIdString + searchParameter
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

<body style="margin:20px 10px 10px 10px; overflow: hidden;" onunload="body_onunload();">

<div data-options="region:'center',split:true" style="width:760px; border-width: 0px;">
<table border="0" cellspacing="0" cellpadding="0" width="760" align="center">
<tbody>
	<tr><td>
		<table border="0" cellpadding="2" cellspacing="0" width="100%">
		<tr>
			<td align="left" id="tdunvalid" valign="top" width="100%">
				<table border="0" cellspacing="0" cellpadding="0" width="100%">
				<tr>
					<td align="right" style="padding-bottom:1px;">
						<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>查询：&nbsp;<input id="searchKey" class="dictSearchInput" maxlength="20" style="width: 230px;" onfocus="this.select();" title="匹配部门名称"></td>
							<td style="padding-left:4px;"><input type="button" value="搜 索" onclick="searchDict()" class="dictSearchButton"></td>
						</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td align="right">
						<div id="treeDiv" class="easyui-panel" style="padding:5px; width: 760px; height: 248px;" onselectstart="return false;">
							<ul class="easyui-tree" id="treeSelect" data-options="method:'get',lines:true,searchServer:true"></ul>
						</div>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
	</td></tr>
	<tr><td align="center" id="descTd" valign="bottom" height="22">
	</td></tr>
</tbody>
</table>
</div>

</body>
</html>