<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>工作纪实查询</title>
</head>
<body class="easyui-layout" data-options="fit:true">
	
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'工作纪实列表',border:true" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/gzjs/queryList',
            		toolbar:'#datagridToolbar',
            		singleSelect:false,selectOnCheck:true,
            		checkOnSelect:true,border:false,
            		sortName:'id',sortOrder:'asc',
            		idField:'id',pageSize:getAutoPageSize(),
            		pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				        	 <th data-options="field:'gzjszldm',width:25,align:'left',sortable:true,halign:'center'">工作纪实种类</th>
				        	 <th data-options="field:'gzjshbsj',width:25,align:'left',sortable:true,halign:'center'">汇报时间</th>
				        	 <th data-options="field:'gzjshbdd',width:25,align:'left',sortable:true,halign:'center'">汇报地点</th>
				            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:80px;width:100%" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" width="1000">
							<tbody>
							<tr>
									<td class="toolbarTd" style="width:400px">
										工作纪实种类：<input type="text" id="gzjszldm" name="gzjszldm" class="easyui-combobox " style="width:200px;"
										data-options="required:false,url: contextPath + '/common/dict/D_ZAFF_GZJSZL.js',valueField:'id',textField:'text',
										tipPosition:'right',selectOnNavigation:false,method:'get'" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:400px">
										    汇报时间：<input type="text" id="gzjshbsj" name="gzjshbsj" class="easyui-validatebox" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" 
											 data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" style="width:200px"/> 
										  
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:400px">
										汇报地点：<input type="text" name="gzjshbdd" id ="gzjshbdd" class="easyui-validatebox" data-options="required:false,validType:'maxLength[100]'" 
										style="width:200px" maxlength="100" />
									</td>
								</tr>
								<tr>
									<td class="toolbarTd" align="right" colspan="7" style="padding-right:8px">
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
										<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="gzjsAdd(this);">新增</a>
								
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
        </div>
    </div>   
</body>
<script type="text/javascript">

var addId = '';//弹出新增工作纪实窗口的工作纪实id
var isAddSubmited = false;//弹出新增工作纪实窗口的提交标识

function processFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">查看</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">注销</a>&nbsp;';
}

function clearCase(){
	  $("#queryForm").form("reset");
}

function addCloseSubmit(){
	//jQuery.extend($('#addWindow').window('options'), {
	$('#addWindow').window({
		onClose:function(){
			$(this).dialog('destroy');
			//alert(addId + '|' + isAddSubmited);
			if(!isAddSubmited){//未保存情况下的关闭，清空已保存的附件
				$.ajax({
					url:"<%= basePath%>gzjs/deleteWithCancel?gzjsid="+addId
				});
			}else{
				isAddSubmited = false;//重置工作纪实的提交标识
			}
			addId = '';//重置工作纪实的工作纪实id
		}
	});
}

function gzjsAdd(obj){
	var editUrl = contextPath + '/gzjs/addGzjsxxb';
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	datagridAdd(obj, 'addWindow', {sqid:'111', sqjwsid:'111'}, {
		title : '工作纪实',
		url : editUrl,
		width : 850,
		height : 650
	}, '您是否要保存数据？');
}
// 修改单条
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = contextPath + '/gzjs/addGzjsxxb';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	datagridEdit(datagrid_ID, 'editWindow', {sqid:'111', sqjwsid:'111'}, {
		title : '工作纪实',
		url : editUrl,
		maximizable : true,
		width : 850,
		height : 650
	}, '您是否要保存数据？');
}
//查询按钮
function queryButton() {
	var gzjszldm = document.getElementById("gzjszldm").value;
	var gzjshbsj = document.getElementById("gzjshbsj").value;
	var gzjshbdd = document.getElementById("gzjshbdd").value;
	$('#dg').datagrid('reload', {
		'gzjszldm' : gzjszldm,
		'gzjshbsj' : gzjshbsj,
		'gzjshbdd' : gzjshbdd
	});
}
//注销单条
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/gzjs/delete';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var submitFields = ""; //  除主键之外需要提交的字段（多个用逗号分隔）
	topMessager.confirm('', '您确认要注销数据吗？', function(r) {
		if (r) {
			var opts = $('#' + datagrid_ID).datagrid("options");
			var rows = $('#' + datagrid_ID).datagrid('getData');
			var rowData = rows.rows[index];
			var postFieldArray = [];
			postFieldArray.push(opts.idField);
			if (submitFields != "") {
				postFieldArray = postFieldArray.concat(submitFields
						.split(","));
			}
			var postData = {};
			for ( var i = 0; i < postFieldArray.length; i++) {
				var postField = postFieldArray[i];
				if (rowData[postField]) {
					postData[postField] = rowData[postField];
				}
			}
			$.ajax( {
				url : deleteUrl,
				type : 'POST',
				data : postData
			}).done( function(result) {
				doSubmitResult(result, null, datagrid_ID);
			});
		}
	});
}
</script>  

</html>

