<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>相关案件列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body class="easyui-layout" data-options="fit:true">
  	
	<div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'相关案件列表',border:true" style="height:auto">
				<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>xsajgxb/queryByXsId?XsId=${xsId}',toolbar:'#datagridToolbar',
				            singleSelect:false,
				            selectOnCheck:true,checkOnSelect:true,border:false,sortOrder:'desc',sortName:'xt_zhxgsj',
				            	idField:'id',pageSize:getAutoPageSize(175),pageList:[getAutoPageSize(175),getAutoPageSize(175) * 2],
				            	onDblClickRow:dbClickRow
				            	">
				    <thead>
				        <tr>
				            <th data-options="field:'ajbh', width:15,	align:'center',	halign:'center'	,sortable:true">案件编号</th>
				            <th data-options="field:'ajmc',	width:15,	align:'center',	halign:'center'	,sortable:true">案件名称</th>
				            <th data-options="field:'xt_lrrbm',	width:15,	align:'center',	halign:'center'	,sortable:true">办案单位</th>
				            <th data-options="field:'ajzt',	width:10,	align:'center',	halign:'center'	,sortable:true">案件状态</th>
				            <th data-options="field:'slsj',	width:10,	align:'center',	halign:'center'	,sortable:true">受理时间</th>
				            <th data-options="field:'jyaq',	width:20,	align:'center',	halign:'center'	,sortable:true">简要案情</th>
				            <th data-options="field:'process',	width:10,   align:'center',	halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto" >
				<input type="hidden" name="xsId" id="xsId" value="${xsId}">
				<input type="hidden" name="alarm" id="alarm" value="${alarm}">
				<div id="operaDiv" style="text-align:right;padding: 10px 0px; display:block;">
					<a id="guanlianyiyou" class="l-btn l-btn-small" href="javascript:void(0)" group="">
						<span class="l-btn-left l-btn-icon-left">
							<span class="l-btn-text">关联已有案件&nbsp;&nbsp;</span>
						</span>
					</a>&nbsp;
					<a id="cjbgl" class="l-btn l-btn-small" href="javascript:void(0)" group="">
						<span class="l-btn-left l-btn-icon-left">
							<span class="l-btn-text">创建案件并关联&nbsp;&nbsp;</span>
						</span>
					</a>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="<%=contextPath%>/js/jwzhold.js"></script>
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
	if(row.ajsource < 1){
		return  '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="viewCase(this,'+index+')">查看案件</a>&nbsp;&nbsp;&nbsp;'+
	    '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDeleteCheck(this, '+index+')">取消关联</a>&nbsp;';
	}else{
		return  '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="JWZH.AJXX(\''+${alarm}+'\',\'0000\',\''+row.ajbh+'\')">查看案件</a>&nbsp;&nbsp;&nbsp;'+
	    '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDeleteCheck(this, '+index+')">取消关联</a>&nbsp;';
	}
    	
}

//注销单条
function doDeleteCheck(linkObject, index) {
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	$.ajax({
		type:"GET",
		url:contextPath+"/xsajgxb/checkXs",
		dataType:"json",
		data:"xsbh="+'${xsId}'+"&ajbh="+rowData.ajbh,
		success:function(data){
			if(data.sqNum == 0) {
				doDelete(linkObject, index);
			}else {
				topMessagerAlert(null, "当前案件已申请奖励，不能取消关联！");
			}
		}
	});
}

//注销单条
function doDelete(linkObject, index) {
	  cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var deleteUrl = contextPath + '/xsajgxb/delete';
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var submitFields = ""; //  除主键之外需要提交的字段（多个用逗号分隔）

		topMessager.confirm('','您确认要取消关联吗？',function(r) {    
			if (r) {	
				var opts = $('#' + datagrid_ID).datagrid("options");
				var rows = $('#' + datagrid_ID).datagrid("getData");
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
					var json = $.parseJSON(result);
					if(json.status!="success") topMessagerAlert(null, "取消失败");
					doSubmitResult(result, null, datagrid_ID);
				});
			}
		});
	}

var windowID = null;
function doInit(paramArray) {
	windowID = paramArray['windowID'];
}

function viewCase(linkObject, index,xsbh){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var hsUrl = "/ajxxb/viewCase?";
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var xsbh = '${xsId}';
	hsUrl+="ajId="+rowData.ajbh+"&xsbh="+xsbh+"&showFlag="+'1'+"&mainTabID="+getMainTabID();
	//mainTabID=1
	menu_open("查看案件",hsUrl);
}

function toCreateAndLinkCase(){

	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var hsUrl = "/ajxxb/createAndLink?";
	hsUrl+="xsId="+'${xsId}'+"&mainTabID="+getMainTabID();
	openTabPage("创建案件并关联",hsUrl);
}

function clearCase(){
	  $("#queryForm").form("reset");
}
	
function dbClickRow(rowIndex,rowData){
		var hsUrl = "/ajxxb/viewCase?";
		hsUrl+="ajId="+rowData.ajbh+"&xsbh="+xsbh+"&showFlag="+'1'+"&mainTabID="+getMainTabID();
		menu_open("查看案件－" + rowData.xm,hsUrl);
}

function addRw(){
	var hsUrl = "/zdzxrwb/zdzxrwbAdd?";
	hsUrl+="&mainTabID="+getMainTabID();
	menu_open("自动执行任务新增",hsUrl);
}

function openTabPage(menuName, openURL) {
	menu_open(menuName, openURL);
	window.parent.$('#' + windowID).window('close');
}

function reloadDg(){
	$("#dg").datagrid("clearSelections");
	$('#dg').datagrid('reload');
}
//关联已有案件
$('#guanlianyiyou').click(function(){
	var tabId = getMainTabID();
	//alert('/forward/yjjb|glyyaj?xsId=${xsId}&alarm=${alarm}&tabId='+tabId)
	menu_open('关联已有案件','/forward/yjjb|glyyaj?xsId=${xsId}&alarm=${alarm}&tabId='+tabId);
});
//创建并关联
$('#cjbgl').click(function(){
	toCreateAndLinkCase();
});
    </script>
  </body>
</html>
