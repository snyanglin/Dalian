<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>工作量统计首页</title>

<script type="text/javascript">
$(function() {

    query();
});
// 点击查询按钮方法
function query() {
	

	queryUrl = basePath + 'ldym/count';

	 this.loadInfo(queryUrl);
	 


}
function loadInfo(queryUrl) {

     $('#gzltj_index_infoList').datagrid({
			url : queryUrl,
			toolbar : '#datagridToolbar',
			method : 'post',
			fitColumns : false,
			pagination : false,
			columns : [ [ {
				title : "单位",field : 'gxfjname',rowspan : 2,width : 150},        
				{title : "实有人口",colspan : 3}, 
				{title : "实有房屋",colspan : 3}, 
				{title : "实有单位",colspan : 3}], 
			
			   [{field : "syrkAdd",title : "新增",rowspan : 1,width : 40}, 
			    {field : "syrkUpdate",title : "修改",rowspan : 1,width : 40},
			    {field : "syrkDelete",title : "注销",rowspan : 1,width : 40},
                {field : "syfwAdd",title : "新增",rowspan : 1,width : 40},
                {field : "syfwUpdate",title : "修改",rowspan : 1,width : 40},
                {field : "syfwDelete",title : "注销",rowspan : 1,width : 40},
                {field : "sydwAdd",title : "新增",rowspan : 1,width : 40},
                {field : "sydwUpdate",title : "修改",rowspan : 1,width : 40},
                {field : "sydwDelete",title : "注销",rowspan : 1,width : 40}] 
			],
			onLoadSuccess : function() {
			}
		});

}

   
</script>
</head>
<body >
	<div class="easyui-layout" data-options="fit:true,border:false">
	<div id="testabc" data-options="region:'center', split:true,title:''" style="width:500px; border-width: 0px;">
					<!-- 表格工具条按钮 -->
					<table id="gzltj_index_infoList"></table>
				    <div id="datagridToolbar" style="padding:5px;height:auto">
					
				    </div>
				</div>
				
				
			</div>
		
</body>
</html>
