/**
 * @Author:       [yu_guangli@founder.com.cn]
 * @CreateDate:   [2015-6-6 上午8:51:54]
 */
function processFormater1(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this, '+index+')">编辑</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">删除</a>&nbsp;';
}

function processFormater3(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doManageItem(this, '+index+')">管理</a>&nbsp;';
}

// 行单击
function doOnClickRow(rowIndex, rowData) {
	var editUrl = contextPath + '/dwjctemp/editDwjctype';
	var opts = $(this).datagrid('options');
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	datagridEdit(opts.id, 'editWindow', 
   		null,
  		{
   		title: '单位检查类目修改',
   		url: editUrl,
   		width: 850,
   		height: 320
   		}
   	);
}

// 修改单条
function doEdit(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = contextPath + '/dwjctemp/editDwjctype';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	datagridEdit(datagrid_ID, 'editWindow', 
   		null,
  		{
   		title: '单位检查类目修改',
   		url: editUrl,
   		width: 850,
   		height: 320
   		},
   		'您是否要保存数据？'
   	);
}

// 删除单条
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/dwjctemp/deleteDwjctype';
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
				data: postData
			}).done(function(result) {
				doSubmitResult(result, null, datagrid_ID);
			});
		}
	});
}

// 字典项管理
function doManageItem(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = contextPath + '/forward/sydw|dwjcdata';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + "typeid=" + rowData[idField];
	datagridView(datagrid_ID, 'itemWindow', 
   		null,
  		{
   		title: '单位检查项管理：' + rowData['name'],
   		url: editUrl,
   		width: 850,
   		height: 420
   		}
   	);
}

function queryButton() {
	var data = {};
	data["name"] = $("#name").val();
	data["ywlbdm"] = $("#ywlbdm").val();
	data["sydwlx"] = $("#sydwlx").val();
	$("#dg").datagrid("load", data);	
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}
//预览
function preview(){
	var sydwlxdm = $("#sydwlx").val();
	var sydwlx = $("#sydwlx-box").combotree("getText");
	var ywlbdm = $("#ywlbdm").val();
	if (sydwlxdm=="") {
		topMessagerAlert('', '请选择要预览的单位类型！');
		return;
	}
	var editUrl = contextPath + '/dwjctemp/queryDwjcTemp';
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	editUrl = editUrl + "sydwlx=" + sydwlxdm +"&ywlbdm="+ywlbdm;
	datagridView('dg', 'itemWindow', 
   		null,
  		{
   		title: '单位检查模板预览：' + sydwlx,
   		url: editUrl,
   		width: 700,
   		height: 520
   		}
	);
}