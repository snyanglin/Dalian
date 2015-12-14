<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>重点人员指定列表</title>

</head>
<body>
	<div id="layout_main" class="easyui-layout"  data-options="fit:true,border:false">
		<div id="panel_center" border="0" data-options="region:'center',border:false" style="width:700px;border:none;">
			<table id="dg" class="easyui-datagrid" style="width:700px;height:auto" data-options="url:'<%=contextPath%>/zdrySjzdlcg/queryCgZdryzdlb',fitColumns:true,singleSelect:true,
    		toolbar:'#dgToolbar',
    		pageSize:getAutoPageSize(300),
       		pageList:[getAutoPageSize(300),
       		getAutoPageSize(300) * 2]">
    			<thead>   
			        <tr>   
			        	<th data-options="field:'id',hidden:true"></th>
			        	<th data-options="field:'ryid',hidden:true"></th>
			        	<th data-options="field:'syrkid',hidden:true"></th>
			        	<th data-options="field:'zdrygllxdm',width:200,align:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_ZDRYLBDM.js'">重点人员类型</th>
			        	<th data-options="field:'ssfxjdm',width:200,align:'center'">管辖分局</th>
			        	<th data-options="field:'sspcsdm',width:200,align:'center'">管辖派出所</th>
			        	<th data-options="field:'xm',width:200,align:'center',fixed:true">姓名</th>
			        	<th data-options="field:'cyzjdm',width:150,align:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/KX_D_CYZJDM.js'">证件类型</th>
			        	<th data-options="field:'zjhm',width:150,align:'center',fixed:true">证件号码</th>
			        	<th data-options="field:'xbdm',width:150,align:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/GB_D_XBDM.js'">性别</th>
			            <th data-options="field:'dz_jzdzxz',width:200,align:'center',fixed:true">现住地址</th>
			            <th data-options="field:'process',width:200,align:'center',fixed:true,formatter:datagridProcessFormater">操作</th>   
			        </tr>   
			    </thead>
    		</table>
    		<div id="dgToolbar" style="padding:5px;height:110px" align="left">
				<form id="queryForm">
					<table cellspacing="2" cellpadding="2" border="0">
						<tbody>
							<tr>
								<td class="toolbarTd" align="right">
									重点人员管理类型：<input class="easyui-combobox" type="text" id="zdrygllxdm" name="zdrygllxdm"
												data-options="url: contextPath + '/common/dict/BD_D_ZDRYLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" style="width:200px"/>
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" align="right">
									 管辖分局：<input type="text" name="ssfxjdm" id="ssfxjdm" class="easyui-combobox" style="width:200px;" 
					data-options="url: contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=21',method:'get',
						valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:orgList21_onChange">
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" align="right">
									 管辖派出所：<input type="text" name="sspcsdm" id="sspcsdm" class="easyui-combobox" style="width:200px;" 
					data-options="method:'get',valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false">
								</td>
							</tr>
							<tr>
								<td class="toolbarTd" align="right">
									姓名：<input type="text" name="xm" id="xm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:200px;" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" align="right">
									证件类型：<input type="text" name="cyzjdm" id="cyzjdm" class="easyui-combobox" data-options="required:false,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'" style="width:200px" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" align="right">
									 证件号码：<input type="text" name="zjhm" id="zjhm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" style="width:200px" />
								</td>
							</tr>
							<tr>
								<td class="toolbarTd" align="right">
									现住地址：<input type="text" name="dz_jzdzxz" id ="dz_jzdzxz" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" style="width:200px"  />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" colspan="3" align="left">
									<a class="easyui-linkbutton" iconCls="icon-search" onclick="query();" style="margin-right: 10px;">查询</a>
									<a class="easyui-linkbutton" iconCls="icon-reload" onclick="reset();">重置</a>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
var parentGrid;

function doInit(paramArray) {
	parentGrid = paramArray['_p'];
}

$(document).ready(function(){
	$('#panel_center').find('div.panel-body').css('border', 'none');
});

function afterSubmitSuccess(){
	$('#dg').datagrid('reload');
}

//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	return '<a class="link" href="javascript:javascript:void(0)" onclick="doCg(this,'+index+')">撤管</a>&nbsp;&nbsp;&nbsp;'+		
	       '<a class="link" href="javascript:javascript:void(0)" onclick="doView(this,'+index+')">查看</a>';
}

//查看【实有人口】（跳转至【实有人口】编辑页面）
function doView(linkObject, index) {
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/syrkgl/view?id="+rowData.ryid+"&jzdzdm="+rowData.dz_jzdzdm+"&zdryid="+"&jzdzzbid="+rowData.id;
	menu_open("实有人口－" + rowData.xm,editUrl);
}

//撤管
function doCg(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	window.top.openWindowWithSave(false, null, window, 
   		{}, 
   		{
   		title: '指定撤管',
   		url: '<%=contextPath%>/zdrySjzdlcg/sjzdcgAdd?ryid='+rowData.ryid+'&id='+rowData.id+'&dz_jzdzxz='+rowData.dz_jzdzxz+'&zdrylbdm='+rowData.zdrylbdm+'&dzdm='+rowData.dzdm,
   		width: 830,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}

//撤管Temp
function doCgTemp(linkObject, id, dz_jzdzxz, zdrylbdm, dzdm, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var rows = $('#'+datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	window.top.openWindowWithSave(false, null, window, 
   		{}, 
   		{
   		title: '指定撤管',
   		url: '<%=contextPath%>/zdrySjzdlcg/sjzdcgAdd?ryid='+rowData.ryid+'&id='+id+'&dz_jzdzxz='+dz_jzdzxz+'&zdrylbdm='+zdrylbdm+'&dzdm='+dzdm,
   		width: 830,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}

//查询按钮
function query(){
	var zdrygllxdm = document.getElementById("zdrygllxdm").value;
	var ssfxjdm = document.getElementById("ssfxjdm").value;
	var sspcsdm = document.getElementById("sspcsdm").value;
	var xm = document.getElementById("xm").value;
	var cyzjdm = document.getElementById("cyzjdm").value;
	var zjhm = document.getElementById("zjhm").value;
	var dz_jzdzxz = document.getElementById("dz_jzdzxz").value;
	
	
	$('#dg').datagrid(
			'reload',
			{    
				'zdrygllxdm': zdrygllxdm,   
				'ssfxjdm': ssfxjdm ,
				'sspcsdm':sspcsdm,
				'xm':xm,
				'cyzjdm':cyzjdm,
				'zjhm':zjhm,
				'dz_jzdzxz':dz_jzdzxz
			});
}

//重置
function reset(){
	  $("#queryForm").form("reset");
}

function orgList21_onChange(newValue, oldValue) {
	var parentOrgCode = $('#ssfxjdm').combobox('getValue');
	if (parentOrgCode == "") {
		$('#sspcsdm').combobox('loadData', []);
	}
	else {
		var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=32&parentOrgCode=' + parentOrgCode;    
	    $('#sspcsdm').combobox('reload', url);
	}
}

</script>
</html>