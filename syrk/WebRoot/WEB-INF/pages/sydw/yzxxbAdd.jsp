<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@UpdateDate:   [2015-6-2 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>印章业信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwownsydw/saveYz" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" id="dwid" name="dwid" value="${entity.dwid}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">治安主管单位：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="zazgdw" name="zazgdw" style="width:200px;" value="${entity.zazgdw}" 
			    			data-options="required:false,validType:['maxLength[50]'],invalidMessage:'治安主管单位不能超过50个汉字，请重新输入！',tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">特行备案编号：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="tybabh" name="tybabh" style="width:200px;" value="${entity.tybabh}" maxlength="1"
			    			data-options="required:false,validType:['maxLength[50]'],invalidMessage:'特行备案编号不能超过50个汉字，请重新输入！',tipPosition:'left'"/>
			    	</td>
			    </tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">特行备案机构：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="tebajg" name="tebajg" style="width:200px;" value="${entity.tebajg}"
							data-options="required:false,validType:['maxLength[50]'],invalidMessage:'特行备案机构不能超过50个汉字，请重新输入！',tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">行业许可证号：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="hyxkz" name="hyxkz" style="width:200px;" value="${entity.hyxkz}"
							data-options="required:false,validType:['maxLength[50]'],invalidMessage:'行业许可证号不能超过50个汉字，请重新输入！',tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">员工从业人数 ：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="ygcyrs" name="ygcyrs" style="width:200px;" value="${entity.ygcyrs}"
							data-options="required:false,validType:['naturalNumberRange[1,9999999]'],tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">企业经营状况：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="qyjyzk" name="qyjyzk" style="width:200px;" value="${entity.qyjyzk}"
							data-options="required:false,validType:['maxLength[50]'],invalidMessage:'企业经营状况不能超过50个汉字，请重新输入！',tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">备注：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="bz" name="bz" style="width: 627px; height:48px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',required:false,tipPosition:'left',required:false">${entity.bz}</textarea>
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

function beforeSubmit(){}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	window.parent.location.reload();
}
</script>