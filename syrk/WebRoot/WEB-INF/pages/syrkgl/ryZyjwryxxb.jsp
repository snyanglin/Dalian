<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>主要交往人员信息</title>
</head>
<body>
	<form action="" id="dataForm" name="dataForm" method="post" >
	
		<input type="hidden" id="_method" name="_method" value=""/>
		<input type='hidden' name='id' id="pk" value="${entity.id}" />
		<input type="hidden" id="ryid" name="ryid" value="${entity.ryid}"/>
		<input type="hidden" id="zyjwry_ryid" name="zyjwry_ryid" value="${entity.zyjwry_ryid}"/>
		
		<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">证件种类：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="cyzjdm" name="cyzjdm" style="width:200px;" value="${entity.cyzjdm }"
					data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:zjhmCheck" />
		    	</td>
				<td width="20%" class="dialogTd" align="right">证件号码：</td>
		    	<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox" type="text" id="zjhm" name="zjhm" style="width:200px;float:left;" value="${entity.zjhm }" maxlength="30" 
		    		data-options="required:true,tipPosition:'left'"/><div class="lodingimg" id="jbxxLoadDiv"></div></td>
	    	</tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xm" name="xm" style="width:200px;" value="${entity.xm }" maxlength="20" 
		    		data-options="required:true,tipPosition:'right'"/>
		    	</td>
				<td width="20%" class="dialogTd" align="right">性别：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:200px;" value="${entity.xbdm }"
					data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'"/>
				</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">民族：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="mzdm" name="mzdm" style="width:200px;" value="${entity.mzdm }"
					data-options="url: contextPath + '/common/dict/D_BZ_MZ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="csrq" id="csrq" class="easyui-validatebox" style="width: 200px;" value="${entity.csrq }"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">籍贯国家/地区：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="jggjdqdm" id="jggjdqdm"  class="easyui-combobox" style="width:200px;" value="${entity.jggjdqdm }"
	    			data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',dataFilter:'',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'">
		    	</td>
				<td width="20%" class="dialogTd" align="right">籍贯省市县：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="jgssxdm" id="jgssxdm"  class="easyui-combobox" style="width:200px;" value="${entity.jgssxdm }"
	    			data-options="mode:'remote',dataFilter:'.*[^00]$',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'">
		    	</td>
		    </tr>
			<tr class="dialogTr" id="jzdz">
				<td width="20%" class="dialogTd" align="right" >居住地址：</td>
				<td width="50%" class="dialogTd" colspan="2">
				<input class="easyui-combobox" id="jzd1" style="width:400px;" value="${entity.jzd_mlpxz}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				<input type='hidden' name='jzd_mlpdm' id="jzd_mlpdm" value="${entity.jzd_mlpdm}"/>
				<input type='hidden' name='jzd_mlpxz' id="jzd_mlpxz" value="${entity.jzd_mlpxz}"/>
				</td>
				<td width="30%" class="dialogTd" >
					<input class="easyui-combobox" id="jzd2" style="width:200px;" value='${fn:replace(entity.jzd_dzxz, entity.jzd_mlpxz, "")}' data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    <input type='hidden' name='jzd_dzid' id='jzd_dzid' value="${entity.jzd_dzid}" />
				    <input type='hidden' name='jzd_xzqhdm' id='jzd_xzqhdm' value="${entity.jzd_xzqhdm}" />
				    <input type='hidden' name='jzd_dzxz' id='jzd_dzxz' value="${entity.jzd_dzxz}" /> 
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">联系电话：</td>
		    	<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox" type="text" id="lxdh" name="lxdh" style="width:200px;float:left;" value="${entity.lxdh }" maxlength="100" 
		    		data-options="required:false,validType:['phone'],tipPosition:'left'" /></td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">工作单位：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input type='hidden' name='gzdwid' id="gzdwid" value="${entity.gzdwid}"/>
		    	<input type='hidden' name='gzdw' id="gzdw" value="${entity.gzdw}"/>
		    	<input class="easyui-combobox" name="gzdw-box" id="gzdw-box" value="${entity.gzdw}" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" maxlength="50"  style="width:618px;" /></td>
	    	</tr>
	    	<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">职业类别：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="zylbdm" name="zylbdm" value="${entity.zylbdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_ZYFLYDM.js',onlyLeaf:true,multiple:false,panelWidth:300,method:'get',editable:true,lines:true"></td>
		    	<td width="20%" class="dialogTd" align="right">职业：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zy" name="zy" style="width:200px;" value="${entity.zy }" maxlength="60" 
		    		data-options="required:false,tipPosition:'left'"/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">人员关系：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="rygxdm" id="rygxdm" class="easyui-combotree" style="width:200px;" value="${entity.rygxdm }"
	    			data-options="url: contextPath + '/common/dict/XZ_D_RYGXDM.js',onlyLeaf:true,dataFilter:'^2.*',multiple:false,method:'get',editable:true,lines:true"/></td>
		    	</td>                                                                                       
		    </tr>
    	</table>
    </form>
</body>
<script type="text/javascript">
function doInit(paramArray){
	initComboBox("jgssxdm", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 
	//编辑时 不允许修改证件种类和证件号码
	if ($("#pk").val() != "") {
		setInputReadonly("cyzjdm", true);
		setInputReadonly("zjhm", true); 
	}
	
	
}

function beforeSubmit() {
	if ($("#jzd_mlpdm").val() == "") {
		topMessager.alert("", "居住地必须为标准地址，请重新选择！");
		var comboText = $("#jzd1").next(".combo").children(".combo-text");
		comboText.focus();
		return false;
	}
	if ($("#jzd2").combobox("getValue") == "") {
		topMessager.alert("", "居住地必须为标准地址，请重新选择！");
		var comboText = $("#jzd2").next(".combo").children(".combo-text");
		comboText.focus();
		return false;
	}
	
	if ($("#pk").val() == "") {
		var _count;
		$.ajax({
			type:"GET",
			url:"<%= basePath%>ryZyjwryxxb/queryCount",
			dataType:"json",
			data:"ryid="+$("#ryid").val()+"&cyzjdm="+$("#cyzjdm").val()+"&zjhm="+$("#zjhm").val(),
			async:false,
			success:function(data){
				if(data && data != null && data != undefined && data == 1){
					$.messager.alert('确认对话框', '该主要交往人员已存在！请重新输入', 'warning', function(){
						$("#zhhm").focus();
					});
					_count = 1;
				}
			},
			complete:function(){}
		});
		if(_count == 1){
			return false;
		}
		$("#_method").val('');
		$("#dataForm").attr('action', contextPath + '/ryZyjwryxxb/save');
	}
	else {

		$("#_method").val('PUT');
		$("#dataForm").attr('action', contextPath + '/ryZyjwryxxb/' + $("#pk").val());
	}
	
	//验证与其他人员联系方式重复
	var _xm;
	$.ajax({
		type: "POST",
		url: contextPath + "/ryRylxfsxxb/check",
		dataType: "json",
		data: "lxfs="+$("#lxfs").val()+"&ryid="+$("#ryid").val(),
		async:false,
		success: function(data){
			if (data && data.xm) {
				if (data.xm != ""||data.xm!=null) {
					topMessagerAlert('数据质量提醒', '电话号码：'+data.lxfs+'<br><br>已于'+data.djsj+'在办理业务中<br><br>登记为【'+data.xm+'】的联系电话，<br><br>与当前录入信息不符');
					_xm = data.xm;
				}
			}
		}
	});
	if(_xm != "" && _xm != null){
		return false;
	}

	
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}

var _zjhm = "";

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
	if(newValue == "111" || newValue=="112" || newValue == "335"){ 
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
	$("#zyjwry_ryid").val("");
	$("#xm").val("");
	$("#xbdm").combobox("setValue","");
	$("#csrq").val("");
	$("#mzdm").combobox("setValue","");
	$("#jggjdqdm").combobox("setValue","");
	$("#jgssxdm").combobox("setValue","");
	$("#jzd1").combobox('setValue', "");
	$("#jzd2").combobox('setValue', "");
	$("#jzd_mlpdm").val("");
	$("#jzd_mlpxz").val("");
	$("#jzd_dzxz").val("");
	$("#jzd_xzqhdm").val("");
	$("#jzd_dzdm").val("");
	setInputReadonly("xm", false);
	setInputReadonly("csrq", false);
	setInputReadonly("xbdm", false);
	setInputReadonly("mzdm", false);
	setInputReadonly("jzd1", false);
	setInputReadonly("jzd2", false);
}

//根据证件种类与号码 ，进行人员复用
function jbxx_zjhm_onblur() {
	if (!$("#cyzjdm").combo("isValid")){
		return;
	}
	if (!$("#zjhm").validatebox("isValid")){
		return;
	}
	var _zjhm = $("#zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if ($("#zjhm").val() == _zjhm) {
		return;
	}
	$("#jbxxLoadDiv").show();
	$.ajax({
		type: "POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType: "json",
		data:"zjhm=" + $("#zjhm").val() + "&cyzjdm=" + $("#cyzjdm").val(),
		success: function(data) {
			if (data && data.ryRyjbxxb) {
				$("#zyjwry_ryid").val(data.ryRyjbxxb.id);
				$("#xm").val(data.ryRyjbxxb.xm);
				$("#xm").validatebox("validate");
				$("#xbdm").combobox("setValue",data.ryRyjbxxb.xbdm);
				$("#csrq").val(data.ryRyjbxxb.csrq);
				$("#jbxx_csrq").validatebox("validate");
				$("#mzdm").combobox("setValue", data.ryRyjbxxb.mzdm);
				$("#lxdh").val(data.ryRyjbxxb.lxdh);
				if (data.ryRyjbxxb.jggjdqdm != "") {
					$("#jggjdqdm").combobox("setValue", data.ryRyjbxxb.jggjdqdm);
				}
				$("#jgssxdm").combobox("setValue", data.ryRyjbxxb.jgssxdm);
				$("#zylbdm").combotree("setValue", data.ryRyjbxxb.zylbdm);
				$("#zy").val(data.ryRyjbxxb.zy);
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete: function() {
			$("#zjhm").attr("zjhm", $("#zjhm").val());
			$("#jbxxLoadDiv").hide();
		},
		error: function() {
		}
	});	
}

$(document).ready(function(){
	initAddressSearch("jzd1", {}, "jzd_mlpdm", "jzd_mlpxz", "jzd2", {text:"jzd_dzxz",dzxzqh:"jzd_xzqhdm",id:"jzd_dzid"}, null, null);
	initDepartmentSearch('gzdw-box', {glpcsid: ''}, 'gzdwid', 'gzdw', {});
	//复用人员基本表
	$("#zjhm").bind("blur",function(e){ jbxx_zjhm_onblur(); });
	var cyzjdm =$("#cyzjdm").val();
	//111-居民身份证,335-机动车驾驶证
	if(cyzjdm == "111" || cyzjdm=="112" || cyzjdm == "335"){ 
		$("#zjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#zjhm").validatebox({validType:['maxLength[30]']});
	}
});

</script>
</html>
