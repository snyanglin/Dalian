if(typeof FrameTools =="undefined" || !FrameTools){
	 var FrameTools = {};
};
var str = new Array();
/**
 * @title: FrameTools.Map 
 * @description:地图对象
 * @author: zhang_guoliang@founder.com
 * @date：2014-07-03 下午4:09:02
 */
FrameTools.Map = function(){
	this._MapApp = null;                              //地图对象
	this.centerZbx = centerAtLatLng.split(",")[0];    //地图中心点X
	this.centerZby = centerAtLatLng.split(",")[1];    //地图中心点Y
	this.minx = centerAtMBR.split(",")[0];            //地图全图最小坐标X
	this.miny = centerAtMBR.split(",")[1];            //地图全图最小坐标Y
	this.maxx = centerAtMBR.split(",")[2];            //地图全图最大坐标X
	this.maxy = centerAtMBR.split(",")[3];            //地图全图最大坐标Y
	this.mapInitLevel = mapInitMaxZoom.split(",")[0]; //地图初始化级别
	this.mapMaxLevel = mapInitMaxZoom.split(",")[1];  //地图最大显示级别
	this.zoomOffset = mapInitMaxZoom.split(",")[2];   //地图级别偏移量
	this.zoomLevelSequence = 2;                       //地图比例尺级别排序模式
	this.copyRight = "&nbsp;";      				  //地图版权信息
	this.proxy = "/Proxy";                            //地图代理
	this.zIndex = 100;                                //地图对象的层级
	this.imgPath = "../images/map/";                  //地图图片路径
};
/**
 * @title: onloadMap
 * @description:初始化地图
 * @author: zhang_guoliang@founder.com
 * @date：2014-07-03 下午4:32:12
 */
FrameTools.Map.prototype.onloadMap = function(){
	if(typeof EzServerClient != "undefined"){
		str = ezMapServer.split(",");
		 //将地图加载到传入的地图容器中，并获取地图控件句柄
		this._MapApp = this.initEzMap();
		for(var i=0;i<str.length;i++){
			var serverMap = str[i];
			var GroupLayers = this.initMapLayer("GroupLayers_"+i,serverMap.split("|")[0],serverMap.split("|")[1]);
			var uGroupLyr = new EzServerClient.GroupLayer(serverMap.split("|")[2],[GroupLayers]);
			this._MapApp.addGroupLayers([uGroupLyr]);
		}
		this._MapApp.registerProx(this.proxy);//代理
		this._MapApp.initialize();//初始化地图，并显示地图
		this._MapApp.showMapCtrl();//显示新版地图控件
		this._MapApp.hideMapScale();//隐藏比例尺信息
	}
};
/**
 * @title: initMapLayer 
 * @description:初始化一个地图服务图层
 * @author: zhang_guoliang@founder.com
 * @param mapName<String> 地图图层名称
 * @param mapUrl<String> 地图图层服务地址
 * @returns {EzServerClient.Layer.EzMapTileLayer2010} 
 * @date：2014-07-03 下午4:57:32
 */
FrameTools.Map.prototype.initMapLayer = function(mapName,mapUrl,bs){
	if(bs=="1"){
		var tileLyr = new EzServerClient.Layer.WMTSTileLayer(mapName, mapUrl,{
			layer:"vec",
			style:"default",
			tileMatrixSet:"c",
			originAnchor:[-180,90],
			initResolution:1.40625,
			format:"tiles",
			tileMatrix:"%d"
		});
		return tileLyr;
	}else{
		var tileLyr = new EzServerClient.Layer.EzMapTileLayer2010(mapName, mapUrl,{
			tileWidth:256,//瓦片的宽度，单位为像素px
			tileHeight:256,//瓦片的高度，单位为像素px
			originAnchor:[0,0],//设置瓦片地图起始锚点，即0行0列地图的左下角地图坐标，瓦片行列号方向为以此锚点向上向右递增
			mapCoordsinatetype:1,
			zoomLevelSequence:this.zoomLevelSequence//地图比例尺级别排序模式
		});
		return tileLyr;
	}
};
/**
 * @title: initEzMap 
 * @description:将地图加载到传入的地图容器中，并获取地图控件句柄
 * @author: zhang_guoliang@founder.com
 * @param mapDiv<String>|<Object>  地图容器
 * @returns  
 * @date：2014-07-03 下午6:34:57
 */
FrameTools.Map.prototype.initEzMap = function(){
	var map = new EzMap(this.mapDiv,{
		//设置地图中心
		mapCenter:[this.centerZbx,this.centerZby],
		//设置地图全图范围
		mapFullExtent:[this.minx,this.miny,this.maxx,this.maxy],
		//设置地图初始化级别
		mapInitLevel:this.mapInitLevel,
		//设置地图最大级别
		mapMaxLevel:this.mapMaxLevel,
		//设置地图级别偏移量
		zoomOffset:this.zoomOffset,
		//设置版权信息
		copyRight:this.copyRight,
		//地图比例尺级别排序模式
		zoomLevelSequence:this.zoomLevelSequence
	});
	return map;
};
/**
 * @title: addOverView
 * @description:在地图中增加鹰眼显示框 
 * @author: zhang_guoliang@founder.com
 * @date：2014-07-03 下午4:57:32
 */
FrameTools.Map.prototype.addOverView = function(width,height,maxL,minL){
	var ov = new OverView();//构造鹰眼对象
	ov.width = width ==null?200:width;
	ov.height = height ==null?200:height;
	ov.maxLevel = maxL ==null?14:maxL;
	ov.minLevel = minL ==null?5:minL;
	this._MapApp.addOverView(ov);
};
/**
 * @title: changeDragMode 
 * @description:地图绘制方法
 * @author: zhang_guoliang@founder.com
 * @param drawmode
 * 		drawmode为"pan"时，设置当前地图操作状态为漫游状态，参数[2]、参数[3]和参数[4]均不可用;
 * 		drawmode为"drawPoint"时，设置当前地图操作状态为获取地图坐标的状态;
 * 		drawmode为"drawRect"时，设置当前地图操作状态为绘制矩形状态;
 * 		drawmode为"drawCircle"时，设置当前地图操作状态为绘制圆形状态;
 * 		drawmode为"drawPolyline"时，设置当前地图操作状态为绘制多义线状态;
 * 		drawmode为"drawPolygon"时，设置当前地图操作状态为绘制多边形状态;
 *      参数省略：不可以省略
 * @param inputform1
 * @param inputform2
 * @param callback 
 * @date：2014-07-03 下午4:57:32
 */
FrameTools.Map.prototype.changeDragMode = function(drawmode, inputform1, inputform2, callback){
	this._MapApp.changeDragMode(drawmode, inputform1, inputform2, callback);
};
/**
 * @title: setMapDiv
 * @description:设置地图容器
 * @author: zhang_guoliang@founder.com
 * @date：2014-07-03 下午5:54:48
 */
FrameTools.Map.prototype.setMapDiv = function(mapDiv){
	this.mapDiv = typeof(mapDiv) == "object" ? mapDiv : document.getElementById(mapDiv);
};
/**
 * @title: setProxy
 * @description:设置代理服务地址
 * @author: zhang_guoliang@founder.com
 * @date：2014-07-03 下午5:20:12
 */
FrameTools.Map.prototype.setProxy = function(url){
	this.proxy = url;
};
/**
 * @title: initMarker 
 * @description:创建并返回一个marker定位对象
 * @author: zhang_guoliang@founder.com
 * @param title 标题
 * @param zbx 坐标X
 * @param zby 坐标Y
 * @param imgName 定位图片名称
 * @param msgHtml 气泡框内容
 * @param mouseFun 鼠标点击事件
 * @returns {Marker} 
 * @date：2014-07-03 下午6:24:23
 */
FrameTools.Map.prototype.initMarker = function(title,zbx,zby,imgName,msgHtml,mouseFun,imgWidth,imgHeight){
	var pPoint = new Point(zbx,zby);
	var pIcon = new Icon();
	if(imgWidth==null&&pIcon.height==""){
		pIcon.width = 16;
	}else{
		pIcon.width = imgWidth;
	}
	if(imgWidth==null&&pIcon.height==""){
		pIcon.height = 16;
	}else{
		pIcon.height = imgHeight;
	}
	pIcon.image = "../images/map/icons/";
	if(imgName==null||imgName=="")
		pIcon.image += "tack.gif";
	else
		pIcon.image += imgName;
	var pTitle = new Title(title, 12, 7, "宋体", "#000000", "#FFFFFF", "#FFFFFF", "2");
	var pMarker = "";
	//图片大向上移动-8像素
	pIcon.topOffset=-8;
	if(title==null||title==""){
		pMarker = new Marker(pPoint, pIcon);
	}else{
		pMarker = new Marker(pPoint, pIcon ,pTitle);
	}
	pMarker.setZIndex(this.zIndex);
	if(msgHtml!=null||(mouseFun!=null&&mouseFun!="")){
		this.addPointClickFun(pMarker,msgHtml,mouseFun);
	}
	if(mouseFun!=null&&mouseFun!="")
		pMarker.hideTitle();
	return pMarker;
};
/**
 * @title: addPointClickFun
 * @description:增加图标点击事件
 * @author: zhang_guoliang@founder.com
 * @date：2014-07-16 下午9:21:32
 */
FrameTools.Map.prototype.addPointClickFun = function(obj, msgHtml,mouseFun,param){
	if(mouseFun!=null&&msgHtml!=""&&msgHtml!=null){
		obj.addListener("click", function(){
			obj.openInfoWindowHtml(msgHtml);
			mouseFun(param);
		});
	}else if(mouseFun!=null){
		obj.addListener("click", function(){mouseFun(param);});
	}else{
		if(msgHtml!=""&&msgHtml!=null)
		obj.addListener("click", function(){obj.openInfoWindowHtml(msgHtml);});
	}
};
/**
 * @title: buildTools
 * @description:初始化地图工具栏
 * @author: zhang_guoliang@founder.com
 * @date：2014-07-03 下午7:38:11
 */
FrameTools.Map.prototype.buildTools = function(mapDiv,toolDiv,mapName){
	var toolsHtml =  ' <table border="0" cellspacing="0" cellpadding="0" style="border-collapse:collapse;">'
			+' 	<tr id="uptr">'
			+' 		<td id="bottonModules">'
			+' 			<div id="toolButtonDiv">'
			+' 				<table cellspacing="0" cellpadding="0">'
			+' 					<tr>'
			+' 						<td><img src="'+this.imgPath+'tools/box left1.png"></img></td>'
			+' 						<td background="'+this.imgPath+'tools/box middle1.png"><img'
			+' 							src="'+this.imgPath+'tools/1-1.png"'
			+' 							onmouseover="FrameTools.Map.toolButtonFun(this)"'
			+' 							onmouseout="FrameTools.Map.toolButtonFun(this)" style="cursor:hand"'
			+' 							onclick="'+mapName+'._MapApp.zoomInExt();"></img></td>'
			+' 						<td background="'+this.imgPath+'tools/box middle1.png"><img'
			+' 							src="'+this.imgPath+'tools/2-1.png"'
			+' 							onmouseover="FrameTools.Map.toolButtonFun(this)"'
			+' 							onmouseout="FrameTools.Map.toolButtonFun(this)" style="cursor:hand"'
			+' 							onclick="'+mapName+'._MapApp.zoomOutExt();"></img></td>'
			+' 						<td background="'+this.imgPath+'tools/box middle1.png"><img'
			+' 							src="'+this.imgPath+'tools/3-1.png"'
			+' 							onmouseover="FrameTools.Map.toolButtonFun(this)"'
			+' 							onmouseout="FrameTools.Map.toolButtonFun(this)" style="cursor:hand"'
			+' 							onclick="'+mapName+'._MapApp.changeDragMode(\'pan\');"></img></td>'
			+' 						<td background="'+this.imgPath+'tools/box middle1.png"><img'
			+' 							src="'+this.imgPath+'tools/4-1.png"'
			+' 							onmouseover="FrameTools.Map.toolButtonFun(this)"'
			+' 							onmouseout="FrameTools.Map.toolButtonFun(this)" style="cursor:hand"'
			+' 							onclick="'+mapName+'._MapApp.fullExtent();"></img></td>'
			+' 						<td background="'+this.imgPath+'tools/box middle1.png"><img'
			+' 							src="'+this.imgPath+'tools/5-1.png"'
			+' 							onmouseover="FrameTools.Map.toolButtonFun(this)"'
			+' 							onmouseout="FrameTools.Map.toolButtonFun(this)" style="cursor:hand"'
			+' 							onclick="'+mapName+'._MapApp.changeDragMode(\'measure\');"></img></td>'
			+' 						<td background="'+this.imgPath+'tools/box middle1.png"><img'
			+' 							src="'+this.imgPath+'tools/6-1.png"'
			+' 							onmouseover="FrameTools.Map.toolButtonFun(this)"'
			+' 							onmouseout="FrameTools.Map.toolButtonFun(this)" style="cursor:hand"'
			+' 							onclick="'+mapName+'._MapApp.measureArea();"></img></td>'
			+' 						<td background="'+this.imgPath+'tools/box middle1.png"><img'
			+' 							src="'+this.imgPath+'tools/7-1.png"'
			+' 							onmouseover="FrameTools.Map.toolButtonFun(this)"'
			+' 							onmouseout="FrameTools.Map.toolButtonFun(this)" style="cursor:hand"'
			+' 							onclick="'+mapName+'._MapApp.reverseOverView();"></img></td>'
			+' 						<td background="'+this.imgPath+'tools/box middle1.png"><img'
			+' 							src="'+this.imgPath+'tools/8-1.png"'
			+' 							onmouseover="FrameTools.Map.toolButtonFun(this)"'
			+' 							onmouseout="FrameTools.Map.toolButtonFun(this)" style="cursor:hand"'
			+' 							onclick="'+mapName+'._MapApp.print();"></img></td>'
			+' 						<td background="'+this.imgPath+'tools/box middle1.png"><img'
			+' 							src="'+this.imgPath+'tools/9-1.png"'
			+' 							onmouseover="FrameTools.Map.toolButtonFun(this)"'
			+' 							onmouseout="FrameTools.Map.toolButtonFun(this)" style="cursor:hand"'
			+' 							onclick="'+mapName+'._MapApp.clear();"></img></td>'
			+' 						<td background="'+this.imgPath+'tools/box middle1.png"><img'
			+' 							src="'+this.imgPath+'tools/12-1.png" style="cursor:hand"'
			+' 							onclick="FrameTools.Map.toolShowOrHide();"></img></td>'
			+' 						<td><img src="'+this.imgPath+'tools/box right1.png"/></td>'
			+' 					</tr>'
			+' 				</table>'
			+' 			</div>'
			+' 		</td>'
			+' 		<td id="toolButton"><img style="cursor:hand" src="'+this.imgPath+'tools/tool1.png"'
			+' 			onclick="FrameTools.Map.toolShowOrHide(648);"></img></td>'
			+' 	</tr>'
			+' 	</tr>'
			+' </table> ';
	$("#"+toolDiv).html(toolsHtml);
	FrameTools.Map.setToolDiv(mapDiv,toolDiv);
	FrameTools.Map.toolShowOrHide();
	$("#"+mapDiv).resize(function(){FrameTools.Map.setToolDiv(mapDiv,toolDiv);});
};
/**
 * @title:setToolDiv
 * @description:设置工具条显示的位置
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-11 17:31:21
 */	
FrameTools.Map.setToolDiv=function(mapDiv,toolDiv){
	var top = $("#"+mapDiv).height() - 40;
	$("#"+toolDiv).css({
		"top" : top,
		"left" : 10
	});
};
/**
 * @title: toolShowOrHide
 * @description:地图操作工具栏收缩
 * @author: zhang_guoliang@founder.com
 * @date：2014-07-03 下午7:42:52
 */
FrameTools.Map.toolShowOrHide = function(width){
	if($("#toolButtonDiv").is(":hidden")){
		$("#toolButton").hide("slow");
		$("#toolButtonDiv").show("slow");
	}else{
		$("#toolButtonDiv").hide("slow");
		$("#toolButton").show("slow");
	}
};
/**
 * @title:toolButtonFun
 * @description:切换图片效果
 * @author: zhang_guoliang@founder.com
 * @date：2014-07-03 晚上8:06:32
 */
FrameTools.Map.toolButtonFun = function(toolObj) {
	var imgsrc = toolObj.src;
	if (imgsrc.substring(imgsrc.length - 5, imgsrc.length) == "1.png") {
		toolObj.src = imgsrc.substring(0, imgsrc.length - 5) + "2.png";
	} else if (imgsrc.substring(imgsrc.length - 5, imgsrc.length) == "2.png") {
		toolObj.src = imgsrc.substring(0, imgsrc.length - 5) + "1.png";
	} else {
		alert("图片格式错误！");
	}
};
/**
 * @title:showNewMapServer
 * @description:显示自定义的矢量影像图层对象
 * @param mapDiv 地图容器
 * @author: zhang_guoliang@founder.com
 * @date：2014-07-08 14:37:54
 */
FrameTools.Map.prototype.showNewMapServer = function(mapDiv,mapName){
	var imgHtml = "";
	for(var i=0;i<str.length;i++){
		var imgStr = str[i];
		var bz = (str.length -1) - i;
		imgHtml += "<img id='img_"+bz+"' onclick='FrameTools.Map.showMap("+bz+","+mapName+","+str.length+");' style='cursor:hand;' src='../images/map/icons/"+imgStr.split('|')[3]+"'>&nbsp;&nbsp;"
	}
	var html = "<div id='mapToolDiv' style='position:absolute;right:5px;top:10px;'>"+imgHtml+"</div>";
	$("#"+mapDiv).append(html);
	var newMaxW = 70*str.length;
	document.getElementById("mapToolDiv").style.width = newMaxW+"px";
};
/**
 * @title:showMap
 * @description:切换地图以及切换图标
 * @param bz 切换标识
 * @param mapName 地图对象
 * @author: zhang_guoliang@founder.com
 * @date：2014-07-08 15:38:21
 */
FrameTools.Map.showMap = function(bz,mapName,zs){
	mapName._MapApp.switchMapServer(bz);
	for(var i=0;i<zs;i++){
		var imgsrc = document.getElementById("img_"+i).src;
		if(i==bz){
			document.getElementById("img_"+i).src = imgsrc.substring(0, imgsrc.length - 5) + "1.png";
		}else{
			document.getElementById("img_"+i).src = imgsrc.substring(0, imgsrc.length - 5) + "2.png";
		}
	}
};
/**
 * @title: initPolyline 
 * @description:创建并返回一个线对象
 * @author: zhang_guoliang@founder.com
 * @param linezbz  //线坐标值 
 * @param color    //线颜色
 * @param lineWidth//线宽
 * @param type     //透明度
 * @returns 
 * @date：2014-07-08 20:20:32
 */
FrameTools.Map.prototype.initPolyline = function(linezbz,color,lineWidth,type){
	var polyline = null;
	if(this.verify(linezbz)){
		$.messager.show({title:'系统提示',msg:'坐标串格式错误！',timeout:3000});
		return;
	}
	if(color==null||color==""){
		color = "#0000FF";
	}
	if(lineWidth==null||lineWidth==""){
		lineWidth = 3;
	}
	if(type==null||type==""){
		type = 1;
	}
	if(linezbz.indexOf("|") == -1){
		var lineArr = linezbz.split("|");
		polyline = new Polyline(lineArr[0], color, lineWidth, type);
	}else{
		polyline = new Polyline(linezbz, color, lineWidth, type);
	}
	return polyline;
};
/**
 * @title: verify 
 * @description:判断线或面的坐标是否正确
 * @author: zhang_guoliang@founder.com
 * @param linezbz //线坐标值 
 * @date：2014-07-08 20:27:14
 */
FrameTools.Map.prototype.verify = function(linezbz){
	if(!linezbz || linezbz.split(",").length<=4){
		return true;
	}
	return false;
};
/**
 * @title: addZb 
 * @description:判断线或面的坐标是否正确
 * @author: song_yongqiang@founder.com
 * @param zbx、zby、ajaxMethod、url
 * @date：2014-08-20 16:48:12
 */
FrameTools.Map.prototype.addZb = function(id,zbx,zby,ajaxMethod,url,callback){
	callback = callback==null?function(){}:callback;
	$.ajax({
		type:ajaxMethod,
		sync:true,
		url:contextPath+url,
		data:{id:id,zbx:zbx,zby:zby},
		dataType:'json',
		success:function(json){
			if(callback){
				callback(json);
			}
		}
	});
};
/**
 * @title: AreaInPolygon
 * @description:判断后坐标区域是否在区域内
 * @author: zhang_guoliang@founder.com
 * @param true在范围内 area为坐标点、polygon为线的坐标
 * @date：2015-01-16 20:13:32
 */
FrameTools.Map.prototype.AreaInPolygon = function(area, polygon){
	var pArr = area.split(",");
	var polygonArr = polygon.split(";");
	for(var j=0;j<polygonArr.length;j++){
		var flag=true;
		for(var i=0; i<pArr.length; i+=2) {
			var point = pArr[i] + "," + pArr[i+1];
			if(!this.PtInPolygon(point, polygonArr[j])) {
				flag = false;
				break;
			}
		}		
		if(flag) {
			return true;
		}
	}
	return false;
};
/**
 * @title: PtInPolygon
 * @description:判断后坐标是否在区域内
 * @author: zhang_guoliang@founder.com
 * @param true在范围内 area为坐标点、polygon为线的坐标
 * @date：2015-01-16 20:19:36
 */
FrameTools.Map.prototype.PtInPolygon = function(point, polygon){
	var pArr = point.split(",");
	var p =  new Object();
	p.x = parseFloat(pArr[0]);
	p.y = parseFloat(pArr[1]);
	var pt = new Array();
	var gArr = polygon.split(",");
	var num = gArr.length;
	for(var i=0;i<num;i++){
		var p1 =  new Object();
		p1.x = parseFloat(gArr[i]);
		p1.y = parseFloat(gArr[++i]);
		pt.push(p1);
	}
   var nCount = pt.length;
   var nCross = 0;
   for (var i = 0; i < nCount; i++)
   {
	   var p1 = pt[i];
	   var p2 = pt[(i + 1) % nCount];
      if (p1.y == p2.y) 
      {
         if (p.y == p1.y && p.x >= this.min(p1.x, p2.x) && p.x <= this.max(p1.x, p2.x))
        	 return true;
         continue;
      }
      if (p.y < this.min(p1.y, p2.y) || p.y > this.max(p1.y, p2.y)) 
         continue;
     var x = (p.y - p1.y) * (p2.x - p1.x) / (p2.y - p1.y) + p1.x;
     if (x > p.x)
           nCross++; 
     else if (x == p.x)
    	 return true;
   }
    if (nCross % 2 == 1)
    	  return true;
     return false;
};
/**
 * @title: min
 * @description:获取小值
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date：2015-01-16 20:20:53
 */
FrameTools.Map.prototype.min = function (x,y){
	if(x>y){
		return y;
	}else{
		return x;
	}
};
/**
 * @title: max
 * @description:获取大值
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date：2015-01-16 20:21:12
 */
FrameTools.Map.prototype.max=function(x,y){
	if(x<y){
		return y;
	}else{
		return x;
	}
};
/**
 * @title: moveMapToBjzbz
 * @description:加载边界坐标值
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date：2015-04-14 10:35:43
 */
FrameTools.Map.prototype.moveMapToBjzbz = function(bjzbz){
	if(bjzbz!="" && bjzbz!='null'){
		/*清楚地图上所有的标记*/
		this._MapApp.clear();
		/*非地坐标*/
		var bj = bjzbz.split(";");
		var bjnum = bj.length;
		/*记录边线中心点坐标*/
		var mbr = null;
		for(var j=0;j<bjnum;j++){
			var gArr = bj[j];
			/*创建边界图元素*/
			var polyline = FrameTools.Map.prototype.initPolyline(gArr,"blue");
			/*图元素添加到地图上*/
			if(polyline){
				this._MapApp.addOverlay(polyline);
				if(mbr==null){
					mbr = polyline.getMBR();
				}else{
					mbr = MBR.union(mbr,polyline.getMBR());
				}
			}
		}
		/*根据图元素将地图放到最适合的级别和位置*/
		this._MapApp.centerAtMBR(mbr);
		/*新版本cliect自动适应级别有问题必须降一级*/
		this._MapApp.zoomOut();
	}
};
/**
 * @title:clearGraph
 * @description:【空间查询】清除查询图层
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2015-04-23 10:57:32
 */
FrameTools.Map.prototype.clearGraph = function(){
	var objs = this._MapApp.getOverlays();
	var len = objs.length;
	for(var i=0;i<len;i++){
		if("getGeometryType" in objs[i] ){
			if(objs[i].getGeometryType()=="polygon"){
				this._MapApp.removeOverlay(objs[i]);
			}else if(objs[i].getGeometryType()=="circle"){
				this._MapApp.removeOverlay(objs[i]);
			}else if(objs[i].getGeometryType()=="rectangle"){
				this._MapApp.removeOverlay(objs[i]);
			}
		}
	}
};
/**
 * @title: checkPoint
 * @description:判断线是否现交叉或不正规数据
 * @author: zhang_guoliang@founder.com
 * @param lineStr
 * @returns
 * @date：2015-04-23 13:55:21
 */
FrameTools.Map.prototype.checkPoint = function (point){
	var zbs = point.toString().split(",");
	if(zbs.length==6){
		if(zbs[0]==zbs[4]&&zbs[1]==zbs[5]){
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '多边形存在问题，请重新画。',
				timeout:2500
			});
			return false;
		}
	}else{
		if(FrameTools.Map.prototype.poylineIntersect(point)){
			topMessager.show({
				title: MESSAGER_TITLE,
				msg: '多边形不能有交叉，请重新画。',
				timeout:2500
			});
			return false;
		}
	}
	return true;
};
/**
 * @title: poylineIntersect 
 * @description:判断线是否现交叉
 * @author: zhang_guoliang@founder.com
 * @param lineStr
 * @returns {Boolean} ture:有相交，false：无相交
 * @date：2015-04-23 11:20:32
 */
FrameTools.Map.prototype.poylineIntersect = function (lineStr){
	var zbArr = lineStr.split(",");
	for(var i = 0 ;i < zbArr.length - 4 ;i += 2){
		for(var j = i+4;j < zbArr.length-2;j += 2){
			if(i!=0||j < zbArr.length-4){
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
				if(FrameTools.Map.prototype.lineIntersect(a,b,c,d))
					return true;
			}
		}
	}
	return false;
};
/**
 * @title: LineIntersect 
 * @description:判断两条直线是否相交
 * @author: zhang_guoliang@founder.com
 * @param a 第一条线的第一点坐标 
 * @param b 第一条线的第二点坐标
 * @param c 第二条线的第一点坐标
 * @param d 第二条线的第二点坐标
 * @returns {Boolean} 
 * @date：2015-04-23 11:26:32
 */
FrameTools.Map.prototype.lineIntersect = function (a,b,c,d) {
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
    if (area_cda * area_cdb >= 0){  
        return false;  
    }  
    return true;  
};