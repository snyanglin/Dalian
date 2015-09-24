if (typeof ZdryManage == "undefined" || !ZdryManage) {
	var ZdryManage = {};
};
ZdryManage = function() {
	this.pk = Math.random();
};
ZdryManage.initMarkerArr = new Array();// 放点对象
ZdryManage.setInt = "";// 记录延时
/**
 * @title:Jquery
 * @description:初始化地址管理
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-26 10:37:32
 */
$(function() {
	ZdryManage.onloadMap();
	// 键盘回车进行查询
	$("body").bind("keydown", function(e) {
		if (e.keyCode == 13) {
			ZdryManage.queryButton();
		}
	});
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-26 10:38:12
 */
ZdryManage.onloadMap = function() {
	/* 地图对象 */
	ZdryManage.map = new FrameTools.Map();
	/* 设置地图代理 */
	ZdryManage.map.setProxy(contextPath + "/Proxy");
	/* 设置地图加载容器 */
	ZdryManage.map.setMapDiv("mapDiv");
	/* 加载地图 */
	ZdryManage.map.onloadMap();
	/* 显示鹰眼 */
	ZdryManage.map.addOverView();
	/* 隐藏自带矢量影像图层对象 */
	ZdryManage.map._MapApp.hideMapServer();
	/* 加载自定义的矢量影像图层对象 */
	ZdryManage.map.showNewMapServer("mapDiv", "ZdryManage.map");
	/* 加载地图工具条 */
	ZdryManage.map.buildTools("mapDiv", "toolDiv", "ZdryManage.map");
	/* 设置工具条显示的位置 */
	ZdryManage.diyToolDiv();
	/* 窗口变化地图工具条自动变 */
	$("#mapDiv").resize(function() {
		ZdryManage.diyToolDiv();
	});
	/* 加载边界坐标值 */
	if (bjzbz != "" && bjzbz != 'null') {
		/* 显示当前用户边界 */
		ZdryManage.moveMapToBjzbz();
	}
};
/**
 * @title:diyToolDiv
 * @description:设置工具条显示的位置
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-26 10:39:41
 */
ZdryManage.diyToolDiv = function() {
	var top = $("#mapDiv").height() - 40;
	$("#toolDiv").css({
		"top" : top,
		"left" : 10
	});
};
/**
 * @title:moveMapToBjzbz
 * @description:加载当前用户边界
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-26 10:39:54
 */
ZdryManage.moveMapToBjzbz = function() {
	/* 清楚地图上所有的标记 */
	ZdryManage.map._MapApp.clear();
	/* 非地坐标 */
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/* 记录边线中心点坐标 */
	ZdryManage.mbrArr = new Array();
	for ( var j = 0; j < bjnum; j++) {
		var gArr = bj[j];
		/* 创建边界图元素 */
		var polyline = ZdryManage.map.initPolyline(gArr, "blue");
		/* 图元素添加到地图上 */
		if (polyline) {
			ZdryManage.map._MapApp.addOverlay(polyline);
			ZdryManage.mbrArr.push(polyline);
			if (ZdryManage.Mbr == null) {
				ZdryManage.Mbr = polyline.getMBR();
			} else {
				ZdryManage.Mbr = MBR.union(ZdryManage.Mbr, polyline.getMBR());
			}
		}
	}
	/* 根据图元素将地图放到最适合的级别和位置 */
	ZdryManage.map._MapApp.centerAtMBR(ZdryManage.Mbr);
	/* 新版本cliect自动适应级别有问题必须降一级 */
	ZdryManage.map._MapApp.zoomOut();
};
/**
 * @title:datagridProcessFormater
 * @description:列表操作
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-26 10:47:21
 */
ZdryManage.datagridProcessFormater = function(val, row, index) {
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="ZdryManage.doUpdateAndXq(this, '
			+ index + ')">编辑</a>&nbsp;';
};
/**
 * @title:loadPoint
 * @description:加载地图坐标点
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-26 10:58:43
 */
ZdryManage.loadPoint = function(data) {
	// 延迟加载列表统计
	beforeTableLoad(data, 'dg');
	// 关闭所有器已经打开的气泡框
	ZdryManage.map._MapApp.closeInfoWindow();
	// 判断延时是否执行完，没执行完终止此方法
	if (ZdryManage.setInt != "") {
		clearInterval(ZdryManage.setInt);
	}
	// 判断地图上已经存在点图层清除
	if (ZdryManage.initMarkerArr != null) {
		var markerLen = ZdryManage.initMarkerArr.length;
		for ( var j = 0; j < markerLen; j++) {
			ZdryManage.map._MapApp.removeOverlay(ZdryManage.initMarkerArr[j]);
		}
	}
	// 延时加载点图层
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	var count = 0;
	ZdryManage.setInt = setInterval(function() {
		if (count < len) {
			var zbx = rows[count].jzd_zbx;
			var zby = rows[count].jzd_zby;
			var title = rows[count].xm;
			if (zbx != "" && zby != "") {
				// 气泡框内容
				var openHtml = "";
				var initMarker = ZdryManage.map.initMarker(title, zbx, zby,
						"jzw1.png", openHtml, null, 43, 37);
				ZdryManage.map._MapApp.addOverlay(initMarker);
				ZdryManage.initMarkerArr.push(initMarker);
				// 地图元素和列表联动
				ZdryManage.addMapToListFun(initMarker, count);
			}
		} else {
			clearInterval(ZdryManage.setInt);
		}
		count++;
	}, 90);
};
/**
 * @title:addMapToListFun
 * @description:地图元素和列表联动
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-26 18:02:12
 */
ZdryManage.addMapToListFun = function(PMarker, row) {
	PMarker.addListener("click", function() {
		// 鼠标移动到点上列表选中
		$('#dg').datagrid("selectRow", row);
	});
	/*
	 * PMarker.addListener("mouseout",function(){ //鼠标移动到点上取消列表选中
	 * $('#dg').datagrid("unselectRow",row); });
	 */
};
/**
 * @title:datagridDzzt
 * @description:地址状态颜色
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-26 18:12:24
 */
ZdryManage.datagridDzzt = function(value, row, index) {
	var opts = $(this);
	if (opts[0].dictName) {
		try {
			value = window.top.getDictName(opts[0].dictName, value);
		} catch (err) {
		}
	}
	if (row.dzzt == "01") {
		if (row.bz == "维护中") {
			return "<span style='color:green;font: bold;'>" + value
					+ "(维护中)</span>";
		} else {
			return "<span style='color:green;font: bold;'>" + value + "</span>";
		}
	} else if (row.dzzt == "02") {
		return "<span style='color:#C86C00;font: bold;'>" + value + "</span>";
	} else if (row.dzzt == "03") {
		return "<span style='color:red;font: bold;'>" + value + "</span>";
	} else if (row.dzzt == "04") {
		return "<span style='color:gray;font: bold;'>" + value + "</span>";
	} else {
		return value;
	}
};
//只清除marker
ZdryManage.clearMarkers = function(){
	ZdryManage.map._MapApp.closeInfoWindow();
	var objs = ZdryManage.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			var obj =objs[i].toString().split(",");
			if(obj.length<=2){
				ZdryManage.map._MapApp.removeOverlay(objs[i]);
			}
		}
	}
};
/**
 * @title:onClickRow
 * @description:点击一行的时候触发
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-27 14:57:21
 */
ZdryManage.onClickRow = function(rowIndex, rowData) {
	var point = new Point(rowData.jzd_zbx, rowData.jzd_zby);
	// 气泡框内容
	//var openHtml = "";
	//ZdryManage.map._MapApp.openInfoWindow(point, openHtml, true);
	ZdryManage.clearMarkers();
	//ZdryManage.map._MapApp.clear();
	ZdryManage.map._MapApp.addOverlay(ZdryManage.initMarkerArr[rowIndex]);
	ZdryManage.map._MapApp.centerAndZoom(point, 19);
};

/**
 * @title:doUpdateAndXq
 * @description:地址维护
 * @author: zhang_guoliang@founder.com
 * @param type
 *            0为可编辑、1为只读，dzChb地址层户表 0为层户地址对象表、1为层户地址审核表
 * @date:2015-02-04 18:23:35
 */
ZdryManage.doUpdateAndXq = function(linkObject, index) {
	// 阻止冒泡，不然要执行onClickRow
	cancelBubble();
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	menu_open(rowData.xm + '', '/zdryzb/' + rowData.ryid + '/' + rowData.id
			+ '/view?mainTabID=' + getMainTabID());
};

// 精确查询
function detailSearch() {
	$("#win").window("open");
}
function closeWindow() {
	$("#win").window("close");
}
