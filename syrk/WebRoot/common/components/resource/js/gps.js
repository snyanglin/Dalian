/**
 * GPS警力
 * znjg - v1.0.0 (2014-10-17 11:06)
 * Copyright(c) 2014 founder
 */

function Gps() {
	

	var comwhere = "XHZT=1 AND ISGPS=1";
	
	var nameField = "SBID";
	
	var subFields ="SBID:SBID,SBCPH:SBCPH,SBGHH:SBGHH,JYBH:JYBH,JYXM:JYXM,JTFSID:JTFSID,YWLXID:YWLXID,YWLXMC:YWLXMC,JYZZJGMC:JYZZJGMC";
	
	var realtimeInfoTableName = SysConfig.GPS_REALTIMEINFO_TABLENAME;//需要建立同义词到空间数据库中
	
	var currMapGpsMarkerJson = {};//当前地图Gps Marker json
	
	var gpsLsgjObject = null;//历史轨迹对象
	
	var gpsXlqyObject = null;//巡逻区域对象
	
	var gpsZjkGpsId = null;//主监控gpsid
	
	var pOverlay=null;//空间查询范围Overlay
	
	var currgpsids = "";//当前查询gpsids
	
	//var gpsBubbleGpsId = null;//当前气泡gpsid
	
	var currXzqh = null ;//当前辖区
	
	var	zbGpsobjArray=[];
		/**
		 * 实时警力页面查询后加入地图的gpsid
		 */
	var	ssjlGpsidArray=[];
		/**
		 * 实时警力查询的gps对象
		 */
	var	ssjlGpsobjArray=[];
		/**
		 * 实时查询请求的gpsid
		 */
	var	ssjlRequestGpsid=[];
	
	var jk_objArray=[];

	/**
	 * 主监控默认地图层级
	 */
	var zjkDefaultZoomLevel = 14;
	
	/**
	 *当前点击的GPS警力数据 
	 */
	var currClickGpsData = {};
	
	/**
	 * 页面初始化
	 */
	this.init = function(zzjgdm,isLoad,roadid) {
		//初始周边字典（下拉）
//		Dictionary.initDictionaryList({url: "/syrk/dictionary/getDictionaryListJSON.f", data: {"zdbh": "D_ZBJL"}, dictShowId: "around_distance", initVal: "1",dictContainerReferenceObjectId: "ssjl_zb"}, function() {
//		});
		//初始历史轨迹时间字典（下拉）
//		Dictionary.initDictionaryList({url: "/syrk/dictionary/getDictionaryListJSON.f", data: {"zdbh": "D_GJSJ"}, dictShowId: "timeInterval", dictContainerReferenceObjectId: "ssjl_sjgj", initVal: "1"}, function() {
//		});
		Dictionary.createDictionaryList("around_distance", "ssjl_zb", "", 
				{"list":[{"xtZxbz":"0","pId":1000150,"zdbh":"D_ZBJL","zdmc":"周边距离","dm":"1","ct":"500","py":"500","wb":"500"},{"xtZxbz":"0","pId":1000151,"zdbh":"D_ZBJL","zdmc":"周边距离","dm":"2","ct":"1000","py":"1000","wb":"1000"},{"xtZxbz":"0","pId":1000152,"zdbh":"D_ZBJL","zdmc":"周边距离","dm":"3","ct":"3000","py":"3000","wb":"3000"},{"xtZxbz":"0","pId":1000153,"zdbh":"D_ZBJL","zdmc":"周边距离","dm":"4","ct":"5000","py":"5000","wb":"5000"}]}, null);
		
		Dictionary.createDictionaryList("timeInterval", "ssjl_sjgj", "1", 
				{"list":[{"xtZxbz":"0","pId":1000154,"zdbh":"D_GJSJ","zdmc":"轨迹时间","dm":"1","ct":"5","py":"5","wb":"5"},{"xtZxbz":"0","pId":1000155,"zdbh":"D_GJSJ","zdmc":"轨迹时间","dm":"2","ct":"10","py":"10","wb":"10"},{"xtZxbz":"0","pId":1000157,"zdbh":"D_GJSJ","zdmc":"轨迹时间","dm":"4","ct":"30","py":"30","wb":"30"},{"xtZxbz":"0","pId":1000157,"zdbh":"D_GJSJ","zdmc":"轨迹时间","dm":"5","ct":"60","py":"60","wb":"60"}]}, null);
		//初始警力分组字典（树）
		/*Dictionary.initDictTree({url: "dictionary/getGpsDictTreeJSON.f", zdbh: "T_GPS_ZZJG", zdmc: "警力分组", zzjgdm: zzjgdm, dictDataDivId: "ssjl_gpszzjg_data_Div"}, function() {
			Dictionary.beforeCreateDictTree({createCount: 1, zdbh: "T_GPS_ZZJG", treeData: data_T_GPS_ZZJG, dictDataDivId: "ssjl_gpszzjg_data_Div"});
			Dictionary.createDictTree({dictObject: T_GPS_ZZJG, treeData: data_T_GPS_ZZJG_1, isLeaf: false, dictHiddenId: "ssjl_gpszzjg_dm", dictShowId: "ssjl_gpszzjg_mc",initVal: zzjgdm,"dictContainerReferenceObjectId": "ssjl_zzjg"});
		});*/
		//初始组织机构字典（树）
		Dictionary.initDictTree({url: "/syrk/dictionary/getOrganizationDictTreeJSON", zdbh: "T_GPS_ZZJG", zdmc: "组织机构", zzjgdm: zzjgdm, dictDataDivId: "ssjl_gpszzjg_data_Div"}, function() {
			Dictionary.beforeCreateDictTree({createCount: 1, zdbh: "T_GPS_ZZJG", treeData: data_T_GPS_ZZJG, dictDataDivId: "ssjl_gpszzjg_data_Div"});
			Dictionary.createDictTree({dictObject: T_GPS_ZZJG, treeData: data_T_GPS_ZZJG_1, isLeaf: false, dictHiddenId: "ssjl_gpszzjg_dm", dictShowId: "ssjl_gpszzjg_mc",initVal: zzjgdm, "dictContainerReferenceObjectId": "ssjl_zzjg"});
		});
		
		//实时统计
		startCount(zzjgdm);
		
		//从交通态势管理路段周边警力查询
		//if("yes"== isLoad ){
	    // gps.getroadzbjl(roadid);
		//}
	};
	
	/**
	 * 空间查询
	 * @param type
	 */
	this.spatialquery = function(type){
		this.clear();
		_MapApp.changeDragMode(type, strCoodsX, strCoodsY, function() {
			removeLastOverlay();
			spatialqueryCallback(type);
		});
	};
	
	/**
	 * 周边查询
	 * @param type
	 */
	this.aroundQuery = function (type){
		this.clear();
		_MapApp.changeDragMode(type, strCoodsX, strCoodsY, function() {
			removeLastOverlay();
			aroundqueryCallback(type);
		});
	};
	
	/**
	 * 周边查询
	 * @param strCoods 坐标串
	 * @param distance 周边距离
	 * @param type point or polyline or polygon
	 * @param isShowOverlay true or false
	 */
	this.aroundQuery2 = function(strCoods, distance, type, isShowOverlay) {
		this.clear();
		aroundQuery(strCoods, distance, type, isShowOverlay);
	};
	
	/**
	 * 关键字查询
	 */
	this.keyWordQuery = function() {
		this.clear();
		var value=$("#keywordsearch").val();
		var kwwhere  = "SBID LIKE '%"+value+"%' OR JYBH LIKE '%"+value+"%' OR JYXM LIKE '%"+value+"%' OR SBGHH LIKE '%"+value+"%' OR SBCPH LIKE '%"+value+"%'";
		attributequery(kwwhere);
	};
	
	/**
	 * 辖区内查询
	 * @param type
	 */
	this.xqnquery = function(dm) {
		if(typeof(dm) == 'undefined') {
			dm = dwbh;
		}
		this.clear();
		xqnquery(dm);
	};
	
	/**
	 * 辖区外查询
	 * @param type
	 */
	this.xqwquery = function(dm) {
		if(typeof(dm) == 'undefined') {
			dm = dwbh;
		}
		this.clear();
		xqwquery(dm);
	};
	
	/**
	 * 视野内查询
	 */
	this.synQuery = function() {
		
	};
	
	/**
	 * 加载气泡内容
	 */
	this.loadBubbleContent = function(data){
		loadBubbleContent(data);
	};
	
	/**
	 * 气泡派警事件
	 */
	this.bubblePjFunc = function(mark) {
		bubblePjFunc(mark);
	};
	
	/**
	 * gps主监控
	 */
	this.gpsZjk = function(gpsid){
		gpsZjk(gpsid);
	};
	
	/**
	 * 历史轨迹
	 */
	this.addGpsLsgj = function(gpsid) {
		addGpsLsgj(gpsid);
	};
	
	/**
	 * 清除历史轨迹
	 */
	this.clearGpsLsgj = function() {
		clearGpsLsgj();
	};
	
	/**
	 * 巡逻区域上图
	 */
	this.addGpsXlqy = function(layerType, points, color) {
		clearGpsXlqy();//上图前先清除
		addGpsXlqy(layerType, points, color);
	};
	
	/**
	 * 清除巡逻辖区
	 */
	this.clearGpsXlqy = function() {
		clearGpsXlqy();
	};
	
	/**
	 * 清除
	 */
	this.clear = function() {
		try{
			stopGps();
			stopGpsZjk();
			clearGpsXlqy();
			clearGpsLsgj();
			clearGpsMarker();
			MapBubble.closeBubble();
			_MapApp.removeOverlay(pOverlay);
		}catch(e){}
	};
	
	this.startCount = function(zzjgdm) {
		//开启实时统计
		startCount(zzjgdm);
	};
	
	this.gpsCount = function(zzjgdm) {
		gpsCount(zzjgdm);
	};
	this.backto=function (){
		$("#resultdiv").css("display","none");
		$("#reason").css("display","block");
	};
	this.doJlReasult = function (aa) {
//		if($("#jl_tj dd").children().hasClass('a_on')){//点击统计数字进入
//			Ssjl.oldids=Ssjl.selectedIds();
//		}
//		var oldids=Ssjl.oldids;
		gps.clear();
		SysTool.ajax({
			url : '/syrk/gps/getGpsOnlineList',
			data : {
				'zzjgdm' : $('#ssjl_gpszzjg_dm').val(),
				gpsTableName : realtimeInfoTableName ,
				'gpstype':$(aa).parent("div").find("span").text()
			}
		}, function(resultSet) {
			 
		
		
		$("#reason").css("display", "none");
		$("#resultdiv").css("display", "block");
		$("#results").html("");
		$("#result_count").html("");
		if (resultSet.length == 0) {
			$("#result_count").append("<span>共有<span class='spancolor' id='ssjl_result_count'>0</span>条</span>");
			return false;
		}else{
			$("#result_count").append("<span>共有<span class='spancolor' id='ssjl_result_count'>"+resultSet.length+"</span>条</span>");
		}
		var addGpsList=[];
		
		//警力上图
		var returnMarkerArray=[];
		returnMarkerArray = createMarker(resultSet, function(){
			
		});
		jk_objArray=[];
		for ( var j = 0; j < resultSet.length; j++) {
				 
//			addGpsList.push(resultSet[j]);
//			ssjlRequestGpsid.push(resultSet[j].SBID);
//			
//			//警力列表
			var jk_obj={};
			jk_obj["SBID"]=resultSet[j].SBID;//监控对象gpsid
			//jk_obj["ztid"]=resultSet[j].STATUSID;
			$("#results").append(
					"<a  href='javascript:gps.clickFunc(\""+resultSet[j].SBID+"\")' id='"+resultSet[j].SBID+"'>" + "<span class='span1'>" + (resultSet[j].JYXM||"空") + "</span>"
							+ "<span class='span2'>" + (resultSet[j].SBGHH||"空") + "</span>"
							+ "<span class='span3'>"+(resultSet[j].JYZZJGMC||"空") + "</span></a>");
//			if(addGpsList.length==0){
				jk_obj["marker"] = returnMarkerArray[resultSet[j].SBID];
				jk_objArray.push(jk_obj);
//				ssjlGpsobjArray.push(jk_obj);
//			}else{
//				for(var n=0;n<addGpsList.length;n++){//添加的gpsmarker
//					if(addGpsList[n]["SBID"]==resultSet[j].SBID){
//						jk_obj["marker"]=returnMarkerArray[n];//监控对象marker
//						jk_objArray.push(jk_obj);
//						ssjlGpsobjArray.push(jk_obj);
//						break;
//					}
//				};
//			}
		}
		});
	};
	
	this.clickFunc = function(id){
		if($("#"+id).hasClass("result_on")){
			$("#results a").removeClass("result_on");//再次点击清除样式
			MapBubble.closeBubble();
		}else{
			$("#results a").removeClass("result_on");
			$("#"+id).addClass("result_on");
			for(var i=0;i<jk_objArray.length;i++){
				if(id===jk_objArray[i]["SBID"]){
					_MapApp.centerAtLatLng(jk_objArray[i]["marker"].getPoint());
					jk_objArray[i]["marker"].onclick();
					
				}
			}
		}
		
	};
	
	this.intoMaps = function(pnodes){
		//alert(JSON.stringify(pnodes));
		if(currXzqh)
			_MapApp.removeOverlay(currXzqh);
		if(pnodes!='' &&  pnodes.substr(pnodes.length-8,pnodes.length)!="00000000"){
			
//			var fajax = new FrameTools.Ajax("/syrk/homePage/queryXjZzjgxj",this.queryXjZzjg_backs);
//			fajax.send(params);
			
			SysTool.ajax({
				url : '/syrk/homePage/queryXjZzjgxj',
				data : {
					'zzjgdm' : pnodes 
				}
			}, function(json) {
				gps.queryXjZzjg_backs(json);
			})
		}
	};
	/**
	 * 在地图上显示组织机构面
	 * @param json
	 */
	this.queryXjZzjg_backs = function(json){
		
		if(json!=null&&json.length>0){
			//区域范围显示则四色预警清除
//					XjMap.bjJson = json;
			var countZrq = json.length;
			var colors = new Array("#F1E740","#FFB543","#FF7A7B","#008080","#AA4400","#0000FF","#0066CC","#00CCCC","#6600CC","#FF99FF","#CCFFFF","#85D021","#4DC2ED","#EE431B","#E96A3B","#EE9539","#FDBE63","#FFFF66","#CC3333","#9966FF","#99CCFF","#FF00FF","#FF66CC","#996666","#00CC00","#330000","#336600","#666600","#990000","#996600","#99CC00","#CC0000","#CC6600","#CCCC00");
			//辖区面
				var i = 0;
				json.MMM = setInterval(function(){
					if(i < countZrq){
			        	if(undefined != json[i].bjzbz && null!=json[i].bjzbz && json[i].bjzbz!=""){
			        		var col = colors[i];
			        		gps.showAreas(json[i].zzjgdm, json[i].zzjgmc, json[i].bjzbz, col);
			        	}
			        	
					} else {
						clearInterval(json.MMM);
					}
			        	
			        	i++;
				}, 130);
		}
	};
	
	this.showAreas = function(dm,mc,zbz,col){
		var ObjMap = new Polygon(zbz, "red", 3, 0.2,col);
		var pMbr = ObjMap.getMBR();
		var cPoint = pMbr.centerPoint();
		var _pTitle = new Title(mc,12,7,"宋体","#000000","#FFFFFF","#FFFFFF","2");
		_pTitle.setPoint(cPoint);
		_MapApp.addOverlay(ObjMap);
		currXzqh = ObjMap;
		_MapApp.centerAtMBR(pMbr);
//		XjMap.markerArr.push(ObjMap);
//		XjMap.markerArr.push(_pTitle);
//		_MapApp.addOverlay(_pTitle);
		//点击下钻到责任区
//		_pTitle.addListener("click", function (){
//			//全局变量
//			dms = dm;
//			/*根据图元素将地图放到最适合的级别和位置*/
//			XjMap.map._MapApp.centerAtMBR(pMbr);
//			/*记录当前展示的组织机构代码*/
//			XjMap.zzjgdm = dm;
//			/*记录当前展示的组织机构名称*/
//			XjMap.zzjgmc = mc;
//			intoMC = mc;
//			if(parentType == 'xqgk'){
//				XjMap.showXqgkInfo(XjMap.zzjgdm);
//			} else {
//				XjMap.showJrjqInfo(userOrgCode);
//			}
//		});	
	};
	
	/**
	 * 根据roadid获取路段坐标，并进行周边警力查询（从交通态势管理系统跳转专用）
	 * @param roadid
	 */
/*//	this.getroadzbjl=function(roadid) {
//		var aQuery = new QueryObject();
//		removeLastOverlay();
//		aQuery.featurelimit = 10000;
//		aQuery.queryType = 6;
//		aQuery.dispField = 'objectid,lddm,ldmc';
//		aQuery.addSubFields('objectid,lddm,ldmc');
//		aQuery.tableName = SysConfig.GIS_DB_USERNAME + '.' + SysConfig.JT_ROADSEGITEM_PL;
//		var where = "";
//		var lddm = roadid;
//     	if(lddm != "" && lddm != null) {
//			where += " lddm in ("+lddm+")";
//		} else {
//			where += " lddm = 'noshow'";
//		}
//		aQuery.where = where;
//	   _MapApp.query(aQuery, function(vBIsOK, vRequestObj) {
//			try {
//				var features = new Array();
//				var dwLayers = _MapApp.getQueryResult(vRequestObj); 
//				var areastr = '';
//				for ( var j = 0; j < dwLayers.length; j++) {
//					if (dwLayers[j].tableName.toUpperCase() == aQuery.tableName
//							.toUpperCase()) {
//						features = dwLayers[j].features;
//					}
//				}
//				var ilength = features.length;
//				if (ilength > 0) {
//					for ( var i = 0; i < ilength; i++) {
//						dwftrObj = features[i];
//					    areastr = dwftrObj.linestr;
//					    $("#strCoodsX").val(areastr);
//					    aroundqueryCallback('drawPolyline');
//		     	}
//				}
//					
//		} catch (e) {
//		}
//		});
//	};
*/	
	/**
	 * GPS警力图标配置
	 */
	var gps_img = {
		//徒步
		1:{1:"/syrk/common/components/resource/images/gpsimage/1_1.png",//巡逻
			2:"/syrk/common/components/resource/images/gpsimage/1_2.png",//处警
			3:"/syrk/common/components/resource/images/gpsimage/1_3.png",//特勤
			4:"/syrk/common/components/resource/images/gpsimage/1_4.png"//备勤
		},
		//警车
		2:{1:"/syrk/common/components/resource/images/gpsimage/5_1.png",
			2:"/syrk/common/components/resource/images/gpsimage/5_2.png",
			3:"/syrk/common/components/resource/images/gpsimage/5_3.png",
			4:"/syrk/common/components/resource/images/gpsimage/5_4.png"
		},
		//摩托车
		3:{1:"/syrk/common/components/resource/images/gpsimage/3_1.png",
			2:"/syrk/common/components/resource/images/gpsimage/3_2.png",
			3:"/syrk/common/components/resource/images/gpsimage/3_3.png",
			4:"/syrk/common/components/resource/images/gpsimage/3_4.png"
		},
		//电瓶车
		4:{1:"/syrk/common/components/resource/images/gpsimage/djj_kx.png",
			2:"/syrk/common/components/resource/images/gpsimage/4_2.png",
			3:"/syrk/common/components/resource/images/gpsimage/4_3.png",
			4:"/syrk/common/components/resource/images/gpsimage/4_4.png"
		},
		//自行车
		5:{1:"/syrk/common/components/resource/images/gpsimage/2_1.png",
			2:"/syrk/common/components/resource/images/gpsimage/2_2.png",
			3:"/syrk/common/components/resource/images/gpsimage/2_3.png",
			4:"/syrk/common/components/resource/images/gpsimage/2_4.png"
		}		
	};
	
	/**
	 * 空间查询
	 * @param type
	 */
	function spatialqueryCallback (type){
		SysTool.loading.mask("pgis_map", "50%", "50%");
		var strCoods = $("#strCoodsX").val();
		var extent = SysTool.getMapExtent(_MapApp);
		var width = SysTool.getMapWidth("pgis_map");
		var qType = "";
		switch (type) {
		case "drawRect":
			qType = SysConfig.QUERY_TYPE[0];
			pOverlay = new Rectangle(strCoods, "#9edafa", 1, 0.6, "#9edafa");
			break;
		case "drawCircle":
			qType = SysConfig.QUERY_TYPE[1];
			pOverlay = new Circle(strCoods, "#9edafa", 1, 0.6, "#9edafa");
			break;
		case "drawPolygon":
			qType = SysConfig.QUERY_TYPE[2];
			pOverlay = new Polygon(strCoods, "#9edafa", 1, 0.6, "#9edafa");
		}
		var options = {
			tablename : realtimeInfoTableName,
			layertype : SysConfig.LAYER_TYPE[0],
			coords : strCoods,
			nameField : nameField,
			mapWidth : width,
			where : comwhere,
			querytype : qType,
			extent : extent,
			x : "x",
			y : "y",
			iscluster : false,
			subFields:subFields
		};
		_MapApp.addOverlay(pOverlay);
		GeoQuery.spatialQuery(options, function(resultSet) {
			doQueryResult(resultSet);
			SysTool.loading.unmask();
		});
	}
	
	/**
	 * 周边查询
	 * @param type
	 */
	function aroundqueryCallback(type){
		SysTool.loading.mask("pgis_map", "50%", "50%");
		var strCoods = $("#strCoodsX").val();
		var extent = SysTool.getMapExtent(_MapApp);
		var width = SysTool.getMapWidth("pgis_map");
		var distance =$("#around_distance").val();
		var bound=_MapApp.getBoundsLatLng();
		var degree=_MapApp.getDegree(new Point(bound.minX+","+bound.minY),distance);
		var qType = "";
		switch (type) {
		case "drawPoint":
			qType = SysConfig.QUERY_TYPE[3];
			strCoods=$("#strCoodsX").val()+","+$("#strCoodsY").val()+","+degree;
			pOverlay = new Circle(strCoods, "#9edafa",2,0.6, "#9edafa");
			break;
		case "drawPolyline":
			qType = SysConfig.QUERY_TYPE[4];
			pOverlay = new Polyline(strCoods, "#9edafa", degree*2, 0.6, 0);
			pOverlay.unit = "degree";
			pOverlay.setColor("#9edafa");
			break;
		case "drawPolygon":
			qType = SysConfig.QUERY_TYPE[5];
			pOverlay = new Polyline(strCoods, "#9edafa", degree*2, 0.6,0);
			pOverlay.unit = "degree";
			pOverlay.setColor( "#9edafa");
		}
		var options = {
			tablename : realtimeInfoTableName,
			layertype : SysConfig.LAYER_TYPE[0],
			coords : strCoods,
			nameField : nameField,
			mapWidth : width,
			radius:degree,
			where : comwhere,
			querytype : qType,
			extent : extent,
			x : "x",
			y : "y",
			iscluster : false,
			subFields:subFields
		};
		_MapApp.addOverlay(pOverlay);
		GeoQuery.aroundQuery(options, function(resultSet) {
			doQueryResult(resultSet);
			SysTool.loading.unmask();
		});
	}
	
	/**
	 * 周边查询
	 * @param strCoods 坐标串
	 * @param distance 周边距离
	 * @param type point or polyline or polygon
	 * @param isShowOverlay true or false
	 */
	function aroundQuery(strCoods, distance, type, isShowOverlay){
		SysTool.loading.mask("pgis_map", "50%", "50%");
		var extent = SysTool.getMapExtent(_MapApp);
		var width = SysTool.getMapWidth("pgis_map");
		var bound=_MapApp.getBoundsLatLng();
		var degree=_MapApp.getDegree(new Point(bound.minX+","+bound.minY),distance);
		var qType = "";
		switch (type) {
		case "point":
			qType = SysConfig.QUERY_TYPE[3];
			strCoods=strCoods+","+degree;
			pOverlay = new Circle(strCoods, "#9edafa",2,0.6, "#9edafa");
			break;
		case "polyline":
			qType = SysConfig.QUERY_TYPE[4];
			pOverlay = new Polyline(strCoods, "#9edafa", degree*2, 0.6, 0);
			pOverlay.unit = "degree";
			pOverlay.setColor("#9edafa");
			break;
		case "polygon":
			qType = SysConfig.QUERY_TYPE[5];
			pOverlay = new Polyline(strCoods, "#9edafa", degree*2, 0.6,0);
			pOverlay.unit = "degree";
			pOverlay.setColor( "#9edafa");
		}
			
		var options = {
			tablename : realtimeInfoTableName,
			layertype : SysConfig.LAYER_TYPE[0],
			coords : strCoods,
			nameField : nameField,
			mapWidth : width,
			radius:degree,
			where : comwhere,
			querytype : qType,
			extent : extent,
			x : "x",
			y : "y",
			iscluster : false,
			subFields:subFields
		};
		if(isShowOverlay){
			_MapApp.addOverlay(pOverlay);
		}
		GeoQuery.aroundQuery(options, function(resultSet) {
			doQueryResult(resultSet);
			SysTool.loading.unmask();
		});
	}
	
	/**
	 * 属性查询
	 * @param kwwhere
	 */
	function attributequery(kwwhere){
		SysTool.loading.mask("pgis_map", "50%", "50%");
		var extent = SysTool.getMapExtent(_MapApp);
		var width = SysTool.getMapWidth("pgis_map");
		var qType = "";
		var options = {
			tablename : realtimeInfoTableName,
			layertype : SysConfig.LAYER_TYPE[0],
			nameField : nameField,
			mapWidth : width,
			where : comwhere + " and ("+kwwhere+")",
			querytype : SysConfig.QUERY_TYPE[6],
			extent : extent,
			x : "x",
			y : "y",
			iscluster : false,
			subFields:subFields
		};
		GeoQuery.attributeQuery(options, function(resultSet) {
			doQueryResult(resultSet);
			SysTool.loading.unmask();
		});
	}
	
	/**
	 * 辖区内查询
	 * @param dm
	 */
	function xqnquery(dm) {
		var splitdm = SysTool.getSplitJgdm(dm);
		var qwhere = " JYZZJGDM LIKE '%"+splitdm+"%' ";
		attributequery(qwhere);
	}
	
	/**
	 * 辖区外查询
	 * @param dm
	 */
	function xqwquery(dm) {
		var splitdm = SysTool.getSplitJgdm(dm);
		var qwhere = " JYZZJGDM NOT LIKE '%"+splitdm+"%' ";
		attributequery(qwhere);
	}
	
	/**
	 * 查询结果处理
	 * @param resultSet
	 */
	function doQueryResult(resultSet) {
		for ( var i = 0; i < resultSet.length; i++) {
			if(resultSet[i].result == "") {
				continue;
			}
			var sResult = eval("(" + resultSet[i].result + ")");
			var allcount=sResult.count;
			SysTool.show("查询结果共有 "+allcount+" 条！");
			if (allcount == 0) {
				//$("#result_count").append("<span>共有<span class='spancolor' id='ssjl_result_count'>0</span>条</span>");
			} else {
				var jsonlist = eval("(" + sResult.jsonlist + ")");
				//$("#result_count").append("<span>共有<span class='spancolor' id='ssjl_result_count'>"+allcount+"</span>条</span>");
				//警力上图
				var returnMarkerArray=[];
				returnMarkerArray = createMarker(jsonlist, function(){
					
				});
				$("#reason").css("display", "none");
				$("#resultdiv").css("display", "block");
				$("#results").html("");
				$("#result_count").html("");
				jk_objArray=[];
				for ( var j = 0; j < jsonlist.length; j++) {
					var jk_obj={};
					jk_obj["SBID"]=jsonlist[j].SBID;//监控对象gpsid
					jk_obj["ztid"]=jsonlist[j].STATUSID;
					$("#results").append(
							"<a href='javascript:gps.clickFunc(\""+jsonlist[j].SBID+"\")' id='"+jsonlist[j].SBID+"'>" + "<span class='span1'>" + (jsonlist[j].JYXM||"空") + "</span>"
									+ "<span class='span2'>" + (jsonlist[j].SBID||"空") + "</span>"
									+ "<span class='span3'>"+(jsonlist[j].JYZZJGMC||"空") + "</span></a>");
//					if(addGpsList.length==0){
//						jk_obj["marker"]=returnMarkerArray[j];
//						jk_objArray.push(jk_obj);
//						ssjlGpsobjArray.push(jk_obj);
//					}else{
//						for(var n=0;n<addGpsList.length;n++){//添加的gpsmarker
//							if(addGpsList[n]["SBID"]==jsonlist[j].SBID){
								jk_obj["marker"]=returnMarkerArray[jsonlist[j].SBID];//监控对象marker
								jk_objArray.push(jk_obj);
//								ssjlGpsobjArray.push(jk_obj);
//								break;
//							}
//						};
//					}
					

				}
			}
		}
	}
	
	/**
	 * 结果上图
	 * @param jsonlist
	 * @param callback
	 * @returns
	 */
	function createMarker(jsonlist, callback) {
		var image = "";
		var markerArray = new Array();
		for (var i = 0; i < jsonlist.length; i++) {
			var json = jsonlist[i];
			if (typeof (json) != 'undefined' && json != null
					&& json != "") {
				var ywlxid = json["YWLXID"];
				var jtfsid = json["JTFSID"];
				/*var carno=json["SBCPH"];
				var plcname=json["JYXM"];
				var title = "";
				if(typeof (carno) != "undefined" && carno != "" && carno != null) {
					title += " "+carno;
				}
				if(typeof (plcname) != "undefined" && plcname != "" && plcname != null) {
					title += " "+plcname;
				}*/
				var icon = "";
				try{
					icon = gps_img[jtfsid][ywlxid];
				}catch(e){}
				var marker = {dataJson:json,
						id:json["SBID"]||"",
						/*titleName:title,*/
						x:json["X"]||json["x"],
						y:json["Y"]||json["y"],
						iconUrl:icon,
						iconWidth:40,
						iconHeight:40,
						iconLeftOffset:0,
						iconTopOffset:-8
					};
				markerArray.push(marker);
			}
		}
		var markerParam = {markerArray:markerArray,
					contentType:"html",
					contentValue:initBubbleContent(),
					contentCallback:"gps.loadBubbleContent",
					eventFuncJson:{},
					bubbleShowEvent:"click",
					titleShowEvent:"",
					bubbleWidth:400,
					bubbleHeight:240,
					moveMode:"movetoshow"
				};
		var returnMarkerJson = MapBubble.addMarkerToMap(markerParam);
		callback();
		currMapGpsMarkerJson = returnMarkerJson;//赋值
		startGps();//开启实时信号更新
		currgpsids = getMapGpsIds(currMapGpsMarkerJson);
		return returnMarkerJson;
	}
	
	function getJltjList(zzjgdm) {
		SysTool.ajax({
			url : '',
			data : {zzjgdm:zzjgdm}
		}, function(data) {
			if ("undefined" != typeof data.list && data.list != null) {
				
			}	
		});
	}
	
	/**
	 * 初始气泡内容
	 */
	function initBubbleContent(){
		var msg = "";
		msg += "<div id='ssjl_gps' value='' class='tips_top'><div class='tips_title'><strong style='padding:0 10px;'>警力</strong></div></div>";
		msg += "<div class='tips_jlct'><div class='tipsjili'>警员姓名：<span style='color:#000' id='name'></span></div><div class='tipsjili'>组织机构：<span style='color:#000' id='orgname' title=''></span></div>";
		msg += "<div class='tipsjili'>车牌号码：<span style='color:#000' id='carno'></span></div><div class='tipsjili'>警力呼号：<span style='color:#000' id='callno'></span></div>";
		msg += "<div class='tipsjili'>车辆速度：<span style='color:#000' id='speed'></span>km/h</div><div class='tipsjili'>车辆方向：<span style='color:#000' id='direction'></span></div>";
		msg += "<div class='tipsjili' style='display:none'>警力状态：<span style='color:#000' id='jlstatus'></span></div><div class='tipsjili' style='display:none'>班次时间：<span style='color:#000' id='qwbbbcsj'></span></div>";
		msg += "<div class='tipsjili' style='width:380px;display:none'>同班人员：<span style='color:#000' id='qwbbtbry'></span></div>";
		msg += "<div class='tipsjili' style='width:380px;display:none'>关联装备：<span style='color:#000' id='qwbbtxdzb'></span></div>";
		msg += "<div class='bubllebtn'><a id='gpsbubble_xlqy' href='javascript:void(0);' class='btn_tipsdw' style='display:none'>巡逻区域</a>";
		msg += "<a id='gpsbubble_zjk' href='javascript:void(0);' class='btn_tipsdw'>主监控</a>";
		msg += "<a class='btn_tipsdw_s' id='gpsbubble_lsgj' href='javascript:void(0);'>轨迹</a>";
		msg += "<a class='btn_tipsdw_s btn_tipsdwnot_s' id='gpsbubble_hj' style='display:none'>呼叫</a>";
		msg += "<a class='btn_tipsdw_s' id='gpsbubble_pj' href='javascript:gps.bubblePjFunc(0)'  style='display:none;'>派警</a>";
		msg += "<a class='btn_tipsdw_s' id='gpsbubble_zy' href='javascript:gps.bubblePjFunc(1)'  style='display:none;'>增援</a>";
		msg += "<a class='btn_tipsdw_s' id='gpsbubble_gp' href='javascript:gps.bubblePjFunc(2)'  style='display:none;'>改派</a>";
		msg +=	"<div class='clear'></div></div>";
		return msg;
	}
	
	/**
	 * 加载气泡数据内容
	 * @param data
	 */
	function loadBubbleContent(data){
		var gpsid = data.SBID||data.sbid;
		
		//根据gpsid取得详细信息
		getGpsInfoDetail(gpsid, loadGpsInfoDetail);
		
		
		function loadGpsInfoDetail(data) {
			//设置当前点击的GPS警力数据
			currClickGpsData = data;
			$("#name").text(data["JYXM"]|| "未知");
			$("#carno").text(data["SBCPH"] || "未知");
			$("#callno").text(data["SBGHH"] || "未知");
			$("#speed").text(data["SPEED"] || "未知");
			$("#orgname").text(data["JYZZJGMC"] || "未知");
			$("#direction").text(getDirection(data["DIR"]) || "未知");
			$("#jlstatus").text(data["YWLXMC"] || "未知");
			
			
			//绑定主监控事件
			$("#gpsbubble_zjk").attr("href","javascript:gps.gpsZjk('"+data["SBID"]+"')");
			//绑定轨迹事件
			$("#gpsbubble_lsgj").attr("href","javascript:gps.addGpsLsgj('"+data["SBID"]+"')");
			
			//计算业务数量
			/*var ywsl = getGpsJlYwCount(data);
			$("#ssjl_jqsl").text(ywsl);*/
			
			//控制按钮
			controlBubbleContentButton(data);
			
			//根据警员编号取得勤务相关信息
			//getGpsPersonQwInfo(data["JYBH"], loadGpsPersonQwInfo);
			//getGpsPersonQwInfo('026703', loadGpsPersonQwInfo);
		}
		
		function loadGpsPersonQwInfo(data) {
			//班次时间
			$("#qwbbbcsj").text(data["BCSJ"] || "未知");
			//同班人员
			var otherpersonStr = "";
			var otherperson = data["OTHERPERSON"];
			var otherpersonLen = otherperson.length;
			if(otherpersonLen > 0) {
				otherpersonStr += otherpersonLen+"人 ";
			}
			for(var i = 0; i < otherpersonLen; i++) {
				var json = otherperson[i];
				otherpersonStr += "<span title='";
				otherpersonStr += "呼号：" + json["CALLNO"] || "未知";
				otherpersonStr += "，";
				otherpersonStr += "电话：" + json["JYDH"] || "未知";
				otherpersonStr += "'>";
				otherpersonStr += json["RYXM"] || "未知";
				otherpersonStr += "</span>";
				if(i < otherpersonLen - 1) {
					otherpersonStr += "，";
				}
			}
			$("#qwbbtbry").html(otherpersonStr || "未知");
			
			//携带装备
			var zblxcountStr = "";
			var zblxcount = data["ZBLXCOUNT"];
			var zblxcountLen = zblxcount.length;
			for(var i = 0; i < zblxcountLen; i++) {
				var json = zblxcount[i];
				zblxcountStr += json["ZBLXMC"] + "（" + json["ZBLXNUMBER"]+"）";
				if(i < zblxcountLen - 1) {
					zblxcountStr += "，";
				}
			}
			
			
			$("#qwbbtxdzb").text(zblxcountStr || "未知");
			//绑定巡逻区域上图事件
			$("#gpsbubble_xlqy").attr(
					"href",
					"javascript:gps.addGpsXlqy('" + data["XQLX"]
							+ "','" + data["XQZB"] + "')");
		}
	}
	
	/**
	 * 控制气泡框按钮
	 * @param data
	 */
	function controlBubbleContentButton(data) {
//		var jqxx = Jqxx.currentPointObject[1];
//		if($.isEmptyObject(jqxx)){//警情为空
//			/*$("#gpsbubble_pj").hide();
//			$("#gpsbubble_zy").hide();
//			$("#gpsbubble_gp").hide();*/
//		}else if(jqxx["jqzt"]==2){//未派警
//			/*$("#gpsbubble_zy").hide();
//			$("#gpsbubble_gp").hide();*/
//			$("#gpsbubble_pj").show();
//		}else if(jqxx["jqzt"]>2&&jqxx["jqzt"]<5){//已派警，处置中
//			if (typeof (data["YWBH"]) != 'undefined'
//					&& data["YWBH"].indexOf(jqxx["jqbh"]) != -1) {//当前警力已经在处理该警情
//				/*$("#gpsbubble_pj").hide();
//				$("#gpsbubble_zy").hide();
//				$("#gpsbubble_gp").hide();*/
//			}else{//当前警力未参加该警情
//				/*$("#gpsbubble_pj").hide();*/
//				$("#gpsbubble_zy").show();
//				$("#gpsbubble_gp").show();
//			}
//		}else{//其它则不显示
//			/*$("#gpsbubble_pj").hide();
//			$("#gpsbubble_zy").hide();
//			$("#gpsbubble_gp").hide();*/
//		}
//		
		if(gpsZjkGpsId==data["SBID"]) {
			$("#gpsbubble_zjk").attr("class","btn_tipsdwon");
		}
	}
	
	/**
	 * 取得该GPS警力正在执行的业务数量
	 * @param data
	 * @returns {Number}
	 */
	function getGpsJlYwCount(data) {
		var ywsl = 0;
		var ywbh = data.YWBH || data.ywbh;
		if(typeof (ywbh) != "undefined"){
			if(ywbh.indexOf(",") != -1){
				var count=ywbh.split(",").length;
				ywsl=count;
			}else{
				ywsl=1;
			}
		}
		return ywsl;
	}
	
	/**
	 * 气泡派警事件
	 * @param mark
	 */
	function bubblePjFunc(mark){
		var data = currClickGpsData;
		var policeid=data["JYBH"];
		var policename=data["JYXM"];
		var gpsid=data["SBID"];
		var callno=data["SBGHH"];
		var param={jybh:policeid,jymc:policename,gpsid:gpsid,callno:callno,mark:mark,jqxx:Jqxx.currentPointObject[1]};
		Jqcz.jqczTspj(param);
	}
	
	/**
	 * 根据gpsid取得详细信息
	 * @param gpsid
	 * @param callback
	 */
	function getGpsInfoDetail(gpsid, callback) {
		SysTool.ajax({
			url : '/syrk/gps/getGpsInfoDetail',
			data : {
				'gpsid' : gpsid,
				'gpsTableName' : realtimeInfoTableName
			}
		}, function(data) {
			callback(data);
		});
	}
	
	/**
	 * 根据人员ID查询班次，班次时间，巡逻区域，同班人员信息等
	 * @param jybh
	 * @param callback
	 * @returns
	 */
	function getGpsPersonQwInfo(jybh, callback) {
		SysTool.ajax({
			url : 'gps/getGpsPersonQwInfo',
			data : {
				'ryid' : jybh
			}
		}, function(data) {
			callback(data);
		});
	}
	
	/**
	 * 主监控
	 * @param gpsid
	 */
	function gpsZjk(gpsid) {
		var zjkClass = $("#gpsbubble_zjk").attr("class");
		if(zjkClass.indexOf("on") != -1) {
			$("#gpsbubble_zjk").attr("class","btn_tipsdw");
			gpsZjkGpsId = null;
			try{
				var zjkmarker = currMapGpsMarkerJson[gpsid];
				zjkmarker.hideTitle();
			}catch(e){}
			return;
		} else {
			$("#gpsbubble_zjk").attr("class","btn_tipsdwon");
			try{
				var zjkmarker = currMapGpsMarkerJson[gpsZjkGpsId];
				zjkmarker.hideTitle();
			}catch(e){}
			gpsZjkGpsId = gpsid;
			gpsZjkCreateMarker(currClickGpsData);
			gpsZjkFunc(MapBubble.currMarker.getPoint());
		}
	}
	
	/**
	 * 主监控事件
	 * @param point
	 */
	function gpsZjkFunc(point) {
		var nowZoomLevel = _MapApp.getZoomLevel();
		if(nowZoomLevel < zjkDefaultZoomLevel) {
			_MapApp.centerAndZoom(point, zjkDefaultZoomLevel);
		} else {
			_MapApp.centerAndZoom(point, nowZoomLevel);
		}
	}
	
	/**
	 * 主监控marker
	 * @param data
	 */
	function gpsZjkCreateMarker(data) {
		var gpsid = data["SBID"];
		var currmarker = MapBubble.currMarker;
		var point = currmarker.getPoint();
		var icon = currmarker.div.src;

		var markerArray = new Array();
		var carno=data["SBCPH"];
		var plcname=data["JYXM"];
		var title = "主监控";
		if(typeof (carno) != "undefined" && carno != "" && carno != null) {
			title += " "+carno;
		}
		if(typeof (plcname) != "undefined" && plcname != "" && plcname != null) {
			title += " "+plcname;
		}
		var marker = {dataJson:data,
				id:gpsid,
				titleName:title,
				x:point.x,
				y:point.y,
				iconUrl:icon,
				iconWidth:40,
				iconHeight:40,
				iconLeftOffset:0,
				iconTopOffset:-8
			};
		markerArray.push(marker);
		var markerParam = {markerArray:markerArray,
				contentType:"html",
				contentValue:initBubbleContent(),
				contentCallback:"gps.loadBubbleContent",
				eventFuncJson:{},
				bubbleShowEvent:"click",
				titleShowEvent:"",
				bubbleWidth:400,
				bubbleHeight:240,
				moveMode:"movetoshow"};
		var returnMarkerJson = MapBubble.addMarkerToMap(markerParam);
		_MapApp.removeOverlay(currmarker);
		var marker_ = returnMarkerJson[gpsid];
		marker_.titleDiv.style.background="#e40000";
		marker_.titleDiv.style.paddingLeft="3px";
		marker_.titleDiv.style.paddingRight="3px";
		marker_.titleDiv.style.marginLeft="-3px";
		marker_.titleDiv.style.marginTop="-3px";
		currMapGpsMarkerJson[gpsid] = marker_;
		MapBubble.currMarker = marker_;
	}
	
	/**
	 * 停止主监控
	 */
	function stopGpsZjk() {
		try{
			var zjkClass = $("#gpsbubble_zjk").attr("class");
			if(zjkClass.indexOf("on") != -1) {
				$("#gpsbubble_zjk").attr("class","btn_tipsdw");
				gpsZjkGpsId = null;
				return;
			}
		}catch(e){}
	}
	
	/**
	 * 历史轨迹
	 * @param gpsid
	 */
	function addGpsLsgj(gpsid) {
		var time = $("#timeInterval").val();;
		if (typeof (time) == 'undefined' || time == null
				|| time == "") {
			time = 5;
		}
		//clearGpsLsgj();
		SysTool.ajax({
			url : '/syrk/gps/getLsgj',
			data : {
				'gpsid' : gpsid,
				'time' : time
			}
		}, function(data) {
			$("#gpsbubble_lsgj").attr("class","btn_tipsdwon");
			var strCoods = "";
			for ( var i = 0; i < data.length; i++) {
				if (i != (data.length - 1)) {
					strCoods += data[i].x + "," + data[i].y + ",";
				} else {
					strCoods += data[i].x + "," + data[i].y;
				}
			}
			//strCoods = "121.69189,38.86865,121.70861,38.90612,121.67932,38.91564";
			var pOverlay = new Polyline(strCoods, "red", 3, 0.6, 0);//画轨迹
			_MapApp.addOverlay(pOverlay);
			gpsLsgjObject = pOverlay;
		});
	}
	
	/**
	 * 清除历史轨迹
	 */
	function clearGpsLsgj() {
		if(gpsLsgjObject != null) {
			_MapApp.removeOverlay(gpsLsgjObject);
		}
	}
	
	/**
	 * 开启实时统计
	 */
	function startCount(zzjgdm) {
		//关闭实时统计
		stopCount();
		gpsCount(zzjgdm);
		ProtectedTimer.sstjTimer = setInterval(function(){
			gpsCount(zzjgdm);
		},SysConfig.SSTJ_TIMER);
		gps.intoMaps(zzjgdm);
	}
	
	/**
	 * 实时统计
	 * @param zzjgdm
	 */
	function gpsCount(zzjgdm) {
		//开启倒计时
		startDjTimer();
		//类型统计
		gpsTypeCount(zzjgdm);
		//人员统计
		//gpsPersonCount(zzjgdm);
	}
	
	/**
	 * 关闭实时统计
	 */
	function stopCount() {
		SysTimer.clearTimer(ProtectedTimer.sstjTimer);
	}
	
	/**
	 * 开启实时GPS信息
	 */
	function startGps() {
		stopGps();
		ProtectedTimer.ssxxTimer = setInterval(function(){
			ssxxUpdate();
		},SysConfig.SSXX_TIMER);
	}
	
	/**
	 * 关闭实时GPS信号
	 */
	function stopGps() {
		SysTimer.clearTimer(ProtectedTimer.ssxxTimer);
	}
	
	/**
	 * 处理实时信号更新
	 */
	function ssxxUpdate() {
		SysTool.ajax({
			url : '/syrk/gps/getRealTimeGpsInfo',
			data : {
				'gpsids' : currgpsids
			}
		}, function(data) {
			 for(var gpsid in data){  
				 var marker = getMapMarkerByGpsid(gpsid);
				 var gpsRealTimeInfo = data[gpsid];
				 if (typeof (gpsRealTimeInfo) != 'undefined' && gpsRealTimeInfo != null
						&& gpsRealTimeInfo != "") {
					 var pointx = gpsRealTimeInfo["X"];
					 var pointy = gpsRealTimeInfo["Y"];
					 var speed = gpsRealTimeInfo["SPEED"];
					 var dir = gpsRealTimeInfo["DIR"];
					 var ywlxid = gpsRealTimeInfo["YWLXID"];
					 var ywlxmc = gpsRealTimeInfo["YWLXMC"];
					 
					 //更新marker位置
					 var point = new Point(pointx, pointy);
					 marker.setPoint(point);
					 
					 //根据状态(业务类型ID)重新设置icon
					 setMarkerNewIcon(marker, ywlxid);
					 
					 //气泡跟随移动
					 if(currClickGpsData["SBID"] == gpsid){
						 MapBubble.relocation(marker, point.x, point.y, function(marker){
								MapBubble.setBubblePositionByMarker(marker);
						 });
					 }
					 
					 //处理主监控gpsid
					 if(gpsZjkGpsId == gpsid) {
						 gpsZjkFunc(point);
					 }
					 
					 //气泡打开时，实时更新速度、方向、状态
					 if(MapBubble.isExistBubble && currClickGpsData["SBID"] == gpsid) {
						 	$("#speed").text(speed || "未知");
							$("#direction").text(getDirection(dir) || "未知");
							$("#jlstatus").text(ywlxmc || "未知");
					 }
				 } else {
					 var point = new Point(0, 0);
					 marker.setPoint(point);
				 }
		     }
		});
	}
	
	/**
	 * 警力按交通类型统计
	 * @param zzjgdm
	 */
	function gpsTypeCount(zzjgdm) {
		SysTool.ajax({
			url : '/syrk/gps/getGpsTypeNumberCount',
			data : {
				'zzjgdm' : zzjgdm,
				gpsTableName : realtimeInfoTableName
			}
		}, function(data) {
			var countHtml = "";
			for(var i = 0; i < data.length; i++) {
				var json = data[i];
				countHtml += '<div>';
				countHtml += '<span >'+json["LXMC"]+'</span>';
				countHtml += '<a href="javascript:;" onclick="gps.doJlReasult(this);">'+json["XL"]+'</a>';
				countHtml += '<a href="javascript:;" >'+json["ALLNUMBER"]+'</a>';
				//countHtml += '<a href="javascript:;">'+json["CJ"]+'</a>';
				//countHtml += '<a href="javascript:;">'+json["QT"]+'</a>';
				countHtml += '</div>';
			}
			$("#gps_type_counterid").html(countHtml);
		});
	}
	
	/**
	 * 警力按人员分类统计
	 * @param zzjgdm
	 */
	function gpsPersonCount(zzjgdm) {
		SysTool.ajax({
			url : '/syrk/gps/getGpsPersonNumberCount',
			data : {
				'zzjgdm' : zzjgdm,
				 gpsTableName : realtimeInfoTableName
			}
		}, function(data) {
			var countHtml = '';
			countHtml += '<div>';
			countHtml += '<a href="javascript:;">'+data["ALLNUM"]+'</a>';
			countHtml += '<a href="javascript:;">'+data["MJ"]+'</a>';
			countHtml += '<a href="javascript:;">'+data["XJ"]+'</a>';
			countHtml += '<a href="javascript:;">'+data["QT"]+'</a>';
			countHtml += '</div>';
			$("#gps_person_counterid").html(countHtml);
		});
	}
	
	/**
	 * 根据状态(业务类型ID)重新设置icon
	 * @param marker
	 * @param ywlxid
	 */
	function setMarkerNewIcon(marker, ywlxid) {
		if(ywlxid != null && ywlxid != "") {
			 var icon = "";
			 var oldicon = marker.div.src;
			 var temp = "";
			 var idx = oldicon.indexOf(".png");
			 if(idx > 3) {
				 temp = oldicon.substring(idx - 3,idx);
				 var tempArray = temp.split("_");
				 var jtfsid_t = tempArray[0];
				 var ywlxid_t = tempArray[1];
				 if(ywlxid != ywlxid_t) {
					 try{
							icon = gps_img[jtfsid_t][ywlxid];
							marker.div.src = icon;
						}catch(e){}
				 }
			 }
		 }
	}
	
	/**
	 * 当前地图GPSID串，逗号分隔
	 * @param json
	 * @returns {String}
	 */
	function getMapGpsIds(json) {
		var gpsids = "";
		if(typeof(json) == 'undefined') {
			json = currMapGpsMarkerJson;
		}
        for(var gpsid in json){  
        	gpsids += gpsid + ",";
        }
		if(gpsids != null && gpsids != "") {
			gpsids = gpsids.substring(0, gpsids.length - 1);
		}
		return gpsids;
	}
	
	/**
	 * 根据gpsid取得对应的地图marker对象
	 * @param gpsid
	 * @returns
	 */
	function getMapMarkerByGpsid(gpsid) {
		return currMapGpsMarkerJson[gpsid];
	}
	
	/**
	 * 巡逻区域上图
	 * @param layerType
	 * @param points
	 * @param color
	 * @returns
	 */
	function addGpsXlqy(layerType, points, color) {
			if (undefined == color)
			{
				color = "blue";
			}
			var obj = null;
			if ("point" == layerType)
			{
				var point = null;
				if(points.indexOf(",") != -1) {
					var pointsArray = points.split(",");
					point = new Point(pointsArray[0],pointsArray[1]);
				}
				if(point==null) {
					return;
				}
				var degree = _MapApp.getDegree(point, 500);
				var circlePoint = points + ","+degree;
				obj = new Circle(circlePoint, color, 2, 0.6,"none");
			}
			else if ("polyline" == layerType)
			{
				obj = new Polyline(points, color, 2, 0.6, "none");
			}
			else if ("polygon" == layerType)
			{
				obj = new Polygon(points, color, 2, 0.6, "none");
			}
			if(obj != null) {
				_MapApp.addOverlay(obj);
				obj.flash(3);
				gpsXlqyObject = obj;
			}
			return obj;
	}
	
	/**
	 * 清除巡逻辖区
	 */
	function clearGpsXlqy() {
		if(gpsXlqyObject != null) {
			_MapApp.removeOverlay(gpsXlqyObject);
		}
	}
	
	/**
	 * 清除marker
	 */
	function clearGpsMarker() {
		for(var key in currMapGpsMarkerJson) {
			_MapApp.removeOverlay(currMapGpsMarkerJson[key]);
		}
		currMapGpsMarkerJson = {};
	}
	
	/**
	 * 开启倒计时
	 */
	function startDjTimer() {
		stopDjTimer();
		$("#gpstjdjsid").html(SysConfig.SSTJ_TIMER / 1000);
		ProtectedTimer.ssdjTimer = setInterval(function(){
			var oldV = $("#gpstjdjsid").html();
			var newV = oldV - 1;
			if(newV >=0) {
				$("#gpstjdjsid").html(newV);
			} else {
				stopDjTimer();
				gpsCount($('#ssjl_gpszzjg_dm').val());
			}
		},1000);
	}
	
	/**
	 * 关闭倒计时
	 */
	function stopDjTimer() {
		SysTimer.clearTimer(ProtectedTimer.ssdjTimer);
	}
	
	/**
	 * 移除最后一个Overlay
	 */
	function removeLastOverlay() {
		var olArray = _MapApp.getOverlays();
		try{
			var olObj = olArray[olArray.length - 1];
			_MapApp.removeOverlay(olObj); 
		}catch(e){}
	}
	
	/**
	 * 根据偏移角度返回方向
	 * @param dir
	 * @returns {String}
	 */
	function getDirection(dir){
		var initDir=270;
		var direction = parseInt(initDir)  + parseInt(dir);
		while(direction > 360){
			direction -= 360;
		}
		var txt = "";
		if(direction === 0 || direction === 360){
			txt = "北";
		}else if(direction > 0 && direction < 90){
			txt = "东北";
		}else if(direction === 90){
			txt = "东";
		}else if(direction >  90 && direction < 180){
			txt = "东南";
		}else if(direction === 180){
			txt = "南";
		}else if(direction > 180 && direction < 270){
			txt = "西南";
		}else if(direction === 270){
			txt = "西";
		}else if(direction > 270 && direction < 360){
			txt = "西北";
		}
		return txt;
	}
}

var gps = new Gps();