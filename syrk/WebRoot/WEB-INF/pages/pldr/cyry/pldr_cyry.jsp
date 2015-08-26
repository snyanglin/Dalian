<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>从业人员</title>
</head>
<body>
	<form action="<%=basePath%>pldr/cyry/CyryUpload" method="post" enctype="multipart/form-data" style="">

			<br><span style="font-size: 30">请选择您的单位：</span><br><br>
			<input type="text" id="fwcs-box" name="fwcs-box" value="${entity.fwcs}" 
				class="easyui-combobox" style="width:613px;" maxlength="100" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:true"   />
		
			<br><span style="font-size: 30">请选择您需要导入的excel：</span><br><br>
			<input id="excel" class="easyui-validatebox" validType="fileType['xls']" required="true" invalidMessage="请上传97-2003兼容模式标准excel" type="file" name="file" style="width: 613px;"/>
		
			<br><span style="font-size: 30">请选择您需要导入的RAR：</span><br><br>
			<input id="rar" class="easyui-validatebox" type="file" name="file2" required="true" style="width: 613px;">
			<input type="hidden" id="fwcs" name="fwcs" value="${entity.fwcs}"/>
			<input type="hidden" id="dwid" name="dwid" value="${entity.dwid}"/>
		
			<p align="center">
			<a href="javascript:;"  class="easyui-linkbutton" icon="icon-save" onclick="check();">提交</a>
			<a href="javascript:;"  class="easyui-linkbutton" icon="icon-cancel" onclick="cancel();">取消</a></p>
	</form>
</body>
</html>
<script type="text/javascript" >
$(document).ready(function(){
	initDepartmentSearch('fwcs-box', {glpcsid: ''}, 'dwid', 'fwcs', {});
});
function check(){
	if ($("#dwid").val()!="") {
		//上传后关闭
		document.forms[0].submit();
	}
}
function cancel(){
	document.forms[0].reset();
}
</script>