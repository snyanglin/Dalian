if(typeof XjMap == "undefined" || !XjMap){
	var XjMap = {};
};

XjMap = function(){
	this.pk = Math.random();
};

XjMap.queryHTML = "";
XjMap.floatWin = "";
XjMap.XqMJ = "";
XjMap.map = null;//声明地图对象
XjMap.syrkMarkerArr = new Array();//放点对象
XjMap.mbrArr = new Array();//组织机构辖区面对象集合
XjMap.Mbr = null;//辖区外边框
var ifClearAll = false;
XjMap.PcsTjJson = ""; //记录统计json串后退时用到

XjMap.orgcodes = parent.frames.pnodes;


$(function(){
	XjMap.loadMap();
});

XjMap.loadMap = function(){
	/*地图对象*/
	XjMap.map = new FrameTools.Map();
	/*设置地图代理*/
	XjMap.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	XjMap.map.setMapDiv("mapDiv");
	/*加载地图*/
	XjMap.map.onloadMap();
	/*显示鹰眼*/
	XjMap.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	XjMap.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	XjMap.map.showNewMapServer("mapDiv","XjMap.map");
	/*加载地图工具条*/
	XjMap.map.buildTools("mapDiv","toolDiv","XjMap.map");
	/*设置工具条显示的位置*/
	XjMap.diyToolDiv();
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){XjMap.diyToolDiv();});
	/*地图清空事件方法*/
	//XjMap.map._MapApp.addMapEventListener(EzEvent.MAP_CLEAROVERLAYS,function(obj){
	//	ifClearAll = true;
	//});
	
	//hx
	XjMap.queryButton();
	//hx
	
	if(bjzbz!="" && bjzbz!='null'){
		/*显示当前用户边界*/
		var org = parent.frames.userOrgCode;
		//大连市公安局，不画边界
		var zero8 = org.substr(org.length-8, org.length);
		if (zero8 != "00000000") {
			XjMap.moveMapToBjzbz();
		} else {
			//XjMap.map._MapApp.zoomOut(9);
			XjMap.map._MapApp.centerAndZoom(new Point('122.05535','39.41894'),9);
			
		}
	}
};

XjMap.diyToolDiv =function(){
	var top = $("#mapDiv").height() - 40;
	$("#toolDiv").css({
		"top" : top,
		"left" : 10
	});
};

//begin
var dms = "";

/**
 * @title:queryXjZzjg
 * @description:加载派出所全部责任区信息
 * @param  
 */	
 XjMap.queryXjZzjg = function(pnodes){
	if(pnodes!=''){
		var params = {zzjgdm: pnodes};
		var fajax =new FrameTools.Ajax(contextPath+"/xj/queryXjZzjgxj",XjMap.queryXjZzjg_back);
		fajax.send(params);
	}
};

/**
 * @title:intoMap
 * @description:地图下钻
 * @param  
*/	
XjMap.intoMap = function(pnodes){
	//alert(JSON.stringify(pnodes));
	if(pnodes!=''){
		var temp = "";
		for(var i=0; i<pnodes.length; i++){
			temp += pnodes[i].orgcode + ",";
		}
		var params = {zzjgdm: temp.substr(0, temp.length-1)};
		var fajax =new FrameTools.Ajax(contextPath+"/xj/queryXjZzjgxj",XjMap.queryXjZzjg_into);
		fajax.send(params);
	}
};

/**
 * @title:queryXjZrq
 * @description:加载责任区
 * @param  
*/	
XjMap.queryXjZrq = function(pnodes){ 
	if(pnodes!=''){
		var params = {id: '', orgcode: pnodes};
		var fajax =new FrameTools.Ajax(contextPath+"/xj/downMap", XjMap.intoMap);
		fajax.send(params);
		//加载统计
		XjMap.initFloatWin_back(pnodes);
	}
};

var markerArr = parent.frames.markerArrQysz;

/**
 * @title:queryXjZzjg_back
 * @description:加载派出所全部责任区信息_回调函数
 * @param  
 */	
 XjMap.queryXjZzjg_back = function(json){
	
	 XjMap.removeMark();
	 if(json[0].bjzbz!=""){
			//XjMap.map._MapApp.clear();
		}
		if(json!=null&&json.length>0){
			//区域范围显示则四色预警清除
			clearSsyj();
			XjMap.bjJson = json;
			XjMap.countZrq = json.length;
			var colors = new Array("#F1E740","#FFB543","#FF7A7B","#008080","#AA4400","#0000FF","#0066CC","#00CCCC","#6600CC","#FF99FF","#CCFFFF","#85D021","#4DC2ED","#EE431B","#E96A3B","#EE9539","#FDBE63","#FFFF66","#CC3333","#9966FF","#99CCFF","#FF00FF","#FF66CC","#996666","#00CC00","#330000","#336600","#666600","#990000","#996600","#99CC00","#CC0000","#CC6600","#CCCC00");
			//辖区面
			var option = parent.frames.options;
			if(option.indexOf('qyfw') != -1){
				 //for(var i=0;i<XjMap.countZrq;i++){
				 var i = 0;
				
				json.MMM = setInterval(function(){
					if(i<XjMap.countZrq){
			        	if(undefined != json[i].bjzbz && null!=json[i].bjzbz && json[i].bjzbz!=""){
			        		var col = colors[i];
			        		XjMap.showArea(json[i].zzjgdm, json[i].zzjgmc, json[i].bjzbz, col);
			        	}
			        	
					} else {
						clearInterval(json.MMM);
					}
			        	
			        	i++;
				}, 130);
			     //}
			}
		}
		//加载派出所概况
		if(XjMap.PcsTjJson!=""){
			XjMap.initFloatWin_back(XjMap.PcsTjJson);
		}else{
			XjMap.initFloatWin(userOrgCode);
		}
 };
 
 /**
  * @title:queryXjZzjg_into
  * @description:点击下钻
  * @param  
 */
 XjMap.queryXjZzjg_into = function(json){
		
	 XjMap.removeMark();
	 if(json[0].bjzbz!=""){
			//XjMap.map._MapApp.clear();
		}
		if(json!=null&&json.length>0){
			//区域范围显示则四色预警清除
			clearSsyj();
			//XjMap.bjJson = json;
			XjMap.countZrq = json.length;
			var colors = new Array("#F1E740","#FFB543","#FF7A7B","#008080","#AA4400","#0000FF","#0066CC","#00CCCC","#6600CC","#FF99FF","#CCFFFF","#85D021","#4DC2ED","#EE431B","#E96A3B","#EE9539","#FDBE63","#FFFF66","#CC3333","#9966FF","#99CCFF","#FF00FF","#FF66CC","#996666","#00CC00","#330000","#336600","#666600","#990000","#996600","#99CC00","#CC0000","#CC6600","#CCCC00");
			//辖区面
			var option = parent.frames.options;
			if(option.indexOf('qyfw') != -1){
				 //for(var i=0;i<XjMap.countZrq;i++){
				 var i = 0;
				
				json.MMM = setInterval(function(){
					if(i<XjMap.countZrq){
			        	if(undefined != json[i].bjzbz && null!=json[i].bjzbz && json[i].bjzbz!=""){
			        		var col = colors[i];
			        		XjMap.showArea(json[i].zzjgdm, json[i].zzjgmc, json[i].bjzbz, col);
			        	}
			        	
					} else {
						clearInterval(json.MMM);
					}
			        	
			        	i++;
				}, 130);
			     //}
			}
		}
		//加载派出所概况
//		if(XjMap.PcsTjJson!=""){
//			XjMap.initFloatWin_back(XjMap.PcsTjJson);
//		}else{
//			XjMap.initFloatWin(userOrgCode);
//		}
 };
 
 var ObjMap = parent.frames.ObjMap;
 var _pTitle = parent.frames._pTitle; 
 
 /**
  * @title:removeMark
  * @description:清空已存在坐标点
  * @param  
 */
 XjMap.removeMark = function(){
	 if(XjMap.floatWin!=""){
		 XjMap.floatWin.close();
	 }
		var mapWindow = null;
		if (IE) {
			mapWindow = parent.frames["biz_center"];
		}
		else {
			mapWindow = parent.frames.document.getElementById("biz_center").contentWindow;
		}
		if ("undefined" != typeof mapWindow && mapWindow != null) {
			if(markerArr != null){
				var markerLen = markerArr.length;
				for(var j=0;j<markerLen;j++){
					XjMap.map._MapApp.removeOverlay(markerArr[j]);
				}
			}
		}
		XjMap.map._MapApp.closeInfoWindow();
	};
	
 /**
  * @title:showArea
  * @description:各个辖区面
  * @author: sny
  * @param  begin
  * @date:2014-10-23 14:17:48
  */	
 var intoMC = '';
 var num = 0;
 XjMap.showArea = function(dm,mc,zbz,col){
 	var ObjMap = new Polygon(zbz, "red", 3, 0.4,col);
 	var pMbr = ObjMap.getMBR();
 	var cPoint = pMbr.centerPoint();
 	var _pTitle = new Title(mc,12,7,"宋体","#000000","#FFFFFF","#FFFFFF","2");
 	_pTitle.setPoint(cPoint);
 	XjMap.map._MapApp.addOverlay(ObjMap);
 	markerArr.push(ObjMap);
 	markerArr.push(_pTitle);
 	XjMap.map._MapApp.addOverlay(_pTitle);
 	//点击下钻到责任区
 	_pTitle.addListener("click", function (){
 		//全局变量
 		dms = dm;
 		//XjMap.map._MapApp.clear();
 		//XjMap.removeMark();
 		/*加载派出所*/
 		if(0 == num){
 			//XjMap.showArea(dm,mc,zbz,col);
 		} else {
 			//下钻到责任区
 			//XjMap.queryXjZrq(dm);
 			//XjMap.showArea(dm,mc,zbz,col);
 		}
 		/*根据图元素将地图放到最适合的级别和位置*/
 		XjMap.map._MapApp.centerAtMBR(pMbr);
 		if(userOrgCode!="210204410000"||screen.width>1600){
 			/*新版本cliect自动适应级别有问题必须降一级*/
 			//XjMap.map._MapApp.zoomOut();
 		}
 		/*记录当前展示的组织机构代码*/
 		XjMap.zzjgdm = dm;
 		/*记录当前展示的组织机构名称*/
 		XjMap.zzjgmc = mc;
 		intoMC = mc;
 		/*计算辖区面积*/
 		//XjMap.showAreaMJ(15,zbz);
 		/*获取责任区民警*/
 		//XjMap.queryZrqUser();
 		//统计
 		XjMap.initFloatWin_back(XjMap.zzjgdm);
 		num++;
 	});	
 	
 	/*记录当前展示的组织机构代码*/
 	XjMap.zzjgdm = userOrgCode;
 	/*记录当前展示的组织机构名称*/
 	XjMap.zzjgmc = "";
 };
 

 /**
  * @title:initFloatWin
  * @description:辖区概况统计查询
  * @author: sny
  * @param  
  * @date:2014-10-23 14:17:48
  */	
 XjMap.initFloatWin = function(zzjgdm){
	XjMap.initFloatWin_back(zzjgdm);
 };
 
 /**
  * @title:queryZrqUser
  * @description:获取责任区民警
  * @author: sny
  * @param  
  * @date:2014-10-26 14:36:42
  */	
 XjMap.queryZrqUser = function(){
 	var params = {zzjgdm:XjMap.zzjgdm};
 	var fajax =new FrameTools.Ajax(contextPath+"/xj/queryZrqUser",XjMap.queryZrqUser_back);
 	fajax.send(params);
 };
 
 /**
  * @title:queryZrqUser_back
  * @description:获取责任区民警_回调函数
  * @author: sny
  * @param  
  * @date:2014-10-26 14:42:21
  */	
 XjMap.queryZrqUser_back = function(json){
 	/*
 	XjMap.queryHTML = "<div class='textwrap'><div class='oneText'>1</div><div class='title_big'>责任区信息</div></div>";
 	if(json!=null&&json.length>0){
 		for(var i=0;i<json.length;i++){
 			var username = json[i].username;
 			var telephone = json[i].telephone;
 			XjMap.queryHTML += "<div class='text1'>姓名：<span class='bold'>"+username+"</span> 电话：<span class='bold'>"+telephone+"</span></div>";
 		}
 	}
 	*/
 	//XjMap.queryHTML += "<div class='text1'>辖区面积：<span class='redText'>"+XjMap.XqMJ+"</span>(平方米)</div>";
 	/*责任区概况*/
 	XjMap.initFloatWin(XjMap.zzjgdm);
 	//组织机构名称
 	$jquery("#orgZzjgmc").html(XjMap.zzjgmc); 
 };
 
 /**
  * @title:showAreaMJ
  * @description:换算面积
  * @author: sny
  * @param  
  * @date:2014-10-25 16:49:48
  */	
 XjMap.showAreaMJ = function(lx,zbz){
 	XjMap.XqMJ = "";
 	var strLine = zbz;
 	var mj = "";
 	var polyline = new Polygon(strLine,'red',"3","1","#AACEEB");
 	if(lx == "15"){
 		mj = polyline.getArea();
 		mj = Math.round(mj*100)/100;
 		XjMap.XqMJ = mj;
 	}else{
 		mj = polyline.getArea()/1000000;
 		mj = Math.round(mj*100)/100;
 		XjMap.XqMJ = mj;
 		XjMap.PcsXqMJ = XjMap.XqMJ;
 	}	
 };
 
 /**
  * @title:initFloatWin_back
  * @description:辖区概况文字描述_回调函数
  * @author: sny
  * @param  
  * @date:2014-10-23 16:30:23
  */	
 XjMap.initFloatWin_back = function(json){
	 //var org = parent.frames.userOrgCode;
	 var htmlStr = '';
     $.ajax
		({
			url:contextPath+"/eachSevlet?zzjgdm="+ json,
			type:"post",
			dataType:"xml",
			success:function(xmls){
			  $(xmls).find('menu').each(
				    function(){
				       var SYRK_NUM= $(this).attr("SYRK_NUM");	
				       var CZRK_NUM= $(this).attr("CZRK_NUM");	
				       var LDRK_NUM= $(this).attr("LDRK_NUM");	
				       var ZDRK_NUM= $(this).attr("ZDRK_NUM");	
				       var ZJL_NUM= $(this).attr("ZJL_NUM");	
				       var XLJL_NUM= $(this).attr("XLJL_NUM");	
				       var XLCL_NUM= $(this).attr("XLCL_NUM");	 
				       var PCS_NUM= $(this).attr("PCS_NUM");	
				       var XLLX_NUM= $(this).attr("XLLX_NUM");	
				       var MJ_NUM= $(this).attr("MJ_NUM");	
					   htmlStr="<div class='text1'>实有人口: <span class='bold'>"+SYRK_NUM+"</span>人<br>" +
						"&nbsp;&nbsp;&nbsp;&nbsp;常住人口: <span class='bold'>"+CZRK_NUM+"</span>人<br>" +
						"&nbsp;&nbsp;&nbsp;&nbsp;流动人口: <span class='bold'>"+LDRK_NUM+"</span>人<Br>" +
						"&nbsp;&nbsp;&nbsp;&nbsp;重点人员: <span class='bold'>"+ZDRK_NUM+"</span>个<br>" +
						"&nbsp;&nbsp;&nbsp;&nbsp;总警力: <span class='bold'>"+ZJL_NUM+"</span>人<Br>" +
						"&nbsp;&nbsp;&nbsp;&nbsp;巡逻警力: <span class='bold'>"+XLJL_NUM+"</span>人<br>" +
						"&nbsp;&nbsp;&nbsp;&nbsp;巡逻车辆: <span class='bold'>"+XLCL_NUM+"</span>个<br>" +
						"&nbsp;&nbsp;&nbsp;&nbsp;派出所数量: <span class='bold'>"+PCS_NUM+"</span>个<br>" +
						"&nbsp;&nbsp;&nbsp;&nbsp;巡逻路线: <span class='bold'>"+XLLX_NUM+"</span>个<br>" +
					    "&nbsp;&nbsp;&nbsp;&nbsp;面积: <span class='bold'>"+MJ_NUM+"平方公里</span><br>" +
					    //"&nbsp;&nbsp;&nbsp;&nbsp;其他: <span class='bold'>"+zdqtNum+"</span>个</div>" +
						"</div>";
				  });
			},
			error:function(){
			}
		});
        //上面procedure执行有延时，故下面使用settimeout
        setTimeout(function() {
        	XjMap.queryHTML = htmlStr;
			//加载页面显示数据
			 XjMap.queryHTML += "<br><div class='text2'>" +
		 		"<a id='backBotton' class='l-btn l-btn-small' href='javascript:void(0)' group='' onclick='XjMap.back()'>" +
		 		"<span class='l-btn-left l-btn-icon-left'><span class='l-btn-text'>后退</span>" +
		 		"<span class='l-btn-icon icon-back'></span>" +
		 		"</span></a>" +
		 		" &nbsp" + 
		 		"<a id='backBotton' class='l-btn l-btn-small' href='javascript:void(0)' group='' onclick='XjMap.downMap();'>" +
		 		"<span class='l-btn-left l-btn-icon-left'><span class='l-btn-text'>下钻</span>" +
		 		"<span class='l-btn-icon icon-back'></span>" +
		 		"</span></a>" +
		 		"</div>";
			 if(XjMap.floatWin!=""){
				 XjMap.floatWin.close();
			 }
			 var titleWin = userOrgName+"统计";
			 if(XjMap.zzjgmc!="" && undefined != XjMap.zzjgmc){
				 titleWin = XjMap.zzjgmc+"统计";
				 $jquery("#OrgZzjgmc").html(XjMap.zzjgmc);
			 } 
			 //intoMC是下钻使用统计标题,使用完成清空
			 else if(intoMC != null && intoMC != ''){
				 titleWin = intoMC + "统计";
				 intoMC = '';
			 }
			 /*加载辖区概况窗口*/
			 var left = $jquery("#mapDiv").width() - 190;
			 XjMap.floatWin = new FrameTools.FloatWin(titleWin,"mapDiv",185,350,85,left,85,null,220,0.9);
			 XjMap.floatWin.setOpHtml(XjMap.queryHTML);
			 XjMap.queryHTML = "";
        }, 1000);
 };
	
 XjMap.downMap = function(){
	 //责任区则不下钻
	 var zero8 = dms.substr(dms.length-8, dms.length);
	 var zero6 = dms.substr(dms.length-6, dms.length);
	 var zero4 = dms.substr(dms.length-4, dms.length);
	 if(zero8 != "00000000" && zero6 != "000000" && zero4 != "0000"){
		 return;
	 }
	 XjMap.queryXjZrq(dms);
	 dms = "";
 };
 
//统计的后退功能，目前功能：大连市公安局情况，后退直接退到第一步；分局及其以下逐步后退；
 XjMap.back = function(){
		//删除地图事件_平移事件
		if(XjMap.EventListenerPan !=""){
			//XjMap.map._MapApp.removeMapEventListener(XjMap.EventListenerPan); 
		}
		//删除地图事件_放大缩小
		if(XjMap.EventListenerZoom !=""){
			//XjMap.map._MapApp.removeMapEventListener(XjMap.EventListenerZoom); 
		}
		XjMap.removeMark();
		
		XjMap.queryXjZzjg_back(XjMap.bjJson);
		
		/*根据图元素将地图放到最适合的级别和位置*/
		var org = parent.frames.userOrgCode;
		//大连市公安局，不画边界
		var zero8 = org.substr(org.length-8, org.length);
		if (zero8 != "00000000") {
			XjMap.map._MapApp.centerAtMBR(XjMap.Mbr);
		}
		if(userOrgCode!="210204410000"||screen.width>1600){
			/*新版本cliect自动适应级别有问题必须降一级*/
			//XjMap.map._MapApp.zoomOut();
		}
		//组织机构名称
		$jquery("#orgZzjgmc").html(userOrgName);
		num = 0;
	};
	
//end

XjMap.moveMapToBjzbz = function(){
	/*清楚地图上所有的标记*/
	XjMap.map._MapApp.clear();
	/*非地坐标*/
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/*记录边线中心点坐标*/
	XjMap.mbrArr = new Array();
	for(var j=0;j<bjnum;j++){
		var gArr = bj[j];
		/*创建边界图元素*/
		var polyline = XjMap.map.initPolyline(gArr,"blue");
		/*图元素添加到地图上*/
		if(polyline){
			XjMap.map._MapApp.addOverlay(polyline);
			XjMap.mbrArr.push(polyline);
			if(XjMap.Mbr==null){
				XjMap.Mbr = polyline.getMBR();
			}else{
				XjMap.Mbr = MBR.union(XjMap.Mbr,polyline.getMBR());
			}
		}
	}
	/*根据图元素将地图放到最适合的级别和位置*/
	XjMap.map._MapApp.centerAtMBR(XjMap.Mbr);
	/*新版本cliect自动适应级别有问题必须降一级*/
	//XjMap.map._MapApp.zoomOut();
};

var generalZbz = "";
var generalType = "";
var generalMapRadius="";
XjMap.polygonObj =null;
XjMap.point = null;
XjMap.mapRadius = null;
XjMap.pointBufferShape=null;
XjMap.pointObj=null;

//主方法

//map上添加Marker
function addMarker(title,zbx,zby,imgName,msgHtml,mouseFun,imgWidth,imgHeight,ifClearMap,dz_jzdzdm,type){
	XjMap.map._MapApp.closeInfoWindow();
	if(ifClearMap){
		XjMap.clearMap();
	}
	 if(title=="" || title==null){
		 title="";
	 }
	var marker = XjMap.map.initMarker(title,zbx,zby,imgName,null,null,imgWidth,imgHeight);
	marker.addListener("click", function(){
		if(type=="zdrk"){
			var msgHtml = queryPersonByDzDm(marker,dz_jzdzdm);
		} else if("jq" == type){
			var msgHtml = queryMsgJq(marker,dz_jzdzdm);
		} else if("aj" == type){
			var msgHtml = queryMsgAj(marker,dz_jzdzdm);
		} else if("sj" == type){
			var msgHtml = queryMsgSj(marker,dz_jzdzdm);
		}
		
	});
	//使用2张图片实现虚实效果
//	marker.addListener("mouseover", function(){
//	});
	
	XjMap.map._MapApp.addOverlay(marker);
	return marker;
};


//只清除marker
XjMap.clearMarkers = function(){
	XjMap.map._MapApp.closeInfoWindow();
	var objs = XjMap.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			var obj =objs[i].toString().split(",");
			if(obj.length<=2){
				XjMap.map._MapApp.removeOverlay(objs[i]);
			}
		}
	}
};
//清除地图上的查询图层
XjMap.clearGraph = function(){
	var objs = XjMap.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			if("getGeometryType" in objs[i] ){
				if(objs[i].getGeometryType()=="polygon"){
					XjMap.map._MapApp.removeOverlay(objs[i]);
				}else if(objs[i].getGeometryType()=="circle"){
					XjMap.map._MapApp.removeOverlay(objs[i]);
				}else if(objs[i].getGeometryType()=="rectangle"){
					XjMap.map._MapApp.removeOverlay(objs[i]);
				}
			}
		}
	}
};

//以点为对象居中
XjMap.centerByPoint = function(marker,zoomLevel,date, flag){
	var point = marker.getPoint() ;
	if(ifClearAll){
		XjMap.moveMapToBjzbz();
		XjMap.map._MapApp.addOverlay(marker);
		marker.addListener("click", function(){
			var msgHtml = "";
			if("jq" == flag){
				msgHtml = queryMsgJq(marker,date);
			} else if("aj" == flag){
				msgHtml = queryMsgAj(marker,date);
			} else if("sj" == flag){
				msgHtml = queryMsgSj(marker,date);
			} 
		});
	}
	XjMap.map._MapApp.centerAndZoom(point, zoomLevel);
	
};

function queryMsgJq(marker,date){
	var msgHtml=" <table border='0' cellpadding='0' cellspacing='10' width='300' align='center'>";
	msgHtml+="<tr><td>发生时间:</td><td>" + date.jjsj + "</td></tr>";
	var lb = window.top.getDictName(contextPath + '/common/dict/D_RK_ZDRKGLLB.js', '1');
	msgHtml += "<tr><td>出警方式:</td><td> "+ date.cjfs +"</td></tr>";
	msgHtml += "<tr><td>警情类别:</td><td> "+ date.jqlb +"</td></tr>";
	msgHtml += "<tr><td>简要警情:</td><td> "+ date.jyjq +"</td></tr>";
	//msgHtml+= "<tr align='center'><td></td><td><a href='javascript:void(0)' onclick='openCh("+ "1" +")'>更多</a></td></tr>";
	msgHtml+="</table>";
	marker.openInfoWindowHtml(msgHtml);
}

function queryMsgAj(marker,date){
	var msgHtml=" <table border='0' cellpadding='0' cellspacing='10' width='350' align='center'>";
	msgHtml+="<tr><td>案件编号:</td><td>" + date.ajbh + "</td></tr>";
	var lb = window.top.getDictName(contextPath + '/common/dict/D_RK_ZDRKGLLB.js', '1');
	msgHtml += "<tr><td>发案时间:</td><td> "+ date.fasj +"</td></tr>";
	msgHtml += "<tr><td>发案地址:</td><td> "+ date.faxz +"</td></tr>";
	//msgHtml += "<tr><td>案件类型:</td><td> "+ date.ajlx +"</td></tr>";
	msgHtml += "<tr><td>案件名称:</td><td> "+ date.ajmc +"</td></tr>";
	msgHtml+="</table>";
	marker.openInfoWindowHtml(msgHtml);
}

function queryMsgSj(marker,date){
	var msgHtml=" <table border='0' cellpadding='0' cellspacing='10' width='300' align='center'>";
	msgHtml+="<tr><td>事件编号:</td><td>" + date.sjbh + "</td></tr>";
	var lb = window.top.getDictName(contextPath + '/common/dict/D_RK_ZDRKGLLB.js', '1');
	msgHtml += "<tr><td>事件名称:</td><td> "+ date.sjmc +"</td></tr>";
	msgHtml += "<tr><td>发生时间:</td><td> "+ date.fasj +"</td></tr>";
	msgHtml += "<tr><td>触发人:</td><td> "+ date.cfr +"</td></tr>";
	msgHtml+="</table>";
	marker.openInfoWindowHtml(msgHtml);
}

//以点为对象居中
XjMap.centerByPoint = function(marker,zoomLevel,date){
	var point = marker.getPoint() ;
	if(ifClearAll){
		XjMap.moveMapToBjzbz();
		XjMap.map._MapApp.addOverlay(marker);
		marker.addListener("click", function(){
			var msgHtml = queryPersonByDzDm(marker,date);
		});
	}
	XjMap.map._MapApp.centerAtLatLng(point);
};

/**
 * 点击marker显示此地址有多少人
 */
function queryPersonByDzDm(marker,dz_jzdzdm){
	if(dz_jzdzdm!='-'&&dz_jzdzdm!=null){
		$.ajax({
			type:"GET",
			sync:true,
			url:contextPath+"/zdryjbxxb/queryPersonByDzDm",
			data:{dz_jzdzdm:dz_jzdzdm},
			dataType:'json',
			success:function(json){
				var len = json.length;
				var msgHtml=" <table border='0' cellpadding='0' cellspacing='10' width='100%' align='center'>";
				msgHtml+="<tr><td>姓名</td><td>类型</td></tr>";
				var jzwid="";
				for(var i=0;i<len;i++){
					jzwid = json[i].jzwid;
					var lb = window.top.getDictName(contextPath + '/common/dict/D_RK_ZDRKGLLB.js', json[i].zdrylxdm);
					msgHtml += "<tr><td>"+json[i].xm+"</td><td> "+lb+"</td></tr>";
				}
				msgHtml+= "<tr align='center'><td><a href='javascript:void(0)' onclick='openZk("+dz_jzdzdm+")'>更多</a></td></tr>";
				msgHtml+="</table>";
				marker.openInfoWindowHtml(msgHtml);
			}
		});
	} else {
		var msgHtml=" <table border='0' cellpadding='0' cellspacing='10' width='100%' align='center'>";
		msgHtml+="<tr><td>暂无地址</td></tr>";
		msgHtml+="</table>";
		marker.openInfoWindowHtml(msgHtml);
	}
}

function queryMsg(marker,date){
	var msgHtml=" <table border='0' cellpadding='0' cellspacing='10' width='100%' align='center'>";
	msgHtml+="<tr><td>发生时间:</td><td>" + date.jjsj + "</td></tr>";
	var lb = window.top.getDictName(contextPath + '/common/dict/D_RK_ZDRKGLLB.js', '1');
	msgHtml += "<tr><td>出警方式:</td><td> "+ date.cjfs +"</td></tr>";
	msgHtml += "<tr><td>警情类别:</td><td> "+ date.jqlb +"</td></tr>";
	msgHtml += "<tr><td>简要警情:</td><td> "+ date.jyjq +"</td></tr>";
	//msgHtml+= "<tr align='center'><td></td><td><a href='javascript:void(0)' onclick='openCh("+ "1" +")'>更多</a></td></tr>";
	msgHtml+="</table>";
	marker.openInfoWindowHtml(msgHtml);
}

function openCh(dz_jzdzdm){
	 if(dz_jzdzdm!=null&&dz_jzdzdm!=""){
	     //var hsUrl = "/forward/sqjw|building|buildingShow?bzdzid="+dz_jzdzdm+"&bs=3";
	     var hsUrl = "/forward/query|xjJqQueryListDown";
	     menu_open("更多智能巡警",hsUrl);
   }else{
      $.messager.alert("提示","暂无层户结构信息","info");
   }
}

function openZk(dz_jzdzdm){
	 if(dz_jzdzdm!=null&&dz_jzdzdm!=""){
	     var hsUrl = "/forward/sqjw|building|buildingShow?bzdzid="+dz_jzdzdm+"&bs=3";
	     menu_open("层户结构",hsUrl);
  }else{
     $.messager.alert("提示","暂无层户结构信息","info");
  }
}

//==============================================恒星======================================沈阳开始


var bsdm="";
var allsum_ssyj =new Array(); //后台查询出代码和颜色
var ssyjtype=""; //组织机构类型
var jsonData="" ; //统计图返回结果
var allneirong_ssyj=[];
var allneirong_ssyj_list=[];

var zzjgdm_ssyj="";
var zzjglx_ssyj="";
var Ftime_ssyj="";
var Etime_ssyj="";
var Type_ssyj="";

var allmark_FJ_ssyj=parent.frames.allmark_FJ_ssyjs;
var allmark_PCS_ssyj=parent.frames.allmark_PCS_ssyjs;
var allplane_FJ_ssyj=parent.frames.allplane_FJ_ssyjs;
var allplane_PCS_ssyj=parent.frames.allplane_PCS_ssyjs;

//kk为1查询2.统计图 。 a 组织机构代码。组织机构类型。c,d时间。e为选择类型
XjMap.showcx_ = function (kk,a,b,c,d,e){
	if(kk==""){
		return;
	}
	document.getElementById("tb_ssyj").style.display ='none'; 
	zzjgdm_ssyj=a;
	zzjglx_ssyj=b;
	Ftime_ssyj=c;
	Etime_ssyj=d;
	Type_ssyj =e;
	
	if(kk==0){
    	selectSJ(a,b,c,d,e);
	}else if(kk==1){
	    selectTJT(a,b,c,d,e);
	}
};

//清除
var clearSsyj = function(){
	if(allmark_PCS_ssyj.length!=0){
	    for(var i1=0; i1 < allmark_PCS_ssyj.length; i1++){
	    	XjMap.map._MapApp.removeOverlay(allmark_PCS_ssyj[i1]);
	    }
        for(var i2=0; i2 < allplane_PCS_ssyj.length; i2++){
	    	XjMap.map._MapApp.removeOverlay(allplane_PCS_ssyj[i2]);
	    }

		}
		
	
		if(allmark_FJ_ssyj.length!=0){
		   for(var i3=0; i3 < allmark_FJ_ssyj.length; i3++){
			  XjMap.map._MapApp.removeOverlay(allmark_FJ_ssyj[i3]);
		    }
	        for(var i4=0; i4 < allplane_FJ_ssyj.length; i4++){
			 XjMap.map._MapApp.removeOverlay(allplane_FJ_ssyj[i4]);
		    }
	    
		}
};

//查询开始
var selectSJ=function(ssyj_zzjgdm,ssyj_zzjglx,time1,time2,type){
	//四色预警，则清除区域范围
	XjMap.removeMark();
	ajaxLoading();
	XjMap.map._MapApp.closeInfoWindow();
	//分局开始就清除派出所；同理
	allsum_ssyj =new Array();
	 allneirong_ssyj=[];
	 allneirong_ssyj_list=[];
	
		if(allmark_PCS_ssyj.length!=0){
	    for(var i1=0; i1 < allmark_PCS_ssyj.length; i1++){
	    	XjMap.map._MapApp.removeOverlay(allmark_PCS_ssyj[i1]);
	    }
        for(var i2=0; i2 < allplane_PCS_ssyj.length; i2++){
	    	XjMap.map._MapApp.removeOverlay(allplane_PCS_ssyj[i2]);
	    }

		}
		
	
		if(allmark_FJ_ssyj.length!=0){
		   for(var i3=0; i3 < allmark_FJ_ssyj.length; i3++){
			  XjMap.map._MapApp.removeOverlay(allmark_FJ_ssyj[i3]);
		    }
	        for(var i4=0; i4 < allplane_FJ_ssyj.length; i4++){
			 XjMap.map._MapApp.removeOverlay(allplane_FJ_ssyj[i4]);
		    }
	    
		}
		   //allmark_PCS_ssyj=new Array();
	       //allplane_PCS_ssyj=new Array();
		   //allmark_FJ_ssyj=new Array();
	       //allplane_FJ_ssyj=new Array();
		
		$.ajax
		({
			url:contextPath+"/SsyjSevlet?type="+ type + "&time1=" + time1 + "&time2=" + time2+"&zzjgdm="+ssyj_zzjgdm+"&zzjglx="+ssyj_zzjglx,
			type:"post",
			dataType:"xml",
			success:function(xmls){
				 $(xmls).find('menu').each(function(idx){
	
	      var zzjgdm_= $(this).attr("zzjgdm");
	      var zzjgmc_= $(this).attr("zzjgmc");	
	      var sum_= $(this).attr("sum");	
	      var yszs=$(this).attr("ysz");	
	      var ysz_=yszs.split("||")[0];
	      var fz_=yszs.split("||")[7];
	      var a1=yszs.split("||")[1];
	      var a2=yszs.split("||")[2];
	      var a3=yszs.split("||")[3];
	      var a4=yszs.split("||")[4];
	      var a5=yszs.split("||")[5];
	      var a6=yszs.split("||")[6];
	      var bfb=yszs.split("||")[8];
	      //star
	      allsum_ssyj.push(zzjgdm_+"||"+ysz_);
	      var id_s="aaa"+(idx+1);
	      allneirong_ssyj+=id_s+"||"+zzjgmc_+"||"+sum_+"||"+fz_+"||"+ysz_+"||"+bfb+"=="; 
	      allneirong_ssyj_list+=id_s+"||"+a1+"||"+a2+"||"+a3+"||"+a4+"||"+a5+"||"+a6+"==";     
	
	      }
	   );
	   ssyjtype="";
	   ssyjtype =ssyj_zzjglx ;
	   var option = parent.frames.options;
		if(option.indexOf('ssyj') != -1){
			aaaa(0);
		} else {
			aaaa(1);
		}
	   showlb_ssyj();
	
			},
			error:function(){
				
			}
		});
};





//递归
function aaaa(i){

	if(i>=allsum_ssyj.length){
		 ajaxLoadEnd(); 
		 return;
	}else{
		var zzjgdm_ =allsum_ssyj[i].split("||")[0];
		var color = allsum_ssyj[i].split("||")[1];

		if(ssyjtype =="11"){
		 showssyj_fj(zzjgdm_,color,'11',i);
		}else{
		 showssyj_pcs(zzjgdm_,color,ssyjtype,i);
		}
		
		} 
} 


//跳转主页面

function showlb_ssyj(){
	window.parent.zdParms(allneirong_ssyj, allneirong_ssyj_list);
}

//统计图

var selectTJT=function(ssyj_zzjgdm,ssyj_zzjglx,time1,time2,type){
	ajaxLoading();
	$.ajax({
		url:contextPath+"/SsyjSevlet?type="+ type + "&time1=" + time1 + "&time2=" + time2+"&zzjgdm="+ssyj_zzjgdm+"&zzjglx="+ssyj_zzjglx,
		type:"post",
		dataType:"xml",
		success:function(xmls){
			
			var Tzzjg="";	
			var Tfz="";
			var Tsum="";
     $(xmls).find('menu').each(
    function(){
      var zzjgdm_= $(this).attr("zzjgdm");	
        var zzjgmc_= $(this).attr("zzjgmc");
          var sum_= $(this).attr("sum");
          var yszs=$(this).attr("ysz");	
           var fz_=yszs.split("||")[7];
      Tzzjg +='{"label":"'+zzjgmc_+'"},';
     Tfz +='{"value":"'+fz_+'"},';
     Tsum +='{"value":"'+sum_+'"},';
    }
   );
			
			jsonData='';
			if(type=='0'){
			jsonData += '{"chart":{"caption":"'+time1+'一周统计",';
			}else if(type=='1'){
			jsonData += '{"chart":{"caption":"'+time1+'年'+time2+'月统计",';
			}else if(type=='2'){
			jsonData += '{"chart":{"caption":"'+time1+'年第'+time2+'季度统计",';
			}else if(type=='3'){
				var ss1;
			     if(time2=='1'){
			     ss1="上";
			     }if(time2=='2'){
			     ss1="下";
			     }

			jsonData += '{"chart":{"caption":"'+time1+'年'+ss1+'半年统计",';
			}else if(type=='4'){
			jsonData += '{"chart":{"caption":"'+time1+'年统计",';
			}
			jsonData += '"numberprefix": "值", "plotgradientcolor": "","bgcolor": "FFFFFF", "showalternatehgridcolor": "0", "divlinecolor": "CCCCCC", "showvalues": "0",';
				jsonData += ' "showcanvasborder": "0", "canvasborderalpha": "0", "canvasbordercolor": "CCCCCC",  "canvasborderthickness": "1", "yaxismaxvalue": "5000", "captionpadding": "30",';
					jsonData += ' "yaxisvaluespadding": "15", "legendshadow": "0", "legendborderalpha": "0","palettecolors": "#f8bd19,#008ee4,#33bdda,#e44a00,#6baa01,#583e78", "showplotborder": "0", "showborder": "0","formatNumberScale": "0"},';
					jsonData += ' "categories": [{ "category": [';
					jsonData +=Tzzjg;
					jsonData +=' ] } ], "dataset": [ { "seriesname": "案件数", "data": [';
					jsonData +=Tsum;
					jsonData +=' ] }, {"seriesname": "阀值","data": [';
					jsonData +=Tfz;
					jsonData +='   ] } ]}';
	  show_tjt(jsonData);
		},
		error:function(){
			
		}
	});
};

function show_tjt(jsonData)
    {
	 ajaxLoadEnd();
	window.parent.zdParms_ssyj(jsonData);
	 }

//派出所
function showssyj_pcs(zzjgdm_,ysz_,ssyj_zzjglx,ww){

//  bstjt=1;
  XjMap.map._MapApp.clearLayers();
var queryObjects = new QueryObject();
var _subFields="mc:mc;dm:dm";
var _table = "gis210200000000.jb_pcs_pg";
queryObjects.serviceSource="http://10.80.1.165:9080/PGIS_S_Map/";
	queryObjects.queryType = 6;
	queryObjects.tableName = _table;
	queryObjects.addSubFields(_subFields);
	queryObjects.where="dm='"+zzjgdm_+"'";
	XjMap.map._MapApp.query(queryObjects,function(){
		var so = XjMap.map._MapApp.getQueryResult();
  for(var i=0; i < so.length; i++){
      	for(var j=0;j<so[i].features.length;j++){
     
         var linestr = so[i].features[j].linestr;
      	 var mc = so[i].features[j].fieldValues[0];
				 var dm = so[i].features[j].fieldValues[1];
	   		 var zbx = so[i].features[j].point.x;
		 		   var zby = so[i].features[j].point.y;
		 		   var _point = new Point(zbx,zby);
		 		   var _icon = new Icon();
				       _icon.image = "";
					     _icon.width = 0;
				      _icon.height = 0;
					 var _title = new Title(mc, 12, 2,"宋体", "#000000", "#e4f2fc", "#00B2FF", "1");
					 var marker_fj = new Marker(_point, _icon, _title);
	      		marker_fj.addListener("click",function(marker_fj,dm){
				  	return function(){
           selectEachFJPCS(marker_fj,dm,mc,zbx,zby,ssyj_zzjglx);
      	}
				}(marker_fj,dm));
        		allmark_PCS_ssyj.push(marker_fj);
	      		XjMap.map._MapApp.addOverlay(marker_fj);
  	var mp = new MultiPolygon(linestr,"#000000", 2,0.45, ysz_);
  
	 for (var m = 0; m < mp.getSegmentCount(); m++) 
	 {
	 var se = mp.getSegment(m); 
	 allplane_PCS_ssyj.push(se);
	 XjMap.map._MapApp.addOverlay(se);
     }
         
				}}
	
 aaaa(ww+1);
  
  });
}

//分局查询
function showssyj_fj(zzjgdm_,ysz_,ssyj_zzjglx,ww){
	XjMap.map._MapApp.centerAndZoom(new Point('122.05535','39.41894'),9);//
	XjMap.map._MapApp.clearLayers();
var queryObjects = new QueryObject();
var _subFields="mc:mc;dm:dm";
var _table = "gis210200000000.jb_gafj_pg";
queryObjects.serviceSource="http://10.80.1.165:9080/PGIS_S_Map/";
	queryObjects.queryType = 6;
	queryObjects.tableName = _table;
	queryObjects.addSubFields(_subFields);
	queryObjects.baseDistanceTolerance =0.001;
	if(ssyj_zzjglx=='11'){
	queryObjects.where="zzjgdm='"+zzjgdm_+"'";
	}
	XjMap.map._MapApp.query(queryObjects,function(){

		var so = XjMap.map._MapApp.getQueryResult();
	
	    for(var i=0; i < so.length; i++){
      	for(var j=0;j<so[i].features.length;j++){
      	    
      	  var linestr = so[i].features[j].linestr;
      	  var mc = so[i].features[j].fieldValues[0];
					var dm = so[i].features[j].fieldValues[1];
	   			    var zbx = so[i].features[j].point.x;
		 		    var zby = so[i].features[j].point.y;
		 		    var _point = new Point(zbx,zby);
		 		    var _icon = new Icon();
				        _icon.image = "";
					      _icon.width = 0;
				      	_icon.height = 0;
					   var _title = new Title(mc, 12, 2,"宋体", "#000000", "#e4f2fc", "#00B2FF", "1");
					   var marker_fj = new Marker(_point, _icon, _title);
					        marker_fj.addListener("click",function(marker_fj,dm){
				 			
					return function(){
                      selectEachFJPCS(marker_fj,dm,mc,zbx,zby,ssyj_zzjglx);
      
					}
				}(marker_fj,dm));
				 		allmark_FJ_ssyj.push(marker_fj);
				 		XjMap.map._MapApp.addOverlay(marker_fj); 

  	var mp = new MultiPolygon(linestr,"#000000", 2, 0.45, ysz_);

	 for (var m = 0; m < mp.getSegmentCount(); m++) 
	 {
	 var se = mp.getSegment(m);
	 allplane_FJ_ssyj.push(se);
	 XjMap.map._MapApp.addOverlay(se);
     }
		   	  	
				}}
	
 aaaa(ww+1);
  
  });
  
}

//点击分局弹出该区派出所

function bkwl_Marker_Click(dm,x1,y1){
	  if(XjMap.floatWin!=""){
			 XjMap.floatWin.close();
		 }
	  if(dm=='210203000000')
	  { 
		  XjMap.map._MapApp.centerAndZoom(new Point('121.60715','38.91477'),13);//
	     } if(dm=='210204000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.5868','38.90962'),13);//
	     }  if(dm=='210202000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.64139','38.91546'),13);//
	    } if(dm=='210283000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('122.88139','39.79522'),10);//
	    }  if(dm=='210281000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.7855','39.63317'),10);//
	    }  if(dm=='210212000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.25576','38.86962'),11);//
	    }if(dm=='210211000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.53659','38.95751'),11);//
	    } if(dm=='210213000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.79374','39.17449'),10);//
	    } if(dm=='210282000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('122.03956','39.41619'),10);//
	    } 


	   selectSJ(dm,12,Ftime_ssyj,Etime_ssyj,Type_ssyj);

}


var selectEachFJPCS=function(marker_fj,dm,mc,zbx,zby,ssyj_zzjglx){
	$.ajax
	({
		url:contextPath+"/eachSevlet?zzjgdm="+ dm,
		type:"post",
		dataType:"xml",
		success:function(xmls){
		var htmlStr = "";
	  $(xmls).find('menu').each(
  function(){
   var _point = new Point(zbx,zby);
     var SYRK_NUM= $(this).attr("SYRK_NUM");	
       var CZRK_NUM= $(this).attr("CZRK_NUM");	
         var LDRK_NUM= $(this).attr("LDRK_NUM");	
           var ZDRK_NUM= $(this).attr("ZDRK_NUM");	
             var ZJL_NUM= $(this).attr("ZJL_NUM");	
               var XLJL_NUM= $(this).attr("XLJL_NUM");	
                 var XLCL_NUM= $(this).attr("XLCL_NUM");	 
                 var PCS_NUM= $(this).attr("PCS_NUM");	
                   var XLLX_NUM= $(this).attr("XLLX_NUM");	
                     var MJ_NUM= $(this).attr("MJ_NUM");	
                     var htmlSt=""; 
          htmlStr="<div class='text1'>实有人口: <span class='bold'>"+SYRK_NUM+"</span>人<br>" +
                 	"&nbsp;&nbsp;&nbsp;&nbsp;常住人口: <span class='bold'>"+CZRK_NUM+"</span>人<br>" +
                 	"&nbsp;&nbsp;&nbsp;&nbsp;流动人口: <span class='bold'>"+LDRK_NUM+"</span>人<Br>" +
                 	"&nbsp;&nbsp;&nbsp;&nbsp;重点人员: <span class='bold'>"+ZDRK_NUM+"</span>个<br>" +
                 	"&nbsp;&nbsp;&nbsp;&nbsp;总警力: <span class='bold'>"+ZJL_NUM+"</span>人<Br>" +
                 	"&nbsp;&nbsp;&nbsp;&nbsp;巡逻警力: <span class='bold'>"+XLJL_NUM+"</span>人<br>" +
                 	"&nbsp;&nbsp;&nbsp;&nbsp;巡逻车辆: <span class='bold'>"+XLCL_NUM+"</span>个<br>" +
                 	"&nbsp;&nbsp;&nbsp;&nbsp;派出所数量: <span class='bold'>"+PCS_NUM+"</span>个<br>" +
                 	"&nbsp;&nbsp;&nbsp;&nbsp;巡逻路线: <span class='bold'>"+XLLX_NUM+"</span>个<br>" +
                  "&nbsp;&nbsp;&nbsp;&nbsp;面积: <span class='bold'>"+MJ_NUM+"平方公里</span><br>" +
                 	"</div>"; 
          htmlStr += "<br/><br/><div align='rigth'>&nbsp;&nbsp;&nbsp;&nbsp;";
           if(ssyj_zzjglx=='11'){
          htmlStr += "<a href='javascript:void(0)' id='baBotton' class='easyui-linkbutton'  iconCls='icon-search' onclick='bkwl_Marker_Click(\""+dm+"\",\""+zbx+"\",\""+zby+"\");'>下属派出所</a>&nbsp;&nbsp;&nbsp;"; 
          }else{
        	  htmlStr +="<div class='text2'><a id='backBotton' class='l-btn l-btn-small' href='javascript:void(0)' group='' onclick='selectBJ(2);'><span class='l-btn-left l-btn-icon-left'><span class='l-btn-text'>后退</span><span class='l-btn-icon icon-back'></span></span></a>&nbsp;&nbsp;&nbsp;";
              //  htmlStr += "<a id='baBotton' class='l-btn l-btn-small' href='javascript:void(0)'  onclick='selectBJ(2);'>返回<span class='l-btn-icon icon-back'></span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
              htmlStr += "<a id='baBotton' href='javascript:void(0)' class='easyui-linkbutton'  iconCls='icon-search' onclick='bkwl_tz_Click(\""+dm+"\");'>巡逻力量</a></div>";
          }
          htmlStr += "</div>";

}  );
	  
	  if(XjMap.floatWin!=""){
			 XjMap.floatWin.close();
		 }
		 var titleWin =mc+"";
		 var left = $jquery("#mapDiv").width() - 190;
		 XjMap.floatWin = new FrameTools.FloatWin(titleWin,"mapDiv",185,350,85,left,85,null,220,0.9);
		 XjMap.floatWin.setOpHtml(htmlStr);
	

		},
		error:function(){
			
		}
	});
};
function bkwl_tz_Click (dm)
{ 
		  var urs="http://10.80.5.228:9090/xjpt/html/CarUserInfo.html?zzjglx=13&zzjgdm="+dm;
		   	window.showModalDialog(urs, window, "Status:No;DialogWidth:570px;DialogHeight:610px;help:no");
   }



//Loading
var ajaxLoading=function(){

	$('<div class="datagrid-mask"></div>').css({
		display:'block',
		width:'100%',
		height:500
	}).appendTo('body');
	$('<div class="datagrid-mask-msg"></div>').html('正在处理，请稍候...').appendTo('body').css({
		display:'block',
		left:500,
		top:200
	});

};
//Loading end
var ajaxLoadEnd=function(){
	$('.datagrid-mask').remove();
	$('.datagrid-mask-msg').remove();
};
function selectBJ(){
   	selectSJ(zzjgdm_ssyj,zzjglx_ssyj,Ftime_ssyj,Etime_ssyj,Type_ssyj);
	  document.getElementById("tb_ssyj").style.display ='none'; 
}

XjMap.queryButton = function(){
	//恒星
	var html = " <div  id='tb_ssyj' style='right:50px;bottom:50px;position:absolute;display: none'> <img style='cursor:hand' src='../images/arrow_left_green.png' onclick='selectBJ(2);' /></div>";
	$("#mapDiv").append(html);

}

//wuw
document.writeln("<script type='text/javascript' src='"+basePath+"js/xj/alermAnalysis.js'></script>");
document.writeln("<script type='text/javascript' src='"+basePath+"js/xj/patrolLine.js'></script>");
//wuw

//===================巡逻员==========



var arrmark_xly=new Array();
XjMap.showmap_xly = function (sb){

	arrmark_xly=new Array();
	for(var i=0; i < sb.length; i++){

		 var zbx=sb[i].split("||")[0];
		 var zby=sb[i].split("||")[1];
		 var name=sb[i].split("||")[2];
		 var GPSID=sb[i].split("||")[3];
		 
	    	var jzlx="";
			var _point = new Point(zbx, zby);
			var _icon = new Icon();
         	_icon.image =contextPath+"/images/xly.png";
				jzlx="巡逻员";
		    
			_icon.width = 20;
			_icon.height = 20;
	var _title = new Title(name, 12, 2,"宋体", "#000000", "#e4f2fc", "#00B2FF", "1");
		var  _maker = new Marker(_point, _icon, _title);
		
				_maker.addListener("click",function(_maker,GPSID){
				return function(){
					var strMsg= addListenerEvent_xly(name,GPSID,zbx,zby,jzlx);
						_maker.openInfoWindowHtml(strMsg);

				}
			}(_maker,GPSID));
			 XjMap.map._MapApp.addOverlay(_maker);
			 arrmark_xly.push(_maker);
	 }
		 
	 
};


XjMap.show_dw_map_xly = function (dm){
	  if(dm=='210203000000')
	  { 
		  XjMap.map._MapApp.centerAndZoom(new Point('121.60715','38.91477'),13);//
	     } if(dm=='210204000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.5868','38.90962'),13);//
	     }  if(dm=='210202000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.64139','38.91546'),13);//
	    } if(dm=='210283000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('122.88139','39.79522'),13);//
	    }  if(dm=='210281000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.7855','39.63317'),13);//
	    }  if(dm=='210212000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.25576','38.86962'),13);//
	    }if(dm=='210211000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.53659','38.95751'),13);//
	    } if(dm=='210213000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.79374','39.17449'),13);//
	    } if(dm=='210282000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('122.03956','39.41619'),13);//
	    }   if(dm=='210200000000')
		  { 
	    	XjMap.map._MapApp.centerAndZoom(new Point('122.05535','39.41894'),9);//
	    } 
};

//===================巡逻车==========

var arrmark_xlc=new Array();
XjMap.showmap_xlc = function (sb){

	arrmark_xlc=new Array();
	for(var i=0; i < sb.length; i++){

		 var zbx=sb[i].split("||")[0];
		 var zby=sb[i].split("||")[1];
		 var name=sb[i].split("||")[2];
		 var GPSID=sb[i].split("||")[3];
		 
	    	var jzlx="";
			var _point = new Point(zbx, zby);
			var _icon = new Icon();
         	_icon.image =contextPath+"/images/xlc.png";
				jzlx="巡逻车";
		    
			_icon.width = 20;
			_icon.height = 20;
	var _title = new Title(name, 12, 2,"宋体", "#000000", "#e4f2fc", "#00B2FF", "1");
		var  _maker = new Marker(_point, _icon, _title);
		
				_maker.addListener("click",function(_maker,GPSID){
				return function(){
					var strMsg= addListenerEvent_xlc(name,GPSID,zbx,zby,jzlx);
						_maker.openInfoWindowHtml(strMsg);

				}
			}(_maker,GPSID));
			 XjMap.map._MapApp.addOverlay(_maker);
			 arrmark_xlc.push(_maker);
	 }
		 
	 
};



XjMap.show_dw_map_xlc = function (dm){
	  if(dm=='210203000000')
	  { 
		  XjMap.map._MapApp.centerAndZoom(new Point('121.60715','38.91477'),13);//
	     } if(dm=='210204000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.5868','38.90962'),13);//
	     }  if(dm=='210202000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.64139','38.91546'),13);//
	    } if(dm=='210283000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('122.88139','39.79522'),13);//
	    }  if(dm=='210281000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.7855','39.63317'),13);//
	    }  if(dm=='210212000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.25576','38.86962'),13);//
	    }if(dm=='210211000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.53659','38.95751'),13);//
	    } if(dm=='210213000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('121.79374','39.17449'),13);//
	    } if(dm=='210282000000')
	  { 
	    	 XjMap.map._MapApp.centerAndZoom(new Point('122.03956','39.41619'),13);//
	    }  if(dm=='210200000000')
		  { 
	    	XjMap.map._MapApp.centerAndZoom(new Point('122.05535','39.41894'),9);//
	    } 
};

//巡警2015年修改

XjMap.showmap_xly_make = function (list){

        var zbx=list.split("||")[0];
		var zby=list.split("||")[1];
	     var name=list.split("||")[2];
	   	 var gpsid=list.split("||")[3];
		
			var _point = new Point(zbx, zby);
			var _icon = new Icon();
		   	_icon.image =contextPath+"/images/xly.png";
         	_icon.width = 20;
			_icon.height = 20;
	    var _title = new Title(gpsid, 12, 2,"宋体", "#000000", "#e4f2fc", "#00B2FF", "1");
		var  _maker = new Marker(_point, _icon, _title);

				_maker.addListener("click",function(_maker,zbx,zby,name,gpsid){
				return function(){
		       	var strMsg= addListenerEvent_xly(zbx,zby,name,gpsid);
						_maker.openInfoWindowHtml(strMsg);

				}
			}(_maker,zbx,zby,name,gpsid));
			 XjMap.map._MapApp.addOverlay(_maker);
			  return _maker;
	 
	 
};


XjMap.showmap_xly_new = function (list){

         var zbx=list.zbx;
		 var zby=list.zby;
		 var name=list.xm;
	  	 var gpsid=list.gpsid;
			var _point = new Point(zbx, zby);
			var _icon = new Icon();
		  	_icon.image =contextPath+"/images/xly.png";

		    
			_icon.width = 20;
			_icon.height = 20;
	var _title = new Title(gpsid, 12, 2,"宋体", "#000000", "#e4f2fc", "#00B2FF", "1");
		var  _maker = new Marker(_point, _icon, _title);

				_maker.addListener("click",function(_maker,zbx,zby,name,gpsid){
				return function(){
		
					var strMsg= addListenerEvent_gps(zbx,zby,name,gpsid);
						_maker.openInfoWindowHtml(strMsg);

				}
			}(_maker,zbx,zby,name,gpsid));
			 XjMap.map._MapApp.addOverlay(_maker);
	
	 
};
function addListenerEvent_xly(zbx,zby,name,gpsid){

	var htmlStr = "<table  cellspacing='0' cellpadding='2'>";

	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>姓名:</td><td>" +name+ "</td>";
	htmlStr += "</tr>";
     htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>GPSID:</td><td>" + gpsid + "</td>";
	htmlStr += "</tr>";
	
	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>坐标&nbsp;&nbsp;X:</td><td>" + zbx + "</td>";
	htmlStr += "</tr>";
	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>坐标&nbsp;&nbsp;Y:</td><td>" + zby + "</td>";
	htmlStr += "</tr>";
	htmlStr += "<tr>";
	htmlStr += "<td>&nbsp;</td>";
	htmlStr += "</tr>";

	htmlStr += "</table>";

	return htmlStr;
}

XjMap.showpoint_map_xly = function (name,zbx,zby,gpsid){
	var _point = new Point(zbx, zby);
	XjMap.map._MapApp.centerAndZoom(_point,12);
	var htmlStr= addListenerEvent_xly(zbx,zby,name,gpsid);
	 XjMap.map._MapApp.openInfoWindow(_point, htmlStr, true) 

	
};
//清除
XjMap.clearshowpoint_map_xly = function (_maker){
	
	 XjMap.map._MapApp.removeOverlay(_maker);

};
//定位
XjMap.show_dw_map_gps = function (dm){
		  XjMap.map._MapApp.centerAndZoom(new Point('121.56234','38.99528'),10);//	   
};

//生成新MAKE

XjMap.showmap_xly_MAKENEW = function (list){

     var zbx=list.split("||")[0];
	 var zby=list.split("||")[1];
	 var name=list.split("||")[2];
     var gpsid=list.split("||")[3];
		var _point = new Point(zbx, zby);
		var _icon = new Icon();
	  	_icon.image =contextPath+"/images/xly.png";
        _icon.width = 20;
		_icon.height = 20;
   var _title = new Title(gpsid, 12, 2,"宋体", "#000000", "#e4f2fc", "#00B2FF", "1");
	var  _makerSNEW = new Marker(_point, _icon, _title);
		 return _makerSNEW;
 
};
//巡逻车2015年修改

XjMap.showmap_xlc_make = function (list){

        var zbx=list.split("||")[0];
		var zby=list.split("||")[1];
	     var name=list.split("||")[2];
	   	 var gpsid=list.split("||")[3];
		
			var _point = new Point(zbx, zby);
			var _icon = new Icon();
		   	_icon.image =contextPath+"/images/xlc.png";
         	_icon.width = 20;
			_icon.height = 20;
	    var _title = new Title(gpsid, 12, 2,"宋体", "#000000", "#e4f2fc", "#00B2FF", "1");
		var  _maker = new Marker(_point, _icon, _title);

				_maker.addListener("click",function(_maker,zbx,zby,name,gpsid){
				return function(){
		       	var strMsg= addListenerEvent_xlc(zbx,zby,name,gpsid);
						_maker.openInfoWindowHtml(strMsg);

				}
			}(_maker,zbx,zby,name,gpsid));
			 XjMap.map._MapApp.addOverlay(_maker);
			  return _maker;
	 
	 
};


XjMap.showmap_xlc_new = function (list){

         var zbx=list.zbx;
		 var zby=list.zby;
		 var name=list.cph;
	  	 var gpsid=list.gpsid;
			var _point = new Point(zbx, zby);
			var _icon = new Icon();
		  	_icon.image =contextPath+"/images/xlc.png";

		    
			_icon.width = 20;
			_icon.height = 20;
	var _title = new Title(gpsid, 12, 2,"宋体", "#000000", "#e4f2fc", "#00B2FF", "1");
		var  _maker = new Marker(_point, _icon, _title);

				_maker.addListener("click",function(_maker,zbx,zby,name,gpsid){
				return function(){
		
					var strMsg= addListenerEvent_xlc(zbx,zby,name,gpsid);
						_maker.openInfoWindowHtml(strMsg);

				}
			}(_maker,zbx,zby,name,gpsid));
			 XjMap.map._MapApp.addOverlay(_maker);
	
	 
};
function addListenerEvent_xlc(zbx,zby,name,gpsid){

	var htmlStr = "<table  cellspacing='0' cellpadding='2'>";

	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>车牌号:</td><td>" +name+ "</td>";
	htmlStr += "</tr>";
     htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>GPSID:</td><td>" + gpsid + "</td>";
	htmlStr += "</tr>";
	
	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>坐标&nbsp;&nbsp;X:</td><td>" + zbx + "</td>";
	htmlStr += "</tr>";
	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>坐标&nbsp;&nbsp;Y:</td><td>" + zby + "</td>";
	htmlStr += "</tr>";
	htmlStr += "<tr>";
	htmlStr += "<td>&nbsp;</td>";
	htmlStr += "</tr>";

	htmlStr += "</table>";

	return htmlStr;
}

XjMap.showpoint_map_xlc = function (name,zbx,zby,gpsid){
	var _point = new Point(zbx, zby);
	XjMap.map._MapApp.centerAndZoom(_point,12);
	var htmlStr= addListenerEvent_xlc(zbx,zby,name,gpsid);
	 XjMap.map._MapApp.openInfoWindow(_point, htmlStr, true) 

	
};
//清除
XjMap.clearshowpoint_map_xlc = function (_maker){
	
	 XjMap.map._MapApp.removeOverlay(_maker);

};
//定位
XjMap.show_dw_map_gps = function (dm){
		  XjMap.map._MapApp.centerAndZoom(new Point('121.56234','38.99528'),10);//	   
};

//生成新MAKE

XjMap.showmap_xlc_MAKENEW = function (list){

     var zbx=list.split("||")[0];
	 var zby=list.split("||")[1];
	 var name=list.split("||")[2];
     var gpsid=list.split("||")[3];
		var _point = new Point(zbx, zby);
		var _icon = new Icon();
	  	_icon.image =contextPath+"/images/xly.png";
        _icon.width = 20;
		_icon.height = 20;
   var _title = new Title(gpsid, 12, 2,"宋体", "#000000", "#e4f2fc", "#00B2FF", "1");
	var  _makerSNEW = new Marker(_point, _icon, _title);
		 return _makerSNEW;
 
};
