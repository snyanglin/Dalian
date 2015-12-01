
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
	.imgStyle{
		height:19px;
		width:19px;
	}
	</style>
<script type="text/javascript">
  var markerArr = new Array();
  var dz_dwdzdmArr = new Array();
  var dwmcArr = new Array();
</script>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" 
            	data-options="url:'<%=basePath %>sydwcx_dl/queryDw?flag=jsq',
            	delayCountUrl:'<%=basePath %>sydwcx_dl/queryCountDw?flag=jsq',
            	toolbar:'#datagridToolbar',
            		idField:'id',
            		sortOrder:'desc',
            		sortName:'',
            		selectOnCheck:true,
            		checkOnSelect:true,
            		border:false,
            		fitColumns:true,
            		pageSize:getAutoPageSize(230),
            		pageList:[getAutoPageSize(230),getAutoPageSize(230) * 2],
            		onSelect:onSelectRow,
            		onLoadSuccess:function(data){ loadpoints1(data);},
            		fitColumns:true,
            		singleSelect:true">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				            <th data-options="field:'jgjbdm',	width:50,align:'left',halign:'center',formatter:jgjbdm"></th>
				            <th data-options="field:'dwlbdm',	width:70,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_DW_DWLB.js',sortable:true">类别</th>
				            <th data-options="field:'dwmc',		width:120,align:'left',halign:'center',sortable:true">单位名称</th>
				            <th data-options="field:'dz_dwdzxz',	width:200,align:'right',halign:'center',formatter:subjzdz,sortable:true">单位地址</th>
				            <th data-options="field:'process',width:70,align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:0px;height:auto">
						<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
							<form id="queryForm"> 
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
									<td width="20%" class="dialogTd" align="right">单位类型：</td>
						    		<td width="30%" class="dialogTd">
										<input class="easyui-combobox" type="text" id="dwlbdm" name="dwlbdm" style="width:130px;"
										data-options="url: contextPath + '/common/dict/D_DW_DWLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
									</td>
						    	<td width="20%" class="dialogTd" align="right">单位名称：</td>
						    	<td width="30%" class="dialogTd">
									<input  type="text" id="dwmc" name="dwmc" style="width:130px;"
									class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"	/>
									</td>
					   		</tr>	
				        <tr class="dialogTr">
						    	<td width="20%" class="dialogTd" align="right">单位地址：</td>
						    	<td width="30%" class="dialogTd">
						    	<input type="text" id="dz_dwdzxz" name="dz_dwdzxz" style="width:130px;" class="easyui-validatebox" 
						    		data-options="required:false,validType:'maxLength[30]'"  />
						    		
						    		</td>					    
					    </tr>							
					   <tr class="dialogTr">
						    	<td width="20%" class="dialogTd" align="right">经营范围(主营)：</td>
						    	<td width="30%" class="dialogTd"><input type="text" id="jyfwzy" name="jyfwzy"  style="width:130px;"
						    	class="easyui-validatebox" 
						    	data-options="required:false,validType:'maxLength[30]'"/>
						    	
						    	<td width="20%" class="dialogTd" align="right">经济类型：</td>
						    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jyxzdm" name="jyxzdm" style="width:130px;"
									data-options="url: contextPath + '/common/dict/D_BZ_JYXZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
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

</body>
<script type="text/javascript">
///----------查询功能页方法--------------
//查询按钮
function queryButton(){
	if (IE) {
		parent.frames["biz_center"].SydwMap.clearGraph();
	}else{
		var obj = parent.frames.document.getElementById("biz_center").contentWindow;
		obj.SydwMap.clearGraph();
	}
	var dwlbdm = document.getElementById("dwlbdm").value;
	var dwmc = document.getElementById("dwmc").value;
	var dz_dwdzxz = document.getElementById("dz_dwdzxz").value;
	var jyfwzy = document.getElementById("jyfwzy").value;
	var jyxzdm = document.getElementById("jyxzdm").value;
	
	dwmc= $.trim(dwmc);
	dz_dwdzxz= $.trim(dz_dwdzxz);
	// 新增查询条件 beign
	var gxsxj = $("#gxsxj").val(); //管辖市(县)局
	var gxpcs =  $("#gxpcs").val(); //管辖派出所
	//var gxxzqh =  $("#gxxzqh").val(); //管辖行政区划
	var gxsxjs = gxsxj=='210200000000' ? '' : gxsxj;
	// 新增查询条件 end
	var reloadUrl = contextPath + '/sydwcx_dl/queryDw?flag=jsq';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	
	$('#dg').datagrid(
			'load',
			{    
				'dwlbdm':dwlbdm,
				'dwmc':dwmc,
				'dz_dwdzxz':dz_dwdzxz,
				'jyfwzy':jyfwzy,
				'jjlxdm':jyxzdm,
				'glfxjid': gxsxjs,
				'glpcsid': gxpcs
				//'gxzrqdm': gxxzqh
			});
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}
//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="inFo(this,'+index+')">详情</a>&nbsp;&nbsp;&nbsp;';
}
function inFo(linkObject, index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/sydwgl_dl/view?id="+rowData.id+"&mode=view";
	menu_open("实有单位信息--"+rowData.dwmc,editUrl);
}
//----精确查询框方法---------
//1关注：绿；2重点关注：红；3重点管理：黄
function jgjbdm(value,row,index){
	if(value==1){
		return '<img src= '+contextPath+'/images/lamp_green.png class=imgStyle title=关注		/>';
	}else if(value==2){
		return '<img src= '+contextPath+'/images/lamp_red.png class=imgStyle title=重点关注			/>';
	}else if(value==3){
		return '<img src= '+contextPath+'/images/lamp.png class=imgStyle title=重点管理		/>';
	}
	return "";
}

function onSelectRow(rowIndex, data){
	if(typeof(markerArr[data.dz_dwdzdm])!="undefined" && markerArr[data.dz_dwdzdm]!="" && markerArr[data.dz_dwdzdm]!=null){
		if(IE){
			parent.frames["biz_center"].SydwMap.centerByPoint(markerArr[data.dz_dwdzdm],19,dz_dwdzdmArr[data.dz_dwdzdm]);
		}else{
			var obj = parent.frames.document.getElementById("biz_center").contentWindow;
			obj.SydwMap.centerByPoint(markerArr[data.dz_dwdzdm],19,dz_dwdzdmArr[data.dz_dwdzdm]);
		}
			
	}else{
		//alert("人员无坐标");
	}
}

//---------------框查-----
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
	
	
	var reloadUrl = contextPath + '/sydwcx_dl/queryDwDzOnPT';
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

//重置加载
function loadGrid(){
	$('#dg').datagrid('load',{zbz:null,type:null,mapRadius:null,rows:21});  
	$('#dg').datagrid("clearSelections");
}

function loadpoints1(data) { //页面载入画点
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
		if (mapWindow.SydwMap) {
			mapPoint(mapWindow);
		}
		else {
			setTimeout(function() {mapPoint(mapWindow);}, 3000);
		}
	}
}

function mapPoint(mapWindow) {
	if (mapWindow.SydwMap) {
		mapWindow.SydwMap.clearMarkers();
		var rows = $('#dg').datagrid("getRows");
		var len = rows.length;
		var dwidsArray = [];
		for (var i = 0; i < len; i++) {
			dwidsArray.push("'" + rows[i].id + "'");
			if (rows[i].dz_dwdzdm != "undefined" && rows[i].dz_dwdzdm != "") {
				dwmcArr[rows[i].dz_dwdzdm] = rows[i].dwmc;
				dz_dwdzdmArr[rows[i].dz_dwdzdm] = rows[i].dz_dwdzdm;
			}
		}
		if (len > 0) {
			$.ajax({
				type:"GET",
				sync:true,
				url:contextPath+"/sydwcx_dl/queryZbByDzId",
				data:{dwids:dwidsArray.join(",")},
				dataType:'json',
				success:function(json){
					var len = json.length;
					for (var i = 0; i < len; i++) {
						if (dwmcArr[json[i].dz_dwdzdm] != "" && json[i].zbx!=null && json[i].zbx!="") {
							var marker = null;
							if (IE) {
								marker = mapWindow.addMarker(dwmcArr[json[i].dz_dwdzdm],json[i].zbx,json[i].zby,"location.png",null,null,34,34,false,json[i].dz_dwdzdm,null);
							} else{
								marker = mapWindow.addMarker(dwmcArr[json[i].dz_dwdzdm],json[i].zbx,json[i].zby,"location.png",null,null,34,34,false,json[i].dz_dwdzdm,null);
							}
							markerArr[json[i].dz_dwdzdm] = marker;
							dz_dwdzdmArr[json[i].dz_dwdzdm] = json[i].dz_dwdzdm;
						}
					}
				}
			});
		}
	}
}

</script>  

</html>