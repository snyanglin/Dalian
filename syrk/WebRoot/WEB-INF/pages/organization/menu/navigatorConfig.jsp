<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%

SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
Long userPk = new Long(0);
if (userInfo != null) {
	userPk = userInfo.getUserPk();
}
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
</head>

<STYLE TYPE="text/CSS">

.inputSelect {
	font:9pt "宋体"; 
}

.buttonMultiSelect {
	cursor: pointer;
	width: 32px; 
	height: 30px;
}

.buttonAddSelect {
	width: 18px;
	height : 18px;
	background: url('../common/skin/images/but_leftRight2.gif') no-repeat top;
}

.buttonRemoveSelect {
	width: 18px;
	height : 18px;
	background: url('../common/skin/images/but_leftRight3.gif') no-repeat top;
}

.buttonRemoveAll {
	width: 18px;
	height : 18px;
	background: url('../common/skin/images/but_leftRight4.gif') no-repeat top;
}

.dictSearchButton {
	font: 9pt "宋体"; 
	color: #222222;
	border: #3774A8 1px solid; 
	height: 20px; 
	width: 50px;
}
</STYLE>

<script>
var windowID = "";
var treeObject = null;
var selectedUserNode = "${selectNodeID}";
var addNodesArray = [];
var select_validObj = null;
var selectedIDString = ",";
var initNodeArray = null;
var initCheckedTarget = [];

function doInit(paramArray) {
  	windowID = paramArray["windowID"];
  	select_validObj = document.getElementById("select_valid");
  	if (IE && IE_VERSION <= 9) {
		select_validObj.style.height = "278px";
	}
	$('#treeSelect').tree({
		
		data: ${menuJson},

		onClick: function(node) { // 点击结点事件
			var nodeType = node['nodeType'];
			if (node.children) { // 点击中间结点自动展开与折叠当前结点
				if (node.state == 'closed') {
					$(this).tree('expand', node.target);
				}
				else {
					$(this).tree('collapse', node.target);
				}
			}
		},
		
		onDblClick: function(node) { // 在双击一个节点的时候执行
			var nodeType = node['nodeType'];
			if (nodeType == "menu2") {
				$(this).tree('check',  node.target);
				addOptions(node['id'], node['text']);
			}
		}
		
	});	
	
	treeObject = $('#treeSelect');
	$(document).ready(function() {
		setSelectedOptions();
	});
}

function setSelectedOptions() {
	if (selectedUserNode != "") {
		addNodesArray = [];
		initCheckedTarget = [];
		initNodeArray = selectedUserNode.split(",");
		for (var i = 0; i < initNodeArray.length; i++) {
			var node = treeObject.tree('find', initNodeArray[i]);
			if (node != null) {
				initCheckedTarget.push(node.target);
				var optionArray = [];
				optionArray['id'] = node['id'];
				optionArray['text'] = node['text'];
				addNodesArray.push(optionArray);
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

//批量增加到列表
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


function addOptions(optionValue, optionText) {
	if (selectedIDString.indexOf(',' + optionValue + ',') == -1) {
		selectedIDString += optionValue + ",";
		$('#select_valid').append(getOptionString(optionValue, optionText));
	}
}

//取提单条列表option的html字符串
function getOptionString(optionValue, optionText) {
	var optionString = '<option value="' + optionValue + '">';
	optionString += '\xA0' + optionText + '</options>';
	return optionString;
}

function button2_onclick() {
	var nodes = treeObject.tree('getChecked');
	addNodesArray = [];
	for (var item in nodes) {
		var node = nodes[item];
		var nodeType = node['nodeType'];
		if (nodeType == "menu2") {
			var optionArray = [];
			optionArray['id'] = node['id'];
			optionArray['text'] = node['text'];
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
		if (i>=0) {
			select_validObj.remove(i);
		}
		i = select_validObj.selectedIndex;  
	}
	initSelectedIDString();
}

function button4_onclick() {
	if (select_validObj.length > 0) {
		var times = select_validObj.length - 1;
		for (var i = 0; i <= times; i++) {        
			select_validObj.remove(0);
		}
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

//设置已存在列表ID串
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

//置顶
function menuTop(){
   var cur_sele = 0;
	if (select_validObj.length > 0) {
		cur_sele = select_validObj.selectedIndex;
		if (cur_sele >= 0) {
			var times = select_validObj.length - 2;
			var tempValue = select_validObj.options[cur_sele].text+","+select_validObj.options[cur_sele].value;
			select_validObj.remove(cur_sele);
			for ( var i = 0; i <= times; i++) {
				  tempValue = tempValue+":"+select_validObj.options[i].text+","+select_validObj.options[i].value;
			}
			for ( var i = 0; i <= times; i++) {
				select_validObj.remove(0);
			}
			var tempArray = tempValue.split(":");
			for(var i=0; i <tempArray.length;i++){
			   var textArray = tempArray[i].split(",");
			   var opt = new Option(textArray[0],
			   textArray[1]);
			   select_validObj.options.add(opt);
			}
			select_validObj.selectedIndex = 0;
		  }
	  }
}
//上移
function menuUp(){
   var cur_sele = 0;
		if (select_validObj.length > 0) {
			cur_sele = select_validObj.selectedIndex;
			if (cur_sele > 0) {
                   var currtText = select_validObj.options[cur_sele].text;
                   var currtValue = select_validObj.options[cur_sele].value;
			    select_validObj.options[cur_sele].text = select_validObj.options[cur_sele-1].text;
                   select_validObj.options[cur_sele].value = select_validObj.options[cur_sele-1].value;
                   select_validObj.options[cur_sele-1].text = currtText;
                   select_validObj.options[cur_sele-1].value = currtValue;
                   select_validObj.selectedIndex = cur_sele-1;
				}
		}
}
//下移
function menuDown(){
   var cur_sele = 0;
		if (select_validObj.length > 0) {
			cur_sele = select_validObj.selectedIndex;
			if (cur_sele >= 0 && cur_sele != select_validObj.length-1) {
				var downText = select_validObj.options[cur_sele+1].text;
                   var downValue = select_validObj.options[cur_sele+1].value;
                   
			    select_validObj.options[cur_sele+1].text = select_validObj.options[cur_sele].text;
                   select_validObj.options[cur_sele+1].value = select_validObj.options[cur_sele].value;
                   select_validObj.options[cur_sele].text = downText;
                   select_validObj.options[cur_sele].value = downValue;
                   select_validObj.selectedIndex = cur_sele+1;
			}
		}
}
//置底
function menuBotton(){
   var cur_sele = 0;
		if (select_validObj.length > 0) {
			cur_sele = select_validObj.selectedIndex;
			if (cur_sele >= 0) {
				var opt = new Option(select_validObj.options[cur_sele].text,
						select_validObj.options[cur_sele].value);
				select_validObj.remove(cur_sele);
				select_validObj.options.add(opt);
				select_validObj.selectedIndex = select_validObj.length-1;
			}
		}
}
	
function closeWindow() {
	window.parent.$('#' + windowID).window('close');
}

function ok_execute() {
	var returnID = "";
	for ( var i = 0; i <= select_validObj.length - 1; i++) {
		returnID += select_validObj.options[i].value + ",";
	}
	if (returnID != "") {
		returnID = returnID.substr(0, returnID.length - 1);
	}
	saveMenu(returnID);
};
	
//ajax导航配置信息
function saveMenu(menuids){
  var idValue = '<%=userPk%>';
    $.ajax({
       type:"POST",
       url :"<%=basePath%>ztTheme/saveMenuPz",
       data:{userid:idValue,menuids:menuids},
       dataType:"json",
       success:function(data){
    	   topMessager.show({
   				title: MESSAGER_TITLE,
   				msg: '保存成功！',
   				timeout:1500
   			});
    	   parent.location.reload();
         closeWindow();
       }
    });
  
}
</script>

<body style="margin:20px 10px 10px 20px; overflow: hidden;">
<form name="dataform" id="dataform" method="post">
<input type="hidden" id="hidLeft" name="hidLeft" value="${tempMenu}"/>
<div data-options="region:'center',split:true" style="width:800px; border-width: 0px;">
<table border="0" cellspacing="0" cellpadding="0" width="800" align="center">
<tbody>
	<tr><td>
		<table border="0" cellpadding="2" cellspacing="0" width="100%">
		<tr>
			<td align="left" id="tdunvalid" valign="top" width="330">
				<table border="0" cellspacing="0" cellpadding="0" width="100%">
				<tr>
					<td align="right">
						<div id="treeDiv" class="easyui-panel" style="padding:5px; width: 330px; height: 269px;" onselectstart="return false;">
							<ul class="easyui-tree" id="treeSelect" data-options="method:'get',lines:true,checkbox:true"></ul>
						</div>
					</td>
				</tr>
				</table> 
			</td>
			<td align="center" width="100">
				<table border="0" cellspacing="0">
				<tr><td align="center" height="80"><button onclick="button2_onclick()" tabindex="5" class="buttonMultiSelect" TYPE="button"><table border="0" cellspacing="0" cellpadding="0" width="23"><tr><td align="center" class="buttonAddSelect"   ></td></tr><tr><td height="2"></td></tr></table></button></td></tr>
				<tr><td align="center" height="50"><button onclick="button3_onclick()" tabindex="7" class="buttonMultiSelect" TYPE="button"><table border="0" cellspacing="0" cellpadding="0" width="23"><tr><td align="center" class="buttonRemoveSelect"></td></tr><tr><td height="2"></td></tr></table></button></td></tr>
				<tr><td align="center" height="80"><button onclick="button4_onclick()" tabindex="8" class="buttonMultiSelect" TYPE="button"><table border="0" cellspacing="0" cellpadding="0" width="23"><tr><td align="center" class="buttonRemoveAll"   ></td></tr><tr><td height="2"></td></tr></table></button></td></tr>
				</table>
			</td>
			<td align="right" id="tdvalid" valign="top" width="330">
				<select id="select_valid" size="10" tabindex="10" class="inputSelect" style="width: 330px; height: 269px;" multiple ondblclick="right_ondblclick(1)">
				</select>
			</td>
			<td align="left" width="10%" style="padding-left:10px;">
				<table border="0" cellspacing="0" cellpadding="0">
				<tr><td align="left" height="50"><input type="button" class="dictSearchButton" onclick="menuTop();" value="置 顶"/></td></tr>
				<tr><td align="left" height="50"><input type="button" class="dictSearchButton" onclick="menuUp();"  value="上 移"/></td></tr>
				<tr><td align="left" height="50"><input type="button" class="dictSearchButton" onclick="menuDown();" value="下 移"/></td></tr>
				<tr><td align="left" height="50"><input type="button" class="dictSearchButton" onclick="menuBotton();" value="置 底"/></td></tr>
				</table>
			</td>
		</tr>
		<tr>
		  <td colspan="4" align="center" height="50">
		  	<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="ok_execute();">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  	<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="closeWindow();">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">取消</span>
					<span class="l-btn-icon icon-cancel"> </span>
				</span>
			</a>
		  </td>
		</tr>
		</table>
	</td></tr>
</tbody>
</table>
</div>
</form>

</body>
</html>