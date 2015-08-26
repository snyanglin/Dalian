<!--  
	@Author:       [xu_haibo@founder.com.cn]
	@CreateDate:   [2015-7-8 下午13:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
    }
%>
<script type="text/javascript">
	var cccs = ${entitycs.cccs };
	
function addXfdwcyxxb(obj){
	var bfb = "${entity.zddwzccdwdbfb }";
	var id = "${entity.id }";
	var editUrl = contextPath + '/cyjh/todwcyadd?id='+id+'&cyid='+id+'&mainTabID='+getMainTabID();
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	datagridAdd(obj, 'addWindow', {bfb:bfb},{
		title : '抽查信息',
		url : editUrl,
		width : 650,
		height : 345
	}, '您是否要保存数据？');
}
//操作按钮
function processFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="deleteRow(this,'+index+')">删除</a>&nbsp;';
}

function cccsFormater(val, row, index) { // 抽查次数
	return "<font color='blue'>第"+row.cccs+"次</font>";
}
//注销单条
function deleteRow(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/cyjh/deleteXfdwcyxxb';
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
			postData["xfdwcccsxxbid"] = "${entity.id}";
			$.ajax( {
				url : deleteUrl,
				type : 'POST',
				data : postData
			}).done( function(result) {
				var json = $.parseJSON(result);
				$('#cccsan').text(json.cs);
				doSubmitResult(result, null, datagrid_ID);
			});
		}
	});
}
/*
 * datagrid reload
 */
function reloadDg(){
	cccs = cccs+1;
	$("#dg").datagrid("clearSelections");
	$('#dg').datagrid('reload');
	$('#cccsan').text(cccs);
}
</script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>抽样</title>
		<style type="text/css">
			.title{
				font-size:12px;color: #0e2d5f;background:#eaf2ff;font-weight: bold;
				border-top: 1px  #95B8E7 solid;border-bottom: 1px  #95B8E7 solid;
			}
			.td-solid{
				border-left:1px  #ccc solid;
				border-bottom: 1px  #ccc solid;
				border-right: 1px  #ccc solid;
				background:#efefef;
			}
			.td-bottom{
				border-bottom: 1px  #ccc dotted;
			}
			.td-left-bottom{
				border-left:1px  #ccc dotted;
				border-bottom: 1px  #ccc solid;
			}
			.td-lb-dotted{
				border-left:1px  #ccc dotted;
				border-bottom: 1px  #ccc dotted;
				text-align: center;
				color:blue;
				width:170px;
			}
		</style>
	</head>
<body style="overflow: hidden;">   
	<table  border="0" cellpadding="0" cellspacing="0" width="100%" align="center"   style="height: 60px" >
		<tr>
			<td  class="td-solid"  align="right" width="180px">
				专职监督检查人员数（N）:
			</td>
			<td class="td-bottom" width="180px">
				${entity.zzjcrs }
			</td>
			<td class="td-solid"  align="right" width="200px">
				兼职监督检查人员数（N）:
			</td>
			<td class="td-bottom">
				${entity.jzjcrs }
			</td>
		</tr>
		<tr>
			<td  class="td-solid"  align="right" width="180px">
				重点单位占抽查单位的百分比:
			</td>
			<td class="td-bottom">
				${entity.zddwzccdwdbfb }%
			</td>
			<td  class="td-solid"  align="right" width="200px">
				全年应检查单位数:
			</td>
			<td class="td-bottom">
				总数<font color="red">${entity.zs }</font>家,重点<font color="red">${entity.zddws }</font>家,一般<font color="red">${entity.fzddws }</font>家
			</td>
		</tr>
	</table>
	&nbsp;
	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center"   style="height: 90px">
		<tr>
			<td colspan="5" class="title">
				&nbsp;辖区现已录入单位数
			</td>
		</tr>
		<tr bgcolor="#efefef"  align="center">
			<td style="border-bottom: 1px  #ccc solid;">
				重点单位
			</td>
			<td class="td-left-bottom">
				一般单位
			</td>
			<td class="td-left-bottom">
				九小类单位
			</td>
			<td class="td-left-bottom">
				其他单位
			</td>
			<td class="td-left-bottom">
				总计
			</td>
		</tr>
		<tr  align="center">
			<td style="color: blue;border-bottom: 1px  #ccc dotted;"  align="center">${entitydws.zddws }
			</td>
			<td class="td-lb-dotted">${entitydws.ybdws }
			</td>
			<td class="td-lb-dotted">${entitydws.jxcss }
			</td>
			<td class="td-lb-dotted">${entitydws.qtdws }
			</td>
			<td class="td-lb-dotted">${entitydws.zddws+entitydws.ybdws+entitydws.jxcss+entitydws.qtdws }
			</td>
		</tr>
	</table>
	&nbsp;
	<table  border="0" cellpadding="0" cellspacing="0" style="height: 30px" width="100%">
		<tr>
			<td  class="title">&nbsp;年度抽样检查总计划列表
			</td>
		</tr>
	</table>
	<div data-options="region:'center', split:true" style="width:100%; margin:0 0 0;border-width: 0px; height:246px;"> 
	<table id="dg" class="easyui-datagrid"   data-options="url: contextPath +'/cyjh/queryXfdwcyxxbList?xfdwcccsxxbid=${entity.id }' ,
         		singleSelect:true,selectOnCheck:true,
         		checkOnSelect:true,border:false,
         		sortName:'cccs',sortOrder:'asc',
         		idField:'id',pagination:false">
			    <thead>
			        <tr>
			        	<th data-options="field:'id',hidden:true"></th>
			        	<th data-options="field:'xfdwcccsxxbid',hidden:true"></th>
			        	<th data-options="field:'cccs',width:160,align:'center',sortable:true,halign:'center',formatter:cccsFormater">抽查次数</th>
						<th data-options="field:'ccsjks',width:160,align:'center',sortable:true,halign:'center'">抽查时间开始</th>
						<th data-options="field:'ccsjjs',width:160,align:'center',sortable:true,halign:'center'">抽查时间结束</th>
						<th data-options="field:'zddwzs',width:150,align:'center',sortable:true,halign:'center'">重点单位数量</th>
			        	<th data-options="field:'ybdwzs',width:150,align:'center',sortable:true,halign:'center'">一般单位数量</th>
			        	<th data-options="field:'qtdwzs',width:150,align:'center',sortable:true,halign:'center'">其他单位总数</th>
			        	<th data-options="field:'jxcszs',width:150,align:'center',sortable:true,halign:'center'">九小场所总数</th>
			            <th data-options="field:'process',width:150,align:'center',halign:'center',formatter:processFormater">操作</th>
			        </tr>
			    </thead>
	</table>
	</div>
	<table id="datagridToolbar"  bgcolor="#F4F4F4" cellspacing="0" cellpadding="0" border="0" width="100%">
		<tbody>
			<tr>
				<td class="toolbarTd"  align="center" id="dcccan" colspan="7" style="padding-right:8px;height: 40px;border-top: 1px  #ccc solid;text-align: right;">
					<a href="javascript:void(0)"  class="easyui-linkbutton"  iconCls="icon-add"  onclick="addXfdwcyxxb(this);">进行第<span id="cccsan">${entitycs.cccs }</span>次抽查</a>
					<a href="javascript:void(0)"  class="easyui-linkbutton"  iconCls="icon-cancel"  onclick="parent.$('#dwcywindow').dialog('close');">关闭</a>
				</td>
			</tr>
		</tbody>
	</table>
</body>  
</html>
