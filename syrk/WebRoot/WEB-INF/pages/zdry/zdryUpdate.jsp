<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>重点人员列撤管</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>zdryLcg/update"  id="dataForm" name="dataForm" method="post" >
    	<input type="text" id="syrkid" name="zdryZdryzb.syrkid" value="${zdryVO.zdryZdryzb.syrkid}" />
    	<input type="hidden" id="id" name="zdryZdryzb.id" value="${zdryVO.zdryZdryzb.id}" />
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">姓名：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text"  id="xm" name="zdryZdryzb.xm" style="width:200px;" readonly="readonly"  value="${zdryVO.zdryZdryzb.xm}"/></td>
				<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox inputreadonly" type="text" name="zdryZdryzb.zjhm" style="width:200px;" readonly="readonly" value="${zdryVO.zdryZdryzb.zjhm}"/></td>
		    </tr>
		    <tr class="dialogTr"> 
		    	<td width="20%" class="dialogTd" align="right">重点人员管理类型：</td>
		    	<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="zdrygllxdm" name="zdryZdryzb.zdrygllxdm"   style="width:200px;" value="${zdryVO.zdryZdryzb.zdrygllxdm}" 
					data-options="url: contextPath +  '/common/dict/BD_D_ZDRYLBDMLIST_MUNICIPAL.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
				</td>
		    </tr>
		      <tr class="dialogTr">
	    		<td width="20%" class="dialogTd" align="right">重点人员类别：</td>
	    		<td width="80%" class="dialogTd" colspan="3"><input type="text" name="zdrylbStr" id="zdrylbStr"  class="easyui-combotree" style="width:619px;"
	    			data-options="url: contextPath + '/common/dict/BD_D_ZDRYLBDM.js',onlyLeaf:true,
	    			multiple:true,required:true,panelWidth:613,method:'get',lines:true,tipPosition:'left'" >
		    	</td>
		    </tr>
		    
		    </table>
 		<!-- 这里引用公用列管信息模块 -->
		    <%@include file="/WEB-INF/pages/zdry/zdryLgLxInc.jsp"%>
	    		    	
	    </div>
    </form>
    
</div>
<script type="text/javascript" >
var zdrygllxdm="${zdryVO.zdryZdryzb.zdrygllxdm}";
var _p;
var placeVersion = "<%=SystemConfig.getString("PlaceVersion")%>";

function doInit(paramArray) {
	_p = paramArray["_p"];
	$("#jgdxDiv").hide();
	$("#zdrkDiv").hide();
	$("#zszhjsbrDiv").hide();
	$("#fzcfryDiv").hide();
	$("#sqjzryDiv").hide();
	if(placeVersion=="大连版"){
		if(zdrygllxdm=="01"){
			$("#jgdxDiv").show();
		}else if(zdrygllxdm=="02"||zdrygllxdm == "03"){
			$("#zdrkDiv").show();
		}else if(zdrygllxdm=="04"||zdrygllxdm=="05"){
			$("#zszhjsbrDiv").show();
		}else if(zdrygllxdm=="06"){
			$("#fzcfryDiv").show();
		}
	}else if(placeVersion=="辽宁省厅版"){
		if(zdrygllxdm=="01"){
			$("#scpjs").hide();
			$("#sqjzryDiv").show();
		}else if(zdrygllxdm=="02"){
			$("#zdrkDiv").show();
		}else if(zdrygllxdm=="03"){
			$("#zszhjsbrDiv").show();
		}else if(zdrygllxdm=="04"){
			$("#fzcfryDiv").show();
		}

	}
	
	zdrylxChange(zdrygllxdm,"");
	var str11="${zdryVO.zdrylbStr}";
	var  zdrylbs = str11.split(',');
	$('#zdrylbStr').combotree('setValues', zdrylbs);
	var windowID = paramArray['windowID'];
	$('#sfcjslcjzdm').combobox('setValue', '${zdryVO.zdryZszhjsbrxxb.sfcjslcjzdm}');
	setInputReadonly('zdrygllxdm', true);

}

function beforeSubmit() {
	
}

function afterSubmit() {
	parent.location.reload();
}
</script>