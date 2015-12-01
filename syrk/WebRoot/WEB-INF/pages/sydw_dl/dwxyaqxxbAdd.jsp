<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>校园安全信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwxyaqxxb_dl/save" id="dataForm" name="dataForm" method="post">
    	
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
    	
	    <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<input type="hidden" name="id" id="pk" value="${entity.id}" />
			<input type="hidden" name="jbxx_id" id="jbxx_id"  />
			
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">学校类别：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-combobox" type="text" name="xxlbdm" id="xxlbdm" value="${entity.xxlbdm}" style="width:210px"
					data-options="required:true,url: contextPath + '/common/dict/D_DW_XXLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'" /></td>
		    	<td width="20%" class="dialogTd" align="right">学校隶属关系：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-combobox" type="text" name="xxlsgxdm" id="xxlsgxdm" style="width:210px" value="${entity.xxlsgxdm}"
		    		data-options="required:true,url: contextPath + '/common/dict/D_DW_XXLSGX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'" /></td>
		    </tr>		    
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">办公电话：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="bbdh" id="bbdh" style="width:210px" value="${entity.bbdh}" 
		    	data-options="validType:'phone',tipPosition:'right'" maxlength="18"/></td>
		    	<td width="20%" class="dialogTd" align="right">校门数量：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" name="xmsl" id="xmsl" value="${entity.xmsl}" style="width:210px" maxlength="12" 
		    	data-options="validType:'naturalNumber',tipPosition:'left'"/></td>
		    </tr>
		     <tr>	    
				<td width="20%" class="dialogTd" align="right">学校人数：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" name="xxrs" id="xxrs" value="${entity.xxrs}" style="width:210px" maxlength="12" data-options="validType:'naturalNumber',tipPosition:'left'"/></td>
		    	<td width="20%" class="dialogTd" align="right">校车接送学生数量：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" name="xcjsxssl" id="xcjsxssl" value="${entity.xcjsxssl}" style="width:210px" maxlength="12" 
		    	data-options="validType:'naturalNumber',tipPosition:'left'"/></td>
			</tr>	
			 <tr>	    
				<td width="20%" class="dialogTd" align="right">学校安保负责人证件类型：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-combobox" type="text" name="xxabfzrzjlx" id="xxabfzrzjlx" value="${entity.xxabfzrzjlx}" style="width:210px" maxlength="3" 
		    	data-options="required:true,url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left',onChange:bafzrzjhmCheck"/></td>
		    	<td width="20%" class="dialogTd" align="right">学校安保负责人证件号码：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" name="xxabfzrzjhm" id="xxabfzrzjhm" value="${entity.xxabfzrzjhm}" style="width:210px" maxlength="30" 
		    	data-options="required:true,tipPosition:'left'"/><div class="lodingimg" id="zjhmLoadDiv"></div></td>
			</tr>	
			 <tr>	    
				<td width="20%" class="dialogTd" align="right">学校安保负责人姓名：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" name="xxabfzrxm" id="xxabfzrxm" value="${entity.xxabfzrxm}" style="width:210px" maxlength="50" data-options="required:true,tipPosition:'left'"/></td>
		    	<td width="20%" class="dialogTd" align="right">学校安保负责人电话：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" name="xxabfzrdh" id="xxabfzrdh" value="${entity.xxabfzrdh}" style="width:210px" maxlength="18" 
		    	data-options="required:true,validType:'phone',tipPosition:'left'"  onblur="checkLxdh('xxabfzrdh','jbxx_id')"/></td>
			</tr>	
			 <tr>	    
				<td width="20%" class="dialogTd" align="right">法制副校长证件类型：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-combobox" type="text" name="fzfxzzjlx" id="fzfxzzjlx" value="${entity.fzfxzzjlx}" style="width:210px" maxlength="3" 
		    	data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left',
		    		onChange:fxzzjhamCheck"
		    	/></td>
		    	<td width="20%" class="dialogTd" align="right">法制副校长证件号码：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" name="fzfxzzjhm" id="fzfxzzjhm" value="${entity.fzfxzzjhm}" style="width:210px" maxlength="30" 
		    	data-options="tipPosition:'left'"/><div class="lodingimg" id="fxzLoadDiv"></td>
			</tr>
			 <tr>	    
				<td width="20%" class="dialogTd" align="right">法制副校长姓名：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" name="fzfxzxm" id="fzfxzxm" value="${entity.fzfxzxm}" style="width:210px" maxlength="50" 
		    	data-options="tipPosition:'left'"/></td>
		    	<td width="20%" class="dialogTd" align="right">法制副校长电话：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" name="fzfxzdh" id="fzfxzdh" value="${entity.fzfxzdh}" style="width:210px" maxlength="18" 
		    	data-options="validType:'phone',tipPosition:'left'"/></td>
			</tr>
			 <tr>	    
				<td width="20%" class="dialogTd" align="right">校园警务室民警姓名：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" name="xyjwsmjxm" id="xyjwsmjxm" value="${entity.xyjwsmjxm}" style="width:210px" maxlength="50" 
		    	data-options="tipPosition:'left'"/></td>
		    	<td width="20%" class="dialogTd" align="right">校园警务室民警电话：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" name="xyjwsmjdh" id="xyjwsmjdh" value="${entity.xyjwsmjdh}" style="width:210px" maxlength="18" 
		    	data-options="validType:'phone',tipPosition:'left'"/></td>
			</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">宿舍情况：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" name="ssqk" id="ssqk"  value="${entity.ssqk}" data-options="tipPosition:'left'" maxlength="300" style="width:640px;" /></td>
		    </tr>	
			 <tr>	    
				<td width="20%" class="dialogTd" align="right">安全等级：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-combobox" type="text" name="aqdj" id="aqdj" value="${entity.aqdj}" style="width:210px" maxlength="1" 
		    	data-options="url: contextPath + '/common/dict/D_DW_AQDJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
		    	<td width="20%" class="dialogTd" align="right">有无许可：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-combobox" type="text" name="ywxkdm" id="ywxkdm" value="${entity.ywxkdm}" style="width:210px" maxlength="32" 
		    	data-options="url: contextPath + '/common/dict/D_BZ_YW.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
			</tr>
		    <tr>	    
				<td width="20%" class="dialogTd" align="right">是否签订安全责任状：</td>
		    	<td width="30%" class="dialogTd" ><input class="easyui-combobox" type="text" name="sfqdaqzrzdm" id="sfqdaqzrzdm" value="${entity.sfqdaqzrzdm}" style="width:210px" maxlength="32"
		    	 data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
		    	</tr>
			</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
var _p;
$(document).ready(function(){
	if ($("#xxabfzrzjlx").combobox('getValues') == "") {
		$("#xxabfzrzjlx").combobox('setValue', '111'); // 认为居民身份证
		//$('#xxabfzrzjhm').validatebox({validType:['sfzh']});
	}
	if ($("#fzfxzzjlx").combobox('getValues') == "") {
		$("#fzfxzzjlx").combobox('setValue', '111'); // 认为居民身份证
		//$('#fzfxzzjlx').validatebox({validType:['sfzh']});
	}
	$("#xxabfzrzjhm").bind("blur",function(e){	
		checkZjhm('xxabfzrzjhm');
	});
	$("#fzfxzzjhm").bind("blur",function(e){	
		checkZjhm('fzfxzzjhm');
	});

	bafzrzjhmCheck($("#xxabfzrzjlx").combobox('getValues'),"");
	fxzzjhamCheck($("#fzfxzzjlx").combobox('getValues'),"");
});

//副校长
function fxzzjhamCheck(newValue, oldValue){
	if(newValue==""){
		$("#fzfxzzjhm").validatebox({validType:null});
		return;
	}
	if (!newValue) {
		return;
	}
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue=="112" || newValue == "335"){ 
		$("#fzfxzzjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#fzfxzzjhm").validatebox({validType:['maxLength[30]']});
	}
	  
}
//验证证件号码
function bafzrzjhmCheck(newValue, oldValue){
	if(newValue==""){
		$("#xxabfzrzjhm").validatebox({validType:null});
		return;
	}
	if (!newValue) {
		return;
	}
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue=="112" || newValue == "335"){ 
		$("#xxabfzrzjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#xxabfzrzjhm").validatebox({validType:['maxLength[30]']});
	}
	  
}
/**
 * 根据证件类型与号码 ，进行人员比对，复用
 */
function checkZjhm(type) {
	var zjhm="";
	var cyzjdz="";
	if(type=='xxabfzrzjhm'){
		
		if (!$("#xxabfzrzjlx").combo("isValid")){
			return;
		}
		if (!$("#xxabfzrzjhm").validatebox("isValid")){
			return;
		}
		zjhm=$("#xxabfzrzjhm").val();
		cyzjdz=$("#xxabfzrzjlx").val();
		$("#zjhmLoadDiv").show();
	}else if(type=='fzfxzzjhm'){
		if (!$("#fzfxzzjlx").combo("isValid")){
			return;
		}
		if (!$("#fzfxzzjhm").validatebox("isValid")){
			return;
		}
		zjhm=$("#fzfxzzjhm").val();
		cyzjdz=$("#fzfxzzjlx").val();
		if(zjhm==null||zjhm==""){
			return;
			}
		
			$("#fxzLoadDiv").show();
		}
	$.ajax({
		type:"POST",
		url:"<%=basePath%>syrkgl/getSyrk",
		dataType:"json",
		data:"zjhm="+zjhm+"&cyzjdm="+cyzjdz,
		success:function(data) {
			if (data && data.ryjbxxb) {
				$("#jbxx_id").val(data.ryjbxxb.id);
				if(type=='xxabfzrzjhm'){
				$("#xxabfzrxm").val(data.ryjbxxb.xm);
				$('#xxabfzrxm').validatebox('validate')
				$("#xxabfzrdh").val(data.ryjbxxb.lxdh);
				$('#xxabfzrdh').validatebox('validate')
				}else if(type=='fzfxzzjhm'){
					$("#fzfxzxm").val(data.ryjbxxb.xm);
					$('#fzfxzxm').validatebox('validate')
					$("#fzfxzdh").val(data.ryjbxxb.lxdh);
					$('#fzfxzdh').validatebox('validate')
					}
			}
			else {
				$("#jbxx_id").val("");
				if(type=='xxabfzrzjhm'){
				$("#xxabfzrxm").val("");
				$("#xxabfzrdh").val("");
				}else if(type=='fzfxzzjhm'){
					$("#fzfxzxm").val("");
					$("#fzfxzdh").val("");
				}
			}
		},
		complete:function() {
			if(type=='xxabfzrzjhm'){
			$("#zjhmLoadDiv").hide();
			}else if(type=='fzfxzzjhm'){
				$("#fxzLoadDiv").hide();
			}
		},
		error:function() {
		}
	});	
}

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