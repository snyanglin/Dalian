<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>导入反馈详细信息</title>

</head>
<body>
	<div id="layout_main" class="easyui-layout" data-options="" style="height:100%">
		<!-- 从业人员基本信息展示区域 -->
		<div id="panel_north" class="easyui-panel" data-options="region:'north',noheader:true" style="width:700px;height:200px;border:none">
			<div id="layout_north" class="easyui-layout" data-options="fit:true">
				<div id="div_north_west" data-options="region:'west'" style="width:180px;border:none">
					<img id="img_cyry_photo" align="middle" style="width:162px;height:200px" src=""/>
				</div>
				<div id="div_north_center" data-options="region:'center'" style="width:520px;height:250px;padding-left:50px;border:none">
					<p>入职时间：<font id="text_pysj"></font></p>
					<p>身份证号：<font id="text_sfzh"></font></p>
					<p>姓名：<font id="text_xm"></font></p>
					<p>性别：<font id="text_xbdm"></font></p>
					<p>出生日期：<font id="text_csrq"></font></p>
					<p>居住地址：<font id="text_dz_xzzxz"></font></p>
				</div>
			</div>
		</div>
		<!-- 从业人员列表展示区域 -->
		<div id="panel_center" class="easyui-panel" data-options="region:'center'" style="width:700px;border:none">
			<table id="cyryxxbDetailGrid" class="easyui-datagrid" data-options="url:'<%=contextPath%>/cyrydrrwmxb_dl/view?rwid=${rwid}',fitColumns:true,singleSelect:true,
    		toolbar:'#cyryxxbDetailGridToolbar',onSelect:loadCyryDetail,method:'get'">
    			<thead>   
			        <tr>   
			            <th data-options="field:'xm',width:80,align:'center'">姓名</th>
	        	<th data-options="field:'zjhm',width:150,align:'center'">身份证号码</th>
	        	<th data-options="field:'xbdm',width:50,align:'center',formatter:xb_formatter">性别</th>
	            <th data-options="field:'csrq',width:90,align:'center'">出生日期</th>
	            <th data-options="field:'pysj',width:90,align:'center'">入职时间</th>   
	            <th data-options="field:'dz_xzzxz',align:'center'">居住地址</th>
	            <th data-options="field:'drjg',align:'center',formatter:drjg_formatter">导入结果</th>
	            <th data-options="field:'mxms',align:'center'">描述</th>
	            <th data-options="field:'dz_xzzdm',hidden:true">居住地址代码</th>
	            <th data-options="field:'cyrwid',hidden:true">从业人员ID</th>
	             <th data-options="field:'ryid',hidden:true">人员ID</th>
	            <th data-options="field:'process',width:70,align:'center',formatter:datagridProcessFormater">操作</th>   
			        </tr>   
			    </thead>
    		</table>
    		
    		
    		<div id="cyryxxbDetailGridToolbar" style="padding:5px;height:auto">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
					<tr>
						
						<td align="right">
							<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls=""  onclick="export_cyryxxb();">导出</a>
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
	
});




function export_cyryxxb(){
	location.href=contextPath+'/cyrydrrwmxb_dl/export?rwid=${rwid}';
}




//显示从业人员详细信息
function loadCyryDetail(rowIndex, rowData){
	$('#text_pysj').html(rowData.pysj);
	$('#text_sfzh').html(rowData.zjhm);
	$('#text_xm').html(rowData.xm);
	if(rowData.xbdm == '1'){
		$('#text_xbdm').html('男');
	}else if(rowData.xbdm == '2'){
		$('#text_xbdm').html('女');
	}
	$('#text_csrq').html(rowData.csrq);
	$('#text_dz_xzzxz').html(rowData.dz_xzzxz);
	document.getElementById("img_cyry_photo").src = contextPath+"/zpfjPtryzp/queryPtryzpSingle.jpg?ryid="+rowData.cyrwid+"&zjhm="+rowData.zjhm+"&cyzjdm=111";
}

//性别formatter
function xb_formatter(value, rowData, rowIndex){
	if(value == '1'){
		return '男';
	}else if(value == '2'){
		return '女';
	}else{
		return '其他';
	}
}


function drjg_formatter(value, rowData, rowIndex){
	if(value == '1'){
		return '<font color="green">成功</font>';
	}else if(value == '2'){
		return '<font color="yellow">警告</font>';
	}else{
		return '<font color="red">失败</font>';
	}
	
}
//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	 if(row.cyrwid==''){
		return '导入失败';
		 }
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">查看</a>&nbsp;';
}

//修改单条
function doEdit(linkObject, index) {
	var rows = $('#cyryxxbDetailGrid').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/syrkgl/view?id="+rowData.ryid+"&jzdzdm="+rowData.dz_xzzdm+"&zdryid="+"&jzdzzbid="+rowData.ryid;
	menu_open("实有人口－" + rowData.xm,editUrl);
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