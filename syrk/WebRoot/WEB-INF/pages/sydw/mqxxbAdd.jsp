<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@CreateDate:   [2015-6-3 下午13:15:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>民枪单位信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwownsydw/saveMq" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" id="dwid" name="dwid" value="${entity.dwid}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">仓库情况：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="ckqk" name="ckqk" style="width:200px;" value="${entity.ckqk}"  
			    			data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">安全设施：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="aqss" name="aqss" style="width:200px;" value="${entity.aqss}"  
			    			data-options="required:false,validType:['maxLength[50]'],tipPosition:'left'"/>
			    	</td>
			    </tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">审批机关：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="spjg" name="spjg" style="width:200px;" value="${entity.spjg}"  
							data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">审批人：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="spr" name="spr" style="width:200px;" value="${entity.spr}"  
							data-options="required:false,validType:['maxLength[50]'],tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">审批日期：</td>
					<td width="30%" class="dialogTd" >
						<input type="text" name="sprq" id="sprq" class="easyui-validatebox" style="width: 200px;" value="${entity.sprq}"  
							data-options="required:false,validType:['date[\'yyyy-MM-dd \']']" 
							data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
							onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
					</td>
					<td width="20%" class="dialogTd" align="right">持枪类型：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="cqlx" name="cqlx" style="width:200px;" value="${entity.cqlx}"
							data-options="required:false,tipPosition:'right'"/>
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