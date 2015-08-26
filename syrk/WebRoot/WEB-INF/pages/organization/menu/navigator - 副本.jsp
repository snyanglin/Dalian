<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="/errorPage.jsp"%>
<%
String contextPath = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
%>
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
Long userPk = new Long(0);
if (userInfo != null) {
   userPk = userInfo.getUserPk();	
}
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="<%=contextPath%>/common/skin/login.css" rel="stylesheet" />
<script type="text/javascript" src="<%=contextPath%>/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/mine.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/global.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/mainFrame.js"></script>

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
<body style="background:none;" scroll = "no">
<div style="width:100%;overflow:hidden;position:relative;">
<div class="Content">
<Div class="navi_nr" style="margin-left:-620px">
<h3><span>导航</span><a href="#"><img src="<%=contextPath%>/common/skin/images/close.png" width="10" height="10" /></a></h3>
<div id="banner_images">
<b class="scroll_button"><span class="left"><a href="javascript:void(0)"></a></span></b>
<b class="scroll_button"><span class="right"><a href="javascript:void(0)"></a></span></b>
<div class="focus" id="poster_focus">
<div class="wrapper">
<ul class="page poster3">
<li onclick="openTabPage('实有人口', '/forward/syrk|bzdzMain')" style="cursor:pointer;"><img src="<%=contextPath%>/common/skin/images/lunbo-1.png" width="96" height="96"/><br/>实有人口</li>
<li onclick="openTabPage('重点人口', '/forward/syrk|bzdzMain')" ><img src="<%=contextPath%>/common/skin/images/lunbo-2.png" width="96" height="96" /><br />重点人口</li>
<li onclick="openTabPage('组合查询', 'http://10.80.5.222:7007/mosty/query_template_engineQuery.action')"><img src="<%=contextPath%>/common/skin/images/lunbo-3.png" width="96" height="96" /><br />组合查询</li>
<%-- <li><img src="<%=contextPath%>/common/skin/images/lunbo-4.png" width="96" height="96" /><br /><a href="#">服务群众</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-5.png" width="96" height="96" /><br /><a href="#">治安防范</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-6.png" width="96" height="96" /><br /><a href="#">实有单位</a></li> --%>
</ul>
<ul class="page poster5" style="display:none">
<li><img src="<%=contextPath%>/common/skin/images/lunbo-1.png" width="96" height="96" /><br /><a href="#">标准地址</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-4.png" width="96" height="96" /><br /><a href="#">服务群众</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-5.png" width="96" height="96" /><br /><a href="#">治安防范</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-6.png" width="96" height="96" /><br /><a href="#">实有单位</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-2.png" width="96" height="96" /><br /><a href="#">实有房屋</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-3.png" width="96" height="96" /><br /><a href="#">工作对象</a></li>

</ul>
<ul class="page poster5" style="display:none">
<li><img src="<%=contextPath%>/common/skin/images/lunbo-3.png" width="96" height="96" /><br /><a href="#">工作对象</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-4.png" width="96" height="96" /><br /><a href="#">服务群众</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-1.png" width="96" height="96" /><br /><a href="#">标准地址</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-2.png" width="96" height="96" /><br /><a href="#">实有房屋</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-5.png" width="96" height="96" /><br /><a href="#">治安防范</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-6.png" width="96" height="96" /><br /><a href="#">实有单位</a></li>
</ul> 
<ul class="page poster5" style="display:none">
<li><img src="<%=contextPath%>/common/skin/images/lunbo-1.png" width="96" height="96" /><br /><a href="#">标准地址</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-2.png" width="96" height="96" /><br /><a href="#">实有房屋</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-3.png" width="96" height="96" /><br /><a href="#">工作对象</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-4.png" width="96" height="96" /><br /><a href="#">服务群众</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-5.png" width="96" height="96" /><br /><a href="#">治安防范</a></li>
<li><img src="<%=contextPath%>/common/skin/images/lunbo-6.png" width="96" height="96" /><br /><a href="#">实有单位</a></li>
</ul>

</div>
<div class="switcher">
    <b class="switcher-button cur" pg="0"><span class="button"></span></b>
    <b class="switcher-button" pg="1"><span class="button"></span></b>
    <b class="switcher-button" pg="2"><span class="button"></span></b>
    <b class="switcher-button" pg="3"><span class="button"></span></b>
</div>
</div>
</div>
<div class="peizhi"><img src="<%=contextPath%>/common/skin/images/peizhi.png" width="434" height="45" onclick="window.top.openWindow(false,'', contextPath + '/navigator/query?id='+<%=id %>, {document: document}, {title: '配置导航项',    
	    width: 690,   
	    height: 450,  
		collapsible: false, 
		minimizable: false, 
		maximizable: false,
		closable: true,
	    closed: false,    
	    cache: false,
	    inline: false,
		resizable: false, 
	    modal: true})"/></div>
</Div>
</div>
</div>
<script src="<%=contextPath%>/js/g.js"></script> 
<script src="<%=contextPath%>/js/movie-home.js"></script>
</body>
</html>