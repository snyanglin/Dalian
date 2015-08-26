<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>举报奖励待申请列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body class="easyui-layout" data-options="fit:true">
	    <div data-options="region:'center',border:false">
	    	<div class="easyui-layout" data-options="fit:true,border:false">   
	            <div data-options="region:'center',split:true,title:'举报奖励待申请列表',border:true" style="height:auto">
				<table id="dg" class="easyui-datagrid" data-options="url:'<%=basePath %>xsajgxb/queryList',toolbar:'#datagridToolbar',
				            singleSelect:false,
				            selectOnCheck:true,checkOnSelect:true,border:false,sortOrder:'desc',sortName:'xt_zhxgsj',
				            	idField:'id',pageSize:getAutoPageSize(175),pageList:[getAutoPageSize(175),getAutoPageSize(175) * 2],
				            	onDblClickRow:dbClickRow
				            	">
					<thead>
					    <tr>
					    	<th data-options="field:'xsbh', width:20,	align:'center',	halign:'center'	,sortable:true">线索编号</th>
				            <th data-options="field:'ajbh', width:20,	align:'center',	halign:'center'	,sortable:true">案件编号</th>
				            <th data-options="field:'ajmc',	width:20,	align:'center',	halign:'center'	,sortable:true">案件名称</th>
				            <th data-options="field:'xt_lrrbm',	width:20,	align:'center',	halign:'center'	,sortable:true">办案单位</th>
				            <th data-options="field:'sfffjl',	width:20,	align:'center',	halign:'center'	,sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_SFFFJL.js'">是否已申请奖励</th>
				            <th data-options="field:'process',	width:10,   align:'center',	halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
					</thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm" style="margin:0px;">
						<table cellspacing="0" cellpadding="0" border="0" width="100%" >
							<tbody>
								<tr>
									<td class="toolbarTd" style="width:250px">
										线索编号：<input class="easyui-validatebox" type="text" name="xsbh" id="xsbh" 
											data-options="required:false"  style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:250px">
										案件编号：<input class="easyui-validatebox" type="text" name="ajbh" id="ajbh" 
											data-options="required:false" style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:280px">
										是否提交申请：<input class="easyui-combobox" type="text" name="sfffjl" id="sfffjl" 
											data-options="required:false,url: contextPath + '/common/dict/D_BZ_SFFFJL.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"  
											style="width:160px;" />
									</td>
								</tr>
								<tr>
									<td class="toolbarTd" style="width:280px">
										办案单位：<input class="easyui-combobox" type="text" name="badw" id="badw" 
												 data-options="required:false,url: '<%=basePath %>common/myOrg?type=JLDSQ',
			    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"
												style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" style="width:250px">
										案件名称：<input class="easyui-validatebox" type="text" name="ajmc" id="ajmc" 
											data-options="required:false" style="width:160px;" />
									</td>
									<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
									<td class="toolbarTd" align="left" colspan="7" style="padding-right:8px">
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
		if(rowData.sfffjl == '0'){
			return  '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="jlSq(this,'+index+')">申请奖励</a>&nbsp;';
		}else if(rowData.sfffjl == '1'){
			return  '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">查看</a>&nbsp;';
		}
	}

	var windowID = null;
	function doInit(paramArray) {
		windowID = paramArray['windowID'];
	}

	//查询按钮
	function queryButton(){
		
	  	var xsbh = $("#xsbh").val();
	  	var ajbh = $("#ajbh").val();
	  	var ajmc = $("#ajmc").val();
	  	var badw = $("#badw").val();
	  	var sfffjl = $("#sfffjl").val();
	  	
	  	$('#dg').datagrid(
  			'reload',
  			{   'xsbh':xsbh,
  				'ajbh':ajbh,
  				'ajmc':ajmc,
  				'badw':badw,
  				'sfffjl':sfffjl
  			});
	 }

	function clearCase(){
		  $("#queryForm").form("reset");
	}
		
	function dbClickRow(rowIndex,rowData){
			if(rowData.sfffjl == '0'){
				var hsUrl = "/jbjlxxb/jlSq?";
				hsUrl+="xsbh="+rowData.xsbh+"&ajbh="+rowData.ajbh+"&ajSource="+rowData.ajsource+"&id="+rowData.id+"&mainTabID="+getMainTabID();
				menu_open("举报奖励申请",hsUrl);
			}else{
				$.ajax({
					type:"GET",
					url:contextPath+"/jlxxb/queryId",
					dataType:"json",
					data:"xsbh="+rowData.xsbh+"&ajbh="+rowData.ajbh,
					success:function(data){
						var hsUrl = "/jlxxb/openAdd?";
						hsUrl+="id="+data.appId+"&mainTabID="+getMainTabID();
						menu_open("查看申请",hsUrl);
					}
				});
			}
			
			
	}

	function reloadDg(){
			$("#dg").datagrid("clearSelections");
			$("#dg").datagrid("reload");
	}
	//跳转到奖励申请页面
	function jlSq(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var hsUrl = "/jbjlxxb/jlSq?";
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		
		hsUrl+="xsbh="+rowData.xsbh+"&ajbh="+rowData.ajbh+"&ajSource="+rowData.ajsource+"&id="+rowData.id+"&mainTabID="+getMainTabID();
		menu_open("举报奖励申请",hsUrl);
  }
	
	function doEdit(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		$.ajax({
			type:"GET",
			url:contextPath+"/jlxxb/queryId",
			dataType:"json",
			data:"xsbh="+rowData.xsbh+"&ajbh="+rowData.ajbh,
			success:function(data){
				var hsUrl = "/jlxxb/openAdd?";
				var datagrid_ID = getDatagrid_ID(0, linkObject);
				var opts = $('#' + datagrid_ID).datagrid("options");
				var rows = $('#' + datagrid_ID).datagrid('getData');
				var rowData = rows.rows[index];
				
				hsUrl+="id="+data.appId+"&mainTabID="+getMainTabID();
				menu_open("查看申请",hsUrl);
			}
		});
		
		
	  }
    </script>
  	</body>
</html>
