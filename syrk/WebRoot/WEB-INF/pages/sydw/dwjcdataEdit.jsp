<!--  
	@Author: [yuguangli@founder.com]
	@CreateDate:   [2015-6-6 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwjctemp/updateDwjcdata" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="id" value="${entity.id}"/>
	    <div data-options="region:'center', split:true" style="border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">检查项内容：</td>
			    	<td width="80%" class="dialogTd" colspan="3">
			    		<textarea class="easyui-validatebox" type="text" name="name" style="width: 503px;height: 40px;" maxlength="200" data-options="required:true">${entity.name}</textarea>
			    	</td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">默认值：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="def" name="def" style="width:150px;" value="${entity.def}"
							data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
					</td>
			    	<td width="20%" class="dialogTd" align="right"></td>
			    	<td width="30%" class="dialogTd"></td>
		    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >
function doInit(paramArray) {
}

function beforeSubmit() {
}

function afterSubmit(submitData) {
}
</script>

</body>
</html>