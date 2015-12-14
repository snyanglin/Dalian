<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>工作纪实新增</title>
</head>
<div class="easyui-layout" data-options="fit:true">
<!-- <input type="hidden" id="totalUploadIdArray"/> -->
<form action="<%=basePath%>gzjs/saveGzjsxxb" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" id="sqid" name="sqid" value="${entity.sqid}" />
		<input type="hidden" id="sqjwsid" name="sqjwsid" value="${entity.sqjwsid}">
    	<input type="hidden" id="flag" name="flag" value="${flag}">
	    <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<input type="hidden" id="pk" name="id" value="${entity.id}" />
			 <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">工作纪实种类：</td>
				<td width="30%" class="dialogTd"><input  type="text" id="gzjszldm" name="gzjszldm" class="easyui-combobox" style="width:200px;"
				 data-options="url:contextPath+'/common/dict/D_ZAFF_GZJSZL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'" /></td>
				<td width="20%" class="dialogTd" align="right">汇报时间：</td>
				<td width="30%" class="dialogTd"><input  type="text" id="gzjshbsj" name="gzjshbsj" class="easyui-validatebox" style="width:200px;"
				 value="${entity.gzjshbsj}" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" 
				 data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'" /></td>	
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">汇报地点：</td>
				<td width="30%" class="dialogTd"><input  type="text" id="gzjshbdd" name="gzjshbdd" class="easyui-validatebox" style="width:200px;"
				 value="${entity.gzjshbdd}" maxlength="100"/></td>
				 <td width="20%" class="dialogTd" align="right">工作纪实简要描述：</td>
				<td width="30%" class="dialogTd"><input  type='text' id='gzjsjyms' name='gzjsjyms' class="easyui-validatebox" style="width:200px;"
				 value="${entity.gzjsjyms}" maxlength="100"/></td>	
			</tr>
			<tr class="dialogTr">
			<td align="right" width="20%">图片文件上传：</td>
			<td width="80%" colspan="3">
				<a id="" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="openUploadWindow();">
					<span class="l-btn-left l-btn-icon-left">
						<span class="l-btn-text">照片附件管理</span>
						<span class="l-btn-icon icon-attach"></span>
					</span>
				</a>
			</td>
			</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">工作纪实内容：</td>
		    	<td width="80%" class="dialogTd" colspan="3">
		    	<input type='hidden' id='gzjsnr' name='gzjsnr' value="${entity.gzjsnr}"/>
		    	<div id="myEditor" style="width: 613px; height:200px;"></div>
		    	</td>
	    	</tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz"  id="bz"  maxlength="1000" class="easyui-validatebox" style="width: 613px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea></td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" src="<%=contextPath%>/common/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/ueditor/ueditor.all.js"></script>
<script type="text/javascript" >

function openUploadWindow(){
	window.top.openWindowWithSave(false, 'addGzjsdmtWindow', window, 
   		{gzjsid:$('#pk').val()}, 
   		{
   		title: '照片附件管理',
   		url: '<%=basePath%>/gzjs/uploadImg?gzjsid='+$('#pk').val(),
   		maximizable: false,
   		width: 550,
   		height:600
   		}, 
   		null, null
   	);
}

function doInit(paramArray) {
	$("#sqid").val(paramArray["sqid"]);
	$("#sqjwsid").val(paramArray["sqjwsid"]);
}

var ue = UE.getEditor('myEditor', {
	maximumWords: 100
});

ue.ready(function(){
	ue.setContent($('#gzjsnr').val());
});

function body_onload() {

	window.parent.addId = $('#pk').val();
	window.parent.addCloseSubmit();
	
	$('#dataform').form({  
        onSubmit:function(){
            return $(this).form('validate');  
        },  
        success:function(data){  
        }  
    });   
    
} 
// 页面加载完成事件
window.onload = function() {
	body_onload();
}

function beforeSubmit() {
	var reg = new RegExp('"', 'g');
	$('#gzjsnr').val(ue.getContent().replace(reg, '\''));
}

function afterSubmit(arr) {
	window.parent.isAddSubmited = true;
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}
</script>