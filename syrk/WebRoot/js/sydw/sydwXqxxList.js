function xqAdd(){
	window.top.openWindowWithSave(false, null, window, 
   		{"_p":$("#dg")}, 
   		{
   		title: '小区信息',
   		url: contextPath+'/dwxqjbxxb/createPage',
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}

function afterSubmitSuccess(){
	$('#dg').datagrid('reload');
}

//操作列
function dataXqFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEditXq(this,'+index+')">修改</a>&nbsp;'
		  +'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doCancel(this, '+index+')">注销</a>&nbsp;';
}
//重置  
function clearCase(){
 	$("#queryForm").form("reset");
}
  
//查询按钮
function queryButton(){
	var xqmc = document.getElementById("xqmc").value;
	var wymc = document.getElementById("wymc").value;
	xqmc= $.trim(xqmc);
	wymc= $.trim(wymc);
	$('#dg').datagrid('load',{'xqmc':xqmc,'wymc':wymc});
}

function doEditXq(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	window.top.openWindowWithSave(false, null, window, 
   		{}, 
   		{
   		title: '小区信息修改',
   		url: contextPath+'/dwxqjbxxb/createPage?id='+$('#dg').datagrid('getData').rows[index].id,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, 'afterSubmitSuccess',null
   	);
}

  
//重新加载	
function reloadDg(){
	$("#dg").datagrid("clearSelections");
	$('#dg').datagrid('load');
}
	
//注销action
function doCancel(linkObject, index){
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	
	document.getElementById("xt_zxyy").value ="请输入注销原因...";
	document.getElementById("id").value =rowData.id;
	
	$("#win").window("open"); 
}
	
//注销后台操作
function updatexq(){
	var dwxqUrl= contextPath+"/dwxqjbxxb/dwxqzx";
	var xt_zxyy = document.getElementById("xt_zxyy").value;
	var id = document.getElementById("id").value;
	if(xt_zxyy!="" ){
		if(xt_zxyy.length>100){
			return;
		}else{
			$.ajax({
				type:"GET",
				sync:true,
				url:dwxqUrl,
				data:{'id':id,'xt_zxyy':xt_zxyy,'xt_zxbz':1},
				dataType:'json',
				success:function(json){
					if(json==1){
						$.messager.alert("提示","小区注销成功","info");
						$("#win").window("close");
						$("#dg").datagrid("load");
					}else{
						$.messager.alert("提示","小区注销失败","info");
					}
				}
			
			});	
		}
	}else{
		$.messager.alert("提示","请输入注销原因","info");
	}
}
//关闭窗口	  
function closeWindow(){
	var zxyy = document.getElementById("xt_zxyy").value;
	if(zxyy!="请输入注销原因..." && zxyy!=""){
		if(confirm("数据还未保存，确定要关闭吗?")){
			$("#win").window("close");
		}
	}else{
		$("#win").window("close");
	}
}