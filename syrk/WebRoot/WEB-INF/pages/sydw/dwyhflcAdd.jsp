<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@UpdateDate:   [2015-6-3 下午14:31:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>银行分理处</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwyhflcxxb/save" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
    	<input type="hidden" name="flag" id="flag" value="${flag}" />
	    <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<tr class="dialogTr">
			    	<td width="25%" class="dialogTd" align="right">分理处名称：</td>
			    	<td width="75%" class="dialogTd" colspan='3'>
			    		<input class="easyui-validatebox" type="text" name="flcmc" id="flcmc" maxlength="50"
			    		data-options="required:true,validType:['maxLength[50]'],invalidMessage:'分理处名称不能超过50个汉字，请重新输入！',tipPosition:'left'"
			    		style="width:613px;" value="${entity.flcmc}"/>
			    	</td>
			    </tr>	
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">经营地址：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
					  	<input class="easyui-combobox" id="jyd1" style="width:400px;" value="${entity.dz_jydzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_jydzmlpdm' id="dz_jydzmlpdm" value="${entity.dz_jydzmlpdm}"/>
				    	<input type='hidden' name='dz_jydzmlpxz' id="dz_jydzmlpxz" value="${entity.dz_jydzmlpxz}"/>
					 </td>
			    	<td width="30%" class="dialogTd" >
						<input class="easyui-combobox" id="jyd2" style="width:200px;" value='${fn:replace(entity.dz_jydzxz, entity.dz_jydzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						<input type="hidden" name="dz_jydzdm" id="dz_jydzdm" value="${entity.dz_jydzdm}"/>
						<input type="hidden" name="dz_jydzxzqhdm" id="dz_jydzxzqhdm" value="${entity.dz_jydzxzqhdm}"/>
					    <input type='hidden' name='dz_jydzxz' id="dz_jydzxz" value="${entity.dz_jydzxz}"/>
					</td>
		    	</tr>		
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">主营：</td>
					<td width="80%" class="dialogTd" colspan='3'>
						<textarea id="zy" name="zy" class="easyui-validatebox" style="width:613px; height:48px;" maxlength="200"
						data-options="required:true,validType:['maxLength[200]'],invalidMessage:'主营不能超过200个汉字，请重新输入！',tipPosition:'left'">${entity.zy}</textarea>
					</td>
				 </tr>	
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">副营：</td>
					<td width="80%" class="dialogTd" colspan='3'>
						<textarea id="fy" name="fy" class="easyui-validatebox" style="width:613px; height:48px;"  maxlength="200"
						data-options="validType:['maxLength[200]'],invalidMessage:'副营不能超过200个汉字，请重新输入！',tipPosition:'left'">${entity.fy}</textarea>
					</td>
				 </tr>	
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">负责人证件种类：</td>
			    	<td width="30%" class="dialogTd" >
			    		<input class="easyui-combobox" type="text" name="fzrcyzjdm" id="fzrcyzjdm"
			    		data-options="required:false,url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left',onChange:setPassPort,
			    		onSelect:function(record){
							if(record.id==111||record.id==112||record.id==335){
								$('#fzrzjhm').validatebox({validType:['sfzh']});
							}else {
								$('#fzrzjhm').validatebox({validType:['maxLength[30]']});
							}
						}" style="width:200px" value="${entity.fzrcyzjdm}"/>
					</td>
					<td width="20%" class="dialogTd" align="right">负责人证件号码：</td>
			    	<td width="30%" class="dialogTd" >
			    		<input class="easyui-validatebox" type="text" name="fzrzjhm" id="fzrzjhm"
						data-options="required:false,validType:['maxLength[30]'],tipPosition:'left'" value="${entity.fzrzjhm}" maxlength="30"
			    	 	style="width:200px;float:left;" /><div class="lodingimg" id="jjlxrDiv" ></div>
			    	 </td>
			    </tr>	
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">联系电话：</td>
			    	<td width="30%" class="dialogTd" >
			    		<input class="easyui-validatebox" type="text" name="flclxdh" id="flclxdh" value="${entity.flclxdh}" maxlength="18"
			    		data-options="required:false,validType:['phone']" 
			    		style="width:200px" onblur="checkLxdh('flclxdh','ryid')" />
			    	</td>
			    	<td width="20%" class="dialogTd" align="right">负责人姓名：</td>
			    	<td width="30%" class="dialogTd" >
			    		<input class="easyui-validatebox" type="text" name="fzr" id="fzr"
			    		data-options="required:false,validType:['maxLength[20]'],tipPosition:'left'" value="${entity.fzr}" maxlength="20" style="width:200px" /></td>
			    </tr>	
	
				<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">负责人联系电话：</td>
			    	<td width="30%" class="dialogTd" >
			    		<input class="easyui-validatebox" type="text" name="fzrlxdh" id="fzrlxdh" maxlength="18"
			    		data-options="required:false,validType:['phone'],tipPosition:'right'" value="${entity.fzrlxdh}" 
			    	 	style="width:200px" />
			    	</td>
					<td width="20%" class="dialogTd" align="right">负责人职务：</td>
			    	<td width="30%" class="dialogTd" >
			    		<input class="easyui-validatebox" type="text" name="fzrzw" id="fzrzw"
			    		data-options="required:false,validType:['maxLength[20]'],tipPosition:'left'" value="${entity.fzrzw}" maxlength="20"
			    	 	style="width:200px"/>
			    	 </td>
			    </tr>	
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
function beforeSubmit() {
}
var _zjhm = "";
$(document).ready(function(){
	var flag = document.getElementById("flag").value;
	if(flag=="update"){
	}else {
		$("#fzrcyzjdm").combobox("setValue","111");
	}
	
	$("#fzrzjhm").bind("blur",function(e){	check();});
	initAddressSearch('jyd1', {}, 'dz_jydzmlpdm', 'dz_jydzmlpxz', 'jyd2', {text:'dz_jydzxz',dzxzqh:'dz_jydzxzqhdm',id:'dz_jydzdm'}, null, null);
	
});
/**根据证件种类 设置证件号码验证 与人员基本信息只读状态*/
function setPassPort(newVal,oldVal){
	if (!newVal) {
		return;
	}
	if(newVal=="111"||newVal=="112"||newVal=="335"){
		$("#fzrzjhm").validatebox({validType:['sfzh']});
	
	}else{
		$("#fzrzjhm").validatebox({validType:['maxLength[30]']});
	}
	clearRyjbxx();
	$("#fzrzjhm").val("");
	_zjhm = "";
	
}

/**
 * 根据证件种类与号码 ，进行人员比对，复用
 */
function check(){
	if(!$("#fzrzjhm").validatebox("isValid")){
		return;
	}
	
	if($("#fzrzjhm").val() == _zjhm){
		return;
	}
	$(".lodingimg").show();
	$.ajax({
		type:"POST",
		url:"<%= basePath%>ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#fzrzjhm").val()+"&cyzjdm="+$("#fzrcyzjdm").val(),
		success:function(data){
			if (data && data.ryRyjbxxb) {
				$("#fzr").val(data.ryRyjbxxb.xm);
				$("#fzrlxdh").val(data.ryRyjbxxb.lxdh);
				$("#fzrzw").val(data.ryRyjbxxb.zw);
			}else {
				//clearRyjbxx();
			}
		},
		complete:function(){
			_zjhm = $("#fzrzjhm").val();
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
function clearRyjbxx(){
	$("#fzr").val("");
	$("#fzrlxdh").val("");
	$("#fzrzw").val("");
}
function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}
</script>