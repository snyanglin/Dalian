<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
    }
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>警情查询</title>
<style type="text/css">
.lf_ddicon span{ color:black; display:block; width:67px; overflow:hidden;  font-size:12px; -webkit-transform: scale(0.75); line-height:14px;}
</style>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
				<div id="datagridToolbar" style="padding:0px;height:auto">
				<form id="queryForm">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
				        <tr class="dialogTr">
				        <!-- 210200000000 -->
						<td width="20%" class="dialogTd" align="right">管辖市(县)局：</td>
						<td width="30%" class="dialogTd"><input id="cc1" class="easyui-combobox" value=""
							         data-options="valueField: 'id',textField: 'text',width:110, url: '<%=basePath %>gzjk/queryOrg',
							         onSelect: function(rec){var url = '<%=basePath %>gzjk/queryOrgLower?orgCode='+rec.id;$('#cc2').combobox('reload', url);}"/>
			            </td>
			            </tr>
			            <tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">管辖派出所：</td>
						<td width="30%" class="dialogTd">
							<input id="cc2" class="easyui-combobox"
							data-options="valueField:'id', width:110, textField:'text',onSelect: function(rec1){var url = '<%=basePath %>gzjk/queryOrgLowest?orgCode='+rec1.id;$('#cc3').combobox('reload',url);}" />
						</td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">管辖责任区：</td>
							<td width="30%" class="dialogTd" colspan="3">
								<input id="cc3" class="easyui-combobox"
							data-options="valueField:'id', width:110, textField:'text'" />
							</td>
						</tr>
						<tr class="dialogTr">
						<!-- 
						<td class="dialogTd" align="center" colspan="4">
								<hr>
								<a href="javascript:void(0)" class="easyui-linkbutton" 
								 	iconCls="icon-reset" onclick="resetButton()">重置</a>
								 &nbsp;
								<a href="javascript:void(0)" class="easyui-linkbutton" 
								 iconCls="icon-search" onclick="queryButton()">设置</a>
							</td>
						</tr>
						 -->		
						<tr class="dialogTr" align="center" height="50">
						</tr>
			            <tr class="dialogTr" align="center">
				        <!-- 210200000000 -->
							<td width="50%" height="100" class="dialogTd">
								<a class="lf_ddicon" href="javascript:void(0)" onclick="query('xqgk')">
									<img src="<%=contextPath%>/images/navigator/czfwgl.png" border="0" alt="辖区概况" width="70" height="70"/><span>辖区概况</span></a>
							</td>
							<td width="50%" height="100" class="dialogTd">
								<a class="lf_ddicon" href="javascript:void(0)" onclick="query('jrjq')">
									<img src="<%=contextPath%>/images/navigator/znff.png" border="0" alt="今日警情" width="70" height="70"/><span>今日警情<label id="count"></label></span></a>
							</td>
			            </tr>
			            <tr class="dialogTr" align="center">
							<td width="50%" height="100" class="dialogTd">
								<a class="lf_ddicon" href="javascript:void(0)" onclick="query('gzdt')">
									<img src="<%=contextPath%>/images/navigator/sydwhs.png" border="0" alt="工作动态" width="70" height="70"/><span>工作动态</span></a>
							</td>
							<td width="50%" height="100" class="dialogTd">
								<a class="lf_ddicon" href="javascript:void(0)" onclick="query('jwts')">
									<img src="<%=contextPath%>/images/navigator/sydwgl.png" border="0" alt="警务态势" width="70" height="70"/><span>警务态势</span></a>
							</td>
			            </tr>
				</table>
				</form>
				</div>
			</div>
        </div>
    </div>   
    
    <input type="hidden" id ="zbz" value="">
    <input type="hidden" id ="type" value="">
    <input type="hidden" id ="mapRadius" value="">


</body>
<script type="text/javascript">
<!--
var orgcode = "<%=userOrgCode %>";
//init
$(function(){
	//父页面公共变量
	//orgcode = parent.frames.orgcodeTotal;
	//延长3秒执行，否则没加载完元素报错
	setTimeout(function() {query("xqgk");}, 3000);
	//初始化查询今日警情
	var date = new Date();
	var y = date.getFullYear();
	var m = date.getMonth()+1+'';
	if(m.length != 2){
		m = '0'+m;
	}
	var d = date.getDate()+'';
	if(d.length != 2){
		d = '0'+d;
	}
	var last = y + "-" + m + "-" + d;
	$.ajax({
		async:false,
		type:"POST",
		url: contextPath+"/jz/queryCountJq",
		dataType:"json",
		data: "gxdwdm=" + orgcode + "&fqsj=" + last + "&jssj=" + last,
		success:function(data){
			//document.getElementById("count").innerHTML = '(<font color=red>' + data + '</font>)';
		}
	});
	    				
});

//条件查询按钮
function query(type){
	queryButton();
	var parm = "?gxdwdm=" + orgcode;
	if("xqgk" == type){
		parm = orgcode + "-xqgk";
		window.parent.zdParm(parm, type);
	} else if("jrjq" == type){
		//add by wuw start
		var cc1=$("#cc1").combobox('getValue');
		var cc2=$("#cc2").combobox('getValue');
		var cc3=$("#cc3").combobox('getValue');
		var cc=cc3==''?cc2==''?cc1==''?orgcode:cc1:cc2:cc3;
		var level=(cc+'').indexOf('000000')!=-1?1:2;
		parm = level + '|'+cc;
		//add by wuw end
		window.parent.zdParm(parm, type);
	} else if("gzdt" == type){
		window.parent.zdParm(parm, type);
	} else if("jwts" == type){
		var lx1 = document.getElementById("cc1").value;
		var lx2 = document.getElementById("cc2").value;
		var lx3 = document.getElementById("cc3").value;
		parm = "?lx1=" + lx1 + "&lx2=" +  lx2+ "&lx3=" +  lx3;
		window.parent.zdParm(parm, type);
	}
}

//查询按钮
function queryButton(){
	var cc1 = document.getElementById("cc1").value;
	var cc2 = document.getElementById("cc2").value;
	var cc3 = document.getElementById("cc3").value;
	if(cc3!=null && cc3!=''){
		orgcode = cc3;
	} else if(cc2!=null && cc2!=''){
		orgcode = cc2;
	} else if(cc1!=null && cc1!=''){
		orgcode = cc1;
	} else {
		orgcode = <%=userOrgCode%>;
	}
	//主页变量赋值
	//parent.frames.orgcodeTotal = orgcode;
	//var parm = "?&gxdwdm=" + orgcode;
	//window.parent.zdParm(parm, "queryTotal");
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}
-->
</script>  

</html>