//@updateAuthor: [star]
var _zjhm = "";
function doInit(paramArray) {
	if($("#zrr_cyzjdm").combobox("getValue") == ""){
		$("#zrr_cyzjdm").combobox("setValue","111");
	}
	//人员信息复用
	$("#zrr_zjhm").bind("blur",function(e){ checkRyxx(); });
}

function beforeSubmit() {
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	parent.$("#zzyhjzzsbb_datagrid").datagrid("reload");
}

//验证证件号码
function zjhmCheck(newValue, oldValue){
	if(newValue==""){
		$("#zrr_zjhm").validatebox({validType:null});
		return;
	}
	if (!newValue) {
		return;
	}
	
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue=="112" || newValue == "335"){ 
		$("#zrr_zjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#zrr_zjhm").validatebox({validType:['maxLength[30]']});
	}
	
	clearRyxx();
	$("#zrr_zjhm").val("");
	_zjhm = "";
}

/**
 * 人员基本信息复用人员基本信息表
 */
function checkRyxx(){
	if($("#zrr_zjhm").val() == _zjhm){
		return;
	}
	if(!$("#zrr_zjhm").validatebox("isValid")){
		return;
	}
	
	$("#yrjbxxDiv").show();
	$.ajax({
		type:"POST",
		url:"<%= basePath%>ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#zrr_zjhm").val()+"&cyzjdm="+$("#zrr_cyzjdm").val(),
		success:function(data){
			if (data && data.ryRyjbxxb) {
				$("#zrr_ryid").val(data.ryRyjbxxb.id);
				$("#zrr_xm").val(data.ryRyjbxxb.xm);
				$("#zrr_lxdh").val(data.ryRyjbxxb.lxdh);
			}else{
				clearRyxx();
			}
		},
		complete:function(){
			$("#yrjbxxDiv").hide();
		}
	});
}

//清空复用的人员基本信息
function clearRyxx(){
	$("#zrr_ryid").val("");
	$("#zrr_xm").val("");
	$("#zrr_lxdh").val("");
}