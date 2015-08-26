var markerArr = new Array();

if(typeof Jzjcxx == "undefined" || !Jzjcxx){
	var Jzjcxx = {};
};
Jzjcxx = function(){
	this.pk = Math.random();
};


Jzjcxx.tjOrgcode = "";//统计单位代码
Jzjcxx.tjOrgname = "";//统计单位名称
Jzjcxx.tjjb = "";//统计级别(sj,fj,pcs,zrq)
Jzjcxx.dataType = "";//数据列表类型

/**
 * @title:onloadMap
 * @description:初始化派出苏首页地图
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-22 17:54:32
 */
Jzjcxx.onloadMap = function(){
	/*地图对象*/
	Jzjcxx.map = new FrameTools.Map();
	/*设置地图代理*/
	Jzjcxx.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	Jzjcxx.map.setMapDiv("mapDiv");
	/*加载地图*/
	Jzjcxx.map.onloadMap();
	/*显示鹰眼*/
	Jzjcxx.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	Jzjcxx.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	Jzjcxx.map.showNewMapServer("mapDiv","Jzjcxx.map");
	/*加载地图工具条*/
	Jzjcxx.map.buildTools("mapDiv","toolDiv","Jzjcxx.map");
	/*设置工具条显示的位置*/
	Jzjcxx.diyToolDiv();
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){Jzjcxx.diyToolDiv();});
	if(bjzbz!="" && bjzbz!='null'){
		/*显示当前用户边界*/
		Jzjcxx.moveMapToBjzbz();
	}
};
/**
 * @title:diyToolDiv
 * @description:设置工具条显示的位置
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-10-22 17:55:43
 */	
Jzjcxx.diyToolDiv =function(){
	var left = $("#mapDiv").offset().left-230;
	var top = $("#mapDiv").height() - 40;
	$("#toolDiv").css({
		"top" : top,
		"left" : left
	});
};
/**
 * @title:moveMapToBjzbz
 * @description:显示当前用户边界
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-22 17:56:12
 */	
Jzjcxx.moveMapToBjzbz = function(){
	/*清楚地图上所有的标记*/
	Jzjcxx.map._MapApp.clear();
	/*非地坐标*/
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/*记录边线中心点坐标*/
	Jzjcxx.mbrArr = new Array();
	for(var j=0;j<bjnum;j++){
		var gArr = bj[j];
		/*创建边界图元素*/
		var polyline = Jzjcxx.map.initPolyline(gArr,"blue");
		/*图元素添加到地图上*/
		if(polyline){
			Jzjcxx.map._MapApp.addOverlay(polyline);
			Jzjcxx.mbrArr.push(polyline);
			if(Jzjcxx.Mbr==null){
				Jzjcxx.Mbr = polyline.getMBR();
			}else{
				Jzjcxx.Mbr = MBR.union(Jzjcxx.Mbr,polyline.getMBR());
			}
		}
	}
	/*根据图元素将地图放到最适合的级别和位置*/
	Jzjcxx.map._MapApp.centerAtMBR(Jzjcxx.Mbr);
};
/**
 * @title:initFloatWin
 * @description:辖区概况统计查询
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-23 14:17:48
 */	
Jzjcxx.queryJcxx = function(){
	var fsxjValue = $('#fsxj').combobox('getValue');
	var pcsValue = $('#pcs').combobox('getValue');
	if (pcsValue != "") {
		Jzjcxx.tjjb = "pcs";
		Jzjcxx.tjOrgcode = pcsValue;
		Jzjcxx.tjOrgname = $('#pcs').combobox('textbox').val();
	}
	else if (fsxjValue != "") {
		Jzjcxx.tjjb = "fj";
		Jzjcxx.tjOrgcode = fsxjValue;
		Jzjcxx.tjOrgname = $('#fsxj').combobox('textbox').val();
	}
	else {
		Jzjcxx.tjjb = "sj";
		Jzjcxx.tjOrgcode = sjOrgcode;
		Jzjcxx.tjOrgName = sjOrgname;
	}
	$('#orgZzjgmc').html(Jzjcxx.tjOrgname);
	var params = {tjjb:Jzjcxx.tjjb,tjOrgcode:Jzjcxx.tjOrgcode};
	var fajax =new FrameTools.Ajax(contextPath+"/jzjcxx/queryJcxx",Jzjcxx.queryJcxx_back);
	fajax.send(params);
};
/**
 * @title:queryJcxx_back
 * @description:辖区概况文字描述_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-23 16:30:23
 */	
Jzjcxx.queryJcxx_back = function(json){
	var czrkNum = 0,jzrkNum = 0,ldrkNum = 0,jwrkNum = 0,wlhrkNum = 0,zdrkNum = 0,jkdxNum = 0,jsbrNum = 0,fzcfNum = 0,qtgzdxNum = 0;
	var bzdzyhsNum = 0,bzdzwhsNum = 0,twNum = 0;
	var dwldNum = 0,dwwbNum=0,dwzsNum=0;
	var fwzsNum = 0,fwczfwNum=0,fwkzfNum=0,fwsyNum=0;
	var aqbnNum=0,aqbyNum=0,aqbzNum=0;
	var jqbnNum=0,jqbyNum=0,jqwpNum=0;
	var zdrkNum=0,zdflgNum=0;zdxdryNum=0;zdsfryNum=0;zdqtNum=0;
	if(json!=null&&json.length>0){
		 if(Jzjcxx.PcsTjJson == ""){
			 Jzjcxx.PcsTjJson = json;
		 }
		 for(var i=0;i<json.length;i++){
			 if(json[i].lxmc=="常住人员"){
				 czrkNum = json[i].sl;
			 }else if(json[i].lxmc=="寄住人员"){
				 jzrkNum = json[i].sl;
			 }else if(json[i].lxmc=="暂住人口"){
				 ldrkNum = json[i].sl;
			 }else if(json[i].lxmc=="境外人员"){
				 jwrkNum = json[i].sl;
			 }else if(json[i].lxmc=="未落户人员"){
				 wlhrkNum = json[i].sl;
			 }else if(json[i].lxmc=="重口"){
				 zdrkNum = json[i].sl;
			 }else if(json[i].lxmc=="监管对象"){
				 jkdxNum = json[i].sl;
			 }else if(json[i].lxmc=="精神病人"){
				 jsbrNum = json[i].sl;
			 }else if(json[i].lxmc=="非正常访"){
				 fzcfNum = json[i].sl;
			 }else if(json[i].lxmc=="其它工作对象"){
				 qtgzdxNum = json[i].sl;
			 }else if(json[i].lxmc=="已核实"){
				 bzdzyhsNum = json[i].sl;
			 }else if(json[i].lxmc=="未核实"){
				 bzdzwhsNum = json[i].sl;
			 }else if(json[i].lxmc=="天网"){
				 twNum = json[i].sl;
			 }else if(json[i].lxmc=="全部单位"){
				 dwzsNum = json[i].sl;
			 }else if(json[i].lxmc=="宾馆旅店"){
				 dwldNum = json[i].sl;
			 }else if(json[i].lxmc=="上网服务场所"){
				 dwwbNum = json[i].sl;
			 }else if(json[i].lxmc=="所有房屋"){
				 fwzsNum = json[i].sl;
			 }else if(json[i].lxmc=="出租房屋"){
				 fwczfwNum = json[i].sl;
			 }else if(json[i].lxmc=="有人居住房屋"){
				 fwsyNum = json[i].sl;
			 }else if(json[i].lxmc=="本周发生"){
				 aqbzNum = json[i].sl;
			 }else if(json[i].lxmc=="本月发生"){
				 aqbyNum = json[i].sl;
			 }else if(json[i].lxmc=="本年发生"){
				 aqbnNum = json[i].sl;
			 }else if(json[i].lxmc=="本年刑事案件发生"){
				 jqbnNum = json[i].sl;
			 }else if(json[i].lxmc=="本年未破刑事案件"){
				 jqwpNum = json[i].sl;
			 }else if(json[i].lxmc=="本月刑事案件发生"){
				 jqbyNum = json[i].sl;
			 }else if(json[i].lxmc=="重点人口总计"){
				 zdrkNum = json[i].sl;
			 }else if(json[i].lxmc=="法轮功"){
				 zdflgNum = json[i].sl;
			 }else if(json[i].lxmc=="吸毒人员"){
				 zdxdryNum = json[i].sl;
			 }else if(json[i].lxmc=="上访人员"){
				 zdsfryNum = json[i].sl;
			 }
		 }
	}
	var syrkNum = parseFloat(czrkNum)+parseFloat(jzrkNum)+parseFloat(ldrkNum)+parseFloat(jwrkNum)+parseFloat(wlhrkNum);
	var gzdxNum = parseFloat(zdrkNum)+parseFloat(jkdxNum)+parseFloat(jsbrNum)+parseFloat(fzcfNum)+parseFloat(qtgzdxNum);
	var bzdzNum = parseFloat(bzdzyhsNum)+parseFloat(bzdzwhsNum);
	var fwkzfNum = parseFloat(fwzsNum)-parseFloat(fwsyNum);
	zdqtNum = parseFloat(zdrkNum)-parseFloat(zdflgNum)-parseFloat(jkdxNum)-parseFloat(zdxdryNum)-parseFloat(zdsfryNum);
	//加载树状数字
	//实有人口
	if(syrkNum==0){
		$("#syrkNumId").html("（<span style='font-weight: bold;'>"+syrkNum+"</span>）"); 
	}else{
		$("#syrkNumId").html("（<span style='font-weight: bold;'>"+syrkNum+"</span>）"); 
	}
	if(czrkNum==0){
		$("#czrkNumId").html("（<span style='font-weight: bold;'>"+czrkNum+"</span>）"); 
	}else{
		$("#czrkNumId").html("（<span style='color: blue;font-weight: bold;' onclick='Jzjcxx.syrkListMBR(1, "+ czrkNum +")'>"+czrkNum+"</span>）"); 
	}
	if(jzrkNum==0){
		$("#jzrkNumId").html("（<span style='font-weight: bold;'>"+jzrkNum+"</span>）"); 
	}else{
		$("#jzrkNumId").html("（<span style='color: blue;font-weight: bold;' onclick='Jzjcxx.syrkListMBR(2, "+ jzrkNum +")'>"+jzrkNum+"</span>）"); 
	}
	if(ldrkNum==0){
		$("#ldrkNumId").html("（<span style='font-weight: bold;'>"+ldrkNum+"</span>）"); 
	}else{
		$("#ldrkNumId").html("（<span style='color: blue;font-weight: bold;' onclick='Jzjcxx.syrkListMBR(3, "+ ldrkNum +")'>"+ldrkNum+"</span>）"); 
	}
	if(jwrkNum==0){
		$("#jwrkNumId").html("（<span style='font-weight: bold;'>"+jwrkNum+"</span>）"); 
	}else{
		$("#jwrkNumId").html("（<span style='color: blue;font-weight: bold;' onclick='Jzjcxx.syrkListMBR(4, "+ jwrkNum +")'>"+jwrkNum+"</span>）"); 
	}
	if(wlhrkNum==0){
		$("#wlhrkNumId").html("（<span style='font-weight: bold;'>"+wlhrkNum+"</span>）"); 
	}else{
		$("#wlhrkNumId").html("（<span style='color: blue;font-weight: bold;' onclick='Jzjcxx.syrkListMBR(5, "+ wlhrkNum +")'>"+wlhrkNum+"</span>）"); 
	}
	//重点人员
	if(zdrkNum==0){
		$("#zdrkNumId").html("（<span style='font-weight: bold;'>"+zdrkNum+"</span>）");
	}else{
		$("#zdrkNumId").html("（<span style='font-weight: bold;'>"+zdrkNum+"</span>）"); 
	}
	if(zdflgNum==0){
		$("#flgNumId").html("（<span style='font-weight: bold;'>"+zdflgNum+"</span>）");
	}else{
		$("#flgNumId").html("（<span style='color: blue;font-weight: bold;' onclick='Jzjcxx.zdryListMBR(11, "+ zdflgNum +")'>"+zdflgNum+"</span>）"); 
	}
	if(jkdxNum==0){
		$("#jgdxNumId").html("（<span style='font-weight: bold;'>"+jkdxNum+"</span>）");
	}else{
		$("#jgdxNumId").html("（<span style='color: blue;font-weight: bold;' onclick='Jzjcxx.zdryListMBR(12, "+ jkdxNum +")'>"+jkdxNum+"</span>）"); 
	}
	if(zdxdryNum==0){
		$("#xdryNumId").html("（<span style='font-weight: bold;'>"+zdxdryNum+"</span>）");
	}else{
		$("#xdryNumId").html("（<span style='color: blue;font-weight: bold;' onclick='Jzjcxx.zdryListMBR(13, "+ zdxdryNum +")'>"+zdxdryNum+"</span>）"); 
	}
	if(zdsfryNum==0){
		$("#sfryNumId").html("（<span style='font-weight: bold;'>"+zdsfryNum+"</span>）");
	}else{
		$("#sfryNumId").html("（<span style='color: blue;font-weight: bold;' onclick='Jzjcxx.zdryListMBR(3, "+ zdsfryNum +")'>"+zdsfryNum+"</span>）"); 
	}
	if(zdqtNum==0){
		$("#qtgzdxNumId").html("（<span style='font-weight: bold;'>"+zdqtNum+"</span>）");
	}else{
		$("#qtgzdxNumId").html("（<span style='color: blue;font-weight: bold;' onclick='Jzjcxx.zdryListMBR(4, "+ zdqtNum +")'>"+zdqtNum+"</span>）"); 
	}
	//单位
	if(dwzsNum==0){
		$("#dwzsNumId").html("（<span style='font-weight: bold;'>"+dwzsNum+"</span>）"); 
	}else{
		$("#dwzsNumId").html("（<span style='color: blue;font-weight: bold;' onclick='Jzjcxx.sydwListMap()'>"+dwzsNum+"</span>）"); 
	}
	if(dwldNum==0){
		$("#dwldNumId").html("（<span style='font-weight: bold;'>"+dwldNum+"</span>）"); 
	}else{
		$("#dwldNumId").html("（<span style='color: blue;font-weight: bold;' onclick='Jzjcxx.sydwListMap(211)'>"+dwldNum+"</span>）"); 
	}
	if(dwwbNum==0){
		$("#dwwbNumId").html("（<span style='font-weight: bold;'>"+dwwbNum+"</span>）");
	}else{
		$("#dwwbNumId").html("（<span style='color: blue;font-weight: bold;' onclick='Jzjcxx.sydwListMap(350)'>"+dwwbNum+"</span>）");
	}
	//实有房屋
	if(fwzsNum==0){
		$("#fwzsNumId").html("（<span style='font-weight: bold;'>"+fwzsNum+"</span>）"); 
	}else{
		$("#fwzsNumId").html("（<span style='color: blue;font-weight: bold;' onclick='Jzjcxx.syfwListMap(1)'>"+fwzsNum+"</span>）"); 
	}
	if(fwczfwNum==0){
		$("#fwczfNumId").html("（<span style='font-weight: bold;'>"+fwczfwNum+"</span>）"); 
	}else{
		$("#fwczfNumId").html("（<span style='color: blue;font-weight: bold;' onclick='Jzjcxx.syfwListMap(2)'>"+fwczfwNum+"</span>）"); 
	}
	if(fwkzfNum==0){
		$("#fwkzfNumId").html("（<span style='font-weight: bold;'>"+fwkzfNum+"</span>）");
	}else{
		$("#fwkzfNumId").html("（<span style='color: blue;font-weight: bold;'>"+fwkzfNum+"</span>）");
	}
	//案情
	$("#aqbnNumId").html(aqbnNum); 
	$("#aqbyNumId").html(aqbyNum); 
	$("#aqbzNumId").html(aqbzNum);
	//警情
	$("#jqbzNumId").html(jqbnNum); 
	$("#jqbyNumId").html(jqbyNum); 
	$("#jqwpNumId").html(jqwpNum);
};

Jzjcxx.fsxj_onChange = function(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var parentOrgCode = $('#fsxj').combobox('getValue');
	if (parentOrgCode == "") {
		$('#pcs').combobox('loadData', []);
	}
	else {
		var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=32&parentOrgCode=' + parentOrgCode;    
	    $('#pcs').combobox('reload', url);
	}
}

Jzjcxx.syrkListMBR = function(lx, tjCount) {
	Jzjcxx.dataType = "syrk"; 
	$('#tjxxDiv').hide();
	$('#gridDiv').show();
	$('#dg').datagrid('loadData', []);
	var data = {}; 
	data['syrkgllbdm'] = "0" + lx;
	data['tjCount'] = tjCount;
	data['gxpcsdm'] = "";
	data['gxfxjdm'] = "";
	if (Jzjcxx.tjjb == "pcs") {
		data['gxpcsdm'] = Jzjcxx.tjOrgcode;
	}
	else if (Jzjcxx.tjjb == "fj") {
		data['gxfxjdm'] = Jzjcxx.tjOrgcode;
	}
	$("#dg").datagrid({    
		url: contextPath +'/jzjcxx/querySyrkList',
		queryParams: data,
	    columns:[[   
	        {field:"zjhm",title:"证件号码",width:12,align:'center',halign:'center'}, 
	        {field:"xm",title:"姓名",width:10,halign:'center'},
	        {field:"xb",title:"性别",width:8,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js'},
	        {field:"dz_jzdzxz",title:"居住地址",width:15,align:'left',halign:'center',formatter:subjzdz}
    	]]
	});
}

Jzjcxx.zdryListMBR = function(lx, tjCount) {
	Jzjcxx.dataType = "zdry"; 
	$('#tjxxDiv').hide();
	$('#gridDiv').show();
	$('#dg').datagrid('loadData', []);
	var data = {}; 
	data['syrkgllbdm'] = "0" + lx;
	data['tjCount'] = tjCount;
	data['gxpcsdm'] = "";
	data['gxfxjdm'] = "";
	if (Jzjcxx.tjjb == "pcs") {
		data['gxpcsdm'] = Jzjcxx.tjOrgcode;
	}
	else if (Jzjcxx.tjjb == "fj") {
		data['gxfxjdm'] = Jzjcxx.tjOrgcode;
	}
	$("#dg").datagrid({    
		url: contextPath +'/jzjcxx/queryZdryList',
		queryParams: data,
	    columns:[[   
	        {field:"gmsfhm",title:"身份证号码",width:12,align:'center',halign:'center'}, 
	        {field:"xm",title:"姓名",width:10,halign:'center'},
	        {field:"xbdm",title:"性别",width:8,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js'},
	        {field:"dz_jzdzxz",title:"居住地址",width:15,align:'left',halign:'center',formatter:subjzdz}
    	]]
	});
}

Jzjcxx.backJcxx = function() {
	$('#gridDiv').hide();
	$('#tjxxDiv').show();
}

//截地址字段
function subjzdz(val, row, index) {
	for (var i = 0; i < addressPrefixArray.length; i++) {
		val = val.replace(addressPrefixArray[i], "");
	}
	return val;
}

function datagridOnClickRow(rowIndex, rowData) {
	var dz = rowData['dz_jzdzxz'];
	var zbx = rowData['zbx'];
	var zby = rowData['zby'];
	var xm = rowData['xm'];
	//alert(dz + " zbx:" + zbx + " zby:" + zby + " | " + markerArr[rowIndex]);
	if (zbx != null && zbx != "" && zby != null && zby != "") {
		var marker = parent.frames["biz_center"].addMarker(xm, zbx, zby, "dz_zb02.png",null,null,25,25,false,rowData, 'jc');
		markerArr.push(marker);
		//if(typeof(markerArr[rowIndex])!="undefined" && markerArr[rowIndex]!="" && markerArr[rowIndex]!=null){
			if (IE) {
				parent.frames["biz_center"].XjMap.centerByPoint(marker,18,data, 'jc');
			}else{
				var obj = parent.frames.document.getElementById("biz_center").contentWindow;
				obj.XjMap.centerByPoint(markerArr[rowIndex], 19, data, 'jc');
			}
		//}
	} else {
		alert("此地址无坐标");
	}
}

//页面载入画点
function loadPoints(data) {
	clearPoints();
	//延迟加载统计
	beforeTableLoad(data,'dg');
	var mapWindow = null;
	if (IE) {
		mapWindow = parent.frames["biz_center"];
	}
	else {
		mapWindow = parent.frames.document.getElementById("biz_center").contentWindow;
	}
	if ("undefined" != typeof mapWindow && mapWindow != null) {
		if (mapWindow.XjMap) {
			mapPoint(mapWindow);
		}
		else {
			setTimeout(function() {mapPoint(mapWindow);}, 3000);
		}
	}
}

function mapPoint(mapWindow) {
	var obj = parent.frames.document.getElementById("biz_center").contentWindow;
	obj.XjMap.clearMarkers();
	if (mapWindow.XjMap) {
		//mapWindow.XjMap.clearMarkers();
		var rows = $('#dg').datagrid("getRows");
		var len = rows.length;
		for (var i = 0; i < len; i++) {
			var dz = rows[i].dz_jzdzxz;
			var xm = rows[i].xm; 
			if (rows[i].zbx != null && rows[i].zbx != "" && rows[i].zby != null && rows[i].zby != "") {
				var marker = null;
				//根据设置决定是否显示图层
				var img = "dz_zb02.png";
				if (IE) {
					marker = mapWindow.addMarker(xm, rows[i].zbx, rows[i].zby, img,null,null,25,25,false,rows[i], 'jc');
				}
				else {
					marker = mapWindow.addMarker(xm,rows[i].zddw_zxdhzb,rows[i].zddw_zxdzzb, img,null,null,25,25,false,rows[i], 'jc');
				}
				markerArr.push(marker);
			}
		}
	}
}

//清空已存在坐标点
function clearPoints(){
	var mapWindow = null;
	if (IE) {
		mapWindow = parent.frames["biz_center"];
	}
	else {
		mapWindow = parent.frames.document.getElementById("biz_center").contentWindow;
	}
	if ("undefined" != typeof mapWindow && mapWindow != null) {
		if(markerArr != null){
			var markerLen = markerArr.length;
			for(var j=0;j<markerLen;j++){
				mapWindow.XjMap.map._MapApp.removeOverlay(markerArr[j]);
			}
		}
	}
	//mapWindow.XjMap.map._MapApp.closeInfoWindow();
}

