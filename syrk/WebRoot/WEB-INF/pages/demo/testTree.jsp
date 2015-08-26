<%@page language="java" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
</head>
<body style="margin:10px 10px 10px 10px;" onload="body_onload()">
	<div class="easyui-panel" id="treeDiv" style="padding:5px; width: 500px; height: 300px;">
		<ul class="easyui-tree" id="myTree" data-options="url:'<%=contextPath%>/common/dict/D_BZ_XZQH_PROVINCE.js',method:'get',lines:true,dataFilter:'',checkbox:true,onlyLeaf:true"></ul>
	</div>
	
	<div id="menu0" class="easyui-menu" data-options="onClick:menuHandler" style="width:220px;">
		<div id='a1' data-options="name:'addMenuGroup',iconCls: 'icon-add'">新增菜单分组</div>
	</div>
	
	<div id="menu1" class="easyui-menu" data-options="onClick:menuHandler" style="width:220px;">
		<div data-options="name:'addGroup',iconCls: 'icon-add'">新增菜单分组</div>
		<div data-options="name:'addItem',iconCls: 'icon-add'">新增菜单项</div>
		<div class="menu-sep"></div>
		<div data-options="name:'edit',iconCls: 'icon-edit'">修改</div>
		<div data-options="name:'delete',iconCls: 'icon-cancel'">删除</div>
		<div class="menu-sep"></div>
		<div data-options="name:'moveUp',iconCls: 'icon-moveUp'">上移</div>
		<div data-options="name:'moveDown',iconCls: 'icon-moveDown'">下移</div>
	</div>

	<input type="button" value="locate" onclick="locate();"/>
	<input type="button" value="insert" onclick="insert();"/>
	<input type="button" value="append" onclick="append();"/>
	<input type="button" value="GetDataFilter" onclick="alert($('#myTree').tree('getDataFilter'));"/>
	<input type="button" value="SetDataFilter" onclick="$('#myTree').tree('setDataFilter', '5101');"/>
	
</body>
</html>

<script type="text/javascript">

function body_onload() {
	$('#myTree').tree({

		onClick: function(node) { // 在用户点击的时候提示
			var opts = $(this).tree('options');
			if (node.id != "ROOT") { // 根结点不变
				if (opts.onlyLeaf && node.children) { // 增加只能选叶子结点时点击中间结点自动展开与折叠当前结点
					if (node.state == 'closed') {
						$(this).tree('expand', node.target);
					}
					else {
						//$(this).tree('collapse', node.target);
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
		
		onDblClick: function(node) { // 在用户双击一个节点的时候触发
			if (node.id != "ROOT") { // 根结点不变
				if (!node.checked) {
					$(this).tree('check',  node.target);
				}
			}
		},
		
		onContextMenu: function(e, node) { // 鼠标右键事件
			e.preventDefault();
			$(this).tree('select', node.target);
			treeNodeContextMethod(e, node);
		},
		
		onLoadSuccess: function(node, data) {
			init();
		}
	});
}

function init() {
	var checkedID = "510301,510302,510303,510304,510311,510321,510322";
	var tempArray = checkedID.split(",");
	for (var i = 0; i < tempArray.length; i++) {
		var node = $('#myTree').tree('find', tempArray[i]);
		if (node != null) {
		   $('#myTree').tree('expandTo', node.target);
		   $('#myTree').tree('check', node.target);
		}
	}
}

function locate() {
   var node = $('#myTree').tree('find', "510104");
   if (node != null) {
	   $('#myTree').tree('expandTo', node.target);
	   $('#myTree').tree('select', node.target);
	   $('#myTree').tree('check', node.target);
   }
   init();
}

function insert() {
	var node = $('#myTree').tree('find', "510104");
	if (node != null) {
		$('#myTree').tree('insert', {
			before: node.target,
			data: [{
				id: '423',
				text: 'insert23'
			}]
		});
	}
}

function append() {
	var node = $('#myTree').combotree('tree').tree('find', "510100");
	if (node != null) {
		$('#myTree').combotree('tree').tree('append', {
			parent: node.target,
			data: [{
				id: '510199',
				text: '增加的结点',
				py: 'ROOT',
				biz: '增加的属性'
			}]
		});
	}	
}

function treeNodeContextMethod(e, nodeObject) {
	var menuTop = nodeObject.target.offsetTop + 21;
	var menuLeft = document.body.scrollLeft + e.pageX;
	
	
	//$('#menu1').menu('show', { left: menuLeft, top: e.menuTop});
	$('#menu1').menu('show', { left: e.pageX, top: e.pageY});
	return;
   
   contextTreeNode = nodeObject;
   if (contextMenuObj != null) {
      contextMenuObj.style.display = "none";
   }
   var nodeType = nodeObject['nodeType'];
   switch (nodeType) {    
   case "0" :
       contextMenuObj = document.getElementById("contextMenu0"); 
	   break;
   case "1" :
	   contextMenuObj = document.getElementById("contextMenu1"); 
	   break;
   case "2" :
	   contextMenuObj = document.getElementById("contextMenu2"); 
	   break;
   }
   contextMenuObj.style.display = "block";
   contextMenuMainObj.style.display = "block";
   contextMenuMainObj.style.top = nodeObject.target.offsetTop + 21;
   contextMenuMainObj.style.left = document.body.scrollLeft + e.clientX;
}

function menuHandler(item) {
	alert(item.name);        
}

$(function(){
	$(document).bind('contextmenu',function(e){
		e.preventDefault();
		$('#menu0').menu('show', {
			left: e.pageX,
			top: e.pageY
		});
	});
});
</script>
