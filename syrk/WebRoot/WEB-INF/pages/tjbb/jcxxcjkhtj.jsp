<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>基础信息采集考核</title>
  </head>
  <body class="easyui-layout" style="overflow: hidden;height:100%;">
      <div data-options="region:'center',split:true,title:'',border:true" style="height:auto">
			<form id="queryForm">
				<table cellspacing="0" cellpadding="0" border="0" width="1000" style="padding: 10px;" >
					<tbody>
					   <tr>
							<td class="toolbarTd" style="width:190px" align="right">
								分局：<input id="cc1" class="easyui-combobox"
							         data-options="valueField: 'id',textField: 'text',width:140,url: '<%=basePath %>gzjk/queryOrg',onSelect: function(rec){var url = '<%=basePath %>gzjk/queryOrgLower?orgCode='+rec.id;$('#cc2').combobox('reload', url);}"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd" style="width:190px" align="right">
								派出所：<input id="cc2" class="easyui-combobox"
							data-options="valueField:'id', width:140, textField:'text'" />
							</td>
							<td class="toolbarTd" style="width:190px" align="right">
								周：<input id="week1" name="week1" class="easyui-combobox"
							         data-options="valueField: 'id',textField: 'text',width:140,onChange:changeValue,required:true,tipPosition:'left'"/>
							</td>
							<input  type='hidden' id='ZQ_KS' name='ZQ_KS'/>
							<input  type='hidden' id='ZQ_JS' name='ZQ_JS'/>
							<!--  <td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							 <td class="toolbarTd" style="width:200px" align="right">
								    开始时间：<input  type='text' id='ZQ_KS' name='ZQ_KS' class="easyui-validatebox" style="width:140px;"
		  							value="" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="toolbarTd" style="width:200px" align="right">
								结束时间：<input  type='text' id='ZQ_JS' name='ZQ_JS' class="easyui-validatebox" style="width:140px;"
		 							value="" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'"/>
							</td>
							<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>-->
							<td class="toolbarTd">
								<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >统计</a>
								<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
							</td>
				
						 </tr>
					</tbody>
				</table>
			</form>
			<hr>
			<iframe id="iframe" src="" width="100%" height="92%" frameborder="0"></iframe>
    </div>
 <script type="text/javascript">
	var msgObj;
	var bgObj;
	var nowyear ;
	
	$(document).ready(function(){
		var data=[];
		for(var i=1;i<53;i++){
			if(i==52){
				data.push({"id":""+i,"text":"第"+i+"周"});
			}else {
				data.push({"id":""+i,"text":"第"+i+"周"});
			}
		}
		$("#week1").combobox("loadData",data);
		theWeek();
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
		var ks = "";
		var js = "";
		var zzjglx;
		var mydate = new Date();
		var nowdate = formatdate(mydate);
		ks = nowdate;
		js = nowdate;
			if($("#cc1").val()!=""){
				fj=$("#cc1").val();
			}
			if($("#cc2").val()!=""){
				pcs=$("#cc2").val();
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
			if (fj=="0" && pcs=="0"){zzjglx=11;}
			if (fj!="0" && pcs=="0"){zzjglx=12;}
			if (fj!="0" && pcs!="0"){zzjglx=13;}
			var url ="<%=contextPath%>/ReportEmitter?rpt=JCXXCJKHTJ.brt&params=";
			url = url+"ORG_FJ="+fj+";ORG_PCS="+pcs+";ZQ_KS="+ks+";ZQ_JS="+js+";zzjglx="+zzjglx;
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
		
		//获取某年某周的开始日期
		function getBeginDateOfWeek(paraYear, weekIndex){
			 var firstDay = GetFirstWeekBegDay(paraYear);
			 //7*24*3600000 是一星期的时间毫秒数,(JS中的日期精确到毫秒)
			 var time=(weekIndex-1)*7*24*3600000;
			 var beginDay = firstDay;
			beginDay.setTime(firstDay.valueOf()+time);
			$("#ZQ_KS").val(formatdate(beginDay));
	 		return formatdate(beginDay);
		}
		function changeValue(newVal,oldrVal){
			if (!newVal) {
				return;
			}
			var date = new Date();
			nowyear = date.getFullYear();
			getBeginDateOfWeek(nowyear,newVal);
			getEndDateWeek(nowyear,newVal);
		}
		
		//获取某年的第一天
		function GetFirstWeekBegDay(year){
			var tempdate = new Date(year, 0, 1);
			 var temp = tempdate.getDay();
			 if(temp == 1){
			 	 return tempdate;
			 }
			temp = temp==0?7:temp;
			tempdate = tempdate.setDate(tempdate.getDate() + (8 - temp));
			return new Date(tempdate);
		}
		//获取某年某周的结束日期
		function getEndDateWeek(paraYear,weekIndex){
			var firstDay = GetFirstWeekBegDay(paraYear);
			//7*24*3600000 是一星期的时间毫秒数,(JS中的日期精确到毫秒)
			var time=(weekIndex-1)*7*24*3600000;
			var weekTime = 6*24*3600000;
			var endDay = firstDay;
			//为日期对象 date 重新设置成时间 time
			endDay.setTime(firstDay.valueOf()+weekTime+time);
			$("#ZQ_JS").val(formatdate(endDay));
			return formatdate(endDay);
		}
		function theWeek(){
			var totalDays= 0;
			var now = new Date();
			var years = now.getFullYear();
			if(years<1000){
				years+=1900;
			}
			var days = new Array(12);
			days[0]=31;
			days[2]=31;
			days[3]=30;
			days[4]=31;
			days[5]=30;
			days[6]=31;
			days[7]=31;
			days[8]=30;
			days[9]=31;
			days[10]=30;
			days[11]=31;
			if(Math.round(now.getFullYear()/4)==years/4){
				days[1]=28;
			}else {
				days[1]=29;
			}
			if(now.getMonth()==0){
				totalDays=totalDays+day;	
			}else {
				var curMonth = now.getMonth();
				for(var count=1;count<=curMonth;count++){
					totalDays=totalDays+days[count-1];
				}
				totalDays = totalDays+now.getDate();
			}
			//得到第几周
			var week = Math.round(totalDays/7);
			$('#week1').combobox('select',''+week);
		}
		
		
	</script>
  </body>
</html>