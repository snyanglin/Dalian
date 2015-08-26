if(typeof XjMap == "undefined" || !XjMap){
	var XjMap = {};
};

XjMap = function(){
	this.pk = Math.random();
};

XjMap.markerArr = new Array;//查询叠加的地图元素集合
XjMap.PcsTjJson = ""; //记录统计json串后退时用到
XjMap.map = null;//声明地图对象
XjMap.zzjgdm = "";//当前组织机构代码
XjMap.zzjgmc = "";//当前组织机构名称
/**
 *加载地图 
 */
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
	
	/*隐藏地图操作控件，包括一般地图控件、简化地图控件和标准地图控件。*/
	XjMap.map._MapApp.hideMapControl();
	XjMap.showZzjgMap();
	
};
/**
 * 显示下去边界
 */
XjMap.showZzjgMap = function(){
	XjMap.jrjq_clear();
	if(bjzbz!="" && bjzbz!='null'){
		/*显示当前用户边界*/
		var org = userOrgCode;
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
}

/**
 * 显示用户组织机构边界
 */
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

/**
 * 根据查询类型，组织所需条件，进行查询
 * @param type
 */
XjMap.query = function(type){
		XjMap.showZzjgMap();
		var parm = "?gxdwdm=" + userOrgCode;
		XjMap.removeMark();
		if("xqgk" == type){
			parm = userOrgCode + "-xqgk";
			/*记录当前展示的组织机构代码*/
			XjMap.zzjgdm = userOrgCode;
			/*记录当前展示的组织机构名称*/
			XjMap.zzjgmc = userOrgName;
			XjMap.queryXjZrqs(parm);
		} else if("jrjq" == type){
			//add by wuw start
			var level=(userOrgCode+'').indexOf('000000')!=-1?1:2;
			parm = level + '|'+userOrgCode;
			//add by wuw end
			
			XjMap.jrjq_showAlermInMap(parm);
		} else if("gzdt" == type){
			XjMap.zdParm(parm, type);
		} else if("jwts" == type){//TODO **Q:警务态势如何选择组织机构
			XjMap.queryJwts()
		}else if("ssyj" == type){
			$.ajax({
				url:basePath+'forward/jzym|ssyj|jzSsyjQueryList',
				type:'post',
				dataType:'html',
				success:function(html){
					$("#infoShowDiv").html(html);
				}
			});
		}else if("ssyj_tj" == type){
			fla = type;
			$("#up").css("height","690px");
    	    $("#down").css("height","1");
    	    //bigger
    	    //点击时候，将gps查询停止
    		//document.getElementById("jwts_").src = "";
    	    //var obj = document.getElementById("biz_center").contentWindow;
    	    //责任区则不下钻
    	    //alert(userOrgCode);
			 var zero8 = userOrgCode.substr(userOrgCode.length-8, userOrgCode.length);
			 var zero6 = userOrgCode.substr(userOrgCode.length-6, userOrgCode.length);
			 var zero4 = userOrgCode.substr(userOrgCode.length-4, userOrgCode.length);
			 if(zero8 != "00000000" && zero6 != "000000" && zero4 != "0000"){
				 return;
			 }
			//obj.XjMap.
			queryXjZrq(userOrgCode);
//			document.getElementById("show").style.display = '';
//			document.getElementById("chart").style.display = 'none';
//			document.getElementById("cha").style.display = "";
//			document.getElementById("img").src = "<%=contextPath%>/images/navigator/lunbo-2.png";
		}
};
/**
 * 查询下级责任区
 * @param pnodes 本级责任区编码
 */
XjMap.queryXjZrqs = function(pnodes){ 
	parentOrgcode = pnodes.substring(0, 12);
	parentType = pnodes.substring(13, pnodes.length);
	if(pnodes!=''){
		var params = {id: '', orgcode: parentOrgcode};
		var fajax =new FrameTools.Ajax(contextPath+"/homePage/downMap", XjMap.intoMaps);
		fajax.send(params);
	}
};
/**
 * 根据组织机构代码查询边界坐标
 * @param pnodes 组织机构结果集
 */
XjMap.intoMaps = function(pnodes){
	//alert(JSON.stringify(pnodes));
	if(pnodes!=''){
		var temp = "";
		for(var i=0; i<pnodes.length; i++){
			temp += pnodes[i].orgcode + ",";
		}
		var params = {zzjgdm: temp.substr(0, temp.length-1)};
		var fajax =new FrameTools.Ajax(contextPath+"/homePage/queryXjZzjgxj",XjMap.queryXjZzjg_backs);
		fajax.send(params);
	}
};
/**
 * 在地图上显示组织机构面
 * @param json
 */
XjMap.queryXjZzjg_backs = function(json){
	    XjMap.removeMark();
	 	//大连公安局不铺面
	    var org = userOrgCode;
		var zero8 = org.substr(org.length-8, org.length);
		if (zero8 != "00000000") {	
			if(json!=null&&json.length>0){
				//区域范围显示则四色预警清除
				XjMap.bjJson = json;
				XjMap.countZrq = json.length;
				var colors = new Array("#F1E740","#FFB543","#FF7A7B","#008080","#AA4400","#0000FF","#0066CC","#00CCCC","#6600CC","#FF99FF","#CCFFFF","#85D021","#4DC2ED","#EE431B","#E96A3B","#EE9539","#FDBE63","#FFFF66","#CC3333","#9966FF","#99CCFF","#FF00FF","#FF66CC","#996666","#00CC00","#330000","#336600","#666600","#990000","#996600","#99CC00","#CC0000","#CC6600","#CCCC00");
				//辖区面
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
			}
		}
		//加载派出所概况
		if(XjMap.PcsTjJson!=""){
			if(parentType == 'xqgk'){
				XjMap.showXqgkInfo(userOrgCode);
			} else {
				XjMap.showJrjqInfo(XjMap.PcsTjJson);
			}
		}else{
			if(parentType == 'xqgk'){
				XjMap.showXqgkInfo(parentOrgcode);
			} else {
				
				XjMap.showJrjqInfo(userOrgCode);
			}
		}
};
/**
 * 显示下去概况信息
 * @param json
 */
XjMap.showXqgkInfo= function(json){
	var params = {zzjgdm:json};
	var fajax =new FrameTools.Ajax(contextPath+"/jz/queryPcsTj",XjMap.initFloatWin_back);
	fajax.send(params);
};

XjMap.PcsTjJson = ""; //记录派出所统计json串后退时用到
XjMap.initFloatWin_back = function(json){
	var htmlStr = '';
	var czrkNum = 0,jzrkNum = 0,ldrkNum = 0,jwrkNum = 0,wlhrkNum = 0,zdrkNum = 0,jkdxNum = 0,jsbrNum = 0,fzcfNum = 0,qtgzdxNum = 0;
	var bzdzyhsNum = 0,bzdzwhsNum = 0,twNum = 0;
	var dwldNum = 0,dwwbNum=0,dwzsNum=0;
	var fwzsNum = 0,fwczfwNum=0,fwkzfNum=0,fwsyNum=0;
	var aqbnNum=0,aqbyNum=0,aqbzNum=0;
	var jqbnNum=0,jqbyNum=0,jqwpNum=0;
	var zdrkNum=0,zdflgNum=0;zdxdryNum=0;zdsfryNum=0;zdqtNum=0;
	
	 var bzdzNum = 0;
	 var tzhyNum = 0,ylcsNum=0;
	if(json!=null&&json.length>0){
		 if(XjMap.PcsTjJson == ""){
			 XjMap.PcsTjJson = json;
		 }
		 for(var i=0;i<json.length;i++){
			 if(json[i].lxmc=="常住人口"){
				 czrkNum = json[i].sl;
			 }else if(json[i].lxmc=="实有人口"){
				 syrkNum = json[i].sl;
			 }else if(json[i].lxmc=="寄住人口"){
				 jzrkNum = json[i].sl;
			 }else if(json[i].lxmc=="暂住人口"){
				 ldrkNum = json[i].sl;
			 }else if(json[i].lxmc=="流动人口"){
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
			 }else if(json[i].lxmc=="实有单位"){
				 dwzsNum = json[i].sl;
			 }else if(json[i].lxmc=="旅店业"){
				 dwldNum = json[i].sl;
			 }else if(json[i].lxmc=="特种行业"){
				 tzhyNum = json[i].sl;
			 }else if(json[i].lxmc=="娱乐场所"){
				 ylcsNum = json[i].sl;
			 }else if(json[i].lxmc=="出租房屋"){
				 fwczfwNum = json[i].sl;
			 }else if(json[i].lxmc=="标准地址"){
				 bzdzNum = json[i].sl;
			 }else if(json[i].lxmc=="本周发生"){
				 aqbzNum = json[i].sl;
			 }else if(json[i].lxmc=="重点人口总计"){
				 zdrkNum = json[i].sl;
			 }else if(json[i].lxmc=="法轮功"){
				 zdflgNum = json[i].sl;
			 }else if(json[i].lxmc=="吸毒人员"){
				 zdxdryNum = json[i].sl;
			 }else if(json[i].lxmc=="上访人员"){
				 zdsfryNum = json[i].sl;
			 }
		 }
	}
	var gzdxNum = parseFloat(zdrkNum)+parseFloat(jkdxNum)+parseFloat(jsbrNum)+parseFloat(fzcfNum)+parseFloat(qtgzdxNum);
	var fwkzfNum = parseFloat(fwzsNum)-parseFloat(fwsyNum);
	zdqtNum = parseFloat(zdrkNum)-parseFloat(zdflgNum)-parseFloat(jkdxNum)-parseFloat(zdxdryNum)-parseFloat(zdsfryNum);
	//加载树状数字
	
   htmlStr= "<div class='infoOrgTitle'>"
   
   if(XjMap.zzjgmc != userOrgName)
	    htmlStr+="<span class='infoOrgTitle_on' onclick='XjMap.query(\"xqgk\")'>"+userOrgName+"</span>--"+XjMap.zzjgmc;
   else
	    htmlStr+="<span >"+userOrgName+"</span>";
   htmlStr+="</div><ul class='infoUl'>" +
	   "<li><h2>实有人口</h2><h3>"+syrkNum+"人</h3>" +
	   "<li><h2>常住人口</h2><h3>"+czrkNum+"人</h3>" +
	   "<li><h2>暂住人口</h2><h3>"+ldrkNum+"人</h3>" +
	   "<li><h2>寄住人员</h2><h3>"+jzrkNum+"人</h3>" +
	   "<li><h2>实有单位</h2><h3>"+dwzsNum+"个</h3>" +
	   "<li><h2>旅店业</h2><h3>"+dwldNum+"个</h3>" +
	   "<li><h2>特种行业</h2><h3>"+tzhyNum+"个</h3>" +
	   "<li><h2>娱乐场所</h2><h3>"+ylcsNum+"个</h3>" +
	   "<li><h2>标准地址</h2><h3>"+bzdzNum+"条</h3>" +
	   "<li><h2>出租房屋</h2><h3>"+fwczfwNum+"间</h3>" +
	   "<li><h2>重点人员</h2><h3>"+zdrkNum+"个</h3>" +
	   "</ul>";
   $("#infoShowDiv").html(htmlStr);
}

/**
 * 清空查询所叠加的地图元素
 */
XjMap.removeMark = function(){
	XjMap.jrjq_clear();
	if(XjMap.markerArr != null){
		var markerLen = XjMap.markerArr.length;
		for(var j=0;j<markerLen;j++){
			XjMap.map._MapApp.removeOverlay(XjMap.markerArr[j]);
		}
	}
}
/**
 * 只清除marker
 */
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
/**
 * 显示辖区面积
 * @param dm
 * @param mc
 * @param zbz
 * @param col
 */
XjMap.showAreas = function(dm,mc,zbz,col){
	var ObjMap = new Polygon(zbz, "red", 3, 0.4,col);
	var pMbr = ObjMap.getMBR();
	var cPoint = pMbr.centerPoint();
	var _pTitle = new Title(mc,12,7,"宋体","#000000","#FFFFFF","#FFFFFF","2");
	_pTitle.setPoint(cPoint);
	XjMap.map._MapApp.addOverlay(ObjMap);
	XjMap.markerArr.push(ObjMap);
	XjMap.markerArr.push(_pTitle);
	XjMap.map._MapApp.addOverlay(_pTitle);
	//点击下钻到责任区
	_pTitle.addListener("click", function (){
		//全局变量
		dms = dm;
		/*根据图元素将地图放到最适合的级别和位置*/
		XjMap.map._MapApp.centerAtMBR(pMbr);
		/*记录当前展示的组织机构代码*/
		XjMap.zzjgdm = dm;
		/*记录当前展示的组织机构名称*/
		XjMap.zzjgmc = mc;
		intoMC = mc;
		if(parentType == 'xqgk'){
			XjMap.showXqgkInfo(XjMap.zzjgdm);
		} else {
			XjMap.showJrjqInfo(userOrgCode);
		}
	});	
};


/**
 * 根据分类进行
 * @param parm
 * @param flag
 */
XjMap.zdParm = function(parm, flag){
	if("jq" == flag){
		$("#up").css("height","440px");
	    $("#down").css("height","250px");
	    $("#tabs").tabs("select", "警情查询");
	    //smaller
	    //点击时候，将gps查询停止
		document.getElementById("jwts_").src = "";
		//document.getElementById('biz_center').contentWindow.XjMap.removeMark();
		document.getElementById("jqs").src = "<%=contextPath%>/forward/jzym|jqcx|jzJqQueryListDown" + parm;
		document.getElementById("up").innerHTML = 
			'<iframe id="biz_center" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/jzym|jzMap"></iframe>';
		document.getElementById("show").style.display = '';
		document.getElementById("chart").style.display = 'none';
	} else if("jqtj" == flag){
		//点击时候，将gps查询停止
		document.getElementById("jwts_").src = "";
		document.getElementById("chart").innerHTML = '<iframe id="charts" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/jzym|jqtj|jzChart"></iframe>';
		document.getElementById("charts").src = "<%=contextPath%>/forward/jzym|jqtj|jzChart" + parm;
		document.getElementById("show").style.display = 'none';
		document.getElementById("chart").style.display = '';
	} else if("jqdb" == flag){
		//点击时候，将gps查询停止
		document.getElementById("jwts_").src = "";
		document.getElementById("chart").innerHTML = '<iframe id="charts" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/jzym|jqdb|jzdbChart"></iframe>';
		document.getElementById("charts").src = "<%=contextPath%>/forward/jzym|jqdb|jzdbChart" + parm;
		document.getElementById("show").style.display = 'none';
		document.getElementById("chart").style.display = '';
	} else if("ssyj" == flag){
		par = parm;
		fla = flag;
		$("#up").css("height","690px");
	    $("#down").css("height","1");
	    //bigger
	    //点击时候，将gps查询停止
		document.getElementById("jwts_").src = "";
	    var obj = document.getElementById("biz_center").contentWindow;
	    //责任区则不下钻
		 var zero8 = pnodes.substr(pnodes.length-8, pnodes.length);
		 var zero6 = pnodes.substr(pnodes.length-6, pnodes.length);
		 var zero4 = pnodes.substr(pnodes.length-4, pnodes.length);
		 if(zero8 != "00000000" && zero6 != "000000" && zero4 != "0000"){
			 return;
		 }
		obj.XjMap.queryXjZrq(parm);
		document.getElementById("show").style.display = '';
		document.getElementById("chart").style.display = 'none';
		document.getElementById("cha").style.display = "";
		document.getElementById("img").src = "<%=contextPath%>/images/navigator/lunbo-2.png";
	} else if("ssyj_tj" == flag){
		//点击时候，将gps查询停止
		document.getElementById("jwts_").src = "";
		par = parm;
		fla = flag;
		document.getElementById("chart").innerHTML 
			= '<iframe id="charts" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="<%=contextPath%>/forward/jzym|ssyj|ssyjChart"></iframe>';
		document.getElementById("charts").src = "<%=contextPath%>/forward/jzym|ssyj|ssyjChart" + parm;
		document.getElementById("show").style.display = 'none';
		document.getElementById("chart").style.display = '';
		document.getElementById("cha").style.display = "";
		document.getElementById("img").src = "<%=contextPath%>/images/navigator/bzdzhs.png";
	} else if("jwts" == flag){
		$("#up").css("height","440px");
	    $("#down").css("height","250px");
	    $("#tabs").tabs("select", "在线警车");
	    //smaller
		document.getElementById('biz_center').contentWindow.XjMap.removeMark();
		document.getElementById("jwts_").src = "<%=contextPath%>/forward/jzym|jwts|jwtsListDown" + parm;
		document.getElementById("show").style.display = '';
		document.getElementById("chart").style.display = 'none';
	} else if("xqgk" == flag){
		
		XjMap.queryXjZrqs(parm);
	} else if("jrjq" == flag){
		$("#up").css("height","690px");
	    $("#down").css("height","1");
		document.getElementById('biz_center').contentWindow.XjMap.removeMark();
		document.getElementById('biz_center').contentWindow.jrjq_showAlermInMap(parm);
	} else if("lktj" == flag){
		//点击时候，将gps查询停止
		document.getElementById("jwts_").src = "";
		document.getElementById("chart").style.display = '';
		document.getElementById("show").style.display = 'none';
		document.getElementById("chart").innerHTML = 
			'<iframe id="chartLktj" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>';
		document.getElementById("chartLktj").src = "<%=contextPath%>/forward/jzym|xqtjChart|jzLktjChart" + parm;
	} else if("sstj" == flag){
		//点击时候，将gps查询停止
		document.getElementById("jwts_").src = "";
		document.getElementById("chart").style.display = '';
		document.getElementById("show").style.display = 'none';
		document.getElementById("chart").innerHTML = 
			'<iframe id="chartLktj" style="width: 100%;height: 20%;" noresize scrolling="no" frameborder="no" src=""></iframe>'
			+
			'<iframe id="chartLktj1" style="width: 100%;height: 60%;" noresize scrolling="no" frameborder="no" src=""></iframe>'
			+
			'<iframe id="chartLktj2" style="width: 100%;height: 20%;" noresize scrolling="no" frameborder="no" src=""></iframe>';
		document.getElementById("chartLktj1").src = "<%=contextPath%>/forward/jzym|xqtjChart|jzSstjChart" + parm;
	} else if("gzdx" == flag){
		//点击时候，将gps查询停止
		document.getElementById("jwts_").src = "";
		document.getElementById("chart").style.display = '';
		document.getElementById("show").style.display = 'none';
		document.getElementById("chart").innerHTML = 
			'<iframe id="chartLktj" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>';
		document.getElementById("chartLktj").src = "<%=contextPath%>/forward/jzym|xqtjChart|jzGzdxChart" + parm;
	} else if("nltj" == flag){
		//点击时候，将gps查询停止
		document.getElementById("jwts_").src = "";
		document.getElementById("chart").style.display = '';
		document.getElementById("show").style.display = 'none';
		document.getElementById("chart").innerHTML = 
			'<iframe id="chartLktj" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src=""></iframe>';
		document.getElementById("chartLktj").src = "<%=contextPath%>/forward/jzym|xqtjChart|jzNltjChart" + parm;
	} 
}

//begin
//画图
XjMap.drawChart = function(chartFlag){
	XjMap.showZzjgMap();
	var width = "400px";
	var height = "500px";
	if(chartFlag == "querySyrkChart" || chartFlag == "querySydwChart" || chartFlag == "querySyfwChart"){
		var height = "475px";
	}
	var htmlStr = "<div id='chart'></div>";
	$("#infoShowDiv").html(htmlStr);
    swfobject.embedSWF(
		contextPath+"/js/tools/flashChart/open-flash-chart.swf",
		"chart",
		width,
		height,
		"9.0.0",
		"expressInstall.swf",
		{"data-file":contextPath+"/homePage/" + chartFlag + "?zzjgdm=" + XjMap.zzjgdm + "~"},
		{wmode:"transparent"}
    );
}

XjMap.drawChart = function(chartFlag){
	XjMap.showZzjgMap();
	var width = "400px";
	var height = "500px";
	if(chartFlag == "querySyrkChart" || chartFlag == "querySydwChart" || chartFlag == "querySyfwChart"){
		var height = "475px";
	}
	var htmlStr = "<div id='chart'></div>";
	$("#infoShowDiv").html(htmlStr);
    swfobject.embedSWF(
		contextPath+"/js/tools/flashChart/open-flash-chart.swf",
		"chart",
		width,
		height,
		"9.0.0",
		"expressInstall.swf",
		{"data-file":contextPath+"/homePage/" + chartFlag + "?zzjgdm=" + XjMap.zzjgdm + "~"},
		{wmode:"transparent"}
    );
}

//三实统计图
XjMap.drawSstjChart = function(chartFlag){
	XjMap.showZzjgMap();
    swfobject.embedSWF(
		contextPath+"/js/tools/flashChart/open-flash-chart.swf",
		"chart",
		"400px",
		"465px",
		"9.0.0",
		"expressInstall.swf",
		{"data-file":contextPath+"/homePage/" + chartFlag + "?zzjgdm=" + XjMap.zzjgdm + "~"},
		{wmode:"transparent"}
    );
}

//三实统计
XjMap.sstjChart = function(){
	var htmlStr = 
		"<div><input type='button' style='color: white; font:normal 12px Microsoft YaHei; background:#42bdf5' onclick='XjMap.drawSstjChart(\"querySyrkChart\")' value='实有人口'>&nbsp;"
		+ "<input type='button' style='color: white; font:normal 12px Microsoft YaHei; background:#42bdf5' onclick='XjMap.drawSstjChart(\"querySydwChart\")' value='实有单位'>&nbsp;"
		+ "<input type='button' style='color: white; font:normal 12px Microsoft YaHei; background:#42bdf5' onclick='XjMap.drawSstjChart(\"querySyfwChart\")' value='实有房屋'></div>"
		+ "<br><div id='chart'>test</div>";
	$("#infoShowDiv").html(htmlStr);
	XjMap.drawSstjChart("querySyrkChart");
}

//警情对比图
XjMap.jqdbChart = function(){
	XjMap.showZzjgMap();
	var htmlStr = 
		'<iframe id="jqdb" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="' + contextPath + '/forward/jzym|jqdb|jzJqdbQuery"></iframe>'
		+ "<br><div id='chart'></div>";
	$("#infoShowDiv").html(htmlStr);
}

//父页面方法,用于展现对比图
function zdParm(parm, flag){
	if("jqdb" == flag){
		document.getElementById("chart").innerHTML = '<iframe id="charts" style="width: 400px;height: 350px;" noresize scrolling="no" frameborder="no" src=""></iframe>';
		document.getElementById("charts").src = contextPath + "/forward/jzym|jqdb|jzdbChart" + parm;
	} else if("jqtj" == flag){
		document.getElementById("chart").innerHTML = '<iframe id="charts" style="width: 400px;height: 350px;" noresize scrolling="no" frameborder="no" src=""></iframe>';
		document.getElementById("charts").src = contextPath + "/forward/jzym|jqtj|jzChart" + parm;
	} else if("jq" == flag){
		document.getElementById("chart").innerHTML = '<iframe id="charts" style="width: 400px;height: 350px;" noresize scrolling="no" frameborder="no" src=""></iframe>';
		document.getElementById("charts").src = contextPath + "/forward/jzym|jqcx|jzJqQueryListDown" + parm;
	}
}

//警情统计图
XjMap.jqtjChart = function(){
	XjMap.showZzjgMap();
	var htmlStr = 
		'<iframe id="jqtj" style="width: 100%;height: 100%;" noresize scrolling="no" frameborder="no" src="' + contextPath + '/forward/jzym|jqtj|jzJqQuery"></iframe>'
		+ "<br><div id='chart'></div>";
	$("#infoShowDiv").html(htmlStr);
}

//撒点
XjMap.centerByPoint = function(marker,zoomLevel,date, flag){
	if(undefined != marker){
		var point = marker.getPoint() ;
		XjMap.moveMapToBjzbz();
		XjMap.map._MapApp.addOverlay(marker);
		marker.addListener("click", function(){
			var msgHtml = "";
			if("jq" == flag){
				msgHtml = queryMsgJq(marker,date);
			} 
		});
		XjMap.map._MapApp.centerAndZoom(point, zoomLevel);
	}
};

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

//弹出框
function queryMsgJq(marker,date){
	var msgHtml=" <table border='0' cellpadding='0' width='200' align='center'>";
	msgHtml+="<tr><td width='40%'>警情编号:</td><td>" + date.jjbh + "</td></tr>";
	msgHtml += "<tr><td width='40%'>警情地点:</td><td> "+ date.jqdzms +"</td></tr>";
	//msgHtml+= "<tr align='center'><td></td><td><a href='javascript:void(0)' onclick='openCh("+ "1" +")'>更多</a></td></tr>";
	msgHtml+="</table>";
	marker.openInfoWindowHtml(msgHtml);
}

//map上添加Marker
function addMarkers(title,zbx,zby,imgName,msgHtml,mouseFun,imgWidth,imgHeight,ifClearMap,dz_jzdzdm,type){
	XjMap.map._MapApp.closeInfoWindow();
	if(ifClearMap){
		XjMap.clearMap();
	}
	if(title=="" || title==null){
		title="";
	}
	var marker = XjMap.map.initMarker(title,zbx,zby,imgName,null,null,imgWidth,imgHeight);
	marker.addListener("click", function(){
		if(type == 'jqs'){
			var msgHtml = queryMsgJq(marker,dz_jzdzdm);
		}
	});
	XjMap.map._MapApp.addOverlay(marker);
	return marker;
};

//全文检索
XjMap.search = function(){
	menu_open('全文检索', 'http://10.80.8.178:7001/PGIS_Portal/');
}

//end
