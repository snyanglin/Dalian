<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        bjzbz = userInfo.getBjzbz();
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>线索处理日志</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'线索处理日志',border:true" style="height:auto">
			<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>xscljlb/query',toolbar:'#datagridToolbar',
			            singleSelect:false,
			            selectOnCheck:true,checkOnSelect:true,border:false,sortOrder:'desc',sortName:'xt_zhxgsj',
			            	idField:'id',pageSize:getAutoPageSize(175),pageList:[getAutoPageSize(175),getAutoPageSize(175) * 2],
			            	onDblClickRow:dbClickRow
			            	">
			  <!-- 查询结果模块 -->
			    <thead>
			        <tr>
			       	 	<th data-options="field:'xsbh',     width:20,   align:'center',	halign:'center'	,sortable:true">线索编号</th>
				        <th data-options="field:'czlx',   	width:20,   align:'center',	halign:'center'	,sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_CZLX.js'">操作类型</th>
				        <th data-options="field:'xt_cjsj',  width:20,   align:'center',	halign:'center'	,sortable:true">操作时间</th>
				        <th data-options="field:'cznr',   	width:40,   align:'center',	halign:'center'	,sortable:true">操作内容</th>
				        
			         </tr>
				</thead>
			</table>
			<!-- 查询条件模块 -->
			<div id="datagridToolbar" style="padding:5px;height:auto" >
					
					<!-- 表格工具条按钮 -->
					<form id="queryForm" style="margin: 0px;">
						<table cellspacing="0" cellpadding="0" border="0" width="100%" >
							<tbody>
							<tr>
								<td class="toolbarTd" style="width:250px">
									线索编号：<input class="easyui-validatebox" type="text" name="xsbh" id="xsbh" 
											data-options="required:false"  style="width:160px;" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" style="width:250px">
									操作类型：<input class="easyui-combobox" type="text" name="czlx" id="czlx" 
										data-options="required:false,url: contextPath + '/common/dict/D_BZ_CZLX.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" 
										style="width:160px;" />
								</td>
								
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" style="width:250px">
									操作内容：<input class="easyui-validatebox" type="text" name="cznr" id="cznr" 
										data-options="required:false"  	style="width:160px;" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" style="width:250px">
									操作时间：<input class="easyui-validatebox" type="text" name="xt_cjsj" id="xt_cjsj" 
										data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" 
										onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"
										style="width:160px;" />
								</td>
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
		
	var Process = '<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">查看详细</a>';
	
    return Process;
}
  
function clearCase(){
	  $("#queryForm").form("reset");
}

//查询按钮
function queryButton(){

	var xsbh = document.getElementById("xsbh").value;
  	var czlx = document.getElementById("czlx").value;
  	var cznr = document.getElementById("cznr").value;
  	var xt_cjsj = document.getElementById("xt_cjsj").value;
  	
	xsbh = $.trim(xsbh);
	cznr = $.trim(cznr);
	
  	$('#dg').datagrid(
  			'reload',
  			{   'xsbh':xsbh,
  				'czlx':czlx,
  				'cznr':cznr,
  				'xt_cjsj':xt_cjsj
  			});
  }
  
function doEdit(linkObject, index){
	
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
  }
 
//暂停
// SYS_SYRK_11.	把自动执行任务表的任务状态修改为1，同时把操作里面暂停调整为“启动”
function doStop(linkObject,index){
	
}

//注销单条
function doDelete(linkObject, index) {
	
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
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
