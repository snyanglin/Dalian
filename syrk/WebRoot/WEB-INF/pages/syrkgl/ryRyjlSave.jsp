<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>会员卡新建</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>ryRyjlxxb/save" id="dataForm" name="dataForm" method="post" >
    	<input type="hidden" id="ryid" name="ryid" value="${entity.ryid}" />
    	<input type="hidden" id="pk" name="id" value="${entity.id}" />
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<td width="20%" class="dialogTd" align="right">经历类型：</td>
		    <td width="30%" class="dialogTd">
		    	<input class="easyui-combobox" type="text"  id="jllxdm" name="jllxdm"   style="width:200px;" value="${entity.jllxdm}"
					data-options="url: contextPath +  '/common/dict/BD_D_JLLXDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
		    </td>
	
		     <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">开始时间：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="kssj" id="kssj" class="easyui-validatebox" style="width: 200px;" value="${entity.kssj}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
		    	</td>
			    <td width="20%" class="dialogTd" align="right">结束时间：</td>
	            <td width="30%" class="dialogTd"><input type="text" name="jssj" id="jssj" class="easyui-validatebox" style="width: 200px;" value="${entity.jssj}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',minDate:'#F{$dp.$D(\'kssj\')}'})"/>
		    	</td>
		    </tr>
		    	    	
		    <tr>
		    <td width="20%" class="dialogTd" align="right">单位：</td>
			<td width="80%" class="dialogTd" colspan="3">
				    	<input type="hidden" id="dwid" name="dwid" value="${entity.dwid}" />
				    	<input type="hidden" id="dwmc" name="dwmc" value="${entity.dwmc}" />				         
						<input class="easyui-combobox" type="text" id="dwjbxxb_dwmc" data-options="tipPosition:'left',mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false" value="${entity.dwmc}" maxlength="50" style="width:627px;"/>
             </td>
		    </tr>
		 
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">职业类别：</td>
				<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="zylbdm" name="zylbdm" style="width:200px;" value="${entity.zylbdm}"
					data-options="required:false,tipPosition:'right',url: contextPath + '/common/dict/GB_D_ZYFLYDM.js',onlyLeaf:true,panelWidth:280,multiple:false,method:'get',editable:true,lines:true"/>
				</td>
				<td width="20%" class="dialogTd" align="right">职务名称：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="zwmc" name="zwmc" value="${entity.zwmc}" style="width:200px;" data-options="validType:['maxLength[20]'],invalidMessage:'职务名称不能超过20个汉字，请重新输入！',tipPosition:'left'"/>
		    	</td>
		    </tr>
		    <tr>
		        <td width="20%" class="dialogTd" align="right">经历情况：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="jlqk" id="jlqk" class="easyui-validatebox" style="width: 627px; height:48px;"
					data-options="required:true,validType:['maxLength[1000]'],invalidMessage:'经历不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.jlqk}</textarea></td>
    	    </tr>
		
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 
	initDepartmentSearch('dwjbxxb_dwmc', {glpcsid: ''}, 'dwid', 'dwmc', null, null);

}

function beforeSubmit() {
	
	if ($("#pk").val() == "") {
		$("#dataForm").attr('action', contextPath + '/ryRyjlxxb/save');
	}
	else {
		$("#dataForm").attr('action', contextPath + '/ryRyjlxxb/update');
	}
	if ($("#kssj").val() != "" && $("#jssj").val() != "" && $("#kssj").val() >  $("#jssj").val()) {
		topMessager.alert("", "开始时间不能小于结束时间，请重新输入！");
		$("#kssj").focus();
		return false;
	}
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}

</script>
</html>