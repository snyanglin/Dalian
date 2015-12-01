/*
 * @Author: [wu_chunhui@founder.com.cn]
 * */

if(typeof SydwMap == "undefined" || !SydwMap){
	var SydwMap = {};
};
SydwMap.map = null;//声明地图对象
SydwMap.syrkMarkerArr = new Array();//放点对象
SydwMap.mbrArr = new Array();//组织机构辖区面对象集合
SydwMap.Mbr = null;//辖区外边框
var ifClearAll = false;
//空间查询
SydwMap.drawMode="";
SydwMap.pointBufferShape=null;
SydwMap.generalZbz="";
SydwMap.generalMapRadius="";
//空间查询end
SydwMap = function(){
	this.pk = Math.random();
};
$(function(){
	if(typeof EzServerClient != "undefined" && EzServerClient){
	SydwMap.loadMap();
	}
});

SydwMap.loadMap = function(){
	
	/*地图对象*/
	SydwMap.map = new FrameTools.Map();
	/*设置地图代理*/
	SydwMap.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	SydwMap.map.setMapDiv("mapDiv");
	/*加载地图*/
	SydwMap.map.onloadMap();
	/*显示鹰眼*/
	SydwMap.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	SydwMap.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	SydwMap.map.showNewMapServer("mapDiv","SydwMap.map");
	/*加载地图工具条*/
	SydwMap.map.buildTools("mapDiv","toolDiv","SydwMap.map");
	/*设置工具条显示的位置*/
	SydwMap.diyToolDiv();
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){SydwMap.diyToolDiv();});
	SydwMap.map._MapApp.addMapEventListener(EzEvent.MAP_CLEAROVERLAYS,function(obj){
		ifClearAll = true;
	});
	//SydwMap.queryButton();
	//SydwMap.queryButton();
	if(bjzbz!="" && bjzbz!='null'){
		/*显示当前用户边界*/
		SydwMap.moveMapToBjzbz();
	}
};
/**
 * @title:diyToolDiv
 * @description:设置工具条显示的位置
 * @author: zhang_guoliang@founder.com
 * @param 显示位置进行了调整  
 * @date:2015-03-10 10:31:42
 */	
SydwMap.diyToolDiv =function(){
	var top = $("#mapDiv").height() - 40;
	$("#toolDiv").css({
		"top" : top,
		"left" : 10
	});
};
function showarea(area){
	/*创建边界图元素*/
	var polyline = SydwMap.map.initPolyline(area,"blue");
	/*图元素添加到地图上*/
	if(polyline){
		SydwMap.map._MapApp.addOverlay(polyline);
		SydwMap.mbrArr.push(polyline);
		if(SydwMap.Mbr==null){
			SydwMap.Mbr = polyline.getMBR();
		}else{
			SydwMap.Mbr = MBR.union(SydwMap.Mbr,polyline.getMBR());
		}
	}
}
SydwMap.moveMapToBjzbz = function(){
	/*清楚地图上所有的标记*/
	SydwMap.map._MapApp.clear();
	/*非地坐标*/
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/*记录边线中心点坐标*/
	SydwMap.mbrArr = new Array();
	for(var j=0;j<bjnum;j++){
		var gArr = bj[j];
		/*创建边界图元素*/
		var polyline = SydwMap.map.initPolyline(gArr,"blue");
		/*图元素添加到地图上*/
		if(polyline){
			SydwMap.map._MapApp.addOverlay(polyline);
			SydwMap.mbrArr.push(polyline);
			if(SydwMap.Mbr==null){
				SydwMap.Mbr = polyline.getMBR();
			}else{
				SydwMap.Mbr = MBR.union(SydwMap.Mbr,polyline.getMBR());
			}
		}
	}
	/*根据图元素将地图放到最适合的级别和位置*/
	SydwMap.map._MapApp.centerAtMBR(SydwMap.Mbr);
	/*新版本cliect自动适应级别有问题必须降一级*/
	SydwMap.map._MapApp.zoomOut();
};
/**
 * 查询按钮的放置位置
 */
SydwMap.queryButton = function(){
	var html = "<div style='position:absolute;right:5px;top:100px;width:200px;'>" +
	"<img id='img4' onclick='SydwMap.drawRange(\"drawRect\")' style='cursor:hand;' title='拉框查询' src='../images/map/icons/icon_box_select01.png'>&nbsp;&nbsp;" +
	"<img id='img1' onclick='SydwMap.drawRange(\"drawPolygon\")' style='cursor:hand;' title='多变形查询' src='../images/map/icons/icon_polygon_select01.png'>&nbsp;&nbsp;" +
	"<img id='img2' onclick='SydwMap.drawRange(\"drawPoint\")' style='cursor:hand;' title='点周边查询' src='../images/map/icons/icon_ellip_select01.png'>&nbsp;&nbsp;" +
	"<img id='img3' onclick='SydwMap.reset()' style='cursor:hand;' title='重置' src='../images/map/icons/icon_back_select01.png'>&nbsp;&nbsp;" +
	"</div>";
	$("#mapDiv").append(html);
};

/*画图方法*/
SydwMap.drawRange=function(drawMode){
	SydwMap.clearMap();
	SydwMap.drawMode=drawMode;
	SydwMap.map._MapApp.changeDragMode(drawMode, null, null, SydwMap.drawRange_back);
}

/*画图回调*/
SydwMap.drawRange_back=function(polygon){
	SydwMap.generalZbz=polygon;
	var polygonObj = new Polygon(polygon, "#A6CDEC", 5, 0.5, "#A6CDEC");
	if(SydwMap.drawMode=="drawPoint"){
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
		SydwMap.map._MapApp.addOverlay(marker);
		var distance = 100;;//周边100米的距离
		var mapRadius = SydwMap.map._MapApp.getDegree(_pPoint, distance);
		var _coords =polygon + "," + mapRadius;
		SydwMap.generalMapRadius = mapRadius;
		polygonObj = new Circle(_coords, "#A6CDEC", 5, 0.5, "#A6CDEC");
		SydwMap.pointBufferShape = polygonObj;
	}
	SydwMap.map._MapApp.addOverlay(polygonObj);
	if(checkZbz(polygon)){
		SydwMap.queryJzdz();
	}else{
		return;
	}
}

SydwMap.reset= function(){
	SydwMap.clearMap();
	SydwMap.clearGraph();
	var obj = parent.frames.document.getElementById("main_left");
	obj.contentWindow.loadGrid();
};

/*清理地图，并且重新初始化*/
SydwMap.clearMap= function(){
	if(SydwMap.pointBufferShape){
		SydwMap.map._MapApp.removeOverlay(SydwMap.pointBufferShape);
	}
	var objs = SydwMap.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			var obj =objs[i].toString().split(",");
			if(obj.length<=2){
				SydwMap.map._MapApp.removeOverlay(objs[i]);
			}else if(typePPP(objs[i])=="polygon"||typePPP(objs[i])=="rectangle"){
				SydwMap.map._MapApp.removeOverlay(objs[i]);
			}
		}
	}

	SydwMap.map._MapApp.closeInfoWindow();
	//移动到适当的级别
	//SydwMap.MultiPointZoom(bjzbz);
};

SydwMap.MultiPointZoom = function (gjpoint){
	var gg = gjpoint.split(",");
	if(gg.length>2){
		var mp = new MultiPoint(gjpoint);
		var mr = mp.getMBR();
		var l = SydwMap.map._MapApp.getLevelOfMBR(mr.minX,mr.minY,mr.maxX,mr.maxY);
		SydwMap.map._MapApp.centerAtMBR(mr.minX,mr.minY,mr.maxX,mr.maxY);
		SydwMap.map._MapApp.zoomTo(l);
	}else{
	SydwMap.map._MapApp.centerAndZoom(new Point(gjpoint),_MapApp.getZoomLevel());
	}
};


function checkZbz(zbz){
	var flag = true;
	var zbs = zbz.toString().split(",");
	if(zbs.length==6){
		if(zbs[0]==zbs[4]&&zbs[1]==zbs[5]){
			$.messager.alert('提示','多边形存在问题，请重新输入！','warning');
			SydwMap.clearMap();
			flag = false;
		}}else{
			if(SydwMap.poylineIntersect(zbz)){
				$.messager.alert('提示','多边形轮廓不能有交叉，请重新输入！','warning');
				SydwMap.clearMap();
				flag = false ;
			}
		}
	return flag;
}




//判断是否相交
SydwMap.poylineIntersect = function (lineStr){
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
				if(SydwMap.lineIntersect(a,b,c,d))
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
SydwMap.lineIntersect = function (a,b,c,d) {
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
SydwMap.addMarker = function (title,zbx,zby,imgName,msgHtml,mouseFun,imgWidth,imgHeight,ifClearMap,dz_jzdzdm,type){
	if(typeof EzServerClient != "undefined" && EzServerClient){
	SydwMap.map._MapApp.closeInfoWindow();
	}
	if(ifClearMap){
		SydwMap.clearMap();
	}
	 if(title=="" || title==null){
		 title="坐标定位";
	 }
	var marker = SydwMap.map.initMarker(title,zbx,zby,imgName,null,null,imgWidth,imgHeight);
	marker.addListener("click", function(){
		/*if(type=="zdrk"){
			var msgHtml = groupByDzId_Zdrk(marker,dz_jzdzdm);
		}else{
			var msgHtml = queryPersonByDzDm(marker,dz_jzdzdm);
		}*/
		
	});
	
	SydwMap.map._MapApp.addOverlay(marker);
	return marker;
};

//以点为对象居中
SydwMap.centerByPoint = function(marker,zoomLevel,dz_dwdzdm){
	var point = marker.getPoint() ;
	if(ifClearAll){
		SydwMap.moveMapToBjzbz();
		SydwMap.map._MapApp.addOverlay(marker);
		marker.addListener("click", function(){
			var msgHtml = queryDwByDzDm(marker,dz_dwdzdm);
		});
	}
	SydwMap.map._MapApp.centerAndZoom(point, zoomLevel);
	
};


/**
 * 地图上多边形查询
 */
SydwMap.queryJzdz = function(){
	var generalType='0';
	if(SydwMap.drawMode=="drawPoint"){
		generalType='2'
	}else if(SydwMap.drawMode=="drawPolygon"){
		generalType='1'
	}
	else if(SydwMap.drawMode=="drawRect"){
		generalType='3'
	}
	var obj = parent.frames.document.getElementById("main_left");
	obj.contentWindow.document.getElementById("zbz").value = SydwMap.generalZbz;
	obj.contentWindow.document.getElementById("type").value = generalType;
	obj.contentWindow.document.getElementById("mapRadius").value = SydwMap.generalMapRadius;
	obj.contentWindow.reloadGrid();
};



//只清除marker
SydwMap.clearMarkers = function(){
	SydwMap.map._MapApp.closeInfoWindow();
	var objs = SydwMap.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			var obj =objs[i].toString().split(",");
			if(obj.length<=2){
				SydwMap.map._MapApp.removeOverlay(objs[i]);
			}
		}
	}
};
//map上添加Marker
function addMarker(title,zbx,zby,imgName,msgHtml,mouseFun,imgWidth,imgHeight,ifClearMap,dz_dwdzdm,type){
	//SydwMap.map._MapApp.closeInfoWindow();
	//zbx='121.58475',zby='38.90452';
	if(ifClearMap){
		//SydwMap.clearMap();
	}
	 if(title=="" || title==null){
		 title="坐标定位";
	 }
	var marker = SydwMap.map.initMarker(title,zbx,zby,imgName,null,null,imgWidth,imgHeight);
	marker.addListener("click", function(){
		
	});
	
	SydwMap.map._MapApp.addOverlay(marker);
	return marker;
};

//清除地图上的查询图层
SydwMap.clearGraph = function(){
	var objs = SydwMap.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			if("getGeometryType" in objs[i] ){
				if(objs[i].getGeometryType()=="polygon"){
					SydwMap.map._MapApp.removeOverlay(objs[i]);
				}else if(objs[i].getGeometryType()=="circle"){
					SydwMap.map._MapApp.removeOverlay(objs[i]);
				}else if(objs[i].getGeometryType()=="rectangle"){
					SydwMap.map._MapApp.removeOverlay(objs[i]);
				}
			}
		}
	}
}


/**
 * 
 */
function queryDwByDzDm(marker,dz_dwdzdm){
	$.ajax({
		type:"GET",
		sync:true,
		url:contextPath+"/sydwcx_dl/queryDwByDzDm",
		data:{dz_dwdzdm:dz_dwdzdm},
		dataType:'json',
		success:function(json){
			var len = json.length;
			var idVaule='infoDiv'+dz_dwdzdm;
			$("#"+idVaule).remove();
			var msgHtml="<div style='width:490px;' cellpadding='0' cellspacing='10'  align='right'>";
				msgHtml+='<div id="'+idVaule+'"  >';
			for(var i=0;i<len;i++){
				var lb = window.top.getDictName(contextPath + '/common/dict/D_DW_DWLB.js', json[i].dwlbdm);
			msgHtml+='<div title="'+json[i].dwmc+'['+lb+']"   style="overflow:false;padding:10px;height:auto"> '
			msgHtml+="<table style='width:100%' ><tr><td>";
			msgHtml+="<table   border='0'  cellpadding='0' cellspacing='10'  align='center' >";
			msgHtml+="<tr><td style='width:90px'>实有单位名称:</td><td>"+json[i].dwmc+"</td></tr>" ;
			msgHtml+="<tr><td>单位类别:</td><td>"+lb+"</td></tr>" ;
			msgHtml+="<tr><td>联系电话:</td><td>"+json[i].lxdh+"</td></tr>" ;
			msgHtml+="<tr><td>单位地址:</td><td>"+json[i].dz_dwdzxz+"</td></tr>" ;
			msgHtml+="<tr><td></td><td></td></tr>" ;
			msgHtml+="</table>" ;
			console.log(contextPath+"/zpfjFjxxb/queryZpByLyid.jpg?id="+json[i].id);
			msgHtml+="</td><td><img   width='140px' height='110' src='"+contextPath+"/zpfjFjxxb/queryZpByLyid.jpg?id="+json[i].id+"' /></td>";
			msgHtml+="</tr></table></div>";
			}
				//msgHtml+="</div><a href='javascript:void(0);' style='height:25px;margin-top:5px;'  onclick='openCh("+dz_dwdzdm+")'  >层户结构</a></div>"	;
			marker.openInfoWindowHtml(msgHtml);
			$("#"+idVaule).accordion({
				multiple:false,
				animate:true
			});
		}
	});
}

function openCh(dz_jzdzdm){
	 if(dz_jzdzdm!=null&&dz_jzdzdm!=""){
	     var hsUrl = "/forward/sqjw|building|buildingShow?bzdzid="+dz_jzdzdm+"&bs=3";
	     menu_open("层户结构",hsUrl);
   }else{
      $.messager.alert("提示","暂无层户结构信息","info");
   }
}

function openDwView(id){
	if(null!==id&&""!=id){
		var hsUrl = "/sydwgl_dl/view?id="+id+"&menuName=实有单位编辑";
		 menu_open("实有单位编辑",hsUrl);
	}else{
	      $.messager.alert("提示","暂无单位信息","info");
	   }
}

/**
 * 查询按钮的放置位置
 */
SydwMap.queryButton = function(){
	var html = "<div style='position:absolute;right:5px;top:100px;width:200px;'>" +
	"<img id='img4' onclick='SydwMap.oprateMap(3)' style='cursor:hand;' title='拉框查询' src='../images/map/icons/icon_box_select01.png'>&nbsp;&nbsp;" +
	"<img id='img1' onclick='SydwMap.oprateMap(1)' style='cursor:hand;' title='多变形查询' src='../images/map/icons/icon_polygon_select01.png'>&nbsp;&nbsp;" +
	"<img id='img2' onclick='SydwMap.oprateMap(2)' style='cursor:hand;' title='点周边查询' src='../images/map/icons/icon_ellip_select01.png'>&nbsp;&nbsp;" +
	"<img id='img3' onclick='SydwMap.reset()' style='cursor:hand;' title='重置' src='../images/map/icons/icon_back_select01.png'>&nbsp;&nbsp;" +
	"</div>";
	$("#mapDiv").append(html);
};

SydwMap.oprateMap = function(type){
	switch(type){
		case 1: SydwMap.drawPolygon();break;
		case 2: SydwMap.drawCircle();break;
		case 3: SydwMap.drawRect();break;
	}
};
SydwMap.drawPolygon = function(){
	SydwMap.clearMap();
	SydwMap.map._MapApp.changeDragMode('drawPolygon', null, null, SydwMap.drawPolygon_back);
	
};
 
SydwMap.drawPolygon_back = function(polygon){
	var polygonObj = new Polygon(polygon, "#A6CDEC", 5, 0.5, "#A6CDEC");
	SydwMap.polygonObj = polygonObj;
	SydwMap.map._MapApp.addOverlay(polygonObj);
	generalZbz  =polygon;
	generalType = 1;
	var flag = checkZbz(polygon);
	if(flag){
		SydwMap.queryJzdz(polygon);
	}else{
		return;
	}
};

var RfxxId ="";

SydwMap.drawPoint = function(id){
	//RfxxMap.clearMap();
	RfxxId= "";
	RfxxId = id;
	SydwMap.map._MapApp.changeDragMode('drawPoint', null, null, SydwMap.drawPoint_back);
};
SydwMap.drawPoint_back = function(point){
	SydwMap.point = point;
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
	SydwMap.pointObj = marker; 
	
	SydwMap.map._MapApp.addOverlay(marker);
	//ajax保存坐标
	SydwMap.map.addZb(RfxxId,x, y, "POST", "/Rfxx/updateWf", SydwMap.back);
};
