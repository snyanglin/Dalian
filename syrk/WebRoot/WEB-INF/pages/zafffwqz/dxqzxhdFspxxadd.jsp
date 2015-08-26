<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String tbrxmss = "";
    String myOrgName = "";
    if(userInfo!=null){
        tbrxmss = userInfo.getUserName();
        myOrgName = userInfo.getUserOrgName();
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大型活动非审批新增</title>
</head>
<div class="easyui-layout" data-options="fit:true">
<form action="<%=basePath%>DxqzxhdFspxxb/saveDxqzxhdFspxxb" id="dataForm" name="dataForm" method="post">
	    <div data-options="region:'center', split:true" style="width:100%;height:50% border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<input type="hidden" id="pk" name="id" value="${entity.id}" />
			<tr class="dialogTr">
				<td width="15%" class="dialogTd" align="right">填报单位：</td>
			   	<td  width="35%">
			   	<input  id="orgcode1"  name="orgcode1" value="" style="width: 10;"  type="hidden" />
			    <input type="text" id="tbdw" name="tbdw" style="width: 200;" value="${entity.tbdw}"  readonly="readonly"/>
			   	<input  id="orgid1" name="orgid1" value="" style="width: 10;"  type="hidden" />
			    <input type="button" id="orgbutton1" value="选择" onClick="public_singleSelectOrg('', '01', '', '', 'orgcode1', 'tbdw', 'orgid1', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
			    </td>
				 
				<td width="15%" class="dialogTd" align="right">填报时间：</td>
				<td width="35%" class="dialogTd">
				<input  type="text" id="tbsj" name="tbsj" class="easyui-validatebox" style="width:200px;"
				 maxlength="19" value="${entity.tbsj}" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'"/></td>	
			</tr>
			 <tr class="dialogTr">
				<td width="15%" class="dialogTd" align="right">活动名称：</td>
				<td width="35%" class="dialogTd"><input  type="text" id="hdmc" name="hdmc" class="easyui-validatebox" style="width:200px;"
				 maxlength="50" value="${entity.hdmc}"  data-options="required:false,validType:'maxLength[100]'" /></td>
				 <td width="15%" class="dialogTd" align="right">活动规模：</td>
				<td width="35%" class="dialogTd"><input  type="text" id="hdgm" name="hdgm" class="easyui-validatebox" style="width:165px;"
				 maxlength="50" value="${entity.hdgm}"  data-options="required:false,validType:['maxLength[50]','naturalNumber']" />（人）</td>
			</tr>
			 <tr class="dialogTr">
				<td width="15%" class="dialogTd" align="right">活动地点：</td>
				<td width="35%" class="dialogTd"><input  type="text" id="hddd" name="hddd" class="easyui-validatebox" style="width:200px;"
				 maxlength="50" value="${entity.hddd}"  data-options="required:false,validType:'maxLength[100]'" /></td>
				<td width="15%" class="dialogTd" align="right">举办单位：</td>
				<td width="35%" class="dialogTd"><input  type="text" id="jbdw" name="jbdw" class="easyui-validatebox" style="width:200px;"
				 maxlength="50" value="${entity.jbdw}"  data-options="required:false,validType:'maxLength[50]'" /></td>
			</tr>
			 <tr class="dialogTr">
				<td width="15%" class="dialogTd" align="right">活动开始时间：</td>
				<td width="35%" class="dialogTd">
				<input  type="text" id="hdkssj" name="hdkssj" class="easyui-validatebox" style="width:200px;"
				 maxlength="19" value="${entity.hdkssj}"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'hdjssj\') }'})"data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'"/></td>
				<td width="15%" class="dialogTd" align="right">活动结束时间：</td>
				<td width="35%" class="dialogTd">
				<input  type="text" id="hdjssj" name="hdjssj" class="easyui-validatebox" style="width:200px;"
				 maxlength="19" value="${entity.hdjssj}" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'hdkssj\') }'})" data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'"/></td>		
			</tr>
			<tr class="dialogTr">
				<td width="15%" class="dialogTd" align="right">承办单位：</td>
				<td width="35%" class="dialogTd"><input  type="text" id="cbdw" name="cbdw" class="easyui-validatebox" style="width:200px;"
				 maxlength="50" value="${entity.cbdw}"  data-options="required:false,validType:'maxLength[50]'" /></td>
				<td width="15%" class="dialogTd" align="right">承办单位负责人：</td>
				<td width="35%" class="dialogTd"><input  type="text" id="cbdwfzr" name="cbdwfzr" class="easyui-validatebox" style="width:200px;"
				 maxlength="50" value="${entity.cbdwfzr}"  data-options="required:false,validType:'maxLength[20]'" /></td>
			</tr>
			<tr class="dialogTr">
				<td width="15%" class="dialogTd" align="right">联系方式：</td>
				<td width="35%" class="dialogTd"><input  type="text" id="lxfs" name="lxfs" class="easyui-validatebox" style="width:200px;"
				 maxlength="50" value="${entity.lxfs}"  data-options="required:false,validType:'maxLength[20]'" /></td>
			</tr>
			<tr class="dialogTr">
    		<td width="15%" class="dialogTd" align="right">活动主要内容：</td>
		    	<td width="85%" class="dialogTd" colspan="3" ><textarea id="hdzynr" name="hdzynr" class="easyui-validatebox" style="width: 613px; height:48px;"
					data-options="validType:['maxLength[2000]'],invalidMessage:'活动主要内容不能超过2000个汉字，请重新输入！',tipPosition:'left'">${entity.hdzynr}</textarea></td>
    		</tr>
    		<tr class="dialogTr">
    		<td width="15%" class="dialogTd" align="right">市(县/区)局意见：</td>
		    	<td width="85%" class="dialogTd" colspan="3" ><textarea id="sxqjyj" name="sxqjyj" class="easyui-validatebox" style="width: 613px; height:48px;"
					data-options="validType:['maxLength[2000]'],invalidMessage:'市(县/区)局意见不能超过2000个汉字，请重新输入！',tipPosition:'left'">${entity.sxqjyj}</textarea></td>
    		</tr>
    		<tr class="dialogTr">
    		<td width="15%" class="dialogTd" align="right">备注：</td>
		    	<td width="85%" class="dialogTd" colspan="3" ><textarea id="bz" name="bz" class="easyui-validatebox" style="width: 613px; height:48px;"
					data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea></td>
    		</tr>
    		<tr class="dialogTr">
				<td width="15%" class="dialogTd" align="right">填表人：</td>
				<td width="35%" class="dialogTd"><input  type="text" id="tbr" name="tbr" class="easyui-validatebox" style="width:200px;"
				 maxlength="50" value="${entity.tbr}"  data-options="required:false,validType:'maxLength[20]'" /></td>
				<td width="15%" class="dialogTd" align="right">审核人：</td>
				<td width="35%" class="dialogTd"><input  type="text" id="shr" name="shr" class="easyui-validatebox" style="width:200px;"
				 maxlength="50" value="${entity.shr}"  data-options="required:false,validType:'maxLength[20]'" /></td>
			</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
function body_onload() {
	$('#dataform').form({  
        onSubmit:function(){
            return $(this).form('validate');  
        },  
        success:function(data){  
            alert(data);  
        }  
    });   
} 
//为填报时间进行时间格式转换
function setDates(){
	var dates = new Date();
	var year = dates.getFullYear();
	var date = dates.getDate();
	var month = dates.getMonth()+1;
	if(month<10){
		month='0'+month;
	}
	var rishuchu = year+'-'+month+'-'+date;
	$("#tbsj").val(rishuchu);
}
// 页面加载完成事件
window.onload = function() {
	setDates();
	$("#tbr").val('<%=tbrxmss%>');  
	$("#tbdw").val('<%=myOrgName%>');
	body_onload();
}
//重置
function resetForm(){
	$("#jzqkms").val("");
	$("#gzjzsj").val("");
	$("#bz").val("");
}
function onOrgSelected(orgCodeInputID) {
	//alert(orgCodeInputID);
}
</script>