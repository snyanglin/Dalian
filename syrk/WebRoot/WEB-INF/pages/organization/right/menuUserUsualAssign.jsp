<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>个人常用菜单配置</title>
</head>
<body class="easyui-layout" data-options="fit:true">
	    
    <div id="searchDiv" style="position: relative; float: right; width: 290px; padding-top:4px; text-align: right; color: #333333; z-index:255;">
		<input id="searchKey" maxlength="20" class="treeSearchInput" style="width: 200px;" onfocus="this.select();"> 
		<input type="button" id="search_but" value="搜 索" onclick="searchTree()" class="treeSearchButton">
	</div>

	<div data-options="region:'center',split:false,title:'',border:false,collapsible:false" style="padding: 5px; height: auto;">
		<ul class="easyui-tree" id="editTree" data-options="method:'get',lines:true,checkbox:true"></ul>
		<div style="height: 36px;"></div>
	</div>
	<div style="display: none;">
		<form action="<%=basePath%>orgMenuUserUsual/assignSave" id="dataForm" name="dataForm" method="post">
		<input type="hidden" name="userid" value="${userid}" id="userid"/>
		<input type="hidden" name="assignMenuID" id="assignMenuID"/>
		</form>
	</div>    
</body>

<script type="text/javascript">
var treeObject = null; 

function doInit(paramArray) {

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
		$("#searchDiv").css('margin-right', '3px');
		$("#searchDiv").css('padding-top', '4px');
	}
	else {
		$("#searchDiv").css('margin-right', '22px');
		$("#searchDiv").css('padding-top', '5px');
	}

	$('#editTree').tree({
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
		}
	});	

	treeObject = $('#editTree');
}

function beforeSubmit() {
	var nodes = $('#editTree').tree('getChecked');
	var selectNodeID = [];
	if (nodes.length > 0) {
		for (var item in nodes) {
			var nodeObject = nodes[item];
			var nodeType = nodeObject['nodeType'];
			if (nodeType == "menu2") {
				selectNodeID.push(nodeObject['id']);
			}
		}
	}
	$('#assignMenuID').val(selectNodeID.join(','));
}

function afterSubmit(submitData) {
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

</html>