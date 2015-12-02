if(typeof SgafzdryGl == "undefined" || !SgafzdryGl){
	var SgafzdryGl = {};
};
SgafzdryGl = function(){
	this.pk = Math.random();
};
SgafzdryGl.initMarkerArr = new Array();//放点对象
SgafzdryGl.setInt = "";//记录延时
SgafzdryGl.initMarker = "";//记录点击列表点
/**
 * @title:Jquery
 * @description:初始化地址管理
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-04-14 10:10:54
 */
$(function(){
	SgafzdryGl.onloadMap();
	$('#dg').datagrid({
		rowStyler: function(index,row){
			if(row.jzd_dzxz!=""&&row.jzd_dzid==""){
				return 'color:red;';
	    	}
		}
	});
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 10:16:21
 */	
SgafzdryGl.onloadMap = function(){
	/*地图对象*/
	SgafzdryGl.map = new FrameTools.Map();
	/*设置地图代理*/
	SgafzdryGl.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	SgafzdryGl.map.setMapDiv("mapDiv");
	/*加载地图*/
	SgafzdryGl.map.onloadMap();
	/*显示鹰眼*/
	SgafzdryGl.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	SgafzdryGl.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	SgafzdryGl.map.showNewMapServer("mapDiv","SgafzdryGl.map");
	/*加载地图工具条*/
	SgafzdryGl.map.buildTools("mapDiv","toolDiv","SgafzdryGl.map");
	/*设置工具条显示的位置*/
	SgafzdryGl.diyToolDiv();
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){SgafzdryGl.diyToolDiv();});
	/*加载边界坐标值*/
	SgafzdryGl.map.moveMapToBjzbz(bjzbz);
};
/**
 * @title:diyToolDiv
 * @description:设置工具条显示的位置
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 10:29:32
 */	
SgafzdryGl.diyToolDiv = function(){
	var top = $("#mapDiv").height() - 40;
	$("#toolDiv").css({
		"top" : top,
		"left" : 10
	});
};
/**
 * @title:loadPoint
 * @description:加载地图坐标点
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 10:16:36
 */	
SgafzdryGl.loadPoint = function(data){
	//延迟加载列表统计
	beforeTableLoad(data,'dg');
	//关闭所有器已经打开的气泡框
	SgafzdryGl.map._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(SgafzdryGl.setInt!=""){
		clearInterval(SgafzdryGl.setInt);
	}
	//判断地图上已经存在点图层清除
	if(SgafzdryGl.initMarkerArr!=null){
		var markerLen = SgafzdryGl.initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			SgafzdryGl.map._MapApp.removeOverlay(SgafzdryGl.initMarkerArr[j]);
		}
	}
	//清除记录点击列表点
	if(SgafzdryGl.initMarker!=""){
		//清除之前的坐标点
		SgafzdryGl.map._MapApp.removeOverlay(SgafzdryGl.initMarker);
	}
	//延时加载点图层
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	var count = 0;
	SgafzdryGl.setInt = setInterval(function(){
		if(count<len){
			var zbx = rows[count].jzd_zbx;
			var zby = rows[count].jzd_zby;
			var title = rows[count].xm;
			if(zbx!=""&&zby!=""){
				var initMarker = SgafzdryGl.map.initMarker(title,zbx,zby,'syrkBlue.png',null,null,43,37);
				SgafzdryGl.map._MapApp.addOverlay(initMarker);
				SgafzdryGl.initMarkerArr.push(initMarker);
				//地图元素和列表联动
				SgafzdryGl.addMapToListFun(initMarker,count);
			}
		}else{
			clearInterval(SgafzdryGl.setInt);
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
SgafzdryGl.addMapToListFun = function(PMarker,row){
	PMarker.addListener("click",function(){
		SgafzdryGl.addClickMarker(row);
	});
};
/**
 * @title:addClickMarker
 * @description:地图图标变换
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 19:28:43
 */	
SgafzdryGl.addClickMarker = function(row){
	//关闭所有器已经打开的气泡框
	SgafzdryGl.map._MapApp.closeInfoWindow();
	if(SgafzdryGl.initMarker!=""){
		//清除之前的坐标点
		SgafzdryGl.map._MapApp.removeOverlay(SgafzdryGl.initMarker);
	}
	//获取基本信息内容
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[row];
	var title = rowData.xm;
	var zbx = rowData.jzd_zbx;
	var zby = rowData.jzd_zby;
	if(zbx!=""&&zby!=""){
		SgafzdryGl.initMarker = SgafzdryGl.map.initMarker(title,zbx,zby,'syrkRedSmall.png',null,null,43,37);
		SgafzdryGl.map._MapApp.addOverlay(SgafzdryGl.initMarker);
		//鼠标移动到点上列表选中
		$('#dg').datagrid("selectRow",row);
		//打开气泡
		SgafzdryGl.openInfoWindow(row);
	}
}
/**
 * @title:openInfoWindow
 * @description:打开气泡框内容
 * @author: zhang_guoliang@founder.com
 * @param    
 * @date:2015-04-16 18:31:32
 */	
SgafzdryGl.openInfoWindow = function(row){
	//获取基本信息内容
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[row];
	var zbx = rowData.jzd_zbx;
	var zby = rowData.jzd_zby;
	var ryid = rowData.ryid;
	var zjhm = rowData.gmsfhm;
	var hjdz = rowData.hjd_dzms;
	var jzdz = "";
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
			       "<tr><td class='infoTable' width='80'>证件号码：</td><td class='infoTable1' colspan='2'><a class='infoTable' style='text-decoration:underline;' href='javascript:void(0)' onclick='SgafzdryGl.doEdit("+row+")'>"+rowData.zjhm+"</a></td></tr>";
			       if(rowData.jzd_mlpdm!=""&&rowData.jzd_dzid!=""){
			    	   openHtml += "<tr><td class='infoTable' width='80'>现居地址：</td><td class='infoTable1' colspan='2'><a class='infoTable' style='text-decoration:underline;' href='javascript:void(0)' onclick='SgafzdryGl.doBuildingShow("+row+")'>"+jzdz+"</a></td></tr>";
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
			       "</tr>" +
			       "<tr><td class='infoTable' width='80'>证件号码：</td><td class='infoTable1' colspan='2'><a class='infoTable' style='text-decoration:underline;' href='javascript:void(0)' onclick='SgafzdryGl.doEdit("+row+")'>"+rowData.gmsfhm+"</a></td></tr>" 
			       if(rowData.jzd_mlpdm!=""&&rowData.jzd_dzid!=""){
			    	   openHtml += "<tr><td class='infoTable' width='80'>现居地址：</td><td class='infoTable1' colspan='2'><a class='infoTable' style='text-decoration:underline;' href='javascript:void(0)' onclick='SgafzdryGl.doBuildingShow("+row+")'>"+jzdz+"</a></td></tr>";
			       }else{
			    	   openHtml += "<tr><td class='infoTable' width='80'>现居地址：</td><td class='infoTable1' colspan='2'>"+jzdz+"</td></tr>";
			       }
	  openHtml += "</table></td>" +
			       "</tr>" +
			       "</table>";
	}
	//打开气泡框
	SgafzdryGl.map._MapApp.openInfoWindow(point,openHtml,true);
};
/**
 * @title: subjzddzxz
 * @description:居住地址截取
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 15:08:32
 */	
SgafzdryGl.subjzddzxz = function(val, row, index){
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
SgafzdryGl.datagridProcessFormater = function(val,row,index){
	
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	
	var formatterStr = '';
	
	if(orglevel=="10"){//市局
		
//		if(){//管控中：责任区不为空
//			
//		}else if(){//待处理：分局为空
//			
//		}else if(){//下发中：分局不为空 且 责任区为空
//			
//		}
		
		if(!rowData.ssfj) {//待处理
			formatterStr = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SgafzdryGl.doXiaFa('+index+')">下发</a>&nbsp;';
		}
		formatterStr += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SgafzdryGl.doEdit('+index+')">查看</a>&nbsp;';
	}else if(orglevel=="21"){//分县局
		//	if(){//管控中：责任区不为空
		//		
		//	}else if(){//待处理：派出所为空
		//		
		//	}else if(){//下发中：派出所为空 且 责任区为空
		//		
		//	}
		if(!rowData.sspcs) {//待处理
			formatterStr = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SgafzdryGl.doXiaFa('+index+')">下发</a>&nbsp;';
		}
		formatterStr += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SgafzdryGl.doEdit('+index+')">查看</a>&nbsp;';
	}else if(orglevel=="32"){//派出所
		//	if(){//管控中：责任区不为空
		//		
		//	}else if(){//待处理：责任区为空
		//		
		//	}
		if(!rowData.sszrq) {//待处理
			formatterStr = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SgafzdryGl.doXiaFa('+index+')">下发</a>&nbsp;';
		}
		formatterStr += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SgafzdryGl.doEdit('+index+')">查看</a>&nbsp;';
		
	}else if(orglevel=="50"){
		//责任区理论不看当前页面
	}
	return formatterStr;
};
/**
 * @title:doSearch
 * @description:列表搜索
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 15:50:58
 */
SgafzdryGl.doSearch = function(value,name){
	value = $.trim(value)
	$('#dg').datagrid('load',{    
		'condition':value,
		'searchStatus':name
	});
};
/**
 * @title:onClickRow
 * @description:点击列表事件
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 16:06:43
 */
SgafzdryGl.onClickRow = function(rowIndex,rowData){
	SgafzdryGl.addClickMarker(rowIndex);
};
/**
 * @title:syrkAdd
 * @description:实有人口【新增】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 16:24:35
 */
SgafzdryGl.zdryAdd = function(){
	 //关闭所有器已经打开的气泡框
	 //SgafzdryGl.map._MapApp.closeInfoWindow();
	 menu_open('涉公安访重点人员新增','/zdrySgafzdryGl/addView');
};


SgafzdryGl.doXiaFa = function(index){
	
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	
	var dialogUrl = basePath + 'zdrySgafzdryGl/viewXiaFa/'+rowData.id
	$('#ddtest').dialog({    
	    title: '涉公安访重点人员下发',    
	    width: 700,    
	    height: 500,    
	    closed: true,    
	    cache: false,    
	    href: dialogUrl,    
	    modal: true,
	    onLoad:function(){    
	    	initPage();
	    }
	});    
	$("#ddtest").window("open");
}

/**
 * @title:doEdit
 * @description:实有人口【编辑】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 16:24:35
 */
SgafzdryGl.doEdit = function(index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/zdryzb/"+rowData.id+"/sgafview";
	menu_open("涉公安访重点人员查看",editUrl);
};
/**
 * @title:doSyrkXq
 * @description:实有人口【详情】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 16:24:35
 */
SgafzdryGl.doSyrkXq = function(index){
	//关闭所有器已经打开的气泡框
	SgafzdryGl.map._MapApp.closeInfoWindow();
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
 * @title:doCancel
 * @description:实有人口【注销】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-15 14:48:32
 */
SgafzdryGl.doCancel = function(linkObject,index){
	//重置之前选项
	cancelBubble(); 
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var id = rowData.id;
	var xm = rowData.xm;
	var ryid = rowData.ryid;
	var syrkywlxdm = rowData.syrkywlxdm;
	SgafzdryGl.resetButton("cancelform_"+syrkywlxdm);

	$("#id_"+syrkywlxdm).val(id);
	$("#qcyxm_"+syrkywlxdm).val(xm);
	$("#ryid_"+syrkywlxdm).val(ryid);
	$("#syrkywlxdm_"+syrkywlxdm).val(syrkywlxdm);
	var syrkywlxmc = window.top.getDictName(contextPath+'/common/dict/BD_D_SYRKYWLXDM.js',syrkywlxdm);
	$("#cancel_"+syrkywlxdm).window("open"); 
	if(rowData.xm){
		$("#cancel_"+syrkywlxdm).window("setTitle",""+syrkywlxmc+"注销【"+rowData.xm+"】");
	}else{
		$("#cancel_"+syrkywlxdm).window("setTitle",""+syrkywlxmc+"注销");
	}
	if(syrkywlxdm=="1"){
		if($("#czrkTable").attr("delayParse") == "true"){	
			initAddressSearch("czrk_qwd1", {}, "czrk_qwd_mlpdm", "czrk_qwd_mlpxz", "czrk_qwd2", {text:"czrk_qwd_dzxz",dzxzqh:"czrk_qwd_xzqhdm",id:"czrk_qwd_dzid",dzzrqdm:"czrk_qwd_zrqdm"}, null, null);
			$("#czrkTable").find("input.easyui-combobox-delay").removeClass("easyui-combobox-delay").addClass("easyui-combobox");
			$("#czrkTable").find("input.easyui-validatebox-delay").removeClass("easyui-validatebox-delay").addClass("easyui-validatebox");
			$.parser.parse("#czrkTable");
			$("#czrkTable").attr("delayParse", "false");
		}
	}else if(syrkywlxdm=="2"){
		if($("#jzrkTable").attr("delayParse") == "true"){
			initAddressSearch("jzrk_qwd1", {}, "jzrk_qwd_mlpdm", "jzrk_qwd_mlpxz", "jzrk_qwd2", {text:"jzrk_qwd_dzxz",dzxzqh:"jzrk_qwd_xzqhdm",id:"jzrk_qwd_dzid",dzzrqdm:"jzrk_qwd_zrqdm"}, null, null);
			$("#jzrkTable").find("input.easyui-combobox-delay").removeClass("easyui-combobox-delay").addClass("easyui-combobox");
			$("#jzrkTable").find("input.easyui-validatebox-delay").removeClass("easyui-validatebox-delay").addClass("easyui-validatebox");
			$.parser.parse("#jzrkTable");
			$("#jzrkTable").attr("delayParse", "false");
		}
	}else if(syrkywlxdm=="3"){
		if($("#ldrkTable").attr("delayParse") == "true"){
			initAddressSearch("ldrk_qwd1", {}, "ldrk_qwd_mlpdm", "ldrk_qwd_mlpxz", "ldrk_qwd2", {text:"ldrk_qwd_dzxz",dzxzqh:"ldrk_qwd_xzqhdm",id:"ldrk_qwd_dzid",dzzrqdm:"ldrk_qwd_zrqdm"}, null, null);
			$("#ldrkTable").find("input.easyui-combobox-delay").removeClass("easyui-combobox-delay").addClass("easyui-combobox");
			$("#ldrkTable").find("input.easyui-validatebox-delay").removeClass("easyui-validatebox-delay").addClass("easyui-validatebox");
			$.parser.parse("#ldrkTable");
			$("#ldrkTable").attr("delayParse", "false");
		}
	}else if(syrkywlxdm=="4"){
		if($("#jwryTable").attr("delayParse") == "true"){
			initAddressSearch("jwry_qwd1", {}, "jwry_qwd_mlpdm", "jwry_qwd_mlpxz", "jwry_qwd2", {text:"jwry_qwd_dzxz",dzxzqh:"jwry_qwd_xzqhdm",id:"jwry_qwd_dzid",dzzrqdm:"jwry_qwd_zrqdm"}, null, null);
			$("#jwryTable").find("input.easyui-combobox-delay").removeClass("easyui-combobox-delay").addClass("easyui-combobox");
			$("#jwryTable").find("input.easyui-validatebox-delay").removeClass("easyui-validatebox-delay").addClass("easyui-validatebox");
			$.parser.parse("#jwryTable");
			$("#jwryTable").attr("delayParse", "false");
		}
	}
};
/**
 * @title:detailSearch
 * @description:精确查询【窗口】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 18:11:36
 */
SgafzdryGl.detailSearch = function(){
	//加载字典项
	if($("#jqcxTable").attr("delayParse") == "true"){
		$("#jqcxTable").find("input.easyui-combobox-delay").removeClass("easyui-combobox-delay").addClass("easyui-combobox");
		$.parser.parse("#jqcxTable");
		$("#jqcxTable").attr("delayParse", "false");
	}
	$("#win").window("open"); 
	$("#queryForm").form("reset");
};

/**
 * 下发弹窗页面，确定下发动作
 */
SgafzdryGl.xiaFaButton = function(){
	$('#xiaFaForm').submit(); 
}

/**
 * @title:queryButton
 * @description:精确查询【确定】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 18:42:43
 */
SgafzdryGl.queryButton = function(){
	var searchStatus = document.getElementById("query_searchStatus").value;
	var xm = document.getElementById("query_xm").value;
	var gmsfhm = document.getElementById("query_gmsfhm").value;
	var xbdm = document.getElementById("query_xbdm").value;
	var jzd_dzxz = document.getElementById("query_jzd_dzxz").value;
	var condition = $('#searchbox').searchbox('getValue');;
	$('#dg').datagrid('load',{    
		'searchStatus':searchStatus,
		'xm':xm,
		'gmsfhm':gmsfhm,
		'xbdm':xbdm,
		'jzd_dzxz':jzd_dzxz,
		'condition':condition
	});
	SgafzdryGl.closeWindow("win");
};
/**
 * @title:closeWindow
 * @description:精确查询【关闭】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 18:47:32
 */
SgafzdryGl.closeWindow = function(obj){
	$("#"+obj).window("close");
};
/**
 * @title:resetButton
 * @description:精确查询【重置】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 18:48:43
 */
SgafzdryGl.resetButton = function(obj){
	$("#"+obj).form("reset");
 };
/**
 * @title:cancelButton
 * @description:实有人口【注销】
 * @author: zhang_guoliang@founder.com
 * @param formName 提交的FORM名称
 * @date:2015-04-14 18:42:43
 */
SgafzdryGl.cancelButton = function(obj){
	topMessager.confirm('','您确认要注销数据吗？',function(r){    
		if(r){
			$("#cancelform_" + obj).form("submit",{
				dataType:"json",
				success: function(result){
					result = parseReturn(result);
					if (result.status == "success"){
						SgafzdryGl.queryButton();
						topMessager.show({
							title: MESSAGER_TITLE,
							msg: result.message,
							timeout:1500
						});
						SgafzdryGl.closeWindow("cancel_"+obj);
					}
					else {
						topMessager.alert(MESSAGER_TITLE, result.message, "error");
					}
				}
			});
		}
	});
};
/**
 * @title:doBuildingShow
 * @description:层户结构【展现】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-05-07 09:34:23
 */
SgafzdryGl.doBuildingShow = function(index){
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