<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@CreateDate:   [2015-6-2 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>游戏游艺场所信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwownsydw/saveYxyycs" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" id="dwid" name="dwid" value="${entity.dwid}" />
	    <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">游戏游艺机机型：</td>
			    	<td width="80%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="yxyyjlx" name="yxyyjlx" style="width:600px;" value="${entity.yxyyjlx}" 
			    			data-options="required:false,validType:['maxLength[50]'],invalidMessage:'游戏游艺机机型不能超过50个汉字，请重新输入！',tipPosition:'left'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">游戏游艺机数：</td>
			    	<td width="80%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="yxyyjs" name="yxyyjs" style="width:600px;" value="${entity.yxyyjs}" 
			    			data-options="required:false,validType:['naturalNumberRange[1,99999]'],tipPosition:'left'"/>
			    	</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">出口数量：</td>
					<td width="80%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="cksl" name="cksl" style="width:600px;" value="${entity.cksl}"
							data-options="required:false,validType:['naturalNumberRange[1,9999]'],tipPosition:'left'"/>
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
	window.parent.location.reload();
}
</script>