<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userId = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userId = userInfo.getUserId();
        bjzbz = userInfo.getBjzbz();
        
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>基本线索列表</title>
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
			<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>xsjbxxb/queryAll',toolbar:'#datagridToolbar',
			            singleSelect:false,
			            selectOnCheck:true,checkOnSelect:true,border:false,sortOrder:'desc',sortName:'xt_zhxgsj',
			            	idField:'id',pageSize:getAutoPageSize(175),pageList:[getAutoPageSize(175),getAutoPageSize(175) * 2],
			            	onDblClickRow:dbClickRow
			            	">
			  <!-- 查询结果模块 -->
			    <thead>
			        <tr>
			       	 	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
			       	 	<th data-options="field:'id',     width:20,   align:'center',	halign:'center'	,sortable:true">线索编号</th>
				        <th data-options="field:'jbsj',     width:20,   align:'center',	halign:'center'	,sortable:true">受理日期</th>
				        <th data-options="field:'ccjg',		width:20,	align:'center',	halign:'center'	,sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_DCJG.js'">初查结果</th>
				        <th data-options="field:'fcjg',		width:20,	align:'center',	halign:'center'	,sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_DCJG.js'">复查结果</th>
				        <th data-options="field:'xslx',		width:20,	align:'center',	halign:'center'	,sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XSLX.js'">线索类型</th>
				        <th data-options="field:'jbxxxz',	width:20,	align:'center',	halign:'center'	,sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_AJLB.js'">信息性质</th>
				        <th data-options="field:'xszt', 	width:20,	align:'center',	halign:'center'	,sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XSZT.js'">线索状态</th>
				        <th data-options="field:'process',	width:5,   align:'left',	halign:'center',formatter:datagridProcessFormater">操作</th>
			         </tr>
				</thead>
			</table>
			<!-- 查询条件模块 -->
			<div id="datagridToolbar" style="padding:5px;height:auto" >
					
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" >
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
									<td class="toolbarTd" style="width:280px">
										初查结果：<input class="easyui-combobox" type="text" name="ccjg" id="ccjg" 
											data-options="required:false,url: contextPath + '/common/dict/D_BZ_DCJG.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
											style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:250px">
										复查结果：<input class="easyui-combobox" type="text" name="fcjg" id="fcjg" 
											data-options="required:false,url: contextPath + '/common/dict/D_BZ_DCJG.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
											style="width:160px;" />
									</td>
								</tr>								
								<tr>
									<td class="toolbarTd" style="width:250px">
										信息性质：<input class="easyui-combobox" type="text" name="jbxxxz" id="jbxxxz" 
											data-options="required:false,url: contextPath + '/common/dict/D_BZ_AJLB.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
											style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:250px">
										线索类型：<input class="easyui-combobox" type="text" name="xslx" id="xslx" 
											data-options="required:false,url: contextPath + '/common/dict/D_BZ_XSLX.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
											style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:250px">
										线索状态：<input class="easyui-combobox" type="text" name="xszt" id="xszt" 
											data-options="required:false,url: contextPath + '/common/dict/D_BZ_XSZT.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
											style="width:160px;" />
									</td>
								</tr>
								<tr>
									<td class="toolbarTd" align="right" colspan="7" style="padding-right:8px">
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
										<a class="easyui-linkbutton" iconCls="icon-add" onclick="addNew();">新增</a>
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
		
	var Process = '';
	Process +='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="viewFq(this, '+index+')">查看</a>&nbsp;&nbsp;';
    return Process;
}
  
function clearCase(){
	  $("#queryForm").form("reset");
}

//查询按钮
function queryButton(){
  	var starttime = document.getElementById("starttime").value;
  	var endtime = document.getElementById("endtime").value;
  	var ccjg = document.getElementById("ccjg").value;
  	var fcjg = document.getElementById("fcjg").value;
  	var jbxxxz = document.getElementById("jbxxxz").value;
  	var xslx = document.getElementById("xslx").value;
  	var xszt = document.getElementById("xszt").value;

  	$('#dg').datagrid(
  			'reload',
  			{    'starttime':starttime,
  				'endtime':endtime,
  				'ccjg':ccjg,
  				'fcjg':fcjg,
  				'jbxxxz':jbxxxz,
  				'xslx':xslx,
  				'xszt':xszt
  			});
  }
 
function dbClickRow(rowIndex,rowData){
	
	var hsUrl = "/xsjbxxb/openAdd?";
	hsUrl+="id="+rowData.id+"&mainTabID="+getMainTabID();
	//mainTabID=1
	menu_open("编辑线索",hsUrl);
}

function addNew(){
	var hsUrl = "/xsjbxxb/openAdd?";
	hsUrl+="&mainTabID="+getMainTabID();
	//mainTabID=1
	menu_open("新增线索",hsUrl);
}

function reloadDg(){
	$("#dg").datagrid("clearSelections");
	$('#dg').datagrid('reload');
}

//废弃查看
function viewFq(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var hsUrl = "/xsjbxxb/openXsck?";
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	
	hsUrl+="xsbh="+rowData.id+"&mainTabID="+getMainTabID();
	//mainTabID=1
	menu_open("查看详细",hsUrl);
}

    </script>
  </body>
</html>
