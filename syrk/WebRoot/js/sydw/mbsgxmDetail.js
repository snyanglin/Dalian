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
		$('#mbsgxmDetailGrid').datagrid('selectRow', 0);
	}
}


//添加民爆项目业绩
function add(){
	window.top.openWindowWithSaveNext(false, null, window, 
   		{}, 
   		{
   		title: '民爆项目实施业绩新增',
   		url: contextPath+'/dwownsydw/editbMbxmyj?dwid='+dwid,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}
//添加民爆项目业绩回调函数
function afterSubmitSuccess(){
	$('#mbsgxmDetailGrid').datagrid('reload');
	parentGrid.datagrid('reload');
}

//显示民爆项目实施业绩信息
function loadMbsgxmDetail(rowIndex, rowData){
	$('#text_xmjb').html(rowData.xmjb);
	$('#text_xmmc').html(rowData.xmmc);
	$('#text_bpsgrq').html(rowData.bpsgrq);
	$('#text_dysjr').html(rowData.dysjr);
}

//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
   	var ophtml = "";
	if($('#mode_').val()=="view"){
		ophtml = '<a class="link" href="javascript:void(0)" onclick="doView(\'dwownsydw/editbMbxmyj\',\'民爆项目实施业绩\',\''+row.id+'\')">详情</a>&nbsp;';
	}else{
		ophtml = '<a class="link" href="javascript:void(0)" onclick="doEdit(this,'+index+')">修改</a>&nbsp;'+
		   		 '<a class="link" href="javascript:void(0)" onclick="doCancel(this,'+index+')">注销</a>';
		
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

//编辑【民爆项目实施业绩】
function doEdit(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	window.top.openWindowWithSave(false, null, window, 
   		{}, 
   		{
   		title: '修改 民爆项目实施业绩',
   		url: contextPath+'/dwownsydw/editbMbxmyj?dwid='+dwid+'&id='+$('#mbsgxmDetailGrid').datagrid('getData').rows[index].id,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}

//注销【民爆项目实施业绩】
function doCancel(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/dwownsydw/deleteMbxmyj';
	topMessager.confirm('','您确认要注销数据吗？',function(r) {  
		if (r) {	
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: {id:$('#mbsgxmDetailGrid').datagrid('getData').rows[index].id}
			}).done(function(result) {
				$('#mbsgxmDetailGrid').datagrid('reload');
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
	if(condition=="请输入项目名称"){
		condition="";
	}
	$('#mbsgxmDetailGrid').datagrid('load',{condition:condition});
	$('#mbsgxmDetailGrid').datagrid("clearSelections");
}