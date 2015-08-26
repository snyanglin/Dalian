<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>系统消息</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:true" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/jcj/list',
            	    method:'POST',
            	    queryParams:{currrentDay:'1'},
            	    toolbar:'#datagridToolbar',
            		singleSelect:true,selectOnCheck:true,checkOnSelect:true,border:false,
            		idField:'id',pageSize:getAutoPageSize(),pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
            		<!-- onClickRow:doOnClickRow 单击行事件 --> 
				    <thead>
				        <tr>
				            
				            
					        <th data-options="field:'bj_sj',width:10,align:'center'">报警时间</th>
					        <th data-options="field:'jjlxdm',width:10,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_JCJ_JJLXDM.js'">接警类别</th>
				            <th data-options="field:'bjnr',width:75,align:'left',halign:'center'">报警内容</th>
				            <th data-options="field:'jjbh',hidden:true">jjbh</th>
				            <th data-options="field:'xzqhdm',hidden:true">xzqhdm</th>
				            <th data-options="field:'id',hidden:true">id</th>
				            <th data-options="field:'cjdbh',hidden:true">cjdbh</th>
				            <th data-options="field:'orgseatno',hidden:true">orgseatno</th>
				          	<th data-options="field:'process',width:5,align:'center',halign:'center',formatter:processFormater">操作</th>
				        </tr>
				    </thead>
				</table>
			</div>
        </div>
    </div>   
</body>
<script type="text/javascript">

function processFormater(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;';
}

function process(val, row, index) { // 自定义操作生成
    if(row.xxlb == '9'){
       if(row.bool ==0){
          return "&nbsp;<a class='link' href='javascript:javascript:void(0)' onclick='title_onclick2("+row.id+",\""+row.ywurl+"\")'>"+row.xxnr+"</a>&nbsp";
       }else{
          return "&nbsp;<a class='link' href='javascript:javascript:void(0)' onclick='hrefUrl("+row.id+",\""+row.ywurl+"\")'>"+row.xxnr+"</a>&nbsp";
       }
       
    }else{
       return row.xxnr;
    }
}
//弹出窗口打开!
function title_onclick2(xxID,str) {
	//先更新查看状态;
	updateTzggZt(xxID);
	var strArray =new Array;
	if(str.indexOf("?")>0){
		strArray = str.split("?");
		var url = '<%=contextPath %>' +"/tzgg/tzggInfo?id="+strArray[0]+"&mode=inFo&xxID="+xxID;
		window.open(url,'通知公告',"");
	}else{
		var url = '<%=contextPath %>' +"/tzgg/tzggInfo?id="+str+"&mode=inFo&xxID="+xxID;
		window.open(url,'通知公告',"");
	}
}
function hrefUrl(xxID,url){
	//先更新查看状态;
	updateTzggZt(xxID);
	window.open(url,'通知公告',"");
}
//ajax修改查看消息的状态
function updateTzggZt(xxid){
    $.ajax({
       type:"POST",
       url :contextPath+"/tzgg/view",
       data:{id:xxid},
       dataType:'json',
       success:function(data){
    	   
       }
    });
}
//ajax修改消息状态
function editMsgStar(xxid){
    $.ajax({
       type:"POST",
       url :"<%=basePath%>sysMessage/update",
       data:{id:xxid},
       dataType:"json",
       success:function(data){
       }
    });
}
function title_onclick(xxID, ywurl,xxbt) {
  editMsgStar(xxID);
  if(null != ywurl && "" != ywurl){
     menu_open(xxbt, "/"+ywurl);
  }else{
     window.top.openWindow(false,'', '<%=contextPath %>' +"/sysMessage/view?id="+xxID, {document: document}, {title: '消息信息',    
	    width: 850,   
	    height: 420,  
		collapsible: false, 
		minimizable: false, 
		maximizable: false,
		closable: true,
	    closed: false,    
	    cache: false,
	    inline: false,
		resizable: false, 
	    modal: true});
  }
}
// 行单击
function doOnClickRow(rowIndex, rowData) {
	var editUrl = contextPath + '/sysMessage/edit';
	var opts = $(this).datagrid('options');
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var idField = opts.idField;
	editUrl = editUrl + idField + "=" + rowData[idField];
	datagridEdit(opts.id, 'editWindow', 
   		null,
  		{
   		title: '消息列表',
   		url: editUrl,
   		maximizable: true,
   		width: 850,
   		height: 320
   		}
   	);
}

function doView(linkObject, index){
	var datagrid_ID = getDatagrid_ID(0, linkObject);
    var rows = $('#' + datagrid_ID).datagrid("getData");
    var rowData = rows.rows[index];
	var editUrl = contextPath + '/jcj/queryJjxx?id='+rowData.id;
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var paramArray = [3];
	paramArray[0] = rowData.jjbh;
	paramArray[1] = rowData.xzqhdm;
	paramArray[2] = rowData.cjdbh;
	openWindowNoSave(true, null, this.Window, 
   		paramArray, 
   		{
   		title: '',
   		url: editUrl,
   		maximizable: false,
   		width: 700,
   		height: 520
   		}, 
   		'', null
   	);
}

// datagrid 修改
// 默认在本页面中弹出，不缓存页面
// paramArray 可以传入参数（如：{document:document, param1: 'test1', param2: 2}）
// dataOptions jquery.window中的data-options定义参数
// submitConfirm 提交确认提示信息（为空则不出现确认框）
function datagridEdit(datagrid_ID, windowID, paramArray, dataOptions, submitConfirm) {
	if (!dataOptions.url) {
		topMessagerAlert('', '弹出层缺少 url 参数！');
		return;
	}
	dataOptions.datagrid_ID = datagrid_ID;
	if (!dataOptions.title) {
		dataOptions.title = '修改';
	}
	dataOptions.title = '&nbsp;' + dataOptions.title;
	if (!dataOptions.width) {
		dataOptions.width = 850;
	}
	if (!dataOptions.height) {
		dataOptions.height = 420;
	}
	if (!windowID) {
		windowID = "editWindow";
	}
	dataOptions.collapsible = dataOptions.collapsible ? dataOptions.collapsible : false;
	dataOptions.minimizable = dataOptions.minimizable ? dataOptions.minimizable : false;
	dataOptions.maximizable = dataOptions.maximizable ? dataOptions.maximizable : false; // 是否最大化图标
	dataOptions.closable = true;
	dataOptions.closed = false;   
	dataOptions.cache = false;
	dataOptions.inline = false;
	dataOptions.modal = true;
	openWindow(false, windowID, dataOptions.url, paramArray, dataOptions);
}

// 删除单条
function doDelete(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/sysMessage/delete';
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
				url: deleteUrl,
				type: 'POST',
				data: postData
			}).done(function(result) {
				doSubmitResult(result, null, datagrid_ID);
			});
		}
	});
}

</script>  

</html>