if(typeof jcjManage == "undefined" || !jcjManage){
	var jcjManage = {};
};
jcjManage = function(){
	this.pk = Math.random();
};
jcjManage.initMarkerArr = new Array();//放点对象
jcjManage.setInt = "";//记录延时
/**
 * @title:Jquery
 * @description:初始化地址管理
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2014-12-26 10:37:32
 */
$(function(){
	jcjManage.onloadMap();
	//键盘回车进行查询
	$("body").bind("keydown",function(e){
        if(e.keyCode==13){
        	jcjManage.queryButton();
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
jcjManage.onloadMap = function(){
	/*地图对象*/
	jcjManage.map = new FrameTools.Map();
	/*设置地图代理*/
	jcjManage.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	jcjManage.map.setMapDiv("mapDiv");
	/*加载地图*/
	jcjManage.map.onloadMap();
	/*显示鹰眼*/
	jcjManage.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	jcjManage.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	jcjManage.map.showNewMapServer("mapDiv","jcjManage.map");
	/*加载地图工具条*/
	jcjManage.map.buildTools("mapDiv","toolDiv","jcjManage.map");
	/*设置工具条显示的位置*/
	jcjManage.diyToolDiv();
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){jcjManage.diyToolDiv();});
	/*加载边界坐标值*/
	if(bjzbz!="" && bjzbz!='null'){
		/*显示当前用户边界*/
		jcjManage.moveMapToBjzbz();
	}
};
/**
 * @title:diyToolDiv
 * @description:设置工具条显示的位置
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 10:39:41
 */	
jcjManage.diyToolDiv = function(){
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
jcjManage.moveMapToBjzbz = function(){
	/*清楚地图上所有的标记*/
	jcjManage.map._MapApp.clear();
	/*非地坐标*/
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/*记录边线中心点坐标*/
	jcjManage.mbrArr = new Array();
	for(var j=0;j<bjnum;j++){
		var gArr = bj[j];
		/*创建边界图元素*/
		var polyline = jcjManage.map.initPolyline(gArr,"blue");
		/*图元素添加到地图上*/
		if(polyline){
			jcjManage.map._MapApp.addOverlay(polyline);
			jcjManage.mbrArr.push(polyline);
			if(jcjManage.Mbr==null){
				jcjManage.Mbr = polyline.getMBR();
			}else{
				jcjManage.Mbr = MBR.union(jcjManage.Mbr,polyline.getMBR());
			}
		}
	}
	/*根据图元素将地图放到最适合的级别和位置*/
	jcjManage.map._MapApp.centerAtMBR(jcjManage.Mbr);
	/*新版本cliect自动适应级别有问题必须降一级*/
	jcjManage.map._MapApp.zoomOut();
};

/**
 * @title:queryButton
 * @description:查询按钮
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 10:58:43
 */	
jcjManage.queryButton = function(){
	var dzmc = document.getElementById("dzmc").value;
	var dzzt = document.getElementById("dzzt").value;
	dzmc = $.trim(dzmc);
	//加载查询列表
	$('#dg').datagrid('load',{    
		'dzmc':dzmc,
		'dzzt':dzzt
	});
};
/**
 * @title:loadPoint
 * @description:加载地图坐标点
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 10:58:43
 */	
jcjManage.loadPoint = function(data){
	//延迟加载列表统计
	beforeTableLoad(data,'dg');
	//关闭所有器已经打开的气泡框
	jcjManage.map._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(jcjManage.setInt!=""){
		clearInterval(jcjManage.setInt);
	}
	//判断地图上已经存在点图层清除
	if(jcjManage.initMarkerArr!=null){
		var markerLen = jcjManage.initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			jcjManage.map._MapApp.removeOverlay(jcjManage.initMarkerArr[j]);
		}
	}
	//延时加载点图层
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	var count = 0;
	jcjManage.setInt = setInterval(function(){
		if(count<len){
			var zbx = "";
			var zby = "";
			
			if(rows[count].sgdw_zxdhhb !=""){
				zbx =rows[count].sgdw_zxdhhb;
				zby =rows[count].sgdw_zxdzzb;
			}else{
				zbx =rows[count].jq_zxdhzb;
				zby =rows[count].jq_zxdzzb;
			}
			
			
			var title = rows[count].bjnr;
			if(zbx!=""&&zby!=""){
				//气泡框内容
				var openHtml ="";
				//地图标点
				var img = "jzw3.png";
				var initMarker = jcjManage.map.initMarker(title,zbx,zby,img,openHtml,null,43,37);
				jcjManage.map._MapApp.addOverlay(initMarker);
				jcjManage.initMarkerArr.push(initMarker);
			}
		}else{
			clearInterval(jcjManage.setInt);
		}
		count++;
	},90);
};
/**
 * @title:addMapToListFun
 * @description:地图元素和列表联动
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 18:02:12
 */	
jcjManage.addMapToListFun = function(PMarker,row){
	PMarker.addListener("click",function(){
		//鼠标移动到点上列表选中
		$('#dg').datagrid("selectRow",row);
	});
	/*PMarker.addListener("mouseout",function(){
		//鼠标移动到点上取消列表选中
		$('#dg').datagrid("unselectRow",row);
	});*/
};
/**
 * @title:datagridDzzt
 * @description:地址状态颜色
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 18:12:24
 */	
jcjManage.datagridDzzt = function(value,row,index){
	var opts = $(this);
	if (opts[0].dictName) {
		try {
			value = window.top.getDictName(opts[0].dictName, value);
		}
		catch (err) {}
	}
    if(row.dzzt=="01"){
    	return "<span style='color:green;font: bold;'>"+value+"</span>";
    }else if(row.dzzt=="02"){
    	return "<span style='color:#C86C00;font: bold;'>"+value+"</span>";
    }else if(row.dzzt=="03"){
    	return "<span style='color:red;font: bold;'>"+value+"</span>";
    }else if(row.dzzt=="04"){
    	return "<span style='color:gray;font: bold;'>"+value+"</span>";
    }else{
    	return value;   
    }	
};
/**
 * @title:onClickRow
 * @description:点击一行的时候触发
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-27 14:57:21
 */	
jcjManage.onClickRow = function(rowIndex,rowData){
	var point = new Point(rowData.zbx,rowData.zby);
	//气泡框内容
	var openHtml =  "<div><img width='300' height='300' src='"+contextPath+"/images/bzdz/building/building.jpg'/></div>" +
			        "<div class='textwrap'><div class='oneText'>1</div><div class='title_big'>地址全称："+rowData.dzmc+"</div></div>" +
					"<div class='textwrap'><div class='oneText'>2</div><div class='title_big'>采集时间："+rowData.xt_cjsj+"</div></div>";
	if(rowData.dzzt=="01"){
		openHtml += "<div class='textwrap'><div class='oneText'>3</div><div class='title_big'>启用时间："+rowData.xt_hssj+"</div></div>";
	}else if(rowData.dzzt=="03"){
		openHtml += "<div class='textwrap'><div class='oneText'>3</div><div class='title_big'>退回时间："+rowData.xt_zhxgsj+"</div></div>";
	}else{
		openHtml += "<div class='textwrap'><div class='oneText'>3</div><div class='title_big'>注销时间："+rowData.xt_zhxgsj+"</div></div>";
	}
	openHtml += "<div class='textwrap'><div class='title_big'><div class='blueText'>层户结构</div></div></div>";
	jcjManage.map._MapApp.openInfoWindow(point,openHtml,true);
};
/**
 * @title:dzAdd
 * @description:新建地址
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-29 14:37:47
 */	
jcjManage.dzAdd = function(){
	menu_open('地址新建', '/dz/createDz');
};
/**
 * @title:doUpdate
 * @description:地址维护
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-29 14:37:47
 */	
jcjManage.doUpdate = function(linkObject, index){
	//阻止冒泡，不然要执行onClickRow
    cancelBubble(); 
    
};
/**
 * @title:doDelete
 * @description:地址注销
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-29 14:37:47
 */	
jcjManage.doDelete = function(linkObject, index){
	//阻止冒泡，不然要执行onClickRow
    cancelBubble(); 
	
};