<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>转递</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>zdryZd/saveZd" id="dataForm" name="dataForm" method="post" enctype="multipart/form-data">
    	
    	<input type="hidden" id="id" name="id" value="${zdryZb.id}" />
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" name="xm" style="width:200px;" readonly="readonly"  value="${zdryZb.xm}"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zjhm" style="width:200px;" readonly="readonly" value="${zdryZb.zjhm}"/></td>
		    </tr>		 
		    <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">现居住地址：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox inputreadonly"  type="text" id="dz_hjdzmlpxz" name="dz_hjdzmlpxz" value="${zdryZb.jzd_dzxz}" maxlength="50"  readonly="readonly"
		    		style="width: 665px;" data-options=""/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">管辖派出所：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="ygxpcs" name="ygxpcs" value="" style="width:200px;" readonly="readonly"/>
		    		<input type="hidden" name="ygxpcsdm" id="ygxpcsdm" value="${zdryZb.gxpcsdm}"/>	
		    	</td>
				<td width="20%" class="dialogTd" align="right">管辖责任区：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox inputreadonly" type="text" id="ygxzrq" name="ygxzrq" value="" style="width:200px;" readonly="readonly"/>
		    		<input type="hidden" name="ygxzrqdm" id="ygxzrqdm" value="${zdryZb.gxzrqdm }"/>	
		    	</td>
		    </tr>    			
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">转递地址：</td>
		    	<td width="50%" class="dialogTd" colspan="2">
					<input class="easyui-combobox" id="xjzd1" style="width:400px;" value="" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					<input type='hidden' name='jzd_xzqhdm' id="jzd_xzqhdm" value=""/>
					<input type='hidden' name='jzd_mlpdm' id="jzd_mlpdm" value=""/>
					<input type='hidden' name='jzd_mlpxz' id="jzd_mlpxz" value=""/>										
					<input type='hidden' name='jzd_zbx' id="jzd_zbx" value=""/>
					<input type='hidden' name='jzd_zby' id="jzd_zby" value=""/>
				</td>
				<td width="30%" class="dialogTd">
					    	<input class="easyui-combobox" id="xjzd2" style="width:200px;" value='' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type='hidden' name='jzd_dzid' id="jzd_dzid" value=""/>
					    	<input type='hidden' name='jzd_dzxz' id="jzd_dzxz" value=""/>
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
		    		<input type="hidden" name="glbm" id="xgxzrqdm" value=""/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">转递原因：</td>
		    	<td width="30%" class="dialogTd" colspan="3">
		    		<input class="easyui-validatebox" type="text" id="ywfqyy" name="ywfqyy" style="width: 665px;" value=""  />
				</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">转递依据：</td>
		    	<td width="30%" class="dialogTd" colspan="3">
		    		<input type="file" name="uploadFile" id="uploadFile" style="width:665px;" class="easyui-validatebox" data-options="tipPosition:'left',invalidMessage:'请选择要上传的转递依据'" />
				</td>
		    </tr>		    
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 
	
	initAddressSearch('xjzd1', {zrqdm:'${xgxzrqdm}'}, 'jzd_mlpdm', 'jzd_mlpxz', 'xjzd2', {text:'jzd_dzxz',dzxzqh:'jzd_xzqhdm',id:'jzd_dzid',dzpcsdm:'xgxpcsdm',dzzrqdm:'xgxzrqdm',dzzbx:'jzd_zbx',dzzby:'jzd_zby'}, 'changeCodeToName', null);

	
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
