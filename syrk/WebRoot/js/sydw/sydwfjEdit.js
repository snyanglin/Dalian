//updateAuthor: [star]
var _p;
var isUploadFilePage = "1";  // 上传文件页面标志
var uploadCount = 1;
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
//增加一个附件 按钮事件
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
	var validTypeString = "";
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
	}else {
		countStr = "" + uploadCount;
	}
	var validTypeString = "";
	if (validType != "") {
		validTypeString = "validType:['"+ validType +"'],";
	}
	td.html(countStr + "、<input type=\"file\" id=\"upload"+ uploadCount +"\" name=\"uploadFile\" style=\"width:560px;\" class=\"easyui-validatebox\" data-options=\""+ validTypeString +"invalidMessage:'请选择图片格式的文件！',tipPosition:'left'\"/>");
	tr.append(td);
	$('#uploadTable').append(tr);
	$.parser.parse('#uploadTable');
}
//列表操作列
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
//刷新父页面的附件列表
function setFormDataToSpan(){
	parent.$("#fjxx_datagrid").datagrid("reload");
}