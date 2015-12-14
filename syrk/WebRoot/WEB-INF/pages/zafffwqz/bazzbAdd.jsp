<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>保安组织</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>bazzb/saveBazzb" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" id="sqjwsid" name="sqjwsid" value="${entity.sqjwsid}">
    	<input type="hidden" name="sqid" id="sqid" value="${entity.sqid}" />	
    	<input type="hidden" name="ryid" id="ryid" value="${entity.ryid}" />	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	    	<input type="hidden" name="id" id="pk" value="${entity.id}" />
    		<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">负责人常用证件：</td>
				<td width="30%" class="dialogTd"><input type="text" name="fzrcyzjdm" id="zjlx"  value="${entity.fzrcyzjdm }" class="easyui-combobox " style="width:200px;"
	    		data-options="required:true,url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:setPassPort" /></td> 
				<td width="20%" class="dialogTd" align="right">负责人证件号码：</td>
				
				<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox" type="text" id="fzrzjhm" name="fzrzjhm" style="width:200px;float:left;" value="${entity.fzrzjhm }" maxlength="30" 
		    		data-options="required:true,tipPosition:'left'" /><div class="lodingimg" id="yrjbxxDiv"></div></td>
			</tr>
			<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">负责人姓名：</td>
				<td width="30%" class="dialogTd"><input type="text" name="fzrxm" id="xm" value="${entity.fzrxm}" 
				class="easyui-validatebox " data-options="required:false,validType:['maxLength[10]']" style="width:200px;"  /></td>
			<td width="20%" class="dialogTd" align="right">联系方式：</td>
			<td width="30%" class="dialogTd" >
			<input type="text" id="lxdh" name="fzrlxfs" value="${entity.fzrlxfs}" class="easyui-validatebox inputxtext " maxlength="30" style="width:200px;" 
			data-options="required:false,validType:['phone'],tipPosition:'left'" onblur="checkLxdh('lxdh','ryid')"   />
				</td>
			</tr>
			<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">组织名称：</td>
			<td width="30%" class="dialogTd"><input type="text" id="zzmc" name="zzmc" value="${entity.zzmc}" maxlength="100" 
				class="easyui-validatebox inputxtext " style="width:200px;" data-options="required:false"   /></td>
			<td width="20%" class="dialogTd" align="right">组织类别：</td>
			<td width="30%" class="dialogTd"><input type="text" id="zzlb" name="zzlb" value="保安组织" maxlength="20" 
				class="easyui-validatebox inputreadonly " style="width:200px;" data-options="required:false"  readonly="readonly"/></td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">组织形式：</td>
				<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text"  id="zzxsdm" name="zzxsdm" style="width:200px;" value="${entity.zzxsdm}"
					data-options="url: contextPath + '/common/dict/D_ZAFF_BAZZXS.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
					required:false,tipPosition:'right'"/></td>
				<td width="20%" class="dialogTd" align="right">地域类别：</td>
			<td width="30%" class="dialogTd" ><input class="easyui-combobox" type="text"  id="dylbdm" name="dylbdm" style="width:200px;" value="${entity.dylbdm}"
					data-options="url: contextPath + '/common/dict/D_ZAFF_DYLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
					required:false,tipPosition:'right'"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">责任范围：</td>
				<td width="80%" class="dialogTd" colspan="3">
				<input type="text" id="zrfw" name="zrfw" value="${entity.zrfw}" maxlength="100" 
				class="easyui-validatebox inputxtext " style="width:619px;" data-options="required:false"   />
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">装备配置情况：</td>
			<td width="30%" class="dialogTd" colspan="3">
			<input type="text" id="zbpbqk" name="zbpbqk" value="${entity.zbpbqk}" maxlength="100" 
				class="easyui-validatebox inputxtext " style="width:619px;" data-options="required:false"   />
				</td>
			</tr>
			<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">保安组织地址：</td>
			 <td width="50%" class="dialogTd" colspan="2">
				  <input class="easyui-combobox" id="jzd1" style="width:400px;" value="${entity.bazzdzdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='bazzdzmlpdm' id="bazzdzmlpdm" value="${entity.bazzdzmlpdm}"/>
				    	<input type='hidden' name='bazzdzdzmlpxz' id="bazzdzdzmlpxz" value="${entity.bazzdzdzmlpxz}"/>
				  </td>
				<td width="30%" class="dialogTd" >
				<input class="easyui-combobox" id="jzd2" style="width:200px;" value='${fn:replace(entity.bazzdzdzxz, entity.bazzdzdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				<input type="hidden" name="bazzdzdm" id="bazzdzdm" value="${entity.bazzdzdm}"/>
				<input type="hidden" name="bazzdzssxdm" id="bazzdzssxdm" value="${entity.bazzdzssxdm}"/>
			    <input type='hidden' name='bazzdzdzxz' id="bazzdzdzxz" value="${entity.bazzdzdzxz}"/>
				</td>
			</tr>

			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">隶属关系：</td>
				<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text"  id="lsgxdm" name="lsgxdm" style="width:200px;" value="${entity.lsgxdm}"
					data-options="url: contextPath + '/common/dict/D_ZAFF_LSGX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
					required:false,tipPosition:'right'"/></td>
				<td width="20%" class="dialogTd" align="right">经费来源：</td>
			<td width="30%" class="dialogTd" >
				<input type="text" id="jfly" name="jfly" value="${entity.jfly}" maxlength="50" 
				class="easyui-validatebox inputxtext " style="width:200px;" data-options="required:false"   />
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">作用情况：</td>
				<td width="30%" class="dialogTd" colspan="3">
				<input type="text" id="zyqk" name="zyqk" value="${entity.zyqk}" maxlength="100" 
				class="easyui-validatebox inputxtext " style="width:619px;" data-options="required:false"   /></td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">是否治安承包：</td>
			<td width="30%" class="dialogTd" >
			<input class="easyui-combobox" type="text"  id="sfzacbdm" name="sfzacbdm" style="width:200px;" value="${entity.sfzacbdm}"
					data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
					required:false,tipPosition:'right'"/></td>
			<td width="20%" class="dialogTd" align="right">组建日期：</td>
				<td width="30%" class="dialogTd"><input type="text" name="zjrq" id="zjrq" class="easyui-validatebox " style="width: 200px;" value="${entity.zjrq}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" 
					onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" /></td>
			</tr>
			<tr class="dialogTr">
				
				<td width="20%" class="dialogTd" align="right">组织联系方式：</td>
			<td width="30%" class="dialogTd" >
			<input type="text" id="zzlxfs" name="zzlxfs" value="${entity.zzlxfs}" class="easyui-validatebox inputxtext " maxlength="30" style="width:200px;" 
			data-options="required:false,validType:['phone'],tipPosition:'left'"    />
				</td>
				<td width="20%" class="dialogTd" align="right">组织传真号码：</td>
				<td width="30%" class="dialogTd"><input type="text" id="zzczhm" name="zzczhm" value="${entity.zzczhm}"
				 class="easyui-validatebox inputxtext " maxlength="30" style="width:200px;" 
			data-options="required:false,validType:['phone'],tipPosition:'left'"    /></td>
			</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">所属单位：</td>
		    	<td width="30%" class="dialogTd" colspan="3"><input type="text" id="ssdw" name="ssdw" value="${entity.ssdw}" maxlength="50" 
				class="easyui-validatebox inputxtext " style="width:200px;" data-options="required:false"   /></td>
	    	</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz"  id="bz"  maxlength="1000" class="easyui-validatebox" style="width: 619px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea></td>
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

function beforeSubmit() {

}


function afterSubmit(arr) {
	if (arr["saveID"]) {
		$("#pk").val(arr["saveID"]);
		$(_p).find("input[name='id']").val($("#pk").val());
	}
	setFormDataToSpan($("body"),_p);
	
	var e = _p;
	while (e = e.parent()) {
		if (e.is("body")) {
			break;
		}
	}
	if (e) {
		var formdata = $(e).find("#formPara").val() + ',"bazzid":"'+ arr["saveID"] +'"';
		$(e).find("#formPara").val(formdata);
		window.parent.infoPara["add_childInfo_iframePara"] = "{"+$(e).find("#formPara").val()+"}";
	}
	
}

var _zjhm = "";
$(document).ready(function(){
	$("#fzrzjhm").bind("blur",function(e){	check();});
	initAddressSearch('jzd1', {}, 'bazzdzmlpdm', 'bazzdzdzmlpxz', 'jzd2', {text:'bazzdzdzxz',dzxzqh:'bazzdzssxdm',id:'bazzdzdm'}, null, null);
	if(typeof ($("#zjlx").combo("getValue")) == "undefined"){
		$("#zjlx").combobox("setValue","111");
	}
});
/**根据证件类型 设置证件号码验证 与人员基本信息只读状态*/
function setPassPort(newVal,oldVal){
	if(newVal==""){
		$("#fzrzjhm").validatebox({validType:null});
		return;
	}
	if(oldVal!=""){
		$("#fzrzjhm").val("");
	}
	if(!newVal){
		return;
	}
	
	if(newVal=="111"||newVal=="112"||newVal=="335"){
		$("#fzrzjhm").validatebox({validType:['sfzh']});
	}else {
		$("#fzrzjhm").validatebox({validType:['maxLength[30]']});
	}
}
/**
 * 根据证件类型与号码 ，进行人员比对，复用
 */
function check(){
	if(!$("#zjlx").combo("isValid")){
		return;
	}
	if(!$("#fzrzjhm").validatebox("isValid")){
		return;
	}
	
	if($("#fzrzjhm").val() == _zjhm){
		return;
	}
	$(".lodingimg").show();
	$.ajax({
		type:"POST",
		url:contextPath+"/ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#fzrzjhm").val()+"&cyzjdm="+$("#zjlx").val(),
		success:function(data){
			if (data && data.ryRyjbxxb) {
				$("#xm").val(data.ryRyjbxxb.xm);
				$("#ryid").val(data.ryRyjbxxb.id);
				if(data.ryRyjbxxb.xm != ""){
					setInputReadonly("xm", true);
				}
			}
		},
		complete:function(){
			_zjhm = $("#fzrzjhm").val();
			$('#dataForm').form('validate');
			$(".lodingimg").hide();
		}
	});
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