<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>人员虚拟身份信息</title>
</head>
<body>
	<form action="" id="dataForm" name="dataForm" method="post" >
	
		<input type="hidden" id="_method" name="_method" value=""/>
		<input type='hidden' name='id' id="pk" value="${entity.id}" />
		<input type="hidden" id="ryid" name="ryid" value="${entity.ryid}"/>
		
		<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">账户类型：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="zhlxdm" name="zhlxdm" style="width:200px;" value="${entity.zhlxdm }"
					data-options="url: contextPath + '/common/dict/BD_ZHLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'" />
		    	</td>
				<td width="20%" class="dialogTd" align="right">账户名称：</td>
		    	<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox" type="text" id="zhmc" name="zhmc" style="width:200px;float:left;" value="${entity.zhmc }" maxlength="100" 
		    		data-options="tipPosition:'left'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">账户号码：</td>
		    	<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox" type="text" id="zhhm" name="zhhm" style="width:200px;float:left;" value="${entity.zhhm }" maxlength="100" 
		    		data-options="required:true,tipPosition:'right'"/></td>
		    	<td width="20%" class="dialogTd" align="right">账户单位名称：</td>
		    	<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox" type="text" id="zhdwmc" name="zhdwmc" style="width:200px;float:left;" value="${entity.zhdwmc }" maxlength="50" 
		    		data-options="tipPosition:'left'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">账户注册日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="zhzcrq" id="zhzcrq" value="${entity.zhzcrq}" class="easyui-validatebox"  style="width: 200px;" 
			     	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'"/></td>
		    	<td width="20%" class="dialogTd" align="right">账户有效日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="zhyxrq" id="zhyxrq" value="${entity.zhyxrq}" class="easyui-validatebox"  style="width: 200px;" 
			     	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'zhzcrq\')}'})" data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">账户注册人：</td>
		    	<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox" type="text" id="zhzcr" name="zhzcr" style="width:200px;float:left;" value="${entity.zhzcr }" maxlength="20" 
		    		data-options="tipPosition:'right'"/></td>
		    	<td width="20%" class="dialogTd" align="right">是否实名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="sfsmdm" name="sfsmdm" style="width:200px;" value="${entity.sfsmdm }"
					data-options="url: contextPath + '/common/dict/BD_D_SFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'" />
		    	</td>
	    	</tr>
    	</table>
    </form>
</body>
<script type="text/javascript">
function doInit(paramArray){}

function beforeSubmit() {
	if ($("#pk").val() == "") {	
		$("#_method").val('');
		$("#dataForm").attr('action', contextPath + '/ryRyxnsfxxb/save');
	}
	else {
		$("#_method").val('PUT');
		$("#dataForm").attr('action', contextPath + '/ryRyxnsfxxb/' + $("#pk").val());
	}
	if ($("#zhzcrq").val() != "" && $("#zhyxrq").val() != "" && $("#zhzcrq").val() >  $("#zhyxrq").val()) {
		topMessager.alert("", "注册日期不能小于账户有效日期，请重新输入！");
		$("#zhzcrq").focus();
		return false;
	}
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}

</script>
</html>
