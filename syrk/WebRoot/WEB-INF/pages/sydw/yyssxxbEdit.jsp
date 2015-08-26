<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!--  
	@updateAuthor: [star]
	@updateDate:   [2015-6-4 上午8:51:54]
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>营业设备</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>yyssxxb/save" id="dataForm" name="dataForm" method="post">   	
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
 	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<input type="hidden" name="id" id="pk" value="${entity.id}" />
		    <tr class="dialogTr">
			   <td width="20%" class="dialogTd" align="right">设备名称：</td>
			   <td width="80%" class="dialogTd" colspan="3">
			   		<input class="easyui-validatebox "  type="text" id="sbmc" name="sbmc" data-options="required:true,charSet:'halfUpper'"  maxlength="30" style="width:628px;"  value="${entity.sbmc}" />
			   </td>
			</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">设备用途：</td>
				<td width="80%" class="dialogTd" colspan="3">
					<textarea class="easyui-validatebox" id="sbyt" name="sbyt" style="width: 628px; height:48px;"
					data-options="validType:['maxLength[500]'],invalidMessage:'设备用途不能超过500个汉字，请重新输入！',tipPosition:'left',required:false,charSet:'halfUpper'">${entity.sbyt}</textarea>
				</td>
	    	</tr>
			<tr>
				<td width="20%" class="dialogTd" align="right">设备状态：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class='easyui-validatebox' maxlength="20" type='text' name='sbzt' id="sbztdm" value="${entity.sbzt}" style="width:200px;"
		    	    data-options="required:false,valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
		    	</td>
			   <td width="20%" class="dialogTd" align="right">设备数量：</td>
			   <td width="30%" class="dialogTd">
			   		<input class="easyui-validatebox "  type="text" id="sbsl" name="sbsl" data-options="validType:['naturalNumber'],required:false,tipPosition:'left',charSet:'halfUpper'" maxlength="8" style="width:200px;"  value="${entity.sbsl}" />
			   </td>
		  	</tr>
		   	<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right"> 设备购买日期：</td>
				<td width="30%" class="dialogTd">
					<input class='easyui-validatebox ' type='text' name='sbgm_rq'  id="sbgm_rq" style="width:200px;" value="${entity.sbgm_rq}" 
					data-options="required:false,validType:['date[\'yyyy-MM-dd\']']" 
					onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
				</td>
			</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注：</td>
				<td width="80%" class="dialogTd" colspan="3">
					<textarea class="easyui-validatebox" id="bz" name="bz" style="width: 628px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left',required:false,charSet:'halfUpper'">${entity.bz}</textarea>
				</td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
function doInit(paramArray) {
	
}
function beforeSubmit() {
 
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}

</script>