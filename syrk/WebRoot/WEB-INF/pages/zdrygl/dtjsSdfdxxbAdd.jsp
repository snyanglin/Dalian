<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>

<html>
<% SessionBean userInfo = (SessionBean) session.getAttribute("userSession"); 

String userOrgCode = userInfo.getUserOrgCode();
String userOrgName = userInfo.getUserOrgName();

%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>贩毒信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dtjsMore/saveDtjsSdfdxxb" id="dataForm" name="dataForm" method="post" >
    	<input type="hidden" id="pk" name="id" value="${entity.id}" />
    	<input type="hidden" id="zdryzjhm" name="zdryzjhm" value="${entity.zdryzjhm}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">贩卖毒品种类：</td>
			        <td width="30%" class="dialogTd">
			           <input class="easyui-combobox" type="text"  id="fmdpzl" name="fmdpzl"   style="width:200px;" value="${entity.fmdpzl}"
		    			data-options="url: contextPath +  '/common/dict/JD_D_DPZLDM.js',
						valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
			       	</td>
					<td width="20%" class="dialogTd" align="right">毒品种类其他：</td>
					<td width="30%" class="dialogTd">
					     <input class="easyui-validatebox" type="text" id="dpzlqt" name="dpzlqt" value="${entity.dpzlqt}" data-options="validType:['maxLength[100]'],invalidMessage:'毒品种类其他不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
					</td>
		        </tr>
		     	<tr class="dialogTr">
		  	    	<td width="20%" class="dialogTd" align="right">毒品来源：</td>
		    		<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text"  id="dply" name="dply"   style="width:200px;" value="${entity.dply}"
						data-options="url: contextPath +  '/common/dict/JD_D_DPLYDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
					</td>
			        <td width="20%" class="dialogTd" align="right">毒品来源其他：</td>
			       	<td width="30%" class="dialogTd">
			           <input class="easyui-validatebox" type="text" id="dplyqt" name="dplyqt" value="${entity.dplyqt}" data-options="validType:['maxLength[100]'],invalidMessage:'毒品来源其他不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
			      	</td>
		    	</tr>	
           		<tr class="dialogTr">
		  	    	<td width="20%" class="dialogTd" align="right">贩卖毒品渠道：</td>
	    			<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text"  id="fmdpqd" name="fmdpqd"   style="width:200px;" value="${entity.fmdpqd}"
						data-options="url: contextPath +  '/common/dict/D_QBLD_FDQD.js',
						valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
					</td>
		        	<td width="20%" class="dialogTd" align="right">贩卖毒品渠道其他：</td>
			       	<td width="30%" class="dialogTd">
			           	<input class="easyui-validatebox" type="text" id="dpqdqt" name="dpqdqt" value="${entity.dpqdqt}" data-options="validType:['maxLength[100]'],invalidMessage:'贩卖毒品渠道其他不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
			      	</td>
		    	</tr>
		        <tr class="dialogTr">
		  	    	<td width="20%" class="dialogTd" align="right">毒资去向：</td>
		    		<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text"  id="shdzqx" name="shdzqx"   style="width:200px;" value="${entity.shdzqx}"
						data-options="url: contextPath +  '/common/dict/D_QBLD_DZQX.js',
						valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
					</td>
		        	<td width="20%" class="dialogTd" align="right">毒资去向其他：</td>
		       		<td width="30%" class="dialogTd">
		           		<input class="easyui-validatebox" type="text" id="dzqxqt" name="dzqxqt" value="${entity.dzqxqt}" data-options="validType:['maxLength[100]'],invalidMessage:'贩卖毒品渠道其他不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      		</td>
		    	</tr>
		    	<tr>
		       		<td width="20%" class="dialogTd" align="right">来源地：</td>
				    <td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" type="text"  id="lyd" name="lyd"   style="width:200px;" value="${entity.lyd}"
				             data-options="mode:'remote',
							valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
				    </td>
    	    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 
	initComboBox("lyd", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 

    if("${type}"=="view"){
    	setInputReadonly("fmdpzl", true);
    	setInputReadonly("dpzlqt", true);
    	setInputReadonly("dply", true);
    	setInputReadonly("dplyqt", true);
    	setInputReadonly("fmdpqd", true);
    	setInputReadonly("dpqdqt", true);
    	setInputReadonly("lyd", true);
    	setInputReadonly("shdzqx", true);
    	setInputReadonly("dzqxqt", true);
    	
    }
}



function beforeSubmit() {
	
	
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}

</script>
</html>