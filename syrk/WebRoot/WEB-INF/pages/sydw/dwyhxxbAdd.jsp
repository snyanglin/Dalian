<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@CreateDate:   [2015-6-3 下午14:31:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>烟花单位特殊信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwownsydw/saveYh" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;margin-top:5px;text-align: center;">
		    <fieldset style="width: 90%;">
	  			<legend>烟花营业单位基本信息</legend>
	  			<table border="0" cellpadding="0" cellspacing="5" width="100%" align="center">
	    		<input type="hidden" name="id" id="pk" value="${entity.id}" />
	    		<input type="hidden" name="flag" id="flag" value="${flag}" />
			    <tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">备案机关：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-validatebox ' data-options="validType:['maxLength[50]'],required:false,tipPosition:'right'" type='text' 
						name='bajg'  style="width:200px;" value="${entity.bajg}" />
					</td>
					<td width="20%" class="dialogTd" align="right">是否配送：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox"  data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'" type="text" id="sfps" name="sfps"  style="width:200px;" value="${entity.sfps}"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    <td width="20%" class="dialogTd" align="right">作业人数：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-validatebox ' data-options="validType:['naturalNumberRange[1,999999]'],required:false ,tipPosition:'right'" type='text' 
						name='zyry'  style="width:200px;" value="${entity.zyry}" />
					</td>
					<td width="20%" class="dialogTd" align="right">产品质量检验信息：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox"  data-options="required:false,validType:['maxLength[50]'],tipPosition:'left'" type="text" id="cpzljyxx" name="cpzljyxx" maxlength="100" style="width:200px;" value="${entity.cpzljyxx}"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">备注：</td>
					<td width="80%" class="dialogTd"  colspan="3">
						<textarea class="easyui-validatebox" type="text" data-options="validType:['maxLength[1000]'],required:false ,tipPosition:'left'" id="bz" name="bz" style="width:580px;height: 30px;">${entity.bz}</textarea>
					</td>
				</tr>
		    	</table>
	  		</fieldset>
	  		<span style="width: 200px;">&nbsp;</span>
		    <fieldset style="width: 90%;">
	  			<legend>许可证信息</legend>
				<table border="0" cellpadding="0" cellspacing="5" width="100%" align="center">
				   	<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">燃放规模等级：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-combobox' data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'" type='text' 
							name='yfgmdjdm'  style="width:200px;" value="${entity.yfgmdjdm}" />
						</td>
						<td width="20%" class="dialogTd" align="right">许可证类型：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-combobox"  data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'" type="text" id="xkzlx" name="xkzlx"  style="width:200px;" value="${entity.xkzlx}"/>
						</td>
				    </tr>
				    <tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">许可证编号：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="required:false ,validType:['letterOrNum'],tipPosition:'right'" type='text' maxlength="30"
							name='xkzbh'  style="width:200px;" value="${entity.xkzbh}" />
						</td>
						<td width="20%" class="dialogTd" align="right">发证机关：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-validatebox"  data-options="required:false,validType:['maxLength[50]'],tipPosition:'left'" type="text" id="fzjg" name="fzjg"  style="width:200px;" value="${entity.fzjg}"/>
						</td>
					</tr>
					 <tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">发证日期：</td>
						<td width="30%" class="dialogTd">
							<input type="text" name="fzrq" id="fzrq" class="easyui-validatebox" style="width: 200px;" value="${entity.fzrq}"  
							data-options="required:false,validType:['date[\'yyyy-MM-dd \']']" 
							data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
							onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'yxjzrq\') }'})"/>
						</td>
						<td width="20%" class="dialogTd" align="right">有效截止日期：</td>
						<td width="30%" class="dialogTd">
							<input type="text" name="yxjzrq" id="yxjzrq" class="easyui-validatebox" style="width: 200px;" value="${entity.yxjzrq}"  
							data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" 
							onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'fzrq\') }'})"/></td>
					</tr>
		    	</table>
		    </fieldset>
		    <span style="width: 200px;">&nbsp;</span>
		    <fieldset style="width: 90%;">
	  			<legend>库房信息</legend>
				<table border="0" cellpadding="0" cellspacing="5" width="100%" align="center">
				   	<tr class="dialogTr">
				    <td width="20%" class="dialogTd" align="right">库房名称：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="required:false ,validType:['maxLength[50]'],tipPosition:'right'" type='text' 
							name='kfmc'  style="width:200px;" value="${entity.kfmc}" />
						</td>
						<td width="20%" class="dialogTd" align="right">库房类别：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-combobox"  data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'" type="text" id="kflb" name="kflb" maxlength="100" style="width:200px;" value="${entity.kflb}"/>
						</td>
				    </tr>
				    <tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">危险等级：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-combobox" type="text" data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'" id="wxdj" name="wxdj" style="width:200px;" value="${entity.wxdj}" maxlength="12"/>
						</td>
						<td width="20%" class="dialogTd" align="right">总建筑面积：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-validatebox" type="text" data-options="validType:['numeric[\'f\',2]'],invalidMessage:'总建筑面积为两位小数的数字，请重新输入！',required:false ,tipPosition:'left'" id="zjzmj" name="zjzmj" style="width:200px;" value="${entity.zjzmj}" maxlength="12"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">回收间建筑面积：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-validatebox" type="text" data-options="validType:['numeric[\'f\',2]'],invalidMessage:'回收间建筑面积为两位小数的数字，请重新输入！',required:false,tipPosition:'right'" id="hsjjzmj" name="hsjjzmj" style="width:200px;" value="${entity.hsjjzmj}" maxlength="12"/>
						</td>
						<td width="20%" class="dialogTd" align="right">生产区建筑面积：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-validatebox" type="text" data-options="validType:['numeric[\'f\',2]'],invalidMessage:'生产区建筑面积为两位小数的数字，请重新输入！',required:false ,tipPosition:'left'" id="scqjzmj" name="scqjzmj" style="width:200px;" value="${entity.scqjzmj}" maxlength="12"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">经营面积：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-validatebox" type="text" data-options="validType:['numeric[\'f\',2]'],invalidMessage:'经营面积为两位小数的数字，请重新输入！',required:false ,tipPosition:'right'" id="jymj" name="jymj" style="width:200px;" value="${entity.jymj}" maxlength="12"/>
						</td>
						<td width="20%" class="dialogTd" align="right">涉药库房面积：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-validatebox" type="text" data-options="validType:['numeric[\'f\',2]'],invalidMessage:'涉药库房面积为两位小数的数字，请重新输入！',required:false ,tipPosition:'left'" id="sykfmj" name="sykfmj" style="width:200px;" value="${entity.sykfmj}" maxlength="12"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">核定库存量：</td>
						<td width="30%" class="dialogTd">
							<input class="easyui-validatebox" type="text" data-options="validType:['numeric[\'f\',2]'],invalidMessage:'核定库存量为两位小数的数字，请重新输入！',required:false ,tipPosition:'right'" id="hdkcl" name="hdkcl" style="width:200px;" value="${entity.hdkcl}" maxlength="12"/>
						</td>
					</tr>
		    	</table>
		    </fieldset>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
var _p ;
function doInit(paramArray) {
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
	window.parent.location.reload();
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