<!--  
	@Author:       [wu.w@founder.com.cn]
	@CreateDate:   [2015-5-15 上午8:51:54]
	@review      : tian_chengwei@founder.com.cn
    @reviewDate  : 20150604 
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>开具证明管理</title>
	</head>
	<body class="easyui-layout bodybg" data-options="fit:true" style="margin-top:20px;margin-bottom:10px">
       	<div data-options="region:'center',split:true,title:'比对查询',border:true" style="height:auto" align="center">
       		<table id="queryTB" style="width: 600px;margin-top: 20px">
       			<tr height="30px"><td>身份证号:</td><td>
       				<input class="easyui-validatebox" type="text" id="sfzh" style="width:200px;float:left;" maxlength="18" 
						   data-options="required:true
						   				,charSet:'halfUpper'
						   				,validType:['sfzh']
						   				,invalidMessage:'请输入正确的身份证号码'
						   				,tipPosition:'right'" />
       			</td></tr>
       			<tr height="30px"><td colspan="2">
       				<input type="checkbox" name="zyk" value="1" checked="checked"/>全国违法犯罪人员库
					<input type="checkbox" name="zyk" value="2" checked="checked"/>吸毒人员库
					<input type="checkbox" name="zyk" value="3" checked="checked"/>重点人员库
					<input type="checkbox" name="zyk" value="4" checked="checked"/>全国在逃人员库
       			</td></tr>
       			<tr height="30px"><td colspan="2">
       				<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="query()">搜索</a>
       			</td></tr>
       		</table>
       		<div id="querying" style="display: none">查询中请稍候。。。</div>
       		<table id="resTB" style="width: 600px;margin-top: 50px;display: none">
       			<tr style="height: 20px;background-color: #eeffee"><td>身份证号：<span id="resSfz"></span></td></tr>
       			<tr><td>查询结果如下：</td></tr>
       			<tr><td id="zykRes1"></td></tr>
       			<tr><td id="zykRes2"></td></tr>
       			<tr><td id="zykRes3"></td></tr>
       			<tr><td id="zykRes4"></td></tr>
       		</table>
       	</div>
	</body>
	<script type="text/javascript" src="<%=contextPath%>/js/zafffwqz/kjzmgl.js"></script>
</html>