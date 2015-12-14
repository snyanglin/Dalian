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
var allExcludeChild = false;
var parentWindow = null;
var orgCodeInputID = null;
var orgNameInputID = null;
var orgIDInputID = null;
var onOkMethod = null;
var otherOrgCode = "";
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
	allExcludeChild = paramArray['allExcludeChild'];
	orgCodeInputID = paramArray['orgCodeInputID'];
	orgNameInputID = paramArray['orgNameInputID'];
	orgIDInputID = paramArray['orgIDInputID'];
	onOkMethod = paramArray['onOkMethod'];
	otherOrgCode = paramArray['otherOrgCode'];
	var desc = "";
	var maxMessageLength = 70;
	if (allExcludeChild) {
		maxMessageLength = maxMessageLength - 20;
	}
	if (getGBLength(validMessage) > maxMessageLength) {
		desc = "当前可以选择&nbsp;<font color='red' title='"+ validMessage +"'>" + getGBLeft(validMessage, maxMessageLength) + "...</font>";
	}
	else {
		desc = "当前可以选择&nbsp;<font color='red'>"+ validMessage +"</font>";
	}
	if (allExcludeChild) {
		desc += "，<font color='green'>但列表筛选只取大类</font>"; 
	}
	document.getElementById("descTd").innerHTML = "说明：双击结点可以选择到右边列表，"+ desc;
	
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
				else {
					if (node.checked) {
						$(this).tree('uncheck',  node.target);
					}
					else {
						$(this).tree('check',  node.target);
					}
				}
			}
		},
		
		onDblClick: function(node) { // 在双击一个节点的时候执行
			if (node.id != "ROOT") { // 根结点不变
				if (node.children) {
					if (isValidNode(node)) {
						addOptions(node['id'], node['text'], node['bizID']);
					}
				}
				else {
					$(this).tree('check',  node.target);
					if (isValidNode(node)) {
						addOptions(node['id'], node['text'], node['bizID']);
					}
				}
			}
		},
		onLoadSuccess: function(node, data) {
			initSelectedIDString();
			if (otherOrgCode != "") {
				initNodeArray = otherOrgCode.split(",");
				setTimeout("setSelectedOptions()", 0); 
			}
		}
		
	});
	
}

function ok_execute() {
	var returnIDArray = [];
	var returnNameArray = [];
	var returnBizIDArray = [];
	for (var i = 0; i <= select_validObj.length - 1; i++) {
		returnIDArray.push(select_validObj.options[i].value);
		returnNameArray.push(select_validObj.options[i].getAttribute("optionName"));
		returnBizIDArray.push(select_validObj.options[i].getAttribute("bizID"));
	}
	if (orgCodeInputID) {
		parentWindow.document.getElementById(orgCodeInputID).value = returnIDArray.join(",");
		parentWindow.$('#' + orgCodeInputID).validatebox('validate');
	}
	if (orgNameInputID) {
		parentWindow.document.getElementById(orgNameInputID).value = returnNameArray.join(",");
		parentWindow.$('#' + orgNameInputID).validatebox('validate');
	}
	if (orgIDInputID) {
		parentWindow.document.getElementById(orgIDInputID).value = returnBizIDArray.join(",");
		parentWindow.$('#' + orgIDInputID).validatebox('validate');
	}
}

function closeWindow() {
	window.parent.$('#' + windowID).window('close');
}

function setSelectedOptions() {
	if (initNodeArray != null && initNodeArray.length > 0) {
		addNodesArray = [];
		initCheckedTarget = [];
		for (var i = 0; i < initNodeArray.length; i++) {
			var node = treeObject.tree('find', initNodeArray[i]);
			if (node != null) {
				if (isValidNode(node)) {
					initCheckedTarget.push(node.target);
					addNodesArray.push(node);
				}
			}
		}
		initNodeArray = [];
		if (addNodesArray.length > 0) {
			addOptionsBatch(addNodesArray); 
			setTimeout("initChecked()", 0); 
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

// 是否有效的结点
function isValidNode(node) {
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

// 单条增加到列表
function addOptions(optionValue, optionText, bizID) {
	if (selectedIDString.indexOf(',' + optionValue + ',') == -1) {
		selectedIDString += optionValue + ",";
		$('#select_valid').append(getOptionString(optionValue, optionText, bizID));
	}
}

// 批量增加到列表
function addOptionsBatch() {
	var addHTML = [];
	for (var i = 0; i < addNodesArray.length; i++) {
		var node = addNodesArray[i];
		if (selectedIDString.indexOf(',' + node['id'] + ',') == -1) { 
			selectedIDString += node['id'] + ",";
			addHTML.push(getOptionString(node['id'], node['text'], node['bizID']));
		}		
	}
	if (addHTML.length > 0) {
		$('#select_valid').append(addHTML.join(''));
	}
}

function button2_onclick() {
	if (allExcludeChild) { // 清空已选择列表
		button4_onclick()
	}
	addNodesArray = [];
	if (allExcludeChild) {
		var checkedArray = [];
		var nodes = treeObject.tree('getChecked');
		if (nodes.length > 0) {
			for (var item in nodes) {
				var node = nodes[item];
				checkedArray.push(node['id']);
			}
			var rootNodes = treeObject.tree('getRoots');
			allExcludeChildTreeNode(rootNodes, ',' + checkedArray.join(',') + ',');
		}
	}
	else {
		var nodes = treeObject.tree('getChecked');
		for (var item in nodes) {
			var node = nodes[item];
			if (node.id != "ROOT") { 
				if (isValidNode(node)) {
					addNodesArray.push(node);
				}
			}
		}
	}
	if (addNodesArray.length > 0) {
		addOptionsBatch(addNodesArray);
	}
}

// 只取大类增加到列表的遍历
function allExcludeChildTreeNode(nodes, checkedArray) {
	for (var i = 0; i < nodes.length; i++) {
		var node = nodes[i];
		if (node.children) {
			if (node['id'] == "ROOT") {
				allExcludeChildTreeNode(node.children, checkedArray);
			}
			else {
				if (checkedArray.indexOf(',' + node['id'] +  ',') != -1) {
					if (isValidNode(node)) {
						addNodesArray.push(node);
					}
					else {
						allExcludeChildTreeNode(node.children, checkedArray);
					}
				}
				else {
					allExcludeChildTreeNode(node.children, checkedArray);
				}
			}
		}
		else {
			if (checkedArray.indexOf(',' + node['id'] +  ',') != -1 && isValidNode(node)) {
				addNodesArray.push(node);
			}
		}
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
function getOptionString(optionValue, optionText, bizID) {
	var optionString = '<option value="' + optionValue + '" optionName="' + optionText + '" bizID="' + bizID + '">';
	optionString += '\xA0' + optionValue + '\xA0|\xA0' + optionText + '</options>';
	return optionString;
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
			<td align="left" id="tdunvalid" valign="top" width="340">
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
						<div id="treeDiv" class="easyui-panel" style="padding:5px; width: 340px; height: 248px;" onselectstart="return false;">
							<ul class="easyui-tree" id="treeSelect" data-options="method:'get',lines:true,checkbox:true"></ul>
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