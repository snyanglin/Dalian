<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>orgOrganization/bizRelationSave" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="id" value="${entity.id}" />
	    <div data-options="region:'center', split:true" style="border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="816" align="center">
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">上级部门：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="parentOrgName" value="${parentOrgName}" style="width:200px;" maxlength="40"/></td>
		    	<td width="20%" class="dialogTd" align="right">部门类型：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="orgtype" style="width:200px;" value="${entity.orgtype}"
					data-options="url: contextPath + '/common/dict/D_ORG_ORGTYPE.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">部门代码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="orgcode" value="${entity.orgcode}" style="width:200px;" maxlength="32" 
		    		data-options="required:true,validType:['letterOrNum'],invalidMessage:'部门代码必须为字母或数字组成，请重新输入！'"/></td>
		    	<td width="20%" class="dialogTd" align="right">部门名称：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="orgname" value="${entity.orgname}" style="width:200px;" maxlength="40" 
		    		data-options="required:true,validType:['noMark'],invalidMessage:'部门名称不能包含单引号、双引号，请重新输入！',tipPosition:'left'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">部门等级：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="orglevel" style="width:200px;" value="${entity.orglevel}"
					data-options="url: contextPath + '/common/dict/D_ORG_ORGLEVEL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true"/></td>
		    	<td width="20%" class="dialogTd" align="right">部门业务类型：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="orgbiztype" style="width:200px;" value="${entity.orgbiztype}"
					data-options="url: contextPath + '/common/dict/D_ORG_ORGBIZTYPE.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" style="color: #0000FF;">上级业务部门：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    		<table border="0" cellpadding="0" cellspacing="0">
		    		<tr>
		    			<td width="555"><textarea class="easyui-validatebox" rows="3" id="parentBizNames" name="parentBizNames" style="width:550px; height:48px;">${parentBizNames}</textarea></td>
		    			<td><input type="hidden" name="parentBizCodes" id="parentBizCodes" value="${parentBizCodes}"/>
		    				<input type="hidden" name="parentBizIds" id="parentBizIds" value="${parentBizIds}"/><input type="button" id="orgSelectButton" class="butSelect2" 
		    					onclick="window.parent.public_multiSelectOrg('', '', '', '', 'parentBizCodes', 'parentBizNames', 'parentBizIds', false, false, '', window, '', '')"/></td>
		    		</tr>
		    		</table>
		    	</td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >
function doInit(paramArray) {
	setInputReadonly('parentOrgName', true);
	setInputReadonly('orgtype', true);
	setInputReadonly('orgcode', true);
	setInputReadonly('orgname', true);
	setInputReadonly('orglevel', true);
	setInputReadonly('orgbiztype', true);
	setInputReadonly('parentBizNames', true);
}

function beforeSubmit() {
}

function afterSubmit(submitData) {
}

</script>

</body>
</html>