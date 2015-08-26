/**
 * 
 * @description:集会游行示威添加
 * @author: tian_chengwei@founder.com    
 * @date:2015-06-02
 */
$(document).ready(function() {
		//单位查询接口 注意文本ID对应
		initDepartmentSearch('gzdw1', {
			glpcsid : ''
		}, 'gzdwid', 'gzdw', {});
		//地址接口
		initAddressSearch('jzd1', {}, 'dz_jzdmlpdm', 'dz_jzdmlpxz', 'jzd2', {
			text : 'dz_jzdzxz',
			dzxzqh : 'dz_jzdzssxdm',
			id : 'dz_jzdzdm'
		}, null, null);
		//initAddressSearch('hjd1', {}, 'dz_hjdzmlpdm', 'dz_hjdzmlpxz', 'hjd2', {text:'dz_hjdzxz',dzxzqh:'dz_hjdzssxdm',id:'dz_hjdzdm'}, null, null);
		//根据身份证号检索信息赋值到文本框中
		$("#gmsfhm").bind("blur", function(e) {
			checkZjhm();
		});
	});
//表单提交
$(function() {
	$('#dataForm').form({
		success : function(data) {
			var json = $.parseJSON(data);
			if (json.status != 'success') {
				topMessagerAlert(null, json.message);

			} else {
				//这块可以是否调整关闭保存页面
				topMessagerShow(null, json.message);
				executeTabPageMethod(mainTabID, "reloadDg");
				closeSelf();
			}
		}
	});
//表单点击保存按钮 
$('#saveBotton').click(function() {
	if ($("#dataForm").form('validate')) {
		topMessager.confirm('操作确认', '您是否保存信息？', function(r) {
			if (r) {
				$('#dataForm').submit();
			}
		});
	}
});
//重置
$('#restBotton').click(function() {
	/**
	var objForm = document.getElementById("dataForm");
	var inputs = objForm.getElementsByTagName("input");
	for ( var i = 0; i < inputs.length; i++) {
		if (inputs[i].type != "hidden") {
			inputs[i].value = "";
		}
	}
	*/
	$("input[type=text]").val("");
	$("#jhswcs").val("");
	$("#bykh").val("");
	$("#bz").val("");
});

});
//身份证检索 111为身份证号编码
function checkZjhm() {
	if (!$("#gmsfhm").validatebox("isValid")) {
		return;
	}
	$.ajax({
		type : "POST",
		url : contextPath + "/ryRyjbxxb/dataApply",
		dataType : "json",
		data : "zjhm=" + $("#gmsfhm").val() + "&cyzjdm=111",
		success : function(data) {
			if (data && data.ryRyjbxxb) {

				$("#xm").val(data.ryRyjbxxb.xm);
				$("#xbdm").combobox("setValue", data.ryRyjbxxb.xbdm);
				$("#mzdm").combobox("setValue", data.ryRyjbxxb.mzdm);
				$("#nl").val(getNL(data.ryRyjbxxb.csrq));
				$("#zy").val(data.ryRyjbxxb.zy);
				$("#lxdh").val(data.ryRyjbxxb.lxdh);

				if (data.ryRyjbxxb.xm != "") {
					setInputReadonly("xm", true);
				}
				if (data.ryRyjbxxb.xbdm != "") {
					setInputReadonly("xbdm", true);
				}
				if (data.ryRyjbxxb.mzdm != "") {
					setInputReadonly("mzdm", true);
				}
				if (data.ryRyjbxxb.nl != "") {
					setInputReadonly("nl", true);
				}
				if (data.ryRyjbxxb.zy != "") {
					setInputReadonly("zy", true);
				}
				if (data.ryRyjbxxb.lxdh != "") {
					setInputReadonly("lxdh", true);
				}

			}

		}

	});

}
//根据出生日期计算年龄
function getNL(n) {
	if (n == "") {
		return;
	}
	var dates = new Date();
	var year = dates.getFullYear();
	var date = dates.getDate();
	var month = dates.getMonth() + 1;
	if (month < 10) {
		month = '0' + month;
	}
	var nl = n.substring(0, 4);
	return (year - nl);
}