//@updateAuthor: [star]
var parentGrid;
function doInit(paramArray) {
	parentGrid = paramArray['_p'];
}

$(document).ready(function(){
	
});

function export_cyryxxb(){
	location.href=contextPath+'/cyrydrrwmxb/export?rwid='+rwid;
}

//显示从业人员详细信息
function loadCyryDetail(rowIndex, rowData){
	$('#text_pysj').html(rowData.pysj);
	$('#text_sfzh').html(rowData.zjhm);
	$('#text_xm').html(rowData.xm);
	if(rowData.xbdm == '1'){
		$('#text_xbdm').html('男');
	}else if(rowData.xbdm == '2'){
		$('#text_xbdm').html('女');
	}
	$('#text_csrq').html(rowData.csrq);
	$('#text_dz_xzzxz').html(rowData.dz_xzzxz);
	document.getElementById("img_cyry_photo").src = contextPath+"/zpfjPtryzp/queryPtryzpSingle.jpg?ryid="+rowData.cyrwid+"&zjhm="+rowData.zjhm+"&cyzjdm=111";
}

//性别formatter
function xb_formatter(value, rowData, rowIndex){
	if(value == '1'){
		return '男';
	}else if(value == '2'){
		return '女';
	}else{
		return '其他';
	}
}

function drjg_formatter(value, rowData, rowIndex){
	if(value == '1'){
		return '<font color="green">成功</font>';
	}else if(value == '2'){
		return '<font color="yellow">警告</font>';
	}else{
		return '<font color="red">失败</font>';
	}
	
}
//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	 if(row.cyrwid==''){
		return '导入失败';
		 }
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this,'+index+')">查看</a>&nbsp;';
}

//修改单条
function doEdit(linkObject, index) {
	var rows = $('#cyryxxbDetailGrid').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/syrkgl/view?id="+rowData.ryid+"&jzdzdm="+rowData.dz_xzzdm+"&zdryid="+"&jzdzzbid="+rowData.ryid;
	menu_open("实有人口－" + rowData.xm,editUrl);
}

//按下enter,清空
function setDzqc(obj){
	obj.value="";
}

//查询
function searchMain(){
	var condition = document.getElementById("condition").value;
	if(condition=="请输入从业人员姓名、身份证号"){
		condition="";
	}
	$('#cyryxxbDetailGrid').datagrid('load',{condition:condition});
	$('#cyryxxbDetailGrid').datagrid("clearSelections");
}