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
<title>有效数据统计</title>

<script type="text/javascript">
$(function() {

    query();
});
// 点击查询按钮方法
function query() {
	

	queryUrl = basePath + 'ldym/yxsjtj';

	 this.loadInfo(queryUrl);
	 


}
function loadInfo(queryUrl) {

     $('#yxsjtj_index_infoList').datagrid({
			url : queryUrl,
			toolbar : '#datagridToolbar',
			method : 'post',
			fitColumns : false,
			pagination : false,
			columns : [ [ {
				title : "单位",field : 'gxfjname',rowspan : 2,width : 80},        
				{title : "实有人口",colspan : 5}, 
				{title : "实有房屋",colspan : 3}, 
				{title : "实有单位",colspan : 4}], 
			
			   [{field : "cz",title : "常住",rowspan : 1,width : 40}, 
			    {field : "jz",title : "寄住",rowspan : 1,width : 40},
			    {field : "ld",title : "流动",rowspan : 1,width : 40},
                {field : "jw",title : "境外",rowspan : 1,width : 35},
                {field : "wl",title : "未落",rowspan : 1,width : 35},
                {field : "syfw",title : "实有",rowspan : 1,width : 40},
                {field : "czfw",title : "出租",rowspan : 1,width : 40},
                {field : "czr",title : "承租人",rowspan : 1,width : 50},
                {field : "ldy",title : "旅店",rowspan : 1,width : 40},
                {field : "tzhy",title : "特种",rowspan : 1,width : 40},
                {field : "ylcs",title : "娱乐",rowspan : 1,width : 40},
                {field : "nbdw",title : "内保",rowspan : 1,width : 40}] 
			],
			onLoadSuccess : function() {
			}
		});

}

   
</script>
</head>
<body >
	<div class="easyui-layout" data-options="fit:true,border:false">
	<div id="testabc" data-options="region:'center', split:true,title:''" style="width:550px; border-width: 0px;">
					<!-- 表格工具条按钮 -->
					<table id="yxsjtj_index_infoList"></table>
				    <div id="datagridToolbar" style="padding:5px;height:auto">
					
				    </div>
				</div>
				
				
			</div>
		
</body>
</html>
