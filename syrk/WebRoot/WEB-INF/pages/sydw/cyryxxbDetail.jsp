<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!--  
	@updateAuthor: [star]
	@updateDate:   [2015-6-2 上午8:51:54]
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=contextPath%>/js/sydw/cyryxxbDetail.js"></script>
<title>从业人员详细列表</title>
</head>
<body>
	<input type="hidden" id="mode_"	 value="${mode }" />
	<div id="layout_main" class="easyui-layout"  data-options="fit:true,border:false">
		<!-- 从业人员基本信息展示区域 -->
		<div id="panel_north" class="easyui-panel" data-options="region:'north',noheader:true" style="width:700px;height:200px;border:none">
			<div id="layout_north" class="easyui-layout" data-options="fit:true">
				<div id="div_north_west" data-options="region:'west'" style="width:180px;border:none;padding-left:10px;">
					<img id="img_cyry_photo" align="middle" style="width:162px;height:200px" src=""/>
				</div>
				<div id="div_north_center" data-options="region:'center'" style="width:520px;height:250px;padding-left:10px;border:none">
					<table border="0" cellpadding="5" cellspacing="5" width="70%"	align="left">
						<tr>
							<td width="30%" align="right">入职时间：</td>
							<td width="70%" align="left"><font id="text_pyrq"></font></td>
						</tr>
						<tr>
							<td width="30%" align="right">身份证号：</td>
							<td width="70%" align="left"><font id="text_sfzh"></font></td>
						</tr>
						<tr>
							<td width="30%" align="right">姓名：</td>
							<td width="70%" align="left"><font id="text_xm"></font></td>
						</tr>
						<tr>
							<td width="30%" align="right">性别：</td>
							<td width="70%" align="left"><font id="text_xbdm"></font></td>
						</tr>
						<tr>
							<td width="30%" align="right">出生日期：</td>
							<td width="70%" align="left"><font id="text_csrq"></font></td>
						</tr>
						<tr>
							<td width="30%" align="right">居住地址：</td>
							<td width="70%" align="left"><font id="text_dz_xzzxz"></font></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- 从业人员列表展示区域 -->
		<div id="panel_center" border="0" data-options="region:'center',border:false" style="width:700px;border:none;">
			<table id="cyryxxbDetailGrid" class="easyui-datagrid" style="width:700px;height:auto" data-options="url:'<%=contextPath%>/sydwgl/cyryxxb_query_all?dwid=${dwid}',fitColumns:true,singleSelect:true,
    		delayCountUrl:'<%=basePath%>',toolbar:'#cyryxxbDetailGridToolbar',onSelect:loadCyryDetail,onLoadSuccess:dgLoadSuccess,
    		pageSize:getAutoPageSize(300),
            		pageList:[getAutoPageSize(300),
            		getAutoPageSize(300) * 2]">
    			<thead>   
			        <tr>   
			            <th data-options="field:'xm',width:60,align:'center',fixed:true">姓名</th>
			        	<th data-options="field:'zjhm',width:120,align:'center',fixed:true">身份证号码</th>
			        	<th data-options="field:'xbdm',width:40,align:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js'">性别</th>
			            <th data-options="field:'csrq',width:70,align:'center',fixed:true">出生日期</th>
			            <th data-options="field:'pyrq',width:70,align:'center',fixed:true">入职时间</th>   
			            <th data-options="field:'dz_xzzxz',width:230,align:'center'">居住地址</th>
			            <th data-options="field:'dz_xzzdm',hidden:true"></th>
			            <th data-options="field:'process',width:150,align:'center',fixed:true,formatter:datagridProcessFormater">操作</th>   
			        </tr>   
			    </thead>
    		</table>
    		<div id="cyryxxbDetailGridToolbar" style="padding:5px;height:46px;border:none;">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
					<tr>
						<td align="left" width="35%">
							<input type="text" class="searchText" name="condition"  id="condition" value="请输入从业人员姓名、身份证号" 
									style="color:gray;height:25px;font-size:13px;width:100%;min-width:100%"  onclick="setDzqc(this)" />
						</td>
						<td align="left">
							<a href="javascript:void(0)" class="easyui-linkbutton" 
								 iconCls="icon-search" onclick="searchMain()">查询</a>
						</td>
						<td align="right">
							<c:if test="${mode != 'view'}">
								<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="add_cyryxxb();">新增</a>
								<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls=""  onclick="import_cyryxxb();">导入</a>
							</c:if>
							<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls=""  onclick="export_cyryxxb();">导出</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
var dwid='${dwid}';
</script>
</html>