<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>转递</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>zdryZd/saveZd" id="dataForm" name="dataForm" method="post" >
    	<input type="hidden" id="syrkid" name="syrkid" value="${zdryZdryzbVO.syrkid}" />
    	<input type="hidden" id="ryid" name="ryid" value="${zdryZdryzbVO.ryid }" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" name="zdryZdryzb.xm" style="width:200px;" readonly="readonly"  value="${zdryZdryzbVO.xm}"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zdryZdryzb.zjhm" style="width:200px;" readonly="readonly" value="${zdryZdryzbVO.zjhm}"/></td>
		    </tr>
		      <c:if test="${ displayStr != null}">
		       <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">已列管类别：</td>
	    		<td width="80%" class="dialogTd" colspan="3">
	    		${displayStr}
		    	</td>
		    </tr>
		    </c:if>
		     <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">转递类别：</td>
		    	<td width="30%" class="dialogTd" colspan="3">
		    	<input class="easyui-combobox" type="text"  id="zdrygllxdm" name="zdrygllxdm"   style="width:200px;" value=""
					data-options="url: contextPath +  '/common/dict/BD_D_ZDRYLBDMLIST_MUNICIPAL.js',dataFilter:'${filterZdStr}',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">户籍地址：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox inputreadonly"  type="text" id="dz_hjdmlpxz" name="dz_hjdmlpxz" value="${zdryZdryzbVO.dz_hjdzmlpxz}" maxlength="50"  readonly="readonly"
		    		style="width: 619px;" data-options=""/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">管辖派出所：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="ygxpcs" name="ygxpcs" value="" style="width:200px;" readonly="readonly"/>
		    		<input type="hidden" name="ygxpcsdm" id="ygxpcsdm" value="${zdryZdryzbVO.sspcsdm }"/>	
		    	</td>
				<td width="20%" class="dialogTd" align="right">管辖责任区：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox inputreadonly" type="text" id="ygxzrq" name="ygxzrq" value="" style="width:200px;" readonly="readonly"/>
		    		<input type="hidden" name="ygxzrqdm" id="ygxzrqdm" value="${zdryZdryzbVO.sszrqdm }"/>	
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">发起民警：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox inputreadonly" type="text" id="ywblr_xm" name="ywblr_xm" value="${zdryLczywblb.ywblr_xm}" style="width:200px;" readonly="readonly"/>
		    	<input type="hidden" name="ywblr_id" id="ywblr_id" value="${zdryLczywblb.ywblr_id }"/>	
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">转递地址：</td>
		    	<td width="50%" class="dialogTd" colspan="2">
					<input class="easyui-combobox" id="xjzd1" style="width:400px;" value="" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					<input type='hidden' name='dz_jzdzmlpdm' id="dz_jzdzmlpdm" value=""/>
					<input type='hidden' name='dz_jzdzmlpxz' id="dz_jzdzmlpxz" value=""/></td>
					<td width="30%" class="dialogTd">
					    	<input class="easyui-combobox" id="xjzd2" style="width:200px;" value='' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type='hidden' name='dz_jzdzdm' id='dz_jzdzdm' value="" />
					    	<input type='hidden' name='dz_jzdzxz' id='dz_jzdzxz' value="" /> 
				    </td>	
		    	
    	   </tr>
    	   <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">管辖派出所：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox inputreadonly" type="text" id="xgxpcs" name="xgxpcs" value="" style="width:200px;" readonly="readonly" />
		    		<input type="hidden" name="sspcsdm" id="xgxpcsdm" value=""/>
		    	</td>
				<td width="20%" class="dialogTd" align="right">管辖责任区：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox inputreadonly" type="text" id="xgxzrq" name="xgxzrq" value="" style="width:200px;" readonly="readonly" />
		    		<input type="hidden" name=sszrqdm id="xgxzrqdm" value=""/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">转递原因：</td>
		    	<td width="30%" class="dialogTd">
							<input class="easyui-combobox" type="text" id="ywfqyy"
								name="ywfqyy" style="width: 200px;" value=""
								data-options="url: contextPath + '/common/dict/D_RK_ZDYY.js',valueField:'text',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',
								formatter: function(row){
										var opts = $(this).combobox('options');
										return row[opts.textField];
									}" />
						</td>
		    </tr>
		    
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >
var filterZdStr='${filterZdStr}';
function doInit(paramArray) { 
	if(filterZdStr=='9999'){
		alert("此人所有重点人员类型状态都为进行中状态不可再撤管和转递");
	}
	initAddressSearch('xjzd1', {zrqdm:'${xgxzrqdm}'}, 'dz_jzdzmlpdm', 'dz_jzdzmlpxz', 'xjzd2', {text:'dz_jzdzxz',dzxzqh:'dz_xjzdzssxdm',id:'dz_jzdzdm',dzpcsdm:'xgxpcsdm',dzzrqdm:'xgxzrqdm'}, 'changeCodeToName', null);

	//$('#zdh_jzdzzbid').combobox('loadData','${jzdzJson}');
	public_getOrgName('ygxpcsdm','ygxpcs');
	public_getOrgName('ygxzrqdm','ygxzrq');
}

function beforeSubmit() {
}

function Submit() {
}

function changeCodeToName(){
	public_getOrgName('xgxpcsdm','xgxpcs');
	public_getOrgName('xgxzrqdm','xgxzrq');
}

</script>
</html>