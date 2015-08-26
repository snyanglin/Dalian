<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>社区治保会</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>sqzbhb/saveSqzbhb" id="dataForm" name="dataForm" method="post">
    		<input type="hidden" name="flag" id="flag" value="flag" />
    	<input type="hidden" name="sqid" id="sqid" value="" />
    	<input type="hidden" id="sqjwsid" name="sqjwsid" value="${entity.sqjwsid}">
   		<input type="hidden" id="ryid" name="ryid" value="${entity.ryid}">
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
   		<input type="hidden" name="id" id="pk" value="${entity.id}" />
    		<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">负责人常用证件：</td>
				<td width="30%" class="dialogTd"><input type="text" name="fzrcyzjdm" id="zjlx"  value="${entity.fzrcyzjdm}" class="easyui-combobox" style="width:200px;"
	    		data-options="required:true,url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:setPassPort
	    								"/></td> 
				<td width="20%" class="dialogTd" align="right">负责人证件号码：</td>
				
				<td width="30%" class="dialogTd" align="left">
				<input class="easyui-validatebox" type="text" id="zjhm" name="fzrzjhm" style="width:200px;float:left;" value="${entity.fzrzjhm }" maxlength="30" 
		    		data-options="required:true,tipPosition:'left'" />
		    		<div class="lodingimg" id="yrjbxxDiv"></div></td>
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
			<td width="30%" class="dialogTd"><input type="text" id="zzmc" name="zzmc" value="${entity.zzmc}" maxlength="30" 
				class="easyui-validatebox inputxtext " style="width:200px;" data-options="required:false,validType:['maxLength[30]']"   /></td>
			<td width="20%" class="dialogTd" align="right">组织类别：</td>
			<td width="30%" class="dialogTd"><input type="text" id="zzlb" name="zzlb" value="治保组织" maxlength="20" 
				class="easyui-validatebox inputreadonly " style="width:200px;" data-options="required:false"  readonly="readonly" /></td>
			</tr>
		   <tr class="dialogTr">
				 <td width="20%" class="dialogTd" align="right">组织形式：</td>
				<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text"  id="zzxsdm" name="zzxsdm" style="width:200px;" value="${entity.zzxsdm}"
					data-options="url: contextPath + '/common/dict/D_ZAFF_ZBHZZXS.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
					required:false,tipPosition:'right'"/></td>
				<td width="20%" class="dialogTd" align="right">地域类别：</td>
			<td width="30%" class="dialogTd" ><input class="easyui-combobox" type="text"  id="dylbdm" name="dylbdm" style="width:200px;" value="${entity.dylbdm}"
					data-options="url: contextPath + '/common/dict/D_ZAFF_DYLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
					required:false,tipPosition:'right'"/>
				</td>
			</tr>
			<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">治保会地址：</td>
			 <td width="50%" class="dialogTd" colspan="2">
				  <input class="easyui-combobox" id="jzd1" style="width:400px;" value="${entity.dz_zbhdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_zbhdzmlpdm' id="zbhdzmlpdm" value="${entity.dz_zbhdzmlpdm}"/>
				    	<input type='hidden' name='dz_zbhdzmlpxz' id="zbhdzmlpxz" value="${entity.dz_zbhdzmlpxz}"/>
				  </td>
				<td width="30%" class="dialogTd" >
				<input class="easyui-combobox" id="jzd2" style="width:200px;" value="${fn:replace(entity.dz_zbhdzxz, entity.dz_zbhdzmlpxz, '')}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				<input type="hidden" name="dz_zbhdzdm" id="zbhdzdm" value="${entity.dz_zbhdzdm}"/>
				<input type="hidden" name="dz_zbhdzssxdm" id="zbhdzssxdm" value="${entity.dz_zbhdzssxdm}"/>
			    <input type='hidden' name='dz_zbhdzxz' id="zbhdzxz" value="${entity.dz_zbhdzxz}"/>
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
			<input type="text" id="zbpzqk" name="zbpzqk" value="${entity.zbpzqk}" maxlength="100" 
				class="easyui-validatebox inputxtext " style="width:619px;" data-options="required:false"   />
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
				<td width="20%" class="dialogTd" align="right" >职务：</td>
				<td width="80%" class="dialogTd" colspan="3" >
				<input type="text" id="zw" name="zw" value="${entity.zw}" class="easyui-validatebox inputxtext " 
				style="width:620px;" data-options="required:false,validType:['maxLength[30]']"   maxlength="30"/></td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right" >分管工作描述：</td>
				<td width="80%" class="dialogTd" colspan="3" >
				<input type="text" id="fggzms" name="fggzms" value="${entity.fggzms}" class="easyui-validatebox inputxtext " 
				style="width:620px;" data-options="required:false,validType:['maxLength[100]']"   maxlength="100"/></td>
			</tr>			
			
			
			
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">作用情况：</td>
				<td width="30%" class="dialogTd" colspan="3">
				<input type="text" id="zyqk" name="zyqk" value="${entity.zyqk}" maxlength="100" 
				class="easyui-validatebox inputxtext " style="width:620px;" data-options="required:false"   /></td>
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
function doInit(paramArray) {
	$("#sqid").val(paramArray["sqid"]);
}

function beforeSubmit() {
}


function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}

var _zjhm = "";
$(document).ready(function(){
	$("#zjhm").bind("blur",function(e){	check();});
	initAddressSearch('jzd1', {}, 'zbhdzmlpdm', 'zbhdzmlpxz', 'jzd2', {text:'zbhdzxz',dzxzqh:'zbhdzssxdm',id:'zbhdzdm'}, null, null);
	var flag = document.getElementById("flag").value;
	if(flag=="add"){
		if(typeof ($("#zjlx").combo("getValue")) == "undefined"){
			$("#zjlx").combobox("setValue","111");
		}
	}else {
	
	}
	
});
/**根据证件种类 设置证件号码验证 与人员基本信息只读状态*/
function setPassPort(newVal,oldVal){
	if(oldVal!=""){
		$("#zjhm").val("");
	}
	if(!newVal){
		return;
	}
	
	if(newVal=="111"||newVal=="335"||newVal=="112"){
		$("#zjhm").validatebox({validType:['sfzh']});
	//	setInputReadonly('jg',true);
	//	setInputReadonly('xb',true);
	//	setInputReadonly('mzdm',true);
	//	setInputReadonly('csrq',true);
	//	setInputReadonly('dz_jzdzxz',true);
	}else {
		$("#zjhm").validatebox({validType:['maxLength[30]']});
	//	setInputReadonly('jg',false);
	//	setInputReadonly('xb',false);
	//	setInputReadonly('mzdm',false);
	//	setInputReadonly('csrq',false);
	//	setInputReadonly('dz_jzdzxz',false);
	}
	
}
/**
 * 根据证件种类与号码 ，进行人员比对，复用
 */
function check(){
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
			if(data.ryRyjbxxb.xm != ""){
				setInputReadonly("xm", true);
			}
		}
		},
		complete:function(){
			_zjhm = $("#zjhm").val();
			$('#dataForm').form('validate');
			$(".lodingimg").hide();
		}
	});
}
function resetTable(){
	 document.forms["dataForm"].reset();
	$("#xm").val();
	setInputReadonly("xm",false);
}
</script>