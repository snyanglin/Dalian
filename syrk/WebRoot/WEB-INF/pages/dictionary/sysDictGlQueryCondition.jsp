<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<body> 
<div class="easyui-layout" data-options="fit:true">
    <form action="" id="queryForm" name="queryForm" method="post">
	    <div data-options="region:'center',split:true" style="padding: 6px; border-width: 0px;">
	    	<table border="0" cellpadding="0" cellspacing="10" width="816" align="center">
	    	<tr class="dialogTr">
		    	<td width="15%" class="dialogTd" align="right">字典英文名：</td>
		    	<td width="35%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zdywm" name="zdywm" style="width:200px;" maxlength="20" data-options="validType:['variable'],charSet:'halfUpper'"/>（模糊）</td>
		    	<td width="15%" class="dialogTd" align="right">字典中文名：</td>
		    	<td width="35%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zdzwm" name="zdzwm" style="width:200px;" maxlength="20" data-options="validType:['noMark']"/>（模糊）</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="15%" class="dialogTd" align="right">生成类别：</td>
		    	<td width="35%" class="dialogTd"><input class="easyui-combobox" type="text" id="zdsclb" name="zdsclb" style="width:200px;"
					data-options="url: contextPath + '/common/dict/D_SYS_ZDSCLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
		    	<td width="15%" class="dialogTd" align="right">使用类别：</td>
		    	<td width="35%" class="dialogTd"><input class="easyui-combobox" type="text" id="zdsylb" name="zdsylb" style="width:200px;"
					data-options="url: contextPath + '/common/dict/D_SYS_ZDSYLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="15%" class="dialogTd" align="right">业务类别：</td>
		    	<td width="35%" class="dialogTd"><input class="easyui-combobox" type="text" id="zdywlb" name="zdywlb" style="width:200px;"
					data-options="url: contextPath + '/common/dict/D_SYS_ZDYWLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
		    	<td width="15%" class="dialogTd" align="right"></td>
		    	<td width="35%" class="dialogTd"></td>
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
</script>

</body>
</html>
