
$(document).ready(function(){
	setInputReadonly("jbxx_hjd_dzms", true);
	setInputReadonly("jbxx_xm", true);
	setInputReadonly("jbxx_xbdm", true);
	setInputReadonly("jbxx_csrq", true);
	$("#jbxx_zjhm").attr("cyzjdm", cyzjdm);
	$("#jbxx_zjhm").attr("zjhm", zjhm);

	// 大数据的下拉列表初始化
	initComboBox("jbxx_csdssxdm", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 
	initComboBox("jbxx_jgssxdm", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 
	
	// 地址选择初始化
	initAddressSearch("czrk1_hjd1", {zrqdm:zrqdm}, "czrk1_hjd_mlpdm", "czrk1_hjd_mlpxz", "czrk1_hjd2", {text:"czrk1_hjd_dzxz",dzxzqh:"czrk1_hjd_xzqhdm",id:"czrk1_hjd_dzid"}, null, null);
	initAddressSearch("czrk_jzd1", {zrqdm:'#czrk_zrqdm'}, "czrk_jzd_mlpdm", "czrk_jzd_mlpxz", "czrk_jzd2", {text:"czrk_jzd_dzxz",dzxzqh:"czrk_jzd_xzqhdm",id:"czrk_jzd_dzid",dzzbx:"czrk_jzd_zbx",dzzby:"czrk_jzd_zby"}, null, null);
	initAddressSearch("czrk_lbsqk_lzd1", {}, "czrk_lbsqk_lzd_mlpdm", "czrk_lbsqk_lzd_mlpxz", "czrk_lbsqk_lzd2", {text:"czrk_lbsqk_lzd_dzxz",dzxzqh:"czrk_lbsqk_lzd_xzqhdm",id:"czrk_lbsqk_lzd_dzid"}, null, null);
	initAddressSearch("jzrk_jzd1", {zrqdm:zrqdm}, "jzrk_jzd_mlpdm", "jzrk_jzd_mlpxz", "jzrk_jzd2", {text:"jzrk_jzd_dzxz",dzxzqh:"jzrk_jzd_xzqhdm",id:"jzrk_jzd_dzid",dzzbx:"jzrk_jzd_zbx",dzzby:"jzrk_jzd_zby"}, null, null);
	initAddressSearch("jzrk_fz_jzd1", {}, "jzrk_fz_jzd_mlpdm", "jzrk_fz_jzd_mlpxz", "jzrk_fz_jzd2", {text:"jzrk_fz_jzd_dzxz",dzxzqh:"jzrk_fz_jzd_xzqhdm",id:"jzrk_fz_jzd_dzid"}, null, null);
	initAddressSearch("ldrk_jzd1", {zrqdm:zrqdm}, "ldrk_jzd_mlpdm", "ldrk_jzd_mlpxz", "ldrk_jzd2", {text:"ldrk_jzd_dzxz",dzxzqh:"ldrk_jzd_xzqhdm",id:"ldrk_jzd_dzid",dzzbx:"ldrk_jzd_zbx",dzzby:"ldrk_jzd_zby"}, null, null);
	initAddressSearch("ldrk_lzd1", {}, "ldrk_lzd_mlpdm", "ldrk_lzd_mlpxz", "ldrk_lzd2", {text:"ldrk_lzd_dzxz",dzxzqh:"ldrk_lzd_xzqhdm",id:"ldrk_lzd_dzid"}, null, null);
	initAddressSearch("ldrk_fz_jzd1", {}, "ldrk_fz_jzd_mlpdm", "ldrk_fz_jzd_mlpxz", "ldrk_fz_jzd2", {text:"ldrk_fz_jzd_dzxz",dzxzqh:"ldrk_fz_jzd_xzqhdm",id:"ldrk_fz_jzd_dzid"}, null, null);
	//initAddressSearch("jwry_fz_jzd1", {}, "jwry_fz_jzd_mlpdm", "jwry_fz_jzd_mlpxz", "jwry_fz_jzd2", {text:"jwry_fz_jzd_dzxz",dzxzqh:"jwry_fz_jzd_xzqhdm",id:"jwry_fz_jzd_dzid"}, null, null);
	initAddressSearch("wlrk_jzd1", {zrqdm:zrqdm}, "wlrk_jzd_mlpdm", "wlrk_jzd_mlpxz", "wlrk_jzd2", {text:"wlrk_jzd_dzxz",dzxzqh:"wlrk_jzd_xzqhdm",id:"wlrk_jzd_dzid",dzzbx:"wlrk_jzd_zbx",dzzby:"wlrk_jzd_zby"}, null, null);
	initAddressSearch("wlrk_lzd1", {}, "wlrk_lzd_mlpdm", "wlrk_lzd_mlpxz", "wlrk_lzd2", {text:"wlrk_lzd_dzxz",dzxzqh:"wlrk_lzd_xzqhdm",id:"wlrk_lzd_dzid"}, null, null);
	initAddressSearch("wlrk_fz_jzd1", {}, "wlrk_fz_jzd_mlpdm", "wlrk_fz_jzd_mlpxz", "wlrk_fz_jzd2", {text:"wlrk_fz_jzd_dzxz",dzxzqh:"wlrk_fz_jzd_xzqhdm",id:"wlrk_fz_jzd_dzid"}, null, null);
	
	//工作单位隐藏
	
	// 单位选择初始化
	//initDepartmentSearch("ldrk_fwcs_select", {}, "ldrk_fwcsid", "ldrk_fwcs", {});
	initDepartmentSearch("gzdw_select", {}, "gzdwid", "gzdw", {});
	//initDepartmentSearch("jzrk_gzdw_select", {}, "jzrk_gzdwid", "jzrk_gzdw", {});
	//initDepartmentSearch("ldrk_gzdw_select", {}, "ldrk_gzdwid", "ldrk_gzdw", {});
	initDepartmentSearch("wlrk_gzdw_select", {}, "wlrk_gzdwid", "wlrk_gzdw", {});

	//initDepartmentSearch("jwry_gzdw_dwmc_select", {}, "jwry_gzdw_dwid", "jwry_gzdw_dwmc", {});
	initDepartmentSearch("jwry_lsdw_dwmc_select", {}, "jwry_lsdw_dwid", "jwry_lsdw_dwmc", {});
	initDepartmentSearch("jwry_jddw_dwmc_select", {}, "jwry_jddw_dwid", "jwry_jddw_dwmc", {});
	
	jbxx_jggjdqdm_onChange($("#jbxx_jggjdqdm").combobox("getValue"));
	
	if(orglevel!="50"){
		$("#syrkywlxdm").combobox("setDataFilter", "4");
		$("#syrkywlxdm").combobox("setValue", "4");
		setInputReadonly("syrkywlxdm", true);
	}
});

// 保存按钮 type标示为1为保存并打印，0为保存（默认）
function saveForm(type) {
	if (!$("#jbxxForm").form("validate")) {
		return;
	}
	var formName = "";
	var divName = "";
	var syrkywlxdmValue = $("#syrkywlxdm").combobox("getValue");
	if (syrkywlxdmValue == "1") {
		formName = "czrkForm";
		divName = "czrkDiv";
	} 
	else if (syrkywlxdmValue == "2") {
		formName = "jzrkForm";
		divName = "jzrkDiv";
	} 
	else if (syrkywlxdmValue == "3") {
		formName = "ldrkForm";
		divName = "ldrkDiv";
	}
	else if (syrkywlxdmValue == "4") {
		formName = "jwryForm";
		divName = "jwryDiv";
	}
	else if (syrkywlxdmValue == "5") {
		formName = "wlrkForm";
		divName = "wlrkDiv";
	}
	if ($("#" + formName).form("validate")) {
		if (syrkywlxdmValue == "1") {
			var czrk_sfrhyzdmValue = $("#czrk_sfrhyzdm").combobox("getValue");
			if (czrk_sfrhyzdmValue == "0") { // 人户分离
				if ($("#hjRadio1").is(":checked")) {
					if ($("#czrk1_hjd_mlpdm").val() == "") {
						topMessager.alert("", "户籍地址必须为标准地址，请重新选择！");
						var comboText = $("#czrk1_hjd1").next(".combo").children(".combo-text");
						comboText.focus();
						return;
					}
					if ($("#czrk1_hjd2").combobox("getValue") == "") {
						topMessager.alert("", "户籍地址必须为标准地址，请重新选择！");
						var comboText = $("#czrk1_hjd2").next(".combo").children(".combo-text");
						comboText.focus();
						return;
					}
					$("#czrk_hjd_xzqhdm").val($("#czrk1_hjd_xzqhdm").val());
					$("#czrk_hjd_mlpdm").val($("#czrk1_hjd_mlpdm").val());
					$("#czrk_hjd_mlpxz").val($("#czrk1_hjd_mlpxz").val());
					$("#czrk_hjd_dzid").val($("#czrk1_hjd_dzid").val());
					$("#czrk_hjd_dzxz").val($("#czrk1_hjd_dzxz").val());
				}
				else if ($("#hjRadio2").is(":checked")) {
					if ($("#czrk2_hjd_dzxz").val() == "") {
						topMessager.alert("", "户籍集体空挂户不能为空！");
						return;
					}
					$("#czrk_hjd_xzqhdm").val($("#czrk2_hjd_xzqhdm").val());
					$("#czrk_hjd_mlpdm").val($("#czrk2_hjd_mlpdm").val());
					$("#czrk_hjd_mlpxz").val($("#czrk2_hjd_mlpxz").val());
					$("#czrk_hjd_dzid").val($("#czrk2_hjd_dzid").val());
					$("#czrk_hjd_dzxz").val($("#czrk2_hjd_dzxz").val());
				}
				else if ($("#hjRadio3").is(":checked")) {
					if ($("#czrk3_hjd_dzxz").val() == "") {
						topMessager.alert("", "户籍居民空挂户不能为空！");
						return;
					}
					$("#czrk_hjd_xzqhdm").val($("#czrk3_hjd_xzqhdm").val());
					$("#czrk_hjd_mlpdm").val($("#czrk3_hjd_mlpdm").val());
					$("#czrk_hjd_mlpxz").val($("#czrk3_hjd_mlpxz").val());
					$("#czrk_hjd_dzid").val($("#czrk3_hjd_dzid").val());
					$("#czrk_hjd_dzxz").val($("#czrk3_hjd_dzxz").val());
				}
			}
			else { // 人户一致
				if ($("#czrk_jzd_mlpdm").val() == "") {
					topMessager.alert("", "居住地必须为标准地址，请重新选择！");
					var comboText = $("#czrk_jzd1").next(".combo").children(".combo-text");
					comboText.focus();
					return;
				}
				if ($("#czrk_jzd2").combobox("getValue") == "") {
					topMessager.alert("", "居住地必须为标准地址，请重新选择！");
					var comboText = $("#czrk_jzd2").next(".combo").children(".combo-text");
					comboText.focus();
					return;
				}
				$("#czrk_hjd_xzqhdm").val($("#czrk_jzd_xzqhdm").val());
				$("#czrk_hjd_mlpdm").val($("#czrk_jzd_mlpdm").val());
				$("#czrk_hjd_mlpxz").val($("#czrk_jzd_mlpxz").val());
				$("#czrk_hjd_dzid").val($("#czrk_jzd_dzid").val());
				$("#czrk_hjd_dzxz").val($("#czrk_jzd_dzxz").val());
			}
		} 
		else if (syrkywlxdmValue == "2") {
			if ($("#jzrk_jzd_mlpdm").val() == "") {
				topMessager.alert("", "居住地必须为标准地址，请重新选择！");
				var comboText = $("#jzrk_jzd1").next(".combo").children(".combo-text");
				comboText.focus();
				return;
			}
			if ($("#jzrk_jzd2").combobox("getValue") == "") {
				topMessager.alert("", "居住地必须为标准地址，请重新选择！");
				var comboText = $("#jzrk_jzd2").next(".combo").children(".combo-text");
				comboText.focus();
				return;
			}
			if ($("#jzrk_jz_ksrq01").val() != "" && $("#jzrk_yj_lksj").val() != "" && $("#jzrk_jz_ksrq01").val() >  $("#jzrk_yj_lksj").val()) {
				topMessager.alert("", "预计离开时间不能小于寄住开始时间，请重新输入！");
				$("#jzrk_yj_lksj").focus();
				return;
			}
			var jzrk_zjzcsfldmValue = $("#jzrk_zjzcsfldm").combotree("getValue");
			if (jzrk_zjzcsfldmValue == "30") { // 居住处所为租赁房屋
				if ($("#jbxx_id").val() != "" && $("#jzrk_fz_ryid").val() != "" && $("#jbxx_id").val() == $("#jzrk_fz_ryid").val()) {
					topMessager.alert("", "房主不能为本人，请重新输入！");
					$("#jzrk_fz_zjhm").focus();
					return;
				}
			}
		} 
		else if (syrkywlxdmValue == "3") {
			if ($("#ldrk_jzd_mlpdm").val() == "") {
				topMessager.alert("", "居住地必须为标准地址，请重新选择！");
				var comboText = $("#ldrk_jzd1").next(".combo").children(".combo-text");
				comboText.focus();
				return;
			}
			if ($("#ldrk_jzd2").combobox("getValue") == "") {
				topMessager.alert("", "居住地必须为标准地址，请重新选择！");
				var comboText = $("#ldrk_jzd2").next(".combo").children(".combo-text");
				comboText.focus();
				return;
			}
			var ldrk_zjzcsfldmValue = $("#ldrk_zjzcsfldm").combotree("getValue");
			if (ldrk_zjzcsfldmValue == "30") { // 居住处所为租赁房屋
				if ($("#jbxx_id").val() != "" && $("#ldrk_fz_ryid").val() != "" && $("#jbxx_id").val() == $("#ldrk_fz_ryid").val()) {
					topMessager.alert("", "房主不能为本人，请重新输入！");
					$("#ldrk_fz_zjhm").focus();
					return;
				}
			}
		}
		else if (syrkywlxdmValue == "4") {
			var dzredio = $('input[name="jwry.fz_sflb"]:checked').val();
			if(dzredio=="0"){
				if ($("#jwry_jzd_mlpdm").val() == "") {
					topMessager.alert("", "居住地必须为标准地址，请重新选择！");
					var comboText = $("#jwry_jzd1").next(".combo").children(".combo-text");
					comboText.focus();
					return;
				}
				if ($("#jwry_jzd2").combobox("getValue") == "") {
					topMessager.alert("", "居住地必须为标准地址，请重新选择！");
					var comboText = $("#jwry_jzd2").next(".combo").children(".combo-text");
					comboText.focus();
					return;
				}
			}
			if ($("#jwry_zsrq").val() != "" && $("#jwry_nlkrq").val() != "" && $("#jwry_zsrq").val() >  $("#jwry_nlkrq").val()) {
				topMessager.alert("", "拟离开日期不能小于入宿日期，请重新输入！");
				$("#jwry_nlkrq").focus();
				return;
			}
			/*var jwry_zjzcsfldmValue = $("#jwry_zjzcsfldm").combotree("getValue");
			if (jwry_zjzcsfldmValue == "30") { // 居住处所为租赁房屋
				if ($("#jbxx_id").val() != "" && $("#jwry_fz_ryid").val() != "" && $("#jbxx_id").val() == $("#jwry_fz_ryid").val()) {
					topMessager.alert("", "房主不能为本人，请重新输入！");
					$("#jwry_fz_zjhm").focus();
					return;
				}
			}*/
		}
		else if (syrkywlxdmValue == "5") {
			if ($("#wlrk_jzd_mlpdm").val() == "") {
				topMessager.alert("", "居住地必须为标准地址，请重新选择！");
				var comboText = $("#wlrk_jzd1").next(".combo").children(".combo-text");
				comboText.focus();
				return;
			}
			if ($("#wlrk_jzd2").combobox("getValue") == "") {
				topMessager.alert("", "居住地必须为标准地址，请重新选择！");
				var comboText = $("#wlrk_jzd2").next(".combo").children(".combo-text");
				comboText.focus();
				return;
			}
			var wlrk_zjzcsfldmValue = $("#wlrk_zjzcsfldm").combotree("getValue");
			if (wlrk_zjzcsfldmValue == "30") { // 居住处所为租赁房屋
				if ($("#jbxx_id").val() != "" && $("#wlrk_fz_ryid").val() != "" && $("#jbxx_id").val() == $("#wlrk_fz_ryid").val()) {
					topMessager.alert("", "房主不能为本人，请重新输入！");
					$("#wlrk_fz_zjhm").focus();
					return;
				}
			}
		}

		var bottonObject = "#saveButton";
		if (buttonDisabled(bottonObject) == false) {
			return false;
		}
		topMessager.confirm("", "您是否要保存当前的数据？", function(r) {
			if (r) {
				var sb = new StringBuffer();
				sb.append("<input type='hidden' name='syrkywlxdm' value='"+ $("#syrkywlxdm").combobox("getValue") +"'/>");
				sb.append("<input type='hidden' name='jbxx.id' value='"+ $("#jbxx_id").val() +"'/>");
				if (syrkywlxdmValue != "4") { // 境外人员不提交基本信息补充
					sb.append("<input type='hidden' name='jbxx.cyzjdm' value='"+ $("#jbxx_cyzjdm").combobox("getValue") +"'/>");     
					sb.append("<input type='hidden' name='jbxx.zjhm' value='"+ $("#jbxx_zjhm").val() +"'/>");
					sb.append("<input type='hidden' name='jbxx.xm' value='"+ $("#jbxx_xm").val() +"'/>");
					sb.append("<input type='hidden' name='jbxx.xbdm' value='"+ $("#jbxx_xbdm").combobox("getValue") +"'/>");
					sb.append("<input type='hidden' name='jbxx.csrq' value='"+ $("#jbxx_csrq").val() +"'/>");
					sb.append("<input type='hidden' name='jbxx.mzdm' value='"+ $("#jbxx_mzdm").combobox("getValue") +"'/>"); 
					sb.append("<input type='hidden' name='jbxx.lxdh' value='"+ $("#jbxx_lxdh").val() +"'/>");
					sb.append("<input type='hidden' name='jbxx.csdgjhdqdm' value='"+ $("#jbxx_csdgjhdqdm").combobox("getValue") +"'/>"); 
					sb.append("<input type='hidden' name='jbxx.csdssxdm' value='"+ $("#jbxx_csdssxdm").combobox("getValue") +"'/>"); 
					sb.append("<input type='hidden' name='jbxx.jggjdqdm' value='"+ $("#jbxx_jggjdqdm").combobox("getValue") +"'/>"); 
					sb.append("<input type='hidden' name='jbxx.jgssxdm' value='"+ $("#jbxx_jgssxdm").combobox("getValue") +"'/>"); 
					sb.append("<input type='hidden' name='jbxx.cym' value='"+ $("#jbxx_cym").val() +"'/>");
					sb.append("<input type='hidden' name='jbxx.xldm' value='"+ $("#jbxx_xldm").combotree("getValue") +"'/>"); 
					sb.append("<input type='hidden' name='jbxx.hyzkdm' value='"+ $("#jbxx_hyzkdm").combobox("getValue") +"'/>"); 
					sb.append("<input type='hidden' name='jbxx.zzmmdm' value='"+ $("#jbxx_zzmmdm").combobox("getValue") +"'/>"); 
					sb.append("<input type='hidden' name='jbxx.zjxydm' value='"+ $("#jbxx_zjxydm").combobox("getValue") +"'/>"); 
					sb.append("<input type='hidden' name='jbxx.byzkdm' value='"+ $("#jbxx_byzkdm").combobox("getValue") +"'/>"); 
					sb.append("<input type='hidden' name='jbxx.xxdm' value='"+ $("#jbxx_xxdm").combobox("getValue") +"'/>"); 
					sb.append("<input type='hidden' name='jbxx.zylbdm' value='"+ $("#jbxx_zylbdm").combotree("getValue") +"'/>"); 
					sb.append("<input type='hidden' name='jbxx.zy' value='"+ $("#jbxx_zy").val() +"'/>");
					sb.append("<input type='hidden' name='jbxx.hjd_dzms' value='"+ $("#jbxx_hjd_dzms").val() +"'/>");
					sb.append("<input type='hidden' name='jbxx.hjd_xzqhdm' value='"+ $("#jbxx_hjd_xzqhdm").val() +"'/>");
					sb.append("<input type='hidden' name='jbxx.hjd_mlpdm' value='"+ $("#jbxx_hjd_mlpdm").val() +"'/>");
					sb.append("<input type='hidden' name='jbxx.hjd_mlpxz' value='"+ $("#jbxx_hjd_mlpxz").val() +"'/>");
					sb.append("<input type='hidden' name='jbxx.hjd_dzid' value='"+ $("#jbxx_hjd_dzid").val() +"'/>");
					sb.append("<input type='hidden' name='jbxx.hjd_dzxz' value='"+ $("#jbxx_hjd_dzxz").val() +"'/>");
					sb.append("<input type='hidden' name='jbxx.hjd_pcsdm' value='"+ $("#jbxx_hjd_pcsdm").val() +"'/>");
					sb.append("<input type='hidden' name='gzdw' value='"+ $("#gzdw").val() +"'/>");
					sb.append("<input type='hidden' name='gzdwid' value='"+ $("#gzdwid").val() +"'/>");
				}else{
					sb.append("<input type='hidden' name='jbxx.cyzjdm' value='"+ $("#jwry_cyzjdm").combobox("getValue") +"'/>");     
					sb.append("<input type='hidden' name='jbxx.zjhm' value='"+ $("#jwry_zjhm").val() +"'/>");
					sb.append("<input type='hidden' name='jbxx.xm' value='"+ $("#jwry_xm").val() +"'/>");
				}
				document.getElementById(divName).innerHTML = sb.toString();

				$("#" + formName).form("submit",{
					dataType : "json",
					onSubmit: function() {
					},
					success: function(result) {
						buttonEnabled(bottonObject);
						result = parseReturn(result);
						if (result.status == "success") { // 返回成功后执行的方法
							if(type=="1"){
								var editUrl = contextPath +  "/ReportEmitter?rpt=/syrkgl/jwryPrint.brt&emitter=print&params=ryid="+result.ryid+";syrkid="+result.saveID;
								window.open(editUrl,'临住登记表打印',"location=0,menubar=0,resizable=1,scrollbars=0,status=0,titlebar=0,toolbar=0");
							}
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
								var openUrl = contextPath + "/syrkEdit/"+ result.ryid + "/" + result.saveID + "/view";
								location.href = openUrl;
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
}
// 实有人口业务类型改变事件
function syrkywlxdm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var syrkywlxdmValue = $("#syrkywlxdm").combobox("getValue");
	$("#saveDiv").show();
	//隐藏保存并打印按钮
	$("#saveAndPrintButton").hide();
	if (syrkywlxdmValue == "1") {
		$("#jbxxTbody").show();
		if ($("#czrkTable").attr("delayParse") == "true") {	
			$("#czrkTable").find("input.easyui-combobox-delay").removeClass("easyui-combobox-delay").addClass("easyui-combobox");
			$("#czrkTable").find("input.easyui-combotree-delay").removeClass("easyui-combotree-delay").addClass("easyui-combotree");
			$("#czrkTable").find("input.easyui-validatebox-delay").removeClass("easyui-validatebox-delay").addClass("easyui-validatebox");
			$.parser.parse("#czrkTable");
			$("#czrkTable").attr("delayParse", "false");
			$("#czrk_lbsqk_lzd_gjhdqdm").combobox("setValue", "156");
		}
		$("#jzrkTable").hide();
		$("#ldrkTable").hide();
		$("#jwryTable").hide();
		$("#wlrkTable").hide();
		$("#czrkTable").show();
		
		$("#jbxx_cyzjdm").combobox("setDataFilter", "111");
		$("#jbxx_cyzjdm").combobox("setValue", "111");
		setInputReadonly("jbxx_cyzjdm", true);
		$("#jbxx_xm_td").html("姓名：");
		$("#jbxx_xm").validatebox({required:true});
		setComboRequired("jbxx_xbdm", true);
		$("#jbxx_csrq").validatebox({required:true});
		$("#jbxx_csdgjhdqdm").combobox("setValue", "156");
		$("#jbxx_jggjdqdm").combobox("setValue", "156");
		if (zjhm == "") {
			$("#jbxx_zjhm").focus();
		}
		$("#czrk_sfrhyzdm").combobox("setValue","1");
		//以下改动
		$("#jbxxZjbody").show();
		$("#jbxx_zjhm").validatebox({required:true});
		//显示证件种类
		$("#jbxx_zjzlId").html("证件种类：");
		document.getElementById("jbxx_zjzlDiv").style.display ='';
		setComboRequired("jbxx_cyzjdm", true);
	} 
	else if (syrkywlxdmValue == "2") {
		$("#jbxxTbody").show();
		if ($("#jzrkTable").attr("delayParse") == "true") {	
			$("#jzrkTable").find("input.easyui-combobox-delay").removeClass("easyui-combobox-delay").addClass("easyui-combobox");
			$("#jzrkTable").find("input.easyui-combotree-delay").removeClass("easyui-combotree-delay").addClass("easyui-combotree");
			$("#jzrkTable").find("input.easyui-validatebox-delay").removeClass("easyui-validatebox-delay").addClass("easyui-validatebox");
			$.parser.parse("#jzrkTable");
			$("#jzrkTable").attr("delayParse", "false");
		}		       
		$("#czrkTable").hide();
		$("#ldrkTable").hide();
		$("#jwryTable").hide();
		$("#wlrkTable").hide();
		$("#jzrkTable").show();
		$("#jbxx_cyzjdm").combobox("setDataFilter", "111");
		$("#jbxx_cyzjdm").combobox("setValue", "111");
		setInputReadonly("jbxx_cyzjdm", true);
		$("#jbxx_xm_td").html("姓名：");
		$("#jbxx_xm").validatebox({required:true});
		setComboRequired("jbxx_xbdm", true);
		$("#jbxx_csrq").validatebox({required:true});
		$("#jbxx_csdgjhdqdm").combobox("setValue", "156");
		$("#jbxx_jggjdqdm").combobox("setValue", "156");
		if (zjhm == "") {
			$("#jbxx_zjhm").focus();
		}
		//以下改动
		$("#jbxxZjbody").show();
		$("#jbxx_zjhm").validatebox({required:true});
		//显示证件种类
		$("#jbxx_zjzlId").html("证件种类：");
		document.getElementById("jbxx_zjzlDiv").style.display ='';
		setComboRequired("jbxx_cyzjdm", true);
	} 
	else if (syrkywlxdmValue == "3") {
		$("#jbxxTbody").show();
		if ($("#ldrkTable").attr("delayParse") == "true") {
			$("#ldrkTable").find("input.easyui-combobox-delay").removeClass("easyui-combobox-delay").addClass("easyui-combobox");
			$("#ldrkTable").find("input.easyui-combotree-delay").removeClass("easyui-combotree-delay").addClass("easyui-combotree");
			$("#ldrkTable").find("input.easyui-validatebox-delay").removeClass("easyui-validatebox-delay").addClass("easyui-validatebox");
			$.parser.parse("#ldrkTable");
			$("#ldrkTable").attr("delayParse", "false");
			$("#ldrk_lzd_gjhdqdm").combobox("setValue", "156");
		}		       
		$("#czrkTable").hide();
		$("#jzrkTable").hide();
		$("#jwryTable").hide();
		$("#wlrkTable").hide();
		$("#ldrkTable").show();

		$("#jbxx_cyzjdm").combobox("setDataFilter", "");
		$("#jbxx_cyzjdm").combobox("setValue", "111");
		setInputReadonly("jbxx_cyzjdm", false);
		$("#jbxx_xm_td").html("姓名：");
		$("#jbxx_xm").validatebox({required:true});
		setComboRequired("jbxx_xbdm", true);
		$("#jbxx_csrq").validatebox({required:true});
		$("#jbxx_csdgjhdqdm").combobox("setValue", "156");
		$("#jbxx_jggjdqdm").combobox("setValue", "156");
		//以下改动
		$("#jbxxZjbody").show();
		$("#jbxx_zjhm").validatebox({required:true});
		//显示证件种类
		$("#jbxx_zjzlId").html("证件种类：");
		document.getElementById("jbxx_zjzlDiv").style.display ='';
		setComboRequired("jbxx_cyzjdm", true);
	}
	else if (syrkywlxdmValue == "4") {
		$("#jbxxTbody").hide();
		if ($("#jwryTable").attr("delayParse") == "true") {
			$("#jwryTable").find("input.easyui-combobox-delay").removeClass("easyui-combobox-delay").addClass("easyui-combobox");
			$("#jwryTable").find("input.easyui-combotree-delay").removeClass("easyui-combotree-delay").addClass("easyui-combotree");
			$("#jwryTable").find("input.easyui-validatebox-delay").removeClass("easyui-validatebox-delay").addClass("easyui-validatebox");
			$.parser.parse("#jwryTable");
			$("#jwryTable").attr("delayParse", "false");
		}		       
		$("#czrkTable").hide();
		$("#jzrkTable").hide();
		$("#ldrkTable").hide();
		$("#wlrkTable").hide();
		$("#jwryTable").show();

		$("#jwry_cyzjdm").combobox("setDataFilter", "^[4|5|6|7|8|9].*");
		setInputReadonly("jbxx_cyzjdm", false);
		//$("#jbxx_xm_td").html("中文姓名：");
		$("#jbxx_xm").validatebox({required:false});
		setComboRequired("jbxx_xbdm", false);
		$("#jbxx_csrq").validatebox({required:false});
		$("#jbxx_csdgjhdqdm").combobox("setValue", "");
		$("#jbxx_jggjdqdm").combobox("setValue", "");
		//以下改动
		$("#jbxxZjbody").hide();
		$("#jbxx_zjhm").validatebox({required:false});
		//隐藏证件种类
		$("#jbxx_zjzlId").html("");
		document.getElementById("jbxx_zjzlDiv").style.display ='none';
		setComboRequired("jbxx_cyzjdm", false);
		//显示保存并打印按钮
		$("#saveAndPrintButton").show();
		//权限控制
		if(orglevel == "50"){
			$("#dzmsbody").hide();
			$("#jzdzRadio").hide();
			initAddressSearch("jwry_jzd1", {zrqdm:zrqdm}, "jwry_jzd_mlpdm", "jwry_jzd_mlpxz", "jwry_jzd2", {text:"jwry_jzd_dzxz",dzxzqh:"jwry_jzd_xzqhdm",id:"jwry_jzd_dzid",dzzbx:"jwry_jzd_zbx",dzzby:"jwry_jzd_zby"}, null, null);
		}else{
			initAddressSearch("jwry_jzd1", {pcsdm:zrqdm}, "jwry_jzd_mlpdm", "jwry_jzd_mlpxz", "jwry_jzd2", {text:"jwry_jzd_dzxz",dzxzqh:"jwry_jzd_xzqhdm",id:"jwry_jzd_dzid",dzzbx:"jwry_jzd_zbx",dzzby:"jwry_jzd_zby"}, null, null);
			//地址描述门楼地址选择
			initAddressSearch('dzms_mldzXz',{pcsdm:zrqdm},null,'dzms_mldz',null,null, null, null);
			setInputReadonly('dzms_sspcsmc', true);
			setInputReadonly('dzms_sszrqmc', true);
			onRadioClick(0);
			//地图标点【标识0返回X、Y坐标，1返回X、Y坐标并所属派出所、责任区信息】
			$("#dtbdButton").click(function(){
				var zbx = $("#entity_zbx").val();
				var zby = $("#entity_zby").val();
				var url = contextPath+"/forward/map|mapBz?bz=1&zbx="+zbx+"&zby="+zby;
				var paramArray = [];
				openWindow(false, null, url, 
			   		paramArray, 
			   		{
				   		title:"地图标注（鼠标点击左键标注位置，右键退出标注模式）",
				   		maximizable: false,
				   		width: 700,	
				   		height:400
			   		}
			   	);
			});
		}
	}
	else if (syrkywlxdmValue == "5") {
		$("#jbxxTbody").show();
		if ($("#wlrkTable").attr("delayParse") == "true") {
			$("#wlrkTable").find("input.easyui-combobox-delay").removeClass("easyui-combobox-delay").addClass("easyui-combobox");
			$("#wlrkTable").find("input.easyui-combotree-delay").removeClass("easyui-combotree-delay").addClass("easyui-combotree");
			$("#wlrkTable").find("input.easyui-validatebox-delay").removeClass("easyui-validatebox-delay").addClass("easyui-validatebox");
			$.parser.parse("#wlrkTable");
			$("#wlrkTable").attr("delayParse", "false");
		}		       
		$("#czrkTable").hide();
		$("#jzrkTable").hide();
		$("#ldrkTable").hide();
		$("#jwryTable").hide();
		$("#wlrkTable").show();
		
		$("#jbxx_cyzjdm").combobox("setDataFilter", "");
		//$("#jbxx_cyzjdm").combobox("setDataFilter", "111");
		$("#jbxx_cyzjdm").combobox("setValue", "111");
		//setInputReadonly("jbxx_cyzjdm", true);
		$("#jbxx_xm_td").html("姓名：");
		$("#jbxx_xm").validatebox({required:true});
		setComboRequired("jbxx_xbdm", true);
		$("#jbxx_csrq").validatebox({required:true});
		$("#jbxx_csdgjhdqdm").combobox("setValue", "156");
		$("#jbxx_jggjdqdm").combobox("setValue", "156");
		if (zjhm == "") {
			$("#jbxx_zjhm").focus();
		}
		//以下改动
		$("#jbxxZjbody").show();
		$("#jbxx_zjhm").validatebox({required:true});
		//显示证件种类
		$("#jbxx_zjzlId").html("证件种类：");
		document.getElementById("jbxx_zjzlDiv").style.display ='';
		setComboRequired("jbxx_cyzjdm", true);
	}
}

// 基本信息，证件种类改变事件
function jbxx_cyzjdm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var cyzjdmValue = $("#jbxx_cyzjdm").combobox("getValue");
	if (cyzjdmValue == "111" || cyzjdmValue == "112" || cyzjdmValue == "335") { // 身份证类型、临时身份证、机动车驾驶证
		$("#jbxx_zjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#jbxx_zjhm").validatebox({validType:['letterOrNum']});
	}
	setTimeout("jbxx_zjhm_onblur();", 300);
}

// 基本信息，根据证件种类与号码 ，进行人员复用
function jbxx_zjhm_onblur() {
	if (!$("#jbxx_cyzjdm").combo("isValid")) {
		$("#jbxx_id").val("");
		return;
	}
	if (!$("#jbxx_zjhm").validatebox("isValid")) {
		$("#jbxx_id").val("");
		return;
	}
	if ($("#jbxx_zjhm").val() == "") {
		$("#jbxx_id").val("");
		return;
	}
	var _cyzjdm = $("#jbxx_zjhm").attr("cyzjdm");
	if (!_cyzjdm) {
		_cyzjdm = "";
	} 
	var _zjhm = $("#jbxx_zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if ($("#jbxx_cyzjdm").combobox("getValue") == _cyzjdm && $("#jbxx_zjhm").val() == _zjhm) {
		return;
	}
	$("#jbxxLoadDiv").show();
	$.ajax({
		type: "POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType: "json",
		data:"zjhm=" + $("#jbxx_zjhm").val() + "&cyzjdm=" + $("#jbxx_cyzjdm").combobox("getValue"),
		success: function(data) {
			if (data && data.ryRyjbxxb) {
				$("#jbxx_id").val(data.ryRyjbxxb.id);
				$("#jbxx_xm").val(data.ryRyjbxxb.xm);
				$("#jbxx_xm").validatebox("validate");
				$("#jbxx_xbdm").combobox("setValue", data.ryRyjbxxb.xbdm);
				$("#jbxx_csrq").val(data.ryRyjbxxb.csrq);
				$("#jbxx_csrq").validatebox("validate");
				$("#jbxx_mzdm").combobox("setValue", data.ryRyjbxxb.mzdm);
				$("#jbxx_lxdh").val(data.ryRyjbxxb.lxdh);
				if (data.ryRyjbxxb.csdgjhdqdm != "") {
					$("#jbxx_csdgjhdqdm").combobox("setValue", data.ryRyjbxxb.csdgjhdqdm);
				}
				$("#jbxx_csdssxdm").combobox("setValue", data.ryRyjbxxb.csdssxdm);
				if (data.ryRyjbxxb.jggjdqdm != "") {
					$("#jbxx_jggjdqdm").combobox("setValue", data.ryRyjbxxb.jggjdqdm);
				}
				$("#jbxx_jgssxdm").combobox("setValue", data.ryRyjbxxb.jgssxdm);
				
				$("#jbxx_cym").val(data.ryRyjbxxb.cym);
				$("#jbxx_xldm").combotree("setValue", data.ryRyjbxxb.xldm);
				$("#jbxx_hyzkdm").combobox("setValue", data.ryRyjbxxb.hyzkdm);
				$("#jbxx_zzmmdm").combobox("setValue", data.ryRyjbxxb.zzmmdm);
				$("#jbxx_zjxydm").combobox("setValue", data.ryRyjbxxb.zjxydm);
				$("#jbxx_byzkdm").combobox("setValue", data.ryRyjbxxb.byzkdm);
				$("#jbxx_xxdm").combobox("setValue", data.ryRyjbxxb.xxdm);
				$("#jbxx_zylbdm").combotree("setValue", data.ryRyjbxxb.zylbdm);
				$("#jbxx_zy").val(data.ryRyjbxxb.zy);
				$("#jbxx_hjd_dzms").val(data.ryRyjbxxb.hjd_dzms);
				$("#jbxx_hjd_xzqhdm").val(data.ryRyjbxxb.hjd_xzqhdm);
				$("#jbxx_hjd_mlpdm").val(data.ryRyjbxxb.hjd_mlpdm);
				$("#jbxx_hjd_mlpxz").val(data.ryRyjbxxb.hjd_mlpxz);
				$("#jbxx_hjd_dzid").val(data.ryRyjbxxb.hjd_dzid);
				$("#jbxx_hjd_dzxz").val(data.ryRyjbxxb.hjd_dzxz);
				$("#jbxx_hjd_pcsdm").val(data.ryRyjbxxb.hjd_pcsdm);
				
				var syrkywlxdmValue = $("#syrkywlxdm").combobox("getValue");
				if (syrkywlxdmValue == "4") { // 境外人员时处理
					$("#jwry_wwx").val(data.ryRyjbxxb.wwx);
					$("#jwry_wwm").val(data.ryRyjbxxb.wwm);
					$("#jwry_xbdm").combobox("setValue", data.ryRyjbxxb.xbdm);
					$("#jwry_csrq").val(data.ryRyjbxxb.csrq);
					$("#jwry_gjdm").combobox("setValue", data.ryRyjbxxb.gjdm);
					$("#jwry_lxdh").val(data.ryRyjbxxb.lxdh);
				}
			}if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete: function() {
			$("#jbxx_zjhm").attr("cyzjdm", $("#jbxx_cyzjdm").combobox("getValue"));
			$("#jbxx_zjhm").attr("zjhm", $("#jbxx_zjhm").val());
			$("#jbxxLoadDiv").hide();
		},
		error: function() {
		}
	});	
}

function jbxx_jggjdqdm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var jbxx_jggjdqdmValue = $("#jbxx_jggjdqdm").combobox("getValue");
	if (jbxx_jggjdqdmValue == "156") {
		setInputReadonly("jbxx_jgssxdm", false);
	}
	else {
		$("#jbxx_jgssxdm").combobox("setValue", "");
		setInputReadonly("jbxx_jgssxdm", true);
	}
}

function czrk_hh_onblur() {
	var czrk_hhValue = $("#czrk_hh").val();
	if (czrk_hhValue != "" && $("#czrk_hh").validatebox("isValid")) {
		czrk_hhValue = "000000000" + czrk_hhValue;
		czrk_hhValue = czrk_hhValue.substring(czrk_hhValue.length - 9);
		$("#czrk_hh").val(czrk_hhValue);
	}
}

function czrk_sfrhyzdm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var czrk_sfrhyzdmValue = $("#czrk_sfrhyzdm").combobox("getValue");
	if (czrk_sfrhyzdmValue == "0") { // 人户分离
		$("#rhfl_hjd_tr1").show();
		$("#rhfl_hjd_tr2").show();
		$("#rhfl_hjd_tr3").show();
		var selectNo = 1;
		if ($("#hjRadio2").is(":checked")) {
			selectNo = 2;
		} 
		else if ($("#hjRadio3").is(":checked")) {
			selectNo = 3;
		}
		czrk_rhfl_hjd_select(selectNo);
		setComboRequired("czrk_jzd1", false);
		setComboRequired("czrk_jzd2", false);
		$("#czrk_zrqdm").val("");
	}
	else {
		$("#rhfl_hjd_tr1").hide();
		$("#rhfl_hjd_tr2").hide();
		$("#rhfl_hjd_tr3").hide();
		setComboRequired("czrk1_hjd1", false);
		setComboRequired("czrk1_hjd2", false);
		setComboRequired("czrk_jzd1", true);
		setComboRequired("czrk_jzd2", true);
		$("#czrk_zrqdm").val(zrqdm);
	}
}

function czrk_rhfl_hjd_select(selectNo) {
	if (selectNo == 1) {
		setInputReadonly("czrk1_hjd1", false);
		setInputReadonly("czrk1_hjd2", false);
		setComboRequired("czrk1_hjd1", true);
		setComboRequired("czrk1_hjd2", true);		
		setInputReadonly("czrk2_hjd_dzxz", true);
		setInputReadonly("czrk3_hjd_dzxz", true);
	}
	else if (selectNo == 2) {
		setInputReadonly("czrk2_hjd_dzxz", true);
		setInputReadonly("czrk3_hjd_dzxz", true);
		setInputReadonly("czrk1_hjd1", true);
		setInputReadonly("czrk1_hjd2", true);
		$("#czrk2_hjd_dzxz").removeClass("inputReadonly");
		setComboRequired("czrk1_hjd1", false);
		setComboRequired("czrk1_hjd2", false);		
	}
	else {
		setInputReadonly("czrk2_hjd_dzxz", true);
		setInputReadonly("czrk3_hjd_dzxz", true);
		setInputReadonly("czrk1_hjd1", true);
		setInputReadonly("czrk1_hjd2", true);
		$("#czrk3_hjd_dzxz").removeClass("inputReadonly");
		setComboRequired("czrk1_hjd1", false);
		setComboRequired("czrk1_hjd2", false);		
	}
}

function jzrk_zjzcsfldm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var jzrk_zjzcsfldmValue = $("#jzrk_zjzcsfldm").combotree("getValue");
	if (jzrk_zjzcsfldmValue == "30") { // 居住处所为租赁房屋
		$("#jzrk_fz_tr1").show();
		$("#jzrk_fz_tr2").show();
		$("#jzrk_fz_tr3").show();
		$("#jzrk_fz_tr4").show();
	}
	else {
		$("#jzrk_fz_tr1").hide();
		$("#jzrk_fz_tr2").hide();
		$("#jzrk_fz_tr3").hide();
		$("#jzrk_fz_tr4").hide();
		$("#jzrk_fwczqkdm").combobox("setValue", "");
		$("#jzrk_chzr_yfzgx_rygxdm").combotree("setValue", "");
		$("#jzrk_fz_ryid").val("");
		$("#jzrk_fz_cyzjdm").combobox("setValue", "");
		$("#jzrk_fz_zjhm").val("");
		$("#jzrk_fz_xm").val("");
		$("#jzrk_fz_lxdh").val("");
		$("#jzrk_fz_jzd1").combobox("loadData", []);
		$("#jzrk_fz_jzd2").combobox("loadData", []);
		var comboText = $("#jzrk_fz_jzd1").next(".combo").children(".combo-text");
		comboText.val("");
		var comboText = $("#jzrk_fz_jzd2").next(".combo").children(".combo-text");
		comboText.val("");
		var opts = $("#jzrk_fz_jzd2").combobox("options");
		opts.validEnter = false;
		$("#jzrk_fz_jzd_xzqhdm").val("");
		$("#jzrk_fz_jzd_mlpdm").val("");
		$("#jzrk_fz_jzd_mlpxz").val("");
		$("#jzrk_fz_jzd_dzid").val("");
		$("#jzrk_fz_jzd_dzxz").val("");
	}
}

function jzrk_fz_cyzjdm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var cyzjdmValue = $("#jzrk_fz_cyzjdm").combobox("getValue");
	if (cyzjdmValue == "111" || cyzjdmValue == "112" || cyzjdmValue == "335") { // 身份证类型、临时身份证、机动车驾驶证
		$("#jzrk_fz_zjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#jzrk_fz_zjhm").validatebox({validType:['letterOrNum']});
	}
	setTimeout("jzrk_fz_zjhm_onblur();", 300);
}

function jzrk_fz_zjhm_onblur() {
	if (!$("#jzrk_fz_cyzjdm").combo("isValid")) {
		$("#jzrk_fz_ryid").val("");
		return;
	}
	if (!$("#jzrk_fz_zjhm").validatebox("isValid")) {
		$("#jzrk_fz_ryid").val("");
		return;
	}
	if ($("#jzrk_fz_zjhm").val() == "") {
		$("#jzrk_fz_ryid").val("");
		return;
	}
	var _cyzjdm = $("#jzrk_fz_zjhm").attr("cyzjdm");
	if (!_cyzjdm) {
		_cyzjdm = "";
	} 
	var _zjhm = $("#jzrk_fz_zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if ($("#jzrk_fz_cyzjdm").combobox("getValue") == _cyzjdm && $("#jzrk_fz_zjhm").val() == _zjhm) {
		return;
	}
	$("#jzrk_fzLoadDiv").show();
	$.ajax({
		type: "POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType: "json",
		data:"zjhm=" + $("#jzrk_fz_zjhm").val() + "&cyzjdm=" + $("#jzrk_fz_cyzjdm").combobox("getValue"),
		success: function(data) {
			if (data && data.ryRyjbxxb) {
				$("#jzrk_fz_ryid").val(data.ryRyjbxxb.id);
				$("#jzrk_fz_xm").val(data.ryRyjbxxb.xm);
				$("#jzrk_fz_xm").validatebox("validate");
				$("#jzrk_fz_lxdh").val(data.ryRyjbxxb.lxdh);
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete: function() {
			$("#jzrk_fz_zjhm").attr("cyzjdm", $("#jzrk_fz_cyzjdm").combobox("getValue"));
			$("#jzrk_fz_zjhm").attr("zjhm", $("#jzrk_fz_zjhm").val());
			$("#jzrk_fzLoadDiv").hide();
		},
		error: function() {
		}
	});	
}

function ldrk_zjzcsfldm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var ldrk_zjzcsfldmValue = $("#ldrk_zjzcsfldm").combotree("getValue");
	if (ldrk_zjzcsfldmValue == "30") { // 居住处所为租赁房屋
		$("#ldrk_fz_tr1").show();
		$("#ldrk_fz_tr2").show();
		$("#ldrk_fz_tr3").show();
		$("#ldrk_fz_tr4").show();
	}
	else {
		$("#ldrk_fz_tr1").hide();
		$("#ldrk_fz_tr2").hide();
		$("#ldrk_fz_tr3").hide();
		$("#ldrk_fz_tr4").hide();
		$("#ldrk_fwczqkdm").combobox("setValue", "");
		$("#ldrk_chzr_yfzgx_rygxdm").combotree("setValue", "");
		$("#ldrk_fz_ryid").val("");
		$("#ldrk_fz_cyzjdm").combobox("setValue", "");
		$("#ldrk_fz_zjhm").val("");
		$("#ldrk_fz_xm").val("");
		$("#ldrk_fz_lxdh").val("");
		$("#ldrk_fz_jzd1").combobox("loadData", []);
		$("#ldrk_fz_jzd2").combobox("loadData", []);
		var comboText = $("#ldrk_fz_jzd1").next(".combo").children(".combo-text");
		comboText.val("");
		var comboText = $("#ldrk_fz_jzd2").next(".combo").children(".combo-text");
		comboText.val("");
		var opts = $("#ldrk_fz_jzd2").combobox("options");
		opts.validEnter = false;
		$("#ldrk_fz_jzd_xzqhdm").val("");
		$("#ldrk_fz_jzd_mlpdm").val("");
		$("#ldrk_fz_jzd_mlpxz").val("");
		$("#ldrk_fz_jzd_dzid").val("");
		$("#ldrk_fz_jzd_dzxz").val("");
	}
}

function ldrk_fz_cyzjdm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var cyzjdmValue = $("#ldrk_fz_cyzjdm").combobox("getValue");
	if (cyzjdmValue == "111" || cyzjdmValue == "112" || cyzjdmValue == "335") { // 身份证类型、临时身份证、机动车驾驶证
		$("#ldrk_fz_zjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#ldrk_fz_zjhm").validatebox({validType:['letterOrNum']});
	}
	setTimeout("ldrk_fz_zjhm_onblur();", 300);
}

function ldrk_fz_zjhm_onblur() {
	if (!$("#ldrk_fz_cyzjdm").combo("isValid")) {
		$("#ldrk_fz_ryid").val("");
		return;
	}
	if (!$("#ldrk_fz_zjhm").validatebox("isValid")) {
		$("#ldrk_fz_ryid").val("");
		return;
	}
	if ($("#ldrk_fz_zjhm").val() == "") {
		$("#ldrk_fz_ryid").val("");
		return;
	}
	var _cyzjdm = $("#ldrk_fz_zjhm").attr("cyzjdm");
	if (!_cyzjdm) {
		_cyzjdm = "";
	} 
	var _zjhm = $("#ldrk_fz_zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if ($("#ldrk_fz_cyzjdm").combobox("getValue") == _cyzjdm && $("#ldrk_fz_zjhm").val() == _zjhm) {
		return;
	}
	$("#ldrk_fzLoadDiv").show();
	$.ajax({
		type: "POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType: "json",
		data:"zjhm=" + $("#ldrk_fz_zjhm").val() + "&cyzjdm=" + $("#ldrk_fz_cyzjdm").combobox("getValue"),
		success: function(data) {
			if (data && data.ryRyjbxxb) {
				$("#ldrk_fz_ryid").val(data.ryRyjbxxb.id);
				$("#ldrk_fz_xm").val(data.ryRyjbxxb.xm);
				$("#ldrk_fz_xm").validatebox("validate");
				$("#ldrk_fz_lxdh").val(data.ryRyjbxxb.lxdh);
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete: function() {
			$("#ldrk_fz_zjhm").attr("cyzjdm", $("#ldrk_fz_cyzjdm").combobox("getValue"));
			$("#ldrk_fz_zjhm").attr("zjhm", $("#ldrk_fz_zjhm").val());
			$("#ldrk_fzLoadDiv").hide();
		},
		error: function() {
		}
	});	
}

function jwry_zjzcsfldm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var jwry_zjzcsfldmValue = $("#jwry_zjzcsfldm").combotree("getValue");
	if (jwry_zjzcsfldmValue == "30") { // 居住处所为租赁房屋
		$("#jwry_fz_tr1").show();
		$("#jwry_fz_tr2").show();
		$("#jwry_fz_tr3").show();
		$("#jwry_fz_tr4").show();
	}
	else {
		$("#jwry_fz_tr1").hide();
		$("#jwry_fz_tr2").hide();
		$("#jwry_fz_tr3").hide();
		$("#jwry_fz_tr4").hide();
		$("#jwry_fwczqkdm").combobox("setValue", "");
		$("#jwry_chzr_yfzgx_rygxdm").combotree("setValue", "");
		$("#jwry_fz_ryid").val("");
		$("#jwry_fz_cyzjdm").combobox("setValue", "");
		$("#jwry_fz_zjhm").val("");
		$("#jwry_fz_xm").val("");
		$("#jwry_fz_lxdh").val("");
		$("#jwry_fz_jzd1").combobox("loadData", []);
		$("#jwry_fz_jzd2").combobox("loadData", []);
		var comboText = $("#jwry_fz_jzd1").next(".combo").children(".combo-text");
		comboText.val("");
		var comboText = $("#jwry_fz_jzd2").next(".combo").children(".combo-text");
		comboText.val("");
		var opts = $("#jwry_fz_jzd2").combobox("options");
		opts.validEnter = false;
		$("#jwry_fz_jzd_xzqhdm").val("");
		$("#jwry_fz_jzd_mlpdm").val("");
		$("#jwry_fz_jzd_mlpxz").val("");
		$("#jwry_fz_jzd_dzid").val("");
		$("#jwry_fz_jzd_dzxz").val("");
	}
}

function jwry_fz_cyzjdm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var cyzjdmValue = $("#jwry_fz_cyzjdm").combobox("getValue");
	if (cyzjdmValue == "111" || cyzjdmValue == "112" || cyzjdmValue == "335") { // 身份证类型、临时身份证、机动车驾驶证
		$("#jwry_fz_zjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#jwry_fz_zjhm").validatebox({validType:['letterOrNum']});
	}
	setTimeout("jwry_fz_zjhm_onblur();", 300);
}

function jwry_fz_zjhm_onblur() {
	if (!$("#jwry_fz_cyzjdm").combo("isValid")) {
		$("#jwry_fz_ryid").val("");
		return;
	}
	if (!$("#jwry_fz_zjhm").validatebox("isValid")) {
		$("#jwry_fz_ryid").val("");
		return;
	}
	if ($("#jwry_fz_zjhm").val() == "") {
		$("#jwry_fz_ryid").val("");
		return;
	}
	var _cyzjdm = $("#jwry_fz_zjhm").attr("cyzjdm");
	if (!_cyzjdm) {
		_cyzjdm = "";
	} 
	var _zjhm = $("#jwry_fz_zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if ($("#jwry_fz_cyzjdm").combobox("getValue") == _cyzjdm && $("#jwry_fz_zjhm").val() == _zjhm) {
		return;
	}
	$("#jwry_fzLoadDiv").show();
	var url = contextPath + "/ryRyjbxxb/dataApply";
	if($("#jwryId").is(":checked")){
		url = contextPath + "/syrkJwryxxb/dataApply";
	}
	$.ajax({
		type: "POST",
		url: url,
		dataType: "json",
		data:"zjhm=" + $("#jwry_fz_zjhm").val() + "&cyzjdm=" + $("#jwry_fz_cyzjdm").combobox("getValue"),
		success: function(data) {
			if($("#jwryId").is(":checked")){
				if (data && data.jwRyjbxxb) {
					$("#jwry_fz_ryid").val(data.jwRyjbxxb.ryid);
					$("#jwry_fz_xm").val(data.jwRyjbxxb.xm);
					$("#jwry_fz_xm").validatebox("validate");
					$("#jwry_fz_lxdh").val(data.jwRyjbxxb.fz_lxdh);
					$("#jwry_fz_gjdm").combobox("setValue",data.jwRyjbxxb.fz_gjdm);
					$("#jwry_fz_xbdm").combobox("setValue",data.jwRyjbxxb.fz_xbdm);
					$("#jwry_fz_wwx").val(data.jwRyjbxxb.fz_wwx);
					$("#jwry_fz_wwx").validatebox("validate");
					$("#jwry_fz_wwm").val(data.jwRyjbxxb.fz_wwm);
					$("#jwry_fz_wwm").validatebox("validate");
					$("#jwry_fz_csrq").val(data.jwRyjbxxb.fz_csrq);
					$("#jwry_fz_csrq").validatebox("validate");
				}
			}else{
				if (data && data.ryRyjbxxb) {
					$("#jwry_fz_ryid").val(data.ryRyjbxxb.id);
					$("#jwry_fz_xm").val(data.ryRyjbxxb.xm);
					$("#jwry_fz_xm").validatebox("validate");
					$("#jwry_fz_lxdh").val(data.ryRyjbxxb.lxdh);
				}
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete: function() {
			$("#jwry_fz_zjhm").attr("cyzjdm", $("#jwry_fz_cyzjdm").combobox("getValue"));
			$("#jwry_fz_zjhm").attr("zjhm", $("#jwry_fz_zjhm").val());
			$("#jwry_fzLoadDiv").hide();
		},
		error: function() {
		}
	});	
}

function wlrk_qtcyzjdm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var cyzjdmValue = $("#wlrk_qtcyzjdm").combobox("getValue");
	if (cyzjdmValue == "111" || cyzjdmValue == "112" || cyzjdmValue == "335") { // 身份证类型、临时身份证、机动车驾驶证
		$("#wlrk_qtzjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#wlrk_qtzjhm").validatebox({validType:['letterOrNum']});
	}
}

function wlrk_zjzcsfldm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var wlrk_zjzcsfldmValue = $("#wlrk_zjzcsfldm").combotree("getValue");
	if (wlrk_zjzcsfldmValue == "30") { // 居住处所为租赁房屋
		$("#wlrk_fz_tr1").show();
		$("#wlrk_fz_tr2").show();
		$("#wlrk_fz_tr3").show();
		$("#wlrk_fz_tr4").show();
	}
	else {
		$("#wlrk_fz_tr1").hide();
		$("#wlrk_fz_tr2").hide();
		$("#wlrk_fz_tr3").hide();
		$("#wlrk_fz_tr4").hide();
		$("#wlrk_fwczqkdm").combobox("setValue", "");
		$("#wlrk_chzr_yfzgx_rygxdm").combotree("setValue", "");
		$("#wlrk_fz_ryid").val("");
		$("#wlrk_fz_cyzjdm").combobox("setValue", "");
		$("#wlrk_fz_zjhm").val("");
		$("#wlrk_fz_xm").val("");
		$("#wlrk_fz_lxdh").val("");
		$("#wlrk_fz_jzd1").combobox("loadData", []);
		$("#wlrk_fz_jzd2").combobox("loadData", []);
		var comboText = $("#wlrk_fz_jzd1").next(".combo").children(".combo-text");
		comboText.val("");
		var comboText = $("#wlrk_fz_jzd2").next(".combo").children(".combo-text");
		comboText.val("");
		var opts = $("#wlrk_fz_jzd2").combobox("options");
		opts.validEnter = false;
		$("#wlrk_fz_jzd_xzqhdm").val("");
		$("#wlrk_fz_jzd_mlpdm").val("");
		$("#wlrk_fz_jzd_mlpxz").val("");
		$("#wlrk_fz_jzd_dzid").val("");
		$("#wlrk_fz_jzd_dzxz").val("");
	}
}
function wlrk_fz_cyzjdm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var cyzjdmValue = $("#wlrk_fz_cyzjdm").combobox("getValue");
	if (cyzjdmValue == "111" || cyzjdmValue == "112" || cyzjdmValue == "335") { // 身份证类型、临时身份证、机动车驾驶证
		$("#wlrk_fz_zjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#wlrk_fz_zjhm").validatebox({validType:['letterOrNum']});
	}
	setTimeout("wlrk_fz_zjhm_onblur();", 300);
}

function wlrk_fz_zjhm_onblur() {
	if (!$("#wlrk_fz_cyzjdm").combo("isValid")) {
		$("#wlrk_fz_ryid").val("");
		return;
	}
	if (!$("#wlrk_fz_zjhm").validatebox("isValid")) {
		$("#wlrk_fz_ryid").val("");
		return;
	}
	if ($("#wlrk_fz_zjhm").val() == "") {
		$("#wlrk_fz_ryid").val("");
		return;
	}
	var _cyzjdm = $("#wlrk_fz_zjhm").attr("cyzjdm");
	if (!_cyzjdm) {
		_cyzjdm = "";
	} 
	var _zjhm = $("#wlrk_fz_zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if ($("#wlrk_fz_cyzjdm").combobox("getValue") == _cyzjdm && $("#wlrk_fz_zjhm").val() == _zjhm) {
		return;
	}
	$("#wlrk_fzLoadDiv").show();
	$.ajax({
		type: "POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType: "json",
		data:"zjhm=" + $("#wlrk_fz_zjhm").val() + "&cyzjdm=" + $("#wlrk_fz_cyzjdm").combobox("getValue"),
		success: function(data) {
			if (data && data.ryRyjbxxb) {
				$("#wlrk_fz_ryid").val(data.ryRyjbxxb.id);
				$("#wlrk_fz_xm").val(data.ryRyjbxxb.xm);
				$("#wlrk_fz_xm").validatebox("validate");
				$("#wlrk_fz_lxdh").val(data.ryRyjbxxb.lxdh);
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete: function() {
			$("#wlrk_fz_zjhm").attr("cyzjdm", $("#wlrk_fz_cyzjdm").combobox("getValue"));
			$("#wlrk_fz_zjhm").attr("zjhm", $("#wlrk_fz_zjhm").val());
			$("#wlrk_fzLoadDiv").hide();
		},
		error: function() {
		}
	});	
}
/**
 * @title:jwry_zjhm_onblur
 * @description:境外人员_证件号码_复用信息
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-05-28 11:32:23
 */
function jwry_zjhm_onblur(){
	if (!$("#jwry_gjdm").combo("isValid")) {
		$("#jwry_id").val("");
		return;
	}
	if (!$("#jwry_cyzjdm").combo("isValid")) {
		$("#jwry_id").val("");
		return;
	}
	if (!$("#jwry_zjhm").validatebox("isValid")) {
		$("#jwry_id").val("");
		return;
	}
	if ($("#jwry_zjhm").val() == "") {
		$("#jwry_id").val("");
		return;
	}
	var _gjdm = $("#jwry_zjhm").attr("gjdm");
	if (!_gjdm) {
		_gjdm = "";
	} 
	var _cyzjdm = $("#jwry_zjhm").attr("cyzjdm");
	if (!_cyzjdm) {
		_cyzjdm = "";
	} 
	var _zjhm = $("#jwry_zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if ($("#jwry_gjdm").combobox("getValue") == _gjdm && $("#jwry_cyzjdm").combobox("getValue") == _cyzjdm && $("#jwry_zjhm").val() == _zjhm ) {
		return;
	}
	$("#jwryLoadDiv").show();
	$.ajax({
		type: "POST",
		url: contextPath + "/syrkJwryxxb/dataApply",
		dataType: "json",
		data:"gjdm="+$("#jwry_gjdm").combobox("getValue")+"&zjhm=" + $("#jwry_zjhm").val() + "&cyzjdm=" + $("#jwry_cyzjdm").combobox("getValue"),
		success: function(data) {
			if (data && data.jwRyjbxxb) {
				$("#jbxx_id").val(data.jwRyjbxxb.ryid);
				$("#jwry_xm").val(data.jwRyjbxxb.xm);
				$("#jwry_wwx").val(data.jwRyjbxxb.wwx);
				$("#jwry_wwx").validatebox("validate");
				$("#jwry_wwm").val(data.jwRyjbxxb.wwm);
				$("#jwry_wwm").validatebox("validate");
				$("#jwry_xbdm").combobox("setValue", data.jwRyjbxxb.xbdm);
				$("#jwry_csrq").val(data.jwRyjbxxb.csrq);
				$("#jwry_csrq").validatebox("validate");
				$("#jwry_qt_sfzhm").val(data.jwRyjbxxb.qt_sfzhm);
				$("#jwry_qt_sfzhm").validatebox("validate");
				$("#jwry_qzjlxkzldm").combobox("setValue", data.jwRyjbxxb.qzjlxkzldm);
				$("#jwry_qzjlxkh").val(data.jwRyjbxxb.qzjlxkh);
				$("#jwry_rjrq").val(data.jwRyjbxxb.rjrq);
				$("#jwry_qztjl_jzrq").val(data.jwRyjbxxb.qztjl_jzrq);
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete: function() {
			$("#jwry_zjhm").attr("gjdm", $("#jwry_gjdm").combobox("getValue"));
			$("#jwry_zjhm").attr("cyzjdm", $("#jwry_cyzjdm").combobox("getValue"));
			$("#jwry_zjhm").attr("zjhm", $("#jwry_zjhm").val());
			$("#jwryLoadDiv").hide();
		},
		error: function() {
		}
	});	
};
/**
 * @title:jwry_fzsflb_onClick
 * @description:境外人员_房主身份类别
 * @author: zhang_guoliang@founder.com
 * @param 0境内人员、1境外人员 
 * @date:2015-05-28 09:34:32
 */
function jwry_fzsflb_onClick(){
	var redio = $('input[name="jwry.fz_sflb"]:checked').val();
	if(redio=='0'){
		$("#jwry_fz_tr1").hide();
		$("#jwry_fz_tr2").hide();
		$("#jwry_fz_tr3").hide();
		//设置房主的必填项
		setComboRequired("jwry_fz_gjdm", false);
		setComboRequired("jwry_fz_xbdm", false);
		$("#jwry_fz_wwx").validatebox({required:false});
		$("#jwry_fz_wwm").validatebox({required:false});
		$("#jwry_fz_csrq").validatebox({required:false});
	}else if(redio=='1'){
		$("#jwry_fz_tr1").show();
		$("#jwry_fz_tr2").show();
		$("#jwry_fz_tr3").show();
		//设置房主的必填项
		setComboRequired("jwry_fz_gjdm", true);
		setComboRequired("jwry_fz_xbdm", true);
		$("#jwry_fz_wwx").validatebox({required:true});
		$("#jwry_fz_wwm").validatebox({required:true});
		$("#jwry_fz_csrq").validatebox({required:true});
	}
	//清空房主基本信息
	$("#jwry_fz_cyzjdm").combobox("setValue", "");
	$("#jwry_fz_zjhm").val("");
	$("#jwry_fz_xm").val("");
	$("#jwry_fz_lxdh").val("");
	$("#jwry_fz_gjdm").combobox("setValue", "");
	$("#jwry_fz_xbdm").combobox("setValue", "");
	$("#jwry_fz_wwx").val("");
	$("#jwry_fz_wwm").val("");
	$("#jwry_fz_csrq").val("");
	$("#jwry_fz_zjhm").attr("cyzjdm","");
	$("#jwry_fz_zjhm").attr("zjhm","");
};
/**
 * @title:jwry_gjdm_onChange
 * @description:境外人员_国籍选择判断（台湾、韩国时身份证号码为必填）
 * @author: zhang_guoliang@founder.com
 * @param record下拉列表数据
 * @date:2015-06-01 15:55:43
 */
function jwry_gjdm_onChange(record){
	if(record!="undefined"&&(record=='158'||record=='410')){
		$("#jwry_qt_sfzhm").validatebox({required:true});
	}else{
		$("#jwry_qt_sfzhm").validatebox({required:false});
	}
};
/**
 * @title:onRadioClick
 * @description:地址描述是【禁用】还是【启用】
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-06-02 14:43:31
 */
var radioBz = 0; 
function onRadioClick(bz){
	 radioBz = bz;
	 if(bz==0){
		 setInputReadonly('jwry_jzd1', false);
		 setInputReadonly('jwry_jzd2', false);
		 setInputReadonly('dzms_mldzXz', true);
		 setInputReadonly('dzms_chdz', true);
		 //必填校验
		 setComboRequired('jwry_jzd1', true);
		 setComboRequired('jwry_jzd2', true);
		 setComboRequired('dzms_mldzXz', false);
		 document.getElementById("dtbdButton").disabled = "disabled";
		 //重置单位地址描述
		 $("#dzms_mldzXz").combobox("clear");
		 $("#dzms_mldz").val("");
		 $("#dzms_chdz").val("");
		 $("#dzms_sspcsmc").val("地址描述所属派出所");
		 $("#dzms_sszrqmc").val("地址描述所属责任区");
		 $("#dzms_sspcsdm").val("");
		 $("#dzms_sszrqdm").val("");
		 $("#entity_zbx").val("");
		 $("#entity_zby").val("");
	 }else if(bz==1){
		 setInputReadonly('jwry_jzd1', true);
		 setInputReadonly('jwry_jzd2', true);
		 setInputReadonly('dzms_mldzXz', false);
		 setInputReadonly('dzms_chdz', false);
		 //必填校验
		 setComboRequired('jwry_jzd1', false);
		 setComboRequired('jwry_jzd2', false);
		 setComboRequired('dzms_mldzXz', true);
		 document.getElementById("dtbdButton").disabled = "";
		 //重置单位标准地址
		 $("#jwry_jzd1").combobox("clear");
		 $("#jwry_jzd2").combobox("clear");
		 $("#jwry_jzd_mlpdm").val("");
		 $("#jwry_jzd_mlpxz").val("");
		 $("#jwry_jzd_dzid").val("");
		 $("#jwry_jzd_xzqhdm").val("");
		 $("#jwry_jzd_dzxz").val("");
		 $("#jwry_jzd_zbx").val("");
		 $("#jwry_jzd_zby").val("");
	 }
};