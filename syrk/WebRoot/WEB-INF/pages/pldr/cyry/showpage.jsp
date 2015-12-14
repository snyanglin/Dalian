<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>从业人员</title>
</head>
<html>
  <head>
  </head>
  <body>
  <div data-options="region:'center', split:true" style="width:1400px; margin:0 0 0;border-width: 0px; height:250px;">
  <div id="tt" class="easyui-tabs" style="height:650px;">   
    <div title="格式非法数据" >
    <div id="tb">
    	<span style="color: red;">请确认，以下数据在格式上不符合检测条件，已经失效，点击后面的注销按钮注销数据，建议重新上传这部分数据：</span>
		<a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="errordelete();">注销</a>
	</div>
    
	<table class="easyui-datagrid" id="dataListe" title="以下数据格式错误，已失效，请确认，建议重传" 
			data-options="url: '<%=basePath %>/pldrshow/cyry/showError',fitColumns:true">
	<thead>
		<tr>
			<!-- <th data-options="field:'hh',width:'100',checkbox:'true',align:'left',halign:'center'"></th> -->
			<th data-options="field:'dwid',width:'0px',align:'left',halign:'center',hidden:true"></th>
			<th data-options="field:'lrrid',width:'0px',align:'left',halign:'center',hidden:true""></th>
			<th data-options="field:'dw',width:'180px',align:'left',halign:'center'"></th>
			<th data-options="field:'sfzh',width:'300px',align:'left',halign:'center'">身份证号</th>
			<th data-options="field:'xm',width:'100px',align:'left',halign:'center'">姓名</th>
			<th data-options="field:'xb',width:'100px',align:'left',halign:'center'">性别</th>
			<th data-options="field:'csrq',width:'200px',align:'left',halign:'center'">出生日期</th>
			<th data-options="field:'mz',width:'100px',align:'left',halign:'center'">民族</th>
			<th data-options="field:'lxdh',width:'200px',align:'left',halign:'center'">联系电话</th>
		</tr>		
	</thead>	
	</table>
	</div>
	<div title="格式合法数据" >
		<table class="easyui-datagrid" id="dataListr" title="以下数据格式正确，请比对复用数据，确认重点人口，然后提交" 
			data-options="url: '<%=basePath %>/pldrshow/cyry/showRight',fitColumns:true">
		<thead>
		<tr>
			<!-- <th data-options="field:'hh',width:'100',checkbox:'true',align:'left',halign:'center'"></th> -->
			<th data-options="field:'dwid',width:'0px',align:'left',halign:'center',hidden:true"></th>
			<th data-options="field:'dw',width:'200px',align:'left',halign:'center'"></th>
			<th data-options="field:'lrrid',width:'0px',align:'left',halign:'center',hidden:true""></th>
			<th data-options="field:'sfzh',width:'100px',align:'left',halign:'center'">身份证号</th>
			<th data-options="field:'sfzd',width:'50px',align:'left',halign:'center',styler:function(value,row,index){if(value=='' || value==null){return 'background-color:green;';}else{return 'background-color:red;';}}">重口</th>
			<th data-options="field:'xm',width:'100px',align:'left',halign:'center',styler:cellStyler_xm">姓名</th>
			<th data-options="field:'xm_fy',width:'100px',align:'left',halign:'center',styler:function(value,row,index){return 'color:green;'}">复用姓名</th>
			<th data-options="field:'xb',width:'100px',align:'left',halign:'center',styler:cellStyler_xb,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js'">性别</th>
			<th data-options="field:'xb_fy',width:'75px',align:'left',halign:'center',styler:function(value,row,index){return 'color:green;';},formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js'">复用性别</th>
			<th data-options="field:'csrq',width:'75px',align:'left',halign:'center',styler:cellStyler_csrq">出生日期</th>
			<th data-options="field:'csrq_fy',width:'100px',align:'left',halign:'center',styler:function(value,row,index){return 'color:green;'}">复用出生日期</th>
			<th data-options="field:'mz',width:'50px',align:'left',halign:'center',styler:cellStyler_mz">民族</th>
			<th data-options="field:'mz_fy',width:'50px',align:'left',halign:'center',styler:function(value,row,index){return 'color:green;';},formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_MZ.js'">复用民族</th>
			<th data-options="field:'lxdh',width:'100px',align:'left',halign:'center',styler:cellStyler_lxdh">联系电话</th>
			<th data-options="field:'lxdh_fy',width:'100px',align:'left',halign:'center',styler:function(value,row,index){return 'color:green;';},formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_MZ.js'">复用联系电话</th>
			<th data-options="field:'caozuo',width:'180px',align:'left',halign:'center',formatter:caozuo">操作</th>
		</tr>		
		</thead>
		</table>
	</div>  
	</div>
	</div>
  </body>
</html>
<script type="text/javascript" >
$('#dataListe').datagrid({
	toolbar: '#tb'
});	
	function  cellStyler_xm(value,row,index){
		if(row.xm!=row.xm_fy){
			return 'color:red;';
		}else{
			return 'color:green;';
		}
	}
	function  cellStyler_xb(value,row,index){
		if(row.xb!=row.xb_fy){
			return 'color:red;';
		}else{
			return 'color:green;';
		}
	}
	function  cellStyler_csrq(value,row,index){
		if(row.csrq!=row.csrq_fy){
			return 'color:red;';
		}else{
			return 'color:green;';
		}
	}
	function  cellStyler_mz(value,row,index){
		if(row.mz!=row.mz_fy){
			return 'color:red;';
		}else{
			return 'color:green;';
		}
	}
	function  cellStyler_lxdh(value,row,index){
		if(row.lxdh!=row.lxdh_fy){
			return 'color:red;';
		}else{
			return 'color:green;';
		}
	}
	function caozuo(value,row,index){
		return "<a href='javascript:;' class='easyui-linkbutton' icon='icon-save' onclick='fysave(this,"+index+");'>复用生效</a>&nbsp;<a href='javascript:;' class='easyui-linkbutton' icon='icon-save' onclick='yssave(this,"+index+");'>原始生效</a>&nbsp;<a href='javascript:;' class='easyui-linkbutton' icon='icon-cancel' onclick='zxsave(this,"+index+");'>注销该条</a>";
	}
	function errordelete(){
		$.post("<%=basePath %>/pldrshow/cyry/errordelete",function(result){$('#dataListe').datagrid('reload');});
	}
	function fysave(linkobject,index){
		alert("fysave");
		var rows = $('#dataListr').datagrid('getData');
		var rowData = rows.rows[index];
		alert("单位id"+rowData.dwid+"+"+rowData.sfzh);
		$.post("<%=basePath %>/pldrshow/cyry/fysave_one",{dwid:rowData.dwid,sfzh:rowData.sfzh},function(result){$('#dataListr').datagrid('reload');});
	}
	function yssave(linkobject,index){
		var rows = $('#dataListr').datagrid('getData');
		var rowData = rows.rows[index];
		$.post("<%=basePath %>/pldrshow/cyry/yssave_one",{dwid:rowData.dwid,sfzh:rowData.sfzh},function(result){$('#dataListr').datagrid('reload');});
	}
	function zxsave(linkobject,index){
		var rows = $('#dataListr').datagrid('getData');
		var rowData = rows.rows[index];
		$.post("<%=basePath %>/pldrshow/cyry/delete_one",{dwid:rowData.dwid,sfzh:rowData.sfzh},function(result){$('#dataListr').datagrid('reload');});
	}
</script>