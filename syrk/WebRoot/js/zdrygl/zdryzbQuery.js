if(typeof ZdryManage == "undefined" || !ZdryManage){
	var ZdryManage = {};
};
ZdryManage = function(){
	this.pk = Math.random();
};
ZdryManage.initMarkerArr = new Array();//放点对象
ZdryManage.setInt = "";//记录延时

//空间查询
ZdryManage.drawMode="";
ZdryManage.pointBufferShape=null;
ZdryManage.generalZbz="";
ZdryManage.generalMapRadius="";
//空间查询end
/**
 * @title:Jquery
 * @description:初始化地址管理
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2014-12-26 10:37:32
 */
$(function(){
	ZdryManage.onloadMap();
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 10:38:12
 */	
ZdryManage.onloadMap = function(){
	/*地图对象*/
	ZdryManage.map = new FrameTools.Map();
	/*设置地图代理*/
	ZdryManage.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	ZdryManage.map.setMapDiv("mapDiv");
	/*加载地图*/
	ZdryManage.map.onloadMap();
	/*显示鹰眼*/
	ZdryManage.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	ZdryManage.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	ZdryManage.map.showNewMapServer("mapDiv","ZdryManage.map");
	/*加载地图工具条*/
	ZdryManage.map.buildTools("mapDiv","toolDiv","ZdryManage.map");
	/*设置工具条显示的位置*/
	ZdryManage.diyToolDiv();
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){ZdryManage.diyToolDiv();});
	ZdryManage.map._MapApp.addMapEventListener(EzEvent.MAP_CLEAROVERLAYS,function(obj){
		ifClearAll = true;
	});
	ZdryManage.queryButton();
	/*加载边界坐标值*/
	if(bjzbz!="" && bjzbz!='null'){
		/*显示当前用户边界*/
		ZdryManage.moveMapToBjzbz();
	}
};
/**
 * @title:diyToolDiv
 * @description:设置工具条显示的位置
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 10:39:41
 */	
ZdryManage.diyToolDiv = function(){
	var top = $("#mapDiv").height() - 40;
	$("#toolDiv").css({
		"top" : top,
		"left" : 10
	});
};
/**
 * @title:moveMapToBjzbz
 * @description:加载当前用户边界
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 10:39:54
 */	
ZdryManage.moveMapToBjzbz = function(){
	/*清楚地图上所有的标记*/
	ZdryManage.map._MapApp.clear();
	/*非地坐标*/
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/*记录边线中心点坐标*/
	ZdryManage.mbrArr = new Array();
	for(var j=0;j<bjnum;j++){
		var gArr = bj[j];
		/*创建边界图元素*/
		var polyline = ZdryManage.map.initPolyline(gArr,"blue");
		/*图元素添加到地图上*/
		if(polyline){
			ZdryManage.map._MapApp.addOverlay(polyline);
			ZdryManage.mbrArr.push(polyline);
			if(ZdryManage.Mbr==null){
				ZdryManage.Mbr = polyline.getMBR();
			}else{
				ZdryManage.Mbr = MBR.union(ZdryManage.Mbr,polyline.getMBR());
			}
		}
	}
	/*根据图元素将地图放到最适合的级别和位置*/
	ZdryManage.map._MapApp.centerAtMBR(ZdryManage.Mbr);
	/*新版本cliect自动适应级别有问题必须降一级*/
	ZdryManage.map._MapApp.zoomOut();
};



//只清除marker
ZdryManage.clearMarkers = function(){
	ZdryManage.map._MapApp.closeInfoWindow();
	var objs = ZdryManage.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			var obj =objs[i].toString().split(",");
			if(obj.length<=2){
				ZdryManage.map._MapApp.removeOverlay(objs[i]);
			}
		}
	}
};
/**
 * @title:loadPoint
 * @description:加载地图坐标点
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 10:58:43
 */	
ZdryManage.loadPoint = function(data){
	//延迟加载列表统计
	beforeTableLoad(data,'dg');
	//关闭所有器已经打开的气泡框
	ZdryManage.map._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(ZdryManage.setInt!=""){
		clearInterval(ZdryManage.setInt);
	}
	//判断地图上已经存在点图层清除
	if(ZdryManage.initMarkerArr!=null){
		var markerLen = ZdryManage.initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			ZdryManage.map._MapApp.removeOverlay(ZdryManage.initMarkerArr[j]);
		}
	}
	//延时加载点图层
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	var count = 0;
	ZdryManage.setInt = setInterval(function(){
		if(count<len){
			var zbx = rows[count].jzd_zbx;
			var zby = rows[count].jzd_zby;
			var title = rows[count].xm;
			if(zbx!=""&&zby!=""){
				//气泡框内容
				var openHtml =  "" ;
				var initMarker = ZdryManage.map.initMarker(title,zbx,zby,"jzw1.png",openHtml,null,43,37);
				ZdryManage.map._MapApp.addOverlay(initMarker);
				ZdryManage.initMarkerArr.push(initMarker);
				//地图元素和列表联动
				ZdryManage.addMapToListFun(initMarker,count);
			}
		}else{
			clearInterval(ZdryManage.setInt);
		}
		count++;
	},90);
};
/**
 * @title:addMapToListFun
 * @description:地图元素和列表联动
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 18:02:12
 */	
ZdryManage.addMapToListFun = function(PMarker,row){
	PMarker.addListener("click",function(){
		//鼠标移动到点上列表选中
		$('#dg').datagrid("selectRow",row);
	});
	/*PMarker.addListener("mouseout",function(){
		//鼠标移动到点上取消列表选中
		$('#dg').datagrid("unselectRow",row);
	});*/
};
/**
 * @title:datagridDzzt
 * @description:地址状态颜色
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 18:12:24
 */	
ZdryManage.datagridDzzt = function(value,row,index){
	var opts = $(this);
	if (opts[0].dictName) {
		try {
			value = window.top.getDictName(opts[0].dictName, value);
		}
		catch (err) {}
	}
    if(row.dzzt=="01"){
    	if(row.bz=="维护中"){
    		return "<span style='color:green;font: bold;'>"+value+"(维护中)</span>";
    	}else{
    		return "<span style='color:green;font: bold;'>"+value+"</span>";
    	}
    }else if(row.dzzt=="02"){
    	return "<span style='color:#C86C00;font: bold;'>"+value+"</span>";
    }else if(row.dzzt=="03"){
    	return "<span style='color:red;font: bold;'>"+value+"</span>";
    }else if(row.dzzt=="04"){
    	return "<span style='color:gray;font: bold;'>"+value+"</span>";
    }else{
    	return value;   
    }	
};
/**
 * @title:onClickRow
 * @description:点击一行的时候触发
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-27 14:57:21
 */	
ZdryManage.onClickRow = function(rowIndex,rowData){
	
	var point = new Point(rowData.jzd_zbx,rowData.jzd_zby);
	//气泡框内容
	//var openHtml =  "";
	//ZdryManage.map._MapApp.openInfoWindow(point,openHtml,true);
	ZdryManage.clearMarkers();
	//ZdryManage.map._MapApp.clear();
	//判断延时是否执行完，没执行完终止此方法
	if(ZdryManage.setInt!=""){
		clearInterval(ZdryManage.setInt);
	}
	if(ZdryManage.initMarkerArr[rowIndex]&&rowData.zbx !=""){
	ZdryManage.map._MapApp.addOverlay(ZdryManage.initMarkerArr[rowIndex]);
	ZdryManage.map._MapApp.centerAndZoom(point, 19);
	}else{
		alert("无坐标点");
	}
};

/**
 * @title:doUpdateAndXq
 * @description:地址维护
 * @author: zhang_guoliang@founder.com
 * @param type 0为可编辑、1为只读，dzChb地址层户表 0为层户地址对象表、1为层户地址审核表 
 * @date:2015-02-04 18:23:35
 */	
ZdryManage.doUpdateAndXq = function(linkObject, index){
	//阻止冒泡，不然要执行onClickRow
    cancelBubble(); 
    var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
    menu_open(rowData.xm +'','/zdry/'+rowData.ryid+'/'+rowData.syrkid+'/view'+'?mainTabID='+getMainTabID());
};

/**
 * 查询按钮的放置位置
 */
ZdryManage.queryButton = function(){
	var html = "<div style='position:absolute;right:5px;top:100px;width:200px;'>" +
	"<img id='img4' onclick='ZdryManage.drawRange(\"drawRect\")' style='cursor:hand;' title='拉框查询' src='../images/map/icons/icon_box_select01.png'>&nbsp;&nbsp;" +
	"<img id='img1' onclick='ZdryManage.drawRange(\"drawPolygon\")' style='cursor:hand;' title='多变形查询' src='../images/map/icons/icon_polygon_select01.png'>&nbsp;&nbsp;" +
	"<img id='img2' onclick='ZdryManage.drawRange(\"drawPoint\")' style='cursor:hand;' title='点周边查询' src='../images/map/icons/icon_ellip_select01.png'>&nbsp;&nbsp;" +
	"<img id='img3' onclick='ZdryManage.reset()' style='cursor:hand;' title='重置' src='../images/map/icons/icon_back_select01.png'>&nbsp;&nbsp;" +
	"</div>";
	$("#mapDiv").append(html);
};
/*画图方法*/
ZdryManage.drawRange=function(drawMode){
	ZdryManage.clearMap();
	ZdryManage.drawMode=drawMode;
	ZdryManage.map._MapApp.changeDragMode(drawMode, null, null, ZdryManage.drawRange_back);
}

/*画图回调*/
ZdryManage.drawRange_back=function(polygon){
	ZdryManage.generalZbz=polygon;
	var polygonObj = new Polygon(polygon, "#A6CDEC", 5, 0.5, "#A6CDEC");
	if(ZdryManage.drawMode=="drawPoint"){
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
		ZdryManage.map._MapApp.addOverlay(marker);
		var distance = 100;;//周边100米的距离
		var mapRadius = ZdryManage.map._MapApp.getDegree(_pPoint, distance);
		var _coords =polygon + "," + mapRadius;
		ZdryManage.generalMapRadius = mapRadius;
		polygonObj = new Circle(_coords, "#A6CDEC", 5, 0.5, "#A6CDEC");
		ZdryManage.pointBufferShape = polygonObj;
	}
	ZdryManage.map._MapApp.addOverlay(polygonObj);
	if(checkZbz(polygon)){
		ZdryManage.queryJzdz();
	}else{
		return;
	}
}
/**
 * 地图上多边形查询
 */
ZdryManage.queryJzdz = function(){
	var generalType='0';
	if(ZdryManage.drawMode=="drawPoint"){
		generalType='2'
	}else if(ZdryManage.drawMode=="drawPolygon"){
		generalType='1'
	}
	else if(ZdryManage.drawMode=="drawRect"){
		generalType='3'
	}
	document.getElementById("zbz").value = ZdryManage.generalZbz;
	document.getElementById("type").value = generalType;
	document.getElementById("mapRadius").value = ZdryManage.generalMapRadius;
	queryButton();
};

ZdryManage.reset= function(){
	ZdryManage.clearMap();
	ZdryManage.clearGraph();
	queryButton();
};

/*清理地图，并且重新初始化*/
ZdryManage.clearMap= function(){
	if(ZdryManage.pointBufferShape){
		ZdryManage.map._MapApp.removeOverlay(ZdryManage.pointBufferShape);
	}
	var objs = ZdryManage.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			var obj =objs[i].toString().split(",");
			if(obj.length<=2){
				ZdryManage.map._MapApp.removeOverlay(objs[i]);
			}else if(typePPP(objs[i])=="polygon"||typePPP(objs[i])=="rectangle"){
				ZdryManage.map._MapApp.removeOverlay(objs[i]);
			}
		}
	}

	ZdryManage.map._MapApp.closeInfoWindow();
	//移动到适当的级别
	//ZdryManage.MultiPointZoom(bjzbz);
};

ZdryManage.MultiPointZoom = function (gjpoint){
	var gg = gjpoint.split(",");
	if(gg.length>2){
		var mp = new MultiPoint(gjpoint);
		var mr = mp.getMBR();
		var l = ZdryManage.map._MapApp.getLevelOfMBR(mr.minX,mr.minY,mr.maxX,mr.maxY);
		ZdryManage.map._MapApp.centerAtMBR(mr.minX,mr.minY,mr.maxX,mr.maxY);
		ZdryManage.map._MapApp.zoomTo(l);
	}else{
	ZdryManage.map._MapApp.centerAndZoom(new Point(gjpoint),_MapApp.getZoomLevel());
	}
};


function checkZbz(zbz){
	var flag = true;
	var zbs = zbz.toString().split(",");
	if(zbs.length==6){
		if(zbs[0]==zbs[4]&&zbs[1]==zbs[5]){
			$.messager.alert('提示','多边形存在问题，请重新输入！','warning');
			ZdryManage.clearMap();
			flag = false;
		}}else{
			if(ZdryManage.poylineIntersect(zbz)){
				$.messager.alert('提示','多边形轮廓不能有交叉，请重新输入！','warning');
				ZdryManage.clearMap();
				flag = false ;
			}
		}
	return flag;
}




//判断是否相交
ZdryManage.poylineIntersect = function (lineStr){
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
				if(ZdryManage.lineIntersect(a,b,c,d))
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
ZdryManage.lineIntersect = function (a,b,c,d) {
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
//清除地图上的查询图层
ZdryManage.clearGraph = function(){
	var objs = ZdryManage.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			if("getGeometryType" in objs[i] ){
				if(objs[i].getGeometryType()=="polygon"){
					ZdryManage.map._MapApp.removeOverlay(objs[i]);
				}else if(objs[i].getGeometryType()=="circle"){
					ZdryManage.map._MapApp.removeOverlay(objs[i]);
				}else if(objs[i].getGeometryType()=="rectangle"){
					ZdryManage.map._MapApp.removeOverlay(objs[i]);
				}
			}
		}
	}
}
//精确查询
function detailSearch(){
	$("#win").window("open"); 
}
function closeWindow(){
	$("#win").window("close"); 
}
