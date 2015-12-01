<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>出租房屋</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>czfw" id="dataForm" name="dataForm" enctype="multipart/form-data" method="post">
    	<input type="hidden" id="_method" name="_method" />
    	<input type="hidden" id="fwid" name="fwid" value="${entity.fwid}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">出租间数：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="czjs" name="cz_fjs" style="width:170px;" value="${entity.cz_fjs}"
						data-options="validType:['naturalNumber'],tipPosition:'left'"/>（间）
					</td>
					
					<td width="20%" class="dialogTd" align="right">出租面积：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="fwmj" name="cz_mjpfm" style="width:140px;" value="${entity.cz_mjpfm}"
						data-options="validType:['money'],invalidMessage:'房屋面积为两位小数的数字，请重新输入！',tipPosition:'left'"/>（平方米）
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">承租人数：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="czrs" style="width:200px;" value="${entity.czrs}" />
					</td>
					<td width="20%" class="dialogTd" align="right">出租日期：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="czrq" name="cz_rq" style="width:200px;" value="${entity.cz_rq}" maxlength="19"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">租金(元/月)</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="zj" name="zj" style="width:200px;" value="${entity.zj}"
						data-options="validType:['money'],invalidMessage:'租金为两位小数的数字，请重新输入！',tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">房屋等级：</td>
				    <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="fwdjdm" name="fwdjdm" style="width:200px;" value="${entity.fwdjdm}"
							data-options="url: contextPath + '/common/dict/BD_D_FWDJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" />
				    </td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">治安责任人：</td>
					<td width="30%" class="dialogTd">
						<input type="hidden" id="zazrr_id" name="zazrr_id" value="${sessionScope.userSession.userId }" style="width: 100;" />
							    <input type="text" class="easyui-validatebox" id="zazrr_xm" name="zazrr_xm" style="width:150;" value="${sessionScope.userSession.userName }" />
							    <input type="button" id="orgbutton4" value="选择" onClick="public_singleSelectOrgUser('${sessionScope.userSession.userOrgCode}', '', '', '03,04', '', '', 'zazrr_id', 'zazrr_xm', '', '', '', '', false, '', window, null, '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	   				</td>
					<td width="20%" class="dialogTd" align="right">责任书签订日期：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="zrs_qd_rq" name="zrs_qd_rq" style="width:200px;" value="${entity.zrs_qd_rq}" maxlength="19"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">备注：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="bz" name="bz" style="width:620px; height:50px;"
						data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',required:false,tipPosition:'right'">${entity.bz}</textarea>
					</td>
				</tr>
				<tr class="dialogTr">
   	      		<td width="20%" class="dialogTd" align="right" style="color: #FF0000;font-weight: bold;">出租人信息：</td>
   	      		<td width="80%" class="dialogTd" colspan="3"></td>
			</tr>
				<tr class="dialogTr">
				    <td width="20%" class="dialogTd" align="right">证件种类：</td>
				    <td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="czur_cyzjdm" name="czur_cyzjdm" style="width:200px;" value="${entity.czur_cyzjdm}"
							data-options="url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',onChange:czrzjdm_onchange" />
				    </td>
				    <td width="20%" class="dialogTd" align="right">证件号码：</td>
					<td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="czur_zjhm" name='czur_zjhm' maxlength="18" value="${entity.czur_zjhm}" style="width:200px;float:left;" 
			    	        data-options="required:true,charSet:'halfUpper',validType:['sfzh'],tipPosition:'left'"/><div class="lodingimg" id="czfwLoadDiv"></div></td>		
			    </tr>
		    	<tr class="dialogTr">
		    	     <td width="20%" class="dialogTd" align="right">姓名：</td>
					 <td width="30%" class="dialogTd">
					   <input type="hidden" name="czur_ryid" id="czur_ryid" value="${entity.czur_ryid}"/>
					   <input class='easyui-validatebox' type='text' id="czur_xm" name='czur_xm' value="${entity.czur_xm}" style="width:200px;"  maxlength="50"
			    	        data-options="required:true,charSet:'halfUpper'"/></td>
		    	    <td width="20%" class="dialogTd" align="right">联系电话：</td>
				    <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' name='czur_lxdh' id="czur_lxdh" maxlength="18" value="${entity.czur_lxdh}" onblur="checkLxdh('czur_lxdh','czur_ryid')" style="width:200px;" data-options="required:true,validType:['phone'],charSet:'halfUpper',tipPosition:'left'" /></td>
		    	</tr>
			    <tr class="dialogTr">
					 <td width="20%" class="dialogTd" align="right">外文姓：</td>
					 <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="czur_wwx" name='czur_wwx' value="${entity.czur_wwx}" style="width:200px;"  maxlength="40"
			    	        data-options="required:false,validType:['letterOrSpace']"/></td>
					 <td width="20%" class="dialogTd" align="right">外文名：</td>
					 <td width="30%" class="dialogTd"><input class='easyui-validatebox' type='text' id="czur_wwm" name='czur_wwm' value="${entity.czur_wwm}" style="width:200px;"  maxlength="40"
			    	        data-options="required:false,validType:['letterOrSpace']"/>
			    	 </td> 
		    	</tr>
		    	<tr class="dialogTr">
				    <td width="20%" class="dialogTd" align="right">与房主关系：</td>
				    <td width="30%" class="dialogTd" colspan="3"><input class="easyui-combotree" type="text" id="czur_yfzgx_rygxdm" name="czur_yfzgx_rygxdm" style="width:200px;" value="${entity.czur_yfzgx_rygxdm}"
							data-options="url:contextPath+'/common/dict/XZ_D_RYGXDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true,required:true,tipPosition:'right'" />
				    </td>
		    	</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">是否注销：</td>
					<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="xt_zxbz" name="xt_zxbz" style="width:200px;" value="${entity.xt_zxbz}"
						data-options="url:contextPath +'/common/dict/BD_D_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left',
						onSelect:function(record){
							if(record.id==0){
								if($('#pk').val() != ''){
									$('#dataForm').attr({'action':'<%=basePath%>czfw/'+$('#pk').val()});
									$('#_method').val('put');
								}else{
									$('#dataForm').attr({'action':'<%=basePath%>czfw'});
									$('#_method').val('');
								}
								setInputReadonly('xt_zxyy',true);
							} else if(record.id==1){
								$('#dataForm').attr({'action':'<%=basePath%>czfw/'+$('#pk').val()+'/delete'});
								$('#_method').val('delete');
								setInputReadonly('xt_zxyy',false);
							}
						}"/>
					</td>
				</tr>
				<tr class="dialogTr">
				<td width="15%" class="dialogTd" align="right">注销理由：</td>
		    		<td width="80%" class="dialogTd" colspan="3"><textarea name="xt_zxyy" id="xt_zxyy" class="easyui-validatebox" style="width: 620px; height:48px;"
					data-options="validType:['maxLength[100]'],invalidMessage:'注销理由不能超过100个汉字，请重新输入！',tipPosition:'right'">${entity.xt_zxyy}</textarea></td>
				</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
var _p;
function doInit(paramArray) {
	setInputReadonly("czrs", true); 
	$("#xt_zxbz").combobox("setValue","0");
	var f = $("#xt_zxbz").combobox("getValue");
	if(f=="0"){
		setInputReadonly("xt_zxyy", true);
	}else {
	
	}
	_p = paramArray["_p"];
	
}

function beforeSubmit(){
	if($('#pk').val() != ''&&$('#_method').val()!='delete'){
		$('#dataForm').attr({'action':'<%=basePath%>czfw/'+$('#pk').val()});
	}
}

function afterSubmit(arr) {
	if (arr["saveID"]) {
		$("#pk").val(arr["saveID"]);
	}
	
	parent.location.href = "<%=basePath%>syfw/"+$('#fwid').val()+"/main";
	
/** 	setFormDataToSpan($("body"),_p);
	var xt_zxbz = $("#xt_zxbz").combobox("getValue");
	
	if(xt_zxbz=="1"){
		setFormDataToSpan2($("body"),_p);
		//setFormDataClear($("body"),_p);
	}else {
		if (arr["saveID"]) {
			$(_p).find("input[name='id']").val($("#pk").val());
		}
		setFormDataToSpan($("body"),_p);
	
	} */
	
}
$(document).ready(function(){
	var newVal = "${entity.czur_cyzjdm}";
	if (newVal == "111" || newVal == "112" || newVal == "335" || newVal == "") {
		$("#czur_zjhm").validatebox({validType:['sfzh']});
	}else {
		$("#czur_zjhm").validatebox({validType:['maxLength[30]']});
	}
	$("#czur_zjhm").bind("blur",function(e){ checkCzrZjhm();});
});
function czrzjdm_onchange(newVal, oldVal) {
	if (newVal) {
	}else {
		newVal = "";
	}
	if (newVal == "111" || newVal == "112" || newVal == "335" || newVal == "") {
		$("#czur_zjhm").validatebox({validType:['sfzh']});
	}else {
		$("#czur_zjhm").validatebox({validType:['maxLength[30]']});
	}
}

//出租人员信息复用
function checkCzrZjhm(){
	$("#czfwLoadDiv").show();
	$.ajax({
		type:"POST",
		url:"<%=basePath%>ryRyjbxxb/dataApply",
		dataType:"json",
		data:"zjhm="+$("#czur_zjhm").val()+"&cyzjdm="+$("#czur_cyzjdm").val(),
		success:function(data) {
			if (data && data.ryRyjbxxb) {
				$("#czur_xm").val(data.ryRyjbxxb.xm);//姓名
				$("#czur_ryid").val(data.ryRyjbxxb.id);//ID
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete:function() {
			$("#czfwLoadDiv").hide();
			
		},
		error:function() {
		}
	});	
}

function setFormDataToSpan2(containObject,_p){
	var inputSelector = containObject.find('input');
	$.each(inputSelector, function(index, object) {
		var element = $(object);
		var _type = element.attr('type');
		var _name = element.attr('name');
		var _comboname = element.attr('comboname');
		var _span = null;
		if (_name) {
			if (_type == "text" || _type =="hidden") {
				var _class = element.attr('class');
				if (_class != 'combo-value') {
					_span = $(_p).find("span[name='"+_name+"']");
					if (_span) {
						_span.text("");
					}
				}
			}
		}
		if (_comboname) {
			var comboText = element.combo("getText");
			_span = $(_p).find("span[name='"+_comboname+"']");
			if (_span) {
				_span.text("");
			}
		}
	});
	
	
}

function setFormDataToSpan(containObject,_p) {
	var inputSelector = containObject.find('input');
	$.each(inputSelector, function(index, object) {
		var element = $(object);
		var _type = element.attr('type');
		var _name = element.attr('name');
		var _comboname = element.attr('comboname');
		var _span = null;
		if (_name) {
			if (_type == "text" || _type =="hidden") {
				var _class = element.attr('class');
				if (_class != 'combo-value') {
					_span = $(_p).find("span[name='"+_name+"']");
					if (_span) {
						_span.text(element.val());
					}
				}
			}
		}
		if (_comboname) {
			var comboText = element.combo("getText");
			_span = $(_p).find("span[name='"+_comboname+"']");
			if (_span) {
				_span.text(comboText);
			}
		}
	});
	var textareaSelector = containObject.find('textarea.edit_input');
	$.each(textareaSelector, function(index, object) {
		var element = $(object);
		var _name = element.attr('name');
		if (_name) {
			_span = $(_p).find("span[name='"+_name+"']");
			if (_span) {
				var spanHtml = element.val();
				spanHtml = spanHtml.replace(/\n/g, "<br>");
				_span.html(spanHtml);
			}
		}
	});
}
</script>