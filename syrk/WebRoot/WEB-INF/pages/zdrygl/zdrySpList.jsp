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
            		idField:'id',pageSize:5,
            		pageList:[5,5 * 2]">
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
			</div>
        </div>
    </div>   
</body>
<script type="text/javascript">

function processFormater(val, row, index) { // 自定义操作生成
	var hsButton='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doHslg(this,'+index+',\'edit\')">审批</a>&nbsp;';
	
	
	return hsButton;
}

function doHslg(linkObject, index,openType) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl ="";
	
		editUrl = contextPath+"/zdryApproval/zdryApproval?executionId="+rowData.executionId+"&workflowId="+rowData.workflowId;
	
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
</script>  

</html>

