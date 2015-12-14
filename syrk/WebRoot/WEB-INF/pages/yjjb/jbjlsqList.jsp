<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>举报奖励申请列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
	    	<div class="easyui-layout" data-options="fit:true,border:false">   
	            <div data-options="region:'center',split:true,title:'举报奖励申请列表',border:true" style="height:auto">
				<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>jbjlxxb/query',toolbar:'#datagridToolbar',
				            singleSelect:false,
				            selectOnCheck:true,checkOnSelect:true,border:false,sortOrder:'desc',sortName:'xt_zhxgsj',
				            	idField:'id',pageSize:getAutoPageSize(175),pageList:[getAutoPageSize(175),getAutoPageSize(175) * 2],
				            	onDblClickRow:dbClickRow
				            	">
					<thead>
					    <tr>
					        <th data-options="field:'id', width:20, align:'center',	halign:'center', sortable:true">申请编号</th>
					        <th data-options="field:'xsbh',	width:20, align:'center', halign:'center' ,sortable:true">线索编号</th>
					        <th data-options="field:'ajbh',	width:20, align:'center', halign:'center' ,sortable:true">案件编号</th>
					        <th data-options="field:'sqdw', width:20, align:'center', halign:'center' ,sortable:true, formatter:dictFormatter,dictName:'<%=basePath %>common/myOrg?type=JBJLSQ'">管辖单位</th>
					        <th data-options="field:'xt_cjsj',	width:30, align:'center', halign:'center' ,sortable:true">申请时间</th>
					        <th data-options="field:'spzt', width:20, align:'center', halign:'center', sortable:true">审批状态</th>
					        <th data-options="field:'process', width:30, align:'center',	halign:'center',formatter:datagridProcessFormater">操作</th>
					    </tr>
					</thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0"  >
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
									<td class="toolbarTd" style="width:250px">
										审批状态：<input class="easyui-combobox" type="text" name="spzt" id="spzt" 
											data-options="required:false,url: contextPath + '/common/dict/D_BZ_SPZT.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
											style="width:160px;" />
									</td>
									<td class="toolbarTd" align="right" colspan="7" style="padding-right:8px">
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >筛选</a>
										<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
									</td>
								</tr>
								
								<tr>
									<td class="toolbarTd" style="width:280px">
										申请编号：<input class="easyui-validatebox" type="text" name="id" id="id" 
												data-options="required:false"  
												style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										线索编号：<input class="easyui-validatebox" type="text" name="xsbh" id="xsbh" 
												data-options="required:false" style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										案件编号：<input class="easyui-validatebox" type="text" name="ajbh" id="ajbh" 
												data-options="required:false" style="width:160px;" />
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
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

	    	return  '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="viewDetail(this,'+index+')">查看详细</a>&nbsp;';
	}

	var windowID = null;
	function doInit(paramArray) {
		windowID = paramArray['windowID'];
	}

	//查询按钮
	function queryButton(){
		
	  	var starttime = $("#starttime").val();
	  	var endtime = $("#endtime").val();
	  	var spzt = $("#spzt").val();
	  	var xsbh = $("#xsbh").val();
	  	var id = $("#id").val();
	  	var ajbh = $("#ajbh").val();
	  	
		xsbh = $.trim(xsbh);
	  	$('#dg').datagrid(
  			'reload',
  			{   'starttime':starttime,
  				'endtime':endtime,
  				'spzt':spzt,
  				'xsbh':xsbh,
  				'id':id,
  				'ajbh':ajbh
  			});
	 }

	function clearCase(){
		  $("#queryForm").form("reset");
	}
		
	function dbClickRow(rowIndex,rowData){
			var hsUrl = "/xsjbxxb/openZCCK?";
			hsUrl+="xsbh="+rowData.xsbh+"&sqbh="+rowData.id+"&mainTabID="+getMainTabID();
			menu_open("查看详细",hsUrl);
	}

	function reloadDg(){
			$("#dg").datagrid("clearSelections");
			$("#dg").datagrid("reload");
	}

	//查看详细
	function viewDetail(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = "/xsjbxxb/openZCCK?";
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		
		hsUrl+="xsbh="+rowData.xsbh+"&sqbh="+rowData.id+"&mainTabID="+getMainTabID();
		menu_open("查看详细",hsUrl);
	}
    </script>
  	</body>
</html>
