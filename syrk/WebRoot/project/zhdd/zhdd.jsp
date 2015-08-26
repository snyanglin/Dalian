<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:v="urn:schemas-microsoft-com:vml">
<head>
<title></title>
<meta http-equiv="X-UA-Compatible" content="IE=7"/>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>project/zhdd/css/zhdd.css"/>
<script type="text/javascript">
	var jjrbh = "${userSession.userId}";
	var jjrdwbh = "${userSession.userOrgCode}";
	//var ywjgdm = "${userSession.userOrgCode}";
	//var jqssdddm = "${UserSession.userOrgProperty}";
	SysConfig.USERID = jjrbh;// 存储登录用户名
	$(document).ready(function() {
        LeftLayout.init({id:"zhdd_load_lf"},function() {			
			var param = {menu: [
								{name: '警力监控', url: '/syrk/common/components/resource/gps.jsp',lfwidth:275},
								{name: '警力态势', url: 'http://10.80.8.179:9080/Componentnew',openNew:'true'}
					    		//{name: '辖区概况', url: 'xqgk',lfwidth:560}
					    		], idx: 0, expand: false};
			LeftLayout.addlftabmenu(param, function(){ 
				SysTool.setContentHeight();
			});
		});
		setTimeout(function(){
			// 隐藏左侧基础资源
			//展开右侧（临时处理方式）
		}, 800);
	//	setJqztTimer(jqssdddm,jjrbh);
						
	});
	//设置左右两边页面高度
	$(window).resize(function() {
		setContentHeight();
	});
	function setContentHeight(){
		SysTool.setContentHeight();
		var bodyerht=$("body").height();
		var bodwidth=$("body").width();
	};
	
</script>
</head>
<body>
	<div id="zhdd_load_lf" style="position:relative;"></div><!-- 容器-lf -->
	<div id="zhdd_load_rt"></div><!-- 容器-rt -->
</body>
</html>
