<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>人员照片管理</title>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
	
    <form name="dataform" id="dataForm" action="<%=basePath%>zpfjPtryzp/save" method="post" enctype="multipart/form-data">
		<input type="hidden" name="ryid" value="${ryid}"/>
		<input type='hidden' name='lybm' value="${lybm}"/>
		<input type='hidden' name='lyid' value="${lyid}"/>
		<input type='hidden' name='lyms' value="${lyms}"/>

		<div data-options="region:'center', split:true" id="formDiv" style="width:100%; border-width: 0px;">
  		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
		   	<tr class="dialogTr">
			   	<td width="20%" class="dialogTd" align="right">上传人员照片：</td>
			   	<td width="80%" class="dialogTd" colspan="3"><input type="file" name="uploadFile" id="upload" style="width:500px;" class="easyui-validatebox" data-options="validType:['imgFile'],tipPosition:'left',required:true,invalidMessage:'请选择图片格式的文件！'" />
	    	</tr>
	    </table>
	    </div>
    </form>
    
</div>

<script type="text/javascript">
var isUploadFilePage = "1";  // 上传文件页面标志

function doInit(paramArray) {
}

function beforeSubmit() {
}

function afterSubmit() {
}

function successCloseWindow() {
}
function resetForm(){
	 document.forms["dataForm"].reset();
}
</script>
  
</body>
</html>