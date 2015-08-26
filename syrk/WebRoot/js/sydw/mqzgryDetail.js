//updateAuthor: [star]
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
		$('#mqzgryDetailGrid').datagrid('selectRow', 0);
	}
}

//添加民爆项目业绩
function add(){
	window.top.openWindowWithSaveNext(false, null, window, 
   		{}, 
   		{
   		title: '民枪专管人员新增',
   		url: contextPath+'/dwownsydw/editbMqzgry?dwid='+dwid,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}
//民枪专管人员回调函数
function afterSubmitSuccess(){
	$('#mqzgryDetailGrid').datagrid('reload');
	parentGrid.datagrid('reload');
}

//显示民枪专管人员信息
function loadMqzgryDetail(rowIndex, rowData){
	$('#text_xm').html(rowData.xm);
	$('#text_zjhm').html(rowData.zjhm);
	$('#text_lxdh').html(rowData.lxdh);
	$('#text_zz').html(rowData.zz);
	$('#text_spjg').html(rowData.spjg);
	$('#text_spr').html(rowData.spr);
	$('#text_sprq').html(rowData.sprq);
	$('#text_bz').html(rowData.bz);
}

//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
   	var ophtml = "";
	if($('#mode_').val()=="view"){
		ophtml = '<a class="link" href="javascript:void(0)" onclick="doView(\'dwownsydw/editbMqzgry\',\'民枪专管人员\',\''+row.id+'\')">详情</a>&nbsp;';
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

//编辑【民枪专管人员】
function doEdit(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	window.top.openWindowWithSave(false, null, window, 
   		{}, 
   		{
   		title: '修改 民枪专管人员',
   		url: contextPath+'/dwownsydw/editbMqzgry?dwid='+dwid+'&id='+$('#mqzgryDetailGrid').datagrid('getData').rows[index].id,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}

//注销【民枪专管人员】
function doCancel(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/dwownsydw/deleteMqzgry';
	topMessager.confirm('','您确认要注销数据吗？',function(r) {  
		if (r) {	
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: {id:$('#mqzgryDetailGrid').datagrid('getData').rows[index].id}
			}).done(function(result) {
				$('#mqzgryDetailGrid').datagrid('reload');
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
	if(condition=="请输入姓名、身份证号"){
		condition="";
	}
	$('#mqzgryDetailGrid').datagrid('load',{condition:condition});
	$('#mqzgryDetailGrid').datagrid("clearSelections");
}