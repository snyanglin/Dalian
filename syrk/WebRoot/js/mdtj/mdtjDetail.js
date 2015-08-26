/**
 * 
 * @description:矛盾详情
 * @author: tian_chengwei@founder.com      
 * @date:2015-06-02
 * 
 * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */

$(document).ready(function(){
	$("#xxk").show();
    setInputReadonly('dwmc',true);//根据公安管下来控制文本框是分可以编辑，原来是false
		setInputReadonly('sfyjdm',true);
		setInputReadonly('yjr',true);
		setInputReadonly('jsr',true);
		setInputReadonly('mdlydm',true); 
		setInputReadonly('mdgxgsdm',true); 
		setInputReadonly('mdlx',true); 
		setInputReadonly('mdfssj',true);
		setInputReadonly('mdfsddmc',true);
		setInputReadonly('mdyy',true);
		
		setInputReadonly('mdxz',true);
		setInputReadonly('dwmc',true);
		setInputReadonly('sfyjdm',true);
		setInputReadonly('bz',true);  
	
});

function processFormater0(val, row, index) { // 自定义操作生成
	return    '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="queryDsr(this, '+index+')">查看</a>&nbsp;';
}
function processFormater1(val, row, index) { // 自定义操作生成
	return 	   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="queryTj(this, '+index+')">查看</a>&nbsp;';
}
function processFormater2(val, row, index) { // 自定义操作生成
	return 	   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="queryGz(this, '+index+')">查看</a>&nbsp;';
}
//查看当事人详细信息
function queryDsr(linkObject,index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var querytUrl = contextPath + '/dsrxxzb/dsrInfo';
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		var querytUrl = querytUrl + (querytUrl.indexOf('?') != -1 ? '&' : '?');
		var idField = opts.idField;
		querytUrl = querytUrl + idField + "=" + rowData[idField];
		datagridView(obj, 'viewWindow', null, {
			title : '当事人信息',
			url : querytUrl,
			width : 850,
			height : 360
		}, '详细数据!');
}
//查看调节详细信息1
function queryTj(linkObject,index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var querytUrl = contextPath + '/tjxxzb/queryTjxx';
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		var querytUrl = querytUrl + (querytUrl.indexOf('?') != -1 ? '&' : '?');
		var idField = opts.idField;
		querytUrl = querytUrl + idField + "=" + rowData[idField];
		datagridView(obj, 'viewWindow', null, {
			title : '调节信息',
			url : querytUrl,
			width : 850,
			height : 360
		}, '详细数据!');
}
//查看跟踪详细信息2
function queryGz(linkObject,index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var querytUrl = contextPath + '/gzjzqkzb/queryGzjzqkInfo';
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var opts = $('#' + datagrid_ID).datagrid("options");
		var rows = $('#' + datagrid_ID).datagrid('getData');
		var rowData = rows.rows[index];
		var querytUrl = querytUrl + (querytUrl.indexOf('?') != -1 ? '&' : '?');
		var idField = opts.idField;
		querytUrl = querytUrl + idField + "=" + rowData[idField];
		datagridView(obj, 'viewWindow', null, {
			title : '跟踪进度信息',
			url : querytUrl,
			width : 850,
			height : 360
		}, '详细数据!');
}
