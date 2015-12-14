<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>orgPosition/save" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="id" value="${entity.id}"/>
	    <div data-options="region:'center', split:true" style="border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="816" align="center">
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">岗位ID：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="posid" value="${entity.posid}" style="width:200px;" maxlength="100" 
		    		data-options="required:true,validType:['letterOrNum'],charSet:'halfUpper',invalidMessage:'岗位ID必须为字母或数字组成，请重新输入！'"/></td>
		    	<td width="20%" class="dialogTd" align="right">岗位名称：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="posname" value="${entity.posname}" style="width:200px;" maxlength="20" 
		    		data-options="required:true,validType:['noMark'],invalidMessage:'岗位名称不能包含单引号、双引号，请重新输入！',tipPosition:'left'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">岗位描述：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="posdesc" class="easyui-validatebox" style="width: 603px; height:48px;"
					data-options="validType:['maxLength[200]'],invalidMessage:'岗位描述不能超过200个汉字，请重新输入！',tipPosition:'left'">${entity.posdesc}</textarea></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz" class="easyui-validatebox" style="width: 603px; height:48px;"
					data-options="validType:['maxLength[200]'],invalidMessage:'备注不能超过200个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea></td>
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