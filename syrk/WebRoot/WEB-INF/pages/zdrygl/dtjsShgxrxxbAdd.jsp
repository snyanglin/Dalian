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
<title>社会关系人信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dtjsMore/saveDtjsShgxrxxb" id="dataForm" name="dataForm" method="post" >
    	<input type="hidden" id="pk" name="id" value="${entity.id}" />
    	<input type="hidden" id="zdryzjhm" name="zdryzjhm" value="${entity.zdryzjhm}" />
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	
			
	        <tr>
		     	<td width="20%" class="dialogTd" align="right">重点人员所属类型：</td>
	    		<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="zdrylbbj" name="zdrylbbj"   style="width:200px;" value="${entity.zdrylbbj}"
					data-options="url: contextPath +  '/common/dict/BD_D_QBZDRYLBDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',readonly:true"/>
				</td>
		    			<td width="20%" class="dialogTd" align="right">重点人员所属细类：</td>
		       	 <td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="zdryxl" name="zdryxl" value="${entity.zdryxl}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/BD_D_QBZDRYXLDM.js',onlyLeaf:true,multiple:false,panelWidth:200,method:'get',editable:true,lines:true"/></td>
		       </td>
            </tr>
		     <tr class="dialogTr">
		        <td width="20%" class="dialogTd" align="right" id="jbxx_zjzlId">证件种类：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="zjlx" name="zjlx" value="${entity.zjlx}" style="width:200px;"
							data-options="required:true,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left',onChange:zjlx_onChange"/></td> 
		      
		       <td width="20%" class="dialogTd" align="right">证件号码：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zjhm" name="zjhm" value="${entity.zjhm}" style="width:200px;float:left;" maxlength="30" 
		    	        	data-options="required:true,charSet:'halfUpper',invalidMessage:'请输入正确的证件号码', tipPosition:'right'" onblur="zjhm_onblur()"/><div class="lodingimg" id="jbxxLoadDiv"></div></td>
		    
		    </tr>	

		    <tr>
		       <td width="20%" class="dialogTd" align="right">部级重点人员编号：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="bjzdrybh" name="bjzdrybh" value="${entity.bjzdrybh}" data-options="required:false,validType:['maxLength[24]'],invalidMessage:'部级重点人员编号不能超过24个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		      <td width="20%" class="dialogTd" align="right">省级重点人员编号：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="sjzdrybh" name="sjzdrybh" value="${entity.sjzdrybh}" data-options="validType:['maxLength[24]'],invalidMessage:'省级重点人员编号不能超过24个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
    	    </tr>
		    <tr>
		       <td width="20%" class="dialogTd" align="right">姓名：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="xm" name="xm" value="${entity.xm}" data-options="required:true,validType:['maxLength[100]'],invalidMessage:'姓名不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		      <td width="20%" class="dialogTd" align="right">姓名拼音：</td>
		        <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="xmpy" name="xmpy" value="${entity.xmpy}" data-options="validType:['maxLength[100]'],invalidMessage:'姓名拼音不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>	
    	    </tr>  
    	        <tr>
    	         <td width="20%" class="dialogTd" align="right">民族：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="mz" name="mz"   style="width:200px;" value="${entity.mz}"
	    			data-options="url: contextPath +  '/common/dict/GB_D_MZDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
		       <td width="20%" class="dialogTd" align="right">性别：</td>
		          <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="xb" name="xb"   style="width:200px;" value="${entity.xb}"
	    			data-options="url: contextPath +  '/common/dict/GB_D_XBDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
		     	
    	    </tr>  
    	    <tr>
    	        <td width="20%" class="dialogTd" align="right">关系：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="gx" name="gx" value="${entity.gx}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/XZ_D_RYGXDM.js',onlyLeaf:true,multiple:false,panelWidth:410,method:'get',editable:true,lines:true"></td>
		       </td>
    	         <td width="20%" class="dialogTd" align="right">国籍：</td>
		       	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="gj" name="gj" value="${entity.gj}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
		     	
    	    </tr> 
    	    <tr>	    
    	    <tr>
    	       <td width="20%" class="dialogTd" align="right">户籍地区划：</td>
    	       <td width="30%" class="dialogTd">
		         <input class="easyui-combobox" type="text"  id="hjqh" name="hjqh"   style="width:200px;" value="${entity.hjqh}"
		             data-options="mode:'remote',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"
	    			/>
	    		  <input type="hidden" id="hjdpcsdm" name="hjdpcsdm" value="${ entity.hjdpcsdm}" />
    	        </td>
		     	  <td width="20%" class="dialogTd" align="right">户籍地详址：</td>
		            <td width="80%" class="dialogTd" colspan="3">		          	
		           <input class="easyui-validatebox" type="text" id="hjdxz" name="hjdxz" value="${entity.hjdxz}" data-options="validType:['maxLength[200]'],invalidMessage:'户籍地详址不能超过200个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
    	    </tr>  
    	       <tr>
    	      <td width="20%" class="dialogTd" align="right">现住地区划：</td>
    	       <td width="30%" class="dialogTd">
		         <input class="easyui-combobox" type="text"  id="xzdqh" name="xzdqh"   style="width:200px;" value="${entity.xzdqh}"
		             data-options="mode:'remote',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"
	    			/>
	    		  <input type="hidden" id="hjdpcsdm" name="hjdpcsdm" value="${ entity.hjdpcsdm}" />
		     	</td>
		     	 <td width="20%" class="dialogTd" align="right">现住地详址：</td>
		            <td width="30%" class="dialogTd" colspan="3">		          	
		           <input class="easyui-validatebox" type="text" id="xzdxz" name="xzdxz" value="${entity.xzdxz}" data-options="validType:['maxLength[200]'],invalidMessage:'现住地详址不能超过200个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
    	    </tr> 
    	   
		          <tr>
		            <td width="20%" class="dialogTd" align="right">曾用名：</td>
		            <td width="30%" class="dialogTd">		          	
		             <input class="easyui-validatebox" type="text" id="cym" name="cym" value="${entity.cym}" data-options="validType:['maxLength[100]'],invalidMessage:'曾用名不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		           </td>	
		           <td width="20%" class="dialogTd" align="right">绰号：</td>
		             <td width="30%" class="dialogTd" colspan="1">		          	
		            <input class="easyui-validatebox" type="text" id="ch" name="ch" value="${entity.ch}" data-options="validType:['maxLength[100]'],invalidMessage:'绰号不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		     
		          </td>
		      </tr> 
		     <tr class="dialogTr">
				   
				    	<td width="20%" class="dialogTd" align="right">政治面貌：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="zzmm" name="zzmm" value="${entity.zzmm}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_ZZMMDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/></td> 
			            <td width="20%" class="dialogTd" align="right">宗教信仰：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="zjxy" name="zjxy" value="${entity.zjxy}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/ZA_D_ZJXYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
			  </tr>     
		       <tr class="dialogTr">
					    <td width="20%" class="dialogTd" align="right">出生日期：</td>
		    	 		<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="csrq" name="csrq" value="${entity.csrq}" style="width:200px;" 
		    	 			data-options="required:false,validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
			            <td width="20%" class="dialogTd" align="right">婚姻状况：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="hyzk" name="hyzk" value="${entity.hyzk}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_HYZKDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
			 </tr>  
		         
		      <tr class="dialogTr">
					    <td width="20%" class="dialogTd" align="right">学历：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="whcd" name="whcd" value="${entity.whcd}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_XLDM.js',onlyLeaf:true,multiple:false,panelWidth:300,method:'get',editable:true,lines:true"></td> 
			           <td width="20%" class="dialogTd" align="right">身高：</td>
		               <td width="30%" class="dialogTd">		          	
		              <input class="easyui-validatebox" type="text" id="sg" name="sg" value="${entity.sg}" data-options="validType:['maxLength[10]'],invalidMessage:'身高不能超过10个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		              </td>
			          
			 </tr>  
		        <tr class="dialogTr">
					    <td width="20%" class="dialogTd" align="right">体重：</td>
				    	<td width="30%" class="dialogTd">		          	
		              <input class="easyui-validatebox" type="text" id="tz" name="tz" value="${entity.tz}" data-options="validType:['maxLength[10]'],invalidMessage:'体重不能超过10个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		              </td>
			           <td width="20%" class="dialogTd" align="right">足长：</td>
		               <td width="30%" class="dialogTd">		          	
		              <input class="easyui-validatebox" type="text" id="sg" name="zc" value="${entity.zc}" data-options="validType:['maxLength[10]'],invalidMessage:'足长不能超过10个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		              </td>
			          
			 </tr>    
		         <tr class="dialogTr">
		                <td width="20%" class="dialogTd" align="right">鞋号mm：</td>
		               <td width="30%" class="dialogTd">		          	
		              <input class="easyui-validatebox" type="text" id="xh" name="xh" value="${entity.xh}" data-options="validType:['maxLength[10]'],invalidMessage:'鞋号不能超过10个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		              </td>
			          
					   <td width="20%" class="dialogTd" align="right">口音：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="ky" name="ky" value="${entity.ky}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/D_RK_KYDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
			 </tr>    
		      <tr>
		        <td width="20%" class="dialogTd" align="right">特长：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="tc" id="tc" class="easyui-validatebox" style="width: 610px; height:48px;"
					data-options="required:false,validType:['maxLength[100]'],invalidMessage:'特长不超过100个汉字，请重新输入！',tipPosition:'left'">${entity.tc}</textarea></td>
    	    </tr>
    	    <tr>
		        <td width="20%" class="dialogTd" align="right">兴趣爱好：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="xqah" id="xqah" class="easyui-validatebox" style="width: 610px; height:48px;"
					data-options="required:false,validType:['maxLength[200]'],invalidMessage:'兴趣爱好不超过200个汉字，请重新输入！',tipPosition:'left'">${entity.xqah}</textarea></td>
    	    </tr>     
		         <tr>
		        <td width="20%" class="dialogTd" align="right">体貌特征：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="tmtz" id="tmtz" class="easyui-validatebox" style="width: 610px; height:48px;"
					data-options="required:false,validType:['maxLength[100]'],invalidMessage:'体貌特征不超过100个汉字，请重新输入！',tipPosition:'left'">${entity.tmtz}</textarea></td>
    	    </tr>
    	    <tr>
		        <td width="20%" class="dialogTd" align="right">特殊标记：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="tsbj" id="tsbj" class="easyui-validatebox" style="width: 610px; height:48px;"
					data-options="required:false,validType:['maxLength[100]'],invalidMessage:'特殊标记不超过100个汉字，请重新输入！',tipPosition:'left'">${entity.tsbj}</textarea></td>
    	    </tr>     
		      <tr class="dialogTr">
		                <td width="20%" class="dialogTd" align="right">DNA：</td>
		               <td width="30%" class="dialogTd">		          	
		              <input class="easyui-validatebox" type="text" id="dna" name="dna" value="${entity.dna}" data-options="validType:['maxLength[100]'],invalidMessage:'DNA不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		              </td>
			          
					   <td width="20%" class="dialogTd" align="right">血型：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="xx" name="xx" value="${entity.xx}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/ZA_D_XXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/></td> 
			 </tr>        
		        <tr class="dialogTr">
		                <td width="20%" class="dialogTd" align="right">指纹编号：</td>
		               <td width="30%" class="dialogTd">		          	
		              <input class="easyui-validatebox" type="text" id="zwbh" name="zwbh" value="${entity.zwbh}" data-options="validType:['maxLength[100]'],invalidMessage:'指纹编号不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		              </td>
			          
					   <td width="20%" class="dialogTd" align="right">职业：</td>
				    	<td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="zy" name="zy" value="${entity.zy}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/GB_D_ZYFLYDM.js',onlyLeaf:true,multiple:false,panelWidth:410,method:'get',editable:true,lines:true"></td>
			 </tr>        
		             
		      <tr class="dialogTr">
		                  <td width="20%" class="dialogTd" align="right">实际收入：</td>	     
			    <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="sjsr" name="sjsr"   style="width:200px;" value="${entity.sjsr}"
					data-options="url: contextPath +  '/common/dict/BD_D_SJSRDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
			      <td width="20%" class="dialogTd" align="right">经济来源：</td>
		         <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="jjly" name="jjly"   style="width:200px;" value="${entity.jjly}"
					data-options="url: contextPath +  '/common/dict/BD_D_JJLYDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>      
				
			 </tr>        
		      <tr>
    	      <td width="20%" class="dialogTd" align="right">工作单位区划：</td>
    	      
    	       <td width="30%" class="dialogTd">
		         <input class="easyui-combobox" type="text"  id="gzdwqh" name="gzdwqh"   style="width:200px;" value="${entity.gzdwqh}"
		             data-options="mode:'remote',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"
	    			/> </td>
	    		       <td width="20%" class="dialogTd" align="right">工作单位：</td>
		               <td width="30%" class="dialogTd">		          	
		              <input class="easyui-validatebox" type="text" id="gzdw" name="gzdw" value="${entity.gzdw}" data-options="validType:['maxLength[100]'],invalidMessage:'工作单位不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		              </td>

		      </tr>       
		      <tr>
		            <td width="20%" class="dialogTd" align="right">工作单位详址：</td>
		            <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="gzdwxz" name="gzdwxz" value="${entity.gzdwxz}" data-options="validType:['maxLength[200]'],invalidMessage:'工作单位详址不能超过200个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		       <td width="20%" class="dialogTd" align="right">联系方式：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="lxfs" name="lxfs" value="${entity.lxfs}" style="width:200px;" maxlength="18"
							data-options="validType:['phone'],charSet:'half',tipPosition:'left'"/></td>
		      </tr>    

	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 
	initComboBox("hjqh", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 
	initComboBox("xzdqh", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 
	initComboBox("gzdwqh", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 

    if("${type}"=="view"){
    	setInputReadonly("zjlx", true);
    	setInputReadonly("zjhm", true);
    	setInputReadonly("bjzdrybh", true);
    	setInputReadonly("sjzdrybh", true);
    	setInputReadonly("xm", true);
    	setInputReadonly("xmpy", true);
    	setInputReadonly("mz", true);
    	setInputReadonly("xb", true);
    	setInputReadonly("gx", true);
    	setInputReadonly("gj", true);
    	setInputReadonly("hjqh", true);
    	setInputReadonly("hjdxz", true);
    	setInputReadonly("xzdqh", true);
    	setInputReadonly("xzdxz", true);
    	setInputReadonly("zdrylbbj", true);
    	setInputReadonly("zdryxl", true);
    	setInputReadonly("cym", true);
    	setInputReadonly("ch", true);
    	setInputReadonly("zzmm", true);
    	setInputReadonly("zjxy", true);
    	setInputReadonly("csrq", true);
    	setInputReadonly("hyzk", true);
    	setInputReadonly("whcd", true);
    	setInputReadonly("sg", true);
    	setInputReadonly("tz", true);
    	setInputReadonly("zc", true);
    	setInputReadonly("xh", true);
    	setInputReadonly("ky", true);
    	setInputReadonly("tc", true);
    	setInputReadonly("xqah", true);
    	setInputReadonly("tmtz", true);
    	setInputReadonly("tsbj", true);
    	setInputReadonly("dna", true);
    	setInputReadonly("xx", true);
    	setInputReadonly("zwbh", true);
    	setInputReadonly("zy", true);
    	setInputReadonly("sjsr", true);
    	setInputReadonly("jjly", true);
    	setInputReadonly("gzdwqh", true);
    	setInputReadonly("gzdw", true);
    	setInputReadonly("gzdwxz", true);
    	setInputReadonly("lxfs", true);

    	
    }
}



function beforeSubmit() {
	
	
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}
//基本信息，证件种类改变事件
function zjlx_onChange(newValue, oldValue) {
	if ("undefined" == typeof newValue || newValue == null) {
		return;
	}
	var cyzjdmValue = $("#zjlx").combobox("getValue");
	if (cyzjdmValue == "111" || cyzjdmValue == "112" || cyzjdmValue == "335") { // 身份证类型、临时身份证、机动车驾驶证
		$("#zjhm").validatebox({validType:['sfzh']});
	}
	else {
		$("#zjhm").validatebox({validType:['letterOrNum']});
	}
	//setTimeout("zjhm_onblur();", 300);
}
function zjhm_onblur() {
	if (!$("#zjlx").combo("isValid")) {
		return;
	}
	if (!$("#zjhm").validatebox("isValid")) {
		return;
	}
	if ($("#zjhm").val() == "") {
		return;
	}
	var _cyzjdm = $("#zjhm").attr("cyzjdm");
	if (!_cyzjdm) {
		_cyzjdm = "";
	} 
	var _zjhm = $("#zjhm").attr("zjhm");
	if (!_zjhm) {
		_zjhm = "";
	} 
	if ($("#zjlx").combobox("getValue") == _cyzjdm && $("#zjhm").val() == _zjhm) {
		return;
	}
	$("#jbxxLoadDiv").show();
	$.ajax({
		type: "POST",
		url: contextPath + "/ryRyjbxxb/dataApply",
		dataType: "json",
		data:"zjhm=" + $("#zjhm").val() + "&zjlx=" + $("#zjlx").combobox("getValue"),
		success: function(data) {
			if (data && data.ryRyjbxxb) {
				$("#xm").val(data.ryRyjbxxb.xm);
				$("#xm").validatebox("validate");
				$("#xb").combobox("setValue", data.ryRyjbxxb.xbdm);
				$("#csrq").val(data.ryRyjbxxb.csrq);
				$("#csrq").validatebox("validate");
				$("#mz").combobox("setValue", data.ryRyjbxxb.mzdm);
				$("#lxfs").val(data.ryRyjbxxb.lxdh);
				if (data.ryRyjbxxb.jggjdqdm != "") {
					$("#gj").combobox("setValue", data.ryRyjbxxb.jggjdqdm);
				}		
			}if(data && data.ztxx){
				topMessager.alert("", "提醒：该人员是在逃人员！");
			}
		},
		complete: function() {
			$("#zjhm").attr("zjlx", $("#zjlx").combobox("getValue"));
			$("#zjhm").attr("zjhm", $("#zjhm").val());
			$("#jbxxLoadDiv").hide();
		},
		error: function() {
		}
	});	
}
</script>
</html>