if(typeof DmManage == "undefined" || !DmManage){
	var DmManage = {};
};
DmManage = function(){
	this.pk = Math.random();
};
DmManage.dlstMap = null;//记录当前的地理实体
/**
 * @title:Jquery
 * @description:初始化地名管理
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2014-12-11 16:11:21
 */
$(function(){
	DmManage.onloadMap();
	//新增权限判断
	if(orglevel != "31" && orglevel !="30"){
		//设置只读属性
       DmManage.onloadReadonly();
 	   document.getElementById("dmaddid").style.display = "none";
    }
	//键盘回车进行查询
	$("body").bind("keydown",function(e){
        if(e.keyCode==13){
        	DmManage.queryButton();
        }		
	});
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-22 02:12:31
 */	
DmManage.onloadMap = function(){
	/*地图对象*/
	DmManage.map = new FrameTools.Map();
	/*设置地图代理*/
	DmManage.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	DmManage.map.setMapDiv("mapDiv");
	/*加载地图*/
	DmManage.map.onloadMap();
	/*显示鹰眼*/
	DmManage.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	DmManage.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	DmManage.map.showNewMapServer("mapDiv","DmManage.map");
	/*加载地图工具条*/
	DmManage.map.buildTools("mapDiv","toolDiv","DmManage.map");
	//只在责任区和派出所级别加载辖区边界 辖区太大在IE8会停止运行脚本
	if(orglevel=="50"||orglevel=="32"){
		DmManage.map.moveMapToBjzbz(bjzbz);
	}
};
/**
 * @title:queryButton
 * @description:查询按钮
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-12 14:03:12
 */	
DmManage.queryButton = function(){
	var dmmc = document.getElementById("dmmc").value;
	var xzqh = document.getElementById("xzqh").value;
	var gxsxj = document.getElementById("gxsxj").value;
	var gxpcs = document.getElementById("gxpcs").value;
	dmmc = $.trim(dmmc);
	//加载查询列表
	$('#dg').datagrid(
		'load',{    
			'dmmc':dmmc,
			'xzqhdm':xzqh,
			'fxjdm':gxsxj,
			'pcsdm':gxpcs
	});
};
/**
 * @title:datagridProcessFormater
 * @description:列表操作
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-12 14:07:52
 */	
DmManage.datagridProcessFormater = function(val,row,index){
	if(orglevel == "31" || orglevel =="30"){
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DmManage.updateDmmc(this, '+index+')">维护</a>&nbsp;'+
    	   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DmManage.doDelete(this, '+index+')">注销</a>&nbsp;';
	}
};
/**
 * @title:dmAdd
 * @description:新增地名
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-12 14:07:52
 */	
DmManage.dmAdd = function(){
	var paramArray =null;
	var url = contextPath + "/dm/saveEditDm";
	openWindowWithSave(false, null,this.Window, 
		paramArray, 
   		{
   		title:'新增地名',
   		url:url,
   		maximizable:false,
   		width:680,
   		height:450
   		}, 
   		'您确定要保存吗？',null,null
   	);
};
/**
 * @title:doDelete
 * @description:注销地名
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-12 14:07:52
 */	
DmManage.doDelete = function(linkObject, index){
	cancelBubble();//阻止冒泡，不然要执行onClickRow
	$("#index").val(index);
	document.getElementById("xt_zxyy").value = "";
	$("#dmzxId").window("open"); 
	$("#dmzxId").window("setTitle","地名注销");
};
/**
 * @title:updateDmmc
 * @description:更新地名名称
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-09 12:38:32
 */	
DmManage.updateDmmc = function(linkObject, index){
	cancelBubble();//阻止冒泡，不然要执行onClickRow
	var paramArray =null;
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var url = contextPath + "/dm/saveEditDm?dmdm="+rowData.dmdm;
	openWindowWithSave(false, null,this.Window, 
		paramArray, 
   		{
   		title:'维护地名',
   		url:url,
   		maximizable:false,
   		width:680,
   		height:450
   		}, 
   		'您确定要保存吗？',null,null
   	);
};
/**
 * @title:onSelectRow
 * @description:点击列表地图画点线面
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-18 14:34:23
 */	
DmManage.onSelectRow = function(rowIndex, data){
	if(data.dlst!=""&&data.dlst!=null){
		if(DmManage.dlstMap!=data.dlst){
			var params = {objectid:data.dlst};
			var fajax =new FrameTools.Ajax(contextPath+"/dm/quertDlst",DmManage.onSelectRow_back);
			fajax.send(params);
			DmManage.dlstMap = data.dlst;
		}
	}else{
		topMessager.show({
			title: MESSAGER_TITLE,
			msg: '所选择的地名没有标注空间信息！',
			timeout:2000
		});
	}
};
/**
 * @title:onSelectRow
 * @description:点击列表地图画点线面_回调函数
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-18 14:34:56
 */	
DmManage.onSelectRow_back = function(json){
	if(json){
		var Linepolyline = DmManage.map.initPolyline(json[0].coords,"#FF0000",8,1);
		if(Linepolyline){
			/*清楚地图上所有的标记*/
			DmManage.map._MapApp.clear();
			DmManage.map._MapApp.addOverlay(Linepolyline);
			if(DmManage.map.verify(json[0].coords)){
				var point = new Point(centerZbx,centerZby) 
				DmManage.map._MapApp.centerAndZoom(point,16);
			}
		}
	}
};
/**
 * @title:onloadReadonly
 * @description:设置只读属性
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-09 18:54:23
 */	
DmManage.onloadReadonly = function(){
	var xzqh = document.getElementById("xzqh").value;
	var gxsxj = document.getElementById("gxsxj").value;
	if(xzqh!=null&&xzqh!=""){
		//行政区划【只读】
		setInputReadonly('xzqh', true);
	}
	if(gxsxj!=null&&gxsxj!=""){
		//管辖分(县)局【只读】
		setInputReadonly('gxsxj', true);
		var url = basePath +'gzjk/queryOrgLower?orgCode='+userOrgCode;
		$('#gxpcs').combobox('reload', url);
	}
};
/**
 * @title:cancelButton
 * @description:地名注销【注销】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-05-18 14:47:32
 */
DmManage.cancelButton = function(){
	if($("#cancelform").form('validate')){
		//关闭弹出框
		DmManage.closeWindow();
		var index = document.getElementById("index").value;
		var xt_zxyy = document.getElementById("xt_zxyy").value;
		var rows = $('#dg').datagrid('getData');
		var rowData = rows.rows[index];
		var url = contextPath+"/dm/crossouDm";
		$.ajax({
			url: url,
			type: 'POST',
			data: {dmdm:rowData.dmdm,xt_zxyy:xt_zxyy}
		}).done(function(result) {
			//刷新列表
			doSubmitResult(result, null, "dg");
		});
	}
};
/**
 * @title:closeWindow
 * @description:地名注销【关闭】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-05-18 14:55:57
 */
DmManage.closeWindow = function(){
	$("#dmzxId").window("close");
};