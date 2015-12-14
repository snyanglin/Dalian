if(typeof SyrkGl == "undefined" || !SyrkGl){
	var SyrkGl = {};
};
SyrkGl = function(){
	this.pk = Math.random();
};
SyrkGl.initMarkerArr = new Array();//放点对象
SyrkGl.setInt = "";//记录延时
SyrkGl.initMarker = "";//记录点击列表点
/**
 * @title:Jquery
 * @description:初始化地址管理
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-04-14 10:10:54
 */
$(function(){
	SyrkGl.onloadMap();
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
SyrkGl.onloadMap = function(){
	/*地图对象*/
	SyrkGl.map = new FrameTools.Map();
	/*设置地图代理*/
	SyrkGl.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	SyrkGl.map.setMapDiv("mapDiv");
	/*加载地图*/
	SyrkGl.map.onloadMap();
	/*显示鹰眼*/
	SyrkGl.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	SyrkGl.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	SyrkGl.map.showNewMapServer("mapDiv","SyrkGl.map");
	/*加载地图工具条*/
	SyrkGl.map.buildTools("mapDiv","toolDiv","SyrkGl.map");
	/*设置工具条显示的位置*/
	SyrkGl.diyToolDiv();
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){SyrkGl.diyToolDiv();});
	/*加载边界坐标值*/
	SyrkGl.map.moveMapToBjzbz(bjzbz);
};
/**
 * @title:diyToolDiv
 * @description:设置工具条显示的位置
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 10:29:32
 */	
SyrkGl.diyToolDiv = function(){
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
SyrkGl.loadPoint = function(data){
	//延迟加载列表统计
	beforeTableLoad(data,'dg');
	//关闭所有器已经打开的气泡框
	SyrkGl.map._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(SyrkGl.setInt!=""){
		clearInterval(SyrkGl.setInt);
	}
	//判断地图上已经存在点图层清除
	if(SyrkGl.initMarkerArr!=null){
		var markerLen = SyrkGl.initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			SyrkGl.map._MapApp.removeOverlay(SyrkGl.initMarkerArr[j]);
		}
	}
	//清除记录点击列表点
	if(SyrkGl.initMarker!=""){
		//清除之前的坐标点
		SyrkGl.map._MapApp.removeOverlay(SyrkGl.initMarker);
	}
	//延时加载点图层
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	var count = 0;
	SyrkGl.setInt = setInterval(function(){
		if(count<len){
			var zbx = rows[count].jzd_zbx;
			var zby = rows[count].jzd_zby;
			var title = rows[count].xm;
			if(zbx!=""&&zby!=""){
				var initMarker = SyrkGl.map.initMarker(title,zbx,zby,'syrkBlue.png',null,null,43,37);
				SyrkGl.map._MapApp.addOverlay(initMarker);
				SyrkGl.initMarkerArr.push(initMarker);
				//地图元素和列表联动
				SyrkGl.addMapToListFun(initMarker,count);
			}
		}else{
			clearInterval(SyrkGl.setInt);
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
SyrkGl.addMapToListFun = function(PMarker,row){
	PMarker.addListener("click",function(){
		SyrkGl.addClickMarker(row);
	});
};
/**
 * @title:addClickMarker
 * @description:地图图标变换
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 19:28:43
 */	
SyrkGl.addClickMarker = function(row){
	//关闭所有器已经打开的气泡框
	SyrkGl.map._MapApp.closeInfoWindow();
	if(SyrkGl.initMarker!=""){
		//清除之前的坐标点
		SyrkGl.map._MapApp.removeOverlay(SyrkGl.initMarker);
	}
	//获取基本信息内容
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[row];
	var title = rowData.xm;
	var zbx = rowData.jzd_zbx;
	var zby = rowData.jzd_zby;
	if(zbx!=""&&zby!=""){
		SyrkGl.initMarker = SyrkGl.map.initMarker(title,zbx,zby,'syrkRedSmall.png',null,null,43,37);
		SyrkGl.map._MapApp.addOverlay(SyrkGl.initMarker);
		//鼠标移动到点上列表选中
		$('#dg').datagrid("selectRow",row);
		//打开气泡
		SyrkGl.openInfoWindow(row);
	}
}
/**
 * @title:openInfoWindow
 * @description:打开气泡框内容
 * @author: zhang_guoliang@founder.com
 * @param    
 * @date:2015-04-16 18:31:32
 */	
SyrkGl.openInfoWindow = function(row){
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
			       "<tr><td class='infoTable' width='80'>证件号码：</td><td class='infoTable1' colspan='2'><a class='infoTable' style='text-decoration:underline;' href='javascript:void(0)' onclick='SyrkGl.doEdit("+row+")'>"+rowData.zjhm+"</a></td></tr>";
			       if(rowData.jzd_mlpdm!=""&&rowData.jzd_dzid!=""){
			    	   openHtml += "<tr><td class='infoTable' width='80'>现居地址：</td><td class='infoTable1' colspan='2'><a class='infoTable' style='text-decoration:underline;' href='javascript:void(0)' onclick='SyrkGl.doBuildingShow("+row+")'>"+jzdz+"</a></td></tr>";
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
			       "<tr><td class='infoTable' width='80'>证件号码：</td><td class='infoTable1' colspan='2'><a class='infoTable' style='text-decoration:underline;' href='javascript:void(0)' onclick='SyrkGl.doEdit("+row+")'>"+rowData.zjhm+"</a></td></tr>" 
			      // "<tr><td class='infoTable' width='80'>户籍地址描述：</td><td class='infoTable1' colspan='2'>"+hjdz+"</td></tr>";
			       if(rowData.jzd_mlpdm!=""&&rowData.jzd_dzid!=""){
			    	   openHtml += "<tr><td class='infoTable' width='80'>现居地址：</td><td class='infoTable1' colspan='2'><a class='infoTable' style='text-decoration:underline;' href='javascript:void(0)' onclick='SyrkGl.doBuildingShow("+row+")'>"+jzdz+"</a></td></tr>";
			       }else{
			    	   openHtml += "<tr><td class='infoTable' width='80'>现居地址：</td><td class='infoTable1' colspan='2'>"+jzdz+"</td></tr>";
			       }
	  openHtml += "</table></td>" +
			       "<td><div><img id='topPhotoid' width='160' height='200' alt='' src= '"+contextPath+"/zpfjPtryzp/queryPtryzpSingle.jpg?pk="+Math.random()+"&ryid="+ryid+"&zjhm="+zjhm+"&cyzjdm="+cyzjdm+"'/></div></td>" +
			       "</tr>" +
			       "</table>";
	}
	//打开气泡框
	SyrkGl.map._MapApp.openInfoWindow(point,openHtml,true);
};
/**
 * @title: subjzddzxz
 * @description:居住地址截取
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 15:08:32
 */	
SyrkGl.subjzddzxz = function(val, row, index){
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
SyrkGl.datagridProcessFormater = function(val,row,index){
	
	if(biztype == "12"){
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SyrkGl.doEdit('+index+')">编辑</a>&nbsp;'+
    	   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SyrkGl.doCancel(this, '+index+')">注销</a>&nbsp;';
	}else{
		if(orglevel=="50"){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SyrkGl.doEdit('+index+')">编辑</a>&nbsp;'+
		       	   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SyrkGl.doCancel(this, '+index+')">注销</a>&nbsp;';
		}else if(orglevel=="32"){
			var rows = $('#dg').datagrid('getData');
			var rowData = rows.rows[index];
			if(rowData.syrkywlxdm == "4"){
				return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SyrkGl.doEdit('+index+')">编辑</a>&nbsp;'+
			       	   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SyrkGl.doCancel(this, '+index+')">注销</a>&nbsp;';
			}else{
				return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SyrkGl.doSyrkXq('+index+')">详情</a>&nbsp;';
			}
		}
	}
	
};
/**
 * @title:doSearch
 * @description:列表搜索
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 15:50:58
 */
SyrkGl.doSearch = function(value,name){
	value = $.trim(value)
	$('#dg').datagrid('load',{    
		'searchbox':value
	});
};
/**
 * @title:onClickRow
 * @description:点击列表事件
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 16:06:43
 */
SyrkGl.onClickRow = function(rowIndex,rowData){
	SyrkGl.addClickMarker(rowIndex);
};
/**
 * @title:syrkAdd
 * @description:实有人口【新增】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 16:24:35
 */
SyrkGl.syrkAdd = function(){
	 //关闭所有器已经打开的气泡框
	 SyrkGl.map._MapApp.closeInfoWindow();
	 menu_open('实有人口新增','/syrkGl/add?mainTabID='+getMainTabID()+'&invokeJSMethod=SyrkGl.queryButton');
};
/**
 * @title:doEdit
 * @description:实有人口【编辑】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 16:24:35
 */
SyrkGl.doEdit = function(index){
	//关闭所有器已经打开的气泡框
	SyrkGl.map._MapApp.closeInfoWindow();
    cancelBubble(); 
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/syrkEdit/"+rowData.ryid+"/"+rowData.id+"/view";
	if(rowData.xm){
		menu_open("实有人口【"+rowData.xm+"】",editUrl);
	}else{
		menu_open("实有人口",editUrl);
	}
};
/**
 * @title:doSyrkXq
 * @description:实有人口【详情】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 16:24:35
 */
SyrkGl.doSyrkXq = function(index){
	//关闭所有器已经打开的气泡框
	SyrkGl.map._MapApp.closeInfoWindow();
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
SyrkGl.doCancel = function(linkObject,index){
	//重置之前选项
	cancelBubble(); 
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var id = rowData.id;
	var xm = rowData.xm;
	var ryid = rowData.ryid;
	var syrkywlxdm = rowData.syrkywlxdm;
	SyrkGl.resetButton("cancelform_"+syrkywlxdm);

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
SyrkGl.detailSearch = function(){
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
 * @title:queryButton
 * @description:精确查询【确定】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 18:42:43
 */
SyrkGl.queryButton = function(){
	var syrkywlxdm = document.getElementById("syrkywlxdm").value;
	var xm = document.getElementById("xm").value;
	var zjhm = document.getElementById("zjhm").value;
	var xbdm = document.getElementById("xbdm").value;
	var mzdm = document.getElementById("mzdm").value;
	var jzd_dzxz = document.getElementById("jzd_dzxz").value;
	var searchbox = $('#searchbox').searchbox('getValue');;
	$('#dg').datagrid('load',{    
		'syrkywlxdm':syrkywlxdm,
		'xm':xm,
		'zjhm':zjhm,
		'xbdm':xbdm,
		'mzdm':mzdm,
		'jzd_dzxz':jzd_dzxz,
		'searchbox':searchbox
	});
	SyrkGl.closeWindow("win");
};
/**
 * @title:closeWindow
 * @description:精确查询【关闭】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 18:47:32
 */
SyrkGl.closeWindow = function(obj){
	$("#"+obj).window("close");
};
/**
 * @title:resetButton
 * @description:精确查询【重置】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 18:48:43
 */
SyrkGl.resetButton = function(obj){
	$("#"+obj).form("reset");
 };
/**
 * @title:cancelButton
 * @description:实有人口【注销】
 * @author: zhang_guoliang@founder.com
 * @param formName 提交的FORM名称
 * @date:2015-04-14 18:42:43
 */
SyrkGl.cancelButton = function(obj){
	topMessager.confirm('','您确认要注销数据吗？',function(r){    
		if(r){
			$("#cancelform_" + obj).form("submit",{
				dataType:"json",
				success: function(result){
					result = parseReturn(result);
					if (result.status == "success"){
						SyrkGl.queryButton();
						topMessager.show({
							title: MESSAGER_TITLE,
							msg: result.message,
							timeout:1500
						});
						SyrkGl.closeWindow("cancel_"+obj);
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
SyrkGl.doBuildingShow = function(index){
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