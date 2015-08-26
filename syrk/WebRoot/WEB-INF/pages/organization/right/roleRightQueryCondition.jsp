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
	    <div data-options="region:'center',split:true" style="padding: 6px; border-width: 0px;">
	    	<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	<tr class="dialogTr">
		    	<td width="30%" class="dialogTd" align="right">角色名称：</td>
		    	<td width="70%" class="dialogTd"><input class="easyui-validatebox" type="text" name="rolename" maxlength="20" style="width:200px;"/>（模糊查询）</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="30%" class="dialogTd" align="right">角色描述：</td>
		    	<td width="70%" class="dialogTd"><input class="easyui-validatebox" type="text" name="roledesc" maxlength="200" style="width:200px;"/>（模糊查询）</td>
	    	</tr>
	    	<tr class="dialogTr" id="trManagerorg">
		    	<td width="30%" class="dialogTd" align="right">角色所属部门：</td>
		    	<input type="hidden" name="managerorgcode" id="managerorgcode" >
                <input type="hidden" name="managerorgid" id="managerorgid" />
		    	<td width="70%" class="dialogTd"><input class="easyui-validatebox" type="text" name="managerorgname" id="managerorgname" style="width:200px;"/>
 		    	<input type="button" id="orgbutton" value="选择" class="butSelect1" onClick="window.parent.public_singleSelectOrg('', '', '', '', 'managerorgcode', 'managerorgname', 'managerorgid', false, false, '', window, '', '')" />
		    	</td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>
<script type="text/javascript">
function doInit(paramArray) {
	if ("${userManageOrgId}" == "0") {
		$('#trManagerorg').hide();
	}
	else {
		setInputReadonly('managerorgname', true);
	}
}

function beforeSubmit() {
}
</script>

</body>
</html>
