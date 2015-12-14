<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        bjzbz = userInfo.getBjzbz();
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>递转审批列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
	    	<div class="easyui-layout" data-options="fit:true,border:false">   
	            <div data-options="region:'center',split:true,title:'递转审批列表',border:true" style="height:auto">
				<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>xsdzspb/query',toolbar:'#datagridToolbar',
				            singleSelect:false,
				            selectOnCheck:true,checkOnSelect:true,border:false,sortOrder:'desc',sortName:'xt_zhxgsj',
				            	idField:'id',pageSize:getAutoPageSize(175),pageList:[getAutoPageSize(175),getAutoPageSize(175) * 2],
				            	onDblClickRow:dbClickRow
				            	">
					<thead>
					    <tr>
					        <th data-options="field:'sqbh', width:20, align:'center',	halign:'center', sortable:true">申请编号</th>
					        <th data-options="field:'xsbh',	width:20, align:'center', halign:'center' ,sortable:true">线索编号</th>
					        <th data-options="field:'sqdw', width:20, align:'center', halign:'center' ,sortable:true,formatter:dictFormatter,dictName:'<%=basePath %>common/queryOrg?orgCode=210200000000'">申请单位</th>
					        <th data-options="field:'spdw', width:20, align:'center', halign:'center' ,sortable:true,formatter:dictFormatter,dictName:'<%=basePath %>common/queryOrgLower?orgCode=<%=userOrgCode%>'">审批单位</th>
					        <th data-options="field:'sqsj',	width:30, align:'center', halign:'center' ,sortable:true">申请时间</th>
					        <th data-options="field:'spzt', width:20, align:'center', halign:'center', sortable:true, formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_SPZT.js'">审批状态</th>
					        <th data-options="field:'process', width:30, align:'left',	halign:'center',formatter:datagridProcessFormater">操作</th>
					    </tr>
					</thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="0" cellpadding="0" border="0" >
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
										申请编号：<input class="easyui-validatebox" type="text" name="sqbh" id="sqbh" 
												data-options="required:false"  
												style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										线索编号：<input class="easyui-validatebox" type="text" name="xsbh" id="xsbh" 
												data-options="required:false"  
												style="width:160px;" />
									</td>
								</tr>
								<tr>
									<td class="toolbarTd" style="width:250px">
										审批状态：<input class="easyui-combobox" type="text" name="spzt" id="spzt" 
											data-options="required:false,url: contextPath + '/common/dict/D_BZ_SPZT.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
											style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										申请单位：<input class="easyui-combobox" type="text" name="sqdw" id="sqdw" 
												data-options="required:false,url: '<%=basePath %>common/myOrg?type=DZSP',
			    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
												style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										审批单位：<input class="easyui-combobox" type="text" name="spdw" id="spdw" value=<%=userOrgCode %>
												data-options="required:false,url: '<%=basePath %>common/queryOrgHigher?orgCode=<%=userOrgCode%>',
			    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
												style="width:160px;" />
									</td>
								</tr>
								<tr>
									<td class="toolbarTd" align="right" colspan="7" style="padding-right:8px">
										<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
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
		var rows = $('#dg').datagrid('getData');
		var rowData = rows.rows[index];
		
		var process = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="viewDetail(this,'+index+')">查看详细</a>&nbsp;';
		if(rowData.spzt == '0'){
			// 未处理的数据显示该按钮
			process +=  '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="approval(this,'+index+')">审批处理</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
		}
		
		return process;
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
	  	var sqbh = $("#sqbh").val();
	  	var sqdw = $("#sqdw").val();
	  	var spdw = $("#spdw").val();
	  	
		xsbh = $.trim(xsbh);
	  	$('#dg').datagrid(
  			'reload',
  			{   'starttime':starttime,
  				'endtime':endtime,
  				'spzt':spzt,
  				'xsbh':xsbh,
  				'sqbh':sqbh,
  				'sqdw':sqdw,
  				'spdw':spdw
  			});
	 }

	function clearCase(){
		  $("#queryForm").form("reset");
	}
		
	function dbClickRow(rowIndex,rowData){
		var hsUrl = "/xsjbxxb/openDZCK?";
		hsUrl+="xsbh="+rowData.xsbh+"&sqbh="+rowData.id+"&mainTabID="+getMainTabID();
		menu_open("查看详细",hsUrl);
	}

	function reloadDg(){
			$("#dg").datagrid("clearSelections");
			$('#dg').datagrid('reload');
	}

	//审批处理
	function approval(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = "/xsdzspb/approval?";
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		
		hsUrl+="id="+rowData.id+"&sqbh="+rowData.sqbh+"&xsbh="+rowData.xsbh+"&mainTabID="+getMainTabID();
		menu_open("审批处理",hsUrl);
	}

	//查看详细
	function viewDetail(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = "/xsjbxxb/openDZCK?";
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
