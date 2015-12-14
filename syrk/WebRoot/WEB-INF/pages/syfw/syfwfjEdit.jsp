<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>附件管理</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/zpfjFjxxb/queryList',toolbar:'#datagridToolbar',rownumbers:true,
            		border:false,selectOnCheck:false,sortName:'xt_cjsj',sortOrder:'asc',idField:'id',pageSize:10,queryParams:{lybm:'${lybm}',lyid:'${lyid}'}">
				    <thead>
				        <tr>
				            <th data-options="field:'wjhzlx',width:10,align:'center',halign:'center',sortable:true">附件类型</th>
				            <th data-options="field:'wjmc',width:30,align:'left',halign:'center',sortable:true">附件名称</th>
				            <th data-options="field:'wjdx',width:10,align:'right',halign:'center',sortable:true">附件字节</th>
				            <th data-options="field:'wjdxsm',width:10,align:'center',halign:'center'">附件大小</th>
				            <th data-options="field:'wjxzcs',width:10,align:'center',halign:'center',sortable:true">下载次数</th>
				            <th data-options="field:'process',width:10,align:'center',halign:'center',formatter:processFormater">下载</th>
				        </tr>
				    </thead>
				</table>
				
				<div id="datagridToolbar" style="padding: 0px; height: 150px; width: 100%; vertical-align: top;">
					<form name="dataform" action="<%=basePath%>zpfjFjxxb/save" method="post" enctype="multipart/form-data">
					<input type='hidden' name='lybm' value="${lybm}"/>
					<input type='hidden' name='lyid' value="${lyid}"/>
					<input type='hidden' name='lyms' value="${lyms}"/>
					<input type='hidden' name='fileOnly' id='fileOnly' value="${fileOnly}"/>
          			<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tbody>
					<tr>
						<td width="20%" align="right" valign="top" class="dialogTd" style="padding-top: 13px; padding-right: 20px;">新上传的附件：
							<br/><br/>
							<input type="button" id="upload_add_but" value="增加一个附件" onclick="upload_add()" style="font: 9pt 宋体; color: #034277; background-color: #CDE1F9; border: #2E81E7 1px solid; height: 20px; width: 100px; cursor: pointer;">
						</td>
						<td width="80%" class="dialogTd" valign="top">
							<div style="overflow-y: auto; vertical-align: top; width: 100%; height: 150;" id="uploadDiv">
								<table border="0" cellpadding="0" cellspacing="0" width="100%" id="uploadTable">
				              	<tr>
				                 	<td height="30" class="dialogTd">01、<input type="file" name="uploadFile" id="upload1" style="width:560px;" class="easyui-validatebox" data-options="tipPosition:'left',invalidMessage:'请选择图片格式的文件！'" /></td></td>
				              	</tr>
				              	</table>
			              	</div>
						</td>
					</tr>
					</tbody>
					</table>
					</form>
				</div>
				
			</div>
        </div>
    </div>   
    
    <div style="display:none;">
	    <form name="downloadform" id="downloadform" action="<%=basePath%>zpfjFjxxb/download" target="submitFrame" method="post">
	    <input type="hidden" name="id" id="downloadID"/>
	    </form>
	</div>
	<iframe name="submitFrame" id="submitFrame" src="" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" width="0" height="0" style="z_index: 60; display:none;"></iframe>
	
</body>

<script type="text/javascript">
var _p;
var isUploadFilePage = "1";  // 上传文件页面标志
var uploadCount = 1;
var fileType = "${fileType}";
var validType = "";
if (fileType == "img") {
	validType = "imgFile";
}
	
function doInit(paramArray) {
	_p = paramArray["_p"];
	if (validType != "") {
		$('#upload1').validatebox({validType:[validType]});
	}
	if ($('#fileOnly').val() == "1") {
		$('#upload_add_but').hide();
	}
}

function beforeSubmit() {
	var addFlag = false;
	for (var i = 1; i <= uploadCount; i++) {
        if ($("#upload" + i).val() != "") {
			addFlag = true;
			break;
		}
	}
	if (!addFlag) {
		topMessager.alert('', '您没有选择有效的附件，无需上传！');
		return false;
	}
	return true;
}

function afterSubmit() {
	upload_clear();
	$('#dg').datagrid('reload');
	setFormDataToSpan();
}

function successCloseWindow() {
	return false;
}

function upload_add() {
	if (uploadCount == 20) {
		topMessager.alert('', '一次最多上传 20 个附件！');
		return;
	}
	uploadCount ++;
	var tr = $('<tr></tr>');
	var td = $('<td height="30" class="dialogTd"></td>');
	var countStr = "";
	if (uploadCount < 10) {
		countStr = "0" + uploadCount;
	}
	else {
		countStr = "" + uploadCount;
	}
	var validTypeString = ""
	if (validType != "") {
		validTypeString = "validType:['"+ validType +"'],";
	}
	td.html(countStr + "、<input type=\"file\" id=\"upload"+ uploadCount +"\" name=\"uploadFile\" style=\"width:560px;\" class=\"easyui-validatebox\" data-options=\""+ validTypeString +"invalidMessage:'请选择图片格式的文件！',tipPosition:'left'\"/>");
	tr.append(td);
	$('#uploadTable').append(tr);
	$.parser.parse('#uploadTable');
	$('#upload' + uploadCount).focus();
}

function upload_clear() {
	$('#uploadTable tr').remove();
	uploadCount = 1;
	var tr = $('<tr></tr>');
	var td = $('<td height="30" class="dialogTd"></td>');
	var countStr = "";
	if (uploadCount < 10) {
		countStr = "0" + uploadCount;
	}
	else {
		countStr = "" + uploadCount;
	}
	var validTypeString = ""
	if (validType != "") {
		validTypeString = "validType:['"+ validType +"'],";
	}
	td.html(countStr + "、<input type=\"file\" id=\"upload"+ uploadCount +"\" name=\"uploadFile\" style=\"width:560px;\" class=\"easyui-validatebox\" data-options=\""+ validTypeString +"invalidMessage:'请选择图片格式的文件！',tipPosition:'left'\"/>");
	tr.append(td);
	$('#uploadTable').append(tr);
	$.parser.parse('#uploadTable');
}

function processFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this, '+index+')">下载</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">删除</a>&nbsp;';
}

// 修改单条
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var idField = opts.idField;
	$('#downloadID').val(rowData[idField]);
	$('#downloadform').form('submit', {
		success: function(result) {
			if (result) {
				result = parseReturn(result);
				if (result.status == 'success') {
				}
				else {
					topMessager.alert('', result.message);
				}
			}
		}
	});
}

// 删除单条
function doDelete(linkObject, index) {
	
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/zpfjFjxxb/delete';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var submitFields = "csmc"; //  除主键之外需要提交的字段（多个用逗号分隔）
	topMessager.confirm('','您确认要删除数据吗？',function(r) {    
		if (r) {	
			var opts = $('#' + datagrid_ID).datagrid("options");
			var rows = $('#' + datagrid_ID).datagrid('getData');
			var rowData = rows.rows[index];
			var postFieldArray = [];
			postFieldArray.push(opts.idField);
			if (submitFields != "") {
				postFieldArray = postFieldArray.concat(submitFields.split(","));
			}
			var postData = {};
			for (var i = 0; i < postFieldArray.length; i++) {
				var postField = postFieldArray[i];
				if (rowData[postField]) {
					postData[postField] = rowData[postField];
				}
			}
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: postData,
				success:setFormDataToSpan
			}).done(function(result) {
				doSubmitResult(result, null, datagrid_ID);
			});
		}
	});
}

function setFormDataToSpan(){
	$.get(contextPath+'/syfw//fj/${lyid}/list',{fwid:'${lyid}'},function(d){
		$(_p).children('li').remove();
		$.each(d,function(i,item){
			var sb = new StringBuffer();
			sb.append("<ul>");
			sb.append("<li><span class='spantitle'>附件名称：</span><span name='wjmc' class='edit_word input_w2'><a href='javascript:void(0)' class='_fjxz' id='"+item.id+"'>"+item.wjmc+"</a></span></li>");
			sb.append("<li><span class='spantitle'>上传时间：</span><span name='xt_cjsj' class='edit_word input_w2'>"+item.xt_cjsj+"</span></li>");
			sb.append("<li class='uline2'></li>");
			sb.append("<input type='hidden' name='id' />");
			sb.append("</ul>");
			$(_p).append("<li>"+sb+"</li>");
			$(_p).css("display","");
		});
	},'json');
}
</script>  

</html>