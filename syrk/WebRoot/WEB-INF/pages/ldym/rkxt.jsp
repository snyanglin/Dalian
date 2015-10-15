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
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" name="xm" style="width:200px;" readonly="readonly"  value="张春婷"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zjhm" style="width:200px;" readonly="readonly" value="210204198204146751"/></td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">协同内容：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="xxnr" id="xxnr" class="easyui-validatebox " style="width: 630px; height:86px;overflow: auto;" >白山路派出所、解放责任区李长荣把录入张春婷联系方式为13471182772与你辖区实有人口侯清华相重复，请确认侯清华电话是否正确，是否修改联系方式</textarea></td>
	    	</tr>
	    	</table>
	    	
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
			
			
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 
	setInputReadonly("xxnr", true);
	$("#agreeBotton").bind("click",function() {
	
	
				window.parent.$('#xtrwclWindow').dialog('close');
		
	});
	$("#refuseBotton").bind("click",function() {
	
				window.parent.$('#xtrwclWindow').dialog('close');
	
	});
	
}

function beforeSubmit() {
}

function Submit() {
}

</script>
</html>