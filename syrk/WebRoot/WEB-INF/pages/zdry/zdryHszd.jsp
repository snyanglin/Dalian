<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>重点人员核实转递</title>
</head>

<body>

<form action="<%=basePath%>zdryHsb/saveHszd" id="dataForm" name="dataForm" method="post">

    	<input type='hidden' name='id' id="id" value="${zdryHsb.id}" />
  	   	
   		<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
		<tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">姓名：</td>
	    	<td width="30%" class="dialogTd">
	    		<input class="easyui-validatebox inputreadonly" type="text" id="xm" name="xm" value="${zdryHsb.xm}" style="width:200px;" readonly="readonly"/>
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
	    	<td width="30%" class="dialogTd">
	    		<input class="easyui-validatebox inputreadonly" type="text" id="sfzh" name="sfzh" value="${zdryHsb.zjhm}"style="width:200px;" readonly="readonly"/>
	    	</td>
   		</tr>
		<tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">性别：</td>
	    	<td width="30%" class="dialogTd">
	    		<input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:200px;" value="${zdryHsb.xbdm}"
					data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">民族：</td>
	    	<td width="30%" class="dialogTd">
	    		<input class="easyui-combobox" type="text" id="mzdm" name="mzdm" style="width:200px;" value="${zdryHsb.mzdm}"
					data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
	    	</td>
   		</tr>
	    <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">户籍地址详址：</td>
	    	<td width="80%" class="dialogTd" colspan="3">
	    		<input class="easyui-validatebox" type="text" id="dz_hjdzxz" name="dz_hjdzxz" style="width: 618px;" value="${zdryHsb.dz_hjdzxz}"/>
	    	</td>
	   	</tr>
	    <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">原居住地址详址：</td>
	    	<td width="80%" class="dialogTd" colspan="3">
	    		<input type='hidden' name='ydz_jzdzdm' value="${zdryHsb.dz_jzdzdm}" />
	    		<input type='hidden' name='ydz_jzdzmlpdm' value="${zdryHsb.dz_jzdzmlpdm}" />
	    		<input type='hidden' name='ydz_jzdzmlpxz' value="${zdryHsb.dz_jzdzmlpxz}" />
	    		<input type='hidden' name='ydz_jzdzssxdm' value="${zdryHsb.dz_jzdzssxdm}" />
	    		<input class="easyui-validatebox" type="text" id="ydz_jzdzxz" name="ydz_jzdzxz" style="width: 618px;" value="${entity.ydz_jzdzxz}"/>
	    	</td>
	   	</tr>
	    <tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">转递居住地址详址：</td>
	    	<td width="50%" class="dialogTd" colspan="2">
		    	<input class="easyui-combobox" id="jzd1" style="width:380px;" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
		    	<input type='hidden' name='dz_jzdzmlpdm' id="dz_jzdzmlpdm"/>
		    	<input type='hidden' name='dz_jzdzmlpxz' id="dz_jzdzmlpxz"/>
	    	</td>
	    	<td width="30%" class="dialogTd">
		    	<input class="easyui-combobox" id="jzd2" style="width:200px;" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,tipPosition:'left'">
		    	<input type='hidden' name='dz_jzdzdm' id="dz_jzdzdm"/>
		    	<input type='hidden' name='dz_jzdzssxdm' id="dz_jzdzssxdm"/>
		    	<input type='hidden' name='dz_jzdzxz' id="dz_jzdzxz"/>
		    	<input type='hidden' name='sspcs' id="sspcs"/>
		    	<input type='hidden' name='sszrq' id="sszrq"/>
	    	</td>
	   	</tr>
	</table>	    
</form>
<script type="text/javascript" >

function doInit(paramArray) {
	setInputReadonly('xbdm',true);
	setInputReadonly('mzdm',true);
	setInputReadonly('dz_hjdzxz',true);
	setInputReadonly('ydz_jzdzxz',true);
	initAddressSearch('jzd1', {}, 'dz_jzdzmlpdm', 'dz_jzdzmlpxz', 'jzd2', {text:'dz_jzdzxz',dzxzqh:'dz_jzdzssxdm',id:'dz_jzdzdm',dzpcsdm:'sspcs',dzzrqdm:'sszrq'}, '', '');
}

function beforeSubmit() {
	if ($('#dz_jzdzmlpdm').val() == "") {
		topMessager.alert('', '请先选择有效的居住地！');
		var comboText = $('#jzd1').next(".combo").children(".combo-text");
		comboText.focus();
		return false;
	}
}

function afterSubmit() {
}
	
</script>