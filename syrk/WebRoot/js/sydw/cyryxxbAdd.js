//	@updateAuthor: [star]
var _p ;
function doInit(paramArray) { 
	_p = paramArray["_p"];
	lzCheck(sflzdm, "");
	$("#gjdm").combobox("setValue",gjdm);
	if($("#xm").val() != ""){
		setInputReadonly("xm", true);
	}
	if($("#csrq").val() != ""){
		setInputReadonly("csrq", true);
	}
	if($("#xbdm").val() != ""){
		setInputReadonly("xbdm", true);
	}
	if($("#mzdm").val() != ""){
		setInputReadonly("mzdm", true);
	}
	if($("#hjd1").val() != ""){
		setInputReadonly("hjd1", true);
		setInputReadonly("hjd2", true);
	}
	if($("#jjlxr_xm").val() != ""){
		setInputReadonly("jjlxr_xm", true);
	}
	if($("#jjlxr_xbdm").val() != ""){
		setInputReadonly("jjlxr_xbdm", true);
	}
	var sfzzpx = null;
	if(sfzzpx=="是"){
		$("#cyry1").show();
		$("#pxzszl1").show();
		$("#zzpxms1").show();
		
	}else {
		$("#cyry1").hide();
		$("#pxzszl1").hide();
		$("#zzpxms1").hide();
	}
		if($("#cyzjdm").val()  == "111" || $("#cyzjdm").val() =="112" || $("#cyzjdm").val()  == "335"){ 
			$("#zjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
		}else{
			$("#zjhm").validatebox({validType:['maxLength[30]']});
		}
	if($("#id").val()&&$("#id").val()!=''){
		setInputReadonly("cyzjdm", true);
		setInputReadonly("zjhm", true);
	}
	
}
function zzpx(){
	var sfzzpx = null;
	if(sfzzpx=="是"){
		$("#cyry1").show();
		$("#pxzszl1").show();
		$("#zzpxms1").show();
		
	}else {
		$("#cyry1").hide();
		$("#pxzszl1").hide();
		$("#zzpxms1").hide();
	}
	
}
function beforeSubmit() { 	
	var ryid = $("#ryid").val();
	var jjqklxrid = $("#jjlxr_ryid").val();
	if(ryid != undefined && ryid != "" && jjqklxrid != undefined && jjqklxrid != ""){
		if(ryid == jjqklxrid){
			alert("【从业人员】和【紧急联系人员】不能为同一个人！");
			return false;
		}
	}
}

function afterSubmit(arr) {
	$("#dataForm")[0].reset();
	parent.$(_p).datagrid("reload");
	//是否离职默认设置为0
	setInputReadonly("lz_rq", true);
	setInputReadonly("lzyy", true);
	setInputReadonly("lzqx", true);
	setInputReadonly("zjhm", false);
	setInputReadonly("xm", false);
	setInputReadonly("csrq", false);
	setInputReadonly("xbdm", false);
	setInputReadonly("mzdm", false);
	setInputReadonly("hjd1", false);
	setInputReadonly("hjd2", false);
	setInputReadonly("jjlxr_xm", false);
	setInputReadonly("jjlxr_xbdm", false);
	setInputReadonly("jjlxr_lxdh", false);
	
}

$(document).ready(function(){
	initDepartmentSearch('gzdw-box', {glpcsid: ''}, 'sslwgsid', 'sslwgsmc', {});
	initAddressSearch('jzd1', {}, 'dz_xzzdmlpdm', 'dz_xzzdmlpxz', 'jzd2', {text:'dz_xzzxz',dzxzqh:'dz_xzzxzqhdm',id:'dz_xzzdm'}, null, null);
	initAddressSearch('hjd1', {}, 'dz_hjdmlpdm', 'dz_hjdmlpxz', 'hjd2', {text:'dz_hjdxz',dzxzqh:'dz_hjdxzqhdm',id:'dz_hjddm'}, null, null);
	
	if($("#cyzjdm").combobox("getValue") == ""){
		$("#cyzjdm").combobox("setValue","111");
	}
	if($("#jjlxr_cyzjdm").combobox("getValue") == ""){
		$("#jjlxr_cyzjdm").combobox("setValue","111");
	}
     //证件种类
	$("#cyzjdm").bind("onchange",function(e){ zjhmCheck(); });
	$("#sflzdm").bind("onchange",function(e){ lzCheck(); });
	$("#jjlxr_cyzjdm").bind("onchange",function(e){ jjlxrzjhmCheck(); });
	//从业人员信息复用
	$("#zjhm").bind("blur",function(e){ checkRyxx(); });
	//紧急联系人复用人员基本表
	$("#jjlxr_zjhm").bind("blur",function(e){ checkJjlxRyxx(); });
	
});

var _zjhm = "";
/**
 * 从业人员基本信息复用人员基本信息表
 */
function checkRyxx(){
	
	if($("#zjhm").val() == _zjhm){
		return;
	}
	if(!$("#zjhm").validatebox("isValid")){
		return;
	}
	
	$("#yrjbxxDiv").show();
	$.ajax({
		type:"POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#zjhm").val()+"&cyzjdm="+$("#cyzjdm").val(),
		success:function(data){
			if (data && data.ryRyjbxxb) {
				$("#ryid").val(data.ryRyjbxxb.id);
				$("#xm").val(data.ryRyjbxxb.xm);
				$("#xbdm").combobox("setValue",data.ryRyjbxxb.xbdm);
				$("#csrq").val(data.ryRyjbxxb.csrq);
				$("#mzdm").combobox("setValue",data.ryRyjbxxb.mzdm);
				$("#whcddm").combotree("setValue",data.ryRyjbxxb.xldm);
				$("#gjdm").combobox("setValue",data.ryRyjbxxb.jggjdqdm);
				$("#dz_hjdmlpxz").val(data.ryRyjbxxb.hjd_mlpxz);
				$("#dz_hjdmlpdm").val(data.ryRyjbxxb.hjd_mlpdm);
				$("#dz_hjdxz").val(data.ryRyjbxxb.hjd_dzxz);
				$("#dz_hjddm").val(data.ryRyjbxxb.hjd_dzid);
				$("#dz_hjdxzqhdm").val(data.ryRyjbxxb.hjd_xzqhdm);
				$("#hjd1").combobox('setValue', data.ryRyjbxxb.hjd_mlpxz);
				$("#hjd2").combobox('setValue', data.ryRyjbxxb.hjd_dzxz.replace(data.ryRyjbxxb.hjd_mlpxz, ''));
				if(data.ryRyjbxxb.xm != ""){
					setInputReadonly("xm", true);
				}
				if(data.ryRyjbxxb.csrq != ""){
					setInputReadonly("csrq", true);
				}
				if(data.ryRyjbxxb.xbdm != ""){
					setInputReadonly("xbdm", true);
				}
				if(data.ryRyjbxxb.mzdm != ""){
					setInputReadonly("mzdm", true);
				}
				if(data.ryRyjbxxb.dz_hjdzxz != ""){
					setInputReadonly("hjd1", true);
					setInputReadonly("hjd2", true);
				}
			}else{
				clearRyjbxx();
			}
		},
		complete:function(){
			_zjhm = $("#zjhm").val();
			$("#yrjbxxDiv").hide();
		}
	});
}

var _jjlxrZjhm = "";
/**
 * 紧急联系人复用人员基本信息表
 */
function checkJjlxRyxx(){
	if(!$("#jjlxr_zjhm").validatebox("isValid")){
		return;
	}
	if($("#jjlxr_zjhm").val() == _jjlxrZjhm){
		return;
	}
	$("#jjlxrDiv").show();
	$.ajax({
		type:"POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#jjlxr_zjhm").val()+"&cyzjdm="+$("#jjlxr_cyzjdm").val(),
		success:function(data){
			if (data && data.ryRyjbxxb) {
				$("#jjlxr_ryid").val(data.ryRyjbxxb.id);
				$("#jjlxr_xm").val(data.ryRyjbxxb.xm);
				$("#jjlxr_xbdm").combobox("setValue",data.ryRyjbxxb.xbdm);
				$("#jjlxr_lxdh").val(data.ryRyjbxxb.lxdh);
				if(data.ryRyjbxxb.xm != ""){
					setInputReadonly("jjlxr_xm", true);
				}
				if(data.ryRyjbxxb.xbdm != ""){
					setInputReadonly("jjlxr_xbdm", true);
				}
			}else{
				clearJjlxryjbxx();
			}
		},
		complete:function(){
			_jjlxrZjhm = $("#jjlxr_zjhm").val();
			$("#jjlxrDiv").hide();
		}
	});
}

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

//紧急联系人-验证证件号码
function jjlxrzjhmCheck(newValue, oldValue){
	if(newValue==""){
		$("#jjlxr_zjhm").validatebox({validType:null});
		return;
	}
	if (!newValue) {
		return;
	}
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue=="112" || newValue == "335"){ 
		$("#jjlxr_zjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#jjlxr_zjhm").validatebox({validType:['maxLength[30]']});
	}
	
	clearJjlxryjbxx();
	$("#jjlxr_zjhm").val("");
	_jjlxrZjhm = "";
}
//是否离职 判断
function lzCheck(newValue, oldValue){
	if(newValue == "1"){//是
		setInputReadonly("lz_rq", false);
		setInputReadonly("lzyy", false);
		setInputReadonly("lzqx", false);
		
	}else{//否
		$("#lz_rq").val("");//离职日期
		$("#lzyy").val("");//离职原因
		$("#lzqx").val("");//离职去向
		setInputReadonly("lz_rq", true);
		setInputReadonly("lzyy", true);
		setInputReadonly("lzqx", true);
	}
}

//清空复用的人员基本信息
function clearRyjbxx(){
	$("#ryid").val("");
	$("#xm").val("");
	$("#xbdm").combobox("setValue","");
	$("#csrq").val("");
	$("#mzdm").combobox("setValue","");
	$("#whcddm").combotree("setValue","");
	$("#gjdqdm").combobox("setValue","");
	$("#hjd1").combobox('setValue', "");
	$("#hjd2").combobox('setValue', "");
	$("#jzd1").combobox('setValue', "");
	$("#jzd2").combobox('setValue', "");
	$("#dz_hjdxz").val("");
	$("#dz_hjdxzqhdm").val("");
	$("#dz_hjddm").val("");
	$("#dz_hjdmlpxz").val("");
	$("#dz_hjdmlpdm").val("");
	$("#dz_xzzdmlpdm").val("");
	$("#dz_xzzdmlpxz").val("");
	$("#dz_xzzxz").val("");
	$("#dz_xzzxzqhdm").val("");
	$("#dz_xzzdm").val("");
	setInputReadonly("xm", false);
	setInputReadonly("csrq", false);
	setInputReadonly("xbdm", false);
	setInputReadonly("mzdm", false);
	setInputReadonly("hjd1", false);
	setInputReadonly("hjd2", false);
}

//清空复用的紧急联系人员信息
function clearJjlxryjbxx(){
	$("#jjlxr_ryid").val("");
	$("#jjlxr_xm").val("");
	$("#jjlxr_xbdm").combobox("setValue","");
	$("#jjlxr_lxdh").val("");
	setInputReadonly("jjlxr_xm", false);
	setInputReadonly("jjlxr_xbdm", false);
	setInputReadonly("jjlxr_dh", false);
}

//清空复用的从业人员信息
function clearCyryxx(){
	$("#pk").val("");
	$("#jl").val("");
	$("#szbmmc").val("");
	$("#zylbdm").val("");
	$("#pyrq").val("");
	$("#lxdh").val("");
	$("#lwxz").val("");
	$("#sslwgsid").val("");
	$("#sslwgsmc").val("");
	$("#jjlxr_ryid").val(""); 
	$("#jjlxr_cyzjdm").combobox("setValue","");
	$("#jjlxr_zjhm").val("");
	$("#jjlxr_xm").val("");
	$("#jjlxr_xbdm").combobox("setValue","");
	$("#jjlxr_lxdh").val("");
	$("#ycyrygxdm").combobox("setValue","");
}

function resetForm(){
	document.forms["dataForm"].reset();
	//$("#sfysgzdm").combobox("setValue","0");
	$("#sflzdm").combobox("setValue","0");
	$("#cyzjdm").combobox("setValue","111");
	$("#jjlxr_cyzjdm").combobox("setValue","111");
}

function resetTable(){
	document.forms["dataForm"].reset();
	setInputReadonly("xm", false);
	setInputReadonly("csrq", false);
	setInputReadonly("xbdm", false);
	setInputReadonly("mzdm", false);
	setInputReadonly("hjd1", false);
	setInputReadonly("hjd2", false);
	setInputReadonly("jjlxr_xm", false);
	setInputReadonly("jjlxr_xbdm", false);
	setInputReadonly("lz_rq", true);
	setInputReadonly("lzyy", true);
	setInputReadonly("lzqx", true);
	setInputReadonly("sgzjhm", true);
	setInputReadonly("sgzjjb", true);
	setInputReadonly("sgzjqdsj", true);
	setInputReadonly("sgzyxq", true);
	setInputReadonly("sgzfzjg", true);
	$("#sflzdm").combobox("setValue","0");
	$("#cyzjdm").combobox("setValue","111");
	$("#jjlxr_cyzjdm").combobox("setValue","111");
}
