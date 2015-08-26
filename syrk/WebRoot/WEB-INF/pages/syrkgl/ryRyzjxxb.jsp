<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>人员证件信息</title>
</head>
<body>
	<form action="" id="dataForm" name="dataForm" method="post" >
	
		<input type="hidden" id="_method" name="_method" value=""/>
		<input type='hidden' name='id' id="pk" value="${entity.id}" />
		<input type="hidden" id="ryid" name="ryid" value="${entity.ryid}"/>
		
		<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">证件种类：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="cyzjdm" name="cyzjdm" style="width:200px;" value="${entity.cyzjdm }"
					data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:zjhmCheck" />
		    	</td>
				<td width="20%" class="dialogTd" align="right">证件号码：</td>
		    	<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox" type="text" id="zjhm" name="zjhm" style="width:200px;float:left;" value="${entity.zjhm }" maxlength="30" 
		    		data-options="required:true,tipPosition:'left'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">证件取得时间：</td>
			    <td width="30%" class="dialogTd"><input type="text" name="zjqdsj" id="zjqdsj" value="${entity.zjqdsj}" class="easyui-validatebox"  style="width: 200px;" 
			     	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'"/></td>
			   	<td width="20%" class="dialogTd" align="right">证件有效期：</td>
			    <td width="30%" class="dialogTd"><input type="text" name="zjyxq" id="zjyxq" value="${entity.zjyxq}" class="easyui-validatebox"  style="width: 200px;" 
			     	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'"/></td>
	    	</tr>
    	</table>
    </form>
</body>
<script type="text/javascript">
function doInit(paramArray){
	if($("#pk").val()!=""){
		setInputReadonly("cyzjdm",true);
		setInputReadonly("zjhm",true);

	}
}

function beforeSubmit() {
	if ($("#pk").val() == "") {
		var _count;
		$.ajax({
			type:"GET",
			url:"<%= basePath%>ryRyzjxxb/queryCount",
			dataType:"json",
			data:"cyzjdm="+$("#cyzjdm").val()+"&zjhm="+$("#zjhm").val(),
			async:false,
			success:function(data){
				if(data && data != null && data != undefined && data == 1){
					$.messager.alert('确认对话框', '该证件已存在！请重新输入', 'warning', function(){
						$("#zjhm").focus();
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
		$("#dataForm").attr('action', contextPath + '/ryRyzjxxb/save');
	}
	else {
		var _count;
		$.ajax({
			type:"GET",
			url:"<%= basePath%>ryRyzjxxb/queryCount",
			dataType:"json",
			data:"id="+$("#pk").val()+"&cyzjdm="+$("#cyzjdm").val()+"&zjhm="+$("#zjhm").val(),
			async:false,
			success:function(data){
				if(data && data != null && data != undefined && data == 1){
					$.messager.alert('确认对话框', '该证件已存在！请重新输入', 'warning', function(){
						$("#zjhm").focus();
					});
					_count = 1;
				}
			},
			complete:function(){}
		});
		if(_count == 1){
			return false;
		}
		$("#_method").val('PUT');
		$("#dataForm").attr('action', contextPath + '/ryRyzjxxb/' + $("#pk").val());
	}
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}

//验证证件号码
function zjhmCheck(newValue, oldValue){
	if(newValue==""){
		$("#zjhm").validatebox({validType:null});
		return;
	}
	if (!newValue) {
		return;
	}
	
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue=="112" || newValue == "335"){ 
		$("#zjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#zjhm").validatebox({validType:['maxLength[30]']});
	}
}
</script>
</html>
