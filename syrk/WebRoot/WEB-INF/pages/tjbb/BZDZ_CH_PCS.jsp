<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>标准地址统计</title>
  </head>
  <body class="easyui-layout" style="overflow: hidden;height:100%;">
      <div data-options="region:'center',split:true,title:'',border:true" style="height:auto">
      		<input type="hidden" id="orgcode" value="${userSession.userOrgCode}">
			<form id="queryForm">
				<table cellspacing="0" cellpadding="0" border="0" width="1000" style="padding: 10px;" >
					<tbody>
					   <tr>
							<td class="toolbarTd" style="width:150px" align="left">
								分局：<input id="cc1" class="easyui-combobox"
							         data-options="valueField: 'id',textField: 'text',width:140,url: '<%=basePath %>gzjk/queryOrg',onSelect: function(rec){var url = '<%=basePath %>gzjk/queryOrgLower?orgCode='+rec.id;$('#cc2').combobox('reload', url);}"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd" style="width:150px" align="left">
								派出所：<input id="cc2" class="easyui-combobox"
							data-options="valueField:'id', width:140, textField:'text',onSelect: function(rec1){var url = '<%=basePath %>gzjk/queryOrgLowest?orgCode='+rec1.id;$('#cc3').combobox('reload',url);}" />
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd" style="width:150px" align="left">
								责任区：<input id="cc3" class="easyui-combobox"
							data-options="valueField:'id', width:140, textField:'text'" />
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd" style="width:160px" align="left">
								    开始时间：<input  type='text' id='ZQ_KS' name='ZQ_KS' class="easyui-validatebox" style="width:140px;"
		  							value="" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'ZQ_JS\')}'})" data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd" style="width:160px" align="left">
							<input id = "zdrq" name = "zdrq" type="hidden"/>
								结束时间：<input  type='text' id='ZQ_JS' name='ZQ_JS' class="easyui-validatebox" style="width:140px;"
		 							value="" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'zdrq\')}',minDate:'#F{$dp.$D(\'ZQ_KS\')}'})" data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'"/>
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
			<hr>
			<iframe id="iframe" src="" width="100%" height="90%" frameborder="0"></iframe>
    </div>
	<script type="text/javascript">
	var msgObj;
	var bgObj;
	var orgcode;
	$(document).ready(function(){
		orgcode = $("#orgcode").val();
		org6=orgcode.substr(0,6);
		$("#cc1").combobox("setValue",orgcode.substr(0,6)+"000000");
		var url = "<%=basePath %>gzjk/queryOrgLower?orgCode="+orgcode.substr(0,6)+"000000";
		$('#cc2').combobox('reload', url);
		$("#cc2").combobox("setValue",orgcode.substr(0,8)+"0000");
		url = "<%=basePath %>gzjk/queryOrgLowest?orgCode="+orgcode.substr(0,8)+"0000";
		$('#cc3').combobox('reload',url);
		setInputReadonly('cc1', true);
		setInputReadonly('cc2', true);
		var mydate = new Date();
		mydate.setTime(mydate.getTime()-1000*24*60*60);
		var nowdate = formatdate(mydate);
		$("#zdrq").val(nowdate);
		$("#ZQ_KS").val(nowdate);
		$("#ZQ_JS").val(nowdate);
		$("#iframe").on("load",function(){
			$(document.body).unmask(); 
		});
	});
		
		function clearCase(){
		  $("#queryForm").form("reset");
		}
		function queryButton(){
		mask();
		var fj = "0";
		var pcs = "0";
		var zrq = "0";
		var zzjglx=10;
		var ks = "";
		var js = "";
		var mydate = new Date();
		mydate.setTime(mydate.getTime()-24*1000*60*60);
		var yesdate = formatdate(mydate);
		ks = yesdate;
		js = yesdate;
			if($("#cc1").val()!=""){
				fj=$("#cc1").val();
			}
			if($("#cc2").val()!=""){
				pcs=$("#cc2").val();
			}
			if($("#cc3").val()!=""){
				zrq=$("#cc3").val();
			}
			if ($("#ZQ_KS").val()!="") {
				ks=$("#ZQ_KS").val();
			}
			if ($("#ZQ_JS").val()!="") {
				js=$("#ZQ_JS").val();
			}
			if (fj=="210200000000") {
					fj="0";
					pcs="0";
				}
			if (fj=="0" && pcs=="0" && zrq=="0"){zzjglx=11;}
			if (fj!="0" && pcs=="0" && zrq=="0"){zzjglx=12;}
			if (fj!="0" && pcs!="0" && zrq=="0"){zzjglx=13;}
			if (fj!="0" && pcs!="0" && zrq!="0"){zzjglx=14;}
			var url ="<%=contextPath%>/ReportEmitter?rpt=BZDZ_CH.brt&params=";
			url = url+"ORG_FJ="+fj+";ORG_PCS="+pcs+";ORG_ZRQ="+zrq+";ZQ_KS="+ks+";ZQ_JS="+js+";zzjglx="+zzjglx;
			$("#iframe").attr("src",url);
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
		function mask(){$(document.body).mask("正在加载，可能会比较慢，请稍等...");}
	</script>
  </body>
</html>