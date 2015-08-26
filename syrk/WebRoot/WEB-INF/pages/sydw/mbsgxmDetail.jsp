<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@CreateDate:   [2015-6-3 下午13:15:54]
	@updateAuthor: [star]
	@updateDate:   [2015-6-5 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=contextPath%>/js/sydw/mbsgxmDetail.js"></script>
<title>民爆实施项目业绩列表</title>
</head>
<body>
	<input type="hidden" id="mode_"	 value="${mode }" />
	<div id="layout_main" class="easyui-layout"  data-options="fit:true,border:false">
		<!-- 从业人员基本信息展示区域 -->
		<div id="panel_north" class="easyui-panel" data-options="region:'north',noheader:true" style="width:700px;height:60px;border:none">
			<div id="layout_north" class="easyui-layout" data-options="fit:true">
				<div id="div_north_center" data-options="region:'center'" style="width:520px;height:60px;padding-left:10px;border:none">
					<table border="0" cellpadding="5" cellspacing="5" width="100%"	align="left">
						<tr>
							<td width="20%" align="right">项目级别：</td>
							<td width="30%" align="left"><font id="text_xmjb"></font></td>
							<td width="20%" align="right">项目名称：</td>
							<td width="30%" align="left"><font id="text_xmmc"></font></td>
						</tr>
						<tr>
							<td width="20%" align="right">爆破施工日期：</td>
							<td width="30%" align="left"><font id="text_bpsgrq"></font></td>
							<td width="20%" align="right">第一设计人：</td>
							<td width="30%" align="left"><font id="text_dysjr"></font></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- 从业人员列表展示区域 -->
		<div id="panel_center" border="0" data-options="region:'center',border:false" style="width:700px;border:none;">
			<table id="mbsgxmDetailGrid" class="easyui-datagrid" style="width:700px;height:auto" data-options="url:'<%=contextPath%>/sydwgl/mbsgxm_query_all?dwid=${dwid}',fitColumns:true,singleSelect:true,
	    		delayCountUrl:'<%=basePath%>',toolbar:'#mbsgxmDetailGridToolbar',onSelect:loadMbsgxmDetail,onLoadSuccess:dgLoadSuccess,
	    		pageSize:getAutoPageSize(300),pageList:[getAutoPageSize(300),getAutoPageSize(300) * 2]">
    			<thead>   
			        <tr>   
			            <th data-options="field:'xmjb',width:120,align:'center',fixed:true">项目级别</th>
			        	<th data-options="field:'xmmc',width:120,align:'center',fixed:true">项目名称</th>
			            <th data-options="field:'bpsgrq',width:100,align:'center',fixed:true">爆破施工日期</th>
			            <th data-options="field:'dysjr',width:100,align:'center',fixed:true">第一设计人</th>   
			            <th data-options="field:'process',width:150,align:'center',fixed:true,formatter:datagridProcessFormater">操作</th>   
			        </tr>   
			    </thead>
    		</table>
    		<div id="mbsgxmDetailGridToolbar" style="padding:5px;height:46px;border:none;">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
					<tr>
						<td align="left" width="35%">
							<input type="text" class="searchText" name="condition"  id="condition" value="请输入项目名称" 
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