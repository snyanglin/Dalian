$('#infotype').combobox({
	onSelect: function(rec){
		if(rec.value=='公告'){
			$("#toolurl").attr("disabled","disabled");
			$("#filespan").show();
			$("#toolspan").hide();
			$('#showtitle').html('公告标题：');
		}
		if(rec.value=='提示'){
			$("#toolurl").attr("disabled","disabled");
			$("#filespan").hide();
			$("#toolspan").hide();
			$('#showtitle').html('提示标题：');
		}
		if(rec.value=='工具'){
			$("#toolurl").removeAttr("disabled");
			$("#filespan").hide();
			$("#toolspan").show();
			$('#showtitle').html('工具标题：');
		}
	}
});


function dgOnCheck(rowIndex,rowData){
	dgchange();
}
function dgOnUncheck(rowIndex,rowData){
	dgchange();
}
function dgOnCheckAll(rows){
	dgchange();
}
function dgOnUncheckAll(rows){
	dgchange();
}
function dgchange(){
	var rows = $('#appdg').datagrid('getSelections');
	var ids = "" ;
	for(var i=0; i<rows.length; i++){
   		 ids+=rows[i].id+",";
    }
    $('#appids').val(ids.substring(0,ids.length-1));
}
//编辑页面载入时执行
function dgOnLoadSuccess(row){
	var rowData = row.rows;  
    $.each(rowData,function(idx,val){//遍历JSON   
      if(val.status==1){  
          $("#appdg").datagrid("selectRow", idx);//如果数据行为已选中则选中改行   
          $("#appdg").datagrid("checkRow", idx);
       } 
    });
    dgchange();
}

//附件列表格式化操作列
function rowFormaterFile(val,row,index) {
	return '&nbsp;<a href="javascript:javascript:void(0)" onclick="removeFile(this, '+index+')">删除</a>&nbsp;<input type="hidden" name="files[]" value="'+row.id+'" />';
}
//删除附件
function removeFile(elem, index){
	$('#filelists').datagrid('deleteRow', index);
	var rows = $('#filelists').datagrid('getData');
	$('#filelists').datagrid({data:rows,url:''});
}
//表单提交后执行
function MyafterSubmit(result) {}
//表单提交前执行
function MybeforeSubmit() {
	var files_str = '';
	$('#myform').find('input[name="files[]"]').each(function(index, element) {
        files_str += (index==0?'':',')+$(this).val();
    });
	$('#fileids').val(files_str);
}
//获取文件后缀


var formid = plupload.guid();
$('#formid').val(formid);
var uploader = new plupload.Uploader({
	runtimes : 'html5,flash,silverlight,html4',
	file_data_name : 'file', //附件提交字段名
	browse_button : 'pickfiles', // you can pass in id...
	//container: document.getElementById('container'), // ... or DOM Element itself
	url : basePath+'/InformationController/doFile', //附件提交的地址
	flash_swf_url : '../js/libs/plupload/Moxie.swf',
	silverlight_xap_url : '../js/libs/plupload/Moxie.xap',
	
	filters : {
		max_file_size : '10mb', //文件大小限制
		mime_types: [
			{title : "Image files", extensions : "jpg,gif,png"},
			{title : "Zip files", extensions : "zip,rar,gzip,7z"},
			{title : "Office files", extensions : "doc,docx,xls,xlsx"}
		]
	},

	init: {
		PostInit: function() {},
		FilesAdded: function(up, files) {
			plupload.each(files, function(file) {
				/*var _data = {fileid:file.id,filename:file.name,filesize:plupload.formatSize(file.size),fileformat:file.type,status:file.status};
				$('#filelists').datagrid('appendRow', _data);*/
			});
			uploader.start();
		},
		BeforeUpload:function(up, file) {
			up.setOption('multipart_params', {
				formid : formid,
				fileid : file.id
			});
			Cmessager.progress({
                title:'附件上传',
                msg:file.name+' 正在上传...'
            });
		},
		UploadProgress: function(up, file) {
			//document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
		},
		FileUploaded: function(up, file, info) {
			// Called when a file has finished uploading
			Cmessager.progress('close');
			var response = eval('('+info.response+')');
			if(response.status == 'success') {
				var _data = {id:file.id,filename:file.name,filesize:plupload.formatSize(file.size).toUpperCase(),fileformat:file.type,status:file.status};
				$('#filelists').datagrid('appendRow', _data);
			} else {
				Cmessager.alert(GV.MESSAGER_TITLE, response.message, 'error');
			}
		},
		UploadComplete:function(up, file) {
			Cmessager.progress('close');
		},
		Error: function(up, err) {
			Cmessager.progress('close');
			Cmessager.alert(GV.MESSAGER_TITLE, "\nError #" + err.code + ": " + err.message, 'error');
			//document.getElementById('console').innerHTML += "\nError #" + err.code + ": " + err.message;
		}
	}
});
uploader.init();