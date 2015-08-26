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
		    	<td width="30%" class="dialogTd" align="right">人员帐号：</td>
		    	<td width="70%" class="dialogTd"><input type="text" name="userid" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"  style="width:200px;" />（模糊查询）</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="30%" class="dialogTd" align="right">人员姓名：</td>
		    	<td width="70%" class="dialogTd"><input type="text" name="username" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'"  style="width:200px;" />（模糊查询）</td>
	    	</tr>	
	    	<tr class="dialogTr">
		    	<td width="30%" class="dialogTd" align="right">所在部门：</td>
		    	<input type="hidden" name="orgcode" id="orgcode" >
                <input type="hidden" name="orgid" id="orgid" />
		    	<td width="70%" class="dialogTd"><input class="easyui-validatebox" type="text" name="orgname" id="orgname" style="width:200px;"/>
 		    	<input type="button" id="orgbutton" value="选 择" class="dictSearchButton" onClick="window.parent.public_singleSelectOrg('${userManageOrgCode}', '', '', '', 'orgcode', 'orgname', 'orgid', false, false, '', window, '', '')" />
		    	</td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>
<script type="text/javascript">
function doInit(paramArray) {
	setInputReadonly('orgname', true);
}

function beforeSubmit() {
}
</script>

</body>
</html>
