<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>工作纪实 - 照片附件管理</title>
</head>
<div class="easyui-layout" data-options="fit:true">
	<form action="<%=basePath%>gzjs/saveTmpImg" id="imgForm" name="imgForm" method="post" enctype="multipart/form-data">
	    <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table id="uploadTable" border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<input type="hidden" id="pk" name="id" value="${entity.id}" />
			<input type="hidden" id="gzjsid" name="gzjsid" />
			<input type="hidden" id="changedFileId" name="changedFileId" />
			<input type="hidden" id="totalUploadIdArray" name="totalUploadIdArray" />
	    	</table>
	    	<br/><br/>
			<input type="button" id="add_but" value="添加" onclick="upload_add('')" style="font: 9pt 宋体; color: #034277; background-color: #CDE1F9; border: #2E81E7 1px solid; height: 20px; width: 60px; cursor: pointer;">
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
//全局fileId数组
var totalUploadIdArray = new Array();

function selectFile(){
	//alert('select'+$('#uploadFile_'+trId).val());
}

window.onload = function(){
	//alert(window.top.document.head.children[41]);
	window.parent.addGzjsUploadEvent();
}
function changeFile(trId){
	//alert('change'+$('#previewImg_'+trId).attr('src'));
	var newTrId = trId;
	if($('#previewImg_'+trId).attr('src').indexOf('/syrk/common/skin/images/sys_empty.gif') == -1){//非第一次选择文件
		newTrId = new Date().getTime().toString();
		totalUploadIdArray.push(newTrId);
		window.parent.totalUploadIdArray.push(newTrId);
	}
	var reg = new RegExp(trId, 'g');
	$("#uploadTable tr[id='tr_"+trId+"']").html().replace(reg, newTrId);
	$('#changedFileId').val(newTrId);
	//
	$('#uploadFileId_'+trId).val(newTrId);
	$('#totalUploadIdArray').val(totalUploadIdArray.join());
	$.parser.parse('#uploadTable');
	$('#imgForm').form('submit',{
		success:function(data){
			var reg = new RegExp('"', 'g');
			$('#previewImg_'+trId).attr('src', contextPath + data.replace(reg, ''));
			$('#changedFileId').val('');
		}
	});
}

function upload_add(trId) {
	if(trId == ''){
		trId = new Date().getTime().toString();
	}
	var tr = $('<tr id="tr_'+trId+'"></tr>');
	var td = $('<td width="40%" class="dialogTd" align="right"></td>');
	var validTypeString = ""
	td.html("<input type=\"file\" id=\"uploadFile_"+trId+"\" name=\"cmfile\" style=\"width:200px;\" class=\"easyui-validatebox\" onChange=\"changeFile("+trId+");\" onSelect=\"selectFile();\"/>"+
	"<input type=\"hidden\" id=\"uploadFileId_"+trId+"\" name=\"uploadFileId\" value=\""+trId+"\"/>");
	tr.append(td);
	td = $('<td width="40%" class="dialogTd" align="left"></td>');
	td.html("<img id=\"previewImg_"+trId+"\" width=\"150\" height=\"150\" align=\"left\" src=\"<%=contextPath%>/common/skin/images/sys_empty.gif\">");
	tr.append(td);
	td = $('<td width="20%" class="dialogTd" align="left"></td>');
	td.html("<input type=\"button\" id=\"delete_but\" value=\"删除\" onclick=\"upload_delete("+trId+")\" style=\"font: 9pt 宋体; color: #034277; background-color: #CDE1F9; border: #2E81E7 1px solid; height: 20px; width: 60px; cursor: pointer;\">");
	tr.append(td);
	$('#uploadTable').append(tr);
	$.parser.parse('#uploadTable');
	totalUploadIdArray.push(trId);
	window.parent.totalUploadIdArray.push(trId);
}

function upload_delete(trId){
	$("#uploadTable tr[id='tr_"+trId+"']").remove();
	$.parser.parse("#uploadTable");
}

function doInit(paramArray) {
	$('#gzjsid').val(paramArray['gzjsid']);
	
	var currIdList = ${currIdList};
	for(i in currIdList){
		if(currIdList.hasOwnProperty(i)){
			upload_add(currIdList[i]);
			$('#previewImg_'+currIdList[i]).attr('src', contextPath + '/tmpImg/' + currIdList[i]);
		}
	}
}

function beforeSubmit() {
	$('#totalUploadIdArray').val(totalUploadIdArray.join());
}

function afterSubmit(arr) {
	this.window.close();
	window.parent.isUploadSubmited = true;
}
</script>