<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>高校信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>gxxxb_dl/save" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
	    <div data-options="region:'center', split:true" style="width:700px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
		    <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">高校学生人数：</td>
				<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="gxxs_rs" name="gxxs_rs" style="width:200px;" value="${entity.gxxs_rs }" maxlength="20" 
		    		data-options="required:true,validType:['naturalNumber'],tipPosition:'right'"/>
		    	</td>
				<td width="20%" class="dialogTd" align="right">教师人数：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" name="js_rs" id="js_rs" style="width:200px" value="${entity.js_rs}" maxlength="20" 
		    		data-options="validType:['naturalNumber'],required:true,tipPosition:'left'" /></td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">外籍学生人数：</td>
				<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="wjxs_rs" name="wjxs_rs" style="width:200px;" value="${entity.wjxs_rs }" maxlength="20" 
		    		data-options="required:false,validType:['naturalNumber'],tipPosition:'right'"/>
		    	</td>
				<td width="20%" class="dialogTd" align="right">外籍教师人数：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" name="wjjs_rs" id="wjjs_rs" style="width:200px" value="${entity.wjjs_rs}" maxlength="20" 
		    		data-options="validType:['naturalNumber'],required:false,tipPosition:'left'" /></td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">少数民族学生人数：</td>
				<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ssmzxs_rs" name="ssmzxs_rs" style="width:200px;" value="${entity.ssmzxs_rs }" maxlength="20" 
		    		data-options="required:false,validType:['naturalNumber'],tipPosition:'right'"/>
		    	</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">化学实验室数量：</td>
				<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="hxsyssl" name="hxsyssl" style="width:200px;" value="${entity.hxsyssl }" maxlength="20" 
		    		data-options="required:false,validType:['naturalNumber'],tipPosition:'right'"/>
		    	</td>
				<td width="20%" class="dialogTd" align="right">有无化学危险品：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-combobox" type="text" id="ywhxwxpdm" name="ywhxwxpdm" style="width:200px;" value="${entity.ywhxwxpdm }"
					data-options="url: contextPath + '/common/dict/D_GG_YW.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'" />
		    	</td>
			</tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">化学危险品责任人：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="glhxwxpzrr" name="glhxwxpzrr" style="width:200px;" value="${entity.glhxwxpzrr }" maxlength="20" 
		    		data-options="required:false,tipPosition:'right'"/>
		    	</td>
				<td width="20%" class="dialogTd" align="right">责任人联系电话：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zrr_lxdh" name="zrr_lxdh" style="width:200px;" value="${entity.zrr_lxdh }" maxlength="18"
		    		data-options="validType:['phone'],required:false,tipPosition:'left'" />
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">化学危险品种类及数量情况：</td>
				<td width="80%" class="dialogTd" colspan="3">
					<textarea class="easyui-validatebox" id="hxwxpzljslqk" name="hxwxpzljslqk" style="width: 627px; height:48px;"
					data-options="validType:['maxLength[4000]'],invalidMessage:'化学危险品种类及数量情况不能超过4000个汉字，请重新输入！',required:false,tipPosition:'left',required:false">${entity.hxwxpzljslqk}</textarea>
				</td>
	    	</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注：</td>
				<td width="80%" class="dialogTd" colspan="3">
					<textarea class="easyui-validatebox" id="bz" name="bz" style="width: 627px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',required:false,tipPosition:'left',required:false">${entity.bz}</textarea>
				</td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
var _p ;
function doInit(paramArray) {
	_p = paramArray["_p"];
	
}

function beforeSubmit() {}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	$(_p).find("input[name='id']").val($("#pk").val());
	setFormDataToSpan($("body"),_p);
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
