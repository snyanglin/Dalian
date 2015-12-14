<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="" id="queryForm" name="queryForm" method="post">
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr>
				<td width="18%" class="dialogTd" align="right">所属责任区：</td>
				<td width="82%" class="dialogTd" colspan="3">
					<input type="hidden" name="sszrqdm" id="sszrqdm">
					<input type="text" id="sszrqmc" style="width:200px;" class="easyui-validatebox"/>
					<input type="button" id="orgbutton" value="选择" class="butSelect1" onClick="window.top.public_singleSelectOrg('${userOrgCode}', '01', '', '', 'sszrqdm', 'sszrqmc', '', false, false, '', window, '', '')" />
				</td>
			</tr>
			<c:forEach items="${fieldNameArray}" var="fieldNameArray" varStatus="status">
				<c:if test="${status.index % 2 == 0}"><tr class="dialogTr"></c:if>
				<td width="18%" class="dialogTd" align="right">${fieldNameArray}：</td>
				<td width="32%" class="dialogTd"><input class="easyui-validatebox" type="text" name="ddbsjx${status.index + 1}" id="ddbsjx${status.index + 1}" style="width:200px;"/></td>						
				<c:if test="${status.index % 2 == 1}"></tr></c:if>
			</c:forEach>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript">
function doInit(paramArray) {
	var ddbsjx1 = paramArray['ddbsjx1'];
	if (ddbsjx1 != "") {
		$('#ddbsjx1').val(ddbsjx1);
		setInputReadonly('ddbsjx1', true);
	}
}

function beforeSubmit() {
}
</script>

</body>
</html>