<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        bjzbz = userInfo.getBjzbz();
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script type="text/javascript" src="<%=contextPath%>/js/syfw/syfwManage.js"></script>
<script type="text/javascript">
var userOrgCode = "<%=userOrgCode%>"; 
var bjzbz = "<%=bjzbz%>";
</script>
<style type="text/css">
    	.infoTable{font-size: 15px;font-family: Microsoft YaHei;text-align: left;}
    	.infoTable1{font-size: 16px;font-family: Microsoft YaHei;text-align: left;}
</style>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'west',border:false" style="width:538px;">
		<!-- 地址管理列表 -->
		<table id="dg" class="easyui-datagrid"
			data-options="url:'<%=contextPath%>/syfw/list',
						onLoadSuccess:function(data){SyfwManager.loadPoint(data,'dg');},
						queryParams:{sfczfw:'${sfczfw}'},
						selectOnCheck:true,
		        		checkOnSelect:true,
		        		rownumbers:true,
		        		border:false,
		        		sortName:'',
		        		sortOrder:'desc',
		        		pageSize:getAutoPageSize(105),
		        		pageList:[getAutoPageSize(105),
		        		getAutoPageSize(105) * 2],
		        		singleSelect:true,
		        		fitColumns:true,
						toolbar:'#datagridToolbar',
						onClickRow:SyfwManager.onClickRow">
			<thead>
				<tr>
					<th data-options="field:'fwlbdm',width:70,align:'left',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/ZA_D_FWLBDM.js'">房屋类别</th>
					<th data-options="field:'fwdz_dzxz',width:200,align:'right',halign:'center',formatter:subjzdz,sortable:true">房屋地址</th>
					<th data-options="field:'fz_xm',width:70,align:'center',halign:'center',sortable:true">房主</th>
					<th data-options="field:'sfczfw',width:70,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_SF.js'">出租房屋</th>
					<th data-options="field:'process',width:100,align:'center',halign:'center',formatter:SyfwManager.datagridProcessFormater">操作</th>
				</tr>
			</thead>
		</table>
		<!-- 查询条件 -->
		<div id="datagridToolbar" style="padding:5px;height:auto;">
			<table cellspacing="0" cellpadding="0" border="0">
				<tbody>
					<tr class="dialogTr">
						<td class="dialogTd" style="width:340px;" align="right"><input
							type="text" name="condition" id="condition"
							class="easyui-searchbox" 
							data-options="required:false,prompt:'请输入房屋地址,房主信息',validType:'maxLength[20]',searcher:SyfwManager.queryButton"
							style="width:340px;" /></td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div>
						</td>
						<td class="toolbarTd" align="center">
							<a href="javascript:void(0)" class="easyui-linkbutton"
							iconCls="icon-search" onclick="detailSearch()">精确查询</a>
							<a id="dzaddid" class="easyui-linkbutton" iconCls="icon-add"
							onclick="SyfwManager.add();">新增</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div id="win" class="easyui-window" title="实有房屋精确查询"
		style="width:400px;height:300px;top:20px;display:none;"
		data-options="iconCls:'icon-search',collapsible:false,
        minimizable:false,maximizable:false,
        modal:true,
        closed:true,
        top:100,
        width:400,
        height:280,
        left:50">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'left'">
				<form id="queryForm">
					<table border="0" cellpadding="0" cellspacing="10" width="100%"
						height="100%" align="center">
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">房主姓名：</td>
							<td width="70%" class="dialogTd"><input
								class="easyui-validatebox" type="text" id="fz_xm" name="fz_xm"
								style="width:150px;" /></td>
						</tr>
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">房屋类别：</td>
							<td width="70%" class="dialogTd"><input
								class="easyui-combobox" type="text" id="fwlbdm" name="fwlbdm"
								style="width:150px;"
								data-options="url: contextPath + '/common/dict/ZA_D_FWLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" />
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">房屋地址：</td>
							<td width="70%" class="dialogTd"><input type="text"
								name="fwdz_dzxz" id="fwdz_dzxz" class="easyui-validatebox"
								data-options="required:false,validType:'maxLength[50]'"
								style="width:150px;" />
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">是否出租房：</td>
							<td width="70%" class="dialogTd"><input
								class="easyui-combobox" type="text" id="sfczfw" name="sfczfw"
								style="width:150px;"
								data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" />
							</td>
						</tr>
						<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
							<td width="100%" colspan="2" align="right"><a
								class="easyui-linkbutton" iconCls="icon-ok"
								onclick="queryButton();">确定</a> <a class="easyui-linkbutton"
								iconCls="icon-reset" onclick="resetButton()">重置</a> <a
								class="easyui-linkbutton" iconCls="icon-cancel"
								onclick="closeWindow();">关闭</a></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		 <div id="cancel_1" class="easyui-window" data-options="iconCls:'icon-user',
                collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:460,height:180">
		        <form action="<%=basePath%>syfw/" id="cancelform_1" name="cancelform_1" method="post">
		            <input type="hidden" id="main_id" name="id" />
		            <input type="hidden"   name="_method" value="delete" />
			        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">注销原因：</td>
					    	<td width="70%" class="dialogTd" colspan="2">
					            <textarea id="xt_zxyy" name="xt_zxyy" class="easyui-validatebox" style="width: 300px; height:78px;overflow: auto;" data-options="validType:['maxLength[100]'],required:true,invalidMessage:'注销原因不能超过100个汉字，请重新输入！',tipPosition:'left'"></textarea>
					        </td>
				    	</tr>
				    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td colspan="3" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="SyfwManager.cancelButton();">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow('cancel_1');">关闭</a>
					    	</td>
				    	</tr>
			         </table>
		        </form>
		   </div>
	</div>
	<div data-options="region:'center',border:false">
		<div id="mapDiv"></div>
		<div id="toolDiv"
			style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
	</div>
</body>
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
//精确查询
function detailSearch(){
	$("#win").show();
	$("#win").window("open"); 
}
//----精确查询框方法---------
function closeWindow(id){
	if(id)
		$("#"+id).window("close"); 
	else
		$("#win").window("close"); 
}
function setDzqc(obj){
	   obj.value="";
}
//查询按钮
function queryButton(){
	var fz_xm = document.getElementById("fz_xm").value;
	var fwlbdm = document.getElementById("fwlbdm").value;
	var fwdz_dzxz = document.getElementById("fwdz_dzxz").value;
	var sfczfw = document.getElementById("sfczfw").value;
	$('#dg').datagrid(
			'load',
			{    
				'fz_xm':fz_xm,				  
				'fwlbdm': fwlbdm ,
				'fwdz_dzxz':fwdz_dzxz,
				'sfczfw':sfczfw
			});
	closeWindow("win");
}
//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}
</script>
</html>