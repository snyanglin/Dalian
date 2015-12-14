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
</script>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" 
            	data-options="url:'<%=basePath %>zdryjbxxb/queryZdryjbxxNoPt?flag=jsq',
            	delayCountUrl:'<%=basePath %>zdryjbxxb/queryCountZdry?flag=jsq',
            	toolbar:'#datagridToolbar',
            		singleSelect:false,
            		selectOnCheck:true,
            		checkOnSelect:true,
            		border:false,
            		sortName:'',
            		sortOrder:'desc',
            		idField:'id',
            		pageSize:getAutoPageSize(270),
            		pageList:[getAutoPageSize(270),getAutoPageSize(270) * 2],
            		onSelect:onSelectRow,
            		onLoadSuccess:function(data){ loadPoints(data);},
            		fitColumns:true,
            		singleSelect:true">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				            <th data-options="field:'zdrylxdm',width:60,align:'left',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_RK_ZDRYLX.js'">类型</th>
				            <th data-options="field:'gmsfhm',width:130,align:'center',sortable:true,halign:'center'">身份证号码</th>
				            <th data-options="field:'xm',width:80,align:'left',sortable:true,halign:'center'">姓名</th>
				            <th  data-options="field:'dz_jzdzxz',width:200,align:'right',halign:'center',sortable:true,formatter:subjzdz">居住地址</th>
				            <th data-options="field:'zbx',hidden:true">zbx</th>
				            <th data-options="field:'zby',hidden:true">zby</th>
				            <th data-options="field:'process',width:60,align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:0px;height:auto">
				<form id="queryForm">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
						<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">管辖市(县)局：</td>
						<td width="30%" class="dialogTd"><input type="text" name="gxsxj" id ="gxsxj" class="easyui-combobox" style="width:130px;"
							data-options="valueField:'id',textField:'text',url:'<%=basePath %>gzjk/queryOrg',onSelect:function(rec){
			            	var url = '<%=basePath %>gzjk/queryOrgLower?orgCode='+rec.id;$('#gxpcs').combobox('reload', url);}" />
			            </td>
						<td width="20%" class="dialogTd" align="right">管辖派出所：</td>
						<td width="30%" class="dialogTd">
							<input type="text" id="gxpcs" name="gxpcs" class="easyui-combobox" style="width:130px;" data-options="valueField:'id',textField:'text',required:false"/>
						</td>
						</tr>
						<tr class="dialogTr">
								<td width="20%" class="dialogTd" align="right">管辖行政区划：</td>
								<td width="80%" class="dialogTd" colspan="3">
									<input type="text" name="gxxzqh" id="gxxzqh" class="easyui-combobox" style="width:130px;" 
											             data-options="url: contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',dataFilter:'.*[^00]$',
									                                  method:'get',valueField:'id',textField:'text',selectOnNavigation:false" />
								</td>
								</td>
						</tr>
						<tr class="dialogTr">
						    	<td width="20%" class="dialogTd" align="right">实有人口类别：</td>
						    	<td width="30%" class="dialogTd">
									<input class="easyui-combobox" type="text" id="syrkgllbdm" name="syrkgllbdm" style="width:130px;" 
										data-options="url: contextPath + '/common/dict/D_RK_SYRKGLLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
									</td>
							    <td width="20%" class="dialogTd" align="right">姓名：</td>
						    	<td width="30%" class="dialogTd"><input type="text" name="xm" id ="xm" style="width:130px;" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"   /></td>
									
					   	</tr>	
				        <tr class="dialogTr">
						    	<td width="20%" class="dialogTd" align="right">重点人员类型：</td>
						    	<td width="30%" class="dialogTd">
									<input class="easyui-combobox" type="text" id="zdrylxdm" name="zdrylxdm" style="width:130px;" 
									data-options="url: contextPath + '/common/dict/D_RK_ZDRYLX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
									</td>
						    	<td width="20%" class="dialogTd" align="right">身份证号码：</td>
						    	<td width="30%" class="dialogTd"><input type="text" id="gmsfhm" name="gmsfhm" style="width:130px;" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'"  /></td>					   
					    </tr>				
					    <tr class="dialogTr">
						    	<td width="20%" class="dialogTd" align="right">民族：</td>
						    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="mzdm" name="mzdm" style="width:130px;"
									data-options="url: contextPath + '/common/dict/D_BZ_MZ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
						    	<td width="20%" class="dialogTd" align="right">居住地址：</td>
						    	<td width="30%" class="dialogTd"><input type="text" name="dz_jzdzxz" id ="dz_jzdzxz" style="width:130px;" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'"  /></td>					   
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
				</table>
				</form>
				</div>
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
		parent.frames["biz_center"].ZdrkMap.clearGraph();
	}else{
		var obj = parent.frames.document.getElementById("biz_center").contentWindow;
		obj.ZdrkMap.clearGraph();
	}
	
	var xm = document.getElementById("xm").value;
	var gmsfhm = document.getElementById("gmsfhm").value;
	var syrkgllbdm = document.getElementById("syrkgllbdm").value;
	var dz_jzdzxz = document.getElementById("dz_jzdzxz").value;
	var zdrylxdm = document.getElementById("zdrylxdm").value;
	
	// 新增查询条件 beign
	var gxsxj = $("#gxsxj").val(); //管辖市(县)局
	var gxsxjs = gxsxj=='210200000000' ? '' : gxsxj;
	var gxpcs =  $("#gxpcs").val(); //管辖派出所
	var gxxzqh =  $("#gxxzqh").val(); //管辖行政区划
	// 新增查询条件 end
	
	xm= $.trim(xm);
	gmsfhm= $.trim(gmsfhm);
	dz_jzdzxz= $.trim(dz_jzdzxz);
	$('#dg').datagrid(
			'load',
			{    
				'zdrylxdm':zdrylxdm,
				'syrkgllbdm':syrkgllbdm,
				'xm': xm,   
				'gmsfhm': gmsfhm ,
				'dz_jzdzxz':dz_jzdzxz,
				'gxfxjdm': gxsxjs,
				'gxpcsdm': gxpcs,
				'gxzrqdm': gxxzqh
			});
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}

function onSelectRow(rowIndex, data){
	if(typeof(markerArr[rowIndex])!="undefined" && markerArr[rowIndex]!="" && markerArr[rowIndex]!=null){
		if (IE) {
			parent.frames["biz_center"].ZdrkMap.centerByPoint(markerArr[rowIndex],19,data.jzdzdm);
		}else{
			var obj = parent.frames.document.getElementById("biz_center").contentWindow;
			obj.ZdrkMap.centerByPoint(markerArr[rowIndex],19,data.jzdzdm);
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
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="info(this,'+index+')">详情</a>&nbsp;&nbsp;';
}
// 修改单条
function info(linkObject, index) {
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/syrkgl/view?id="+rowData.ryid+"&jzdzdm="+rowData.dz_jzdzdm+"&zdryid="+rowData.id+"&mode=view";
	menu_open("重点人口－" + rowData.xm,editUrl);
}

//重新加载列表
function reloadGrid(){
	$('#dg').datagrid("clearSelections");
	var zbz = document.getElementById("zbz").value;
	var type = document.getElementById("type").value;
	var mapRadius = document.getElementById("mapRadius").value;
	var reloadUrl = contextPath + '/zdryjbxxb/queryZdryjbxx';
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
		if (mapWindow.ZdrkMap) {
			mapPoint(mapWindow);
		}
		else {
			setTimeout(function() {mapPoint(mapWindow);}, 3000);
		}
	}
}

function mapPoint(mapWindow) {
	if (mapWindow.ZdrkMap) {
		mapWindow.ZdrkMap.clearMarkers();
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

</html>