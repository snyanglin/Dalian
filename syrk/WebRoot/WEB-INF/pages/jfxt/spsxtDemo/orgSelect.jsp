<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>

</head>

<html>
<head>
<title>组织机构选择测试页面</title>

</head>

<body> 
   	
<table width="100%">   	
   	<tr>
	   	<td>单选部门（所有数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="orgcode1" name="orgcode1" value="" style="width: 100;" />
	    <input type="text" id="orgname1" name="orgname1" style="width: 400;" value="" />
	   	<input type="text" id="orgid1" name="orgid1" value="" style="width: 100;" />
	    <input type="button" id="orgbutton1" value="选择" onClick="selectOrganization()" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
</table>


<script language="JavaScript">

var g_filterOrgCode="210200000000";//全局变量

$(document).ready(function() { // 初始化部门名称
	public_getOrgName('orgcode', 'orgname');
	setFilterOrgCode();//获得初始过滤组织机构
});


//点击按钮后调用
function selectOrganization(){
	//第四个参数取值:01--社区,04--责任区
	public_singleSelectOrg(g_filterOrgCode, '01', '', '04', 'orgcode1', 'orgname1', 'orgid1', false, false, '', window, 'onOrgSelected', '');
	
}
//为全局变量赋值
function setFilterOrgCode(){
	url=contextPath+"/idName/getFilterOrgCode";
	$.getJSON(url,function(orgCode){
		g_filterOrgCode=orgCode;
		alert(orgCode);
	})
}

function onOrgSelected(orgCodeInputID) {
	alert(orgCodeInputID);
}

</script>

</body>
</html>
