<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <title>地图定位</title>
	<script type="text/javascript">
	var ezmap = null;//地图对象
	function loadMap(){
		/*地图对象*/
		ezmap = new FrameTools.Map();
		/*设置地图代理*/
		ezmap.setProxy(contextPath + "/Proxy");
		/*设置地图加载容器*/
		ezmap.setMapDiv("mapDiv");
		/*加载地图*/
		ezmap.onloadMap();
		/*显示鹰眼*/
		ezmap.addOverView();
		/*隐藏自带矢量影像图层对象*/
		ezmap._MapApp.hideMapServer();
		/*加载自定义的矢量影像图层对象*/
		ezmap.showNewMapServer("mapDiv","ezmap");
		/*隐藏地图操作控件，包括一般地图控件、简化地图控件和标准地图控件。*/
		ezmap._MapApp.hideMapControl();
	};
	$(function(){
		loadMap();
	});
	</script>
  </head>
  <body>
  	<div width="100%" height="100%" id="mapDiv"></div>
  </body>
</html>
