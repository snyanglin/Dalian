<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>待办任务列表</title>
    <script type="text/javascript" src="<%=contextPath%>/js/dbrw/tab.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/tools/flashChart/swfobject.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/tools/tabChart/event.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/tools/tabChart/tween.js"></script>
    
	<style type="text/css">
		.wrapper{width:100%; height:100%; overflow:hidden;}
		.dbrw_left{width:69%; height:220px; overflow:hidden; float:left; background-color:#fff; border:1px solid #d1d1d1;}
		.dubanrenwu_table{width:98%; margin:14px auto 0 auto;}
		.dubanrenwu_table tr{height:35px;}
		.dubanrenwu_table th{font-size:12px; color:#333; line-height:35px; text-align:right; border-bottom:1px dashed #d6d6d6;}
		.dubanrenwu_table td{font-size:12px; color:#888888; line-height:35px; text-align:left; border-bottom:1px dashed #d6d6d6;}
		.dbrw_right{width:30%; height:220px; overflow:hidden; float:right; background-color:#fff; border:1px solid #d1d1d1;}
		.dbrw_jdt{width:230px; height:210px; margin:10px auto 0 auto;}
	</style>

</head>




<body class="easyui-layout" data-options="fit:true" > 
	
	 <div data-options="region:'north',border:false" style="height: 250px;padding-left: 10px;padding-right: 10px;padding-top: 10px;padding-bottom: 10px;">
	 
	 	<div class="wrapper" >
		<div class="dbrw_left">
		<table cellpadding="0" cellspacing="0" class="dubanrenwu_table">
		<tr>
		<th width="12%" nowrap="nowrap">任务开始时间：</th>
		<td width="38%" nowrap="nowrap">${fn:substring(entity.rwkssj,0,10)}</td>
		<th width="12%" nowrap="nowrap">任务结束时间：</th>
		<td width="38%" nowrap="nowrap">${fn:substring(entity.rwjssj,0,10)}</td>
		</tr>
		<tr>
		<th nowrap="nowrap">任务发起时间：</th>
		<td nowrap="nowrap">${fn:substring(entity.rwfqsj,0,10)}</td>
		<th nowrap="nowrap">任务数据总量：</th>
		<td nowrap="nowrap">${entity.rwsjzl}</td>
		</tr>
		<tr>
		<th nowrap="nowrap">任务标题：</th>
		<td colspan="3" nowrap="nowrap">${entity.rwbt}</td>
		</tr>
		<tr>
		<th nowrap="nowrap">任务说明：</th>
		<td colspan="3" nowrap="nowrap">${entity.rwsm}</td>
		</tr>
		
		<tr>
		<th nowrap="nowrap">数据操作：</th>
		<td colspan="3" align="center" nowrap="nowrap">
			 	<table id="bottomId" style="display: none;" cellspacing="0" cellpadding="0" border="0" align="center" >
					<tbody>
					<tr>
						<td class="toolbarTd">
							<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" onclick="refreshDataHandle('${entity.id}','${entity.dbmxid}');" group="">
								<span class="l-btn-left l-btn-icon-left">
									<span class="l-btn-text">刷新任务</span>
									<span class="l-btn-icon icon-reload"> </span>
								</span>
							</a>
						</td>
						
						<td class="toolbarTd" style="width: 35px;"></td>
						
						
						<td>
							<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" onclick="CompleteData('${entity.id}','${entity.dbmxid}','${messageid}');" group="">
								<span class="l-btn-left l-btn-icon-left">
									<span class="l-btn-text">完成任务</span>
									<span class="l-btn-icon icon-ok"> </span>
								</span>
							</a>
						</td>
						
					</tr>
					</tbody>
					</table>
			
		</td>
		</tr>
		
		
		</table>
		</div>
		<div class="dbrw_right">
		<div class="dbrw_jdt" id="wcrwqkFig">
		</div>
		</div>
		</div>
	 
	 
	 </div>

    <div data-options="region:'center',border:false" style="padding-left: 10px;padding-right: 10px;"> 
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/dbrwRwcl/getTaskList',toolbar:'#datagridToolbar',
            		singleSelect:true,border:true,sortName:'id',sortOrder:'asc',queryParams:{dbrwid:'${entity.id}'},showFooter:true,
            		idField:'id',pageSize:getAutoPageSize(272),pageList:[getAutoPageSize(272),getAutoPageSize(272) * 2]">
				    <thead>
				    		<th data-options="field:'id',hidden:'true'">id</th>
				    		<th data-options="field:'dbfknr1',hidden:'true'">dbfknr1</th>
				    	  <c:forEach items="${filedTitle}" var="o" varStatus="i">
				    	  	<th data-options="field:'dbsjx${i.index+1}',width:${o['filedRatio']},align:'center',halign:'center',sortable:true">${o["filedName"]}</th>
				    	  </c:forEach>
				    	  	<th data-options="field:'dbfknr',width:20,align:'center',halign:'center',sortable:true,formatter:dbfknrFormater">处理内容</th>
				    	  	<th data-options="field:'sjclr',width:10,align:'center',halign:'center',sortable:true">任务处理人</th>
				    	  	<th data-options="field:'sjclsj',width:10,align:'center',halign:'center',sortable:true">任务处理时间</th>
				    		<th data-options="field:'sfwcdm',width:10,align:'center',halign:'center',sortable:true, formatter:isFormater">是否完成</th>
				    		<th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
				    		
				  
				    </thead>
				</table>
				
					<div id="datagridToolbar" style="padding:5px;height:auto">
							<!-- 表格工具条按钮 -->
							<table cellspacing="0" cellpadding="0" border="0">
							<tbody>
							<tr>
								<td class="toolbarTd">
							    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-query" plain="true" onclick="datagridQuery(this, 'queryWindow', 
								  		null,
								  		{
								  		title: '督办任务明细查询条件',
								  		url: contextPath + '/dbrwVL/queryCondition?rwid=${entity.id}',
								  		width: 850,
								  		height: 320
								  		})">查询</a>
								</td>
							</tr>
							</tbody>
							</table>
					</div>					
				
				
				</div>
			</div>
        </div>
    </div>
    
    
    <div id="showMessageInfo" class="easyui-dialog" title="反馈内容详情"   
	    data-options="iconCls:'icon-search',resizable:true,modal:true,closed:true"
	    style="width: 400px;height: 200px;display: none;">
    </div>
    
    
    
    
</body>
<script type="text/javascript">


function showMessageInfo(rowIndex){
	/*
		var rowArray = $("#dg").datagrid("getRows");
		var rowObject = rowArray[rowIndex];
		$("#showMessageInfo").html(rowObject["dbfknr1"]);
		alert($("#showMessageInfo").html());
		$("#showMessageInfo").dialog('open');
		*/
}


function dbfknrFormater(val, row, index) { // 自定义操作生成
	return  "<a href='#' style='cursor: pointer;' onclick=showMessageInfo("+ index +")>"+val+"</a>";
}



//页面加载完毕时加载
$(function(){
	loadRwqkFig();
	//判断任务是否完成
	if('${entity.rwzt}'=="1"){
		document.getElementById("bottomId").style.display="none";
	}else{
		document.getElementById("bottomId").style.display="";
	}
});



//初始化工作情况
function loadRwqkFig(){
	 var vdata = new Date();
	 var mili = vdata.getMilliseconds();
     swfobject.embedSWF(
			contextPath+"/js/tools/flashChart/open-flash-chart.swf",
			"wcrwqkFig",
			"100%",
			"100%;",
			"9.0.0",
			"expressInstall.swf",
			{
				"data-file":contextPath+"/dbrwRwcl/getfigdata?dbrwid=${entity.id}~" + mili
			},
			{
				wmode:"transparent"
			}
	);
}



function processFormater(val, row, index) { // 自定义操作生成
	var is = row['sfwcdm'];
	if(is != "1"){
		return  '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="FeedBack(this, \''+row['id']+'\')">反馈</a>&nbsp;';
	}
	else {
		return;
	}
}

function isFormater(val, row, index) { // 自定义操作生成
	return row['sfwcdm']=="1" ? "已完成" : "待完成";
}

//处理工具栏 增加自定义按钮
function HandleTools(){
	var Pager = $("#dg").datagrid("getPager");
	Pager.pagination({
		showPageList:true,
		buttons:[{
			iconCls:"icon-undo",
			handler:function(){
				CompleteData('${entity.id}','${entity.dbmxid}','${messageid}');
			},
			text:"完成任务",
			iconAlign:'right'
			
		}]
		
	});
}



//刷新当前DataGrid
function refreshDataGrid(){
	$('#dg').datagrid("reload");
}


//调用后台数据处理刷新
function refreshDataHandle(P_ID,DBMXID){
	$.ajax({
		type:"POST",
		url:"<%= basePath%>dbrwRwcl/refreshClqk",
		dataType:"json",
		data:{id:P_ID,dbmxid:DBMXID},
		success:function(data){
			if (data) {
				refreshDataGrid();
			}
		}
	});
	
}


//任务完成
function CompleteData(P_ID,DBMXID,MessageID){
	topMessager.confirm('', '您确认要完成当前督办任务？', function(r) {
		if (r) {
			$.ajax({
				type:"POST",
				url:"<%= basePath%>dbrwRwcl/complete",
				dataType:"json",
				data:{id:P_ID,dbmxid:DBMXID,MessageID:MessageID},
				success:function(data){
					if (data) {
						//refreshDataGrid();
						closeSelf();
					}
				}
			});
		}
	});
}
	

// 修改单条
function FeedBack(linkObject,ObjectId) {
	var editUrl = contextPath + '/dbrwRwcl/openFk?dbrwsjmxbID='+ObjectId;
	var paramArray = [];
   	openWindowWithSave(false, null,this.window, 
   	   		paramArray, 
   	   		{
   	   		title: '反馈内容',
   	   		url: editUrl,
   	   		maximizable: true,
	   	   	width: 850,
	   		height: 280
   	   		}, 
   	   		'您是否要保存？', 'refreshDataGrid'
   	   	);
}

// 删除单条
function doSend(linkObject, rowId) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var dataArray = $('#' + datagrid_ID).datagrid('getData').rows;
	if (dataArray.length > 0) {
		var deleteIndex = -1
		for (var i = 0; i < dataArray.length; i++) {
			if (dataArray[i]['id'] == rowId) {
				deleteIndex = i;
				break;
			}
		}
		if (deleteIndex != -1) {
			$('#' + datagrid_ID).datagrid('deleteRow', deleteIndex);
		}
	}
	return;
}

</script>  

</html>