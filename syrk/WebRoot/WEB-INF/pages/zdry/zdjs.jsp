<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>转递审批</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>zdryZd/saveZdjs" id="dataForm" name="dataForm" method="post" >
    	<input type="hidden" id="zdryid" name="zdryid" value="${fqywb.zdryid }" />
    	<input type="hidden" id="type" name="type" value="${type}" />
    	<input type="hidden" id="messageid" name="messageid" value="${messageid }" />
    	<c:if test="${type eq 'sjcj'}">
    	<input type="hidden" id="id" name="id" value="${cjywb.id }" />
    	</c:if>
    	<c:if test="${type ne 'sjcj'}">
    	<input type="hidden" id="id" name="id" value="${jsywb.id }" />
    	</c:if>
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" name="zdryZdryzb.xm" style="width:200px;" readonly="readonly"  value="${zdryZdryzb.xm}"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zdryZdryzb.zjhm" style="width:200px;" readonly="readonly" value="${zdryZdryzb.zjhm}"/></td>
		    </tr>
		      <c:if test="${ displayStr != null}">
		       <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">已列管类别：</td>
	    		<td width="80%" class="dialogTd" colspan="3">
	    		${displayStr}
		    	</td>
		    </tr>
		    </c:if>
		    <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">户籍地址：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox inputreadonly"  type="text" id="dz_hjdmlpxz" name="dz_hjdmlpxz" value="${fqywb.dz_jzdzmlpxz}" maxlength="50"  readonly="readonly"
		    		style="width: 629px;" data-options=""/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">管辖派出所：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="ygxpcs" name="ygxpcs" value="" style="width:200px;" readonly="readonly"/>
		    		<input type="hidden" name="ygxpcsdm" id="ygxpcsdm" value="${fqywb.sspcsdm }"/>	
		    	</td>
				<td width="20%" class="dialogTd" align="right">管辖责任区：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox inputreadonly" type="text" id="ygxzrq" name="ygxzrq" value="" style="width:200px;" readonly="readonly"/>
		    		<input type="hidden" name="ygxzrqdm" id="ygxzrqdm" value="${fqywb.sszrqdm }"/>	
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">发起民警：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox inputreadonly" type="text" id="zdfqrmc" name="zdfqrmc" value="${fqywb.ywblr_xm}" style="width:200px;" readonly="readonly"/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">现居住地址：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox inputreadonly"  type="text" id="dz_jzdzxz" name="dz_jzdzxz" value="${jsywb.dz_jzdzxz}" maxlength="50"  readonly="readonly"
		    		style="width: 629px;" data-options=""/>
		    	</td>
    	   </tr>
    	   <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">管辖派出所：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox inputreadonly" type="text" id="xgxpcs" name="xgxpcs"  style="width:200px;" readonly="readonly" />
		    		<input type="hidden" name="xgxpcsdm" id="xgxpcsdm" value="${jsywb.sspcsdm }"/>
		    	</td>
				<td width="20%" class="dialogTd" align="right">管辖责任区：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox inputreadonly" type="text" id="xgxzrq" name="xgxzrq"  style="width:200px;" readonly="readonly" />
		    		<input type="hidden" name="xgxzrqdm" id="xgxzrqdm" value="${jsywb.sszrqdm }"/>
		    	</td>
		    </tr>
		     <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">接收民警：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox inputreadonly" type="text" id="ygxpcs" name="ygxpcs" value="${jsywb.ywblr_xm}" style="width:200px;" readonly="readonly"/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    <td width="20%" class="dialogTd" align="right">是否接收：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-combobox " type="text" id="ywcljg" value="${jsywb.ywcljg}"
								name="ywcljg" style="width: 200px;" 
								data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:sfjs" />
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">转递原因：</td>
		    	<td width="30%" class="dialogTd">
							<input class="easyui-validatebox inputreadonly" type="text" id="zdyydm" readonly="readonly"
								name="zdyydm" style="width: 200px;" value="${fqywb.ywfqyy}"   
								data-options="tipPosition:'right'" />
						</td>
		    </tr>
		     <c:if test="${type ne 'sjcj'}">
		     <tr class="dialogTr" id="syrkTr">
		   	<td width="20%" class="dialogTd" align="right">实有人口居住地址：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<select name="syrkid" id="syrkid" style="width: 520px; height:20px;" class="easyui-combobox" data-options="required:false" > 
		    	<c:forEach items="${ryjzdzList}" var="ryjzdz" varStatus="status">
		    	<option value="${ryjzdz.id}">${ryjzdz.jzd_dzxz} </option>
		    	</c:forEach>
		    	</select>
		    <a id="syrkAddButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="syrkAdd()">
					<span class="l-btn-text">新增实有人口</span>
			</a>
		    	</td>
		    </tr>
		    </c:if>
		     <tr class="dialogTr" id="jjjslyTr">
		    	<td width="20%" class="dialogTd" align="right">拒绝理由：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="ywfqyy" id="ywfqyy" class="easyui-validatebox" style="width: 620px; height:48px;" 
					data-options="validType:['maxLength[1000]'],invalidMessage:'拒绝理由不能超过1000个汉字，请重新输入！',tipPosition:'left'">${jsywb.ywfqyy}</textarea></td>
	    	</tr>
		    <c:if test="${type eq 'sjcj'}">
		     <tr class="dialogTr" >
		    	<td width="20%" class="dialogTd" align="right">裁决结果：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-combobox" type="text" id="cjjgdm" value="${cjywb.ywcljg }"
								name="cjjgdm" style="width: 200px;" 
								data-options="url: contextPath + '/common/dict/D_GG_CJJG.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'" />
		    	</td>
	    	</tr>
		      <tr class="dialogTr" id="cjlyTr">
		    	<td width="20%" class="dialogTd" align="right">裁决理由：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="sp_cjly" id="cjly" class="easyui-validatebox" style="width: 620px; height:48px;" 
					data-options="validType:['maxLength[1000]'],invalidMessage:'拒绝理由不能超过1000个汉字，请重新输入！',tipPosition:'left'">${cjywb.ywfqyy}</textarea></td>
	    	</tr>
		    </c:if>
	    	</table>
	    	<c:if test="${openType ne 'view' }">
	    	<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px;">
		<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			</div>
			</c:if>
	    </div>
    </form>
</div>

<script type="text/javascript" >
var type="${type}";
var openType="${openType}"
function doInit(paramArray) { 
	
	 if(type=="sjcj"){
		$("#dataForm").attr("action","<%=basePath%>zdryZd/saveZdcj");
		setInputReadonly("ywcljg", true);
	}else{
		$("#dataForm").attr("action","<%=basePath%>zdryZd/saveZdjs");
	}
	
}

function beforeSubmit() {
	
}

function Submit() {
}
$(document).ready(function(){
	 if(openType=="view"){
		 	setInputReadonly("ywcljg", true);
			setInputReadonly("syrkid", true);
			setInputReadonly("cjjgdm", true);
			setInputReadonly("cjly", true);
			setInputReadonly("ywfqyy", true);
			$("#syrkAddButton").css("display","none");
	 }
	public_getOrgName('xgxpcsdm','xgxpcs');
	public_getOrgName('xgxzrqdm','xgxzrq');
	public_getOrgName('ygxpcsdm','ygxpcs');
	public_getOrgName('ygxzrqdm','ygxzrq');
	$("#syrkTr").hide();
	 if(type=="sjcj"){
		 $("#jjjslyTr").hide();
	}
	$("#saveBotton").bind("click",function() {
		if($("#syrkid").val()==null&&type!="sjcj"){
			alert("居住地址不可输入，请选择，或新增实有人口");
			return false;
		}
		var formObject =$("#dataForm");
		if (!formObject.form("validate")) {
			return;
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

function sfjs(newValue,oldValue){
		if(newValue=="0"){
			$("#jjjslyTr").show();
			setComboRequired("syrkid",false);
			$("#syrkTr").hide();
			}
		else{
			$("#jjjslyTr").hide();
			setComboRequired("syrkid",true);
			$("#syrkTr").show();
			}
		
	
}
function syrkAdd(){
	var zjhm='${zdryZdryzb.zjhm}';
	menu_open('实有人口新增', '/syrkGl/add?mainTabID='+getMainTabID()+'&cyzjdm=111&zjhm='+zjhm+'&invokeJSMethod=queryButton');
	window.parent.$('#windowWithoutSave').dialog('close');
}

</script>
</html>