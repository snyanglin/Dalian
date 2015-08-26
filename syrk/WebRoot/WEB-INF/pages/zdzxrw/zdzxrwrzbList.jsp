<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>自动执行任务日志</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'自动执行任务日志',border:true" style="height:auto">
			<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>zdzxrwrzb/queryList',toolbar:'#datagridToolbar',
			            singleSelect:false,
			            selectOnCheck:true,checkOnSelect:true,border:false,sortOrder:'desc',sortName:'xt_zhxgsj',
			            	idField:'id',pageSize:getAutoPageSize(175),pageList:[getAutoPageSize(175),getAutoPageSize(175) * 2],
			            	onDblClickRow:dbClickRow
			            	">
			    <thead>
			        <tr>
			       	 	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
			            <th data-options="field:'rwmc', 	width:25,	align:'center',	halign:'center'	,sortable:true">任务名称</th>
			            <th data-options="field:'rwzxkssj',	width:20,	align:'center',	halign:'center'	,sortable:true">任务执行开始时间</th>
			            <th data-options="field:'rwzxwcsj',	width:20,	align:'center',	halign:'center'	,sortable:true">任务执行完成时间 </th>
			            <th data-options="field:'rwzxsc',	width:20,	align:'center',	halign:'center'	,sortable:true">任务执行时长</th>
			            <th data-options="field:'sfzxcg',	width:10,	align:'center',	halign:'center'	,sortable:true">是否执行成功</th>
			            <th data-options="field:'zxqk', 	width:12,	align:'center',	halign:'center'	,sortable:true">执行情况</th>
			            <!-- 
				        <th data-options="field:'process',	width:10,   align:'center',	halign:'center',formatter:datagridProcessFormater">操作</th>
			             -->
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
										任务名称：<input class="easyui-validatebox" type="text" id="rwmc" name="rwmc" 
												data-options="required:false,validType:'maxLength[100]'" 
												style="width:160px"/>
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										是否执行成功：<input class="easyui-validatebox" type="text" name="sfzxcg" id="sfzxcg" 
													data-options="required:false,validType:'maxLength[1]'"  
													style="width:160px;" />
									</td>
								</tr>
								<tr>
									<td class="toolbarTd" style="width:280px">
										执行时长：<input class="easyui-validatebox" type="text" name="rwzxsc" id="rwzxsc" 
												data-options="required:false,validType:'maxLength[13]'"  
												style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										执&nbsp行&nbsp情&nbsp况&nbsp：<input class="easyui-validatebox" type="text" name="zxqk" id="zxqk" 
												data-options="required:false,validType:'maxLength[4000]'"  
												style="width:160px;" />
									</td>
								</tr>
								<tr>
									<td class="toolbarTd" align="right" colspan="7" style="padding-right:8px">
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
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

    	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">查看详情</a>&nbsp;&nbsp;&nbsp;';
}

function doEdit(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = "/zdzxrwrzb/zdzxrwbAdd?";
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		
		hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
		menu_open("自动执行任务日志查看－" ,hsUrl);
  }
function clearCase(){
	  $("#queryForm").form("reset");
}

//查询按钮
function queryButton(){
  	var rwmc = document.getElementById("rwmc").value;
  	var sfzxcg = document.getElementById("sfzxcg").value;
  	var rwzxsc = document.getElementById("rwzxsc").value;
  	var zxqk = document.getElementById("zxqk").value;
  	
  	rwmc= $.trim(rwmc);
  	zxqk= $.trim(zxqk);
  	
  	$('#dg').datagrid(
  			'reload',
  			{    
  				'rwmc':rwmc,
  				'sfzxcg':sfzxcg,
  				'rwzxsc':rwzxsc,
  				'zxqk':zxqk
  			});
  }
  
 
	
function dbClickRow(rowIndex,rowData){
}


function reloadDg(){
		$("#dg").datagrid("clearSelections");
		$('#dg').datagrid('reload');
}
    </script>
  </body>
</html>
