<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
	SessionBean userInfo = (SessionBean) session
			.getAttribute("userSession");
	String userOrgCode = "";
	String userOrgName = "";
	String userOrgLevel = "";

	String level1Name = "";
	String level1Code = "";

	String level2Name = "";
	String level2Code = "";

	String level3Name = "";
	String level3Code = "";

	String level4Name = "";
	String level4Code = "";

	if (userInfo != null) {
		userOrgCode = userInfo.getUserOrgCode();
		userOrgName = userInfo.getUserOrgName();
		userOrgLevel = userInfo.getUserOrgLevel();
		if ("10".equals(userOrgLevel) || "20".equals(userOrgLevel)
				|| "30".equals(userOrgLevel)
				|| "40".equals(userOrgLevel)) {
			level1Name = userInfo.getExtendValue("ssDsjName");
			level1Code = userInfo.getExtendValue("ssDsjCode");
		} else if ("21".equals(userOrgLevel)
				|| "31".equals(userOrgLevel)
				|| "41".equals(userOrgLevel)) {
			//市局
			level1Name = userInfo.getExtendValue("ssDsjName");
			level1Code = userInfo.getExtendValue("ssDsjCode");
			//分局
			level2Name = userInfo.getExtendValue("ssFsxName");
			level2Code = userInfo.getExtendValue("ssFsxCode");
		} else if ("32".equals(userOrgLevel)
				|| "42".equals(userOrgLevel)) {
			//市局
			level1Name = userInfo.getExtendValue("ssDsjName");
			level1Code = userInfo.getExtendValue("ssDsjCode");
			//分局
			level2Name = userInfo.getExtendValue("ssFsxName");
			level2Code = userInfo.getExtendValue("ssFsxCode");
			//派出所
			level3Name = userInfo.getExtendValue("ssPcsName");
			level3Code = userInfo.getExtendValue("ssPcsCode");
		} else if ("50".equals(userOrgLevel)) {
			//市局
			level1Name = userInfo.getExtendValue("ssDsjName");
			level1Code = userInfo.getExtendValue("ssDsjCode");
			//分局
			level2Name = userInfo.getExtendValue("ssFsxName");
			level2Code = userInfo.getExtendValue("ssFsxCode");
			//派出所
			level3Name = userInfo.getExtendValue("ssPcsName");
			level3Code = userInfo.getExtendValue("ssPcsCode");
			//责任区
			level4Name = userOrgName;
			level4Code = userOrgCode;
		}

	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>考核系统首页</title>
<script type="text/javascript"
	src="<%=contextPath%>/js/zakh/zakh_zakhIndex.js"></script>
<script type="text/javascript">
var userOrgCode = "<%=userOrgCode%>"; 
var userOrgName = "<%=userOrgName%>";
var userOrgLevel="<%=userOrgLevel%>";
var queryCount=1;

var level1Name= "<%=level1Name%>"; 
var level1Code= "<%=level1Code%>"; 

var level2Name= "<%=level2Name%>"; 
var level2Code= "<%=level2Code%>"; 

var level3Name= "<%=level3Name%>"; 
var level3Code= "<%=level3Code%>"; 

var level4Name= "<%=level4Name%>"; 
var level4Code= "<%=level4Code%>";
</script>
</head>

<body class="easyui-layout" data-options="fit:true">

	<!-- main start -->
	<div class="easyui-layout" data-options="fit:true,border:false">
		<div id="testabc"
			data-options="region:'center',split:true,title:'',border:true"
			style="height:auto">
			<table id="zakh_index_infoList"></table>
			<div id="datagridToolbar" style="padding:5px;height:auto">
				<!-- 表格工具条按钮 -->
				<table cellspacing="0" cellpadding="0" border="0">
					<tbody>
						<tr>
							<td id="zakh_indexDh" class="toolbarTd" align="right"></td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div>
							</td>
							<td class="toolbarTd" align="right">考核年份：</td>
							<td class="toolbarTd"><input id="zakh_index_khnf"
								class="easyui-combobox" value=""
								data-options="valueField: 'id',textField: 'text',width:120,method:'GET',onChange:zakhYear_onChange,url: '<%=basePath%>zakhgetweek/zakhYearJson'" />
							</td>
							<td class="toolbarTd" align="right">考核周：</td>
							<td class="toolbarTd"><input id="zakh_index_khz"
								class="easyui-combobox" value=""
								data-options="valueField: 'id',textField: 'text',width:150,method:'GET',selectOnNavigation:false" />
							</td>
							<td class="toolbarTd"><a href="javascript:void(0)"
								class="easyui-linkbutton" iconCls="icon-query" plain="true"
								onclick="query()">查询</a></td>
							<td class="toolbarTd"><a href="javascript:void(0)"
								class="easyui-linkbutton" iconCls="icon-excel" plain="true"
								onclick="zakh_toExcel()">导出Excel</a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- main end -->
	<!-- gjQue star-->
	<div id="zakh_index_xqWin" class="easyui-window" title=""
		style="width:780px;height:400px;right:200px;top:70px;background:#eee;"
		data-options="modal:false,minimizable:false,maximizable:false,resizable:false,closed:true">
		<div class="easyui-layout" data-options="fit:true,border:false">
			<div data-options="region:'center',split:true,title:'',border:true"
				style="height:auto">
				<table id="zakh_index_xqList"></table>
			</div>
		</div>
	</div>
	<!-- gjQue end-->
</body>
</html>
