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
    <form action="<%=basePath%>dtjsMore/saveDtjsZdxsfzqkxxb" id="dataForm" name="dataForm" method="post" >
    	<input type="hidden" id="pk" name="id" value="${entity.id}" />
    	<input type="hidden" id="zdryzjhm" name="zdryzjhm" value="${entity.zdryzjhm}" />
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	
			
	        <tr>
		     	<td width="20%" class="dialogTd" align="right">重点人员所属类型：</td>
	    		<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="sslb" name="sslb"   style="width:200px;" value="${entity.sslb}"
					data-options="url: contextPath +  '/common/dict/BD_D_QBZDRYLBDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',readonly:true"/>
				</td>
				<td width="20%" class="dialogTd" align="right">重点人员所属细类：</td>
		       	 <td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="sslbxl" name="sslbxl" value="${entity.sslbxl}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/BD_D_QBZDRYXLDM.js',onlyLeaf:true,multiple:false,panelWidth:200,method:'get',editable:true,lines:true"/></td>
		       </td>
             </tr>
		     <tr class="dialogTr">
		      
		        <td width="20%" class="dialogTd" align="right">作案手段：</td>
		       <td width="30%" class="dialogTd">					
				  <input class="easyui-combobox" type="text"  id="zasd" name="zasd"   style="width:200px;" value="${entity.zasd}"
					data-options="url: contextPath +  '/common/dict/XZ_D_ZASDFLHSDDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
		       </td>	
		      <td width="20%" class="dialogTd" align="right">作案工具：</td>
		       	 <td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="zagj" name="zagj" value="${entity.zagj}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/XZ_D_SAWPFLHDM.js',onlyLeaf:true,multiple:false,panelWidth:200,method:'get',editable:true,lines:true"/></td>
		       </td>
    	    </tr>  
		    <tr>
		       <td width="20%" class="dialogTd" align="right">作案工具来源：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="zagjly" name="zagjly" value="${entity.zagjly}" data-options="validType:['maxLength[100]'],invalidMessage:'包保领导不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		      <td width="20%" class="dialogTd" align="right">作案特点：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="zatd" name="zatd"   style="width:200px;" value="${entity.zatd}"
	    			data-options="url: contextPath +  '/common/dict/XZ_D_ZATDFLHDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
		       </td>	
    	    </tr>  
    	    <tr>
    	      <td width="20%" class="dialogTd" align="right">选择对象：</td>
			 <td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="xzdx" name="xzdx" value="${entity.xzdx}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/XZ_D_XZDXDM.js',onlyLeaf:true,multiple:false,panelWidth:410,method:'get',editable:true,lines:true"/></td>
		       </td>
		      <td width="20%" class="dialogTd" align="right">选择物品：</td>
		     	 <td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="xzwp" name="xzwp" value="${entity.xzwp}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/XZ_D_XZWPDM.js',onlyLeaf:true,multiple:false,panelWidth:410,method:'get',editable:true,lines:true"/></td>
		       </td>
    	    </tr>  
    	    <tr>
    	        <td width="20%" class="dialogTd" align="right">选择处所：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="xzcs" name="xzcs"   style="width:200px;" value="${entity.xzcs}"
	    			data-options="url: contextPath +  '/common/dict/XZ_D_XZCSDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
    	         <td width="20%" class="dialogTd" align="right">是否踩点：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="sfcd" name="sfcd"   style="width:200px;" value="${entity.sfcd}"
	    			data-options="url: contextPath +  '/common/dict/BD_D_SFDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
		     
		     	
    	    </tr> 
    	     <tr>
    	       <td width="20%" class="dialogTd" align="right">选择时机：</td>
		      <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="xzsj" name="xzsj"   style="width:200px;" value="${entity.xzsj}"
	    			data-options="url: contextPath +  '/common/dict/XZ_D_XZSJDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
    	          <td width="20%" class="dialogTd" align="right">销赃方式：</td>
		        <td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="xzfs" name="xzfs" value="${entity.xzfs}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/XZ_D_XZFSFLHDM.js',onlyLeaf:true,multiple:false,panelWidth:410,method:'get',editable:true,lines:true"/></td>
		       </td>
    	    </tr> 
    	    <tr>
		        <td width="20%" class="dialogTd" align="right">销赃地区：</td>
		    	<td width="30%" class="dialogTd" >
		    	   <input class="easyui-combobox" type="text"  id="xzdq" name="xzdq"   style="width:200px;" value="${entity.xzdq}"
		             data-options="mode:'remote',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"
	    			/>
		    	 </td>
    	    </tr>
    	    <tr>
		        <td width="20%" class="dialogTd" align="right">管控注意事项：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="gkzysx" id="gkzysx" class="easyui-validatebox" style="width: 627px; height:48px;"
					data-options="required:false,validType:['maxLength[500]'],invalidMessage:'上访过程描述不超过500个汉字，请重新输入！',tipPosition:'left'">${entity.gkzysx}</textarea></td>
    	    </tr> 
    	   <tr>
    	       <td width="20%" class="dialogTd" align="right">是否团伙作案：</td>
		      <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="sfthza" name="sfthza"   style="width:200px;" value="${entity.sfthza}"
	    			data-options="url: contextPath +  '/common/dict/BD_D_SFDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
    	          <td width="20%" class="dialogTd" align="right">结伙方式：</td>
		      <td width="30%" class="dialogTd">
		          	<input class="easyui-validatebox" type="text" id="jhfs" name="jhfs" value="${entity.jhfs}" data-options="required:false,validType:['maxLength[16]'],invalidMessage:'结伙方式不能超过16个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		          
		       </td>
    	    </tr>
    	      <tr>
    	       <td width="20%" class="dialogTd" align="right">作案地逗留方式：</td>
		      <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="zaddlfs" name="zaddlfs"   style="width:200px;" value="${entity.zaddlfs}"
	    			data-options="url: contextPath +  '/common/dict/BD_D_ZADDLFSDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
    	        <td width="20%" class="dialogTd" align="right">异地逗留方式：</td>
		      <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="yddlfs" name="yddlfs"   style="width:200px;" value="${entity.yddlfs}"
	    			data-options="url: contextPath +  '/common/dict/BD_D_YDDLFSDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
    	    </tr>
    	       <tr>
    	       <td width="20%" class="dialogTd" align="right">案前联系方式：</td>
		      <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="aqlxfs" name="aqlxfs"   style="width:200px;" value="${entity.aqlxfs}"
	    			data-options="url: contextPath +  '/common/dict/D_QBLD_LXFS.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
    	        <td width="20%" class="dialogTd" align="right">案前其他联系方式：</td>
		        <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="aqqtlxfs" name="aqqtlxfs"   style="width:200px;" value="${entity.aqqtlxfs}"
	    			data-options="url: contextPath +  '/common/dict/D_QBLD_LXFS.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
    	    </tr>
    	           <tr>
    	       <td width="20%" class="dialogTd" align="right">案中联系方式：</td>
		      <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="azlxfs" name="azlxfs"   style="width:200px;" value="${entity.azlxfs}"
	    			data-options="url: contextPath +  '/common/dict/D_QBLD_LXFS.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
    	        <td width="20%" class="dialogTd" align="right">案中其他联系方式：</td>
		        <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="azqtlxfs" name="azqtlxfs"   style="width:200px;" value="${entity.azqtlxfs}"
	    			data-options="url: contextPath +  '/common/dict/D_QBLD_LXFS.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
    	    </tr>
    	    
    	     <tr>
    	       <td width="20%" class="dialogTd" align="right">案后联系方式：</td>
		      <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="ahlxfs" name="ahlxfs"   style="width:200px;" value="${entity.ahlxfs}"
	    			data-options="url: contextPath +  '/common/dict/D_QBLD_LXFS.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
    	        <td width="20%" class="dialogTd" align="right">案后其他联系方式：</td>
		        <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="ahqtlxfs" name="ahqtlxfs"   style="width:200px;" value="${entity.ahqtlxfs}"
	    			data-options="url: contextPath +  '/common/dict/D_QBLD_LXFS.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
    	    </tr>
    	    
    	      <tr>
    	       <td width="20%" class="dialogTd" align="right">销赃渠道：</td>
		      <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="xzqd" name="xzqd"   style="width:200px;" value="${entity.xzqd}"
	    			data-options="url: contextPath +  '/common/dict/BD_D_XZQDDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
    	        <td width="20%" class="dialogTd" align="right">销赃方法：</td>
		        <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="xzff" name="xzff"   style="width:200px;" value="${entity.xzff}"
	    			data-options="url: contextPath +  '/common/dict/XZ_D_XZFSFLHDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
    	    </tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 
	initComboBox("xzdq", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 

    if("${type}"=="view"){
    	setInputReadonly("sslb", true);
    	setInputReadonly("sslbxl", true);
    	setInputReadonly("zasd", true);
    	setInputReadonly("zagj", true);
    	setInputReadonly("zagjly", true);
    	setInputReadonly("zatd", true);
    	setInputReadonly("xzdx", true);
    	setInputReadonly("xzwp", true);
    	setInputReadonly("xzcs", true);
    	setInputReadonly("sfcd", true);
    	setInputReadonly("xzsj", true);
    	setInputReadonly("xzfs", true);
    	setInputReadonly("xzdq", true);
    	setInputReadonly("gkzysx", true);
    	setInputReadonly("sfthza", true);
    	setInputReadonly("jhfs", true);
    	setInputReadonly("zaddlfs", true);
    	setInputReadonly("yddlfs", true);
    	setInputReadonly("aqlxfs", true);
    	setInputReadonly("aqqtlxfs", true);
    	setInputReadonly("azlxfs", true);
    	setInputReadonly("azqtlxfs", true);
    	setInputReadonly("ahlxfs", true);
    	setInputReadonly("ahqtlxfs", true);
    	setInputReadonly("xzqd", true);
    	setInputReadonly("xzff", true);
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