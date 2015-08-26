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
		//辖区概况
		//HomePage.initFloatWin();
	}
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
		//HomePage.showAreaMJ(bjzbz);
		/*显示当前用户边界*/
		HomePage.moveMapToBjzbz();
	}
	//begin
	/*显示当前用户边界*/
	//大连市公安局，不画边界
	var zero8 = userOrgCode.substr(userOrgCode.length-8, userOrgCode.length);
	if (zero8 != "00000000") {
		HomePage.queryXjZrq(userOrgCode);
	} else {
		//XjMap.map._MapApp.zoomOut(9);
		//HomePage.map._MapApp.centerAndZoom(new Point('122.05535','39.41894'),9);
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
		var fajax =new FrameTools.Ajax(contextPath+"/xj/queryBzdzList",HomePage.bzdzListMBR_back);
		fajax.send(params);
	}
};

//begin
HomePage.intoMap = function(pnodes){
	//alert(JSON.stringify(pnodes));
	if(pnodes!=''){
		var temp = "";
		for(var i=0; i<pnodes.length; i++){
			temp += pnodes[i].orgcode + ",";
		}
		var params = {zzjgdm: temp.substr(0, temp.length-1)};
		var fajax =new FrameTools.Ajax(contextPath+"/xj/queryXjZzjgxj",HomePage.queryXjZzjg_back);
		fajax.send(params);
	}
};

//load zrq
HomePage.queryXjZrq = function(pnodes){ 
	if(pnodes!=''){
		var params = {id: '', orgcode: pnodes};
		var fajax =new FrameTools.Ajax(contextPath+"/xj/downMap", HomePage.intoMap);
		fajax.send(params);
	}
};

/**
 * @title:queryXjZzjg_back
 * @description:加载派出所全部责任区信息_回调函数
 * @param  
 */	

 HomePage.queryXjZzjg_back = function(json){
	
	 HomePage.removeMark();
	 if(json[0].bjzbz!=""){
			//HomePage.map._MapApp.clear();
		}
		if(json!=null&&json.length>0){
			//区域范围显示则四色预警清除
			//clearSsyj();
			HomePage.bjJson = json;
			HomePage.countZrq = json.length;
			var colors = new Array("#F1E740","#FFB543","#FF7A7B","#008080","#AA4400","#0000FF","#0066CC","#00CCCC","#6600CC","#FF99FF","#CCFFFF","#85D021","#4DC2ED","#EE431B","#E96A3B","#EE9539","#FDBE63","#FFFF66","#CC3333","#9966FF","#99CCFF","#FF00FF","#FF66CC","#996666","#00CC00","#330000","#336600","#666600","#990000","#996600","#99CC00","#CC0000","#CC6600","#CCCC00");
			//辖区面
			var option = parent.frames.options;
			//if(option.indexOf('qyfw') != -1){
				 //for(var i=0;i<HomePage.countZrq;i++){
				 var i = 0;
				
				json.MMM = setInterval(function(){
					if(i<HomePage.countZrq){
			        	if(undefined != json[i].bjzbz && null!=json[i].bjzbz && json[i].bjzbz!=""){
			        		var col = colors[i];
			        		HomePage.showArea(json[i].zzjgdm, json[i].zzjgmc, json[i].bjzbz, col);
			        	}
			        	
					} else {
						clearInterval(json.MMM);
					}
			        	
			        	i++;
				}, 130);
			     //}
			//}
		}
		//加载派出所概况
		if(HomePage.PcsTjJson!=""){
			//HomePage.initFloatWin_back(HomePage.PcsTjJson);
		}else{
			//HomePage.initFloatWin(userOrgCode);
		}
 };
 
 /**
  * @title:showArea
  * @description:各个辖区面
  * @author: sny
  * @param  begin
  * @date:2014-10-23 14:17:48
  */	
 var markerArr = new Array;
 HomePage.showArea = function(dm,mc,zbz,col){
 	var ObjMap = new Polygon(zbz, "red", 3, 0.4,col);
 	var pMbr = ObjMap.getMBR();
 	var cPoint = pMbr.centerPoint();
 	var _pTitle = new Title(mc,12,7,"宋体","#000000","#FFFFFF","#FFFFFF","2");
 	_pTitle.setPoint(cPoint);
 	HomePage.map._MapApp.addOverlay(ObjMap);
 	markerArr.push(ObjMap);
 	markerArr.push(_pTitle);
 	HomePage.map._MapApp.addOverlay(_pTitle);
 	//点击下钻到责任区
 	
 	/*记录当前展示的组织机构代码*/
 	HomePage.zzjgdm = userOrgCode;
 	/*记录当前展示的组织机构名称*/
 	HomePage.zzjgmc = "";
 };
 
//清空已存在坐标点
 HomePage.removeMark = function(){
	 if(HomePage.floatWin!=""){
		 HomePage.floatWin.close();
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
					HomePage.map._MapApp.removeOverlay(markerArr[j]);
				}
			}
		}
		HomePage.map._MapApp.closeInfoWindow();
	}
 
//end

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
		$("#yhid").css("height","500px");
	    HomePage.openFlag = false;
	    if(typeof EzServerClient != "undefined"){
	    	/*地图缩小一个级别*/
			HomePage.map._MapApp.zoomOut();
	    }
	}
};

HomePage.zoomWins = function(){
	if(HomePage.openFlag == false){
		$("#lhid").css("height","100%");
	    $("#shid").css("display","none");
	    $("#xqid").css("display","none");
	    $("#yhid").css("display","none");
	    //bigger
	    //window.frames["xlrw"].document.getElementById("sub").style.height = "100%";
	    $("#date").css("display","");
	    HomePage.openFlag = true;
	}else if(HomePage.openFlag == true){
		$("#lhid").css("height","500px");
	    $("#shid").css("display","block");
	    $("#xqid").css("display","block");
		$("#yhid").css("display","block");
		$("#date").css("display","none");
		//window.frames["xlrw"].document.getElementById("sub").style.height = "100%";
	    HomePage.openFlag = false;
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
		//$(document.getElementById("tdmapid")).mask("数据加载中...");
		lxs = lx.substring(lx.indexOf("^")+1, lx.length);
		lx = lx.substring(0, lx.indexOf("^"));
		var params = {lx:lx, lxs:lxs, zzjgdm:userOrgCode};
		var fajax =new FrameTools.Ajax(contextPath+"/xj/queryXjList",HomePage.syrkListMBR_back);
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
	
	var str = "";
	
	//加载坐标点以及气泡框
	for(var i=0;i<json.length;i++){
		var openHtml =  "<div>发生时间：<span>"+json[i].jjsj+"</span></div>&nbsp;" +
						"<div>出警方式：<span>"+json[i].cjfs+"</span></div>&nbsp;" +
						"<div>警情类别：<span>"+json[i].lx+"</span></div>&nbsp;" +
						"<div>简要警情：<span>"+json[i].jyjq+"</span></div>";
		
		var img = "jq_qz.png";
		var flag = json[i].flag;
		if('jq' == flag){
			if(json[i].lx == '1'){
				img = "jq_qz.png";
			} else if(json[i].lx == '2'){
				img = "jq_tj.png";
			} else if(json[i].lx == '3'){
				img = "jq_xs.png";
			} else if(json[i].lx == '4'){
				img = "jq_za.png";
			}
		} else if('aj' == flag){
			if(json[i].lxmc == '治安案件'){
				img = "aj_dao.png";
			} else if(json[i].lxmc == '刑事案件'){
				img = "aj_pian.png";
			} else if(json[i].lxmc == '其他'){
				img = "aj_qiang.png";
			} 
			
//			else if(json[i].zab == '03'){
//				img = "aj_pian.png";
//			} else if(json[i].zab == '04'){
//				img = "aj_fang.png";
//			} else if(json[i].zab == '05'){
//				img = "aj_dao.png";
//			} else if(json[i].zab == '06'){
//				img = "aj_dao.png";
//			} else if(json[i].zab == '07'){
//				img = "aj_dao.png";
//			} else if(json[i].zab == '08'){
//				img = "aj_dao.png";
//			}
		} else if('sj' == flag){
			
		}
		
		//暂时需求不添加气泡
		openHtml='';
		//坐标为空就不撒点
		if(json[i].zbx == '' || json[i].zby == ''){
			continue;
		}
		
		str = 'yes';
		
		var initMarker = HomePage.map.initMarker(json[i].mlphqc,json[i].zbx,json[i].zby, img,openHtml,null,30,30);
		HomePage.map._MapApp.addOverlay(initMarker);
		HomePage.mpdzMarkerArr.push(initMarker);
	}
	
	if('' == str){
		//$.messager.alert("提示","无坐标");
		$.messager.show({
			title: '提示',
			msg: '无坐标' ,
			timeout: 3000,
			showType:'slide'
		});
		
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
		var fajax =new FrameTools.Ajax(contextPath+"/xj/queryGzdxList",HomePage.gzdxListMBR_back);
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
		var fajax =new FrameTools.Ajax(contextPath+"/xj/queryldrkList",HomePage.ldrkListMBR_back);
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
		var fajax =new FrameTools.Ajax(contextPath+"/xj/queryjwrkList",HomePage.jwrkListMBR_back);
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
		var fajax =new FrameTools.Ajax(contextPath+"/xj/querynlList",HomePage.nlListMBR_back);
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
	var fajax =new FrameTools.Ajax(contextPath+"/xj/queryPcsTj",HomePage.initFloatWin_back);
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
	var czrkNum = 0,jzrkNum = 0,ldrkNum = 0,jwrkNum = 0,wlhrkNum = 0,zdrkNum = 0,jkdxNum = 0,jsbrNum = 0,fzcfNum = 0,qtgzdxNum = 0;
	var bzdzyhsNum = 0,bzdzwhsNum = 0,twNum = 0;
	var dwldNum = 0,dwwbNum=0,dwzsNum=0;
	var fwzsNum = 0,fwczfwNum=0,fwkzfNum=0,fwsyNum=0;
	var aqbnNum=0,aqbyNum=0,aqbzNum=0;
	var jqbnNum=0,jqbyNum=0,jqwpNum=0;
	var zdrkNum=0,zdflgNum=0;zdxdryNum=0;zdsfryNum=0;zdqtNum=0;
	var syrkwhsNum = 0;sydwwhsNum = 0;
	if(json!=null&&json.length>0){
		 if(HomePage.PcsTjJson == ""){
			 HomePage.PcsTjJson = json;
		 }
		 for(var i=0;i<json.length;i++){
			 if(json[i].lxmc=="常住人员"){
				 czrkNum = json[i].sl;
			 }else if(json[i].lxmc=="寄住人员"){
				 jzrkNum = json[i].sl;
			 }else if(json[i].lxmc=="暂住人口"){
				 ldrkNum = json[i].sl;
			 }else if(json[i].lxmc=="境外人员"){
				 jwrkNum = json[i].sl;
			 }else if(json[i].lxmc=="未落户人员"){
				 wlhrkNum = json[i].sl;
			 }else if(json[i].lxmc=="重口"){
				 zdrkNum = json[i].sl;
			 }else if(json[i].lxmc=="监管对象"){
				 jkdxNum = json[i].sl;
			 }else if(json[i].lxmc=="精神病人"){
				 jsbrNum = json[i].sl;
			 }else if(json[i].lxmc=="非正常访"){
				 fzcfNum = json[i].sl;
			 }else if(json[i].lxmc=="其它工作对象"){
				 qtgzdxNum = json[i].sl;
			 }else if(json[i].lxmc=="已核实"){
				 bzdzyhsNum = json[i].sl;
			 }else if(json[i].lxmc=="未核实"){
				 bzdzwhsNum = json[i].sl;
			 }else if(json[i].lxmc=="天网"){
				 twNum = json[i].sl;
			 }else if(json[i].lxmc=="全部单位"){
				 dwzsNum = json[i].sl;
			 }else if(json[i].lxmc=="宾馆旅店"){
				 dwldNum = json[i].sl;
			 }else if(json[i].lxmc=="上网服务场所"){
				 dwwbNum = json[i].sl;
			 }else if(json[i].lxmc=="所有房屋"){
				 fwzsNum = json[i].sl;
			 }else if(json[i].lxmc=="出租房屋"){
				 fwczfwNum = json[i].sl;
			 }else if(json[i].lxmc=="有人居住房屋"){
				 fwsyNum = json[i].sl;
			 }else if(json[i].lxmc=="本周发生"){
				 aqbzNum = json[i].sl;
			 }else if(json[i].lxmc=="本月发生"){
				 aqbyNum = json[i].sl;
			 }else if(json[i].lxmc=="本年发生"){
				 aqbnNum = json[i].sl;
			 }else if(json[i].lxmc=="本年刑事案件发生"){
				 jqbnNum = json[i].sl;
			 }else if(json[i].lxmc=="本年未破刑事案件"){
				 jqwpNum = json[i].sl;
			 }else if(json[i].lxmc=="本月刑事案件发生"){
				 jqbyNum = json[i].sl;
			 }else if(json[i].lxmc=="重点人口总计"){
				 zdrkNum = json[i].sl;
			 }else if(json[i].lxmc=="法轮功"){
				 zdflgNum = json[i].sl;
			 }else if(json[i].lxmc=="吸毒人员"){
				 zdxdryNum = json[i].sl;
			 }else if(json[i].lxmc=="上访人员"){
				 zdsfryNum = json[i].sl;
			 }else if(json[i].lxmc=="实有人口未核实"){
				 syrkwhsNum = json[i].sl;
			 }else if(json[i].lxmc=="实有单位未核实"){
				 sydwwhsNum = json[i].sl;
			 }
		 }
	}
	var syrkNum = parseFloat(czrkNum)+parseFloat(jzrkNum)+parseFloat(ldrkNum)+parseFloat(jwrkNum)+parseFloat(wlhrkNum);
	var gzdxNum = parseFloat(zdrkNum)+parseFloat(jkdxNum)+parseFloat(jsbrNum)+parseFloat(fzcfNum)+parseFloat(qtgzdxNum);
	var bzdzNum = parseFloat(bzdzyhsNum)+parseFloat(bzdzwhsNum);
	var fwkzfNum = parseFloat(fwzsNum)-parseFloat(fwsyNum);
	var zdqtNum = parseFloat(zdrkNum)-parseFloat(zdflgNum)-parseFloat(jkdxNum)-parseFloat(zdxdryNum)-parseFloat(zdsfryNum);
	HomePage.queryHTML += "<div class='textwrap'><div class='oneText'>1</div><div class='title_big'>" +
			"实有人口<span class='bigBlueText' onclick='HomePage.gridList(0);'>【"+syrkNum+"】</span></div></div>" +
			"<div class='text1'>" +
			"常住人口<span class='blueText' onclick='HomePage.gridList(1);'>"+czrkNum+"</span>人、" +
			"寄住人口<span class='blueText' onclick='HomePage.gridList(2);'>"+jzrkNum+"</span>人、" +
			"流动人口<span class='blueText' onclick='HomePage.gridList(3);'>"+ldrkNum+"</span>人、" +
			"境外人口<span class='blueText' onclick='HomePage.gridList(4);'>"+jwrkNum+"</span>人、" +
			"未落户人口<span class='blueText' onclick='HomePage.gridList(5);'>"+wlhrkNum+"</span>人。<br></div>" +
			"<div class='text1'>实有人口未核实<span class='blueText' onclick='HomePage.gridList(6);'>"+syrkwhsNum+"</span>人。</div>" +
			"<div class='textwrap'><div class='oneText'>2</div><div class='title_big'>" +
			"重点人员<span class='bigBlueText' onclick='HomePage.gridList(10);'>【"+zdrkNum+"】</span></div></div>" +
			"<div class='text1'>" +
			"法轮功<span class='bold'>"+zdflgNum+"</span>个、" +
			"监管对象<span class='bold'>"+jkdxNum+"</span>个、" +
			"吸毒人员<span class='bold'>"+zdxdryNum+"</span>个、" +
		    "上访人员<span class='bold'>"+zdsfryNum+"</span>个、" +
		    "其他<span class='bold'>"+zdqtNum+"</span>个。</div>" +
		    "<div class='textwrap'><div class='oneText'>3</div><div class='title_big'>" +
		    "实有单位<span class='bigBlueText' onclick='HomePage.gridList(20);'>【"+dwzsNum+"】</span></div></div>" +
			"<div class='text1'>" +
			"旅店<span class='bold'>"+dwldNum+"</span>个、" +
		    "网吧<span class='bold'>"+dwwbNum+"</span>个。<br></div>" +
		    "<div class='text1'>实有单位未核实<span class='blueText' onclick='HomePage.gridList(21);'>"+sydwwhsNum+"</span>人</div>";
	 if(HomePage.floatWin!=""){
		 HomePage.floatWin.close();
	 }
	 var titleWin = "辖区概况 "+HomePage.XqMJ+"(平方米)";
	 /*加载辖区概况窗口*/
	 var left = $("#mapDiv").width() - 260;
	 HomePage.floatWin = new FrameTools.FloatWin(titleWin,"mapDiv",250,350,85,left,85,null,250,0.9);
	 HomePage.floatWin.setOpHtml(HomePage.queryHTML);
	 HomePage.queryHTML = "";
};
/**
 * @title:gridList
 * @description:打开数据列表
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-11-05 14:01:21
 */	
HomePage.gridList = function(bs){
	if(bs=='0'){
		menu_open('实有人口', '/forward/syrk|syrkMain')
	}else if(bs=='1'){
		menu_open('常住人口', '/forward/syrk|syrkMain?syrkgllbdm=01')
	}else if(bs=='2'){
		menu_open('寄住人口', '/forward/syrk|syrkMain?syrkgllbdm=02')
	}else if(bs=='3'){
		menu_open('流动人口', '/forward/syrk|syrkMain?syrkgllbdm=03')
	}else if(bs=='4'){
		menu_open('境外人口', '/forward/syrk|syrkMain?syrkgllbdm=04')
	}else if(bs=='5'){
		menu_open('未落户人口', '/forward/syrk|syrkMain?syrkgllbdm=05')
	}else if(bs=='10'){
		menu_open('重点人口', '/forward/zdrk|zdrkMain')
	}else if(bs=='20'){
		menu_open('实有单位', '/forward/sydw|sydwMain')
	}else if(bs=='6'){
		menu_open('实有人口核实', '/forward/syrk|syrkHs')
	}else if(bs=='21'){
		menu_open('实有单位核实', '/forward/sydw|sydwHs')
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