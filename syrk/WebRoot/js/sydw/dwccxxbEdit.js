//@updateAuthor: [star]
//@updateDate:   [2015-6-2 上午8:51:54]

var _zjhm = "";
	initAddressSearch('ccd1', {}, 'dz_ccdzmlpdm', 'dz_ccdzmlpxz', 'ccd2', {text:'dz_ccdzxz',dzxzqh:'dz_ccdzxzqhdm',id:'dz_ccdzdm'}, null, null);
function doInit(paramArray) {
	$("#dwmc").val(paramArray["dwmc"]);
	var flag = document.getElementById("flag").value;
	if(flag=="add"){
		$("#ccfzrcyzjdm").combobox("setValue","111");
	}
	
	zrrdm_init();
}
function beforeSubmit() {
 
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}
function zrrdm_onchange(newVal, oldVal) {
	if (!newVal) {
		return;
	}
	var newFirst = "";
	if (newVal) {
		newFirst = newVal.substring(0, 1);
	}
	else {
		newVal = "";
	}
	var oldFirst = "";
	if (oldVal) {
		oldVal = oldVal.substring(0, 1);
	}
	if (newVal == "111" || newVal == "112" || newVal == "335" ) {
		$("#ccfzrzjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#ccfzrzjhm").validatebox({validType:['maxLength[30]']});
	}
	clearRyjbxx();
	$("#ccfzrzjhm").val("");
	_zjhm = "";
}

function zrrdm_init() {
	var newVal = $("#ccfzrcyzjdm").val();
	if (newVal) {
		newFirst = newVal.substring(0, 1);
	}
	else {
		newVal = "";
	}
	if (newVal == "111" || newVal == "112" || newVal == "335" ) {
		$("#ccfzrzjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#ccfzrzjhm").validatebox({validType:['maxLength[30]']});
	}
}
function clearRyjbxx(){
	$("#ccfzrid").val("");
	$("#ccfzr").val("");
	$("#ccfzrlxdh").val("");
	$("#ccfzrzw").val("");
}
function cczgrzjhm_onblur() {
	if (!$("#ccfzrzjhm").validatebox("isValid")){
		return;
	}
	
		if($("#ccfzrzjhm").val() == _zjhm){
			return;
		}
		$(".lodingimg").show();
		$.ajax({
			type:"POST",
			url: contextPath + "/ryRyjbxxb/dataApply",
			dataType:"json",
			data:"zjhm="+$("#ccfzrzjhm").val()+"&cyzjdm="+$("#ccfzrcyzjdm").val(),
			success:function(data){
				if (data && data.ryRyjbxxb) {
					$("#ccfzrid").val(data.ryRyjbxxb.id);
					$("#ccfzr").val(data.ryRyjbxxb.xm);
					$("#ccfzrlxdh").val(data.ryRyjbxxb.lxdh);
					$("#ccfzrzw").val(data.ryRyjbxxb.zw);
					if("" != $("#ccfzr").val()){
					    setInputReadonly('ccfzr', true);
					}else{
					    setInputReadonly('ccfzr', false);
					}
				}
				else {
					clearRyjbxx();
				}
			},
			complete:function(){
				$("#ccfzrzjhm").attr("zjhm", $("#ccfzrzjhm").val());
				$(".lodingimg").hide();
			}
		});	
	
	
}

function resetTable(){
	$("#ccmc").val("");
	$("#dz_ccdzmlpdm").val("");
	$("#dz_ccdzmlpxz").val("");
	$("#dz_ccdzdm").val("");
	$("#dz_ccdzxzqhdm").val("");
	$("#dz_ccdzxz").val("");
	$("#dz_ccdzxz").val("");
	$("#ccd1").combobox("clear");
	$("#ccd2").combobox("clear");
	$("#zdmj").val("");
	$("#jzmj").val("");
	$("#sfdlccdm").combobox("clear");
	$("#qysj").val("");
	$("#ysqx").val("");
	$("#ccwp").val("");
	$("#ccmj").val("");
	$("#ccrj").val("");
	$("#ccsl").val("");
	$("#sldw").val("");
	$("#xfsbqk").val("");
	$("#zgryxx").val("");
	$("#cczbsdh").val("");
	$("#kgryxx").val("");
	$("#ccfzrcyzjdm").combobox("clear");
	$("#ccfzrzjhm").val("");
	$("#ccfzr").val("");
	$("#ccfzrzw").val("");
	$("#ccfzrlxdh").val("");
	setInputReadonly("ccfzr", false);
	$("#ccfzrcyzjdm").combobox("setValue","111");
}