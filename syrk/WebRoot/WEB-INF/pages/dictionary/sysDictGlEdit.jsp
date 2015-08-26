<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>sysDictGl/save" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="id" value="${entity.id}"/>
	    <div data-options="region:'center', split:true" style="border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="816" align="center">
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">字典英文名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zdywm" name="zdywm" value="${entity.zdywm}"style="width:200px;" maxlength="20" data-options="required:true,validType:['variable'],charSet:'halfUpper',invalidMessage:'字典英文名必须为合法的变量名称，请重新输入！'"/></td>
		    	<td width="20%" class="dialogTd" align="right">字典中文名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zdzwm" name="zdzwm" value="${entity.zdzwm}" style="width:200px;" maxlength="20" data-options="required:true,validType:['noMark'],invalidMessage:'字典中文名不能为空且不能包含单引号、双引号、分号，请重新输入！',tipPosition:'left'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">生成类别：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="zdsclb" name="zdsclb" value="${entity.zdsclb}" style="width:200px;"
					data-options="required:true,url: contextPath + '/common/dict/D_SYS_ZDSCLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:zdsclb_onChange"/></td>
		    	<td width="20%" class="dialogTd" align="right">使用类别：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="zdsylb" name="zdsylb" value="${entity.zdsylb}" style="width:200px;"
					data-options="required:true,url: contextPath + '/common/dict/D_SYS_ZDSYLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">业务类别：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="zdywlb" name="zdywlb" value="${entity.zdywlb}" style="width:200px;"
					data-options="required:true,url: contextPath + '/common/dict/D_SYS_ZDYWLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/></td>
		    	<td width="20%" class="dialogTd" align="right"></td>
		    	<td width="30%" class="dialogTd"></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">引用标准：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" name="zdyybz" value="${entity.zdyybz}" style="width: 603px;" maxlength="40"/></td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >
function doInit(paramArray) {
	setInputReadonly('zdywm', true);
}

function beforeSubmit() {
}

function afterSubmit(submitData) {
}

function zdsclb_onChange(newValue, oldValue) {
	var zdsclbValue = $("#zdsclb").combobox("getValue");
	if (zdsclbValue == "1" || zdsclbValue == "2") {
		$("#zdsylb").combobox("setValue", zdsclbValue);
	}
}
</script>

</body>
</html>