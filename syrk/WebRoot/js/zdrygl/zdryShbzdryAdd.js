var mainTabID = "${mainTabID}";
var invokeJSMethod = "${invokeJSMethod}";
$(document).ready(function(){
	hjdfj_onChange();
	jzdfj_onChange();
	
	setInputReadonly("hjd_dzms", true);
	$("#zjhm").attr("cyzjdm", cyzjdm);
	$("#zjhm").attr("zjhm", zjhm);

	// 大数据的下拉列表初始化
	initComboBox("csdssxdm", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 
	initComboBox("jgssxdm", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 
	initComboBox("hjdsssxdm", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 

	// 地址选择初始化
	//initAddressSearch("hjd1", {zrqdm:zrqdm}, "hjd_mlpdm", "hjd_mlpxz", "hjd2", {text:"hjd_dzxz",dzxzqh:"hjd_xzqhdm",id:"hjd_dzid"}, null, null);
	initAddressSearch("jzd1", {zrqdm:'#zrqdm'}, "dz_jzdzmlpdm", "dz_jzd_mlpxz", "jzd2", {text:"dz_jzdzxz",dzxzqh:"dz_jzdzssxdm",id:"dz_jzdzdm"}, null, null);
});
         
function hjdfj_onChange(newValue, oldValue) {
	var parentOrgCode = $('#hjd_ssxjgajgdm').combobox('getValue');
	if (parentOrgCode == "") {
		$('#hjd_sspcsdm').combobox('loadData', []);
	}
	else {
		var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=32&parentOrgCode=' + parentOrgCode;    
	    $('#hjd_sspcsdm').combobox('reload', url);
	}
}


function jzdfj_onChange(newValue, oldValue) {
	var parentOrgCode = $('#ssfxjdm').combobox('getValue');
	if (parentOrgCode == "") {
		$('#sspcsdm').combobox('loadData', []);
	}
	else {
		var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=32&parentOrgCode=' + parentOrgCode;    
	    $('#sspcsdm').combobox('reload', url);
	}
}

// 保存按钮
function saveForm() {
	if (!$("#shbForm").form("validate")) {
		return;
	}
	
		var bottonObject = "#saveButton";
		if (buttonDisabled(bottonObject) == false) {
			return false;
		}
		topMessager.confirm("", "您是否要保存当前的数据？", function(r) {
			if (r) {
				$("#shbForm").form("submit",{
					dataType : "json",
					onSubmit: function() {
					},
					success: function(result) {
						buttonEnabled(bottonObject);
						result = parseReturn(result);
						if (result.status == "success") { // 返回成功后执行的方法
							if (mainTabID != "" && invokeJSMethod != "") {
								topMessager.show({
									title: MESSAGER_TITLE,
									msg: result.message,
									timeout:1500
								});
								closeSelf();
								executeTabPageMethod(mainTabID, invokeJSMethod);
							}
							else {
								//var openUrl = contextPath + "/syrkEdit/"+ result.ryid + "/" + result.saveID + "/view";
								//location.href = openUrl;
							}
						}
						else {
							topMessager.alert(MESSAGER_TITLE, result.message, "error");
						}
					}
				});			
			}
			else {
				buttonEnabled(bottonObject);
			}
		});		
	
}

// 重置按钮
function resetForm() {
	document.forms["shbForm"].reset();
}

// 基本信息，证件种类改变事件
function cyzjdm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var cyzjdmValue = $("#cyzjdm").combobox("getValue");
	if (cyzjdmValue == "111" || cyzjdmValue == "112" || cyzjdmValue == "335") { // 身份证类型、临时身份证、机动车驾驶证
		$("#zjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#zjhm").validatebox({validType:['letterOrNum']});
	}
	setTimeout("zjhm_onblur();", 300);
}

// 基本信息，根据证件类型与号码 ，进行人员复用
function zjhm_onblur() {
	if (!$("#cyzjdm").combo("isValid")) {
		$("#jbxx_id").val("");
		return;
	}
	if (!$("#zjhm").validatebox("isValid")) {
		$("#jbxx_id").val("");
		return;
	}
	if ($("#zjhm").val() == "") {
		$("#jbxx_id").val("");
		return;
	}
	var _cyzjdm = $("#zjhm").attr("cyzjdm");
	if (!_cyzjdm) {
		_cyzjdm = "";
	} 
	var _zjhm = $("#zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if ($("#cyzjdm").combobox("getValue") == _cyzjdm && $("#zjhm").val() == _zjhm) {
		return;
	}
	$("#jbxxLoadDiv").show();
	$.ajax({
		type: "POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType: "json",
		data:"zjhm=" + $("#zjhm").val() + "&cyzjdm=" + $("#cyzjdm").combobox("getValue"),
		success: function(data) {
			if (data && data.ryRyjbxxb) {
				$("#ryid").val(data.ryRyjbxxb.id);
				$("#xm").val(data.ryRyjbxxb.xm);
				$("#xm").validatebox("validate");
				$("#xbdm").combobox("setValue", data.ryRyjbxxb.xbdm);
				$("#csrq").val(data.ryRyjbxxb.csrq);
				$("#csrq").validatebox("validate");
				$("#mzdm").combobox("setValue", data.ryRyjbxxb.mzdm);
				$("#lxdh").val(data.ryRyjbxxb.lxdh);
//				if (data.ryRyjbxxb.csdgjhdqdm != "") {
//					$("#jbxx_csdgjhdqdm").combobox("setValue", data.ryRyjbxxb.csdgjhdqdm);
//				}
				$("#jgssxdm").combobox("setValue", data.ryRyjbxxb.jgssxdm);
				/*if (data.ryRyjbxxb.jggjdqdm != "") {
					$("#jbxx_jggjdqdm").combobox("setValue", data.ryRyjbxxb.jggjdqdm);
				}*/
				//$("#jbxx_jgssxdm").combobox("setValue", data.ryRyjbxxb.jgssxdm);
				
				$("#hjdsssxdm").combobox("setValue",data.ryRyjbxxb.hjd_xzqhdm);
				$("#hjd_dzms").val(data.ryRyjbxxb.hjd_dzms);
				$("#hjd_xzqhdm").val(data.ryRyjbxxb.hjd_xzqhdm);
				$("#hjd_mlpdm").val(data.ryRyjbxxb.hjd_mlpdm);
				$("#hjd_mlpxz").val(data.ryRyjbxxb.hjd_mlpxz);
				$("#hjd_dzid").val(data.ryRyjbxxb.hjd_dzid);
				$("#hjd_dzxz").val(data.ryRyjbxxb.hjd_dzxz);
				$("#hjd_sspcsdm").val(data.ryRyjbxxb.hjd_sspcsdm);
				
				
				$("#jzd_mlpxz").val(data.ryRyjbxxb.jzd_mlpxz);
				$("#jzd_mlpdm").val(data.ryRyjbxxb.jzd_mlpdm);
				$("#jzd_dzxz").val(data.ryRyjbxxb.jzd_dzxz);
				$("#jzd_dzid").val(data.ryRyjbxxb.jzd_dzid);
				$("#jzd_xzqhdm").val(data.ryRyjbxxb.jzd_xzqhdm);
				$("#jzd1").combobox('setValue', data.ryRyjbxxb.jzd_mlpxz);
				$("#jzd2").combobox('setValue', data.ryRyjbxxb.jzd_dzxz.replace(data.ryRyjbxxb.jzd_mlpxz, ''));
				
				
				

			}if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete: function() {
			$("#zjhm").attr("cyzjdm", $("#cyzjdm").combobox("getValue"));
			$("#zjhm").attr("zjhm", $("#zjhm").val());
			$("#jbxxLoadDiv").hide();
		},
		error: function() {
		}
	});	
}
