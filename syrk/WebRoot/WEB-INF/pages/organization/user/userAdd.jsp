<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>orgUser/save" id="dataForm" name="dataForm" method="post">
	     <div data-options="region:'center', split:true" id="formDiv" style="border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="816" align="center">
			<input type="hidden" name="id"/>
			<tr class="dialogTr" >
		        <td width="20%" class="dialogTd" align="right">人员帐号：</td>
		        <td width="30%" class="dialogTd"><input type="text" maxlength="20" name="userid" id="userid" style="width:200px;" class="easyui-validatebox"  
					data-options="required:true,tipPosition:'right',validType:['variable'],invalidMessage:'人员帐号必须为字母、数字或下划线组成！'"/>
		        </td>
		        <td width="20%" class="dialogTd" align="right">登录密码：</td>
		        <td width="30%" class="dialogTd"><input type="password" maxlength="20" name="password" id="password" style="width:200px;" class="easyui-validatebox" 
                    data-options="required:true,tipPosition:'left',charSet:'half'"/>
		        </td>
		    </tr>
		    <tr class="dialogTr">
		        <td width="20%" class="dialogTd" align="right">人员姓名：</td>
		        <td width="30%" class="dialogTd"><input type="text" maxlength="20" name="username" id="username" style="width:200px;" class="easyui-validatebox" 
                    data-options="required:true,tipPosition:'right',validType:['noMark'],invalidMessage:'人员姓名不能包含单引号、双引号！'"/>
		        </td>
		        <td width="20%" class="dialogTd" align="right">原所在上级部门：</td>
		        <td width="30%" class="dialogTd"><input type="text" maxlength="20" id="parentOrgName" value="${parentOrgName}" style="width:200px;" class="easyui-validatebox"/>
		        </td>
		    </tr>
		    <tr class="dialogTr" >
		        <td width="20%" class="dialogTd"  align="right">所在部门：</td>
		        <td width="30%" class="dialogTd">
					<input type="hidden" name="userOrgCode" id="userOrgCode">
					<input type="hidden" name="userOrgId" id="userOrgId"/>
					<input type="text" name="userOrgName" id="userOrgName" style="width:145px;" class="easyui-validatebox"/>
					<input type="button" id="orgbutton" value="选 择" class="dictSearchButton" onClick="window.parent.public_singleSelectOrg('${userManageOrgCode}', '01', '', '', 'userOrgCode', 'userOrgName', 'userOrgId', false, false, '', window, 'isValidManagerOrg', '')" />
				</td>
		        <td width="20%" class="dialogTd"  align="right">人员类型：</td>
		        <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="usertype" name="usertype" style="width:200px;" value="3"
					data-options="url: contextPath + '/common/dict/D_ORG_USERTYPE.js',dataFilter:'3',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:usertype_exit"/></td>
		    </tr>
		    <tr class="dialogTr">
		        <td width="20%" class="dialogTd"  align="right">管理部门：</td>
		        <td width="30%" class="dialogTd">
					<input type="hidden" name="managerorgcode" id="managerorgcode"/>
					<input type="hidden" name="managerorgid" id="managerorgid"/>
					<input type="text" name="managerorgname" id="managerorgname" style="width:145px;" class="easyui-validatebox"/>
					<input type="button" id="managerButton" value="选 择" class="dictSearchButton" onClick="window.parent.public_singleSelectOrg('${userManageOrgCode}', '', '', '', 'managerorgcode', 'managerorgname', 'managerorgid', false, false, '', window, '', '')" />
		        </td>
				<td width="20%" class="dialogTd" align="right">身份证号码：</td>
				<td width="30%" class="dialogTd"><input class='easyui-validatebox' style="width:200px;" type='text' maxlength="30" name='identitycard' id="identitycard"
					data-options="required:false,charSet:'halfUpper',validType:['sfzh'],tipPosition:'right'"/></td>
			</tr>
		    <tr class="dialogTr" >
		        <td width="20%" class="dialogTd" align="right">行业号码（警号）：</td>
		       	<td width="30%" class="dialogTd"><input type="text" maxlength="30" id="industrialid" name="industrialid" style="width:200px;" class="easyui-validatebox" />
		       	</td>
		        <td width="20%" class="dialogTd" align="right">民族：</td>
		        <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="nation" name="nation" style="width:200px;" 
					data-options="url: contextPath + '/common/dict/D_BZ_MZ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8"/></td>
		    </tr>
		    <tr class="dialogTr" >
		        <td width="20%" class="dialogTd" align="right">性别：</td>
		        <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sex" name="sex" style="width:200px;" 
					data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
		        <td width="20%" class="dialogTd" align="right">出生日期：</td>
		        <td width="30%" class="dialogTd"><input type="text" maxlength="20" id="birthday" name="birthday" class="easyui-validatebox " style="width:200px;" 
				    data-options="validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" /> 
		        </td>
		    </tr>
		     <tr class="dialogTr" >
		        <td width="20%" class="dialogTd" align="right">办公电话：</td>
		        <td width="30%" class="dialogTd"><input type="text" maxlength="50" id="telephone" name="telephone" style="width:200px;" class="easyui-validatebox"   
                    data-options="required:false,validType:['phone'],charSet:'halfUpper',tipPosition:'right'"/>
		        </td>
		        <td width="20%" class="dialogTd" align="right">移动电话：</td>
		        <td width="30%" class="dialogTd"><input type="text" maxlength="50" id="mobile" name="mobile" style="width:200px;" class="easyui-validatebox"   
                    data-options="required:false,validType:['manyMobils'],charSet:'halfUpper',tipPosition:'left'"/>
		        </td>
		    </tr>
		    <tr class="dialogTr" >
		       <td width="20%" class="dialogTd" align="right">主题风格：</td>
		       <td width="30%" class="dialogTd"><input type="text" maxlength="10" id="theme" name="theme" style="width:200px;" class="easyui-validatebox" />
		       </td>
		       <td width="20%" class="dialogTd" align="right">电子邮件：</td>
		       <td width="30%" class="dialogTd"><input type="text" maxlength="50" id="email" name="email" style="width:200px;" class="easyui-validatebox" 
                    data-options="validType:['email'],tipPosition:'left'" /></td>
		    </tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea id="bz" name="bz" class="easyui-validatebox" style="width: 603px; height:48px;"
					data-options="validType:['maxLength[200]'],invalidMessage:'备注不能超过200个汉字，请重新输入！',tipPosition:'left'"></textarea></td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >
function doInit(paramArray) {
	setInputReadonly('parentOrgName', true);
	setInputReadonly('userOrgName', true);
	setInputReadonly('managerorgname', true);
	setInputDisabled('managerButton', true);
}

function beforeSubmit() {
	var userTypeValue = $("#usertype").combobox("getValue");
	var managerorgidValue = $("#managerorgid").val();
	if (userTypeValue == "2" && managerorgidValue == "") {
		topMessager.alert('', '管理人员请选择管理部门！');
		$("#managerButton").focus();
		return false;
	}
}

function afterSubmit(submitData) {
}

//设置管理部门
function usertype_exit(newVal, oldVal) {
	var userTypeValue = $("#usertype").combobox("getValue");
	if (userTypeValue == "2") {
		$('#managerorgname').validatebox({required:true});
		setInputDisabled('managerButton', false);
	}
	else {
		$('#managerorgname').validatebox({required:false});
		$('#managercode').val("");
		$('#managerorgid').val("");
		$('#managerorgname').val("");
		setInputDisabled('managerButton', true);
	}
	isValidManagerOrg();
}

function isValidManagerOrg() {
	var userOrgCodeValue = $("#userOrgCode").val();
	if (userOrgCodeValue == "") {
		$('#usertype').combobox('setDataFilter', '3');
		$("#usertype").combobox("setValue","3");
		$("#managercode").val("");
		$("#managerorgid").val("");
		$("#managerorgname").val("");
		setInputDisabled('managerButton', true);
	}
	else {
		$('#usertype').combobox('setDataFilter', '2|3');
	}
}

</script>

</body>
</html>