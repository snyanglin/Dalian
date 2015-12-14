if(typeof SyfwQuery == "undefined" || !SyfwQuery){
	var SyfwQuery = {};
};
SyfwQuery = function(){
	this.pk = Math.random();
};
SyfwQuery.initMarkerArr = new Array();//放点对象
SyfwQuery.setInt = "";     //记录延时
SyfwQuery.initMarker = ""; //记录点击列表点
SyfwQuery.drawType = "";   //空间查询类型
SyfwQuery.drawZbz = "";    //空间查询坐标值
SyfwQuery.drawRadius = ""; //空间查询半径弧度值
/**
 * @title:Jquery
 * @description:初始化地址管理
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-04-14 10:10:54
 */
$(function(){
	SyfwQuery.onloadMap();
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 10:16:21
 */	
SyfwQuery.onloadMap = function(){
	/*地图对象*/
	SyfwQuery.map = new FrameTools.Map();
	/*设置地图代理*/
	SyfwQuery.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	SyfwQuery.map.setMapDiv("mapDiv");
	/*加载地图*/
	SyfwQuery.map.onloadMap();
	/*显示鹰眼*/
	SyfwQuery.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	SyfwQuery.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	SyfwQuery.map.showNewMapServer("mapDiv","SyfwQuery.map");
	/*加载地图工具条*/
	SyfwQuery.map.buildTools("mapDiv","toolDiv","SyfwQuery.map");
	//只在责任区和派出所级别加载辖区边界 辖区太大在IE8会停止运行脚本
	if(orglevel=="50"||orglevel=="32"){
		SyfwQuery.map.moveMapToBjzbz(bjzbz);
	}
};
/**
 * @title:loadPoint
 * @description:加载地图坐标点
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 10:16:36
 */	
SyfwQuery.loadPoint = function(data){
	//延迟加载列表统计
	beforeTableLoad(data,'dg');
	//关闭所有器已经打开的气泡框
	SyfwQuery.map._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(SyfwQuery.setInt!=""){
		clearInterval(SyfwQuery.setInt);
	}
	//判断地图上已经存在点图层清除
	if(SyfwQuery.initMarkerArr!=null){
		var markerLen = SyfwQuery.initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			SyfwQuery.map._MapApp.removeOverlay(SyfwQuery.initMarkerArr[j]);
		}
	}
	//清除记录点击列表点
	if(SyfwQuery.initMarker!=""){
		//清除之前的坐标点
		SyfwQuery.map._MapApp.removeOverlay(SyfwQuery.initMarker);
	}
	//延时加载点图层
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	var count = 0;
	SyfwQuery.setInt = setInterval(function(){
		if(count<len){
			var zbx = rows[count].fwdz_zbx;
			var zby = rows[count].fwdz_zby;
			var title = rows[count].fwdz_dzxz;
			if(zbx!=""&&zby!=""){
				var initMarker = SyfwQuery.map.initMarker(title,zbx,zby,'jzw3.png',null,null,43,37);
				SyfwQuery.map._MapApp.addOverlay(initMarker);
				SyfwQuery.initMarkerArr.push(initMarker);
				//地图元素和列表联动
				SyfwQuery.addMapToListFun(initMarker,count);
			}
		}else{
			clearInterval(SyfwQuery.setInt);
		}
		count++;
	},90);
};
/**
 * @title: addMapToListFun
 * @description:地图元素和列表联动
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 19:28:43
 */	
SyfwQuery.addMapToListFun = function(PMarker,row){
	PMarker.addListener("click",function(){
		SyfwQuery.addClickMarker(row);
	});
};
/**
 * @title:addClickMarker
 * @description:地图图标变换
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 19:28:43
 */	
SyfwQuery.addClickMarker = function(row){
	//关闭所有器已经打开的气泡框
	SyfwQuery.map._MapApp.closeInfoWindow();
	if(SyfwQuery.initMarker!=""){
		//清除之前的坐标点
		SyfwQuery.map._MapApp.removeOverlay(SyfwQuery.initMarker);
	}
	//获取基本信息内容
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[row];
	var title = rowData.fwdz_dzxz;
	var zbx = rowData.fwdz_zbx;
	var zby = rowData.fwdz_zby;
	if(zbx!=""&&zby!=""){
		SyfwQuery.initMarker = SyfwQuery.map.initMarker(title,zbx,zby,'jzw3.png',null,null,43,37);
		SyfwQuery.map._MapApp.addOverlay(SyfwQuery.initMarker);
		//鼠标移动到点上列表选中
		$('#dg').datagrid("selectRow",row);
		//打开气泡
		SyfwQuery.openInfoWindow(row);
	}
}
/**
 * @title:openInfoWindow
 * @description:打开气泡框内容
 * @author: zhang_guoliang@founder.com
 * @param    
 * @date:2015-04-16 18:31:32
 */	
SyfwQuery.openInfoWindow = function(row){
	//获取基本信息内容
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[row];
	var point = new Point(rowData.fwdz_zbx,rowData.fwdz_zby);
	//气泡框内容
	
	
	var openHtml = "<table width='360'><tr>" +
    "<td valign='top' width='360'>" +
    "<table cellpadding='0' cellspacing='0'>" +
    "<tr><td class='infoTable' align='right' width='125'>房主证件号码：</td><td class='infoTable1'>"+rowData.fz_zjhm+"</td></tr>" +
    "<tr><td class='infoTable' align='right' width='125'>房&nbsp;&nbsp;主&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;名：</td><td class='infoTable1' colspan='2'>"+rowData.fz_xm+"</td></tr>" +
    "<tr><td class='infoTable' align='right' width='125'>托管人证件号码：</td><td class='infoTable1' colspan='2'>"+rowData.tgr_zjhm+"</td></tr>" +
    "<tr><td class='infoTable' align='right' width='125'>托&nbsp;管&nbsp;人&nbsp;姓&nbsp;名：</td><td class='infoTable1' colspan='2'>"+rowData.tgr_xm+"</td></tr>" +
    "<tr><td class='infoTable' align='right' width='125'>房屋所属单位：</td><td class='infoTable1' colspan='2'>"+rowData.fwssdw_dwmc+"</td></tr>" +
    "<tr><td class='infoTable' align='right' width='125'>地&nbsp;&nbsp;&nbsp;址&nbsp;&nbsp;全&nbsp;&nbsp;称：</td><td class='infoTable1' colspan='2'>"+rowData.fwdz_dzxz+"</td></tr>" +
    "</table></td>" +
    "</tr>" +
    "</table>";
	SyfwQuery.map._MapApp.openInfoWindow(point,openHtml,true);
};
/**
 * @title: subjzddzxz
 * @description:居住地址截取
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 15:08:32
 */	
SyfwQuery.subjzddzxz = function(val, row, index){
  	var xzqhmc = window.top.getDictName(contextPath+'/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',row.jzd_xzqhdm);
	return val.replace(xzqhmc, "");
};
/**
 * @title:datagridProcessFormater
 * @description:列表操作
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 15:26:45
 */	
SyfwQuery.datagridProcessFormater = function(val,row,index){
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SyfwQuery.doSyrkXq('+index+')">详情</a>&nbsp;';
};
/**
 * @title:doSearch
 * @description:列表搜索
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 15:50:58
 */
SyfwQuery.doSearch = function(value,name){
	value = $.trim(value)
	$('#dg').datagrid('load',{    
		'condition':value
	});
	//清除【空间查询】图层
	if(SyfwQuery.drawType == ""){
		SyfwQuery.map.clearGraph();
	}
};
/**
 * @title:onClickRow
 * @description:点击列表时间
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 16:06:43
 */
SyfwQuery.onClickRow = function(rowIndex,rowData){
	SyfwQuery.addClickMarker(rowIndex);
};
/**
 * @title:doSyrkXq
 * @description:实有人口【详情】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 16:24:35
 */
SyfwQuery.doSyrkXq = function(index){
    cancelBubble(); 
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/syfw/"+rowData.id+"/main"+'?mode=view&mainTabID='+getMainTabID();
	menu_open("实有房屋编辑",editUrl);
};
/**
 * @title:detailSearch
 * @description:精确查询【窗口】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 18:11:36
 */
SyfwQuery.detailSearch = function(){
	$("#win").window("open"); 
	$("#queryForm").form("reset");
};
/**
 * @title:queryButton
 * @description:精确查询【确定】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 18:42:43
 */
SyfwQuery.queryButton = function(){
	//清除【空间查询】图层
	if(SyfwQuery.drawType == ""){
		SyfwQuery.map.clearGraph();
	}
	
	var fz_xm = document.getElementById("fz_xm").value;
	var fwlbdm = document.getElementById("fwlbdm").value;
	var fwdz_dzxz = document.getElementById("fwdz_dzxz").value;
	var sfczfw = document.getElementById("sfczfw").value;
	
	var searchbox = $('#searchbox').searchbox('getValue');
	$('#dg').datagrid('load',{  
		'fz_xm':fz_xm,				  
		'fwlbdm': fwlbdm ,
		'fwdz_dzxz':fwdz_dzxz,
		'sfczfw':sfczfw,
		//'condition':searchbox,
		'drawType':SyfwQuery.drawType,
		'drawZbz':SyfwQuery.drawZbz,
		'drawRadius':SyfwQuery.drawRadius
	});
	SyfwQuery.closeWindow();
};
/**
 * @title:closeWindow
 * @description:精确查询【关闭】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 18:47:32
 */
SyfwQuery.closeWindow = function(){
	$("#win").window("close");
};
/**
 * @title:resetButton
 * @description:精确查询【重置】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 18:48:43
 */
SyfwQuery.resetButton = function(){
	$("#queryForm").form("reset");
};
/**
 * @title:dragModeSpace
 * @description:【空间查询】
 * @author: zhang_guoliang@founder.com
 * @param drawmode
 *        drawCircle  设置当前地图操作状态为绘制圆形状态
 * 		  drawRect    设置当前地图操作状态为绘制矩形状态
 *        drawPolygon 设置当前地图操作状态为绘制多边形状态
 * @date:2015-04-20 11:04:32
 */
SyfwQuery.dragModeSpace = function(drawmode){
	SyfwQuery.drawType = drawmode;
	SyfwQuery.map.changeDragMode(drawmode,null,null,SyfwQuery.dragModeSpace_back);
};
/**
 * @title:dragModeSpace_back
 * @description:【空间查询】_回调函数
 * @author: zhang_guoliang@founder.com
 * @param json 返回坐标信息
 * @date:2015-04-20 13:50:23
 */
SyfwQuery.dragModeSpace_back = function(json){
	if(SyfwQuery.drawType=="drawCircle"){//圆形查询
		var zbz = json.split(",");
		SyfwQuery.drawZbz = zbz[0]+" "+zbz[1];
		SyfwQuery.drawRadius = zbz[2];
	}else if(SyfwQuery.drawType=="drawRect"){//矩形查询
		SyfwQuery.drawZbz = json;
	}else if(SyfwQuery.drawType=="drawPolygon"){//多边形查询
		//判断多表形是否有交叉情况
		if(SyfwQuery.map.checkPoint(json)){
		   SyfwQuery.drawZbz = json;
		}else{
		   SyfwQuery.dragModeSpace("drawPolygon");
	       return;
		}
	}
	//列表查询方法
	SyfwQuery.queryButton();
	//清空空间查询条件
	SyfwQuery.drawType = "";
	SyfwQuery.drawZbz = "";
	SyfwQuery.drawRadius = "";
};