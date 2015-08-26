<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<body >
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>orgUser/savePersonal" id="dataForm" name="dataForm" method="post">
		<div data-options="region:'north',split:false,title:'',border:false,collapsible:false" class="datagrid-toolbar" style="padding: 5px; height: 37; overflow: hidden;">
			<table cellspacing="0" cellpadding="0" border="0" width="100%">
				<tbody>
				<tr>
				<td class="toolbarTd" nowrap="nowrap" width="100">
					<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
						<span class="l-btn-left l-btn-icon-left">
							<span class="l-btn-text" nowrap="nowrap">保存</span>
							<span class="l-btn-icon icon-save"> </span>
						</span>
					</a>
				</td>
				</tr>
				</tbody>
			</table>
		</div>    
	     <div data-options="region:'center',split:false,border:false" id="formDiv" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="816" align="center">
			<input type="hidden" name="id" value="${entity.id}"/>
			<tr class="dialogTr" >
		        <td width="20%" class="dialogTd" align="right">人员帐号：</td>
		        <td width="30%" class="dialogTd"><input type="text" maxlength="20" name="userid" id="userid" value="${entity.userid}" style="width:200px;" class="easyui-validatebox"  
					data-options="required:true,tipPosition:'right',validType:['variable'],invalidMessage:'人员帐号必须为字母、数字或下划线组成！'"/>
		        </td>
		        <td width="20%" class="dialogTd" align="right">登录密码：</td>
		        <td width="30%" class="dialogTd"><input type="password" maxlength="20" name="password" id="password" value="${entity.password}" style="width:200px;" class="easyui-validatebox" 
                    data-options="required:true,tipPosition:'left',charSet:'half'"/>
		        </td>
		    </tr>
		    <tr class="dialogTr">
		        <td width="20%" class="dialogTd" align="right">人员姓名：</td>
		        <td width="30%" class="dialogTd"><input type="text" maxlength="20" name="username" id="username" value="${entity.username}" style="width:200px;" class="easyui-validatebox" 
                    data-options="required:true,tipPosition:'right',validType:['noMark'],invalidMessage:'人员姓名不能包含单引号、双引号！'"/>
		        </td>
		        <td width="20%" class="dialogTd"  align="right">所在部门：</td>
		        <td width="30%" class="dialogTd">
					<input type="hidden" name="userOrgCode" id="userOrgCode" value="${userOrgCode}"/>
					<input type="hidden" name="userOrgId" id="userOrgId" value="${userOrgId}"/>
					<input type="text" name="userOrgName" id="userOrgName" value="${userOrgName}" style="width:200px;" class="easyui-validatebox"/>
				</td>
		    </tr>
		    <tr class="dialogTr" >
		        <td width="20%" class="dialogTd"  align="right">人员类型：</td>
		        <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="usertype" name="usertype" value="${entity.usertype}" style="width:200px;"
					data-options="url: contextPath + '/common/dict/D_ORG_USERTYPE.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
		        <td width="20%" class="dialogTd"  align="right">管理部门：</td>
		        <td width="30%" class="dialogTd">
					<input type="hidden" name="managerorgcode" id="managerorgcode" value="${managerorgcode}"/>
					<input type="hidden" name="managerorgid" id="managerorgid" value="${entity.managerorgid}"/>
					<input type="text" name="managerorgname" id="managerorgname" style="width:200px;" class="easyui-validatebox" value="${managerorgname}"/>
		        </td>
		    </tr>
		    <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">身份证号码：</td>
				<td width="30%" class="dialogTd"><input class='easyui-validatebox' style="width:200px;" type='text' maxlength="30" name='identitycard' id="identitycard" value="${entity.identitycard}"
					data-options="required:false,charSet:'halfUpper',validType:['sfzh'],tipPosition:'right'"/></td>
		        <td width="20%" class="dialogTd" align="right">行业号码（警号）：</td>
		       	<td width="30%" class="dialogTd"><input type="text" maxlength="30" id="industrialid" name="industrialid" value="${entity.industrialid}" style="width:200px;" class="easyui-validatebox" />
		       	</td>
			</tr>
		    <tr class="dialogTr" >
		        <td width="20%" class="dialogTd" align="right">民族：</td>
		        <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="nation" name="nation" value="${entity.nation}" style="width:200px;" 
					data-options="url: contextPath + '/common/dict/D_BZ_MZ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
		        <td width="20%" class="dialogTd" align="right">性别：</td>
		        <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sex" name="sex" value="${entity.sex}" style="width:200px;" 
					data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
		    </tr>
		    <tr class="dialogTr" >
		        <td width="20%" class="dialogTd" align="right">出生日期：</td>
		        <td width="30%" class="dialogTd"><input type="text" maxlength="20" id="birthday" name="birthday" value="${entity.birthday}" class="easyui-validatebox " style="width:200px;" 
				    data-options="validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" /> 
		        </td>
		        <td width="20%" class="dialogTd" align="right"></td>
		       	<td width="30%" class="dialogTd"></td>
		    </tr>
		     <tr class="dialogTr" >
		        <td width="20%" class="dialogTd" align="right">办公电话：</td>
		        <td width="30%" class="dialogTd"><input type="text" maxlength="50" id="telephone" name="telephone" value="${entity.telephone}" style="width:200px;" class="easyui-validatebox"   
                    data-options="required:false,validType:['phone'],charSet:'halfUpper',tipPosition:'right'"/>
		        </td>
		        <td width="20%" class="dialogTd" align="right">移动电话：</td>
		        <td width="30%" class="dialogTd"><input type="text" maxlength="50" id="mobile" name="mobile" value="${entity.mobile}" style="width:200px;" class="easyui-validatebox"   
                    data-options="required:false,validType:['mobile'],charSet:'halfUpper',tipPosition:'left'"/>
		        </td>
		    </tr>
		    <tr class="dialogTr" >
		       <td width="20%" class="dialogTd" align="right">主题风格：</td>
		       <td width="30%" class="dialogTd"><input type="text" maxlength="10" id="theme" name="theme" value="${entity.theme}" style="width:200px;" class="easyui-validatebox" />
		       </td>
		       <td width="20%" class="dialogTd" align="right">电子邮件：</td>
		       <td width="30%" class="dialogTd"><input type="text" maxlength="50" id="email" name="email" value="${entity.email}" style="width:200px;" class="easyui-validatebox" 
                    data-options="validType:['email'],tipPosition:'left'" /></td>
		    </tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea id="bz" name="bz" class="easyui-validatebox" style="width: 603px; height:48px;"
					data-options="validType:['maxLength[200]'],invalidMessage:'备注不能超过200个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea></td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

$(document).ready(function() {
	setInputReadonly('userid', true);
	setInputReadonly('username', true);
	setInputReadonly('userOrgName', true);
	setInputReadonly('usertype', true);
	setInputReadonly('managerorgname', true);
	
	$("#saveBotton").bind("click",function() {
		var bottonObject = this;
		if (buttonDisabled(bottonObject) == false) {
			return false;
		}	
		if ($('#dataForm').form('validate')) { // 表单的验证
			topMessager.confirm('', '您是否要保存当前的数据？', function(r) {
				if (r) {
					$('#dataForm').form('submit',{
						dataType : 'json',
						onSubmit: function() {
						},
						success: function(result) {
							buttonEnabled(bottonObject);
							result = parseReturn(result);
							if (result.status == 'success') { // 返回成功后执行的方法
								doSubmitResult(result, null, null);
							}
							else {
								topMessager.alert(MESSAGER_TITLE, result.message, 'error');
							}
						}
					});			
				}
				else {
					buttonEnabled(bottonObject);
				}
			});
		}
		else {
			buttonEnabled(bottonObject);
		}
	});	
	
});

</script>

</body>
</html>