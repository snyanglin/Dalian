<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
<title>新增(修改)视频建设单位</title>
<script type="text/javascript">
var mainTabID = '${mainTabID}';
var mode = '${mode}';
</script>
</head>
  
 <body>
 <div>
 	

 
 </div>
 <hr>
 <div id="mainPanel" class="easyui-panel" style="width:500px;height:400px;padding:10px;"   
        title="从远程实时拿取数据功能测试" data-options="iconCls:'icon-save',collapsible:true">   

<input class='easyui-combobox' type='text' id="mz" name='mz'  style="width:200px;"  maxlength="30"
     	data-options="mode:'remote',method:'post',url:contextPath+'/idName/getIdNameByCondition',required:true,valueField: 'id',textField:'name'"/>
<br>
<input class="easyui-combobox" data-options="mode:'remote',method:'post',url:contextPath+'/idName/getIdNameByCondition',panelHeight: 22,valueField:'id',textField:'name',selectOnNavigation:false,required:false" type="text" name="dl_org" id="dl_org" value="${czrk.dl_org}" maxlength="50"  style="width:595px;" /></td>
	
	
	
	
	<button onclick="getSelectedValue()">获得选择的值</button>
	
</div> 
<script type="text/javascript">
$(document).ready(function(){
	//服务处所选择
	initDepartmentSearch('jwry_gzdwmc-box', {glpcsid: ''}, 'jwry_gzdwid', 'jwry_gzdwmc', {});
	
	initDepartmentSearch('czrk_fwcs-box', {glpcsid: ''}, 'czrk_fwcsid', 'czrk_fwcs', {});
	initDepartmentSearch('jzrk_fwcs-box', {glpcsid: ''}, 'jzrk_fwcsid', 'jzrk_fwcs', {});
	initDepartmentSearch('ldrk_fwcs-box', {glpcsid: ''}, 'ldrk_fwcsid', 'ldrk_fwcs', {});
	initDepartmentSearch('wlczrk_fwcs-box', {glpcsid: ''}, 'wlczrk_fwcsid', 'wlczrk_fwcs', {});
});



</script>

<script type="text/javascript">

function getSelectedValue(){
	var selValue=$('#mz').combobox('getValue');
	var selText=$('#mz').combobox('getText');
	alert(selValue+","+selText);
}
</script>
</body>
</html>
