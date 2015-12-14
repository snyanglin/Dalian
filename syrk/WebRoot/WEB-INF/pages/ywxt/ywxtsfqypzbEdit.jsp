<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>ywxtsfqypz/save" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="id" value="${entity.id}"/>
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">描述：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz" class="easyui-validatebox" style="width: 613px; height:48px;"
					data-options="validType:['maxLength[250]'],invalidMessage:'备注不能超过250个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea></td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript">
function doInit(paramArray) {
}

function beforeSubmit() {
}

function afterSubmit(submitData) {
}
</script>

</body>
</html>

