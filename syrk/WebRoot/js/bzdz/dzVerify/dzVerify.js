if(typeof DzVerify == "undefined" || !DzVerify){
	var DzVerify = {};
};
DzVerify = function(){
	this.pk = Math.random();
}
DzVerify.initMarkerArr = new Array();//放点对象
DzVerify.MrMbr = null;//默认地图中心点
DzVerify.setInt = "";//记录延时
DzVerify.zzjgdm = "";//记录列表选中的组织机构代码
DzVerify.rowIndex = 0;//记录列表选中的行数
/**
 * @title:Jquery
 * @description:初始化地址审核
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-02-05 14:24:45
 */
$(function(){
	DzVerify.onloadMap();
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-05 14:25:12
 */	
DzVerify.onloadMap = function(){
	/*地图对象*/
	DzVerify.map = new FrameTools.Map();
	/*设置地图代理*/
	DzVerify.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	DzVerify.map.setMapDiv("mapDiv");
	/*加载地图*/
	DzVerify.map.onloadMap();
	/*显示鹰眼*/
	DzVerify.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	DzVerify.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	DzVerify.map.showNewMapServer("mapDiv","DzVerify.map");
	/*加载地图工具条*/
	DzVerify.map.buildTools("mapDiv","toolDiv","DzVerify.map");
	//只在责任区和派出所级别加载辖区边界 辖区太大在IE8会停止运行脚本
	if(orglevel=="50"||orglevel=="32"){
		DzVerify.map.moveMapToBjzbz(bjzbz);
	}
};
/**
 * @title:loadPoint
 * @description:加载地图坐标点
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-05 15:00:32
 */	
DzVerify.loadPoint = function(data){
	//延迟加载列表统计
	beforeTableLoad(data,'dg');
	//关闭所有器已经打开的气泡框
	DzVerify.map._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(DzVerify.setInt!=""){
		clearInterval(DzVerify.setInt);
	}
	//判断地图上已经存在点图层清除
	if(DzVerify.initMarkerArr!=null){
		var markerLen = DzVerify.initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			DzVerify.map._MapApp.removeOverlay(DzVerify.initMarkerArr[j]);
		}
	}
	//延时加载点图层
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	var count = 0;
	DzVerify.setInt = setInterval(function(){
		if(count<len){
			DzVerify.loadInitMarker(rows,count);
		}else{
			clearInterval(DzVerify.setInt);
		}
		count++;
	},90);
};
/**
 * @title:loadInitMarker
 * @description:加载点方法
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-06 10:50:21
 */	
DzVerify.loadInitMarker = function(rows,count){
	var zbx = rows[count].zbx;
	var zby = rows[count].zby;
	var title = rows[count].mlphqc;
	var shztdm = rows[count].shztdm;
	var mldzid = rows[count].mldzid;
	if(zbx!=""&&zby!=""){
		//气泡框内容
		var openHtml =  "<div id='uploadFileImageDiv' style='width: 300px; height: 300px;text-align: center;'></div>" +
				        "<div class='divwrap'><div class='oneText'>1</div><div class='title_big'>地址全称："+rows[count].dzmc+"</div></div>" +
						"<div class='divwrap'><div class='oneText'>2</div><div class='title_big'>采集时间："+rows[count].xt_cjsj+"</div></div>";
		//地图标点
		var img = "";
		if(shztdm=="01"){
			//黄色
			img = "jzw4.png";
			openHtml += "<div class='divwrap'><div class='oneText'>3</div><div class='title_big'>管辖派出所："+rows[count].pcsmc+"</div></div>" +
						"<div class='divwrap'><div class='oneText'>4</div><div class='title_big'>管辖责任区："+rows[count].zrqmc+"</div></div>";
		}else if(shztdm=="02"){
			//绿色
			img = "jzw3.png";
			openHtml += "<div class='divwrap'><div class='oneText'>3</div><div class='title_big'>管辖派出所："+rows[count].pcsmc+"</div></div>" +
						"<div class='divwrap'><div class='oneText'>4</div><div class='title_big'>管辖责任区："+rows[count].zrqmc+"</div></div>";
		}else if(shztdm=="03"){
			//红色
			img = "jzw1.png";
			openHtml += "<div class='divwrap'><div class='oneText'>3</div><div class='title_big'>管辖派出所："+rows[count].pcsmc+"</div></div>" +
						"<div class='divwrap'><div class='oneText'>4</div><div class='title_big'>管辖责任区："+rows[count].zrqmc+"</div></div>";
		}else{
			//灰色
			img = "jzw0.png";
		}
		var initMarker = DzVerify.map.initMarker(title,zbx,zby,img,openHtml,null,43,37);
		DzVerify.map._MapApp.addOverlay(initMarker);
		DzVerify.initMarkerArr.push(initMarker);
		//地图元素和列表联动
		DzVerify.addMapToListFun(initMarker,count);
		initMarker.addListener("click", function(){
			DzVerify.uploadFileImageView(mldzid);
		});
	}
};
/**
 * @title:uploadFileImageView
 * @description:加载照片
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2015-03-21 14:56:32
 */
DzVerify.uploadFileImageView = function(mldzid){
	uploadFileImageView('BZDZ_ADD_MLDZDXB',mldzid, 'uploadFileImageDiv', 300, 275,contextPath+'/images/bzdz/building/building.jpg'); //附件图片多张显示
};
/**
 * @title:addMapToListFun
 * @description:地图元素和列表联动
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-05 20:17:53
 */	
DzVerify.addMapToListFun = function(PMarker,row){
	PMarker.addListener("click",function(){
		//鼠标移动到点上列表选中
		$('#dg').datagrid("selectRow",row);
	});
};
/**
 * @title:queryButton
 * @description:条件查询按钮
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-05 16:03:43
 */	
DzVerify.queryButton = function(){
	var dzmc = $.trim($('#dzmc').searchbox('getValue'));
	var shztdm = document.getElementById("shztdm").value;
	var pcsdm = document.getElementById("pcsdm").value;
	var zrqdm = document.getElementById("zrqdm").value;
	//加载查询列表
	$('#dg').datagrid('load',{    
		'dzmc':dzmc,
		'shztdm':shztdm,
		'pcsdm':pcsdm,
		'zrqdm':zrqdm
	});
	DzVerify.zzjgdm = "";
	/*清楚地图上所有的标记*/
	DzVerify.map._MapApp.clear();
};
/**
 * @title:datagridDzzt
 * @description:地址状态颜色
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-05 16:17:32
 */	
DzVerify.datagridDzzt = function(value,row,index){
	var opts = $(this);
	if (opts[0].dictName) {
		try {
			value = window.top.getDictName(opts[0].dictName, value);
		}
		catch (err) {}
	}
	if(row.shztdm=="01"){
    	return "<span style='color:#C86C00;font: bold;'>"+value+"</span>";
    }else if(row.shztdm=="02"){
    	return "<span style='color:green;font: bold;'>"+value+"</span>";
    }else if(row.shztdm=="03"){
    	return "<span style='color:red;font: bold;'>"+value+"</span>";
    }else{
    	return value;   
    }
};
/**
 * @title:datagridProcessFormater
 * @description:列表操作
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-05 16:17:32
 */
DzVerify.datagridProcessFormater = function(val,row,index){
	if(row.shztdm=="02"){
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzVerify.dzVerifyShAndXq(this,'+index+',1,0,1)">详情</a>&nbsp;';
    }else if(row.shztdm=="03"){
    	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzVerify.dzVerifyShAndXq(this,'+index+',1,1,1)">详情</a>&nbsp;';
    }else if(row.shztdm=="01"){
    	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzVerify.dzVerifyShAndXq(this,'+index+',0,1,1)">审核</a>&nbsp;';
    }else{
    	return "";
    }
};
/**
 * @title:onClickRow
 * @description:点击一行的时候触发
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-05 09:58:03
 */
DzVerify.onClickRow = function(rowIndex,rowData){
	DzVerify.rowIndex = rowIndex;
	//关闭所有器已经打开的气泡框
	DzVerify.map._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(DzVerify.setInt!=""){
		clearInterval(DzVerify.setInt);
	}
	//判断地图上已经存在点图层清除
	if(DzVerify.initMarkerArr!=null){
		var markerLen = DzVerify.initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			DzVerify.map._MapApp.removeOverlay(DzVerify.initMarkerArr[j]);
		}
	}
	if(DzVerify.zzjgdm!=rowData.zrqdm){
		DzVerify.zzjgdm = rowData.zrqdm;
		if(DzVerify.zzjgdm==""||DzVerify.zzjgdm==null){
			DzVerify.zzjgdm = rowData.pcsdm;
		}
		//查询组织机构信息（主要查询边界坐标，无公共方法）
		var params = {zzjgdm:DzVerify.zzjgdm};
		var fajax = new FrameTools.Ajax(contextPath+"/dz/queryZzjg",DzVerify.queryZzjg_back);
		fajax.send(params);
	}else{
		//加载点选的点信息
		var rows = $('#dg').datagrid("getRows");
		DzVerify.loadInitMarker(rows,DzVerify.rowIndex);
	}
};
/**
 * @title:queryZzjg_back
 * @description:查询组织机构信息_回调函数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-05 10:22:32
 */
DzVerify.queryZzjg_back = function(json){
	if(json){
		if(json[0].bjzbz!=""){
			DzVerify.map.moveMapToBjzbz(json[0].bjzbz);
		}
		//加载点选的点信息
		var rows = $('#dg').datagrid("getRows");
		DzVerify.loadInitMarker(rows,DzVerify.rowIndex);
	}
};
/**
 * @title:dzVerifyShAndXq
 * @description:地址审核或查看详情
 * @author: zhang_guoliang@founder.com
 * @param type 0为可编辑、1为只读，dzChb地址层户表 0为层户地址对象表、1为层户地址审核表、chType层户结构 0为编辑、1为只读    
 * @date:2015-02-05 14:29:43
 */
DzVerify.dzVerifyShAndXq = function(linkObject,index,type,dzChb,chType){
	//阻止冒泡，不然要执行onClickRow
    cancelBubble(); 
    var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var title = "";
	if(type=="0"){
		title = "审核";
	}else{
		title = "详情";
	}
    menu_open('【'+rowData.mlphqc+'】'+title+'','/dz/createDzShAndXq?mldzid='+rowData.mldzid+'&type='+type+'&dzChb='+dzChb+'&chType='+chType+'&mainTabID='+getMainTabID());
};