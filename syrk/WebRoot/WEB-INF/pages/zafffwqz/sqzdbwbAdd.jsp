<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>社区重点部位</title>
</head>

<div class="easyui-layout" data-options="fit:true">
   <form action="<%=basePath%>sqzdbwb/saveSqzdbwb" id="dataForm" name="dataForm" method="post">
   
		<input type="hidden" id="pk" name="id" value="${entity.id}" />
		<input type="hidden" id="sqid" name="sqid" value="" />
		<input type="hidden" id="sqjwsid" name="sqjwsid" value="${entity.sqjwsid}">
		
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">重点部位名称：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="zdbwmc" name="zdbwmc" style="width:200px;" value="${entity.zdbwmc}" maxlength="30" 
			    		data-options="required:true,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">重点部位类型：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="dz_zdbwlxdm" name="dz_zdbwlxdm" style="width:200px;" value="${entity.dz_zdbwlxdm}" maxlength="18"
			    		data-options="url:contextPath+'/common/dict/D_ZAFF_ZDBWLX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">确定日期：</td>
			    	<td width="30%" class="dialogTd"><input type="text" name="qdrq" id="qdrq" class="easyui-validatebox" style="width: 200px;" maxlength="19" value="${entity.qdrq}"
		     			onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" data-options="tipPosition:'right',validType:['date[\'yyyy-MM-dd\']']"/>
		     		</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">部位描述：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="bwms" name="bwms" style="width: 629px; height:48px;"
						data-options="validType:['maxLength[100]'],invalidMessage:'部位描述不能超过100个汉字，请重新输入！',required:false,tipPosition:'left',required:false">${entity.bwms}</textarea>
					</td>
		    	</tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">重点部位地址：</td>
					<td width="50%" class="dialogTd" colspan="2">
						<input class="easyui-combobox" id="zdbw1" style="width:400px;" value="${entity.dz_zdbwmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
			    		<input type='hidden' name='dz_zdbwmlpdm' id="zdbw_zdbwmlpdm" value="${entity.dz_zdbwmlpdm}"/>
			    		<input type='hidden' name='dz_zdbwmlpxz' id="zdbw_zdbwmlpxz" value="${entity.dz_zdbwmlpxz}"/>
		    		</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox" id="zdbw2" style="width:200px;" value="${fn:replace(entity.dz_zdbwxz, entity.dz_zdbwmlpxz, '')}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_zdbwdzdm' id='zdbw_zdbwdzdm' value="${entity.dz_zdbwdzdm}" />
				    	<input type='hidden' name='dz_zdbwssxdm' id='zdbw_zdbwssxdm' value="${entity.dz_zdbwssxdm}" />
				    	<input type='hidden' name='dz_zdbwxz' id='zdbw_zdbwxz' value="${entity.dz_zdbwxz}" /> 
					</td>
				</tr>
				<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">备注：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="bz" name="bz" style="width: 629px; height:48px;" 
						data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',required:false,tipPosition:'left',required:false">${entity.bz}</textarea>
					</td>
		    	</tr>
	    	</table>
	    </div>
    </form>
</div>

</html>
<script type="text/javascript" >

var _zjhm = "";
$(document).ready(function(){
	initAddressSearch('zdbw1', {}, 'zdbw_zdbwmlpdm', 'zdbw_zdbwmlpxz', 'zdbw2', {text:'zdbw_zdbwxz',dzxzqh:'zdbw_zdbwssxdm',id:'zdbw_zdbwdzdm'}, null, null);
});

function doInit(paramArray) {
	$("#sqid").val(paramArray["sqid"]);
}

function beforeSubmit(){
	
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	
}

</script>