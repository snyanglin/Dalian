if(typeof GzjkMap == "undefined" || !GzjkMap){
	var GzjkMap = {};
};
GzjkMap.map = null;//声明地图对象
GzjkMap.syrkMarkerArr = new Array();//放点对象
GzjkMap.mbrArr = new Array();//组织机构辖区面对象集合
GzjkMap.Mbr = null;//辖区外边框
var ifClearAll = false;
GzjkMap = function(){
	this.pk = Math.random();
};
$(function(){
	GzjkMap.loadMap();
});
var centerPoints= new Array();//放点对象
GzjkMap.loadMap = function(){
	/*地图对象*/
	GzjkMap.map = new FrameTools.Map();
	/*设置地图代理*/
	GzjkMap.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	GzjkMap.map.setMapDiv("mapDiv");
	/*加载地图*/
	GzjkMap.map.onloadMap();
	/*显示鹰眼*/
	GzjkMap.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	GzjkMap.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	GzjkMap.map.showNewMapServer("mapDiv","GzjkMap.map");
	/*加载地图工具条*/
	GzjkMap.map.buildTools("mapDiv","toolDiv","GzjkMap.map");
	/*设置工具条显示的位置*/
	GzjkMap.diyToolDiv();
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){GzjkMap.diyToolDiv();});
	/*地图清空事件方法*/
	GzjkMap.map._MapApp.addMapEventListener(EzEvent.MAP_CLEAROVERLAYS,function(obj){
		ifClearAll = true;
	});
	if(bjzbz!="" && bjzbz!='null'){
		/*显示当前用户边界*/
		GzjkMap.moveMapToBjzbz();
	}
};

GzjkMap.diyToolDiv =function(){
	var top = $("#mapDiv").height() - 40;
	$("#toolDiv").css({
		"top" : top,
		"left" : 10
	});
};
GzjkMap.moveMapToBjzbz = function(){
	/*清楚地图上所有的标记*/
	GzjkMap.map._MapApp.clear();
	/*非地坐标*/
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/*记录边线中心点坐标*/
	GzjkMap.mbrArr = new Array();
	for(var j=0;j<bjnum;j++){
		var gArr = bj[j];
		/*创建边界图元素*/
		var polyline = GzjkMap.map.initPolyline(gArr,"blue");
		/*图元素添加到地图上*/
		if(polyline){
			GzjkMap.map._MapApp.addOverlay(polyline);
			GzjkMap.mbrArr.push(polyline);
			if(GzjkMap.Mbr==null){
				GzjkMap.Mbr = polyline.getMBR();
			}else{
				GzjkMap.Mbr = MBR.union(GzjkMap.Mbr,polyline.getMBR());
			}
		}
	}
	/*根据图元素将地图放到最适合的级别和位置*/
	GzjkMap.map._MapApp.centerAtMBR(GzjkMap.Mbr);
	/*新版本cliect自动适应级别有问题必须降一级*/
	GzjkMap.map._MapApp.zoomOut();
};


//主方法

//map上添加Marker
function addMarker(title,zbx,zby,imgName,msgHtml,mouseFun,imgWidth,imgHeight,ifClearMap,dz_jzdzdm,type){
	GzjkMap.map._MapApp.closeInfoWindow();
	if(ifClearMap){
		GzjkMap.clearMap();
	}
	 if(title=="" || title==null){
		 title="坐标定位";
	 }
	var marker = GzjkMap.map.initMarker(title,zbx,zby,imgName,null,null,imgWidth,imgHeight);
	//marker.flash(5);
	
	
	marker.addListener("click", function(){
		var msgHtml="";
	});
	GzjkMap.map._MapApp.addOverlay(marker);
	return marker;
};

GzjkMap.clearMap= function(){
	if(GzjkMap.pointObj){
		GzjkMap.map._MapApp.removeOverlay(GzjkMap.pointObj);
	}
	if(GzjkMap.pointBufferShape){
		GzjkMap.map._MapApp.removeOverlay(GzjkMap.pointBufferShape);
	}
	var objs = GzjkMap.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			var obj =objs[i].toString().split(",");
			if(obj.length<=2){
				GzjkMap.map._MapApp.removeOverlay(objs[i]);
			}else if(typePPP(objs[i])=="polygon"){
				GzjkMap.map._MapApp.removeOverlay(objs[i]);
			}
		}
	}
	if(GzjkMap.polygonObj){
		GzjkMap.map._MapApp.removeOverlay(GzjkMap.polygonObj);
	}
	//
	GzjkMap.map._MapApp.closeInfoWindow();
	//移动到适当的级别
	GzjkMap.MultiPointZoom(bjzbz);
};

//只清除marker
GzjkMap.clearMarkers = function(){
	GzjkMap.map._MapApp.closeInfoWindow();
	GzjkMap.map._MapApp.refresh();
	var objs = GzjkMap.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			var obj =objs[i].toString().split(",");
			if(obj.length<=2){
				GzjkMap.map._MapApp.removeOverlay(objs[i]);
			}
		}
	}
};
//清除地图上的查询图层
GzjkMap.clearGraph = function(){
	var objs = GzjkMap.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			if("getGeometryType" in objs[i] ){
				if(objs[i].getGeometryType()=="polygon"){
					GzjkMap.map._MapApp.removeOverlay(objs[i]);
				}else if(objs[i].getGeometryType()=="circle"){
					GzjkMap.map._MapApp.removeOverlay(objs[i]);
				}else if(objs[i].getGeometryType()=="rectangle"){
					GzjkMap.map._MapApp.removeOverlay(objs[i]);
				}
			}
		}
	}
}


//以点为对象居中
GzjkMap.centerByPoint = function(marker,zoomLevel,dz_jzdzdm){
	var point = marker.getPoint() ;
	if(ifClearAll){
		//GzjkMap.moveMapToBjzbz();
		//GzjkMap.map._MapApp.addOverlay(marker);
		//centerPoints.push(marker);
		marker.flash(5);
		marker.addListener("click", function(){
			var msgHtml = "";
				//queryPersonByDzDm(marker,dz_jzdzdm);
		});
	}
	GzjkMap.map._MapApp.centerAndZoom(point, zoomLevel);
	
};
//找最适合的地图放大级别
GzjkMap.MultiPointZoom = function (gjpoint){
	var gg = gjpoint.split(",");
	if(gg.length>2){
		var mp = new MultiPoint(gjpoint);
		var mr = mp.getMBR();
		var l = GzjkMap.map._MapApp.getLevelOfMBR(mr.minX,mr.minY,mr.maxX,mr.maxY);
		GzjkMap.map._MapApp.centerAtMBR(mr.minX,mr.minY,mr.maxX,mr.maxY);
		GzjkMap.map._MapApp.zoomTo(l);
	}else{
		GzjkMap.map._MapApp.centerAndZoom(new Point(gjpoint),_MapApp.getZoomLevel());
	}
};