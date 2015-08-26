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
	select_validObj = document.getElementById("select_valid");
	if (IE && IE_VERSION <= 9) {
		select_validObj.style.height = "278px";
	}
	else {
		document.getElementById("descTd").height = 22;
	}
	
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
	var desc = "";
	var maxMessageLength = 70;
	if (getGBLength(validMessage) > maxMessageLength) {
		desc = "当前可以选择&nbsp;<font color='red' title='"+ validMessage +"'>" + getGBLeft(validMessage, maxMessageLength) + "...</font>";
	}
	else {
		desc = "当前可以选择&nbsp;<font color='red'>"+ validMessage +"</font>";
	}
	document.getElementById("descTd").innerHTML = "说明：双击岗位可以选择到右边列表，"+ desc;
	
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
	var returnIDArray = [];
	var returnNameArray = [];
	var returnOrgCodeArray = [];
	var returnOrgNameArray = [];
	var returnOrgIDArray = [];
	for (var i = 0; i <= select_validObj.length - 1; i++) {
		returnIDArray.push(select_validObj.options[i].value);
		returnNameArray.push('【' + select_validObj.options[i].getAttribute("orgName") + '】' + select_validObj.options[i].getAttribute("optionName"));
		returnOrgCodeArray.push(select_validObj.options[i].getAttribute("orgCode"));
		returnOrgNameArray.push(select_validObj.options[i].getAttribute("orgName"));
		returnOrgIDArray.push(select_validObj.options[i].getAttribute("orgID"));
	}
	if (parentWindow.contentWindow) {
		parentWindow = parentWindow.contentWindow;
	}
	if (posIDInputID) {
		parentWindow.document.getElementById(posIDInputID).value = returnIDArray.join(",");
		parentWindow.$('#' + posIDInputID).validatebox('validate');
	}
	if (posNameInputID) {
		parentWindow.document.getElementById(posNameInputID).value = returnNameArray.join(",");
		parentWindow.$('#' + posNameInputID).validatebox('validate');
	}
	if (orgCodeInputID) {
		parentWindow.document.getElementById(orgCodeInputID).value = returnOrgCodeArray.join(",");
		parentWindow.$('#' + orgCodeInputID).validatebox('validate');
	}
	if (orgNameInputID) {
		parentWindow.document.getElementById(orgNameInputID).value = returnOrgNameArray.join(",");
		parentWindow.$('#' + orgNameInputID).validatebox('validate');
	}
	if (orgIDInputID) {
		parentWindow.document.getElementById(orgIDInputID).value = returnOrgIDArray.join(",");
		parentWindow.$('#' + orgIDInputID).validatebox('validate');
	}
}

function closeWindow() {
	window.parent.$('#' + windowID).window('close');
}

function setSelectedOptions() {
	if (selectedPosNode != "") {
		addNodesArray = [];
		initCheckedTarget = [];
		initNodeArray = selectedPosNode.split(",");
		for (var i = 0; i < initNodeArray.length; i++) {
			var node = treeObject.tree('find', initNodeArray[i]);
			if (node != null) {
				initCheckedTarget.push(node.target);
				var parentNode = treeObject.tree('getParent', node.target);
				var optionArray = [];
				optionArray['id'] = node['id'];
				optionArray['text'] = node['text'];
				optionArray['bizID'] = node['bizID'];
				optionArray['orgCode'] = parentNode['bizID'];
				optionArray['orgName'] = parentNode['text'];
				optionArray['orgID'] = parentNode['id'];
				addNodesArray.push(optionArray);
			}
		}
		initNodeArray = [];
		if (addNodesArray.length > 0) {
			addOptionsBatch(addNodesArray); 
			setTimeout("initChecked()", 0); 
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

function initChecked() {
	for (var i = 0; i < initCheckedTarget.length; i++) { // 设置初始选中
		treeObject.tree('expandTo', initCheckedTarget[i]);
		treeObject.tree('check', initCheckedTarget[i]);
	}
	initCheckedTarget = [];
}

function body_onunload() {
	document.getElementById("treeDiv").innerHTML = "";
}

// 单条增载到列表
function addOptions(optionValue, optionText, bizID, orgCode, orgName, orgID) {
	if (selectedIDString.indexOf(',' + optionValue + ',') == -1) {
		selectedIDString += optionValue + ",";
		$('#select_valid').append(getOptionString(optionValue, optionText, bizID, orgCode, orgName, orgID));
	}
}

// 批量增加到列表
function addOptionsBatch() {
	var addHTML = [];
	for (var i = 0; i < addNodesArray.length; i++) {
		var node = addNodesArray[i];
		if (selectedIDString.indexOf(',' + node['id'] + ',') == -1) { 
			selectedIDString += node['id'] + ",";
			addHTML.push(getOptionString(node['id'], node['text'], node['bizID'], node['orgCode'], node['orgName'], node['orgID']));
		}		
	}
	if (addHTML.length > 0) {
		$('#select_valid').append(addHTML.join(''));
	}
}

function button2_onclick() {
	var nodes = treeObject.tree('getChecked');
	addNodesArray = [];
	for (var item in nodes) {
		var node = nodes[item];
		var nodeType = node['nodeType'];
		if (nodeType == "pos") {
			var nodeID = node['id'];
			var parentNode = treeObject.tree('getParent', node.target);
			var optionArray = [];
			var optionValue = nodeID;
			optionValue = optionValue.substr(optionValue.indexOf('_') + 1);
			optionArray['id'] = optionValue;
			optionArray['text'] = node['text'];
			optionArray['bizID'] = node['bizID'];
			optionArray['orgCode'] = parentNode['bizID'];
			optionArray['orgName'] = parentNode['text'];
			optionArray['orgID'] = parentNode['id'];
			addNodesArray.push(optionArray);
		}
	}
	if (addNodesArray.length > 0) {
		addOptionsBatch(addNodesArray);
	}
}

function button3_onclick() {
	var i = select_validObj.selectedIndex;
	while (i >= 0) {
		select_validObj.remove(i);
		i = select_validObj.selectedIndex;  
	}
	initSelectedIDString();
}

function button4_onclick() {
	if (select_validObj.length > 0) {
		select_validObj.length = 0;
	}
	initSelectedIDString();
}

function right_ondblclick() {
	var cur_sele = 0;
	if (select_validObj.length > 0) {
		cur_sele = select_validObj.selectedIndex;
		if (cur_sele >= 0) {
			select_validObj.remove(cur_sele);
		}
	}
	initSelectedIDString();
}

// 设置已存在列表ID串
function initSelectedIDString() {
	if (select_validObj.length > 0) {
		var tempArray = [];
		for (var j = 0; j < select_validObj.length; j++) {        
			tempArray.push(select_validObj.options[j].value);
		}
		selectedIDString = "," + tempArray.join(",") + ","; 
	}
	else {
		selectedIDString = ","; 
	}
}

// 取提单条列表option的html字符串
function getOptionString(optionValue, optionText, bizID, orgCode, orgName, orgID) {
	var optionString = '<option value="' + optionValue + '" optionName="' + optionText + '" bizID="' + bizID + '" orgCode="' + orgCode + '" orgName="' + orgName + '" orgID="' + orgID + '">';
	var tempBizID = bizID + getReapeatString("\xA0", 12 - bizID.length);
	optionString += '\xA0' + tempBizID + '\xA0|\xA0【' + orgName + '】' + optionText + '</options>';
	return optionString;
}

function searchDict() {
	var searchKeyValue = document.getElementById("searchKey").value;
	searchKeyValue = searchKeyValue.replace(/(^\s*)|(\s*$)/g, "");
	document.getElementById("searchKey").value = searchKeyValue;
	if (searchKeyValue != "") {
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
			<td align="left" id="tdunvalid" valign="top" width="340">
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
						<div id="treeDiv" class="easyui-panel" style="padding:5px; width: 340px; height: 248px;" onselectstart="return false;">
							<ul class="easyui-tree" id="treeSelect" data-options="method:'get',lines:true,checkbox:true,searchServer:true"></ul>
						</div>
					</td>
				</tr>
				</table>
			</td>
			<td align="center" width="80">
				<table border="0" cellspacing="0">
				<tr><td align="center" height="80"><button onclick="button2_onclick()" tabindex="5" class="buttonMultiSelect" TYPE="button"><table border="0" cellspacing="0" cellpadding="0" width="23"><tr><td align="center" class="buttonAddSelect"   ></td></tr><tr><td height="2"></td></tr></table></button></td></tr>
				<tr><td align="center" height="50"><button onclick="button3_onclick()" tabindex="7" class="buttonMultiSelect" TYPE="button"><table border="0" cellspacing="0" cellpadding="0" width="23"><tr><td align="center" class="buttonRemoveSelect"></td></tr><tr><td height="2"></td></tr></table></button></td></tr>
				<tr><td align="center" height="80"><button onclick="button4_onclick()" tabindex="8" class="buttonMultiSelect" TYPE="button"><table border="0" cellspacing="0" cellpadding="0" width="23"><tr><td align="center" class="buttonRemoveAll"   ></td></tr><tr><td height="2"></td></tr></table></button></td></tr>
				</table>
			</td>
			<td align="right" id="tdvalid" valign="top" width="340">
				<select id="select_valid" size="10" tabindex="10" class="multiSelect" style="width: 340px; height: 269px;" multiple ondblclick="right_ondblclick(1)">
				${listOptions}
				</select>
			</td>
		</tr>
		</table>
	</td></tr>
	<tr><td align="center" id="descTd" valign="bottom">
	</td></tr>
</tbody>
</table>
</div>

</body>
</html>