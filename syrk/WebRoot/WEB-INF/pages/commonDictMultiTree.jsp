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
var onlyLeaf = true;
var allExcludeChild = false;
var parentWindow = null;
var dictInputID = null;
var dictShowID = null;
var onOkMethod = null;
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
	treeObject = $('#treeDict');
	var opts = treeObject.tree("options");
	opts.url = paramArray['dictName'];
	opts.onlyLeaf = paramArray['onlyLeaf'];
	opts.dataFilter = paramArray['dataFilter'];
	onlyLeaf = paramArray['onlyLeaf'];
	allExcludeChild = paramArray['allExcludeChild'];
	dictInputID = paramArray['dictInputID'];
	dictShowID = paramArray['dictShowID'];
	onOkMethod = paramArray['onOkMethod'];
	var desc = "";
	if (onlyLeaf) {
		desc = "当前只能选择&nbsp;<font color='red'>【叶子结点】</font>";
	}
	else {
		desc = "当前可以选择&nbsp;<font color='red'>【所有结点】</font>";
		if (allExcludeChild) {
			desc += "，<font color='green'>但列表筛选只取大类</font>"; 
		}
	}
	document.getElementById("descTd").innerHTML = "说明：双击结点可以选择到右边列表，"+ desc;
	
	treeObject.tree({

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
					if (!onlyLeaf) {
						addOptions(node['id'], node['text']);
					}
				}
				else {
					$(this).tree('check',  node.target);
					addOptions(node['id'], node['text']);
				}
			}
		},
		
		onLoadSuccess: function(node, data) {
			var initOrgCode = parentWindow.document.getElementById(dictInputID).value;
			if (initOrgCode != "") {
				initNodeArray = initOrgCode.split(",");
				setTimeout("setSelectedOptions()", 0); 
			}
		}
	});	
}

function ok_execute() {
	var returnIDArray = [];
	var returnNameArray = [];
	for (var i = 0; i <= select_validObj.length - 1; i++) {
		returnIDArray.push(select_validObj.options[i].value);
		returnNameArray.push(select_validObj.options[i].getAttribute("optionName"));
	}
	if (parentWindow.contentWindow) {
		parentWindow = parentWindow.contentWindow;
	}
	if (dictInputID) {
		parentWindow.document.getElementById(dictInputID).value = returnIDArray.join(",");
		parentWindow.$('#' + dictInputID).validatebox('validate');
	}
	if (dictShowID) {
		parentWindow.document.getElementById(dictShowID).value = returnNameArray.join(",");
		parentWindow.$('#' + dictShowID).validatebox('validate');
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
				if (!onlyLeaf || !node.children) {
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


// 单条增加到列表
function addOptions(optionValue, optionText) {
	if (selectedIDString.indexOf(',' + optionValue + ',') == -1) {
		selectedIDString += optionValue + ",";
		$('#select_valid').append(getOptionString(optionValue, optionText));
	}
}

// 批量增加到列表
function addOptionsBatch() {
	var addHTML = [];
	for (var i = 0; i < addNodesArray.length; i++) {
		var node = addNodesArray[i];
		if (selectedIDString.indexOf(',' + node['id'] + ',') == -1) { 
			selectedIDString += node['id'] + ",";
			addHTML.push(getOptionString(node['id'], node['text']));
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
				if (!onlyLeaf || !node.children) {			
					addNodesArray.push(node);
				}
			}
		}
	}
	if (addNodesArray.length > 0) {
		addOptionsBatch(addNodesArray);
	}
}

// 只取大类增加到列表
function allExcludeChildTreeNode(nodes, checkedArray) {
	for (var i = 0; i < nodes.length; i++) {
		var node = nodes[i];
		if (node.children) {
			if (node['id'] == "ROOT") {
				allExcludeChildTreeNode(node.children, checkedArray);
			}
			else {
				if (checkedArray.indexOf(',' + node['id'] +  ',') != -1) {
					addNodesArray.push(node);
				}
				else {
					allExcludeChildTreeNode(node.children, checkedArray);
				}
			}
		}
		else {
			if (checkedArray.indexOf(',' + node['id'] +  ',') != -1) {
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
function getOptionString(optionValue, optionText) {
	var optionString = '<option value="' + optionValue + '" optionName="' + optionText + '">';
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
				msg: '无匹配的字典项！',
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
							<td>查询：&nbsp;<input id="searchKey" class="dictSearchInput" maxlength="20" style="width: 230px;" onfocus="this.select();" title="可以根据字典代码(前匹配)、拼音首字母(中间匹配)、字典词条(中间匹配)进行搜索"></td>
							<td style="padding-left:4px;"><input type="button" value="搜 索" onclick="searchDict()" class="dictSearchButton"></td>
						</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td align="right">
						<div id="treeDiv" class="easyui-panel" style="padding:5px; width: 340px; height: 248px;" onselectstart="return false;">
							<ul class="easyui-tree" id="treeDict" data-options="method:'get',lines:true,checkbox:true"></ul>
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