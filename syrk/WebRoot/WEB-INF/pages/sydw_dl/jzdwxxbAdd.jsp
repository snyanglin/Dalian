<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>旅店信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>jzdwxxb_dl/saveJzdwxxb" id="dataForm" name="dataForm" method="post">
    	
    	<input type="hidden" id="dwid" name="dwid" value="${entity.dwid}" />
    
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<input type="hidden" id="pk" name="id" value="${entity.id}" />
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">数据录入人员姓名：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="sjlrryxm" name="sjlrryxm" style="width:200px;" value="${entity.sjlrryxm}" 
		    		data-options="required:false,validType:['maxLength[10]'],invalidMessage:'数据录入人员姓名不能超过10个汉字，请重新输入！',tipPosition:'right'"/>
		    	</td>
				<td width="20%" class="dialogTd" align="right">数据录入人员电话：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="sjlrrydh" name="sjlrrydh" style="width:200px;" value="${entity.sjlrrydh}" 
		    		data-options="validType:['phone'],charSet:'half',tipPosition:'left'"/>
		    	</td>
		    </tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">业务量：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="ywl" name="ywl" style="width:200px;" value="${entity.ywl}"
					data-options="required:false,validType:['naturalNumberRange[1,1000000000000000]'],tipPosition:'right'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">业务量单位：</td>
				<td width="30%" class="dialogTd" >
					<input class="easyui-combobox" type="text" id="ywldw" name="ywldw" style="width:200px;" value="${entity.ywldw}"
					data-options="url:contextPath+'/common/dict/BD_D_JZSYDWYWLDW.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
				</td>
			</tr>

			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">派送范围：</td>
				<td width="80%" class="dialogTd" colspan="3">
					<textarea class="easyui-validatebox" id="psfw" name="psfw" style="width: 627px; height:48px;"
					data-options="validType:['maxLength[30]'],invalidMessage:'派送范围不能超过30个汉字，请重新输入！',required:false,tipPosition:'left',required:false">${entity.psfw}</textarea>
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