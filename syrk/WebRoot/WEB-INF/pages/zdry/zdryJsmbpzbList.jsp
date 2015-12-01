<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>重点人员纪实模板配置</title>

</head>
<body>
	<div id="layout_main" class="easyui-layout"  data-options="fit:true,border:false">
		<div id="panel_center" border="0" data-options="region:'center',border:false" style="width:700px;border:none;">
			<table id="dg" class="easyui-datagrid" style="width:700px;height:auto" data-options="url:'<%=contextPath%>/zdryJsmbpzb/queryList',fitColumns:true,singleSelect:true,
    		toolbar:'#dgToolbar',
    		pageSize:getAutoPageSize(300),
       		pageList:[getAutoPageSize(300),
       		getAutoPageSize(300) * 2]">
    			<thead>   
			        <tr>   
			        	<th data-options="field:'id',hidden:true"></th>
			        	<th data-options="field:'sfmr',width:150,align:'center',fixed:true,formatter:datagridDefaultFormater">默认</th>
			        	<th data-options="field:'zdrygllxdm',width:250,align:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_ZDRYLBDMLIST_MUNICIPAL.js'">重点人员类型代码</th>
			        	<th data-options="field:'mbmc',width:400,align:'center',fixed:true">模板名称</th>
			            <th data-options="field:'mbnr',width:400,align:'center'">模板内容</th>
			            <th data-options="field:'process',width:200,align:'center',fixed:true,formatter:datagridProcessFormater">操作</th>   
			        </tr>   
			    </thead>
    		</table>
    		<div id="dgToolbar" style="padding:5px;height:50px" align="left">
				<form id="queryForm">
					<table cellspacing="4" cellpadding="4" border="0">
						<tbody>
							<tr>
								<td class="toolbarTd">
									重点人员管理类型：<input type="text" name="zdrygllxdm" id="zdrygllxdm" class="easyui-combobox" data-options="required:false,url: contextPath + '/common/dict/BD_D_ZDRYLBDMLIST_MUNICIPAL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'" style="width:200px" />
								</td>
								<td class="toolbarTd">
									<a class="easyui-linkbutton" iconCls="icon-search" onclick="query();" style="margin-right: 10px;">查询</a>
									<a class="easyui-linkbutton" iconCls="icon-reload" onclick="reset();" style="margin-right: 10px;">重置</a>
								</td>
								<td class="toolbarTd">
									<a class="easyui-linkbutton" iconCls="icon-search" onclick="doAdd();" style="margin-right: 10px;">新增</a>
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
		$('#zdrygllxdm').combobox('setDataFilter', '^0[1-8]{1,1}$');
	
});

function afterSubmitSuccess(){
	$('#dg').datagrid('reload');
}

//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	return '<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">编辑</a>&nbsp;&nbsp;&nbsp;'+
   	'<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this,'+index+')">删除</a>&nbsp;&nbsp;&nbsp;'+
   	'<a class="link" href="javascript:javascript:void(0)" onclick="doSetDefault(this,'+index+')">设为默认</a>';
}

//【默认】列
function datagridDefaultFormater(val, row, index){
	if(val == "1"){
		return '<font color="orange">默认</font>';
	}
}

//删除
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	topMessager.confirm('','您确认要注销数据吗？',function(r) {    
		if (r) {	
			var rows = $('#dg').datagrid('getData');
			var rowData = rows.rows[index];
			$.ajax({
				type:"GET",
				url:"<%= basePath%>zdryJsmbpzb/delete",
				dataType:"json",
				data:"id="+rowData.id,
				async:false,
				success:function(data){
					$('#dg').datagrid('reload');
				}
			});
		}
	});
}

//新增
function doAdd(){
	window.top.openWindowWithSave(false, null, window, 
   		{}, 
   		{
   		title: '动态纪实模板新增',
   		url: '<%=contextPath%>/zdryJsmbpzb/add',
   		width: 830,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}

//编辑
function doEdit(linkObject, index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	window.top.openWindowWithSave(false, null, window, 
   		{}, 
   		{
   		title: '动态纪实模板编辑',
   		url: '<%=contextPath%>/zdryJsmbpzb/add?id='+rowData.id,
   		width: 830,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}

//设为默认
function doSetDefault(linkObject, index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	$.ajax({
		type:"GET",
		url:"<%= basePath%>zdryJsmbpzb/setDefault",
		dataType:"json",
		data:"id="+rowData.id+"&zdrygllxdm="+rowData.zdrygllxdm,
		async:false,
		success:function(data){
			$('#dg').datagrid('reload');
		}
	});
}

//按下enter,清空
function setDzqc(obj){
	obj.value="";
}

//查询按钮
function query(){
	var zdrygllxdm = document.getElementById("zdrygllxdm").value;
	$('#dg').datagrid(
			'reload',
			{    
				'zdrygllxdm': zdrygllxdm
			});
}

//重置
function reset(){
	  $("#queryForm").form("reset");
}
</script>
</html>