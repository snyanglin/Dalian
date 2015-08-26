 //@updateAuthor: [star]
function doInit(paramArray) {
	parentGrid = paramArray['_p'];
}

$(document).ready(function(){
	$('#panel_center').find('div.panel-body').css('border', 'none');
});
var parentGrid;
//默认选中第一条数据
function dgLoadSuccess(data){
	var rows = data.rows;
	if(rows.length > 0){
		$('#cyryxxbDetailGrid').datagrid('selectRow', 0);
	}
}

//[从业人员详细信息]数据提取
function sadwExtractor(data){
	{
		/***返回值***/
		var returnValue = '';
		if(data != null && data != undefined){
			var tempValue;
			tempValue = '<p>' + data.dwmc + '</p>' +
			'单位性质：' + list[i].dwxzdm + '&nbsp;&nbsp;&nbsp;' + 
			'单位类型：' + list[i].dwlxdm + '&nbsp;&nbsp;&nbsp;' + 
			'注册资金：' + list[i].zczj + '<br>' + 
			'主管部门：' + list[i].zgbm + '&nbsp;&nbsp;&nbsp;' +
			'营业执照号：' + list[i].yyzzh + '<br>' +
			'经营期限：：' + list[i].jyqxqrq + '&nbsp;' + '至' + '&nbsp;' + list[i].jyqxzrq + '<br><br>';
			returnValue += tempValue;
		}
		return returnValue;
	}
}
function import_cyryxxb(){
	var url = contextPath + '/cyrydrrwxxb/createPage?dwid='+dwid;
	openWindow(false, 'cyry_import_win', url, null, {title:'导入任务列表', width:720, height:600});
	
}

function export_cyryxxb(){
	location.href=contextPath+'/sydwgl/cyryxxb_export?dwid='+dwid;
}
//添加从业人员
function add_cyryxxb(){
	window.top.openWindowWithSaveNext(false, null, window, 
 		{}, 
 		{
 		title: '从业人员新增',
 		url: contextPath+'/cyryxxb/createPage?dwid='+dwid,
 		width: 880,
 		inline:true,
 		height:500
 		}, 
 		null, 'afterSubmitSuccess',null
 	);
}

function afterSubmitSuccess(){
	$('#cyryxxbDetailGrid').datagrid('reload');
	parentGrid.datagrid('reload');
}

//显示从业人员详细信息
function loadCyryDetail(rowIndex, rowData){
	$('#text_pyrq').html(rowData.pyrq);
	$('#text_sfzh').html(rowData.zjhm);
	$('#text_xm').html(rowData.xm);
	if(rowData.xbdm == '1'){
		$('#text_xbdm').html('男');
	}else if(rowData.xbdm == '0'){
		$('#text_xbdm').html('女');
	}
	$('#text_csrq').html(rowData.csrq);
	$('#text_dz_xzzxz').html(rowData.dz_xzzxz);
	document.getElementById("img_cyry_photo").src = contextPath+"/zpfjPtryzp/queryPtryzpSingle.jpg?ryid="+rowData.ryid+"&zjhm="+rowData.zjhm+"&cyzjdm="+rowData.cyzjdm;
}

//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	var ophtml = "";
	if($('#mode_').val()=="view"){
		ophtml = '<a class="link" href="javascript:void(0)" onclick="doView(\'cyryxxb/createPage\',\'从业人员-'+row.xm+'\',\''+row.id+'\')">详情</a>&nbsp;';
	}else{
		ophtml = '<a class="link" href="javascript:void(0)" onclick="doEdit(this,'+index+')">修改</a>&nbsp;'+
		   		 '<a class="link" href="javascript:void(0)" onclick="doCancel(this,'+index+')">注销</a>';
		
	}
	return ophtml;
}

//查看单条
function doView(url,title,id) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	window.top.openWindowNoSave(false, null, window, 
 		{}, 
 		{
 		title: title,
 		url: contextPath+'/'+url+'?id='+id,
 		width: 880,
 		inline:true,
 		height:500
 		}, 
 		null, null,null
 	);
	
}

//编辑【从业人员】
function doEdit(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	window.top.openWindowWithSave(false, null, window, 
 		{}, 
 		{
 		title: '修改 从业人员',
 		url: contextPath+'/cyryxxb/createPage?dwid='+dwid+'&id='+$('#cyryxxbDetailGrid').datagrid('getData').rows[index].id,
 		width: 880,
 		inline:true,
 		height:500
 		}, 
 		null, 'afterSubmitSuccess',null
 	);
}

//注销【从业人员】
function doCancel(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/cyryxxb/delete';
	topMessager.confirm('','您确认要注销数据吗？',function(r) {  
		if (r) {	
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: {id:$('#cyryxxbDetailGrid').datagrid('getData').rows[index].id}
			}).done(function(result) {
				$('#cyryxxbDetailGrid').datagrid('reload');
				parentGrid.datagrid('reload');
			});
		}
	});
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
