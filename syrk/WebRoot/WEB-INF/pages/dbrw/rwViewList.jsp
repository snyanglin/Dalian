<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="<%=contextPath%>/css/dbrw.css" rel="stylesheet" type="text/css" />
	 <script type="text/javascript" src="<%=contextPath%>/js/tools/flashChart/swfobject.js"></script>
    <title>工作督办任务列表</title>
    
    <style type="text/css">
		.wrapper{width:100%; height:100%; }
		.dbrw_left{width:98%; background-color:#fff; border:1px solid #d1d1d1;}
		.dubanrenwu_table{width:100%; margin:auto;}
		.dubanrenwu_table tr{height:30px;}
		.dubanrenwu_table th{font-size:12px; color:#333; line-height:30px; text-align:right; border-bottom:1px dashed #d6d6d6;}
		.dubanrenwu_table td{font-size:12px; color:#888888; line-height:30px; text-align:left; border-bottom:1px dashed #d6d6d6;}
	</style>
    
    
    
</head>
<body class="easyui-layout" data-options="split:false">

   			<input id="rwid" value="${entity.id}" type="hidden" />
   
	   		<div data-options="region:'north',split:false" title="任务概况" style="height:235px">
	   		
	   		
	   			 <div style="padding-top: 12px;padding-left: 25px;" >
					<div class="dbrw_left">
						<table cellpadding="0" cellspacing="0" class="dubanrenwu_table">
							<tr>
							<th width="12%" nowrap="nowrap">任务开始时间：</th>
							<td width="38%" nowrap="nowrap">&nbsp;${fn:substring(entity.rwkssj,0,10)}</td>
							<th width="12%" nowrap="nowrap">任务结束时间：</th>
							<td width="38%" nowrap="nowrap">&nbsp;${fn:substring(entity.rwjssj,0,10)}</td>
							</tr>
							<tr>
							<th nowrap="nowrap">任务发起时间：</th>
							<td nowrap="nowrap">&nbsp;${fn:substring(entity.rwfqsj,0,10)}</td>
							<th nowrap="nowrap">任务数据总量：</th>
							<td nowrap="nowrap">&nbsp;${entity.rwsjzl}</td>
							</tr>
							<tr>
							<th nowrap="nowrap">任务标题：</th>
							<td colspan="3" nowrap="nowrap">&nbsp;${entity.rwbt}</td>
							</tr>
							<tr>
							<th nowrap="nowrap">任务说明：</th>
							<td colspan="3" nowrap="nowrap">&nbsp;${entity.rwsm}</td>
							</tr>
						
							<tr style="height: 55px;">
							<th nowrap="nowrap">完成情况：</th>
							<td colspan="3" rowspan="2" align="center" nowrap="nowrap" >
							 	&nbsp;${entity.rwwcqk}
							</td>
							</tr>
							
						</table>
					
					</div>
					
				</div>
	   		
	   		
	   		
	   		
			</div>
	        <div data-options="region:'center',split:false,border:false" style="height:auto" >
				<div id="rwqk" class="easyui-tabs" data-options="fit:true">
					<div title="整体情况" >
						<div style="margin-top:5px;">
							<div id="queryRwqktjChart"></div>
						</div>
					</div>
					<div title="任务明细" >
						<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/dbrwVL/rwmxlist',toolbar:'#datagridToolbar',
		            		border:false,queryParams:{dbrwid:'${entity.id}'},idField:'id',pageSize:getAutoPageSize(350),pageList:[getAutoPageSize(350),getAutoPageSize(350) * 2]">
						    <thead>
						        <tr>
						        	<th data-options="field:'sszrqmc',width:15,align:'left',halign:'center',sortable:true">所属责任区</th>
						        	<c:forEach items="${titleArray}" var="titleArray" varStatus="status">
						        		<th data-options="field:'dbsjx${status.index + 1}',width:${titleArray['filedRatio']},align:'center',halign:'center',sortable:true">${titleArray["filedName"]}</th>
						        	</c:forEach>
						            <th data-options="field:'sjclsj',width:10,align:'center',halign:'center'">数据处理时间</th>
						            <th data-options="field:'dbfknr',align:'center',halign:'center',width:10,formatter:fkviewFormater">&nbsp;反馈内容&nbsp;</th>
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
							  		title: '督办任务明细查询条件',
							  		url: contextPath + '/dbrwVL/queryCondition?rwid=${entity.id}',
							  		width: 850,
							  		height: 320
							  		})">查询</a>
							</td>
						</tr>
						</tbody>
						</table>
						</div>						
					</div>
				</div>
			</div>
			
<script type="text/javascript">
<!--
$(function(){
	showChart("${entity.id}");
});

function fkviewFormater(val,row,index){
	if (row["dbfknr"] == "") {
		return '';
	}
	else {
		return '<a href="javascript:void(0)" title="'+row["dbfknr"]+'" onclick="doView(this,'+index+')">查看</a>';
	}
}
function doView(_this,index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	$.messager.alert("反馈内容", rowData["dbfknr"],'info');
}

function showChart(rwid){
	var vdata = new Date();
	var mili = vdata.getMilliseconds();
	var url = contextPath + "/dbrwVL/queryRwqktjChart?rwid="+rwid + "~" + mili;
	swfobject.embedSWF(contextPath + "/js/tools/flashChart/open-flash-chart.swf","queryRwqktjChart","100%","98%","9.0.0","expressInstall.swf",{"data-file":url},{wmode:"transparent"});
}
-->
</script>
  </body>
</html>
