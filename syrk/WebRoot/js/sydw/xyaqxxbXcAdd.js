//@updateAuthor: [star]
var _p ;
var _zjhm = "";
function doInit(paramArray) {
	_p = paramArray["_p"];
	if($("#jsrzjlxdm").combobox("getValue") == ""){
		$("#jsrzjlxdm").combobox("setValue","111");
	}
	//人员信息复用
	$("#jsrzjhm").bind("blur",function(e){ checkRyxx(); });
	
	//编辑时，根据【自有或租赁】切换租赁相关属性显示
	if($('#zyhzl').combobox('getValue') == '1'){
		onChangeZyhzl('1', null);
	}
}

$(document).ready(function(){
	//单位搜索下拉控件
	initDepartmentSearch('zldw-box', {glpcsid: ''}, 'zldwid', 'zldwmc', {lxdh:'lxdh'}, 'afterSelectDw');
});

function afterSelectDw(dwComboID){
	$('#zldwlxdh').val($('#lxdh').val());
}
//自有或租赁改变触发事件 隐藏或者显示一些显示项。
function onChangeZyhzl(newVal, oldVal){
	if(newVal == '1'){
		$('#tr_zldw').hide();
		$('#tr_zldwdh').hide();
		$('#zldwid').val("");
		$('#zldwmc').val("");
		$('#zldw-box').combobox('setValue', '');
		$('#zldwlxdh').val("");
		$('#zldwfrdbxm').val("");
	}else if(newVal == '2'){
		$('#tr_zldw').show();
		$('#tr_zldwdh').show();
	}
}

function beforeSubmit(){}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	parent.$("#xcxxb_datagrid").datagrid("reload");
}

//验证证件号码
function zjhmCheck(newValue, oldValue){
	if(newValue==""){
		$("#jsrzjhm").validatebox({validType:null});
		return;
	}
	if (!newValue) {
		return;
	}
	
	//111-居民身份证,335-机动车驾驶证
	if(newValue == "111" || newValue=="112" || newValue == "335"){ 
		$("#jsrzjhm").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	}else{
		$("#jsrzjhm").validatebox({validType:['maxLength[30]']});
		clearRyxx();
		$("#jsrzjhm").val("");
		_zjhm = "";
	}
	
}

/**
 * 人员基本信息复用人员基本信息表
 */
function checkRyxx(){
	if($("#jsrzjhm").val() == _zjhm){
		return;
	}
	if(!$("#jsrzjhm").validatebox("isValid")){
		return;
	}
	$("#yrjbxxDiv").show();
	$.ajax({
		type:"POST",
		url:"<%= basePath%>ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#jsrzjhm").val()+"&cyzjdm="+$("#jsrzjlxdm").val(),
		success:function(data){
			if (data && data.ryRyjbxxb) {
				$("#ryid").val(data.ryRyjbxxb.id);
				$("#jsrxm").val(data.ryRyjbxxb.xm);
				$("#jsrlxdh").val(data.ryRyjbxxb.lxdh);
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
	$("#jsrxm").val("");
	$("#jsrlxdh").val("");
}
