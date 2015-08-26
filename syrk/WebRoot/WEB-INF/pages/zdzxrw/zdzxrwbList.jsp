<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>自动执行任务</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'自动执行任务',border:true" style="height:auto">
			<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>zdzxrwb/queryList',toolbar:'#datagridToolbar',
			            singleSelect:false,
			            selectOnCheck:true,checkOnSelect:true,border:false,sortOrder:'desc',sortName:'xt_zhxgsj',
			            	idField:'id',pageSize:getAutoPageSize(175),pageList:[getAutoPageSize(175),getAutoPageSize(175) * 2],
			            	onDblClickRow:dbClickRow
			            	">
							    <thead>
							        <tr>
							       	 	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
							            <th data-options="field:'rwmc', 	width:25,	align:'center',	halign:'center'	,sortable:true">任务名称</th>
							            <th data-options="field:'rwzxff',	width:20,	align:'center',	halign:'center'	,sortable:true">执行方法</th>
							            <th data-options="field:'rwkssj',	width:20,	align:'center',	halign:'center'	,sortable:true">开始时间</th>
							            <th data-options="field:'rwjssj',	width:20,	align:'center',	halign:'center'	,sortable:true">结束时间</th>
							            <th data-options="field:'jglx',		width:10,	align:'center',	halign:'center'	,sortable:true">间隔类型</th>
							            <th data-options="field:'sfjytg', 	width:12,	align:'center',	halign:'center'	,sortable:true">是否校验通过</th>
							            <th data-options="field:'rwzt', 	width:10,	align:'center',	halign:'center'	,sortable:true">任务状态</th>
							            <th data-options="field:'process',	width:10,   align:'center',	halign:'center',formatter:datagridProcessFormater">操作</th>
							        </tr>
							    </thead>
							</table>
					<div id="datagridToolbar" style="padding:5px;height:auto" >
					
					
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" >
							<tbody>
							<tr>
									<td class="toolbarTd" style="width:280px">
										任&nbsp务&nbsp名&nbsp称&nbsp：<input class="easyui-validatebox" type="text" id="rwmc" name="rwmc" 
												data-options="required:false,validType:'maxLength[100]'" 
												style="width:160px"/>
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										间隔类型：<input class="easyui-validatebox" type="text" name="jglx" id="jglx" 
												data-options="required:false,validType:'maxLength[1]'"  
												style="width:160px;" />
									</td>
								</tr>
								
								<tr>
									<td class="toolbarTd" style="width:280px">
										是否校验通过：<input class="easyui-validatebox" type="text" name="sfjytg" id="sfjytg" 
												data-options="required:false,validType:'maxLength[1]'"  
												style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										任务状态：<input class="easyui-validatebox" type="text" name="rwzt" id="rwzt" 
												data-options="required:false,validType:'maxLength[1]'"  
												style="width:160px;" />
									</td>
									
								</tr>
								
								<tr>
									<td class="toolbarTd" align="right" colspan="7" style="padding-right:8px">
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
										<a class="easyui-linkbutton" iconCls="icon-add" onclick="addRw();">新增</a>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
	</div>
	</div>
	</div>
<script type="text/javascript">
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
    	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">编辑</a>&nbsp;&nbsp;&nbsp;'+
    			'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doStop(this, '+index+')">暂停</a>&nbsp;'+//未实现
    		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">注销</a>&nbsp;';
}
  
function clearCase(){
	  $("#queryForm").form("reset");
}

//查询按钮
function queryButton(){
  	var rwmc = document.getElementById("rwmc").value;
  	var jglx = document.getElementById("jglx").value;
  	var rwzt = document.getElementById("rwzt").value;
  	var sfjytg = document.getElementById("sfjytg").value;
  	
  	rwmc= $.trim(rwmc);
  	//jglx= $.trim(jglx);
  	//rwzt= $.trim(rwzt);
  	//sfjytg= $.trim(sfjytg);

  	$('#dg').datagrid(
  			'reload',
  			{    
  				'rwmc':rwmc,
  				'jglx':jglx,
  				'rwzt':rwzt,
  				'sfjytg':sfjytg
  			});
  }
  
function doEdit(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = "/zdzxrwb/zdzxrwbAdd?";
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		
		hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
		menu_open("自动执行任务编辑－" + rowData.ffzrrxm,hsUrl);
  }
 
//暂停
// SYS_SYRK_11.	把自动执行任务表的任务状态修改为1，同时把操作里面暂停调整为“启动”
function doStop(linkObject,index){
	
}
//注销单条
  function doDelete(linkObject, index) {
	  cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var deleteUrl = contextPath + '/zdzxrwb/deleteZdzxrwb';
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var submitFields = ""; //  除主键之外需要提交的字段（多个用逗号分隔）
		
		topMessager.confirm('','您确认要注销数据吗？',function(r) {    
			if (r) {	
				var opts = $('#' + datagrid_ID).datagrid("options");
				var rows = $('#' + datagrid_ID).datagrid('getData');
				var rowData = rows.rows[index];
				var postFieldArray = [];
				postFieldArray.push(opts.idField);
				if (submitFields != "") {
					postFieldArray = postFieldArray.concat(submitFields.split(","));
				}
				var postData = {};
				for (var i = 0; i < postFieldArray.length; i++) {
					var postField = postFieldArray[i];
					if (rowData[postField]) {
						postData[postField] = rowData[postField];
					}
				}
				$.ajax({
					url: deleteUrl,
					type: 'POST',
					data: postData
				}).done(function(result) {
					doSubmitResult(result, null, datagrid_ID);
				});
			}
		});
  }
	
function dbClickRow(rowIndex,rowData){
		var hsUrl = "/zdzxrwb/zdzxrwbAdd";
		hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
		menu_open("自动执行任务－" + rowData.xm,hsUrl);
}

function addRw(){
	var hsUrl = "/zdzxrwb/zdzxrwbAdd?";
	hsUrl+="&mainTabID="+getMainTabID();
	menu_open("自动执行任务新增",hsUrl);
}

function reloadDg(){
		$("#dg").datagrid("clearSelections");
		$('#dg').datagrid('reload');
}
    </script>
  </body>
</html>
