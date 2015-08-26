<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>关联已有案件</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
	    	<div class="easyui-layout" data-options="fit:true,border:false">   
	            <div data-options="region:'center',split:true,title:'关联已有案件',border:true" style="height:auto">
					<table id="dg" class="easyui-datagrid" data-options="toolbar:'#datagridToolbar',
					            singleSelect:false,
					            selectOnCheck:true,checkOnSelect:true,border:false,sortOrder:'desc',sortName:'xt_zhxgsj',
					            	idField:'ajbh',pageSize:getAutoPageSize(175),pageList:[getAutoPageSize(175),getAutoPageSize(175) * 2],
					            	onDblClickRow:dbClickRow
					            	">
					    <thead>
					        <tr>
					       	 	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
					            <th data-options="field:'ajbh', width:15,	align:'center',	halign:'center'	,sortable:true">案件编号</th>
					            <th data-options="field:'ajmc',	width:10,	align:'center',	halign:'center'	,sortable:true">案件名称</th>
					            <th data-options="field:'ajzt',	width:10,	align:'center',	halign:'center'	,sortable:true, formatter:datagridAjzt">案件状态</th>
					            <th data-options="field:'slsj',	width:10,	align:'center',	halign:'center'	,sortable:true">受理时间</th>
					            <th data-options="field:'sajyxx',	width:40,	align:'center',	halign:'center'	,sortable:true">简要案情</th>
					            <th data-options="field:'process',	width:10,   align:'center',	halign:'center',formatter:datagridProcessFormater">操作</th>
					        </tr>
					    </thead>
					</table>
					<div id="datagridToolbar" style="padding:5px;height:auto" >
					<input type="hidden" name="alarm" id="alarm" value="${alarm}">
					<input type="hidden" name="tabId" id="tabId" value="${tabId}">
					<!-- 表格工具条按钮 -->
					<form id="queryForm" style="margin:0px;">
						<table cellspacing="0" cellpadding="0" border="0" width="100%">
							<tbody>
							<tr>
								<td class="toolbarTd" style="width:250px">
									开始时间：<input class="easyui-validatebox" type="text" name="starttime" id="starttime" 
										data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
										onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" 
										style="width:160px;" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" style="width:250px">
									结束时间：<input class="easyui-validatebox" type="text" name="endtime" id="endtime" 
										data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
										onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" 
										style="width:160px;" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" style="width:280px">
									简要案情：<input class="easyui-validatebox" type="text" name="sajyxx" id="sajyxx" 
											data-options="required:false,validType:'maxLength[10]'"  
											style="width:160px;" />
								</td>
							</tr>
							<tr>
								<td class="toolbarTd" style="width:280px">
									案件编号：<input class="easyui-validatebox" type="text" id="ajbh" name="ajbh" 
											data-options="required:false,validType:'maxLength[100]'" 
											style="width:160px"/>
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" style="width:280px">
									案件名称：<input class="easyui-validatebox" type="text" name="ajmc" id="ajmc" 
											data-options="required:false,validType:'maxLength[100]'"  
											style="width:160px;" />
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" style="width:280px">
									案件状态：<input class="easyui-combobox" type="text" name="ajzt" id="ajzt" 
											data-options="required:false,url: '<%=basePath %>common/myOldAjzt',
			    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" 
										style="width:160px;" />
								</td>
								<td class="toolbarTd" align="right" colspan="7" style="padding-right:8px">
									<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
									<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
									<a id="linkCase" class="easyui-linkbutton" href="javascript:void(0)">关联已选案件</a>
									<a id="backButton" class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)">关闭</a>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="<%=contextPath%>/js/jwzhold.js"></script>
<script type="text/javascript">
var addressPrefix = "<%=SystemConfig.getString("addressPrefix")%>";
var addressPrefixArray = addressPrefix.split(",");
$(function(){
	
});
//截地址字段
function subjzdz(val, row, index){
	for (var i = 0; i < addressPrefixArray.length; i++) {
		val = val.replace(addressPrefixArray[i], "");
	}
	return val;
}
function datagridAjzt(val,row,i){
	if(row.ajlx < 3){
		return '破案';
	}else{
		return window.top.getDictName('<%=basePath %>common/myOldAjzt?type=1', val);
	}
		
			
}
//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
		if(row.ajlx < 3){
    		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="viewCase(this,'+index+')">查看案件</a>&nbsp;';
		}else{
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="JWZH.AJXX(\''+${alarm}+'\',\'0000\',\''+row.ajbh+'\')">查看案件</a>&nbsp;';
		}
}
  
function clearCase(){
	  $("#queryForm").form("reset");
}

//查询按钮
function queryButton(){
  	var ajbh = $("#ajbh").val();
  	var ajmc = $("#ajmc").val();
  	var ajzt = $("#ajzt").val();
  	var sajyxx = $("#sajyxx").val();
  	var starttime = $("#starttime").val();
  	var endtime = $("#endtime").val();
  	ajbh= $.trim(ajbh);

  	$('#dg').datagrid({
  		url:'<%=basePath %>ajxxb/queryList?xsId=${xsId}',
  		queryParams:{
  			'ajbh':ajbh,
			'ajmc':ajmc,
			'ajzt':ajzt,
			'sajyxx':sajyxx,
			'starttime':starttime,
			'endtime':endtime
  		}
  	});
  }
//复选框选中的添加到案件线索关联表
function linkSelectCase(){
	  var  getSelections = $("#dg").datagrid('getSelections');
	  var len = getSelections.length;
	  var ajNum="";
	  var ajlx="";
	  if(len>=1){
			for(var i=0;i<len;i++){
				ajNum+=getSelections[i].ajbh +",";
				ajlx+=getSelections[i].ajlx +",";
			}
			ajNum = ajNum.substring(0, ajNum.length-1);//去掉最后一个逗号
			//var hsUrl = "<%=contextPath%>/xsajgxb/save?xsId="+'${xsId}'+"&ajNum="+ajNum+"&ajlx="+ajlx;
			$.post('<%=contextPath%>/xsajgxb/save',{xsId:'${xsId}',ajNum:ajNum,ajlx:ajlx},function(d){
				if(d.status!='success'){
					topMessagerAlert(null, d.message);
				}else{
					topMessagerShow(null, "关联案件成功");
					executeTabPageMethod($("#tabId").val(),'reloadDg');
					$('#dg').datagrid('reload');
					//closeSelf();
				}
			},'json');
			//menu_open("关联已选案件",hsUrl);
	  }else{
		topMessagerAlert(null, "请选择案件");
	  }
}

//跳转到查看案件页面
function viewCase(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var hsUrl = "/ajxxb/viewCase?";
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	hsUrl+="ajId="+rowData.ajbh+"&showFlag="+'1'+"&mainTabID="+getMainTabID();
	menu_open("查看案件",hsUrl);
}
	
function dbClickRow(rowIndex,rowData){
	var hsUrl = "/ajxxb/viewCase?";
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	hsUrl+="ajId="+rowData.ajbh+"&showFlag="+'1'+"&mainTabID="+getMainTabID();
	menu_open("查看案件",hsUrl);
}

function addRw(){
	var hsUrl = "/zdzxrwb/zdzxrwbAdd?";
	hsUrl+="&mainTabID="+getMainTabID();
	menu_open("自动执行任务新增",hsUrl);
}

function reloadDg(){
		$("#dg").datagrid("clearSelections");
		$('#dg').datagrid('reload');
}

$('#linkCase').click(function(){
	linkSelectCase();
});
$('#backButton').click(function(){
	closeSelf();
});
    </script>
  </body>
</html>
