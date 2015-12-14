<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>人员别名绰号信息</title>
</head>
<body>
	<form action="" id="dataForm" name="dataForm" method="post" >
	
		<input type="hidden" id="_method" name="_method" value=""/>
		<input type='hidden' name='id' id="pk" value="${entity.id}" />
		<input type="hidden" id="ryid" name="ryid" value="${entity.ryid}"/>
		
		<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">别名绰号类型：</td>
				<td width="30%" class="dialogTd" >
					<input class="easyui-combobox" type="text" id="bmchlxdm" name="bmchlxdm" style="width:200px;" value="${entity.bmchlxdm}"
					data-options="url:contextPath+'/common/dict/BD_D_BMCHLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
				</td>
	    		<td width="20%" class="dialogTd" align="right">别名绰号：</td>
			    <td width="30%" class="dialogTd" >
					<input type="text" id="bmch" name="bmch" class="easyui-validatebox" style="width:200px;" value="${entity.bmch}" maxlength="50"
					data-options="required:true,tipPosition:'left'"/>
				</td>
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
			url:"<%= basePath%>ryRybmchxxb/queryCount",
			dataType:"json",
			data:"ryid="+$("#ryid").val()+"&bmchlxdm="+$("#bmchlxdm").val()+"&bmch="+$("#bmch").val(),
			async:false,
			success:function(data){
				if(data && data != null && data != undefined && data == 1){
					$.messager.alert('确认对话框', '该名称已存在！请重新输入', 'warning', function(){
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
		$("#dataForm").attr('action', contextPath + '/ryRybmchxxb/save');
	}
	else {
		$("#_method").val('PUT');
		$("#dataForm").attr('action', contextPath + '/ryRybmchxxb/' + $("#pk").val());
	}
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}
</script>
</html>
