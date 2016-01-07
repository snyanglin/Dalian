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
<title>写实基本信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>zdryDtjs/saveDtjs" id="dataForm" name="dataForm" method="post" >
    	<input type="hidden" id="zdryid" name="zdryid" value="${entity.zdryid}" />
    	<input type="hidden" id="pk" name="id" value="${entity.id}" />
    	<input type="hidden" id="zdry_zjhm" name="zdry_zjhm" value="${entity.zdry_zjhm}" />
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr>
			
			<td width="20%" class="dialogTd" align="right">核实时间：</td>
		    <td width="30%" class="dialogTd"><input type="text" name="hssj" id="hssj" class="easyui-validatebox" style="width: 200px;" value="${entity.hssj}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
		    </td>
			
	        </tr>
		     	<td width="20%" class="dialogTd" align="right">核实地点：</td>
				    	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="hsd1" style="width:380px;" value="${entity.hsd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="hsd_mlpdm" name="hsd_mlpdm" value="${entity.hsd_mlpdm}"/>
					    	<input type="hidden" id="hsd_mlpxz" name="hsd_mlpxz" value="${entity.hsd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="hsd2" style="width:200px;" value="${fn:replace(entity.hsd_dzxz, entity.hsd_mlpxz, '')}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="hsd_dzid" name="hsd_dzid" value="${entity.hsd_dzid}"/>
					    	<input type="hidden" id="hsd_xzqhdm" name="hsd_xzqhdm" value="${entity.hsd_xzqhdm}"/>
					    	<input type="hidden" id="hsd_dzxz" name="hsd_dzxz" value="${entity.hsd_dzxz}"/>
				</td>

		     <tr class="dialogTr">
		      <td width="20%" class="dialogTd" align="right">在控状态：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="zkzt" name="zkzt"   style="width:200px;" value="${entity.zkzt}"
	    			data-options="url: contextPath +  '/common/dict/BD_D_QBZDRYZKZTDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"
	    			"/>
		       </td>
			    <td width="20%" class="dialogTd" align="right">在籍状态：</td>
		        <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="zjzt" name="zjzt"   style="width:200px;" value="${entity.zjzt}"
					data-options="url: contextPath +  '/common/dict/QB_D_ZDRYYJSNZTDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"
	    			/>
		       </td>
		    </tr>	
		    <tr>
			<td width="20%" class="dialogTd" align="right">离开时间：</td>
		    <td width="30%" class="dialogTd"><input type="text" name="lksj" id="lksj" class="easyui-validatebox" style="width: 200px;" value="${entity.lksj}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
		    </td>
			
			<td width="20%" class="dialogTd" align="right">去往省市：</td>
		    <td width="30%" class="dialogTd">
		    	<input class="easyui-combobox" type="text"  id="qwss" name="qwss"   style="width:200px;" value="${entity.qwss}"
		             data-options="mode:'remote',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"
	    			/>
		    </td>
	        </tr>	
		     <tr>
		     	<td width="20%" class="dialogTd" align="right">危险级别（提示）：</td>	     
			    <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="wxjb" name="wxjb"   style="width:200px;" value="${entity.wxjb}"
					data-options="url: contextPath +  '/common/dict/BD_D_QBZDRYWXJBDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"
	    			/>
		       </td>
			
			  <td width="20%" class="dialogTd" align="right">主要意向：</td>
		    	  <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="zyyx" name="zyyx"   style="width:200px;" value="${entity.zyyx}"
					data-options="url: contextPath +  '/common/dict/BD_D_QBZDRYZYYXDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"
	    			/>
		       </td>
	        </tr>	
	        
	        	    	
		    <tr>
		       <td width="20%" class="dialogTd" align="right">职业：</td>
		       <td width="30%" class="dialogTd">
		     	<input class="easyui-combotree" type="text"  id="zy" name="zy"   style="width:200px;" value="${entity.zy}"
					data-options="required:false,tipPosition:'right',url: contextPath + '/common/dict/GB_D_ZYFLYDM.js',onlyLeaf:true,panelWidth:280,multiple:false,method:'get',editable:true,lines:true"/>
		        </td> 
		  
		         <td width="20%" class="dialogTd" align="right">实际收入：</td>	     
			    <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="sjsr" name="sjsr"   style="width:200px;" value="${entity.sjsr}"
					data-options="url: contextPath +  '/common/dict/D_QBLD_SJSR.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
		        
		    </tr>
		     <tr>
		       <td width="20%" class="dialogTd" align="right">经济来源：</td>
		         <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="jjly" name="jjly"   style="width:200px;" value="${entity.jjly}"
					data-options="url: contextPath +  '/common/dict/D_QBLD_JJLY.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
		       <td width="20%" class="dialogTd" align="right">属性信息类别：</td>
		         <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="rylbxx" name="rylbxx"   style="width:200px;" value="${entity.rylbxx}"
					data-options="url: contextPath +  '/common/dict/BD_D_QBZDRYLBDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
		    </tr>
		   <tr class="dialogTr">
		        <td width="20%" class="dialogTd" align="right">工作单位：</td>
			<td width="30%" class="dialogTd" colspan="1">
				    	<input type="hidden" id="gzdwid" name="gzdwid" value="${entity.gzdwid}" />
				    	<input type="hidden" id="gzdwmc" name="gzdwmc" value="${entity.gzdwmc}" />				         
						<input class="easyui-combobox" type="text" id="gzdw_dwmc" data-options="required:false,tipPosition:'left',mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false" value="${entity.gzdwmc}" maxlength="50" style="width:200px;"/>
             </td>
		       
			      <td width="20%" class="dialogTd" align="right">工作单位详址：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="gzdwxz" name="gzdwxz" value="${entity.gzdwxz}" style="width:200px;" data-options="validType:['maxLength[200]'],invalidMessage:'工作单位详址不能超过200个汉字，请重新输入！',tipPosition:'left'"/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		
		    	<td width="20%" class="dialogTd" align="right">现住地：</td>
				    	<td width="50%" class="dialogTd" colspan="2">
					    	<input class="easyui-combobox" id="jzd1" style="width:380px;" value="${entity.jzd_mlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="jzd_mlpdm" name="jzd_mlpdm" value="${entity.jzd_mlpdm}"/>
					    	<input type="hidden" id="jzd_mlpxz" name="jzd_mlpxz" value="${entity.jzd_mlpxz}"/>
				    	</td>
				    	<td width="30%" class="dialogTd" align="left">
					    	<input class="easyui-combobox" id="jzd2" style="width:200px;" value="${fn:replace(entity.jzd_dzxz, entity.jzd_mlpxz, '')}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
					    	<input type="hidden" id="jzd_dzid" name="jzd_dzid" value="${entity.jzd_dzid}"/>
					    	<input type="hidden" id="jzd_xzqhdm" name="jzd_xzqhdm" value="${entity.jzd_xzqhdm}"/>
					    	<input type="hidden" id="jzd_dzxz" name="jzd_dzxz" value="${entity.jzd_dzxz}"/>
				</td>
		    	
		    </tr>
		    <tr class="dialogTr">
		       <td width="20%" class="dialogTd" align="right">管辖单位：</td>
		    	<td width="30%" class="dialogTd">
		    		<span   id="gxdwmc" name="gxdwmc" style="width:200px;"><%=userOrgName %></span>
		    		<input class="easyui-validatebox" type="hidden" id="gxdwmc" name="gxdwmc" value="<%=userOrgName %>" style="width:200px;"/>
		    	
		    		<input class="easyui-validatebox" type="hidden" id="gxdwdm" name="gxdwdm" value="<%=userOrgCode %>" style="width:200px;"/>
		    	 
		   		 </td>
			    <td width="20%" class="dialogTd" align="right">是否见到本人：</td>
		         <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="sfjdbr" name="sfjdbr"   style="width:200px;" value="${entity.sfjdbr}"
	    			data-options="url: contextPath +  '/common/dict/BD_D_SFDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
		       </td>	      
			      
		    </tr>
		     <tr class="dialogTr">
		     <td width="20%" class="dialogTd" align="right">在控类型：</td>
		         <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="zklx" name="zklx"   style="width:200px;" value="${entity.zklx}"
	    			data-options="url: contextPath +  '/common/dict/BD_D_QBZDRYZKZTDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>	
			  <td width="20%" class="dialogTd" align="right">约见周期：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="yjzq" name="yjzq" value="${entity.yjzq}" style="width:200px;" data-options="validType:['maxLength[10]'],invalidMessage:'约见周期不能超过10个汉字，请重新输入！',tipPosition:'left'"/>
		    	</td>	      
			      
		    </tr>
		    <tr class="dialogTr">
		       <td width="20%" class="dialogTd" align="right">直系亲属信息：</td>
		    	<td width="30%" class="dialogTd">
		    	   <input class="easyui-validatebox" type="text" id="zxqsxx" name="zxqsxx" value="${entity.zxqsxx}" style="width:200px;" data-options="validType:['maxLength[100]'],invalidMessage:'直系亲属信息不能超过100个汉字，请重新输入！',tipPosition:'left'"/>
		    	
		   		 </td>
			      <td width="20%" class="dialogTd" align="right">虚拟身份信息：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="xnsfxx" name="xnsfxx" value="${entity.xnsfxx}" style="width:200px;" data-options="validType:['maxLength[200]'],invalidMessage:'虚拟身份信息不能超过100个汉字，请重新输入！',tipPosition:'left'"/>
		    	</td>
		    </tr>
		    <tr>
		        <td width="20%" class="dialogTd" align="right">情况描述（提示）：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="hsqkms" id="hsqkms" class="easyui-validatebox" style="width: 627px; height:48px;"
					data-options="required:false,validType:['maxLength[500]'],invalidMessage:'情况描述超过500个汉字，请重新输入！',tipPosition:'left'">${entity.hsqkms}</textarea></td>
    	    </tr>
		
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 
	
	initComboBox("qwss", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 
	initComboBox("jzdqh", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 
	initAddressSearch("jzd1", {zrqdm:'#jzd_zrqdm'}, "jzd_mlpdm", "jzd_mlpxz", "jzd2", {text:"jzd_dzxz",dzxzqh:"jzd_xzqhdm",id:"jzd_dzid"}, null, null);
	initAddressSearch("hsd1", {zrqdm:'#hsd_zrqdm'}, "hsd_mlpdm", "hsd_mlpxz", "hsd2", {text:"hsd_dzxz",dzxzqh:"hsd_xzqhdm",id:"hsd_dzid"}, null, null);
	initDepartmentSearch('gzdw_dwmc', {glpcsid: ''}, 'gzdwid', 'gzdwmc', null, null);
    if("${type}"=="view"){
    	setInputReadonly("hssj", true);
    	setInputReadonly("hsd1", true);
    	setInputReadonly("hsd2", true);
    	setInputReadonly("zkzt", true);
    	setInputReadonly("zjzt", true);
    	setInputReadonly("lksj", true);
    	setInputReadonly("qwss", true);
    	setInputReadonly("wxjb", true);
    	setInputReadonly("zyyx", true);
    	setInputReadonly("zy", true);
    	setInputReadonly("sjsr", true);
    	setInputReadonly("jjly", true);
    	setInputReadonly("gzdw_dwmc", true);
    	setInputReadonly("gzdwxz", true);
    	setInputReadonly("jzd1", true);
    	setInputReadonly("jzd2", true);
    	setInputReadonly("gxdwmc", true);
    	setInputReadonly("sfjdbr", true);
    	setInputReadonly("zklx", true);
    	setInputReadonly("yjzq", true);
    	setInputReadonly("zxqsxx", true);
    	setInputReadonly("xnsfxx", true);
    	setInputReadonly("hsqkms", true);
    	
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