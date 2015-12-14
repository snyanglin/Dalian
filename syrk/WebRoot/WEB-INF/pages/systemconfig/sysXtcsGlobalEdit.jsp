<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>sysXtcsGlobal/save" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="id" value="${entity.id}"/>
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">参数名称：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="csmc" value="${entity.csmc}" style="width:200px;" maxlength="40" data-options="required:true,validType:['variable'],invalidMessage:'参数名称必须为合法的变量名称，请重新输入！'"/></td>
		    	<td width="20%" class="dialogTd" align="right">参数类别：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="cslb" name="cslb" value="${entity.cslb}" style="width:200px;"
					data-options="url: contextPath + '/common/dict/D_SYS_CSLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">参数值：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="csz" class="easyui-validatebox" style="width: 613px; height:48px;"
					data-options="required:true,validType:['maxLength[500]'],tipPosition:'left'">${entity.csz}</textarea></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">参数说明：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" name="cssm" value="${fn:escapeXml(entity.cssm)}" style="width: 613px;" maxlength="100"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz" class="easyui-validatebox" style="width: 613px; height:48px;"
					data-options="validType:['maxLength[250]'],invalidMessage:'备注不能超过250个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea></td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript">
function doInit(paramArray) {
}

function beforeSubmit() {
}

function afterSubmit(submitData) {
}
</script>

</body>
</html>

