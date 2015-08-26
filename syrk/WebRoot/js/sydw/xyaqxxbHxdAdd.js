var _p ;
var _zjhm = "";

function doInit(paramArray) {
	_p = paramArray["_p"];
	
	if($("#zjlxdm").combobox("getValue") == ""){
		$("#zjlxdm").combobox("setValue","111");
	}
	//人员信息复用
	$("#zjhm").bind("blur",function(e){ checkRyxx(); });
	zjhmCheck($("#zjlxdm").combobox("getValue"),"")
}

function beforeSubmit(){}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	parent.$("#hxdxxb_datagrid").datagrid("reload");
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
		var id=$("#pk").val();
		if(id == ""){
			clearRyxx();
		}
		_zjhm = "";
	}
}

/**
 * 人员基本信息复用人员基本信息表
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
		url:contextPath+"/ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#zjhm").val()+"&cyzjdm="+$("#zjlxdm").val(),
		success:function(data){
			if (data && data.ryRyjbxxb) {
				$("#ryid").val(data.ryRyjbxxb.id);
				$("#xm").val(data.ryRyjbxxb.xm);
				$("#xbdm").combobox("setValue",data.ryRyjbxxb.xbdm);
				$("#lxdh").val(data.ryRyjbxxb.lxdh);
				$("#xm").validatebox("isValid");
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
	$("#ryid").val("");
	$("#xm").val("");
	$("#xbdm").combobox("setValue","");
	$("#lxdh").val("");
}