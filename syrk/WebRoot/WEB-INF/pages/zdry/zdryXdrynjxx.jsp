<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>吸毒人员尿检信息</title>
	<style type="text/css">
		.item_title{
			width:100px;
		}
		
		.item_content{
			width:200px;
		}
		
		.text_input{
			width:535px;
		}
	</style>
	
	<script type="text/javascript"> 

	function doInit(paramArray) {
	
		//if ($('#pk').val() != "") {
		//	formReadonly('dataForm', true);
		//}
	}
	
	function beforeSubmit() {
		if ($("#pk").val() == "") {
			$("#_method").val('');
			$("#dataForm").attr('action', contextPath + '/zdryXdrynjxx/save');
		}
		else {
			$("#_method").val('PUT');
			$("#dataForm").attr('action', contextPath + '/zdryXdrynjxx/' + $("#pk").val());
		}
	}
	
	function afterSubmit(arr) {
		if (arr["saveID"]){
			$("#pk").val(arr["saveID"]);
		}
	}

</script>
	
</head>

<body>

	<form action="" id="dataForm" name="dataForm" method="post">
	    
		<input type="hidden" id="_method" name="_method" value=""/>
		<input type='hidden' name='id' id="pk" value="${entity.id}" />
		<input type="hidden" id="zdryid" name="zdryid" value="${entity.zdryid}" />
	   
	  	<table border="0" cellpadding="0" cellspacing="10" align="left">
	   		<tr class="dialogTr">
	    		<td class="dialogTd item_title" align="right">尿检日期：</td>
		    	<td class="dialogTd item_content">
		    		<input type="text" name="nj_rq" id="nj_rq" class="easyui-validatebox" style="width: 200px;" value="${entity.nj_rq}"
				     		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'new Date()'})" 
				     		data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left',required:true"/>
		    	</td>
		    	<td class="dialogTd item_title" align="right">尿检结果：</td>
		    	<td class="dialogTd item_content">
		    		<input name="njjgdm" id="njjgdm" value="${entity.njjgdm}" class="easyui-combobox" style="width:200px;" 
						data-options="url: contextPath + '/common/dict/JD_D_NJJGDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left',required:true"/>
		    	</td>
	   		</tr>
			<tr class="dialogTr">
				<td class="dialogTd item_title" align="right">签到日期：</td>
		    	<td class="dialogTd item_content" colspan="3">
		    		<input type="text" name="qd_rq" id="qd_rq" class="easyui-validatebox" style="width: 200px;" value="${entity.qd_rq}"
				     		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'new Date()'})" 
				     		data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"/>
		    	</td>
			</tr>
	    </table>
	</form>
    
</body>

</html>
