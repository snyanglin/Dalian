<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<title>举报奖励审批列表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
  </head>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
	    	<div class="easyui-layout" data-options="fit:true,border:false">   
	            <div data-options="region:'center',split:true,title:'举报奖励审批列表',border:true" style="height:auto">
				<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>zdzxrwb/queryList',toolbar:'#datagridToolbar',
				            singleSelect:false,
				            selectOnCheck:true,checkOnSelect:true,border:false,sortOrder:'desc',sortName:'xt_zhxgsj',
				            	idField:'id',pageSize:getAutoPageSize(175),pageList:[getAutoPageSize(175),getAutoPageSize(175) * 2],
				            	onDblClickRow:dbClickRow
				            	">
					<thead>
					    <tr>
					        <th data-options="field:'rwmc',                 align:'center',	halign:'center'	,sortable:true">申请编号</th>
					        <th data-options="field:'rwzxff',	width:20,	align:'center',	halign:'center'	,sortable:true">线索编号</th>
					        <th data-options="field:'rwkssj',	width:20,	align:'center',	halign:'center'	,sortable:true">案件编号</th>
					        <th data-options="field:'jglx',		width:20,	align:'center',	halign:'center'	,sortable:true">管辖单位</th>
					        <th data-options="field:'sfjytg1', 	width:20,	align:'center',	halign:'center'	,sortable:true">申请时间</th>
					        <th data-options="field:'sfjytg', 	width:20,	align:'center',	halign:'center'	,sortable:true">审批状态</th>
					        <th data-options="field:'process',	width:30,   align:'center',	halign:'center',formatter:datagridProcessFormater">操作</th>
					    </tr>
					</thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" >
							<tbody>
								<tr>
									<td class="toolbarTd" style="width:580px">
										申请时间范围：<input class="easyui-validatebox" type="text" id="rwmc" name="rwmc" 
												data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
											onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" 
												style="width:160px"/>
										至&nbsp<input class="easyui-validatebox" type="text" id="rwmc" name="rwmc" 
											data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
											onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" 
											style="width:160px"/>
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										审批状态：<input class="easyui-validatebox" type="text" name="jglx" id="jglx" 
												data-options="required:false,validType:'maxLength[1]'"  
												style="width:160px;" />
									</td>
								</tr>
								<tr>
									<td class="toolbarTd" style="width:480px">
										&nbsp&nbsp&nbsp&nbsp线索编号：<input class="easyui-validatebox" type="text" name="sfjytg" id="sfjytg" 
												data-options="required:false,validType:'maxLength[1]'"  
												style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										申请编号：<input class="easyui-validatebox" type="text" name="jglx" id="jglx" 
												data-options="required:false,validType:'maxLength[1]'"  
												style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										案件编号：<input class="easyui-validatebox" type="text" name="rwzt" id="rwzt" 
												data-options="required:false,validType:'maxLength[1]'"  
												style="width:160px;" />
									</td>
								</tr>
								<tr>
									<td class="toolbarTd" align="right" colspan="7" style="padding-right:8px">
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >筛选</a>
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
    </script>
  	</body>
</html>
