<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   	<title>实有单位小区管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
</head>
<script type="text/javascript" src="<%=contextPath%>/js/sydw/sydwXqxxList.js"></script>
<body class="easyui-layout" data-options="fit:true">
   	<div data-options="region:'center',border:false">
  	<div class="easyui-layout" data-options="fit:true,border:false">   
	    <div data-options="region:'center',split:true,title:'小区列表',border:true" style="height:auto">
			<table id="dg" class="easyui-datagrid" 
				data-options="url:'<%=basePath %>dwxqjbxxb/queryDwXq',
				delayCountUrl:'<%=basePath %>dwxqjbxxb/queryCountDwXq',
				onLoadSuccess:function(data){ beforeTableLoad(data,'dg');},
				toolbar:'#datagridToolbar',
				singleSelect:false,
				selectOnCheck:true,
				checkOnSelect:true,
				border:false,
			    idField:'id',
			    pageSize:getAutoPageSize(),
			    pageList:[getAutoPageSize(),
			    getAutoPageSize() * 2]">
			    <thead>
			        <tr>
			            <th data-options="field:'xqmc',width:10,	align:'center',	halign:'center',sortable:true">小区名称</th>
			            <th data-options="field:'xqfzr',width:10,	align:'center',	halign:'center',sortable:true">小区负责人</th>
			            <th data-options="field:'wymc', width:10,	align:'center',	halign:'center',sortable:true">物业名称</th>
			            <th data-options="field:'wylxdh', width:10,	align:'center',	halign:'center',sortable:true">物业联系电话</th>
			            <th data-options="field:'process',width:10,  align:'center',	halign:'center',	formatter:dataXqFormater">操作</th>
			        </tr>
			    </thead>
			</table>
			<div id="datagridToolbar" style="padding:5px;height:auto;">
				<!-- 表格工具条按钮 -->
				<form id="queryForm">
					<table cellspacing="0" cellpadding="0" border="0">
						<tbody>
							<tr>
							<td class="toolbarTd" align="right">小区名称 ：
									<input type="text" name="xqmc" id ="xqmc" class="easyui-validatebox" 
									data-options="required:false,validType:'maxLength[20]'"/>
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" align="right">物业名称 ：
									<input type="text" name="wymc" id ="wymc" class="easyui-validatebox" 
									data-options="required:false,validType:'maxLength[20]'"/>
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd">
									<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" style="margin-right: 10px;">查询</a>
									<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();">重置</a>
									<a class="easyui-linkbutton" iconCls="icon-add"  onclick="xqAdd();">新增</a>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>

<div id="win" class="easyui-window" title="小区注销" style="width:700px;height:200px"   
      data-options="iconCls:'icon-save',modal:true,closed:true,collapsible:false,minimizable:false, maximizable:false"> 
      <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
      	<tr>
      		<td align="center"> 
	      		<input type="hidden" id ="id" value="">
	       		<textarea id="xt_zxyy"  onblur="if(value==''){value='请输入注销原因...';}" onfocus="if(value=='请输入注销原因...'){value='';}" title="添加注销原因"
	       			class="easyui-validatebox" style="width: 613px; height:78px;"
					data-options="validType:['maxLength[100]'],invalidMessage:'注销原因不能超过100个汉字，请重新输入！',tipPosition:'left'">请输入注销原因...</textarea>
      		</td>
      	</tr>
      	<tr>
      		<td align="right">
      			<a class="easyui-linkbutton" iconCls="icon-ok" onclick="updatexq();">确定</a>
				<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow();">关闭</a>
	       	</td>
	   	</tr>
   	</table>
</div> 
</body>
</html>
