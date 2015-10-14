<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>重点人员审批</title>
</head>
<%
SessionBean userInfo = (SessionBean) session
.getAttribute("userSession");
String userName="王大军";
if(userInfo!=null){
	 userName=userInfo.getUserName();
}

SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
Calendar cal=Calendar.getInstance();
String today = sdf.format(cal.getTime());

%>

<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script>
<div class="easyui-layout" data-options="fit:true" style="overflow:auto">
    <form action="<%=basePath%>zdryLcg/updateZdryYwspb" id="dataForm" name="dataForm" method="post">

			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center"  >
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">待列管人员姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" name="zdryZdryzb.xm" style="width:200px;" readonly="readonly"  value="王丽华"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zdryZdryzb.zjhm" id="zjhm" style="width:200px;" readonly="readonly" value="210211197610122812"/></td>
		    </tr>
		    <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">管理类型：</td>
		    	<td width="30%" class="dialogTd" id="gllx">
		    	社区矫正人员
				</td>
		    </tr>
		     <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">重点人员类别：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	 宣告缓刑
				</td>
		    </tr>
		   
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="cgrqText">申请日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="sqsj" id="sqsj" class="easyui-validatebox inputreadonly" style="width: 200px;" value="2015-01-01" readonly="readonly" /></td>
	    	</tr>
	    	  <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">申请人：</td>
	    		<td width="80%" class="dialogTd" colspan="3">
	    		<input class="easyui-validatebox inputreadonly" type="text" id="sqr_xm" name="sqr_xm" style="width:619px;" value="李长荣" readonly="readonly" 
		    	</td>
		    </tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="cgsqyjText">申请意见：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="ywfqyy" name="zdryYwspb.sqyj" style="width: 619px;" data-options="required:false,validType:['maxLength[100]','unnormal']"  readonly="readonly" value="申请将【王丽华】列管为社区矫正重点人员"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="cgrqText">审批日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="spsj" id="spsj" class="easyui-validatebox inputreadonly" style="width: 200px;" value="<%=today %>" readonly="readonly" /></td>
		    	<td width="20%" class="dialogTd" align="right" id="cgrText">审批人：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" id="spr_xm" name="spr_xm" style="width:200px;" value="<%=userName %>" readonly="readonly" />
		    	</td>
	    	</tr>
	    	 <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">审批结果：</td>
	    		<td width="80%" class="dialogTd" colspan="3">
	    		<input type="radio" name="spjg" id="spjg" value="1" onclick="changeSpjg(1)" checked="checked"/>	 同意
	    		<input type="radio" name="spjg" id="spjg" value="0" onclick="changeSpjg(0)"/>	 不同意
		    	</td>
		    </tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="cgsqyjText">审批意见：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-validatebox " type="text" id="spyj" name="spyj" style="width: 619px;" data-options="required:false,validType:['maxLength[100]','unnormal']"  value="同意将【王丽华】列管为社区矫正重点人员"/></td>
	    	</tr>
	    	
	    	</table>
	    	
	    	
	    	
	    	
	    	<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px;">
	    		<c:if test="${openType ne 'view' }">
				<a id="saveBotton" class="l-btn l-btn-small"
					href="javascript:void(0)" group=""> <span
					class="l-btn-left l-btn-icon-left"> <span class="l-btn-text">保存</span>
						<span class="l-btn-icon icon-save"> </span> </span> </a>
			    </c:if>
			</div>
	    	
	    	
    </form>
</div>

<script type="text/javascript" >
var placeVersion = "<%=SystemConfig.getString("PlaceVersion")%>";

var zdryHsbId= '${zdryHsbId}';
var openType='${openType}';
$(document).ready(function(){
	if(openType=='view'){
		setInputReadonly('spjg', true);
	}
	changeSpjg(1,null);
	if(placeVersion=="辽宁省厅版"){

		if($("#zdrygllxdm").val()=="07"){
		     $("#gllx").html("涉环保重点人员");
		     if($("#spdj").val()=="1"){
		              $("#dataForm").attr("action","<%=basePath%>shbzdry/updateShbzdry1jYwspb");	     
		     }
		     else if($("#spdj").val()=="2"){
		              $("#dataForm").attr("action","<%=basePath%>shbzdry/updateShbzdry2jYwspb");	     
		     }
		}
	}
	
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
				doSubmitResult(result, null, null);
				window.parent.$('#windowWithoutSave').dialog('close');
			}
		});	
	});
});

function changeSpjg(val){
if(val==1){
	$("#spyj").val("同意将【王丽华】列管为社区矫正重点人员") ;
}else{
	$("#spyj").val("拒绝将【王丽华】列管为社区矫正重点人员") ;
}
		
			
		
	
}


function doInit(paramArray) {
	
	if(zdryHsbId&&zdryHsbId!=""){
		$("#dataForm").attr("action","<%=basePath%>zdryHsb/saveApproval");
	}
}

function beforeSubmit() {
	
}

function afterSubmit() {
}

	
</script>