/*!
 * 地图工具组件
 * znjg - v1.0.0 (2014-03-29 17:30)
 * Copyright(c) 2014 founder
 */

/**
 * @classDescription 地图工具
 * @author gb
 */

SysTool.loadComponentsFile("mapTool", "mapTool", ".css");

var MapTool = {
		
	/**
	 * 初始化地图工具
	 * @param {String} mapContainerId 地图容器id
	 */
	init : function(param) {
		var html = '<div class="toolsmap" id="mapTool">';
		html += '<a class="vector" id="vector" title="矢量地图" href="javascript:void(0)"></a><a class="virtual" id="virtual" title="影像地图" href="javascript:void(0)"></a><a class=';
		//html += '"super" id="super" title="矢量影像叠加地图" href="javascript:void(0)"></a><a class="roadnet" id="roadnet" title="路网图" href="javascript:void(0)"></a><a class="toolbox" title="工具条" href="javascript:void(0)"></a>';
		html += '"super" id="super" title="矢量影像叠加地图" href="javascript:void(0)"></a><a class="toolbox" title="工具条" href="javascript:void(0)"></a>';
		html += '<div class="toolboxbgdiv">';
		html += '<div class="toolboxdiv">';
		html += '<a class="move" id="move" title="移动地图" href="javascript:void(0)"></a><a class="distance" title="测距" id="distance" href="javascript:void(0)"></a>';
		html += '<a class="area" id="area" title="测面积" href="javascript:void(0)"></a><a class="remove" title="清空地图" id="remove" href="javascript:void(0)"></a><a class="print" title="打印地图" id="print" href="javascript:void(0)"></a>';
		html += '</div>';
		html += '</div>';
		html += '</div>';
		$("#" + param.mapContainerId).after(html);
		$(".toolbox").click(function() {
			if ($(this).attr("class").indexOf("toolboxbg") != -1) {
				$(".toolboxbgdiv").hide();
				$(this).removeClass("toolboxbg");
			} else {
				$(".toolboxbgdiv").show();
				$(this).addClass("toolboxbg");
			}
			$("#move").removeClass("movebg");
			$("#distance").removeClass("distancebg");
			$("#area").removeClass("areabg");
			$("#remove").removeClass("removebg");
			$("#print").removeClass("printbg");
			//$("#vector").removeClass("vectorbg");
			//$("#virtual").removeClass("virtualbg");
			//$("#super").removeClass("superbg");
		});
		//$(".toolboxbgdiv").mouseenter(function(){$(this).show();});
		//$(".toolboxbgdiv").mouseleave(function(){$(this).hide();});
		this.setClickFunc(param.mapApp);
		
		$("#vector").click();
	},
	
	/**
	 * 设置工具距离页面左边的位置
	 * @param {Int} pxNumber 像素数
	 */
	setMapToolLeftPosition : function(pxNumber) {
		$(".toolsmap").animate({left : pxNumber});
	},
	
	/**
	 * 设置矢量影像切换以及地图操作功能
	 * @param map
	 */
	setClickFunc:function(map) {
		//矢量
		$("#vector").click(function() {
			map.switchMapServer(2);
			$(this).addClass("vectorbg");
			$("#virtual").removeClass("virtualbg");
			$("#super").removeClass("superbg");
			//$("#roadnet").removeClass("roadnetbg");
			//$(".toolbox").removeClass("toolboxbg");
			//$(".toolboxbgdiv").hide();
		});
		//影像
		$("#virtual").click(function() {
			map.switchMapServer(1);
			$(this).addClass("virtualbg");
			$("#vector").removeClass("vectorbg");
			$("#super").removeClass("superbg");
			//$("#roadnet").removeClass("roadnetbg");
			//$(".toolbox").removeClass("toolboxbg");
			//$(".toolboxbgdiv").hide();
		});
		//叠加
		$("#super").click(function() {
			map.switchMapServer(0);
			$(this).addClass("superbg");
			$("#vector").removeClass("vectorbg");
			$("#virtual").removeClass("virtualbg");
			//$("#roadnet").removeClass("roadnetbg");
			//$(".toolbox").removeClass("toolboxbg");
			//$(".toolboxbgdiv").hide();
		});
		//路网
		/*$("#roadnet").click(function() {
			map.switchMapServer(0);
			$(this).addClass("roadnetbg");
			$("#vector").removeClass("vectorbg");
			$("#virtual").removeClass("virtualbg");
			$("#super").removeClass("superbg");
			//$(".toolbox").removeClass("toolboxbg");
			//$(".toolboxbgdiv").hide();
		});*/
		//移动
		$("#move").click(function() {
			map.pan();
			$(this).addClass("movebg");
			$("#distance").removeClass("distancebg");
			$("#area").removeClass("areabg");
			$("#remove").removeClass("removebg");
			$("#print").removeClass("printbg");
			$('body').live("mousedown", function(e) {
			     if (e.which == 3) {
			    	$("#move").removeClass("movebg");
					//$(".toolbox").removeClass("toolboxbg");
					//$(".toolboxbgdiv").hide();
			     }
			 });
		});
		//测量距离
		$("#distance").click(function() {
			map.measureLength(function(r) {
				document.oncontextmenu = function() {//禁止默认的右键事件
					return false;
				};
				SysTool.alert("测量距离：" + r);
		    	$("#distance").removeClass("distancebg");
				//$(".toolbox").removeClass("toolboxbg");
				//$(".toolboxbgdiv").hide();
			});
			$(this).addClass("distancebg");
			$("#move").removeClass("movebg");
			$("#area").removeClass("areabg");
			$("#remove").removeClass("removebg");
			$("#print").removeClass("printbg");
			$('body').live("mousedown", function(e) {
			     if (e.which == 3) {
			    	$("#distance").removeClass("distancebg");
					//$(".toolbox").removeClass("toolboxbg");
					//$(".toolboxbgdiv").hide();
			     }
			 });
		});
		//测量面积
		$("#area").click(function() {
			map.measureArea(function(a) {
				document.oncontextmenu = function() {//禁止默认的右键事件
					return false;
				};
				SysTool.alert("测量面积：" + a);
		    	$("#area").removeClass("areabg");
				//$(".toolbox").removeClass("toolboxbg");
				//$(".toolboxbgdiv").hide();
			});
			$(this).addClass("areabg");
			$("#move").removeClass("movebg");
			$("#distance").removeClass("distancebg");
			$("#remove").removeClass("removebg");
			$("#print").removeClass("printbg");
			$('body').live("mousedown", function(e) {
			     if (e.which == 3) {
			    	$("#area").removeClass("areabg");
					//$(".toolbox").removeClass("toolboxbg");
					//$(".toolboxbgdiv").hide();
			     }
			 });
		});
		//清除
		$("#remove").click(function() {
			MapBubble.removeAll();
			$(this).addClass("removebg");
			$("#move").removeClass("movebg");
			$("#distance").removeClass("distancebg");
			$("#area").removeClass("areabg");
			$("#print").removeClass("printbg");
			//$(".toolbox").removeClass("toolboxbg");
			//$(".toolboxbgdiv").hide();
			$('body').live("mousedown", function(e) {
			     if (e.which == 3) {
			    	$("#remove").removeClass("removebg");
					//$(".toolbox").removeClass("toolboxbg");
					//$(".toolboxbgdiv").hide();
			     }
			 });
		});
		//打印
		$("#print").click(function() {
			var mbr = map.getBoundsLatLng();
			map.printMapBaseExtent(mbr,"地图");
			$(this).addClass("printbg");
			$("#move").removeClass("movebg");
			$("#distance").removeClass("distancebg");
			$("#area").removeClass("areabg");
			$("#remove").removeClass("removebg");
			//$(".toolbox").removeClass("toolboxbg");
			//$(".toolboxbgdiv").hide();
			$('body').live("mousedown", function(e) {
			     if (e.which == 3) {
			    	$("#print").removeClass("printbg");
					//$(".toolbox").removeClass("toolboxbg");
					//$(".toolboxbgdiv").hide();
			     }
			 });
		});
	}
	
};