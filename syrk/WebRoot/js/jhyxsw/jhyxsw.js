/**
 * 
 * @description:集会游行示威
 * @author: tian_chengwei@founder.com   
 * @date:2015-06-02
 * 
 * @review      :wu.w@founder.com.cn
@reviewDate  : 20150604
 */
	//根据是当前用户机构判断是否查看编辑
function processFormater(val, row, index) { // 自定义操作生成
	var msg = "";
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	if (row.xt_lrrbmid == zzjgdm) {
		msg += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="editJhyxsw(this,'
				+ index + ')">编辑</a>&nbsp;'
	}
	msg += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="detailJhysxs(this, '
			+ index + ')">详细</a>&nbsp;';
	return msg;
}
//重置表单
function clearCase() {
	$("#queryForm").form("reset");
}
//下载
function uploadFile() {
	uploadFileView('JHYXSW_JBXXB', 'JHYXSW_JBXXB', '1', '');
}
// 附件上传
function fileUpload() {
	uploadFileEdit('JHYXSW_JBXXB', 'JHYXSW_JBXXB', '集会游行示威', '', '1', '1',
			'集会游行示威')
}

//查看详情
function detailJhysxs(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var queryUrl = contextPath + "/jhyxswjbxxb/queryJhyxswjbxxb";
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var queryUrl = queryUrl + (queryUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	queryUrl = queryUrl + idField + "=" + rowData[idField];
	window.open(queryUrl,"详情","height=1054,width=1024,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}

//查询按钮
function queryButton() {
	var xm = $("#xm").val();
	var kssj = $("#kssj").val();
	var jssj = $("#jssj").val();
	var hdfsdm = $("#hdfsdm").val();

	$('#dg').datagrid('reload', {
		'xm' : xm,
		'kssj' : kssj,
		'jssj' : jssj,
		'hdfsdm' : hdfsdm

	});
}
//添加集会
function jhyxswAdd() {
	var addUrl = "/jhyxswjbxxb/addJhyxswjbxxb?mainTabID=" + getMainTabID();
	menu_open("集会游行示威添加", addUrl);
}
//修改
function editJhyxsw(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = "/jhyxswjbxxb/addJhyxswjbxxb?mainTabID=" + getMainTabID();
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	menu_open("集会游行示威添加", editUrl);
}
//重载页面
function reloadDg() {
	$("#dg").datagrid("clearSelections");
	$('#dg').datagrid('reload');
}