<%@page language="java" contentType="text/html; charset=UTF-8"  import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
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
	        userOrgName = userInfo.getUserOrgName();
	}
	//获取今年
	Calendar cal=Calendar.getInstance();
	int year=cal.get(Calendar.YEAR);
 	String zzjglx="";
	if("000000".equals(zzjgdm.substring(6))==true){ 
	    if(zzjgdm=="210200000000"){
	    	zzjglx ="11";
	    }else{
	     	zzjglx ="12";
	     }
	}else{
		zzjglx ="13";
	}	
%>
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
var userOrgName = "<%=userOrgName%>";
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
	function showbegin_(kk){
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
		if(chestr=="0"){
			time1=document.getElementById("ssyj_weak").value;
			time2="";
			if(time1==""){ 
				alert("选择时间!");
				return;
		 	}	
		}else if(chestr=="1"){
			time1=$("#ssyj_month").datebox('getValue');
			time2=$("#ssyj_month_").datebox('getValue');
		}else if(chestr=="2"){
			time1=$("#ssyj_quarter").datebox('getValue');
			time2=$("#ssyj_quarter_").datebox('getValue');
		}else if(chestr=="3"){
			time1=$("#ssyj_half_year").datebox('getValue');
			time2=$("#ssyj_half_year_").datebox('getValue');
		}else if(chestr=="4"){
			time1=$("#ssyj_year").datebox('getValue');
			time2="";
		}else{
		  alert('请选择!');
		  return;
		}
		
		//增加警情类别
		var jqlb = $("#jqlb").datebox('getValue');
		var map = {};
		map["kk"] = kk;
		map["ssyj_zzjgdm"] = ssyj_zzjgdm;
		map["ssyj_zzjglx"] = ssyj_zzjglx;
		map["time1"] = time1;
		map["time2"] = time2;
		map["chestr"] = chestr;
		map["jqlb"] = jqlb;
		
		if(kk==0){
			XjMap.querySsyj(map);
		}else if(kk==1){
		    zdParm_chars(ssyj_zzjgdm,ssyj_zzjgdm,ssyj_zzjglx,time1,time2,chestr);
		}
	}
	
	$(function(){
		showzs(1);
	});

</script>
<table style="height: 100%;width: 100%;left: 0px;top:0px;background: #FFFFFF">
	<tr>
		<td>
   						<div class='infoOrgTitle'><span ><%= userOrgName%></span></div>
		            </td>
		            </tr>
	<tr>
		<td style="height: 100%;width: 20%;">
			<div id="leftWin" style="height: 100%;width: 300px;left: 0px;top:0px;"><br/>
			<div id="leftWinControl" style="display:none;position: absolute;top: 50%;right: -10px;cursor: hand;" onclick="leftWinControl()">X</div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type='radio' id='ssyj_type_sjid' name='ssyj_type_sjname' value='1' onfocus='showzs(1)' checked="checked"/><font style='color:#222222;font-family:宋体;font-size:12px;'>&nbsp;月</font>
			&nbsp;&nbsp;&nbsp;&nbsp;
            <input type='radio' id='ssyj_type_sjid' name='ssyj_type_sjname' value='2' onfocus='showzs(2)'/><font style='color:#222222;font-family:宋体;font-size:12px;'>&nbsp;季</font>
            <br/><hr></br>
   			<table border=0>
   				<tr class="dialogTr" style="display: none;">
			    	<td width="40%" class="dialogTd"><font style='color:#222222;font-family:宋体;font-size:12px;'>&nbsp;&nbsp;警情类别：</font></td>
			    	<td width="60%" class="dialogTd">
						<input class="easyui-combobox" type="text" id="jqlb" name="jqlb" style="width:127px;" 
						data-options="url: contextPath + '/common/dict/D_JCJ_JQLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
					</td>
				</tr>
   				<tr>
   					<td>
		            	<font style='color:#222222;font-family:宋体;font-size:12px;'>&nbsp;&nbsp;时间选择：</font>
		            </td>
            		<td>
			            <div style='display:block' id='xs0'> 
						    <input name="ssyj_weak" class="easyui-validatebox validatebox-text" value="" id="ssyj_weak" style="width:150px;" 
						    	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" type="text" nextCtrl="[object]" 
						    	data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" jQuery11100009288664863191853="730" My97Mark="false" />
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
							<select id="ssyj_quarter_" class="easyui-combobox" name="ssyj_quarter_" style="width:60px;display:none">
								<option value="1">一季度</option>
								<option value="2">二季度</option>
								<option value="3">三季度</option>
								<option value="4">四季度</option>
							</select>
						</div>
						<div style='display:none' id='xs3'> 
							<select id="ssyj_half_year" class="easyui-combobox" name="ssyj_half_year" style="width:60px;display:none">
								<option value="<%=year %>"><%=year %>年</option>
								<option value="<%=year-1 %>"><%=year-1 %>年</option>
								<option value="<%=year-2 %>"><%=year-2 %>年</option>
							</select>
		 				</div>
						<div style='display:none' id='xs4'> 
							<select id="ssyj_year" class="easyui-combobox" name="ssyj_year" style="width:60px;display:none">
								<option value="<%=year %>"><%=year %>年</option>
								<option value="<%=year-1 %>"><%=year-1 %>年</option>
								<option value="<%=year-2 %>"><%=year-2 %>年</option>
							</select>
						</div>
	 				</td>
	 			<td>
	 		</td>
	 	</tr>
	 </table>
	 <br/><br/><hr>
	<center>
	    <a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-search" onclick="showbegin_(0)">查询</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-report" onclick='showbegin_(1)' >统计</a>
	</center>
	</div>
	</td>					
		</tr>
	</table>
	<!-- 恒星统计图 -->
    <div id="winser">   
       <div id="chartdiv1" align="center" ></div>
    </div> 
