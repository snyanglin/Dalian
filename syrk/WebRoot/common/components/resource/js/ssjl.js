
var Ssjl={
		/**
		 * 监控对象数组[{gpsid:"",data:"",marker:"",pLine:"",strCoods:"",lsgj:{}}]
		 * gpsid:gps编号,data:每个marker的数据 {Object},marker:marker对象,pLine:轨迹线对象，strCoods:轨迹字符串，lsgs:历史轨迹的数据对象{Object},ztid:gps的状态id(statusid)
		 */
		jk_objArray:[],
		/**
		 * 储存警力统计后的数据包括，数量以及gpsid {car:{kx:{value:2,ids:"101,102"}},police:{cj:{value:1,ids:"103"}}}
		 */
		data:{},
		/**
		 * 为判断某状态的警力信号增加的变量，记录上一次的警力id
		 */
		oldids:"",
		/**
		 * 存储点击历史轨迹的gpsid [101,102]
		 */
		lsgjIds:[],
		/**
		 * 历史轨迹时间
		 */
		lsgjTime:"5",
		/**
		 * 主监控gpsid "101"
		 */
		zjkid:"",
		
		zjksbid : "",
		
		/**
		 * 实时消息接收的timer
		 */
		//ssxxTimer:null,
		/**
		 * 统计timer
		 */
		//sstjTimer:null,
		/**
		 * 所统计的组织机构代码
		 */
		tjzzjgdm:"",
		/**
		 * 关键字
		 */
		gjz:"警员姓名/车牌号/呼号",
		/**
		 * 点击类型
		 */
		selectedType:"",
		/**
		 * 点击状态
		 */
		selectedStatus:"",
		/**
		 * gps警力图片
		 */
//		gps_img:{car:{kx:"common/components/resource/images/gpsimage/cl_kx.png",
//					  cj:"common/components/resource/images/gpsimage/cl_cj.png",
//					  cz:"common/components/resource/images/gpsimage/cl_cz.png"
//				 },
//			     police:{kx:"common/components/resource/images/gpsimage/dh_kx.png",
//			    	       cj:"common/components/resource/images/gpsimage/dh_cj.png",
//			    	       cz:"common/components/resource/images/gpsimage/dh_cz.png"
//			     },
//			     terminal:{kx:"common/components/resource/images/gpsimage/ydd_kx.png",
//			    	       cj:"common/components/resource/images/gpsimage/ydd_cj.png",
//			    	       cz:"common/components/resource/images/gpsimage/ydd_cz.png"
//			     }
//		},
		gps_img:{car:{kx:"common/components/resource/images/gpsimage/cl_kx.png",
			        chj:"common/components/resource/images/gpsimage/cl_cj.png"
		 },
	     police:{kx:"common/components/resource/images/gpsimage/djj_kx.png",
	    	       chj:"common/components/resource/images/gpsimage/djj_cj.png"
	     },
	     telephone:{kx:"common/components/resource/images/gpsimage/ydd_kx.png",
  	       chj:"common/components/resource/images/gpsimage/ydd_cj.png"
	     },
	     terminal:{kx:"common/components/resource/images/gpsimage/ydd_kx.png",
	    	       chj:"common/components/resource/images/gpsimage/ydd_cj.png"
	     }
		},
		/**
		 *  警力圈周边查询的gpsid
		 */
		zbgpsArray:[],
		/**
		 * 警力圈周边查询gps对象
		 */
		zbGpsobjArray:[],
		/**
		 * 实时警力页面查询后加入地图的gpsid
		 */
		ssjlGpsidArray:[],
		/**
		 * 实时警力查询的gps对象
		 */
		ssjlGpsobjArray:[],
		/**
		 * 空间查询的overlay
		 */
		gpspOverlay:null,
		/**
		 * 缩放等级
		 */
		zoomLevel:14,
		/**
		 * 实时查询请求的gpsid
		 */
		ssjlRequestGpsid:[],
		/**
		 * 图上派警时使用
		 */
		clickJlData:{},
		/**
		 * 警力类型
		 */
		jllxArray : [],
		/**
		 * 根据登录组织机构代码开启实时统计
		 * @param zzjgdm
		 */
		startSstj:function(zzjgdm){
			Ssjl.stopSstj();
			ProtectedTimer.sstjTimer=setInterval(function(){
				Ssjl.ssjltj(Ssjl.tjzzjgdm);
			}, SysConfig.SSTJ_TIMER);
		},
		/**
		 * 停止警力统计
		 */
		stopSstj:function(){
			window.clearInterval(ProtectedTimer.sstjTimer);
			ProtectedTimer.sstjTimer = null;
		},
		/**
		 * 根据登录的组织机构代码初始gps树
		 * @param zzjgdm
		 */
		initTree:function(zzjgdm){
			Dictionary.initDictTree({url: "dictionary/getGpsDictTreeJSON.f", zdbh: "T_GPS_ZZJG", zdmc: "警力分组", zzjgdm: zzjgdm, dictDataDivId: "ssjl_gpszzjg_data_Div"}, function() {
				Dictionary.beforeCreateDictTree({createCount: 1, zdbh: "T_GPS_ZZJG", treeData: data_T_GPS_ZZJG, dictDataDivId: "ssjl_gpszzjg_data_Div"});
				Dictionary.createDictTree({dictObject: T_GPS_ZZJG, treeData: data_T_GPS_ZZJG_1, isLeaf: false, dictHiddenId: "ssjl_gpszzjg_dm", dictShowId: "ssjl_gpszzjg_mc",initVal: zzjgdm,"dictContainerReferenceObjectId": "ssjl_zzjg"});
			});
			Ssjl.closeJlfzFunc();
		},
		/**
		 * 选择树触发的事件
		 */
		fireZzjgdmFunc:function(){
			for(var i=0;i<Ssjl.ssjlGpsobjArray.length;i++){
				_MapApp.removeOverlay(Ssjl.ssjlGpsobjArray[i]["marker"]);
			}
			$(".a_on").removeClass("a_on");
			Ssjl.ssjlGpsobjArray=[];//选择树后清空监控对象
			Ssjl.lsgjIds=[];//清空显示历史轨迹的gpsid
			Ssjl.zjkid="";//清空主监控
			Ssjl.tjzzjgdm=$("#ssjl_gpszzjg_dm").val() ;
			SysTool.loading.mask("reason", "30%", "50%");//添加遮罩
			
		},
		/**
		 * 关闭警力分组弹窗
		 */
		closeJlfzFunc:function(){
			
			$("#reason div").click(function(e){
				if(($(this).attr("id")!="ssjl_zzjg")&&($(this).attr("id")!="ssjl_gpszzjg_mc")){
					if($("#ssjl_gpszzjg_mcDiv").css("display")=="block"){
							$("#ssjl_gpszzjg_mcDiv").hide();
							return false;
					}
				}
				
				
			});
		},
		/**
		 * 实时警力根据登录组织机构代码初始化页面
		 * @param id
		 */
		init:function(id){
			Ssjl.tjzzjgdm=id;
			Ssjl.initTree(id);
			Ssjl.getSsjllx(function() {
				Ssjl.ssjltj(id);
				Ssjl.bindFunction();
			});
			Ssjl.startSstj(id);
			Ssjl.initKeywordInput("search");
			Dictionary.initDictionaryList({url: "dictionary/getDictionaryListJSON.f", data: {"zdbh": "D_ZBJL"}, dictShowId: "ssjl_distance", initVal: "1",dictContainerReferenceObjectId: "ssjl_zb"}, function() {
			});
			Dictionary.initDictionaryList({url: "dictionary/getDictionaryListJSON.f", data: {"zdbh": "D_GJSJ"}, dictShowId: "timeInterval", dictContainerReferenceObjectId: "ssjl_sjgj", initVal: "1"}, function() {
				Ssjl.lsgjTime=$("#timeInterval").val();
				
//				if(Ssjl.lsgjIds.length!=0){
//					Ssjl.lsgj(Ssjl.lsgjIds, true);
//				}
			});
			SysTool.changeIputStyle();
			this.showOrHideXqnw();
		},
		/**
		 * 实时警力统计
		 * @param id 所选组织机构分组id
		 */
		
//		ssjltj:function(id){
//			SysTool.ajax({
//			url : 'ssjl/getCount.f',
//			data : {
//				'fzid' : id
//			}
//		}, function(data) {
//			if (data.data == 0) {
//				return false;
//			}
//			Ssjl.data=data;
//			var type = "";
//			var all = {};
//			for ( var k = 0; k < $("#jl_tj dd").length; k++) {
//				switch (k) {
//				case 0:
//					type = "car";
//					break;
//				case 1:
//					type = "police";
//					break;
//				case 2:
//					type = "terminal";
//					break;
//				case 3:
//					all["kx"] = ( typeof (data["car"]["kx"])=="undefined"? 0:(data["car"]["kx"]["value"]))
//							+ (typeof (data["police"]["kx"])=="undefined"?0:(data["police"]["kx"]["value"]))
//							+ (typeof(data["terminal"]["kx"])=="undefined"?0:(data["terminal"]["kx"]["value"]));
//					all["cj"] = (typeof (data["car"]["cj"])=="undefined"?0:data["car"]["cj"]["value"])
//							+ (typeof (data["police"]["cj"])=="undefined"?0:data["police"]["cj"]["value"])
//							+ (typeof (data["terminal"]["cj"])=="undefined"?0:data["terminal"]["cj"]["value"]);
//					all["cz"] = (typeof(data["car"]["cz"])=="undefined"?0:data["car"]["cz"]["value"])
//							+ (typeof (data["police"]["cz"])=="undefined"?0:data["police"]["cz"]["value"])
//							+ (typeof (data["terminal"]["cz"])=="undefined"?0:data["terminal"]["cz"]["value"]);
//					
//				}
//				if (k < $("#jl_tj dd").length - 1) {
//					$("#jl_tj dd:eq(" + k + ") a").each(function(i) {//存入各种类型警力的数量
//						switch (i) {
//						case 0:
//							$(this).attr({
//								status : "kx",
//								type : type
//							});
//							$(this).text(typeof (data[type]["kx"])=="undefined"? 0:(data[type]["kx"]["value"]));
//							break;
//						case 1:
//							$(this).attr({
//								status : "cj",
//								type : type
//							});
//							$(this).text(typeof(data[type]["cj"])=="undefined"? 0:(data[type]["cj"]["value"]));
//							
//							break;
//						case 2:
//							$(this).attr({
//								status : "cz",
//								type : type
//							});
//							$(this).text(typeof (data[type]["cz"])=="undefined"? 0:(data[type]["cz"]["value"]));
//							break;
//						}
//					});
//				} else {
//					$("#jl_tj dd:eq(" + k + ") a").each(function(i) {//存入全部的值
//						switch (i) {
//						case 0:
//							$(this).attr({
//								status : "kx",
//								type : "all"
//							});
//							$(this).text(all["kx"]);
//							break;
//						case 1:
//							$(this).attr({
//								status : "cj",
//								type : "all"
//							});
//							$(this).text(all["cj"]);
//							break;
//						case 2:
//							$(this).attr({
//								status : "cz",
//								type : "all"
//							});
//							$(this).text(all["cz"]);
//							break;
//						}
//					});
//				}
//			}
//
//		});
//	},
	/**
	 * 获取实时警力类型
	 * @param {Function} callback 回调函数
	 */
	getSsjllx : function(callback) {
		SysTool.ajax({
			url : 'ssjl/queryJllx.f',
			data : {}
		}, function(data) {
			if ("undefined" != typeof data.list && data.list != null) {
				Ssjl.jllxArray = data.list;
			} else {
				Ssjl.jllxArray = [];
			}
			callback();
		});
	},
	
	ssjltj:function(id){
		if (Ssjl.jllxArray.length > 0) {
			if ($("#jl_tj dd").size() == 0) {
				var jllxHtmlStr = "";
				for (var i = 0; i < Ssjl.jllxArray.length; i++) {
					if (Ssjl.jllxArray[i] == "car") {
						jllxHtmlStr += '<dd type="car"><span>警车</span><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a></dd>';
					} else if (Ssjl.jllxArray[i] == "police") {
						jllxHtmlStr += '<dd type="police"><span>GPS对讲机</span><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a></dd>';
					} else if (Ssjl.jllxArray[i] == "telephone") {
						jllxHtmlStr += '<dd type="telephone"><span>警务通</span><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a></dd>';
					} else if (Ssjl.jllxArray[i] == "terminal") {
						jllxHtmlStr += '<dd type="terminal"><span>350M</span><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a></dd>';
					}
					
					if (i == Ssjl.jllxArray.length - 1) {
						jllxHtmlStr += '<dd type="all"><span>全部</span><a href="javascript:void(0)">0</a><a href="javascript:void(0)">0</a></dd>';
					}
				}
				$("#jl_tj").append(jllxHtmlStr);
			}
			
			SysTool.ajax({
				url : 'ssjl/getCount.f',
				data : {
					'fzid' : id
				}
			}, function(data) {
				if (data.data == 0) {
					return false;
				}
				Ssjl.data=data;
				var type = "";
				var all = {};
				$("#jl_tj dd").each(function(k) {
					switch ($(this).attr("type")) {
					case "car":
						type = "car";
						break;
					case "police":
						type = "police";
						break;
					case "telephone":
						type = "telephone";
						break;
					case "terminal":
						type = "terminal";
						break;
					case "all":
						var kxCount = 0;
						var chjCount = 0;
						for (var i = 0; i < Ssjl.jllxArray.length; i++) {
							kxCount = kxCount + (typeof (data[Ssjl.jllxArray[i]]["kx"])=="undefined"? 0:(data[Ssjl.jllxArray[i]]["kx"]["value"]));
							chjCount = chjCount + (typeof (data[Ssjl.jllxArray[i]]["chj"])=="undefined"?0:data[Ssjl.jllxArray[i]]["chj"]["value"]);
						}
						all["kx"] = kxCount;
						all["chj"] = chjCount;
					}
					if (k < $("#jl_tj dd").length - 1) {
						$("#jl_tj dd:eq(" + k + ") a").each(function(i) {//存入各种类型警力的数量
							switch (i) {
							case 0:
								$(this).attr({
									status : "kx",
									type : type
								});
								$(this).text(typeof (data[type]["kx"])=="undefined"? 0:(data[type]["kx"]["value"]));
								break;
							case 1:
								$(this).attr({
									status : "chj",
									type : type
								});
								$(this).text(typeof(data[type]["chj"])=="undefined"? 0:(data[type]["chj"]["value"]));
								
								break;
							}
						});
					} else {
						$("#jl_tj dd:eq(" + k + ") a").each(function(i) {//存入全部的值
							switch (i) {
							case 0:
								$(this).attr({
									status : "kx",
									type : "all"
								});
								$(this).text(all["kx"]);
								break;
							case 1:
								$(this).attr({
									status : "chj",
									type : "all"
								});
								$(this).text(all["chj"]);
								break;
							}
						});
					}
				});
				SysTool.loading.unmask();//去掉遮罩
			});
		}
	},
	/**
	 * 警力统计表中的a标签绑定单击事件
	 */
	bindFunction:function(){
		for(var i=0;i<$("#jl_tj dd a").length;i++){
			$("#jl_tj dd a:eq("+i+")").bind("click",function(){
				if($(this).text()!=0){
					if(!$("#jl_tj dd a").hasClass("a_on")){//点击样式判断
						$(this).addClass("a_on");
						Ssjl.jlSearch(this);
					}else{
						if($(this).hasClass("a_on")){
							$(this).removeClass("a_on");
								Ssjl.clearSsjlMarker();
						}else{
							$(".a_on").removeClass("a_on");
							$(this).addClass("a_on");
							Ssjl.jlSearch(this);
						}
					}
					
				} 
			});
		}
	},
	/**
	 * 单击数字响应事件
	 * @param obj 对象
	 */
	jlSearch:function(obj){
//		_MapApp.clear();
//		Ssjl.clearSsjlMarker();
		//_MapApp.clearMapEventListeners();
		//_MapApp.removeMapEventListener("mapzoomend");
		var type=obj.type;
		var status=obj.status;
		Ssjl.jlQuery(type,status);
	},
	/**
	 * 警力属性查询
	 * @param type 警力类型
	 * @param status 状态
	 */
	jlQuery:function(type, status,where){
		/*yichu begin*/
		SysTool.loading.mask("pgis_map", "50%", "50%");
		/*yichu end*/
		this.clearSsjlMarker();
		var extent = SysTool.getMapExtent(_MapApp);
		var width = SysTool.getMapWidth("pgis_map");
		var nwhere = typeof where=="undefined" ? Ssjl.getWhere(type,status):Ssjl.getWhere(type,status)+where;
		var options = {
			tablename:"gpsstatus",
			layertype : SysConfig.LAYER_TYPE[0],
			nameField : "gpsid",
			mapWidth : width,
			x : "X",
			y : "Y",
			iscluster : false,
			querytype : SysConfig.QUERY_TYPE[6],
			extent : extent,
			subFields:"callno:callno,carno:carno,policeid:policeid,policename:policename,orgname:orgname,speed:speed,dir:dir,jllx:jllx,statusid:statusid,ywbh:ywbh",
			where : nwhere
		};
//		_MapApp.clearMapInstanceEventListeners("mapzoomend");
		GeoQuery.attributeQuery(options, function(resultSet) {
			Ssjl.doJlReasult(resultSet,type,status);
			ScrollBarTool.init("scroll_main_ssjl", "scroll_content_ssjl",0, true);
			/*yichu begin*/
			SysTool.loading.unmask();
			/*yichu end*/
		});
	},
	/**
	 * 获取属性条件
	 * @param type
	 * @returns {String}
	 */
//	getWhere:function (type,status){
//		var where = "";
//		if($("#ssjl_gpszzjg_dm").val()!=""){
//			var zzjgdm=$("#ssjl_gpszzjg_dm").val();
//			where+="path like '%"+zzjgdm+"%' ";
//		}
//		if(where!=""){
//			where +=" and ";
//		}
//		switch (type) {
//		case "car":
//			if(status=="kx"){
//				where += " jllx='car' and statusid=850 ";
//			}else if(status=="cj"){
//				where += " jllx='car' and statusid=900 ";
//			}else if(status=="cz"){
//				where += " jllx='car' and statusid=950 ";
//			}else{
//				where +=" jllx='car' ";
//			}
//			break;
//		case "police":
//			if(status=="kx"){
//				where += " jllx='police' and statusid=850 ";
//			}else if(status=="cj"){
//				where += " jllx='police' and statusid=900 ";
//			}else if(status=="cz"){
//				where += " jllx='police' and statusid=950 ";
//			}else{
//				where +=" jllx='police' ";
//			}
//			break;
//		case "terminal":
//			if(status=="kx"){
//				where += " jllx='terminal' and statusid=850 ";
//			}else if(status=="cj"){
//				where += " jllx='terminal' and statusid=900 ";
//			}else if(status=="cz"){
//				where += " jllx='terminal' and statusid=950 ";
//			}else{
//				where +=" jllx='terminal' ";
//			}
//			break;
//		case "all":
//			if(status=="kx"){
//				where += " statusid=850";
//			}else if(status=="cj"){
//				where += " statusid=900 ";
//			}else if(status=="cz"){
//				where += " statusid=900";
//			}else{
//				where += "statusid!=000";
//			}	
//			break;
//		}
//		return where;
//		
//	},
	getWhere:function (type,status){
		var where = "";
		if($("#ssjl_gpszzjg_dm").val()!=""){
			var zzjgdm=$("#ssjl_gpszzjg_dm").val();
			where+="path like '%"+zzjgdm+"%' ";
		}
		if(where!=""){
			where +=" and ";
		}
		switch (type) {
		case "car":
			if(status=="kx"){
				where += " jllx='car' and statusid=850 ";
			}else if(status=="chj"){
				where += " jllx='car' and statusid=980 ";
			}else{
				where +=" jllx='car' ";
			}
			break;
		case "police":
			if(status=="kx"){
				where += " jllx='police' and statusid=850 ";
			}else if(status=="chj"){
				where += " jllx='police' and statusid=980 ";
			}else{
				where +=" jllx='police' ";
			}
			break;
		case "telephone":
			if(status=="kx"){
				where += " jllx='telephone' and statusid=850 ";
			}else if(status=="chj"){
				where += " jllx='telephone' and statusid=980 ";
			}else{
				where +=" jllx='telephone' ";
			}
			break;
		case "terminal":
			if(status=="kx"){
				where += " jllx='terminal' and statusid=850 ";
			}else if(status=="chj"){
				where += " jllx='terminal' and statusid=980 ";
			}else{
				where +=" jllx='terminal' ";
			}
			break;
		case "all":
			if(status=="kx"){
				where += " statusid=850";
			}else if(status=="chj"){
				where += " statusid=980 ";
			}else{
				where += "statusid!=000";
			}	
			break;
		}
		return where;
		
	},
	/**
	 * 空间查询
	 * @param type
	 */
	jlSpatialquery:function (type){
		$("#ssjl_dataInputx").val("");
		$("#ssjl_dataInputy").val("");
		if ($("#jl_tj dd").children().hasClass('a_on')) {
			var status = $('.a_on').attr("status");
			var jltype = $('.a_on').attr("type");
			var where = Ssjl.getWhere(jltype, status);
			_MapApp.changeDragMode(type, ssjl_dataInputx, ssjl_dataInputy, function() {
				Ssjl.callback(type, where,jltype,status);
			});
		} else {
			var status="all";
			var jltype="all";
			var where = Ssjl.getWhere(jltype, status);
			_MapApp.changeDragMode(type, ssjl_dataInputx, ssjl_dataInputy, function() {
				 Ssjl.callback(type, where,jltype,status);
			});
		}
		
	},
	/**
	 * 空间查询的回调
	 * @param type 查询类型
	 * @param where 条件
	 */
	callback:function (type,where,jltype,status){
		/*yichu begin*/
		SysTool.loading.mask("pgis_map", "50%", "50%");
		/*yichu end*/
//		Ssjl.stopSsxx();
//		_MapApp.clear();
//		Ssjl.clearSsjlMarker();
		this.clearSsjlMarker();
		var str = $("#ssjl_dataInputx").val();
		var extent = SysTool.getMapExtent(_MapApp);
		var width = SysTool.getMapWidth("pgis_map");
		var qType = "";
		var pOverlay=null;
		switch (type) {
		case "drawRect":
			qType = SysConfig.QUERY_TYPE[0];
			pOverlay = new Rectangle(str, "#9edafa", 1, 0.6, "#9edafa");
			break;
		case "drawCircle":
			qType = SysConfig.QUERY_TYPE[1];
			pOverlay = new Circle(str, "#9edafa", 1, 0.6, "#9edafa");
			break;
		case "drawPolygon":
			qType = SysConfig.QUERY_TYPE[2];
			pOverlay = new Polygon(str, "#9edafa", 1, 0.6, "#9edafa");
		}
		var options = {
			tablename : "gpsstatus",
			layertype : SysConfig.LAYER_TYPE[0],
			coords : str,
			nameField : "gpsid",
			mapWidth : width,
			where : where,
			querytype : qType,
			extent : extent,
			x : "x",
			y : "y",
			iscluster : false,
			subFields:"callno:callno,carno:carno,uim:uim,policeid:policeid,policename:policename,orgname:orgname,speed:speed,dir:dir,jllx:jllx,statusid:statusid,ywbh:ywbh"

		};
		
		_MapApp.addOverlay(pOverlay);
		Ssjl.gpspOverlay=pOverlay;
		GeoQuery.spatialQuery(options, function(resultSet) {
			Ssjl.doJlReasult(resultSet,jltype,status);
			/*yichu begin*/
			SysTool.loading.unmask();
			/*yichu end*/
		});
	},
	/**
	 * 周边查询
	 * @param type 查询类型
	 */
	jlAroundQuery:function (type){
		//_MapApp.clearMapEventListeners();
//		_MapApp.removeMapEventListener("mapzoomend");
		if ($("#jl_tj dd").children().hasClass('a_on')) {
			var status = $('.a_on').attr("status");
			var jltype = $('.a_on').attr("type");
			var where = Ssjl.getWhere(jltype, status);
			_MapApp.changeDragMode(type, ssjl_dataInputx, ssjl_dataInputy, function() {
				Ssjl.callback1(type, where,jltype,status);
			});
		} else {
			var status="all";
			var jltype="all";
			var where = Ssjl.getWhere(jltype, status);
			_MapApp.changeDragMode(type, ssjl_dataInputx, ssjl_dataInputy, function() {
				Ssjl.callback1(type, where,jltype,status);
			});
		} 
	},

	/**
	 * 周边查询回调
	 * @param type 查询类型
	 * @param where 条件
	 */
	callback1:function (type,where,jltype,status){
		/*yichu begin*/
		SysTool.loading.mask("pgis_map", "50%", "50%");
		/*yichu end*/
//		_MapApp.clear();
//		Ssjl.clearSsjlMarker();
		this.clearSsjlMarker();
		var extent=SysTool.getMapExtent(_MapApp);
		var width=SysTool.getMapWidth("pgis_map");
		var bound=_MapApp.getBoundsLatLng();
		var distance=$("#ssjl_distance").val();
		var degree=_MapApp.getDegree(new Point(bound.minX+","+bound.minY),distance);
		var qType="";
		var strCoods="";
		var pOverlay=null;
		switch(type){
				case "drawPoint":
					qType=SysConfig.QUERY_TYPE[3];
					strCoods=$("#ssjl_dataInputx").val()+","+$("#ssjl_dataInputy").val()+","+degree;
					pOverlay = new Circle(strCoods, "#9edafa",2,0.6, "#9edafa");
					break;
				case "drawPolyline":
					qType=SysConfig.QUERY_TYPE[4];
					strCoods=$("#ssjl_dataInputx").val();
					pOverlay = new Polyline(strCoods, "#9edafa", degree*2, 0.6, 0);
					pOverlay.unit = "degree";
					pOverlay.setColor("#9edafa");
					break;
				case "drawPolygon": 
					qType=SysConfig.QUERY_TYPE[5];
					strCoods=$("#ssjl_dataInputx").val();
					pOverlay = new Polyline(strCoods, "#9edafa", degree*2, 0.6,0);
					pOverlay.unit = "degree";
					pOverlay.setColor( "#9edafa");
					break;
			}
			_MapApp.addOverlay(pOverlay);
			Ssjl.gpspOverlay=pOverlay;
			//组装查询的options
		var options={
					tablename:"gpsstatus",
					layertype:SysConfig.LAYER_TYPE[0],
					coords:strCoods,
					nameField:"gpsid",
					mapWidth:width,
					radius:degree,
					querytype:qType,
					extent:extent,
					where:where,
					subFields:"callno:callno,carno:carno,uim:uim,policeid:policeid,policename:policename,orgname:orgname,speed:speed,dir:dir,jllx:jllx,statusid:statusid,ywbh:ywbh",
					x:"x",
					y:"y",
					iscluster : false
				};
			GeoQuery.aroundQuery(options, function(resultSet){
				Ssjl.doJlReasult(resultSet,jltype,status);
				/*yichu begin*/
				SysTool.loading.unmask();
				/*yichu end*/
			});
		},
		/**
		 * 
		 * 警力关键值查询
		 */
		jlKeySearch:function (){
//			_MapApp.clear();
//			Ssjl.clearSsjlMarker();
			this.clearSsjlMarker();
			var value=$("#search").val();
			var status="";
			var type="";
			var nwhere;
			if(!($("#jl_tj dd").children().hasClass('a_on'))){
				status = "all";
				type = "all";
				var  where = Ssjl.getWhere(type, status);
				nwhere="and ("+where+") and (policename like '%"+value+"%' or callno like '%"+value+"%' or carno like '%"+value+"%')";//关键字待配置
				Ssjl.jlQuery(type,status,nwhere);
			}else{
				status = $('.a_on').attr("status");
				type = $('.a_on').attr("type");
				var  where = Ssjl.getWhere(type, status);
				nwhere="and ("+where+") and (policename like '%"+value+"%' or callno like '%"+value+"%' or carno like '%"+value+"%')";//关键字待配置
				Ssjl.jlQuery(type,status,nwhere);
			}
			
		},
		/**
		 * 气泡框内容
		 * @returns {String}
		 */
		bubbleBox:function(){
			
				var msg = "";
				msg += "<div id='ssjl_gps' value='' class='tips_top'><div class='tips_title'><strong style='padding:0 10px;'>警力</strong></div></div>";
				msg += "<div class='tips_jlct'><div class='tipsjili'>警员姓名：<span style='color:#000' id='name'></span></div><div class='tipsjili'>所属分组：<span style='color:#000' id='orgname' title=''></span></div>";
				msg += "<div class='tipsjili'>车牌号码：<span style='color:#000' id='carno'></span></div><div class='tipsjili'>警力呼号：<span style='color:#000' id='callno'></span></div>";
				msg += "<div class='tipsjili'>车辆速度：<span style='color:#000' id='speed'></span>km/h</div><div class='tipsjili'>车辆方向：<span style='color:#000' id='direction'></span></div>";
				msg += "<div class='tipsjili'>警情数量：<span style='color:#000' id='ssjl_jqsl'>0</span>条</div>";
				msg += "<div class='bubllebtn'><a id='zjk' href='javascript:void(0);' class='btn_tipsdw'>主监控</a>";
				msg += "<a id='lsgj' href='javascript:void(0);' class='btn_tipsdw_s'>轨迹</a>";
				msg += "<a class='btn_tipsdw_s btn_tipsdwnot_s'>呼叫</a>";
				msg += "<a class='btn_tipsdw_s' href='javascript:Ssjl.jlczFunc(0)' id='gps_jlcz'>派警</a>";
				msg += "<a class='btn_tipsdw_s' href='javascript:Ssjl.jlczFunc(1)' id='gps_jlzy'>增援</a>";
				msg += "<a class='btn_tipsdw_s' href='javascript:Ssjl.jlczFunc(2)' id='gps_jlgp'>改派</a>";
				msg +=	"<div class='clear'></div></div>";
				return msg;
			
		},
		/**
		 * 图上派警
		 */
		jlczFunc:function(mark){
			var policeid=Ssjl.clickJlData["POLICEID"]||Ssjl.clickJlData["policeid"];
			var policename=Ssjl.clickJlData["POLICENAME"]||Ssjl.clickJlData["policename"];
			var gpsid=Ssjl.clickJlData["GPSID"]||Ssjl.clickJlData["gpsid"];
			var callno=Ssjl.clickJlData["CALLNO"]||Ssjl.clickJlData["callno"];
			var param={jybh:policeid,jymc:policename,gpsid:gpsid,callno:callno,mark:mark,jqxx:Jqxx.currentPointObject[1]};
			Jqcz.jqczTspj(param);
		},
		/**
		 * 警情周边警力查询入口
		 * @param resultSet
		 * @param type
		 * @param status
		 * @returns {Boolean}
		 */
		zbJlReasult:function(resultSet,type,status){
//			var oldids=Ssjl.oldids;
			for ( var i = 0; i < resultSet.length; i++) {
				var sResult = eval("(" + resultSet[i].result + ")");
				if (sResult.count == 0) {
					return false;
				} else {
					var addGpsList=[];
					var  returnMarkerArray=[];
					var jsonlist = eval("(" + sResult.jsonlist + ")");

					for(var m=0;m<jsonlist.length;m++){
						var gpsid=jsonlist[m]["GPSID"];
						var index=$.inArray(gpsid,Ssjl.ssjlGpsidArray);
						if(index==-1){
							addGpsList.push(jsonlist[m]);
//							Ssjl.ssjlGpsidArray.push(gpsid);
						}
						
					}
					//警力上图
					if(addGpsList.length==0){//判断查询周边警力的gpsid是否已经存在
						 returnMarkerArray = this.createMarker({type : type, status : status}, jsonlist, function(){});
					}else{
						returnMarkerArray = this.createMarker({type : type, status : status}, addGpsList, function(){});
					}
					
					//警力列表
					for ( var j = 0; j < jsonlist.length; j++) {
						var jk_obj={};
						Ssjl.zbgpsArray.push(jsonlist[j].GPSID);
						jk_obj["gpsid"]=jsonlist[j].GPSID;//监控对象gpsid
						jk_obj["marker"]=returnMarkerArray[j];//监控对象marker
						jk_obj["ztid"]=jsonlist[j].STATUSID;
//						Ssjl.jk_objArray.push(jk_obj);
						var has=false;
						for(var m=0;m<Ssjl.ssjlGpsidArray.length;m++){
							if(jsonlist[j].GPSID===Ssjl.ssjlGpsidArray[m]["gpsid"]){
								has=true;
							}
						}
						if(!has){
							Ssjl.zbGpsobjArray.push(jk_obj);
							Ssjl.jk_objArray.push(jk_obj);
						}
						
					}
				}
			}
			Ssjl.startSsxx();
		},
		/**
		 * 警力查询结果集处理
		 * @param resultSet
		 */
		doJlReasult:function (resultSet,type,status) {
			if($("#jl_tj dd").children().hasClass('a_on')){//点击统计数字进入
				Ssjl.oldids=Ssjl.selectedIds();
			}
//			var oldids=Ssjl.oldids;
			$("#reason").css("display", "none");
			$("#resultdiv").css("display", "block");
			$("#results").html("");
			$("#result_count").html("");
			for ( var i = 0; i < resultSet.length; i++) {
				var sResult = eval("(" + resultSet[i].result + ")");
				if (sResult.count == 0) {
					$("#result_count").append("<span>共有<span class='spancolor' id='ssjl_result_count'>0</span>条</span>");
					return false;
				} else {
					var addGpsList=[];
					var jsonlist = eval("(" + sResult.jsonlist + ")");
					var allcount=sResult.count;
					$("#result_count").append("<span>共有<span class='spancolor' id='ssjl_result_count'>"+allcount+"</span>条</span>");
					//警力上图
					var returnMarkerArray=[];
					if(Ssjl.zbgpsArray.length==0){//判断是否有警力圈周边警力
						 returnMarkerArray = this.createMarker({type : type, status : status}, jsonlist, function(){
						});
						 for(var j = 0; j < jsonlist.length; j++){
							 Ssjl.ssjlRequestGpsid.push(jsonlist[j].GPSID);
						 }
					}else{
						for(var j = 0; j < jsonlist.length; j++){
							var gpsid=jsonlist[j].GPSID;
							var index=$.inArray(gpsid,Ssjl.zbgpsArray);
							if(index==-1){
								addGpsList.push(jsonlist[j]);
								Ssjl.ssjlRequestGpsid.push(jsonlist[j].GPSID);
//								Ssjl.ssjlGpsidArray.push(gpsid);
							}
						}
						returnMarkerArray = this.createMarker({type : type, status : status}, addGpsList, function(){
						});
					}
					//警力列表
					for ( var j = 0; j < jsonlist.length; j++) {
						var jk_obj={};
						jk_obj["gpsid"]=jsonlist[j].GPSID;//监控对象gpsid
						jk_obj["ztid"]=jsonlist[j].STATUSID;
						$("#results").append(
								"<a href='javascript:Ssjl.clickFunc(\""+jsonlist[j].GPSID+"\")' id='"+jsonlist[j].GPSID+"'>" + "<span class='span1'>" + (jsonlist[j].POLICENAME||"空") + "</span>"
										+ "<span class='span2'>" + (jsonlist[j].CARNO||"空") + "</span>"
										+ "<span class='span3'>"+(jsonlist[j].ORGNAME||"空") + "</span></a>");
						if(addGpsList.length==0){
							jk_obj["marker"]=returnMarkerArray[j];
							Ssjl.jk_objArray.push(jk_obj);
							Ssjl.ssjlGpsobjArray.push(jk_obj);
						}else{
							for(var n=0;n<addGpsList.length;n++){//添加的gpsmarker
								if(addGpsList[n]["GPSID"]==jsonlist[j].GPSID){
									jk_obj["marker"]=returnMarkerArray[n];//监控对象marker
									Ssjl.jk_objArray.push(jk_obj);
									Ssjl.ssjlGpsobjArray.push(jk_obj);
									break;
								}
							};
						}
						

					}
				}
			}
			Ssjl.startSsxx();
		},
		/**
		 * 右侧列表点击事件
		 * @param id
		 */
		clickFunc:function(id){
			if($("#"+id).hasClass("result_on")){
				$("#results a").removeClass("result_on");//再次点击清除样式
				MapBubble.closeBubble();
			}else{
				$("#results a").removeClass("result_on");
				$("#"+id).addClass("result_on");
				for(var i=0;i<Ssjl.jk_objArray.length;i++){
					if(id===Ssjl.jk_objArray[i]["gpsid"]){
						_MapApp.centerAtLatLng(Ssjl.jk_objArray[i]["marker"].getPoint());
						Ssjl.jk_objArray[i]["marker"].onclick();
						
					}
				}
			}
			
		},
		/**
		 * 
		 * @param param
		 * @param jsonlist
		 * @param callback
		 * @returns
		 */
		
		createMarker : function(param, jsonlist, callback) {
			var type = param["type"];
			var status = param["status"];
			//警力图片
			var image = "";
			var markerArray = new Array();
			for (var i = 0; i < jsonlist.length; i++) {
				if(type!="all"){
					image=Ssjl.gps_img[type][status];
				}else{
					var jllx=jsonlist[i].JLLX||jsonlist[i].picturetype;
					var statusid=jsonlist[i].STATUSID||jsonlist[i].statusid;
					var zt="";
					switch (statusid.toString()){
					case "850":
						zt="kx";
						break;
					case "980":
						zt="chj";
						break;
					
//					case "850":
//						zt="kx";
//						break;
//					case "900":
//						zt="cj";
//						break;
//					case "950":
//						zt="cz";
//						break;
						
					}
					image=Ssjl.gps_img[jllx][zt];
				};
				var carno=(jsonlist[i].CARNO||jsonlist[i].carno)||"";
				var plcname=(jsonlist[i].POLICENAME||jsonlist[i].policename)||"";
				var title="";
				if(carno==""||plcname==""){
					 title=plcname||carno;
				}else{
					title=(jsonlist[i].POLICENAME||jsonlist[i].policename)+"/"+carno;
				}
				var json = jsonlist[i];
				
				/*if(image==null || image==""){
					alert(json[gpsid]);
				}*/
				
				var marker = {dataJson:json,
						id:json["OBJECTID"]||"",
						titleName:title,
						x:json["X"]||json["x"],
						y:json["Y"]||json["y"],
						iconUrl:image,
						iconWidth:40,
						iconHeight:40,
						iconLeftOffset:0,
						iconTopOffset:-11
					};
				markerArray.push(marker);
			}
			var markerParam = {markerArray:markerArray,
						contentType:"html",
						contentValue:Ssjl.bubbleBox(),
						contentCallback:"Ssjl.loadBubbleContent",
						eventFuncJson:{},
						bubbleShowEvent:"click",
						titleShowEvent:"",
						bubbleWidth:400,
						bubbleHeight:180,
						moveMode:"movetoshow"
					};
			var returnMarkerArray = MapBubble.addMarker(markerParam);
			callback();
			return returnMarkerArray;
		},
		
		/**
		 * 加载气泡内容
		 * @param dataJson
		 */
		loadBubbleContent : function(data){
			Ssjl.clickJlData=data;
			var jqxx = Jqxx.currentPointObject[1];
			var ywsl=0;
			if($.isEmptyObject(jqxx)){//警情为空
				$("#gps_jlcz").hide();
				$("#gps_jlzy").hide();
				$("#gps_jlgp").hide();
			}else if(jqxx["jqzt"]==2){//未派警
				$("#gps_jlzy").hide();
				$("#gps_jlgp").hide();
			}else if(jqxx["jqzt"]>2&&jqxx["jqzt"]<5){//已派警，处置中
				if(typeof (data.YWBH||data.ywbh)!='undefined' && (data.YWBH||data.ywbh).indexOf(jqxx["jqbh"])!=-1){
					$("#gps_jlcz").hide();
					$("#gps_jlzy").hide();
					$("#gps_jlgp").hide();
				}else{
//					if((data.STATUSID||data.statusid)=="980"){
						$("#gps_jlcz").hide();
//						$("#gps_jlcz").text("改派");
//						$("#gps_jlcz").attr("href","javascript:Ssjl.jlczFunc(2)");
					
					
				}
			}else{//其它则不显示
				$("#gps_jlcz").hide();
				$("#gps_jlzy").hide();
				$("#gps_jlgp").hide();
			}
			if(typeof (data.YWBH||data.ywbh) !="undefined"){
				if((data.YWBH||data.ywbh).indexOf(",")!=-1){
					var count=(data.YWBH||data.ywbh).split(",").length;
					ywsl=count;
				}else{
					ywsl=1;
				}
			}
			$("#ssjl_jqsl").text(ywsl);
			$("#name").text((data.POLICENAME||data.policename)||"空");
			$("#carno").text((data.CARNO||data.carno)||"空");
			$("#callno").text((data.CALLNO||data.callno)||"空");
			$("#speed").text((data.SPEED||data.speed)||"空");
			$("#orgname").text((data.ORGNAME||data.orgname)||"空");
			$("#orgname").attr("title",(data.ORGNAME||data.orgname)||"");
			$("#direction").text(Ssjl.getDirection((data.DIR||data.dir))||"空");
			$("#lsgj").attr("href","javascript:Ssjl.lsgj("+(data.GPSID||data.gpsId)+")");
			$("#zjk").attr("href","javascript:Ssjl.zjk("+(data.GPSID||data.gpsId)+")");
			$("#ssjl_gps").attr("value",""+(data.GPSID||data.gpsId)+"");
			if($.inArray(data.GPSID||data.gpsId,Ssjl.lsgjIds)!=-1){
				$("#lsgj").addClass("btn_tipsdwon");
			};
			if(Ssjl.zjkid==(data.GPSID||data.gpsId)){
				$("#zjk").addClass("btn_tipsdwon");
			}
		},
		/**
		 * 返回事件
		 */
		backto:function (){
			$("#resultdiv").css("display","none");
			$("#reason").css("display","block");
		},
		/**
		 * 警力历史轨迹
		 * @param gpsid
		 * @param updt 是否更新
		 */
		lsgj:function (gpsid,updt) {
			var update=updt||false;
			if(update){
				var t = $("#timeInterval").val();
				if(t==""||t==null){
					t=Ssjl.lsgjTime;
				}
				for(var k=0;k<gpsid.length;k++){
					var oneGpsId=gpsid[k];
					SysTool.ajax({
						url : 'lsgj/getLsgj.f',
						data : {
							'gpsid' : oneGpsId,
							'time' : t
						}
					}, function(data) {
						var strCoods = "";
						for ( var i = 0; i < data.length; i++) {
							if (i != (data.length - 1)) {
								strCoods += data[i].x + "," + data[i].y + ",";
							} else {
								strCoods += data[i].x + "," + data[i].y;
							}

						}
						var pOverlay = new Polyline(strCoods, "#ff00FF", 2, 1, 1);//画轨迹
						_MapApp.addOverlay(pOverlay);
						for(var j=0;j<Ssjl.jk_objArray.length;j++){
							if(Ssjl.jk_objArray[j]["gpsid"]==oneGpsId){
								_MapApp.removeOverlay(Ssjl.jk_objArray[j]["pLine"]);
								Ssjl.jk_objArray[j]["pLine"]=pOverlay;
								Ssjl.jk_objArray[j]["strCoods"]=strCoods;
								Ssjl.jk_objArray[j]["lsgj"]=data;//存储监控对象线、坐标串、轨迹历史数据（json数组）
//								break;
							};
						}
						
					});
				}
				
			}else{
				if(Ssjl.clearLsgj(gpsid)==0){
					return;
				};
				var t = $("#timeInterval").val();
				if(t==""||t==null){
					t=Ssjl.lsgjTime;
				}
				SysTool.ajax({
					url : 'lsgj/getLsgj.f',
					data : {
						'gpsid' : gpsid,
						'time' : t
					}
				}, function(data) {
					var strCoods = "";
					for ( var i = 0; i < data.length; i++) {
						if (i != (data.length - 1)) {
							strCoods += data[i].x + "," + data[i].y + ",";
						} else {
							strCoods += data[i].x + "," + data[i].y;
						}

					}
					var pOverlay = new Polyline(strCoods, "#ff00FF", 2, 1, 1);//画轨迹
					_MapApp.addOverlay(pOverlay);
					for(var j=0;j<Ssjl.jk_objArray.length;j++){
						if(Ssjl.jk_objArray[j]["gpsid"]==gpsid){
							Ssjl.jk_objArray[j]["pLine"]=pOverlay;
							Ssjl.jk_objArray[j]["strCoods"]=strCoods;
							Ssjl.jk_objArray[j]["lsgj"]=data;//存储监控对象线、坐标串、轨迹历史数据（json数组）
							break;
						}
					}
					
				});
			}
			
		},
		/**
		 * 去除历史轨迹
		 */
		clearLsgj:function(gpsid){
		 var gps=gpsid||"all";
		 if(gps=="all"){ //清除所有轨迹
			 for(var j=0;j<Ssjl.jk_objArray.length;j++){
				 if(typeof (Ssjl.jk_objArray[j]["pLine"]) !="undefined"){
						_MapApp.removeOverlay(Ssjl.jk_objArray[j]["pLine"]);
						$("#lsgj").removeClass("btn_tipsdwon");
					}
				}
			 Ssjl.lsgjIds=[];
			 return 0;
		 	}else{
		 		var lslength=Ssjl.lsgjIds.length;
				if(lslength==0){//之前无历史轨迹id
			 		_MapApp.zoomTo(this.zoomLevel);
					Ssjl.lsgjIds.push(gpsid);
					$("#lsgj").toggleClass("btn_tipsdwon");
					return 1;
				}else{
					var ishas=$.inArray(gpsid,Ssjl.lsgjIds);
					if(ishas==-1){//不在轨迹id列中
				 		_MapApp.zoomTo(this.zoomLevel);
						Ssjl.lsgjIds.push(gpsid);
						$("#lsgj").toggleClass("btn_tipsdwon");
						return 1;
					}else{
						Ssjl.lsgjIds.splice(ishas,1);
						for(var j=0;j<Ssjl.jk_objArray.length;j++){
							if(Ssjl.jk_objArray[j]["gpsid"]==gpsid){
								_MapApp.removeOverlay(Ssjl.jk_objArray[j]["pLine"]);
								$("#lsgj").toggleClass("btn_tipsdwon");
								break;
							}
						}
						return 0;
					}	
				}
		 	}
			
		},
		/**
		 * 除去两数组相同的id
		 * @param a
		 * @param b
		 * @returns {Array}
		 */
		getAllGpsid:function(a,b){
			var aid=a;
			var bid=b;
			var allid=[];
//			console.log("ssjlGpsid"+ssjlGpsid+'====zbjlGpsid='+zbjlGpsid)
			for(var i=0;i<aid.length;i++){
					var index=$.inArray(aid[i],bid);
					if(index!=-1){
						bid.splice(index,1);
					}
				}
			allid=aid.concat(bid);
			return allid;
		},
		/**
		 * 实时消息
		 */
		ssxx:function(){
			var allgpsid="";
			if(Ssjl.jk_objArray.length==0){
				return false;
			}
			var id="";
			if($("#jl_tj dd").children().hasClass('a_on')){//点击统计数字进入
				id=Ssjl.selectedIds();//实时更新的gpsid		
				Ssjl.ssjlRequestGpsid = id.split(",");
			}
//			else{
//				id=Ssjl.oldids;//不选择统计数字进行查询
				
//			}
			//有新增加信号的gpsid
			var newGpsIds=[];
			//有减少的信号的gpsid
			var loseGpsIds=[];
			var oldIds=[];
			if(Ssjl.oldids!=""&&Ssjl.oldids!=null){
					oldIds=(Ssjl.oldids).split(",");
				}
			var oArray=this.getAllGpsid(oldIds,Ssjl.zbgpsArray);
			var iArray=this.getAllGpsid(Ssjl.ssjlRequestGpsid,Ssjl.zbgpsArray);
			for(var a=0;a<iArray.length;a++){
				var isExist = false;
				for(var b=0;b<oArray.length;b++){
					if(iArray[a]==oArray[b]){
						isExist = true;
						break;
					}
				}
				if(!isExist) {
					newGpsIds.push(iArray[a]);
					if(Ssjl.oldids==""){
						Ssjl.oldids = iArray[a];
					}else{
						Ssjl.oldids += ","+iArray[a];
					}
				}
			}
			
			for(var a=0;a<oArray.length;a++){
				var isExist = false;
				for(var b=0;b<iArray.length;b++){
					if(oArray[a]==iArray[b]){
						isExist = true;
						break;
					}
				}
				if(!isExist) {
					loseGpsIds.push(oArray[a]);
					Ssjl.oldids = iArray.join(",");
				}
			}
			allgpsid=this.getAllGpsid(Ssjl.ssjlRequestGpsid,Ssjl.zbgpsArray).join(",");
			
			// 实时消息请求
			SysTool.ajax({
				url : 'gps/getRealGpsInfo.f',
				data : {
					'sbid' : allgpsid
				}
			},function(data){
				
				var jsonlistArray = new Array();
				var gpstype = Ssjl.selectedType;
				var gpsstatus = Ssjl.selectedStatus;
				for(var j=0;j<iArray.length;j++){
					if(data[iArray[j]]){//有实时消息的gps
							for(var n=Ssjl.jk_objArray.length-1;n>=0;n--){
								if(Ssjl.jk_objArray[n]["gpsid"]==iArray[j]&&Ssjl.jk_objArray[n]["ztid"]!=data[iArray[j]].statusid){//循环判断监控对象里相同的gpsid,gps状态改变后的处理
									if(typeof (Ssjl.jk_objArray[n]["marker"]) !="undefined"){//警力marker存在
											
											_MapApp.removeOverlay(Ssjl.jk_objArray[n]["marker"]); //清除marker
											if(Ssjl.compareMarker(MapBubble.currMarker, Ssjl.jk_objArray[n]["marker"])) {
												MapBubble.closeBubble();
											}
										}
										$("#"+Ssjl.jk_objArray[n]["gpsid"]).remove();
										$("#ssjl_result_count").text(parseInt($("#ssjl_result_count").text())-1);
									if(typeof (Ssjl.jk_objArray[n]["pLine"]) !="undefined"){
											_MapApp.removeOverlay(Ssjl.jk_objArray[n]["pLine"]);
										}
										Ssjl.jk_objArray.splice(n,1);//清除监控对象里的信息
								     if($.inArray(iArray[j],Ssjl.zbgpsArray)!=-1&&data[iArray[j]].statusid!='000'){//周边警力状态改变后，警力marker变化
								    	 var zbindex=$.inArray(iArray[j],Ssjl.zbgpsArray);//周边警力对象
								    	 Ssjl.zbGpsobjArray.splice(zbindex, 1);
								    	 Ssjl.zbgpsArray.splice(zbindex, 1);
								    	 var newStatusid=data[iArray[j]].statusid;
								    	 var jsonArray=[];
								    	 if(newStatusid=="850"){
								    		 newGpsStatus="kx";
								    	 }else{
								    		 newGpsStatus="chj";
								    	 }
								    	 jsonArray.push(data[iArray[j]]);
								    	 if(gpstype==""||gpstype==null){
												gpstype=data[iArray[j]].picturetype;
											}
								    	 var returnMarkerArray = Ssjl.createMarker({type : gpstype, status : newGpsStatus}, jsonArray, function(){});
								    	 var newobj={};
								    	 
											newobj["marker"]=returnMarkerArray[0];
											newobj["gpsid"]=iArray[j];
											newobj["ztid"]=newStatusid;
											Ssjl.jk_objArray.push(newobj);//重新监控新的gpsmarker
											Ssjl.zbGpsobjArray.push(newobj);//重新装入周边警力对象中
											Ssjl.zbgpsArray.push(newobj["gpsid"]);//周边警力ID数组中
										}else{//实时警力查询的警力
											$("#"+Ssjl.jk_objArray[j]["gpsid"]).remove();
											$("#ssjl_result_count").text(parseInt($("#ssjl_result_count").text())-1);
//											if($.inArray(iArray[j],Ssjl.ssjlGpsidArray)!=-1){//实时警力查询空闲增援后，状态改变
//												var ssjlindex=$.inArray(iArray[j],Ssjl.ssjlGpsidArray);
//												Ssjl.ssjlGpsobjArray.splice(ssjlindex, 1);
//												Ssjl.ssjlGpsidArray.splice(ssjlindex, 1);
//												 var newStatusid=data[iArray[j]].statusid;
//										    	 var jsonArray=[];
//										    	 if(newStatusid=="850"){
//										    		 newGpsStatus="kx";
//										    	 }else{
//										    		 newGpsStatus="chj";
//										    	 }
//										    	 jsonArray.push(data[iArray[j]]);
//										    	 if(gpstype==""||gpstype==null){
//														gpstype=data[iArray[j]].picturetype;
//													}
//										    	 var returnMarkerArray = Ssjl.createMarker({type : gpstype, status : newGpsStatus}, jsonArray, function(){});
//										    	 var newobj={};
//										    	 
//													newobj["marker"]=returnMarkerArray[0];
//													newobj["gpsid"]=iArray[j];
//													newobj["ztid"]=newStatusid;
//													Ssjl.jk_objArray.push(newobj);//重新监控新的gpsmarker
//													Ssjl.ssjlGpsobjArray.push(newobj);//重新装入实时警力对象中
//													Ssjl.ssjlGpsidArray.push(newobj["gpsid"]);//实时警力ID数组中
//											}
										}
									break;
								}
							}
//						}
						var gpsxx = data[iArray[j]];
						if(gpstype==""){//为空则表示未选择数字统计查询
							gpstype=data[iArray[j]].jllx;
						}
						for(var k=0;k<newGpsIds.length;k++){
							if(iArray[j]==newGpsIds[k]){
								jsonlistArray.push(gpsxx);//新加gpsmarker数据
							}
						}
						
						Ssjl.changePosition(data,iArray[j]);//marker位置，历史轨迹更新
						
					}
				}
				if(jsonlistArray.length!=0){//新加gpsmarker
					var returnMarkerArray = Ssjl.createMarker({type : gpstype, status : gpsstatus}, jsonlistArray, function(){});//创建新加gpsmarker
					
					for(var j=0;j<jsonlistArray.length;j++){
						var newobj={};
						newobj["marker"]=returnMarkerArray[j];
						newobj["gpsid"]=jsonlistArray[j].gpsid;
						newobj["ztid"]=jsonlistArray[j].statusid;
						Ssjl.jk_objArray.push(newobj);
						Ssjl.ssjlGpsobjArray.push(newobj);
						$("#results").append(
								"<a href='javascript:Ssjl.clickFunc(\""+jsonlistArray[j].gpsId+"\")'' id='"+jsonlistArray[j].gpsId+"'>" + "<span class='span1'>" + (jsonlistArray[j].policename||"空") + "</span>"
										+ "<span class='span2'>" + (jsonlistArray[j].carno||"空") + "</span>"
										+ "<span class='span3'>"+(jsonlistArray[j].groupname||"空") + "</span></a>");

					};
					$("#ssjl_result_count").text(parseInt($("#ssjl_result_count").text())+jsonlistArray.length);//改变数量值
				}
				if(loseGpsIds.length > 0){ //减少gpsmarker
					if(Ssjl.jk_objArray.length==0){
						Ssjl.stopSsxx();
						Ssjl.clearSsjlMarker();
						MapBubble.closeBubble();
						$("#results").html("");
						$("#ssjl_result_count").text(0);
						return false;
					}
					var jkobjLength = Ssjl.jk_objArray.length;
					var jkobj = Ssjl.jk_objArray;
					for(var n=jkobjLength - 1;n >=0;n--){
						for(var j = 0; j < loseGpsIds.length; j++) {
							if(jkobj[n]["gpsid"] == loseGpsIds[j]) {
								if(typeof (jkobj[n]["marker"]) !="undefined"){
									_MapApp.removeOverlay(jkobj[n]["marker"]); //清除marker
								}
								
								$("#"+jkobj[n]["gpsid"]).remove();
								$("#ssjl_result_count").text(parseInt($("#ssjl_result_count").text())-1);
								if(typeof (jkobj[n]["pLine"]) !="undefined"){
									_MapApp.removeOverlay(jkobj[n]["pLine"]);
								}
								Ssjl.jk_objArray.splice(n,1);//清除丢失信号的gps
								if(Ssjl.compareMarker(MapBubble.currMarker, jkobj[n]["marker"])) {
									MapBubble.closeBubble();
								}
								break;
							}
						}
					}
				}
				
				Ssjl.zjk();//主监控
			});
		}, 
		/**
		 * 更新GPS位置以及历史轨迹信息
		 * @param data
		 * @param gpsid
		 */
		changePosition:function(data,gpsid){
			var nxy=data[gpsid]["x"]+","+data[gpsid]["y"];
			var tempPoint=new Point(data[gpsid]["x"],data[gpsid]["y"]);
			var divlength=$("#ssjl_gps").length;
			var has=false;//是否有gps气泡框
			var checkid="";
			if(divlength>0){
				has=true;
				checkid=$("#ssjl_gps").attr("value");
			}
			for(var b=0;b<Ssjl.jk_objArray.length;b++){
				if(Ssjl.jk_objArray[b]["gpsid"]==gpsid){//循环判断监控对象中相同gpsid
					//判断是是否是打开气泡框的marker
					if(has&&checkid==gpsid){
							var marker = Ssjl.jk_objArray[b]["marker"];
							if(typeof marker!=null&& typeof marker!="undefined"){
								var cywsl=0;
								MapBubble.relocation(marker, tempPoint.x, tempPoint.y, function(marker){//气泡跟随移动
									MapBubble.setBubblePositionByMarker(marker);
								});
								$("#speed").text(data[Ssjl.jk_objArray[b]["gpsid"]]["speed"]);
								$("#direction").text(Ssjl.getDirection(data[Ssjl.jk_objArray[b]["gpsid"]]["dir"])||"空");
								if(typeof (data.YWBH||data.ywbh) !="undefined"){
									if((data.YWBH||data.ywbh).indexOf(",")!=-1){
										var count=(data.YWBH||data.ywbh).split(",").length;
										cywsl=count;
									}else{
										cywsl=1;
									}
								$("#ssjl_jqsl").text(cywsl);
								}
							}
							
							
					}else{
						
						var marker = Ssjl.jk_objArray[b]["marker"];
						if(typeof marker!=null&& typeof marker!="undefined"){
							MapBubble.relocation(marker, tempPoint.x, tempPoint.y, function(marker){
							});
						}
						
					}
					break;
				}
			}
			
			//Ssjl.zjk();//主监控
			 if($.inArray(gpsid,Ssjl.lsgjIds)!=-1&&Ssjl.lsgjIds.length!=0){//轨迹更新
				 for(var m=0;m<Ssjl.jk_objArray.length;m++){
					 if(typeof (Ssjl.jk_objArray[m]["pLine"]) !="undefined"&&(gpsid==Ssjl.jk_objArray[m]["gpsid"])){//判断有轨迹的gpsid
							var allTime=Ssjl.jk_objArray[m]["lsgj"];
							var jgTime=parseInt($("#timeInterval").val())*60*1000;//间隔时间
							var newTime=data[gpsid]["realtime"];//最新gps信号时间
							var strCoods=Ssjl.jk_objArray[m]["strCoods"].split(",");
							
							for(var b=0;b<allTime.length;b++){//循环判断历史轨迹中超时的点
								if(parseInt(allTime[b]["time"])<(parseInt(newTime)-jgTime)){
									strCoods.splice(0,2);
									Ssjl.jk_objArray[m]["strCoods"]=strCoods.join(",");
									break;
								}
							}
//							console.log("gjdian=="+Ssjl.jk_objArray[m]["strCoods"].split(",").length);
							Ssjl.jk_objArray[m]["pLine"].setPoints(Ssjl.jk_objArray[m]["strCoods"]+","+nxy);
							Ssjl.jk_objArray[m]["strCoods"]=Ssjl.jk_objArray[m]["strCoods"]+","+nxy;
							break;
						}
				 }
				 
			 }
		},
		
		/**
		 * 开始实时接收信号
		 */
		startSsxx:function(){
			ProtectedTimer.ssxxTimer=setInterval(function(){
				Ssjl.ssxx();
			}, SysConfig.SSXX_TIMER);
		},
		/**
		 * 停止接收信号
		 */
		stopSsxx:function(){
			window.clearInterval(ProtectedTimer.ssxxTimer);
			ProtectedTimer.ssxxTimer = null;
			
		},
		/**
		 * 返回所选择的警力类型gpsid
		 * @returns {String}
		 */
		selectedIds:function(){
			var id="";
			if($("#jl_tj dd a").hasClass("a_on")){
				var selectedType=$(".a_on").attr("type");
				var selectedStatus=$(".a_on").attr("status");// 所选状态
				Ssjl.selectedType=selectedType;
				Ssjl.selectedStatus=selectedStatus;
				if(typeof (Ssjl.data[selectedType])!="undefined"){
					id=Ssjl.data[selectedType][selectedStatus]["ids"];
				}else{
					/**
					 * 取得所选全部gpsid
					 */
					$("#jl_tj a[status='"+selectedStatus+"']").each(function(){
						var that=this;
						if($(that).text()!=0&&$(that).attr("type")!="all"){
							if(id==''){
								id=Ssjl.data[($(that).attr("type"))][selectedStatus]["ids"];//状态统计后gpsid
							}else{
								id+=","+Ssjl.data[($(that).attr("type"))][selectedStatus]["ids"];
							}
						}
					});
					
				}
			};
			return id;
		},
		/**
		 *  创建marker
		 * @param x
		 * @param y
		 * @param image
		 * @param title
		 * @returns {Marker}
		 */
		/*createMarker:function(x,y,image,title){
			var pIcon = new Icon();
			pIcon.image = image;
			pIcon.height = 24;
			pIcon.width = 24;
			pIcon.topOffset = 0;
			pIcon.leftOffset = 0;
			var marker=new Marker(new Point(x,y), pIcon, new Title(
					title, 12, 7, "宋体", "black", "white",
					"silver", "2"));
			return marker;
		},*/
		/**
		 * 主监控
		 * @param gpsid
		 */
		zjk:function(gpsid){
			//console.log(gpsid);
			var gps = gpsid || "";
			var nowlevel=_MapApp.getZoomLevel();
			if (gps == "") {
				if (Ssjl.zjkid == "") {
					return 0;
				} else {
					for ( var j = 0; j < Ssjl.jk_objArray.length; j++) {
						if (Ssjl.jk_objArray[j]["gpsid"] == Ssjl.zjkid) {
							if(nowlevel>this.zoomLevel){
								_MapApp.centerAndZoom(Ssjl.jk_objArray[j]["marker"]
								.getPoint(), nowlevel);
							}else{
								_MapApp.centerAndZoom(Ssjl.jk_objArray[j]["marker"]
								.getPoint(), this.zoomLevel);
							}
							
							break;
						}
					}
					return 0;
				}
			} else if (gps != "") {
				if ((gps == Ssjl.zjkid)) {
					$("#zjk").toggleClass("btn_tipsdwon");
					for ( var j = 0; j < Ssjl.jk_objArray.length; j++) {//恢复原有颜色
						if (Ssjl.jk_objArray[j]["gpsid"] == Ssjl.zjkid) {
							
							Ssjl.jk_objArray[j]["marker"].titleDiv.style.background="#000000";
							break;
						}
					}
					Ssjl.zjkid = "";// 置空
				} else {
					if (Ssjl.zjkid != "") {
						$("#zjk").toggleClass("btn_tipsdwon");
						for ( var j = 0; j < Ssjl.jk_objArray.length; j++) {//恢复原有主监控title颜色
							if (Ssjl.jk_objArray[j]["gpsid"] == Ssjl.zjkid) {
								
								Ssjl.jk_objArray[j]["marker"].titleDiv.style.background="#000000";
								break;
							}
						}
						Ssjl.zjkid = gps.toString();
						for ( var j = 0; j < Ssjl.jk_objArray.length; j++) {
							if (Ssjl.jk_objArray[j]["gpsid"] == Ssjl.zjkid) {
								if(nowlevel>this.zoomLevel){
									_MapApp.centerAndZoom(Ssjl.jk_objArray[j]["marker"]
									.getPoint(), nowlevel);
								}else{
									_MapApp.centerAndZoom(Ssjl.jk_objArray[j]["marker"]
									.getPoint(), this.zoomLevel);
								}
								Ssjl.jk_objArray[j]["marker"].titleDiv.style.background="#e40000";//主监控title颜色
								break;
							}
						}
					} else {
						Ssjl.zjkid = gps.toString();
						$("#zjk").toggleClass("btn_tipsdwon");
						for ( var j = 0; j < Ssjl.jk_objArray.length; j++) {
							if (Ssjl.jk_objArray[j]["gpsid"] == Ssjl.zjkid) {
								if(nowlevel>this.zoomLevel){
									_MapApp.centerAndZoom(Ssjl.jk_objArray[j]["marker"]
									.getPoint(), nowlevel);
								}else{
									_MapApp.centerAndZoom(Ssjl.jk_objArray[j]["marker"]
									.getPoint(), this.zoomLevel);
								}
								Ssjl.jk_objArray[j]["marker"].titleDiv.style.background="#e40000";//主监控title颜色
								break;
							}
						}
					}
	
				}
	
			}
		},
		/**
		 * 转换方向
		 * @param dir
		 * @returns {String}
		 */
		getDirection:function(dir){
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
					$("#" + keywordInputId).val(Ssjl.gjz);
				}
			});
			$("#" + keywordInputId).focus(function() {
				if ($("#" + keywordInputId).val() == Ssjl.gjz && $("#" + keywordInputId).css("color") == "#999") {
					$("#" + keywordInputId).val("");
					$("#" + keywordInputId).css("color", "#000");
				}
			});
		},
		/**
		 * 清除实时警力查询的警力
		 */
		clearSsjlMarker:function(){
			for ( var i = 0; i < Ssjl.ssjlGpsobjArray.length; i++) {
			if (typeof (Ssjl.ssjlGpsobjArray[i]["marker"]) != "undefined") {
				_MapApp.removeOverlay(Ssjl.ssjlGpsobjArray[i]["marker"]);
				if ($.inArray(Ssjl.ssjlGpsobjArray[i]["gpsid"], this.lsgjIds) != -1) {//存在轨迹时
					var index=$.inArray(Ssjl.ssjlGpsobjArray[i]["gpsid"], this.lsgjIds);
					var index1 = $.inArray(Ssjl.ssjlGpsobjArray[i],this.jk_objArray);
					if (index1 != -1) {
						
						if (typeof (Ssjl.jk_objArray[index1]["pLine"]) != "undefined") {
							_MapApp.removeOverlay(Ssjl.jk_objArray[index1]["pLine"]);
						}
						
						this.jk_objArray.splice(index1, 1);
						
					};					
					Ssjl.lsgjIds.splice(index, 1);// 清除历史轨迹中的gpsid
					
				}else{
					var index2 = $.inArray(Ssjl.ssjlGpsobjArray[i],this.jk_objArray);
					
					if (index2 != -1) {
						
						this.jk_objArray.splice(index2, 1);//清除该监控对象
					}
				}
				if (Ssjl.ssjlGpsobjArray[i]["gpsid"] == this.zjkid) {// 主监控
					this.zjkid = "";
				}
			}

		}
		if (_MapApp.map.vmlDraw != null) {
			_MapApp.removeOverlay(_MapApp.map.vmlDraw);
		}
		if (Ssjl.gpspOverlay != null) {

			_MapApp.removeOverlay(Ssjl.gpspOverlay);// 清除查询所画的overlay
		}
		this.ssjlGpsobjArray = [];// 实时警力查询清空记录
		this.ssjlRequestGpsid = [];
		MapBubble.closeBubble();
		Ssjl.oldids = "";//清空所选择的gpsid
//			
		},
		/**
		 * 清除警力圈里的周边警力 
		 */
		clearZbjlMarker:function(){
			for ( var i = 0; i < Ssjl.zbGpsobjArray.length; i++) {
			if (typeof (Ssjl.zbGpsobjArray[i]["marker"]) != "undefined") {
				_MapApp.removeOverlay(Ssjl.zbGpsobjArray[i]["marker"]);

				var index = $.inArray(Ssjl.zbGpsobjArray[i]["gpsid"],
						this.lsgiIds);
				if (index != -1) {
					Ssjl.lsgjIds.splice(index, 1);// 清除历史轨迹中的gpsid
				}
				if (Ssjl.zbGpsobjArray[i]["gpsid"] == this.zjkid) {// 主监控
					this.zjkid = "";
				}
				var index1 = $.inArray(Ssjl.zbGpsobjArray[i], this.jk_objArray);
				if (index1 != -1) {
					this.jk_objArray.splice(index1, 1);
				}
			}

		};
		this.zbGpsobjArray = [];
		this.zbgpsArray = [];
		MapBubble.closeBubble();
		},
		/**
		 * 清除所有与警力相关的信息
		 */
		clear:function(){
			$(".a_on").removeClass("a_on");
			if(Ssjl.zbgpsArray.length==0){
				Ssjl.stopSsxx();
			}
			this.clearSsjlMarker();
			this.clearLsgj();
			this.clearZbjlMarker();
			
			Ssjl.jk_objArray=[];
			Ssjl.zjkid="";
			Ssjl.lsgjIds=[];
			Ssjl.oldids="";
			Ssjl.backto();
			MapBubble.closeBubble();
			
		},
		/**
		 * 辖区内空闲警力查询
		 */
		xqnjl:function(){
			var jqxx = Jqxx.currentPointObject[1];
			if(!$.isEmptyObject(jqxx)){
				var xqdm=jqxx["jqssdddm"];
				var where=" and path like '%"+xqdm+"%' ";
				this.jlQuery("all", "kx", where);
			}
		},
		/**
		 * 辖区外空闲警力查询
		 */
		xqwjl:function(){
			var jqxx = Jqxx.currentPointObject[1];
			if(!$.isEmptyObject(jqxx)){
				var xqdm=jqxx["jqssdddm"];
				var where=" and path not like '%"+xqdm+"%' ";
				this.jlQuery("all", "kx", where);
			}
		},
		/**
		 * 显示或隐藏
		 */
		showOrHideXqnw:function(){
			var jqxx = Jqxx.currentPointObject[1];
			if(!$.isEmptyObject(jqxx)){
				$("#ssjl_xqnw_query").children("a").each(function(){
					$(this).removeAttr("disabled");
					$(this).removeClass("btnabbig_disabled");
				});
			}else{
				$("#ssjl_xqnw_query").children("a").each(function(){
					$(this).attr("disabled","");
					$(this).addClass("btnabbig_disabled");
				});
				
			}	
		},
		
		/**
		 * 判断marker是否相同
		 * @param marker1
		 * @param marker2
		 * @returns {Boolean}
		 */
		compareMarker : function(marker1, marker2) {
			if(marker1 == null || marker2 == null) {
				return false;
			}
			var point1 = marker1.getPoint();
			var point2 = marker2.getPoint();
			if(point1 === point2) {
				return true;
			}
			return false;
		}
};


