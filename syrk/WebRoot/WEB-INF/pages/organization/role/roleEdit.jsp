<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>orgRole/save" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="id" value="${entity.id}"/>
    	<input type="hidden" name="managerorgid" value="${entity.managerorgid}"/>
	    <div data-options="region:'center', split:true" style="border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="816" align="center">
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">角色名称：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="rolename" value="${entity.rolename}" style="width:200px;" maxlength="20" 
		    		data-options="required:true,validType:['noMark'],invalidMessage:'角色名称不能包含单引号、双引号，请重新输入！',tipPosition:'left'"/></td>
		    	<td width="20%" class="dialogTd" align="right">角色管理部门：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="userManageOrgName" value="${userManageOrgName}" style="width:200px;"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">角色描述：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="roledesc" class="easyui-validatebox" style="width: 603px; height:48px;"
					data-options="validType:['maxLength[200]'],invalidMessage:'角色描述不能超过200个汉字，请重新输入！',tipPosition:'left'">${entity.roledesc}</textarea></td>
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
	setInputReadonly('userManageOrgName', true);
}

function beforeSubmit() {
}

function afterSubmit(submitData) {
}
</script>

</body>
</html>