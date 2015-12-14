<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>人员联系方式信息</title>
</head>
<body>
	<form action="" id="dataForm" name="dataForm" method="post" >
	
		<input type="hidden" id="_method" name="_method" value=""/>
		<input type='hidden' name='id' id="pk" value="${entity.id}" />
		<input type="hidden" id="ryid" name="ryid" value="${entity.ryid}"/>
		
		<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">联系方式类型：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="lxfslxdm" name="lxfslxdm" style="width:200px;" value="${entity.lxfslxdm }"
					data-options="url: contextPath + '/common/dict/BD_D_LXFSLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',
					onSelect:function(record){
						if(record.id==1){
							$('#lxfs').validatebox({validType:['mobile']});
						} else if(record.id==2){
							$('#lxfs').validatebox({validType:['phone']});
						} else if(record.id==3){
							$('#lxfs').validatebox({validType:['numeric[\'i\']']});
						}else {
							$('#lxfs').validatebox({validType:['maxLength[100]']});
						}
					}" />
		    	</td>
				<td width="20%" class="dialogTd" align="right">联系方式：</td>
		    	<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox" type="text" id="lxfs" name="lxfs" style="width:200px;float:left;" value="${entity.lxfs }" maxlength="100" 
		    		data-options="required:true,tipPosition:'left'" /></td>
	    	</tr>
    	</table>
    </form>
</body>
<script type="text/javascript">
function doInit(paramArray){
	var lxfslxdm =$("#lxfslxdm").val();
	if(lxfslxdm==1){
		$('#lxfs').validatebox({validType:['mobile']});
	} else if(lxfslxdm==2){
		$('#lxfs').validatebox({validType:['phone']});
	} else if(lxfslxdm==3){
		$('#lxfs').validatebox({validType:['numeric[\'i\']']});
	}else {
		$('#lxfs').validatebox({validType:['maxLength[100]']});
	}
	
}

function beforeSubmit() {
	if ($("#pk").val() == "") {
		var _count;
		$.ajax({
			type:"GET",
			url:"<%= basePath%>ryRylxfsxxb/queryCount",
			dataType:"json",
			data:"ryid="+$("#ryid").val()+"&lxfslxdm="+$("#lxfslxdm").val()+"&lxfs="+$("#lxfs").val(),
			async:false,
			success:function(data){
				if(data && data != null && data != undefined && data == 1){
					$.messager.alert('确认对话框', '该联系方式已存在！请重新输入', 'warning', function(){
						$("#zhhm").focus();
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
		$("#dataForm").attr('action', contextPath + '/ryRylxfsxxb/save');
	}
	else {
		$("#_method").val('PUT');
		$("#dataForm").attr('action', contextPath + '/ryRylxfsxxb/' + $("#pk").val());
	}
	
	//验证与其他人员联系方式重复
	var _xm;
	$.ajax({
		type: "POST",
		url: contextPath + "/ryRylxfsxxb/check",
		dataType: "json",
		data: "lxfs="+$("#lxfs").val()+"&ryid="+$("#ryid").val(),
		async:false,
		success: function(data){
			if (data && data.xm) {
				if (data.xm != ""||data.xm!=null) {
					topMessagerAlert('数据质量提醒', '电话号码：'+data.lxfs+'<br><br>已于'+data.djsj+'在办理业务中<br><br>登记为【'+data.xm+'】的联系电话，<br><br>与当前录入信息不符');
					_xm = data.xm;
				}
			}
		}
	});
	if(_xm != "" && _xm != null){
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
