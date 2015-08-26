<!--  
	@Author: [yuguangli@founder.com]
	@CreateDate:   [2015-6-6 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单位检查项管理</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/dwjctemp/queryDwjcdata',toolbar:'#datagridToolbar',
            		singleSelect:false,selectOnCheck:true,checkOnSelect:true,sortName:'px',sortOrder:'asc',border:false,fitColumns:true,
            		idField:'id',pageSize:10,pageList:[10,20],queryParams: {typeid: '${typeid}'}">
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				            <th data-options="field:'name',width:35,align:'left',halign:'center'">检查内容</th>
				            <th data-options="field:'def',width:7,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_GG_SF.js'">默认值</th>
				            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto">
					<!-- 表格工具条按钮 -->
					<table cellspacing="0" cellpadding="0" border="0">
						<tbody>
							<tr>
								<td>
							    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="datagridAdd(this, 'addWindow', 
							    		null,
							    		{
							    		title: '检查项新增',
							    		url: contextPath + '/forward/sydw|dwjcdataAdd?typeid=${typeid}',
							    		width: 700,
							    		height: 300
							    		},
		   								''
							    		)">添加</a>
								</td>
								<td class="toolbarTd">
							    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="datagridDeletePatch(this, '', 
							    		'',
							    		{
							    		url: contextPath + '/dwjctemp/deletePatchDwjcdata'
							    		})">批量删除</a>
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd">
									<table cellspacing="0" cellpadding="0" border="0">
										<tbody>
											<tr class="dialogTr">
												<td width="80" class="dialogTd" align="right">检查项内容：</td>
												<td width="150" class="dialogTd">
													<input class="easyui-validatebox" type="text" id="name" style="width:150px;"/>
												</td>
						    					<td width="80" class="dialogTd">（模糊查询）</td>
												<td width="60" class="dialogTd" align="right">默认值：</td>
												<td width="120" class="dialogTd">
													<input class="easyui-combobox" type="text" id="def" style="width:120px;"
														data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
								<td class="toolbarTd">
							    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-query" plain="true" onclick="queryButton()">查询</a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
        </div>
    </div>   
</body>
<script type="text/javascript">

function processFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this, '+index+')">编辑</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">删除</a>&nbsp;';
}

// 修改单条
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = contextPath + '/dwjctemp/editDwjcdata';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	datagridEdit(datagrid_ID, 'editWindow', 
   		null,
  		{
   		title: '检查项修改',
   		url: editUrl,
   		width: 700,
		height: 300
   		},
   		''
   	);
}

// 删除单条
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/dwjctemp/deleteDwjcdata';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var submitFields = ""; //  除主键之外需要提交的字段（多个用逗号分隔）
	topMessager.confirm('','您确认要删除数据吗？',function(r) {    
		if (r) {	
			var opts = $('#' + datagrid_ID).datagrid("options");
			var rows = $('#' + datagrid_ID).datagrid('getData');
			var rowData = rows.rows[index];
			var postFieldArray = [];
			postFieldArray.push(opts.idField);
			if (submitFields != "") {
				postFieldArray = postFieldArray.concat(submitFields.split(","));
			}
			var postData = {};
			for (var i = 0; i < postFieldArray.length; i++) {
				var postField = postFieldArray[i];
				if (rowData[postField]) {
					postData[postField] = rowData[postField];
				}
			}
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: postData
			}).done(function(result) {
				doSubmitResult(result, null, datagrid_ID);
			});
		}
	});
}

function queryButton() {
	var data = {};
	data['typeid'] = '${typeid}';
	data['name'] = $('#name').val();
	data['def'] = $('#def').combobox("getValue");
	$('#dg').datagrid('load', data);	
}

</script>  

</html>