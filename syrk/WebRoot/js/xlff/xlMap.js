if(typeof XlMap == "undefined" || !XlMap){
	var XlMap = {};
};

XlMap = function(){
	this.pk = Math.random();
};

//设置录入项
var orgcode = userOrgCode;
var kssj = "";
var jssj = "";
var f1 = "";
var f2 = "";
var f3 = "";
var f4 = "";
//色块, 用于清除
var cols = new Array();
var tils = new Array();
//浮动层记录，用于是否清空之前层
XlMap.floatWin = "";
//初始化方法
$(function(){
	//加载地图
	XlMap.loadMap();
	//初始化浮动窗口
	XlMap.initFloatWin_back(userOrgCode);
	//查询设置并画面
	XlMap.getSZ();
	//录入框tooltip
	$("#f1").tooltip({
    	position: 'left',
    	content: '<span style="color:#fff"; font-size:"10"; >注意阀值的大小顺序</span>',
    	onShow: function(){
    		$(this).tooltip('tip').css({
    			backgroundColor: '#666',
    			borderColor: '#444'
    		});
    	}
    });
	$("#f2").tooltip({
    	position: 'left',
    	content: '<span style="color:#fff"; font-size:"10"; >注意阀值的大小顺序</span>',
    	onShow: function(){
    		$(this).tooltip('tip').css({
    			backgroundColor: '#666',
    			borderColor: '#444'
    		});
    	}
    });
	$("#f3").tooltip({
    	position: 'left',
    	content: '<span style="color:#fff"; font-size:"10"; >注意阀值的大小顺序</span>',
    	onShow: function(){
    		$(this).tooltip('tip').css({
    			backgroundColor: '#666',
    			borderColor: '#444'
    		});
    	}
    });
	$("#f4").tooltip({
    	position: 'left',
    	content: '<span style="color:#fff"; font-size:"10"; >注意阀值的大小顺序</span>',
    	onShow: function(){
    		$(this).tooltip('tip').css({
    			backgroundColor: '#666',
    			borderColor: '#444'
    		});
    	}
    });
});

//加载地图
XlMap.loadMap = function(){
	/*地图对象*/
	XlMap.map = new FrameTools.Map();
	/*设置地图代理*/
	XlMap.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	XlMap.map.setMapDiv("mapDiv");
	/*加载地图*/
	XlMap.map.onloadMap();
	/*显示鹰眼*/
	XlMap.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	XlMap.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	XlMap.map.showNewMapServer("mapDiv","XlMap.map");
	/*加载地图工具条*/
	XlMap.map.buildTools("mapDiv","toolDiv","XlMap.map");
	//只在责任区和派出所级别加载辖区边界 辖区太大在IE8会停止运行脚本
	if(orglevel=="50"||orglevel=="32"||orglevel=="21"){
		XlMap.map.moveMapToBjzbz(bjzbz);
	}
};

/**
 * 根据多个组织机构来加载四色面数据
 */
XlMap.intoMap = function(pnodes){
	if(pnodes!=''){
		var temp = "";
		for(var i=0; i<pnodes.length; i++){
			temp += pnodes[i].orgcode + ",";
		}
		var params = {orgcode: temp.substr(0, temp.length-1), kssj:kssj, jssj:jssj, f1:f1, f2:f2, f3:f3, f4:f4};
		var fajax =new FrameTools.Ajax(contextPath+"/xlff/querySsyj", XlMap.doArea_into);
		fajax.send(params);
	}
};

/**
 * 实施铺面
 */
XlMap.doArea_into = function(json){
	if(json!=null&&json.length>0){
		//区域范围显示则四色预警清除
		var countZrq = json.length;
		var colors = new Array("red", "green", "orange", "yellow");
		//逐个铺面
		var i = 0;
		json.MMM = setInterval(function(){
			if(i < countZrq){
	        	if(undefined != json[i].bjzbz && null!=json[i].bjzbz && json[i].bjzbz!=""){
	        		XlMap.showArea(json[i].zzjgdm, json[i].zzjgmc, json[i].bjzbz, json[i].color=='' ? 'green' : json[i].color);
	        	}
			} else {
				clearInterval(json.MMM);
			}
	    i++;
		}, 50);
	}
	
};

/**
 * 铺面方法
 */
XlMap.showArea = function(dm,mc,zbz,col){
	var ObjMap = new Polygon(zbz, "red", 3, 0.4,col);
	var pMbr = ObjMap.getMBR();
	var cPoint = pMbr.centerPoint();
	var _pTitle = new Title(mc,12,7,"宋体","#000000","#FFFFFF","#FFFFFF","2");
	_pTitle.setPoint(cPoint);
	XlMap.map._MapApp.addOverlay(ObjMap);
	XlMap.map._MapApp.addOverlay(_pTitle);
	//画面时，将面和标题放入数组，清除方法里用
	cols.push(ObjMap);
	tils.push(_pTitle);
};

/**
 * 加载地图
 */
XlMap.queryXlZrq = function(parm){
	if(parm!=''){
		orgcode = parm["orgcode"];
		kssj = parm["kssj"];
		jssj = parm["jssj"];
		f1 = parm["f1"];
		f2 = parm["f2"];
		f3 = parm["f3"];
		f4 = parm["f4"];
		var params = {orgcode: orgcode};
		var fajax =new FrameTools.Ajax(contextPath+"/xlff/downMap", XlMap.intoMap);
		fajax.send(params);
	}
};

/**
 * 加载设置
 * 若该住址机构用户存在设置，则将数据显示在浮动层，并四色预警查询
*/
XlMap.getSZ = function(){
	XlMap.clearMarkers();
	$.post(contextPath + "/xlff/queryXlff", {orgcode:userOrgCode},function(d){
		if(d != false){
			$("#kssj").val(d.kssj);
       		$("#jssj").val(d.jssj);
       		$("#f1").val(d.f1);
       		$("#f2").val(d.f2);
       		$("#f3").val(d.f3);
       		$("#f4").val(d.f4);
       		var kssj = $("#kssj").val();
       		var jssj = $("#jssj").val();
       		var f1 = $("#f1").val();
       		var f2 = $("#f2").val();
       		var f3 = $("#f3").val();
       		var f4 = $("#f4").val();
       		var map = {};
       		map["kssj"] = kssj;
       		map["jssj"] = jssj;
       		map["f1"] = f1;
       		map["f2"] = f2;
       		map["f3"] = f3;
       		map["f4"] = f4;
       		map["orgcode"] = userOrgCode;
       		//所有录入项不为空才可以四色预警查询
       		if(kssj!='' && jssj!='' && f1!='' && f2!='' && f3!='' && f4!=''){
       			XlMap.queryXlZrq(map);
       		} 
		}
	},'json');
}
 
/**
 * 保存设置
*/
XlMap.setOption = function(){
	 var kssj = $("#kssj").val();
	 var jssj = $("#jssj").val();
	 var f1 = $("#f1").val();
	 var f2 = $("#f2").val();
	 var f3 = $("#f3").val();
	 var f4 = $("#f4").val();
	 if(kssj > jssj){
		 $.messager.alert("提示", "截止日期要大于起始日期!");
		 return;
	 }
	 if(parseInt(f1) > parseInt(f2) || parseInt(f2) > parseInt(f3) || parseInt(f3) > parseInt(f4)){
		 $.messager.alert("提示", "请确认后重新输入阀值!");
		 return;
	 }
	 var params = {orgcode:orgcode, kssj:kssj, jssj:jssj, f1:f1, f2:f2, f3:f3, f4:f4};
	 $.post(contextPath + "/xlff/saveOption", params, function(d){
		if(d != false){
			XlMap.getSZ();
		}
	 },'json');
 }
 
 /**
  * 浮动设置层
  * @param json
  */	
XlMap.initFloatWin_back = function(json){
	//加载页面显示数据
	 XlMap.queryHTML = '<form id="queryForm">'
		 + '<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">'
		 + '<tr>'
		 + '<td width="30%" align="right">起止日期：</td>'
		 + '<td width="70%" align="center">'
		 + '<input type="text" name="kssj" id="kssj" class="easyui-validatebox"  style="width:85px" '
		 + 'onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyy-MM-dd\', maxDate:\'%y-%M-%d\'})" data-options="required:false,tipPosition:\'left\','
		 + 'validType:[\'date[\'yyyy-MM-dd\']\']" style="" />'
		 + '&nbsp;-&nbsp;'
		 + '<input type="text" name="jssj" id="jssj" class="easyui-validatebox"  style="width:85px" '
		 + 'onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyy-MM-dd\', maxDate:\'%y-%M-%d\'})" data-options="required:false,tipPosition:\'left\','
		 + 'validType:[\'date[\'yyyy-MM-dd\']\']" style="" />'
		 + '</td>'
		 + '</tr>'
		 + '<tr>'
		 + '<td width="30%" align="right">'
		 + '<span style="background-color: green; border:1px solid #17a9ff; height:5px;">&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;绿色 >='
		 + '</td>'
		 + '<td width="70%" colspan="3">'
		 + '<input type="text" name="f1" id ="f1" style="width:200px;" class="easyui-validatebox" data-options="required:false,validType:\'maxLength[20]\'"   />'
		 + '</span>'
		 + '</td>'
		 + '</tr>'
		 + '<tr>'
		 + '<td width="30%" align="right">'
		 + '<span style="background-color: yellow; border:1px solid #17a9ff; height:5px;">&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;黄色 >='
		 + '</td>'
		 + '<td width="70%" colspan="3">'
		 + '<input type="text" name="f2" id ="f2" style="width:200px;" class="easyui-validatebox" data-options="required:false,validType:\'maxLength[20]\'"   />'
		 + '</td>'
		 + '</tr>'
		 + '<tr>'
		 + '<td width="30%" align="right">'
		 + '<span style="background-color: orange; border:1px solid #17a9ff; height:5px;">&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;橙色 >='
		 + '</td>'
		 + '<td width="70%" colspan="3">'
		 + '<input type="text" name="f3" id ="f3" style="width:200px;" class="easyui-validatebox" data-options="required:false,validType:\'maxLength[20]\'"   />'
		 + '</td>'
		 + '</tr>'
		 + '<tr>'
		 + '<td width="20%" align="right">'
		 + '<span style="background-color: red; border:1px solid #17a9ff; height:5px;">&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;红色 >='
		 + '</td>'
		 + '<td width="70%" colspan="3">'
		 + '<input type="text" name="f4" id ="f4" style="width:200px;" class="easyui-validatebox" data-options="required:false,validType:\'maxLength[20]\'"   />'
		 + '</td>'
		 + '</tr>'
		 + '<tr>'
		 + '<td align="center" colspan="4">'
		 + '<input type="button" onclick="XlMap.setOption()" id="query" value="设置" style="background:#127EE2; color: white;"/>'
		 + ' &nbsp;&nbsp;'
		 + '<input type="reset" id="reset" value="重置" style="background:#127EE2; color: white;"/>' 
		 + '</td>'
		 + '</tr>'					
		 + '</table>'
		 + '</form>';
	 if(XlMap.floatWin!=""){
		 XlMap.floatWin.close();
	 }
	 var titleWin = userOrgName+" — 四色预警设置";
	 if(XlMap.zzjgmc != "" && undefined != XlMap.zzjgmc){
		 titleWin = XlMap.zzjgmc+" — 四色预警设置";
		 $jquery("#OrgZzjgmc").html(XlMap.zzjgmc);
	 } 
	 /*加载窗口*/
	 var left = $jquery("#mapDiv").width() - 320;
	 XlMap.floatWin = new FrameTools.FloatWin(titleWin,"mapDiv",320,260,85,left,85,null,220,0.9);
	 XlMap.floatWin.setOpHtml(XlMap.queryHTML);
	 XlMap.queryHTML = "";
};

//只清除marker
XlMap.clearMarkers = function(){
	if(cols != null){
		var markerLen = cols.length;
		for(var j=0; j<markerLen; j++){
			XlMap.map._MapApp.removeOverlay(cols[j]);
			XlMap.map._MapApp.removeOverlay(tils[j]);
		}
	}
};
