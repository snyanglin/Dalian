<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>sysDict/save" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="id" value="${entity.id}"/>
    	<input type="hidden" name="glid" value="${entity.glid}"/>
	    <div data-options="region:'center', split:true" style="border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="616" align="center">
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">字典代码：</td>
		    	<td width="80%" class="dialogTd"><input class="easyui-validatebox" type="text" id="dm" name="dm" value="${entity.dm}" style="width:200px;" maxlength="30" data-options="required:true,validType:['letterOrNum'],invalidMessage:'字典代码不能为空且只能由英文字母或数字组成，请重新输入！'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">字典词条：</td>
		    	<td width="80%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ct" name="ct" value="${entity.ct}" style="width:400px;" maxlength="100" data-options="required:true,validType:['noMark'],invalidMessage:'字典词条不能为空且不能包含单引号、双引号、分号，请重新输入！',tipPosition:'bottom'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注：</td>
		    	<td width="80%" class="dialogTd"><input class="easyui-validatebox" type="text" id="bz" name="bz" value="${entity.bz}" style="width:400px;" maxlength="250" data-options="tipPosition:'bottom'"/></td>
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