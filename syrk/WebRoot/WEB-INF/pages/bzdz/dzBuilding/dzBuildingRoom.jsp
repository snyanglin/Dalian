<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	  <title>房间信息展示</title>
	  <script type="text/javascript">
		 var chdzid = "${chdzid}"
	  </script>
	  <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/bzdz.css"></link>
	  <script type="text/javascript" src="<%=contextPath%>/js/bzdz/dzBuilding/dzBuildingRoom.js"></script>
</head>
<body style="overflow: hidden;">
	<div class="easyui-tabs" data-options="border:false">
	    <div title="人员信息">
	        <table class="tabid" style='border-collapse: collapse; padding: 0; margin: 0 auto;'>
				<tr>
				    <td align='center' width="120px;" class="td" nowrap="nowrap">证件种类</td>
					<td id="zjzl" width="150px;"></td>
					<td align='center' width="120px;" class="td" nowrap="nowrap">证件号码</td>
					<td id="zjhm" width="150px;"></td>
					<td id="thphoto" width="132px;" height="160px;" rowspan='6'></td>
				</tr>
				<tr>
				    <td align='center' class="td" nowrap="nowrap">姓名</td>
					<td id="xm"></td>
					<td align='center'class="td" nowrap="nowrap">性别</td>
					<td id="xb"></td>
				</tr>
				<tr>
				    <td align='center' class="td" nowrap="nowrap">出生日期</td>
					<td id="csrq"></td>
					<td align='center' class="td" nowrap="nowrap">民族</td>
					<td id="mz"></td>
				</tr>
				<tr>
				    <td align='center' class="td" nowrap="nowrap">国籍</td>
					<td id="gj"></td>
					<td align='center' class="td" nowrap="nowrap">籍贯</td>
					<td id="jg"></td>
				</tr>
				<tr>
					<td align='center' class="td" nowrap="nowrap">户籍地址</td>
					<td id="hjdz" colspan="3"></td>
				</tr>
				<tr>
					<td align='center' class="td" nowrap="nowrap">居住地址</td>
					<td id="jzdz" colspan="3"></td>
				</tr>
				<tr>
				   <table style="width: 100%;height: 201px">
				     <tr>
				       <td>
				          <table id="ryList"></table>
				       </td>
				     </tr>
				   </table>
				</tr>
				<tr>
				   <div id="xjzryzpDiv" style="height: 140;overflow:auto">
					 <ul id="xjzryzp"></ul>
				   </div>
				</tr>
			</table>
		</div>
		<div title="单位信息" style="height: 535px;">
          <table id="dg" class="easyui-datagrid" 
           	data-options="url:'<%=basePath %>sydwcx_dl/queryDw?flag=jsq',
	           		delayCountUrl:'<%=basePath %>sydwcx_dl/queryCountDw?flag=jsq',
	           		queryParams: {dz_dwdzdm:'${chdzid}'},   		
	           		selectOnCheck:true,
	        		checkOnSelect:true,
	        		rownumbers:true,
	        		border:false,
	        		sortOrder:'desc',
	        		singleSelect:true,
	        		fitColumns:false,
	        		nowrap:true">
			    <thead>
			        <tr>
			            <th data-options="field:'dwlbdm',width:100,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_DW_DWLB.js',sortable:true">类别</th>
			            <th data-options="field:'dwmc',width:170,align:'left',halign:'center'">单位名称</th>
			            <th data-options="field:'dz_dwdzxz',width:280,align:'left',halign:'center'">单位地址</th>
			            <th data-options="field:'process',width:60,align:'center',halign:'center',formatter:DzBuildingRoom.datagridDw">操作</th>
			        </tr>
			    </thead>
		   </table>
		</div>
	</div>
</body>
</html>