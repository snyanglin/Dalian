/*
 * @Author: [wu_chunhui@founder.com.cn]
 * */

if(typeof SyrkMap == "undefined" || !SyrkMap){
	var SyrkMap = {};
};
SyrkMap.map = null;//声明地图对象
SyrkMap.syrkMarkerArr = new Array();//放点对象
SyrkMap.mbrArr = new Array();//组织机构辖区面对象集合
SyrkMap.Mbr = null;//辖区外边框
var ifClearAll = false;
//空间查询
SyrkMap.drawMode="";
SyrkMap.pointBufferShape=null;
SyrkMap.generalZbz="";
SyrkMap.generalMapRadius="";
//空间查询end
SyrkMap = function(){
	this.pk = Math.random();
};
$(function(){
	if(typeof EzServerClient != "undefined" && EzServerClient){
	SyrkMap.loadMap();
	}
});

SyrkMap.loadMap = function(){
	
	/*地图对象*/
	SyrkMap.map = new FrameTools.Map();
	/*设置地图代理*/
	SyrkMap.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	SyrkMap.map.setMapDiv("mapDiv");
	/*加载地图*/
	SyrkMap.map.onloadMap();
	/*显示鹰眼*/
	SyrkMap.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	SyrkMap.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	SyrkMap.map.showNewMapServer("mapDiv","SyrkMap.map");
	/*加载地图工具条*/
	SyrkMap.map.buildTools("mapDiv","toolDiv","SyrkMap.map");
	/*设置工具条显示的位置*/
	SyrkMap.diyToolDiv();
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){SyrkMap.diyToolDiv();});
	SyrkMap.map._MapApp.addMapEventListener(EzEvent.MAP_CLEAROVERLAYS,function(obj){
		ifClearAll = true;
	});
	//SyrkMap.queryButton();
	if(bjzbz!="" && bjzbz!='null'){
		/*显示当前用户边界*/
		SyrkMap.moveMapToBjzbz();
	}
};
SyrkMap.diyToolDiv =function(){
	var top = $("#mapDiv").height() - 40;
	$("#toolDiv").css({
		"top" : top,
		"left" : 10
	});
};


SyrkMap.moveMapToBjzbz = function(){
	/*清楚地图上所有的标记*/
	SyrkMap.map._MapApp.clear();
	/*非地坐标*/
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/*记录边线中心点坐标*/
	SyrkMap.mbrArr = new Array();
	for(var j=0;j<bjnum;j++){
		var gArr = bj[j];
		/*创建边界图元素*/
		var polyline = SyrkMap.map.initPolyline(gArr,"blue");
		/*图元素添加到地图上*/
		if(polyline){
			SyrkMap.map._MapApp.addOverlay(polyline);
			SyrkMap.mbrArr.push(polyline);
			if(SyrkMap.Mbr==null){
				SyrkMap.Mbr = polyline.getMBR();
			}else{
				SyrkMap.Mbr = MBR.union(SyrkMap.Mbr,polyline.getMBR());
			}
		}
	}
	/*根据图元素将地图放到最适合的级别和位置*/
	SyrkMap.map._MapApp.centerAtMBR(SyrkMap.Mbr);
	/*新版本cliect自动适应级别有问题必须降一级*/
	SyrkMap.map._MapApp.zoomOut();
};
/**
 * 查询按钮的放置位置
 */
SyrkMap.queryButton = function(){
	var html = "<div style='position:absolute;right:5px;top:100px;width:200px;'>" +
	"<img id='img4' onclick='SyrkMap.drawRange(\"drawRect\")' style='cursor:hand;' title='拉框查询' src='../images/map/icons/icon_box_select01.png'>&nbsp;&nbsp;" +
	"<img id='img1' onclick='SyrkMap.drawRange(\"drawPolygon\")' style='cursor:hand;' title='多变形查询' src='../images/map/icons/icon_polygon_select01.png'>&nbsp;&nbsp;" +
	"<img id='img2' onclick='SyrkMap.drawRange(\"drawPoint\")' style='cursor:hand;' title='点周边查询' src='../images/map/icons/icon_ellip_select01.png'>&nbsp;&nbsp;" +
	"<img id='img3' onclick='SyrkMap.reset()' style='cursor:hand;' title='重置' src='../images/map/icons/icon_back_select01.png'>&nbsp;&nbsp;" +
	"</div>";
	$("#mapDiv").append(html);
};

/*画图方法*/
SyrkMap.drawRange=function(drawMode){
	SyrkMap.clearMap();
	SyrkMap.drawMode=drawMode;
	SyrkMap.map._MapApp.changeDragMode(drawMode, null, null, SyrkMap.drawRange_back);
}

/*画图回调*/
SyrkMap.drawRange_back=function(polygon){
	SyrkMap.generalZbz=polygon;
	var polygonObj = new Polygon(polygon, "#A6CDEC", 5, 0.5, "#A6CDEC");
	if(SyrkMap.drawMode=="drawPoint"){
		var _coords = polygon.split(",");
		var x = _coords[0];
		var y = _coords[1];
		var _pPoint = new Point(x, y);
		var _icon = new Icon();
		_icon.image = contextPath + "/images/map/icons/location.png";
		_icon.width = 24;
		_icon.height = 30;
		_icon.topOffset = -(_icon.height / 2);
		var marker = new Marker(_pPoint, _icon);
		SyrkMap.map._MapApp.addOverlay(marker);
		var distance = 100;;//周边100米的距离
		var mapRadius = SyrkMap.map._MapApp.getDegree(_pPoint, distance);
		var _coords =polygon + "," + mapRadius;
		SyrkMap.generalMapRadius = mapRadius;
		polygonObj = new Circle(_coords, "#A6CDEC", 5, 0.5, "#A6CDEC");
		SyrkMap.pointBufferShape = polygonObj;
	}
	SyrkMap.map._MapApp.addOverlay(polygonObj);
	if(checkZbz(polygon)){
		SyrkMap.queryJzdz();
	}else{
		return;
	}
}

SyrkMap.reset= function(){
	SyrkMap.clearMap();
	SyrkMap.clearGraph();
	var obj = parent.frames.document.getElementById("main_left");
	obj.contentWindow.loadGrid();
};

/*清理地图，并且重新初始化*/
SyrkMap.clearMap= function(){
	if(SyrkMap.pointBufferShape){
		SyrkMap.map._MapApp.removeOverlay(SyrkMap.pointBufferShape);
	}
	var objs = SyrkMap.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			var obj =objs[i].toString().split(",");
			if(obj.length<=2){
				SyrkMap.map._MapApp.removeOverlay(objs[i]);
			}else if(typePPP(objs[i])=="polygon"||typePPP(objs[i])=="rectangle"){
				SyrkMap.map._MapApp.removeOverlay(objs[i]);
			}
		}
	}

	SyrkMap.map._MapApp.closeInfoWindow();
	//移动到适当的级别
	//SyrkMap.MultiPointZoom(bjzbz);
};

SyrkMap.MultiPointZoom = function (gjpoint){
	var gg = gjpoint.split(",");
	if(gg.length>2){
		var mp = new MultiPoint(gjpoint);
		var mr = mp.getMBR();
		var l = SyrkMap.map._MapApp.getLevelOfMBR(mr.minX,mr.minY,mr.maxX,mr.maxY);
		SyrkMap.map._MapApp.centerAtMBR(mr.minX,mr.minY,mr.maxX,mr.maxY);
		SyrkMap.map._MapApp.zoomTo(l);
	}else{
	SyrkMap.map._MapApp.centerAndZoom(new Point(gjpoint),_MapApp.getZoomLevel());
	}
};


function checkZbz(zbz){
	var flag = true;
	var zbs = zbz.toString().split(",");
	if(zbs.length==6){
		if(zbs[0]==zbs[4]&&zbs[1]==zbs[5]){
			$.messager.alert('提示','多边形存在问题，请重新输入！','warning');
			SyrkMap.clearMap();
			flag = false;
		}}else{
			if(SyrkMap.poylineIntersect(zbz)){
				$.messager.alert('提示','多边形轮廓不能有交叉，请重新输入！','warning');
				SyrkMap.clearMap();
				flag = false ;
			}
		}
	return flag;
}




//判断是否相交
SyrkMap.poylineIntersect = function (lineStr){
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
				if(SyrkMap.lineIntersect(a,b,c,d))
					return true;
			}
		}
	}
	return false;
};

//返回对象类型
function typePPP(obj){
	return obj.getGeometryType();
}

//判断线段是否相交
SyrkMap.lineIntersect = function (a,b,c,d) {
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
};

//map上添加Marker
SyrkMap.addMarker = function (title,zbx,zby,imgName,msgHtml,mouseFun,imgWidth,imgHeight,ifClearMap,dz_jzdzdm,type){
	if(typeof EzServerClient != "undefined" && EzServerClient){
	SyrkMap.map._MapApp.closeInfoWindow();
	}
	if(ifClearMap){
		SyrkMap.clearMap();
	}
	 if(title=="" || title==null){
		 title="坐标定位";
	 }
	var marker = SyrkMap.map.initMarker(title,zbx,zby,imgName,null,null,imgWidth,imgHeight);
	marker.addListener("click", function(){
		/*if(type=="zdrk"){
			var msgHtml = groupByDzId_Zdrk(marker,dz_jzdzdm);
		}else{
			var msgHtml = queryPersonByDzDm(marker,dz_jzdzdm);
		}*/
		
	});
	
	SyrkMap.map._MapApp.addOverlay(marker);
	return marker;
};

//以点为对象居中
SyrkMap.centerByPoint = function(marker,zoomLevel,dz_dwdzdm){
	var point = marker.getPoint() ;
	if(ifClearAll){
		SyrkMap.moveMapToBjzbz();
		SyrkMap.map._MapApp.addOverlay(marker);
		marker.addListener("click", function(){
			//var msgHtml = queryDwByDzDm(marker,dz_dwdzdm);
		});
	}
	SyrkMap.map._MapApp.centerAndZoom(point, zoomLevel);
	
};


/**
 * 地图上多边形查询
 */
SyrkMap.queryJzdz = function(){
	var generalType='0';
	if(SyrkMap.drawMode=="drawPoint"){
		generalType='2'
	}else if(SyrkMap.drawMode=="drawPolygon"){
		generalType='1'
	}
	else if(SyrkMap.drawMode=="drawRect"){
		generalType='3'
	}
	var obj = parent.frames.document.getElementById("main_left");
	obj.contentWindow.document.getElementById("zbz").value = SyrkMap.generalZbz;
	obj.contentWindow.document.getElementById("type").value = generalType;
	obj.contentWindow.document.getElementById("mapRadius").value = SyrkMap.generalMapRadius;
	obj.contentWindow.reloadGrid();
};



//只清除marker
SyrkMap.clearMarkers = function(){
	SyrkMap.map._MapApp.closeInfoWindow();
	var objs = SyrkMap.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			var obj =objs[i].toString().split(",");
			if(obj.length<=2){
				SyrkMap.map._MapApp.removeOverlay(objs[i]);
			}
		}
	}
};
//map上添加Marker
function addMarker(title,zbx,zby,imgName,msgHtml,mouseFun,imgWidth,imgHeight,ifClearMap,dz_dwdzdm,type){
	SyrkMap.map._MapApp.closeInfoWindow();
	if(ifClearMap){
		SyrkMap.clearMap();
	}
	 if(title=="" || title==null){
		 title="坐标定位";
	 }
	var marker = SyrkMap.map.initMarker(title,zbx,zby,imgName,null,null,imgWidth,imgHeight);
	marker.addListener("click", function(){
		//if(type=="zdrk"){
			//var msgHtml = groupByDzId_Zdrk(marker,dz_jzdzdm);
		//}else{
	
			//var msgHtml = queryDwByDzDm(marker,dz_dwdzdm);
		//}
		
	});
	
	SyrkMap.map._MapApp.addOverlay(marker);
	return marker;
};

//清除地图上的查询图层
SyrkMap.clearGraph = function(){
	var objs = SyrkMap.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			if("getGeometryType" in objs[i] ){
				if(objs[i].getGeometryType()=="polygon"){
					SyrkMap.map._MapApp.removeOverlay(objs[i]);
				}else if(objs[i].getGeometryType()=="circle"){
					SyrkMap.map._MapApp.removeOverlay(objs[i]);
				}else if(objs[i].getGeometryType()=="rectangle"){
					SyrkMap.map._MapApp.removeOverlay(objs[i]);
				}
			}
		}
	}
}


/**
 * 
 */




