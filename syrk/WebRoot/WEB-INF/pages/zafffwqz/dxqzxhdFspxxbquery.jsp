<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>大型活动非审批查询</title>
</head>
<body class="easyui-layout" data-options="fit:true">
	<div style="display:none;">
	    <form name="downloadform" id="downloadform" action="<%=basePath%>zpfjFjxxb/download" target="submitFrame" method="post">
	    <input type="hidden" name="id" id="downloadID"/>
	    </form>
	</div>
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'大型活动非审批类列表',border:true" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/DxqzxhdFspxxb/queryList',
            		toolbar:'#datagridToolbar',
            		singleSelect:false,selectOnCheck:true,
            		checkOnSelect:true,border:false,
            		sortName:'id',sortOrder:'asc',
            		idField:'id',pageSize:getAutoPageSize(),
            		pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				        	<th data-options="field:'hdmc',width:25,align:'left',sortable:true,halign:'center'">活动名称</th>
				        	<th data-options="field:'hdgm',width:25,align:'left',sortable:true,halign:'center'">活动规模</th>
				        	<th data-options="field:'jbdw',width:25,align:'left',sortable:true,halign:'center'">举办单位</th>
				        	<th data-options="field:'hdkssj',width:25,align:'left',sortable:true,halign:'center'">活动开始时间</th>
				        	<th data-options="field:'hdjssj',width:25,align:'left',sortable:true,halign:'center'">活动结束时间</th>
				            <th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:80px;width:100%" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" width="1600">
							<tbody>
								<tr>
									<td class="toolbarTd" style="width:400px" align="right" >
										活动名称：<input type="text" name="hdmc" id ="hdmc" class="easyui-validatebox" data-options="required:false,validType:'maxLength[100]'" 
										style="width:200px" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:400px" align="right" >
										活动规模从：<input type="text" name="hdgmbegin" id ="hdgmbegin" class="easyui-validatebox" data-options="required:false,validType:['maxLength[50]','naturalNumber']" 
										style="width:200px" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:400px" align="right" >
										至：<input type="text" name="hdgmend" id ="hdgmend" class="easyui-validatebox" data-options="required:false,validType:['maxLength[50]','naturalNumber']" 
										style="width:200px"/>
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								</tr>
							<tr>
									<td class="toolbarTd" style="width:400px" align="right" >
										举办单位：<input type="text" name="jbdw" id ="jbdw" class="easyui-validatebox" data-options="required:false,validType:'maxLength[50]'" 
										style="width:200px"  />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:400px" align="right" >
										    活动开始时间-开始：<input type="text" id="hdkssjbegin" name="hdkssjbegin" class="easyui-validatebox"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'hdkssjend\') }'})"
											 data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" style="width:200px"/> 
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:400px" align="right" >
										    活动开始时间-截止：<input type="text" id="hdkssjend" name="hdkssjend" class="easyui-validatebox" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'hdkssjbegin\') }'})"
											 data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" style="width:200px"/> 
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								</tr>
								<tr>
									<td class="toolbarTd" style="width:400px" align="right" >
										    活动结束时间-开始：<input type="text" id="hdjssjbegin" name="hdjssjbegin" class="easyui-validatebox" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'hdjssjend\') }'})"
											 data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" style="width:200px"/> 
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:400px" align="right" >
										    活动结束时间-截止：<input type="text" id="hdjssjend" name="hdjssjend" class="easyui-validatebox" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'hdjssjbegin\') }'})"
											 data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" style="width:200px"/> 
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" align="left"  style="padding-right:8px;width:800px"  >
										<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="gzjsAdd(this);">新增</a>
										<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-movedown"  onclick="fjdown(this, '+index+')">文书下载</a>
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
										<!-- <a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="fjupload(this, '+index+')">文书上传</a> -->
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
var zzjgdmPd = "<%=userOrgCode%>";
function processFormater(val, row, index) { // 自定义操作生成
	if(row.xt_lrrbmid==zzjgdmPd){
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">修改</a>&nbsp;'+
	   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doInfo(this, '+index+')">详细</a>&nbsp;'+
	   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">注销</a>&nbsp;';
	}else {
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doInfo(this, '+index+')">详细</a>&nbsp;';
	}
}
//重置
function clearCase(){
	  $("#queryForm").form("reset");
}
//新增
function gzjsAdd(obj){
	var editUrl = contextPath + '/DxqzxhdFspxxb/addDxqzxhdFspxxb';
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	datagridAdd(obj, 'addWindow', {sqid:'111', sqjwsid:'111'}, {
		title : '大型活动非审批',
		url : editUrl,
		width : 850,
		height : 530
	}, '您是否要保存数据？');
}
// 修改单条
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = contextPath +   '/DxqzxhdFspxxb/addDxqzxhdFspxxb';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	datagridEdit(datagrid_ID, 'editWindow', {sqid:'111', sqjwsid:'111'}, {
		title : '大型活动非审批',
		url : editUrl,
		maximizable : true,
		width : 850,
		height : 530
	}, '您是否要保存数据？');
}
// 查询单条
function doInfo(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = contextPath +    '/DxqzxhdFspxxb/dxhdfspInfo';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	//menu_open('大型活动非审批详细页面','/forward/dxqzxhdFspxxDetail');
	openTabPage("详情",editUrl);
}
//弹出窗口
function openTabPage(menuName, openURL) {
	window.open(openURL,menuName,'height=1000,width=800,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no');
	//menu_open(menuName, openURL);
	//window.parent.$('#' + windowID).window('close');
}
//查询按钮
function queryButton() {
	var hdmc = document.getElementById("hdmc").value;
	var hdgmbegin = document.getElementById("hdgmbegin").value;
	var hdgmend = document.getElementById("hdgmend").value;
	var jbdw = document.getElementById("jbdw").value;
	var hdkssjbegin = document.getElementById("hdkssjbegin").value;
	var hdkssjend = document.getElementById("hdkssjend").value;
	var hdjssjbegin = document.getElementById("hdjssjbegin").value;
	var hdjssjend = document.getElementById("hdjssjend").value;
	$('#dg').datagrid('reload', {
		'hdmc' : hdmc,
		'hdgmbegin' : hdgmbegin,
		'hdgmend' : hdgmend,
		'jbdw' : jbdw,
		'hdkssjbegin' : hdkssjbegin,
		'hdkssjend' : hdkssjend,
		'hdjssjbegin' : hdjssjbegin,
		'hdjssjend' : hdjssjend
	});
}
//注销单条
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/DxqzxhdFspxxb/delete';
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
// 附件上传
function fjupload(){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow    JHYXSW_JBXXB
	uploadFileEdit('DXQZXHDFSPL_JBXXB', 'DXQZXHDFSPL_JBXXB', '大型活动非审批', '', '1', '1', '大型活动非审批类附件')
}
// 附件下载
function fjdown(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	uploadFileView('DXQZXHDFSPL_JBXXB','DXQZXHDFSPL_JBXXB','1','');
}
</script>  

</html>

