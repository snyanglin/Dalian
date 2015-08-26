<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>出租检查信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>syfw/saveCzfwjcxxb" id="dataForm" name="dataForm" enctype="multipart/form-data" method="post">
    	
    	<input type="hidden" id="czfwid" name="czfwid" value="${entity.czfwid}" />
    	
    
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<input type="hidden" id="id" name="id" value="${entity.id}" />
				
				
				
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">房屋地址：</td>
					<td width="30%" class="dialogTd">
						<input class="inputreadonly" style="width:300px;"  type="text" id="fwdz" value="" />
					</td>
					<td width="20%" class="dialogTd" align="right">检查日期：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="jcrq" name="jcrq" style="width:200px;" value="${entity.jcrq}" maxlength="19"
						onclick="WdatePicker({startDate:'%y-%M-%d',skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"/>
					</td>
				</tr>
				
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">简要情况：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="jcqk_jyqk" name="jcqk_jyqk" style="width:690px; height:48px;"
						data-options="required:true,validType:['maxLength[1000]'],invalidMessage:'简要情况不能超过1000个汉字，请重新输入！',tipPosition:'right'">${entity.jcqk_jyqk}</textarea>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">备注：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="bz" name="bz" style="width:690px; height:48px;"
						data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'right'">${entity.bz}</textarea>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">检查单位：</td>
					<td width="30%" class="dialogTd">
					<input type="hidden" id="jcdw_gajgjgdm" name="jcdw_gajgjgdm" value="${entity.jcdw_gajgjgdm}">	
					<input class="easyui-validatebox inputreadonly" type="text" id="jcdw_gajgmc" name="jcdw_gajgmc" style="width:150px;" value="${entity.jcdw_gajgmc}" maxlength="20" data-options="tipPosition:'left'" readonly="readonly"/>
	    			<input type="button" id="orgbutton1"  value="选择" onClick="public_singleSelectOrg('', '', '', '', 'jcdw_gajgjgdm', 'jcdw_gajgmc', '', false, false, '', window, '', '');" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 22px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
					</td>
					<td width="20%" class="dialogTd" align="right">检查人：</td>
					<td width="30%" class="dialogTd">
					<input type="hidden" id="jcr_id" name="jcr_id" value="${entity.jcr_id}">	
					<input class="easyui-validatebox inputreadonly" type="text" id="jcr_xm" name="jcr_xm" style="width:150px;" value="${entity.jcr_xm}" maxlength="20" data-options="tipPosition:'left'" readonly="readonly"/>
	    			<input type="button" id="orgbutton1" value="选择" onClick="public_singleSelectOrgUser('', '', '', '', '', '', 'jcr_id', 'jcr_xm', '', '', '', '', false, '', window, '', '');" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 22px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
					</td>
				</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >


function doInit(paramArray) {
	$("#fwdz").val(paramArray["dz_fwdzxz"]);
}
function beforeSubmit(){
	
}

function afterSubmit(arr) {
	if (arr["saveID"]) {
		$("#id").val(arr["saveID"]);
	}
	
}
</script>