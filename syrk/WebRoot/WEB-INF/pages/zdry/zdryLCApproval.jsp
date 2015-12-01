<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>重点人员审批</title>
</head>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script>
<div class="easyui-layout" data-options="fit:true" style="overflow:auto">
    <form action="<%=basePath%>zdryLcg/updateZdryYwspb" id="dataForm" name="dataForm" method="post">
    	
    	<input type="hidden" id="zdryid" name="zdryid" value="${zdryVO.zdryZdryzb.id}" />
    	<input type="hidden" id="id" name="id" value="${zdryVO.zdryYwspb.id}" />
    	<input type="hidden" id="ywbid" name="ywbid" value="${zdryVO.zdryYwspb.ywbid}" />
    	<input type="hidden" id="spr_id" name="spr_id" value="${zdryVO.zdryYwspb.spr_id}" />
    	<input type="hidden" id="messageid" name="messageid" value="${messageid }" />
    	<input type="hidden" id="zdrygllxdm" name="zdrygllxdm" value="${zdryVO.zdryZdryzb.zdrygllxdm}" />
    	<input type="hidden" id="spdj" name="spdj" value="${spdj}" />
    	
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center"  >
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">待列管人员姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" name="zdryZdryzb.xm" style="width:200px;" readonly="readonly"  value="${zdryVO.zdryZdryzb.xm}"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zdryZdryzb.zjhm" id="zjhm" style="width:200px;" readonly="readonly" value="${zdryVO.zdryZdryzb.zjhm}"/></td>
		    </tr>
		    <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">管理类型：</td>
		    	<td width="30%" class="dialogTd" id="gllx">
		    	<script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/BD_D_ZDRYLBDM.js', "${zdryVO.zdryZdryzb.zdrygllxdm}"));
		    	</script>
				</td>
		    </tr>
		     <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">重点人员类别：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	 <script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/BD_D_ZDRYLBDM.js', "${zdryVO.zdrylbStr}"));
		    	</script> 
				</td>
		    </tr>
		   
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="cgrqText">申请日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="sqsj" id="sqsj" class="easyui-validatebox inputreadonly" style="width: 200px;" value="${zdryVO.zdryYwspb.sqsj }" readonly="readonly" /></td>
	    	</tr>
	    	  <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">申请人：</td>
	    		<td width="80%" class="dialogTd" colspan="3">
	    		<input class="easyui-validatebox inputreadonly" type="text" id="sqr_xm" name="sqr_xm" style="width:619px;" value="${zdryVO.zdryYwspb.sqr_xm }" readonly="readonly" 
		    	</td>
		    </tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="cgsqyjText">申请意见：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="ywfqyy" name="zdryYwspb.sqyj" style="width: 619px;" data-options="required:false,validType:['maxLength[100]','unnormal']"  readonly="readonly" value="${zdryVO.zdryYwspb.sqyj }"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="cgrqText">审批日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="spsj" id="spsj" class="easyui-validatebox inputreadonly" style="width: 200px;" value="${zdryVO.zdryYwspb.spsj }" readonly="readonly" /></td>
		    	<td width="20%" class="dialogTd" align="right" id="cgrText">审批人：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" id="spr_xm" name="spr_xm" style="width:200px;" value="${zdryVO.zdryYwspb.spr_xm }" readonly="readonly" />
		    	</td>
	    	</tr>
	    	 <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">审批结果：</td>
	    		<td width="80%" class="dialogTd" colspan="3">
	    		<input type="radio" name="spjg" id="spjg" value="1" onclick="changeSpjg(this.value)" checked="checked"/>	 同意
	    		<input type="radio" name="spjg" id="spjg" value="0" onclick="changeSpjg(this.value)"/>	 不同意
		    	</td>
		    </tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="cgsqyjText">审批意见：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-validatebox " type="text" id="spyj" name="spyj" style="width: 619px;" data-options="required:false,validType:['maxLength[100]','unnormal']"  value="${zdryVO.zdryYwspb.spyj }"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" >资料查看：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<a href="javascript:void(0);" onclick="openSyrk('${zdryVO.zdryZdryzb.xm }','${zdryVO.zdryZdryzb.ryid}','${zdryVO.zdryZdryzb.syrkid}')">实有人口详情</a>
	    	    <a href="javascript:void(0);" onclick="openZdrk('${zdryVO.zdryZdryzb.xm }','${zdryVO.zdryZdryzb.ryid}','${zdryVO.zdryZdryzb.syrkid}')">列管申请详情</a>
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

function changeSpjg(newValue , oldValue){
	var dictName=window.top.getDictName(contextPath + '/common/dict/BD_D_ZDRYLBDM.js', '${zdryVO.zdryZdryzb.zdrygllxdm}');
	var name = $("#xm").val();
	var sqyj = $("#ywfqyy").val();
	var spyj=sqyj.substring(2,sqyj.length);
		if(newValue=="1"){
			$("#spyj").val("同意"+spyj) ;
		}else{
			$("#spyj").val("拒绝"+spyj) ;
		}
	
}

function openSyrk(xm,ryid,syrkid){
	
	var editUrl = "/syrkEdit/"+ryid+"/"+syrkid+"/view?mode=view";
	menu_open("实有人口【"+xm+"】",editUrl);
	window.parent.$('#windowWithoutSave').dialog('close');
}
function openZdrk(xm,ryid,syrkid){
	
	var editUrl = "/zdry/"+ryid+"/"+syrkid+"/view?mode=view";
	menu_open(xm,editUrl);
	window.parent.$('#windowWithoutSave').dialog('close');
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