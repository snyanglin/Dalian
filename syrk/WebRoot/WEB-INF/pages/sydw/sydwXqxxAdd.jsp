<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>小区信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwxqjbxxb/save" id="dataForm" name="dataForm" method="post">
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="14" width="100%" align="center">
				<input type="hidden" id="id" name="id" value="${entity.id}" />
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">小区名称：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="xqmc" name="xqmc" style="width:200px;" value="${entity.xqmc}" maxlength="20" 
			    		data-options="required:true,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">小区负责人：</td>
			   		<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="xqfzr" name="xqfzr" style="width:200px;" value="${entity.xqfzr}" maxlength="20" 
			    		data-options="required:true,tipPosition:'right'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">物业名称：</td>
			   		<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="wymc" name="wymc" style="width:200px;" value="${entity.wymc}" maxlength="20" 
			    		data-options="required:true,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">物业联系电话：</td>
					<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="wylxdh" name="wylxdh" style="width:200px;" value="${entity.wylxdh}" maxlength="20" 
			    		data-options="validType:['phone'],required:false,tipPosition:'right'" />
			    	</td>
			    </tr>
	    	</table>
	    </div>
    </form>
</div>
</html>