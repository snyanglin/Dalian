<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=basePath %>js/jquery/jquery1.11.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery/jquery.easyui.extend.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/easyui/themes/custom.css" />

<title>系统参数</title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>sysXtcsGlobal/save" id="dataForm" name="dataForm" method="post">
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">参数名称：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="csmc" style="width:200px;" maxlength="40" data-options="required:true,invalidMessage:'参数名称必须为合法的变量名称，请重新输入！'"/></td>
		    	<td width="20%" class="dialogTd" align="right">参数类别：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="cslb" name="cslb" style="width:200px;"
					data-options="url: 'D_SYS_CSLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">参数值：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="csz" class="easyui-validatebox" style="width: 613px; height:48px;"
					data-options="required:true,validType:['maxLength[500]'],tipPosition:'left'"></textarea></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">参数说明：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" name="cssm" style="width: 613px;" maxlength="100"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz" class="easyui-validatebox" style="width: 613px; height:48px;"
					data-options="validType:['maxLength[250]'],invalidMessage:'备注不能超过250个汉字，请重新输入！',tipPosition:'left'"></textarea></td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >
function doInit(paramArray) {
}

function beforeSubmit() {
}

function afterSubmit(submitData) {
}
</script>

</body>
</html>