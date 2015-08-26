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

//ssyj
 var kk = "";
 var ssyj_zzjgdm ="";
 var ssyj_zzjglx = "";
 var time1 = "";
 var time2 = "";
 var chestr = "";
 var jqlb = "";
//ssyj

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
	
	/*隐藏地图操作控件，包括一般地图控件、简化地图控件和标准地图控件。*/
	XjMap.map._MapApp.hideMapControl();
	
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){XjMap.diyToolDiv();});
	
	/*地图清空事件方法*/
	//XjMap.map._MapApp.addMapEventListener(EzEvent.MAP_CLEAROVERLAYS,function(obj){
	//	ifClearAll = true;
	//});
	
	if(bjzbz!="" && bjzbz!='null'){
		/*显示当前用户边界*/
		var org = parent.frames.userOrgCode;
		//大连市公安局，不画边界
		var zero8 = org.substr(org.length-8, org.length);
		if (zero8 != "00000000") {
			XjMap.moveMapToBjzbz();
			XjMap.map._MapApp.zoomOut();
		} else {
			//XjMap.map._MapApp.zoomOut(9);
			XjMap.map._MapApp.centerAndZoom(new Point('122.05535','39.41894'),9);
			
		}
	}
	
};

//load zrq
var parentType = '';
var parentOrgcode = '';
XjMap.queryXjZrqs = function(pnodes){ 
	parentOrgcode = pnodes.substring(0, 12);
	parentType = pnodes.substring(13, pnodes.length);
	if(pnodes!=''){
		var params = {id: '', orgcode: parentOrgcode};
		var fajax =new FrameTools.Ajax(contextPath+"/xj/downMap", XjMap.intoMaps);
		fajax.send(params);
	}
};

XjMap.intoMaps = function(pnodes){
	//alert(JSON.stringify(pnodes));
	if(pnodes!=''){
		var temp = "";
		for(var i=0; i<pnodes.length; i++){
			temp += pnodes[i].orgcode + ",";
		}
		var params = {zzjgdm: temp.substr(0, temp.length-1)};
		var fajax =new FrameTools.Ajax(contextPath+"/xj/queryXjZzjgxj",XjMap.queryXjZzjg_backs);
		fajax.send(params);
	}
};

XjMap.queryXjZzjg_backs = function(json){
	 XjMap.removeMark();
	 if(json[0].bjzbz!=""){
			//HomePage.map._MapApp.clear();
		}
	 	//大连公安局不铺面
	    var org = parent.frames.userOrgCode;
		var zero8 = org.substr(org.length-8, org.length);
		if (zero8 != "00000000") {	
			if(json!=null&&json.length>0){
				//区域范围显示则四色预警清除
				//clearSsyj();
				XjMap.bjJson = json;
				XjMap.countZrq = json.length;
				var colors = new Array("#F1E740","#FFB543","#FF7A7B","#008080","#AA4400","#0000FF","#0066CC","#00CCCC","#6600CC","#FF99FF","#CCFFFF","#85D021","#4DC2ED","#EE431B","#E96A3B","#EE9539","#FDBE63","#FFFF66","#CC3333","#9966FF","#99CCFF","#FF00FF","#FF66CC","#996666","#00CC00","#330000","#336600","#666600","#990000","#996600","#99CC00","#CC0000","#CC6600","#CCCC00");
				//辖区面
				var option = parent.frames.options;
				//if(option.indexOf('qyfw') != -1){
					 //for(var i=0;i<HomePage.countZrq;i++){
					 var i = 0;
					
					json.MMM = setInterval(function(){
						if(i<XjMap.countZrq){
				        	if(undefined != json[i].bjzbz && null!=json[i].bjzbz && json[i].bjzbz!=""){
				        		var col = colors[i];
				        		XjMap.showAreas(json[i].zzjgdm, json[i].zzjgmc, json[i].bjzbz, col);
				        	}
				        	
						} else {
							clearInterval(json.MMM);
						}
				        	
				        	i++;
					}, 130);
				     //}
				//}
			}
		}
		//加载派出所概况
		if(XjMap.PcsTjJson!=""){
			if(parentType == 'xqgk'){
				XjMap.initFloatWin_back(XjMap.PcsTjJson);
			} else {
				XjMap.initFloatWin_backs(XjMap.PcsTjJson);
			}
		}else{
			//XjMap.initFloatWin(userOrgCode);
			if(parentType == 'xqgk'){
				XjMap.initFloatWin(parentOrgcode);
			} else {
				XjMap.initFloatWins(userOrgCode);
			}
		}
};
        
 XjMap.initFloatWin = function(zzjgdm){
	XjMap.initFloatWin_back(zzjgdm);
 };
 
 XjMap.initFloatWins = function(zzjgdm){
	XjMap.initFloatWin_backs(zzjgdm);
 };
 
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
			 /*
			 XjMap.queryHTML += "<br><div class='text2'>" +
		 		" &nbsp" + 
		 		"<a id='backBotton' class='l-btn l-btn-small' href='javascript:void(0)' group='' onclick='XjMap.downMap();'>" +
		 		"<span class='l-btn-left l-btn-icon-left'><span class='l-btn-text'>下钻</span>" +
		 		"<span class='l-btn-icon icon-back'></span>" +
		 		"</span></a>" +
		 		"</div>";
		 	 */
			 if(XjMap.floatWin!=""){
				 XjMap.floatWin.close();
			 }
			 var titleWin = "辖区概况统计";//userOrgName+"统计";
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

//今日警情
XjMap.initFloatWin_backs = function(json){
	var date = new Date();
	var y = date.getFullYear();
	var m = date.getMonth()+1+'';
	if(m.length != 2){
		m = '0'+m;
	}
	var d = date.getDate()+'';
	if(d.length != 2){
		d = '0'+d;
	}
	var last = y + "-" + m + "-" + d;
	
	 var htmlStr = '';
   $.ajax
		({
			url:contextPath+"/jz/queryJrjq",
			type:"post",
			data: "gxdwdm=" + json + "&fqsj=" + "2015-01-01" + "&jssj=" + last,
			dataType:"json",
			success:function(xmls){
				htmlStr="<br><br>&nbsp;&nbsp;警情概况：<br><div class='text1'>报警总数: <span class='bold'>"+ xmls.countTotal +"</span>起<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;违法犯罪警情: <span class='bold'>"+ xmls.countWffz +"</span>起<br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;行事警情: <span class='bold'>"+ xmls.countXs +"</span>起<Br>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;治安警情: <span class='bold'>"+ xmls.countZa +"</span>起<br>" +
			    "&nbsp;&nbsp;&nbsp;&nbsp;其他: <span class='bold'>"+ xmls.countQt +"</span>起</div>" +
				"</div>";
			},
			error:function(){
			}
		});
      //上面procedure执行有延时，故下面使用settimeout
      setTimeout(function() {
      	XjMap.queryHTML = htmlStr;
			//加载页面显示数据
		/*	 
      	XjMap.queryHTML += "<br><div class='text2'>" +
		 		" &nbsp" + 
		 		"<a id='backBotton' class='l-btn l-btn-small' href='javascript:void(0)' group='' onclick='XjMap.downMap();'>" +
		 		"<span class='l-btn-left l-btn-icon-left'><span class='l-btn-text'>下钻</span>" +
		 		"<span class='l-btn-icon icon-back'></span>" +
		 		"</span></a>" +
		 		"</div>";
		 */
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

var markerArr = new Array;
var intoMC = '';
var num = 0;
XjMap.showAreas = function(dm,mc,zbz,col){
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
		if(parentType == 'xqgk'){
			XjMap.initFloatWin(XjMap.zzjgdm);
		} else {
			XjMap.initFloatWins(userOrgCode);
		}
		
		num++;
	});	
	
	/*记录当前展示的组织机构代码*/
	XjMap.zzjgdm = userOrgCode;
	/*记录当前展示的组织机构名称*/
	XjMap.zzjgmc = "";
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
		var fajax =new FrameTools.Ajax(contextPath+"/jz/querySsyj",XjMap.queryXjZzjg_back);
		fajax.send(params);
	}
};

XjMap.intoMap = function(pnodes){
	//alert(JSON.stringify(pnodes));
	if(pnodes!=''){
		var temp = "";
		for(var i=0; i<pnodes.length; i++){
			temp += pnodes[i].orgcode + ",";
		}
		var params = {zzjgdm: temp.substr(0, temp.length-1), time1: time1, time2: time2, ssyj_zzjglx: ssyj_zzjglx, chestr: chestr, jqlbdm: jqlb};
		var fajax =new FrameTools.Ajax(contextPath+"/jz/queryXjZzjgxj",XjMap.queryXjZzjg_into);
		fajax.send(params);
	}
};

//load zrq
XjMap.queryXjZrq = function(parm){
	XjMap.clearMarkers();
	XjMap.moveMapToBjzbz();
	/*新版本cliect自动适应级别有问题必须降一级*/
	XjMap.map._MapApp.zoomOut();
	if(parm!=''){
		var temp = parm["ssyj_zzjgdm"];
		if(typeof temp != "undefined"){
			kk = parm["kk"];
	 	    ssyj_zzjgdm = parm["ssyj_zzjgdm"];
	 	    ssyj_zzjglx = parm["ssyj_zzjglx"];
	 	    time1 = parm["time1"];
	 	    time2 = parm["time2"];
	 	    chestr = parm["chestr"];
	 	    jqlb = parm["jqlb"];
		} else {
			ssyj_zzjgdm = parm;
		}
		var params = {id: '', orgcode: ssyj_zzjgdm};
		var fajax =new FrameTools.Ajax(contextPath+"/jz/downMap", XjMap.intoMap);
		fajax.send(params);
		//加载统计
		//XjMap.initFloatWin_back(pnodes);
	}
};


/**
 * @title:queryXjZzjg_back
 * @description:加载派出所全部责任区信息_回调函数
 * @param  
 */	
var markerArr = new Array();

 XjMap.queryXjZzjg_back = function(json){
	 XjMap.removeMark();
	 if(json[0].bjzbz!=""){
			//XjMap.map._MapApp.clear();
		}
		if(json!=null&&json.length>0){
			//区域范围显示则四色预警清除
			XjMap.bjJson = json;
			XjMap.countZrq = json.length;
			//"#FFB543","#FF7A7B","#008080","#AA4400","#0000FF","#0066CC","#00CCCC","#6600CC","#FF99FF","#CCFFFF","#85D021","#4DC2ED","#EE431B","#E96A3B","#EE9539","#FDBE63","#FFFF66","#CC3333","#9966FF","#99CCFF","#FF00FF","#FF66CC","#996666","#00CC00","#330000","#336600","#666600","#990000","#996600","#99CC00","#CC0000","#CC6600","#CCCC00"
			var colors = new Array("#F1E740");
			//辖区面
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
 };
 
 //点击下钻
 XjMap.queryXjZzjg_into = function(json){
		
	 //XjMap.removeMark();
	 if(json[0].bjzbz!=""){
			//XjMap.map._MapApp.clear();
		}
		if(json!=null&&json.length>0){
			//区域范围显示则四色预警清除
			//XjMap.bjJson = json;
			XjMap.countZrq = json.length;
			//"#4dc2ed", "#85d021", "#ffb543", "#ff7a7b"
			var colors = new Array("red", "green", "orange", "yellow");
			//辖区面
				 //for(var i=0;i<XjMap.countZrq;i++){
				 var i = 0;
				json.MMM = setInterval(function(){
					if(i<XjMap.countZrq){
			        	if(undefined != json[i].bjzbz && null!=json[i].bjzbz && json[i].bjzbz!=""){
			        		var col = colors[i];
			        		XjMap.showArea(json[i].zzjgdm, json[i].zzjgmc, json[i].bjzbz, json[i].color=='' ? 'green' : json[i].color);
			        	}
			        	
					} else {
						clearInterval(json.MMM);
					}
			        	
			        	i++;
				}, 130);
			     //}
		}
 };
 
 var ObjMap = parent.frames.ObjMap;
 var _pTitle = parent.frames._pTitle; 
 
//清空已存在坐标点
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
	}
	
 /**
  * @title:showArea
  * @description:各个辖区面
  * @author: sny
  * @param  begin
  * @date:2014-10-23 14:17:48
  */	
 var intoMC = '';
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
 		XjMap.removeMark();
 		/*加载本责任区*/
 		//XjMap.showArea(dm,mc,zbz,col);
 		XjMap.queryXjZrq(dm);
 		//全局变量
 		dms = dm;
 		/*根据图元素将地图放到最适合的级别和位置*/
 		XjMap.map._MapApp.centerAtMBR(pMbr);
 		if(userOrgCode!="210204410000"||screen.width>1600){
 			/*新版本cliect自动适应级别有问题必须降一级*/
 			XjMap.map._MapApp.zoomOut();
 		}
 		/*记录当前展示的组织机构代码*/
 		XjMap.zzjgdm = dm;
 		/*记录当前展示的组织机构名称*/
 		XjMap.zzjgmc = mc;
 		intoMC = mc;
 	});	
 	
 	/*记录当前展示的组织机构代码*/
 	XjMap.zzjgdm = userOrgCode;
 	/*记录当前展示的组织机构名称*/
 	XjMap.zzjgmc = "";
 };
	
 XjMap.downMap = function(){
	 //责任区则不下钻
	 var zero8 = dms.substr(dms.length-8, dms.length);
	 var zero6 = dms.substr(dms.length-6, dms.length);
	 var zero4 = dms.substr(dms.length-4, dms.length);
	 if(zero8 != "00000000" && zero6 != "000000" && zero4 != "0000"){
		 return;
	 }
	 XjMap.queryXjZrqs(dms);
	 dms = "";
 }
 
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
		
		XjMap.queryXjZzjg_backs(XjMap.bjJson);
		
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

//每次自动撒点就缩小地图
function setMix(){
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
}

//map上添加Marker
function addMarker(title,zbx,zby,imgName,msgHtml,mouseFun,imgWidth,imgHeight,ifClearMap,dz_jzdzdm,type){
	setMix();
	/*新版本cliect自动适应级别有问题必须降一级*/
	//XjMap.map._MapApp.zoomOut();
	XjMap.map._MapApp.closeInfoWindow();
	if(ifClearMap){
		XjMap.clearMap();
	}
	 if(title=="" || title==null){
		 title="";
	 }
	var marker = XjMap.map.initMarker(title,zbx,zby,imgName,null,null,imgWidth,imgHeight);
	marker.addListener("click", function(){
		if(type == 'jq'){
			var msgHtml = queryMsgJq(marker,dz_jzdzdm);
		}
	});
	//使用2张图片实现虚实效果
//	marker.addListener("mouseover", function(){
//	});
	
	XjMap.map._MapApp.addOverlay(marker);
	return marker;
};

//map上添加Marker
function addMarkers(title,zbx,zby,imgName,msgHtml,mouseFun,imgWidth,imgHeight,ifClearMap,dz_jzdzdm,type){
	//XjMap.map._MapApp.closeInfoWindow();
	if(ifClearMap){
		XjMap.clearMap();
	}
	 if(title=="" || title==null){
		 title="";
	 }
	//alert(zbx + "" + zby);
	//setTimeout(function(){}, 3000);
	var marker = XjMap.map.initMarker(title,zbx,zby,imgName,null,null,imgWidth,imgHeight);
	marker.addListener("click", function(){
		if(type == 'jqs'){
			var msgHtml = queryMsgJq(marker,dz_jzdzdm);
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

function queryMsgJq(marker,date){
	var msgHtml=" <table border='0' cellpadding='0' cellspacing='10' width='300' align='center'>";
	msgHtml+="<tr><td>警情编号:</td><td>" + date.jjbh + "</td></tr>";
	msgHtml += "<tr><td>警情地点:</td><td> "+ date.jqdzxz +"</td></tr>";
	//msgHtml+= "<tr align='center'><td></td><td><a href='javascript:void(0)' onclick='openCh("+ "1" +")'>更多</a></td></tr>";
	msgHtml+="</table>";
	marker.openInfoWindowHtml(msgHtml);
}

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

//========恒星编写GPS地图部分==============



XjMap.showmap_gps = function (list){

        var zbx=list.split("||")[0];
		 var zby=list.split("||")[1];
		 var cph=list.split("||")[2];
		 var hh=list.split("||")[3];
     	 var gpsid=list.split("||")[4];
		 var dw=list.split("||")[5];
		 var lx=list.split("||")[6];
		 var tims=list.split("||")[7];
	  
			var _point = new Point(zbx, zby);
			var _icon = new Icon();
         	_icon.image =contextPath+"/images/jzym/pad1.png";

		    
			_icon.width = 20;
			_icon.height = 20;
	var _title = new Title(gpsid, 12, 2,"宋体", "#000000", "#e4f2fc", "#00B2FF", "1");
		var  _maker = new Marker(_point, _icon, _title);

				_maker.addListener("click",function(_maker,zbx,zby,cph,hh,gpsid,dw,lx,tims){
				return function(){
		
					var strMsg= addListenerEvent_gps(zbx,zby,cph,hh,gpsid,dw,lx,tims);
						_maker.openInfoWindowHtml(strMsg);

				}
			}(_maker,zbx,zby,cph,hh,gpsid,dw,lx,tims));
			 XjMap.map._MapApp.addOverlay(_maker);
			 
			 return _maker;
	 
	 
};


XjMap.showmap_gps_new = function (list){

        var zbx=list.zbx;
		 var zby=list.zby;
		 var cph=list.cph;
		 var hh=list.hh;
     	 var gpsid=list.gpsid;
		 var dw=list.dw;
		 var lx=list.lx;
		 var tims=list.tims;
	  
			var _point = new Point(zbx, zby);
			var _icon = new Icon();
         	_icon.image =contextPath+"/images/jzym/pad1.png";

		    
			_icon.width = 20;
			_icon.height = 20;
	var _title = new Title(gpsid, 12, 2,"宋体", "#000000", "#e4f2fc", "#00B2FF", "1");
		var  _maker = new Marker(_point, _icon, _title);

				_maker.addListener("click",function(_maker,zbx,zby,cph,hh,gpsid,dw,lx,tims){
				return function(){
		
					var strMsg= addListenerEvent_gps(zbx,zby,cph,hh,gpsid,dw,lx,tims);
						_maker.openInfoWindowHtml(strMsg);

				}
			}(_maker,zbx,zby,cph,hh,gpsid,dw,lx,tims));
			 XjMap.map._MapApp.addOverlay(_maker);
	
	 
};
function addListenerEvent_gps(zbx,zby,cph,hh,gpsid,dw,lx,tims){

	var htmlStr = "<table  cellspacing='0' cellpadding='2'>";

	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>车牌号:</td><td>" +cph+ "</td>";
	htmlStr += "</tr>";

	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>呼号:</td><td>" + hh + "</td>";
	htmlStr += "</tr>";
	htmlStr += "<tr>";
	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>GPSID:</td><td>" + gpsid + "</td>";
	htmlStr += "</tr>";
	htmlStr += "<tr>";
	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>所属单位:</td><td>" + dw + "</td>";
	htmlStr += "</tr>";
	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>所属类型:</td><td>" + lx + "</td>";
	htmlStr += "</tr>";
	htmlStr += "<tr>";
	htmlStr += "<td style='color:blue'>时间:</td><td>" + tims + "</td>";
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
XjMap.showpoint_map_gps = function (zbx,zby,cph,hh,gpsid,dw,lx,tims){
	var _point = new Point(zbx, zby);
	XjMap.map._MapApp.centerAndZoom(_point,12);
	var htmlStr= addListenerEvent_gps(zbx,zby,cph,hh,gpsid,dw,lx,tims);
	 XjMap.map._MapApp.openInfoWindow(_point, htmlStr, true) 

	
};
//清除
XjMap.clearshowpoint_map_gps = function (_maker){
	
	 XjMap.map._MapApp.removeOverlay(_maker);

};
//定位
XjMap.show_dw_map_gps = function (dm){
		  XjMap.map._MapApp.centerAndZoom(new Point('121.56234','38.99528'),10);//	   
};
//统计数目
XjMap.show_dw_sum_gps = function (SYRK_NUM,CZRK_NUM){
	var htmlStr = "";
	  htmlStr="<div class='text1'>总车辆: <span class='bold'>"+SYRK_NUM+"</span>辆<br>" +
     	"&nbsp;&nbsp;&nbsp;&nbsp;在线车辆: <span class='bold'>"+CZRK_NUM+"</span>辆<br>" +
    
     	"</div>"; 
htmlStr += "<br/><br/><div align='rigth'>&nbsp;&nbsp;&nbsp;&nbsp;";
htmlStr += "</div>";
if(XjMap.floatWin!=""){
	 XjMap.floatWin.close();
}
var titleWin ="车辆统计";
var left = $jquery("#mapDiv").width() - 190;
XjMap.floatWin = new FrameTools.FloatWin(titleWin,"mapDiv",185,150,225,left,85,null,220,0.9);
XjMap.floatWin.setOpHtml(htmlStr);

};
XjMap.show_dw_map_gps_clear = function (dm){
	XjMap.map._MapApp.clear();
};
//生成新MAKE


XjMap.showmapmake_gps = function (list){

        var zbx=list.split("||")[0];
		 var zby=list.split("||")[1];
     	 var gpsid=list.split("||")[4];
    		var _point = new Point(zbx, zby);
			var _icon = new Icon();
         	_icon.image =contextPath+"/images/jzym/pad1.png";

		    
			_icon.width = 20;
			_icon.height = 20;
	var _title = new Title(gpsid, 12, 2,"宋体", "#000000", "#e4f2fc", "#00B2FF", "1");
		var  _maker = new Marker(_point, _icon, _title);
	 return _maker;
	 
	 
};

XjMap.showmap_gps_MAKENEW = function (list){

    var zbx=list.split("||")[0];
	 var zby=list.split("||")[1];
	 var cph=list.split("||")[2];
	 var hh=list.split("||")[3];
 	 var gpsid=list.split("||")[4];
	 var dw=list.split("||")[5];
	 var lx=list.split("||")[6];
	 var tims=list.split("||")[7];
  
		var _point = new Point(zbx, zby);
		var _icon = new Icon();
     	_icon.image =contextPath+"/images/jzym/pad1.png";

	    
		_icon.width = 20;
		_icon.height = 20;
var _title = new Title(gpsid, 12, 2,"宋体", "#000000", "#e4f2fc", "#00B2FF", "1");
	var  _makerSNEW = new Marker(_point, _icon, _title);
		 return _makerSNEW;
 
 
};

//今日警情地图操作
document.writeln("<script type='text/javascript' src='"+basePath+"js/jzym/jrjq_mapOpe.js'></script>");
//四色预警 统计图开始
//a 组织机构代码。组织机构类型。c,d时间。e为选择类型
XjMap.queryXjChar = function (a,b,c,d,e){
 selectTJT(a,b,c,d,e);
	
};
//统计图 star

var selectTJT=function(ssyj_zzjgdm,ssyj_zzjglx,time1,time2,type){

	$.ajax({
		url:contextPath+"/SsyjtjtSevlet?type="+ type + "&time1=" + time1 + "&time2=" + time2+"&zzjgdm="+ssyj_zzjgdm+"&zzjglx="+ssyj_zzjglx,
		type:"post",
		dataType:"xml",
		success:function(xmls){
			
			var Tzzjg="";	
			var Tfz="";
			var Tsum=""
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
			if(type=='1'){
			jsonData += '{"chart":{"caption":"'+time1+'年'+time2+'月统计",';
			}else if(type=='2'){
			jsonData += '{"chart":{"caption":"'+time1+'年第'+time2+'季度统计",';
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

   window.parent.zdParms_ssyj(jsonData);
	 }


//四色预警 统计图结束


//今日警情地图操作
document.writeln("<script type='text/javascript' src='"+basePath+"js/jzym/jrjq_mapOpe.js'></script>");
