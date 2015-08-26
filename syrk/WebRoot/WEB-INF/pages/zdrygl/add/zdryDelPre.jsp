<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="<%=contextPath%>/js/zdrygl/zdryAdd.js"></script>
<title>重点人员撤管</title>
</head>

<body style="margin-top:20px; margin-bottom:10px" class="bodybg" onload="startup()">
<div data-options="region:'center',split:true" style="border-width: 0px;margin:0 0 0;text-align:center;" class="bodybg">
	<table height="100%" style="margin:0 auto;"><tr><td height="100%" valign="top" align="center">
		<div class="pop_conta">
		<div class="pop_contb">
		<div class="pop_contc"> 
 		<div data-options="region:'center', split:true" style="width:800px; border-width: 0px;">

        <form action="<%=basePath%>zdryzb/saveCg"  id="dataForm" name="dataForm" method="post" >
	    	<input type="hidden" id="id" name="zdryZdryzb.id" value="${zdryzb.id}" />
	    	<input type="hidden" id="zdrygllxdm_old"  name="zdryZdryzb.zdrygllxdm" value="${zdryzb.zdrygllxdm}" />
	    	<input type="hidden" id="syrkid" name="zdryZdryzb.syrkid" value="${zdryzb.syrkid}" />
    	
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" name="xm" style="width:200px;" readonly="readonly"  value="${syrk.xm}"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zjhm" style="width:200px;" readonly="readonly" value="${syrk.zjhm}"/></td>
		    </tr>
		    <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">已列管类型：</td>
	    		<td width="80%" class="dialogTd" colspan="3">
	    			<input class="easyui-validatebox inputreadonly" type="text"  id="ylglx" style="width:200px;" readonly="readonly"  value="${zdrylxmc}"/>
		    	</td>
		    </tr>
		   <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">撤管类型：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
					<input class="easyui-combobox" type="text"  id="zdrygllxdm" name="cglxdm"   style="width:200px;" value=""
					data-options="url: contextPath +'/zdryzb/queryZdryCgList?zdrylxdm=${zdryzb.zdrygllxdm}',  
					valueField:'lbdm',textField:'bz',selectOnNavigation:false,method:'get',required:false,tipPosition:'right',onChange:cghlx"/>

	    			<input type="text" name="zdryZdryzb.zdrylb" id="zdrylbStr"  class="easyui-combotree" style="width:400px;"
	    			data-options="onlyLeaf:true,valueField:'lbdm',textField:'bz',
	    			multiple:false,required:false,panelWidth:400,method:'get',lines:true,tipPosition:'left',onChange:cghlx_xl" >
		    	</td>
		    </tr>
		    <tr class="dialogTr" id="cgyyText">
		    	<td width="20%" class="dialogTd" align="right" >撤管原因：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-validatebox " type="text" id="cgyy" name="ywsqyy" style="width: 619px;" data-options="required:false,validType:['maxLength[100]','unnormal']" /></td>
	    	</tr>
	    	<tr class="dialogTr" id="cgyyZd" style="display:none">
		    	<td width="20%" class="dialogTd" align="right" >撤管原因：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-combobox" type="text" id="cgyyCombo" style="width:200px;" 
								data-options="url:contextPath +'/common/dict/BD_D_ZDRYLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
			</tr>
		    </table>
 			<!-- 这里引用公用列管信息模块 -->
		    <%@include file="/WEB-INF/pages/zdrygl/add/zdryLgLxInc.jsp"%>
		     <!-- 列管公共信息 -->
	    	<table id="ggDiv" border="0" cellpadding="0" cellspacing="10" width="100%" align="center" style="margin-top: -10px;">
	    	
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="lgrqText">业务办理日期：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="ywclsj" id="ywclsj" class="easyui-validatebox inputreadonly" style="width: 200px;" value="${blrq}" readonly="readonly" /></td>
		    	<td width="20%" class="dialogTd" align="right" id="lgrText">业务办理人：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" id="ywblr_xm" name="ywblr_xm" style="width:200px;" value="${userName}" readonly="readonly" />
		    	</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right" id="lgsqyjText">申请意见：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input class="easyui-validatebox " type="text" id="ywfqyy_cg" name="zdryLczywblb.ywfqyy" style="width: 619px;" data-options="required:false,validType:['maxLength[100]','unnormal']" /></td>
	    	</tr>
	    	
	    	</table>
	    		    	
   		 </form>
	    </div>
	</div>
			
		</div>
	    </div>
	    
	    <div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px;">
			<a id="saveButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="saveCgForm()">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">保存</span>
					<span class="l-btn-icon icon-save"> </span>
				</span>
			</a>			
		</div>	     
	   
	</td></tr></table>
</div>
</body>
<script type="text/javascript" >
var mainTabID = "${mainTabID}";
var invokeJSMethod = "${invokeJSMethod}";
var pcsdm = "${pcsdm}";
var zrqdm = "${zrqdm}";
var cyzjdm = "${ryRyjbxxb.cyzjdm}"; 
var zjhm = "${ryRyjbxxb.zjhm}"; 
function doInit(paramArray) {
	$.ajax({
		type: "POST",
		url: contextPath + "/zdryzb/queryLglxByZdrylx",
		dataType: "json",
		data:"&syrkid=" + syrkid,
		success: function(data) {
			if (data) {								
				$('#zdrygllxdm').combobox('setDataFilter', '[^'+data+']');
			}
		},		
		error: function() {
		}
	});	
}

function beforeSubmit() {
}

function afterSubmit() {
}	

function startup(){
	$("#jgdxDiv").hide();
	$("#zdrkDiv").hide();
	$("#zszhjsbrDiv").hide();
	$("#fzcfryDiv").hide();
	$("#sqjzryDiv").hide();
	$("#sqsbzdryDiv").hide();
	$("#sgafzdryDiv").hide();
	//$("#ggDiv").hide();	
};

function cghlx(newValue, oldValue){
	zdrylxChange(newValue, oldValue);
	if(newValue){
		newValue = newValue.substr(0,newValue.indexOf("/"));
		if(newValue == "01")
			$('#cgyyCombo').combobox('setDataFilter', '^[1]');
		else if(newValue == "02"){
			$('#cgyyCombo').combobox('setDataFilter', '^[2]');
		}else if(newValue == "03"){
			$('#cgyyCombo').combobox('setDataFilter', '^[3]');
		}else if(newValue == "08"){
			$('#cgyyCombo').combobox('setDataFilter', '^[8]');
		}
		var name = $("#xm").val();
		
		var cglb= 	$("#ylglx").val();
		var cghlb = $("#zdrygllxdm").combo("getText");
		//$("#ywfqyy_cg").val( "申请将【"+name+"】的重点人员管理类别“"+cglb+"”撤管为“"+cghlb+"”管理。");
	}
}

function init(){
	var gllxdm_old = $("#zdrygllxdm_old").val();
	 $('#zdrygllxdm').combobox('setDataFilter', '^[a]');
	if(gllxdm_old ==  "01"||gllxdm_old ==  "02"||gllxdm_old ==  "03"||gllxdm_old ==  "08"){
		//则撤管原因为字典
		$("#cgyyText").hide();
		$("#cgyyZd").show();
		if(gllxdm_old ==  "01")
		  $('#zdrygllxdm').combobox('setDataFilter', '^[0][2]|^[0][6]');
		if(gllxdm_old ==  "02"||gllxdm_old ==  "04")
		  $('#zdrygllxdm').combobox('setDataFilter', '^[0][6]');
		
	}else{
		if(gllxdm_old ==  "05")
			  $('#zdrygllxdm').combobox('setDataFilter', '^[0][6]');
		$("#cgyyText").show();
		$("#cgyyZd").hide();
	}
}

function cghlx_xl(newValue, oldValue){
	//if($("#cgyyCombo").combo("getValues").length > 75){
	//
	//}
}



/**
 * 根据撤管类型,得到撤管后的类型,大类选择
 */
function getcghlx(newValue,oldValue){
	var name = $("#xm").val();
	if(newValue){
		var cglx=newValue;
		var zdrylx="5|6";
		if(cglx=="1"){
			zdrylx="2|5"
		}else if(cglx=="5"){
			zdrylx="6"
		}
		$('#zdrygllxdm').combobox('setDataFilter', zdrylx);
		if(zdrylx=='6'){
		//$('#zdrygllxdm').combobox('setValue', zdrylx);
		setComboRequired("zdrylbStr", false);
		}
	}
}



function closeWindow(){
	closeSelf();
}

function querySyrk(){
	$("#syrkDiv").window("open");
}
//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}
function querySyrkClose(){
	$("#syrkDiv").window("close");
}
function syrkQuery(){
	var xm = document.getElementById("syrkXm").value;
	var cyzjdm = document.getElementById("syrkCyzjdm").value;
	var zjhm = document.getElementById("syrkZjhm").value;
	var xbdm = document.getElementById("syrkXbdm").value;	
	var jzd_dzxz = document.getElementById("syrk_jzd_dzxz").value;	
	$('#dg').datagrid('load',{    		
		'xm':xm,
		'cyzjdm':cyzjdm,
		'zjhm':zjhm,
		'xbdm':xbdm,		
		'jzd_dzxz':jzd_dzxz
	});
}

function selectOne(val,row,index){
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="selectSyrk('+index+')">选择</a>&nbsp;';
}

function selectSyrk(index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	$("#xm").val(rowData.xm);
	$("#zjhm").val(rowData.zjhm);
	$("#syrkid").val(rowData.id);	
	querySyrkClose();
	queryYlglx(rowData.ryid,rowData.id)
}

//查询已列管类型
function queryYlglx(ryid,syrkid){
	$.ajax({
		type: "POST",
		url: contextPath + "/zdryzb/queryYlglx",
		dataType: "json",
		data:"ryid=" + ryid + "&syrkid=" + syrkid,
		success: function(data) {
			if (data) {								
				$("#ylglxTr").show();
				$("#ylglx").text(data);

			}else{
				$("#ylglxTr").hide();
			}
		},		
		error: function() {
			$("#ylglxTr").hide();
		}
	});	
}

//保存按钮
function saveCgForm(){
	var formObject = $("#dataForm");	
	if (formObject.form('validate')) {
		$("#dataForm").form("submit",{
			url:document.dataForm.action,
			dataType : "json",
			onSubmit: function() {},
			success: function(result) {				
				//buttonEnabled(bottonObject);
				result = parseReturn(result);
				if (result.status == "success") { // 返回成功后执行的方法
					alert("撤管申请成功");
					closeWindow();
				}
				else {
					topMessager.alert(MESSAGER_TITLE, result.message, "error");
				}
			}
		});		
				
	}else{
		return false;
	}
		
}
$(document).ready(function(){
	init();
});

</script>

</html>
