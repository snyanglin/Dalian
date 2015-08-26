//@updateAuthor: [star]
var parentGrid;
function doInit(paramArray) {
	parentGrid = paramArray['_p'];
}

$(document).ready(function(){
	$('#panel_center').find('div.panel-body').css('border', 'none');
});

//默认选中第一条数据
function dgLoadSuccess(data){
	var rows = data.rows;
	if(rows.length > 0){
		$('#baryxxbDetailGrid').datagrid('selectRow', 0);
	}
}
//添加保安员
function add_baryxxb(){
	window.top.openWindowWithSave(false, null, window, 
   		{}, 
   		{
   		title: '保安员新增',
   		url: contextPath+'/dwxyaqxxbBay/createPage?dwid='+dwid,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}


function afterSubmitSuccess(){
	$('#baryxxbDetailGrid').datagrid('reload');
	parentGrid.datagrid('reload');
}

//显示保安员详细信息
function loadBaryDetail(rowIndex, rowData){
	$('#text_sfzh').html(rowData.zjhm);
	$('#text_lxdh').html(rowData.lxdh);
	$('#text_xm').html(rowData.xm);
	if(rowData.xbdm == '1'){
		$('#text_xbdm').html('男');
	}else if(rowData.xbdm == '2'){
		$('#text_xbdm').html('女');
	}
}

//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
var ophtml = "";
	if($('#mode_').val()=="view"){
		ophtml = '<a class="link" href="javascript:void(0)" onclick="doView(\'dwxyaqxxbBay/createPage\',\'保安员-'+row.xm+'\',\''+row.id+'\')">详情</a>&nbsp;';
	}else{
		ophtml = '<a class="link" href="javascript:void(0)" onclick="doEdit(this,'+index+')">修改</a>&nbsp;'+
		   		 '<a class="link" href="javascript:void(0)" onclick="del_bayInfo(\''+row.id+'\',\'baryxxbDetailGrid\',\'info_bayxxb\')">注销</a>&nbsp;'+
				 '<a class="link" href="javascript:void(0)" onclick="barycyqkxxb(this,'+index+')">从业情况</a>&nbsp;';
	}
	return ophtml;
};

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
};
//编辑【保安员】
function doEdit(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	window.top.openWindowWithSave(false, null, window, 
   		{}, 
   		{
   		title: '修改 保安员',
   		url: contextPath+'/dwxyaqxxbBay/createPage?dwid='+dwid+'&id='+$('#baryxxbDetailGrid').datagrid('getData').rows[index].id,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}


//保安员从业情况添加
function barycyqkxxb(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	window.top.openWindowWithSave(false, null, window, 
 		{}, 
 		{
 		title: '保安员从业情况信息',
 		url: contextPath+'/dwbaycyqkxxb/createPage?dwid='+dwid+'&id='+$('#baryxxbDetailGrid').datagrid('getData').rows[index].id,
 		width: 880,
 		inline:true,
 		height:500
 		}, 
 		null, 'afterSubmitSuccess',null
 	);
}

//注销【保安员】
function doCancel(dwid,datagrid,url){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/sydwgl/calcle_xxzsnrb';
	topMessager.confirm('','您确认要注销数据吗？',function(r) {  
		if (r) {	
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: {id:dwid,url:url}
			}).done(function(result) {
				$('#'+datagrid).datagrid('reload');
				parentGrid.datagrid('reload');
			});
		}
	});
}

//注销【保安员】
function del_bayInfo(dwid,datagrid,url){
	window.top.openWindowWithSave(false, null, window, 
		{}, 
   		{
   		title: '注销记录',
   		url: contextPath + '/sydwgl/delete_xxzsnrb?id='+dwid + '&url=' +url,
   		width: 880,
   		height:200
   		}, 
   		null,'afterSubmitSuccess',null
   	);
}

//按下enter,清空
function setDzqc(obj){
	obj.value="";
}

//查询
function searchMain(){
	var condition = document.getElementById("condition").value;
	if(condition=="请输入保安员姓名、身份证号"){
		condition="";
	}
	$('#baryxxbDetailGrid').datagrid('load',{condition:condition});
	$('#baryxxbDetailGrid').datagrid("clearSelections");
}