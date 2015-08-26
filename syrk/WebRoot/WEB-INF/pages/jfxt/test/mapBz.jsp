<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String bjzbz = "";
    if(userInfo!=null){
        bjzbz = userInfo.getBjzbz();
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
<head>
<title>地图标注</title>
<script type="text/javascript">
	if (typeof MapBz == "undefined" || !MapBz) {
		var MapBz = {};
	};
	var bjzbz = "<%=bjzbz%>";
	MapBz.map = null;
	MapBz.markerObj = null;
	MapBz.mbrArr = new Array();//组织机构辖区面对象集合
    MapBz.Mbr = null;//辖区外边框
	MapBz.loadMap = function() {
		/*地图对象*/
		MapBz.map = new FrameTools.Map();
		/*设置地图代理*/
		MapBz.map.setProxy(contextPath + "/Proxy");
		/*设置地图加载容器*/
		MapBz.map.setMapDiv("map");
		/*加载地图*/
		MapBz.map.onloadMap();
		/*显示鹰眼*/
		MapBz.map.addOverView();
		/*隐藏自带矢量影像图层对象*/
	    MapBz.map._MapApp.hideMapServer();
	    /*加载自定义的矢量影像图层对象*/
	    MapBz.map.showNewMapServer("map","MapBz.map");
	    if(bjzbz!="" && bjzbz!='null'){
			/*显示当前用户边界*/
			MapBz.moveMapToBjzbz();
	    }
	    /*双击进入标注标点状态*/	
	    MapBz.map._MapApp.addMapEventListener(EzEvent.MAP_CLICK,function(obj){MapBz.moveMapToDrawPoint();});
	    MapBz.queryButton();
	};
	MapBz.moveMapToBjzbz = function(){
		/*清楚地图上所有的标记*/
		MapBz.map._MapApp.clear();
		/*非地坐标*/
		var bj = bjzbz.split(";");
		var bjnum = bj.length;
		/*记录边线中心点坐标*/
		MapBz.mbrArr = new Array();
		for(var j=0;j<bjnum;j++){
			var gArr = bj[j];
			/*创建边界图元素*/
			var polyline = MapBz.map.initPolyline(gArr,"blue");
			/*图元素添加到地图上*/
			if(polyline){
				MapBz.map._MapApp.addOverlay(polyline);
				MapBz.mbrArr.push(polyline);
				if(MapBz.Mbr==null){
					MapBz.Mbr = polyline.getMBR();
				}else{
					MapBz.Mbr = MBR.union(MapBz.Mbr,polyline.getMBR());
				}
			}
		}
		/*根据图元素将地图放到最适合的级别和位置*/
		MapBz.map._MapApp.centerAtMBR(MapBz.Mbr);
		/*新版本cliect自动适应级别有问题必须降一级*/
		MapBz.map._MapApp.zoomOut();
	};
	MapBz.moveMapToDrawPoint = function(){
	      MapBz.map._MapApp.changeDragMode("drawPoint",null,null,function(obj){
	            var pointArray = obj.split(",");
	            if(MapBz.markerObj!=null){
					MapBz.map._MapApp.removeOverlay(MapBz.markerObj);
				}
	      		MapBz.markerObj = MapBz.map.initMarker("",pointArray[0],pointArray[1],"location.png",null,null,25,25);
	      		MapBz.map._MapApp.addOverlay(MapBz.markerObj);
	      		parent.document.getElementById("entity_zbx").value = pointArray[0];
				parent.document.getElementById("entity_zby").value = pointArray[1];
	      });
	};
	MapBz.queryButton = function(){
		var html = "<div style='position:absolute;right:2px;top:80px;width:40px;'>" +
		           "<img id='img2' onclick='MapBz.moveMapToDrawPoint()' style='cursor:hand;' title='点编辑模式' src='../images/map/icons/icon_ellip_select01.png'>&nbsp;&nbsp;" +
		           "</div>";
		$("#map").append(html);
	};
	MapBz.ShubiaoYouji = function(){
		MapBz.map._MapApp.changeDragMode("pan", null, null, null);
	};
	document.oncontextmenu = MapBz.ShubiaoYouji;
	
	
	
	function displayMarker(zbx,zby,title,imgName,msgHtml,mouseFun,imgWidth,imgHeight){
		
		var pPoint = new Point(zbx,zby);
		var pIcon = new Icon();
		if(!imgWidth){
			pIcon.width = 16;
		}else{
			pIcon.width = imgWidth;
		}
		if(!imgHeight){
			pIcon.height = 16;
		}else{
			pIcon.height = imgHeight;
		}
		pIcon.image = contextPath+"/images/map/icons/";
		
		if(imgName==null||imgName=="")
			pIcon.image += "location.png";
		else
			pIcon.image += imgName;
		var pTitle = new Title(title, 12, 7, "宋体", "#000000", "#FFFFFF", "#FFFFFF", "2");
		var pMarker = "";
		if(title==null||title==""){
			pMarker = new Marker(pPoint, pIcon);
		}else{
			pMarker = new Marker(pPoint, pIcon ,pTitle);
		}
		pMarker.setZIndex(100);
		MapBz.map._MapApp.addOverlay(pMarker);
	}
</script>
</head>
<body onload="MapBz.loadMap();" style="overflow: hidden;">
	<div id="map" style="width:100%;height:100%;"></div>
</body>
</html>