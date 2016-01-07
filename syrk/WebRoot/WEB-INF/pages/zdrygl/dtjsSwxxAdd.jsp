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
<title>维稳信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dtjsMore/saveDtjsSwxx" id="dataForm" name="dataForm" method="post" >
    	<input type="hidden" id="pk" name="id" value="${entity.id}" />
    	<input type="hidden" id="zdryzjhm" name="zdryzjhm" value="${entity.zdryzjhm}" />
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	
			
	       <tr>
		     		<td width="20%" class="dialogTd" align="right">重点人员所属类型：</td>
	    		<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="sslb" name="sslb"   style="width:200px;" value="${entity.sslb}"
					data-options="url: contextPath +  '/common/dict/BD_D_QBZDRYLBDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
				</td>
	    		<td width="20%" class="dialogTd" align="right">重点人员所属细类：</td>
		       	 <td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="sslbxl" name="sslbxl" value="${entity.sslbxl}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/BD_D_QBZDRYXLDM.js',onlyLeaf:true,multiple:false,panelWidth:200,method:'get',editable:true,lines:true"/></td>
             </tr>
		     <tr class="dialogTr">
		      <td width="20%" class="dialogTd" align="right">所属组织：</td>
		       <td width="80%" class="dialogTd" colspan="3">
		          	<input type="hidden" id="sszzdm" name="sszzdm" value="${entity.sszzdm}" style="width: 100;" />
				    <input class="easyui-validatebox" type="text" id="sszzmc" name="sszzmc" value="${entity.sszzmc}" style="width:200px;" data-options="readonly:true"/>
				    
				  	<input type="hidden" id="sszzid" name="sszzid" value="" style="width: 100;" />
				    
				    <input type="button" id="orgbutton11" value="选择" onClick="public_singleSelectOrg('', '', '', '', 'sszzdm', 'sszzmc', 'sszzid', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
					          
		       </td>
		    </tr>	

		    <tr>
		        <td width="20%" class="dialogTd" align="right">情况概述：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="qkgs" id="qkgs" class="easyui-validatebox" style="width: 627px; height:48px;"
					data-options="required:false,validType:['maxLength[500]'],invalidMessage:'情况概述超过500个汉字，请重新输入！',tipPosition:'left'">${entity.qkgs}</textarea></td>
    	    </tr>
		
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 

    if("${type}"=="view"){
    	setInputReadonly("sslb", true);
    	//setInputReadonly("sslbxl", true);
    	setInputReadonly("sszzmc", true);
    	setInputReadonly("qkgs", true);
    	
    	
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
