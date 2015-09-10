<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>流动人口信息</title>
</head>

<body>

<form action="<%=basePath%>syrkLdrkxxb/${ldrk.id}" id="dataForm" name="dataForm" method="post">
    
	<input type="hidden" id="_method" name="_method" value="PUT"/>
  	<input type='hidden' id="pk" name='id' value="${ldrk.id}" />
	<input type="hidden" id="ryid" name="ryid" value="${ldrk.ryid}"/>
   
   	<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
		<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">证件种类：</td>
			<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="ldrk_cyzjdm" name="cyzjdm" value="${ldrk.cyzjdm}" style="width:200px;"
				data-options="required:true,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">证件号码：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ldrk_zjhm" name="zjhm" value="${ldrk.zjhm}" style="width:200px;float:left;" maxlength="30" 
   	        	data-options="required:true,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码',tipPosition:'right'"/></td>
  	   	</tr>
		<tr class="dialogTr">
   	        <td width="20%" class="dialogTd" align="right">姓名：</td>
   	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ldrk_xm" name="xm" value="${ldrk.xm}" style="width:200px;" maxlength="50"
   	        	data-options="required:true,tipPosition:'right'"/></td>
   	        <td width="20%" class="dialogTd" align="right">曾用名：</td>
   	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ldrk_cym" name="cym" value="${ldrk.cym}" style="width:200px;" maxlength="50"
   	        	data-options="tipPosition:'left'"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">性别：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="ldrk_xbdm" name="xbdm" value="${ldrk.xbdm}" style="width:200px;" 
				data-options="required:true,url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">出生日期：</td>
   	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ldrk_csrq" name="csrq" value="${ldrk.csrq}" style="width:200px;" 
   	 			data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
  	   	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">民族：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="ldrk_mzdm" name="mzdm" value="${ldrk.mzdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">联系电话：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ldrk_lxdh" name="lxdh" value="${ldrk.lxdh}" style="width:200px;" maxlength="18"
				data-options="validType:['phone'],charSet:'half',tipPosition:'left'" onblur="checkLxdh('ldrk_lxdh','ryid')"/></td>
      	</tr>
  	   	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">学历：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="ldrk_xldm" name="xldm" value="${ldrk.xldm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_XLDM.js',onlyLeaf:true,multiple:false,panelWidth:300,method:'get',editable:true,lines:true"></td> 
	    	<td width="20%" class="dialogTd" align="right">婚姻状况：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="ldrk_hyzkdm" name="hyzkdm" value="${ldrk.hyzkdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_HYZKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
      	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">政治面貌：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="ldrk_zzmmdm" name="zzmmdm" value="${ldrk.zzmmdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_ZZMMDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td> 
	    	<td width="20%" class="dialogTd" align="right">职业类别：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="ldrk_zylbdm" name="zylbdm" value="${ldrk.zylbdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_ZYFLYDM.js',onlyLeaf:true,multiple:false,panelWidth:410,method:'get',editable:true,lines:true"></td>
      	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">职业：</td>
	    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="ldrk_zy" name="zy" value="${ldrk.zy}" style="width:618px;" maxlength="60"/></td> 
      	</tr>
        <tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">工作单位：</td>
			<td width="80%" class="dialogTd" colspan="3">
			<input type="hidden" id="ldrk_gzdwid" name="gzdwid" value="${ldrk.gzdwid}"/>
			<input type="hidden" id="ldrk_gzdw" name="gzdw" value="${ldrk.gzdw}"/>
			<input class="easyui-combobox" id="ldrk_gzdw_select" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" type="text" value="${ldrk.gzdw}" maxlength="50" style="width:595px;" /></td>
		</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">户籍地址：</td>
	    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="ldrk_hjd_dzxz" value="${ldrk.hjd_dzxz}" style="width:618px;" maxlength="60"/></td> 
      	</tr>
      	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">居住地：</td>
      	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="ldrk_jzd1" style="width:380px;" value="${ldrk.jzd_mlpxz}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="ldrk_jzd_mlpdm" name="jzd_mlpdm" value="${ldrk.jzd_mlpdm}"/>
					    	<input type="hidden" id="ldrk_jzd_mlpxz" name="jzd_mlpxz" value="${ldrk.jzd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="ldrk_jzd2" style="width:200px;" value="${fn:replace(ldrk.jzd_dzxz, ldrk.jzd_mlpxz, '')}" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="ldrk_jzd_dzid" name="jzd_dzid" value="${ldrk.jzd_dzid}"/>
					    	<input type="hidden" id="ldrk_jzd_xzqhdm" name="jzd_xzqhdm" value="${ldrk.jzd_xzqhdm}"/>
					    	<input type="hidden" id="ldrk_jzd_dzxz" name="jzd_dzxz" value="${ldrk.jzd_dzxz}"/>
					    	<input type="hidden" id="ldrk_jzd_zbx" name="jzd_zbx" value="${ldrk.jzd_zbx}"/>
					    	<input type="hidden" id="ldrk_jzd_zby" name="jzd_zby" value="${ldrk.jzd_zby}"/>
				    	</td>
      	</tr>
 
  	     <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">居住事由：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="ldrk_zjzsydm" name="zjzsydm" value="${ldrk.zjzsydm}" style="width:200px;" 
				data-options="required:false,url: contextPath + '/common/dict/ZA_D_RKQYYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">户口所在地类型：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="ldrk_hkszdlxdm" name="hkszdlxdm" value="${ldrk.hkszdlxdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_DYCXSXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
  	    </tr>
  	    <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">迁入日期：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ldrk_lbsqk_qlrrq" name="lbsqk_qlrrq" value="${ldrk.lbsqk_qlrrq}" style="width:200px;" 
   	 			data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',maxDate:'%y-%M-%d'})"/></td>
	    	<td width="20%" class="dialogTd" align="right">迁移原因：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="ldrk_lbsqk_qyldyydm" name="lbsqk_qyldyydm" value="${ldrk.lbsqk_qyldyydm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_RKQYYYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
  	    </tr>
  	    <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">来自国家：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="ldrk_lzd_gjhdqdm" name="lzd_gjhdqdm" value="${ldrk.lzd_gjhdqdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">区域范围：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="ldrk_qyfwdm" name="qyfwdm" value="${ldrk.qyfwdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/KX_ZA_RKQYQYFWDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td>
  	   	</tr>
  		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">来自地：</td>
	    	<td width="50%" class="dialogTd" colspan="2">
		    	<input class="easyui-combobox" id="ldrk_lzd1" style="width:400px;" value="${ldrk.lzd_mlpxz}" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    	<input type="hidden" id="ldrk_lzd_mlpdm" name="lzd_mlpdm" value="${ldrk.lzd_mlpdm}"/>
		    	<input type="hidden" id="ldrk_lzd_mlpxz" name="lzd_mlpxz" value="${ldrk.lzd_mlpxz}"/>
	    	</td>
	    	<td width="30%" class="dialogTd" align="left">
		    	<input class="easyui-combobox" id="ldrk_lzd2" style="width:200px;" value="${fn:replace(ldrk.lzd_dzxz, ldrk.lzd_mlpxz, '')}" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    	<input type="hidden" id="ldrk_lzd_dzid" name="lzd_dzid" value="${ldrk.lzd_dzid}"/>
		    	<input type="hidden" id="ldrk_lzd_xzqhdm" name="lzd_xzqhdm" value="${ldrk.lzd_xzqhdm}"/>
		    	<input type="hidden" id="ldrk_lzd_dzxz" name="lzd_dzxz" value="${ldrk.lzd_dzxz}"/>
	    	</td>
   	    </tr>

  	    <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">居住处所：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="ldrk_zjzcsfldm" name="zjzcsfldm" value="${ldrk.zjzcsfldm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_JZCSFLYDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true,onChange:ldrk_zjzcsfldm_onChange"/></td>
	    	<td width="20%" class="dialogTd" align="right"></td>
	    	<td width="30%" class="dialogTd"></td>
  	   	</tr>

      	<tr class="dialogTr" id="ldrk_fz_tr1" style="display: none;">
	    	<td width="20%" class="dialogTd" align="right">房屋承租情况：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="ldrk_fwczqkdm" name="fwczqkdm" value="${ldrk.fwczqkdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/ZA_D_FWCZQKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">与房主关系：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="ldrk_chzr_yfzgx_rygxdm" name="chzr_yfzgx_rygxdm" value="${ldrk.chzr_yfzgx_rygxdm}" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/XZ_D_RYGXDM.js',onlyLeaf:true,dataFilter:'',multiple:false,method:'get',editable:true,lines:true"/></td>
  	    </tr>
		<tr class="dialogTr" id="ldrk_fz_tr2" style="display: none;">
			<td width="20%" class="dialogTd" align="right">房主证件种类：</td>
			<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="ldrk_fz_cyzjdm" name="fz_cyzjdm" value="${ldrk.fz_cyzjdm}" style="width:200px;"
				data-options="required:false,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',panelOptionsNumber:8,tipPosition:'right',onChange:ldrk_fz_cyzjdm_onChange"/></td> 
	    	<td width="20%" class="dialogTd" align="right">房主证件号码：</td>
	    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ldrk_fz_zjhm" name="fz_zjhm" value="${ldrk.fz_zjhm}" style="width:200px;float:left;" maxlength="30" 
   	        	data-options="required:false,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码',tipPosition:'left'" onblur="ldrk_fz_zjhm_onblur()"/><div class="lodingimg" id="ldrk_fzLoadDiv"></div>
 						<input type="hidden" id="ldrk_fz_ryid" name="fz_ryid" value="${ldrk.fz_ryid}"/>
   	        </td>
  	    </tr>
		<tr class="dialogTr" id="ldrk_fz_tr3" style="display: none;">
   	        <td width="20%" class="dialogTd" align="right">房主姓名：</td>
   	        <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ldrk_fz_xm" name="fz_xm" value="${ldrk.fz_xm}" style="width:200px;" maxlength="50"
   	        	data-options="tipPosition:'right'"/></td>
	    	<td width="20%" class="dialogTd" align="right">房主联系电话：</td>
    		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ldrk_fz_lxdh" name="fz_lxdh" value="${ldrk.fz_lxdh}" style="width:200px;" maxlength="18"
				data-options="validType:['phone'],charSet:'half',tipPosition:'left'" onblur="checkLxdh('ldrk_fz_lxdh','ldrk_fz_ryid')"/></td>
  	   	</tr>
  		<tr class="dialogTr" id="ldrk_fz_tr4" style="display: none;">
	    	<td width="20%" class="dialogTd" align="right">房主居住地址：</td>
	    	<td width="50%" class="dialogTd" colspan="2">
		    	<input class="easyui-combobox" id="ldrk_fz_jzd1" style="width:400px;" value="${ldrk.fz_jzd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    	<input type="hidden" id="ldrk_fz_jzd_mlpdm" name="fz_jzd_mlpdm" value="${ldrk.fz_jzd_mlpdm}"/>
		    	<input type="hidden" id="ldrk_fz_jzd_mlpxz" name="fz_jzd_mlpxz" value="${ldrk.fz_jzd_mlpxz}"/>
	    	</td>
	    	<td width="30%" class="dialogTd" align="left">
		    	<input class="easyui-combobox" id="ldrk_fz_jzd2" style="width:200px;" value="${fn:replace(ldrk.fz_jzd_dzxz, ldrk.fz_jzd_mlpxz, '')}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    	<input type="hidden" id="ldrk_fz_jzd_dzid" name="fz_jzd_dzid" value="${ldrk.fz_jzd_dzid}"/>
		    	<input type="hidden" id="ldrk_fz_jzd_xzqhdm" name="fz_jzd_xzqhdm" value="${ldrk.fz_jzd_xzqhdm}"/>
		    	<input type="hidden" id="ldrk_fz_jzd_dzxz" name="fz_jzd_dzxz" value="${ldrk.fz_jzd_dzxz}"/>
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

	$("#ldrk_fz_zjhm").attr("cyzjdm", "${ldrk.fz_cyzjdm}");
	$("#ldrk_fz_zjhm").attr("zjhm", "${ldrk.fz_zjhm}");

	setInputReadonly("ldrk_cyzjdm", true);
	setInputReadonly("ldrk_zjhm", true);
	setInputReadonly("ldrk_hjd_dzxz", true);
	setInputReadonly("ldrk_jzd_dzxz", true);

	// 地址选择初始化
	initAddressSearch("ldrk_lzd1", {}, "ldrk_lzd_mlpdm", "ldrk_lzd_mlpxz", "ldrk_lzd2", {text:"ldrk_lzd_dzxz",dzxzqh:"ldrk_lzd_xzqhdm",id:"ldrk_lzd_dzid"}, null, null);
	initAddressSearch("ldrk_fz_jzd1", {}, "ldrk_fz_jzd_mlpdm", "ldrk_fz_jzd_mlpxz", "ldrk_fz_jzd2", {text:"ldrk_fz_jzd_dzxz",dzxzqh:"ldrk_fz_jzd_xzqhdm",id:"ldrk_fz_jzd_dzid"}, null, null);
	initAddressSearch("ldrk_jzd1", {zrqdm:zrqdm}, "ldrk_jzd_mlpdm", "ldrk_jzd_mlpxz", "ldrk_jzd2", {text:"ldrk_jzd_dzxz",dzxzqh:"ldrk_jzd_xzqhdm",id:"ldrk_jzd_dzid",dzzbx:"ldrk_jzd_zbx",dzzby:"ldrk_jzd_zby"}, null, null);
	// 单位选择初始化
	initDepartmentSearch("ldrk_gzdw_select", {}, "ldrk_gzdwid", "ldrk_gzdw", {});
	initDepartmentSearch("ldrk_gzdw_select", {}, "ldrk_gzdwid", "ldrk_gzdw", {});

	ldrk_zjzcsfldm_onChange("${ldrk.zjzcsfldm}");
	
	
	
}

function beforeSubmit() {
	if ($("#dataForm").form("validate")) {
		if ($("#ldrk_jzd_mlpdm").val() == "") {
			topMessager.alert("", "居住地必须为标准地址，请重新选择！");
			var comboText = $("#ldrk_jzd1").next(".combo").children(".combo-text");
			comboText.focus();
			return false;
		}
		if ($("#ldrk_jzd2").combobox("getValue") == "") {
			topMessager.alert("", "居住地必须为标准地址，请重新选择！");
			var comboText = $("#ldrk_jzd2").next(".combo").children(".combo-text");
			comboText.focus();
			return false;
		}
		var ldrk_zjzcsfldmValue = $("#ldrk_zjzcsfldm").combotree("getValue");
		if (ldrk_zjzcsfldmValue == "30") { // 居住处所为租赁房屋
			if ($("#jbxx_id").val() != "" && $("#ldrk_fz_ryid").val() != "" && $("#jbxx_id").val() == $("#ldrk_fz_ryid").val()) {
				topMessager.alert("", "房主不能为本人，请重新输入！");
				$("#ldrk_fz_zjhm").focus();
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

function ldrk_zjzcsfldm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var ldrk_zjzcsfldmValue = $("#ldrk_zjzcsfldm").combotree("getValue");
	if (ldrk_zjzcsfldmValue == "30") { // 居住处所为租赁房屋
		$("#ldrk_fz_tr1").show();
		$("#ldrk_fz_tr2").show();
		$("#ldrk_fz_tr3").show();
		$("#ldrk_fz_tr4").show();
	}
	else {
		$("#ldrk_fz_tr1").hide();
		$("#ldrk_fz_tr2").hide();
		$("#ldrk_fz_tr3").hide();
		$("#ldrk_fz_tr4").hide();
		$("#ldrk_fwczqkdm").combobox("setValue", "");
		$("#ldrk_chzr_yfzgx_rygxdm").combotree("setValue", "");
		$("#ldrk_fz_ryid").val("");
		$("#ldrk_fz_cyzjdm").combobox("setValue", "");
		$("#ldrk_fz_zjhm").val("");
		$("#ldrk_fz_xm").val("");
		$("#ldrk_fz_lxdh").val("");
		$("#ldrk_fz_jzd1").combobox("loadData", []);
		$("#ldrk_fz_jzd2").combobox("loadData", []);
		var comboText = $("#ldrk_fz_jzd1").next(".combo").children(".combo-text");
		comboText.val("");
		var comboText = $("#ldrk_fz_jzd2").next(".combo").children(".combo-text");
		comboText.val("");
		var opts = $("#ldrk_fz_jzd2").combobox("options");
		opts.validEnter = false;
		$("#ldrk_fz_jzd_xzqhdm").val("");
		$("#ldrk_fz_jzd_mlpdm").val("");
		$("#ldrk_fz_jzd_mlpxz").val("");
		$("#ldrk_fz_jzd_dzid").val("");
		$("#ldrk_fz_jzd_dzxz").val("");
	}
}

function ldrk_fz_cyzjdm_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var cyzjdmValue = $("#ldrk_fz_cyzjdm").combobox("getValue");
	if (cyzjdmValue == "111" || cyzjdmValue == "112" || cyzjdmValue == "335") { // 身份证类型、临时身份证、机动车驾驶证
		$("#ldrk_fz_zjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#ldrk_fz_zjhm").validatebox({validType:['letterOrNum']});
	}
	setTimeout("ldrk_fz_zjhm_onblur();", 300);
}

function ldrk_fz_zjhm_onblur() {
	if (!$("#ldrk_fz_cyzjdm").combo("isValid")) {
		$("#ldrk_fz_ryid").val("");
		return;
	}
	if (!$("#ldrk_fz_zjhm").validatebox("isValid")) {
		$("#ldrk_fz_ryid").val("");
		return;
	}
	if ($("#ldrk_fz_zjhm").val() == "") {
		$("#ldrk_fz_ryid").val("");
		return;
	}
	var _cyzjdm = $("#ldrk_fz_zjhm").attr("cyzjdm");
	if (!_cyzjdm) {
		_cyzjdm = "";
	} 
	var _zjhm = $("#ldrk_fz_zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if ($("#ldrk_fz_cyzjdm").combobox("getValue") == _cyzjdm && $("#ldrk_fz_zjhm").val() == _zjhm) {
		return;
	}
	$("#ldrk_fzLoadDiv").show();
	$.ajax({
		type: "POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType: "json",
		data:"zjhm=" + $("#ldrk_fz_zjhm").val() + "&cyzjdm=" + $("#ldrk_fz_cyzjdm").combobox("getValue"),
		success: function(data) {
			if (data && data.ryRyjbxxb) {
				$("#ldrk_fz_ryid").val(data.ryRyjbxxb.id);
				$("#ldrk_fz_xm").val(data.ryRyjbxxb.xm);
				$("#ldrk_fz_xm").validatebox("validate");
				$("#ldrk_fz_lxdh").val(data.ryRyjbxxb.lxdh);
			}
			if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete: function() {
			$("#ldrk_fz_zjhm").attr("cyzjdm", $("#ldrk_fz_cyzjdm").combobox("getValue"));
			$("#ldrk_fz_zjhm").attr("zjhm", $("#ldrk_fz_zjhm").val());
			$("#ldrk_fzLoadDiv").hide();
		},
		error: function() {
		}
	});	
}

</script>

</html>
