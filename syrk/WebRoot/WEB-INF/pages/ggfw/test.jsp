<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>公共服务测试页</title>
</head>
<body>  
	<br>
    <input type="button" id="btn1" value="处理协同任务" onclick="ywxtgzrwb()" /> 	
</body>
<script type="text/javascript">
function infoOpen(editUrl,title,paramArray){
	var editUrl = contextPath + editUrl;
   	openWindow(false, 'xtrwclWindow', editUrl, {document: document}, {title: '协同任务处理',    
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
	    modal: true,
	    buttons:[
	    	{
				text: '同意',
				handler: function() {
					$('#xtrwclWindow').dialog('close');
				}
			}
		]}
   	);
}

//业务协同规则任务表
function ywxtgzrwb(){ 
	var id='b1d8950d1aee4981b58918b5dad1b129';
	var editUrl = contextPath + '/ywxtgzrwb/ywxtgzrwbView?id='+id;
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
   	openWindow(false, 'xtrwclWindow', editUrl, {document: document}, {title: '协同任务处理',    
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
	    modal: true,
	    buttons:[
	    	{
				text: '同意',
				handler: function() {
					$('#xtrwForm').form('submit');
					$('#xtrwclWindow').dialog('close');
				}
			},
			{
				text: '拒绝',
				handler: function() {
					$('#xtrwclWindow').dialog('close');
				}
			},
			{
				text: '共存',
				handler: function() {
					$('#xtrwclWindow').dialog('close');
				}
			}
		]}
   	);
}

</script>
</html>
