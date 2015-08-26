<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亲属关系</title>
</head>
<div class="easyui-layout" data-options="fit:true">
<form action="<%=basePath%>qsgxzmb/saveQsgxrzb" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="qsgxid" id="qsgxid" value="${entity.qsgxid}" />
    	<input type="hidden" id="sfz" value="${sfz}"/>
	    <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center" id="table1">
			<input type="hidden" id="pk" name="id" value="${entity.id}" />
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">与本人关系：</td>
				<td width="30%" class="dialogTd"><input type="text" name="ybrgxdm" id="ybrgxdm"  value="${entity.ybrgxdm}" class="easyui-combobox " style="width:200px;"
		    		data-options="required:true,url: contextPath + '/common/dict/D_BZ_RYGX.js',valueField:'id',textField:'text',
		    		selectOnNavigation:false,method:'get'"/></td>	
				<td width="20%" class="dialogTd" align="right">身份证号：</td>
				<td width="30%" class="dialogTd">
				<input class="easyui-validatebox"  type="text" id="gmsfhm" name="gmsfhm" style="width:200px;float:left;" 
				value="${entity.gmsfhm }" maxlength="30" 
		    		data-options="required:true,validType:['sfzh'],tipPosition:'left'"  onblur="fzcyzjhm_onblur()" /><div class="lodingimg" id="yrjbxxDiv"></div></td>
			</tr>
			 <tr class="dialogTr">
			 	<td width="20%" class="dialogTd" align="right">姓名：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='xm' name='xm' class="easyui-validatebox" style="width:200px;"
				data-options="required:false,tipPosition:'right'" maxlength="20" value="${entity.xm}" /></td>	
				<td width="20%" class="dialogTd" align="right">出生日期：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='csrq' name='csrq' class="easyui-validatebox" style="width:200px;"
				 maxlength="50" value="${entity.csrq}" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" 
				 data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'"/></td>
			</tr>
			<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">居住地址：</td>
			 <td width="50%" class="dialogTd" colspan="2">
				  <input class="easyui-combobox" id="jzd1" style="width:400px;" value="${entity.dz_jzdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_jzdzmlpdm' id="dz_jzdzmlpdm" value="${entity.dz_jzdzmlpdm}"/>
				    	<input type='hidden' name='dz_jzdzmlpxz' id="dz_jzdzmlpxz" value="${entity.dz_jzdzmlpxz}"/>
				  </td>
				<td width="30%" class="dialogTd" >
				<input class="easyui-combobox" id="jzd2" style="width:200px;" value="${fn:replace(entity.dz_jzdzxz, entity.dz_jzdzmlpxz, '')}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				<input type="hidden" name="dz_jzdzdm" id="dz_jzdzdm" value="${entity.dz_jzdzdm}"/>
				<input type="hidden" name="dz_jzdzssxdm" id="dz_jzdzssxdm" value="${entity.dz_jzdzssxdm}"/>
			    <input type='hidden' name='dz_jzdzxz' id="dz_jzdzxz" value="${entity.dz_jzdzxz}"/>
				</td>
			</tr>
	    	</table>
				   
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
function doInit(paramArray) {
document.getElementById("sfz").value =parent.sfzh() ;
	//var flag = document.getElementById("flag").value;
//	if(flag=="update"){
//		setInputReadonly('ybrgxdm', true);
//		setInputReadonly('gmsfhm', true);
//		setInputReadonly('xm', true);
//		setInputReadonly('csrq',true);
//		setInputReadonly('dz_jzdzxz',true);
//	}
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
	parent.dq();	
	
}
function successCloseWindow(){
 return true;
}
function fzcyzjhm_onblur() {
	if($("#gmsfhm").val()==$("#sfz").val()){
		alert("亲属不能是本人");
		$("#gmsfhm").val("").focus();
	}
	var su = true;
		$.ajax({
			async:false,
			type:"POST",
			url:"<%= basePath%>syrkgl/getQsgxrzb",
			dataType:"json",
			data:"zjhm="+$("#gmsfhm").val()+"&qsgxid="+$("#qsgxid").val(),
			success:function(data){
			if (data && data.sfzhflag) {
					if(data.sfzhflag==true){
						su = false;
						alert("该人员已经添加过了");
						$("#gmsfhm").val("").focus();
					}else {
				
					}
				}
			}
		});
	if(su){
		$(".lodingimg").show();
	$.ajax({
		type:"POST",
		url:contextPath+"/ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#gmsfhm").val()+"&cyzjdm=111",
		success:function(data){
		if (data && data.ryRyjbxxb) {
			$("#xm").val(data.ryRyjbxxb.xm);
			$("#csrq").val(data.ryRyjbxxb.csrq);
		//	$("#jzd2").combobox("setValue",(data.ryjbxxb.dz_jzdzxz).substr((data.ryjbxxb.dz_jzdmlpxz).length));
		//	$("#dz_jzdzxz").val(data.ryRyjbxxb.dz_jzdzxz);
			$("#ryid").val(data.ryRyjbxxb.id);
		//	$("#jzd1").combobox("setValue",data.ryjbxxb.dz_jzdmlpxz);
		//	$("#dz_jzdzssxdm").val(data.ryjbxxb.dz_jzdzssxdm);
		//	$("#dz_jzdzdm").val(data.ryjbxxb.dz_jzdzdm);
		//	$("#dz_jzdzmlpdm").val(data.ryjbxxb.dz_jzdmlpdm);
		//	$("#dz_jzdzmlpxz").val(data.ryjbxxb.dz_jzdmlpxz);
		//	$("#csrq").validatebox('validate');
			
		}
		},
		complete:function(){
			$('#dataForm').form('validate');
			$(".lodingimg").hide();
		}
	});
	}
	return su;
}
$(document).ready(function(){
	initAddressSearch('jzd1', {}, 'dz_jzdzmlpdm', 'dz_jzdzmlpxz', 'jzd2', {text:'dz_jzdzxz',dzxzqh:'dz_jzdzssxdm',id:'dz_jzdzdm'}, null, null);
});
</script>