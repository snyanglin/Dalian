<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>待督办任务管理</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
     <div data-options="region:'north',border:false" style="height: 240px">
		<form action="<%=basePath%>dbrwDdbrwb/insertDbrwb" id="dataForm" name="dataForm" method="post">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<input type="hidden" name="dbmxid" value="${dbrwDbpzb.id}"/>
			<input type="hidden" name="ddbrwid" value="${dbrwDdbrwb.id}"/>
			<input type="hidden" name="dbrwfqfxjdm" value="${dbrwDdbrwb.dbrwfqfxjdm}"/>
			<input type="hidden" name="dbrwfqpcsdm" value="${dbrwDdbrwb.dbrwfqpcsdm}"/>
			<input type="hidden" name="dbrwfqdwdm" value="${entity.dbrwfqdwdm}"/>
			
			<input type="hidden" name="ywfl" value="${entityCondiTions.ywfl}"/>
			<input type="hidden" name="ddbsjx1" id="ddbsjx1" value="${entityCondiTions.ddbsjx1}"/>
			<input type="hidden" name="ddbsjx2" id="ddbsjx2"/>
			<input type="hidden" name="ddbsjx3" id="ddbsjx3"/>
			<input type="hidden" name="ddbsjx4" id="ddbsjx4"/>
			<input type="hidden" name="ddbsjx5" id="ddbsjx5"/>
			<input type="hidden" name="ddbsjx6" id="ddbsjx6"/>
			<input type="hidden" name="ddbsjx7" id="ddbsjx7"/>
			<input type="hidden" name="ddbsjx8" id="ddbsjx8"/>
			<input type="hidden" name="ddbsjx9" id="ddbsjx9"/>
			<input type="hidden" name="sszrqdm" id="sszrqdm"/>
			
			<input type="hidden" name="rwsjzl" id="rwsjzl"/>
			<input type="hidden" name="selectAllMx" id="selectAllMx" value="0"/>
			<input type="hidden" name="selectMxIds" id="selectMxIds"/>
			
		    <tr class="dialogTr" >
		        <td width="20%" class="dialogTd" align="right">督办任务级别：</td>
		        <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="dbrwjbdm" name="dbrwjbdm" value="${dbrwDdbrwb.dbrwjbdm}" style="width:200px;"
					data-options="url: contextPath + '/common/dict/D_DBRW_RWJB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
		        <td width="20%" class="dialogTd"  align="right">督办任务发起分县局：</td>
		        <td width="30%" class="dialogTd"><input type="text" id="dbrwfqfxj" value="${dbrwfqfxj}" style="width:200px;" class="easyui-validatebox" /></td>
		    </tr>
		    <tr class="dialogTr" >
		        <td width="20%" class="dialogTd" align="right">督办任务发起派出所：</td>
		        <td width="30%" class="dialogTd"><input type="text" id="dbrwfqpcs" value="${dbrwfqpcs}" style="width:200px;" class="easyui-validatebox" /></td>
		        <td width="20%" class="dialogTd"  align="right">督办任务发起单位：</td>
		        <td width="30%" class="dialogTd"><input type="text" id="dbrwfqdw" value="${dbrwfqdw}" style="width:200px;" class="easyui-validatebox" /></td>
		    </tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">任务标题：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input type="text" name="rwbt" id="rwbt" value="${dbrwDdbrwb.rwbt}" maxlength="100" class="easyui-validatebox" style="width: 613px;"
					data-options="required:true,tipPosition:'bottom'"></td>
	    	</tr>
		    <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">待督办任务生成时间：</td>
				<td width="30%" class="dialogTd"><input type="text" maxlength="20" id="ddbrwscsj" value="${fn:substring(dbrwDdbrwb.ddbrwscsj,0,10)}" class="easyui-validatebox" style="width:200px;" /></td>
		        <td width="20%" class="dialogTd" align="right"></td>
		       	<td width="30%" class="dialogTd"></td>
			</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">任务开始时间：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="rwkssj" id="rwkssj" value="${fn:substring(entity.rwkssj,0,10)}" class="easyui-validatebox" style="width:200px;"
		    		data-options="required:true,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
		    	<td width="20%" class="dialogTd" align="right">任务结束时间：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="rwjssj" id="rwjssj" value="${fn:substring(entity.rwjssj,0,10)}" class="easyui-validatebox" style="width:200px;"
		    		data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'rwkssj\') || \'%y-%M-%d %H:%m:%s\'}'})"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">任务说明：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="rwsm" id="rwsm" class="easyui-validatebox" style="width: 613px; height:48px;"
					data-options="validType:['maxLength[500]'],invalidMessage:'任务说明不能超过500个汉字，请重新输入！',tipPosition:'left'"></textarea></td>
	    	</tr>
	    	</table>
	    </form>
    </div>
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto; border-top: 1px solid #95b8e7;">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/dbrwDdbrwb/querySjmxbList',toolbar:'#datagridToolbar',
            		singleSelect:false,selectOnCheck:true,checkOnSelect:true,border:false,queryParams:{id:'${dbrwDdbrwb.id}',ywfl:'${entityCondiTions.ywfl}',ddbsjx1:'${entityCondiTions.ddbsjx1}'},
            		idField:'id',pageSize:20,pageList:[20,40],
            		onLoadSuccess:function(data) {
            			if ($('#selectAllMx').val() == '1') {
            				$(this).datagrid('checkAll');
            			}
            		},
            		onUnselect: function(rowIndex, rowData) {
            			$('#selectAllMx').val('0');
            		},
            		onUncheck: function(rowIndex, rowData) {
            			$('#selectAllMx').val('0');
            		}">
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				        	<th data-options="field:'sszrqmc',width:10,align:'left',halign:'center',sortable:true">所属责任区</th>
				        	<c:forEach items="${titleArray}" var="titleArray" varStatus="status">
				        		<th data-options="field:'ddbsjx${status.index + 1}',width:${titleArray["filedRatio"]},align:'center',halign:'center',sortable:true">${titleArray["filedName"]}</th>
				        	</c:forEach>
				        	<c:if test="${not empty dbrwDbpzb.ckxxbtzd}">
								<th data-options="field:'viewbiz',align:'center',halign:'center',formatter:viewFormater">&nbsp;查看&nbsp;</th>
				        	</c:if>
				            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">&nbsp;删除&nbsp;</th>
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
					    		{ddbsjx1:'${entityCondiTions.ddbsjx1}'},
					    		{
					    		title: '待督办任务明细数据查询条件',
					    		url: contextPath + '/dbrwDdbrwb/queryCondition?dbmxid=${dbrwDbpzb.id}',
					    		width: 760,
					    		height: 300
					    		})">查询</a>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="toolbarTd" nowrap="nowrap">
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="datagridSelectAllMx(this)">选择所有数据</a>
						</td>
						<td class="toolbarTd" nowrap="nowrap">
					    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="datagridClearAllMx(this)">清空所有选择</a>
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
 
var ckxxbtzd = "${dbrwDbpzb.ckxxbtzd}";
 
function doInit(paramArray) {
	setInputReadonly('dbmxmc', true);
	setInputReadonly('dbsjjgzq', true);
	setInputReadonly('dbrwjbdm', true);
	setInputReadonly('dbrwfqfxj', true);
	setInputReadonly('dbrwfqpcs', true);
	setInputReadonly('dbrwfqdw', true);
	setInputReadonly('ddbrwscsj', true);
}

function beforeSubmit() {
	if ($("#rwkssj").val() > $("#rwjssj").val()) {
		topMessager.alert('', '任务结束时间必须大于开始时间，请重新输入！');
		$("#rwkssj").focus();
		return false;
	}
	var pager = $('#dg').datagrid('getPager');
	var opts = pager.pagination("options");
	var totalValue = opts.total;
	if (totalValue == 0) {
		topMessager.alert('', '督办任务数据明细不能为空！');
		return false;
	}
	var selections = $('#dg').datagrid('getSelections');
	if (selections.length == 0) {
		topMessagerAlert('', '请先选择需要处理的数据！');
		return false;
	}
	else {
		if ($('#selectAllMx').val() == '1') {
			$('#selectMxIds').val('');
			$('#rwsjzl').val(totalValue);
		}
		else {	
			var postData = [];
			for (var i = 0; i < selections.length; i++) {
				postData.push(selections[i]['id']);
			}
			$('#selectMxIds').val(postData.join(","));
			$('#rwsjzl').val(selections.length);
		}
	}
}

function afterSubmit(submitData) {
}


function viewFormater(val, row, index) { // 查看业务
	var url = row["dataurl"];
	if (url == null || url == "") {
		return "";
	}
	else {
		var menuTitle = row[ckxxbtzd];
		if (menuTitle == null || menuTitle == "") {
			menuTitle = "查看信息";
		}
		return "&nbsp;<a class='link' href='javascript:void(0)' onclick='menu_open(\""+ menuTitle +"\", \""+url+"\")')>查看</a>&nbsp;";
	}
}

function processFormater(val, row, index) { // 删除
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, \''+row['id']+'\')">删除</a>&nbsp;';
}

function datagridQuery(toolbarButton, windowID, paramArray, dataOptions) {
	if (!dataOptions.url) {
		topMessagerAlert('', '弹出层缺少 url 参数！');
		return;
	}
	var datagrid_ID = getDatagrid_ID(1, toolbarButton);
	dataOptions.datagrid_ID = datagrid_ID;
	if (!dataOptions.title) {
		dataOptions.title = '查询条件';
	}
	dataOptions.title = '&nbsp;' + dataOptions.title;
	if (!dataOptions.width) {
		dataOptions.width = 850;
	}
	if (!dataOptions.height) {
		dataOptions.height = 420;
	}
	if (!windowID) {
		windowID = "queryWindow";
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
			text: '确定',
			iconCls: 'icon-ok',
			handler: function() {
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
								return false;
							}
						}
						var opts = $('#' + datagrid_ID).datagrid('options');
						var data = opts.queryParams;
						var queryData = iframeObject.getFormData(formObject[0]);
						for (var item in queryData) {
							data[item] = queryData[item];
							$('#' + item).val(queryData[item]);
						}
						$('#' + windowID).dialog('close');
						$('#' + datagrid_ID).datagrid('load', data);// 强行定位到第一页
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
				var formObject = iframeObject.$('form').first();
				if (formObject) {
					formObject.form('reset');
				}
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
	openWindow(true, windowID, dataOptions.url, paramArray, dataOptions);
}

// 删除单条
function doDelete(linkObject, rowId) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/dbrwDdbrwb/deleteDdbrwSjmxb';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var postData = {};
	postData['id'] = rowId;
	$.ajax({
		url: contextPath + '/dbrwDdbrwb/deleteDdbrwSjmxb',
		type: 'POST',
		data: postData
	}).done(function(result) {
		doSubmitResult(result, null, datagrid_ID);
	});	
}

function datagridSelectAllMx(toolbarButton) {
	$('#selectAllMx').val("1");
	var datagrid_ID = getDatagrid_ID(1, toolbarButton);
	$('#' + datagrid_ID).datagrid('checkAll');
}

function datagridClearAllMx(toolbarButton) {
	$('#selectAllMx').val("0");
	var datagrid_ID = getDatagrid_ID(1, toolbarButton);
	$('#' + datagrid_ID).datagrid('clearChecked');
}

</script>  

</html>