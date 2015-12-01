<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>单位检查信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwjcxxb_dl/save" id="dataForm" name="dataForm" method="post">
    	
    	<input type="hidden" name="dwid"  id="dwid" value="${entity.dwid}" />
    
	    <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<input type="hidden" name="id" id="pk" value="${entity.id}" />
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">单位名称：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox inputreadonly" type="text" id="dwmc" style="width:620px;" readonly="readonly" /></td>
		    </tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">检查单位：</td>
		    	<td width="80%" class="dialogTd" colspan='3'>
		    		<input type="hidden" id="jcdwid" name="jcdwid" value="${entity.jcdwid}" style="width: 100;" />
		    		<input  class="easyui-validatebox inputreadonly" type="text" id="jcdw" name="jcdw" style=";" value="${entity.jcdw}" maxlength="50" style="width: 560;" readonly="readonly"/>
		    		<input type="hidden" id="orgid1" name="orgid1" value="" style="width: 100;" />
	    			<input type="button" id="orgbutton1" value="选择" onClick="public_singleSelectOrg('', '01', '', '', 'jcdwid', 'jcdw', 'orgid1', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" /></td>
		    </tr>
		    
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">检查时间：</td>
		    	<td width="30%" class="dialogTd" >
		    		<input class="easyui-validatebox" type="text" name="jcsj" id="jcsj"
		    			data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" 
		    				onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"
		    				style="width:200px" value="${entity.jcsj}" 
		    	 /></td>
				<td width="20%" class="dialogTd" align="right">检查项目：</td>
		    	<td width="30%" class="dialogTd" >
		    		<input class="easyui-validatebox" type="text"  name="jcxm" id="jcxm" maxlength="100"
						data-options="required:false,method:'get',tipPosition:'left'"
		    	 style="width:200px" value="${entity.jcxm}"
		    	 /></td>		   
		   
		    </tr>		    
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">整改通知书或裁决书号：</td>
		    	<td width="30%" class="dialogTd">
		    			<input class="easyui-validatebox" type="text" name="zgtzshcjsh" id="zgtzshcjsh" maxlength="30"
		    			data-options="validType:['maxLength[30]'],tipPosition:'right'"
		    			style="width:200px" value="${entity.zgtzshcjsh}"
		    	 /></td>
		    	 
		    	<td width="20%" class="dialogTd" align="right">整改通知书名称：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="zgtzsmc" id="zgtzsmc"
		    	data-options="validType:['maxLength[30]'],tipPosition:'left'"   value="${entity.zgtzsmc}"
		    	style="width:200px"/></td>
		    </tr>
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">单位负责人：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" name="dwfzr" id="dwfzr"
		    			data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"
		    			style="width:200px"   value="${entity.dwfzr}"
		    	 /></td>
		    	 
		    	<td width="20%" class="dialogTd" align="right">检查人员：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="jcry" id="jcry"
		    		data-options="required:false,validType:['maxLength[100]'],tipPosition:'left'"  value="${entity.jcry}"  
		    		style="width:200px"/></td>
		    </tr>		    		    
		    <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">检查情况：</td>
				<td width="80%" class="dialogTd" colspan='3'>
				<textarea id="jcqk" name="jcqk" class="easyui-validatebox" style="width: 620px; height:48px;"
					data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'物防设施不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.jcqk}</textarea>
				
				</td>
			 </tr>	
			 
			 <tr>	    
				<td width="20%" class="dialogTd" align="right">检查结果：</td>
				<td width="80%" class="dialogTd" colspan='3'>
				<textarea id="jcjg" name="jcjg" class="easyui-validatebox" style="width: 620px;height:48px;"
					data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'技防设施不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.jcjg}</textarea>
				</td>
			</tr>
			

			 <tr>	    
				<td width="20%" class="dialogTd" align="right">整改或处罚意见：</td>
				<td width="80%" class="dialogTd" colspan='3'>
				<textarea id="zghcfyj" name="zghcfyj" class="easyui-validatebox" style="width: 620px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'技防设施不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.zghcfyj}</textarea>
				</td>
			</tr>

			

			<tr class="dialogTr">
		    	<td width="10%" class="dialogTd" align="right">清查项目：</td>
		    	<td width="90%" class="dialogTd" colspan="3"><textarea  id="qcxm" name="qcxm" class="easyui-validatebox"  
		    		data-options="required:false,validType:['maxLength[1000]'],tipPosition:'left'" style="width:620px;height:48px;">${entity.qcxm}</textarea></td>
		    	 
		    </tr>			
		    
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">清查结果：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea  class="easyui-validatebox"  name="qcjg" id="qcjg"
		    		data-options="required:false,validType:['maxLength[1000]'],tipPosition:'left'"
		    			style="width:620px;height:48px;">${entity.qcjg}</textarea></td>
		    	 
		    </tr>			
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">现场负责人：</td>
		    	<td width="30%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" name="xcfzr" id="xcfzr" value="${entity.xcfzr}"
		    		data-options="required:false,validType:['maxLength[100]'],tipPosition:'left'"
		    			style="width:620px;"
		    	 /></td>
		    	 
		    </tr>	



	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
function doInit(paramArray) {
	$("#dwmc").val(paramArray["dwmc"]);
}
function beforeSubmit() {
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}
function resetForm(){
	$("#jcdw").val("");
	$("#jcsj").val("");
	$("#jcxm").val("");
	$("#zgtzshcjsh").val("");
	$("#zgtzsmc").val("");
	$("#dwfzr").val("");
	$("#jcry").val("");
	$("#jcqk").val("");
	$("#jcjg").val("");
	$("#zghcfyj").val("");
	$("#qcxm").val("");
	$("#qcjg").val("");
	$("#xcfzr").val("");
}
</script>