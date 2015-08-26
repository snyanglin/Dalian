<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>人员体表特殊标记信息</title>
</head>
<body>
	<form action="" id="dataForm" name="dataForm" method="post" >
	
		<input type="hidden" id="_method" name="_method" value=""/>
		<input type='hidden' name='id' id="pk" value="${entity.id}" />
		<input type="hidden" id="ryid" name="ryid" value="${entity.ryid}"/>
		
		<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
		    <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">体表标记_人体部位：</td>
				<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="tbbj_rtbwdm" name="tbbj_rtbwdm" style="width:200px;"  value="${entity.tbbj_rtbwdm }"
						data-options="url: contextPath + '/common/dict/XZ_D_RTBWMCDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'" />
			    </td>
				<td width="20%" class="dialogTd" align="right">体表标记_方位：</td>
				<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="tbbjfwdm" name="tbbjfwdm" style="width:200px;" value="${entity.tbbjfwdm}"
					data-options="url: contextPath + '/common/dict/BD_D_TBBJFWDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">体表标记_数量：</td>
				<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="tbbj_sldm" name="tbbj_sldm" style="width:200px;" value="${entity.tbbj_sldm}"
					data-options="url: contextPath + '/common/dict/BD_D_TBBJSLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">体表标记：</td>
				<td width="30%" class="dialogTd"><input type="text" name="tbbjdm" id="tbbjdm" value="${entity.tbbjdm}" class="easyui-combotree" style="width:200px;" 
	    			data-options="url: contextPath + '/common/dict/BD_D_TBBJDM.js',onlyLeaf:true,dataFilter:'',multiple:false,required:false,panelWidth:200,method:'get',
	    			editable:true,lines:true,tipPosition:'right'">
				</td>
			</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">体表特殊标记描述：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea id="tbtsbjms" name="tbtsbjms" class="easyui-validatebox" style="width: 630px; height:48px;"
					data-options="required:true,validType:['maxLength[200]'],invalidMessage:'体表特殊标记描述不能超过200个汉字，请重新输入！',tipPosition:'left'">${entity.tbtsbjms}</textarea></td>
	    	</tr>
    	</table>
    </form>
</body>
<script type="text/javascript">
function doInit(paramArray){}

function beforeSubmit() {
	if ($("#pk").val() == "") {
		var _count;
		$.ajax({
			type:"GET",
			url:"<%= basePath%>ryRytbtsbjxxb/queryCount",
			dataType:"json",
			data:"ryid="+$("#ryid").val()+"&bmchlxdm="+$("#bmchlxdm").val()+"&bmch="+$("#bmch").val(),
			async:false,
			success:function(data){
				if(data && data != null && data != undefined && data == 1){
					$.messager.alert('确认对话框', '该体表特殊标记已存在！请重新输入', 'warning', function(){
						$("#bmch").focus();
					});
					_count = 1;
				}
			},
			complete:function(){}
		});
		if(_count == 1){
			return false;
		}
		$("#_method").val('');
		$("#dataForm").attr('action', contextPath + '/ryRytbtsbjxxb/save');
	}
	else {
		$("#_method").val('PUT');
		$("#dataForm").attr('action', contextPath + '/ryRytbtsbjxxb/' + $("#pk").val());
	}
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}
</script>
</html>
