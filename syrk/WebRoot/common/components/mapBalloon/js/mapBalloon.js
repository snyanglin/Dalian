/*!
 * 地图气泡框组件
 * znjg - v1.0.0 (2014-03-18 08:36)
 * Copyright(c) 2014 founder
 * 
 * 本组件依赖jquery.min.js、SysTool.js及EzMapAPI.js
 * 
 * 初始化调用示例：MapBalloon.init({mapApp: _MapApp, mapContainerId: "mapContainer"});
 * 初始化调用函数参数说明：@param {Object} param JSON对象（包括：mapApp 地图对象，mapContainerId 地图容器id）
 * 
 * 
 * 注册marker事件调用示例：MapBalloon.bindingMarkerEvent({mapToolId: "mapTool",marker: marker3, htmlPath: "tips.html", isCenter: true});
 * 注册marker事件调用函数参数说明：@param {Object} param JSON对象（包括：mapToolId 地图工具条id，marker marker对象，htmlPath html路径，isCenter 点击marker时超屏幕是否居中。） 
 *                                @param {Function} callback 回调函数
 */

/**
 * 加载地图气泡框组件相关CSS
 */
SysTool.loadComponentsFile("mapBalloon", "mapBalloon", ".css");
/**
 * @classDescription 地图气泡框全局对象
 * @author yichu
 */
var MapBalloon = {
		
	/**
	 * 地图对象
	 */
	MapApp : {},
	
	/**
	 * 是否存在气泡框
	 */
	isExist : false,
	
	/**
	 * 当前marker对象
	 */
	currMarker : null,
	
	/**
	 * 点击的是否是marker对象
	 */
	isClickMarker : false,
	
	/**
	 * 气泡框是否是隐藏的
	 */
	isHiddenMapBalloon : true,
	
	/**
	 * 重新设置地图气泡框位置，x坐标偏移像素
	 */
	xOffsetPx : 60,
	
	/**
	 * 重新设置地图气泡框位置，y坐标偏移像素
	 */
	yOffsetPx : 30,	
	menuoffset:0,
	/**
	 * 初始化
	 * @param {Object} param JSON对象（包括：mapApp 地图对象，mapContainerId 地图容器id）
	 */
	init : function(param) {
		this.initBalloon(param.mapContainerId);
		this.MapApp = param.mapApp;
		this.MapApp.addMapEventListener(EzEvent.MAP_CLICK, function(e) {
			MapBalloon.isHiddenMapBalloon = $("#tips").is(":hidden");
			MapBalloon.hideBalloon();
		});
		
		this.MapApp.addMapEventListener(EzEvent.MAP_DBLCLICK, function(e) {
			if (MapBalloon.isClickMarker) {
				MapBalloon.isClickMarker = false;
				MapBalloon.MapApp.removeMapEventListener(e.eventType);
				return;
			}
			if (MapBalloon.currMarker != null) {
				MapBalloon.changeMapBalloonPosition(MapBalloon.MapApp.getCenterLatLng(), e.mapPoint);
				MapBalloon.MapApp.recenterOrPanToLatLng(e.mapPoint);
				if (!MapBalloon.isHiddenMapBalloon) {
					setTimeout("MapBalloon.showBalloon();", 5);
					MapBalloon.isHiddenMapBalloon = false;
				}
				MapBalloon.MapApp.removeMapEventListener(e.eventType);
			}
		});
		
		this.MapApp.addMapEventListener(EzEvent.MAP_PAN, function(e) {
			if (MapBalloon.currMarker != null) {
				if ($("#revertTips").is(":hidden")) {
					$("#tips").hide();
					MapBalloon.setMapBalloonPosition(MapBalloon.currMarker.getPoint());
					$("#tips").show();
				} else {
					MapBalloon.setMapBalloonPosition(MapBalloon.currMarker.getPoint());
				}
			}
		});
		
		this.MapApp.addMapEventListener(EzEvent.MAP_MOUSEWHEEL, function(e) {
			if (MapBalloon.currMarker != null) {
				if ($("#revertTips").is(":hidden")) {
					$("#tips").hide();
				}
			}
		});
		
		this.MapApp.addMapEventListener(EzEvent.MAP_ZOOMSTART, function(e) {
			if (MapBalloon.currMarker != null) {
				if ($("#revertTips").is(":hidden")) {
					$("#tips").hide();
				}
			}
		});
		
		this.MapApp.addMapEventListener(EzEvent.MAP_ZOOMCHANGE, function(e) {
			if (MapBalloon.currMarker != null) {
				if ($("#revertTips").is(":hidden")) {
					MapBalloon.setMapBalloonPosition(MapBalloon.currMarker.getPoint());
					$("#tips").show();
				} else {
					MapBalloon.setMapBalloonPosition(MapBalloon.currMarker.getPoint());
				}
			}
		});
		
		this.MapApp.addMapEventListener(EzEvent.MAP_ZOOMEND, function(e) {
			if (MapBalloon.currMarker != null) {
				if ($("#revertTips").is(":hidden")) {
					MapBalloon.setMapBalloonPosition(MapBalloon.currMarker.getPoint());
					$("#tips").show();
				} else {
					MapBalloon.setMapBalloonPosition(MapBalloon.currMarker.getPoint());
				}
			}
		});
	},
	
    /**
	 * 初始化气泡框
	 * @param {String} mapContainerId 地图容器id
	 */
	initBalloon : function(mapContainerId) {
		var htmlStr = '<a href="javascript:MapBalloon.showBalloon();" class="revert_tipsbdy" id="revertTips"></a>'
			          + '<div class="tipsbdy" style="width:400px" id="tips">'
		              + '<a href="javascript:MapBalloon.closeBalloon();" title="关闭" class="tips_close"></a>'
		              + '<div class="tips" id="tipsContent"></div>'
		              + '<div class="tips_bt"><img src="/syrk/common/components/mapBalloon/images/tips_btjt.png" width="69" height="34" /></div>'
	                  + '</div>';
		$("#" + mapContainerId).after(htmlStr);
	},
	
	/**
	 * 隐藏气泡框
	 */
	hideBalloon : function() {
		$("#tips").fadeOut();
		if (this.isExist) {
			$("#revertTips").show();
			var menulf=$(".rt_menu").offset().left;
			var menutop=$(".rt_menu").offset().top + $(".rt_menu").height()-75;
			$("#revertTips").animate({left:menulf,top:menutop});
		}
	},

	/**
	 * 移动气泡小图标位置--右侧调用
	 */
	move_revertbtn:function(){
		var bodyrt=$(".body_rt").css("right");
		var rtwidth=$(".body_rt").width();
		var menulf=$(".rt_menu").offset().left;
		var menutop=$(".rt_menu").offset().top + $(".rt_menu").height()-75;
		if($("#tips").is(":hidden")){
			if($(".revert_tipsbdy").is(":hidden")){
				if(MapBalloon.isExist != false){
				$("#revertTips").show();
				var menulfb=$(".rt_menu").offset().left;
				$("#revertTips").animate({left:menulf,top:menutop});
				}else{
					$("#revertTips").hide();
				}
			}else{
				if(bodyrt =="0px"){
					$("#revertTips").animate({left:menulf + rtwidth,top:menutop},568);
				}else{
					$("#revertTips").animate({left:menulf - rtwidth,top:menutop},568);
				}
			}
		}
	},
	/**
	 * 移动气泡小图标位置--左侧调用
	 */
	lfmove_revertbtn:function(){
		var menuoffset=MapBalloon.menuoffset;
		var menuoffsetnew=MapBalloon.menuoffset + $(".body_rt").width();
		var menulf=$(".rt_menu").offset().left;
		var menutop=$(".rt_menu").offset().top + $(".rt_menu").height()-75;
		if($("#tips").is(":hidden")){
			if($(".revert_tipsbdy").is(":hidden")){
				if(MapBalloon.isExist != false){
				$("#revertTips").show();
				var menulfb=$(".rt_menu").offset().left;
				$("#revertTips").animate({left:menulf,top:menutop});
				}else{
					$("#revertTips").hide();
				}
			}else{
					$("#revertTips").animate({left:menuoffsetnew,top:menutop},568);
			}
		}
	},
	/**
	 * 显示气泡框
	 */
	showBalloon : function() {
		$("#tips").fadeIn();
		var tiplf=$("#tips").offset().left + $("#tips").width();
		var tiptop=$("#tips").offset().top;
		$("#revertTips").animate({left:tiplf,top:tiptop}).hide();
	},
	
	/**
	 * 关闭气泡框
	 */
	closeBalloon : function() {
		$("#tipsContent").load("", function() {
			$("#revertTips").hide();
			$("#tips").fadeOut();
			MapBalloon.isExist = false;
			MapBalloon.currMarker = null;
		});
	},
	
	/**
	 * 打开气泡框
	 * @param {Object} param JSON对象（包括：htmlPath html路径，htmlString html字符串，callback 回调函数。）
	 */
	openBalloon : function(param) {
		var htmlPath = param.htmlPath;
		var htmlString = param.htmlString;
		if ("undefined" != typeof htmlPath && htmlPath != null && htmlPath != "") {
			$("#tipsContent").load(param.htmlPath, function() {
				$("#revertTips").hide();
				$("#tips").show();
				MapBalloon.isExist = true;
				$(".inputtext,.tips_slect,textarea").bind("focus",function(){
					$(this).addClass("inputfocus");
				}).focusout(function(){
					$(this).removeClass("inputfocus");
				});
				param.callback();
			});
		} else if ("undefined" != typeof htmlString && htmlString != null && htmlString != "") {
			$("#tipsContent").html(htmlString);
			$("#revertTips").hide();
			$("#tips").show();
			MapBalloon.isExist = true;
			param.callback();
		}
	},
	
	/**
	 * 获取气泡框中的html
	 */
	getBalloonHtml : function() {
		return $("#tipsContent").html();
	},
	
	/**
	 * 注册marker事件
	 * @param {Object} param JSON对象（包括：mapToolId 地图工具条id，marker marker对象，htmlPath html路径，htmlString html字符串，isCenter 点击marker时超屏幕是否居中，enevtType 事件类型（可以不传）。）
	 * @param {Function} callback 回调函数
	 */
	bindingMarkerEvent : function(param, callback) {
		var bindingEventType = "click";
		if ("undefined" != typeof param.enevtType && param.enevtType != null && param.enevtType != "") {
			bindingEventType = param.enevtType;
		}
		param.marker.addListener(bindingEventType, function() {
			MapBalloon.isClickMarker = true;
			if (MapBalloon.currMarker == null) {
				MapBalloon.openBalloon({htmlPath: param.htmlPath, htmlString: param.htmlString, callback: function() {
					MapBalloon.setMapBalloonPosition(param.marker.getPoint());
					MapBalloon.resetMapBalloonPosition(param.marker.getPoint(), param.isCenter, param.mapToolId);
					callback();
				}});
			} else {
				if (MapBalloon.currMarker.getPoint().x == param.marker.getPoint().x  && MapBalloon.currMarker.getPoint().y == param.marker.getPoint().y) {
					MapBalloon.showBalloon();
					MapBalloon.resetMapBalloonPosition(param.marker.getPoint(), param.isCenter, param.mapToolId);
				} else {
					MapBalloon.openBalloon({htmlPath: param.htmlPath, htmlString: param.htmlString, callback: function() {
						MapBalloon.setMapBalloonPosition(param.marker.getPoint());
						MapBalloon.resetMapBalloonPosition(param.marker.getPoint(), param.isCenter, param.mapToolId);
						callback();
					}});
				}
			}
			MapBalloon.currMarker = param.marker;
		});
	},
	
	/**
	 * 设置地图气泡框位置
	 * @param {Object} point point对象
	 */
	setMapBalloonPosition : function(point) {
		var returnPoint = MapBalloon.MapApp.mapCoord2Container(point);
		var x = returnPoint.x - $("#tips").width() / 2;
		var y = returnPoint.y - $("#tips").height();
		$("#tips").css({"left": x, "top": y});
	},
	
	/**
	 * 设置滑动效果地图气泡框位置
	 * @param {Object} point point对象
	 */
	setTravelingMapBalloonPosition : function(point) {
		var returnPoint = MapBalloon.MapApp.mapCoord2Container(point);
		var x = returnPoint.x - $("#tips").width() / 2;
		var y = returnPoint.y - $("#tips").height();
		$("#tips").animate({"left": x, "top": y}, 300);
	},
	/**
	 * /**
	 * 设置滑动效果地图气泡框位置
	 * @param {Object} pointX X坐标
	 * @param {Object} pointY Y坐标 
	 */
	addMapBalloonPosition : function(pointX, pointY) {
		var point = new Point(pointX, pointY);
		MapBalloon.setTravelingMapBalloonPosition(point);
	},
	/**
	 * 改变地图气泡框位置
	 * @param {Object} centerPoint 中心点对象
	 * @param {Object} mapPoint 地图点对象
	 */
	changeMapBalloonPosition : function(centerPoint, mapPoint) {
		var returnCenterPoint = MapBalloon.MapApp.mapCoord2Container(centerPoint);
		var returnMapPoint = MapBalloon.MapApp.mapCoord2Container(mapPoint);
		var disparityX = returnMapPoint.x - returnCenterPoint.x;
		var disparityY = returnMapPoint.y - returnCenterPoint.y;
		var x = parseInt($("#tips").css("left")) - disparityX;
		var y = parseInt($("#tips").css("top")) - disparityY;
		$("#tips").css({"left": x, "top": y});
	},
	
	/**
	 * 重新设置地图气泡框位置
	 * @param {Object} point point对象
	 * @param {boolean}	isCenter 超屏幕是否居中
	 * @param {String} mapToolId 地图工具条id
	 */
	resetMapBalloonPosition : function(point, isCenter, mapToolId) {
		var x = parseInt($("#tips").css("left"));
		var y = parseInt($("#tips").css("top"));
		if (y < 0 || x < 0 || x > (screen.availWidth - $("#tips").width())) {
			if (isCenter) {
				this.hideBalloon();
				this.MapApp.recenterOrPanToLatLng(point);
				this.setMapBalloonPosition(this.MapApp.getCenterLatLng());
				setTimeout("MapBalloon.showBalloon();", 500);
			} else {
				if (y < 0 || x < 0 || x > (screen.availWidth - $("#tips").width())) {
					var xOffset = 0;
					var yOffset = 0;
					yOffset = -y;
					if (x < 0) {
						xOffset = -x;
						this.MapApp.pan((-x + this.xOffsetPx), (y - $("#" + mapToolId).height() - this.yOffsetPx));
						$("#tips").animate({"left": (x + xOffset + this.xOffsetPx), "top": (y + yOffset + $("#" + mapToolId).height() + this.yOffsetPx)}, "300");
					} else if (x > (screen.availWidth - $("#tips").width())) {
						xOffset = x - (screen.availWidth - $("#tips").width());
						this.MapApp.pan((-xOffset - this.xOffsetPx), (y - $("#" + mapToolId).height() - this.yOffsetPx));
						$("#tips").animate({"left": (x - xOffset - this.xOffsetPx), "top": (y + yOffset + $("#" + mapToolId).height() + this.yOffsetPx)}, "300");
					} else {
						this.MapApp.pan(0, (y - $("#" + mapToolId).height() - this.yOffsetPx));
						$("#tips").animate({"left": (x + xOffset), "top": (y + yOffset + $("#" + mapToolId).height() + this.yOffsetPx)}, "300");
					}
				}
			}
		}
	},
	
	/**
	 * 获取气泡框对应的当前marker对象
	 * @returns marker对象
	 */
	getMapBalloonCurrMarker : function() {
		return this.currMarker;
	}
	
};