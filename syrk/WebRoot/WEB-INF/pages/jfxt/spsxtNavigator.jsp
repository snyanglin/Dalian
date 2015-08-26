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


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="<%=contextPath%>/common/skin/login.css" rel="stylesheet" />
<script type="text/javascript" src="<%=contextPath%>/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/mine.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/global.js" ></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/mainFrame.js"></script>

<script type="text/javascript">

function doOpen(title,url){
	closeSelf();
	menu_open(title,url);
}
</script>
</head>
<body style="background:none;overflow:hidden">
<div style="width:100%;overflow:hidden;left:-10%">
<div class="Content">
<div class="navi_nr">
<h3><span>视频摄像头资源采集导航</span></h3>
<div id="banner_images">

<div class="focus" id="poster_focus">
<div class="wrapper">

<ul class="page poster5" >
	<li><a href="#" onclick="doOpen('技防管理--公安自建资源','/forward/jfxt|gaOwner|ga_spsxtMain')"><img src="<%=contextPath%>/images/jfxt/ga1.jpg" /></a></li>						
	<li><a href="#" onclick="doOpen('技防管理--社会资源','/forward/jfxt|spsxtMain')"><img src="<%=contextPath%>/images/jfxt/ga2.jpg" /></a></li>						
</ul>

</div>

</div>
</div>

</div>
</div>

</body>
</html>