<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@CreateDate:   [2015-6-8 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
</head>
<body class="easyui-layout" data-options="fit:true">  
   <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto;overflow:hidden;">
            	<table id="dg" class="easyui-datagrid" 
            		data-options="url:'<%=basePath %>sydw/list',
            		selectOnCheck:true,
            		checkOnSelect:true,
            		border:false,
            		sortName:'',
            		sortOrder:'desc',
            		idField:'id',
            		pageSize:getAutoPageSize(120),
            		pageList:[getAutoPageSize(120),
            		getAutoPageSize(120) * 2],
            		onLoadSuccess:function(data){ loadpoints1(data);},
            		onSelect:onSelectRow,
            		singleSelect:true,
            		fitColumns:true,
            		rownumbers:true,
            		toolbar:'#datagridToolbar'">
				    <thead>
				        <tr>
				            <th data-options="field:'dwlbdm',	width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_DWLXDM.js',sortable:true">类别</th>
				            <th data-options="field:'dwmc',		width:120,align:'left',halign:'center',sortable:true">单位名称</th>
				            <th data-options="field:'dz_dwdzxz',	width:200,align:'right',halign:'center',formatter:subjzdz,sortable:true">单位地址</th>
				            <th data-options="field:'process',width:100,align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto">
					<table border="0" cellpadding="0" cellspacing="2" width="100%"	align="center">
						<tr>
							<td align="left" width="40%">
								<input type="text" class="searchText" name="condition"  id="condition" value="请输入单位名称、地址信息" 
										style="color:gray;height:32px;font-size:13px;width:240px"  onclick="setDzqc(this)" onkeydown="passwordOnkeyPress(this)" />
							</td>
							<td align="left" width="15%">
								<img src ="<%=contextPath%>/images/search_btn_sousuo_01.png" style="cursor: pointer;height:32px;margin-top: 4px;" onclick="searchMain();"/>
							</td>
							<td width="45%">
								<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-search" onclick="detailSearch()">精确查询</a>
							</td>
						</tr>
						<tr>
							<td align="left" width="100%" colspan="3">
								<a href="javascript:void(0)" class="easyui-linkbutton"   onclick="doAllCheck();">所有检查列表</a>&nbsp;
								<a href="javascript:void(0)" class="easyui-linkbutton"   onclick="doAllPunish();">所有处罚列表</a>
							</td>
						</tr>
					</table>
				</div>
			</div>
        </div>
    </div>   
    <!-- 精确查询框 -->
    <div id="win" class="easyui-window" title="实有单位精确查询" style="width:400px;height:350px;top:20px;display:none;"   
        data-options="iconCls:'icon-search',collapsible:false,minimizable:false,maximizable:false,modal:true,closed:true,top:100,width:400,height:280,left:50">   
	    <div class="easyui-layout" data-options="fit:true">   
	        <div data-options="region:'left'">  
		       <form id ="queryForm" >
			        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
				       <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">单位类型：</td>
					    	<td width="70%" class="dialogTd">
								<input class="easyui-combotree" type="text" id="dwlbdm" name="dwlbdm"
								 style="width:150px;" data-options="url: contextPath + '/common/dict/BD_D_DWLXDM.js',onlyLeaf:true,multiple:false,panelWidth:250,panelHeight:210,
									method:'get',editable:true,lines:true"/>
							</td>
					   </tr>					      
				       <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">单位名称：</td>
					    	<td width="70%" class="dialogTd"><!-- data-options="url: contextPath + '/common/dict/D_RK_ZDRYLX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" -->
								<input  type="text" id="dwmc" name="dwmc" style="width:150px;"
									class="easyui-validatebox"  data-options="required:false,validType:'maxLength[20]'"/>
							 </td>
					   	</tr>	
					    <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">单位地址：</td>
					    	<td width="70%" class="dialogTd">
					    		<input type="text" id="dz_dwdzxz" name="dz_dwdzxz" class="easyui-validatebox" 
					    			data-options="required:false,validType:'maxLength[30]'"  style="width:150px;" />
					    	</td>
					   </tr>	
					   <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">经营范围(主营)：</td>
					    	<!-- data-options="url: contextPath + '/common/dict/D_BZ_MZ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" -->
					    	<td width="70%" class="dialogTd">
					    		<input type="text" id="jyfwzy" name="jyfwzy" style="width:150px;" class="easyui-validatebox" 
					    			data-options="required:false,validType:'maxLength[30]'"/>
					    	</td>
					    </tr>
					    <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">经营性质：</td>
					    	<td width="70%" class="dialogTd">
					    		<input class="easyui-combobox" type="text" id="jyxzdm" name="jyxzdm" style="width:150px;"
									data-options="url: contextPath + '/common/dict/D_BZ_JYXZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
							</td>
					    </tr>
					    <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">单位地址状态：</td>
					    	<td width="70%" class="dialogTd">
						    	<input type='checkbox' id='ybzdz'/>有标准地址 
						    	<input type='checkbox' id='wbzdz'/>无标准地址
					    	</td>
					    </tr>
					    <tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td width="100%" colspan="2" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="queryButton();">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow();">关闭</a>
					    	</td>
					    </tr>
			         </table>
			      </form>
	        </div>   
	   </div>   
</div>  
</body>
<script type="text/javascript">
var markerArr = new Array();
var dz_dwdzdmArr = new Array();
///----------查询功能页方法--------------
//精确查询
function closeWindow(){
	$("#win").window("close"); 
}

function detailSearch(){
	$("#win").show();
	$("#win").window("open"); 
}
//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	return '<a class="link" href="javascript:javascript:void(0)" onclick="doView(this,'+index+')">详情</a>&nbsp;'+
		   '<a class="link" href="javascript:javascript:void(0)" onclick="doCheck('+index+',\''+row.dwmc+'\',\''+row.dwlbdm+'\')">检查</a>&nbsp;'+
		   '<a class="link" href="javascript:javascript:void(0)" onclick="doPunish('+index+',\''+row.dwmc+'\',\''+row.dwlbdm+'\');">处罚</a>';
}
// 修改单条
function doView(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/sydwgl/view?id="+rowData.id+"&mode=partview";
	menu_open("实有单位详情",editUrl);
}

//检查管理窗口
function doCheck(index,dwmc,dwlbdm){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/forward/sydw|rcjcMain?dwid="+rowData.id+"&dwmc="+encodeURI(dwmc)+"&dwlbdm="+dwlbdm;
	menu_open("日常检查管理",editUrl);
}

//所有检查管理窗口
function doAllCheck(){
	var editUrl = "/forward/sydw|rcjcMain";
	menu_open("日常检查管理",editUrl);
}

//处罚管理窗口
function doPunish(index,dwmc,dwlbdm){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/forward/sydw|punishMain?dwid="+rowData.id+"&dwmc="+encodeURI(dwmc)+"&dwlbdm="+dwlbdm;
	menu_open("单位处罚管理",editUrl);
}

//所有处罚管理窗口
function doAllPunish(){
	var editUrl = "/forward/sydw|punishMain";
	menu_open("单位处罚管理",editUrl);
}
//按下enter
function passwordOnkeyPress(obj) {
	obj.style.color = "black";
	var keycode = event.keyCode;
	if (keycode == 13) {
		searchMain();
	}
}
//按下enter,清空
function setDzqc(obj){
	obj.value="";
}

//搜索功能
function searchMain(){
	if (IE) {
		parent.frames["biz_center"].SydwMap.clearGraph();
	}else{
		var obj = parent.frames.document.getElementById("biz_center").contentWindow;
		obj.SydwMap.clearGraph();
	}
	var condition = document.getElementById("condition").value;
	if(condition=="请输入单位名称、地址信息"){
		condition="";
	}
	var reloadUrl = contextPath + '/sydwcx/queryDw';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	
	condition= $.trim(condition);
	$('#dg').datagrid('load',{condition:condition});
	$('#dg').datagrid("clearSelections");
}
//----精确查询框方法---------
//单击行地图定位
function onSelectRow(rowIndex, data){
	if(typeof(markerArr[data.dz_dwdzmlpdm])!="undefined" && markerArr[data.dz_dwdzmlpdm]!="" && markerArr[data.dz_dwdzmlpdm]!=null){
		if(IE){
			parent.frames["biz_center"].SydwMap.centerByPoint(markerArr[data.dz_dwdzmlpdm],19,dz_dwdzdmArr[data.dz_dwdzmlpdm]);
		}else{
			var obj = parent.frames.document.getElementById("biz_center").contentWindow;
			obj.SydwMap.centerByPoint(markerArr[data.dz_dwdzmlpdm],19,dz_dwdzdmArr[data.dz_dwdzmlpdm]);
		}
	}else{
		alert("单位地址无坐标");
	}
}
//查询按钮
function queryButton(){
	var dwlbdm = document.getElementById("dwlbdm").value;
	var dwmc = document.getElementById("dwmc").value;
	var dz_dwdzxz = document.getElementById("dz_dwdzxz").value;
	var jyfwzy = document.getElementById("jyfwzy").value;
	var jyxzdm = document.getElementById("jyxzdm").value;
	dwmc= $.trim(dwmc);
	dz_dwdzxz= $.trim(dz_dwdzxz);
	var reloadUrl = contextPath + '/sydw/list';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	var dwdzzt = "0";
	var ybzdz = document.getElementById("ybzdz");
	var wbzdz = document.getElementById("wbzdz");
	if(ybzdz.checked==true&&wbzdz.checked==false){
		dwdzzt = "1";
	}else if(ybzdz.checked==false&&wbzdz.checked==true){
		dwdzzt = "2";
	}
	$('#dg').datagrid('load',{'dwlbdm':dwlbdm,'dwmc':dwmc,'dz_dwdzxz':dz_dwdzxz,'jyfwzy':jyfwzy,'jjlxdm':jyxzdm,'dwdzzt':dwdzzt});
	closeWindow("win");
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
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

//datagrid加载完成后事件，地图定位
function loadpoints1(data){
	//延迟加载统计
	beforeTableLoad(data,'dg');
	var mapWindow = null;
	if (IE) {
		mapWindow = parent.frames["biz_center"];
	}else {
		mapWindow = parent.frames.document.getElementById("biz_center").contentWindow;
	}
	if ("undefined" != typeof mapWindow && mapWindow != null) {
		if (mapWindow.SydwMap) {
			mapPoint(mapWindow);
		}else {
			setTimeout(function() {mapPoint(mapWindow);}, 3000);
		}
	}
}
//地图定位
function mapPoint(mapWindow) {
	//markerArr = new Array();
	if (mapWindow.SydwMap) {
		mapWindow.SydwMap.clearMarkers();
		var rows = $('#dg').datagrid("getRows");
		var len = rows.length;
		var dwidsArray = [];
		for (var i = 0; i < len; i++) {
			dwidsArray.push("'" + rows[i].id + "'");
			if (rows[i].dz_dwdzdm != "undefined" && rows[i].dz_dwdzdm != "") {
				dz_dwdzdmArr[rows[i].dz_dwdzdm] = rows[i].dz_dwdzdm;
			}
		}
		if (len > 0) {
			$.ajax({
				type:"GET",
				sync:true,
				url:contextPath+"/sydwcx/queryZbByDzId",
				data:{dwids:dwidsArray.join(",")},
				dataType:'json',
				success:function(json){
					var len = json.length;
					for (var i = 0; i < len; i++) {
						
						if (json[i].zbx!=null && json[i].zbx!=""){
							var marker = null;
							if (IE) {
								marker = mapWindow.addMarker(json[i].dwmc,json[i].zbx,json[i].zby,"location.png",null,null,34,34,false,json[i].dz_dwdzdm,null);
							} else{
								marker = mapWindow.addMarker(json[i].dwmc,json[i].zbx,json[i].zby,"location.png",null,null,34,34,false,json[i].dz_dwdzdm,null);
							}
							markerArr[json[i].dz_dwdzdm] = marker;
							dz_dwdzdmArr[json[i].dz_dwdzdm] = json[i].dz_dwdzdm;
							console.log(json[i].dz_dwdzdm);
						}
					}
				}
			});
		}
	}
}
</script>  

</html>