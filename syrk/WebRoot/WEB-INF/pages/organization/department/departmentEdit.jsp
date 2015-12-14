<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>orgOrganization/save" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="id" value="${entity.id}" />
    	<input type="hidden" name="parentid" value="${entity.parentid}" />
	    <div data-options="region:'center', split:true" style="border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="816" align="center">
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">上级部门：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="parentOrgName" value="${parentOrgName}" style="width:200px;" maxlength="40"/></td>
		    	<td width="20%" class="dialogTd" align="right">部门类型：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="orgtype" name="orgtype" style="width:200px;" value="${entity.orgtype}"
					data-options="url: contextPath + '/common/dict/D_ORG_ORGTYPE.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">部门代码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="orgcode" value="${entity.orgcode}" style="width:200px;" maxlength="32" 
		    		data-options="required:true,validType:['letterOrNum'],invalidMessage:'部门代码必须为字母或数字组成，请重新输入！'"/></td>
		    	<td width="20%" class="dialogTd" align="right">部门名称：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="orgname" value="${entity.orgname}" style="width:200px;" maxlength="40" 
		    		data-options="required:true,validType:['noMark'],invalidMessage:'部门名称不能包含单引号、双引号，请重新输入！',tipPosition:'left'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">部门等级：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="orglevel" name="orglevel" style="width:200px;" value="${entity.orglevel}"
					data-options="url: contextPath + '/common/dict/D_ORG_ORGLEVEL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true"/></td>
		    	<td width="20%" class="dialogTd" align="right">部门业务类型：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="orgbiztype" name="orgbiztype" style="width:200px;" value="${entity.orgbiztype}"
					data-options="url: contextPath + '/common/dict/D_ORG_ORGBIZTYPE.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">部门地址：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" maxlength="60" name="address" value="${entity.address}" style="width:603px;"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">部门电话：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="linktel" value="${entity.linktel}" style="width:200px;" maxlength="50" 
		    		data-options="validType:['phone']"/></td>
		    	<td width="20%" class="dialogTd" align="right">部门联系人：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="linkman" value="${entity.linkman}" style="width:200px;" maxlength="30"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">联系人电话：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="linkmantel" value="${entity.linkmantel}" style="width:200px;" maxlength="50" 
		    		data-options="validType:['phone']"/></td>
		    	<td width="20%" class="dialogTd" align="right">部门主页：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="weburl" value="${entity.weburl}" style="width:200px;" maxlength="512"
		    		data-options="validType:['url'],tipPosition:'left'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">部门邮箱：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="email" value="${entity.email}" style="width:200px;" maxlength="128" 
		    		data-options="validType:['email']"/></td>
		    	<td width="20%" class="dialogTd" align="right"></td>
		    	<td width="30%" class="dialogTd"></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">所属行政区划：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-combobox" type="text" id="xzqh" name="xzqh" style="width:603px;" value="${entity.xzqh}"
					data-options="url: contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',multiple:true"/></td>
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
	setInputReadonly('parentOrgName', true);
	setInputReadonly('orgtype', true);
}

function beforeSubmit() {
}

function afterSubmit(submitData) {
}
</script>

</body>
</html>