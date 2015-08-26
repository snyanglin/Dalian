/**
 * @Author:       [wu.w@founder.com.cn]
 * @CreateDate:   [2015-5-15 上午8:51:54]
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
/*
 * 格式化操作单元格
 * val 字段值
 * row 行记录数据
 * index 行索引
 * return operate context
 */
function processFormater(val, row, index) { 
	var ope = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="view('+index+')">详情</a>&nbsp;';
	if(row.xt_lrrbmid==zzjgdmPd){
		ope += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="edit('+index+')">修改</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="del('+index+')">注销</a>&nbsp;';
	}
	return ope;
}

/*
 * 修改活动信息
 * index 行索引 
 */
function edit(index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = basePath+"dxqzxhdspl/edit?hdid="+rowData.hdid+"&mainTabID="+getMainTabID()+"&mode=edit";
	openTabPage("大型群众性活动-审批类-编辑－" + rowData.hdmc,editUrl);
}

/*
 * 查看活动信息
 * index 行索引 
 */
function view(index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = basePath+"dxqzxhdspl/edit?hdid="+rowData.hdid+"&mainTabID="+getMainTabID()+"&mode=view";
	openTabPage("大型群众性活动-审批类-查看－" + rowData.hdmc,editUrl);
}

/*
 * 注销单条
 * index 行索引 
 */
function del(index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var datagrid_ID = 'dg';
	topMessager.confirm('', '您确认要注销数据吗？', function(r) {
		if (r) {
			var opts = $('#' + datagrid_ID).datagrid("options");
			var rows = $('#' + datagrid_ID).datagrid('getData');
			var rowData = rows.rows[index];
			$.ajax({
				url : contextPath + '/dxqzxhdspl/delete',
				type : 'POST',
				data : {'hdid':rowData.hdid}
			}).done( function(result) {
				doSubmitResult(result, null, datagrid_ID);
			});
		}
	});
}

/*
 * 新增活动信息
 */
function add(){
	var hsUrl = basePath+"dxqzxhdspl/edit?hdid=&mainTabID="+getMainTabID()+"&mode=add";
	openTabPage("大型群众性活动-审批类-新增",hsUrl);
}

/*
 * 活动文书下载
 */
function fileDownload(){
	uploadFileView('DXQZXHDSPL_JBXXB','WSXZ','0','');
}

/*
 * 查询按钮
 */
function query() {
	$('#dg').datagrid('reload', {
		'hdlxdm' : $('#hdlxdm').combobox('getValue'),
		'hdxzdm' : $('#hdxzdm').combobox('getValue'),
		'hdmc' : $('#hdmc').val(),
		'cljgdm' : $('#cljgdm').combobox('getValue'),
		'hdkssj' : $('#hdkssj').val(),
		'hdkssjjz' : $('#hdkssjjz').val(),
		'hdjssj' : $('#hdjssj').val(),
		'hdjssjjz' : $('#hdjssjjz').val()
	});
}

/*
 * 重置查询条件
 */
function resetQuery(){
	  $("#queryForm").form("reset");
}

/*
 * 新开tab页
 */
function openTabPage(menuName, openURL) {
	menu_open(menuName, openURL);
	window.parent.$('#' + windowID).window('close');
}

/*
 * 重载表格
 */
function reloadDg(){
	$("#dg").datagrid("clearSelections");
	$('#dg').datagrid('reload');
}

/*
 * 活动模板文书上传
 */
function fileUpload(){
	openWindowWithSave(false, null, window, null,{
	   		title: '大型群众性活动审批类-文书上传',
	   		url: contextPath+"/dxqzxhdspl/uploadWS",
	   		width: 880,
	   		height:500
   		}, null,null,null
   	);
}