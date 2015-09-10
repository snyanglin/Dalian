<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Pargma" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<title>实有房屋编辑</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>syfw/${entity.id}" id="syfwForm" name="dataForm" method="post">
  	  <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
					<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
						<input type="hidden" id="pk" name="fwjbxxb.id" value="${entity.id}" />
						<input type="hidden" id="zrqdm" name="fwjbxxb.zrqdm" value="${zrqdm}" />
						<tr class="dialogTr">
		    	      		<td width="20%" class="dialogTd" align="right" style="color: #FF0000;font-weight: bold;">房屋基本信息：</td>
		    	      		<td width="80%" class="dialogTd" colspan="3"></td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">房屋地址：</td>
							<td width="50%" class="dialogTd" colspan="2" id="fwdztd">
								<input class="easyui-validatebox" id="syfw_fwdz1" style="width:400px;" value="${entity.fwdz_mlpxz}" >
				    		</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-validatebox" id="syfw_fwdz2" style="width:200px;" value="${fn:replace(entity.fwdz_dzxz, entity.fwdz_mlpxz, '')}" >
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">房屋性质：</td>
							<td width="30%" class="dialogTd" >
								<input class="easyui-combobox" type="text" id="fwcqxzzldm" name="fwjbxxb.fwcqxzzldm" style="width:200px;" value="${entity.fwcqxzzldm}"
								data-options="url:contextPath+'/common/dict/ZA_D_FWCQXZZLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
							</td>
							<td width="20%" class="dialogTd" align="right">产权证号：</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-validatebox" type="text" id="fwcqzh" name="fwjbxxb.fwcqzh" style="width:200px;" value="${entity.fwcqzh}"
								maxlength="30" data-options="tipPosition:'right'"/>
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">房屋类别：</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-combobox" type="text" id="fwlbdm" name="fwjbxxb.fwlbdm" style="width:200px;" value="${entity.fwlbdm}"
								data-options="url:contextPath +'/common/dict/ZA_D_FWLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
							</td>
							<td width="20%" class="dialogTd" align="right">房屋用途：</td>
							<td width="30%" class="dialogTd" >
								<input class="easyui-combobox" type="text" id="fwytdm" name="fwjbxxb.fwytdm" style="width:200px;" value="${entity.fwytdm}"
								data-options="url:contextPath+'/common/dict/ZA_D_FWYTDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">房屋间数：</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-validatebox" type="text" id="fwjs" name="fwjbxxb.fwjs" style="width:170px;" value="${entity.fwjs}"
								data-options="validType:['naturalNumber'],tipPosition:'right'" maxlength="5" />（间）
							</td>
							<td width="20%" class="dialogTd" align="right">房屋面积：</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-validatebox" type="text" id="fwmj_mjpfm" name="fwjbxxb.fwmj_mjpfm" style="width:130px;" value="${entity.fwmj_mjpfm}"
								data-options="validType:['money'],invalidMessage:'房屋面积为两位小数的数字，请重新输入！',tipPosition:'left'" maxlength="20"/>（平方米）
							</td>
						</tr>
						<tr>
							<td width="20%" class="dialogTd" align="right">是否出租房：</td>
							<td width="30%" class="dialogTd">	
								<input class="easyui-combobox" type="text" id="sfczfw" name="fwjbxxb.sfczfw" style="width:200px;" value="${entity.sfczfw}"
								data-options="url:contextPath+'/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"/>
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">所属单位：</td>
							<td width="80%" class="dialogTd" colspan="3" >
							<input type='hidden' name='fwjbxxb.fwssdw_dwid' id="fwssdw_dwid" value="${entity.fwssdw_dwid}"/>
							<input type="hidden" id="fwssdw_dwmc" name='fwjbxxb.fwssdw_dwmc'  value="${entity.fwssdw_dwmc}"/>
							<input class="easyui-combobox" value="${entity.fwssdw_dwmc}" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" id="gzdw-box" maxlength="50" style="width:610px;"/>
							</td>
							
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">备注：</td>
							<td width="80%" class="dialogTd" colspan="3">
								<textarea id="bz"   title="备注" name="fwjbxxb.bz"
					       			class="easyui-validatebox" style="width: 610px; height:50px;" 
									data-options="required:false,charSet:'halfUpper',validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'right'"
					       		>${entity.bz }</textarea>
		       				</td>
						</tr>
						<tr class="dialogTr">
		    	      		<td width="20%" class="dialogTd" align="right" style="color: #FF0000;font-weight: bold;">房屋房主信息：</td>
		    	      		<td width="80%" class="dialogTd" colspan="3"></td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">证件种类：</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-combobox" type="text" id="fz_cyzjdm" name="fwjbxxb.fz_cyzjdm" style="width:200px;" value="${entity.fz_cyzjdm}" maxlength="100"
								data-options="required:true,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:fzzjdm_onchange" />
							</td>
							<td width="20%" class="dialogTd" align="right">证件号码：</td>
					    	<td width="30%" class="dialogTd">
					    	<input class='easyui-validatebox' type='text' id="fz_zjhm" name='fwjbxxb.fz_zjhm' maxlength="30" value="${entity.fz_zjhm}" style="width:200px;float:left;" 
			    	        data-options="required:true,charSet:'halfUpper',validType:['sfzh'],tipPosition:'left'"/><div class="lodingimg" id="fz_LoadDiv"></div></td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">姓名：</td>
							<td width="30%" class="dialogTd"><input type="hidden" id="fz_ryid" name="fwjbxxb.fz_ryid" value="${entity.fz_ryid}" />
								<input class="easyui-validatebox" type="text" id="fz_xm" name="fwjbxxb.fz_xm" style="width:200px;" value="${entity.fz_xm}" maxlength="50"
								data-options="required:true,charSet:'halfUpper'" />
							</td>
							<td width="20%" class="dialogTd" align="right">联系电话：</td>
					    	<td width="30%" class="dialogTd">
						    	<input class='easyui-validatebox' type='text' id="fz_lxdh" name='fwjbxxb.fz_lxdh' maxlength="18" value="${entity.fz_lxdh}" style="width:200px;" 
				    	        data-options="required:true,charSet:'halfUpper',validType:['phone'],tipPosition:'left'" onblur="checkLxdh('fz_lxdh','fz_zjhm')"/></td>
						</tr>
						<tr class="dialogTr">  
							<td width="20%" class="dialogTd" align="right">外文姓：</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-validatebox" type="text" id="fz_wwx" name="fwjbxxb.fz_wwx" style="width:200px;" value="${entity.fz_wwx}" maxlength="40"
								data-options="required:false,validType:['letterOrSpace']" />
							</td>
							<td width="20%" class="dialogTd" align="right">外文名：</td>
					    	<td width="30%" class="dialogTd">
						    	<input class='easyui-validatebox' type='text' id="fz_wwm" name='fwjbxxb.fz_wwm' maxlength="40" value="${entity.fz_wwm}" style="width:200px;" 
				    	        data-options="required:false,validType:['letterOrSpace'],tipPosition:'left'"/></td>
						</tr>
						<tr class="dialogTr">
		    	      		<td width="20%" class="dialogTd" align="right" style="color: #FF0000;font-weight: bold;">房屋托管人信息：</td>
		    	      		<td width="80%" class="dialogTd" colspan="3"></td>
						</tr>
						<tr class="dialogTr">  
							<td width="20%" class="dialogTd" align="right">证件种类：</td>
							<td width="30%" class="dialogTd"><input type="hidden" id="tgr_ryid" name="fwjbxxb.tgr_ryid" value="${entity.tgr_ryid}" />
								<input class="easyui-combobox" type="text" id="tgr_cyzjdm" name="fwjbxxb.tgr_cyzjdm" style="width:200px;" value="${entity.tgr_cyzjdm}" maxlength="100"
								data-options="required:false,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:tgrzjdm_onchange" />
							</td>
							<td width="20%" class="dialogTd" align="right">证件号码：</td>
					    	<td width="30%" class="dialogTd">
						    	<input class='easyui-validatebox' type='text' id="tgr_zjhm" name='fwjbxxb.tgr_zjhm' maxlength="30" value="${entity.tgr_zjhm}" style="width:200px;float:left;" 
				    	        data-options="required:false,charSet:'halfUpper',validType:['sfzh'],tipPosition:'left'"/><div class="lodingimg" id="tgr_LoadDiv"></div></td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">姓名：</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-validatebox" type="text" id="tgr_xm" name="fwjbxxb.tgr_xm" style="width:200px;" value="${entity.tgr_xm}" maxlength="50"
								data-options="required:false,charSet:'halfUpper'" />
							</td>
							<td width="20%" class="dialogTd" align="right">联系电话：</td>
					    	<td width="30%" class="dialogTd">
						    	<input class='easyui-validatebox' type='text' id="tgr_lxdh" name='fwjbxxb.tgr_lxdh' maxlength="18" value="${entity.tgr_lxdh}" style="width:200px;" 
				    	        data-options="required:false,charSet:'halfUpper',validType:['phone'],tipPosition:'left'" onblur="checkLxdh('tgr_lxdh','tgr_zjhm')"/></td>
						</tr>
						<tr class="dialogTr">  
							<td width="20%" class="dialogTd" align="right">外文姓：</td>
							<td width="30%" class="dialogTd">
								<input class="easyui-validatebox" type="text" id="tgr_wwx" name="fwjbxxb.tgr_wwx" style="width:200px;" value="${entity.tgr_wwx}" maxlength="40"
								data-options="required:false,validType:['letterOrSpace']" />
							</td>
							<td width="20%" class="dialogTd" align="right">外文名：</td>
					    	<td width="30%" class="dialogTd">
						    	<input class='easyui-validatebox' type='text' id="tgr_wwm" name="fwjbxxb.tgr_wwm" maxlength="40" value="${entity.tgr_wwm}" style="width:200px;" 
				    	        data-options="required:false,validType:['letterOrSpace'],tipPosition:'left'"/></td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">与房主关系：</td>
							<td width="30%" class="dialogTd" >
								<input class="easyui-combotree" type="text" id="tgr_yfzgx_rygxdm" name="fwjbxxb.tgr_yfzgx_rygxdm" style="width:200px;" value="${entity.tgr_yfzgx_rygxdm}"
								data-options="url:contextPath+'/common/dict/XZ_D_RYGXDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true,required:false,tipPosition:'right'"/>
							</td>
						</tr>
			    	</table></div>
		    </form>
</div>	
</html>			
<script type="text/javascript" >
var _p;

function doInit(paramArray) {
	_p = paramArray["_p"];
	setInputReadonly("syfw_fwdz1", true); 
	setInputReadonly("syfw_fwdz2", true); 
	setInputReadonly("sfczfw", true); 
	
	var newVal = "${entity.fz_cyzjdm}";
	if (newVal == "111" || newVal == "112" || newVal == "335" || newVal == "") {
		$("#fz_zjhm").validatebox({validType:['sfzh']});
	}else {
		$("#fz_zjhm").validatebox({validType:['maxLength[30]']});
	}
	
	newVal = "${entity.tgr_cyzjdm}";
	if (newVal == "111" || newVal == "112" || newVal == "335" || newVal == "") {
		$("#tgr_zjhm").validatebox({validType:['sfzh']});
	}else {
		$("#tgr_zjhm").validatebox({validType:['maxLength[30]']});
	}
}
function beforeSubmit() {
}

function afterSubmit(arr) {
	if (arr["saveID"]) {
		$("#pk").val(arr["saveID"]);
	}
	setFormDataToSpan($("body"),_p);
	window.parent.location.reload();
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
	var textareaSelector = containObject.find('textarea.easyui-validatebox');
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
$(document).ready(function(){
	//人员信息复用人员基本表
	$("#fz_zjhm").bind("blur",function(e){ checkRyxx("fz_",true); });
	$("#tgr_zjhm").bind("blur",function(e){ checkRyxx("tgr_",true); });
	initDepartmentSearch('gzdw-box', {glpcsid: ''}, 'fwssdw_dwid', 'fwssdw_dwmc', {},'queryFrByDwid');
});

var _zjhm = "";
function checkRyxx(rylx,isReat){ 
	if(!$("#"+rylx+"zjhm").validatebox("isValid") || $("#"+rylx+"zjhm").val()==""){
		return;
	}
	if(isReat){
		if($("#"+rylx+"zjhm").val()!="" && $("#fz_zjhm").val() == $("#tgr_zjhm").val()){
			$("#"+rylx+"zjhm").val("");
			topMessager.alert(MESSAGER_TITLE, "房主与托管人不能相同！", "warn");
			return ;
		}
	}
	$("#"+rylx+"LoadDiv").show();//显示加载进度图片
	$.ajax({
		type:"POST",
		url:"<%= basePath%>ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#"+rylx+"zjhm").val()+"&cyzjdm="+$("#"+rylx+"cyzjdm").val(),
		success:function(data){
			if (data &&data.ryRyjbxxb) {
				if(data.ryRyjbxxb.xm !=null){
					$("#"+rylx+"ryid").val(data.ryRyjbxxb.id);
					$("#"+rylx+"xm").val(data.ryRyjbxxb.xm);
					$("#"+rylx+"xm").validatebox({required:true});
				}
				if(data.ryRyjbxxb.lxdh !=null){
					$("#"+rylx+"lxdh").val(data.ryRyjbxxb.lxdh);
					$("#"+rylx+"lxdh").validatebox({required:true});
				}
				//添加需要复用的值
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete:function(){
			_zjhm = $("#"+rylx+"zjhm").val();
			$("#"+rylx+"LoadDiv").hide();//复用完毕隐藏加载进度图片
		}
	});
}
/**
 检查一个地址仅可有一个房屋
*/
function checkDzcf(){
	$.ajax({
		type:"GET",
		url:"<%= basePath%>syfw/checkdz/"+$("#syfw_dz_fwdzid").val(),
		dataType:"json",
		success:function(data){
			if (data) {
				$("#syfw_fwdz2").combobox("setValue","");
				topMessager.alert(MESSAGER_TITLE, "该地址下已有房屋！", "warn");
			}
		},
		complete:function(){
		
		}
	});
}
function fzzjdm_onchange(newVal, oldVal) {
	if (newVal) {
	}else {
		newVal = "";
	}
	if (newVal == "111" || newVal == "112" || newVal == "335" || newVal == "") {
		$("#fz_zjhm").validatebox({validType:['sfzh']});
	}else {
		$("#fz_zjhm").validatebox({validType:['maxLength[30]']});
	}
}
function tgrzjdm_onchange(newVal, oldVal) {
	if (newVal) {
	}else {
		newVal = "";
	}
	if (newVal == "111" || newVal == "112" || newVal == "335" || newVal == "") {
		$("#tgr_zjhm").validatebox({validType:['sfzh']});
	}else {
		$("#tgr_zjhm").validatebox({validType:['maxLength[30]']});
	}
}
function queryFrByDwid(){
	$.ajax({
		type:"GET",
		url:"<%= basePath%>sydw/"+$("#fwssdw_dwid").val()+"/fr",
		dataType:"json",
		success:function(data){
			if (data) {
				$("#fz_cyzjdm").combobox("setValue",data.cyzjdm);
				$("#fz_zjhm").val(data.zjhm);
				$("#fz_ryid").val(data.ryid);
				$("#fz_xm").val(data.xm);
				$("#fz_lxdh").val(data.lxdh);
			}
		},
		complete:function(){
		
		}
	});
}
</script>