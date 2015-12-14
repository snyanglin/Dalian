<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="/errorPage.jsp"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%
String contextPath = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script type="text/javascript">
var contextPath = "<%=contextPath%>";
var basePath = "<%=basePath%>";
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%

SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
Long userPk =new Long(0);
String userID = "";
if (userInfo != null) {
   userPk = userInfo.getUserPk();
   userID =  userInfo.getUserId();
}


%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/json2.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/tools.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/jquery1.11.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/jquery.form.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.panel.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.combo.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.combobox.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.combotree.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.window.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.datagrid.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.validatebox.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.tooltip.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/plugins/jquery.messager.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/jquery.easyui.extend.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/jquery.easyui.extend.validatebox.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/mainFrame.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/business.tools.js"></script>

<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/jeasyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/jeasyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/jeasyui/themes/custom.css">

<style type="text/css">
.tdNormal {
	padding-top:10px;
	cursor:pointer;
	color: #333333;
	border: 1px dashed #DDDDDD;
	background-color: #FFFFFF;
}
.tdSelect {
	padding-top:10px;
	cursor:pointer;
	color: #BB0000;
	border: 1px dashed #FF0000;
	background-color: #FFE8E8;
}

</style>

<script type="text/javascript">
var windowID = null;
function doInit(paramArray) {
	windowID = paramArray['windowID'];
}

function openTabPage(menuName, openURL) {
	menu_open(menuName, openURL);
	window.parent.$('#' + windowID).window('close');
}

</script>
</head>
<body>

<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'center', split:false" style="border-width: 0px; background:#F8F8F8">
    	
    	<table border="0" cellpadding="0" cellspacing="15" align="center">
    	
			<c:forEach items ="${list}" var="ztys" varStatus="i">
				<c:if test="${i.count mod 6 == 1}">
				<tr height="145">
				</c:if>
		      
				<c:choose>
					<c:when test="${ztys.bigicontext2=='标准地址管理' && ztys.menuopenmode =='2'}">
						<td align="center" width="140" valign="top" onmouseover="this.className='tdSelect';" onmouseout="this.className='tdNormal';" class="tdNormal" onclick="window.open('${ztys.menuurl}<%=userID %>')"><img src="<%=contextPath %>/images/navigatorNew/icon/${ztys.bigiconimg2}" width="96" height="96"/><br/><br/><span style="font-size:13px;font-weight: bold;">${ztys.menuname}&nbsp;</span></td>
					</c:when>
					<c:otherwise>
						<c:if test="${ztys.menuopenmode =='2'}">
							<td align="center" width="140" valign="top" class="tdNormal" onmouseover="this.className='tdSelect';" onmouseout="this.className='tdNormal';" onclick="window.open('${ztys.menuurl}')"><img src="<%=contextPath %>/images/navigatorNew/icon/${ztys.bigiconimg2}" width="96" height="96"/><br/><br/><span style="font-size:13px;font-weight: bold;">${ztys.menuname}&nbsp;</span></td>
						</c:if>
						<c:if test="${ztys.menuopenmode!='2'}">
							<td align="center" width="140" valign="top" class="tdNormal" onmouseover="this.className='tdSelect';" onmouseout="this.className='tdNormal';" onclick="openTabPage('${ztys.menuname}', '${ztys.menuurl}')"><img src="<%=contextPath %>/images/navigatorNew/icon/${ztys.bigiconimg2}" width="96" height="96"/><br/><br/><span style="font-size:13px;font-weight: bold;">${ztys.menuname}&nbsp;</span></td>
						</c:if>
					</c:otherwise>
				</c:choose>
				</td>

				<c:if test="${i.count % 6 == 0}">
				</tr>
				</c:if>

			 </c:forEach>
    	
    	</table>
    
    </div>
    
	<div data-options="region:'south',split:false,title:'',border:false,collapsible:false" class="datagrid-toolbar" style="padding: 5px; height: 37; overflow: hidden; border-top: 1px #DDDDDD solid;background-color: #f4f4f4;">
		<table cellspacing="0" cellpadding="0" border="0" width="100%">
			<tbody>
			<tr>
			<td class="toolbarTd" nowrap="nowrap" align="right">
				<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="menuConfig();">
					<span class="l-btn-left l-btn-icon-left">
						<span class="l-btn-text" nowrap="nowrap">配置导航菜单</span>
						<span class="l-btn-icon icon-config"> </span>
					</span>
				</a>
			</td>
			</tr>
			</tbody>
		</table>
	</div>    
</div>    
<script type="text/javascript">
function menuConfig(){
	var editUrl = contextPath+"/ztTheme/DhPz";
   	openWindowNoSave(false, null, this.Window, 
   		null, 
   		{
   		title: '配置导航菜单',
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height: 400
   		}, 
   		'', null
   	);
  }  
function openWindowNoSave(isCache, windowID, parentWindow, paramArray, dataOptions) {
	if (!dataOptions.url) {
		topMessagerAlert('', '弹出层缺少 url 参数！');
		return;
	}
	if (!dataOptions.title) {
		dataOptions.title = '';
	}
	dataOptions.title = '&nbsp;' + dataOptions.title;
	if (!dataOptions.width) {
		dataOptions.width = 850;
	}
	if (!dataOptions.height) {
		dataOptions.height = 420;
	}
	if (!windowID) {
		var myTime = (new Date()).getTime();
		windowID = "win_" + myTime;
	}
	dataOptions.collapsible = dataOptions.collapsible ? dataOptions.collapsible : false;
	dataOptions.minimizable = dataOptions.minimizable ? dataOptions.minimizable : false;
	dataOptions.maximizable = dataOptions.maximizable ? dataOptions.maximizable : false; // 是否最大化图标
	dataOptions.closable = true;
	dataOptions.closed = false;   
	dataOptions.cache = false;
	dataOptions.inline = false;
	dataOptions.modal = true;
	openWindow(isCache, windowID, dataOptions.url, paramArray, dataOptions);
}
</script>
</body>
</html>