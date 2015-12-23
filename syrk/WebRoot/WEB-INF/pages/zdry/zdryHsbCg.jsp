<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>重点人员列撤管</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>zdryHsb/saveHsCg"  id="dataForm" name="dataForm" method="post" >
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
	    <input type='hidden' id="zdryHsbId" name="zdryHsbId" value="${zdryHsb.id}"/>
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" name="zdryHsb.xm" style="width:200px;" readonly="readonly"  value="${zdryHsb.xm}"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zdryHsb.zjhm" style="width:200px;" readonly="readonly" value="${zdryHsb.zjhm}"/></td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">撤管类别：</td>
		    	<td width="30%" class="dialogTd" colspan="3">
		    	<input class="easyui-combobox" type="text"  id="cglxdm" name="cglxdm"   style="width:200px;" value="${zdrygllxdm}"
					data-options="url: contextPath +  '/common/dict/BD_D_ZDRYLBDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
		    	</td>
		    </tr>
		    <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">重点人员管理类型：</td>
		    	<td width="30%" class="dialogTd">
					<input class="easyui-combobox " type="text"  id="zdrygllxdm" name="zdryZdryzb.zdrygllxdm"   style="width:200px;" value="6" 
					data-options="url: contextPath +  '/common/dict/BD_D_ZDRYLBDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
				</td>
		    </tr>
		    </table>
		     <!-- 列管公共信息 -->
	    	<table id="ggDiv" border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="margin-top: -10px;">
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="lgrqText">业务办理日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="ywclsj" id="ywclsj" class="easyui-validatebox inputreadonly" style="width: 200px;" value="${Sqsj}" readonly="readonly" /></td>
		    	<td width="20%" class="dialogTd" align="right" id="lgrText">业务办理人：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" id="ywblr_xm" name="ywblr_xm" style="width:200px;" value="${sqr_xm }" readonly="readonly" />
		    	</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="lgsqyjText">申请意见：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-validatebox " type="text" id="sqyj" name="sqyj" style="width: 626px;" data-options="required:false,validType:['maxLength[100]','unnormal']" /></td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>
<script type="text/javascript" >
$(document).ready(function(){
	setInputReadonly("zdrygllxdm", true);
	setInputReadonly("cglxdm", true);
	
});


function doInit(paramArray) {
}

function beforeSubmit() {
	
	
}

function afterSubmit() {
	
}







	
</script>