<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%
	SessionBean userInfo = (SessionBean) session.getAttribute("userSession");
	String orgCode = userInfo.getUserOrgCode();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>线索征集列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body class="easyui-layout" data-options="fit:true">
  <div data-options="region:'center',border:false"  >
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'线索征集列表',border:true" style="height:auto">
            <table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>xszjxxb/xxQuery',toolbar:'#datagridToolbar',
			            singleSelect:false,
			            selectOnCheck:true,checkOnSelect:true,border:false,sortOrder:'desc',sortName:'xt_zhxgsj',
			            	idField:'id',pageSize:getAutoPageSize(175),pageList:[getAutoPageSize(175),getAutoPageSize(175) * 2],
			            	onDblClickRow:dbClickRow
			            	">
			  <!-- 查询结果模块 -->
			    <thead>
			        <tr>  
			       	 	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
			       	 	<th data-options="field:'id',     	width:20,   align:'center',	halign:'center'	,sortable:true">申请编号</th>
				        <th data-options="field:'sqsj',		width:20,	align:'center',	halign:'center'	,sortable:true">申请时间</th>
				        <th data-options="field:'sqdw',		width:20,	align:'center',	halign:'center'	,sortable:true,formatter:dictFormatter,dictName:'<%=basePath %>common/searchOrgListChildren?orgCode=<%=orgCode%>'">申请单位</th>
				        <th data-options="field:'ajxz',		width:20,	align:'center',	halign:'center'	,sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_AJLB.js'">案件性质</th>
				        <th data-options="field:'process',	width:22,   align:'center',	halign:'center',formatter:datagridProcessFormater">操作</th>
			         </tr>
				</thead>
			</table>
            <!-- 查询条件模块 -->
			<div id="datagridToolbar" style="padding:5px;height:auto" >
					
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0"  width="100%">
							<tbody>
								<tr>
									<td class="toolbarTd" style="width:250px">
									 	开始时间：<input class="easyui-validatebox" type="text" name="starttime" id="starttime" 
										data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
										onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" 
										style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:250px">
										结束时间：<input class="easyui-validatebox" type="text" name="endtime" id="endtime" 
											data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
											onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" 
											style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:250px">
										征集编号：<input class="easyui-validatebox" type="text" name="id" id="id" 
												data-options="required:false"  
												style="width:160px;" />
									</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" align="right" style="width:250px"></td>
								</tr>
								
								<tr>
								<td class="toolbarTd" style="width:250px">
									申请单位：<input class="easyui-combobox" type="text" name="sqdw" id="sqdw" 
										data-options="required:false,url: '<%=basePath %>common/myOrgPara?type=XSZJSQ',
			    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  	style="width:160px;" />
								</td>
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										案件性质：<input class="easyui-combobox" type="text" name="ajxz" id="ajxz" 
											data-options="required:false,url: contextPath + '/common/dict/D_BZ_AJLB.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
											style="width:160px;" />
									</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
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
  
function clearCase(){
	  $("#queryForm").form("reset");
}

//查询按钮
function queryButton(){
  	var starttime = document.getElementById("starttime").value;
  	var endtime = document.getElementById("endtime").value;
  	var id = document.getElementById("id").value;
  	var ajxz = document.getElementById("ajxz").value;
  	var sqdw = document.getElementById("sqdw").value;

  	$('#dg').datagrid(
  			'reload',
  			{    'starttime':starttime,
  				'endtime':endtime,
  				'id':id,
  				'ajxz':ajxz,
  				'sqdw':sqdw
  			});
  }
  
  //操作列
	function datagridProcessFormater(val, row, index) { // 自定义操作生成

	    	return  '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="viewDetail(this,'+index+')">查看详细</a>&nbsp;';
	}
  
function viewDetail(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = "/xszjxxb/xxOpenAdd?";
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		
		hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
		//mainTabID=1
		menu_open("查看详细 ",hsUrl);
  }
 
function dbClickRow(rowIndex,rowData){
	
	var hsUrl = "/xszjxxb/xxOpenAdd?";
	hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
	//mainTabID=1
	menu_open("查看详细 ",hsUrl);
}


function reloadDg(){
	$("#dg").datagrid("clearSelections");
	$('#dg').datagrid('reload');
}

  </script>
  </body>
</html>
