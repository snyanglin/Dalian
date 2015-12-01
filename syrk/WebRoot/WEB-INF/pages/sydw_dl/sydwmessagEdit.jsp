<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>实有单位注销</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>sydwgl_dl/calcle_xxzsnrb" id="dataForm" name="dataForm" method="post">
    	
    	<input type='hidden' name='id'  value="${id}" />
    	<input type="hidden" name="url" value="${url}" />
    
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">注销理由：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="xt_zxyy" id="xt_zxyy" class="easyui-validatebox" style="width: 613px; height:48px;"
					data-options="validType:['maxLength[100]'],invalidMessage:'注销理由不能超过100个汉字，请重新输入！',tipPosition:'left'"></textarea></td>
	    	</tr>
			
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >

function beforeSubmit() {
}

function afterSubmit(arr) {
	
	
}


</script>