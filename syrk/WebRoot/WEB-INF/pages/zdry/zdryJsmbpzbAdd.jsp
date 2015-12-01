<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>重点人员动态纪实模板配置</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>zdryJsmbpzb/save" id="dataForm" name="dataForm" method="post">
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<tr class="dialogTr">
					 
					<td width="20%" class="dialogTd" align="right">重点人员类型代码：</td>
					<td width="30%" class="dialogTd" >
						<input type="text" name="zdrygllxdm" id="zdrygllxdm" class="easyui-combobox" value="${entity.zdrygllxdm}" data-options="required:true,url: contextPath + '/common/dict/BD_D_ZDRYLBDMLIST_MUNICIPAL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'" style="width:200px" />
					</td>
					<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">模板名称：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="mbmc" name="mbmc" style="width:200px;" value="${entity.mbmc}" maxlength="20"
						data-options=""/>
					</td>
				</tr>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">是否默认：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-combobox" type="text" id="sfmr" name="sfmr" style="width:200px;" value="${entity.sfmr}"
						data-options="url:contextPath+'/common/dict/BD_D_SFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
					</td>
				</tr>
				<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">模板内容：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="mbnr" name="mbnr" style="width: 603px; height:48px;"
						data-options="validType:['maxLength[1000]'],invalidMessage:'模板内容不能超过1000个汉字，请重新输入！',required:false,tipPosition:'left',required:false">${entity.mbnr}</textarea>
					</td>
		    	</tr>
				<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">备注：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="bz" name="bz" style="width: 603px; height:48px;"
						data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',required:false,tipPosition:'left',required:false">${entity.bz}</textarea>
					</td>
		    	</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >

$(document).ready(function(){
	setInputReadonly('jgbmmc', true);
	$('#zdrygllxdm').combobox('setDataFilter', '^0[1-8]{1,1}$');
});

function doInit(paramArray) {
}

function beforeSubmit(){}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}
</script>