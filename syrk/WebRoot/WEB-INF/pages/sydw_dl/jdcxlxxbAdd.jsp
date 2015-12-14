<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>机动车修理信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>jdcxlxxb_dl/save" id="dataForm" name="dataForm" method="post">
    	
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
    	<input type="hidden" name="flag" id="flag" value="${flag}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
    		<input type="hidden" name="id" id="pk" value="${entity.id}" />
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">单位名称：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox inputreadonly" type="text" id="dwmc" style="width:628px;" readonly="readonly" /></td>
		    </tr>
		    <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">是否专修店：</td>
				<td width="30%" class="dialogTd">
				<input class="easyui-combobox" type="text" id="sfzxddm" name="sfzxddm" style="width:200px;" value="${entity.sfzxddm}"
					data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
					required:true,tipPosition:'left'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">是否连锁店：</td>
				<td width="30%" class="dialogTd">
				<input class="easyui-combobox" type="text" id="sflsddm" name="sflsddm" style="width:200px;" value="${entity.sflsddm}"
					data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
					required:true,tipPosition:'left'"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">是否备案：</td>
				<td width="30%" class="dialogTd">
				<input class="easyui-combobox" type="text" id="sfbadm" name="sfbadm" style="width:200px;" value="${entity.sfbadm}"
					data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onSelect: sfba,
					required:true,tipPosition:'right'"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">备案单位：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox " type="text" id="ba_dwmc" name="ba_dwmc" style="width:628px;" value="${entity.ba_dwmc}" /></td>
			</tr>
			 <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">修理范围：</td>
				<td width="80%" class="dialogTd" colspan="3">
				<textarea name="xlfw"  id="xlfw"  maxlength="2000" class="easyui-validatebox" style="width: 628px; height:48px;"
					data-options="required:true,validType:['maxLength[2000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.xlfw}</textarea>
				</td>
			</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
var _p;
function doInit(paramArray) {
	document.getElementById("dwmc").value = paramArray["dwmc"];
	var flag = document.getElementById("flag").value;
	if(flag=="add"){
		$("#sflsddm").combobox("setValue","0");
	}else {
		var ba=$("#sfbadm").combobox("getText");
		if(ba=="是"){
			setInputReadonly('ba_dwmc',false);
		}else {
			setInputReadonly('ba_dwmc',true);
			$("#ba_dwmc").val("");
		}
	}
	
	_p = paramArray["_p"];
}
function beforeSubmit() {
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}

	$(_p).find("input[name='id']").val($("#pk").val());
	setFormDataToSpan($("body"),_p);
}
function resetForm(){
	$("#sflsddm").combobox("clear");
	$("#xlfw").val("");
	$("#sfzxddm").combobox("setValue","0");
	$("#ba_dwmc").val("");
	$("#sfbadm").combobox("clear");
	setInputReadonly("ba_dwmc",false);
}
function sfba(){
	var ba=$("#sfbadm").combobox("getText");
	if(ba=="是"){
		setInputReadonly("ba_dwmc",false);
	}else {
		setInputReadonly("ba_dwmc",true);
		$("#ba_dwmc").val("");
	}
}
function setFormDataToSpan(containObject,_p) {
	var inputSelector = containObject.find('input');
	$.each(inputSelector, function(index, object) {
		var element = $(object);
		var _type = element.attr('type');
		var _name = element.attr('name');
		var _comboname = element.attr('comboname');
		var _span = null;
		if (_name) {
			if (_type == "text" || _type =="hidden") {
				var _class = element.attr('class');
				if (_class != 'combo-value') {
					_span = $(_p).find("span[name='"+_name+"']");
					if (_span) {
						_span.text(element.val());
					}
				}
			}
		}
		if (_comboname) {
			var comboText = element.combo("getText");
			_span = $(_p).find("span[name='"+_comboname+"']");
			if (_span) {
				_span.text(comboText);
			}
		}
	});
	var textareaSelector = containObject.find('textarea');
	$.each(textareaSelector, function(index, object) {
		var element = $(object);
		var _name = element.attr('name');
		if (_name) {
			_span = $(_p).find("span[name='"+_name+"']");
			if (_span) {
				var spanHtml = element.val();
				spanHtml = spanHtml.replace(/\n/g, "<br>");
				_span.html(spanHtml);
			}
		}
	});
}
</script>