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
<title>上访信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dtjsMore/saveDtjsSfxx" id="dataForm" name="dataForm" method="post" >
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
	    		<td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="sslbxl" name="sslbxl"   style="width:200px;" value="${entity.sslbxl}"
	    			data-options="url: contextPath +  '/common/dict/BD_D_QBZDRYXLDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
              </tr>
		     <tr class="dialogTr">
		      <td width="20%" class="dialogTd" align="right">所属群体：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="ssqt" name="ssqt"   style="width:200px;" value="${entity.ssqt}"
	    			data-options="url: contextPath +  '/common/dict/BD_D_QBZDRYQTDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>	
		      <td width="20%" class="dialogTd" align="right">上访时间：</td>
		       <td width="30%" class="dialogTd"><input type="text" name="sfsj" id="sfsj" class="easyui-validatebox" style="width: 200px;" value="${entity.sfsj}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
		      </td>
		    </tr>	

		    <tr>
		       <td width="20%" class="dialogTd" align="right">上访地点：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="sfdd" name="sfdd" value="${entity.sfdd}" data-options="required:true,validType:['maxLength[100]'],invalidMessage:'上访地点不能超过200个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		      <td width="20%" class="dialogTd" align="right">包保单位名称：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="bbdwmc" name="bbdwmc" value="${entity.bbdwmc}" data-options="validType:['maxLength[100]'],invalidMessage:'包保单位名称不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
    	    </tr>
		    <tr>
		       <td width="20%" class="dialogTd" align="right">包保领导：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="bbld" name="bbld" value="${entity.bbld}" data-options="validType:['maxLength[100]'],invalidMessage:'包保领导不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		      <td width="20%" class="dialogTd" align="right">上访方式：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="sffs" name="sffs"   style="width:200px;" value="${entity.sffs}"
	    			data-options="url: contextPath +  '/common/dict/BD_D_SFFSDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
		       </td>	
    	    </tr>  
    	        <tr>
    	         <td width="20%" class="dialogTd" align="right">处置结果：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="czjg" name="czjg"   style="width:200px;" value="${entity.czjg}"
	    			data-options="url: contextPath +  '/common/dict/D_QBLD_CZJG.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
		       <td width="20%" class="dialogTd" align="right">处置人员：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="czry" name="czry" value="${entity.czry}" data-options="validType:['maxLength[100]'],invalidMessage:'处置人员不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		     	
    	    </tr>  
    	    <tr>
    	        <td width="20%" class="dialogTd" align="right">诉求级别：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="sqjb" name="sqjb"   style="width:200px;" value="${entity.sqjb}"
	    			data-options="url: contextPath +  '/common/dict/D_QBLD_SQJB.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
    	         <td width="20%" class="dialogTd" align="right">是否息访：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="sfxf" name="sfxf"   style="width:200px;" value="${entity.sfxf}"
	    			data-options="url: contextPath +  '/common/dict/BD_D_SFDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
		     
		     	
    	    </tr> 
    	     <tr>
    	       <td width="20%" class="dialogTd" align="right">预警级别：</td>
		      <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="yjjb" name="yjjb"   style="width:200px;" value="${entity.yjjb}"
	    			data-options="url: contextPath +  '/common/dict/D_QBLD_YJJB.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
    	       <td width="20%" class="dialogTd" align="right">联系电话：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="lxdh" name="lxdh" value="${entity.lxdh}" data-options="validType:['phone'],charSet:'half',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		     	
    	    </tr> 
    	    <tr>
		        <td width="20%" class="dialogTd" align="right">主要原因：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="zyyy" id="zyyy" class="easyui-validatebox" style="width: 627px; height:48px;"
					data-options="required:true,validType:['maxLength[1000]'],invalidMessage:'主要原因不超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.zyyy}</textarea></td>
    	    </tr>
    	    <tr>
		        <td width="20%" class="dialogTd" align="right">主要事情：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="zysq" id="zysq" class="easyui-validatebox" style="width: 627px; height:48px;"
					data-options="required:true,validType:['maxLength[1000]'],invalidMessage:'主要事情不超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.zysq}</textarea></td>
    	    </tr>
    	    <tr>
		        <td width="20%" class="dialogTd" align="right">上访过程描述：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="sfgcms" id="sfgcms" class="easyui-validatebox" style="width: 627px; height:48px;"
					data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'上访过程描述不超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.sfgcms}</textarea></td>
    	    </tr>  
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 

    if("${type}"=="view"){
    	setInputReadonly("sslb", true);
    	setInputReadonly("sslbxl", true);
    	setInputReadonly("ssqt", true);
    	setInputReadonly("sfsj", true);
    	setInputReadonly("sfdd", true);
    	setInputReadonly("bbdwmc", true);
    	setInputReadonly("bbld", true);
    	setInputReadonly("sffs", true);
    	setInputReadonly("czjg", true);
    	setInputReadonly("czry", true);
    	setInputReadonly("sfxf", true);
    	setInputReadonly("yjjb", true);
    	setInputReadonly("lxdh", true);
    	setInputReadonly("zyyy", true);
    	setInputReadonly("zysq", true);
    	setInputReadonly("sfgcms", true);
    	
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