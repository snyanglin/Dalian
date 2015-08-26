<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>社区基本信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
   <form action="<%=basePath%>sqjbxxb/saveSqjbxxb" id="dataForm" name="dataForm" method="post">
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<input type="hidden" name="sqjwsid" value="${entity.sqjwsid}" />
				
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">社区名称：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="sqmc" name="sqmc" style="width:200px;" value="${entity.sqmc}" maxlength="50"
			    		data-options="required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">办公室电话：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="bgsdh" name="bgsdh" style="width:200px;" value="${entity.bgsdh}" maxlength="18"
			    		data-options="required:false,validType:['phone'],tipPosition:'left'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">社区地址：</td>
					<td width="50%" class="dialogTd" colspan="2">
						<input class="easyui-combobox" id="sqdz1" style="width:400px;" value="${entity.dz_sqdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
			    		<input type='hidden' name='dz_sqdzmlpdm' id="sqdz_sqdzmlpdm" value="${entity.dz_sqdzmlpdm}"/>
			    		<input type='hidden' name='dz_sqdzmlpxz' id="sqdz_sqdzmlpxz" value="${entity.dz_sqdzmlpxz}"/>
		    		</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox" id="sqdz2" style="width:200px;" value="${fn:replace(entity.dz_sqdzxz, entity.dz_sqdzmlpxz, '')}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_sqdzdm' id='sqdz_sqdzdm' value="${entity.dz_sqdzdm}" />
				    	<input type='hidden' name='dz_sqdzssxdm' id='sqdz_sqdzssxdm' value="${entity.dz_sqdzssxdm}" />
				    	<input type='hidden' name='dz_sqdzxz' id='sqdz_sqdzxz' value="${entity.dz_sqdzxz}" /> 
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">负责人常用证件：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text" id="sqfzrcyzjdm" name="sqfzrcyzjdm" style="width:200px;" value="${entity.sqfzrcyzjdm}"
						data-options="url:contextPath+'/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,onChange:setPassPort,tipPosition:'right',
										onSelect:function(record){
											$('#sqfzrzjhm').validatebox({required:true});
											if(record.id == '111' || record.id == '112'||record.id == '335'){
												$('#sqfzrzjhm').validatebox({validType:['sfzh']});
											}else{
												$('#sqfzrzjhm').validatebox({validType:null});
											}
										}"/>
					</td>
					<td width="20%" class="dialogTd" align="right">负责人证件号码：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="sqfzrzjhm" name="sqfzrzjhm" style="width:200px;float:left;" value="${entity.sqfzrzjhm}"
						data-options="required:false,tipPosition:'left'" maxlength="30"/><div class="lodingimg" id="yrjbxxDiv"></div>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">负责人姓名：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="sqfzrxm" name="sqfzrxm" style="width:200px;" value="${entity.sqfzrxm}" maxlength="20"
						data-options="required:false,tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">负责人联系方式：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="sqfzrlxdh" name="sqfzrlxdh" style="width:200px;" value="${entity.sqfzrlxdh}" maxlength="20"
						data-options="validType:['phone'],required:false,tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">备注：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="bz" name="bz" style="width: 628px; height:48px;"
						data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',required:false,tipPosition:'left',required:false">${entity.bz}</textarea>
					</td>
		    	</tr>
	    	</table>
	    </div>
    </form>
</div>

</html>
<script type="text/javascript" >

var _zjhm = "";
$(document).ready(function(){
	initAddressSearch('sqdz1', {}, 'sqdz_sqdzmlpdm', 'sqdz_sqdzmlpxz', 'sqdz2', {text:'sqdz_sqdzxz',dzxzqh:'sqdz_sqdzssxdm',id:'sqdz_sqdzdm'}, null, null);
	$("#sqfzrzjhm").bind("blur",function(e){	check();});
	//
	$('#sqfzrzjhm').validatebox({required:true});
	if($('#sqfzrcyzjdm').val() == '111' || $('#sqfzrcyzjdm').val() == '112'||$('#sqfzrcyzjdm').val() == '335'){
		$('#sqfzrzjhm').validatebox({validType:['sfzh']});
	}else{
		$('#sqfzrzjhm').validatebox({validType:null});}
});

function check(){
	if(!$("#sqfzrzjhm").validatebox("isValid")){
		return;
	}

	if($("#sqfzrzjhm").val() == _zjhm){
		return;
	}
	$(".lodingimg").show();
	$.ajax({
		type:"POST",
		url:contextPath+"/ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#sqfzrzjhm").val()+"&cyzjdm=111",
		success:function(data){
		if (data && data.ryRyjbxxb) {
			$("#sqfzrxm").val(data.ryRyjbxxb.xm);
		 	if(data.ryRyjbxxb.xm!=""){setInputReadonly("sqkfzrxm", true);}
		 }
		},
		
		complete:function(){
			_zjhm = $("#sqfzrzjhm").val();
			$('#sqjbxxbForm').form('validate');
			$(".lodingimg").hide();
		}
	});	
}

var _p;
function doInit(paramArray) {
	_p = paramArray["_p"];
}

function beforeSubmit(){}

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
		var formdata = $(e).find("#formPara").val() + ',"sqid":"'+ arr["saveID"] +'"';
		$(e).find("#formPara").val(formdata);
		window.parent.infoPara["add_childInfo_iframePara"] = "{"+$(e).find("#formPara").val()+"}";
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

/**根据证件种类 设置证件号码验证 与人员基本信息只读状态*/
function setPassPort(newVal,oldVal){
	if (!newVal) {
		return;
	}
	if(newVal=="111"||newVal=="112"||newVal=="335"){
		$("#sqfzrzjhm").validatebox({validType:['sfzh']});
	}else {
		$("#sqfzrzjhm").validatebox({validType:['maxLength[30]']});	
	}
	$("#sqfzrzjhm").val("");
	
}
</script>