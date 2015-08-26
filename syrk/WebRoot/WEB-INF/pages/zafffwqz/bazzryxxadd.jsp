<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>保安组织人员信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
<form action="<%=basePath%>bazzryxxb/saveBazzryxxb" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" id="ryid" name="ryid" value="${entity.ryid}">
    	<input type="hidden" name="sqid" id="sqid" value="${entity.sqid}" />
    	<input type="hidden" id="sqjwsid" name="sqjwsid" value="${entity.sqjwsid}">
	    <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<input type="hidden" id="pk" name="id" value="${entity.id}" />
			<input type="hidden" id="bazzid" name="bazzid" value="${entity.bazzid}">
			
			 <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">常用证件种类：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='cyzjdm' name='cyzjdm' class="easyui-combobox" style="width:200px;"
				 data-options="required:true,tipPosition:'right',url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:setPassPort
				 						,onSelect:function(record){
											$('#zjhm').validatebox({required:true});
											if(record.id == 111||record.id == 112||record.id == 335){
												$('#zjhm').validatebox({validType:['sfzh']});
											}else{
												$('#zjhm').validatebox({validType:['maxLength[30]']});
											}
										}" value="${entity.cyzjdm}" /></td>
				<td width="20%" class="dialogTd" align="right">证件号码：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='zjhm' name='zjhm' class="easyui-validatebox" style="width:200px;float:left;"
				maxlength="30" value="${entity.zjhm}" data-options="required:true,tipPosition:'left',charSet:'halfUpper'" /><div class="lodingimg" id="yrjbxxDiv"></div></td>	
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">姓名：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='xm' name='xm' class="easyui-validatebox" style="width:200px;"
				data-options="required:false,tipPosition:'right'" maxlength="20" value="${entity.xm}" /></td>
				<td width="20%" class="dialogTd" align="right">性别：</td>
				<td width="30%" class="dialogTd"><input type="text" name="xbdm" id="xb" value="${entity.xbdm}" class="easyui-combobox " style="width:200px;"
						data-options="required:true,tipPosition:'left',url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'" /></td>	
			</tr>
			 <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">文化程度：</td>
				<td width="30%" class="dialogTd"><input type="text" name="whcddm" id="whcddm" value="${entity.whcddm}" class="easyui-combotree "  style="width:200px;" 
					data-options="required:false,tipPosition:'right',url: contextPath + '/common/dict/D_BZ_WHCD.js',onlyLeaf:true,panelWidth:280,multiple:false,method:'get',editable:true,lines:true"/>
				 </td>
				 <td width="20%" class="dialogTd" align="right">政治面貌：</td>
				<td width="30%" class="dialogTd"><input class='easyui-combobox input_w2' style="width:200px;" type='text' id='zzmmdm'  name='zzmmdm' value="${entity.zzmmdm}" data-options="required:false,tipPosition:'left',url: contextPath + '/common/dict/D_BZ_ZZMM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
				 </tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">联系方式：</td>
				<td width="30%" class="dialogTd" colspan="3"><input  type='text' id='lxfs' name='lxfs' class="easyui-validatebox" style="width:628px;"
				maxlength="50" value="${entity.lxfs}" data-options="required:false,validType:['phone'],tipPosition:'left'" /></td></tr>
			<tr class="dialogTr">
				 <td width="20%" class="dialogTd" align="right">备注：</td>
		    	<td width="80%" class="dialogTd" colspan="3" ><textarea id="bz" name="bz" class="easyui-validatebox" style="width: 628px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea></td>
			</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
function doInit(paramArray) {
	$("#sqid").val(paramArray["sqid"]);
	$("#bazzid").val(parent.$("#bazzid").val());
}
var _zjhm = "";
$(document).ready(function(){
	$("#zjhm").bind("blur",function(e){	check();});
	if(typeof ($("#cyzjdm").combo("getValue")) == "undefined"){
		$("#cyzjdm").combobox("setValue","111");
	}

	
});
/**根据证件种类 设置证件号码验证 与人员基本信息只读状态*/
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
	
	if(newVal=="111"||newVal=="112"||newVal=="335"){
		$("#zjhm").validatebox({validType:['sfzh']});
	}else {
		$("#zjhm").validatebox({validType:['maxLength[30]']});
	}
}
/**
 * 根据证件种类与号码 ，进行人员比对，复用
 */
function check(){
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
		data:"zjhm="+$("#zjhm").val()+"&cyzjdm=111",
		success:function(data){
		if (data && data.ryRyjbxxb) {
			$("#xm").val(data.ryRyjbxxb.xm);
			$("#ryid").val(data.ryRyjbxxb.id);
			$("#xb").combobox("setValue",data.ryRyjbxxb.xbdm);
			$("#zzmmdm").combobox("setValue",data.ryRyjbxxb.zzmmdm);
			$("#whcddm").combotree("setValue",data.ryRyjbxxb.xldm);
			if(data.ryRyjbxxb.xm!=""){setInputReadonly("xm", true);}
		 	if(data.ryRyjbxxb.xbdm!=""){setInputReadonly("xb", true);}
		 	if(data.ryRyjbxxb.zzmmdm!=""){setInputReadonly("zzmmdm", true);}
		 	if(data.ryRyjbxxb.xldm!=""){setInputReadonly("whcddm", true);}
		 }
	
		},
		
		complete:function(){
			_zjhm = $("#zjhm").val();
			$('#dataform').form('validate');
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
function body_onload() {
	$('#dataform').form({  
        onSubmit:function(){
            return $(this).form('validate');  
        },  
        success:function(data){  
            alert(data);  
        }  
    });   
    
} 
// 页面加载完成事件
window.onload = function() {
	body_onload();
}
function beforeSubmit() {
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}
function resetTable(){
	document.forms["dataForm"].reset();
	setInputReadonly("xm",false);
	setInputReadonly("xb",false);
	setInputReadonly("zzmmdm",false);
	setInputReadonly("whcddm",false);
	$("#cyzjdm").combobox("setValue","111");

}
</script>