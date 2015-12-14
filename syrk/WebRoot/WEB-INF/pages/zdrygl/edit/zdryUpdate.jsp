<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>重点人员编辑</title>
</head>
<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">
    <form action="<%=basePath%>zdryEdit/zdryUpdate"  id="dataForm" name="dataForm" method="post" enctype="multipart/form-data">
    	<input type="hidden" id="syrkid" name="zdryZdryzb.syrkid" value="${zdryVO.zdryZdryzb.syrkid}" />
    	<input type="hidden" id="id" name="zdryZdryzb.id" value="${zdryVO.zdryZdryzb.id}" />    	
    	
    		    
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" name="zdryZdryzb.xm" style="width:200px;" readonly="readonly"  value="${zdryVO.zdryZdryzb.xm}"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zdryZdryzb.zjhm" style="width:200px;" readonly="readonly" value="${zdryVO.zdryZdryzb.zjhm}"/></td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">性别：</td>
		    	<td width="30%" class="dialogTd">		    		
		    		<input class="easyui-combobox inputreadonly" type="text"  id="xbdm" name="zdryZdryzb.xbdm"   style="width:200px;" readonly="readonly" value="${zdryVO.zdryZdryzb.xbdm}" 
					data-options="url: contextPath +'/common/dict/GB_D_XBDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>		    		
		    	</td>
				<td width="20%" class="dialogTd" align="right">证件号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" id="zjhm" name="zdryZdryzb.zjhm" style="width:200px;" readonly="readonly" value="${zdryVO.zdryZdryzb.zjhm}"/></td>
		    </tr>
		    <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">重点人员类型：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    		<input class="easyui-combobox inputreadonly" type="text"  id="zdrygllxdm" name="zdryZdryzb.zdrygllxdm"   style="width:200px;" value="${zdryVO.zdryZdryzb.zdrygllxdm}"  readonly="readonly"
					data-options="url: contextPath +'/common/dict/BD_D_ZDRYGLLX.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>		    					
	    			<input class="easyui-combotree inputreadonly" type="text"  id="zdrylb" name="zdryZdryzb.zdrylb"   style="width:390px;" value="${zdryVO.zdryZdryzb.zdrylb}" readonly="readonly"
					data-options="url: contextPath +'/common/dict/BD_D_ZDRYLB.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>	    			
		    	</td>
		    </tr>
		    
		    </table>
 		<!-- 这里引用公用列管信息模块 -->
		<%@include file="/WEB-INF/pages/zdrygl/add/zdryLgLxInc.jsp"%>
	    		    	
	    
    </form>
    </div>
    
</div>
<script type="text/javascript" >

function doInit(paramArray) {
	setInputReadonly("xbdm", true);
	setInputReadonly("zdrygllxdm", true);
	setInputReadonly("zdrylb", true);
	showGroup($("#zdrygllxdm").val());
}

function beforeSubmit() {
	
}

function afterSubmit() {
	parent.location.reload();
}
</script>
</html>