<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>社区民警信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>sqmjxxb/saveSqmjxxb" id="dataForm" name="dataForm" method="post">
    	
    
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			
    		<input type="hidden" name="id" id="pk" value="${entity.id}" />
    		<input type="hidden" name="sqjwsid" value="${entity.sqjwsid}" />
    		<input type="hidden" name="ryid" id="ryid" value="${entity.ryid}" />
    		<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">常用证件：</td>
				<td width="30%" class="dialogTd"><input type="text" name="cyzjdm" id="zjlx"  value="${entity.cyzjdm }" class="easyui-combobox " style="width:200px;"
	    		data-options="required:true,url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right',onChange:setPassPort" /></td> 
				<td width="20%" class="dialogTd" align="right">证件号码：</td>
				<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox" type="text" id="zjhm" name="zjhm" style="width:200px;float:left;" value="${entity.zjhm }" maxlength="30" 
		    		data-options="required:true,tipPosition:'left'" /><div class="lodingimg" id="yrjbxxDiv"></div></td>
			</tr>
			<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">姓名：</td>
				<td width="30%" class="dialogTd"><input type="text" name="xm" id="xm" value="${entity.xm}" 
				class="easyui-validatebox " data-options="required:false,validType:['maxLength[10]'],tipPosition:'right'" style="width:200px;"  /></td>
			<td width="20%" class="dialogTd" align="right">警号：</td>	
			<td width="30%" class="dialogTd"><input type="text" name="jh" id="jh" value="${entity.jh}" maxlength="6"
				class="easyui-validatebox "  data-options="required:false,validType:['letterOrNum'],tipPosition:'left'" style="width:200px;"  /></td>
			</tr>
			<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">性别：</td>
			<td width="30%" class="dialogTd"><input type="text" name="xbdm" id="xb" value="${entity.xbdm}" class="easyui-combobox " style="width:200px;"
						data-options="required:false,url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',
						tipPosition:'right',selectOnNavigation:false,method:'get'"  /></td>
			<td width="20%" class="dialogTd" align="right">出生日期：</td>
			<td width="30%" class="dialogTd"><input type="text" name="csrq" id="csrq" value="${entity.csrq}" class="easyui-validatebox"   onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" style="width:200px;"
					data-options="required:false,tipPosition:'left',validType:['date[\'yyyy-MM-dd\']']" /></td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">民族：</td>
				<td width="30%" class="dialogTd"><input type="text" name="mzdm" id="mzdm" value="${entity.mzdm}" class="easyui-combotree "  style="width:200px;" 
					data-options="required:false,tipPosition:'right',url: contextPath + '/common/dict/D_BZ_MZ.js',onlyLeaf:true,panelWidth:280,multiple:false,method:'get',
					editable:true,lines:true" /></td>
				<td width="20%" class="dialogTd" align="right">联系电话：</td>
			<td width="30%" class="dialogTd" >
			<input type="text" id="lxdh" name="lxdh" value="${entity.lxdh}" class="easyui-validatebox inputxtext " maxlength="18" style="width:200px;" 
			data-options="required:false,validType:['phone'],tipPosition:'left'" onblur="checkLxdh('lxdh','ryid')"   />
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">文化程度：</td>
				<td width="30%" class="dialogTd">
				<input type="text" name="whcddm" id="whcddm" value="${entity.whcddm}" class="easyui-combotree "  style="width:200px;" 
					data-options="required:false,tipPosition:'right',url: contextPath + '/common/dict/D_BZ_WHCD.js',onlyLeaf:true,panelWidth:280,multiple:false,method:'get',editable:true,lines:true"
				 /></td>
				<td width="20%" class="dialogTd" align="right">政治面貌：</td>
			<td width="30%" class="dialogTd" >
			<input type="text" name="zzmmdm" id="zzmmdm" value="${entity.zzmmdm}" class="easyui-combobox "  style="width:200px;" 
					data-options="required:false,url: contextPath + '/common/dict/D_BZ_ZZMM.js',valueField:'id',textField:'text',
						tipPosition:'left',selectOnNavigation:false,method:'get'" />
				</td>
			</tr>
		   <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">婚姻状况：</td>
				<td width="30%" class="dialogTd"><input type="text" name="hyzkdm" id="hyzkdm" value="${entity.hyzkdm}" class="easyui-combobox "  style="width:200px;" 
					data-options="required:false,url: contextPath + '/common/dict/D_BZ_HYZK.js',valueField:'id',textField:'text',
						tipPosition:'right',selectOnNavigation:false,method:'get'" /></td>
				<td width="20%" class="dialogTd" align="right">血型：</td>
			<td width="30%" class="dialogTd" >
			<input type="text" name="xxdm" id="xxdm" value="${entity.xxdm}" class="easyui-combobox "  style="width:200px;" 
					data-options="required:false,url: contextPath + '/common/dict/D_BZ_XX.js',valueField:'id',textField:'text',
						tipPosition:'left',selectOnNavigation:false,method:'get'" />
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">健康状况：</td>
				<td width="30%" class="dialogTd"><input type="text" name="jkzkdm" id="jkzkdm" value="${entity.jkzkdm}" class="easyui-combobox "  style="width:200px;" 
					data-options="required:false,url: contextPath + '/common/dict/D_RK_JKZK.js',valueField:'id',textField:'text',
						tipPosition:'right',selectOnNavigation:false,method:'get'" /></td>
				<td width="20%" class="dialogTd" align="right">参加工作日期：</td>
			<td width="30%" class="dialogTd" ><input type="text" name="cjgzrq" id="cjgzrq" class="easyui-validatebox " style="width: 200px;" value="${entity.cjgzrq}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" 
					onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" />
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">入警日期：</td>
				<td width="30%" class="dialogTd"><input type="text" name="cjgagzrq" id="cjgagzrq" class="easyui-validatebox " style="width: 200px;" value="${entity.cjgagzrq}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
					onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',minDate:'#F{$dp.$D(\'cjgzrq\') }'})" /></td>
				<td width="20%" class="dialogTd" align="right">任职日期：</td>
				<td width="30%" class="dialogTd" >
				<input  type='text' id='rzrq' name='rzrq' class="easyui-validatebox" style="width:200px;"
				 maxlength="50" value="${entity.rzrq}" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">任职机构名称：</td>
				<td width="30%" class="dialogTd" >
				<input type="text" id="rzjgmc" name="rzjgmc" value="${entity.rzjgmc}" maxlength="100" 
				class="easyui-validatebox inputxtext " style="width:200px;" data-options="required:false,tipPosition:'right'"   /></td>
				<td width="20%" class="dialogTd" align="right">警衔：</td>
			<td width="30%" class="dialogTd" >
			<input type="text" id="jx" name="jx" value="${entity.jx}" maxlength="20" 
				class="easyui-combobox"style="width:200px;" data-options="required:false,url: contextPath + '/common/dict/D_RK_JX.js',valueField:'id',textField:'text',
						tipPosition:'right',selectOnNavigation:false,method:'get'"   /></td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">岗位：</td>
				<td width="30%" class="dialogTd"><input type="text" name="gwdm" id="gwdm" value="${entity.gwdm}" class="easyui-combobox"  style="width:200px;" 
					data-options="required:false,url: contextPath + '/common/dict/D_RK_GW.js',valueField:'id',textField:'text',
						tipPosition:'right',selectOnNavigation:false,method:'get'" /></td>
				<td width="20%" class="dialogTd" align="right">职务：</td>
			<td width="30%" class="dialogTd" >
			<input type="text" id="zw" name="zw" value="${entity.zw}" maxlength="30" 
				class="easyui-validatebox inputxtext " style="width:200px;" data-options="required:false,tipPosition:'left'"   />
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">职级：</td>
				<td width="30%" class="dialogTd"><input type="text" name="zjdm" id="zjdm" value="${entity.zjdm}" class="easyui-combobox "  style="width:200px;" 
					data-options="required:false,url: contextPath + '/common/dict/D_RK_ZJ.js',valueField:'id',textField:'text',
						tipPosition:'right',selectOnNavigation:false,method:'get'" /></td>
				<td width="20%" class="dialogTd" align="right">警种：</td>
			<td width="30%" class="dialogTd" >
			<input type="text" name="jzdm" id="jzdm" value="${entity.jzdm}" class="easyui-combobox "  style="width:200px;" 
					data-options="required:false,url: contextPath + '/common/dict/D_RK_JZ.js',valueField:'id',textField:'text',
						tipPosition:'left',selectOnNavigation:false,method:'get'" />
				</td>
			</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">社区兼任职务描述：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input type="text" id="sqjrzwms" name="sqjrzwms" value="${entity.sqjrzwms}" maxlength="100" 
				class="easyui-validatebox inputxtext " style="width:618px;" data-options="required:false,validType:['maxLength[100]'],tipPosition:'left'"   />
	    	</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">警员状态：</td>
				<td width="30%" class="dialogTd"><input type="text" name="jyztdm" id="jyztdm" value="${entity.jyztdm}" class="easyui-combobox "  style="width:200px;" 
					data-options="required:false,url: contextPath + '/common/dict/D_RK_JKZK.js',valueField:'id',textField:'text',
						tipPosition:'right',selectOnNavigation:false,method:'get'" /></td>
				<td width="20%" class="dialogTd" align="right">登录帐号：</td>
			<td width="30%" class="dialogTd" >
			<input type="text" id="dlzh" name="dlzh" value="${entity.dlzh}" maxlength="18" 
				class="easyui-validatebox inputxtext " style="width:200px;" data-options="required:false,tipPosition:'left',validType:['letterOrNum']"   />
				</td>
			</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz"  id="bz"  maxlength="1000" class="easyui-validatebox" style="width: 620px; height:48px;"
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
	if( "${entity.xm}"!= ""){
		setInputReadonly("xm", true);
	}
	if("${entity.csrq}" != ""){
		setInputReadonly("csrq", true);
	}
	if("${entity.xbdm}"!= ""){
		setInputReadonly("xb", true);
	}
	if("${entity.mzdm}"!= ""){
		setInputReadonly("mzdm", true);
	}
}

function beforeSubmit() {
}

function afterSubmit(arr) {
	if (arr["saveID"]) {
		$("#pk").val(arr["saveID"]);
		$(_p).find("input[name='id']").val($("#pk").val());
	}
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

var _zjhm = "";
$(document).ready(function(){
	$("#zjhm").bind("blur",function(e){	check();});
	if(typeof ($("#zjlx").combo("getValue")) == "undefined"){
		$("#zjlx").combobox("setValue","111");
	}
});
/**根据证件类型 设置证件号码验证 与人员基本信息只读状态*/
function setPassPort(newVal,oldVal){
	if(newVal==""){
		$("#zjhm").validatebox({validType:null});
		return;
	}
	if(oldVal!=""){
		$("#zjhm").val("");
	}
	if(!newVal){
		return;
	}
	
	if(/^11\d{1}$/g.test(newVal)){
		if(!/^11\d{1}$/g.test(oldVal))
			$("#jg").combotree('reload', contextPath + '/common/dict/D_BZ_XZQH.js');
	}else if(/^11\d{1}$/g.test(oldVal)){
		$("#jg").combotree('reload', contextPath + '/common/dict/D_BZ_GJDQ.js');
	}
	if(newVal=="111"||newVal=="335"||newVal=="112"){
		$("#zjhm").validatebox({validType:['sfzh']});

	}else {
		$("#zjhm").validatebox({validType:['maxLength[30]']});
	}
	
}
/**
 * 根据证件类型与号码 ，进行人员比对，复用
 */
function check(){
	clearValue();
	if(!$("#zjlx").combo("isValid")){
		return;
	}
	if(!$("#zjhm").validatebox("isValid")){
		//$("#zjhm").focus();
		return;
	}
	
	if($("#zjhm").val() == _zjhm){
		return;
	}
	$(".lodingimg").show();
	$.ajax({
		type:"POST",
		url:contextPath+"/ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#zjhm").val()+"&cyzjdm="+$("#zjlx").val(),
		success:function(data){
		if (data && data.ryRyjbxxb) {
			$("#xm").val(data.ryRyjbxxb.xm);
			$("#ryid").val(data.ryRyjbxxb.id);
			$("#xb").combobox("setValue",data.ryRyjbxxb.xbdm);		
			$("#whcddm").combotree("setValue",data.ryRyjbxxb.xldm);
			$("#csrq").val(formatDate(data.ryRyjbxxb.csrq));
			$("#mzdm").combotree("setValue",data.ryRyjbxxb.mzdm);
			if(data.ryRyjbxxb.xm != ""){
				setInputReadonly("xm", true);
			}
			if(data.ryRyjbxxb.csrq != ""){
				setInputReadonly("csrq", true);
			}
			if(data.ryRyjbxxb.xbdm != ""){
				setInputReadonly("xb", true);
			}
			if(data.ryRyjbxxb.mzdm != ""){
				setInputReadonly("mzdm", true);
			}
			$("#csrq").validatebox('validate');
			
		}
		},
		complete:function(){
			_zjhm = $("#zjhm").val();
			$('#dataForm').form('validate');
			$(".lodingimg").hide();
		}
	});
}
function formatDate(str){
	var newdate;
	if(str.length == 8){
		newdate = str.substring(0,4)+"-"+str.substring(4,6)+"-"+str.substring(6);
	}else{
		
	}
	return newdate?newdate:str;
}
function clearValue(){
	$("#xm").val("");
	$("#ryid").val("");
	$("#xb").combobox("setValue","");
	$("#csrq").val("");
	$("#mzdm").combotree("setValue","");
	setInputReadonly("xm", false);
	setInputReadonly("csrq", false);
	setInputReadonly("xb", false);
	setInputReadonly("mzdm", false);
}
</script>