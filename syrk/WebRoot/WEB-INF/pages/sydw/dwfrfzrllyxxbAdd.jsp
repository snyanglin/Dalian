<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!--  
	@updateAuthor: [star]
	@updateDate:   [2015-6-2 上午8:51:54]
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/sydw.css"></link>
<title>法人\负责人\联络员</title>
</head>
<script type="text/javascript">
	var gjdm = "${entity.gjdm}";
</script>
<script type="text/javascript" src="<%=contextPath%>/js/sydw/dwfrfzrllyxxbAdd.js"></script>
<div class="easyui-layout" data-options="fit:true">
	<form action="<%=basePath%>dwfrfzrllyxxb/save" id="dataForm" name="dataForm" method="post">
		<input type="hidden" name="dwid" id="dwid" value="${entity.dwid }" />
		<input type="hidden" name="ryid" id="ryid" value="${entity.ryid }" />
		<!-- 从业人员id -->
		<input type="hidden" name="jjlxr_ryid" id="jjqklxrid" value="${entity.jjlxr_ryid }" />
		<!-- 紧急情况联系人ID -->
		<input type="hidden" id="pcsdm" value=${pcsdm } />
		<div data-options="region:'center', split:true"
			style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%"
				align="center">
				<input type="hidden" name="id" id="pk" value="${entity.id }" />
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">证件种类：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text" id="cyzjdm" name="cyzjdm"
						style="width:200px;" value="${entity.cyzjdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left',onChange:zjhmCheck,
						onSelect:function(record){
						if(record.id==111||record.id==112||record.id==335){
							$('#zjhm').validatebox({validType:['sfzh']});
						}else {
							$('#zjhm').validatebox({validType:['maxLength[30]']});
						}
					    }" />
					</td>
					<td width="20%" class="dialogTd" align="right">证件号码：</td>
					<td width="30%" class="dialogTd" align="left">
						<input class="easyui-validatebox" type="text" id="zjhm" name="zjhm"
						style="width:200px;float:left;" value="${entity.zjhm }"
						maxlength="30" data-options="required:true,tipPosition:'left'" />
					<div class="lodingimg" id="yrjbxxDiv"></div>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">姓名：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="xm" name="xm"
						style="width:200px;" value="${entity.xm }" maxlength="50"
						data-options="required:true,tipPosition:'left'" /></td>
					<td width="20%" class="dialogTd" align="right">出生日期：</td>
					<td width="30%" class="dialogTd">
						<input type="text" name="csrq" id="csrq" class="easyui-validatebox"
						style="width: 200px;" value="${entity.csrq }"
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" />
					</td>

				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">性别：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text" id="xbdm" name="xbdm"
						style="width:200px;" value="${entity.xbdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'" />
					</td>
					<td width="20%" class="dialogTd" align="right">民族：</td>
					<td width="30%" class="dialogTd">
						<input	class="easyui-combobox" type="text" id="mzdm" name="mzdm"
						style="width:200px;" value="${entity.mzdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_MZ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'" />
					</td>
				</tr>

				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">联系电话：</td>
					<td width="30%" class="dialogTd">
						<input	class="easyui-validatebox" type="text" id="lxdh" name="lxdh"
						style="width:200px;" value="${entity.lxdh }" maxlength="18"
						data-options="validType:['phone'],required:false,tipPosition:'right'" />
					</td>
					<td width="20%" class="dialogTd" align="right">国籍：</td>
					<td width="30%" class="dialogTd">
						<input type="text" name="gjdm" id="gjdm" class="easyui-combobox" style="width:200px;"
						value="${entity.gjdm }"
						data-options="url: contextPath + '/common/dict/D_BZ_SJGGHDQMCDM.js',dataFilter:'',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'">
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">居住地址：</td>
					<td width="50%" class="dialogTd" colspan="2">
					    <input class="easyui-combobox" id="dwfr_jzdz1" style="width:400px;"
						value="${entity.dz_xjzdmlpxz}"
						data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						<input type='hidden' name='dz_xjzdmlpdm' id="dwfr_dz_xjzdmlpdm"
						value="${entity.dz_xjzdmlpdm}" /> 
						<input type='hidden'
						name='dz_xjzdmlpxz' id="dwfr_dz_xjzdmlpxz"
						value="${entity.dz_xjzdmlpxz}" />
					</td>
					<td width="30%" class="dialogTd">
					    <input class="easyui-combobox" id="dwfr_jzdz2" style="width:200px;"
						value='${fn:replace(entity.dz_xjzdzxz, entity.dz_xjzdmlpxz,"")}'
						data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						<input type='hidden' name='dz_xjzdzdm' id='dwfr_dz_xjzdzdm' value="${entity.dz_xjzdzdm}" /> 
						<input type='hidden' name='dz_xjzdzssxdm' id='dwfr_dz_xjzdzssxdm' value="${entity.dz_xjzdzssxdm}" /> 
						<input type='hidden' name='dz_xjzdzxz' id='dwfr_dz_xjzdzxz' value="${entity.dz_xjzdzxz}" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">户籍地址：</td>
					<td width="50%" class="dialogTd" colspan="2">
					    <input class="easyui-combobox" id="dwfr_hjdz1" 
					    style="width:400px;" value="${entity.dz_hjdmlpxz}"
						data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						<input type='hidden' name='dz_hjdmlpdm' id="dwfr_dz_hjdmlpdm" value="${entity.dz_hjdmlpdm}" /> 
						<input type='hidden' name='dz_hjdmlpxz' id="dwfr_dz_hjdmlpxz" value="${entity.dz_hjdmlpxz}" /></td>
					<td width="30%" class="dialogTd">
					    <input class="easyui-combobox" id="dwfr_hjdz2" style="width:200px;"
						value='${fn:replace(entity.dz_hjdzxz, entity.dz_hjdmlpxz, "")}'
						data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
						<input type='hidden' name='dz_hjdzdm' id='dwfr_dz_hjdzdm' value="${entity.dz_hjdzdm}" /> 
						<input type='hidden' name='dz_hjdzssxdm' id='dwfr_dz_hjdzssxdm' value="${entity.dz_hjdzssxdm}" /> 
						<input type='hidden' name='dz_hjdzxz' id='dwfr_dz_hjdzxz' value="${entity.dz_hjdzxz}" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">职务：</td>
					<td width="30%" class="dialogTd">
					 <input class="easyui-combobox" type="text" id="zw" name="zw" style="width:200px;" value="${entity.zw}" maxlength="20" 
			    		data-options="required:false,url: contextPath + '/common/dict/D_RK_ZW.js',
			    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">单位人员类型：</td>
					<td width="30%" class="dialogTd">
					   <input type="text" name="dwrylxdm"
						id="dwrylxdm" class="easyui-combobox" style="width:200px;"
						value="${entity.dwrylxdm }"
						data-options="url: contextPath + '/common/dict/D_DW_DWRYLXDM.js',dataFilter:'',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left'">
					</td>
				</tr>
				
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">是否在公司任职：</td>
					<td width="30%" class="dialogTd">
					 <input class="easyui-combobox" type="text" id="sfzgsrzdm" name="sfzgsrzdm" style="width:200px;" value="${entity.sfzgsrzdm}" maxlength="20" 
			    		data-options="required:false,url: contextPath + '/common/dict/D_BZ_SF.js',
			    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>
					</td>
				</tr>
				
				<tr class="dialogTr"></tr>
			</table>
		</div>
	</form>
</div>
</html>