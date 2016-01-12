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
<title>肇事肇祸精神病肇事肇祸记录</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dtjsMore/saveDtjsZszhjsbrZszhjlxxb" id="dataForm" name="dataForm" method="post" >
    	<input type="hidden" id="pk" name="id" value="${entity.id}" />
    	<input type="hidden" id="zdryzjhm" name="zdryzjhm" value="${entity.zdryzjhm}" />
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	
			
	        <tr>
	     
		     	<td width="20%" class="dialogTd" align="right">肇事肇祸类别：</td>
	    		<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="zszhlb" name="zszhlb"   style="width:200px;" value="${entity.zszhlb}"
					data-options="url: contextPath +  '/common/dict/BD_D_JSBZSZHLBDM.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
				</td>
				<td width="20%" class="dialogTd" align="right">事发时间：</td>
		       <td width="30%" class="dialogTd"><input type="text" name="sfsj" id="sfsj" class="easyui-validatebox" style="width: 200px;" value="${entity.sfsj}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
		      </td>
              </tr>

		     <tr class="dialogTr">
		  	   <td width="20%" class="dialogTd" align="right">事发地点：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="sfdd" name="sfdd" value="${entity.sfdd}" data-options="validType:['maxLength[200]'],invalidMessage:'事发地点不能超过200个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		    <td width="20%" class="dialogTd" align="right">处理结果：</td>
	    		<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="cljg" name="cljg"   style="width:200px;" value="${entity.cljg}"
					data-options="url: contextPath +  '/common/dict/BD_D_JSBZSCLJG.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
				</td>
		    
		    
    	    </tr>  
    	    <tr>
    	    <td width="20%" class="dialogTd" align="right">鉴定结果：</td>
	    		<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="jdjg" name="jdjg"   style="width:200px;" value="${entity.jdjg}"
					data-options="url: contextPath +  '/common/dict/BD_D_JSBZSJDJG.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
				</td>
    	     <td width="20%" class="dialogTd" align="right">鉴定结果编号：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="jdjgbh" name="jdjgbh" value="${entity.jdjgbh}" data-options="validType:['maxLength[10]'],invalidMessage:'鉴定结果编号不能超过10个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
    	    </tr>
    	    <tr>
    	       <td width="20%" class="dialogTd" align="right">鉴定单号：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="jddh" name="jddh" value="${entity.jddh}" data-options="validType:['maxLength[100]'],invalidMessage:'鉴定单号不能超过100个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
    	       <td width="20%" class="dialogTd" align="right">鉴定人：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="jdr" name="jdr" value="${entity.jdr}" data-options="validType:['maxLength[50]'],invalidMessage:'鉴定人不能超过50个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
    	    </tr>
    	    <tr>
    	     
    	       
    	         <td width="20%" class="dialogTd" align="right">鉴定人联系电话：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="jdrlxdh" name="jdrlxdh" style="width: 200px;"  value="${entity.jdrlxdh}" 
		           data-options="validType:['phone'],charSet:'half',tipPosition:'left'" /></td>
		      </td>
		       <td width="20%" class="dialogTd" align="right">办案民警：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="bamj" name="bamj" value="${entity.bamj}" data-options="validType:['maxLength[50]'],invalidMessage:'办案民警不能超过50个汉字，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
    	    
    	    </tr>
    	       <tr>
    	       
    	       
    	         <td width="20%" class="dialogTd" align="right">民警联系方式：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="mjlxfs" name="mjlxfs" style="width: 200px;"  value="${entity.mjlxfs}" 
		           data-options="validType:['phone'],charSet:'half',tipPosition:'left'" /></td>
		      </td>
		        <td width="20%" class="dialogTd" align="right">所属组织：</td>
		        	<td width="30%" class="dialogTd">
		        
		          	<input type="hidden" id="ssgajgdm" name="ssgajgdm" value="${entity.ssgajgdm}" style="width: 100;" />
				    <input class="easyui-validatebox" type="text" id="ssgajgmc" name="ssgajgmc" value="${entity.ssgajgmc}" style="width:140px;" data-options="readonly:true"/>
				    
				  	<input type="hidden" id="sszzid" name="sszzid" value="" style="width: 100;" />
				    
				    <input type="button" id="orgbutton11" value="选择" onClick="public_singleSelectOrg('', '', '', '', 'ssgajgdm', 'ssgajgmc', 'sszzid', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
					          
		       </td>
    	    
    	    </tr>
    
    	    
    	    <tr>
    	    
		        <td width="20%" class="dialogTd" align="right">事件过程描述：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="sjgcms" id="sjgcms" class="easyui-validatebox" style="width: 627px; height:48px;"
					data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'事件过程描述不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.sjgcms}</textarea></td>
    	    </tr>
    	   
    	    
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 

    if("${type}"=="view"){
    	setInputReadonly("zszhlb", true);
    	setInputReadonly("sfsj", true);
    	setInputReadonly("sfdd", true);
    	setInputReadonly("cljg", true);
    	setInputReadonly("jdjg", true);
    	setInputReadonly("jdjgbh", true);
    	setInputReadonly("jddh", true);
    	setInputReadonly("jdr", true);
    	setInputReadonly("jdrlxdh", true);
    	setInputReadonly("bamj", true);
     	setInputReadonly("mjlxfs", true);
     	setInputReadonly("ssgajgmc", true);
     	setInputReadonly("ssgajgdm", true);
     	setInputReadonly("sjgcms", true);
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