<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>未落户人员信息</title>
</head>

<body>

<form action="<%=basePath%>syrkWlhryxxb/${wlrk.id}" id="dataForm" name="dataForm" method="post">
    
	<input type="hidden" id="_method" name="_method" value="PUT"/>
  	<input type='hidden' id="pk" name='id' value="${wlrk.id}" />
	<input type="hidden" id="ryid" name="ryid" value="${wlrk.ryid}"/>
   
   	<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
		<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">证件种类：</td>
			<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="wlrk_cyzjdm" name="cyzjdm" value="${wlrk.cyzjdm}" style="width:200px;"
				data-options="required:true,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">证件号码：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="wlrk_zjhm" name="zjhm" value="${wlrk.zjhm}" style="width:200px;float:left;" maxlength="30" 
   	        	data-options="required:true,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码',tipPosition:'right'"/></td>
  	   	</tr>
		<tr class="dialogTr">
   	        <td width="20%" class="dialogTd" align="right">姓名：</td>
   	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="wlrk_xm" name="xm" value="${wlrk.xm}" style="width:200px;" maxlength="50"
   	        	data-options="required:true,tipPosition:'right'"/></td>
   	        <td width="20%" class="dialogTd" align="right">曾用名：</td>
   	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="wlrk_cym" name="cym" value="${wlrk.cym}" style="width:200px;" maxlength="50"
   	        	data-options="tipPosition:'left'"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">性别：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="wlrk_xbdm" name="xbdm" value="${wlrk.xbdm}" style="width:200px;" 
				data-options="required:true,url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="wlrk_csrq" name="csrq" value="${wlrk.csrq}" style="width:200px;" 
   	 			data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">民族：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="wlrk_mzdm" name="mzdm" value="${wlrk.mzdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">联系电话：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="wlrk_lxdh" name="lxdh" value="${wlrk.lxdh}" style="width:200px;" maxlength="18"
				data-options="validType:['phone'],charSet:'half',tipPosition:'left'" onblur="checkLxdh('wlrk_lxdh','ryid')"/></td>
      	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">出生国家：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="wlrk_csdgjhdqdm" name="csdgjhdqdm" value="${wlrk.csdgjhdqdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">出生地：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="wlrk_csdssxdm" name="csdssxdm" value="${wlrk.csdssxdm}" style="width:200px;" 
  	                data-options="mode:'remote',dataFilter:'.*[^00]$',valueField:'id',textField:'text',selectOnNavigation:false,method:'post'"/></td>
      	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">学历：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="wlrk_xldm" name="xldm" value="${wlrk.xldm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_XLDM.js',onlyLeaf:true,multiple:false,panelWidth:300,method:'get',editable:true,lines:true"></td> 
	    	<td width="20%" class="dialogTd" align="right">婚姻状况：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="wlrk_hyzkdm" name="hyzkdm" value="${wlrk.hyzkdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_HYZKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
      	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">政治面貌：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="wlrk_zzmmdm" name="zzmmdm" value="${wlrk.zzmmdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_ZZMMDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">宗教信仰：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="wlrk_zjxydm" name="zjxydm" value="${wlrk.zjxydm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_ZJXYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
      	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">兵役状况：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="wlrk_byzkdm" name="byzkdm" value="${wlrk.byzkdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_BYQKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">血型：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="wlrk_xxdm" name="xxdm" value="${wlrk.xxdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_XXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
      	</tr>
      	<tr>
      	    <td width="20%" class="dialogTd" align="right">职业类别：</td>
			<td width="30%" class="dialogTd" ><input class="easyui-combotree" type="text" id="wlrk_zylbdm" name="zylbdm" value="${wlrk.zylbdm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_ZYFLYDM.js',onlyLeaf:true,multiple:false,panelWidth:410,method:'get',editable:true,lines:true"></td>
      	    <td width="20%" class="dialogTd" align="right">职业：</td>
			<td width="30%" class="dialogTd" ><input class="easyui-validatebox" type="text" id="wlrk_zy" name="zy" value="${wlrk.zy}" style="width:200px;" maxlength="60"/></td> 
		
      	</tr>
      	<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">工作单位：</td>
			<td width="80%" class="dialogTd" colspan="3">
			<input type="hidden" id="wlrk_gzdwid" name="gzdwid" value="${wlrk.gzdwid}"/>
			<input type="hidden" id="wlrk_gzdw" name="gzdw" value="${wlrk.gzdw}"/>
			<input class="easyui-combobox" id="wlrk_gzdw_select" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" value="${wlrk.gzdw}" maxlength="50" style="width:595px;" /></td>
		</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">居住地：</td>
      	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="wlrk_jzd1" style="width:380px;" value="${wlrk.jzd_mlpxz}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="wlrk_jzd_mlpdm" name="jzd_mlpdm" value="${wlrk.jzd_mlpdm}"/>
					    	<input type="hidden" id="wlrk_jzd_mlpxz" name="jzd_mlpxz" value="${wlrk.jzd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="wlrk_jzd2" style="width:200px;" value='${fn:replace(wlrk.jzd_dzxz, wlrk.jzd_mlpxz, "")}' data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="wlrk_jzd_dzid" name="jzd_dzid" value="${wlrk.jzd_dzid}"/>
					    	<input type="hidden" id="wlrk_jzd_xzqhdm" name="jzd_xzqhdm" value="${wlrk.jzd_xzqhdm}"/>
					    	<input type="hidden" id="wlrk_jzd_dzxz" name="jzd_dzxz" value="${wlrk.jzd_dzxz}"/>
					    	<input type="hidden" id="wlrk_jzd_zbx" name="jzd_zbx" value="${wlrk.jzd_zbx}"/>
					    	<input type="hidden" id="wlrk_jzd_zby" name="jzd_zby" value="${wlrk.jzd_zby}"/>
				    	</td>
      	</tr>
 
		<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">其他常用证件：</td>
			<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="wlrk_qtcyzjdm" name="qtcyzjdm" value="${wlrk.qtcyzjdm}" style="width:200px;"
				data-options="required:false,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right',onChange:wlrk_qtcyzjdm_onChange"/></td> 
	    	<td width="20%" class="dialogTd" align="right">其他常用证件号码：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="wlrk_qtzjhm" name="qtzjhm" value="${wlrk.qtzjhm}" style="width:200px;float:left;" maxlength="30" 
   	        	data-options="required:false,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码',tipPosition:'left'"/></td>
  	   	</tr>
  	    <tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">未落户原因：</td>
			<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="wlrk_wlhyydm" name="wlhyydm" value="${wlrk.wlhyydm}" style="width:200px;"
				data-options="required:true,url: contextPath + '/common/dict/ZA_D_WLHYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">居住处所：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="wlrk_zjzcsfldm" name="zjzcsfldm" value="${wlrk.zjzcsfldm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_JZCSFLYDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true,onChange:wlrk_zjzcsfldm_onChange"/></td>
  	    </tr>
        
  	    <tr class="dialogTr" id="wlrk_fz_tr1" style="display: none;">
	    	<td width="20%" class="dialogTd" align="right">房屋承租情况：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="wlrk_fwczqkdm" name="fwczqkdm" value="${wlrk.fwczqkdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_FWCZQKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">与房主关系：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="wlrk_chzr_yfzgx_rygxdm" name="chzr_yfzgx_rygxdm" value="${wlrk.chzr_yfzgx_rygxdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/XZ_D_RYGXDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true"/></td>
  	    </tr>
		<tr class="dialogTr" id="wlrk_fz_tr2" style="display: none;">
			<td width="20%" class="dialogTd" align="right">房主证件种类：</td>
			<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="wlrk_fz_cyzjdm" name="fz_cyzjdm" value="${wlrk.fz_cyzjdm}" style="width:200px;"
				data-options="required:false,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right',onChange:wlrk_fz_cyzjdm_onChange"/></td> 
	    	<td width="20%" class="dialogTd" align="right">房主证件号码：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="wlrk_fz_zjhm" name="fz_zjhm" value="${wlrk.fz_zjhm}" style="width:200px;float:left;" maxlength="30" 
   	        	data-options="required:false,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码',tipPosition:'left'" onblur="wlrk_fz_zjhm_onblur()"/><div class="lodingimg" id="wlrk_fzLoadDiv"></div>
 						<input type="hidden" id="wlrk_fz_ryid" name="fz_ryid" value="${wlrk.fz_ryid}"/>
   	        </td>
  	   	</tr>
		<tr class="dialogTr" id="wlrk_fz_tr3" style="display: none;">
   	        <td width="20%" class="dialogTd" align="right">房主姓名：</td>
   	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="wlrk_fz_xm" name="fz_xm" value="${wlrk.fz_xm}" style="width:200px;" maxlength="50"
   	        	data-options="tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">房主联系电话：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="wlrk_fz_lxdh" name="fz_lxdh" value="${wlrk.fz_lxdh}" style="width:200px;" maxlength="18"
				data-options="validType:['phone'],charSet:'half',tipPosition:'left'" onblur="checkLxdh('wlrk_fz_lxdh','wlrk_fz_ryid')"/></td>
      	</tr>
	  	<tr class="dialogTr" id="wlrk_fz_tr4" style="display: none;">
	    	<td width="20%" class="dialogTd" align="right">房主居住地址：</td>
	    	<td width="50%" class="dialogTd" colspan="2">
		    	<input class="easyui-combobox" id="wlrk_fz_jzd1" style="width:400px;" value="${wlrk.fz_jzd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    	<input type="hidden" id="wlrk_fz_jzd_mlpdm" name="fz_jzd_mlpdm" value="${wlrk.fz_jzd_mlpdm}"/>
		    	<input type="hidden" id="wlrk_fz_jzd_mlpxz" name="fz_jzd_mlpxz" value="${wlrk.fz_jzd_mlpxz}"/>
	    	</td>
	    	<td width="30%" class="dialogTd" align="left">
		    	<input class="easyui-combobox" id="wlrk_fz_jzd2" style="width:200px;" value='${fn:replace(wlrk.fz_jzd_dzxz, wlrk.fz_jzd_mlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    	<input type="hidden" id="wlrk_fz_jzd_dzid" name="fz_jzd_dzid" value="${wlrk.fz_jzd_dzid}"/>
		    	<input type="hidden" id="wlrk_fz_jzd_xzqhdm" name="fz_jzd_xzqhdm" value="${wlrk.fz_jzd_xzqhdm}"/>
		    	<input type="hidden" id="wlrk_fz_jzd_dzxz" name="fz_jzd_dzxz" value="${wlrk.fz_jzd_dzxz}"/>
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

	$("#wlrk_fz_zjhm").attr("cyzjdm", "${wlrk.fz_cyzjdm}");
	$("#wlrk_fz_zjhm").attr("zjhm", "${wlrk.fz_zjhm}");

	setInputReadonly("wlrk_cyzjdm", true);
	setInputReadonly("wlrk_zjhm", true);
	setInputReadonly("wlrk_jzd_dzxz", true);

	// 大数据的下拉列表初始化
	initComboBox("wlrk_csdssxdm", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 

	// 地址选择初始化
	initAddressSearch("wlrk_jzd1", {zrqdm:zrqdm}, "wlrk_jzd_mlpdm", "wlrk_jzd_mlpxz", "wlrk_jzd2", {text:"wlrk_jzd_dzxz",dzxzqh:"wlrk_jzd_xzqhdm",id:"wlrk_jzd_dzid",dzzbx:"wlrk_jzd_zbx",dzzby:"wlrk_jzd_zby"}, null, null);
	initAddressSearch("wlrk_lzd1", {}, "wlrk_lzd_mlpdm", "wlrk_lzd_mlpxz", "wlrk_lzd2", {text:"wlrk_lzd_dzxz",dzxzqh:"wlrk_lzd_xzqhdm",id:"wlrk_lzd_dzid"}, null, null);
	initAddressSearch("wlrk_fz_jzd1", {}, "wlrk_fz_jzd_mlpdm", "wlrk_fz_jzd_mlpxz", "wlrk_fz_jzd2", {text:"wlrk_fz_jzd_dzxz",dzxzqh:"wlrk_fz_jzd_xzqhdm",id:"wlrk_fz_jzd_dzid"}, null, null);
	initDepartmentSearch("wlrk_gzdw_select", {}, "wlrk_gzdwid", "wlrk_gzdw", {});

	wlrk_zjzcsfldm_onChange("${wlrk.zjzcsfldm}");
	
	
}

function beforeSubmit() {
	if ($("#dataForm").form("validate")) {
		if ($("#wlrk_jzd_mlpdm").val() == "") {
			topMessager.alert("", "居住地必须为标准地址，请重新选择！");
			var comboText = $("#wlrk_jzd1").next(".combo").children(".combo-text");
			comboText.focus();
			return false;
		}
		if ($("#wlrk_jzd2").combobox("getValue") == "") {
			topMessager.alert("", "居住地必须为标准地址，请重新选择！");
			var comboText = $("#wlrk_jzd2").next(".combo").children(".combo-text");
			comboText.focus();
			return false;
		}
		var wlrk_zjzcsfldmValue = $("#wlrk_zjzcsfldm").combotree("getValue");
		if (wlrk_zjzcsfldmValue == "30") { // 居住处所为租赁房屋
			if ($("#jbxx_id").val() != "" && $("#wlrk_fz_ryid").val() != "" && $("#jbxx_id").val() == $("#wlrk_fz_ryid").val()) {
				topMessager.alert("", "房主不能为本人，请重新输入！");
				$("#wlrk_fz_zjhm").focus();
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

function wlrk_qtcyzjdm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var cyzjdmValue = $("#wlrk_qtcyzjdm").combobox("getValue");
	if (cyzjdmValue == "111" || cyzjdmValue == "112" || cyzjdmValue == "335") { // 身份证类型、临时身份证、机动车驾驶证
		$("#wlrk_qtzjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#wlrk_qtzjhm").validatebox({validType:['letterOrNum']});
	}
}

function wlrk_zjzcsfldm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var wlrk_zjzcsfldmValue = $("#wlrk_zjzcsfldm").combotree("getValue");
	if (wlrk_zjzcsfldmValue == "30") { // 居住处所为租赁房屋
		$("#wlrk_fz_tr1").show();
		$("#wlrk_fz_tr2").show();
		$("#wlrk_fz_tr3").show();
		$("#wlrk_fz_tr4").show();
	}
	else {
		$("#wlrk_fz_tr1").hide();
		$("#wlrk_fz_tr2").hide();
		$("#wlrk_fz_tr3").hide();
		$("#wlrk_fz_tr4").hide();
		$("#wlrk_fwczqkdm").combobox("setValue", "");
		$("#wlrk_chzr_yfzgx_rygxdm").combotree("setValue", "");
		$("#wlrk_fz_ryid").val("");
		$("#wlrk_fz_cyzjdm").combobox("setValue", "");
		$("#wlrk_fz_zjhm").val("");
		$("#wlrk_fz_xm").val("");
		$("#wlrk_fz_lxdh").val("");
		$("#wlrk_fz_jzd1").combobox("loadData", []);
		$("#wlrk_fz_jzd2").combobox("loadData", []);
		var comboText = $("#wlrk_fz_jzd1").next(".combo").children(".combo-text");
		comboText.val("");
		var comboText = $("#wlrk_fz_jzd2").next(".combo").children(".combo-text");
		comboText.val("");
		var opts = $("#wlrk_fz_jzd2").combobox("options");
		opts.validEnter = false;
		$("#wlrk_fz_jzd_xzqhdm").val("");
		$("#wlrk_fz_jzd_mlpdm").val("");
		$("#wlrk_fz_jzd_mlpxz").val("");
		$("#wlrk_fz_jzd_dzid").val("");
		$("#wlrk_fz_jzd_dzxz").val("");
	}
}

function wlrk_fz_cyzjdm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var cyzjdmValue = $("#wlrk_fz_cyzjdm").combobox("getValue");
	if (cyzjdmValue == "111" || cyzjdmValue == "112" || cyzjdmValue == "335") { // 身份证类型、临时身份证、机动车驾驶证
		$("#wlrk_fz_zjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#wlrk_fz_zjhm").validatebox({validType:['letterOrNum']});
	}
	setTimeout("wlrk_fz_zjhm_onblur();", 300);
}

function wlrk_fz_zjhm_onblur() {
	if (!$("#wlrk_fz_cyzjdm").combo("isValid")) {
		$("#wlrk_fz_ryid").val("");
		return;
	}
	if (!$("#wlrk_fz_zjhm").validatebox("isValid")) {
		$("#wlrk_fz_ryid").val("");
		return;
	}
	if ($("#wlrk_fz_zjhm").val() == "") {
		$("#wlrk_fz_ryid").val("");
		return;
	}
	var _cyzjdm = $("#wlrk_fz_zjhm").attr("cyzjdm");
	if (!_cyzjdm) {
		_cyzjdm = "";
	} 
	var _zjhm = $("#wlrk_fz_zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if ($("#wlrk_fz_cyzjdm").combobox("getValue") == _cyzjdm && $("#wlrk_fz_zjhm").val() == _zjhm) {
		return;
	}
	$("#wlrk_fzLoadDiv").show();
	$.ajax({
		type: "POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType: "json",
		data:"zjhm=" + $("#wlrk_fz_zjhm").val() + "&cyzjdm=" + $("#wlrk_fz_cyzjdm").combobox("getValue"),
		success: function(data) {
			if (data && data.ryRyjbxxb) {
				$("#wlrk_fz_ryid").val(data.ryRyjbxxb.id);
				$("#wlrk_fz_xm").val(data.ryRyjbxxb.xm);
				$("#wlrk_fz_xm").validatebox("validate");
				$("#wlrk_fz_lxdh").val(data.ryRyjbxxb.lxdh);
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete: function() {
			$("#wlrk_fz_zjhm").attr("cyzjdm", $("#wlrk_fz_cyzjdm").combobox("getValue"));
			$("#wlrk_fz_zjhm").attr("zjhm", $("#wlrk_fz_zjhm").val());
			$("#wlrk_fzLoadDiv").hide();
		},
		error: function() {
		}
	});	
}

</script>

</html>
