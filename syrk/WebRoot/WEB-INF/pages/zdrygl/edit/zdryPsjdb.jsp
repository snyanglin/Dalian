<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>评审鉴定</title>
	</head>

<body>
	<form action="" id="dataForm" name="dataForm" method="post" >
	
		<input type="hidden" id="_method" name="_method" value=""/>
		<input type='hidden' name='id' id="pk" value="${entity.id}" />
		<input type="hidden" id="zdryid" name="zdryid" value="${entity.zdryid}"/>
		
		<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="xm" name="xm" style="width:200px;" readonly="readonly"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="sfzh" name="sfzh" style="width:200px;" readonly="readonly"/>
		    	</td>
	    	</tr>
		    <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">评议时间：</td>
			    <td width="30%" class="dialogTd"><input type="text" name="py_sj" id="py_sj" value="${entity.py_sj}" class="easyui-validatebox"  style="width: 200px;" 
			     	onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'right'"/></td>
			   	<td width="20%" class="dialogTd" align="right"></td>
			    <td width="30%" class="dialogTd"></td>
	    	</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">评议地点：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input name="pydd" class="easyui-validatebox" style="width: 618px;" value="${entity.pydd}" maxlength="100"
					data-options="required:true,tipPosition:'left'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">参加人员：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="cjry" class="easyui-validatebox" style="width: 618px; height:48px;"
					data-options="validType:['maxLength[300]'],invalidMessage:'参加人员不能超过300个汉字，请重新输入！',tipPosition:'left',required:true">${entity.cjry}</textarea></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">内容纪要：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="nrjy" class="easyui-validatebox" style="width: 618px; height:96px;"
					data-options="validType:['maxLength[2000]'],invalidMessage:'内容纪要不能超过2000个汉字，请重新输入！',tipPosition:'left',required:true">${entity.nrjy}</textarea></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz" class="easyui-validatebox" style="width: 618px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea></td>
	    	</tr>
    	</table>
    	
    </form>
</body>

<script type="text/javascript">


function doInit(paramArray){
	$('#sfzh').val(paramArray["sfzh"]);
	$('#xm').val(paramArray["xm"]);
}

function beforeSubmit() {
	if ($("#pk").val() == "") {
		$("#_method").val('');
		$("#dataForm").attr('action', contextPath + '/zdryPsjdb/save');
	}
	else {
		$("#_method").val('PUT');
		$("#dataForm").attr('action', contextPath + '/zdryPsjdb/' + $("#pk").val());
	}
}

function afterSubmit(arr) {
	parent.location.reload();
}
</script>
</html>
