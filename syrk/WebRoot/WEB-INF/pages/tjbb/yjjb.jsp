<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>有奖举报统计</title>
  </head>
  <body class="easyui-layout" style="overflow: hidden;height:100%;">
	<div data-options="region:'north',split:false" style="overflow:hidden;height:50px;">
		<form id="queryForm" style="padding:10px;">
				<table cellspacing="0" cellpadding="0" border="0" style="" >
					<tbody>
					   <tr>
							<td class="toolbarTd" style="" align="right">
								受理单位：<input id="cc1" class="easyui-combobox" value="210200000000" maxlength="200" style="width:200px;" 
							         data-options="required:false,url: contextPath + '/common/dict/D_BZ_SLDW.js',
				    						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
							</td>
						
							<td class="toolbarTd"id='ZQ_KStitle'><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd"id='ZQ_KStitle01' style="width:160px" align="right">
								开始时间：<input  type='text' id='ZQ_KS' name='ZQ_KS' class="easyui-validatebox" style="width:90px;"
		  							value="" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" 
		  							data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'"/>
							</td>
							<td class="toolbarTd"id='ZQ_JStitle'><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd"id='ZQ_JStitle01' style="width:160px" align="right">
								结束时间：<input  type='text' id='ZQ_JS' name='ZQ_JS' class="easyui-validatebox" style="width:90px;"
		 							value="" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" 
		 							data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd">
								<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >统计</a>
								<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
							</td>
						 </tr>
					</tbody>
				</table>
			</form>
	</div>
	<div data-options="region:'center'" style="">
			<iframe id="iframe" name="iframe" src="" width="1365px" height="100%" frameborder="0" style="border:0px;"></iframe>
	</div> 
			

	<script type="text/javascript">
	
	$(document).ready(function(){

		$("#ZQ_KS").val(formatdate(new Date()));
		$("#ZQ_JS").val(formatdate(new Date()));
	    $("#iframe").on("load",function(){
			$(document.body).unmask(); 
		});
	});
		function clearCase(){
		  $("#queryForm").form("reset");
		}
		
	function queryButton(){
		
		var fj = "0";
		var ks = "";
		var js = "";
		var  zzjglx = 0;
		ks = $("#ZQ_KS").val();
		js = $("#ZQ_JS").val();
		fj = $("#cc1").val();
		zzjglx = 11;
		if("undefined" == typeof ks || ks == null || ks == '')	{
			
			alert("请选择统计开始时间！！");
			return;
		}
		
		if("undefined" == typeof js || js == null || js == '')	{
			
			alert("请选择统计结束时间！！");
			return;
		}
		
		if("undefined" == typeof fj || fj == null || fj == '')	{
			
			alert("请选择统计单位！！");
			return;
		}
		
		mask();

		var url ="<%=contextPath%>/ReportEmitter?rpt=JLGZ.brt&params=";
		url = url+"ORG_FJ="+fj+";KSSJ="+ks+";JSSJ="+js+";zzjglx="+zzjglx+";dw=1";
		iframe.window.location.href=url;
	}

	function formatdate(date){
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		var day = date.getDate();
		if(month<10){month="0"+month;}
		if(day<10){day="0"+day;}
		return year+"-"+month+"-"+day;
	}
	
	function mask(){
	
		$(document.body).mask("正在加载，可能会比较慢，请稍等...");
	}
	</script>
  </body>
</html>