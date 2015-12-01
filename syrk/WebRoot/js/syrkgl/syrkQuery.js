if(typeof SyrkQuery == "undefined" || !SyrkQuery){
	var SyrkQuery = {};
};
SyrkQuery = function(){
	this.pk = Math.random();
};
SyrkQuery.initMarkerArr = new Array();//放点对象
SyrkQuery.setInt = "";     //记录延时
SyrkQuery.initMarker = ""; //记录点击列表点
SyrkQuery.drawType = "";   //空间查询类型
SyrkQuery.drawZbz = "";    //空间查询坐标值
SyrkQuery.drawRadius = ""; //空间查询半径弧度值
/**
 * @title:Jquery
 * @description:初始化地址管理
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-04-14 10:10:54
 */
$(function(){
	SyrkQuery.onloadMap();
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 10:16:21
 */	
SyrkQuery.onloadMap = function(){
	/*地图对象*/
	SyrkQuery.map = new FrameTools.Map();
	/*设置地图代理*/
	SyrkQuery.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	SyrkQuery.map.setMapDiv("mapDiv");
	/*加载地图*/
	SyrkQuery.map.onloadMap();
	/*显示鹰眼*/
	SyrkQuery.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	SyrkQuery.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	SyrkQuery.map.showNewMapServer("mapDiv","SyrkQuery.map");
	/*加载地图工具条*/
	SyrkQuery.map.buildTools("mapDiv","toolDiv","SyrkQuery.map");
	//只在责任区和派出所级别加载辖区边界 辖区太大在IE8会停止运行脚本
	if(orglevel=="50"||orglevel=="32"){
		SyrkQuery.map.moveMapToBjzbz(bjzbz);
	}
};
/**
 * @title:loadPoint
 * @description:加载地图坐标点
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 10:16:36
 */	
SyrkQuery.loadPoint = function(data){
	//延迟加载列表统计
	beforeTableLoad(data,'dg');
	//关闭所有器已经打开的气泡框
	SyrkQuery.map._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(SyrkQuery.setInt!=""){
		clearInterval(SyrkQuery.setInt);
	}
	//判断地图上已经存在点图层清除
	if(SyrkQuery.initMarkerArr!=null){
		var markerLen = SyrkQuery.initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			SyrkQuery.map._MapApp.removeOverlay(SyrkQuery.initMarkerArr[j]);
		}
	}
	//清除记录点击列表点
	if(SyrkQuery.initMarker!=""){
		//清除之前的坐标点
		SyrkQuery.map._MapApp.removeOverlay(SyrkQuery.initMarker);
	}
	//延时加载点图层
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	var count = 0;
	SyrkQuery.setInt = setInterval(function(){
		if(count<len){
			var zbx = rows[count].jzd_zbx;
			var zby = rows[count].jzd_zby;
			var title = rows[count].xm;
			if(zbx!=""&&zby!=""){
				var initMarker = SyrkQuery.map.initMarker(title,zbx,zby,'syrkBlue.png',null,null,43,37);
				SyrkQuery.map._MapApp.addOverlay(initMarker);
				SyrkQuery.initMarkerArr.push(initMarker);
				//地图元素和列表联动
				SyrkQuery.addMapToListFun(initMarker,count);
			}
		}else{
			clearInterval(SyrkQuery.setInt);
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
SyrkQuery.addMapToListFun = function(PMarker,row){
	PMarker.addListener("click",function(){
		SyrkQuery.addClickMarker(row);
	});
};
/**
 * @title:addClickMarker
 * @description:地图图标变换
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 19:28:43
 */	
SyrkQuery.addClickMarker = function(row){
	//关闭所有器已经打开的气泡框
	SyrkQuery.map._MapApp.closeInfoWindow();
	if(SyrkQuery.initMarker!=""){
		//清除之前的坐标点
		SyrkQuery.map._MapApp.removeOverlay(SyrkQuery.initMarker);
	}
	//获取基本信息内容
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[row];
	var title = rowData.xm;
	var zbx = rowData.jzd_zbx;
	var zby = rowData.jzd_zby;
	if(zbx!=""&&zby!=""){
		SyrkQuery.initMarker = SyrkQuery.map.initMarker(title,zbx,zby,'syrkRedSmall.png',null,null,43,37);
		SyrkQuery.map._MapApp.addOverlay(SyrkQuery.initMarker);
		//鼠标移动到点上列表选中
		$('#dg').datagrid("selectRow",row);
		//打开气泡
		SyrkQuery.openInfoWindow(row);
	}
}
/**
 * @title:openInfoWindow
 * @description:打开气泡框内容
 * @author: zhang_guoliang@founder.com
 * @param    
 * @date:2015-04-16 18:31:32
 */	
SyrkQuery.openInfoWindow = function(row){
	//获取基本信息内容
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[row];
	var zbx = rowData.jzd_zbx;
	var zby = rowData.jzd_zby;
	var ryid = rowData.ryid;
	var zjhm = rowData.zjhm;
	var csrq = rowData.csrq;
	var cyzjdm = rowData.cyzjdm;
	var hjdz = rowData.hjd_dzms;
	var jzdz = "";
//	if(rowData.hjd_dzxz!=null){
//		hjdz = rowData.hjd_dzxz;
//	}else{
//		hjdz = rowData.hjd_mlpxz;
//	}
	if(rowData.jzd_dzxz!=null){
		jzdz = rowData.jzd_dzxz;
	}else{
		jzdz = rowData.jzd_mlpxz;
	}
	var xbmc = window.top.getDictName(contextPath+'/common/dict/GB_D_XBDM.js',rowData.xbdm);
	var mzmc = window.top.getDictName(contextPath+'/common/dict/GB_D_MZDM.js',rowData.mzdm);
	var point = new Point(zbx,zby);
	var openHtml = "";
	if(rowData.syrkywlxdm=="4"){
		openHtml = "<table width='360'><tr>" +
			       "<td valign='top' align='left' width='260'>" +
			       "<table cellpadding='0' cellspacing='0' style='margin-left: 5px;padding-top:12px;'>" +
			       "<tr><td class='infoTable' width='80'>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td><td class='infoTable1' colspan='2'>"+rowData.xm+"</td></tr>" +
			       "<tr><td class='infoTable' width='80'>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td><td class='infoTable1'>"+xbmc+"</td></tr>" +
			       "<tr><td class='infoTable' width='80'>出生日期：</td><td class='infoTable1' colspan='2'>"+rowData.csrq+"</td></tr>" +
			       "<tr><td class='infoTable' width='80'>证件号码：</td><td class='infoTable1' colspan='2'><a class='infoTable' style='text-decoration:underline;' href='javascript:void(0)' onclick='SyrkQuery.doSyrkXq("+row+")'>"+rowData.zjhm+"</a></td></tr>";
			       if(rowData.jzd_mlpdm!=""&&rowData.jzd_dzid!=""){
			    	   openHtml += "<tr><td class='infoTable' width='80'>现居地址：</td><td class='infoTable1' colspan='2'><a class='infoTable' style='text-decoration:underline;' href='javascript:void(0)' onclick='SyrkQuery.doBuildingShow("+row+")'>"+jzdz+"</a></td></tr>";
			       }else{
			    	   openHtml += "<tr><td class='infoTable' width='80'>现居地址：</td><td class='infoTable1' colspan='2'>"+jzdz+"</td></tr>";
			       }
	   openHtml += "</table></td>" +
			       "<td><div><img id='topPhotoid' width='160' height='200' alt='' src= '"+contextPath+"/zpfjPtryzp/queryPtryzpSingle.jpg?pk="+Math.random()+"&ryid="+ryid+"&zjhm="+zjhm+"&cyzjdm="+cyzjdm+"'/></div></td>" +
			       "</tr>" +
			       "</table>";
	}else{
		openHtml = "<table width='420'><tr>" +
			       "<td valign='top' align='left' width='260'>" +
			       "<table cellpadding='0' cellspacing='0' style='margin-left: 5px;padding-top:6px;'>" +
			       "<tr><td class='infoTable' width='80'>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td><td class='infoTable1' colspan='2'>"+rowData.xm+"</td></tr>" +
			       "<tr><td class='infoTable' width='80'>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td><td class='infoTable1'>"+xbmc+"</td>" +
			       "<td class='infoTable'>民&nbsp;族：<span class='infoTable1'>"+mzmc+"</span></td></tr>" +
			       "<tr><td class='infoTable' width='80'>出生日期：</td><td class='infoTable1' colspan='2'>"+rowData.csrq+"</td></tr>" +
			       "<tr><td class='infoTable' width='80'>证件号码：</td><td class='infoTable1' colspan='2'><a class='infoTable' style='text-decoration:underline;' href='javascript:void(0)' onclick='SyrkQuery.doSyrkXq("+row+")'>"+rowData.zjhm+"</a></td></tr>" 
			      /* "<tr><td class='infoTable' width='80'>户籍地址描述：</td><td class='infoTable1' colspan='2'>"+hjdz+"</td></tr>";*/
			       if(rowData.jzd_mlpdm!=""&&rowData.jzd_dzid!=""){
			    	   openHtml += "<tr><td class='infoTable' width='80'>现居地址：</td><td class='infoTable1' colspan='2'><a class='infoTable' style='text-decoration:underline;' href='javascript:void(0)' onclick='SyrkQuery.doBuildingShow("+row+")'>"+jzdz+"</a></td></tr>";
			       }else{
			    	   openHtml += "<tr><td class='infoTable' width='80'>现居地址：</td><td class='infoTable1' colspan='2'>"+jzdz+"</td></tr>";
			       }
	  openHtml += "</table></td>" +
			       "<td><div><img id='topPhotoid' width='160' height='200' alt='' src= '"+contextPath+"/zpfjPtryzp/queryPtryzpSingle.jpg?pk="+Math.random()+"&ryid="+ryid+"&zjhm="+zjhm+"&cyzjdm="+cyzjdm+"'/></div></td>" +
			       "</tr>" +
			       "</table>";
	}
	//打开气泡框
	SyrkQuery.map._MapApp.openInfoWindow(point,openHtml,true);
};
/**
 * @title: subjzddzxz
 * @description:居住地址截取
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 15:08:32
 */	
SyrkQuery.subjzddzxz = function(val, row, index){
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
SyrkQuery.datagridProcessFormater = function(val,row,index){
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SyrkQuery.doSyrkXq('+index+')">详情</a>&nbsp;';
};
/**
 * @title:doSearch
 * @description:列表搜索
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 15:50:58
 */
SyrkQuery.doSearch = function(value,name){
	value = $.trim(value)
	$('#dg').datagrid('load',{    
		'searchbox':value
	});
	//清除【空间查询】图层
	if(SyrkQuery.drawType == "" || SyrkQuery.drawZbz ==""){
		SyrkQuery.drawType = "";
		SyrkQuery.map.clearGraph();
	}
};
/**
 * @title:onClickRow
 * @description:点击列表时间
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 16:06:43
 */
SyrkQuery.onClickRow = function(rowIndex,rowData){
	SyrkQuery.addClickMarker(rowIndex);
};
/**
 * @title:doSyrkXq
 * @description:实有人口【详情】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 16:24:35
 */
SyrkQuery.doSyrkXq = function(index){
	//关闭所有器已经打开的气泡框
	SyrkQuery.map._MapApp.closeInfoWindow();
    cancelBubble(); 
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/syrkEdit/"+rowData.ryid+"/"+rowData.id+"/view?mode=view";
	if(rowData.xm){
		menu_open("实有人口【"+rowData.xm+"】",editUrl);
	}else{
		menu_open("实有人口",editUrl);
	}
};
/**
 * @title:detailSearch
 * @description:精确查询【窗口】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 18:11:36
 */
SyrkQuery.detailSearch = function(){
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
SyrkQuery.queryButton = function(){
	//清除【空间查询】图层
	if(SyrkQuery.drawType == "" || SyrkQuery.drawZbz ==""){
		SyrkQuery.drawType = "";
		SyrkQuery.map.clearGraph();
	}
	var syrkywlxdm = document.getElementById("syrkywlxdm").value;
	var xm = document.getElementById("xm").value;
	var cyzjdm = document.getElementById("cyzjdm").value;
	var zjhm = document.getElementById("zjhm").value;
	var xbdm = document.getElementById("xbdm").value;
	var mzdm = document.getElementById("mzdm").value;
	var jzd_dzxz = document.getElementById("jzd_dzxz").value;
	var searchbox = $('#searchbox').searchbox('getValue');
	$('#dg').datagrid('load',{    
		'syrkywlxdm':syrkywlxdm,
		'xm':xm,
		'cyzjdm':cyzjdm,
		'zjhm':zjhm,
		'xbdm':xbdm,
		'mzdm':mzdm,
		'jzd_dzxz':jzd_dzxz,
		'searchbox':searchbox,
		'drawType':SyrkQuery.drawType,
		'drawZbz':SyrkQuery.drawZbz,
		'drawRadius':SyrkQuery.drawRadius
	});
	SyrkQuery.closeWindow();
	SyrkQuery.resetButton();
};
/**
 * @title:closeWindow
 * @description:精确查询【关闭】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 18:47:32
 */
SyrkQuery.closeWindow = function(){
	$("#win").window("close");
};
/**
 * @title:resetButton
 * @description:精确查询【重置】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 18:48:43
 */
SyrkQuery.resetButton = function(){
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
SyrkQuery.dragModeSpace = function(drawmode){
	var maxLevel = SyrkQuery.map._MapApp.getMaxLevel()-5;
	var zoomLevel = SyrkQuery.map._MapApp.getZoomLevel();
	if(zoomLevel>maxLevel){
		SyrkQuery.drawType = drawmode;
		SyrkQuery.map.changeDragMode(drawmode,null,null,SyrkQuery.dragModeSpace_back);
	}else{
		topMessager.show({
			title: MESSAGER_TITLE,
			msg: '请将地图级别缩放到【'+maxLevel+'】级以上，再进<br><br>行空间查询。',
			timeout:3500
		});
		return;
	}
};
/**
 * @title:dragModeSpace_back
 * @description:【空间查询】_回调函数
 * @author: zhang_guoliang@founder.com
 * @param json 返回坐标信息
 * @date:2015-04-20 13:50:23
 */
SyrkQuery.dragModeSpace_back = function(json){
	if(SyrkQuery.drawType=="drawCircle"){//圆形查询
		var zbz = json.split(",");
		SyrkQuery.drawZbz = zbz[0]+" "+zbz[1];
		SyrkQuery.drawRadius = zbz[2];
	}else if(SyrkQuery.drawType=="drawRect"){//矩形查询
		SyrkQuery.drawZbz = json;
	}else if(SyrkQuery.drawType=="drawPolygon"){//多边形查询
		//判断多表形是否有交叉情况
		if(SyrkQuery.map.checkPoint(json)){
		   SyrkQuery.drawZbz = json;
		}else{
		   SyrkQuery.dragModeSpace("drawPolygon");
	       return;
		}
	}
	//列表查询方法
	SyrkQuery.queryButton();
	//清空空间查询条件
	SyrkQuery.drawType = "";
	SyrkQuery.drawZbz = "";
	SyrkQuery.drawRadius = "";
};
/**
 * @title:doBuildingShow
 * @description:层户结构【展现】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-05-07 09:34:23
 */
SyrkQuery.doBuildingShow = function(index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var title = "层户结构";
	if(rowData.jzd_mlpdm!=""){
		var xzqhmc = window.top.getDictName(contextPath+'/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',rowData.jzd_xzqhdm);
		var mlpxz = rowData.jzd_mlpxz.replace(xzqhmc, "");
		title = "【"+mlpxz+"】层户结构";
	}
	//层户结构URL
	menu_open(title, "/dz/dzBuildingShow?mldzid="+rowData.jzd_mlpdm+"&chdzid="+rowData.jzd_dzid+"&mainTabID="+getMainTabID());
};