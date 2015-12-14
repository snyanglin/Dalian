<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无犯罪记录证明</title>
</head>
<body style="margin-top:20px"  class="easyui-layout" data-options="fit:true">

	    <div data-options="region:'center', split:true" style="border-width: 0px;margin:0 0 0; width:800px;text-align:center;" class="bodybg">
    	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
    	
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc">
<form action="<%=basePath%>wfzjlzmb/saveWfzjlzmb" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="ryid" id="ryid" value="${entity.ryid}" />
    	<input type="hidden" id="flag" value="${flag}">
	    <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<input type="hidden" id="pk" name="id" value="${entity.id}" />
			 <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">证明接收单位：</td>
				<td width="80%" class="dialogTd" colspan="3"><input  type='text' id='zmjsdw' name='zmjsdw' class="easyui-validatebox" style="width:611px;"
				 maxlength="50" value="${entity.zmjsdw}" /></td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">证明人身份证号：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='zjhm' name='gmsfhm' class="easyui-validatebox" style="width:200px;float:left;"
				maxlength="18" value="${entity.gmsfhm}" data-options="required:true,validType:['sfzh'],tipPosition:'right'" /><div class="lodingimg" id="yrjbxxDiv"></div></td>	
				<td width="20%" class="dialogTd" align="right">证明人姓名：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='xm' name='xm' class="easyui-validatebox" style="width:200px;"
				data-options="required:false,tipPosition:'left'" maxlength="20" value="${entity.xm}" /></td>
			</tr>
			 <tr class="dialogTr">
			 	<td width="20%" class="dialogTd" align="right">证明人性别：</td>
				<td width="30%" class="dialogTd"><input type="text" name="xbdm" id="xb" value="${entity.xbdm}" class="easyui-combobox " style="width:200px;"
						data-options="required:true,url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',
						tipPosition:'right',selectOnNavigation:false,method:'get'" /></td>	
				<td width="20%" class="dialogTd" align="right">证明人出生日期：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='csrq' name='csrq' class="easyui-validatebox" style="width:200px;"
				 maxlength="50" value="${entity.csrq}" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" 
				 data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'"/></td></tr>
				<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">证明人居住地址：</td>
				<td width="50%" class="dialogTd" colspan="2">
				<input class="easyui-combobox" id="jzd1" style="width:400px;" value="${entity.dz_jzdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				<input type='hidden' name='dz_jzdzmlpdm' id="dz_jzdzmlpdm" value="${entity.dz_jzdzmlpdm}"/>
				<input type='hidden' name='dz_jzdzmlpxz' id="dz_jzdzmlpxz" value="${entity.dz_jzdzmlpxz}"/></td>
				<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="jzd2" style="width:200px;" value='${fn:replace(entity.dz_jzdzxz, entity.dz_jzdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_jzdzdm' id='dz_jzdzdm' value="${entity.dz_jzdzdm}" />
				    	<input type='hidden' name='dz_jzdzssxdm' id='dz_jzdzssxdm' value="${entity.dz_jzdzssxdm}" />
				    	<input type='hidden' name='dz_jzdzxz' id='dz_jzdzxz' value="${entity.dz_jzdzxz}" /> 
			    </td>			 
				</tr>
				<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">证明人户籍地址：</td>
				<td width="50%" class="dialogTd" colspan="2">
				<input class="easyui-combobox" id="hjd1" style="width:400px;" value="${entity.dz_hjdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				<input type='hidden' name='dz_hjdzmlpdm' id="dz_hjdzmlpdm" value="${entity.dz_hjdzmlpdm}"/>
				<input type='hidden' name='dz_hjdzmlpxz' id="dz_hjdzmlpxz" value="${entity.dz_hjdzmlpxz}"/></td>
				<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="hjd2" style="width:200px;" value='${fn:replace(entity.dz_hjdzxz, entity.dz_hjdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_hjdzdm' id='dz_hjdzdm' value="${entity.dz_hjdzdm}" />
				    	<input type='hidden' name='dz_hjdzssxdm' id='dz_hjdzssxdm' value="${entity.dz_hjdzssxdm}" />
				    	<input type='hidden' name='dz_hjdzxz' id='dz_hjdzxz' value="${entity.dz_hjdzxz}" /> 
			    </td>			 
				</tr>
			<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">开具日期：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='kjrq' name='kjrq' class="easyui-validatebox" style="width:200px;"
				 maxlength="50" value="${entity.kjrq}" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'right'"/></td>
				<td width="20%" class="dialogTd" align="right">开具人：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='zmkjr' name='zmkjr' class="easyui-validatebox" style="width:200px;"
				maxlength="20" value="${entity.zmkjr}"  /></td>	
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">开具单位：</td>
				<td width="80%" class="dialogTd" colspan="3"><input  type='text' id='zmkjdw' name='zmkjdw' class="easyui-validatebox" style="width:611px;"
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
	if(flag=="update"){
		setInputReadonly('zmjsdw', true);
		setInputReadonly('zjhm', true);
		setInputReadonly('xm', true);
		setInputReadonly('xb', true);
		setInputReadonly('csrq',true);
		setInputReadonly('hjd1',true);
		setInputReadonly('hjd2',true);
		setInputReadonly('jzd1',true);
		setInputReadonly('jzd2',true);
		setInputReadonly('kjrq',true);
		setInputReadonly('zmkjr',true);
		setInputReadonly('zmkjdw',true);
		$("#saveBotton").hide();
		$("#resetBotton").hide();
	}else {
	
	}
	initAddressSearch('jzd1', {}, 'dz_jzdzmlpdm', 'dz_jzdzmlpxz', 'jzd2', {text:'dz_jzdzxz',dzxzqh:'dz_jzdzssxdm',id:'dz_jzdzdm'}, null, null);
	initAddressSearch('hjd1', {}, 'dz_hjdzmlpdm', 'dz_hjdzmlpxz', 'hjd2', {text:'dz_hjdzxz',dzxzqh:'dz_hjdzssxdm',id:'dz_hjdzdm'}, null, null);
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
				topMessager.confirm('操作确认', '您是否保存无犯罪记录证明信息？',  function(r) {
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
			 	 setInputReadonly('xm', false);
				 setInputReadonly('xb', false);
				 setInputReadonly('csrq',false);
				 setInputReadonly('jzd1',false);
			 	 setInputReadonly('jzd2',false);
			 	 setInputReadonly('hjd1',false);
				 setInputReadonly('hjd2',false);
			
		});
	
	
});
/**
 * 根据证件类型与号码 ，进行人员比对，复用
 */
function check(){
	if(!$("#zjhm").validatebox("isValid")){
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
			$("#xb").combobox("setValue",data.ryRyjbxxb.xbdm);
			$("#csrq").val(data.ryRyjbxxb.csrq);
			//$("#dz_jzdzxz").val(data.ryRyjbxxb.dz_jzdzxz);
			//$("#dz_jzdzmlpxz").val(data.ryRyjbxxb.dz_jzdmlpxz);
			//$("#dz_jzdzmlpdm").val(data.ryRyjbxxb.dz_jzdmlpdm);
			//$("#dz_jzdzssxdm").val(data.ryjbxxb.dz_jzdzssxdm);
		//	$("#dz_jzdzdm").val(data.ryjbxxb.dz_jzdzdm);
		//	$("#jzd1").combobox('setValue', data.ryjbxxb.dz_jzdmlpxz);
		//	$("#jzd2").combobox('setValue', data.ryjbxxb.dz_jzdzxz.replace(data.ryjbxxb.dz_jzdmlpxz, ''));
			$("#dz_hjdzssxdm").val(data.ryRyjbxxb.hjd_xzqhdm);
			$("#dz_hjdzdm").val(data.ryRyjbxxb.hjd_dzid);
			$("#dz_hjdzmlpxz").val(data.ryRyjbxxb.hjd_mlpxz);
			$("#dz_hjdzmlpdm").val(data.ryRyjbxxb.hjd_mlpdm);
			$("#dz_hjdzxz").val(data.ryRyjbxxb.hjd_dzxz);
			$("#hjd1").combobox('setValue', data.ryRyjbxxb.hjd_mlpxz);
			$("#hjd2").combobox('setValue', data.ryRyjbxxb.hjd_dzxz.replace(data.ryRyjbxxb.hjd_mlpxz, ''));
			
			if(data.ryRyjbxxb.xm != ""){
				setInputReadonly("xm", true);
			}
			if(data.ryRyjbxxb.csrq != ""){
				setInputReadonly("csrq", true);
			}
			if(data.ryRyjbxxb.xbdm != ""){
				setInputReadonly("xb", true);
			}
		//	if(data.ryRyjbxxb.dz_jzdzxz != ""){
		//		setInputReadonly("jzd1", true);
		//		setInputReadonly("jzd2", true);	
		//	}
			if(data.ryRyjbxxb.hjd_dzxz != ""){
				setInputReadonly("hjd1", true);
				setInputReadonly("hjd2", true);	
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