<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
	//String zbx =  request.getParameter("zbx");
	//String zby =  request.getParameter("zby");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <title>地图定位</title>
    
	<script type="text/javascript">
	var ezmap = null;//地图对象
	mpdzMarkerArr = new Array();//放点对象
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
		//ezmap.addOverView();
		/*隐藏自带矢量影像图层对象*/
		ezmap._MapApp.hideMapServer();
		/*加载自定义的矢量影像图层对象*/
		ezmap.showNewMapServer("mapDiv","ezmap");
		/*隐藏地图操作控件，包括一般地图控件、简化地图控件和标准地图控件。*/
		ezmap._MapApp.hideMapControl();
	};
	
	//gem
	function getParm(name){
   		  var temp = "";
 	  	  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
 	  	  var r = window.location.search.substr(1).match(reg);
 	  	  if(r != null){
 	  		  temp = unescape(r[2]);
 	  	  } 
 	  	  return temp;
       }
       
	$(function(){
		loadMap();
		//gem
		var zbx = getParm("zbx");
		var zby = getParm("zby");
		var dwmc = getParm("dwmc");
		if (null != zbx && '' != zbx && null != zby && '' != zby) {
			doPoint(zbx, zby, dwmc);
		}
	});
	

/*
*gem 撒点
*/
function doPoint(x, y, dwmc){
	if(mpdzMarkerArr != null){
		var markerLen = mpdzMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			ezmap._MapApp.removeOverlay(mpdzMarkerArr[j]);
		}
	}
	var initMarker = ezmap.initMarker(dwmc, x, y,"syrkRedSmall.png",null,null,43,37);
	ezmap._MapApp.addOverlay(initMarker);
	ezmap._MapApp.centerAndZoom(new Point(x, y), 7); 
	mpdzMarkerArr.push(initMarker);
}

	</script>
  </head>
  <body>
  	<div width="100%" height="100%" id="mapDiv"></div>
  </body>
</html>
