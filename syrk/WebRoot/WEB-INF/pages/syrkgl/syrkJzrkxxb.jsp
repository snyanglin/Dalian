<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>常住人口信息</title>
</head>

<body>

<form action="<%=basePath%>syrkJzrkxxb/${jzrk.id}" id="dataForm" name="dataForm" method="post">
    
	<input type="hidden" id="_method" name="_method" value="PUT"/>
  	<input type='hidden' id="pk" name='id' value="${jzrk.id}" />
	<input type="hidden" id="ryid" name="ryid" value="${jzrk.ryid}"/>
   
   	<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jzrk_gmsfhm" name="gmsfhm" value="${jzrk.gmsfhm}" style="width:200px;" maxlength="30"/></td>
   	        <td width="20%" class="dialogTd" align="right">姓名：</td>
   	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jzrk_xm" name="xm" value="${jzrk.xm}" style="width:200px;" maxlength="50"
   	        	data-options="required:true,tipPosition:'left'"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">性别：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jzrk_xbdm" name="xbdm" value="${jzrk.xbdm}" style="width:200px;" 
				data-options="required:true,url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jzrk_csrq" name="csrq" value="${jzrk.csrq}" style="width:200px;" 
   	 			data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">民族：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jzrk_mzdm" name="mzdm" value="${jzrk.mzdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">联系电话：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jzrk_lxdh" name="lxdh" value="${jzrk.lxdh}" style="width:200px;" maxlength="18"
				data-options="validType:['phone'],charSet:'half',tipPosition:'left'" onblur="checkLxdh('jzrk_lxdh','ryid')"/></td>
      	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">户籍地址：</td>
	    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="jzrk_hjd_dzxz" value="${jzrk.hjd_dzxz}" style="width:618px;" maxlength="60"/></td> 
      	</tr>
      	<tr>
      	    <td width="20%" class="dialogTd" align="right">职业类别：</td>
			<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="jzrk_zylbdm" name="zylbdm" value="${jzrk.zylbdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_ZYFLYDM.js',onlyLeaf:true,multiple:false,panelWidth:410,method:'get',editable:true,lines:true"></td>
      	    <td width="20%" class="dialogTd" align="right">职业：</td>
			<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" id="jzrk_zy" name="zy" value="${jzrk.zy}" style="width:200px;" maxlength="60"/></td> 
		
      	</tr>
      	<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">工作单位：</td>
			<td width="80%" class="dialogTd" colspan="3">
			<input type="hidden" id="jzrk_gzdwid" name="gzdwid" value="${jzrk.gzdwid}"/>
			<input type="hidden" id="jzrk_gzdw" name="gzdw" value="${jzrk.gzdw}"/>
			<input class="easyui-combobox" id="jzrk_gzdw_select" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" value="${jzrk.gzdw}" maxlength="50" style="width:618px;" /></td>
		</tr>
      	
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">居住地：</td>
      	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="jzrk_jzd1" style="width:380px;" value="${jzrk.jzd_mlpxz}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="jzrk_jzd_mlpdm" name="jzd_mlpdm" value="${jzrk.jzd_mlpdm}"/>
					    	<input type="hidden" id="jzrk_jzd_mlpxz" name="jzd_mlpxz" value="${jzrk.jzd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="jzrk_jzd2" style="width:200px;" value="${fn:replace(jzrk.jzd_dzxz, jzrk.jzd_mlpxz, '')}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="jzrk_jzd_dzid" name="jzd_dzid" value="${jzrk.jzd_dzid}"/>
					    	<input type="hidden" id="jzrk_jzd_xzqhdm" name="jzd_xzqhdm" value="${jzrk.jzd_xzqhdm}"/>
					    	<input type="hidden" id="jzrk_jzd_dzxz" name="jzd_dzxz" value="${jzrk.jzd_dzxz}"/>
					    	<input type="hidden" id="jzrk_jzd_zbx" name="jzd_zbx" value="${jzrk.jzd_zbx}"/>
					    	<input type="hidden" id="jzrk_jzd_zby" name="jzd_zby" value="${jzrk.jzd_zby}"/>
				    	</td>
      	</tr>
 
  	    <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">寄住类别：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jzrk_jzlbdm" name="jzlbdm" value="${jzrk.jzlbdm}" style="width:200px;" 
				data-options="required:true,url: contextPath + '/common/dict/BD_D_JZLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">寄住原因：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jzrk_jzyydm" name="jzyydm" value="${jzrk.jzyydm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/BD_D_JZYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
  	    </tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">寄住开始时间：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jzrk_jz_ksrq01" name="jz_ksrq01" value="${jzrk.jz_ksrq01}" style="width:200px;" 
   	 			data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
	    	<td width="20%" class="dialogTd" align="right">预计离开时间：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jzrk_yj_lksj" name="yj_lksj" value="${jzrk.yj_lksj}" style="width:200px;" 
    			data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'jzrk_jz_ksrq01\') || \'%y-%M-%d\'}'})"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">居住处所：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="jzrk_zjzcsfldm" name="zjzcsfldm" value="${jzrk.zjzcsfldm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_JZCSFLYDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true,onChange:jzrk_zjzcsfldm_onChange"/></td>
	    	<td width="20%" class="dialogTd" align="right"></td>
	    	<td width="30%" class="dialogTd"></td>
  	   	</tr>

  	    <tr class="dialogTr" id="jzrk_fz_tr1" style="display: none;">
	    	<td width="20%" class="dialogTd" align="right">房屋承租情况：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jzrk_fwczqkdm" name="fwczqkdm" value="${jzrk.fwczqkdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_FWCZQKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">与房主关系：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="jzrk_chzr_yfzgx_rygxdm" name="chzr_yfzgx_rygxdm" value="${jzrk.chzr_yfzgx_rygxdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/XZ_D_RYGXDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true"/></td>
  	    </tr>
		<tr class="dialogTr" id="jzrk_fz_tr2" style="display: none;">
			<td width="20%" class="dialogTd" align="right">房主证件种类：</td>
			<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jzrk_fz_cyzjdm" name="fz_cyzjdm" value="${jzrk.fz_cyzjdm}" style="width:200px;"
				data-options="required:false,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right',onChange:jzrk_fz_cyzjdm_onChange"/></td> 
	    	<td width="20%" class="dialogTd" align="right">房主证件号码：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jzrk_fz_zjhm" name="fz_zjhm" value="${jzrk.fz_zjhm}" style="width:200px;float:left;" maxlength="30" 
   	        	data-options="required:false,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码',tipPosition:'left'" onblur="jzrk_fz_zjhm_onblur()"/><div class="lodingimg" id="jzrk_fzLoadDiv"></div>
   	        	<input type="hidden" id="jzrk_fz_ryid" name="fz_ryid" value="${jzrk.fz_ryid}"/>
   	        </td>
  	    </tr>
		<tr class="dialogTr" id="jzrk_fz_tr3" style="display: none;">
   	        <td width="20%" class="dialogTd" align="right">房主姓名：</td>
   	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jzrk_fz_xm" name="fz_xm" value="${jzrk.fz_xm}" style="width:200px;" maxlength="50"
   	        	data-options="tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">房主联系电话：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jzrk_fz_lxdh" name="fz_lxdh" value="${jzrk.fz_lxdh}" style="width:200px;" maxlength="18"
				data-options="validType:['phone'],charSet:'half',tipPosition:'left'" onblur="checkLxdh('jzrk_fz_lxdh','jzrk_fz_ryid')"/></td>
  	    </tr>
  		<tr class="dialogTr" id="jzrk_fz_tr4" style="display: none;">
	    	<td width="20%" class="dialogTd" align="right">房主居住地址：</td>
	    	<td width="50%" class="dialogTd" colspan="2">
		    	<input class="easyui-combobox" id="jzrk_fz_jzd1" style="width:400px;" value="${jzrk.fz_jzd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    	<input type="hidden" id="jzrk_fz_jzd_mlpdm" name="fz_jzd_mlpdm" value="${jzrk.fz_jzd_mlpdm}"/>
		    	<input type="hidden" id="jzrk_fz_jzd_mlpxz" name="fz_jzd_mlpxz" value="${jzrk.fz_jzd_mlpxz}"/>
	    	</td>
	    	<td width="30%" class="dialogTd" align="left">
		    	<input class="easyui-combobox" id="jzrk_fz_jzd2" style="width:200px;" value="${fn:replace(jzrk.fz_jzd_dzxz, jzrk.fz_jzd_mlpxz, '')}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    	<input type="hidden" id="jzrk_fz_jzd_dzid" name="fz_jzd_dzid" value="${jzrk.fz_jzd_dzid}"/>
		    	<input type="hidden" id="jzrk_fz_jzd_xzqhdm" name="fz_jzd_xzqhdm" value="${jzrk.fz_jzd_xzqhdm}"/>
		    	<input type="hidden" id="jzrk_fz_jzd_dzxz" name="fz_jzd_dzxz" value="${jzrk.fz_jzd_dzxz}"/>
	    	</td>
   	    </tr>
   	       
	</table>
</form>
    
</body>

<script type="text/javascript"> 

var _p;
var pcsdm = "${pcsdm}";
var zrqdm = "${zrqdm}";

function doInit(paramArray) {
	_p = paramArray["_p"];

	$("#jzrk_fz_zjhm").attr("cyzjdm", "${jzrk.fz_cyzjdm}");
	$("#jzrk_fz_zjhm").attr("zjhm", "${jzrk.fz_zjhm}");

	setInputReadonly("jzrk_gmsfhm", true);
	setInputReadonly("jzrk_hjd_dzxz", true);
	//setInputReadonly("jzrk_jzd_dzxz", true);
	setInputReadonly("jzrk_jzd1", true);
	setInputReadonly("jzrk_jzd2", true);
	if($("#jzrk_jzd_dzid").val()==""&&$("#jzrk_jzd2").val()!=""){
		setInputReadonly("jzrk_jzd1", false);
		setInputReadonly("jzrk_jzd2", false);
	}
	
	// 地址选择初始化
	initAddressSearch("jzrk_jzd1", {zrqdm:zrqdm}, "jzrk_jzd_mlpdm", "jzrk_jzd_mlpxz", "jzrk_jzd2", {text:"jzrk_jzd_dzxz",dzxzqh:"jzrk_jzd_xzqhdm",id:"jzrk_jzd_dzid",dzzbx:"jzrk_jzd_zbx",dzzby:"jzrk_jzd_zby"}, null, null);
	initAddressSearch("jzrk_fz_jzd1", {}, "jzrk_fz_jzd_mlpdm", "jzrk_fz_jzd_mlpxz", "jzrk_fz_jzd2", {text:"jzrk_fz_jzd_dzxz",dzxzqh:"jzrk_fz_jzd_xzqhdm",id:"jzrk_fz_jzd_dzid"}, null, null);
	initDepartmentSearch("jzrk_gzdw_select", {}, "jzrk_gzdwid", "jzrk_gzdw", {});

	jzrk_zjzcsfldm_onChange("${jzrk.zjzcsfldm}");
	
}

function beforeSubmit() {
	if ($("#dataForm").form("validate")) {
		if ($("#jzrk_jzd_mlpdm").val() == "") {
			topMessager.alert("", "居住地必须为标准地址，请重新选择！");
			var comboText = $("#jzrk_jzd1").next(".combo").children(".combo-text");
			comboText.focus();
			return false;
		}
		if ($("#jzrk_jzd2").combobox("getValue") == "") {
			topMessager.alert("", "居住地必须为标准地址，请重新选择！");
			var comboText = $("#jzrk_jzd2").next(".combo").children(".combo-text");
			comboText.focus();
			return false;
		}
		if ($("#jzrk_jz_ksrq01").val() != "" && $("#jzrk_yj_lksj").val() != "" && $("#jzrk_jz_ksrq01").val() >  $("#jzrk_yj_lksj").val()) {
			topMessager.alert("", "预计离开时间不能小于寄住开始时间，请重新输入！");
			$("#jzrk_yj_lksj").focus();
			return false;
		}
		var jzrk_zjzcsfldmValue = $("#jzrk_zjzcsfldm").combotree("getValue");
		if (jzrk_zjzcsfldmValue == "30") { // 居住处所为租赁房屋
			if ($("#jbxx_id").val() != "" && $("#jzrk_fz_ryid").val() != "" && $("#jbxx_id").val() == $("#jzrk_fz_ryid").val()) {
				topMessager.alert("", "房主不能为本人，请重新输入！");
				$("#jzrk_fz_zjhm").focus();
				return false;
			}
		}
	}
}

function afterSubmit(arr) {
	setFormDataToSpan($("body"),_p);
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

function jzrk_zjzcsfldm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var jzrk_zjzcsfldmValue = $("#jzrk_zjzcsfldm").combotree("getValue");
	if (jzrk_zjzcsfldmValue == "30") { // 居住处所为租赁房屋
		$("#jzrk_fz_tr1").show();
		$("#jzrk_fz_tr2").show();
		$("#jzrk_fz_tr3").show();
		$("#jzrk_fz_tr4").show();
	}
	else {
		$("#jzrk_fz_tr1").hide();
		$("#jzrk_fz_tr2").hide();
		$("#jzrk_fz_tr3").hide();
		$("#jzrk_fz_tr4").hide();
		$("#jzrk_fwczqkdm").combobox("setValue", "");
		$("#jzrk_chzr_yfzgx_rygxdm").combotree("setValue", "");
		$("#jzrk_fz_ryid").val("");
		$("#jzrk_fz_cyzjdm").combobox("setValue", "");
		$("#jzrk_fz_zjhm").val("");
		$("#jzrk_fz_xm").val("");
		$("#jzrk_fz_lxdh").val("");
		$("#jzrk_fz_jzd1").combobox("loadData", []);
		$("#jzrk_fz_jzd2").combobox("loadData", []);
		var comboText = $("#jzrk_fz_jzd1").next(".combo").children(".combo-text");
		comboText.val("");
		var comboText = $("#jzrk_fz_jzd2").next(".combo").children(".combo-text");
		comboText.val("");
		var opts = $("#jzrk_fz_jzd2").combobox("options");
		opts.validEnter = false;
		$("#jzrk_fz_jzd_xzqhdm").val("");
		$("#jzrk_fz_jzd_mlpdm").val("");
		$("#jzrk_fz_jzd_mlpxz").val("");
		$("#jzrk_fz_jzd_dzid").val("");
		$("#jzrk_fz_jzd_dzxz").val("");
	}
}

function jzrk_fz_cyzjdm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var cyzjdmValue = $("#jzrk_fz_cyzjdm").combobox("getValue");
	if (cyzjdmValue == "111" || cyzjdmValue == "112" || cyzjdmValue == "335") { // 身份证类型、临时身份证、机动车驾驶证
		$("#jzrk_fz_zjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#jzrk_fz_zjhm").validatebox({validType:['letterOrNum']});
	}
	setTimeout("jzrk_fz_zjhm_onblur();", 300);
}

function jzrk_fz_zjhm_onblur() {
	if (!$("#jzrk_fz_cyzjdm").combo("isValid")) {
		$("#jzrk_fz_ryid").val("");
		return;
	}
	if (!$("#jzrk_fz_zjhm").validatebox("isValid")) {
		$("#jzrk_fz_ryid").val("");
		return;
	}
	if ($("#jzrk_fz_zjhm").val() == "") {
		$("#jzrk_fz_ryid").val("");
		return;
	}
	var _cyzjdm = $("#jzrk_fz_zjhm").attr("cyzjdm");
	if (!_cyzjdm) {
		_cyzjdm = "";
	} 
	var _zjhm = $("#jzrk_fz_zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if ($("#jzrk_fz_cyzjdm").combobox("getValue") == _cyzjdm && $("#jzrk_fz_zjhm").val() == _zjhm) {
		return;
	}
	$("#jzrk_fzLoadDiv").show();
	$.ajax({
		type: "POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType: "json",
		data:"zjhm=" + $("#jzrk_fz_zjhm").val() + "&cyzjdm=" + $("#jzrk_fz_cyzjdm").combobox("getValue"),
		success: function(data) {
			if (data && data.ryRyjbxxb) {
				$("#jzrk_fz_ryid").val(data.ryRyjbxxb.id);
				$("#jzrk_fz_xm").val(data.ryRyjbxxb.xm);
				$("#jzrk_fz_xm").validatebox("validate");
				$("#jzrk_fz_lxdh").val(data.ryRyjbxxb.lxdh);
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete: function() {
			$("#jzrk_fz_zjhm").attr("cyzjdm", $("#jzrk_fz_cyzjdm").combobox("getValue"));
			$("#jzrk_fz_zjhm").attr("zjhm", $("#jzrk_fz_zjhm").val());
			$("#jzrk_fzLoadDiv").hide();
		},
		error: function() {
		}
	});	
}

</script>

</html>
