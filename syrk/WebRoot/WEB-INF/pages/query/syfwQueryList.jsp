<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
	<style type="text/css">
	.searchText {
	   font-size: 13px;
	   font-color: #222222;
	   height: 32px;
	   border: 1px solid #95B8E7;
	   line-height：32px;
	   padding-left: 5px;
	   padding-top: 8px;
	   width:200px;
	}
	.searchIcon {
		width:28px;
		height:28px;
   		background: url('<%=contextPath%>/images/search_icon.png') no-repeat center;
   		cursor: pointer;
	}
	
	</style>
<script type="text/javascript">
  var markerArr = new Array();
  var dz_fwdzidArr = new Array();
  var dwmcArr = new Array();
  var sfczfdm ='${sfczfdm}';
</script>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height: auto;">
            	<div id="datagridToolbar" style="padding:0px;height:auto">
				
				<form id="queryForm">
					<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
					
					
					
					        <tr class="dialogTr">
								<td width="20%" class="dialogTd" align="right">房屋类别：</td>
				    			<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="fwlbdm" name="fwlbdm" style="width:130px;"
										data-options="url: contextPath + '/common/dict/D_BZ_FWLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
			   				    <td width="20%" class="dialogTd" align="right">房屋用途：</td>
				    			<td width="30%" class="dialogTd">
										<input class="easyui-combobox" type="text" id="fwytdm" name="fwytdm" style="width:130px;"
											data-options="url: contextPath + '/common/dict/D_BZ_FWYTDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
								</td>
			   				</tr>
			   				
			   				
			   				
			   				<tr class="dialogTr">
				    			<td width="20%" class="dialogTd" align="right">房主姓名：</td>
				    			<td width="30%" class="dialogTd"><input type="text" name="fz_xm" id="fz_xm" style="width:130px;" class="easyui-validatebox"
				    	 			/></td>
								<td width="20%" class="dialogTd" align="right">托管人姓名：</td>
				    			<td width="30%" class="dialogTd"><input type="text" name="tgr_xm" id="tgr_xm" style="width:130px;" class="easyui-validatebox"   
				    	 			/></td>
			   				</tr>
			   				
			   				
							<tr class="dialogTr">
									<td width="20%" class="dialogTd" align="right">房屋地址：</td>
									<td width="30%" class="dialogTd" colspan="3"><input type="text" name="dz_fwdzxz" id="dz_fwdzxz" style="width:405px;" class="easyui-validatebox"  
				    	 			/></td>
							</tr>
							
							<tr class="dialogTr">
								<td class="dialogTd" align="center" colspan="4">
									<a href="javascript:void(0)" class="easyui-linkbutton" 
									 iconCls="icon-search" onclick="queryButton()">查询</a>
									 &nbsp;&nbsp;&nbsp;&nbsp;
									 <a href="javascript:void(0)" class="easyui-linkbutton" 
									 	iconCls="icon-reset" onclick="resetButton()">重置</a>
								</td>
							</tr>			   				
					</table>
				</form>
				</div>
            	<table id="dg" class="easyui-datagrid" 
            	data-options="url:'<%=basePath %>syfw/list?flag=jsq',
            	delayCountUrl:'<%=basePath %>syfwQuery/queryCountFw?flag=jsq', 
            	toolbar:'#datagridToolbar',
            		selectOnCheck:true,
            		checkOnSelect:true,
            		border:false,
            		sortName:'',
            		sortOrder:'desc',
            		idField:'id',
            		pageSize:getAutoPageSize(220),
            		pageList:[getAutoPageSize(220),
            		getAutoPageSize(220) * 2],
            		onLoadSuccess:function(data){ loadPoints(data);},
            		onSelect:onSelectRow,
            		fitColumns:true,
            		singleSelect:true ">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				            <th data-options="field:'fwlbdm',width:70,align:'left',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_FWLBDM.js'">房屋类别</th>
				            <th  data-options="field:'dz_fwdzxz',width:250,align:'right',halign:'center',formatter:subjzdz,sortable:true">房屋地址</th>
				            <th data-options="field:'fz_xm',width:120,align:'left',sortable:true,halign:'center'">房主</th>
				            <th data-options="field:'process',width:70,align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
				    </thead>
				</table>
        </div>
    </div>   
    </div>
    <input type="hidden" id ="zbz" value="">
    <input type="hidden" id ="type" value="">
    <input type="hidden" id ="mapRadius" value="">


</body>
<script type="text/javascript">
//查询按钮
function queryButton(){
	if (IE) {
		parent.frames["biz_center"].SyFwMap.clearGraph();
	}else{
		var obj = parent.frames.document.getElementById("biz_center").contentWindow;
		obj.SyFwMap.clearGraph();
	}
	var fwlbdm =$("#fwlbdm").val();
	var fwytdm =$("#fwytdm").val();
	var fz_xm =$("#fz_xm").val();
	var tgr_xm =$("#tgr_xm").val();
	var fwytdm =$("#fwytdm").val();
	var dz_fwdzxz =$("#dz_fwdzxz").val();
	$('#dg').datagrid(
			'load',
			{    
				'fwlbdm':fwlbdm,
				'fwytdm': fwytdm,   
				'fz_xm': fz_xm ,
				'tgr_xm':tgr_xm,
				'fwytdm': fwytdm,
				'dz_fwdzxz': dz_fwdzxz
			});
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}
///----------查询功能页方法--------------
//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	//if(row.sfcj!=null && row.sfcj!="" && typeof(row.sfcj)!=undefined){
	//	if(row.sfcj==0){
	//		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doCJ(this,'+index+')">采集</a>&nbsp;'+
	///		'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doChjgZx(this,'+index+')">层户</a>&nbsp;';
	//	}else if(row.sfcj==1){
	//		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">编辑</a>&nbsp;'+
	//		'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doChjgZx(this,'+index+')">层户</a>&nbsp;';
	//	}
	//}
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="inFo(this,'+index+')">详情</a>&nbsp;&nbsp;&nbsp;';
}

function inFo(linkObject, index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/syfw/"+rowData.id+"/main?mode=view";
	menu_open("实有房屋信息",editUrl);
}
/**
 * @title:doChjgZx
 * @description:层户结构展现
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-08-07 14:02:35
 */
function doChjgZx(linkObject, index){
     //阻止冒泡，不然要执行onClickRow
     cancelBubble(); 
     var rows = $('#dg').datagrid('getData');
	 var rowData = rows.rows[index];
     if(rowData.bzdzid!=null&&rowData.bzdzid!=""){
	     var hsUrl = "/forward/sqjw|building|buildingShow?bzdzid="+rowData.bzdzid+"&bs=3";
	     menu_open("层户结构",hsUrl);
     }else{
        topMessager.show({
			title: MESSAGER_TITLE,
			msg: '暂无层户结构信息！',
			timeout:2000
		});
     }
};
//修改单条
function doEdit(linkObject, index) {
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/syfw/view?id="+rowData.id;
	menu_open(" 实有房屋编辑",editUrl);
}

var chAddress = "<%=SystemConfig.getString("chAddress")%>";
//打开层户
function doCH(linkObject, index) {
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var url = chAddress + "/chjg/service.do?view=house&jzwdm="+rowData.jzwid;
	window.open(url,"层户结构","");
}
//---------------框查-----

function onSelectRow(rowIndex, data){
	if(typeof(markerArr[rowIndex])!="undefined" && markerArr[rowIndex]!="" && markerArr[rowIndex]!=null){
		if (IE) {
			parent.frames["biz_center"].SyFwMap.centerByPoint(markerArr[rowIndex],19,data.dz_jzdzdm);
		}else{
			var obj = parent.frames.document.getElementById("biz_center").contentWindow;
			obj.SyFwMap.centerByPoint(markerArr[rowIndex],19,data.dz_jzdzdm);
		}
	}else{
		//alert("人员无坐标");
	}
	
}
var addressPrefix = "<%=SystemConfig.getString("addressPrefix")%>";
var addressPrefixArray = addressPrefix.split(",");

//截地址字段
function subjzdz(val, row, index){
	
	for (var i = 0; i < addressPrefixArray.length; i++) {
		val = val.replace(addressPrefixArray[i], "");
	}
	return val;
}
//重新加载列表
function reloadGrid(){
	$('#dg').datagrid("clearSelections");
	var zbz = document.getElementById("zbz").value;
	var type = document.getElementById("type").value;
	var mapRadius = document.getElementById("mapRadius").value;
	var reloadUrl = contextPath + '/syfwQuery/queryFwOnPt';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	$('#dg').datagrid(
			'load',
			{    
				'zbz': zbz,   
				'type': type ,
				'mapRadius':mapRadius
			});
}


//页面载入画点
function loadPoints(data) {
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
		if (mapWindow.SyFwMap) {
			mapPoint(mapWindow);
		}
		else {
			setTimeout(function() {mapPoint(mapWindow);}, 3000);
		}
	}
}

function mapPoint(mapWindow) {
	if (mapWindow.SyFwMap) {
		mapWindow.SyFwMap.clearMarkers();
		var rows = $('#dg').datagrid("getRows");
		var len = rows.length;
		for (var i = 0; i < len; i++) {
			var dz = rows[i].fwmc;
			if (dz != "" && rows[i].zbx != null && rows[i].zbx != "") {
				var marker = null;
				if (IE) {
					marker = mapWindow.addMarker(dz,rows[i].zbx,rows[i].zby,"location.png",null,null,34,34,false,rows[i].dz_fwdzid,null);
				}
				else {
					marker = mapWindow.addMarker(dz,rows[i].zbx,rows[i].zby,"location.png",null,null,32,32,false,rows[i].dz_fwdzid,null);
				}
				markerArr[i] = marker;
			}
		}
	}
}

//重置加载
function loadGrid(){
	$('#dg').datagrid('load',{zbz:null,type:null,mapRadius:null,rows:21});  
	$('#dg').datagrid("clearSelections");
}
</script>  

</html>