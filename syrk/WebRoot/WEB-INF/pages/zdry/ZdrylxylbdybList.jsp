<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>重点人员类型与类别对应管理</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'重点人员类型与类别对应管理',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>zdrylxylbdyb/queryList',
            		delayCountUrl:'<%=basePath %>zdrylxylbdyb/queryCount',
            		toolbar:'#datagridToolbar',
            		singleSelect:false,selectOnCheck:true,checkOnSelect:true,border:false,sortName:'zdrylxdm',sortOrder:'asc',fitColumns:true,
            		idField:'id',pageSize:getAutoPageSize(),pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				            <th data-options="field:'zdrylxdm',width:20,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_ZDRYLBDM.js'">重点人员类型</th>
				            <th data-options="field:'zdrylbdm',width:60,align:'left',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/DL_D_ZDRYLBDM.js'">重点人员类别</th>
				            <th data-options="field:'process1',width:15,align:'center',halign:'center',formatter:processFormater1">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto">
					<!-- 表格工具条按钮 -->
					<table cellspacing="0" cellpadding="0" border="0">
					<tbody>
					<tr>
						<td class="toolbarTd">
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-query" plain="true" onclick="datagridQuery(this, 'queryWindow', 
					    		null,
					    		{
					    		title: '重点人员类型与类别对应管理查询条件',
					    		url: contextPath + '/zdrylxylbdyb/queryCondition',
					    		width: 850,
					    		height: 320
					    		})">查询</a>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td>
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="datagridAdd(this, 'addWindow', 
					    		null,
					    		{
					    		title: '重点人员类型与类别配置新增',
					    		url: contextPath + '/zdrylxylbdyb/add',
					    		width: 850,
					    		height: 320
					    		},
   								'您是否要保存数据？'
					    		)">添加</a>
						</td>
						<td class="toolbarTd">
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="datagridDeletePatch(this, '', 
					    		'zdrylxdm,zdrylbdm',
					    		{
					    		url: contextPath + '/zdrylxylbdyb/deletePatch'
					    		})">批量解除关系</a>
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

function processFormater1(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this, '+index+')">编辑</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">解除关系</a>&nbsp;';
}



// 行单击
function doOnClickRow(rowIndex, rowData) {
	var editUrl = contextPath + '/zdrylxylbdyb/edit';
	var opts = $(this).datagrid('options');
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	datagridEdit(opts.id, 'editWindow', 
   		null,
  		{
   		title: '重点人员类型与类别配置修改',
   		url: editUrl,
   		width: 850,
   		height: 320
   		}
   	);
}

// 修改单条
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = contextPath + '/zdrylxylbdyb/edit';
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
   		title: '重点人员类型与类别对应管理修改',
   		url: editUrl,
   		width: 850,
   		height: 320
   		},
   		'您是否要保存数据？'
   	);
}

// 删除单条
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/zdrylxylbdyb/delete';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var submitFields = "zdrylxdm,zdrylbdm"; //  除主键之外需要提交的字段（多个用逗号分隔）
	topMessager.confirm('','您确认要解除关系吗？',function(r) {    
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
// datagrid 新增（默认在本页面中弹出，不缓存页面）
// paramArray    传入打开页面的参数（如：{document:document, param1: 'test1', param2: 2}）
// dataOptions   jquery.window中的data-options定义参数
// submitConfirm 提交确认提示信息（为空则不出现确认框）
function datagridAdd(toolbarButton, windowID, paramArray, dataOptions, submitConfirm) {
	if (!dataOptions.url) {
		topMessagerAlert('', '弹出层缺少 url 参数！');
		return;
	}
	var datagrid_ID = getDatagrid_ID(1, toolbarButton);
	dataOptions.datagrid_ID = datagrid_ID;
	if (!dataOptions.title) {
		dataOptions.title = '新增';
	}
	dataOptions.title = '&nbsp;' + dataOptions.title;
	if (!dataOptions.width) {
		dataOptions.width = 850;
	}
	if (!dataOptions.height) {
		dataOptions.height = 420;
	}
	if (!windowID) {
		windowID = "addWindow";
	}
	dataOptions.collapsible = dataOptions.collapsible ? dataOptions.collapsible : false;
	dataOptions.minimizable = dataOptions.minimizable ? dataOptions.minimizable : false;
	dataOptions.maximizable = dataOptions.maximizable ? dataOptions.maximizable : false; // 是否最大化图标
	dataOptions.closable = true;
	dataOptions.closed = false;   
	dataOptions.cache = false;
	dataOptions.inline = false;
	dataOptions.modal = true;
	dataOptions.buttons = [
		{
			text: '保存',
			iconCls: 'icon-save',
			handler: function() {
				var bottonObject = this;
				if (buttonDisabled(bottonObject) == false) {
					return false;
				}
				var iframeObject = window.frames[windowID + '_iframe'];
				if (iframeObject.contentWindow) {
					iframeObject = iframeObject.contentWindow;
				}
				var formObject = iframeObject.$('form').first();
				if (formObject) {
					checkComboIsClosed(iframeObject, formObject); // 提交之前强行校验下拉框的是否关闭
					if (formObject.form('validate')) { // 表单的验证
						if (iframeObject.beforeSubmit && typeof(iframeObject.beforeSubmit) == 'function') { // 执行自定义方法 beforeSubmit
							if (iframeObject.beforeSubmit() == false) {
								buttonEnabled(bottonObject);
								return false;
							}
							else {
								if (submitConfirm) {
									var confirm=iframeObject.getconfirm();
									topMessager.confirm('', confirm, function(r) {
										if (r) {
											formObject.form('submit',{
												dataType : 'json',
												onSubmit: function() {
												},
												success: function(result) {
													buttonEnabled(bottonObject);
													result = parseReturn(result);
													if (result.status == 'success') { // 返回成功后执行的方法
														if (iframeObject.afterSubmit && typeof(iframeObject.afterSubmit) == 'function') { // 执行自定义方法afterSubmit
															iframeObject.afterSubmit(result);
														}
													}
													if (iframeObject.successCloseWindow && typeof(iframeObject.successCloseWindow) == 'function') { // 执行自定义方法successCloseWindow，返回true关闭窗口
														if (!iframeObject.successCloseWindow(result)) {
															doSubmitResult(result, null, datagrid_ID);
															return;
														}
													}
													doSubmitResult(result, windowID, datagrid_ID);
												}
											});
										}
										else {
											buttonEnabled(bottonObject);
										}
									}); 
								}
								else {
									formObject.form('submit',{
										dataType : 'json',
										onSubmit: function() {
										},
										success: function(result) {
											buttonEnabled(bottonObject);
											result = parseReturn(result);
											if (result.status == 'success') { // 返回成功后执行的方法
												if (iframeObject.afterSubmit && typeof(iframeObject.afterSubmit) == 'function') { // 执行自定义方法afterSubmit
													iframeObject.afterSubmit(result);
												}
											}
											if (iframeObject.successCloseWindow && typeof(iframeObject.successCloseWindow) == 'function') { // 执行自定义方法successCloseWindow，返回true关闭窗口
												if (!iframeObject.successCloseWindow(result)) {
													doSubmitResult(result, null, datagrid_ID);
													return;
												}
											}
											doSubmitResult(result, windowID, datagrid_ID);
										}
									});
								}
							}
						}	
					}
					else {
						buttonEnabled(bottonObject);
						if (iframeObject.validateError && typeof(iframeObject.validateError) == 'function') { // 执行自定义方法validateError，验校错误时执行
							iframeObject.validateError();
						}
					}
				}
			}
		},
		{
			text: '重置',
			iconCls: 'icon-reset',
			handler: function() {
				var iframeObject = window.frames[windowID + '_iframe'];
				if (iframeObject.contentWindow) {
					iframeObject = iframeObject.contentWindow;
				}
				iframeObject.resetForm();
			}
		},
		{
			text: '关闭',
			iconCls: 'icon-cancel',
			handler: function() {
				$('#' + windowID).dialog('close');
			}
		}
	];
	openWindow(false, windowID, dataOptions.url, paramArray, dataOptions);
}
// datagrid 修改（默认在本页面中弹出，不缓存页面）
// paramArray    可以传入参数（如：{document:document, param1: 'test1', param2: 2}）
// dataOptions   jquery.window中的data-options定义参数
// submitConfirm 提交确认提示信息（为空则不出现确认框）
function datagridEdit(datagrid_ID, windowID, paramArray, dataOptions, submitConfirm) {
	if (!dataOptions.url) {
		topMessagerAlert('', '弹出层缺少 url 参数！');
		return;
	}
	dataOptions.datagrid_ID = datagrid_ID;
	if (!dataOptions.title) {
		dataOptions.title = '修改';
	}
	dataOptions.title = '&nbsp;' + dataOptions.title;
	if (!dataOptions.width) {
		dataOptions.width = 850;
	}
	if (!dataOptions.height) {
		dataOptions.height = 420;
	}
	if (!windowID) {
		windowID = "editWindow";
	}
	dataOptions.collapsible = dataOptions.collapsible ? dataOptions.collapsible : false;
	dataOptions.minimizable = dataOptions.minimizable ? dataOptions.minimizable : false;
	dataOptions.maximizable = dataOptions.maximizable ? dataOptions.maximizable : false; // 是否最大化图标
	dataOptions.closable = true;
	dataOptions.closed = false;   
	dataOptions.cache = false;
	dataOptions.inline = false;
	dataOptions.modal = true;
	dataOptions.buttons = [
		{
			text: '保存',
			iconCls: 'icon-save',
			handler: function() {
				var bottonObject = this;
				if (buttonDisabled(bottonObject) == false) {
					return false;
				}
				var iframeObject = window.frames[windowID + '_iframe'];
				if (iframeObject.contentWindow) {
					iframeObject = iframeObject.contentWindow;
				}
				var formObject = iframeObject.$('form').first();
				if (formObject) {
					checkComboIsClosed(iframeObject, formObject); // 提交之前强行校验下拉框的是否关闭
					if (formObject.form('validate')) { // 表单的验证
						if (iframeObject.beforeSubmit && typeof(iframeObject.beforeSubmit) == 'function') { // 执行自定义方法beforeSubmit
							if (iframeObject.beforeSubmit() == false) {
								buttonEnabled(bottonObject);
								return false;
							}
							else {
								if (submitConfirm) {
									var Confirm=iframeObject.getsubmitConfirm();
									topMessager.confirm('', Confirm, function(r) {
										if (r) {
											formObject.form('submit',{
												dataType : 'json',
												onSubmit: function() {
												},
												success: function(result) {
													buttonEnabled(bottonObject);
													result = parseReturn(result);
													if (result.status == 'success') { // 返回成功后执行的方法
														if (iframeObject.afterSubmit && typeof(iframeObject.afterSubmit) == 'function') { // 执行自定义方法afterSubmit
															iframeObject.afterSubmit(result);
														}
													}
													if (iframeObject.successCloseWindow && typeof(iframeObject.successCloseWindow) == 'function') { // 执行自定义方法successCloseWindow，返回true关闭窗口
														if (!iframeObject.successCloseWindow(result)) {
															doSubmitResult(result, null, datagrid_ID);
															return;
														}
													}
													doSubmitResult(result, windowID, datagrid_ID);
												}
											});
										}
										else {
											buttonEnabled(bottonObject);
										}
									}); 
								}
								else {
									formObject.form('submit',{
										dataType : 'json',
										onSubmit: function() {
										},
										success: function(result) {
											buttonEnabled(bottonObject);
											result = parseReturn(result);
											if (result.status == 'success') { // 返回成功后执行的方法
												if (iframeObject.afterSubmit && typeof(iframeObject.afterSubmit) == 'function') { // 执行自定义方法afterSubmit
													iframeObject.afterSubmit(result);
												}
											}
											if (iframeObject.successCloseWindow && typeof(iframeObject.successCloseWindow) == 'function') { // 执行自定义方法successCloseWindow，返回true关闭窗口
												if (!iframeObject.successCloseWindow(result)) {
													doSubmitResult(result, null, datagrid_ID);
													return;
												}
											}
											doSubmitResult(result, windowID, datagrid_ID);
										}
									});
								}
							}
						}	
					}
					else {
						buttonEnabled(bottonObject);
						if (iframeObject.validateError && typeof(iframeObject.validateError) == 'function') { // 执行自定义方法validateError，验校错误时执行
							iframeObject.validateError();
						}
					}
				}
			}
		},
		{
			text: '重置',
			iconCls: 'icon-reset',
			handler: function() {
				var iframeObject = window.frames[windowID + '_iframe'];
				if (iframeObject.contentWindow) {
					iframeObject = iframeObject.contentWindow;
				}
				iframeObject.resetForm();
			}
		},
		{
			text: '关闭',
			iconCls: 'icon-cancel',
			handler: function() {
				$('#' + windowID).dialog('close');
			}
		}
	];
	openWindow(false, windowID, dataOptions.url, paramArray, dataOptions);
}
// datagrid 批量删除
// submitFields  除主键之外需要提交的字段（多个用逗号分隔）
// dataOptions   jquery.window中的data-options定义参数
// submitConfirm 提交确认提示信息（为空则不出现确认框）
function datagridDeletePatch(toolbarButton, windowID, submitFields, dataOptions, submitConfirm) {
	if (!dataOptions.url) {
		topMessagerAlert('', '弹出层缺少 url 参数！');
		return;
	}
	var datagrid_ID = getDatagrid_ID(1, toolbarButton);
	dataOptions.datagrid_ID = datagrid_ID;
	var selections = $('#' + datagrid_ID).datagrid('getSelections');
	if (selections.length == 0) {
		topMessagerAlert('', '请先选择需要处理的数据！');
		return;
	}
	if (!submitConfirm) {
		submitConfirm = '您确认要批量解除关系吗？';
	}
	topMessager.confirm('', submitConfirm, function(r) {    
		if (r) {	
			var opts = $('#' + datagrid_ID).datagrid("options");
			var postFieldArray = [];
			postFieldArray.push(opts.idField);
			if ("undefined" == typeof submitFields || submitFields == null) {
				submitFields = "";
			}
			if (submitFields != "") {
				postFieldArray = postFieldArray.concat(submitFields.split(","));
			}
			var postData = [];
			for (var i = 0; i < selections.length; i++) {
				var dataArray = {};
				for (var j = 0; j < postFieldArray.length; j++) {
					var postField = postFieldArray[j];
					if (selections[i][postField]) {
						dataArray[postField] = selections[i][postField];
					}
				}
				postData.push(dataArray);
			}
			$.ajax({
				url: dataOptions.url,
				type: 'POST',
				dataType: "json",
				contentType: "application/json",
				data: JSON.stringify(postData)
			}).done(function(result) {
				result = parseReturn(result);
				doSubmitResult(result, null, datagrid_ID);
			});
		}
	});
}

</script>  

</html>