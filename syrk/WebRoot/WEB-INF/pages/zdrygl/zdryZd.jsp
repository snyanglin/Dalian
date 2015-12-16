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
    	
    	<input type="hidden" id="id" name="id" value="${zdryZb.zdryZdryzb.id}" />
    	<input type="hidden" id="zdryZdryzb.id" name="zdryZdryzb.id" value="${zdryZb.zdryZdryzb.id}" />
    	<input type="hidden" id="zdryZdryzbVO.id" name="zdryZdryzbVO.id" value="${zdryZb.zdryZdryzb.id}" />
    	<input type="hidden" id="lxdh" name="zdryZdryzb.zdrylb" value="${zdryZb.zdryZdryzb.zdrylb}" />
    	<input type="hidden" id="lxdh" name="zdryZdryzb.zdrygllxdm" value="${zdryZb.zdryZdryzb.zdrygllxdm}" />
    	<input type="hidden" id="lxdh" name="zdryZdryzb.cyzjdm" value="${zdryZb.zdryZdryzb.cyzjdm}" />
    	
		<%-- <jsp:include page="zdryYwzd.jsp"></jsp:include> --%>
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" name="xm" style="width:200px;" readonly="readonly"  value="${zdryZb.zdryZdryzb.xm}"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zjhm" style="width:200px;" readonly="readonly" value="${zdryZb.zdryZdryzb.zjhm}"/></td>
		    </tr>		 
		    <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">现居住地址：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox inputreadonly"  type="text" id="dz_hjdzmlpxz" name="zdryZdryzbVO.dz_hjdzmlpxz" value="${zdryZb.zdryZdryzb.jzd_dzxz}" maxlength="50"  readonly="readonly"
		    		style="width: 628px;" data-options=""/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">管辖派出所：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="ygxpcs" name="zdryZb.zdryZdryzb.ygxpcs" value="" style="width:200px;" readonly="readonly"/>
		    		<input type="hidden" name="zdryZdryzbVO.ygxpcsdm" id="ygxpcsdm" value="${zdryZb.zdryZdryzb.gxpcsdm}"/>	
		    	</td>
				<td width="20%" class="dialogTd" align="right">管辖责任区：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox inputreadonly" type="text" id="ygxzrq" name="zdryZb.zdryZdryzb.ygxzrq" value="" style="width:200px;" readonly="readonly"/>
		    		<input type="hidden" name="zdryZdryzbVO.ygxzrqdm" id="ygxzrqdm" value="${zdryZb.zdryZdryzb.gxzrqdm }"/>	
		    	</td>
		    </tr>    			
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">转递地址：</td>
		    	<td width="50%" class="dialogTd" colspan="2">
					<input class="easyui-combobox" id="xjzd1" style="width:400px;" value="" data-options="required:true,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					<input type='hidden' name='zdryZdryzb.jzd_xzqhdm' id="jzd_xzqhdm" value=""/>
					<input type='hidden' name='zdryZdryzb.jzd_mlpdm' id="jzd_mlpdm" value=""/>
					<input type='hidden' name='zdryZdryzb.jzd_mlpxz' id="jzd_mlpxz" value=""/>										
					<input type='hidden' name='zdryZdryzb.jzd_zbx' id="jzd_zbx" value=""/>
					<input type='hidden' name='zdryZdryzb.jzd_zby' id="jzd_zby" value=""/>
				</td>
				<td width="30%" class="dialogTd">
					    	<input class="easyui-combobox" id="xjzd2" style="width:200px;" value='' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type='hidden' name='zdryZdryzb.jzd_dzid' id="jzd_dzid" value=""/>
					    	<input type='hidden' name='zdryZdryzb.jzd_dzxz' id="jzd_dzxz" value=""/>
				</td>	
		    	
    	   </tr>
    	   <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">管辖派出所：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox inputreadonly" type="text" id="xgxpcs" name="zdryZdryzbVO.xgxpcs" value="" style="width:200px;" readonly="readonly" />
		    		<input type="hidden" name="zdryZdryzbVO.sspcsdm" id="xgxpcsdm" value=""/>
		    	</td>
				<td width="20%" class="dialogTd" align="right">管辖责任区：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox inputreadonly" type="text" id="xgxzrq" name="zdryZdryzbVO.xgxzrq" value="" style="width:200px;" readonly="readonly" />
		    		<input type="hidden" name="zdryZdryzbVO.sszrqdm" id="xgxzrqdm" value=""/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">转递原因：</td>
		    	<td width="30%" class="dialogTd" colspan="3">
		    		<input class="easyui-validatebox" type="text" id="ywfqyy" name="zdryZdryzbVO.ywfqyy" style="width: 628px;" value=""  />
				</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">转递依据：</td>
		    	<td width="30%" class="dialogTd" colspan="3">
		    		<input type="file" name="uploadFile" id="uploadFile" style="width:628px;" class="easyui-validatebox" data-options="tipPosition:'left',invalidMessage:'请选择要上传的转递依据'" />
				</td>
		    </tr>	
		    <tr class="dialogTr">
		    	<td class="dialogTd" align="center" colspan="2"><a href="#" onclick="viewWorkflowDialog();">查看流程图</a> </td>		    	
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
function viewWorkflowDialog(){
	var processDefinitionKey = "zd";
	var url = '/syrk/diagram/diagram/' + processDefinitionKey;
	var result=window.open(url,'newWindow','modal=yes,height=600px,width=900px,resizable=yes,z-look=yes,alwaysRaised=yes'); 
	window.onfocus=function (){result.focus();};

}
</script>
</html>
