<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>

<html >
<head>
	<%
		String path = request.getContextPath();
	/* 	String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/"; */
	%>
	<title>人口查询</title>
	<style type="text/css">
		.infoTable {
			font-size: 15px;
			font-family: Microsoft YaHei;
			text-align: left;
		}
		
		.infoTable1 {
			font-size: 16px;
			font-family: Microsoft YaHei;
			text-align: left;
		}
		.div_info_item {
			width: 60px;
			height: 48px;
			background-color: #b8b8b8;
			text-align: center;
			font-size: 12px;
			line-height: 20px;
			margin-top: 20px;
			font-weight: normal;
		}
		.li_value{
			list-style-type: none;
			float:left;
			width: 80px;
			height:16px;
			line-height:16px;
			word-break:break-all;
			text-align: left;
			margin-top:4px;
			font-size: 12px;
		}
		td.info_item {
			word-wrap: break-word;
			word-break: normal;
			width: 42px;
			padding-left: 7px;
		}
		td.info_item_not_break: {
			padding-left: 7px;
		}
	</style>
	
	<script type="text/javascript">
		var path="<%=path%>";
		//var tableHeight = $(window).height() -150;
		
	</script>
	
	<script type="text/javascript" src="<%=contextPath%>/js/zykc/zykcSearch.js"></script>
	
</head>

<body class="easyui-layout" data-options="fit:true,border:false">

	<!-- 平面左侧操作区域 -->
	<div data-options="region:'west',border:false" style="width:550px;">
	
		<!-- 顶部导航 -->
		<table>
			<tr>
				<td class="info_item">
					<div class="div_info_item">
						法定不准<br>出境人员
					</div>
				</td>
			</tr>
		</table>
		
		<!-- 查询页面 -->
		<div id="searchDiv" style="width:auto;padding:5px;height:auto;positon:absolute">
			<form id="queryForm">
				<table cellspacing="0" cellpadding="0" border="0">
					<tr class="dialogTr" >
						<td width="240px"  style="text-align: center;height: 40px" colspan="2">
							<span style="font-size:20px;">法定不准出境人员</span>
						</td>
					</tr>
					<tr class="dialogTr" >
						<td width="80px" align="right">身份证号码：</td>
						<td width="160px"  align="left">
							<input class="easyui-validatebox" type="text" id="sfzhm" name="sfzhm" style="width:200px;" 
							data-options="validType:['maxLength[18]'],invalidMessage:'请输入身份证号码，长度不能超过18位',tipPosition:'right'" />
						</td>
					</tr>
					<tr class="dialogTr" style="height: 40px;">
						<td width="80px"  align="right">中文姓名：</td>
						<td width="160px" align="left"><input
							class="easyui-validatebox" type="text" id="zwxm" name="zwxm"
							style="width:200px;"
							data-options="validType:['maxLength[50]'],invalidMessage:'',tipPosition:'right'" />
						</td>
					</tr>
					<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;" align="right">
						<td align="right" colspan="2" style="width: 100%;">
							<a class="easyui-linkbutton"  id="query" iconCls="icon-ok" >查询</a>
							&nbsp;&nbsp;
							<a id="reset" class="easyui-linkbutton" iconCls="icon-reset" onclick="reset()">重置</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<!-- 数据表格展现 -->
	    <div id="dataList" data-options="region:'west',border:false" style="width:510px;height: 600px;">
	    <div style="width: 100%;text-align: right;">
	    	<a id="buttonBack" class="easyui-linkbutton" onclick="back()">返回</a>
	    </div>
	        <div id="bbtjgrid" class="easyui-datagrid" style="width:510px;" ></div>
        </div>
		
	</div>
	
	<!-- 平面右侧详细信息展现 -->
	<div data-options="region:'center',border:false" >
		<div id="detailDiv" data-options="region:'center',border:false" style="width:750px;display:none">
			<img class="topPhoto" id="topPhotoid" width="162px" height="200px" alt="" style="float: left;margin-top: 50px;" />
			<table border="0" cellpadding="0" cellspacing="10" style="float: right;margin-top: 50px;" >
				<tr class="dialogTr">
					<td width="80px"  colspan="2" align="right">姓名：</td>
					<td width="100px" colspan="2" ><span style="text-align: left;" id="zwm"/></td>
				</tr>
				<tr class="dialogTr">
				  	<td width="80px"  colspan="2" align="right">档案号：</td>
				  	<td width="100px" colspan="2"><span style="text-align: left;" id="dah"/></td> 
				</tr>
				<tr class="dialogTr">
					<td width="80px"  align="right">身份证号码：</td>
					<td width="100px" ><span style="text-align: left;" id="sfzhm1"/></td> 
					<td width="80px"  align="right">性别：</td>
					<td width="100px" ><span style="text-align: left;"  id="xb"/></td> 
				</tr>
				<tr class="dialogTr">
					<td width="80px"  align="right">户口所在地：</td>
					<td width="100px" ><span style="text-align: left;"  id="hkszd"/></td> 
					<td width="80px"  align="right" >出生地：</td>
					<td width="100px" ><span style="text-align: left;"  id='csd'/></td> 
				</tr>
				<tr class="dialogTr">
			    	<td width="80px"  align="right" >证件种类：</td>
			    	<td width="100px" ><span style="text-align: left;" id="zjzl"/></td> 
			    	<td width="80px"  align="right" >证件号码：</td>
			    	<td width="100px" ><span id="zjhm1" style="width:200px"/></td> 
				</tr>
				<tr class="dialogTr">
			    	<td width="80px"  align="right" >派出所：</td>
			    	<td width="100px" ><span style="text-align: left;" id="pcsszd"/></td> 
			    	<td width="80px"  align="right">密级：</td>
			    	<td width="100px" ><span style="text-align: left;" id="mj"/></td> 
				</tr>
				<tr class="dialogTr">
			    	<td width="80px"  colspan="2" align="right">工作单位：</td>
			    	<td width="100px" colspan="2" ><span style="text-align: left;" id="gzdw"/></td> 
				</tr>
				<tr class="dialogTr">
			    	<td width="80px"  colspan="2" align="right">现住址：</td>
			    	<td width="100px" colspan="2"><span style="text-align: left;" id="xzz"/></td> 
				</tr>
				<tr class="dialogTr">
			    	<td width="80px"  align="right">单位电话：</td>
			    	<td width="100px" ><span style="text-align: left;" id="dwdh"/></td> 
			    	<td width="80px"  align="right">家庭电话：</td>
			    	<td width="100px" ><span style="text-align: left;" id="jtdh"/></td> 
				</tr>
				<tr class="dialogTr">
			    	<td width="80px"  align="right">法律依据：</td>
			    	<td width="100px" ><span style="text-align: left;" id="flyj"/></td> 
			    	<td width="80px"  align="right">自动撤控：</td>
			    	<td width="100px" ><span style="text-align: left;" id='zdck'/></td> 
				</tr>
				<tr class="dialogTr">
			    	<td width="80px"  colspan="2" align="right">报备原因：</td>
			    	<td width="100px" colspan="2"><span style="text-align: left;" id="bbyy"/></td> 
				</tr>
				<tr class="dialogTr">
			    	<td width="80px"  align="right">报备单位：</td>
			    	<td width="100px" ><span style="text-align: left;" id="bbdwbm"/></td> 
			    	<td width="80px"  align="right">报备联系人：</td>
			    	<td width="100px" ><span style="text-align: left;" id="bblxr"/></td> 
				</tr>
				<tr class="dialogTr">
			    	<td width="80px"  align="right">报备联系电话：</td>
			    	<td width="100px" ><span style="text-align: left;" id='bblxdh'/></td> 
			    	<td width="80px"  align="right">报备人员类别：</td>
			    	<td width="100px" ><span style="text-align: left;" id="bbrylb"/></td> 
				</tr>
				<tr class="dialogTr">
			    	<td width="80px"  align="right">报备日期：</td>
			    	<td width="100px" ><span style="text-align: left;" id="bbrq"/></td> 
			    	<td width="80px"  align="right">报备期限：</td>
			    	<td width="100px" ><span style="text-align: left;" id="bbqx"/></td> 
				</tr>
				<tr class="dialogTr">
			    	<td width="80px" colspan="2"  align="right">备注：</td>
			    	<td width="100px" colspan="2"><span style="text-align: left;" id="bz"/></td> 
				</tr>
			</table>
		</div>	
	</div>
</body>


</html>