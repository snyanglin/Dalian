/**
 * @Author:       [wu.w@founder.com.cn]
 * @CreateDate:   [2015-5-15 上午8:51:54]
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
/*
 * init dz
 */
initAddressSearch('edz', {}, null, 'hdz', null, null, null, null);

/*
 * init edit window
 */
initEditWindow();
function initEditWindow(){
	$('#editDiv').window({    
	    width:820,    
	    height:400,
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
	var ope = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="view('+index+')">详情</a>&nbsp;';
	if(row.xt_lrrbmid==zzjgdmPd){
		return ope+='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="edit('+index+')">修改</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="del('+index+')">注销</a>&nbsp;';
	}
	return ope;
}

/*
 * save info
 */
function save(){
	$('#editForm').form({    
	    url:contextPath + '/aqffxcjy/edit',
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
				url : contextPath + '/aqffxcjy/delete',
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
	$('#editDiv').window({title:'新增'});
	$('#editDiv').window('open');
}

/*
 * open update window
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
	setInputReadonly('excjyzt',b);
	setInputReadonly('excjynr',b);
	setInputReadonly('ekzrq',b);
	setInputReadonly('excjyxs',b);
	setInputReadonly('etrjf',b);
	setInputReadonly('ejyqzrs',b);
	setInputReadonly('ejydwsl',b);
	setInputReadonly('edz',b);
	setInputReadonly('ebz',b);
	if(b){
		$('#edit_btn_div').find('a').linkbutton('disable');
	}else{
		$('#edit_btn_div').find('a').linkbutton('enable');
	}
}

/*
 * init edit info
 */
function initEditInfo(index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	resetEdit();
	$('#eid').val(rowData.id);
	$('#excjyzt').val(rowData.xcjyzt);
	$('#excjynr').val(rowData.xcjynr);
	$('#ekzrq').val(rowData.kzrq);
	$('#excjyxs').combobox('select',rowData.xcjyxs);
	$('#etrjf').val(rowData.trjf==0?'':rowData.trjf);
	$('#ejyqzrs').val(rowData.jyqzrs==0?'':rowData.jyqzrs);
	$('#ejydwsl').val(rowData.jydwsl==0?'':rowData.jydwsl);
	$('#edz').combobox('setText',rowData.dz);
	$('#hdz').val(rowData.dz);
	$('#ebz').val(rowData.bz);
	$("#editForm").form("validate");
}

/*
 * reset 
 */
function resetEdit(){
	$("#editForm").form("reset");
}

/*
 * query
 */
function query() {
	$('#dg').datagrid('reload', {
		'xcjyzt' : $('#qxcjyzt').val(),
		'kzrq' : $('#qkzrq').val(),
		'xcjyxs' : $('#qxcjyxs').combobox('getValue'),
		'xt_lrrxm' : $('#qzrmj').val()
	});
}

/*
 * reset query
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