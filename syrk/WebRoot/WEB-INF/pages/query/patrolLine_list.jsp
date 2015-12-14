<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
	String deptId=request.getParameter("deptId");
%>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v = "urn:schemas-microsoft-com:vml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<script type="text/javascript">
			var deptId='<%=deptId%>';
			var mapWin=null;
			
			$(function(){
				if(deptId==''){
					$('#patrolLineList').datagrid('loadData',[]);
					return;
				}
				var url ='<%=basePath %>alermAnalyse_patrolLineOpe?opeFlag=getList&orgId='+deptId;   
				$('#patrolLineList').datagrid({url:url});
				$('#patrolLineList').datagrid('reload');
				if (IE) {
					mapWin = parent.frames["biz_center"];
				}else {
					mapWin = parent.frames.document.getElementById("biz_center").contentWindow;
				}
			});
			
			var reloadDG=function(){
				var url ='<%=basePath %>alermAnalyse_patrolLineOpe?opeFlag=getList&orgId='+deptId;    
				$('#patrolLineList').datagrid({url:url});
				$('#patrolLineList').datagrid('reload');
			};
			
			var patrolLineListOpeFormater=function(val, row, index){
				var format= '<table cellpadding="0" cellspacing="0"><tr>'+
							'<td><img src="<%=basePath %>images/patrolLine/patrolInfo.png" style="width:20px;height:20px;"/></td>'+
							'<td Valign="middle"><a href="javascript:void(0)" onclick="showPatrolPlan(this, \''+row.id+'\')">巡逻计划执行情况</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>'+
							'<td><img src="<%=basePath %>images/patrolLine/patrolModify.png" style="width:20px;height:20px;"/></td>'+
							'<td Valign="middle"><a href="javascript:void(0)" onclick="modifyPatrolLine(this, \''+row.id+'\')">巡逻点变更</a></td>'+
							'</tr></table>';
				return format;
			};
			//巡逻路线轨迹显示
			var draw_patrolLineBySites=function(sites){
				mapWin.patrolLine_draw_patrolLineBySites(sites);
			};
			//显示巡逻计划统计
			var showPatrolPlan=function(linkObject,code){
				var bdate=parent.frames['xllx'].document.getElementById('bdate').value;
				var edate=parent.frames['xllx'].document.getElementById('edate').value;
				if(edate==''||bdate==''){
					alert('请选择日期！');
					return;
				}
				if(edate<bdate){
					alert('结束日期不能小于开始日期！');
					return;
				}
				mapWin.patroLine_showPatrolPlan(linkObject,code,bdate,edate);
			};
		
			//----------------------------------------------------巡逻路线更新
			var modifyPatrolLine=function(linkObject,code){
				if(parent.frames['xllx'].aut==0){
					alert('您没有此操作权限！');
					return;
				}
				var dept1='210200000000';
				var dept2=parent.frames['xllx'].document.getElementById('dept2').value;
				var dept3=parent.frames['xllx'].document.getElementById('dept3').value;
				var orgId=dept3==''?dept2==''?dept1:dept2:dept3;
				var dgdata=$('#patrolLineList').datagrid('getData');
				mapWin.patroLine_modifyPatrolLine(linkObject,code,orgId,dgdata);
			};
		</script>
	</head>
	<body>
		<table id="patrolLineList" class="easyui-datagrid" style="width:270px;height:320px" 
		        data-options="url:'',fitColumns:true,pagination:false,rownumbers:'true',singleSelect:true,onDblClickRow:function(rowIndex, rowData){
		        	draw_patrolLineBySites(rowData.sites);
		        }">   
		    <thead>
		        <tr>   
		            <th data-options="field:'id',width:50,align:'center',halign:'center'">编号</th>   
		            <th data-options="field:'name',width:140,align:'center',halign:'center'">名称</th>   
		            <th data-options="field:'ope',width:60,align:'center',halign:'center',formatter:patrolLineListOpeFormater" >操作</th>  
		            <th data-options="field:'sites',hidden:true,width:0,align:'center',halign:'center'" ></th>  
		        </tr>   
		    </thead>   
		</table>
	</body>
</html>