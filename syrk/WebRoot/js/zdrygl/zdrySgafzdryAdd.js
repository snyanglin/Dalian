$(function(){
	
	setInputReadonly("jbxx_xm", true);
	setInputReadonly("jbxx_xbdm", true);
	setInputReadonly("czrk_jzd1", true);
	setInputReadonly("czrk_jzd2", true);
	
	initAddressSearch("czrk_jzd1", null, "czrk_jzd_mlpdm", "czrk_jzd_mlpxz", "czrk_jzd2", {text:"czrk_jzd_dzxz",dzxzqh:"czrk_jzd_xzqhdm",id:"czrk_jzd_dzid",dzzbx:"czrk_jzd_zbx",dzzby:"czrk_jzd_zby"}, null, null);
	
	$("#dataForm").form({
		dataType:"json",
		onSubmit: function() {
			if($("#dataForm").form("validate")){
				if ($("#czrk_jzd_mlpdm").val() == "") {
					topMessager.alert("", "居住地必须为标准地址，请重新选择！");
					var comboText = $("#czrk_jzd1").next(".combo").children(".combo-text");
					comboText.focus();
					return false;
				}
				
				var dz = $("#czrk_jzd2").combobox("getValue");
				if(dz == "" || dz == null){
					dz = $("#czrk_jzd2").val();
				}
				if (dz == "") {
					topMessager.alert("", "居住地必须为标准地址，请重新选择！");
					var comboText = $("#czrk_jzd2").next(".combo").children(".combo-text");
					comboText.focus();
					return false;
				}
	    		return true;
	    	}else{
	    		return false; 
	    	}
		},
		success: function(result) {
			var returnData = parseReturn(result);
	    	if(returnData.status == "error"){
	    		topMessager.alert('新增失败', returnData.message, "error");
//	    		topMessager.show({
//					title: MESSAGER_TITLE,
//					msg: returnData.message,
//					timeout:1500
//				});
	    	}else{
				topMessager.show({
					title: MESSAGER_TITLE,
					msg: returnData.message,
					timeout:1500
				});
	    		closeSelf();
	    		executeTabPageMethod($("#tabid").val(), "SgafzdryGl.loadGrid");
	    	}
		}
	});
});

//基本信息，根据证件类型与号码 ，进行人员复用
function jbxx_zjhm_onblur() {
	
	var _zjhm = $("#jbxx_zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if ( $("#jbxx_zjhm").val() == _zjhm) {
		return;
	}
	
	$("#jbxxLoadDiv").show();
	
	setInputReadonly("jbxx_xm", true);
	setInputReadonly("jbxx_xbdm", true);
	setInputReadonly("czrk_jzd1", true);
	setInputReadonly("czrk_jzd2", true);
	
	$.ajax({
		type: "POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType: "json",
		data:"zjhm=" + $("#jbxx_zjhm").val() + "&cyzjdm=111",
		success: function(data) {
			if (data && data.ryRyjbxxb) {
				
				setInputReadonly("jbxx_xm", false);
				setInputReadonly("jbxx_xbdm", false);
				setInputReadonly("czrk_jzd1", false);
				setInputReadonly("czrk_jzd2", false);
				
				$("#jbxx_id").val(data.ryRyjbxxb.id);
				$("#jbxx_xm").val(data.ryRyjbxxb.xm);
				$("#jbxx_xm").validatebox("validate");
				$("#jbxx_xbdm").combobox("setValue", data.ryRyjbxxb.xbdm);
				$("#czrk_jzd_xzqhdm").val(data.ryRyjbxxb.jzd_xzqhdm);
				$("#czrk_jzd_mlpdm").val(data.ryRyjbxxb.jzd_mlpdm);
				$("#czrk_jzd_mlpxz").val(data.ryRyjbxxb.jzd_mlpxz);
				$("#czrk_jzd1").combobox("setValue", data.ryRyjbxxb.jzd_mlpxz);
			
				$("#czrk_jzd2").combobox("setValue", data.ryRyjbxxb.jzd_dzxz.replace(data.ryRyjbxxb.jzd_mlpxz, ""));
				$("#czrk_jzd_dzid").val(data.ryRyjbxxb.jzd_dzid);
				$("#czrk_jzd_dzxz").val(data.ryRyjbxxb.jzd_dzxz);
				
				
				//补充人员的其他信息
				$("#ry_csrq").val(data.ryRyjbxxb.csrq);
				$("#ry_mzdm").val(data.ryRyjbxxb.mzdm);
				
			}
			
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete: function() {
			//$("#jbxx_zjhm").attr("cyzjdm", $("#jbxx_cyzjdm").combobox("getValue"));
			//$("#jbxx_zjhm").attr("zjhm", $("#jbxx_zjhm").val());
			$("#jbxxLoadDiv").hide();
		},
		error: function() {
		}
	});	
}

function saveForm(){
	$('#dataForm').submit();
}