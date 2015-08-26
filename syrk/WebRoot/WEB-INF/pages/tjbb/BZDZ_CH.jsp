<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>标准地址统计</title>
  </head>
  <body class="easyui-layout" data-options="fit:true">
     <div data-options="region:'center',border:false">
       <form id="queryForm">
			<table cellspacing="0" cellpadding="0" border="0" style="padding: 8px;border-bottom:1px solid #ccc9da;" width="100%">
				   <tr class="dialogTr">
				        <td class="dialogTd" style="width: 40px;" align="right">分局：</td>
				        <td class="dialogTd" style="width: 110px;" align="right">
				            <input id="cc1" class="easyui-combobox"
						         data-options="valueField: 'id',textField: 'text',width:110,url: '<%=basePath %>gzjk/queryOrg',
						         onSelect: function(rec){var url = '<%=basePath %>gzjk/queryOrgLower?orgCode='+rec.id;$('#cc2').combobox('reload', url);}"/>
				        </td>
				        <td class="dialogTd" style="width: 50px;" align="right">派出所：</td>
				        <td class="dialogTd" style="width: 110px;" align="right">
				            <input id="cc2" class="easyui-combobox"
								  data-options="valueField:'id', width:110, textField:'text',
								  onSelect: function(rec1){var url = '<%=basePath %>gzjk/queryOrgLowest?orgCode='+rec1.id;$('#cc3').combobox('reload',url);}" />
				        </td>
				        <td class="dialogTd" style="width: 50px;" align="right">责任区：</td>
				        <td class="dialogTd" style="width: 110px;" align="right">
				            <input id="cc3" class="easyui-combobox"
								data-options="valueField:'id', width:110, textField:'text'" />
				        </td>
						<td class="dialogTd" style="width: 60px;" align="right">开始时间：</td>
						<td class="dialogTd" style="width: 90px;" align="right">
						    <input  type='text' id='ZQ_KS' name='ZQ_KS' class="easyui-validatebox"
	  							value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'ZQ_JS\')}'})" 
	  							data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'"/>
						</td>
						<td class="dialogTd" style="width: 60px;" align="right">结束时间：</td>
						<td class="dialogTd" style="width: 90px;" align="right">
						    <input id="zdrq" name="zdrq" type="hidden"/>
						    <input  type='text' id='ZQ_JS' name='ZQ_JS' class="easyui-validatebox" style="width:90px;"
	 							value="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'zdrq\')}',minDate:'#F{$dp.$D(\'ZQ_KS\')}'})" 
	 							data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'"/>
						</td>
						<td class="toolbarTd" align="left">
							<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();">统计</a>
							<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();">重置</a>
						</td>
					 </tr>
			</table>
		</form>
		<iframe id="iframe" src="" width="100%" height="90%" frameborder="0"></iframe>
    </div>
	<script type="text/javascript">
		var msgObj;
		var bgObj;
		$(document).ready(function(){
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