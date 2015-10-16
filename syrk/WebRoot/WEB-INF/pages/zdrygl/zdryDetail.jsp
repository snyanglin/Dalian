<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>重点人员审批</title>
</head>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <form  id="dataForm" name="dataForm" method="post">
    	
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			${renderedTaskForm}
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" >资料查看：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<a href="javascript:void(0);" onclick="openSyrk()">实有人口详情</a>
	    	</tr>
	    	</table>
	    	
	    	  <div style="margin: 0 auto;"></div>   
	    	
	    	
	    	<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px;">
	    	
			  
			  <a id="close" class="l-btn l-btn-small"
					href="javascript:void(0)" group=""> <span
					class="l-btn-left l-btn-icon-left"> <span class="l-btn-text">关闭</span>
						<span class="l-btn-icon icon-save"> </span> </span> </a>
			</div>
	  	
	    	
    </form>
</div>

<script type="text/javascript" >

		
	$("#close").bind("click",function() {
			
			
				 
					window.parent.$('#windowWithoutSave').dialog('close');
		
			});
});


}











	
</script>