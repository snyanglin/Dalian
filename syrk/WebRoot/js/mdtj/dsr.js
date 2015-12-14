/**
 * 
 * @description:当事人
 * @author: tian_chengwei@founder.com
 * @date:2015-06-02
 * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 * 应将重复使用语句抽取成独立方法
 */
$(document).ready(function(){
	
	initDepartmentSearch('dwmc', {glpcsid: ''}, 'gzdwid', 'gzdw', {});
	initAddressSearch('jzd1', {}, 'dz_jzdzmlpdm', 'dz_jzdzmlpxz', 'jzd2', {text:'dz_jzdzxz',dzxzqh:'dz_jzdzssxdm',id:'dz_jzdzdm'}, null, null);
	initAddressSearch('hjd1', {}, 'dz_hjdzmlpdm', 'dz_hjdzmlpxz', 'hjd2', {text:'dz_hjdzxz',dzxzqh:'dz_hjdzssxdm',id:'dz_hjdzdm'}, null, null);
	//回填人员信息
	$("#zjhm").bind("blur", function(e) {
		check();
	});
});
//进入页面执行
function doInit(paramArray) {
	var flag =document.getElementById("flag").value;
	if(flag=="update"){
		if($("#xm").val()!=""){
		setInputReadonly("xm", true);
		}
		if($("#xb").val()!=""){
		setInputReadonly("xb", true);
		}
		if($("#csrq").val() !=""){
		setInputReadonly("csrq", true);
		}
		if($("#zjlx").val() !=""){
		setInputReadonly("zjlx", true);
		}
		if($("#zjhm").val()!=""){
		setInputReadonly("zjhm", true);
		}
		if($("#lxdh").val()!=""){
		setInputReadonly("lxdh", true);
		}
	}else {
		$("#zjlx").combobox('setValue', '111');
	}
}

//验证是否添加此人
function beforeSubmit() {
	var ifExist = false;
	var flag =document.getElementById("flag").value;
	if(flag=="add"){
	$.ajax({
		type:"POST",
		url:basePaht+"sydwgl_dl/checkIfExistByCol",
		async:false,
		dataType:"json",
		data:{colMap:'{\'tableName\':\'FWQZ_MD_DSRXXZB\',\'colList\':[{\'colName\':\'cyzjdm\',\'colValue\':\''+$('#zjlx').val()+'\'},{\'colName\':\'zjhm\',\'colValue\':\''+$('#zjhm').val()+'\'}]},{\'colName\':\'xt_zxbz\',\'colValue\':\'0\'}]}'},
		success:function(data){
			if (data && data.count > 0) {
				$.messager.alert("提示","当事人已存在,请重新输入","",
				function(){	
					clearValues();
					});
					ifExist = true;
				}
			}
		});
	}
	if(ifExist){
		return false;
	}
}


var _zjhm = "";
/**根据证件类型 设置证件号码验证 与人员基本信息只读状态*/
function setPassPort(newVal,oldVal){
	if(!newVal){
		return ;
	}
	//111-居民身份证,335-机动车驾驶证
	if(newVal=="111"||newVal=="335"||newVal=="112"){
		$("#zjhm").validatebox({validType:['sfzh']});
	}else {
		$("#zjhm").validatebox({validType:['maxLength[100]']});
	}	
	clearValues();
}
//清空文本内容
function clearValues(){
	$("#xm").val("");
	$("#ryid").val("");
	$("#csrq").val("");
	$("#dz_jzdzmlpdm").val("");
	$("#dz_jzdzxz").val("");
	$("#dz_jzdzssxdm").val("");
	$("#dz_jzdzdm").val("");
	$("#dz_jzdzmlpxz").val("");
	$("#lxdh").val("");
	$("#jzd1").combobox("setValue","");
	$("#hjd1").combobox("setValue","");
	$("#hjd2").combobox("setValue","");
	$("#xb").combobox("setValue","");
	$("#jzd2").combobox("setValue","");
	
	setInputReadonly("xm", false);
	setInputReadonly("csrq", false);
	setInputReadonly("xb", false);
	setInputReadonly("lxdh", false);
	
}
/**
 * 根据证件类型与号码 ，进行人员比对，复用
 */
function check(){
	if(!$("#zjlx").combo("isValid")){
		return;
	}
	if(!$("#zjhm").validatebox("isValid")){
		//$("#zjhm").focus();
		return;
	}

	if($("#zjlx").val() !="111" && $("#zjlx").val()!="335"){
		return;
	}

	if($("#zjhm").val() == _zjhm){
		return;
	}
	$(".lodingimg").show();
	if($("#zjhm").val()==$("#sfz").val()){
		alert("交往人员不能是本人");
		$("#zjhm").val("").focus();
	}
	$.ajax({
		type : "POST",
		url : contextPath + "/ryRyjbxxb/dataApply",
		dataType : "json",
		data : "zjhm=" + $("#zjhm").val() + "&cyzjdm=111",
		success : function(data) {
			if (data && data.ryRyjbxxb) {
				$("#xm").val(data.ryRyjbxxb.xm);
				$("#ryid").val(data.ryRyjbxxb.id);
				$("#xb").combobox("setValue",data.ryRyjbxxb.xbdm);
				$("#csrq").val(formatDate(data.ryRyjbxxb.csrq));
				$("#lxdh").val(data.ryRyjbxxb.lxdh);
				if(data.ryRyjbxxb.xm != ""){
					setInputReadonly("xm", true);
				}
				if(data.ryRyjbxxb.csrq != ""){
					setInputReadonly("csrq", true);
				}
				if(data.ryRyjbxxb.xbdm != ""){
					setInputReadonly("xb", true);
				}
				if(data.ryRyjbxxb.lxdh != ""){
					setInputReadonly("lxdh", true);
				}
				
			}else{
				clearValues();
			}
		},
		complete:function(){
			_zjhm = $("#zjhm").val();
			$('#dataform').form('validate');
			$(".lodingimg").hide();
		}
	});	
}
//格式化时间
function formatDate(str){
	var newdate;
	if(str.length == 8){
		newdate = str.substring(0,4)+"-"+str.substring(4,6)+"-"+str.substring(6);
	}else{
		
	}
	return newdate?newdate:str;
}
//datagridAdd窗口保存关闭后执行此函数，调用mdtjAdd.js中的dsList()方法
function afterSubmit(arr){
	executeTabPageMethod(mainTabID, "dsrList");
	
}
