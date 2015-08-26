$(document).ready(function(){
	
	var mode_ = $("#mode_").val();
 	if(mode_=="view"){
 		//$("#server_Menu").hide();
 		//$("a.info_editbtn").remove();
 		getServerMenu(1);
	}else{
 		$("a.editbtn").show();
		$("a.savebtn").click(save_view).click(toggleCyryBtn);
		$("a.info_editbtn").click(editEnable);
		$("a.editbtn").click(edit_view).click(toggleCyryBtn);
		getServerMenu(1);
		getServerMenu(2);
	}
	
	/***************固定事件注册，页面初始化**************************/
	
	$("a.up_btn").click(up_down);
	sylbIcon();
	$(".addphoto").click(addFile);
	iterateDict($("div.lf_conta").eq(1));

	$(".rt").show();
	$(".rt_view").hide();
		
	/**********自己定义方法*************************/
	//loadActivityTrace();
	//loadRelationMessage();
	
	document.getElementById("topPhotoid").src = contextPath+"/zpfjFjxxb/queryZpByLyid.jpg?id="+dwid;
	console.log(document.getElementById("topPhotoid").src);
	
});
//从业人员按钮隐藏或显示
function toggleCyryBtn(){
	$('#addCyryBtn').toggle();
	$('#importCyryBtn').toggle();
	$('#addBaryBtn').toggle();
}
//更多从业人员页面
function show_more_cyry(){
	var url = contextPath + '/sydwgl/cyryxxb_query_more?dwid='+dwid+'&mode='+$('#mode_').val();
	openWindow(false, 'show_more_cyry_win', url, {"_p":$("#cyry_datagrid")}, {title:'从业人员详细列表', modal:true, width:720, height:600});
}
//从业人员导入
function import_cyryxxb(){
	var url = contextPath + '/cyrydrrwxxb/createPage?dwid='+dwid;
	openWindow(false, 'cyry_import_win', url, null, {title:'导入任务列表', width:720, height:600});
}
//从工业人员导出
function export_cyryxxb(){
	location.href=contextPath+'/sydwgl/cyryxxb_export?dwid='+dwid;
}
//打开 从业人员新增页面
function add_cyryxxb(){
	openWindowWithSaveNext(false, null, window, 
   		{"_p":$("#cyry_datagrid")}, 
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
//从业人员保存成功后回调刷新
function afterSubmitSuccess(){
	$('#cyry_datagrid').datagrid('reload');
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
   		url: contextPath+'/cyryxxb/createPage?dwid='+dwid+'&id='+$('#cyry_datagrid').datagrid('getData').rows[index].id,
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
				data: {id:$('#cyry_datagrid').datagrid('getData').rows[index].id}
			}).done(function(result) {
				$('#cyry_datagrid').datagrid('reload');
			});
		}
	});
}

//民爆实施项目业绩操作列
function mbdatagridProcessFormater(val, row, index) { // 自定义操作生成
	var ophtml = "";
	if($('#mode_').val()!="view"){
		ophtml = '<a class="link" href="javascript:void(0)" onclick="doView(\'dwownsydw/editbMbxmyj\',\'实施项目业绩\',\''+row.id+'\')">详情</a>&nbsp;';
	}else{
		ophtml = '<a class="link" href="javascript:void(0)" onclick="mbdoEdit(this,'+index+')">修改</a>&nbsp;'+
		   		 '<a class="link" href="javascript:void(0)" onclick="mbdoCancel(this,'+index+')">注销</a>';
		
	}
	return ophtml;
};

//民枪专管人员操作列
function mqdatagridProcessFormater(val, row, index) { // 自定义操作生成
	var ophtml = "";
	if($('#mode_').val()!="view"){
		ophtml = '<a class="link" href="javascript:void(0)" onclick="doView(\'dwownsydw/editbMqzgry\',\'民枪专管人员\',\''+row.id+'\')">详情</a>&nbsp;';
	}else{
		ophtml = '<a class="link" href="javascript:void(0)" onclick="mqdoEdit(this,'+index+')">修改</a>&nbsp;'+
		   		 '<a class="link" href="javascript:void(0)" onclick="mqdoCancel(this,'+index+')">注销</a>';
		
	}
	return ophtml;
};

//编辑【民爆实施项目业绩】
function mbdoEdit(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	window.top.openWindowWithSave(false, null, window, 
   		{"_p":"#ssxmyj_datagrid"},
   		{
   		title: '修改 民爆项目实施业绩',
   		url: contextPath+'/dwownsydw/editbMbxmyj?dwid='+dwid+'&id='+$('#ssxmyj_datagrid').datagrid('getData').rows[index].id,
   		width: 780,
   		inline:true,
   		height:300
   		}, 
   		null, 'mbafterSubmitSuccess',null
   	);
};

//注销【民爆实施项目业绩】
function mbdoCancel(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/dwownsydw/deleteMbxmyj';
	topMessager.confirm('','您确认要注销数据吗？',function(r) {  
		if (r) {	
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: {id:$('#ssxmyj_datagrid').datagrid('getData').rows[index].id}
			}).done(function(result) {
				$('#ssxmyj_datagrid').datagrid('reload');
			});
		}
	});
};

//编辑【民枪专管人员】
function mqdoEdit(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	window.top.openWindowWithSave(false, null, window, 
   		{"_p":"#mqzgry_datagrid"},
   		{
   		title: '修改 民枪专管人员',
   		url: contextPath+'/dwownsydw/editbMqzgry?dwid='+dwid+'&id='+$('#mqzgry_datagrid').datagrid('getData').rows[index].id,
   		width: 780,
   		inline:true,
   		height:300
   		}, 
   		null, 'mqafterSubmitSuccess',null
   	);
};

//注销【民枪专管人员】
function mqdoCancel(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/dwownsydw/deleteMqzgry';
	topMessager.confirm('','您确认要注销数据吗？',function(r) {  
		if (r) {	
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: {id:$('#mqzgry_datagrid').datagrid('getData').rows[index].id}
			}).done(function(result) {
				$('#mqzgry_datagrid').datagrid('reload');
			});
		}
	});
};
//更多【民爆实施项目业绩】
function show_more_mbsxm(){
	var url = contextPath + '/sydwgl/mbsgxm_query_more?dwid='+dwid+'&mode='+$('#mode_').val();
	openWindow(false, 'show_more_mbssxm_win', url, {"_p":$("#ssxmyj_datagrid")}, {title:'民爆实施项目列表', modal:true, width:720, height:400});
	
};


//更多【民枪专管人员列表】
function show_more_mqzgry(){
	var url = contextPath + '/sydwgl/mqzgry_query_more?dwid='+dwid+'&mode='+$('#mode_').val();
	openWindow(false, 'show_more_mqzgry_win', url, {"_p":$("#mqzgry_datagrid")}, {title:'民枪专管人员列表', modal:true, width:720, height:520});
};
//民爆保存回调函数后刷新
function mbafterSubmitSuccess(){
	$('#ssxmyj_datagrid').datagrid('reload');
}
//民枪保存回调函数后刷新
function mqafterSubmitSuccess(){
	$('#mqzgry_datagrid').datagrid('reload');
}

function closeUploadIframe(){
	$("cyry_import_win").dialog('close');
}

function refreshPhoto(){
	location.reload();
}

//自主银行操作列
function zzyhdatagridProcessFormater(val, row, index) { // 自定义操作生成
	return '<a class="link" href="javascript:void(0)" onclick="edit(\''+row.id+'\',\''+dwid+'\',\'/zzyhjzzsbb/edit\',\'zzyhjzzsbb_datagrid\',\'自助银行及自助设备修改\',\'zzyhafterSubmitSuccess\')">修改</a>&nbsp;'+
		   	'<a class="link" href="javascript:void(0)" onclick="cancel(\''+row.id+'\',\'zzyhjzzsbb_datagrid\',\'info_zzyhjzzsbb\')">注销</a>';
};
//自助银行保存成功回调函数
function zzyhafterSubmitSuccess(){
	$('#zzyhjzzsbb_datagrid').datagrid('reload');
};

//护校队操作列
function hxddatagridProcessFormater(val, row, index) { // 自定义操作生成
	return '<a class="link" href="javascript:void(0)" onclick="edit(\''+row.id+'\',\''+dwid+'\',\'/xyaqxxbHxd/addXyaqxxbHxd\',\'hxdxxb_datagrid\',\'护校队信息修改\',\'hxdafterSubmitSuccess\')">修改</a>&nbsp;'+
		   	'<a class="link" href="javascript:void(0)" onclick="cancel(\''+row.id+'\',\'hxdxxb_datagrid\',\'info_xyaqxxbHxd\')">注销</a>';
};
//护校队保存成功回调函数
function hxdafterSubmitSuccess(){
	$('#hxdxxb_datagrid').datagrid('reload');
};

//校车操作列
function xcdatagridProcessFormater(val, row, index) { // 自定义操作生成
	return '<a class="link" href="javascript:void(0)" onclick="edit(\''+row.id+'\',\''+dwid+'\',\'/xyaqxxbXc/addXyaqxxbXc\',\'xcxxb_datagrid\',\'校车信息\',\'xcafterSubmitSuccess\')">修改</a>&nbsp;'+
		   	'<a class="link" href="javascript:void(0)" onclick="cancel(\''+row.id+'\',\'xcxxb_datagrid\',\'info_xyaqxxbXc\')">注销</a>';
};
//校车保存成功回调函数
function xcafterSubmitSuccess(){
	$('#xcxxb_datagrid').datagrid('reload');
};
//打开保安人员新增页面
function add_baryxxb(){
	openWindowWithSave(false, null, window, 
   		{"_p":$("#bary_datagrid")}, 
   		{
   		title: '保安人员新增',
   		url: contextPath+'/dwxyaqxxbBay/createPage?dwid='+dwid,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, 'baryAfterSubmitSuccess',null
   	);
}

//保安人员操作列
function barydatagridProcessFormater(val, row, index) { // 自定义操作生成
	var ophtml = "";
		ophtml = '<a class="link" href="javascript:void(0)" onclick="barydoEdit(this,'+index+')">修改</a>&nbsp;'+
//	   	     	 '<a class="link" href="javascript:void(0)" onclick="cancel(\''+row.id+'\',\'bary_datagrid\',\'info_bayxxb\')">注销</a>&nbsp;'+
		         '<a class="link" href="javascript:void(0)" onclick="del_bayInfo(\''+row.id+'\',\'bary_datagrid\',\'info_bayxxb\')">注销</a>&nbsp;'+
	   	     	 '<a class="link" href="javascript:void(0)" onclick="barycyqkxxb(this,'+index+')">从业情况</a>&nbsp;';
	return ophtml;
};

//注销【保安员】
function del_bayInfo(dwid,datagrid,url){
	openWindowWithSave(false, null, window, 
		{}, 
   		{
   		title: '注销记录',
   		url: contextPath + '/sydwgl/delete_xxzsnrb?id='+dwid + '&url=' +url,
   		width: 880,
   		height:200
   		}, 
   		null,'baryAfterSubmitSuccess',null
   	);
}


//保安员从业情况添加
function barycyqkxxb(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	openWindowWithSave(false, null, window, 
   		{}, 
   		{
   		title: '保安员从业情况信息',
   		url: contextPath+'/dwbaycyqkxxb/createPage?dwid='+dwid+'&id='+$('#bary_datagrid').datagrid('getData').rows[index].id,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, 'baryAfterSubmitSuccess',null
   	);
}

//编辑【保安人员】
function barydoEdit(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	window.top.openWindowWithSave(false, null, window, 
   		{}, 
   		{
   		title: '修改 保安员信息',
   		url: contextPath+'/dwxyaqxxbBay/createPage?dwid='+dwid+'&id='+$('#bary_datagrid').datagrid('getData').rows[index].id,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, 'baryAfterSubmitSuccess',null
   	);
};
//保安员提交成功后回调函数
function baryAfterSubmitSuccess(){
	$('#bary_datagrid').datagrid('reload');
};

//更多 保安员信息列表
function show_more_bary(){
	var url = contextPath + '/dwxyaqxxbBay/baryxxb_query_more?dwid='+dwid;
	openWindow(false, 'show_more_bary_win', url, {"_p":$("#bary_datagrid")}, {title:'保安员详细列表', modal:true, width:720, height:500});
};
//附件信息操作列
function fjxxprocessFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="fjdown(this, '+index+')">下载</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doFjxxDelete(this, '+index+')">删除</a>&nbsp;';
};

//下载附件信息
function fjdown(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var idField = opts.idField;
	$('#downloadID').val(rowData[idField]);
	$('#downloadform').form('submit', {
		success: function(result) {
			if (result) {
				result = parseReturn(result);
				if (result.status == 'success') {
				}
				else {
					topMessager.alert('', result.message);
				}
			}
		}
	});
}

//删除附件信息
function doFjxxDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/zpfjFjxxb/delete';
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
				url: contextPath + '/zpfjFjxxb/delete',
				type: 'POST',
				data: postData
			}).done(function(result) {
				doSubmitResult(result, null, datagrid_ID);
			});
		}
	});
}

//单位检查操作列
function dwjcprocessFormater(val, row, index) { // 自定义操作生成
	var  zghtml = "";
	if(row.zt=="10"){
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="dwjcmodigy('+index+')">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doZg('+index+')">整改</a>&nbsp;';
	}else if(row.zt=="20"){
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="dwjcmodigy('+index+')">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doZg('+index+')">整改</a>&nbsp;';
	}else if(row.zt=="30"){
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="dwjcmodigy('+index+')">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doZg('+index+')">整改</a>&nbsp;';
	}else if(row.zt=="50"){
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doPrint('+index+');">打印</a>&nbsp;';
	}else if(row.zt=="60"){
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doPrint('+index+');">打印</a>&nbsp;';
	}else if(row.zt=="70"){
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doPrint('+index+');">打印</a>&nbsp;';
	}else if(row.zt=="80"){
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="dwjcmodigy('+index+')">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doZg('+index+')">整改</a>&nbsp;';
	}else if(row.zt=="90"){
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doPrint('+index+');">打印</a>&nbsp;';
	}else if(row.zt=="100"&&row.ywlbdm!=14){
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">打印</a>&nbsp;';
	}else if(row.zt=="100"&&row.ywlbdm==14){
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doPrint('+index+');">打印</a>&nbsp;';
	}else if(row.zt=="110"){
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="dwjcmodigy('+index+')">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doZg('+index+')">复查</a>&nbsp;';
	}else if(row.zt=="120"){
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doPrint('+index+');">打印</a>&nbsp;';
	}else{
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="dwjcmodigy('+index+')">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">整改</a>&nbsp;';
	}
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="dwjcView('+index+')">查看</a>&nbsp;'+
			zghtml;
};

/*
 * 查看日常检查
 * index 行索引 
 */
function dwjcView(index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dwjcxxb_datagrid').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = basePath+"dwjcxxb/add?id="+rowData.id;
	if(rowData.ywlbdm=="11"){
		editUrl = basePath+"dwjcxxb/addXf?id="+rowData.id;
	}else if(rowData.ywlbdm=="14"){
		editUrl = basePath+"dwjcxxb/addJf?id="+rowData.id;
	}
	window.top.openWindowNoSave(false, null, window, 
   		{dwmc:rowData.dwmc,dwlbdm:rowData.dwlbdm,ywlbdm:rowData.ywlbdm,mode:"view"}, 
   		{
   		title: '单位检查信息',
   		url: editUrl,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, null,null
   	);
}

//单位检查修改
function dwjcmodigy(index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dwjcxxb_datagrid').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = basePath+"dwjcxxb/add?id="+rowData.id+"&mainTabID="+getMainTabID();
	if(rowData.ywlbdm=="11"){
		editUrl = basePath+"dwjcxxb/addXf?id="+rowData.id+"&mainTabID="+getMainTabID();
	}else if(rowData.ywlbdm=="14"){
		editUrl = basePath+"dwjcxxb/addJf?id="+rowData.id+"&mainTabID="+getMainTabID();
	}else{
		editUrl = basePath+"dwjcxxb/add?id="+rowData.id+"&mainTabID="+getMainTabID();
	}
	window.top.openWindowWithSave(false, null, window, 
   		{dwmc:rowData.dwmc,dwlbdm:rowData.dwlbdm,ywlbdm:rowData.ywlbdm}, 
   		{
   		title: '单位检查信息',
   		url: editUrl,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, null,null
   	);
};

/*
 * 整改
 * index 行索引 
 */
function doZg(index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var openFlag = false;
	var editUrl = contextPath + "/forward/sydw|zlxqzgxxbAdd?jcid="+rowData.id+"&mainTabID="+getMainTabID();
	if(rowData.zt=="10"){
		editUrl = contextPath + "/forward/sydw|zlxqzgxxbAdd?jcid="+rowData.id+"&mainTabID="+getMainTabID();
		openFlag = true;
	}else if(rowData.zt=="20"){
		editUrl = contextPath + "/forward/sydw|zdhzyhzgAdd?jcid="+rowData.id+"&mainTabID="+getMainTabID();
		openFlag = true;
	}else if(rowData.zt=="30"){
		editUrl = contextPath + "/forward/sydw|lscfzgAdd?jcid="+rowData.id+"&mainTabID="+getMainTabID();
		openFlag = true;
	}else if(rowData.zt=="80"){
		editUrl = contextPath + "/forward/sydw|jfzlxqzgxxbAdd?jcid="+rowData.id+"&mainTabID="+getMainTabID();
		openFlag = true;
	}else if(rowData.zt=="110"){
		editUrl = contextPath + "/forward/sydw|jffcyjsAdd?jcid="+rowData.id+"&mainTabID="+getMainTabID();
		openFlag = true;
	}
	if(openFlag){
		window.top.openWindowWithSave(false, null, window, 
	   		{jcid:rowData.id,dwid:rowData.dwid,dwmc:rowData.dwmc}, 
	   		{
	   		title: '录入整改通知书',
	   		url: editUrl,
	   		width: 880,
	   		inline:true,
	   		height:500
	   		}, 
	   		null, null,null
	   	);
   	}
};

function doPrint(index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var openFlag = false;
	var editUrl = contextPath + "/dwjczg/queryZlzgtzs?jcid="+rowData.id;
	if(rowData.zt=="50"){
		editUrl = contextPath + "/dwjczg/queryZlzgtzs?jcid="+rowData.id;
		openFlag = true;
	}else if(rowData.zt=="60"){
		editUrl = contextPath + "/dwjczg/queryZdhzyhzgtzs?jcid="+rowData.id;
		openFlag = true;
	}else if(rowData.zt=="70"){
		editUrl = contextPath + "/dwjczg/queryLscftzs?jcid="+rowData.id;
		openFlag = true;
	}else if(rowData.zt=="90"){
		editUrl = contextPath + "/jfjczg/queryJfzlzgtzs?jcid="+rowData.id;
		openFlag = true;
	}else if(rowData.zt=="120"){
		editUrl = contextPath + "/jfjczg/queryJFfcyjs?jcid="+rowData.id;
		openFlag = true;
	}
	if(openFlag){
		window.open(editUrl,"详情","height=1054,width=1024,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
   	}
}


//刷新单位检查列表
function queryButton(){
	$("#dwjcxxb_datagrid").datagrid("reload");
};

//单位处罚操作列
function dwcfprocessFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="dwcfView(\''+row.id+'\',\''+row.dwmc+'\')">详情</a>&nbsp;';
};

/*
 * 查看处罚检查
 * index 行索引 
 */
function dwcfView(id,dwmc) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = basePath+"dwcfxxb/edit?id="+id;
	window.top.openWindowNoSave(false, null, window, 
   		{dwmc:dwmc,mode:"view"}, 
   		{
   		title: '单位处罚信息',
   		url: editUrl,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, null,null
   	);
}