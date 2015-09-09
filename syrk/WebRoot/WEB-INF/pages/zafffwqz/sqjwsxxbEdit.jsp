<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>社区警务室信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>sqjwsxxb/saveSqjwsxxb" id="dataForm" name="dataForm" method="post">
    	
    
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
    		<input type="hidden" name="id" id="pk" value="${entity.id}" />
		    <tr class="dialogTr">
		  			<td width="20%" class="dialogTd" align="right">警务室名称：</td>
				<td width="30%" class="dialogTd">
				<input  type='text' id='jwsmc' name='jwsmc' class="easyui-validatebox" style="width:200px;"
				data-options="required:true,tipPosition:'right'" maxlength="50" value="${entity.jwsmc}" />
				</td> 
				<td width="20%" class="dialogTd" align="right">警务室类别：</td>
				<td width="30%" class="dialogTd">
				<input class="easyui-combobox" type="text"  id="jwslb" name="jwslb" style="width:200px;" value="${entity.jwslb}"
					data-options="url: contextPath + '/common/dict/D_ZAFF_JWSLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
					required:false,tipPosition:'left'"/></td>
			</tr>
			 <tr class="dialogTr">
			 <td width="20%" class="dialogTd" align="right">警务室电话：</td>
				<td width="30%" class="dialogTd"><input class="easyui-validatebox " type="text" id="jwsdh" name="jwsdh" maxlength="30"
				data-options="validType:['phone'],tipPosition:'right'"
				style="width:200px;" value="${entity.jwsdh}" />
				</td>
				<td width="20%" class="dialogTd" align="right">警务室面积（㎡）：</td>
				<td width="30%" class="dialogTd" >
				<input class="easyui-validatebox" type="text" name="jwsmj" id="jwsmj" value="${entity.jwsmj}" style="width:200px;"
				data-options="validType:['numericRange[\'f\',2,1,10000]'],tipPosition:'left'" maxlength="100" />
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">是否独立：</td>
				<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text"  id="sfdldm" name="sfdldm" style="width:200px;" value="${entity.sfdldm}"
					data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
					required:false,tipPosition:'right'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">民警人数：</td>
				<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="mjrs" name="mjrs" style="width:200px;" value="${entity.mjrs}" maxlength="3"
					data-options="required:false,tipPosition:'left',validType:['naturalNumber']"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">办公用品配置：</td>
				<td width="80%" class="dialogTd" colspan="3">
				<input  type='text' id='bgyppz' name='bgyppz' class="easyui-validatebox" style="width: 628px; "
				data-options="required:false,tipPosition:'left'" maxlength="1000" value="${entity.bgyppz}" />
				</td>
			</tr>
			<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">警务室地址：</td>
			 <td width="50%" class="dialogTd" colspan="2">
				  <input class="easyui-combobox" id="jzd1" style="width:400px;" value="${entity.dz_jwsdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_jwsdzmlpdm' id="jwsdzmlpdm" value="${entity.dz_jwsdzmlpdm}"/>
				    	<input type='hidden' name='dz_jwsdzmlpxz' id="jwsdzmlpxz" value="${entity.dz_jwsdzmlpxz}"/>
				  </td>
				<td width="30%" class="dialogTd" >
				<input class="easyui-combobox" id="jzd2" style="width:200px;" value='${fn:replace(entity.dz_jwsdzxz, entity.dz_jwsdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				<input type="hidden" name="dz_jwsdzdm" id="jwsdzdm" value="${entity.dz_jwsdzdm}"/>
				<input type="hidden" name="dz_jwsdzssxdm" id="jwsdzssxdm" value="${entity.dz_jwsdzssxdm}"/>
			    <input type='hidden' name='dz_jwsdzxz' id="jwsdzxz" value="${entity.dz_jwsdzxz}"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">计算机台数：</td>
				<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jsjts" name="jsjts" style="width:200px;" value="${entity.jsjts}"
					data-options="validType:['naturalNumber'],required:false,tipPosition:'right'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">连接公安网台数：</td>
				<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ljgawts" name="ljgawts" style="width:200px;" value="${entity.ljgawts}"
					data-options="validType:['naturalNumber'],required:false,tipPosition:'left'"/>
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
	_p = paramArray["_p"];
}
$(document).ready(function(){
	initAddressSearch('jzd1', {}, 'jwsdzmlpdm', 'jwsdzmlpxz', 'jzd2', {text:'jwsdzxz',dzxzqh:'jwsdzssxdm',id:'jwsdzdm'}, null, null);
});
function beforeSubmit() {
var jsjts=document.getElementById("jsjts");
var ljgawts=document.getElementById("ljgawts");
	if(jsjts.value<ljgawts.value){
		alert("连接公安网台数不能大于计算机台数");
		return false;
	}
}

function afterSubmit(arr) {
	if (arr["saveID"]) {
		$("#pk").val(arr["saveID"]);
		$(_p).find("input[name='id']").val($("#pk").val());
	}
	setFormDataToSpan($("body"),_p);
	refreshJbxx();
}

function refreshJbxx() { // 刷新基本信息
	var e = _p;
	while (e = e.parent()) {
		if (e.is("body")) {
			break;
		}
	}
	if (e) {
		$(e).find('#jwsmcSpan').html($('#jwsmc').val());
		
		if ($('#jwslb').val() == "") {
			$(e).find('#jwslbSpan').html("");
		}
		else {
			$(e).find('#jwslbSpan').html($("#jwslb").combobox('getText'));
		}
		
		if ($('#jwsdh').val() == "") {
			$(e).find('#dhSpan').html("");
		}
		else {
			$(e).find('#dhSpan').html($('#jwsdh').val());
		}
		
		if ($('#jwsdzxz').val() == "") {
			$(e).find('#dzSpan').html("");
		}
		else {
			$(e).find('#dzSpan').html($('#jwsdzxz').val());
		}
		
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
	var textareaSelector = containObject.find('textarea.edit_input');
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