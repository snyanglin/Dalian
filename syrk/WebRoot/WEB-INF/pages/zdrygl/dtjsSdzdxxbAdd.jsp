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
<title>吸毒 信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dtjsMore/saveDtjsSdzdxxb" id="dataForm" name="dataForm" method="post" >
    	<input type="hidden" id="pk" name="id" value="${entity.id}" />
    	<input type="hidden" id="zdryzjhm" name="zdryzjhm" value="${entity.zdryzjhm}" />
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	
			
	        </tr>
		     	<td width="20%" class="dialogTd" align="right">毒品种类：</td>
		        <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="dpzl" name="dpzl"   style="width:200px;" value="${entity.dpzl}"
	    			data-options="url: contextPath +  '/common/dict/JD_D_DPZLDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
		       </td>
		      <td width="20%" class="dialogTd" align="right">毒品种类其他：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-validatebox" type="text" id="dpzlqt" name="dpzlqt" value="${entity.dpzlqt}" data-options="validType:['maxLength[100]'],invalidMessage:'毒品种类其他不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		     <tr class="dialogTr">
		  	    	<td width="20%" class="dialogTd" align="right">制毒化学品：</td>
	    		<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="zdhxp" name="zdhxp"   style="width:200px;" value="${entity.zdhxp}"
					data-options="url: contextPath +  '/common/dict/D_QBLD_ZDHXP.js',
				valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
				</td>
		        <td width="20%" class="dialogTd" align="right">制毒化学品其他：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-validatebox" type="text" id="zdhxpqt" name="zdhxpqt" value="${entity.zdhxpqt}" data-options="validType:['maxLength[100]'],invalidMessage:'制毒化学品其他不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		       
		    </tr>	
            <tr class="dialogTr">
		  	    	<td width="20%" class="dialogTd" align="right">毒品去向：</td>
	    		<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="dpqx" name="dpqx"   style="width:200px;" value="${entity.dpqx}"
					data-options="url: contextPath +  '/common/dict/D_QBLD_DPQX.js',
				valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
				</td>
		        <td width="20%" class="dialogTd" align="right">毒品去向其他：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-validatebox" type="text" id="dpqxqt" name="dpqxqt" value="${entity.dpqxqt}" data-options="validType:['maxLength[100]'],invalidMessage:'毒品去向其他不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
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
		       <td width="20%" class="dialogTd" align="right">贩卖地点：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-validatebox" type="text" id="fmdd" name="fmdd" value="${entity.fmdd}" data-options="validType:['maxLength[200]'],invalidMessage:'贩卖地点不能超过200个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		       </td>
    	    </tr>
		   
    	    
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 

    if("${type}"=="view"){
    	setInputReadonly("dpzl", true);
    	setInputReadonly("zdhxp", true);
    	setInputReadonly("dzly", true);
    	setInputReadonly("zdhxpqt", true);
    	setInputReadonly("dpqx", true);
    	setInputReadonly("dpqxqt", true);
    	setInputReadonly("shdzqx", true);
    	setInputReadonly("dzqxqt", true);
    	setInputReadonly("fmdd", true);
    	setInputReadonly("dpzlqt", true);
    	setInputReadonly("dzlyqt", true);
    	
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