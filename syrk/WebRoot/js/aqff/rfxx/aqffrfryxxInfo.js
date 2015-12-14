// @Author:       [xu_haibo@founder.com.cn]
$(document).ready(function(){
	selectDwmc();
	initAddressSearch('fzd3', {}, 'dz_jzdzmlpdm', 'dz_jzdzmlpxz', 'fzd4', {text:'dz_jzdzxz',dzxzqh:'dz_jzdzssxdm',id:'dz_jzdzdm'}, null, null);
	initDepartmentSearch('gzdw', {glpcsid: ''}, '', '', null, null);
});
//保存前（必写此方法可为空,否则弹出框保存失败）
function afterSubmit(arr) {
   //刷新列表
   executeTabPageMethod(mainTabID, "reloadRyDg");
}
//保存后（必写此方法可为空,否则弹出框保存失败）
function beforeSubmit() {
	
}
$(function(){
	$('#rfryxxForm').form({  
		url:contextPath+"/rfxxb/saveRfcyxx",
        onSubmit:function(){
            return $('#rfryxxForm').form('validate');  
        },  
        success:function(data){  
            var json = $.parseJSON(data);
            alert(11);
            if(json.status != 'success'){
            	topMessagerAlert(null,json.message);
            }else{
            	$("#id").val(json.saveID); 
            	topMessagerShow(null,json.message);
            	executeTabPageMethod(mainTabID, "reloadRyDg");
            }
        }  
    });   
});
//证件类型验证绑定
function validateZjhm(param){
	$('#zjhm').val("");
	if(param.id=='111'){
		$('#zjhm').validatebox({validType:'sfzh'});
		$('#zjhm').bind("blur",function(e){checkZjhm();});
	}else{
		$('#zjhm').validatebox({validType:'maxLength[30]'});
		$('#zjhm').unbind("blur");
		cancelJzhmCtr();
	}
}
//根据证件类型与号码 ，进行人员比对，复用
function checkZjhm(){
	if ($('#zjhm').validatebox("isValid")){
		var zjhm = $('#zjhm').val();
		$.ajax({
			type:"POST",
			url: contextPath + "/ryRyjbxxb/dataApply",
			dataType:"json",
			data:"zjhm=" + $("#zjhm").val() + "&cyzjdm=" + $("#cyzjdm").combobox("getValue"),
			success:function(data) {
				if(data.ryRyjbxxb.xm!=''){
					$('#xm').val(data.ryRyjbxxb.xm);
				}
				if(data.ryRyjbxxb.xbdm!=''){
					$("#xbdm").combobox("setValue",data.ryRyjbxxb.xbdm);
				}
			}
		});	
	}else{
		cancelJzhmCtr();
	}
}
function selectDwmc(){
	$('#gzdwVal').html(dwmc);
}