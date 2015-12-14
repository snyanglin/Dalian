<%@ page language="java" contentType="text/html; charset=UTF-8"  import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<%
SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
String userOrgCode = "";
String userOrgName = "";
String bjzbz = "";
String id = "";
String zzjgdm="210200000000";

if(userInfo!=null){
	zzjgdm = userInfo.getUserOrgCode();
}

	//获取今年
Calendar cal=Calendar.getInstance();
int year=cal.get(Calendar.YEAR);
   String zzjglx="";
	
	if("000000".equals(zzjgdm.substring(6))==true)
      { 
	    if(zzjgdm=="210200000000"){
	    zzjglx ="11";
	    }else{
	     	zzjglx ="12";
	     	}
	  }else{
		zzjglx ="13";
	  }	
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
	.searchText {
	   font-size: 13px;
	   font-color: #222222;
	   height: 32px;
	   border: 1px solid #95B8E7;
	   line-height：32px;
	   padding-left: 5px;
	   padding-top: 8px;
	   width:200px;
	}

	.searchIcon {
		width:28px;
		height:28px;
   		background: url('<%=contextPath%>/images/search_icon.png') no-repeat center;
   		cursor: pointer;
	}
	
</style>

<script type="text/javascript">
//切换各类时间开始
function showzs(mm){
 if(mm==0){
 	document.getElementById("xs0").style.display ='block';
 	document.getElementById("xs1").style.display = 'none';
 	document.getElementById("xs2").style.display = 'none';
 	document.getElementById("xs3").style.display = 'none';
 	document.getElementById("xs4").style.display = 'none';
 }else if(mm==1){
  	document.getElementById("xs0").style.display = 'none';
 	document.getElementById("xs1").style.display = 'block';
 	document.getElementById("xs2").style.display = 'none';
 	document.getElementById("xs3").style.display = 'none';
 	document.getElementById("xs4").style.display = 'none';
 }else if(mm==2){
  	document.getElementById("xs0").style.display = 'none';
 	document.getElementById("xs1").style.display = 'none';
 	document.getElementById("xs2").style.display = 'block';
 	document.getElementById("xs3").style.display = 'none';
 	document.getElementById("xs4").style.display = 'none';
 }else if(mm==3){
  	document.getElementById("xs0").style.display = 'none';
 	document.getElementById("xs1").style.display = 'none';
 	document.getElementById("xs2").style.display = 'none';
 	document.getElementById("xs3").style.display = 'block';
 	document.getElementById("xs4").style.display = 'none';
 }else if(mm==4){
  	document.getElementById("xs0").style.display = 'none';
 	document.getElementById("xs1").style.display = 'none';
 	document.getElementById("xs2").style.display = 'none';
 	document.getElementById("xs3").style.display = 'none';
 	document.getElementById("xs4").style.display = 'block';
 }
}
//=========切换各类时间结束
//查询验证
function  showbegin_(kk){
var ssyj_zzjgdm=<%=zzjgdm%>;
var ssyj_zzjglx=<%=zzjglx%>;
var time1="";
var time2="";
var chestr="";
var str=document.getElementsByName('ssyj_type_sjname');
var objarray=str.length;	
for(i=0;i<objarray;i++){
	if(str[i].checked==true){
		chestr=str[i].value;
	}
}

if(chestr=="0")
{
time1=document.getElementById("ssyj_weak").value;

time2="";
if(time1=="")
{ 
 	 alert("选择时间!");
 	 return;
 	}	
}
else if(chestr=="1")
{
time1=$("#ssyj_month").datebox('getValue');
time2=$("#ssyj_month_").datebox('getValue');
}
else if(chestr=="2")
{
time1=$("#ssyj_quarter").datebox('getValue');
time2=$("#ssyj_quarter_").datebox('getValue');
}
else if(chestr=="3")
{
time1=$("#ssyj_half_year").datebox('getValue');
time2=$("#ssyj_half_year_").datebox('getValue');
}
else if(chestr=="4")
{
time1=$("#ssyj_year").datebox('getValue');
time2="";
}else{
  alert('请选择!');return;
}

var parm = "?kk=" + kk + "&ssyj_zzjgdm=" + ssyj_zzjgdm + "&ssyj_zzjglx=" + ssyj_zzjglx + "&time1=" + time1 + "&time2=" + time2 + "&chestr=" + chestr;
if(kk==0){
window.parent.zdParm(parm, 'ssyj');
}else if(kk==1){
	//修改
	window.parent.zdParm_tjt(kk,ssyj_zzjgdm,ssyj_zzjgdm,ssyj_zzjglx,time1,time2,chestr);

}

}

function clearButton(){
	window.parent.zdParm("", "ssyj_clear");
}
</script>
</head>
<title>四色预警</title>
<body class="easyui-layout" data-options="fit:true" >  

	<table style="height: 100%;width: 100%;left: 0px;top:0px;background: #FFFFFF">
			<tr>
				<td style="height: 100%;width: 20%;">

	<div id="leftWin" style="height: 100%;width: 300px;left: 0px;top:0px;background: ">
			<div id="leftWinControl" style="display:none;position: absolute;top: 50%;right: -10px;cursor: hand;background: " onclick="leftWinControl()">X</div>
				<br/>
			<br/><br/>
			<font style='color:#222222;font-family:宋体;font-size:12px;'>&nbsp;&nbsp;周:</font><input type='radio' id='ssyj_type_sjid' name='ssyj_type_sjname' value='0'  onfocus='showzs(0)' checked/>
			<font style='color:#222222;font-family:宋体;font-size:12px;'>&nbsp;月:</font><input type='radio' id='ssyj_type_sjid' name='ssyj_type_sjname' value='1' onfocus='showzs(1)'/>
            <font style='color:#222222;font-family:宋体;font-size:12px;'>&nbsp;季:</font><input type='radio' id='ssyj_type_sjid' name='ssyj_type_sjname' value='2' onfocus='showzs(2)'/>
            <font style='color:#222222;font-family:宋体;font-size:12px;'>&nbsp;半年:</font><input type='radio' id='ssyj_type_sjid' name='ssyj_type_sjname' value='3' onfocus='showzs(3)'/>
            <font style='color:#222222;font-family:宋体;font-size:12px;'>&nbsp;年:</font><input type='radio' id='ssyj_type_sjid' name='ssyj_type_sjname' value='4' onfocus='showzs(4)'/>
            <br/><br/><hr><br/>
   <table><tr><td>
            <font style='color:#222222;font-family:宋体;font-size:12px;'>&nbsp;&nbsp;时间选择：</font>
            </td>
            <td>
            <div style='display:block' id='xs0'> 
			    <input name="ssyj_weak" class="easyui-validatebox validatebox-text" value="" id="ssyj_weak" style="width:150px;" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" type="text" nextCtrl="[object]" data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" jQuery11100009288664863191853="730" My97Mark="false" />
			</div>
		    <div style='display:none' id='xs1'> 
		               <select id="ssyj_month" class="easyui-combobox" name="ssyj_month" style="width:60px">
			            <option value="<%=year %>"><%=year %>年</option>
			            <option value="<%=year-1 %>"><%=year-1 %>年</option>
			            <option value="<%=year-2 %>"><%=year-2 %>年</option>
		               </select>
			<select id="ssyj_month_" class="easyui-combobox" name="ssyj_month_" style="width:60px;display:none">
				<option value="01">一月</option>
				<option value="02">二月</option>
				<option value="03">三月</option>
				<option value="04">四月</option>
				<option value="05">五月</option>
				<option value="06">六月</option>
				<option value="07">七月</option>
				<option value="08">八月</option>
				<option value="09">九月</option>
				<option value="10">十月</option>
				<option value="11">十一月</option>
				<option value="12">十二月</option>
			</select>
			</div> 
			<div style='display:none' id='xs2'> 
			<select id="ssyj_quarter" class="easyui-combobox" name="ssyj_quarter" style="width:60px;display:none">
				<option value="<%=year %>"><%=year %>年</option>
				<option value="<%=year-1 %>"><%=year-1 %>年</option>
				<option value="<%=year-2 %>"><%=year-2 %>年</option>
			</select>
			<select id="ssyj_quarter_" class="easyui-combobox" name="ssyj_quarter_" style="width:80px;display:none">
				<option value="1">第一季度</option>
				<option value="2">第二季度</option>
				<option value="3">第三季度</option>
				<option value="4">第四季度</option>
			</select>
			</div>
		<div style='display:none' id='xs3'> 
		<select id="ssyj_half_year" class="easyui-combobox" name="ssyj_half_year" style="width:60px;display:none">
			<option value="<%=year %>"><%=year %>年</option>
			<option value="<%=year-1 %>"><%=year-1 %>年</option>
			<option value="<%=year-2 %>"><%=year-2 %>年</option>
		</select>
		<select id="ssyj_half_year_" class="easyui-combobox" name="ssyj_half_year_" style="width:70px;display:none">
			<option value="1">上半年</option>
			<option value="2">下半年</option>
		</select>
		 </div>
		<div style='display:none' id='xs4'> 
			<select id="ssyj_year" class="easyui-combobox" name="ssyj_year" style="width:60px;display:none">
				<option value="<%=year %>"><%=year %>年</option>
				<option value="<%=year-1 %>"><%=year-1 %>年</option>
				<option value="<%=year-2 %>"><%=year-2 %>年</option>
			</select>
		</div>
	 </td><td></td>
	 </tr></table>
	 <br/><br/>
	<center>
	    <a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-search" onclick="showbegin_(0)">查询</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-query" onclick='showbegin_(1)'>统计</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" 
								 	iconCls="icon-reload" onclick="clearButton()">清除</a>
	</center>
	<br/>	
	<br/>
	<br/>
	<br/>
	</div>
	</td>					
		<td style="width:80%;height: 100%">						
		 <div id="map" style="width: 100%; height: 70%; display: block"></div>
		 
		 <div id="opeDiv" style="width: 100%; height: 30%; display: block;">
		     <div id="opeDiv_tabs">
			     <div title="内容显示">
		         	 <div id="opeDiv_resDiv">
						<table id="ssyj_res"></table>  
					 </div>
				 </div>
			 </div>
		 </div>
	
		  <div  id='tb_ssyj' style="right:50px;bottom:50px;position:absolute;display: none">
		 	  <img style="cursor:hand" src="<%=basePath %>common/ssyj/img/arrow_left_green.png" onclick='showcx_(0)'></img>
		  </div>					

	         <div id="BJDW_dragDiv" class="dragDiv">
				    <div class="title">
				      <h2></h2>
				        <div>
				        	<a class="open" href="javascript:;" title="打开"></a>
				            <a class="min" href="javascript:;" title="最小化"></a>
				            <a class="max" href="javascript:;" title="最大化"></a>
				            <a class="revert" href="javascript:;" title="还原"></a>
				            <a class="close" href="javascript:;" title="关闭"></a>
				        </div>
				     </div>
				    <div class="resizeL"></div>
				    <div class="resizeT"></div>
				    <div class="resizeR"></div>
				    <div class="resizeB"></div>
				    <div class="resizeLT"></div>
				    <div class="resizeTR"></div>
				    <div class="resizeBR"></div>
				    <div class="resizeLB"></div>
				    <div id="bjdw_drag_div" class="content"></div>    
			</div>
			</td>
		</tr>
	</table>
</body>
</html>