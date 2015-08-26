<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>人口协同</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>ywxt/updateXtjg" id="dataForm" name="dataForm" method="post" >
    	<input type="hidden" id="xtId" name="xtId" value="${xtId }" />
    	<input type="hidden" id="xtType" name="xtType" value="${xtType}" />
    	
    	<input type="hidden" id="approvalLevel" name="approvalLevel" value="${approvalLevel}" />
    	<input type="hidden" id="messageid" name="messageid" value="${messageid }" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" name="xm" style="width:200px;" readonly="readonly"  value="${xm}"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zjhm" style="width:200px;" readonly="readonly" value="${zjhm}"/></td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">协同内容：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="xxnr" id="xxnr" class="easyui-validatebox " style="width: 630px; height:86px;overflow: auto;" >${content}</textarea></td>
	    	</tr>
	    	</table>
	    	<c:if test="${openType ne 'view' &&approvalLevel eq '1'}">
	    	<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px;">
			<a id="agreeBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">同意修改</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			<a style="margin-left: 50px;" id="refuseBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">拒绝修改</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			</div>
			</c:if>
			<c:if test="${openType ne 'view' &&approvalLevel eq '2'}">
			
			
	    	<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px;">
			<a id="agreeBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">发起方正确</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			<a style="margin-left: 50px;" id="refuseBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">接收方正确</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			<c:if test="${xtType eq '常住人口人户分离协同'}">
			<a style="margin-left: 50px;" id="allAgreeBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">都正确</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			</c:if>
			<c:if test="${xtType eq '人员联系电话真实性协同'}">
			<a style="margin-left: 50px;" id="allAgreeBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">都正确</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			<a style="margin-left: 50px;" id="allRefuseBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">都错误</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			</c:if>
			</div>
			</c:if>
			
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 
	setInputReadonly("xxnr", true);
	$("#agreeBotton").bind("click",function() {
		var formObject =$("#dataForm");
		formObject.form('submit',{
			dataType : 'json',
			onSubmit: function(param) {
				param.xtjg = '1';
			},
			success: function(result) {
				doSubmitResult(result, null, null);
				window.parent.$('#windowWithoutSave').dialog('close');
			}
		});	
	});
	$("#refuseBotton").bind("click",function() {
		var formObject =$("#dataForm");
		formObject.form('submit',{
			dataType : 'json',
			onSubmit: function(param) {
				param.xtjg = '0';
			},
			success: function(result) {
				doSubmitResult(result, null, null);
				window.parent.$('#windowWithoutSave').dialog('close');
			}
		});	
	});
	$("#allAgreeBotton").bind("click",function() {
		var formObject =$("#dataForm");
		formObject.form('submit',{
			dataType : 'json',
			onSubmit: function(param) {
				param.xtjg = '2';
			},
			success: function(result) {
				doSubmitResult(result, null, null);
				window.parent.$('#windowWithoutSave').dialog('close');
			}
		});	
	});
	$("#allRefuseBotton").bind("click",function() {
		var formObject =$("#dataForm");
		formObject.form('submit',{
			dataType : 'json',
			onSubmit: function(param) {
				param.xtjg = '4';
			},
			success: function(result) {
				doSubmitResult(result, null, null);
				window.parent.$('#windowWithoutSave').dialog('close');
			}
		});	
	});
}

function beforeSubmit() {
}

function Submit() {
}

</script>
</html>