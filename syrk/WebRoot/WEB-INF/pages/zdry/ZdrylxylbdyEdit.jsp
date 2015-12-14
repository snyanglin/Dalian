<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
     <form action="<%=basePath%>zdrylxylbdyb/save" id="dataForm" name="dataForm" method="post">
	    <div data-options="region:'center', split:true" style="border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="816" align="center">
			<input type="hidden" name="id" value="${entity.id}"/>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">重点人员类型：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="zdrylxdm" name="zdrylxdm" style="width:200px;" value="${entity.zdrylxdm}" 
					data-options="url: contextPath + '/common/dict/BD_D_ZDRYLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true"/></td>
	    	</tr>
	    	<tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">重点人员类别：</td>
	    		<td width="80%" class="dialogTd" colspan="3"><input type="text" name="zdrylbdm" id="zdrylbdm"  class="easyui-combotree" style="width:493px;" value="${entity.zdrylbdm}" 
	    			data-options="url: contextPath + '/common/dict/DL_D_ZDRYLBDM.js',onlyLeaf:true,dataFilter:'^01|^02|^03',
	    			multiple:false,required:true,panelWidth:613,method:'get',editable:true,lines:true,tipPosition:'left'" >
		    	</td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >
var flag ="";
var zdrylxdmstart="";
var zdrylbdmstart="";
var zdrylxdm="";
var zdrylbdm="";
var zdrylbdmText="";
var zdrylxdmText="";
$(document).ready(function(){
	zdrylxdmstart = "${entity.zdrylxdm}";
	zdrylbdmstart = "${entity.zdrylbdm}";
		
});
function doInit(paramArray) {
}

function beforeSubmit() {
	var su = true;
	zdrylxdm =$("#zdrylxdm").combobox("getValue");
	zdrylbdm =$("#zdrylbdm").combotree("getValue");
	if(zdrylxdm==zdrylxdmstart&&zdrylbdm==zdrylbdmstart){
		alert("你未做任何修改，不能保存该数据项！");
		su = false;
	}
	if(su==false){
		
	}else {
		$.ajax({
		async:false,
		type:"POST",
		url:"<%= basePath%>zdrylxylbdyb/getisExist",
		dataType:"json",
		data:"zdrylbdm="+document.getElementById("zdrylbdm").value,
		success:function(data){
				if (data&&data.sfzhflag&&data.zdrylxdm) {
					if(data.sfzhflag==true){
							var zdrylxdmArray = new Array();
							zdrylxdmArray= data.zdrylxdm.split(",");
							for(var i=0;i<zdrylxdmArray.length;i++){
								if(zdrylxdm==zdrylxdmArray[i]){
									zdrylxdmText = window.top.getDictName(contextPath + '/common/dict/BD_D_ZDRYLBDM.js',zdrylxdmArray[i]);
											$.ajax({
											async:false,
											type:"POST",
											url:"<%= basePath%>zdrylxylbdyb/getZdrylxdm",
											dataType:"json",
											data:"zdrylxdm="+document.getElementById("zdrylxdm").value,
											success:function(data){
												if (data && data.sfzhflag&&data.zdrylbdm) {
													if(data.sfzhflag==true){
														var zdrylbdmArray = new Array();
														zdrylbdmArray = data.zdrylbdm.split(",");
														 for(var j=0;j<zdrylbdmArray.length;j++){
														 	if(zdrylbdmArray[j]==zdrylbdm){
														 		zdrylbdmText = window.top.getDictName(contextPath + '/common/dict/DL_D_ZDRYLBDM.js',zdrylbdmArray[j]);
																su = false;
																alert("【重点人员类别】"+zdrylbdmText+"已存在【重点人员类型】"+zdrylxdmText+"不能修改");
																return;	
														 	}else {
														 		
														 	}
														 }
														}else {
													
														}
													}
												}
											});
								}else {
									$.ajax({
											async:false,
											type:"POST",
											url:"<%= basePath%>zdrylxylbdyb/getZdrylxdm",
											dataType:"json",
											data:"zdrylxdm="+zdrylxdmArray[i],
											success:function(data){
												if (data && data.sfzhflag&&data.zdrylbdm) {
													if(data.sfzhflag==true){
														zdrylxdmText = window.top.getDictName(contextPath + '/common/dict/BD_D_ZDRYLBDM.js',zdrylxdmArray[i]);
														var zdrylbdmArray = new Array();
														zdrylbdmArray = data.zdrylbdm.split(",");
														 for(var j=0;j<zdrylbdmArray.length;j++){
														 	if(zdrylbdmArray[j]==zdrylbdm){
														 		zdrylbdmText = window.top.getDictName(contextPath + '/common/dict/DL_D_ZDRYLBDM.js',zdrylbdmArray[j]);
																flag ="1";
																return ;
														 	}else {
														 		
														 	}
														 }
														}else {
													
														}
													}
												}
											});
								}
							}
						
					}
					
					
				}else {
					flag="2";
				}
			}
		});
	}
	return su;
	
}

function afterSubmit(submitData) {
}
function getsubmitConfirm(){
	if(flag=="1"){
		return "【重点人员类别】"+zdrylbdmText+"，已属于【重点人员类型】"+zdrylxdmText+"，是否要强制解除原有关系，建立新的关系？";
	}else {
		return "您是否要保存数据？";
	}
  	
}

</script>

</body>
</html>