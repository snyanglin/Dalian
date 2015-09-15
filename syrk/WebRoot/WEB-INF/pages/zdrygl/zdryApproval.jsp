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
    <form action="<%=basePath%>zdryApproval/${approvalMethod}" id="dataForm" name="dataForm" method="post">
    	
    	<input type="hidden" id="workflowId" name="workflowId""  value="${workflowId}" />
    	<input type="hidden" id="zdrylx" name="zdrylx""   />
    	<input type="hidden" id="sqlxdm" name="sqlxdm""   />
    	
    
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">重点人员姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="zdryName" name="zdryName" style="width:200px;" readonly="readonly"  /></td>
		    	<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zjhm" id="zjhm" style="width:200px;" readonly="readonly" /></td>
		    	
		    
		    
		      <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">申请类型：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="sqlx" id="sqlx" style="width:200px;" readonly="readonly" /></td>	    	
		    	<td width="20%" class="dialogTd" align="right">重点人员类别：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zdrylxmc" id="zdrylxmc" style="width:200px;" readonly="readonly" /></td>	    	
		    </tr>	
		    	
				
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="cgrqText">申请日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="sqsj" id="sqsj" class="easyui-validatebox inputreadonly" style="width: 200px;"  readonly="readonly" /></td>
	    		<td width="10%" class="dialogTd" align="right">申请人：</td>
		    	<td width="20%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="sqrId" id="sqrId" style="width:200px;" readonly="readonly" /></td>		 	    
	    	</tr>
	    	<c:if test="${sqlxdm eq '04'}">	    	
	    	 <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">请假日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="qjrq" id="qjrq" class="easyui-validatebox inputreadonly" style="width: 200px;"  readonly="readonly" /></td>
	    		<td width="20%" class="dialogTd" align="right">预计返回日期：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="yjfh_rq" id="yjfh_rq" style="width:200px;" readonly="readonly" /></td>		 	    
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">请假原因：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    		<textarea name="qjyy" id="qjyy" class="easyui-validatebox inputreadonly" style="width: 618px; height:48px; readonly="readonly"">
						${qjyy}
					</textarea>
		    	</td>	    				 	   
	    	</tr>	    	
	    	</c:if>
	    	
	    	<c:if test="${approvalMethod eq 'szzlApproval'}">
	    	
	    	  <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="cgrqText">重点人员已列管类别：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="yzdrylbmc" id="yzdrylbmc" class="easyui-validatebox inputreadonly" style="width: 200px;"  readonly="readonly" /></td>
	    		<td width="10%" class="dialogTd" align="right">重点人员转类类别：</td>
		    	<td width="20%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="xzdrylbmc" id="xzdrylbmc" style="width:200px;" readonly="readonly" /></td>
		 
	    	
	    	</tr>
	    	
	    	</c:if>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="cgsqyjText">申请意见：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="sqyj" name="sqyj" style="width: 619px;" data-options="required:false,validType:['maxLength[100]','unnormal']"  readonly="readonly"/></td>
	    	</tr>
		    
		    
		     <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">审批结果：</td>
	    		<td width="80%" class="dialogTd" colspan="3">
	    		<input type="radio" name="spjg" id="spjg" value="1"  onclick="changeSpjg(this.value)" checked="checked"/>	 同意
	    		<input type="radio" name="spjg" id="spjg" value="0"  onclick="changeSpjg(this.value)" />	 不同意
		    	</td>
		    </tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="cgsqyjText">审批意见：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-validatebox " type="text" id="spyj" name="spyj" style="width: 619px;" data-options="required:false,validType:['maxLength[100]','unnormal']"  /></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" >资料查看：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<a href="javascript:void(0);" onclick="openSyrk()">实有人口详情</a>
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
var xm;
var ryid;
var syrkid;

$(document).ready(function(){
		getZdryXx();
		changeSpjg(1,null);
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
		url:"<%= basePath%>zdryApproval/getZdryXx",
		dataType:"json",
		data:"executionId="+'${executionId}',
		success:function(data){
				if (data) {
					$("#zdryName").val(data.workflowXx.xm) ;
					$("#zjhm").val(data.workflowXx.zjhm) ;
					$("#sqsj").val(data.workflowXx.createTime) ;						
					$("#sqrId").val(data.zdryZdryzb.xt_lrrxm) ;	
					$("#zdrylx").val(data.workflowXx.zdrylx) ;
					$("#zdrylxmc").val(data.workflowXx.zdrylxmc) ;
					$("#sqlx").val(data.workflowXx.sqlx) ;
					$("#sqlxdm").val(data.workflowXx.sqlxdm) ;
					$("#sqyj").val(data.workflowXx.sqyj) ;
					if(data.workflowXx.yzdrylbmc!='')
					{
					$("#yzdrylbmc").val(data.workflowXx.yzdrylbmc) ;
					$("#xzdrylbmc").val(data.workflowXx.xzdrylbmc) ;
					}
			//		alert(approvalMethod);
					xm=data.workflowXx.xm;
					ryid=data.zdryZdryzb.ryid;
					syrkid=data.zdryZdryzb.syrkid;
					if(data.workflowXx.sqlxdm=='04'){//请假
						$("#qjrq").val(data.zdryJgdxqxjdjb.qjrq);
						$("#yjfh_rq").val(data.zdryJgdxqxjdjb.yjfh_rq);
						$("#qjyy").val(data.zdryJgdxqxjdjb.qjyy);
					}
					
				}
			}
		});
	
}

function openSyrk(){
	var editUrl = "/syrkEdit/"+ryid+"/"+syrkid+"/view?mode=view";
	menu_open("实有人口【"+xm+"】",editUrl);
	window.parent.$('#windowWithoutSave').dialog('close');
}
function openZdrk(){
	
	var editUrl = "/zdrygl/"+ryid+"/"+syrkid+"/view?mode=view";
	menu_open(xm,editUrl);
	window.parent.$('#windowWithoutSave').dialog('close');
}


function changeSpjg(newValue , oldValue){

	var name = $("#zdryName").val();
	var sqyj = $("#sqyj").val();
	var spyj=sqyj.substring(2,sqyj.length);
		if(newValue=="1"){
			$("#spyj").val("同意"+spyj) ;
		}else{
			$("#spyj").val("拒绝"+spyj) ;
		}
	
}









	
</script>