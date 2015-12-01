<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/sydw.css"></link>
<title>法人\负责人\联络员</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwfrfzrllyxxb_dl/save" id="dataForm" name="dataForm" method="post" >
    
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid }"  />
    	<input type="hidden" name="ryid" id="ryid" value="${entity.ryid }"  /><!-- 从业人员id -->
    	<input type="hidden" name="jjlxr_ryid" id="jjqklxrid" value="${entity.jjlxr_ryid }" /><!-- 紧急情况联系人ID -->
    	<input type="hidden"  id="pcsdm" value=${pcsdm } />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	  		 <input type="hidden" name="id" id="pk" value="${entity.id }"  />
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">证件类型：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="cyzjdm" name="cyzjdm" style="width:200px;" value="${entity.cyzjdm }"
					data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left',onChange:zjhmCheck,
					onSelect:function(record){
						if(record.id==111||record.id==112||record.id==335){
							$('#zjhm').validatebox({validType:['sfzh']});
						}else {
							$('#zjhm').validatebox({validType:['maxLength[30]']});
						}
					}" />
		    	</td>
				<td width="20%" class="dialogTd" align="right">证件号码：</td>
		    	<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox" type="text" id="zjhm" name="zjhm" style="width:200px;float:left;" value="${entity.zjhm }" maxlength="30" 
		    		data-options="required:true,tipPosition:'left'"/><div class="lodingimg" id="yrjbxxDiv"></div></td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xm" name="xm" style="width:200px;" value="${entity.xm }" maxlength="50" 
		    		data-options="required:true,tipPosition:'left'"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="csrq" id="csrq" class="easyui-validatebox" style="width: 200px;" value="${entity.csrq }"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
		    	</td>
				
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">性别：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:200px;" value="${entity.xbdm }"
					data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">民族：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="mzdm" name="mzdm" style="width:200px;" value="${entity.mzdm }"
					data-options="url: contextPath + '/common/dict/D_BZ_MZ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
		    	</td>
		    </tr>
		    
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">联系电话：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="lxdh" name="lxdh" style="width:200px;" value="${entity.lxdh }" maxlength="18"
		    		data-options="validType:['phone'],required:false,tipPosition:'right'" />
		    	</td>
				<td width="20%" class="dialogTd" align="right">国籍：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="gjdm" id="gjdm" class="easyui-combobox" style="width:200px;" value="${entity.gjdm }"
	    			data-options="url: contextPath + '/common/dict/D_BZ_SJGGHDQMCDM.js',dataFilter:'',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'">
		    	</td>
		    </tr>
		    <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">居住地址：</td>
				<td width="50%" class="dialogTd" colspan="2">
					<input class="easyui-combobox" id="dwfr_jzdz1" style="width:400px;" value="${entity.dz_xjzdmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    		<input type='hidden' name='dz_xjzdmlpdm' id="dwfr_dz_xjzdmlpdm" value="${entity.dz_xjzdmlpdm}"/>
		    		<input type='hidden' name='dz_xjzdmlpxz' id="dwfr_dz_xjzdmlpxz" value="${entity.dz_xjzdmlpxz}"/>
	    		</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-combobox" id="dwfr_jzdz2" style="width:200px;" value='${fn:replace(entity.dz_xjzdzxz, entity.dz_xjzdmlpxz,"")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
			    	<input type='hidden' name='dz_xjzdzdm' id='dwfr_dz_xjzdzdm' value="${entity.dz_xjzdzdm}" />
			    	<input type='hidden' name='dz_xjzdzssxdm' id='dwfr_dz_xjzdzssxdm' value="${entity.dz_xjzdzssxdm}" />
			    	<input type='hidden' name='dz_xjzdzxz' id='dwfr_dz_xjzdzxz' value="${entity.dz_xjzdzxz}" /> 
				</td>
			</tr>
		    <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">户籍地址：</td>
				<td width="50%" class="dialogTd" colspan="2">
					<input class="easyui-combobox" id="dwfr_hjdz1" style="width:400px;" value="${entity.dz_hjdmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    		<input type='hidden' name='dz_hjdmlpdm' id="dwfr_dz_hjdmlpdm" value="${entity.dz_hjdmlpdm}"/>
		    		<input type='hidden' name='dz_hjdmlpxz' id="dwfr_dz_hjdmlpxz" value="${entity.dz_hjdmlpxz}"/>
	    		</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-combobox" id="dwfr_hjdz2" style="width:200px;" value='${fn:replace(entity.dz_hjdzxz, entity.dz_hjdmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
			    	<input type='hidden' name='dz_hjdzdm' id='dwfr_dz_hjdzdm' value="${entity.dz_hjdzdm}" />
			    	<input type='hidden' name='dz_hjdzssxdm' id='dwfr_dz_hjdzssxdm' value="${entity.dz_hjdzssxdm}" />
			    	<input type='hidden' name='dz_hjdzxz' id='dwfr_dz_hjdzxz' value="${entity.dz_hjdzxz}" /> 
				</td>
			</tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">职务：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zw" name="zw" style="width:200px;" value="${entity.zw }" maxlength="20"
		    		data-options="required:false,tipPosition:'left'" />
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">单位人员类型：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="dwrylxdm" id="dwrylxdm" class="easyui-combobox" style="width:200px;" value="${entity.dwrylxdm }"
	    			data-options="url: contextPath + '/common/dict/D_DW_DWRYLXDM.js',dataFilter:'',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'">
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	
		    </tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) {
	$("#gjdm").combobox("setValue","${entity.gjdm}");
	if($("#xm").val() != ""){
		setInputReadonly("xm", true);
	}
	if($("#csrq").val() != ""){
		setInputReadonly("csrq", true);
	}
	if($("#xbdm").val() != ""){
		setInputReadonly("xbdm", true);
	}
	if($("#mzdm").val() != ""){
		setInputReadonly("mzdm", true);
	}
	if($("#hjd1").val() != ""){
		setInputReadonly("hjd1", true);
		setInputReadonly("hjd2", true);
	}
	if($("#jjqklxrxm").val() != ""){
		setInputReadonly("jjqklxrxm", true);
	}
	if($("#jjqklxrxbdm").val() != ""){
		setInputReadonly("jjqklxrxbdm", true);
	}
	
	initAddressSearch('dwfr_hjdz1', {}, 'dwfr_dz_hjdmlpdm', 'dwfr_dz_hjdmlpxz', 'dwfr_hjdz2', {text:'dwfr_dz_hjdzxz',dzxzqh:'dwfr_dz_hjdzssxdm',id:'dwfr_dz_hjdzdm'}, null, null);
	initAddressSearch('dwfr_jzdz1', {}, 'dwfr_dz_xjzdmlpdm', 'dwfr_dz_xjzdmlpxz', 'dwfr_jzdz2', {text:'dwfr_dz_xjzdzxz',dzxzqh:'dwfr_dz_xjzdzssxdm',id:'dwfr_dz_xjzdzdm'}, null, null);
	
	$.getJSON(contextPath+'/common/dict/D_DW_DWRYLX.js',function(dic){
		$('#cbo_dwrylxdm').empty();
		$.each(dic,function(i,type){
			var checked = $('#dwrylxdm').val().indexOf(type.id)>=0?'checked':'';
			$('#cbo_dwrylxdm').append('<label><input type="checkbox" name="cbo_dwrylxdm" value="'+type.id+'" '+checked+'/>'+type.text+'</label>&nbsp;');
		});
	});
	
	$(document).on('click','#cbo_dwrylxdm :checkbox',function(){
		var tmpArr = Array();
		$('#cbo_dwrylxdm :checked').each(function(){
			tmpArr.push($(this).val());
		});
		$('#dwrylxdm').val(tmpArr.join(','));
	});
	
}

function beforeSubmit() {
	var ryid = $("#ryid").val();
	var jjqklxrid = $("#jjqklxrid").val();
	if(ryid != undefined && ryid != "" && jjqklxrid != undefined && jjqklxrid != ""){
		if(ryid == jjqklxrid){
			alert("【法人\负责人\联络员】和【紧急联系人员】不能为同一个人！");
			return false;
		}
	}
	
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}

$(document).ready(function(){
	var cyzjdm =$("#cyzjdm").combobox("getValue");
	//人员信息复用人员基本表
	$("#zjhm").bind("blur",function(e){ checkRyxx(); });
	if($("#cyzjdm").combobox("getValue") == ""){
		$("#cyzjdm").combobox("setValue","111");
		$('#zjhm').validatebox({validType:['sfzh']});
	}
	if(cyzjdm == "111" || cyzjdm=="112" || cyzjdm == "335"){
		$('#zjhm').validatebox({validType:['sfzh']});
	}
	//紧急联系人复用人员基本表
	$("#jjqklxrzjhm").bind("blur",function(e){ checkJjlxRyxx(); });
});

/**
 * 从业人员基本信息复用人员基本信息表
 */
var _zjhm = "";
function checkRyxx(){ 
	if(!$("#zjhm").validatebox("isValid")){
		return;
	}
	if($("#zjhm").val() == _zjhm){
		return;
	}
	$("#yrjbxxDiv").show();
	$.ajax({
		type:"POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#zjhm").val()+"&cyzjdm="+$("#cyzjdm").val(),
		success:function(data){
			if (data && data.ryRyjbxxb) {
				$("#ryid").val(data.ryRyjbxxb.id);
				$("#xm").val(data.ryRyjbxxb.xm);
				$("#xbdm").combobox("setValue",data.ryRyjbxxb.xbdm);
				$("#csrq").val(data.ryRyjbxxb.csrq);
				$("#mzdm").combobox("setValue",data.ryRyjbxxb.mzdm);
				$("#dwfr_dz_hjdzxz").val(data.ryRyjbxxb.hjd_dzxz);
				$("#dwfr_dz_hjdzssxdm").val(data.ryRyjbxxb.hjd_xzqhdm);
				$("#dwfr_dz_hjdzdm").val(data.ryRyjbxxb.hjd_dzid);
				$("#lxdh").val(data.ryRyjbxxb.lxdh);
				$("#gjdm").combobox("setValue",data.ryRyjbxxb.gjdm);
				$("#dwfr_hjdz1").combobox("setValue", data.ryRyjbxxb.hjd_mlpxz);
				$("#dwfr_hjdz2").combobox("setValue", data.ryRyjbxxb.hjd_dzxz.replace(data.ryRyjbxxb.hjd_mlpxz, ''));
				if(data.ryRyjbxxb.xm != ""){
					setInputReadonly("xm", true);
				}
				if(data.ryRyjbxxb.csrq != ""){
					setInputReadonly("csrq", true);
				}
				if(data.ryRyjbxxb.xbdm != ""){
					setInputReadonly("xbdm", true);
				}
				if(data.ryRyjbxxb.mzdm != ""){
					setInputReadonly("mzdm", true);
				}
				if(data.ryRyjbxxb.dz_hjdzxz != ""){
					setInputReadonly("dwfr_hjdz1", true);
					setInputReadonly("dwfr_hjdz2", true);
					$("#dwfr_dz_hjdmlpxz").val(data.ryRyjbxxb.hjd_mlpxz);
					$("#dwfr_dz_hjdmlpdm").val(data.ryRyjbxxb.hjd_mlpdm);
				}
			}else{
				clearRyjbxx();
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete:function(){
			_zjhm = $("#zjhm").val();
			$("#yrjbxxDiv").hide();
		}
	});
}
var _jjlxrZjhm = "";
/**
 * 紧急联系人复用人员基本信息表
 */
//紧急联系人-验证证件号码
function jjlxrzjhmCheck(newValue, oldValue){
	if(newValue==""){
		$("#jjqklxrzjhm").validatebox({validType:null});
		return;
	}
	if (!newValue) {
		return;
	}
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue=="112" || newValue == "335"){ 
		$("#jjqklxrzjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#jjqklxrzjhm").validatebox({validType:['maxLength[30]']});
	}
	
	clearJjlxryjbxx();
	$("#jjqklxrzjhm").val("");
	_jjlxrZjhm = "";
}
//清空复用的紧急联系人员信息
function clearJjlxryjbxx(){
	$("#jjqklxrid").val("");
	$("#jjqklxrxm").val("");
	$("#jjqklxrxbdm").combobox("setValue","");
	$("#jjqklxrdh").val("");
	setInputReadonly("jjqklxrxm", false);
	setInputReadonly("jjqklxrxbdm", false);
	setInputReadonly("jjqklxrdh", false);
}
//验证证件号码
function zjhmCheck(newValue, oldValue){
	if(newValue==""){
		$("#zjhm").validatebox({validType:null});
		return;
	}
	if (!newValue) {
		return;
	}
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue=="112"||newValue == "335"){ 
		$("#zjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#zjhm").validatebox({validType:['maxLength[30]']});
	}
	
	clearRyjbxx();
	$("#zjhm").val("");
	_zjhm = "";
}

//清空复用的人员基本信息
function clearRyjbxx(){
	$("#ryid").val("");
	$("#xm").val("");
	$("#xbdm").combobox("clear");
	$("#csrq").val("");
	$("#mzdm").combobox("clear");
	$("#dwfr_dz_hjdmlpdm").val("");
	$("#dwfr_dz_hjdmlpxz").val("");
	$("#dwfr_dz_hjdzdm").val("");
	$("#dwfr_dz_hjdzssxdm").val("");
	$("#dwfr_dz_hjdzxz").val("");
	
	
	$("#dwfr_dz_xjzdmlpdm").val("");
	$("#dwfr_dz_xjzdmlpxz").val("");
	$("#dwfr_dz_xjzdzdm").val("");
	$("#dwfr_dz_xjzdzssxdm").val("");
	$("#dwfr_dz_xjzdzxz").val("");
	
	
	
	$("#lxdh").val("");
	$("#gjdm").combobox("clear");
	setInputReadonly("xm", false);
	setInputReadonly("csrq", false);
	setInputReadonly("xbdm", false);
	setInputReadonly("mzdm", false);
	
	$("#dwfr_hjdz1").combobox("clear");
	$("#dwfr_hjdz2").combobox("clear");
	$("#dwfr_jzdz1").combobox("clear");
	$("#dwfr_jzdz2").combobox("clear");
	
}
function resetForm(){
	document.forms["dataForm"].reset();
	setInputReadonly("xm", false);
	setInputReadonly("csrq", false);
	setInputReadonly("xbdm", false);
	setInputReadonly("mzdm", false);
	setInputReadonly("dwfr_hjdz1", false);
	setInputReadonly("dwfr_hjdz2", false);
	$("#dwfr_hjdz1").combobox("clear");
	$("#dwfr_hjdz2").combobox("clear");
	$("#dwfr_dz_hjdzdm").val("");
	$("#dwfr_dz_hjdmlpxz").val("");
	$("#dwfr_dz_hjdzdm").val("");
	$("#dwfr_dz_hjdzssxdm").val("");
	$("#dwfr_dz_hjdzxz").val("");
	
	$("#cyzjdm").combobox("setValue","111");
}
function resetTable(){
	document.forms["dataForm"].reset();
	setInputReadonly("xm", false);
	setInputReadonly("csrq", false);
	setInputReadonly("xbdm", false);
	setInputReadonly("mzdm", false);
	setInputReadonly("dwfr_hjdz1", false);
	setInputReadonly("dwfr_hjdz2", false);
	$("#dwfr_hjdz1").combobox("clear");
	$("#dwfr_hjdz2").combobox("clear");
	$("#dwfr_dz_hjdzdm").val("");
	$("#dwfr_dz_hjdmlpxz").val("");
	$("#dwfr_dz_hjdzdm").val("");
	$("#dwfr_dz_hjdzssxdm").val("");
	$("#dwfr_dz_hjdzxz").val("");
	
	$("#cyzjdm").combobox("setValue","111");
}
</script>
</html>