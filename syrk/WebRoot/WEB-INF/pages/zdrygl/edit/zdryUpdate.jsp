<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>重点人员编辑</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>zdryEdit/zdryUpdate"  id="dataForm" name="dataForm" method="post" enctype="multipart/form-data">
    	<input type="hidden" id="syrkid" name="zdryZdryzb.syrkid" value="${zdryVO.zdryZdryzb.syrkid}" />
    	<input type="hidden" id="id" name="zdryZdryzb.id" value="${zdryVO.zdryZdryzb.id}" />
    	<input type="hidden" id="zdrygllxdm" name="zdryZdryzb.zdrygllxdm" value="${zdryVO.zdrylbStr}/${zdryVO.zdryZdryzb.zdrygllxdm}" />
    	
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" name="zdryZdryzb.xm" style="width:200px;" readonly="readonly"  value="${zdryVO.zdryZdryzbVO.xm}"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zdryZdryzb.zjhm" style="width:200px;" readonly="readonly" value="${zdryVO.zdryZdryzbVO.zjhm}"/></td>
		    </tr>
		    <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">重点人员管理类型：</td>
		    	<td width="30%" class="dialogTd">
		    		${zdryVO.zdryZdryzbVO.zdrygllxmc}
				</td>	
	    		<td width="20%" class="dialogTd" align="right">重点人员类别：</td>
	    		<td width="30%" class="dialogTd">
	    			${zdryVO.zdryZdryzbVO.zdrylbmc}
		    	</td>
		    </tr>
		    
		    </table>
 		<!-- 这里引用公用列管信息模块 -->
		<%@include file="/WEB-INF/pages/zdrygl/add/zdryLgLxInc.jsp"%>
	    		    	
	    </div>
    </form>
    
</div>
<script type="text/javascript" >
var fz='${zdryVO.zdrylbStr}';

function doInit(paramArray) {
	showGroup(fz);
}

function beforeSubmit() {
	
}

function afterSubmit() {
	parent.location.reload();
}
</script>
</html>