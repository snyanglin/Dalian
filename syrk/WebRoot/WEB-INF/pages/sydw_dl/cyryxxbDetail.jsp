<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>从业人员</title>

</head>
<body>
	<div id="layout_main" class="easyui-layout"  data-options="fit:true,border:false">
		<!-- 从业人员基本信息展示区域 -->
		<div id="panel_north" class="easyui-panel" data-options="region:'north',noheader:true" style="width:700px;height:200px;border:none">
			<div id="layout_north" class="easyui-layout" data-options="fit:true">
				<div id="div_north_west" data-options="region:'west'" style="width:180px;border:none;padding-left:10px;">
					<img id="img_cyry_photo" align="middle" style="width:162px;height:200px" src=""/>
				</div>
				<div id="div_north_center" data-options="region:'center'" style="width:520px;height:250px;padding-left:10px;border:none">
					<table border="0" cellpadding="5" cellspacing="5" width="70%"	align="left">
						<tr>
							<td width="30%" align="right">入职时间：</td>
							<td width="70%" align="left"><font id="text_pyrq"></font></td>
						</tr>
						<tr>
							<td width="30%" align="right">身份证号：</td>
							<td width="70%" align="left"><font id="text_sfzh"></font></td>
						</tr>
						<tr>
							<td width="30%" align="right">姓名：</td>
							<td width="70%" align="left"><font id="text_xm"></font></td>
						</tr>
						<tr>
							<td width="30%" align="right">性别：</td>
							<td width="70%" align="left"><font id="text_xbdm"></font></td>
						</tr>
						<tr>
							<td width="30%" align="right">出生日期：</td>
							<td width="70%" align="left"><font id="text_csrq"></font></td>
						</tr>
						<tr>
							<td width="30%" align="right">居住地址：</td>
							<td width="70%" align="left"><font id="text_dz_xzzxz"></font></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- 从业人员列表展示区域 -->
		<div id="panel_center" border="0" data-options="region:'center',border:false" style="width:700px;border:none;">
			<table id="cyryxxbDetailGrid" class="easyui-datagrid" style="width:700px;height:auto" data-options="url:'<%=contextPath%>/sydwgl_dl/cyryxxb_query_all?dwid=${dwid}',fitColumns:true,singleSelect:true,
    		delayCountUrl:'<%=basePath%>',toolbar:'#cyryxxbDetailGridToolbar',onSelect:loadCyryDetail,onLoadSuccess:dgLoadSuccess,
    		pageSize:getAutoPageSize(300),
            		pageList:[getAutoPageSize(300),
            		getAutoPageSize(300) * 2]">
    			<thead>   
			        <tr>   
			            <th data-options="field:'xm',width:60,align:'center',fixed:true">姓名</th>
			        	<th data-options="field:'zjhm',width:120,align:'center',fixed:true">身份证号码</th>
			        	<th data-options="field:'xbdm',width:40,align:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js'">性别</th>
			            <th data-options="field:'csrq',width:70,align:'center',fixed:true">出生日期</th>
			            <th data-options="field:'pyrq',width:70,align:'center',fixed:true">入职时间</th>   
			            <th data-options="field:'dz_xzzxz',width:230,align:'center'">居住地址</th>
			            <th data-options="field:'dz_xzzdm',hidden:true"></th>
			            <th data-options="field:'process',width:150,align:'center',fixed:true,formatter:datagridProcessFormater">操作</th>   
			        </tr>   
			    </thead>
    		</table>
    		<div id="cyryxxbDetailGridToolbar" style="padding:5px;height:46px;border:none;">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
					<tr>
						<td align="left" width="35%">
							<input type="text" class="searchText" name="condition"  id="condition" value="请输入从业人员姓名、身份证号" 
									style="color:gray;height:25px;font-size:13px;width:100%;min-width:100%"  onclick="setDzqc(this)" />
						</td>
						<td align="left">
							<a href="javascript:void(0)" class="easyui-linkbutton" 
								 iconCls="icon-search" onclick="searchMain()">查询</a>
						</td>
						<td align="right">
						<c:if test="${mode != 'view'}">
							<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="add_cyryxxb();">新增</a>
							</c:if>
							<%--<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls=""  onclick="import_cyryxxb();">导入</a>
							--%><a href="javascript:void(0)" class="easyui-linkbutton"  iconCls=""  onclick="export_cyryxxb();">导出</a>
						</td>
					</tr>
				</table>
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

//默认选中第一条数据
function dgLoadSuccess(data){
	var rows = data.rows;
	if(rows.length > 0){
		$('#cyryxxbDetailGrid').datagrid('selectRow', 0);
	}
}

//[从业人员详细信息]数据提取
function sadwExtractor(data){
	{
		/***返回值***/
		var returnValue = '';
		if(data != null && data != undefined){
			var tempValue;
			tempValue = '<p>' + data.dwmc + '</p>' +
			'单位性质：' + list[i].dwxzdm + '&nbsp;&nbsp;&nbsp;' + 
			'单位类型：' + list[i].dwlxdm + '&nbsp;&nbsp;&nbsp;' + 
			'注册资金：' + list[i].zczj + '<br>' + 
			'主管部门：' + list[i].zgbm + '&nbsp;&nbsp;&nbsp;' +
			'营业执照号：：' + list[i].yyzzh + '<br>' +
			'经营期限：：' + list[i].jyqxqrq + '&nbsp;' + '至' + '&nbsp;' + list[i].jyqxzrq + '<br><br>';
			returnValue += tempValue;
		}
		return returnValue;
	}
}

function import_cyryxxb(){
	var url = contextPath + '/cyrydrrwxxb_dl/createPage?dwid=${dw.id}';
	openWindow(false, 'cyry_import_win', url, null, {title:'导入任务列表', width:720, height:600});
	
}

function export_cyryxxb(){
	/*
	$.ajax({
		url:contextPath+'/sydwgl/cyryxxb_export?dwid=${dwid}'
	});
	*/
	location.href=contextPath+'/sydwgl_dl/cyryxxb_export?dwid=${dwid}';
}

//添加从业人员
function add_cyryxxb(){
	window.top.openWindowWithSaveNext(false, null, window, 
   		{}, 
   		{
   		title: '从业人员新增',
   		url: '<%=contextPath%>/cyryxxb_dl/createPage?dwid=${dwid}',
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}

function afterSubmitSuccess(){
	$('#cyryxxbDetailGrid').datagrid('reload');
	parentGrid.datagrid('reload');
}

//显示从业人员详细信息
function loadCyryDetail(rowIndex, rowData){
	$('#text_pyrq').html(rowData.pyrq);
	$('#text_sfzh').html(rowData.zjhm);
	$('#text_xm').html(rowData.xm);
	if(rowData.xbdm == '1'){
		$('#text_xbdm').html('男');
	}else if(rowData.xbdm == '2'){
		$('#text_xbdm').html('女');
	}
	$('#text_csrq').html(rowData.csrq);
	$('#text_dz_xzzxz').html(rowData.dz_xzzxz);
	document.getElementById("img_cyry_photo").src = contextPath+"/zpfjPtryzp/queryPtryzpSingle.jpg?ryid="+rowData.ryid+"&zjhm="+rowData.zjhm+"&cyzjdm="+rowData.cyzjdm;
}

//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	return '<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">修改</a>&nbsp;'+
   	'<a class="link" href="javascript:javascript:void(0)" onclick="doCancel(this,'+index+')">注销</a>';
}

//查看【从业人员】（跳转至【实有人口】编辑页面）
function doView(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#cyryxxbDetailGrid').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = '<%=contextPath%>/cyryxxb_dl/view?id='+rowData.ryid+'&jzdzdm='+rowData.dz_xzzdm+'&zdryid='+'&jzdzzbid='+rowData.ryid;
	//menu_open("实有人口－" + rowData.xm,editUrl);
	$.ajax({
		url:'<%=contextPath%>/cyryxxb_dl/checkIfIsSyrk?id='+rowData.ryid,
		dataType:'json',
		success:function(data){
			if(!data){
				$.messager.alert('提示','非实有人口无法进行查看','info');
			}else{
				window.top.openWindow(false, 'cyryDetailView_', editUrl, null, {
			   		title: '从业人员',
			   		width: 880,
			   		inline:true,
			   		height:500
			   		});
			}
		}
	});
}

//编辑【从业人员】
function doEdit(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	window.top.openWindowWithSave(false, null, window, 
   		{}, 
   		{
   		title: '修改 从业人员',
   		url: '<%=contextPath%>/cyryxxb_dl/createPage?dwid=${dwid}&id='+$('#cyryxxbDetailGrid').datagrid('getData').rows[index].id,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}

//注销【从业人员】
function doCancel(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/cyryxxb_dl/delete';
	topMessager.confirm('','您确认要注销数据吗？',function(r) {  
		if (r) {	
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: {id:$('#cyryxxbDetailGrid').datagrid('getData').rows[index].id}
			}).done(function(result) {
				$('#cyryxxbDetailGrid').datagrid('reload');
				parentGrid.datagrid('reload');
			});
		}
	});
}

//按下enter,清空
function setDzqc(obj){
	obj.value="";
}

//查询
function searchMain(){
	var condition = document.getElementById("condition").value;
	if(condition=="请输入从业人员姓名、身份证号"){
		condition="";
	}
	$('#cyryxxbDetailGrid').datagrid('load',{condition:condition});
	$('#cyryxxbDetailGrid').datagrid("clearSelections");
}
</script>
</html>