<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>重点人员转递接受</title>
</head>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>zdryZd/zdryZdJs" id="dataForm" name="dataForm" method="post">
    	
    	<input type="hidden" id="taskId" name="taskId""  value="${taskId}" />
    	<input type="hidden" id="executionId" name="executionId""  value="${executionId}" />
    
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="30%" class="dialogTd" align="right">转递人员姓名：</td>
		    	<td width="20%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="zdryName" name="zdryName" style="width:200px;" readonly="readonly"  /></td>
		    	<td width="30%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="20%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zjhm" id="zjhm" style="width:200px;" readonly="readonly" /></td>
		     </tr>		
		      <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">原居住地址：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox inputreadonly" type="text" name="yjzddz" id="yjzddz" style="width: 619px;" maxlength="50" readonly="readonly" /></td>	    	
		    </tr>	
		    
		     <tr class="dialogTr">
		    	<td width="40%" class="dialogTd" align="right">原居住管辖派出所：</td>
		    	<td width="10%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="ygxpcs" name="ygxpcs" value="" style="width:200px;" readonly="readonly"/>
		    		<input type="hidden" name="ygxpcsdm" id="ygxpcsdm" "/>	
		    	</td>
				<td width="40%" class="dialogTd" align="right">原居住管辖责任区：</td>
		    	<td width="10%" class="dialogTd">
		    		<input class="easyui-validatebox inputreadonly" type="text" id="ygxzrq" name="ygxzrq" value="" style="width:200px;" readonly="readonly"/>
		    		<input type="hidden" name="ygxzrqdm" id="ygxzrqdm" "/>	
		    	</td>
		    </tr>
		    	
				
		    <tr class="dialogTr">	
		    	<td width="30%" class="dialogTd" align="right" id="cgrqText">转递发起时间：</td>
		    	<td width="20%" class="dialogTd"><input type="text" name="sqsj" id="sqsj" class="easyui-validatebox inputreadonly" style="width: 200px;"  readonly="readonly" /></td>
	    		<td width="30%" class="dialogTd" align="right">转递发起人：</td>
		    	<td width="20%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="sqrName" id="sqrName" style="width:200px;" readonly="readonly" /></td>
		 
	    	
	    	</tr>
	    	
	    	 <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="cgsqyjText">现居住地址：</td>
		      	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox inputreadonly" type="text" name="zddz" id="zddz" style="width: 619px;" maxlength="50" readonly="readonly" /></td>	    	
   			</tr>
		 
	    	
		    
		     <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">处理结果：</td>
	    		<td width="80%" class="dialogTd" colspan="3">
	    		<input type="radio" name="spjg" id="spjg" value="1"  checked="checked"/>	接收
	    		<input type="radio" name="spjg" id="spjg" value="0"   />	 不接收
		    	</td>
		    </tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="cgsqyjText">拒绝理由：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-validatebox " type="text" id="ywfqyy" name="ywfqyy" style="width: 619px;" data-options="required:false,validType:['maxLength[100]','unnormal']"  /></td>
	    	</tr>
	    	
	   
	    	</table>
	    	
 		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px;">
	    	
				<a id="saveBotton" class="l-btn l-btn-small"
					href="javascript:void(0)" group=""> <span
					class="l-btn-left l-btn-icon-left"> <span class="l-btn-text">保存</span>
						<span class="l-btn-icon icon-save"> </span> </span> </a>
			  
			  <a id="close" class="l-btn l-btn-small"
					href="javascript:void(0)" group=""> <span
					class="l-btn-left l-btn-icon-left"> <span class="l-btn-text">关闭</span>
						<span class="l-btn-icon icon-save"> </span> </span> </a>
			</div>
	  	
	    	
    </form>
</div>

<script type="text/javascript" >

$(document).ready(function(){
		getZdryXx();
		
		public_getOrgName('ygxpcsdm','ygxpcs');
		public_getOrgName('ygxzrqdm','ygxzrq');
		$("#saveBotton").bind("click",function() {
			
			var formObject =$("#dataForm");
			if(!formObject.form('validate')){
				return false;
			}
		
			formObject.form('submit',{
				dataType : 'json',
				onSubmit: function() {
				},
				success: function(result) {
				//	alert("212");
					doSubmitResult(result, null, null);
					window.parent.refresh();
					window.parent.$('#windowWithoutSave').dialog('close');
					
				}
			});	
		});
			
		
	$("#close").bind("click",function() {
			
			
				 
					window.parent.$('#windowWithoutSave').dialog('close');
		
			});
});

function getZdryXx() {
	var su = true;
	$.ajax({
		async:false,
		type:"POST",
		url:"<%= basePath%>zdryZd/getZdryXx",
		dataType:"json",
		data:"executionId="+'${executionId}',
		success:function(data){
				if (data) {
					$("#zdryName").val(data.workflowXx.xm) ;
					$("#zjhm").val(data.workflowXx.zjhm) ;
					$("#yjzddz").val(data.workflowXx.yjzddz) ;						
					$("#ygxpcsdm").val(data.workflowXx.ygxpcsdm) ;	
					$("#ygxzrqdm").val(data.workflowXx.ygxzrqdm) ;
					$("#sqsj").val(data.workflowXx.sqsj) ;
					$("#sqrName").val(data.workflowXx.sqrName) ;
					$("#zddz").val(data.workflowXx.zddz) ;
					
		
				}
			}
		});
	
}



	
</script>