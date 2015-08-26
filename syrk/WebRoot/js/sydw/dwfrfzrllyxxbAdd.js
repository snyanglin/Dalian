//@updateAuthor: [star]	

function doInit(paramArray) {
	$("#gjdm").combobox("setValue", gjdm);
	if ($("#xm").val() != "") {
		setInputReadonly("xm", true);
	}
	if ($("#csrq").val() != "") {
		setInputReadonly("csrq", true);
	}
	if ($("#xbdm").val() != "") {
		setInputReadonly("xbdm", true);
	}
	if ($("#mzdm").val() != "") {
		setInputReadonly("mzdm", true);
	}
	if ($("#hjd1").val() != "") {
		setInputReadonly("hjd1", true);
		setInputReadonly("hjd2", true);
	}
	if ($("#jjqklxrxm").val() != "") {
		setInputReadonly("jjqklxrxm", true);
	}
	if ($("#jjqklxrxbdm").val() != "") {
		setInputReadonly("jjqklxrxbdm", true);
	}
	$('#zjhm').validatebox({
		validType : [ 'sfzh' ]
	});
	initAddressSearch('dwfr_hjdz1', {}, 'dwfr_dz_hjdmlpdm', 'dwfr_dz_hjdmlpxz','dwfr_hjdz2', 
			{
				text : 'dwfr_dz_hjdzxz',
				dzxzqh : 'dwfr_dz_hjdzssxdm',
				id : 'dwfr_dz_hjdzdm'
			}, null, null);
	initAddressSearch('dwfr_jzdz1', {}, 'dwfr_dz_xjzdmlpdm',
			'dwfr_dz_xjzdmlpxz', 'dwfr_jzdz2', 
			{
				text : 'dwfr_dz_xjzdzxz',
				dzxzqh : 'dwfr_dz_xjzdzssxdm',
				id : 'dwfr_dz_xjzdzdm'
			}, null, null);

	$.getJSON(contextPath + '/common/dict/D_DW_DWRYLX.js',
			function(dic) {
				$('#cbo_dwrylxdm').empty();
				$.each(dic,function(i, type) {
								var checked = $('#dwrylxdm').val().indexOf(type.id) >= 0 ? 'checked' : '';
								$('#cbo_dwrylxdm').append('<label><input type="checkbox" name="cbo_dwrylxdm" value="'
													+ type.id + '" ' + checked+ '/>' + type.text+ '</label>&nbsp;');
								});
			});

	$(document).on('click', '#cbo_dwrylxdm :checkbox', function() {
		var tmpArr = Array();
		$('#cbo_dwrylxdm :checked').each(function() {
			tmpArr.push($(this).val());
		});
		$('#dwrylxdm').val(tmpArr.join(','));
	});

}

function beforeSubmit() {
	var ryid = $("#ryid").val();
	var jjqklxrid = $("#jjqklxrid").val();
	if (ryid != undefined && ryid != "" && jjqklxrid != undefined
			&& jjqklxrid != "") {
		if (ryid == jjqklxrid) {
			alert("【法人\负责人\联络员】和【紧急联系人员】不能为同一个人！");
			return false;
		}
	}

}

function afterSubmit(arr) {
	if (arr["saveID"]) {
		$("#pk").val(arr["saveID"]);
	}
}

$(document).ready(function() {
	// 人员信息复用人员基本表
	$("#zjhm").bind("blur", function(e) {
		checkRyxx();
	});
	if ($("#cyzjdm").combobox("getValue") == "") {
		$("#cyzjdm").combobox("setValue", "111");
	}

	// 紧急联系人复用人员基本表
	$("#jjqklxrzjhm").bind("blur", function(e) {
		checkJjlxRyxx();
	});
});

/**
 * 从业人员基本信息复用人员基本信息表
 */
var _zjhm = "";
function checkRyxx() {
	if (!$("#zjhm").validatebox("isValid")) {
		return;
	}
	if ($("#zjhm").val() == _zjhm) {
		return;
	}
	$("#yrjbxxDiv").show();
	$.ajax({
				type : "POST",
				url : contextPath + "/ryRyjbxxb/dataApply",
				dataType : "json",
				data : "zjhm=" + $("#zjhm").val() + "&cyzjdm=" + $("#cyzjdm").val(),
				success : function(data) {
					if (data && data.ryRyjbxxb) {
						$("#ryid").val(data.ryRyjbxxb.id);
						$("#xm").val(data.ryRyjbxxb.xm);
						$("#xbdm").combobox("setValue", data.ryRyjbxxb.xbdm);
						$("#csrq").val(data.ryRyjbxxb.csrq);
						$("#mzdm").combobox("setValue", data.ryRyjbxxb.mzdm);
						$("#dwfr_dz_hjdzxz").val(data.ryRyjbxxb.hjd_dzxz);
						$("#dwfr_dz_hjdzssxdm").val(data.ryRyjbxxb.hjd_xzqhdm);
						$("#dwfr_dz_hjdzdm").val(data.ryRyjbxxb.hjd_dzid);
						$("#lxdh").val(data.ryRyjbxxb.lxdh);
						$("#gjdm").combobox("setValue", data.ryRyjbxxb.gjdm);
						$("#dwfr_hjdz1").combobox("setValue",data.ryRyjbxxb.hjd_mlpxz);
						$("#dwfr_hjdz2").combobox("setValue",data.ryRyjbxxb.hjd_dzxz.replace(data.ryRyjbxxb.hjd_mlpxz, ''));
						if (data.ryRyjbxxb.xm != "") {
							setInputReadonly("xm", true);
						}
						if (data.ryRyjbxxb.csrq != "") {
							setInputReadonly("csrq", true);
						}
						if (data.ryRyjbxxb.xbdm != "") {
							setInputReadonly("xbdm", true);
						}
						if (data.ryRyjbxxb.mzdm != "") {
							setInputReadonly("mzdm", true);
						}
						if (data.ryRyjbxxb.dz_hjdzxz != "") {
							setInputReadonly("dwfr_hjdz1", true);
							setInputReadonly("dwfr_hjdz2", true);
							$("#dwfr_dz_hjdmlpxz").val(data.ryRyjbxxb.hjd_mlpxz);
							$("#dwfr_dz_hjdmlpdm").val(data.ryRyjbxxb.hjd_mlpdm);
						}
					} else {
						clearRyjbxx();
					}
				},
				complete : function() {
					_zjhm = $("#zjhm").val();
					$("#yrjbxxDiv").hide();
				}
			});
}
var _jjlxrZjhm = "";
/**
 * 紧急联系人复用人员基本信息表
 */
// 紧急联系人-验证证件号码
function jjlxrzjhmCheck(newValue, oldValue) {
	if (newValue == "") {
		$("#jjqklxrzjhm").validatebox({
			validType : null
		});
		return;
	}
	if (!newValue) {
		return;
	}
	// 111-居民身份证,335-机动车驾驶证
	if (newValue == "111" || newValue == "112" || newValue == "335") {
		$("#jjqklxrzjhm").validatebox({
			validType : [ 'sfzh' ],
			charSet : 'halfUpper'
		});
	} else {
		$("#jjqklxrzjhm").validatebox({
			validType : [ 'maxLength[30]' ]
		});
	}

	clearJjlxryjbxx();
	$("#jjqklxrzjhm").val("");
	_jjlxrZjhm = "";
}
// 清空复用的紧急联系人员信息
function clearJjlxryjbxx() {
	$("#jjqklxrid").val("");
	$("#jjqklxrxm").val("");
	$("#jjqklxrxbdm").combobox("setValue", "");
	$("#jjqklxrdh").val("");
	setInputReadonly("jjqklxrxm", false);
	setInputReadonly("jjqklxrxbdm", false);
	setInputReadonly("jjqklxrdh", false);
}
// 验证证件号码
function zjhmCheck(newValue, oldValue) {
	if (newValue == "") {
		$("#zjhm").validatebox({
			validType : null
		});
		return;
	}
	if (!newValue) {
		return;
	}
	// 111-居民身份证,335-机动车驾驶证
	if (newValue == "111" || newValue == "112" || newValue == "335") {
		$("#zjhm").validatebox({
			validType : [ 'sfzh' ],
			charSet : 'halfUpper'
		});
	} else {
		$("#zjhm").validatebox({
			validType : [ 'maxLength[30]' ]
		});
	}

	clearRyjbxx();
	$("#zjhm").val("");
	_zjhm = "";
}

// 清空复用的人员基本信息
function clearRyjbxx() {
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
function resetForm() {
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

	$("#cyzjdm").combobox("setValue", "111");
}
function resetTable() {
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

	$("#cyzjdm").combobox("setValue", "111");
}