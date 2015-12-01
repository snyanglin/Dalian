<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>重点人员管理配置</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>zdryGlpzpzb/save" id="dataForm" name="dataForm" method="post">
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<tr class="dialogTr">
					 
					<td width="20%" class="dialogTd" align="right">重点人员类型代码：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-combobox" type="text"  id="zdrygllxdm" name="zdrygllxdm"   style="width:200px;" value="${entity.zdrygllxdm }"
					data-options="url: contextPath +  '/common/dict/BD_D_ZDRYLBDMLIST_MUNICIPAL.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
						<div class="lodingimg" id="checkDiv"></div>
					</td>
					<td width="20%" class="dialogTd" align="right">监管部门：</td>
					<td width="30%" class="dialogTd" >
						<input type="text" id="jgbmmc" name="jgbmmc" style="width: 150;" value="${entity.jgbmmc}"/>
						<input type="hidden" id="jgbmdm" name="jgbmdm" value="${entity.jgbmdm}"/>
						<input type="button" id="orgbutton1" value="选择" onClick="public_singleSelectOrg('', '01', '', '', 'jgbmdm', 'jgbmmc', '', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">是否上级审批：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-combobox" type="text" id="sfsjsp" name="sfsjsp" style="width:200px;" value="${entity.sfsjsp}"
						data-options="url:contextPath+'/common/dict/BD_D_SFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">动态纪实周期：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-combobox" type="text" id="dtjszqdm" name="dtjszqdm" style="width:200px;" value="${entity.dtjszqdm}"
						data-options="url:contextPath+'/common/dict/DL_D_DTJSZQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
					</td>
				</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
var _zdrygllxdm='${entity.zdrygllxdm }';

$(document).ready(function(){
	setInputReadonly('jgbmmc', true);
	if(_zdrygllxdm&&_zdrygllxdm!=''){
		setInputReadonly('zdrygllxdm', true);
	}
});

//判断类型代码是否已存在
function check(){
	var checkResult;
	if(!$("#zdrygllxdm").validatebox("isValid")){
		return;
	}
	$("#checkDiv").show();
	$.ajax({
		type:"POST",
		url:"<%= basePath%>zdryGlpzpzb/check",
		dataType:"json",
		data:"zdrygllxdm="+$("#zdrygllxdm").val(),
		async:false,
		success:function(data){
			checkResult = data;
			if(data){
				$.messager.alert('确认对话框', '该类型代码已存在！请重新输入', 'warning', function(){
					$("#zdrygllxdm").focus();
				});
			}
		},
		complete:function(){
			$("#checkDiv").hide();
		}
	});
	return checkResult;
}

function doInit(paramArray) {
}

function beforeSubmit(){
	if($('#pk').val() == null && $('#pk').val() == undefined){
		if(check()){
			return false;
		}
	}
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}
</script>