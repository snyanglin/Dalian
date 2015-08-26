$(function(){
	initAddressSearch("czrk_jzd1", null, "czrk_jzd_mlpdm", "czrk_jzd_mlpxz", "czrk_jzd2", {text:"czrk_jzd_dzxz",dzxzqh:"czrk_jzd_xzqhdm",id:"czrk_jzd_dzid",dzzbx:"czrk_jzd_zbx",dzzby:"czrk_jzd_zby"}, null, null);
	
	$("#dataForm").form({
		dataType:"json",
		onSubmit: function() {
			if($("#dataForm").form("validate")){
	    		return true;
	    	}else{
	    		return false;
	    	}
		},
		success: function(result) {
			var returnData = parseReturn(result);
	    	if(returnData.status == "error"){
	    		topMessager.alert('下发失败', returnData.message, "error");
//	    		topMessager.show({
//					title: MESSAGER_TITLE,
//					msg: returnData.message,
//					timeout:1500
//				});
	    	}else{
				topMessager.show({
					title: MESSAGER_TITLE,
					msg: returnData.message+" 请刷新表格数据",
					timeout:1500
				});
	    		closeSelf();
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
	$.ajax({
		type: "POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType: "json",
		data:"zjhm=" + $("#jbxx_zjhm").val() + "&cyzjdm=111",
		success: function(data) {
			if (data && data.ryRyjbxxb) {
				$("#jbxx_id").val(data.ryRyjbxxb.id);
				$("#jbxx_xm").val(data.ryRyjbxxb.xm);
				$("#jbxx_xm").validatebox("validate");
				$("#jbxx_xbdm").combobox("setValue", data.ryRyjbxxb.xbdm);
				
				/*$("#jbxx_hjd_dzms").val(data.ryRyjbxxb.hjd_dzms);
				$("#jbxx_hjd_xzqhdm").val(data.ryRyjbxxb.hjd_xzqhdm);
				$("#jbxx_hjd_mlpdm").val(data.ryRyjbxxb.hjd_mlpdm);
				$("#jbxx_hjd_mlpxz").val(data.ryRyjbxxb.hjd_mlpxz);
				$("#jbxx_hjd_dzid").val(data.ryRyjbxxb.hjd_dzid);
				$("#jbxx_hjd_dzxz").val(data.ryRyjbxxb.hjd_dzxz);
				$("#jbxx_hjd_pcsdm").val(data.ryRyjbxxb.hjd_pcsdm);*/
				
				$("#czrk_jzd_xzqhdm").val(data.ryRyjbxxb.jzd_xzqhdm);
				$("#czrk_jzd_mlpdm").val(data.ryRyjbxxb.jzd_mlpdm);
				$("#czrk_jzd_mlpxz").val(data.ryRyjbxxb.jzd_mlpxz);
				$("#czrk_jzd1").combobox("setValue", data.ryRyjbxxb.jzd_mlpxz);
				//${fn:replace(zdrySgafzdryxxb.jzd_dzxz, zdrySgafzdryxxb.jzd_mlpxz, "")}
				//$("#czrk_jzd2").combobox("setValue", ${fn:replace(data.ryRyjbxxb.jzd_dzxz, data.ryRyjbxxb.jzd_mlpxz, "")});
				$("#czrk_jzd2").combobox("setValue", data.ryRyjbxxb.jzd_dzxz.replace(data.ryRyjbxxb.jzd_mlpxz, ""));
				$("#czrk_jzd_dzid").val(data.ryRyjbxxb.jzd_dzid);
				$("#czrk_jzd_dzxz").val(data.ryRyjbxxb.jzd_dzxz);
				
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