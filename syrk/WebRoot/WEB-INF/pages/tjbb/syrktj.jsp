<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>实有人口统计</title>
  </head>
  <body class="easyui-layout" style="overflow: hidden;height:100%;">
      <div data-options="region:'center',split:true,title:'',border:true" style="height:auto">
			<form id="queryForm">
				<table cellspacing="0" cellpadding="0" border="0" width="1800px" style="padding: 10px;" >
					<tbody>
					   <tr>
							<td class="toolbarTd" style="width:200px" align="right">
								分局：<input id="cc1" class="easyui-combobox"
							         data-options="valueField: 'id',textField: 'text',width:140,url: '<%=basePath %>gzjk/queryOrg',onSelect: function(rec){var url = '<%=basePath %>gzjk/queryOrgLower?orgCode='+rec.id;$('#cc2').combobox('reload', url);}"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd" style="width:200px" align="right">
								派出所：<input id="cc2" class="easyui-combobox"
							data-options="valueField:'id', width:140, textField:'text'" />
							</td>
							
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd" style="width:220px" align="left">
							 <!-- input type="radio" id="radio1" name="radio1" value = "1"onchange="choose();"/>最近一天 -->
							 <input type="radio" id="radio1" name="radio1" value = "0"onclick="choose();"/>本周
							 <input type="radio" id="radio1" name="radio1" value = "1"onclick="choose();"/>本月
							 <input type="radio" id="radio1" name="radio1" value = "2"onclick="choose();"/>本年
							 <input type="radio" id="radio1" name="radio1" value = "3" checked="true" onclick="choose();"/>自定义
							</td>
							
							<td class="toolbarTd"id='ZQ_KStitle'><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd"id='ZQ_KStitle01' style="width:160px" align="right">
								开始时间：<input  type='text' id='ZQ_KS' name='ZQ_KS' class="easyui-validatebox" style="width:90px;"
		  							value="" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'"/>
							</td>
							<td class="toolbarTd"id='ZQ_JStitle'><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd"id='ZQ_JStitle01' style="width:160px" align="right">
								结束时间：<input  type='text' id='ZQ_JS' name='ZQ_JS' class="easyui-validatebox" style="width:90px;"
		 							value="" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd">
								<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >统计</a>
								<!-- <a class="easyui-linkbutton" iconCls="icon-search" onclick="queryTXButton();" >图形统计</a> -->
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
			var pcs = "0";
			var zrq = "0";
			var ks = "";
			var js = "";
			var mydate = new Date();
			var nowdate = formatdate(mydate);
			ks = nowdate;
			js = nowdate;
			var yearTmp =mydate.getYear();
			var monthTmp = mydate.getMonth()+1;
			var dayTmp =mydate.getDay();
			
			var radio=document.getElementsByName("radio1");
		
			if(radio[0].checked){
				
				ks=mydate.dateAdd('d', dayTmp-6);
				ks = formatdate(ks);
			}else if(radio[1].checked){
				
				if(monthTmp<10){
					
					monthTmp="0"+monthTmp;
				}
				ks =yearTmp+"-"+monthTmp+"-"+"01";
			}else if(radio[2].checked){
				
				ks = yearTmp+"-01-01";
			}else if(radio[3].checked){
			
				ks=$("#ZQ_KS").val();
				js=$("#ZQ_JS").val();
			}

					
			mask();
			if($("#cc1").val()!=""){
				fj=$("#cc1").val();
			}
			if($("#cc2").val()!=""){
				pcs=$("#cc2").val();
			}
			
			if (fj=="210200000000") {
					fj="0";
					pcs="0";
			}
			var zzjglx;
			if (fj=="0" && pcs=="0"){zzjglx=11;}
			if (fj!="0" && pcs=="0"){zzjglx=12;}
			if (fj!="0" && pcs!="0"){zzjglx=13;}
			
			var url ="<%=contextPath%>/ReportEmitter?rpt=SYRKTJBB.brt&params=";
			url = url+"ORG_FJ="+fj+";ORG_PCS="+pcs+";ORG_ZRQ="+zrq+";ZQ_KS="+ks+";ZQ_JS="+js+";zzjglx="+zzjglx;
			iframe.window.location.href=url;
			
		}
		
		function queryTXButton(){
		
			var fj = "0";
			var pcs = "0";
			var zrq = "0";
			var ks = "";
			var js = "";
			var mydate = new Date();
			var nowdate = formatdate(mydate);
			ks = nowdate;
			js = nowdate;
			var yearTmp =mydate.getYear();
			var monthTmp = mydate.getMonth()+1;
			var dayTmp =mydate.getDay();
			
			var radio=document.getElementsByName("radio1");
		
			if(radio[0].checked){
				
				ks=mydate.dateAdd('d', dayTmp-6);
				ks = formatdate(ks);
			}else if(radio[1].checked){
				
				if(monthTmp<10){
					
					monthTmp="0"+monthTmp;
				}
				ks =yearTmp+"-"+monthTmp+"-"+"01";
			}else if(radio[2].checked){
				
				ks = yearTmp+"-01-01";
			}else if(radio[3].checked){
			
				ks=$("#ZQ_KS").val();
				js=$("#ZQ_JS").val();
			}
					
			mask();
			if($("#cc1").val()!=""){
				fj=$("#cc1").val();
			}
			if($("#cc2").val()!=""){
				pcs=$("#cc2").val();
			}
			
			if (fj=="210200000000") {
					fj="0";
					pcs="0";
			}
			var zzjglx;
			if (fj=="0" && pcs=="0"){zzjglx=11;}
			if (fj!="0" && pcs=="0"){zzjglx=12;}
			if (fj!="0" && pcs!="0"){zzjglx=13;}
			
			var url ="<%=contextPath%>/ReportEmitter?rpt=SYRK_txxx.brt&params=";
			url = url+"ORG_FJ="+fj+";ORG_PCS="+pcs+";ORG_ZRQ="+zrq+";ZQ_KS="+ks+";ZQ_JS="+js+";zzjglx="+zzjglx;
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
		
		function choose(evt){
			var evt = evt||window.event;
			var e = evt.srcElement||evt.target;
			if(e.value==3){
			
				$("#ZQ_KStitle").show();
				$("#ZQ_KStitle01").show();
				$("#ZQ_JStitle").show();
				$("#ZQ_JStitle01").show();
			}else{
				
				$("#ZQ_KStitle").hide();
				$("#ZQ_KStitle01").hide();
				$("#ZQ_JStitle").hide();
				$("#ZQ_JStitle01").hide();
				queryButton();
			}
		}
		function mask(){$(document.body).mask("正在加载，很快就好，请稍等...");}
		//20141022 add
        Date.prototype.dateAdd = function (interval, number) {
             var d = this;
             var k = { 'y': 'FullYear', 'q': 'Month', 'm': 'Month', 'w': 'Date', 'd': 'Date', 'h': 'Hours', 'n': 'Minutes', 's': 'Seconds', 'ms': 'MilliSeconds' };
             var n = { 'q': 3, 'w': 7 };
             eval('d.set' + k[interval] + '(d.get' + k[interval] + '()+' + ((n[interval] || 1) * number) + ')');
             return d;
         }

	</script>
  </body>
</html>