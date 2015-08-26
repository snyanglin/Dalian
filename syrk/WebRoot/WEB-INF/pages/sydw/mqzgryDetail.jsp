<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!--  
	@updateAuthor: [star]
	@updateDate:   [2015-6-2 上午8:51:54]
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>民枪专管人员列表</title>
</head>
<script type="text/javascript" src="<%=contextPath%>/js/sydw/mqzgryDetail.js"></script>
<body>
	<input type="hidden" id="mode_"	 value="${mode }" />
	<div id="layout_main" class="easyui-layout"  data-options="fit:true,border:false">
		<!-- 从业人员基本信息展示区域 -->
		<div id="panel_north" class="easyui-panel" data-options="region:'north',noheader:true" style="width:700px;height:160px;border:none">
			<div id="layout_north" class="easyui-layout" data-options="fit:true">
				<div id="div_north_center" data-options="region:'center'" style="width:520px;height:60px;padding-left:10px;border:none">
					<table border="0" cellpadding="5" cellspacing="5" width="100%"	align="left">
						<tr>
							<td width="20%" align="right">姓名：</td>
							<td width="30%" align="left"><font id="text_xm"></font></td>
							<td width="20%" align="right">证件号码：</td>
							<td width="30%" align="left"><font id="text_zjhm"></font></td>
						</tr>
						<tr>
							<td width="20%" align="right">联系电话：</td>
							<td width="30%" align="left"><font id="text_lxdh"></font></td>
							<td width="20%" align="right">职责：</td>
							<td width="30%" align="left"><font id="text_zz"></font></td>
						</tr>
						<tr>
							<td width="20%" align="right">审批机关：</td>
							<td width="30%" align="left"><font id="text_spjg"></font></td>
							<td width="20%" align="right">审批人：</td>
							<td width="30%" align="left"><font id="text_spr"></font></td>
						</tr>
						<tr>
							<td width="20%" align="right">审批日期：</td>
							<td width="30%" align="left"><font id="text_sprq"></font></td>
						</tr>
						<tr>
							<td width="20%" align="right">备注：</td>
							<td width="80%" align="left" colspan='3'><font id="text_bz"></font></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- 从业人员列表展示区域 -->
		<div id="panel_center" border="0" data-options="region:'center',border:false" style="width:700px;border:none;">
			<table id="mqzgryDetailGrid" class="easyui-datagrid" style="width:700px;height:auto" data-options="url:'<%=contextPath%>/sydwgl/mqzgry_query_all?dwid=${dwid}',fitColumns:true,singleSelect:true,
		    		delayCountUrl:'<%=basePath%>',toolbar:'#mqzgryDetailGridToolbar',onSelect:loadMqzgryDetail,onLoadSuccess:dgLoadSuccess,
		    		pageSize:getAutoPageSize(300),pageList:[getAutoPageSize(300),getAutoPageSize(300) * 2]">
    			<thead>   
			        <tr>   
			            <th data-options="field:'xm',width:120,align:'center',fixed:true">姓名</th>
			        	<th data-options="field:'xb',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js',width:80,align:'center',fixed:true">性别</th>
			            <th data-options="field:'zjhm',width:120,align:'center',fixed:true">证件号码</th>
			            <th data-options="field:'lxdh',width:120,align:'center',fixed:true">联系电话</th>  
						<th data-options="field:'zz',width:140,align:'center',fixed:true">职责</th>  
			            <th data-options="field:'process',width:120,align:'center',fixed:true,formatter:datagridProcessFormater">操作</th>   
			        </tr>   
			    </thead>
    		</table>
    		<div id="mqzgryDetailGridToolbar" style="padding:5px;height:46px;border:none;">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
					<tr>
						<td align="left" width="35%">
							<input type="text" class="searchText" name="condition"  id="condition" value="请输入姓名、身份证号" 
									style="color:gray;height:25px;font-size:13px;width:100%;min-width:100%"  onclick="setDzqc(this)" />
						</td>
						<td align="left">
							<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchMain()">查询</a>
						</td>
						<td align="right">
							<c:if test="${mode != 'view'}">
								<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add"  onclick="add();">新增</a>
							</c:if>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
var dwid="${dwid}";
</script>
</html>