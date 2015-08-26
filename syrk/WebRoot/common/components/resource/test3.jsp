<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test3.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>	
	</style>
	<script type="text/javascript" charset="GB2312" src="http://172.29.213.110:7003/POService/EzBuilderAPI/JavascriptApi/JsEzbuilder.js"></script>
	<script type="text/javascript" src="http://172.29.213.102:9080/PGIS_S_TileMap/js/EzMapAPI.js"></script>
	<script type="text/javascript" src="framework/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="common/tools/SysTool.js"></script>
	<script type="text/javascript" src="common/config/SysConfig.js"></script>
	<script type="text/javascript" src="common/tools/GeoQuery.js"></script>
	<script type="text/javascript" src="common/components/resource/js/resource.js"></script>
	
  </head>
  
  <body>
  	<div id="pgis_map" Style="height:1000px;width:100%;"></div>
	<div id="test"></div>
	<script type="text/javascript">
		var _MapApp;
		 $(document).ready(function(){
	   		//初始始化地图
			 _MapApp = new EzMap(document.getElementById("pgis_map"));
		_MapApp.zoomTo(14);
		//map.registerProx(ezmodule.util.getContextPath()+'/Proxy');
		_MapApp.addMapEventListener(EzEvent.MAP_MOUSEMOVE, function(e) {
			window.status = "X:" + e.mapPoint.x + "  Y:" + e.mapPoint.y;
		});
		var ov = new OverView();
		ov.width = 100;
		ov.height = 100;
		ov.minLevel = 4;
		ov.maxLevel = 20;
		_MapApp.addOverView(ov);
		_MapApp.showOverView();
		});	 
		Resource.init("test", [
		{name:"实时警力",url:"common/components/resource/ssjl.jsp"},{name:"基础信息",url:"common/components/resource/jcxx.jsp"},{name:"今日警情",url:"common/components/resource/jrjq.html"},{name:"车辆布控",url:"common/components/resource/clbk.jsp"}]); 

	</script>
  </body>
</html>
