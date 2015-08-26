<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>部门分配人员</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/orgOrgAssignUser/orgAssignQueryList',toolbar:'#datagridToolbar',
            		singleSelect:false,selectOnCheck:true,checkOnSelect:true,border:false,sortName:'userid',sortOrder:'asc',
            		idField:'id',pageSize:10,pageList:[10,20]">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				            <th data-options="field:'userid',width:30,align:'center',halign:'center',sortable:true">人员帐号</th>
				            <th data-options="field:'username',width:30,align:'center',halign:'center',sortable:true">人员姓名</th>
				            <th data-options="field:'identitycard',width:30,align:'center',halign:'center',sortable:true">身份证号码</th>
				            <th data-options="field:'industrialid',width:20,align:'center',halign:'center',sortable:true">行业号码</th>
				            <th data-options="field:'sex',width:20,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js'">性别</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto">
					<!-- 表格工具条按钮 -->
					<table cellspacing="0" cellpadding="0" border="0" width="100%">
					<tbody>
					<tr>
						<td class="toolbarTd">
					    	<table cellspacing="0" cellpadding="0" border="0" width="100%">
					    	<tr class="dialogTr">
		    					<td width="10%" class="dialogTd" align="right">人员帐号：</td>
		    					<td width="25%" class="dialogTd"><input class="easyui-validatebox" type="text" id="userid" style="width:200px;"/></td>
		    					<td width="10%" class="dialogTd">（模糊查询）</td>
		    					<td width="10%" class="dialogTd" align="right">人员姓名：</td>
		    					<td width="25%" class="dialogTd"><input class="easyui-validatebox" type="text" id="username" style="width:200px;"/></td>
		    					<td width="10%" class="dialogTd">（模糊查询）</td>
					    		<td width="10%"><a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-query" plain="true" onclick="datagridQuery(this)">查询</a></td>
					    	</tr>
					    	</table>
					</tr>
					</tbody>
					</table>
				</div>
			</div>
        </div>
    </div>
    
    <div style="display:none;">
    <form action="<%=basePath%>orgOrgAssignUser/assignSave" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="orgid" value="${entity.id}"/>
    	<input type="hidden" name="orgtype" value="${entity.orgtype}"/>
    	<input type="hidden" name="assignUserID" id="assignUserID" />
    	<input type="hidden" name="assignUserName" id="assignUserName" />
    </form>
    </div>
</body>

<script type="text/javascript">

function doInit(paramArray) {
}

function beforeSubmit() {
	var datagrid_ID = "dg";
	var selections = $('#' + datagrid_ID).datagrid('getSelections');
	if (selections.length == 0) {
		topMessagerAlert('', '请选择要分配的人员！');
		return false;
	}
	var returnIDArray = [];
	var returnNameArray = [];
	for (var i = 0; i < selections.length; i++) {
		returnIDArray.push(selections[i]['id']);
		returnNameArray.push(selections[i]['username']);
	}
	$('#assignUserID').val(returnIDArray.join(","));
	$('#assignUserName').val(returnNameArray.join(","));
	return true;
}

function afterSubmit(submitData) {
}

function datagridQuery(toolbarButton) {
	var datagrid_ID = getDatagrid_ID(1, toolbarButton);
	var data = {};
	data['userid'] = $('#userid').val();
	data['username'] = $('#username').val();
	$('#' + datagrid_ID).datagrid('load', data);	
}

</script>

</html>