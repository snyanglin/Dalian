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


选择视频单位：
<input class="easyui-combobox" type="text" id="dwbm" name="dwbm" value="${entity.id}" style="width:200px;"  maxlength="30"		    	        	
		data-options="mode:'remote',isTopLoad:false,url:'<%=basePath%>idName/getSpdwIdNameByCondition',required:true,valueField: 'id',textField:'name',onLoadSuccess: function() {}" />	    	        	
 <button onclick="getSelectedValue('dwbm')">获得选择的值</button>

<hr>
 选择组织机构：
<input class='easyui-combobox' type='text' id="org" name='org'  style="width:200px;"  maxlength="30"
     	data-options="mode:'remote',isTopLoad:false,url:'<%=basePath%>idName/getIdNameByCondition?name=ORG',required:true,valueField: 'id',textField:'name',onLoadSuccess: function() {}"/>
 <button onclick="getSelectedValue('org')">获得选择的值</button>


 <p>
 选择行政区划:   
<input class='easyui-combobox' type='text' id="xzqh" name='xzqh'  style="width:200px;"  maxlength="30"
     	data-options="mode:'remote',isTopLoad:false,url:'<%=basePath%>idName/getIdNameByCondition?name=XZQH',required:true,valueField: 'id',textField:'name',onLoadSuccess: function() {} "/>
<button onclick="getSelectedValue('xzqh')">获得选择的值</button>
 	  
<p>
地理区域：
<input class='easyui-combobox' type='text' id="area" name='area'  style="width:200px;"  maxlength="30"
		data-options="mode:'remote',isTopLoad:false,url:'<%=basePath%>idName/getIdNameByCondition?name=AREA',required:true,valueField: 'id',textField:'name',onLoadSuccess: function() {} "/>
	<button onclick="getSelectedValue('area')">获得选择的值</button>
	
<script type="text/javascript">

function getSelectedValue(){
	var selValue=$('#mz').combobox('getValue');
	var selText=$('#mz').combobox('getText');
	alert(selValue+","+selText);
}
</script>
<script type="text/javascript">

function getSelectedValue(tagId){
	var selValue=$('#'+tagId).combobox('getValue');
	var selText=$('#'+tagId).combobox('getText');
	alert(selValue+"==>"+selText);
}
</script>
</body>
</html>
