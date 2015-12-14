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
    <form action="" id="queryForm" name="queryForm" method="post">
	    <div data-options="region:'center',split:true" style="padding: 6px; border-width: 0px;">
	    	<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	<tr class="dialogTr">
		    	<td width="30%" class="dialogTd" align="right">参数类别：</td>
		    	<td width="70%" class="dialogTd"><input class="easyui-combobox" type="text" id="cslb" name="cslb" style="width:200px;"
					data-options="url: 'D_SYS_CSLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="30%" class="dialogTd" align="right">参数名称：</td>
		    	<td width="70%" class="dialogTd"><input class="easyui-validatebox" type="text" name="csmc" style="width:200px;"/>（模糊查询）</td>
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