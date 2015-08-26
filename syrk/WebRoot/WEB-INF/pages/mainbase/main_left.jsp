<%@page pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%@page import="com.founder.framework.organization.right.service.OrgRightPublic"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<%
String emptyImage = contextPath + "/common/skin/images/sys_empty.gif";

SessionBean userInfo = (SessionBean) session.getAttribute("userSession");
String userID = "";
String password = "";
String userName = "";
String userOrgCode = "";
String userOrgName = "";
String userRemoteAddr = "";
if (userInfo != null) {
   userID =  userInfo.getUserId();
   password = userInfo.getPassword();
   if (password == null) {
      password = "";
   }
   userName =  userInfo.getUserName();
   userOrgCode = userInfo.getUserOrgCode();
   userOrgName = userInfo.getUserOrgName();
   userRemoteAddr = userInfo.getRemoteAddr();
   java.util.Map extendMap = userInfo.getExtendMap();
   if (extendMap != null && extendMap.size() > 0) {
   }
}
OrgRightPublic orgRightPublic = new OrgRightPublic();
String menuJson = orgRightPublic.getUserMenuJson(userInfo, "framework", false);
//String menuJson = "[]";
%>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/skin/mainMenu.css">

<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<script type="text/javascript" >
var menuDivObj = null;
var menuTableObj = null;
var menuTableObjTop = 0;
var menuTableObjWidth = 0;
var butUpObj = null;
var butDownObj = null;
var butDownObjTop = 0;
var repeatFlag = true;
var repeatTimeout = 0;
var heightSpace = 35;
var menuHight = 18;

var sessionUserID = "<%=userID%>";
var sessionPassword = "<%=password%>";
var sessionUserOrgCode = "<%=userOrgCode%>";

(function ($) {

	var defaults = $.extend({}, $.fn.tree.defaults, {

		onClick: function(node) { // 点击结点事件
			var opts = $(this).tree('options');
			if (node.id != "ROOT") { // 根结点不变
				if (node.children) { // 增加只能选叶子结点时点击中间结点自动展开与折叠当前结点
					if (node.state == 'closed') {
						$(this).tree('expand', node.target);
					}
					else {
						$(this).tree('collapse', node.target);
					}
				}
				else {
					var nodeType = node['nodeType'];
					if (nodeType == "menu2") {
						treeNodeClick(node);
					}
				}
			}
		},
		
		onExpand: function(node) { // 展开结点事件
			treeNode_expand();
		},
		
		onCollapse: function(node) { // 折叠结点事件
			treeNode_expand();
		},
		
		onContextMenu: function(e, node) { // 鼠标右键事件
			e.preventDefault();
		}
	
	});

	$.extend($.fn.tree.defaults, defaults);

})(jQuery); 

function body_onLoad() {
	menuDivObj = document.getElementById("menuDiv");
	menuTableObj = document.getElementById("menuTable");
	butUpObj = document.getElementById("butUp");
	butDownObj = document.getElementById("butDown");
   
	$('#menuTree').tree({
		data: <%=menuJson%>
	});
			
	menuTableObjWidth = menuTableObj.offsetWidth;
	menu_onResize();
}   

function menuMousemove(e) {
	var curObject;
	e = e || window.event;
	if (IE)
		curObject = e.srcElement;
	else
		curObject = e.target;
	var parentObject = curObject.parentNode;
	if (parentObject.className == "menuBarTr1") {
		parentObject.className = "menuBarTr2";
		var changeTds = curObject.parentNode.childNodes;
		changeTds[1].className = "menuBarTd2";
	}
}

function menuMouseout(e) {
	var curObject;
	e = e || window.event;
	if (IE)
		curObject = e.srcElement;
	else
		curObject = e.target;
	var parentObject = curObject.parentNode;
	if (parentObject.className == "menuBarTr2") {
		parentObject.className = "menuBarTr1";
		var changeTds = curObject.parentNode.childNodes;
		changeTds[1].className = "menuBarTd1";
	}
}

function treeNodeClick(nodeObject) {
	if (nodeObject.id == "ROOT") {
		return;
	}
	var menuLabel = nodeObject.text;
	var openURL = nodeObject.openURL;
	if (openURL == null || openURL == "") { // URL为空时不处理
		return;
	}
	var openMode = nodeObject['openMode'];
	if (openMode == "new") { // 新窗口中打开
		var screenY = window.screen.availHeight - 30;
		var screenX = window.screen.availWidth - 10;
		var properties = "LEFT=0,TOP=0,HEIGHT="+screenY+",WIDTH="+screenX+",menubar=no,toolbar=no,location=no,directories=no,scrollbars=no,resizable=yes,status=yes";
		var openURLUpper = openURL.toUpperCase();
		var winID = "win_" + nodeObject.id;
		if (openURLUpper.indexOf("HTTP://") == 0) {
			openURL = openURL.replace(/#userID#/g, sessionUserID);
			openURL = openURL.replace(/#password#/g, sessionPassword);
			openURL = openURL.replace(/#userOrgCode#/g, sessionUserOrgCode);
			window.open(openURL, winID, properties); 
		}
		else {
			window.open(contextPath + openURL, winID, properties);
		}
	}
	else { // 在框架页面中打开
		var openURLUpper = openURL.toUpperCase();
		if (openURLUpper.indexOf("HTTP://") == 0) {
			openURL = openURL.replace(/#userID#/g, sessionUserID);
			openURL = openURL.replace(/#password#/g, sessionPassword);
			openURL = openURL.replace(/#userOrgCode#/g, sessionUserOrgCode);
		}
		menu_open(menuLabel, openURL);
	}
}

function menu_open(menuName, openURL) {
	try {
		var menuNameLink = "";
		if (openURL.indexOf("?") == -1) {
			menuNameLink = "?";
		}
		else {
			menuNameLink = "&";
		}
		if (IE) {
			parent.main_center.main_tabTitle.tabTitle_add(menuName, openURL + menuNameLink + "menuName=" + menuName);
		}
		else {
			var main_center = parent.frames.document.getElementById("main_center");
			var main_tabTitle = main_center.contentWindow.frames.document.getElementById("main_tabTitle");
			main_tabTitle.contentWindow.tabTitle_add(menuName, openURL + menuNameLink + "menuName=" + menuName);
		}
	}
	catch (err) {}
}

function menu_onResize() {
	var realHeight = document.body.clientHeight - 30; // 满高度
	//realHeight = Math.floor(realHeight / 20) * 20;  // 不出现半个字的情况，但滚动条没有据底
	menuDivObj.style.height = realHeight; 
	butDownObjTop = document.body.clientHeight - 20;
	butDownObj.style.top = butDownObjTop;
	if (menuTableObj.scrollWidth > menuTableObjWidth) {
		heightSpace = 54;
	}
	else {
		heightSpace = 35;
	}
	checkButDownDisplay();
}

// 树节点展开与收缩时执行的方法
function treeNode_expand() {
	if (menuTableObj.scrollWidth > menuTableObjWidth) {
		heightSpace = 54;
	}
	else {
		heightSpace = 35;
	}
	checkButDownDisplay();
}

function checkButDownDisplay() {
	if (menuTableObj.offsetHeight <= document.body.clientHeight - heightSpace) {
		menuTableObjTop = 0;
		butUpObj.style.display = "none";
		butDownObj.style.display = "none";
		menuTableObj.style.top = menuTableObjTop;
	}
	else {
		if (menuTableObjTop + menuTableObj.offsetHeight > document.body.clientHeight - heightSpace) {
			butDownObj.style.display = "block";
			if (menuTableObj.scrollWidth > menuTableObjWidth) {
				butDownObj.style.top = butDownObjTop - 17;
			}
			else {
				butDownObj.style.top = butDownObjTop;
			}
		}
		else {
			butDownObj.style.display = "none";
		}
	}
}

function butUp_onMouseOver() {
	butUpObj.className = "butUp2";
	repeatFlag = true;
	repeatTimeout = 300;
	timeout_Up();
}

function butUp_onMouseOut() {
	butUpObj.className = "butUp1";
	repeatFlag = false;
}

function butDown_onMouseOver() {
	butDownObj.className = "butDown2";
	repeatFlag = true;
	repeatTimeout = 300;
	timeout_Down();
}

function butDown_onMouseOut() {
	butDownObj.className = "butDown1";
	repeatFlag = false;
}

function timeout_Up() {
	if (repeatFlag) {
		menuTableObjTop += menuHight;
		menuTableObj.style.top = menuTableObjTop;
		if (menuTableObjTop + menuTableObj.offsetHeight > document.body.clientHeight - heightSpace) {
			butDownObj.style.display = "block";
			if (menuTableObj.scrollWidth > menuTableObjWidth) {
				butDownObj.style.top = butDownObjTop - 17;
			}
			else {
				butDownObj.style.top = butDownObjTop;
			}
		}
		if (menuTableObjTop < 0) {
			if (repeatTimeout > 100) {
				repeatTimeout -= 100;
			}
			else {
				repeatTimeout = 15;
			}
			setTimeout("timeout_Up();",repeatTimeout);
		}
		else {
			repeatFlag = false;
			butUpObj.style.display = "none";
			butUpObj.className = "butUp1";
		}
	}
}

function timeout_Down() {
	if (repeatFlag) {
		menuTableObjTop -= menuHight;
		menuTableObj.style.top = menuTableObjTop;
		butUpObj.style.display = "block";
		if (menuTableObjTop + menuTableObj.offsetHeight > document.body.clientHeight - heightSpace) {
			if (repeatTimeout > 100) {
				repeatTimeout -= 100;
			}
			else {
				repeatTimeout = 15;
			}
			setTimeout("timeout_Down();",repeatTimeout);
		}
		else {
			repeatFlag = false;
			butDownObj.style.display = "none";
			butDownObj.className = "butDown1";
		}
	}
}

function menuTable_onmousewheel(e) {
	e = e || window.event;
	if (e.wheelDelta > 0) { // 鼠标中键向上转动，菜单向下移动
		if (menuTableObjTop < 0) {
			menuTableObjTop += menuHight * 3;
			if (menuTableObjTop > 0) {
				menuTableObjTop = 0;
			}
			menuTableObj.style.top = menuTableObjTop;
			if (menuTableObjTop + menuTableObj.offsetHeight > document.body.clientHeight - heightSpace) {
				butDownObj.style.display = "block";
				if (menuTableObj.scrollWidth > menuTableObjWidth) {
					butDownObj.style.top = butDownObjTop - 17;
				}
				else {
					butDownObj.style.top = butDownObjTop;
				}
			}
			if (menuTableObjTop >= 0) {
				butUpObj.style.display = "none";
				butUpObj.className = "butUp1";
			}
		}
	}
	else { // 鼠标中键向下转动，菜单向上移动
		if (menuTableObjTop + menuTableObj.offsetHeight > document.body.clientHeight - heightSpace) {
			if (menuTableObjTop - menuHight * 3 + menuTableObj.offsetHeight > document.body.clientHeight - heightSpace) {
				menuTableObjTop -= menuHight * 3;
			}		
			else if (menuTableObjTop - menuHight * 2 + menuTableObj.offsetHeight > document.body.clientHeight - heightSpace) {
				menuTableObjTop -= menuHight * 2;
			}		
			else {
				menuTableObjTop -= menuHight;
			}
			menuTableObj.style.top = menuTableObjTop;
			butUpObj.style.display = "block";
			if (menuTableObjTop + menuTableObj.offsetHeight <= document.body.clientHeight - heightSpace) {
				repeatFlag = false;
				butDownObj.style.display = "none";
				butDownObj.className = "butDown1";
			}
		}
	}
}

</script>

</HEAD>

<BODY class="menuBody" onselectstart="return false;" onload="body_onLoad();" onResize="menu_onResize();" oncontextmenu="return false;">
<table border="0" cellpadding="0" cellspacing="0" align="center" width="100%" class="tabTable1" style="z-index: 20;">
<tbody>
<tr><td height="1"></td></tr>
</tbody>
</table>

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
<tr><td class="bodyTd" valign="top">

	<table border="0" cellpadding="0" cellspacing="0" align="center" width="100%" class="tabTable2" style="z-index: 20;">
	<tbody>
	<tr><td class="menuTitle" height="24" width="100%"></td></tr>
	</tbody>
	</table>

	<div id="butUp" onMouseOver="butUp_onMouseOver()" onMouseOut="butUp_onMouseOut()" class="butUp1" style="display:none;"></div>
	<div id="butDown" onMouseOver="butDown_onMouseOver()" onMouseOut="butDown_onMouseOut()" class="butDown1" style="display:none;"></div>

	<div id="menuDiv" class="menuDiv" style="z-index: 15; overflow-x: auto;">
	<table id="menuTable" border="0" cellpadding="0" cellspacing="0" align="center" onmousewheel="menuTable_onmousewheel()" class="menuTable" style="top: 0;">
	<tbody><tr><td nowrap id="menuTd" style="padding-left: 2px; padding-right: 2px;">

		<ul class="easyui-tree" id="menuTree" data-options="method:'get',lines:true"></ul>

	</td></tr></tbody></table>
	</div>

</td></tr>
</table>

</BODY>
</HTML>

