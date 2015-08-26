<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
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
<title></title>

<script type="text/javascript">
  var markerArr = new Array();
</script>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" 
            	data-options="url:'<%=basePath %>ryjzdzzb/queryJzdzNoPt?flag=jsq',
            	delayCountUrl:'<%=basePath %>ryjzdzzb/queryCount?flag=jsq',
            	toolbar:'#datagridToolbar',
            		selectOnCheck:true,
            		checkOnSelect:true,
            		border:false,
            		sortName:'',
            		sortOrder:'desc',
            		pageSize:getAutoPageSize(270),
            		pageList:[getAutoPageSize(270),getAutoPageSize(270) * 2],
            		onLoadSuccess:function(data){ loadPoints(data);},
            		onSelect:onSelectRow,
            		singleSelect:true,
            		fitColumns:true,
            		toolbar:'#datagridToolbar' ">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				            <th data-options="field:'syrkgllbdm',width:70,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_RK_SYRKGLLB.js'">类别</th>
				            <th data-options="field:'zjhm',width:130,align:'left',sortable:true,halign:'center'">证件号码</th>
				            <th data-options="field:'xm',width:55,align:'left',sortable:true,halign:'center'">姓名</th>
				            <th  data-options="field:'dz_jzdzxz',width:200,align:'right',halign:'center',formatter:subjzdz,sortable:true">居住地址</th>
				            <th data-options="field:'zbx',hidden:true">zbx</th>
				            <th data-options="field:'zby',hidden:true">zby</th>
				            <th data-options="field:'process',width:55,align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<!--  -->
				<div id="datagridToolbar" style="padding:0px;height:auto">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
				<form id="queryForm" >
				<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">管辖市(县)局：</td>
						<td width="30%" class="dialogTd"><input type="text" name="gxsxj" id ="gxsxj" class="easyui-combobox" style="width:130px;"
							data-options="valueField:'id',textField:'text',url:'<%=basePath %>gzjk/queryOrg',onSelect:function(rec){
			            	var url = '<%=basePath %>gzjk/queryOrgLower?orgCode='+rec.id;$('#gxpcs').combobox('reload', url);}" />
			            </td>
						<td width="20%" class="dialogTd" align="right">管辖派出所：</td>
						<td width="30%" class="dialogTd">
							<input type="text" id="gxpcs" name="gxpcs" style="width:130px;" class="easyui-combobox"  data-options="valueField:'id',textField:'text',required:false"/>
						</td>
				</tr>
				<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">管辖行政区划：</td>
						<td width="80%" class="dialogTd" colspan="3">
							<input type="text" name="gxxzqh" id="gxxzqh" class="easyui-combobox" style="width:130px;" 
									             data-options="url: contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',dataFilter:'.*[^00]$',
							                                  method:'get',valueField:'id',textField:'text',selectOnNavigation:false"/>
						</td>
						</td>
				</tr>
				<tr class="dialogTr">
						<td width="10%" class="dialogTd" align="right">实有人口类别：</td>
				    	<td width="40%" class="dialogTd">
							<input class="easyui-combobox" type="text" id="syrkgllbdm" name="syrkgllbdm" style="width:130px;" 
								data-options="url: contextPath + '/common/dict/D_RK_SYRKGLLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						</td>
						<td width="10%" class="dialogTd" align="right">证件号码：</td>
				    	<td width="40%" class="dialogTd" ><input type="text" name="zjhm" id ="zjhm" style="width:130px;" 
				    			class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" /></td>
				</tr>
				<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">姓名：</td>
				    	<td width="30%" class="dialogTd"><input type="text" name="xm" id="xm" style="width:130px;" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"  /></td>
						<td width="20%" class="dialogTd" align="right">性别：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:130px;" 
							data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
				</tr>
				<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">民族：</td>
						<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="mzdm" name="mzdm" style="width:130px;" 
							data-options="url: contextPath + '/common/dict/D_BZ_MZ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
						<td width="20%" class="dialogTd" align="right">居住地：</td>
						<td width="30%" class="dialogTd"><input type="text" name="dz_jzdzxz" id ="dz_jzdzxz" style="width:130px;" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'"   /></td>
				</tr>
				
				<tr class="dialogTr">
					<td class="dialogTd" align="center" colspan="4">
							<a href="javascript:void(0)" class="easyui-linkbutton" 
								 iconCls="icon-search" onclick="queryButton()">查询</a>
								 &nbsp;&nbsp;
								 <a href="javascript:void(0)" class="easyui-linkbutton" 
								 	iconCls="icon-reset" onclick="resetButton()">重置</a>
								 
					</td>
				</tr>
				</form>
				</table>
				</div>
        </div>
    </div>   
    </div>
    <input type="hidden" id ="zbz" value="">
    <input type="hidden" id ="type" value="">
    <input type="hidden" id ="mapRadius" value="">
    
<script type="text/javascript">
function queryButton(){
	
	if (IE) {
		parent.frames["biz_center"].SyrkMap.clearGraph();
	}else{
		var obj = parent.frames.document.getElementById("biz_center").contentWindow;
		obj.SyrkMap.clearGraph();
	}
	
	var xm = document.getElementById("xm").value;
	xm= $.trim(xm);
	var zjhm = document.getElementById("zjhm").value;
	zjhm= $.trim(zjhm);
	var mzdm = document.getElementById("mzdm").value;
	var xbdm = document.getElementById("xbdm").value;
	var dz_jzdzxz = document.getElementById("dz_jzdzxz").value;
	
	var syrkgllbdm = document.getElementById("syrkgllbdm").value;
	
	// 新增查询条件 beign
	var gxsxj = $("#gxsxj").val(); //管辖市(县)局
	var gxsxjs = gxsxj=='210200000000' ? '' : gxsxj;
	var gxpcs =  $("#gxpcs").val(); //管辖派出所
	var gxxzqh =  $("#gxxzqh").val(); //管辖行政区划
	// 新增查询条件 end
	
	var reloadUrl  = contextPath + '/ryjzdzzb/queryJzdzNoPt?flag=jsq';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	$("#dg").datagrid(
			'load',
			{    
				'syrkgllbdm':syrkgllbdm,
				'xm': xm,   
				'zjhm': zjhm ,
				'mzdm':mzdm,
				'xbdm':xbdm,
				'dz_jzdzxz':dz_jzdzxz,
				'gxfxjdm': gxsxjs,
				'gxpcsdm': gxpcs,
				'gxzrqdm': gxxzqh
			});
}

function resetButton(){
	$("#queryForm").form("reset");
}

function onSelectRow(rowIndex, data){
	if(typeof(markerArr[rowIndex])!="undefined" && markerArr[rowIndex]!="" && markerArr[rowIndex]!=null){
		if (IE) {
			parent.frames["biz_center"].SyrkMap.centerByPoint(markerArr[rowIndex],18,data.dz_jzdzdm);
		}else{
			var obj = parent.frames.document.getElementById("biz_center").contentWindow;
			obj.SyrkMap.centerByPoint(markerArr[rowIndex],18,data.dz_jzdzdm);
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

//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="info(this,'+index+')">详情</a>&nbsp;&nbsp;';
}
//查看详情
function info(linkObject, index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/syrkgl/view?id="+rowData.ryid+"&jzdzdm="+rowData.dz_jzdzdm+"&mode=view";
	menu_open("实有人口－" + rowData.xm,editUrl);
}

//重新加载列表
function reloadGrid(){
	$('#dg').datagrid("clearSelections");
	var zbz = document.getElementById("zbz").value;
	var type = document.getElementById("type").value;
	var mapRadius = document.getElementById("mapRadius").value;
	var reloadUrl = contextPath + '/ryjzdzzb/queryJzdz';
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
		if (mapWindow.SyrkMap) {
			mapPoint(mapWindow);
		}
		else {
			setTimeout(function() {mapPoint(mapWindow);}, 3000);
		}
	}
}

function mapPoint(mapWindow) {
	if (mapWindow.SyrkMap) {
		mapWindow.SyrkMap.clearMarkers();
		var rows = $('#dg').datagrid("getRows");
		var len = rows.length;
		for (var i = 0; i < len; i++) {
			var dz = rows[i].dz_jzdzxz;
			if (dz != "" && rows[i].zbx != null && rows[i].zbx != "") {
				var marker = null;
				if (IE) {
					marker = mapWindow.addMarker(dz,rows[i].zbx,rows[i].zby,"location.png",null,null,34,34,false,rows[i].dz_jzdzdm,null);
				}
				else {
					marker = mapWindow.addMarker(dz,rows[i].zbx,rows[i].zby,"location.png",null,null,32,32,false,rows[i].dz_jzdzdm,null);
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
</body>
</html>