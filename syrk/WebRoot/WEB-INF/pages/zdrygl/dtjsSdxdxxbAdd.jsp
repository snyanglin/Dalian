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
    <form action="<%=basePath%>dtjsMore/saveDtjsSdxdxxb" id="dataForm" name="dataForm" method="post" >
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
				<td width="20%" class="dialogTd" align="right">毒品来源：</td>
	    		<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="dply" name="dply"   style="width:200px;" value="${entity.dply}"
					data-options="url: contextPath +  '/common/dict/JD_D_DPLYDM.js',
				valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
				</td>

		     <tr class="dialogTr">
		  	    <td width="20%" class="dialogTd" align="right">毒资来源：</td>
	    		<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="dzly" name="dzly"   style="width:200px;" value="${entity.dzly}"
					data-options="url: contextPath +  '/common/dict/JD_D_DZLYDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
				</td>
		        <td width="20%" class="dialogTd" align="right">是否复吸：</td>
	    		<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="sffx" name="sffx"   style="width:200px;" value="${entity.sffx}"
					data-options="url: contextPath +  '/common/dict/BD_D_SFDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
				</td>
		    </tr>	

		    <tr>
		       <td width="20%" class="dialogTd" align="right">吸食次数：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="xscs" name="xscs" value="${entity.xscs}" data-options="required:true,validType:['naturalNumber'],invalidMessage:'请输入自然数！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		      <td width="20%" class="dialogTd" align="right">戒断时间：</td>
		     <td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jdsj" name="jdsj" value="${entity.jdsj}" style="width:200px;" 
		    	 			data-options="required:true,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
    	    </tr>
		    <tr>
		       <td width="20%" class="dialogTd" align="right">吸食原因：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-combobox" type="text" id="xsyy" name="xsyy"  style="width:200px;" value="${entity.xsyy}" 
		           data-options="url: contextPath +  '/common/dict/D_QBLD_XSYY.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
		      </td>
		      <td width="20%" class="dialogTd" align="right">人员现状：</td>
		      <td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="ryxz" name="ryxz"   style="width:200px;" value="${entity.ryxz}"
					data-options="url: contextPath +  '/common/dict/BD_D_XDRYXZDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
				</td>
    	    </tr>  
    	        <tr>
    	         <td width="20%" class="dialogTd" align="right">危害后果：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="whhg" name="whhg"   style="width:200px;" value="${entity.whhg}"
	    			data-options="url: contextPath +  '/common/dict/D_QBLD_WHHG.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
		       </td>
		      <td width="20%" class="dialogTd" align="right">毒品种类其他：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-validatebox" type="text" id="dpzlqt" name="dpzlqt" value="${entity.dpzlqt}" data-options="validType:['maxLength[100]'],invalidMessage:'毒品种类其他不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		       </td>
		     	
    	    </tr>  
    	    <tr>
    	        <td width="20%" class="dialogTd" align="right">毒品来源其他：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-validatebox" type="text" id="dplyqt" name="dplyqt" value="${entity.dplyqt}" data-options="validType:['maxLength[100]'],invalidMessage:'毒品来源其他不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		       </td>
    	       <td width="20%" class="dialogTd" align="right">毒资来源其他：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-validatebox" type="text" id="dzlyqt" name="dzlyqt" value="${entity.dzlyqt}" data-options="validType:['maxLength[100]'],invalidMessage:'毒资来源其他不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		       </td>
		     	
    	    </tr>
    	    <tr>
   	         
    	         <td width="20%" class="dialogTd" align="right">是否戒断：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="sfjd" name="sfjd"   style="width:200px;" value="${entity.sfjd}"
	    			data-options="url: contextPath +  '/common/dict/BD_D_SFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
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
    	setInputReadonly("dply", true);
    	setInputReadonly("dzly", true);
    	setInputReadonly("sffx", true);
    	setInputReadonly("xscs", true);
    	setInputReadonly("jdsj", true);
    	setInputReadonly("xsyy", true);
    	setInputReadonly("ryxz", true);
    	setInputReadonly("whhg", true);
    	setInputReadonly("dpzlqt", true);
    	setInputReadonly("dplyqt", true);
    	setInputReadonly("dzlyqt", true);
    	setInputReadonly("sfjd", true);
    	
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