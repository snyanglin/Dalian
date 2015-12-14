if(typeof HomePage == "undefined" || !HomePage){
	var HomePage = {};
};
HomePage = function(){
	this.pk = Math.random();
};
HomePage.map = null;//声明地图对象
HomePage.openFlag = false;//首页辖区地图是否放大
HomePage.mpdzMarkerArr = new Array();//放点对象
HomePage.mc = null;//统计名称
HomePage.mbrArr = new Array();//组织机构辖区面对象集合
HomePage.Mbr = null;//辖区外边框
HomePage.queryHTML = "";
HomePage.floatWin = "";
HomePage.XqMJ = "";
/**
 * @title:Jquery
 * @description:初始化社区警务主页面
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-07 15:27:23
 */
$(function(){
	if(typeof EzServerClient != "undefined"){
		HomePage.loadMap();
		HomePage.initFloatWin();
	}
	$("#mapDiv").resize(function(){
		 HomePage.openFloatWin();
	});
});
/**
 * @title:onloadMap
 * @description:初始化首页地图
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-08 13:30:21
 */
HomePage.loadMap = function(){
	/*地图对象*/
	HomePage.map = new FrameTools.Map();
	/*设置地图代理*/
	HomePage.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	HomePage.map.setMapDiv("mapDiv");
	/*加载地图*/
	HomePage.map.onloadMap();
	/*显示鹰眼*/
	HomePage.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	HomePage.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	HomePage.map.showNewMapServer("mapDiv","HomePage.map");
	/*加载地图工具条*/
	HomePage.map.buildTools("mapDiv","toolDiv","HomePage.map");
	/*设置工具条显示的位置*/
	HomePage.diyToolDiv();
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){HomePage.diyToolDiv();});
	if(bjzbz!="" && bjzbz!='null'){
		/*计算辖区面积*/
		HomePage.showAreaMJ(bjzbz);
		/*显示当前用户边界*/
		HomePage.moveMapToBjzbz();
	}
};
/**
 * @title:diyToolDiv
 * @description:设置工具条显示的位置
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-08 16:32:45
 */	
HomePage.diyToolDiv =function(){
	var left = $("#mapDiv").offset().left+5;
	var top = $("#mapDiv").height() - 5;
	$("#toolDiv").css({
		"top" : top,
		"left" : left
	});
};
/**
 * @title:moveMapToBjzbz
 * @description:显示当前用户边界
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-08 20:38:24
 */	
HomePage.moveMapToBjzbz = function(){
	/*清楚地图上所有的标记*/
	HomePage.map._MapApp.clear();
	/*非地坐标*/
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/*记录边线中心点坐标*/
	HomePage.mbrArr = new Array();
	for(var j=0;j<bjnum;j++){
		var gArr = bj[j];
		/*创建边界图元素*/
		var polyline = HomePage.map.initPolyline(gArr,"blue");
		/*图元素添加到地图上*/
		if(polyline){
			HomePage.map._MapApp.addOverlay(polyline);
			HomePage.mbrArr.push(polyline);
			if(HomePage.Mbr==null){
				HomePage.Mbr = polyline.getMBR();
			}else{
				HomePage.Mbr = MBR.union(HomePage.Mbr,polyline.getMBR());
			}
		}
	}
	/*根据图元素将地图放到最适合的级别和位置*/
	HomePage.map._MapApp.centerAtMBR(HomePage.Mbr);
};
/**
 * @title:bzdzListMBR
 * @description:标准地址统计图撒点
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-12 16:12:22
 */	
HomePage.bzdzListMBR = function(ztbs){
	if(typeof EzServerClient != "undefined"){
		$(document.getElementById("tdmapid")).mask("数据加载中...");
		var params = {ztbs:ztbs,zzjgdm:userOrgCode};
		var fajax =new FrameTools.Ajax(contextPath+"/homePage/queryBzdzList",HomePage.bzdzListMBR_back);
		fajax.send(params);
	}
};
/**
 * @title:bzdzListMBR_back
 * @description:标准地址统计图撒点_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-12 16:15:54
 */	
HomePage.bzdzListMBR_back = function(json){
	//关闭所有器已经打开的气泡框
	HomePage.map._MapApp.closeInfoWindow();
	//清空已存在坐标点
	if(HomePage.mpdzMarkerArr != null){
		var markerLen = HomePage.mpdzMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			HomePage.map._MapApp.removeOverlay(HomePage.mpdzMarkerArr[j]);
		}
	}
	//加载坐标点
	var listLen = json.length;
	for(var i=0;i<listLen;i++){
		var initMarker = HomePage.map.initMarker(json[i].mlphqc,json[i].zbx,json[i].zby,"location.png",null,null,34,34);
		HomePage.map._MapApp.addOverlay(initMarker);
		HomePage.mpdzMarkerArr.push(initMarker);
	}
	$(document.getElementById("tdmapid")).unmask();
};
/**
 * @title:syrkBzdzMain
 * @description:链接实有人口列表
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-15 14:28:32
 */	
HomePage.syrkBzdzMain = function(){
	menu_open("实有人口管理", "/forward/syrk|bzdzMain");
};
/**
 * @title:zoomWin
 * @description:放大辖区地图
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-16 19:45:00
 */	
HomePage.zoomWin = function(){
	if(HomePage.openFlag == false){
		$("#lhid").css("display","none");
	    $("#shid").css("display","none");
	    $("#xqid").css("display","none");
	    $("#gzjlid").css("display","none");
	    $("#yhid").css("height","100%");
	    HomePage.openFlag = true;
	    if(typeof EzServerClient != "undefined"){
	    	/*地图放大一个级别*/
			HomePage.map._MapApp.zoomIn();
	    }
	}else if(HomePage.openFlag == true){
		$("#lhid").css("display","block");
	    $("#shid").css("display","block");
	    $("#xqid").css("display","block");
	    $("#gzjlid").css("display","block");
		$("#yhid").css("height","500px");
	    HomePage.openFlag = false;
	    if(typeof EzServerClient != "undefined"){
	    	/*地图缩小一个级别*/
			HomePage.map._MapApp.zoomOut();
	    }
	}
};
/**
 * @title:syrkListMBR
 * @description:实有人口统计图撒点
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-16 20:27:32
 */	
HomePage.syrkListMBR = function(lx){
	if(typeof EzServerClient != "undefined"){
		$(document.getElementById("tdmapid")).mask("数据加载中...");
		var params = {syrkywlxdm:lx,gxzrqdm:userOrgCode};
		var fajax = new FrameTools.Ajax(contextPath+"/syrkGl/queryListByRyidYwlx",HomePage.syrkListMBR_back);
		fajax.send(params);
	}
};
/**
 * @title:syrkListMBR_back
 * @description:实有人口统计图撒点_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-16 20:28:43
 */	
HomePage.syrkListMBR_back = function(json){
	//关闭所有器已经打开的气泡框
	HomePage.map._MapApp.closeInfoWindow();
	//清空已存在坐标点
	if(HomePage.mpdzMarkerArr != null){
		var markerLen = HomePage.mpdzMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			HomePage.map._MapApp.removeOverlay(HomePage.mpdzMarkerArr[j]);
		}
	}
	//加载坐标点以及气泡框
	var listLen = json.length;
	for(var i=0;i<listLen;i++){
		if(json[i].jzd_zbx!=""&&json[i].jzd_zby!=""){
			var initMarker = HomePage.map.initMarker(json[i].xm,json[i].jzd_zbx,json[i].jzd_zby,"syrkBlue.png",null,null,43,37);
			HomePage.map._MapApp.addOverlay(initMarker);
			HomePage.mpdzMarkerArr.push(initMarker);
		}
	}
	$(document.getElementById("tdmapid")).unmask();
};
/**
 * @title:gzdxListMBR
 * @description:工作对象统计撒点统计
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-17 16:25:32
 */	
HomePage.gzdxListMBR = function(lx){
	if(typeof EzServerClient != "undefined"){
		$(document.getElementById("tdmapid")).mask("数据加载中...");
		var params = {lx:lx,zzjgdm:userOrgCode};
		var fajax =new FrameTools.Ajax(contextPath+"/homePage/queryGzdxList",HomePage.gzdxListMBR_back);
		fajax.send(params);
    }
};
/**
 * @title:gzdxListMBR_back
 * @description:工作对象统计撒点统计_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-17 16:25:32
 */	
HomePage.gzdxListMBR_back = function(json){
	//关闭所有器已经打开的气泡框
	HomePage.map._MapApp.closeInfoWindow();
	//清空已存在坐标点
	if(HomePage.mpdzMarkerArr != null){
		var markerLen = HomePage.mpdzMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			HomePage.map._MapApp.removeOverlay(HomePage.mpdzMarkerArr[j]);
		}
	}
	//加载坐标点以及气泡框
	var listLen = json.length;
	for(var i=0;i<listLen;i++){
		var openHtml =  "<div>重点：<span>"+json[i].zdsl+"</span></div>&nbsp;" +
						"<div>监管对象：<span>"+json[i].jgsl+"</span></div>&nbsp;" +
						"<div>精神病人：<span>"+json[i].jssl+"</span></div>&nbsp;" +
						"<div>非正常访：<span>"+json[i].fzsl+"</span></div>&nbsp;" +
						"<div>其他工作对象：<span>"+json[i].qtsl+"</span></div>";
		var initMarker = HomePage.map.initMarker(json[i].mlphqc,json[i].zbx,json[i].zby,"location.png",openHtml,null,34,34);
		HomePage.map._MapApp.addOverlay(initMarker);
		HomePage.mpdzMarkerArr.push(initMarker);
	}
	$(document.getElementById("tdmapid")).unmask();
};
/**
 * @title:ldrkListMBR
 * @description:流动人口统计撒点统计
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-17 16:26:12
 */	
HomePage.ldrkListMBR = function(lx,mc){
	if(typeof EzServerClient != "undefined"){
		$(document.getElementById("tdmapid")).mask("数据加载中...");
		HomePage.mc = mc;
		var params = {lx:lx,zzjgdm:userOrgCode};
		var fajax =new FrameTools.Ajax(contextPath+"/homePage/queryldrkList",HomePage.ldrkListMBR_back);
		fajax.send(params);
	}
};
/**
 * @title:ldrkListMBR_back
 * @description:流动人口统计撒点统计_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-17 16:28:47
 */	
HomePage.ldrkListMBR_back = function(json){
	//关闭所有器已经打开的气泡框
	HomePage.map._MapApp.closeInfoWindow();
	//清空已存在坐标点
	if(HomePage.mpdzMarkerArr != null){
		var markerLen = HomePage.mpdzMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			HomePage.map._MapApp.removeOverlay(HomePage.mpdzMarkerArr[j]);
		}
	}
	//加载坐标点以及气泡框
	var listLen = json.length;
	for(var i=0;i<listLen;i++){
		var openHtml =  "<div>"+HomePage.mc+"：<span>"+json[i].sl+"人</span></div>&nbsp;";
		var initMarker = HomePage.map.initMarker(json[i].mlphqc,json[i].zbx,json[i].zby,"location.png",openHtml,null,34,34);
		HomePage.map._MapApp.addOverlay(initMarker);
		HomePage.mpdzMarkerArr.push(initMarker);
	}
	$(document.getElementById("tdmapid")).unmask();
};
/**
 * @title:jwrkListMBR
 * @description:境外人口统计撒点统计
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-17 16:45:43
 */	
HomePage.jwrkListMBR = function(lx,mc){
	if(typeof EzServerClient != "undefined"){
		$(document.getElementById("tdmapid")).mask("数据加载中...");
		HomePage.mc = mc;
		var params = {lx:lx,zzjgdm:userOrgCode};
		var fajax =new FrameTools.Ajax(contextPath+"/homePage/queryjwrkList",HomePage.jwrkListMBR_back);
		fajax.send(params);
	}
};
/**
 * @title:jwrkListMBR_back
 * @description:境外人口统计撒点统计_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-17 16:51:32
 */	
HomePage.jwrkListMBR_back = function(json){
	//关闭所有器已经打开的气泡框
	HomePage.map._MapApp.closeInfoWindow();
	//清空已存在坐标点
	if(HomePage.mpdzMarkerArr != null){
		var markerLen = HomePage.mpdzMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			HomePage.map._MapApp.removeOverlay(HomePage.mpdzMarkerArr[j]);
		}
	}
	//加载坐标点以及气泡框
	var listLen = json.length;
	for(var i=0;i<listLen;i++){
		var openHtml =  "<div>"+HomePage.mc+"：<span>"+json[i].sl+"人</span></div>&nbsp;";
		var initMarker = HomePage.map.initMarker(json[i].mlphqc,json[i].zbx,json[i].zby,"location.png",openHtml,null,34,34);
		HomePage.map._MapApp.addOverlay(initMarker);
		HomePage.mpdzMarkerArr.push(initMarker);
	}
	$(document.getElementById("tdmapid")).unmask();
};

/**
 * @title:nlListMBR
 * @description:境外人口统计撒点统计
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-17 17:01:21
 */	
HomePage.nlListMBR = function(lx,mc){
	if(typeof EzServerClient != "undefined"){
		$(document.getElementById("tdmapid")).mask("数据加载中...");
		HomePage.mc = mc;
		var params = {lx:lx,zzjgdm:userOrgCode};
		var fajax =new FrameTools.Ajax(contextPath+"/homePage/querynlList",HomePage.nlListMBR_back);
		fajax.send(params);
	}
};
/**
 * @title:nlListMBR_back
 * @description:境外人口统计撒点统计_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-17 17:03:23
 */	
HomePage.nlListMBR_back = function(json){
	//关闭所有器已经打开的气泡框
	HomePage.map._MapApp.closeInfoWindow();
	//清空已存在坐标点
	if(HomePage.mpdzMarkerArr != null){
		var markerLen = HomePage.mpdzMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			HomePage.map._MapApp.removeOverlay(HomePage.mpdzMarkerArr[j]);
		}
	}
	//加载坐标点以及气泡框
	var listLen = json.length;
	for(var i=0;i<listLen;i++){
		var openHtml =  "<div>"+HomePage.mc+"：<span>"+json[i].sl+"人</span></div>&nbsp;";
		var initMarker = HomePage.map.initMarker(json[i].mlphqc,json[i].zbx,json[i].zby,"location.png",openHtml,null,34,34);
		HomePage.map._MapApp.addOverlay(initMarker);
		HomePage.mpdzMarkerArr.push(initMarker);
	}
	$(document.getElementById("tdmapid")).unmask();
};
/**
 * @title:initFloatWin
 * @description:辖区概况统计查询
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-11-05 10:30:21
 */	
HomePage.initFloatWin = function(){
	var params = {zzjgdm:userOrgCode};
	var fajax =new FrameTools.Ajax(contextPath+"/homePage/queryPcsTj",HomePage.initFloatWin_back);
	fajax.send(params);
};
/**
 * @title:initFloatWin_back
 * @description:辖区概况文字描述_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-11-05 10:30:21
 */	
HomePage.initFloatWin_back = function(json){
	var czrkNum = 0,jzrkNum = 0,ldrkNum = 0,jwrkNum = 0,wlhrkNum = 0,zdrkNum = 0;
	var dwldNum = 0,dwwbNum=0,dwzsNum=0;
	var gzdx_jgdxNum=0,gzdx_zdykNum=0, gzdx_jsbNum=0,gzdx_fzcsfNum=0,gzdx_nrsxNum=0,gzdx_zhNum=0,gzdx_fxdxNum=0;
	if(json!=null&&json.length>0){
		 if(HomePage.PcsTjJson == ""){
			 HomePage.PcsTjJson = json;
		 }
		 for(var i=0;i<json.length;i++){
			 if(json[i].lxmc=="常住人口"){
				 czrkNum = json[i].sl;
			 }else if(json[i].lxmc=="寄住人口"){
				 jzrkNum = json[i].sl;
			 }else if(json[i].lxmc=="流动人员"){
				 ldrkNum = json[i].sl;
			 }else if(json[i].lxmc=="境外人员"){
				 jwrkNum = json[i].sl;
			 }else if(json[i].lxmc=="未落户人员"){
				 wlhrkNum = json[i].sl;
			 }else if(json[i].lxmc=="放心对象"){
				 gzdx_fxdxNum = json[i].sl;
			 }else if(json[i].lxmc=="监管对象"){
				 gzdx_jgdxNum = json[i].sl;
			 }else if(json[i].lxmc=="重点人口"){
				 gzdx_zdykNum = json[i].sl;
			 }else if(json[i].lxmc=="肇事肇祸精神病人"){
				 gzdx_jsbNum = json[i].sl;
			 }else if(json[i].lxmc=="非正常上访人员"){
				 gzdx_fzcsfNum = json[i].sl;
			 }else if(json[i].lxmc=="纳入视线对象"){
				 gzdx_nrsxNum = json[i].sl;
			 }else if(json[i].lxmc=="全部单位"){
				 dwzsNum = json[i].sl;
			 }else if(json[i].lxmc=="宾馆旅店"){
				 dwldNum = json[i].sl;
			 }else if(json[i].lxmc=="上网服务场所"){
				 dwwbNum = json[i].sl;
			 }
		 }
	}
	var syrkNum = parseFloat(czrkNum)+parseFloat(jzrkNum)+parseFloat(ldrkNum)+parseFloat(jwrkNum)+parseFloat(wlhrkNum);
	var gzdxNum = parseFloat(gzdx_jgdxNum)+parseFloat(gzdx_zdykNum)+parseFloat(gzdx_jsbNum)+parseFloat(gzdx_fzcsfNum)+parseFloat(gzdx_nrsxNum);
	HomePage.queryHTML = "<div class='textwrap'><div class='oneText'>1</div><div class='title_big'>" +
			"实有人口<span class='bigBlueText' onclick='HomePage.gridList(10);'>【"+syrkNum+"】</span></div></div>" +
			"<div class='text1'>" +
			"常住人口<span class='bold'>"+czrkNum+"</span>人、" +
			"寄住人口<span class='bold'>"+jzrkNum+"</span>人、" +
			"流动人口<span class='bold'>"+ldrkNum+"</span>人、" +
			"境外人口<span class='bold'>"+jwrkNum+"</span>人、" +
			"未落户人口<span class='bold'>"+wlhrkNum+"</span>人。<br></div>" +
			"<div class='textwrap'><div class='oneText'>2</div><div class='title_big'>" +
			"工作对象<span class='bigBlueText' onclick='HomePage.gridList(20);'>【"+gzdxNum+"】</span></div></div>" +
			"<div class='text1'>" +
			"放心对象<span class='bold'>"+gzdx_fxdxNum+"</span>个、" +
			"监管对象<span class='bold'>"+gzdx_jgdxNum+"</span>个、" +
			"重点人口<span class='bold'>"+gzdx_zdykNum+"</span>个、" +
			"肇事肇祸精神病人<span class='bold'>"+gzdx_jsbNum+"</span>个、" +
		    "非正常上访人员<span class='bold'>"+gzdx_fzcsfNum+"</span>个、" +
		    "纳入视线对象<span class='bold'>"+gzdx_nrsxNum+"</span>个。</div>" +
		    "<div class='textwrap'><div class='oneText'>3</div><div class='title_big'>" +
		    "实有单位<span class='bigBlueText' onclick='HomePage.gridList(30);'>【"+dwzsNum+"】</span></div></div>" +
			"<div class='text1'>" +
			"旅店<span class='bold'>"+dwldNum+"</span>个、" +
		    "网吧<span class='bold'>"+dwwbNum+"</span>个。<br></div>";
	 //加载辖区概况弹出框
	 HomePage.openFloatWin();
};
/**
 * @title:openFloatWin
 * @description:加载辖区概况弹出框
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2015-04-18 20:52:32
 */	
HomePage.openFloatWin = function(){
	if(HomePage.floatWin!=""){
	    HomePage.floatWin.close();
	}
	var titleWin = "辖区概况 "+HomePage.XqMJ+"(平方米)";
	var left = $("#mapDiv").width() - 260;
	HomePage.floatWin = new FrameTools.FloatWin(titleWin,"mapDiv",250,350,85,left,85,null,250,0.9);
	HomePage.floatWin.setOpHtml(HomePage.queryHTML);
};
/**
 * @title:gridList
 * @description:打开数据列表
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-11-05 14:01:21
 */	
HomePage.gridList = function(bs){
	if(bs=='10'){
		menu_open('实有人口管理', '/forward/syrkgl|syrkGl')
	}else if(bs=='20'){
		menu_open('重点人员管理', '/zdryzb/manager')
	}else if(bs=='30'){
		menu_open('实有单位管理', '/sydwcx_dl/queryDwByLx')
	}
};
/**
 * @title:showAreaMJ
 * @description:换算面积
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-25 16:49:48
 */	
HomePage.showAreaMJ = function(zbz){
	HomePage.XqMJ = "";
	var strLine = zbz;
	var mj = "";
	var polyline = new Polygon(strLine,'red',"3","1","#AACEEB");
	mj = polyline.getArea();
	mj = Math.round(mj*100)/100;
	HomePage.XqMJ = mj;
};