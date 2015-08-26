<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/qbld/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgName = "";
    String userName = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName = userInfo.getUserOrgName();
        userName = userInfo.getUserName();
        bjzbz = userInfo.getBjzbz();
    }
 %>
<html>
  <head>
    <title>预警信息</title>
    <script type="text/javascript" src="<%=contextPath%>/js/qbld/xxfb.js" ></script>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/qbld/xxfb.css">
    <script type="text/javascript">
    	var userOrgCode = "<%=userOrgCode%>";
    	var userOrgName = "<%=userOrgName%>";
   		var userName = "<%=userName%>";
    	$(function(){
    		$('#win').window('close');
    		Xxfb.queryXxfbLx();
 		});
    </script>
  </head>
  <body>
	<ul id="xxfbUl">
    </ul>
    
   <div id="win" class="easyui-window" title="更多信息" style="top:10px;width:450px;height:450px"   
        data-options="iconCls:'icon-query',modal:true,collapsible:false,
	    minimizable:false">   
	    <div class="easyui-layout" data-options="fit:true">   
	        <div data-options="region:'north',split:true" style="height:130px" align="center">
	        	<form id="queryForm" >
		        	<table>
		        		<tr><td>信息分类：</td><td id="flmcTd"></td></tr>
		        		<tr><td>标题：</td><td><input id="where_title" name="title"  style="width:100%"/></td></tr>
		        		<tr><td>发布日期：</td><td><input  id="where_createtimeB" name="createtimeB"  style="width:150px;" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"  >-
		        	<input id="where_createtimeE" name="createtimeE" style="width:150px;"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" ></td></tr>
		        		<tr>
		        			<td colspan=2 align="center">
		        			<a href="#"  class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="Xxfb.queryMoreXx();" >查询</a>
		        			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="document.forms['queryForm'].reset();" >重置</a>
		        			</td>
		        		</tr>
		        	</table>
	        	</form>
	        </div>   
	        <div data-options="region:'center'">   
	            <table id="infoGrid" class="easyui-datagrid" style="width:400px;height:250px"   
			        data-options="fit:true,
			        		url:'<%=contextPath%>/xxfb/queryArticleList',
			        		queryParams:{subject:'1'},
							fitColumns : true,
							pagination : true,
							singleSelect : true,
							showFooter:true,
							striped:true,
							rownumbers:true,
							pageSize:10,
							onClickRow:function(index,row){Xxfb.openXxInfoWindow(row.objectid)}">   
				    <thead>   
				        <tr>   
				            <th data-options="field:'title',width:200,align:'center'">标题</th>   
				            <th data-options="field:'createtime',width:100,align:'center'">发布日期</th>   
				        </tr>   
				    </thead>   
				</table> 
	        </div>   
	    </div>   
	</div>  
  </body>
</html>
