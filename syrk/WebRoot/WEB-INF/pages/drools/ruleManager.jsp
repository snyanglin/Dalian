<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>规则引擎管理</title>
<script type="text/javascript">
function processFormater(val, row, index) {
	if(row.key == 'main'){
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="reloadAll(this)">RELOAD ALL</a>&nbsp;';
	}
	else
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="reloadRule(this, \''
	+ row.key + '\')">RELOAD</a>&nbsp;';
}
function reloadRule(obj,key){	
	$(obj).hide();
	$.ajax({
		async:true,
		type:"POST",
		dataType:"json",
		url:"<%= basePath%>ruleSys/reloadOne?str="+key,
		success:function(data){			
			if (data =='success') {
				alert(key + " reload success");	 	
	  	  	}else{
	  	  		alert(key + " reload failed");
	  	  	}			 						 
        },         
 		complete: function() {
 			$(obj).show();
 		},
 		error: function() {
 			alert(key + " reload failed");
 		}
         
		});	
}

function reloadAll(obj){	
	$(obj).hide();
	$.ajax({
		async:true,
		type:"POST",
		dataType:"json",
		url:"<%= basePath%>ruleSys/reloadAll",
		success:function(data){			
			if (data =='success') {
				alert(" reload all success");	 	
	  	  	}else{
	  	  		alert(" reload all failed");
	  	  	}			 						 
        },         
 		complete: function() {
 			$(obj).show();
 		},
 		error: function() {
 			alert(" reload all failed");
 		}
         
		});	
}
</script>
</head>
<body class="easyui-layout" data-options="fit:false">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:false,border:false" style="height:auto">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/ruleSys/getManageList',            		
            		singleSelect:true,
            		selectOnCheck:true,
            		checkOnSelect:true,
            		border:false
            	">
				    <thead>
				        <tr>
				         	
 								<th width="100px" data-options="field:'key',width:400,align:'center',halign:'center',sortable:false">分组</th>
 								
 								<th data-options="field:'value',width:400,align:'center',halign:'center',sortable:false">URL</th>
 								
 								<th width="100px" data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
				        </tr>
				    </thead>
				</table>				
			</div>
        </div>
    </div>   

</body>
</html>
