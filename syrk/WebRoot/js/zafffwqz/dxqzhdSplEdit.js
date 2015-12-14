/**
 * @Author:       [wu.w@founder.com.cn]
 * @CreateDate:   [2015-5-15 上午8:51:54]
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
/*
 * init address combobox
 */
initAddressSearch('jbxx_dz_mlpCombobox', {}, 'jbxx_dz_hdddmlpdm', 'jbxx_dz_hdddmlpxz', 'jbxx_dz_mhcombobox', {text:'jbxx_dz_hdddxz',dzxzqh:'jbxx_dz_hdddssxdm',id:'jbxx_dz_hddddzdm'}, null, null);
initAddressSearch('jbxx_dz_hdlxksCombobox', {}, 'jbxx_dz_hdlxqsmlpdm', 'jbxx_dz_hdlxqsmlpxz', null, null, null, null);
initAddressSearch('jbxx_dz_hdlxjsCombobox', {}, 'jbxx_dz_hdlxjsmlpdm', 'jbxx_dz_hdlxjsmlpxz', null, null, null, null);
jbxx_hideddlx();
initAbxq();

/*
 * execute when page load success
 */
$(document).ready(function(){
	initJbxxDDLX();
	viewInfoControl();
});

/*
 * init jbxx address ele
 */
function initJbxxDDLX(){
	if($('#jbxx_dz_hdddmlpdm').val()!=''){
		$('#jbxx_dd_radio').attr('selected','selected');
		$('#jbxx_dd_radio').click();
	}
	if($('#jbxx_dz_hdlxqsmlpdm').val()!=''){
		$('#jbxx_lx_radio').attr('selected','selected');
		$('#jbxx_lx_radio').click();
	}
}

/*
 * 查看页面禁止编辑
 */
function viewInfoControl(){
	if($('#mode').val()=='view'){
		$('#dataForm').find('input[type="text"]').each(function(i,o){
			$(o).attr('readonly','readonly');
			$(o).addClass('inputReadonly');
			$(o).next(".combo").addClass("inputReadonly");
		});
		$('#dataForm').find('input[type="file"]').each(function(i,o){
			$(o).attr('readonly','readonly');
			$(o).addClass('inputReadonly');
		});
		$('#dataForm').find('textarea').each(function(i,o){
			$(o).attr('readonly','readonly');
			$(o).addClass('inputReadonly');
		});
		$('#dataForm').find('input[type="radio"]').each(function(i,o){
			$(o).attr('disabled','disabled');
		});
		$('#dataForm').find('input[type="checkbox"]').each(function(i,o){
			$(o).attr('disabled','disabled');
		});
		$('#abdw_mccabjlsNS_add').hide();
	}
}

/*
 * 保存信息
 */
function save(){
	var requestUrl=contextPath + '/dxqzxhdspl/';
	if($('#mode').val()=='add'){
		requestUrl+='save';
	}else{
		requestUrl+='update';
	}
	$('#dataForm').form({    
	    url:requestUrl,    
	    onSubmit: function(){    
	    	if(!$('#dataForm').form('validate')){
	    		return false;
	    	}
	    	uploadFa();
	    },    
	    success:function(result){    
	        doSubmitResult(result, null, null);
        	executeTabPageMethod($('#mainTabID').val(),'reloadDg');
	        if($('#mode').val()=='add'){
		        closeSelf();
	        }
	    }    
	});
	$('#dataForm').submit();  
}

/*
 * 上传方案
 */
function uploadFa(){
	$('#abdw_file_form').form({    
	    url:contextPath+"/zpfjFjxxb/save",    
	    onSubmit: function(){
	       $('#abdw_file_form_div').append($('#abdw_abfa'));
	    },    
	    success:function(result){
	    	$('#abdw_abfa_span').append($('#abdw_abfa'));
	    	if ("string" == typeof result) {
				result = parseReturn(result);
			}
			if (result.status == 'error') {
				return false;
			}
	    }  
	});
	$('#abdw_file_form').submit();
};

/*
 * 重置
 */
function reset(){
	$("#dataForm").form("reset");
}

/*
 * 基本信息隐藏地址
 */
function jbxx_hideddlx(){
	setInputReadonly('jbxx_dz_mlpCombobox',true);
	setInputReadonly('jbxx_dz_mhcombobox',true);
	setInputReadonly('jbxx_cdmj',true);
	setInputReadonly('jbxx_dz_hdlxksCombobox',true);
	setInputReadonly('jbxx_dz_hdlxjsCombobox',true);
	setInputReadonly('jbxx_lc',true);
}

/*
 * 显示活动地点
 */
function jbxx_hddd(){
	jbxx_hideddlx();
	
	setInputReadonly('jbxx_dz_mlpCombobox',false);
	setInputReadonly('jbxx_dz_mhcombobox',false);
	setInputReadonly('jbxx_cdmj',false);
	
	$('#jbxx_dz_hdlxksCombobox').combobox('clear');
	$('#jbxx_dz_hdlxjsCombobox').combobox('clear');
	$('#jbxx_lc').val('');
}

/*
 * 显示活动路线
 */
function jbxx_hdlx(){
	jbxx_hideddlx();
	
	setInputReadonly('jbxx_dz_hdlxksCombobox',false);
	setInputReadonly('jbxx_dz_hdlxjsCombobox',false);
	setInputReadonly('jbxx_lc',false);
	
	$('#jbxx_dz_mlpCombobox').combobox('clear');
	$('#jbxx_dz_mhcombobox').combobox('clear');
	$('#jbxx_cdmj').val('');
}

/*
 * 承办方法人显示控制
 * b true/false
 */
function cbf_fr_col(b){
	if(b){
		$('#cbf_fr1').show();
		$('#cbf_fr2').show();
	}else{
		$('#cbf_fr1').hide();
		$('#cbf_fr2').hide();
	}
}

/*
 * 活动安保复选框控制
 * obj checkbox
 * id  id
 * num 是否多个| 警力会出现多个
 */
function hdab_input_col(obj,id,num){
	if(num!=null&&num!='undefined'){
		for(var i=0;i<num;i++){
			if(obj.checked){
				setInputReadonly('hdab_'+id+(i+1),false);
			}else{
				setInputReadonly('hdab_'+id+(i+1),true);
				$('#hdab_'+id+(i+1)).val('');
			}
		}
	}else{
		if(obj.checked){
			setInputReadonly('hdab_'+id,false);
		}else{
			setInputReadonly('hdab_'+id,true);
			$('#hdab_'+id).val('');
		}
	}
}

/*
 * 保存安保详情
 */
function saveAbxq(){
	var abzldm=$('#abdw_mccabzldmNS').combobox('getValue');
	var abzltxt=$('#abdw_mccabzldmNS').combobox('getText');
	var abzlnum=$('#abdw_mccabjlsNS').val();
	if(abzldm==''){
		alert('请选择安保种类！');
		return;
	}
	var exist=false;
	var abli=$("input[name='abdw_abxq_li']").each(function(i,o){
		if(o.value==abzldm){
			alert('此安保种类已录入！');
			exist=true;
		}
	});
	if(exist)return;
	if(abzlnum==''){
		alert('请输入安保警力数！');
		return;
	}
	var li=$("<li style='float:left'></li>");
	var context="<input type='hidden' name='abdw_abxq_li' value='"+abzldm+"'/>";
	context+="<input type='hidden' name='abdw.abxq' value='"+abzldm+"|"+abzltxt+"|"+abzlnum+"'/>";
	context+= abzltxt+"："+abzlnum+"人&nbsp;";
	context+="<a onclick='deleteAbxq(this);' style='cursor:hand;color:blue'>删除</a>&nbsp;&nbsp;";
	li.append(context);
	$('#abdw_abxq').append(li);
}

/*
 * 删除安保详情 
 * a 删除按钮s
 */
function deleteAbxq(a){
	var li=$(a).parent();
	$(li).html('');
}

/*
 * 初始化安保详情
 */
function initAbxq(){
	var abxq=$('#abdw_abxq_hid').val();
	if(abxq!=null&&abxq.length>0){
		var a=abxq.split(',');
		for(var i=0;i<a.length;i++){
			var b=a[i].split('|');
			var abzldm=b[0];
			var abzltxt=b[1];
			var abzlnum=b[2];
			var li=$("<li style='float:left'></li>");
			var context="<input type='hidden' name='abdw_abxq_li' value='"+abzldm+"'/>";
			context+="<input type='hidden' name='abdw.abxq' value='"+abzldm+"|"+abzltxt+"|"+abzlnum+"'/>";
			context+= abzltxt+"："+abzlnum+"人&nbsp;";
			context+="<a onclick='deleteAbxq(this);' style='cursor:hand;color:blue'>删除</a>&nbsp;&nbsp;";
			li.append(context);
			$('#abdw_abxq').append(li);
		}
	}
}

/*
 * 方案下载
 */
function planDownload(){
	uploadFileView('DXQZXHDSPL_ZB_ABZRDWXXB',$('#hdid').val(),'0','');
}

/*
 * 显示关联信息
 */
function loadRelationMessage() { 
	$.ajax({
		type: 'POST',
		url: contextPath + '/relationRyxx/queryList',
		data: "sfzh="+$("#sfzh").val(),
		success: function(data) {
			var dataJson = $.parseJSON(data);
			if (dataJson.length > 0) {
				var sb = new StringBuffer();
				for (var i = 0; i < dataJson.length; i++) {
					var dataObject = dataJson[i];
					var typeName = dataObject['typeName'];
					sb.append('<div class="rtul_title">' + typeName);
					var listArray = dataObject['list'];
					for (var j = 0; j < listArray.length; j++) {
						sb.append('<div class="rtshowxx">' + listArray[j].title + '</div><div class="rtshowSplit"></div>');
					}
					sb.append('</div>');
				}
				$('#relationMessage').append(sb.toString());
			}
		},
		error: function() {
		}
	});
}

/*
 * 证件类型验证绑定
 */
function validateZjhm(param,name){
	$('#'+name+'zjhm').val("");
	if(param.id=='111'){
		$('#'+name+'zjhm').validatebox({validType:'sfzh'});
		$('#'+name+'zjhm').bind("blur",function(e){checkZjhm(name);});
	}else{
		$('#'+name+'zjhm').validatebox({validType:'maxLength[30]'});
		$('#'+name+'zjhm').unbind("blur");
		cancelJzhmCtr(name);
	}
}


/*
 * 根据证件类型与号码 ，进行人员比对，复用
 * name 模块名称
 */
function checkZjhm(name){
	if ($('#'+name+'zjhm').validatebox("isValid")){
		var zjhm = $('#'+name+'zjhm').val();
		$.ajax({
			type:"POST",
			url: contextPath + "/ryRyjbxxb/dataApply",
			dataType:"json",
			data:"zjhm=" + $("#"+name+"zjhm").val() + "&cyzjdm=" + $("#"+name+"zjzldm").combobox("getValue"),
			success:function(data) {
				if(data.ryRyjbxxb.xm!=''){
					$('#'+name).val(data.ryRyjbxxb.xm);
					setInputReadonly(name,true);
				}
				if(name!='cbf_fr'){
					if(data.ryRyjbxxb.lxdh!=''){
						$('#'+name+'lxdh').val(data.ryRyjbxxb.lxdh);
						setInputReadonly(name+'lxdh',true);
					}
				}
			}
		});	
	}else{
		cancelJzhmCtr(name);
	}
}

/*
 * 取消绑定
 * name 模块名称
 */
function cancelJzhmCtr(name){
	$('#'+name).val('');
	setInputReadonly(name,false);
	if(name!='cbf_fr'){
		$('#'+name+'lxdh').val('');
		setInputReadonly(name+'lxdh',false);
	}
}