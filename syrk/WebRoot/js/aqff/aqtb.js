/**
 * @Author:       [wu.w@founder.com.cn]
 * @CreateDate:   [2015-5-15 上午8:51:54]
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
/*
 * init edit window
 */
initEditWindow();
function initEditWindow(){
	$('#editDiv').window({    
	    width:820,    
	    height:300,
	    modal:true
	});
	$('#editDiv').window('close');
}

/*
 * 格式化操作单元格
 * val 字段值
 * row 行记录数据
 * index 行索引
 * return operate context
 */
function processFormater(val, row, index) { // 自定义操作生成
	var ope= '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="view('+index+')">详情</a>&nbsp;';
	var up='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="uploadFj('+index+')">附件上传</a>&nbsp;';
	var down='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="downloadFj('+index+')">附件下载</a>&nbsp;';
	if(row.xt_lrrbmid==zzjgdmPd){
		return ope+up+down+'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="edit('+index+')">修改</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="del('+index+')">注销</a>&nbsp;';
	}else{
		return ope+down;
	}
}

/*
 * save info
 */
function save(){
	$('#editForm').form({    
	    url:contextPath + '/aqffzatb/edit',
	    onSubmit: function(){    
	    	if(!$('#editForm').form('validate')){
	    		return false;
	    	}
	    },    
	    success:function(result){    
	        doSubmitResult(result, null, 'dg');
	        $('#editDiv').window('close');
	    }    
	});
	$('#editForm').submit(); 
}

/*
 * delete info
 */
function del(index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	topMessager.confirm('', '您确认要注销数据吗？', function(r) {
		if (r) {
			var rows = $('#dg').datagrid('getData');
			var rowData = rows.rows[index];
			$.ajax({
				url : contextPath + '/aqffzatb/delete',
				type : 'POST',
				data : {'id':rowData.id}
			}).done( function(result) {
				doSubmitResult(result, null, 'dg');
			});
		}
	});
}

/*
 * open add window
 */
function openEditWin(){
	controlEditReadonly(false);
	$('#eid').val('');
	resetEdit();
	$('#efbdw').val(userOrgName);
	$('#editDiv').window({title:'新增'});
	$('#editDiv').window('open');
}

/*
 * open modify window
 */
function edit(index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	controlEditReadonly(false);
	initEditInfo(index);
	$('#editDiv').window({title:'修改'});
	$('#editDiv').window('open');
}

/*
 * view info
 */
function view(index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	controlEditReadonly(true);
	initEditInfo(index);
	$('#editDiv').window({title:'查看'});
	$('#editDiv').window('open');
}

/*
 * control readonly
 */
function controlEditReadonly(b){
	setInputReadonly('etbrq',b);
	setInputReadonly('etbqh',b);
	setInputReadonly('etbbt',b);
	setInputReadonly('efbdw',b);
	setInputReadonly('efbfs',b);
	setInputReadonly('etbnr',b);
	if(b){
		$('#edit_btn_div').find('a').linkbutton('disable');
		$('#efbdw_selbtn').hide();
	}else{
		$('#edit_btn_div').find('a').linkbutton('enable');
		$('#efbdw_selbtn').show();
	}
}

/*
 * init edit info
 * index 数据索引
 */
function initEditInfo(index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	resetEdit();
	$('#eid').val(rowData.id);
	$('#etbrq').val(rowData.tbrq);
	$('#etbqh').val(rowData.tbqh);
	$('#etbbt').val(rowData.tbbt);
	$('#efbdw').val(rowData.fbdw);
	$('#efbfs').val(rowData.fbfs==0?'':rowData.fbfs);
	$('#etbnr').val(rowData.tbnr);
	$("#editForm").form("validate");
}

/*
 * reset
 */
function resetEdit(){
	$("#editForm").form("reset");
}

/*
 * upload fj
 */
function uploadFj(index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	openWindowWithSave(false, null, window, 
   		null, 
   		{
	   		title: '上传附件',
	   		url: contextPath+"/aqffzatb/uploadFj?id="+rowData.id,
	   		width: 880,
	   		height:500
   		}, 
   		null,null,null
   	);
}

/*
 * download fj
 */
function downloadFj(index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	uploadFileView('AQFF_XC_ZATBXXB',rowData.id,'0','');
}

/*
 * query
 */
function query() {
	$('#dg').datagrid('reload', {
		'tbrq' : $('#qtbrq').val(),
		'tbqh' : $('#qtbqh').val(),
		'fbdw' : $('#qfbdw').val(),
		'tbbt' : $('#qtbbt').val()
	});
}

/*
 * reset
 */
function resetQuery(){
	$("#queryForm").form("reset");
}

/*
 * datagrid reload
 */
function reloadDg(){
	$("#dg").datagrid("clearSelections");
	$('#dg').datagrid('reload');
}