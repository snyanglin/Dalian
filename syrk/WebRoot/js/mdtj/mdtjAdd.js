/**
 * 
 * @description:矛盾调节添加
 * @author: tian_chengwei@founder.com  
 * @date:2015-06-02
 * 
 * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 * 应将重复使用语句抽取成独立方法
 */
$(document).ready(function(){
    //单位查询控件 
	initDepartmentSearch('dwmc', {glpcsid: ''}, 'gxdwid', 'gxdwmc', {});
	init();
	
	
});
$(function(){
		$('#dataForm').form({  
	        onSubmit:function(){
	            return $(this).form('validate');  
	        },  
	        success:function(data){  
	            var json = $.parseJSON(data);
	            if(json.status != 'success'){
	            	topMessagerAlert(null,json.message);
	          	
	            }else{
	            	
	            	$("#pk").val(json.saveID); 
	            	if($("#pk").val()){
	            		$("#xxk").show();
	            	}
	            	topMessagerShow(null,json.message);
	            	executeTabPageMethod(mainTabID, "reloadDg");
	            }
	        }  
});   
//提交保存	    
$('#saveBotton').click(function(){
    var mdfssj = $("#mdfssj").val();
	if(mdfssj == "" || mdfssj == null){
	    return;
	}
	if ($("#dataForm").form('validate')){
		topMessager.confirm('操作确认', '您是否保存矛盾调解？',  function(r) {
			if (r) {
				$('#dataForm').submit();
			}
		});
	}
});
//关闭页面
$('#backBotton').click(function(){
	closeSelf();
});
//根据返回参数控制文本框
$('#resetBotton').click(function(){
		var flag = document.getElementById("flag").value;
		if(flag=="update"){
			$("#mdlydm").combobox("clear");			
			$("#mdlx").val("");
			$("#mdfssj").val("");
			$("#mdfsddmc").val("");
			$("#mdyy").val("");
			$("#mdxz").val("");
			$("#bz").val("");
			var gx=$("#mdgxgsdm").combobox("getText");
			if(gx=="公安管辖"){
			
			}else {
				$("#mdgxgsdm").combobox("clear");
				 setInputReadonly('dwmc',false);
		    	 setInputReadonly('sfyjdm',false);
		   	     setInputReadonly('yjr',false);
		         setInputReadonly('jsr',false);
		         $("#dwmc").combobox("clear");
				 $("#sfyjdm").combobox("clear");
				 $("#yjr").val("");
				 $("#jsr").val("");
			}
		
		}else {
			document.forms["dataForm"].reset();
		    setInputReadonly('dwmc',false);
		    setInputReadonly('sfyjdm',false);
		    setInputReadonly('yjr',false);
		    setInputReadonly('jsr',false);		
				}				 
		});	
});
//初始化函数
function init(){
	var flag = $("#flag").val();
	if(flag=="update"){
		$("#xxk").show();
		var gx=$("#mdgxgsdm").combobox("getText");
		if(gx=="公安管辖"){
			fzgx();	
			}else {
			//$("#xxk").hide();
		}
	}else {
		$("#xxk").hide();
	}
	fszj();
}
//当事人
function processFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="edit(this,'+index+',1)">编辑</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="del(this, '+index+',1)">注销</a>&nbsp;';
}
//调节
function processFormater1(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="edit(this,'+index+',2)">编辑</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="del(this, '+index+',2)">注销</a>&nbsp;';
}
//进度跟踪
function processFormater2(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="edit(this,'+index+',3)">编辑</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="del(this, '+index+',3)">注销</a>&nbsp;';
}
//当事人/调节/进度修改方法
function edit(linkObject, index,stype){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var tabName = "";
	var editUrl = "";
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	var idField = opts.idField;
	switch(stype){
	case 1:
		tabName = "当事人信息";
		editUrl = contextPath + '/dsrxxzb/addDsrxxzb';
		editUrl =editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
		editUrl = editUrl + idField + "=" + rowData[idField];
	break;
	case 2:
		tabName = "调节信息";
		editUrl = contextPath + '/tjxxzb/addTjxxzb';
		editUrl =editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
		editUrl = editUrl + idField + "=" + rowData[idField];
		break;
	case 3:
		tabName = "跟踪进展情况";
		editUrl = contextPath + '/gzjzqkzb/addGzjzqkzb';
		editUrl =editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
		editUrl = editUrl + idField + "=" + rowData[idField];
		break;
	default:
		topMessagerShow(null,"请求路径错误！");
	
	}
	datagridEdit(datagrid_ID, 'editWindow', null, {
		title : tabName,
		url : editUrl,
		maximizable : true,
		width : 850,
		height : 360
	}, '您是否要保存数据？');
	
}
////当事人/调节/进度注销
function del(linkObject, index,style){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var submitFields = ""; //  除主键之外需要提交的字段（多个用逗号分隔）
	var deleteUrl = "";
	switch(style){
	case 1:
		deleteUrl = contextPath + '/dsrxxzb/delete';
		break;
	case 2:
		deleteUrl = contextPath + '/tjxxzb/delete';
		break;
	case 3:
		deleteUrl = contextPath + '/gzjzqkzb/delete';
		break;
	default:	
		topMessagerShow(null,"请求路径错误！");
	}
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

//判断是否是公安管辖
function fzgx(){
	var gx=$("#mdgxgsdm").combobox("getText");
	if(gx=="公安管辖"){
	    setInputReadonly('dwmc',true);
		setInputReadonly('sfyjdm',true);
		setInputReadonly('yjr',true);
		setInputReadonly('jsr',true);
		$("#dwmc").combobox("setValue","");
		$("#sfyjdm").combobox("setValue","");
		$("#yjr").val("");
		$("#jsr").val("");
	}else {
	    setInputReadonly('dwmc',false);
		setInputReadonly('sfyjdm',false);
		setInputReadonly('yjr',false);
		setInputReadonly('jsr',false);
	}
}
//判断是否，控制文本是否可编辑
function fszj(){
	var zj=$("#sfyjdm").combobox("getText");
	if(zj=="否"){
	    $("#yjr").val("");
		$("#jsr").val("");
		setInputReadonly('yjr',true);
		setInputReadonly('jsr',true);
		
	} else {
		setInputReadonly('yjr',false);
		setInputReadonly('jsr',false);
	}
}
function add(obj,style){
	var mdjfxxid  = $("#pk").val();
	var addUrl = "";
	var tabName = "";
	switch(style){
	case 1:
		tabName = "当事人信息";
		addUrl = contextPath + '/dsrxxzb/addDsrxxzb?mdjfxxid='+mdjfxxid+'&mainTabID='+getMainTabID();
		addUrl = addUrl + (addUrl.indexOf('?') != -1 ? '&' : '?');
		break;
	case 2:
		tabName = "调节信息";
		addUrl = contextPath + '/tjxxzb/addTjxxzb?mdjfxxid='+mdjfxxid+'&mainTabID='+getMainTabID();
		addUrl = addUrl + (addUrl.indexOf('?') != -1 ? '&' : '?');
		break;
	case 3:
		tabName = "跟踪进展";
		addUrl = contextPath + '/gzjzqkzb/addGzjzqkzb?mdjfxxid='+mdjfxxid;
		addUrl = addUrl + (addUrl.indexOf('?') != -1 ? '&' : '?');
		break;
		default:
			topMessagerShow(null,"请求路径错误！");
	
	}
	datagridAdd(obj, 'addWindow', null, {
		title : tabName,
		url : addUrl,
		width : 850,
		height : 360
	}, '您是否要保存数据？');
	
}
//添加当事人
function dsrxxAdd(obj){
		var mdjfxxid = document.getElementById("pk").value;		
		var addUrl = contextPath + '/dsrxxzb/addDsrxxzb?mdjfxxid='+mdjfxxid+'&mainTabID='+getMainTabID();
		var addUrl = addUrl + (addUrl.indexOf('?') != -1 ? '&' : '?');
		datagridAdd(obj, 'addWindow', null, {
			title : '当事人信息',
			url : addUrl,
			width : 850,
			height : 360
		}, '您是否要保存数据？');
}
//添加调节
function tjxxzbAdd(obj){
	var mdjfxxid = document.getElementById("pk").value;
	var addUrl = contextPath + '/tjxxzb/addTjxxzb?mdjfxxid='+mdjfxxid+'&mainTabID='+getMainTabID();
		var addUrl = addUrl + (addUrl.indexOf('?') != -1 ? '&' : '?');
		datagridAdd(obj, 'addWindow', null, {
			title : '调解信息',
			url : addUrl,
			width : 850,
			height : 360
		}, '您是否要保存数据？');
		
}
//添加跟踪进展
function gzjzqkzbAdd(obj){
		var mdjfxxid = document.getElementById("pk").value;
		var addUrl = contextPath + '/gzjzqkzb/addGzjzqkzb?mdjfxxid='+mdjfxxid;
		var addUrl = addUrl + (addUrl.indexOf('?') != -1 ? '&' : '?');
		datagridAdd(obj, 'addWindow', null, {
			title : '跟踪进展情况',
			url : addUrl,
			width : 850,
			height : 360
		}, '您是否要保存数据？');

}
//刷新当事人添加后列表
function dsrList(){
	var reloadUrl  = contextPath + '/dsrxxzb/queryList';
	var opt = $('#dg0').datagrid('options');
	opt.url = reloadUrl;
	var mdjfxxid=$("#pk").val()+"";
	$('#dg0').datagrid('load',{mdjfxxid:mdjfxxid});
}
//刷新调节添加后的列表内容
function tjxList(){
	var reloadUrl  = contextPath + '/tjxxzb/queryList';
	var opt = $('#tb1').datagrid('options');
	opt.url = reloadUrl;
	var mdjfxxid=$("#pk").val()+"";
	$('#tb1').datagrid('load',{mdjfxxid:mdjfxxid});
}
//刷跟踪进展添加后的列表内容
function gzjzqkList(){
	var reloadUrl  = contextPath + '/gzjzqkzb/queryList';
	var opt = $('#tb2').datagrid('options');
	opt.url = reloadUrl;
	var mdjfxxid=$("#pk").val()+"";
	$('#tb2').datagrid('load',{mdjfxxid:mdjfxxid});

}
