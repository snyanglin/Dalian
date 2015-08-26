<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>出生证明新增</title>
</head>
<body style="margin-top:20px"  class="easyui-layout" data-options="fit:true">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0; width:800px;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
	<form action="<%=basePath%>cszmb/saveCszmb" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="ryid" id="ryid" value="${entity.ryid}" />
    	<input type="hidden" id="flag" name="flag" value="${flag}">
    	<input type="hidden" id="zmkjdwid" name="zmkjdwid" value="${entity.zmkjdwid}">
    	<input type="hidden" id="zmkjrid" name="zmkjrid" value="${entity.zmkjrid}">
	    <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<input type="hidden" id="pk" name="id" value="${entity.id}" />
			 <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">证明接收单位：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='zmjsdw' name='zmjsdw' class="easyui-validatebox" style="width:200px;"
				 maxlength="50" value="${entity.zmjsdw}" /></td>
				<td width="20%" class="dialogTd" align="right">证明人身份证号：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='zjhm' name='gmsfhm' class="easyui-validatebox" style="width:200px;float:left;"
				maxlength="18" value="${entity.gmsfhm}" data-options="required:true,validType:['sfzh'],tipPosition:'left'" /><div class="lodingimg" id="yrjbxxDiv"></div></td>	
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">证明人姓名：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='xm' name='xm' class="easyui-validatebox" style="width:200px;"
				data-options="required:false,validType:['chinese'],tipPosition:'right'" maxlength="20" value="${entity.xm}" /></td>
				<td width="20%" class="dialogTd" align="right">证明人性别：</td>
				<td width="30%" class="dialogTd"><input type="text" name="xbdm" id="xb" value="${entity.xbdm}" class="easyui-combobox " style="width:200px;"
						data-options="required:true,url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'" /></td>	
			</tr>
			 <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">证明人出生日期：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='csrq' name='csrq' class="easyui-validatebox" style="width:200px;"
				 maxlength="50" value="${entity.csrq}" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'right'"/></td></tr>
			 <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">证明人出生地：</td>
				<td width="80%" class="dialogTd" colspan="3"><input  type='text' id='csd' name='csd' class="easyui-validatebox" style="width:610px;"
				maxlength="50" value="${entity.csd}"  /></td>	
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">证明人居住地址：</td>
				<td width="50%" class="dialogTd" colspan="2">
				<input class="easyui-combobox" id="jzd1" style="width:400px;" value="${entity.dz_jzdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false"/>
				<input type='hidden' name='dz_jzdzmlpdm' id="dz_jzdzmlpdm" value="${entity.dz_jzdzmlpdm}"/>
				<input type='hidden' name='dz_jzdzmlpxz' id="dz_jzdzmlpxz" value="${entity.dz_jzdzmlpxz}"/></td>
				<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="jzd2" style="width:200px;" value='${fn:replace(entity.dz_jzdzxz, entity.dz_jzdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false" />
				    	<input type='hidden' name='dz_jzdzdm' id='dz_jzdzdm' value="${entity.dz_jzdzdm}" />
				    	<input type='hidden' name='dz_jzdzssxdm' id='dz_jzdzssxdm' value="${entity.dz_jzdzssxdm}" />
				    	<input type='hidden' name='dz_jzdzxz' id='dz_jzdzxz' value="${entity.dz_jzdzxz}" /> 
			    </td>			 
				</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">证明人生父：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='sfxm' name='sfxm' class="easyui-validatebox" style="width:200px;"
				maxlength="20" value="${entity.sfxm}"  data-options="required:false,tipPosition:'right'"/></td>	
				<td width="20%" class="dialogTd" align="right">证明人生母：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='smxm' name='smxm' class="easyui-validatebox" style="width:200px;"
				maxlength="20" value="${entity.smxm}" data-options="required:false,tipPosition:'left'" /></td>	
			</tr>
			<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">开具日期：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='kjrq' name='kjrq' class="easyui-validatebox" style="width:200px;"
				  value="${entity.kjrq}" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'"/></td>
				<td width="20%" class="dialogTd" align="right">开具人：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='zmkjr' name='zmkjr' class="easyui-validatebox" style="width:200px;"
				maxlength="20" value="${entity.zmkjr}"  /></td>	
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">开具单位：</td>
				<td width="80%" class="dialogTd" colspan="3"><input  type='text' id='zmkjdw' name='zmkjdw' class="easyui-validatebox" style="width:610px;"
				 maxlength="50" value="${entity.zmkjdw}" /></td>
			</tr>
	    	</table>
	    </div>
    </form>
	</div>
	    </div>
	    </div>
		<div style="height:6px;font-size:1px;"></div>
	    	  
		<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:block;">
			<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="backBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">退出</span>
					<span class="l-btn-icon icon-back"> </span>
				</span>
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="resetBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">重置</span>
					<span class="l-btn-icon icon-reset"> </span>
				</span>
			</a>
		</div>

</td>
</tr>
</table>
</div>
</body>
</html>
<script type="text/javascript" >
var mainTabID = "${mainTabID}";

function doInit(paramArray) {
	
}
var _zjhm = "";
$(document).ready(function(){
	var flag = document.getElementById("flag").value;
	if(flag=="see"){
		setInputReadonly('zmjsdw', true);
		setInputReadonly('zjhm', true);
		setInputReadonly('xm', true);
		setInputReadonly('xb', true);
		setInputReadonly('csrq',true);
		setInputReadonly('csd',true);
		//setInputReadonly('jzd1',true);
		//setInputReadonly('jzd2',true);
		setInputReadonly('sfxm',true);
		setInputReadonly('smxm',true);
		setInputReadonly('kjrq',true);
		setInputReadonly('zmkjr',true);
		setInputReadonly('zmkjdw',true);
		$("#saveBotton").hide();
		$("#resetBotton").hide();
	}else if(flag=="update"){
		
	}else {
		setInputReadonly('zmkjr',true);
		setInputReadonly('zmkjdw',true);
		$('#zmjsdw').val("大连市公证处");
	}
	initAddressSearch('jzd1', {}, 'dz_jzdzmlpdm', 'dz_jzdzmlpxz', 'jzd2', {text:'dz_jzdzxz',dzxzqh:'dz_jzdzssxdm',id:'dz_jzdzdm'}, null, null);
	$("#zjhm").bind("blur",function(e){	check();});
	$('#dataForm').form({  
	        onSubmit:function(){
	            return $(this).form('validate');  
	        },  
	        success:function(data){  
	            var json = $.parseJSON(data);
	            if(json.status != 'success'){
	            	topMessagerAlert(null,json.message);
	            }else{
	            	topMessagerShow(null,json.message);
	            	$("#pk").val(json.saveID); 
	            	executeTabPageMethod(mainTabID, "reloadDg");
	            	closeSelf();
	            }
	        }  
	    });   
		$('#saveBotton').click(function(){
			if ($("#dataForm").form('validate')){
				topMessager.confirm('操作确认', '您是否保存出生证明信息？',  function(r) {
					if (r) {									
						$('#dataForm').submit();
					}
				});
			}
		});
		
		$('#backBotton').click(function(){
			closeSelf();
		});
		$('#resetBotton').click(function(){
				 document.forms["dataForm"].reset();
				 $('#zmjsdw').val("大连市公证处");
			 	 setInputReadonly('xm', false);
				 setInputReadonly('xb', false);
				 setInputReadonly('csrq',false);
				// setInputReadonly('jzd1',false);
			 	// setInputReadonly('jzd2',false);
			
		});
	
});
/**
 * 根据证件种类与号码 ，进行人员比对，复用
 */
function check(){
	if(!$("#zjhm").validatebox("isValid")){
		return;
	}

	if($("#zjhm").val() == _zjhm){
		return;
	}
	$(".lodingimg").show();
	if($("#zjhm").val()==$("#sfz").val()){
		alert("证明人不能是本人");
		$("#zjhm").val("").focus();
	}
	$.ajax({
		type:"POST",
		url:contextPath+"/ryRyjbxxb/dataApply",		dataType:"json",
		data:"zjhm="+$("#zjhm").val()+"&cyzjdm=111",
		success:function(data){
		if (data && data.ryRyjbxxb) {
			$("#xm").val(data.ryRyjbxxb.xm);
			$("#xb").combobox("setValue",data.ryRyjbxxb.xbdm);
			$("#csrq").val(formatDate(data.ryRyjbxxb.csrq));
			$("#ryid").val(data.ryRyjbxxb.id);
			if(data.ryRyjbxxb.xm != ""){
				setInputReadonly("xm", true);
			}
			if(data.ryRyjbxxb.csrq != ""){
				setInputReadonly("csrq", true);
			}
			if(data.ryRyjbxxb.xbdm != ""){
				setInputReadonly("xb", true);
			}
			if(data.ryRyjbxxb.dz_jzdzxz != ""){
			//	setInputReadonly("jzd1", true);
			//	setInputReadonly("jzd2", true);	
			}
			
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
</script>