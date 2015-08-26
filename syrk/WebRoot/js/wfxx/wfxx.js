/**
 * 
 * @description:物防地图操作
 * @author: tian_chengwei@founder.com      
 * @date:2015-06-02
 * 
 *  * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
if(typeof WfxxMap == "undefined" || !WfxxMap){
	var WfxxMap = {};
};
WfxxMap.map = null;//声明地图对象
WfxxMap.mbrArr = new Array();//组织机构辖区面对象集合
WfxxMap.Mbr = null;//辖区外边框
var ifClearAll = false;
WfxxMap = function(){
	this.pk = Math.random();
};
//初始化地图
$(function(){
	WfxxMap.loadMap();
});

WfxxMap.loadMap = function(){
	/*地图对象*/
	WfxxMap.map = new FrameTools.Map();
	/*设置地图代理*/
	WfxxMap.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	WfxxMap.map.setMapDiv("mapDiv");
	/*加载地图*/
	WfxxMap.map.onloadMap();
	/*显示鹰眼*/
	WfxxMap.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	WfxxMap.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	WfxxMap.map.showNewMapServer("mapDiv","WfxxMap.map");
	/*加载地图工具条*/
	WfxxMap.map.buildTools("mapDiv","toolDiv","WfxxMap.map");
	/*设置工具条显示的位置*/
	WfxxMap.diyToolDiv();
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){WfxxMap.diyToolDiv();});
	/*地图清空事件方法*/
	WfxxMap.map._MapApp.addMapEventListener(EzEvent.MAP_CLEAROVERLAYS,function(obj){
		ifClearAll = true;
	});
	WfxxMap.queryButton();
	if(bjzbz!="" && bjzbz!='null'){
		/*显示当前用户边界*/
		WfxxMap.moveMapToBjzbz();
	}
};
//工具条位置
WfxxMap.diyToolDiv =function(){
	//var left = $("#mapDiv").offset().left+5;
	//var top = $("#mapDiv").height() - 5;
	var top = $("#mapDiv").height() - 40;
	$("#toolDiv").css({
		"top" : top,
		"left" : 10
	});
};
//显示边界坐标
WfxxMap.moveMapToBjzbz = function(){
	/*清楚地图上所有的标记*/
	WfxxMap.map._MapApp.clear();
	/*非地坐标*/
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/*记录边线中心点坐标*/
	WfxxMap.mbrArr = new Array();
	for(var j=0;j<bjnum;j++){
		var gArr = bj[j];
		/*创建边界图元素*/
		var polyline = WfxxMap.map.initPolyline(gArr,"blue");
		/*图元素添加到地图上*/
		if(polyline){
			WfxxMap.map._MapApp.addOverlay(polyline);
			WfxxMap.mbrArr.push(polyline);
			if(WfxxMap.Mbr==null){
				WfxxMap.Mbr = polyline.getMBR();
			}else{
				WfxxMap.Mbr = MBR.union(WfxxMap.Mbr,polyline.getMBR());
			}
		}
	}
	/*根据图元素将地图放到最适合的级别和位置*/
	WfxxMap.map._MapApp.centerAtMBR(WfxxMap.Mbr);
	/*新版本cliect自动适应级别有问题必须降一级*/
	WfxxMap.map._MapApp.zoomOut();
};

var generalZbz = "";
var generalType = "";
var generalMapRadius="";
WfxxMap.polygonObj =null;
WfxxMap.point = null;
WfxxMap.mapRadius = null;
WfxxMap.pointBufferShape=null;
WfxxMap.pointObj=null;

//主方法

//map上添加Marker
function addMarker(title,zbx,zby,imgName,msgHtml,mouseFun,imgWidth,imgHeight,ifClearMap,dz_jzdzdm,type){
	WfxxMap.map._MapApp.closeInfoWindow();
	if(ifClearMap){
		WfxxMap.clearMap();
	}
	 if(title=="" || title==null){
		 title="坐标定位";
	 }
	var marker = WfxxMap.map.initMarker(title,zbx,zby,imgName,null,null,imgWidth,imgHeight);
	marker.addListener("click", function(){
		
	});
	
	WfxxMap.map._MapApp.addOverlay(marker);
	return marker;
};
//清除
WfxxMap.clearMap= function(){
	if(WfxxMap.pointObj){
		WfxxMap.map._MapApp.removeOverlay(WfxxMap.pointObj);
	}
	if(WfxxMap.pointBufferShape){
		WfxxMap.map._MapApp.removeOverlay(WfxxMap.pointBufferShape);
	}
	var objs = WfxxMap.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			var obj =objs[i].toString().split(",");
			if(obj.length<=2){
				WfxxMap.map._MapApp.removeOverlay(objs[i]);
			}else if(typePPP(objs[i])=="polygon"){
				WfxxMap.map._MapApp.removeOverlay(objs[i]);
			}
		}
	}
	if(WfxxMap.polygonObj){
		WfxxMap.map._MapApp.removeOverlay(WfxxMap.polygonObj);
	}
	//
	WfxxMap.map._MapApp.closeInfoWindow();
	//移动到适当的级别
	WfxxMap.MultiPointZoom(bjzbz);
};

//只清除marker
WfxxMap.clearMarkers = function(){
	WfxxMap.map._MapApp.closeInfoWindow();
	var objs = WfxxMap.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			var obj =objs[i].toString().split(",");
			if(obj.length<=2){
				WfxxMap.map._MapApp.removeOverlay(objs[i]);
			}
		}
	}
};
//清除地图上的查询图层
WfxxMap.clearGraph = function(){
	var objs = WfxxMap.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			if("getGeometryType" in objs[i] ){
				if(objs[i].getGeometryType()=="polygon"){
					WfxxMap.map._MapApp.removeOverlay(objs[i]);
				}else if(objs[i].getGeometryType()=="circle"){
					WfxxMap.map._MapApp.removeOverlay(objs[i]);
				}else if(objs[i].getGeometryType()=="rectangle"){
					WfxxMap.map._MapApp.removeOverlay(objs[i]);
				}
			}
		}
	}
}
//检查坐标值
function checkZbz(zbz){
	var flag = true;
	var zbs = zbz.toString().split(",");
	if(zbs.length==6){
		if(zbs[0]==zbs[4]&&zbs[1]==zbs[5]){
			$.messager.alert('提示','多边形存在问题，请重新输入！','warning');
			WfxxMap.clearMap();
			flag = false;
		}}else{
			if(WfxxMap.poylineIntersect(zbz)){
				$.messager.alert('提示','多边形轮廓不能有交叉，请重新输入！','warning');
				WfxxMap.clearMap();
				flag = false ;
			}
		}
	return flag;
}

//以点为对象居中
WfxxMap.centerByPoint = function(marker,zoomLevel,dz_jzdzdm){
	var point = marker.getPoint() ;
	//alert(marker.getZIndex());
	//marker.setZIndex(marker.getZIndex()+10000);
	//marker.flash(5);
	if(ifClearAll){
		WfxxMap.moveMapToBjzbz();
		WfxxMap.map._MapApp.addOverlay(marker);
		marker.addListener("click", function(){
			//var msgHtml = queryPersonByDzDm(marker,dz_jzdzdm);
		});
	}
	WfxxMap.map._MapApp.centerAndZoom(point, zoomLevel);
	
};
//空间查询
WfxxMap.drawPolygon = function(){
	WfxxMap.clearMap();
	WfxxMap.map._MapApp.changeDragMode('drawPolygon', null, null, WfxxMap.drawPolygon_back);
	
};
//回掉 
WfxxMap.drawPolygon_back = function(polygon){
	var polygonObj = new Polygon(polygon, "#A6CDEC", 5, 0.5, "#A6CDEC");
	WfxxMap.polygonObj = polygonObj;
	WfxxMap.map._MapApp.addOverlay(polygonObj);
	generalZbz  =polygon;
	generalType = 1;
	var flag = checkZbz(polygon);
	if(flag){
		WfxxMap.queryJzdz(polygon);
	}else{
		return;
	}
};
var WfxxId ="";

WfxxMap.drawPoint = function(id){
	//WfxxMap.clearMap();
	WfxxId= "";
	WfxxId = id;
	WfxxMap.map._MapApp.changeDragMode('drawPoint', null, null, WfxxMap.drawPoint_back);
};
WfxxMap.drawPoint_back = function(point){
	WfxxMap.point = point;
	generalZbz = point;
	generalType =2;
	
	var _coords = point.split(",");
	var x = _coords[0];
	var y = _coords[1];
	var _pPoint = new Point(x, y);
	var _icon = new Icon();
	_icon.image = contextPath + "/images/map/icons/dz_zb01.png";
	_icon.width = 24;
	_icon.height = 30;
	_icon.topOffset = -(_icon.height / 2);
	var marker = new Marker(_pPoint, _icon);
	WfxxMap.pointObj = marker; 
	
	WfxxMap.map._MapApp.addOverlay(marker);
	//ajax保存坐标
	WfxxMap.map.addZb(WfxxId,x, y, "POST", "/wfxx/updateWf", WfxxMap.back);
};

WfxxMap.back = function(json){
	if(json.status=="success"){
		topMessager.show({
			title: "物防坐标采集",
			msg: "坐标采集成功",
			timeout:1500
		});
		var obj = parent.frames.document.getElementById("main_left");
		obj.contentWindow.loadGrid();
	}else{
		topMessager.show({
			title: "物防坐标采集",
			msg: "坐标采集失败",
			timeout:1500
		});
	}
	
	
}
//多边形空间查询
WfxxMap.drawRect=function(){
	WfxxMap.clearMap();
	WfxxMap.map._MapApp.changeDragMode('drawRect', null, null, WfxxMap.drawRect_back);
};

WfxxMap.drawRect_back = function(polygon){
	var polygonObj = new Polygon(polygon, "#A6CDEC", 5, 0.5, "#A6CDEC");
	WfxxMap.polygonObj = polygonObj;
	WfxxMap.map._MapApp.addOverlay(polygonObj);
	generalZbz  =polygon;
	generalType = 3;
	var flag = checkZbz(polygon);
	if(flag){
		WfxxMap.queryJzdz(polygon);
	}else{
		return;
	}
};
//圆形空间查询
WfxxMap.drawCircle=function(){
	WfxxMap.clearMap();
	WfxxMap.map._MapApp.changeDragMode('drawCircle', null, null, WfxxMap.drawCircle_back);
};
//回调
WfxxMap.drawCircle_back = function(circle){
	WfxxMap.point = circle;
	generalZbz = circle;
	generalType =2;
	//查询
	WfxxMap.queryJzdz();
};
//根据点击执行对应的空间查询方法
WfxxMap.oprateMap = function(type){
	switch(type){
		case 1: WfxxMap.drawPolygon();break;
		case 2: WfxxMap.drawCircle();break;
		case 3: WfxxMap.drawRect();break;
	}
};

//判断是否相交
WfxxMap.poylineIntersect = function (lineStr){
	var zbArr = lineStr.split(",");
	for(var i = 0 ;i < zbArr.length - 4 ;i += 2){
		for(var j = i+4;j < zbArr.length-2;j += 2){
			if(i!=0||j < zbArr.length-4){//不对第一条线和最后一条线做比较
				var a={};
				var b={};
				var c={};
				var d={};
				a.x=zbArr[i];
				a.y=zbArr[i+1];
				b.x=zbArr[i+2];
				b.y=zbArr[i+3];
				c.x=zbArr[j];
				c.y=zbArr[j+1];
				d.x=zbArr[j+2];
				d.y=zbArr[j+3];
				if(WfxxMap.lineIntersect(a,b,c,d))
					return true;
			}
		}
	}
	return false;
};

/**
 * 地图上多边形查询
 */
WfxxMap.queryJzdz = function(){
	var obj = parent.frames.document.getElementById("main_left");
	obj.contentWindow.document.getElementById("zbz").value = generalZbz;
	obj.contentWindow.document.getElementById("type").value = generalType;
	obj.contentWindow.document.getElementById("mapRadius").value = generalMapRadius;
	obj.contentWindow.reloadGrid();
};

/**
 * 查询按钮的放置位置
 */
WfxxMap.queryButton = function(){
	var html = "<div style='position:absolute;right:5px;top:100px;width:200px;'>" +
	"<img id='img4' onclick='WfxxMap.oprateMap(3)' style='cursor:hand;' title='拉框查询' src='../images/map/icons/icon_box_select01.png'>&nbsp;&nbsp;" +
	"<img id='img1' onclick='WfxxMap.oprateMap(1)' style='cursor:hand;' title='多变形查询' src='../images/map/icons/icon_polygon_select01.png'>&nbsp;&nbsp;" +
	"<img id='img2' onclick='WfxxMap.oprateMap(2)' style='cursor:hand;' title='点周边查询' src='../images/map/icons/icon_ellip_select01.png'>&nbsp;&nbsp;" +
	"<img id='img3' onclick='WfxxMap.reset()' style='cursor:hand;' title='重置' src='../images/map/icons/icon_back_select01.png'>&nbsp;&nbsp;" +
	"</div>";
	$("#mapDiv").append(html);
};
//清除
WfxxMap.reset= function(){
	WfxxMap.clearMap();
	WfxxMap.clearGraph();
	var obj = parent.frames.document.getElementById("main_left");
	obj.contentWindow.loadGrid();
};

//返回对象类型
function typePPP(obj){
	return obj.getGeometryType();
}

//判断线段是否相交
WfxxMap.lineIntersect = function (a,b,c,d) {
	// 三角形abc 面积的2倍  
    var area_abc = (a.x - c.x) * (b.y - c.y) - (a.y - c.y) * (b.x - c.x);  
  
    // 三角形abd 面积的2倍  
    var area_abd = (a.x - d.x) * (b.y - d.y) - (a.y - d.y) * (b.x - d.x);   
  
    // 面积符号相同则两点在线段同侧,不相交 (对点在线段上的情况,本例当作不相交处理);  
    if ( area_abc*area_abd>=0 ) {  
        return false;  
    }  
  
    // 三角形cda 面积的2倍  
    var area_cda = (c.x - a.x) * (d.y - a.y) - (c.y - a.y) * (d.x - a.x);  
    // 三角形cdb 面积的2倍  
    // 注意: 这里有一个小优化.不需要再用公式计算面积,而是通过已知的三个面积加减得出.  
    var area_cdb = area_cda + area_abc - area_abd ;  
    if (  area_cda * area_cdb >= 0 ) {  
        return false;  
    }  
    return true;  
    //计算交点坐标  
//    var t = area_cda / ( area_abd- area_abc );  
//    var dx= t*(b.x - a.x),  
//        dy= t*(b.y - a.y);  
//    return { x: a.x + dx , y: a.y + dy };  
};

WfxxMap.MultiPointZoom = function (gjpoint){
	var gg = gjpoint.split(",");
	if(gg.length>2){
		var mp = new MultiPoint(gjpoint);
		var mr = mp.getMBR();
		var l = WfxxMap.map._MapApp.getLevelOfMBR(mr.minX,mr.minY,mr.maxX,mr.maxY);
		WfxxMap.map._MapApp.centerAtMBR(mr.minX,mr.minY,mr.maxX,mr.maxY);
		WfxxMap.map._MapApp.zoomTo(l);
	}else{
		WfxxMap.map._MapApp.centerAndZoom(new Point(gjpoint),_MapApp.getZoomLevel());
	}
};