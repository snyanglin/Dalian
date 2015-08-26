
var Jcxx = {
	/**
	 * 所选图层名称
	 */
	name : [],
	/**
	 * 所选图层关键字段
	 */
	field : [],
	/**
	 * 所选图层对应条件
	 */
	where : [],

	/**
	 * 图层权限信息 [{tableName:"",field:"",cname:""}],tableName：图层名，field:关键字，cname:中文名称
	 */
	dataPrivilege_info:[],
	gjz:"请输入关键字查询",
	/**
	 * 空间查询overlay
	 */
	kjcxOverlay:null,
	kjcxType:"",
	/**
	 * 查询方式，用于判断切换标签后原有查询
	 */
	queryType:"",
	xqCoords:"",
	/**
	 * 初始化
	 */
	init:function(isLoad,roadid) { 
//		this.name=[];
//		this.field=[];
//		this.where=[];
		Jcxx.getDataPrivilege();//查询权限
		Dictionary.initDictionaryList({url: "dictionary/getDictionaryListJSON.f", data: {"zdbh": "D_ZBJL"}, dictShowId: "jcxx_distance", initVal: "1","dictContainerReferenceObjectId": "jcxx_all"}, function() {

    	});
		Jcxx.initKeywordInput("jcxx_search");  
		//从交通态势管理路段周边资源查询
		if("yes"== isLoad ){
			
			var timer=window.setInterval(addClass, 100);
			//定时器执行函数
			function addClass() { 
				//在基础资源页面中获取class=btnzy的元素
				var eles=$(".btnzy");
				if(eles.length>0) {
					//改变视频和卡口的样式
					for(var i=0;i<2;i++) {
						$(eles[i]).click();
					}
					//取消定时器
				
				  clearInterval(timer);
				}
			}
			var initValue=SysConfig.JQXX_FAST_QUERY["target"];
			Jcxx.name=initValue;
			Jcxx.field=["MC","MC"];
			Jcxx.getroadzbzy(roadid);
		}
		SysTool.changeIputStyle();
	
	},
	/**
	 * 生成图层选择栏
	 * @param title 图层中文名
	 * @param layerName 图层名称
	 * @param layerField 图层关键字段
	 * @param bgurl 背景图url
	 */
	createLayerData:function(title,layerName,layerField,bgurl){
		var data="<a href='javascript:void(0)' class='btnzy' title='"+title+"' value='"+layerName+"' value1='"+layerField+"' >" +
				"<span style='background:url("+bgurl+") 0 0 no-repeat'>"+title+"</span></a>";
		$("#layer_data_content").append(data);
	},
	/**
	 * 获取专题权限
	 */
	getDataPrivilege:function(){
		GeoQuery.dataPrivilege_info=[];//清空
		var userid=SysConfig.USERID;
        var systemName=SysConfig.SYSTEM_NAME;
       var moduleName="辅助系统";
       var functionName="基础信息";
       var spatialcode=SysConfig.SPATIAL_CODE;
         var ezmanager=new ezbuilderAPI.Ezmanager();
         ezmanager.getThemePrivilegeByFunction(userid,systemName,moduleName,functionName,spatialcode,function(json){//查询权限
        	 var objs = eval("("+json.resultJson+")");
        	 if(objs.length!=0){
        		 for(var i=0;i<objs.length;i++){
 					var themeTree=objs[i]["themeTree"];
 					if(themeTree!="undefined"&&themeTree.length>0){
 						Jcxx.parseTree(themeTree);
 					}
 					
               }
         	 if(Jcxx.dataPrivilege_info.length>0){//解析权限图层后的结果
         		 var dpi=Jcxx.dataPrivilege_info;
         		 for(var i=0;i<SysConfig.GIS_LAYER_ICONS.length;i++){
         			 var tablename=SysConfig.GIS_LAYER_ICONS[i]["id"].toUpperCase();
         			 var order=SysConfig.GIS_LAYER_ICONS[i]["order"];
         			 if(order==(i+1)){
         				 for(var j=0;j<dpi.length;j++){
             				 if(dpi[j].tableName.toUpperCase()==tablename){//创建已有图层
             					 Jcxx.createLayerData(dpi[j].cname, dpi[j].tableName, dpi[j].field,SysConfig.GIS_LAYER_ICONS[i]["bg_url"]);
             					 break;
             				 }
             			 }
         				 continue;
         			 }
         			 
         		 }
         	 }
         	 Jcxx.bindFunction();//生成图层列表后开始绑定事件
         	 Jcxx.syxqClickBind();
         	Jcxx.jqxxFastQueryMode();
//         	$(".btnzy").each(function(i){
//				var that=this;
//				for(var j=0;j<Jcxx.name.length;j++){
//					if(Jcxx.name[j].toUpperCase()==that.value.toUpperCase()){
//						$(that).addClass("btnzyon");
//					}
//				};//判断切换基础信息后，原有的查询
//				switch(Jcxx.queryType){
//				case ""#fast_"+"
//				}
//			});
        	 }else{//权限图层为空
        		 $("#no_data").show();
        	 }
         });

	},
	/**
	 * 解析专题权限树
	 * @param treeobj
	 */
	parseTree:function(treeobj){
			
			for(var i=0;i<treeobj.length;i++){
				var jsonobj={};
				if(treeobj[i]["themeTree"]!="undefined"&&treeobj[i]["themeTree"].length>0){
					Jcxx.parseTree(treeobj[i]["themeTree"]);
				}else{
					 jsonobj["tableName"]=treeobj[i]["tableName"];//图层名
					 jsonobj["field"]=treeobj[i]["queryFieldName"];//关键字段
					 jsonobj["cname"]=treeobj[i]["aliasName"];//中文名
					 Jcxx.dataPrivilege_info.push(jsonobj);//存储图层名以及关键字
				}
			}

	},
	bindFunction : function() { 
		$(".btnzy").bind("click", function(e) {  
			if ($(this).hasClass("btnzyon")) {
				$(this).removeClass("btnzyon");
				if ($("#layer_data_content").children(".btnzyon").length > 0) {
					for ( var i = 0; i < Jcxx.name.length; i++) {
						if (Jcxx.name[i] == $(this).attr("value")) {
							Jcxx.name.splice(i, 1);
							Jcxx.field.splice(i, 1);
							break;
						}
					}
					Jcxx.clearOneLayerOverlay($(this).attr("value"));
					
				} else {
					Jcxx.kjcxType="";//清空空间查询标识
					Jcxx.clearOneLayerOverlay($(this).attr("value"));
					Jcxx.clearCustomListener();
					Jcxx.clearStyle("visionSearch","bnt_syn_on");
					Jcxx.clearStyle("xqSearch","bnt_xqn_on");
					$("#fast_query_mode a").removeClass("btnab_onb");
					Jcxx.name = [];
					Jcxx.field = [];
//					$("#fast_query_mode a").remove();//未选择后，清除快速周边查
				}

			} else {
				Jcxx.name.push($(this).attr("value"));
				Jcxx.field.push($(this).attr("value1"));
				var jqxx = Jqxx.currentPointObject[1];
				if(!$.isEmptyObject(jqxx)){
					if ($("#layer_data_content").children(".btnzyon").length == 0) {//有警情未选择的情况
						 Jcxx.showOrHideFastQuery();
					}else{//有警情，已选择其它的情况
						var sy=$("#query_mode a").hasClass("bnt_syn_on");
						var xq=$("#query_mode a").hasClass("bnt_xqn_on");
						var zbfast=$("#fast_query_mode").children("a").hasClass("btnab_onb");
						if(sy||xq||zbfast){
							if(sy){
								Jcxx.visionSearch($(this).attr("value"), $(this).attr("value1"));//视野查询
							};
							if(xq){
								Jcxx.xqSearch($(this).attr("value"), $(this).attr("value1"));//辖区查询
							};
							if(zbfast){
								var distance=$("#fast_query_mode").children(".btnab_onb").attr("value");
								Jcxx.fastQuery(distance, $(this).attr("value"), $(this).attr("value1"));//快速周边
							}
						}else{
							if(Jcxx.kjcxType=="drawRect"||Jcxx.kjcxType=="drawCircle"||Jcxx.kjcxType=="drawPolygon"){//空间查询
								Jcxx.callback(Jcxx.kjcxType, $(this).attr("value"), $(this).attr("value1"));
							};
							if(Jcxx.kjcxType=="drawPoint"||Jcxx.kjcxType=="drawPolyline"||Jcxx.kjcxType=="drawPolygon"){
								Jcxx.callback1(Jcxx.kjcxType, $(this).attr("value"), $(this).attr("value1"));
							}
						}
					}
				}else{//无警情情况
					var sy=$("#query_mode a").hasClass("bnt_syn_on");
					var xq=$("#query_mode a").hasClass("bnt_xqn_on");
					var zbfast=$("#fast_query_mode").children("a").hasClass("btnab_onb");
					if(sy||xq||zbfast){
						if(sy){
							Jcxx.visionSearch($(this).attr("value"), $(this).attr("value1"));//视野查询
						};
						if(xq){
							Jcxx.xqSearch($(this).attr("value"), $(this).attr("value1"));//辖区查询
						};
						if(zbfast){
							var distance=$("#fast_query_mode").children(".btnab_onb").attr("value");
							Jcxx.fastQuery(distance, $(this).attr("value"), $(this).attr("value1"));//快速周边
						}
					}else{
						if(Jcxx.kjcxType=="drawRect"||Jcxx.kjcxType=="drawCircle"||Jcxx.kjcxType=="drawPolygon"){//空间查询
							Jcxx.callback(Jcxx.kjcxType, $(this).attr("value"), $(this).attr("value1"));
						};
						if(Jcxx.kjcxType=="drawPoint"||Jcxx.kjcxType=="drawPolyline"||Jcxx.kjcxType=="drawPolygon"){
							Jcxx.callback1(Jcxx.kjcxType, $(this).attr("value"), $(this).attr("value1"));
						}
					}
				}
					
				$(this).addClass("btnzyon");
				
					
			}

		});
	},
	/**
	 * 属性查询
	 * 
	 * @param name
	 * @param field
	 * @param where
	 */
	allQuery : function(name, field, where) {
		this.kjcxType="";
		this.queryType="";
		var where = where || "1=1";
		this.clearStyle("visionSearch","bnt_syn_on");
		this.clearStyle("xqSearch","bnt_xqn_on");
		$("#fast_query_mode a").removeClass("btnab_onb");
		Jcxx.t(name, field, where);
			_MapApp.addMapEventListener(EzEvent.MAP_ZOOMEND, function() {
				Jcxx.t(Jcxx.name, Jcxx.field,where);
			});

	},
	t : function(name, field, where) {
		/*yichu begin*/
		SysTool.loading.mask("pgis_map", "50%", "50%");
		/*yichu end*/
		var where = where || "1=1";
		var add=false;
		if(typeof name=="string"){
			this.clearOneLayerOverlay(name);
			add=true;
		}else{
			this.clearJcxxAllOverlays();
		}
		var extent = SysTool.getMapExtent(_MapApp);
		var width = SysTool.getMapWidth("pgis_map");
		var options = {
			tablename : name,
			layertype : SysConfig.LAYER_TYPE[0],
			nameField : field,
			mapWidth : width,
			where : where,
			querytype : SysConfig.QUERY_TYPE[6],
			extent : extent
		};
		GeoQuery.attributeQuery(options, function(resultSet) {
			GeoQuery.dataProcess(resultSet, _MapApp,add);
			Ssjl.startSsxx();
			/*yichu begin*/
			SysTool.loading.unmask();
			/*yichu end*/
		});
	},
	/**
	 * 空间查询
	 * @param type
	 * @param where
	 * @returns {Boolean}
	 */
	spatialQuery : function(type, where) {
		this.queryType="";
		this.kjcxType=type;
		var where = where || "1=1";
		if (Jcxx.name.length == 0) {
			SysTool.alert("请选择需要查询的基础信息");
			return false;
		}
		;
		_MapApp.changeDragMode(type, dataInputx, dataInputy, function(str) {
			
			Jcxx.callback(type, Jcxx.name, Jcxx.field,where);
		});
		this.clearCustomListener();
		_MapApp.addMapEventListener(EzEvent.MAP_ZOOMEND, function() {
			Jcxx.callback(type, Jcxx.name, Jcxx.field,where);
		});
	},
	callback : function(type, name, field, where) {
		/*yichu begin*/
		SysTool.loading.mask("pgis_map", "50%", "50%");
		/*yichu end*/
		var nwhere=where||"1=1";
		this.clearStyle("visionSearch","bnt_syn_on");
		this.clearStyle("xqSearch","bnt_xqn_on");
		$("#fast_query_mode a").removeClass("btnab_onb");
		var add=false;
		if(typeof name=="string"){
			this.clearOneLayerOverlay(name);
			add=true;
		}else{
			this.clearJcxxAllOverlays();
		}
		var str = $("#dataInputx").val();
		var extent = SysTool.getMapExtent(_MapApp);
		var width = SysTool.getMapWidth("pgis_map");
		var qType = "";
		var pOverlay=null;
		switch (type) {
		case "drawRect":
			qType = SysConfig.QUERY_TYPE[0];
			pOverlay = new Rectangle(str, "#9edafa", 0.5, 0.6, "#9edafa");
			break;
		case "drawCircle":
			qType = SysConfig.QUERY_TYPE[1];
			pOverlay = new Circle(str, "#9edafa", 0.5, 0.6, "#9edafa");
			break;
		case "drawPolygon":
			qType = SysConfig.QUERY_TYPE[2];
			pOverlay = new Polygon(str, "#9edafa", 0.5, 0.6, "#9edafa");
		}
		var options = {
			tablename : name,
			layertype : SysConfig.LAYER_TYPE[0],
			coords : str,
			nameField : field,
			mapWidth : width,
			where : nwhere,
			querytype : qType,
			extent : extent
		};
		if(!add){
			_MapApp.addOverlay(pOverlay);
			this.kjcxOverlay=pOverlay;
		}else{
			if(this.kjcxOverlay==null){
				_MapApp.addOverlay(pOverlay);
				this.kjcxOverlay=pOverlay;
			}
		}
		
		GeoQuery.spatialQuery(options, function(resultSet) {
			GeoQuery.dataProcess(resultSet,add);
			/*yichu begin*/
			SysTool.loading.unmask();
			/*yichu end*/
		});
	},
	/**
	 * 周边查询
	 * @param type
	 */
	aroundQuery : function(type) {
		this.queryType="";
		if (Jcxx.name.length == 0) {
			SysTool.alert("请选择需要查询的基础信息");
			return false;
		};
		this.kjcxType=type;
	
		_MapApp.changeDragMode(type, dataInputx, dataInputy, function() {
			Jcxx.callback1(type, Jcxx.name, Jcxx.field);
		});
		_MapApp.clearMapInstanceEventListeners("mapzoomend");
		_MapApp.addMapEventListener(EzEvent.MAP_ZOOMEND, function() {
			Jcxx.callback1(type, Jcxx.name, Jcxx.field);
		});

	},
	callback1 : function(type, name, field) {
		/*yichu begin*/
		SysTool.loading.mask("pgis_map", "50%", "50%");
		/*yichu end*/
		this.clearStyle("visionSearch","bnt_syn_on");
		this.clearStyle("xqSearch","bnt_xqn_on");
		$("#fast_query_mode a").removeClass("btnab_onb");
		var add=false;
		if(typeof name=="string"){
			this.clearOneLayerOverlay(name);
			add=true;
		}else{
			this.clearJcxxAllOverlays();
		}
		var nname=name||Jcxx.name;
		var nfield=field||Jcxx.field;
		var extent = SysTool.getMapExtent(_MapApp);
		var width = SysTool.getMapWidth("pgis_map");
		var bound = _MapApp.getBoundsLatLng();
		var distance = $("#jcxx_distance").val();
		
		var degree = _MapApp.getDegree(
				new Point(bound.minX + "," + bound.minY), distance);
		var qType = "";
		var strCoods = "";
		var pOverlay=null;
		switch (type) {
		case "drawPoint":
			qType = SysConfig.QUERY_TYPE[3];
			strCoods = $("#dataInputx").val() + "," + $("#dataInputy").val()
					+ "," + degree;
			pOverlay = new Circle(strCoods, "#9edafa", -1, 0.6, "#9edafa");
			break;
		case "drawPolyline":
			qType = SysConfig.QUERY_TYPE[4];
			strCoods = $("#dataInputx").val();
			pOverlay = new Polyline(strCoods, "#9edafa", degree * 2, 0.6, 0);
			pOverlay.unit = "degree";
			pOverlay.setColor("#9edafa");
			break;
		case "drawPolygon":
			qType = SysConfig.QUERY_TYPE[5];
			strCoods = $("#dataInputx").val();
			pOverlay = new Polyline(strCoods, "#9edafa", degree * 2, 0.6, 0);
			pOverlay.unit = "degree";
			pOverlay.setColor("#9edafa");
			break;
		}
		if(!add){
			_MapApp.addOverlay(pOverlay);
			this.kjcxOverlay=pOverlay;
		}else{
			if(this.kjcxOverlay==null){
				_MapApp.addOverlay(pOverlay);
				this.kjcxOverlay=pOverlay;
			}
		}
		var options = {
			tablename : nname,
			layertype : SysConfig.LAYER_TYPE[0],
			coords : strCoods,
			nameField : nfield,
			mapWidth : width,
			radius : degree,
			querytype : qType,
			extent : extent
		};
		GeoQuery.aroundQuery(options, function(resultSet) {
			GeoQuery.dataProcess(resultSet,add);
			/*yichu begin*/
			SysTool.loading.unmask();
			/*yichu end*/
		});
	},
	
	
	
	/**
	 * 根据roadid获取路段坐标，并进行周边警力查询（从交通态势管理系统跳转专用）
	 * @param roadid
	 */
	getroadzbzy : function(roadid) {
		var aQuery = new QueryObject();
//		removeLastOverlay();
		aQuery.featurelimit = 10000;
		aQuery.queryType = 6;
		aQuery.dispField = 'objectid,lddm,ldmc';
		aQuery.addSubFields('objectid,lddm,ldmc');
		aQuery.tableName = SysConfig.GIS_DB_USERNAME + '.' + SysConfig.JT_ROADSEGITEM_PL;
		var where = "";
		var lddm = roadid;
     	if(lddm != "" && lddm != null) {
			where += " lddm in ("+lddm+")";
		} else {
			where += " lddm = 'noshow'";
		}
		aQuery.where = where;
	   _MapApp.query(aQuery, function(vBIsOK, vRequestObj) {
			try {
				var features = new Array();
				var dwLayers = _MapApp.getQueryResult(vRequestObj); 
				var areastr = '';
				for ( var j = 0; j < dwLayers.length; j++) {
					if (dwLayers[j].tableName.toUpperCase() == aQuery.tableName
							.toUpperCase()) {
						features = dwLayers[j].features;
					}
				}
				var ilength = features.length;
				if (ilength > 0) {
					for ( var i = 0; i < ilength; i++) {
						dwftrObj = features[i];
					    areastr = dwftrObj.linestr;
					    $("#dataInputx").val(areastr);
					    Jcxx.callback1("drawPolyline",Jcxx.name,Jcxx.field);
		     	}
				}
					
		} catch (e) {
		}
		});
	},
	
	
	/**
	 * 关键字查询
	 */
	mysearch : function() {
		this.kjcxType="";
		Jcxx.where = [];
		var value = $("#jcxx_search").val();
		if (Jcxx.name.length == 0) {
			SysTool.alert("请选择需要查询的基础信息");
			return false;
		} else if (Jcxx.name.length >= 1) {
			if(value==this.gjz){
				$("#jcxx_search").focus();
				return false;
			}
			for ( var i = 0; i < Jcxx.name.length; i++) {
				Jcxx.where.push(Jcxx.field[i] + " like '%" + value + "%'");
			}
			this.clearCustomListener();
			Jcxx.allQuery(Jcxx.name, Jcxx.field, Jcxx.where);
		}
	},
	syxqClickBind:function(){
		$("#visionSearch").click(function(){
			if($("#visionSearch").hasClass("bnt_syn_on")){
				$("#visionSearch").removeClass("bnt_syn_on");
				Jcxx.clearJcxxAllOverlays();
				Jcxx.clearCustomListener();
				return false;
			}else{
				Jcxx.visionSearch();
			}
		});
		$("#xqSearch").click(function(){
			if($("#xqSearch").hasClass("bnt_xqn_on")){
				$("#xqSearch").removeClass("bnt_xqn_on");
				Jcxx.clearJcxxAllOverlays();
				Jcxx.clearCustomListener();
				return false;
			}else{
				Jcxx.xqSearch();
				
				
			}
			
		});
	},
	/**
	 * 视野内查询
	 */
	visionSearch:function(name,field){
		this.queryType="visionSearch";
		this.kjcxType="";
		this.clearStyle("xqSearch","bnt_xqn_on");
		$("#fast_query_mode a").removeClass("btnab_onb");
		if(Jcxx.name.length==0){
			SysTool.alert("请选择需要查询的基础信息");
			return false;
		}
		$("#visionSearch").addClass("bnt_syn_on");
		var nname=name||Jcxx.name;
		var nfield=field||Jcxx.field;
		this.clearCustomListener();
		this.visionSearchListenerFunc(nname,nfield);
		_MapApp.addMapEventListener(EzEvent.MAP_PANEND, function(){
			Jcxx.visionSearchListenerFunc(Jcxx.name,Jcxx.field);
		});
	},
	/**
	 * 视野内查询监听
	 * @param name
	 * @param field
	 */
	visionSearchListenerFunc:function(name,field){
		/*yichu begin*/
		SysTool.loading.mask("pgis_map", "50%", "50%");
		/*yichu end*/
		var add=false;
		if(typeof name=="string"){
			this.clearOneLayerOverlay(name);
			add=true;
		}else{
			this.clearJcxxAllOverlays();
		}
		
		var coords=SysTool.getMapExtent(_MapApp);
		var width = SysTool.getMapWidth("pgis_map");
		var options = {
				tablename : name,
				layertype : SysConfig.LAYER_TYPE[0],
				coords : coords,
				nameField : field,
				mapWidth : width,
				querytype : SysConfig.QUERY_TYPE[0],
				extent : coords
			};

		GeoQuery.spatialQuery(options, function(resultSet) {
			GeoQuery.dataProcess(resultSet,add);
			/*yichu begin*/
			SysTool.loading.unmask();
			/*yichu end*/
		});
	},
	/**
	 * 清除查询样式
	 * @param id dom元素id
	 */
	clearStyle:function(id,classname){
		$("#"+id).removeClass(classname);
	},
	/**
	 * 警情辖区内查询
	 */
	xqSearch:function(name,field){
		this.kjcxType="";
		this.queryType="xqSearch";
		this.clearStyle("visionSearch","bnt_syn_on");
		$("#fast_query_mode a").removeClass("btnab_onb");
		if(Jcxx.name.length==0){
			SysTool.alert("请选择需要查询的基础信息");
			return false;
		}
		$("#xqSearch").addClass("bnt_xqn_on");
		var nname=name||Jcxx.name;
		var nfield=field||Jcxx.field;
		var jqxx = Jqxx.currentPointObject[1];
		var xqdm="";
		var xqStr="";
		if(!$.isEmptyObject(jqxx)){
			 xqdm=jqxx["jqssdddm"];//警情所属大队代码
			 GeoQuery.getOrganizationBoundaryCoordinates(xqdm, function(boundaryCoordinates){//所属大队辖区边界值
				 xqStr=boundaryCoordinates;
				 if(xqStr!=""&& typeof xqStr!="undefined"){
					 var temp=xqStr.split(",");
					 xqStr=xqStr+","+temp[0]+","+temp[1];//使面坐标能闭合
					 Jcxx.xqSpatialQuery(nname,nfield,xqStr);
					 Jcxx.xqCoords=xqStr;//用于缩放监听
					}else{
						SysTool.alert("警情所属大队辖区边界未采集,无法对辖区进行查询");
						return false;
					}
				
			 });
			 Jcxx.clearCustomListener();
			 _MapApp.addMapEventListener(EzEvent.MAP_ZOOMEND, function() {
					Jcxx.xqSpatialQuery(Jcxx.name,Jcxx.field,Jcxx.xqCoords);
					
				});
		}

	},
	/**
	 * 辖区边界查询
	 * @param name 图层名
	 * @param field 图层关键字段
	 * @param xqstr 坐标范围
	 */
	xqSpatialQuery:function(name,field,xqstr){
		SysTool.loading.mask("pgis_map", "50%", "50%");
		
		var add=false;
		if(typeof name=="string"){
			this.clearOneLayerOverlay(name);
			add=true;
		}else{
			this.clearJcxxAllOverlays();
		}
		var str = xqstr;
		var extent = SysTool.getMapExtent(_MapApp);
		var width = SysTool.getMapWidth("pgis_map");
		var options = {
			tablename : name,
			layertype : SysConfig.LAYER_TYPE[0],
			coords : str,
			nameField : field,
			mapWidth : width,
			querytype : SysConfig.QUERY_TYPE[2],
			extent : extent
		};
		GeoQuery.spatialQuery(options, function(resultSet) {
			GeoQuery.dataProcess(resultSet,add);
			SysTool.loading.unmask();
		});
	},
	/**
	 * 辖区查询条件
	 * @param dm
	 * @returns {String}
	 */
	getDmWhere:function(dm){
		
		var where="";
		if(dm.indexOf("000000000")!=-1){
			return where;
		}else if(dm.indexOf("000000")!=-1){
			var newDm=dm.substr(0,dm.indexOf("000000"));
			where="GXDWDM like '%"+newDm+"%'";
			return where ;
		}else{
			where="GXDWDM ='"+dm+"'";
			return where;
		}
	},
	/**
	 * 清除资源图层
	 */
	clearJcxxAllOverlays:function(){
		for(var i=0;i<GeoQuery.allOverlays.length;i++){
			var overlays=GeoQuery.allOverlays[i];
			if($.isArray(overlays)){
				for(var j=0;j<overlays.length;j++){
					_MapApp.removeOverlay(overlays[j]);
				}
			}else{
				_MapApp.removeOverlay(overlays);
			}
		}
		if(_MapApp.map.vmlDraw!=null){
			_MapApp.removeOverlay(_MapApp.map.vmlDraw);
		};
		if(this.kjcxOverlay!=null){
			_MapApp.removeOverlay(this.kjcxOverlay);
			this.kjcxOverlay=null;
		}
		MapBubble.closeBubble();
		
	},
	/**
	 * 清除图层以及样式
	 */
	clear:function(){
		$("#layer_data_content").children(".btnzyon").removeClass("btnzyon");
		this.clearStyle("visionSearch","bnt_syn_on");
		this.clearStyle("xqSearch","bnt_xqn_on");
		$("#fast_query_mode a").removeClass("btnab_onb");
		this.clearJcxxAllOverlays();
		this.clearCustomListener();
		this.name=[];
		this.field=[];
		this.where=[];
		this.queryType="";
		MapBubble.closeBubble();
//		$("#fast_query_mode a").remove();
	},
	/**
	 * 清除监听
	 */
	clearCustomListener:function(){
		_MapApp.clearMapInstanceEventListeners("mappanend");
		//_MapApp.clearMapInstanceEventListeners("mapzoomend");
		MapBubble.clearMapZoomendEventListeners();
	},
	/**
	 * 初始化输入关键字的input控件
	 * @param {String} keywordInputId 输入关键字的input控件id
	 */
	initKeywordInput : function(keywordInputId) {
		$("#" + keywordInputId).val(this.gjz);
		this.bindingKeywordInputEvent(keywordInputId);
	},
	
	/**
	 * 绑定输入关键字的input控件的事件
	 * @param {String} keywordInputId 输入关键字的input控件id
	 */
	bindingKeywordInputEvent : function(keywordInputId) {
		$("#" + keywordInputId).blur(function() {
			if ($("#" + keywordInputId).val() == "") {
				$("#" + keywordInputId).css("color", "#999");
				$("#" + keywordInputId).val(Jcxx.gjz);
			}
		});
		$("#" + keywordInputId).focus(function() {
			if ($("#" + keywordInputId).val() == Jcxx.gjz && $("#" + keywordInputId).css("color") == "#999") {
				$("#" + keywordInputId).val("");
				$("#" + keywordInputId).css("color", "#000");
			}
		});
	},
	/**
	 * 警情快速周边查按钮生成
	 */
	jqxxFastQueryMode:function(){
			var mode=SysConfig.JQXX_FAST_QUERY["mode"];
			for(var i=0;i<mode.length;i++){
				$("#fast_query_mode").append("<a class='btnab btnab_disabled' id='fast_"+mode[i]+"' value='"+mode[i]+"' disabled=''  style='float:left;margin:9px' href='javascript:;' >周边"+mode[i]+"米</a>");

			};
			$("#fast_query_mode").children("a").each(function(){//绑定快速周边click事件
				$(this).click(function(){
					var that=this;
					if(Jcxx.name.length==0){
						SysTool.alert("请选择需要查询的基础信息");
						return false;
					}
					if($(that).hasClass("btnab_onb")){
						$(that).removeClass("btnab_onb");
						Jcxx.clearJcxxAllOverlays();
						Jcxx.clearCustomListener();
						return false;
					}else{
						$("#fast_query_mode a").removeClass("btnab_onb");
						$(that).addClass("btnab_onb");
						Jcxx.fastQuery($(that).attr("value"));
					}
					
					
				});
			});
//		}
		
		
	},
	/**
	 * 快速查询
	 * @param value
	 */
	fastQuery:function(value,name,field){
		var jqxx = Jqxx.currentPointObject[1];
		if($.isEmptyObject(jqxx)){
			SysTool.alert("请确定警情位置");
			return false;
		};
		var add=false;
		if(typeof name=="string"){
			this.clearOneLayerOverlay(name);
			add=true;
		}else{
			this.clearJcxxAllOverlays();
		}
		this.clearCustomListener();
		this.clearStyle("visionSearch","bnt_syn_on");
		this.clearStyle("xqSearch","bnt_xqn_on");
		$("#fast_query_mode a").removeClass("btnab_onb");
		$("#fast_"+value).addClass("btnab_onb");//加入样式
		this.queryType="#fast_"+value;//查询方式记录
		var nname=name||Jcxx.name;
		var nfield=field||Jcxx.field;
		var marker=Jqxx.currentPointObject[0];
		var degree = _MapApp.getDegree(marker.getPoint(), value);
		var strCoods=marker.getPoint()+","+degree;
		var extent = SysTool.getMapExtent(_MapApp);
		var width = SysTool.getMapWidth("pgis_map");
		var options = {
				tablename : nname,
				layertype : SysConfig.LAYER_TYPE[0],
				coords : strCoods,
				nameField : nfield,
				mapWidth : width,
				radius : degree,
				querytype : SysConfig.QUERY_TYPE[3],
				extent : extent
				
			};
			GeoQuery.aroundQuery(options, function(resultSet) {
				GeoQuery.dataProcess(resultSet,add);
			});
	},
	/**
	 * 显示或隐藏快速周边查询按钮
	 */
	showOrHideFastQuery:function(){
		var jqxx = Jqxx.currentPointObject[1];
		if(!$.isEmptyObject(jqxx)&&jqxx["jqzt"]!=1){
//			$("#fast_query_mode").show();
//			Jcxx.name = [];
//			Jcxx.field = [];
//			$(".btnzy").each(function(i){
//				var that=this;
//				for(var j=0;j<name.length;j++){
//					if(name[j].toUpperCase()==that.value.toUpperCase()){
//						$(that).addClass("btnzyon");
//						var tablename=name[j].toUpperCase();
//						if($.inArray(tablename,Jcxx.name)==-1){
//							Jcxx.name.push($(that).attr("value"));
//							Jcxx.field.push($(that).attr("value1"));
//						}
//						
//					}
//				};
//			});
			if(Jcxx.name.length==0){
				return false;
			}
			var initValue=SysConfig.JQXX_FAST_QUERY["init"];
			this.fastQuery(initValue);
			
			
		}
		
		
	},
	fastQueryRemove:function(){
		if($("#fast_query_mode").children("a").hasClass("btnab_onb")){
			$("#fast_query_mode a").remove();
			$("#layer_data_content").children(".btnzyon").removeClass("btnzyon");
			this.clear();
		}
		
	},
	/**
	 * 清除单个图层对象
	 * @param tablename
	 */
	clearOneLayerOverlay:function(tablename){
		for(var i=0;i<GeoQuery.eachOverlays.length;i++){
			var obj=GeoQuery.eachOverlays[i];
			if(typeof obj[tablename]!="undefined"){
				for (var j=0;j<obj[tablename].length;j++){
					var overlays=obj[tablename];
					_MapApp.removeOverlay(overlays[j]);
				};
				GeoQuery.eachOverlays.splice(i,1);
				break;
			}
		};
		if(this.kjcxType!=""){
			return;
		}else{
			if(this.kjcxOverlay!=null){
				_MapApp.removeOverlay(this.kjcxOverlay);
				this.kjcxOverlay=null;
			}
		}
		MapBubble.closeBubble();
	},
	/**
	 * 显示与警情相关的功能
	 */
	showJqfunc:function(){
		var jqxx = Jqxx.currentPointObject[1];
		if(!$.isEmptyObject(jqxx)){
			$("#xqSearch").removeAttr("disabled");//清除辖区内禁用样式
			$("#xqSearch").removeClass("bnt_xqn_disabled");
			$("#fast_query_mode").children("a").each(function(){//清空快速周边禁用样式
				$(this).removeAttr("disabled");
				$(this).removeClass("btnab_disabled");
			});
		}
	},
	/**
	 * 禁用于警情相关的功能
	 */
	disableFunc:function(){
		$("#xqSearch").attr("disabled","");
		$("#xqSearch").addClass("bnt_xqn_disabled");
		$("#fast_query_mode").children("a").each(function(){//添加快速周边禁用样式
			$(this).attr("disabled","");
			$(this).addClass("btnab_disabled");
		});
		this.clear();
	},
	/**
	 * 过往车辆查询
	 */
	kkclcx : function(){
		var kkid = "";
		var kkmc = "";
		$.each(GeoQuery.marker_info,function(key,value){
			if ("ID" == GeoQuery.marker_info[key].fieldName)
			{
				kkid = GeoQuery.marker_info[key].fieldValue;
			}
			else if ("名称" == GeoQuery.marker_info[key].fieldName)
			{
				kkmc = GeoQuery.marker_info[key].fieldValue;
			}
		});
		SysTool.window.open({
			width : 600,
			height: 480,
			title : kkmc,
			url : 'project/busiapp/kkcl/kkcl.jsp?id="'+kkid
		});
	},
	
	/**
	 * 播放视频
	 * @param objectId
	 */
	playVideo: function(objectId) {
		var videoBh = "";
		$.each(GeoQuery.marker_info, function(key, value) {
			if (SysConfig.VIDEO_TD_FIELD == GeoQuery.marker_info[key].fieldName) {
				videoBh = GeoQuery.marker_info[key].fieldValue;
				return false;
			}
		});
		var width = 850;   
		var height = 480;
		var sFeatures = "width=" + width + ",height=" + height + ",left=" + ((screen.availWidth - width) / 2) + ",top=" + ((screen.availHeight - height) / 2)
				        + ",location=no,menubar=no,resizable=yes,scrollbars=no,status=no,titlebar=no,toolbar=no";
		var url = "common/components/video/playVideo.jsp?multiVideoInfo=" + videoBh;  
		window.open(url, "openWin", sFeatures);
	}
	
};

