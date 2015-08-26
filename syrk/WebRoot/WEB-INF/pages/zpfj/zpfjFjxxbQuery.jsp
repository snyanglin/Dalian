<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>照片附件管理</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/zpfjFjxxb/queryList',toolbar:'#datagridToolbar',rownumbers:true,
            		border:false,selectOnCheck:false,sortName:'xt_cjsj',sortOrder:'asc',idField:'id',pageSize:10,queryParams:{lybm:'${lybm}',lyid:'${lyid}'}">
				    <thead>
				        <tr>
				            <th data-options="field:'wjhzlx',width:10,align:'center',halign:'center',sortable:true">附件类型</th>
				            <th data-options="field:'wjmc',width:30,align:'left',halign:'center',sortable:true">附件名称</th>
				            <th data-options="field:'wjdx',width:10,align:'right',halign:'center',sortable:true">附件字节</th>
				            <th data-options="field:'wjdxsm',width:10,align:'center',halign:'center'">附件大小</th>
				            <th data-options="field:'wjxzcs',width:10,align:'center',halign:'center',sortable:true">下载次数</th>
				            <th data-options="field:'process',width:10,align:'center',halign:'center',formatter:processFormater">下载</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto">
					<!-- 表格工具条按钮 -->
					<table cellspacing="0" cellpadding="0" border="0">
					<tbody>
					<tr>
						<td align="center" width="80">附件名称：</td>
						<td align="left" width="210"><input class="easyui-validatebox" type="text" id="wjmc" style="width:200px;"/></td>
						<td class="toolbarTd">
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-query" plain="true" onclick="datagridQuery()">查询</a>
						</td>
					</tr>
					</tbody>
					</table>
				
			</div>
        </div>
    </div>   

    <div style="display:none;">
	    <form name="downloadform" id="downloadform" action="<%=basePath%>zpfjFjxxb/download" target="submitFrame" method="post">
	    <input type="hidden" name="id" id="downloadID"/>
	    </form>
	</div>
	<iframe name="submitFrame" id="submitFrame" src="" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" width="0" height="0" style="z_index: 60; display:none;"></iframe>
    
</body>

<script type="text/javascript">
	
function doInit(paramArray) {
}

function beforeSubmit() {
}

function afterSubmit() {
}

function successCloseWindow() {
}

function processFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this, '+index+')">下载</a>&nbsp;';
}

function datagridQuery() {
	var datagrid_ID = "dg";
	var opts = $('#' + datagrid_ID).datagrid("options");
	var queryParams = opts.queryParams;
	queryParams['wjmc'] = $('#wjmc').val();
	$('#' + datagrid_ID).datagrid('reload');
}

// 下载
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var idField = opts.idField;
	$('#downloadID').val(rowData[idField]);
	$('#downloadform').form('submit', {
		success: function(result) {
			if (result) {
				result = parseReturn(result);
				if (result.status == 'success') {
				}
				else {
					topMessager.alert('', result.message);
				}
			}
		}
	});
}

</script>  

</html>