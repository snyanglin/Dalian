<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
</head>

<script language="JavaScript">
var windowID = null;
var parentWindow = null;
var orgCodeInputID = null;
var orgNameInputID = null;
var orgIDInputID = null;
var onOkMethod = null;
var orgType = "${orgType}";
var orgLevel = "${orgLevel}";
var orgBizType = "${orgBizType}";
if (orgLevel != "") {
	orgLevel = "," + orgLevel + ",";
}
if (orgBizType != "") {
	orgBizType = "," + orgBizType + ",";
}
var validMessage = "${validMessage}";
var treeObject = null; 

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
	orgCodeInputID = paramArray['orgCodeInputID'];
	orgNameInputID = paramArray['orgNameInputID'];
	orgIDInputID = paramArray['orgIDInputID'];
	onOkMethod = paramArray['onOkMethod'];
	var desc = "";
	var maxMessageLength = 70;
	if (getGBLength(validMessage) > maxMessageLength) {
		desc = "当前可以选择&nbsp;<font color='red' title='"+ validMessage +"'>" + getGBLeft(validMessage, maxMessageLength) + "...</font>";
	}
	else {
		desc = "当前可以选择&nbsp;<font color='red'>"+ validMessage +"</font>";
	}
	document.getElementById("descTd").innerHTML = "说明："+ desc;
	
	treeObject = $('#treeSelect');
	
	$('#treeSelect').tree({
		onlyLeaf: false,	
		data: ${treeJson},

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
		},
		
		onLoadSuccess: function(node, data) {
			setSelectedOptions(parentWindow.document.getElementById(orgCodeInputID).value);
		}
	});	
}

function ok_execute() {
	var node = treeObject.tree('getSelected');
	var validNodeSelected = false;
	if (node != null) {
		validNodeSelected = isValidNode(node);
	}
	if (validNodeSelected) {
		if (parentWindow.contentWindow) {
			parentWindow = parentWindow.contentWindow;
		}
		if (orgCodeInputID) {
			parentWindow.document.getElementById(orgCodeInputID).value = node['id'];
			parentWindow.$('#' + orgCodeInputID).validatebox('validate');
		}
		if (orgNameInputID) {
			parentWindow.document.getElementById(orgNameInputID).value = node['text'];
			parentWindow.$('#' + orgNameInputID).validatebox('validate');
		}
		if (orgIDInputID) {
			parentWindow.document.getElementById(orgIDInputID).value = node['bizID'];
			parentWindow.$('#' + orgIDInputID).validatebox('validate');
		}
	}
	else {
		$.messager.alert('系统信息','请选择一个有效的部门！','error');
		return false;
	}
	return true;
}

function clear_execute() {
	treeObject.tree('select', null);
	if (orgCodeInputID) {
		parentWindow.document.getElementById(orgCodeInputID).value = "";
	}
	if (orgNameInputID) {
		parentWindow.document.getElementById(orgNameInputID).value = "";
	}
	if (orgIDInputID) {
		parentWindow.document.getElementById(orgIDInputID).value = "";
	}
}

function closeWindow() {
	window.parent.$('#' + windowID).window('close');
}

function setSelectedOptions(selectedValue) {
	if (("undefined" != typeof selectedValue) && (selectedValue != "")) {
		var node = treeObject.tree('find', selectedValue);
		if (node != null) {
			if (isValidNode(node)) {
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

// 是否有效的结点
function isValidNode(node) {
	if (node.id == "ROOT") {
		return false;
	}
	if (orgType != "") {
		var nodeOrgType = node['nodeType'];
		if ("undefined" == typeof nodeOrgType || nodeOrgType == null || nodeOrgType == "") {
			return false;
		}
		else {
			if (nodeOrgType != orgType) {
				return false;
			}
		}
	}
	if (orgLevel != "") {
		var nodeOrgLevel = node['orgLevel'];
		if ("undefined" == typeof nodeOrgLevel || nodeOrgLevel == null || nodeOrgLevel == "") {
			return false;
		}
		else {
			if (orgLevel.indexOf(',' + nodeOrgLevel + ',') == -1) {
				return false;
			}
		}
	}
	if (orgBizType != "") {
		var nodeOrgBizType = node['orgBizType'];
		if ("undefined" == typeof nodeOrgBizType || nodeOrgBizType == null || nodeOrgBizType == "") {
			return false;
		}
		else {
			if (orgBizType.indexOf(',' + nodeOrgBizType + ',') == -1) {
				return false;
			}
		}
	}
	return true;
}

function searchDict() {
	var searchKeyValue = document.getElementById("searchKey").value;
	searchKeyValue = searchKeyValue.replace(/(^\s*)|(\s*$)/g, "");
	document.getElementById("searchKey").value = searchKeyValue;
	if (searchKeyValue != "") {
  		var node = treeObject.tree('searchTreeNode', {searchKey:searchKeyValue.toUpperCase()});
   		if (node != null) {
			var locateNode = treeObject.tree('find', node['id']);
			treeObject.tree('expandTo', locateNode.target);
			treeObject.tree('scrollTo', locateNode.target);
			treeObject.tree('select', locateNode.target);
		}
		else {
			$.messager.show({
				title: '搜索结果',
				msg: '无匹配的数据项！',
				timeout: 1500,
				showType: 'show',
				style: {
					right: '',
					top: 20
				}
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
							<td>查询：&nbsp;<input id="searchKey" class="dictSearchInput" maxlength="20" style="width: 230px;" onfocus="this.select();"  title="匹配部门名称、部门代码、部门拼音"></td>
							<td style="padding-left:4px;"><input type="button" value="搜 索" onclick="searchDict()" class="dictSearchButton"></td>
						</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td align="right">
						<div id="treeDiv" class="easyui-panel" style="padding:5px; width: 760px; height: 248px;" onselectstart="return false;">
							<ul class="easyui-tree" id="treeSelect" data-options="method:'get',lines:true"></ul>
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