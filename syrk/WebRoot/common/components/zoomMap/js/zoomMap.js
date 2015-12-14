/*!
 * 地图缩放组件
 * znjg - v1.0.0 (2014-03-18 08:36)
 * Copyright(c) 2014 founder
 * 
 * 本组件依赖jquery.min.js、SysTool.js及EzMapAPI.js
 * 
 * 初始化调用示例：ZoomMap.init({mapApp: _MapApp, mapContainerId: "mapContainer"});
 * 初始化调用函数参数说明：@param {Object} param JSON对象（包括：mapApp 地图对象，mapContainerId 地图容器id）
 * 
 * 设置缩放工具距离页面左边的位置调用示例：ZoomMap.setZoomToolLeftPosition(50);
 * 设置缩放工具距离页面左边的位置调用函数参数说明：@param {Int} pxNumber 像素数
 * 
 * 设置缩放工具距离页面顶部的位置调用示例：ZoomMap.setZoomToolTopPosition(10);
 * 设置缩放工具距离页面顶部的位置调用函数参数说明：@param {Int} pxNumber 像素数
 */

/**
 * 加载地图缩放组件相关CSS
 */
SysTool.loadComponentsFile("zoomMap", "zoomMap", ".css");

/**
 * @classDescription 地图缩放全局对象
 * @author yichu
 */
var ZoomMap = {
	
	/**
	 * 地图对象
	 */
	MapApp : {},
	
	/**
	 * 缩放级别
	 */
	zoomLevel : 0, 
	
	/**
	 * 缩放最大级别
	 */
	zoomMaxLevel : 0, 
	
	/**
	 * 缩放最小级别
	 */
	zoomMinLevel : 0, 
	
	/**
	 * 滑块滑动像素
	 */
	slipPx : 0,
	
	/**
	 * 标记拖曳状态
	 */
	dragging : false,
	
	/**
	 * 初始滑块位置（css中top的值）
	 */	
	top : 0,
	
	/**
	 * 初始鼠标位置(在屏幕上的纵坐标位置pageY)
	 */
	pageY : 0,
	
	/**
	 * 当前鼠标位置(在屏幕上的纵坐标位置pageY)
	 */
	currPageY : 0,
	
	/**
	 * 初始化
	 * @param {Object} param JSON对象（包括：mapApp 地图对象，mapContainerId 地图容器id）
	 */
	init : function(param) {
		this.MapApp = param.mapApp;
		this.zoomLevel = this.MapApp.getZoomLevel();
		this.zoomMinLevel = 0;
		this.zoomMaxLevel = this.MapApp.getMaxLevel();
		this.MapApp.addMapEventListener(EzEvent.MAP_ZOOMEND, function(e) {
			ZoomMap.setSliderPosition();
		});
		this.initZoomTool(param.mapContainerId);
		this.slipPx = $("#sliderDiv").height() / (this.zoomMaxLevel + 1);
		this.slipSlider("slider");
	},
	
	/**
	 * 初始化缩放工具
	 * @param {String} mapContainerId 地图容器id
	 */
	initZoomTool : function(mapContainerId) {
		var htmlStr = '<div class="maptools_div">'
			+ '<div class="tool_direction">'
			+ '<a class="tool_north" href="javascript:ZoomMap.MapApp.pan(0, -screen.availHeight/2)" title="向上平移"></a>'
			+ '<a class="tool_east" href="javascript:ZoomMap.MapApp.pan(-screen.availWidth/2, 0)" title="向右平移"></a>'
			+ '<a class="tool_south" href="javascript:ZoomMap.MapApp.pan(0, screen.availHeight/2)" title="向下平移"></a>'
			+ '<a class="tool_west" href="javascript:ZoomMap.MapApp.pan(screen.availWidth/2, 0)" title="向左平移"></a>'
			+ '</div>'
			+ '<a class="tool_zoom" href="javascript:ZoomMap.zoomInMap(\'slider\')" title="放大一级"></a>'
			+ '<div id="sliderDiv" class="sliderdiv">'
			+ '<a id="slider" class="tool_contro" href="javascript:void(0)" title="拖动缩放"></a>'
			+ '<a id="sliderbar" class="tool_track" href="javascript:void(0)" title="放置到此级别"></a>'
			+ '</div>'
			+ '<a class="tool_narrow" href="javascript:ZoomMap.zoomOutMap(\'slider\')" title="缩小一级"></a>'
			+ '</div>';
		$("#" + mapContainerId).after(htmlStr);
		
		/* 方向按钮效果 */
		var tool_direction=$(".tool_direction");
		var tool_north=$(".tool_north");
		var tool_west=$(".tool_west");
		var tool_east=$(".tool_east");
		var tool_south=$(".tool_south");
		tool_north.mouseover(function() {
			tool_direction.addClass("tool_bgn");
		});
		tool_north.mouseout(function() {
			tool_direction.removeClass("tool_bgn");
		});
		tool_west.mouseover(function() {
			tool_direction.toggleClass("tool_bgw");
		});
		tool_west.mouseout(function() {
			tool_direction.removeClass("tool_bgw");
		});
		tool_east.mouseover(function() {
			tool_direction.toggleClass("tool_bge");
		});
		tool_east.mouseout(function() {
			tool_direction.removeClass("tool_bge");
		});
		tool_south.mouseover(function() {
			tool_direction.toggleClass("tool_bgs");
		});
		tool_south.mouseout(function() {
			tool_direction.removeClass("tool_bgs");
		});
		
		this.draggingSlider("sliderDiv", "slider", "sliderbar");
		this.clickSliderbar("sliderDiv", "slider", "sliderbar");
	},
	
	/**
	 * 设置滑块位置
	 */
	setSliderPosition: function() {
		if (this.MapApp.getZoomLevel() >= this.zoomMinLevel && this.MapApp.getZoomLevel() <= this.zoomMaxLevel) {
			this.zoomLevel = this.MapApp.getZoomLevel();
			this.slipSlider("slider");
		}
	},
	
	/**
	 * 设置缩放工具距离页面左边的位置
	 * @param {Int} pxNumber 像素数
	 */
	setZoomToolLeftPosition : function(pxNumber) {
		$(".maptools_div").animate({left : pxNumber});
	},
	
	/**
	 * 获取缩放工具距离页面左边的位置
	 */
	getZoomToolLeftPosition : function() {
		return parseInt($(".maptools_div").css("left"));
	},
	
	/**
	 * 设置缩放工具距离页面顶部的位置
	 * @param {Int} pxNumber 像素数
	 */
	setZoomToolTopPosition : function(pxNumber) {
		$(".maptools_div").animate({top : pxNumber});
	},
	
	/**
	 * 获取缩放工具距离页面顶部的位置
	 */
	getZoomToolTopPosition : function() {
		return parseInt($(".maptools_div").css("top"));
	},
		
	/**
	 * 滑动滑块
	 * @param {String} sliderId 滑块Id
	 */
	slipSlider : function(sliderId) {
		$("#" + sliderId).animate({top:((this.zoomMaxLevel - this.zoomLevel) * this.slipPx)}, 0);
	},
	
	/**
	 * 地图放大一个级别
	 * @param {String} sliderId 滑块Id
	 */
	zoomInMap : function(sliderId) {
		if (this.MapApp.getZoomLevel() < this.zoomMaxLevel) {
			this.zoomLevel = this.MapApp.getZoomLevel() + 1;
			this.MapApp.zoomIn();
			this.slipSlider(sliderId);
		}
	},
	
	/**
	 * 地图缩小一个级别
	 * @param {String} sliderId 滑块Id
	 */
	zoomOutMap : function(sliderId) {
		if (this.MapApp.getZoomLevel() > this.zoomMinLevel) {
			this.zoomLevel = this.MapApp.getZoomLevel() - 1;
			this.MapApp.zoomOut();
			this.slipSlider(sliderId);
		}
	},
	
	/**
	 * 拖拽滑块
	 * @param {String} sliderDivId 滑块div id
	 * @param {String} sliderId 滑块Id
	 * @param {String} sliderbarId 滑条Id
	 */
	draggingSlider : function(sliderDivId, sliderId, sliderbarId) {
		var mysliderId=$("#" + sliderId);
		mysliderId.mousedown(function(e) {
			ZoomMap.dragging = true;
			ZoomMap.top = parseInt(mysliderId.css("top"));
			ZoomMap.pageY = e.pageY;
        	return false;
       	});
		mysliderId.mousemove(function(e) {
           	if (ZoomMap.dragging) {
           		ZoomMap.currPageY = e.pageY;
           		if ((ZoomMap.top + ZoomMap.currPageY - ZoomMap.pageY) >= 0 && (ZoomMap.top + ZoomMap.currPageY - ZoomMap.pageY) <= (ZoomMap.slipPx * ZoomMap.zoomMaxLevel)) {
           			mysliderId.css("top", ZoomMap.top + ZoomMap.currPageY - ZoomMap.pageY);
           		}
           		return false;
           	}
    	});
		mysliderId.mouseup(function(e) {
   			ZoomMap.dragging = false;
   			var currTop = parseInt(mysliderId.css("top"));// 拖拽后滑块位置（css中top的值）
   			var changeLevel = 0;// 改变的级别
   			if (currTop > ZoomMap.top) {
   				changeLevel = Math.floor((currTop - ZoomMap.top) / ZoomMap.slipPx) + 1;
   				ZoomMap.zoomLevel = ZoomMap.zoomLevel - changeLevel;
   				ZoomMap.MapApp.zoomTo(ZoomMap.zoomLevel);
   			} else if (currTop < ZoomMap.top) {
   				changeLevel = Math.floor((ZoomMap.top - currTop - (mysliderId.height() / 2)) / ZoomMap.slipPx) + 1;
   				if (parseInt(mysliderId.css("top")) >= 0 && parseInt(mysliderId.css("top")) <= (ZoomMap.slipPx / 2)) {
   					ZoomMap.zoomLevel = ZoomMap.zoomMaxLevel;
   				} else {
   					ZoomMap.zoomLevel = ZoomMap.zoomLevel + changeLevel;
   				}
   				ZoomMap.MapApp.zoomTo(ZoomMap.zoomLevel);
   			} else {
   				ZoomMap.MapApp.zoomTo(ZoomMap.zoomLevel);
   			}
   			ZoomMap.slipSlider(sliderId);
       	});
		mysliderId.mouseout(function(e) {
    		if (ZoomMap.dragging) {
    			ZoomMap.dragging = false;
       			var currTop = parseInt(mysliderId.css("top"));// 拖拽后滑块位置（css中top的值）
       			var changeLevel = 0;// 改变的级别
       			if (currTop > ZoomMap.top) {
       				changeLevel = Math.floor((currTop - ZoomMap.top) / ZoomMap.slipPx) + 1;
       				ZoomMap.zoomLevel = ZoomMap.zoomLevel - changeLevel;
       				ZoomMap.MapApp.zoomTo(ZoomMap.zoomLevel);
       			} else if (currTop < ZoomMap.top) {
       				changeLevel = Math.floor((ZoomMap.top - currTop - (mysliderId.height() / 2)) / ZoomMap.slipPx) + 1;
       				ZoomMap.zoomLevel = ZoomMap.zoomLevel + changeLevel;
       				ZoomMap.MapApp.zoomTo(ZoomMap.zoomLevel);
       			} else {
       				ZoomMap.MapApp.zoomTo(ZoomMap.zoomLevel);
       			}
       			ZoomMap.slipSlider(sliderId);
    		}
       	});
	},
	
	/**
	 * 点击滑条
	 * @param {String} sliderDivId 滑块div id
	 * @param {String} sliderId 滑块Id
	 * @param {String} sliderbarId 滑条Id
	 */
	clickSliderbar : function(sliderDivId, sliderId, sliderbarId) {
       	$("#" + sliderbarId).click(function(e) {
       		ZoomMap.currPageY = e.pageY;
       		var sliderDivTop = $("#" + sliderDivId).offset().top;// 滑块div距离页面顶部的距离
       		if ((ZoomMap.currPageY - sliderDivTop) >= 0 && (ZoomMap.currPageY - sliderDivTop) <= $("#" + sliderDivId).height()) {
       			var changeLevel = 0;// 改变的级别
       			changeLevel = ZoomMap.zoomMaxLevel - Math.floor((ZoomMap.currPageY - sliderDivTop) / ZoomMap.slipPx);
       			ZoomMap.zoomLevel = changeLevel;
       			ZoomMap.MapApp.zoomTo(ZoomMap.zoomLevel);
   				ZoomMap.slipSlider(sliderId);
       		}
    	});
	}
};