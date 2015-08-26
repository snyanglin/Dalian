<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>comboBox测试</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
</head>
  
 <body>
 <div>
 	

 
 </div>
 <hr>
 <div id="mainPanel" class="easyui-panel" style="width:500px;height:400px;padding:10px;"   
        title="从后台实时拿取数据功能测试" data-options="iconCls:'icon-save',collapsible:true">   

选择视频单位：
<input class="easyui-combobox" type="text" id="dwbm" name="dwbm" value="${entity.id}" style="width:200px;"  maxlength="30"		    	        	
		data-options="mode:'remote',isTopLoad:false,url:'<%=basePath%>idName/getSpdwIdNameByCondition',required:true,valueField: 'id',textField:'name',onLoadSuccess: function() {}" />	    	        	



<br>
  选择组织机构：
<input class='easyui-combobox' type='text' id="mz" name='mz'  style="width:200px;"  maxlength="30"
     	data-options="mode:'remote',url:'<%=basePath%>idName/getOrgCodeNameByCondition',required:true,valueField: 'id',textField:'name',onLoadSuccess: function() {}"/>
 <button onclick="getSelectedValue()">获得选择的值</button>

</div> 
<script type="text/javascript">

function getSelectedValue(){
	var selValue=$('#mz').combobox('getValue');
	var selText=$('#mz').combobox('getText');
	alert(selValue+","+selText);
}
</script>
</body>
</html>
