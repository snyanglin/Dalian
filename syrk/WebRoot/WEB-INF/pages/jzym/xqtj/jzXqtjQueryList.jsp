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
			           <tr class="dialogTr" align="center">
				        <!-- 210200000000 -->
							<td width="50%" height="100" class="dialogTd">
								<a class="lf_ddicon" href="javascript:void(0)" onclick="query('sstj')">
									<img src="<%=contextPath%>/images/navigator/lunbo-6.png" border="0" alt="辖区概况" width="70" height="70"/><span>三实统计</span></a>
							</td>
							<td width="50%" height="100" class="dialogTd">
								<a class="lf_ddicon" href="javascript:void(0)" onclick="query('lktj')">
									<img src="<%=contextPath%>/images/navigator/syrkzh.png" border="0" alt="今日警情" width="70" height="70"/><span>流口统计<label id="count"></label></span></a>
							</td>
			            </tr>
			            <tr class="dialogTr" align="center">
							<td width="50%" height="100" class="dialogTd">
								<a class="lf_ddicon" href="javascript:void(0)" onclick="query('gzdx')">
									<img src="<%=contextPath%>/images/navigator/syrkhs.png" border="0" alt="工作动态" width="70" height="70"/><span>工作对象</span></a>
							</td>
							<td width="50%" height="100" class="dialogTd">
								<a class="lf_ddicon" href="javascript:void(0)" onclick="query('nltj')">
									<img src="<%=contextPath%>/images/navigator/lunbo-2.png" border="0" alt="警务态势" width="70" height="70"/><span>年龄统计</span></a>
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
	
});

//条件查询按钮
function query(type){
	var parm = "?gxdwdm=" + orgcode;
	if("sstj" == type){
		parm = "?gxdwdm=" + orgcode;
		window.parent.zdParm(parm, type);
	} else if("lktj" == type){
		parm = "?gxdwdm=" + orgcode;
		window.parent.zdParm(parm, type);
	} else if("gzdx" == type){
		parm = "?gxdwdm=" + orgcode;
		window.parent.zdParm(parm, type);
	} else if("nltj" == type){
		parm = "?gxdwdm=" + orgcode;
		window.parent.zdParm(parm, type);
	}
}

//查询按钮
function queryButton(){
	
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}
-->
</script>  

</html>