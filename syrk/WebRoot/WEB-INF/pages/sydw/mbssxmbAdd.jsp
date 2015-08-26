<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@CreateDate:   [2015-6-3 下午13:15:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>民爆-实施项目业绩</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwownsydw/saveMbxmyj" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" id="dwid" name="dwid" value="${entity.dwid}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">项目级别：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="xmjb" name="xmjb" 
			    			data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'" value="${entity.xmjb}" maxlength="50" style="width:200px;"/>
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">项目名称：</td>
			    	<td width="30%" class="dialogTd">
			    		<input  class="easyui-validatebox" type="text" id="xmmc" name="xmmc"  
			    			data-options="required:false,validType:['maxLength[50]'],tipPosition:'left'" value="${entity.xmmc}" maxlength="50" style="width: 200px;"/>
			    	</td>
			    </tr>
			    
				<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">爆破施工日期：</td>
			    	<td width="30%" class="dialogTd" >
			    		<input class="easyui-validatebox" type="text" name="bpsgrq" id="bpsgrq"
			    			data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" 
		    				onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"
		    				style="width:200px" value="${entity.bpsgrq}"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">第一设计人：</td>
			    	<td width="30%" class="dialogTd" >
			    		<input class="easyui-validatebox" type="text"  name="dysjr" id="dysjr" maxlength="50"
							data-options="required:false,validType:['maxLength[50]'],tipPosition:'left'"
			    	 		style="width:200px" value="${entity.dysjr}"/>
			    	 </td>		   
			    </tr>	
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
var _p ;
function doInit(paramArray) {
	_p = paramArray["_p"];
}

function beforeSubmit(){}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	parent.$("#ssxmyj_datagrid").datagrid("reload");
}
</script>