<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>社区委员会成员</title>
</head>

<div class="easyui-layout" data-options="fit:true">
   <form action="<%=basePath%>sqwyhcyb/saveSqwyhcyb" id="dataForm" name="dataForm" method="post">
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<input type="hidden" id="sqid" name="sqid" value="${entity.sqid}" />
				<input type="hidden" id="ryid" name="ryid" value="${entity.ryid}" />
				<input type="hidden" id="sqjwsid" name="sqjwsid" value="${entity.sqjwsid}">
				
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">常用证件：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text" id="cyzjdm" name="cyzjdm" style="width:200px;" value="${entity.cyzjdm}"
						data-options="url:contextPath+'/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right',
										onChange:setPassPort"/>
					</td>
					<td width="20%" class="dialogTd" align="right">证件号码：</td>
					<td width="30%" class="dialogTd" align="left">
						<input class="easyui-validatebox" type="text" id="zjhm" name="zjhm" style="width:200px;float:left;" value="${entity.zjhm}" maxlength="30"
						data-options="required:true,tipPosition:'left'"/>
						<div class="lodingimg" id="sqwyhcybLodingDiv"></div>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">姓名：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="xm" name="xm" style="width:200px;" value="${entity.xm}" maxlength="20"
			    		data-options="required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">性别：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:200px;" value="${entity.xbdm}" maxlength="1"
			    		data-options="url:contextPath+'/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
			    	</td>
			    </tr>
			    
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">文化程度：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combotree" type="text" id="whcddm" name="whcddm" style="width:200px;" value="${entity.whcddm}" maxlength="2"
						data-options="url:contextPath+'/common/dict/D_BZ_WHCD.js',onlyLeaf:true,multiple:false,required:false,panelWidth:200,
							method:'get',editable:true,lines:true"/>
					</td>
					<td width="20%" class="dialogTd" align="right">政治面貌：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text" id="zzmmdm" name="zzmmdm" style="width:200px;" value="${entity.zzmmdm}" maxlength="2"
						data-options="url:contextPath+'/common/dict/D_BZ_ZZMM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">联系电话：</td>
					<td width="30%" class="dialogTd" >
						<input class="easyui-validatebox" type="text" id="lxdh" name="lxdh" style="width:200px;" value="${entity.lxdh}" maxlength="18"
						data-options="required:false,validType:['phone'],tipPosition:'right'"/>
					</td>
				</tr>
				
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">职务：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<input class="easyui-validatebox" type="text" id="zw" name="zw" style="width:629px;" value="${entity.zw}" maxlength="30"
						data-options="required:false,tipPosition:'right'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">分管工作描述：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<input class="easyui-validatebox" type="text" id="fggzms" name="fggzms" style="width:629px;" value="${entity.fggzms}" maxlength="100"
						data-options="required:false,tipPosition:'right'"/>
					</td>
				</tr>		
						
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">家庭住址：</td>
					<td width="50%" class="dialogTd" colspan="2">
						<input class="easyui-combobox" id="jtzz1" style="width:400px;" value="${entity.dz_jtzzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
			    		<input type='hidden' name='dz_jtzzmlpdm' id="jtzz_jtzzmlpdm" value="${entity.dz_jtzzmlpdm}"/>
			    		<input type='hidden' name='dz_jtzzmlpxz' id="jtzz_jtzzmlpxz" value="${entity.dz_jtzzmlpxz}"/>
		    		</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox" id="jtzz2" style="width:200px;" value="${fn:replace(entity.dz_jtzzxz, entity.dz_jtzzmlpxz, '')}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_jtzzdm' id='jtzz_jtzzdm' value="${entity.dz_jtzzdm}" />
				    	<input type='hidden' name='dz_jtzzssxdm' id='jtzz_jtzzssxdm' value="${entity.dz_jtzzssxdm}" />
				    	<input type='hidden' name='dz_jtzzxz' id='jtzz_jtzzxz' value="${entity.dz_jtzzxz}" /> 
					</td>
				</tr>
				<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">备注：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="bz" name="bz" style="width: 629px; height:48px;"
						data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',required:false,tipPosition:'left',required:false">${entity.bz}</textarea>
					</td>
		    	</tr>
	    	</table>
	    </div>
    </form>
</div>

</html>
<script type="text/javascript" >

function doInit(paramArray) {
	$("#sqid").val(paramArray["sqid"]);
	if(typeof ($("#cyzjdm").combo("getValue")) == "undefined"){
		$("#cyzjdm").combobox("setValue","111");
	}

}

function beforeSubmit(){
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}


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
	clearValue();
	
	
}
var _zjhm = "";
$(document).ready(function(){
	initAddressSearch('jtzz1', {}, 'jtzz_jtzzmlpdm', 'jtzz_jtzzmlpxz', 'jtzz2', {text:'jtzz_jtzzxz',dzxzqh:'jtzz_jtzzssxdm',id:'jtzz_jtzzdm'}, null, null);
	$("#zjhm").bind("blur",function(e){	check();});
	if($('#pk').val()==null){
		if($('#cyzjdm').val() == '111' && $('#zjhm').val() != ''){
			check();
		}
	}
	if($('#cyzjdm').val()=="111"||$('#cyzjdm').val()=="112"||$('#cyzjdm').val()=="335"){
		$("#zjhm").validatebox({validType:['sfzh']});
	}
});

function check(){
	if(!$("#cyzjdm").combobox("isValid")){
		return;
	}
	if(!$("#zjhm").validatebox("isValid")){
		//$("#zjhm").focus();
		return;
	}
	
	if($("#zjhm").val() == _zjhm){
		return;
	}
	
	//clearValue();
	
	//验证人员唯一  begin
	var ifExist = false;
	$.ajax({
		type:"POST",
		url:"<%= basePath%>sydwgl/checkIfExistByCol",
		async:false,
		dataType:"json",
		data:{colMap:'{\'tableName\':\'zaff_sqwyhcyb\',\'colList\':[{\'colName\':\'sqid\',\'colValue\':\''+$('#sqid').val()+'\'},{\'colName\':\'zjhm\',\'colValue\':\''+$('#zjhm').val()+'\'},{\'colName\':\'xt_zxbz\',\'colValue\':\'0\'}]}'},
		success:function(data){
			if (data && data.count > 0) {
				$.messager.alert("提示","该人员身份证号已存在,请重新输入","",
				function(){
					$('#zjhm').val('');
					$('#zjhm').focus();
				});
				ifExist = true;
			}
		}
	});
	if(ifExist){
		return;
	}
	//end
	
	$(".lodingimg").show();
	$.ajax({
		type:"POST",
		url:contextPath+"/ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#zjhm").val()+"&cyzjdm="+$("#cyzjdm").val(),
		success:function(data){
			if (data && data.ryRyjbxxb) {
				debugger;
				if(data.ryRyjbxxb.xm != ""){
					$("#xm").val(data.ryRyjbxxb.xm);
				}
				$("#ryid").val(data.ryRyjbxxb.id);
				if(data.ryRyjbxxb.xbdm != ""){
					$("#xbdm").combobox("setValue",data.ryRyjbxxb.xbdm);
				}
				if(data.ryRyjbxxb.xldm != ""){
					$("#whcddm").combotree("setValue",data.ryRyjbxxb.xldm);
				}
				if(data.ryRyjbxxb.zzmmdm != ""){
					$("#zzmmdm").combobox("setValue",data.ryRyjbxxb.zzmmdm);
				}
				if(data.ryRyjbxxb.lxdh != ""){
					$("#lxdh").val(data.ryRyjbxxb.lxdh);
				}
				/*if(data.ryjbxxb.dz_jzdmlpdm != ""){
					$("#jtzz_jtzzmlpdm").val(data.ryRyjbxxb.dz_jzdmlpdm);
				}
				if(data.ryjbxxb.dz_jzdmlpxz != ""){
					$("#jtzz_jtzzmlpxz").val(data.ryRyjbxxb.dz_jzdmlpxz);
				}
				if(data.ryjbxxb.dz_jzdxz != ""){
					$("#jtzz_jtzzxz").val(data.ryRyjbxxb.dz_jzdzxz);
				}
				if(data.ryjbxxb.dz_jzdzdm != ""){
					$("#jtzz_jtzzdm").val(data.ryRyjbxxb.dz_jzdzdm);
				}
				if(data.ryjbxxb.dz_jzdzssxdm != ""){
					$("#jtzz_jtzzssxdm").val(data.ryRyjbxxb.dz_jzdzssxdm);
				}
				*/
				if(data.ryRyjbxxb.xm != ""){
					setInputReadonly("xm", true);
				}
				if(data.ryRyjbxxb.xbdm != ""){
					setInputReadonly("xbdm", true);
				}
				if(data.ryRyjbxxb.xldm != ""){
					setInputReadonly("whcddm", true);
				}
				if(data.ryRyjbxxb.zzmmdm != ""){
					setInputReadonly("zzmmdm", true);
				}
				if(data.ryRyjbxxb.lxdh != ""){
					setInputReadonly("lxdh", true);
				}
				
			/*	if(data.ryjbxxb.dz_jzdmlpxz != ""){
					$("#jtzz1").combobox("setValue",data.ryRyjbxxb.dz_jzdmlpxz);
					setInputReadonly("jtzz1", true);
				}
				if(data.ryjbxxb.dz_jzdzxz != ""){
					$("#jtzz2").combobox("setValue", data.ryRyjbxxb.dz_jzdzxz.replace(data.ryjbxxb.dz_jzdmlpxz, ''));
					setInputReadonly("jtzz2", true);
				}
			*/	
				
			}else {
				
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
	setInputReadonly("xm", false);
	setInputReadonly("xbdm", false);
	setInputReadonly("whcddm", false);
	setInputReadonly("zzmmdm", false);
	setInputReadonly("lxdh", false);
	setInputReadonly("jtzz1", false);
	setInputReadonly("jtzz2", false);
	$("#xm").val("");
	$("#whcddm").combobox("clear");
	$("#zzmmdm").combobox("clear");
	$("#lxdh").val("");
	$("#xbdm").combobox("clear");
	$("#jtzz1").combobox("clear");
	$("#jtzz2").combobox("clear");
	$("#bz").val("");
	
	$("#cyzjdm").combobox("setValue","111");
}
function clearValue(){
	$("#xm").val("");
	$("#whcddm").combobox("clear");
	$("#lxdh").val("");
	$("#xbdm").combobox("clear");
	$("#jtzz1").combobox("clear");
	$("#jtzz2").combobox("clear");
}

function resetForm(){
	setInputReadonly("xm", false);
	setInputReadonly("xbdm", false);
	setInputReadonly("whcddm", false);
	setInputReadonly('zzmmdm', false);
	setInputReadonly('lxdh', false);
	setInputReadonly('jtzz1', false);
	setInputReadonly('jtzz2', false);
	$('#dataForm').form('reset');
	$(dataForm.id).val('');
	$("#cyzjdm").combobox("setValue","111");
}


</script>