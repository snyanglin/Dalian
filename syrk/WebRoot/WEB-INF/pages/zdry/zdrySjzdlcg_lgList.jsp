<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>指定列管-重点人员指定列表</title>

</head>
<body>
	<div id="layout_main" class="easyui-layout"  data-options="fit:true,border:false">
		<div id="panel_center" border="0" data-options="region:'center',border:false" style="width:700px;border:none;">
			<table id="dg" class="easyui-datagrid" style="width:700px;height:auto" data-options="fitColumns:true,singleSelect:true,
    		toolbar:'#dgToolbar',
    		pageSize:getAutoPageSize(300),
       		pageList:[getAutoPageSize(300),
       		getAutoPageSize(300) * 2]">
    			<thead>   
			        <tr>   
			        	<th data-options="field:'ryid',hidden:true"></th>
			        	<th data-options="field:'xm',width:150,align:'center',fixed:true">姓名</th>
			        	<th data-options="field:'xbdm',width:100,align:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/GB_D_XBDM.js'">性别</th>
			        	<th data-options="field:'cyzjdm',width:150,align:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/KX_D_CYZJDM.js'">证件种类</th>
			        	<th data-options="field:'zjhm',width:150,align:'center',fixed:true">证件号码</th>
			            <th data-options="field:'csrq',width:150,align:'center',fixed:true">出生日期</th>
			            <th data-options="field:'mzdm',width:100,align:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/GB_D_MZDM.js'">民族</th>
			            <th data-options="field:'dz_hjdzxz',width:250,align:'center'">户籍地址</th>
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
									姓名：<input type="text" name="xm" id="xm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:200px;" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" align="right">
									证件种类：<input type="text" name="cyzjdm" id="cyzjdm" class="easyui-combobox" data-options="required:false,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'" style="width:200px" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" align="right">
									 证件号码：<input type="text" name="zjhm" id="zjhm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" style="width:200px" />
								</td>
							</tr>
							<tr>
								<td class="toolbarTd" align="right">
									性别：<input class="easyui-combobox" type="text" id="xbdm" name="xbdm"
												data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" style="width:200px"/>
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" align="right">
									民族：<input class="easyui-combobox" type="text" id="mzdm" name="mzdm" style="width:200px;"
								data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" align="right">
									国籍：<input type="text" name="gjdm" id ="gjdm" class="easyui-combobox" data-options="required:false,url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'" style="width:200px"  />
								</td>
							</tr>
							<tr>
								<td class="toolbarTd" align="right">
									户籍地址：<input type="text" name="dz_hjdzxz" id ="dz_hjdzxz" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" style="width:200px"  />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" align="right">
									户籍地派出所：<input type="hidden" id="hjdpcsdm" name="hjdpcsdm" value="" style="width: 100;" />
										    <input type="text" id="hjdpcs" name="hjdpcs" style="width: 145px;" value="" />
										    <input type="button" id="orgbutton" value="选择" onClick="public_singleSelectOrg('', '01', '32', '', 'hjdpcsdm', 'hjdpcs', '', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" align="left">
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
	setInputReadonly('hjdpcs', true);
	
	$('#panel_center').find('div.panel-body').css('border', 'none');
	
	//初始化SubGrid
	$('#dg').datagrid({
		view: detailview,
		detailFormatter: function(index, row){
			return '<div style="padding:2px; height:100px;"><table class="ddv"></table></div>';
		},
		onExpandRow: function(index, row){
			var ddv = $(this).datagrid('getRowDetail', index).find('table.ddv');
			ddv.datagrid({
				url:contextPath + '/zdrySjzdlcg/querySubList?ryid='+row.id,
				fitColumns:true,
				rownumbers:true,
				loadMsg:'正在查询，请稍候...',
				pagination: false,
				height:'auto',
				columns:[[
					{field:'dz_jzdzxz', align:'center', title:'现居住地址', width:200},
					{field:'zdrygllxdm', align:'center', title:'重点人员类型', width:200, formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_ZDRYLBDM.js'},
					{field:'xt_zhxgsj', align:'center', title:'列管日期', width:80},
					{field:'xt_zhxgrxm', align:'center', title:'列管人', width:60},
					{field:'zdlgbmmc', align:'center', title:'指定部门', width:80}
				]],
				onResize: function(){
					//$('#dg').datagrid('fixDetailRowHeight', index);
				},
				onLoadSuccess: function(data){
					$('#dg').datagrid('fixRowHeight',index);
					setTimeout(function(){
						//$('#dg').datagrid('fixDetailRowHeight', index);
					}, 0);
				}
			});
			//$('#dg').datagrid('fixDetailRowHeight', index);
		}
	});
});

function afterSubmitSuccess(){
	//$('#dg').datagrid('reload');
}

//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	return '<a class="link" href="javascript:javascript:void(0)" onclick="doLg(this,'+index+')">列管</a>&nbsp;&nbsp;&nbsp;';
}

//查看【实有人口】（跳转至【实有人口】编辑页面）
function doView(linkObject, index) {
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/syrkgl/view?id="+rowData.id+"&jzdzdm="+rowData.dz_jzdzdm+"&zdryid="+"&jzdzzbid="+rowData.id;
	menu_open("实有人口－" + rowData.xm,editUrl);
}

//列管
function doLg(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	window.top.openWindowWithSave(false, null, window, 
   		{}, 
   		{
   		title: '指定列管',
   		url: '<%=contextPath%>/zdrySjzdlcg/sjzdlgAdd?ryid='+$('#dg').datagrid('getData').rows[index].id,
   		width: 830,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}

//按下enter,清空
function setDzqc(obj){
	obj.value="";
}

//查询按钮
function query(){
	var xm = document.getElementById("xm").value;
	var cyzjdm = document.getElementById("cyzjdm").value;
	var zjhm = document.getElementById("zjhm").value;
	var xbdm = document.getElementById("xbdm").value;
	var mzdm = document.getElementById("mzdm").value;
	var gjdm = document.getElementById("gjdm").value;
	var dz_hjdzxz = document.getElementById("dz_hjdzxz").value;
	var hjdpcsdm = document.getElementById("hjdpcsdm").value;
	$('#dg').datagrid('options').url = '<%=contextPath%>/zdrySjzdlcg/queryLgZdryzdlb';
	$('#dg').datagrid(
			'reload',
			{    
				'xm': xm,
				'cyzjdm': cyzjdm,
				'zjhm': zjhm,
				'xbdm': xbdm,
				'mzdm': mzdm,
				'gjdm': gjdm,
				'dz_hjdzxz': dz_hjdzxz,
				'hjdpcsdm': hjdpcsdm
			});
}

//重置
function reset(){
	  $("#queryForm").form("reset");
}
</script>
</html>