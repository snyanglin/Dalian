/**
 * 
 * @description:矛盾查询
 * @author: tian_chengwei@founder.com  
 * @date:2015-06-02
 */


//根据是否移交和已经解决来决定是否查看编辑
function processFormater(val, row, index) { // 自定义操作生成
	 var rows = $('#dg').datagrid('getData');
	 var rowData = rows.rows[index];
	 var flagTJ = rowData.tjjgdm;
	 var flagYJ = rowData.sfyjdm;
	   if(flagYJ==1 || flagTJ==2 || row.xt_lrrbmid != zzjgdm ){
	       return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="queryMdtj(this,'+index+')">查看</a>&nbsp;';	 
	   }else{
	      return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="editMdtj(this,'+index+')">编辑</a>&nbsp;'+
			     '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="deleteMdtj(this, '+index+')">注销</a>&nbsp;'; 
	    }
		
}
//清除表单内容
function clearCase(){
	  $("#queryForm").form("reset");
}
//添加跳转
function mdtjAdd(obj){
	menu_open("矛盾调解新增",'/mdxxb/addMdxxb');
   		
}
//查看详情
function queryMdtj(linkObject, index){
       var rows = $('#dg').datagrid('getData');
	   var rowData = rows.rows[index];
	   var xxxquery = "/mdxxb/queryMdxxxx?id="+rowData.id+"&mainTabID="+getMainTabID();
	   menu_open("矛盾详细信息",xxxquery);

}
// 修改单条
function editMdtj(linkObject, index) {
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var rows = $('#dg').datagrid('getData');
		var rowData = rows.rows[index];
		var editUrl = "/mdxxb/addMdxxb?id="+rowData.id+"&mainTabID="+getMainTabID();
		menu_open("矛盾调解编辑",editUrl);
		
	}
//查询按钮
function queryButton() {
		var mdlydm = $("#mdlydm").val();
		var mdgxgsdm = $("#mdgxgsdm").val();
		var mdlx = $("#mdlx").val();
		var mdfssj = $("#mdfssj").val();
		var mdfsddmc = $("#mdfsddmc").val();
		var tjjgdm = $("#tjjgdm").val();
		$('#dg').datagrid('reload', {
			'mdlydm' : mdlydm,
			'mdgxgsdm' : mdgxgsdm,
			'mdlx' : mdlx,
			'mdfssj' : mdfssj,
			'mdfsddmc' : mdfsddmc,
			'tjjgdm' : tjjgdm
		});
	}
//注销单条
function deleteMdtj(linkObject, index) {
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var deleteUrl = contextPath + '/mdxxb/delete';
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		var submitFields = ""; //  除主键之外需要提交的字段（多个用逗号分隔）
		topMessager.confirm('', '您确认要注销数据吗？', function(r) {
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
				for ( var i = 0; i < postFieldArray.length; i++) {
					var postField = postFieldArray[i];
					if (rowData[postField]) {
						postData[postField] = rowData[postField];
					}
				}
				$.ajax( {
					url : deleteUrl,
					type : 'POST',
					data : postData
				}).done( function(result) {
					doSubmitResult(result, null, datagrid_ID);
				});
			}
		});
	}
//重新加载列表
function reloadGrid(){
	$('#dg').datagrid("clearSelections");
	var mdlydm = $("#mdlydm").va();
		var mdgxgsdm = $("#mdgxgsdm").va();
		var mdlx = $("#mdlx").val();
		var mdfssj = $("#mdfssj").val();
		var mdfsddmc = $("#mdfsddmc").val();
		var tjjgdm = $("#tjjgdm").val();
		var reloadUrl = contextPath + '/mdxxb/queryList';
		var opt = $('#dg').datagrid('options');
		opt.url = reloadUrl;
		$('#dg').datagrid('reload', {
			'mdlydm' : mdlydm,
			'mdgxgsdm' : mdgxgsdm,
			'mdlx' : mdlx,
			'mdfssj' : mdfssj,
			'mdfsddmc' : mdfsddmc,
			'tjjgdm' : tjjgdm
		});
	
	
}
//重新载入页面
function reloadDg(){
		$("#dg").datagrid("clearSelections");
		$('#dg').datagrid('reload');
}
