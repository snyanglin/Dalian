<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>法人/负责人列表</title>
  </head>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'法人/负责人列表',border:false" style="height:auto">
			<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>shhxxcj/queryFrfzrList?enterpriseid=${ementerpriseid}',
			            method:'POST',
						selectOnCheck:true,
		        		checkOnSelect:true,
		        		rownumbers:true,
		        		border:false,
		        		pageSize:'20',
		        		pageList:['20','40'],
		        		singleSelect:false,
		        		fitColumns:true,
						toolbar:'#datagridToolbar'
			            	">
							    <thead>
							        <tr>
							        	<th data-options="field:'type',width:10,align:'center',	halign:'center'	,sortable:false">法人/负责人</th>							        
							         	<th data-options="field:'zjhm', width:15,	align:'center',	halign:'center',sortable:false">证件号码</th>							         
							            <th data-options="field:'xm', 	width:10,	align:'center',	halign:'center',sortable:false">姓名</th>
							           	<th data-options="field:'mz',width:10,align:'center',	halign:'center'	,sortable:false">民族</th>
							            <th data-options="field:'xb',width:10,	align:'center',	halign:'center',sortable:false">性别</th> 
							           	<th data-options="field:'lxdh',width:10,align:'center',	halign:'center'	,sortable:false">联系电话</th>
							           	<th data-options="field:'jtzz',width:30,align:'center',	halign:'center'	,sortable:false">家庭住址</th>
							           	<th data-options="field:'xdz',width:30,align:'center',	halign:'center'	,sortable:false">现住址</th>
						           	
							        </tr>
							    </thead>
							</table>
					<div id="datagridToolbar" style="padding:5px;height:70px;width:100%" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" width="1000">
							<tbody>
						
								<tr>
									<td class="toolbarTd" style="width:700px;font-size: 15" align="left">
										单位名称：<span style="font-size: 15">${enterpriseName}</span>
									
									</td>
							     </tr>
							     </br>
								<tr align="right">
									<td class="toolbarTd" style="width:1000px" align="right">
										姓名：<input type="text" name="xm" id ="xm" class="easyui-validatebox"
										style="width:150px"  />
								  &nbsp;
										证件号码：<input type="text" name="zjhm" id ="zjhm" class="easyui-validatebox"
										style="width:150px"  />
									</td>
								
								
									
									<td class="toolbarTd" style="width:200px" align="right">
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();">查询</a>
										&nbsp;
									    <a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();">重置</a>
									</td>
									
								</tr>
							
							</tbody>
						</table>
					</form>
				</div>
	</div>
	</div>
	</div>
	
	
<script language="javascript">

</script>	
<script type="text/javascript">



function clearCase(){
	  $("#queryForm").form("reset");
}


//查询按钮
function queryButton() {
		var xm = $("#xm").val();
		var zjhm = $("#zjhm").val();
	
		$('#dg').datagrid('reload', {
			'xm' : xm,
			'zjhm' : zjhm
		});
	
	
}



    </script>
  </body>
</html>
