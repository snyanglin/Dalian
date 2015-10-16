<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script>
<title>重点人员业务审批</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'重点人员业务审批',border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/zdryApproval/queryList',
            		toolbar:'#datagridToolbar',
            		singleSelect:true,selectOnCheck:true,
            		checkOnSelect:true,border:false,
            		fitColumns:true,
            		idField:'id',pageSize:10,
            		pageList:[10,10 * 2]">
				    <thead>
				        <tr>
				        	
				         	
 								<th data-options="field:'sqlx',width:400,align:'center',halign:'center',sortable:false">申请类型</th>
 								
 								<th data-options="field:'createTime',width:400,align:'center',halign:'center',sortable:false">申请时间</th>
 								
 								<th data-options="field:'sqrName',width:400,align:'center',halign:'center',sortable:false">申请人</th>
 								
 								
 								<th data-options="field:'zdryName',width:400,align:'center',halign:'center',sortable:false">重点人员姓名</th>

 								
 								<th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				
				<div id="datagridToolbar" style="padding: 0px; height: 50px; width: 100%; vertical-align: top;">
					<form id ="queryForm" >		        
			        <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				        
				        <tr class="dialogTr">
					    	<td width="20%" class="dialogTd" align="right">审批类型：</td>
					    	<td width="30%" class="dialogTd">
					    	    <select class="easyui-combobox" style="width:200px" id="splx">
						    		<option value="0">待审批</option>
						    		<option value="1">已审批</option>
						    		<option value="2">流程结束</option>
						    	</select>
					    	</td>	
					    	<td width="10%" class="dialogTd" align="right">申请类型：</td>
								<td width="20%" class="dialogTd"><input
									class='easyui-validatebox ' 
									type='text' id='sqlx' name='sqlx'
									 style="width:250px;" />
								</td>			    	
				    	</tr>					    	
			         </table>
			         <div id="saveDiv"
									style="text-align:center; height:50px; padding-top: 10px;">
									<a id="saveBotton" class="l-btn l-btn-small"
										href="javascript:void(0)" group=""   onclick="queryButton();"> <span
										class="l-btn-left l-btn-icon-left"> <span
											class="l-btn-text">查询</span> <span
											class="l-btn-icon icon-save"> </span> </span> </a>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a id="resetBotton"
										class="l-btn l-btn-small" href="javascript:void(0)" group="">
										<span class="l-btn-left l-btn-icon-left"> <span
											class="l-btn-text">重置</span> <span
											class="l-btn-icon icon-reset"> </span> </span> </a>
								</div>
		        </form>
				</div>
			</div>
        </div>
    </div>   
</body>
<script type="text/javascript">

function processFormater(val, row, index) { // 自定义操作生成
	var splx=$("#splx").val();
	
	var hsButton='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doHslg(this,'+index+',\'edit\')">审批2</a>&nbsp;';		
	
	if(splx=="0"){//未审批
		hsButton='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doHslg(this,'+index+',\'edit\')">审批</a>&nbsp;';	
	}else {
		hsButton='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doHslg(this,'+index+',\'edit\')">查看</a>&nbsp;';		
	}
	
	return hsButton;
}

function doHslg(linkObject, index,openType) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl ="";
	var splx=$("#splx").val();
	
	editUrl = contextPath+"/zdryApproval/zdryApproval?executionId="+rowData.executionId+"&workflowId="+rowData.workflowId;
	
	if(splx=="0"){
		editUrl = contextPath+"/zdryApproval/zdryApproval?executionId="+rowData.executionId+"&workflowId="+rowData.workflowId;
	}
	else {
		editUrl = contextPath+"/zdryApproval/zdryDetail?pocessDefinitionId="+rowData.pocessDefinitionId+"&workflowId="+rowData.workflowId;
	}
	//alert(rowData.workflowId);
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	
	openTabPage('重点人员审批', editUrl,datagrid_ID)
}

function openTabPage(menuName, openURL,datagrid_ID) {
	openWindow(false,'windowWithoutSave', openURL, {document: document}, {title: menuName,    
	    width: 880,   
	    height: 420,  
		collapsible: false, 
		minimizable: false, 
		maximizable: false,
		closable: true,
	    closed: false,    
	    cache: false,
	    inline: false,
		resizable: false, 
	    modal: true})
	
}
function refresh()
{

this.location = this.location;

}
 	function queryButton() {
		$('#dg').datagrid('reload', {
		'splx' : $("#splx").val(),
		'sqlx' : $("#sqlx").val()
		});
 	}
	$("#resetBotton").click(function(){
	 $("#queryForm").form("reset");
		
	});

    function searchList(){
	 var reloadUrl = contextPath +'/zdryApproval/queryList';
	 var spzt=$("#spzt").val();
	 reloadUrl = contextPath +'/zdryApproval/queryList?spzt'+spzt;	
	
	
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	alert("查询："+opt.url);
	$('#dg').datagrid('reload');
    }
 
	function reloadDg(){
		$("#dg").datagrid("clearSelections");
		$('#dg').datagrid('reload');
}
</script>  

</html>

