<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>居住证办理</title>
</head>

<body style="padding-left: 2px;">
<object id="ActiveX_print" width="420" height="250" classid="clsid:A55994D7-DCD1-45A2-B108-24DF72773B17">
</object>


<script language="javascript">

function data_refresh(Name_str, Sex_str,mz_str, Id_str,hjdz_str, xjzdz_str, bh_str,Date_startend_str, Path_str)
{
	try{
	ActiveX_print.data_refresh(Name_str, Sex_str,mz_str, Id_str,hjdz_str, xjzdz_str, bh_str,Date_startend_str, Path_str); 
	}catch(e){
		alert("打印机调用异常，请联系系统管理员。");
	}

}

function print_test(Name_str, Sex_str,mz_str, Id_str,hjdz_str, xjzdz_str, bh_str,Date_startend_str, Path_str)
{
	try{
	ActiveX_print.print_test(Name_str, Sex_str,mz_str, Id_str,hjdz_str, xjzdz_str, bh_str,Date_startend_str, Path_str); 
	}catch(e){
		alert("打印机调用异常，请联系系统管理员。");
	}
}

</script>
<script language="javascript">
var xb= window.top.getDictName(contextPath + '/common/dict/GB_D_XBDM.js', "${entity.xbdm}");
var mz= window.top.getDictName(contextPath + '/common/dict/GB_D_MZDM.js', "${entity.mzdm}");
var url ="<%=basePath%>/zpfjPtryzp/queryPtryzpSingle.jpg?ryid=${entity.ryid}&zjhm=${entity.zjhm}&cyzjdm=${entity.cyzjdm}";
var yxq ="${entity.jzz_qfrq}" +"至"+"${entity.yxq_jzrq}";

$(document).ready(function() { // 初始化部门名称
	data_refresh("${entity.xm}",xb,mz,"${entity.zjhm}","${entity.hjd_dzxz}","${entity.jzd_dzxz}","${entity.dy_bh}",yxq,url);
});

function print(){
	print_test("${entity.xm}",xb,mz,"${entity.zjhm}","${entity.hjd_dzxz}","${entity.jzd_dzxz}","${entity.dy_bh}",yxq,url);
}

</script>
</br></br>
 <a  class="easyui-linkbutton" iconCls="icon-add" onclick="print();">打印</a>
 </body>
</html>