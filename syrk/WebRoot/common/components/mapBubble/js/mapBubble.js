/*!
 * 地图气泡工具类
 * http://jquery.com/
 * znjg - v1.0.0 (2014-03-12 09:30)
 * Copyright(c) 2014 founder
 */

/**
 * @classDescription 地图气泡工具类
 * @author gb
 */

SysTool.loadComponentsFile("mapBubble", "mapBubble", ".css");

var MapBubble = {
	/**
	 * 地图对象
	 */
	_MapApp : null,

	/**
	 * 地图divID
	 */

	mapDivId : "pgis_map",

	/**
	 * 当前marker对象
	 */
	currMarker : null,

	/**
	 * 点击的是否是marker对象
	 */
	isClickMarker : false,

	/**
	 * 是否存在气泡框
	 */
	isExistBubble : false,

	/**
	 * 移动地图显示气泡后，气泡边缘离地图边缘距离（px）
	 */
	distanceBorderPx : 20,

	menuoffset : 0,

	/**
	 * 自动平移时延迟毫秒数
	 */
	autoPanTimeout : 700,

	/**
	 * 以marker为中心的圆数组
	 */
	circleArray : new Array(),

	/**
	 * 周边marker数组
	 */
	aroundMarkerArray : new Array(),

	/**
	 * 地图初始化
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：mapContainerId 地图容器id）
	 * @param {Function}
	 *            回调函数
	 */
	initMap : function(param, callbackFunc) {
		if (typeof EzMap == "undefined") {
			window.setTimeout(function() {
				this.initMap();
			}, 500);
			return;
		}
		if (_compatIE()) {
			$("#" + param.mapContainerId).append(
					'<div id="' + this.mapDivId + '"></div>');
			_MapApp = new EzMap(document.getElementById(this.mapDivId));
			if (_MapApp.initialize) {
				_MapApp.initialize();
			}
			var pOverview = new OverView();
			pOverview.height = 200;
			pOverview.width = 200;
			pOverview.minLevel = 8;
			pOverview.maxLevel = 10;
			_MapApp.addOverView(pOverview);
			_MapApp.zoomTo(SysConfig.MAPINIT_ZOOM_LEVEL);
			_MapApp.hideMapServer();
			_MapApp.hideCopyright();
			_MapApp.addMapEventListener(EzEvent.MAP_MOUSEMOVE, function(e) {
				window.status = "X:" + e.mapPoint.x + "  Y:" + e.mapPoint.y;
			});
			this.initBubble(param.mapContainerId);
			this.addMapEventListener(_MapApp);
		} else if (_MapApp == null) {
			var pEle = document.getElementById("pgis_map");
			pEle.innerHTML = "<p>EzMap地图引擎不支持您使用的浏览器!</p>";
		}
		this._MapApp = _MapApp;
		callbackFunc(_MapApp);
	},

	/**
	 * 初始气泡
	 * 
	 * @param param
	 */
	init : function(param) {
		this._MapApp = param.mapApp;
		this.initBubble(param.mapContainerId);
		this.addMapEventListener(_MapApp);
	},

	/**
	 * 在地图上添加marker
	 * 
	 * @param param
	 *            {*markerArray:[{*titleName:title名称,*x:经度,*y:纬度,*iconUrl:图标地址,iconWidth:图标宽,iconHeight:图标高,
	 *            iconLeftOffset:图标X偏移像素,iconTopOffset:图标Y偏移像素},
	 *            {},{}],contentType:id/html/url,contentValue:id/html/url,contentCallback:"Jqxx.callback",
	 *            eventFuncJson:{click:"Jqxx.markerClickEvent",dblclick:"Jqxx.markerDbClickEvent"},
	 *            bubbleShowEvent:click/dblclick/mouseover,titleShowEvent:""/mouseover,bubbleWidth:气泡宽,bubbleHeight:气泡高,
	 *            moveMode:notmove/movetoshow/movetocenter/movetobubblecenter,
	 *            geometryType:point/polyline/polygon}
	 */
	addMarker : function(param) {
		var icon, point, title, marker, markerArray = new Array();
		for ( var i = 0; i < param.markerArray.length; i++) {
			var makerParam = param.markerArray[i];
			if (makerParam.x == null || makerParam.x == ""
					|| makerParam.y == null || makerParam.y == "") {
				continue;
			}
			icon = new Icon();
			icon.image = ("undefined" == typeof makerParam.iconUrl ? "" : makerParam.iconUrl);
			icon.width = ("undefined" == typeof makerParam.iconWidth ? 30 : makerParam.iconWidth);
			icon.height = ("undefined" == typeof makerParam.iconHeight ? 30 : makerParam.iconHeight);
			icon.leftOffset = ("undefined" == typeof makerParam.iconLeftOffset ? 0 : makerParam.iconLeftOffset);
			icon.topOffset = ("undefined" == typeof makerParam.iconTopOffset ? 0 : makerParam.iconTopOffset);
			point = new Point(makerParam.x, makerParam.y);
			title = ("undefined" == typeof makerParam.titleName ? "" : makerParam.titleName);
			if(title != "" && title != null){
				title = new Title(makerParam.titleName, 12, 7,"宋体","#ffffff", "#000000", "#000000", 0);
				marker = new Marker(point, icon, title);
			} else {
				marker = new Marker(point, icon);
			}
			marker = this.initMarkerEventListener(marker, param, makerParam);
			this._MapApp.addOverlay(marker);
			markerArray.push(marker);
		}
		this.initBubbleSize(param.bubbleWidth, param.bubbleHeight);
		return markerArray;
	},
	
	
	/**
	 * 在地图上添加marker
	 * 
	 * @param param
	 *            {*markerArray:[{*titleName:title名称,*x:经度,*y:纬度,*iconUrl:图标地址,iconWidth:图标宽,iconHeight:图标高,
	 *            iconLeftOffset:图标X偏移像素,iconTopOffset:图标Y偏移像素},
	 *            {},{}],contentType:id/html/url,contentValue:id/html/url,contentCallback:"Jqxx.callback",
	 *            eventFuncJson:{click:"Jqxx.markerClickEvent",dblclick:"Jqxx.markerDbClickEvent"},
	 *            bubbleShowEvent:click/dblclick/mouseover,titleShowEvent:""/mouseover,bubbleWidth:气泡宽,bubbleHeight:气泡高,
	 *            moveMode:notmove/movetoshow/movetocenter/movetobubblecenter,
	 *            geometryType:point/polyline/polygon}
	 */
	addJttsMarker : function(param) {
		var icon, point, title, marker, markerArray = new Array();
		for ( var i = 0; i < param.markerArray.length; i++) {
			var makerParam = param.markerArray[i];
			if (makerParam.x == null || makerParam.x == ""
					|| makerParam.y == null || makerParam.y == "") {
				continue;
			}
			icon = new Icon();
			icon.image = ("undefined" == typeof makerParam.iconUrl ? "" : makerParam.iconUrl);
			icon.width = ("undefined" == typeof makerParam.iconWidth ? 30 : makerParam.iconWidth);
			icon.height = ("undefined" == typeof makerParam.iconHeight ? 30 : makerParam.iconHeight);
			icon.leftOffset = ("undefined" == typeof makerParam.iconLeftOffset ? 0 : makerParam.iconLeftOffset);
			icon.topOffset = ("undefined" == typeof makerParam.iconTopOffset ? 0 : makerParam.iconTopOffset);
			point = new Point(makerParam.x, makerParam.y);
			title = ("undefined" == typeof makerParam.titleName ? "" : makerParam.titleName);
			if(title != "" && title != null){
				title = new Title(makerParam.titleName, 12, 7,"宋体","#ffffff", "#000079", "#000079", 0);
				marker = new Marker(point, icon, title);
			} else {
				marker = new Marker(point, icon);
			}
			marker = this.initMarkerEventListener(marker, param, makerParam);
			this._MapApp.addOverlay(marker);
			markerArray.push(marker);
		}
		this.initBubbleSize(param.bubbleWidth, param.bubbleHeight);
		return markerArray;
	},
	
	addMarkerToMap : function(param) {
		var icon, point, title, marker, markerArray = new Array();
		var markerJson = {};
		for ( var i = 0; i < param.markerArray.length; i++) {
			var makerParam = param.markerArray[i];
			if (makerParam.x == null || makerParam.x == ""
					|| makerParam.y == null || makerParam.y == "") {
				continue;
			}
			icon = new Icon();
			icon.image = ("undefined" == typeof makerParam.iconUrl ? "" : makerParam.iconUrl);
			icon.width = ("undefined" == typeof makerParam.iconWidth ? 30 : makerParam.iconWidth);
			icon.height = ("undefined" == typeof makerParam.iconHeight ? 30 : makerParam.iconHeight);
			icon.leftOffset = ("undefined" == typeof makerParam.iconLeftOffset ? 0 : makerParam.iconLeftOffset);
			icon.topOffset = ("undefined" == typeof makerParam.iconTopOffset ? 0 : makerParam.iconTopOffset);
			point = new Point(makerParam.x, makerParam.y);
			title = ("undefined" == typeof makerParam.titleName ? "" : makerParam.titleName);
			if(title != "" && title != null){
				title = new Title(makerParam.titleName, 12, 7,"宋体","#ffffff", "#000000", "#000000", 0);
				marker = new Marker(point, icon, title);
			} else {
				marker = new Marker(point, icon);
			}
			marker = this.initMarkerEventListener(marker, param, makerParam);
			this._MapApp.addOverlay(marker);
			//markerArray.push(marker);
			var key = makerParam.id;
			markerJson[key] = marker;
		}
		this.initBubbleSize(param.bubbleWidth, param.bubbleHeight);
		return markerJson;
	},
	
	/**
	 * 在地图上添加几何图层
	 * @param param [{param:[{points:points,color:color,weight:weight,opacity:opacity,arrow:arrow},{}],geometryType:point/polyline/polygon/marker},{}]
	 */
	addGeometryLayers: function(param) {
		for(var i = 0; i < param.length; i++){
			var p = param[i];
			var geometryType = p.geometryType; 
			var p_ = p.param;
			if(geometryType == "polyline") {
				this.addPolyline(p_);
			} else if(geometryType == "polygon") {
				this.addPolygon(p_);
			} else if(geometryType == "point") {
				this.addPoint(p_);
			} else if(geometryType == "marker") {
				this.addMarker(p_);
			}
		}
	},
	
	/**
	 * 在地图上添加点
	 * @param param
	 */
	addPoint : function(param) {
		
	},
	
	/**
	 * 在地图上添加线 
	 * @param param [{points:points,color:color,weight:weight,opacity:opacity,arrow:arrow},{}]
	 */
	addPolyline : function(param) {
		for(var i = 0; i < param.length; i++) {
			var p = param[i];
			var polyline = new Polyline(p.points, p.color, p.weight, p.opacity, p.arrow);
			this._MapApp.addOverlay(polyline);
		}
	},
	
	/**
	 * 在地图上添加面
	 * @param param [{points:points,color:color,weight:weight,opacity:opacity,fillcolor:fillcolor},{}]
	 */
	addPolygon : function(param) {
		for(var i = 0; i < param.length; i++) {
			var p = param[i];
			var polygon = new Polygon(p.points, p.color, p.weight, p.opacity, p.fillcolor);
			this._MapApp.addOverlay(polygon);
		}
	},

	/**
	 * 根据marker对应的气泡尺寸初始化
	 * 
	 * @param bubbleWidth
	 * @param bubbleHeight
	 */
	initBubbleSize : function(bubbleWidth, bubbleHeight) {
		$("#tips").css({
			"width" : bubbleWidth + "px",
			"height" : bubbleHeight + "px",
			"min-height" : bubbleHeight + "px",
			"max-height" : bubbleHeight + "px"
		});
		$("#tips").find(".tips_ct").css({
			"height" : bubbleHeight-30 + "px",
			"min-height" : bubbleHeight-30 + "px",
			"max-height" : bubbleHeight-30 + "px"
		});

	},

	/**
	 * 初始化marker监听事件
	 * 
	 * @param marker
	 * @param param
	 * @param makerParam
	 * @returns
	 */
	initMarkerEventListener : function(marker, param, makerParam) {
		marker.addListener("click", function() {
			MapBubble.isClickMarker = true;
			MapBubble.closeBubble();
			MapBubble.currMarker = marker;
			MapBubble.initBubbleSize(param.bubbleWidth, param.bubbleHeight);
			if ("undefined" != typeof param.bubbleShowEvent
					&& param.bubbleShowEvent == "click") {
				MapBubble.closeBubble();
				MapBubble.loadContentToBubble(param, makerParam, function() {
					MapBubble.setMarkerPostion(marker, param, function() {
						MapBubble.currMarker = marker;
						MapBubble.openBubble(param);
						MapBubble.setBubblePositionByMarker(marker);
					});
				});
			}
			MapBubble.exeParamEventFunc(param, makerParam, "click");
		});
		marker.addListener("dblclick", function() {
			MapBubble.isClickMarker = true;
			MapBubble.currMarker = marker;
			MapBubble.initBubbleSize(param.bubbleWidth, param.bubbleHeight);
			if ("undefined" != typeof param.bubbleShowEvent
					&& param.bubbleShowEvent == "dblclick") {
				MapBubble.closeBubble();
				MapBubble.loadContentToBubble(param, makerParam, function() {
					MapBubble.setMarkerPostion(marker, param, function() {
						MapBubble.currMarker = marker;
						MapBubble.openBubble(param);
						MapBubble.setBubblePositionByMarker(marker);
					});
				});
			}
			MapBubble.exeParamEventFunc(param, makerParam, "dblclick");
		});
		marker.addListener("mouseover", function() {
			MapBubble.isClickMarker = true;
			if ("undefined" != typeof param.bubbleShowEvent
					&& param.bubbleShowEvent == "mouseover") {
				MapBubble.closeBubble();
				MapBubble.currMarker = marker;
				MapBubble.initBubbleSize(param.bubbleWidth, param.bubbleHeight);
				MapBubble.loadContentToBubble(param, makerParam, function() {
					MapBubble.setMarkerPostion(marker, param, function() {
						MapBubble.currMarker = marker;
						MapBubble.openBubble(param);
						MapBubble.setBubblePositionByMarker(marker);
					});
				});
			}
			if ("undefined" != typeof param.titleShowEvent
					&& param.titleShowEvent == "mouseover") {
				marker.showTitle();
			}
			MapBubble.exeParamEventFunc(param, makerParam, "mouseover");
		});
		if ("undefined" != typeof param.titleShowEvent
				&& param.titleShowEvent == "mouseover") {
			marker.hideTitle();
			marker.addListener("mouseout", function() {
				marker.hideTitle();
			});
		}
		return marker;
	},

	/**
	 * 加载内容到气泡框
	 */
	loadContentToBubble : function(param, makerParam, callbackFunc) {
		if ("undefined" != typeof param.contentType
				&& "undefined" != typeof param.contentValue) {
			var callback = param.contentCallback;
			if (param.contentType == "id") {
				$("#tipsContent").html($("#" + param.contentValue).html());
				MapBubble.initBubbleSize(param.bubbleWidth, param.bubbleHeight);
				callbackFunc();
				if ("undefined" != typeof callback && callback != null
						&& callback != "") {
					var func = eval(callback);
					func.call(func, makerParam["dataJson"]);
				}
			} else if (param.contentType == "html") {
				$("#tipsContent").html(param.contentValue);
				MapBubble.initBubbleSize(param.bubbleWidth, param.bubbleHeight);
				callbackFunc();
				if ("undefined" != typeof callback && callback != null
						&& callback != "") {
					var func = eval(callback);
					func.call(func, makerParam["dataJson"]);
				}
			} else if (param.contentType == "url") {
				$("#tipsContent").load(
						param.contentValue,
						function() {
							MapBubble.initBubbleSize(param.bubbleWidth, param.bubbleHeight);
							callbackFunc();
							if ("undefined" != typeof callback
									&& callback != null && callback != "") {
								var func = eval(callback);
								func.call(func, makerParam["dataJson"]);
							}
						});
			}
		}
	},

	/**
	 * 根据事件类型执行参数中的事件代码
	 * 
	 * @param param
	 * @param eventType
	 */
	exeParamEventFunc : function(param, makerParam, eventType) {
		var eventFuncJson = param.eventFuncJson;
		if ("undefined" != typeof eventFuncJson
				&& "undefined" != typeof eventFuncJson[eventType]) {
			var func = eval(eventFuncJson[eventType]);
			func.call(func, makerParam["dataJson"]);
		}
	},

	/**
	 * 初始化气泡框
	 * 
	 * @param {String}
	 *            mapContainerId 地图容器id
	 */
	initBubble : function(mapContainerId) {
		var htmlStr = '<a href="javascript:MapBubble.showBubble();" class="revert_tipsbdy" id="revertTips"></a>'
				+ '<div class="tipsbdy" style="width:400px" id="tips">'
				+ '<a href="javascript:MapBubble.closeBubble();" title="关闭" class="tips_close"></a>'
				+ '<div class="tips" id="tipsContent"></div>'
				+ '<div class="tips_bt"><img src="/syrk/common/components/mapBalloon/images/tips_btjt.png" width="69" height="34" /></div>'
				+ '</div>';
		$("#" + mapContainerId).after(htmlStr);

	},

	/**
	 * 添加地图监听事件
	 */
	addMapEventListener : function(_MapApp) {
		_MapApp.addMapEventListener(EzEvent.MAP_CLICK, function(e) {
			//alert(MapBubble.isClickMarker)
			if (MapBubble.isExistBubble && MapBubble.isClickMarker) {
				//MapBubble.closeBubble();
				MapBubble.hideBubble();
			}
			MapBubble.isClickMarker = false;
			//TODO
			//MapBubble.hideBubble();
			return;
		});
		//TODO
		_MapApp.addMapEventListener(EzEvent.MAP_DBLCLICK, function(e) {
			MapBubble._MapApp.removeMapEventListener("mapdblclick");
			MapBubble.closeBubble();
			MapBubble.isClickMarker = false;
			return;
		});
		/*_MapApp.addMapEventListener(EzEvent.MAP_DBLCLICK, function(e) {
			if (MapBubble.isClickMarker) {
				MapBubble.isClickMarker = false;
				MapBubble._MapApp.removeMapEventListener("mapdblclick");
				return;
			} else {
				MapBubble._MapApp.recenterOrPanToLatLng(e.mapPoint);
				// MapBubble.setBubblePositionByMarker(MapBubble.currMarker);
			}
		});*/
		_MapApp.addMapEventListener(EzEvent.MAP_PANSTART, function(e) {
			MapBubble.setBubblePositionByMarker(MapBubble.currMarker);
		});
		_MapApp.addMapEventListener(EzEvent.MAP_PAN, function(e) {
			MapBubble.setBubblePositionByMarker(MapBubble.currMarker);
		});
		_MapApp.addMapEventListener(EzEvent.MAP_PANEND, function(e) {
			MapBubble.setBubblePositionByMarker(MapBubble.currMarker);
		});
		_MapApp.addMapEventListener(EzEvent.MAP_MOUSEWHEEL, function(e) {
			MapBubble.setBubblePositionByMarker(MapBubble.currMarker);
		});
		_MapApp.addMapEventListener(EzEvent.MAP_ZOOMSTART, function(e) {
			MapBubble.setBubblePositionByMarker(MapBubble.currMarker);
		});
		_MapApp.addMapEventListener(EzEvent.MAP_ZOOMCHANGE, function(e) {
			MapBubble.setBubblePositionByMarker(MapBubble.currMarker);
		});
		_MapApp.addMapEventListener(EzEvent.MAP_ZOOMEND, function(e) {
			ZoomMap.setSliderPosition();
			MapBubble.setBubblePositionByMarker(MapBubble.currMarker);
		});
		_MapApp.addMapEventListener(EzEvent.MAP_RESIZE, function(e) {
			MapBubble.setBubblePositionByMarker(MapBubble.currMarker);
		});
	},

	/**
	 * 隐藏气泡框
	 */
	hideBubble : function() {
		MapBubble.isExistBubble = false;
		//$("#tips").fadeOut(0);
		$("#tips").hide(0);
		var menulf = $(".rt_menu").offset().left;
		var menutop = $(".rt_menu").offset().top + $(".rt_menu").height() - 75;
		$("#revertTips").animate({
			left : menulf,
			top : menutop
		}).show();
	},

	/**
	 * 显示气泡框
	 */
	showBubble : function() {
		//$("#tips").fadeIn(0);
		MapBubble.isExistBubble = true;
		MapBubble.setBubblePositionByMarker(MapBubble.currMarker);
		MapBubble.isClickMarker = true;
		$("#tips").show(0);
		var tiplf = $("#tips").offset().left + $("#tips").width();
		var tiptop = $("#tips").offset().top;
		$("#revertTips").animate({
			left : tiplf,
			top : tiptop
		}).hide();
	},

	/**
	 * 关闭气泡框
	 */
	closeBubble : function() {
		$("#tips").hide(0);
		$("#revertTips").hide(0);
		MapBubble.isExistBubble = false;
		MapBubble.currMarker = null;
		//$("#tipsContent").empty();
		$("#tipsContent").html("");
		var callbacks = $.Callbacks();
		callbacks.add(this.loadContentToBubble);
		callbacks.add(this.initMarkerEventListener);
		callbacks.add(this.addMapEventListener);
		callbacks.empty();
		//$("#tipsContent").html("");
		/*$("#revertTips").hide();
		$("#tips").fadeOut(0);*/
		//Jqcz.hideLoateButton(); // by pan
	},

	/**
	 * 打开气泡框
	 * 
	 * @param param
	 *            {html:html代码,url:地址}
	 */
	openBubble : function(param) {
		MapBubble.isExistBubble = true;
		MapBubble.initBubbleSize(param.bubbleWidth,170);
		$(".inputtext,.tips_slect,textarea").bind("focus",function(){
			$(this).addClass("inputfocus");
		}).focusout(function(){
			$(this).removeClass("inputfocus");
		});
		/*
		$("#tips").fadeIn();
		$("#revertTips").hide();*/
		$("#tips").show(0);
		$("#revertTips").hide(0);
	},

	/**
	 * 取得点的像素坐标
	 */
	getMarkerPointXY : function(marker) {
		if (marker == null) {
			return null;
		}
		var point = marker.getPoint();
		var returnPointXY = MapBubble._MapApp.mapCoord2Container(point);
		return returnPointXY;
	},

	/**
	 * 根据marker点的像素坐标设置气泡位置
	 * 
	 * @param marker
	 */
	/*
	 * setBubblePositionByMarkerPointXY : function(pointXY) { if(pointXY==null) {
	 * return; } var x = pointXY.x - $("#tips").width() / 2; var y = pointXY.y -
	 * $("#tips").height() - 20; $("#tips").css({"left": x, "top": y}); },
	 */

	/**
	 * 根据marker设置气泡位置
	 * 
	 * @param marker
	 */
	setBubblePositionByMarker : function(marker) {
		if (marker == null || !MapBubble.isExistBubble) {
			return;
		}
		var point = marker.getPoint();
		var returnPointXY = MapBubble._MapApp.mapCoord2Container(point);
		//alert($("#tips").height());
		var x = returnPointXY.x - $("#tips").width() / 2;
		var y = returnPointXY.y - $("#tips").height() - 35;
		$("#tips").css({
			"left" : x,
			"top" : y
		});
	},

	/**
	 * 根据设置的maker打开气泡后的移动模式移动地图
	 * 
	 * @param marker
	 * @param param
	 */
	/*
	 * setMarkerPostion : function(pointXY,param) { if(pointXY==null) { return
	 * false; } if(param.moveMode == "movetoshow") { var markerY = pointXY.y;
	 * var bubbleHeight = param.bubbleHeight; if(markerY < bubbleHeight) {
	 * alert(markerY - bubbleHeight); MapBubble._MapApp.pan(0, markerY -
	 * bubbleHeight); return true; } } else if(param.moveMode == "movetocenter") {
	 * MapBubble._MapApp.recenterOrPanToLatLng(point); return true; } return
	 * false; },
	 */

	setMarkerPostion : function(marker, param, callback) {
		if (marker == null) {
			return;
		}
		var point = marker.getPoint();
		var pointXY = MapBubble._MapApp.mapCoord2Container(point);
		var mapWidth = parseInt(document.getElementById(MapBubble.mapDivId).clientWidth);
		var mapHeight = parseInt(document.getElementById(MapBubble.mapDivId).clientHeight);
		//var bubbleHeight = param.bubbleHeight;
		//var bubbleWidth = param.bubbleWidth;
		
		
		var bubbleHeight = parseInt($("#tips").height());
		var bubbleWidth = parseInt($("#tips").width());

		if (param.moveMode == "movetoshow") {
			var markerY = pointXY.y;
			var markerX = pointXY.x;
			var v = MapBubble.distanceBorderPx;
			var passTop = markerY - bubbleHeight;
			var passLeft = markerX - (bubbleWidth / 2);
			var passRight = (mapWidth - (bubbleWidth / 2) - markerX);
			if (passTop < mapHeight && passTop < 0 && passLeft >= 0 && passRight >= 0) {
				MapBubble.pan(0, passTop - v - 20, callback);
			} else if (passTop < mapHeight && passLeft < 0 && passTop >= 0) {
				MapBubble.pan(-passLeft + v, 0, callback);
			} else if (passTop < mapHeight && passRight < 0 && passTop >= 0) {
				MapBubble.pan(passRight - v, 0, callback);
			} else if (passTop < mapHeight && passLeft < 0 && passTop < 0) {
				MapBubble.pan(-passLeft + v, passTop - v - 20, callback);
			} else if (passTop < mapHeight && passRight < 0 && passTop < 0) {
				MapBubble.pan(passRight - v, passTop - v - 20, callback);
			} else if(passTop > mapHeight && passLeft <= 0) {
				MapBubble.pan(-passLeft + v, passTop - mapHeight + bubbleHeight + 20, callback);
			} else if(passTop > mapHeight && passRight <= 0) {
				MapBubble.pan(passRight - v, passTop - mapHeight + bubbleHeight + 20, callback);
			} else if(passTop > mapHeight && passLeft > 0 && passRight > 0) {
				MapBubble.pan(0, passTop - mapHeight + bubbleHeight + 20, callback);
			} else{
				MapBubble.pan(0, 0, callback);
			}
		} else if (param.moveMode == "movetocenter") {
			MapBubble.recenterOrPanToLatLng(point, callback);
		} else if (param.moveMode == "movetobubblecenter") {
			var markerY = pointXY.y;
			var markerX = pointXY.x;
			var moveX = mapWidth / 2 - markerX;
			//var moveY = ((mapHeight - bubbleHeight -35) / 2) + markerY - mapHeight;
			var moveY = markerY - (bubbleHeight + 35 +10);
			MapBubble.pan(moveX, moveY, callback);
		}
	},

	/**
	 * 移动气泡小图标位置--右侧调用
	 */
	move_revertbtn : function() {
		var bodyrt = $(".body_rt").css("right");
		var rtwidth = $(".body_rt").width();
		var menulf = $(".rt_menu").offset().left;
		var menutop = $(".rt_menu").offset().top + $(".rt_menu").height() - 75;
		if ($("#tips").is(":hidden")) {
			if ($(".revert_tipsbdy").is(":hidden")) {
				if (MapBubble.isExistBubble != false) {
					$("#revertTips").show();
					$("#revertTips").animate({
						left : menulf,
						top : menutop
					});
				} else {
					$("#revertTips").hide();
				}
			} else {
				if (bodyrt == "0px") {
					$("#revertTips").animate({
						left : menulf + rtwidth,
						top : menutop
					}, 568);
				} else {
					$("#revertTips").animate({
						left : menulf - rtwidth,
						top : menutop
					}, 568);
				}
			}
		}
	},
	/**
	 * 移动气泡小图标位置--左侧调用
	 */
	lfmove_revertbtn : function() {
		var menuoffsetnew = MapBubble.menuoffset + $(".body_rt").width();
		//var menulf = $(".rt_menu").offset().left;
		//var menutop = $(".rt_menu").offset().top + $(".rt_menu").height() - 75;
		var menulf = 70;
		var menutop = 250;
		if ($("#tips").is(":hidden")) {
			if ($(".revert_tipsbdy").is(":hidden")) {
				if (MapBubble.isExistBubble != false) {
					$("#revertTips").show();
					$("#revertTips").animate({
						left : menulf,
						top : menutop
					});
				} else {
					$("#revertTips").hide();
				}
			} else {
				$("#revertTips").animate({
					left : menuoffsetnew,
					top : menutop
				}, 568);
			}
		}
	},

	/**
	 * 缩放地图到指定层级
	 * 
	 * @param level
	 */
	zoomToLevel : function(level) {
		this._MapApp.zoomTo(level);
	},

	/**
	 * 在地图上一marker周边绘制多个圈
	 * 
	 * @param marker
	 * @param radiusArray
	 * @param colorArray
	 * @param fillcolorArray
	 * @param isFlash
	 */
	addManyCircle : function(marker, radiusArray, colorArray, fillcolorArray,
			isFlash) {
		var point = marker.getPoint();
		var circlePoint = "";
		this.removeCircle();
		for ( var i = 0; i < radiusArray.length; i++) {
			circlePoint = point.x + "," + point.y + ","
					+ this.getDegree(marker, radiusArray[i]);
			var circle = new Circle(circlePoint, colorArray[i], 2, 0.3,
					fillcolorArray[i]);
			this._MapApp.addOverlay(circle);
			if (isFlash) {
				circle.flash(3);
			}
			this.circleArray.push(circle);
		}
	},

	/**
	 * 取得最大的圈
	 * 
	 * @param marker
	 * @param radiusArray
	 */
	getMaxCirclePointFromManyCircle : function(marker, radiusArray) {
		var point = marker.getPoint();
		//return point.x + "," + point.y + "," + this.getDegree(marker, radiusArray[radiusArray.length - 1]);
		return point.x + "," + point.y + "," + this.getDegree(marker, radiusArray[0]);
	},

	/**
	 * 周边查询距离，单位为度
	 * 
	 * @param marker
	 * @param radius
	 * @returns
	 */
	getDegree : function(marker, radius) {
		return this._MapApp.getDegree(marker.getPoint(), radius);
	},

	/**
	 * 删除叠加在地图上的以marker对象为圆心的圆
	 */
	removeCircle : function() {
		for ( var i = 0; i < this.circleArray.length; i++) {
			this._MapApp.removeOverlay(this.circleArray[i]);
			if (i == this.circleArray - 1) {
				this.circleArray = new Array();
			}
		}
	},

	/**
	 * 删除叠加在地图上的周边查询结果marker对象
	 */
	removeAroundMarker : function() {
		for ( var i = 0; i < this.aroundMarkerArray.length; i++) {
			this._MapApp.removeOverlay(this.aroundMarkerArray[i]);
			if (i == this.aroundMarkerArray - 1) {
				this.aroundMarkerArray = new Array();
			}
		}
	},

	/**
	 * 清除地图所有对象
	 */
	removeAll : function() {
		this._MapApp.clear();
		this.circleArray = new Array();
		this.aroundMarkerArray = new Array();
		this.currMarker = null;
		this.closeBubble();
		try{
			Ssjl.clear();
		}catch(e){}
		try{
			var gps = new Gps();
			gps.clear();
		}catch(e){}
		try{
			Jcxx.clear();
			Jqxx.currentPointObject=[null,{}];//清空当前警情信息对象变量
			Jcxx.disableFunc();//禁用于警情相关的样式以及功能
		}catch(e){}
	},

	/**
	 * 清除非首次叠加的图层对象
	 */
	removeNotFirstLoadLayer : function() {
		this.removeCircle();
		this.removeAroundMarker();
		this.currMarker = null;
		this.closeBubble();
	},
	/**
	 * 重新定位
	 * @param marker
	 * @param x
	 * @param y
	 * @param callback
	 */
	relocation : function(marker, x, y, callback) {
		var point = new Point(x, y);
		marker.setPoint(point);
		callback(marker);
	},
	
	/**
	 * 添加自动平移事件
	 * @param callback
	 */
	addPanOverListener : function(callback) {
		var point;
		var pointZbX_1 = '';
		var pointZbY_1 = '';
		var pointZbX_2;
		var pointZbY_2;
		var panTimer = null;
		panTimer = setInterval(function() {
			point = this._MapApp.getCenterLatLng();
			pointZbX_2 = point.x;
			pointZbY_2 = point.y;
			if(pointZbX_2 == pointZbX_1 && pointZbY_2 == pointZbY_1) {
				clearInterval(panTimer);
				panTimer = null;
				callback();
			}
			pointZbX_1 = pointZbX_2;
			pointZbY_1 = pointZbY_2;
		},'100');
	},
	
	/**
	 * 重写平移事件（增加了回调事件）
	 * @param x
	 * @param y
	 * @param callback
	 */
	pan : function(x, y, callback) {
		if(x != 0 || y != 0) {
			this._MapApp.pan(x,y);
			this.addPanOverListener(callback);
		} else {
			callback();
		}
	},
	
	/**
	 * 重写地图对中到指定点
	 * @param pt Point对象
	 * @param callback
	 */
	recenterOrPanToLatLng : function(pt, callback) {
		this._MapApp.recenterOrPanToLatLng(pt);
		this.addPanOverListener(callback);
	},
	
	/**
	 * 清除缩放结束事件（但需要加入地图气泡的默认该类事件）
	 */
	clearMapZoomendEventListeners : function() {
		this._MapApp.clearMapInstanceEventListeners("mapzoomend");
		this._MapApp.addMapEventListener(EzEvent.MAP_ZOOMEND, function(e) {
			ZoomMap.setSliderPosition();
			MapBubble.setBubblePositionByMarker(MapBubble.currMarker);
		});
	}
	
};