<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
	String dept=request.getParameter("dept");
	String btime=request.getParameter("btime");
	String etime=request.getParameter("etime");
	String cjfs=request.getParameter("cjfs");
	String jqlb=request.getParameter("jqlb");
%>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v = "urn:schemas-microsoft-com:vml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<script type="text/javascript">
			$(function(){
				if('<%=dept %>'==''||'<%=dept %>'=='null'){
					return;
				}
				var url ='<%=basePath %>/forward/query|alermAnalysis_getListData?dept=<%=dept %>&btime=<%=btime %>&etime=<%=etime %>&cjfs=<%=cjfs %>&jqlb=<%=jqlb %>';
				$('#alermCountList').datagrid({url:url});
				$('#alermCountList').datagrid('reload');
			});
		</script>
	</head>
	<body>
		<table id="alermCountList" class="easyui-datagrid" style="width:270px;height:320px" data-options="url:'',fitColumns:true,rownumbers:'true',singleSelect:true,pagination:false">   
		    <thead>
		        <tr>   
		            <th data-options="field:'area',width:50,align:'center',halign:'center'">区域</th>   
		            <th data-options="field:'count',width:140,align:'center',halign:'center'">数量</th>   
		        </tr>   
		    </thead>   
		</table>
	</body>
</html>