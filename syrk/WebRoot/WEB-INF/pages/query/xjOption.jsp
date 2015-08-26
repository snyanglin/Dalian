<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@page import="com.founder.framework.config.SystemConfig" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgName = "";
    String bjzbz = "";
    String id = "";
    String userid = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName = userInfo.getUserOrgName();
        bjzbz = userInfo.getBjzbz();
        id = ""+userInfo.getUserOrgId();
        userid = userInfo.getUserId();
    }
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">
    var userOrgCode = "<%=userOrgCode%>"; 
    var userOrgName = "<%=userOrgName%>";
    var bjzbz = "<%=bjzbz%>";
    var id = "<%=id%>";
    var userid = "<%=userid%>";
</script>
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
  var markerArr = new Array();
</script>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
				<div id="datagridToolbar" style="padding:0px;height:auto">
				<form id ="queryForm" method="post" action="">
		        <table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
			        <tr class="dialogTr">
					    	<td width="50%" class="dialogTd" align="left">
								<input type="checkbox" id='qyfw' value="qyfw" name="checks" />区域范围
							</td>
					    	<td width="50%" class="dialogTd" align="left">
								<input type="checkbox" id='zdrk' value="zdrk" name="checks" />重点人口
							</td>
					</tr>
					<tr class="dialogTr">
							<td width="50%" class="dialogTd" align="left">
								<input type="checkbox" id='jq' value="jq" name="checks" />警情
							</td>
					    	<td width="50%" class="dialogTd" align="left">
								<input type="checkbox" id='aj' value="aj" name="checks" />案件
							</td>
				   	</tr>	
				   	<tr class="dialogTr">
					    	<td width="50%" class="dialogTd" align="left">
								<input type="checkbox" id='sj' value="sj" name="checks" />事件
							</td>
					    	<td width="50%" class="dialogTd" align="left">
								<input type="checkbox" id='xlxl' value="xlxl" name="checks" />巡逻线路
							</td>
					</tr>
					<tr class="dialogTr">
							<td width="50%" class="dialogTd" align="left">
								<input type="checkbox" id='xlc' value="xlc" name="checks" />巡逻车
							</td>
					    	<td width="50%" class="dialogTd" align="left">
								<input type="checkbox" id='xly' value="xly" name="checks" />巡逻员
							</td>
				   	</tr>	
				   	<tr class="dialogTr">
							<td width="50%" class="dialogTd" align="left">
								<input type="checkbox" id='ssyj' value="ssyj" name="checks" />四色预警
							</td>
					    	<td width="50%" class="dialogTd" align="left">
								<input type="checkbox" id='jqfx' value="jqfx" name="checks" />警情分析
							</td>
				   	</tr>	
				   	<tr class="dialogTr">
							<td width="50%" class="dialogTd" align="left">
								<input type="checkbox" id='xljh' value="xljh" name="checks" />巡逻计划
							</td>
					    	<td width="50%" class="dialogTd" align="left">
								<input type="checkbox" id='kffx' value="kffx" name="checks" />可防分析
							</td>
				   	</tr>	
			    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
				    	<td width="100%" colspan="2" align="center">
				    		<hr>
				    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="queryButton('win1', 'xj');">确定</a>
				    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="allCheck();">重置</a>
				    		<a class="easyui-linkbutton" iconCls="icon-reload" onclick="loadSZ();">刷新</a>
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
$(function(){
	loadSZ();
	setTimeout(function(){
		var res = document.getElementsByName("checks");
		var context = "";
	   	for(var i=0; i<res.length; i++){
	   		var check = res[i].checked;
	   		if(check == true){
	    		context += res[i].value + ",";
	    	}
	    }
	   	var parm = context ;
		window.parent.zdParm(parm, 'option');
	}, 2500);
});

var num = 0;
function allCheck(){
	if(num == 0){
		resetButton('queryForm1');
		num++;
	} else {
		var res = document.getElementsByName("checks");
		for(var i=0; i<res.length; i++){
			res[i].checked = true;
		}
		num = 0;
	}
}

//查询按钮
function queryButton(){
	var res = document.getElementsByName("checks");
	var context = "";
   	for(var i=0; i<res.length; i++){
   		if(res[i].checked == true){
    		context += res[i].value + ",";
    	}
    }
   	submits(context);
   	var parm = context ;
	window.parent.zdParm(parm, 'option');
}

function submits(pro){
	$.ajax({
		type:"POST",
		url:"<%= basePath%>homePage/uptSZ",
		dataType:"json",
		data:"userid=" + userid + "&pro=" + pro,
		success:function(data){
		if (data && data.length>0) {
			window.parent.zdParm(pro, 'msg');
		}
		}
	});
}

function loadSZ(){
	$.ajax({
		type:"POST",
		url:"<%= basePath%>homePage/querySZ",
		dataType:"json",
		data:"userid=" + userid,
		success:function(data){
		if (data && data.length>0) {
			for(var i=0; i<data.length; i++){
				var pro = data[i].pro;
				var sfxz = data[i].sfxz;
				if ("qyfw" == pro && "1"==sfxz) {
					document.getElementById("qyfw").checked = true;
				} else if("qyfw" == pro && "0"==sfxz){
					document.getElementById("qyfw").checked = false;
				}
				if ("zdrk" == pro && "1"==sfxz) {
					document.getElementById("zdrk").checked = true;
				} else if("zdrk" == pro && "0"==sfxz){
					document.getElementById("zdrk").checked = false;
				}
				if ("jq" == pro && "1"==sfxz) {
					document.getElementById("jq").checked = true;
				} else if("jq" == pro && "0"==sfxz){
					document.getElementById("jq").checked = false;
				}
				if ("aj" == pro && "1"==sfxz) {
					document.getElementById("aj").checked = true;
				} else if("aj" == pro && "0"==sfxz){
					document.getElementById("aj").checked = false;
				}
				if ("sj" == pro && "1"==sfxz) {
					document.getElementById("sj").checked = true;
				} else if("sj" == pro && "0"==sfxz){
					document.getElementById("sj").checked = false;
				}
				if ("xlxl" == pro && "1"==sfxz) {
					document.getElementById("xlxl").checked = true;
				} else if("xlxl" == pro && "0"==sfxz){
					document.getElementById("xlxl").checked = false;
				}
				if ("xlc" == pro && "1"==sfxz) {
					document.getElementById("xlc").checked = true;
				} else if("xlc" == pro && "0"==sfxz){
					document.getElementById("xlc").checked = false;
				}
				if ("xly" == pro && "1"==sfxz) {
					document.getElementById("xly").checked = true;
				} else if("xly" == pro && "0"==sfxz){
					document.getElementById("xly").checked = false;
				}
				if ("ssyj" == pro && "1"==sfxz) {
					document.getElementById("ssyj").checked = true;
				} else if("ssyj" == pro && "0"==sfxz){
					document.getElementById("ssyj").checked = false;
				}
				if ("jqfx" == pro && "1"==sfxz) {
					document.getElementById("jqfx").checked = true;
				} else if("jqfx" == pro && "0"==sfxz){
					document.getElementById("jqfx").checked = false;
				}
				if ("xljh" == pro && "1"==sfxz) {
					document.getElementById("xljh").checked = true;
				} else if("xljh" == pro && "0"==sfxz){
					document.getElementById("xljh").checked = false;
				}
				if ("kffx" == pro && "1"==sfxz) {
					document.getElementById("kffx").checked = true;
				} else if("kffx" == pro && "0"==sfxz){
					document.getElementById("kffx").checked = false;
				}
			}
		}
		}
	});
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}
-->
</script>  

</html>