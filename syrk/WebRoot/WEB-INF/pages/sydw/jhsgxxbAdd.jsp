<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@updateDate:   [2015-6-3 下午13:15:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>旧货收购信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>jhsgxxb/save" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">单位名称：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox inputreadonly" type="text" id="dwmc" style="width:600px;" readonly="readonly" />
			    	</td>
			    </tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">申请报告号：</td>
					<td width="80%" class="dialogTd">
						<input  type='text' id='sqbgh' name='sqbgh' class="easyui-validatebox" style="width:600px;"
						maxlength="50"  data-options="required:true,tipPosition:'left'" value="${entity.sqbgh}" /></td>
				</tr>
				 <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">资信证明：</td>
					<td width="80%" class="dialogTd">
						<input  type='text' id='zxzm' name='zxzm' class="easyui-validatebox" style="width:600px;"
						maxlength="50" data-options="required:false,tipPosition:'left'" value="${entity.zxzm}" /></td>
				</tr>
				 <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">经营场所使用证明：</td>
					<td width="80%" class="dialogTd">
						<input  type='text' id='jycssyzm' name='jycssyzm'  class="easyui-validatebox"style="width:600px;"
						maxlength="100"	 data-options="required:false,tipPosition:'left'" value="${entity.jycssyzm}" /></td>
				</tr>
		  	    <tr class="dialogTr">
		    	    <td width="16%" class="dialogTd" align="right">备注：</td>
		    	    <td width="80%" class="dialogTd" colspan="5">
		    	    	<textarea id="bz" name="bz" class="easyui-validatebox" rows="2" style="width:627px; height:48px;"
						data-options="validType:['maxLength[500]'],invalidMessage:'备注不能超过500个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
				</td>
   	       </tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
function doInit(paramArray) {
	document.getElementById("dwmc").value = paramArray["dwmc"];
}
function beforeSubmit() {
}

function afterSubmit(arr) {
	window.parent.location.reload();
}
</script>
