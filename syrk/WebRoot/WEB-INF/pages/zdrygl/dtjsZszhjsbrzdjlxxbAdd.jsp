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
<title>肇事肇祸精神病诊断记录信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dtjsMore/saveDtjsZszhjsbrzdjlxxb" id="dataForm" name="dataForm" method="post" >
    	<input type="hidden" id="pk" name="id" value="${entity.id}" />
    	<input type="hidden" id="zdryzjhm" name="zdryzjhm" value="${entity.zdryzjhm}" />
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	
			
	        <tr>
	     
		     <td width="20%" class="dialogTd" align="right">诊断单号：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="zddh" name="zddh" value="${entity.zddh}" data-options="validType:['maxLength[50]'],invalidMessage:'诊断单号长度不能超过50，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
				 <td width="20%" class="dialogTd" align="right">诊断时间：</td>
		       <td width="30%" class="dialogTd"><input type="text" name="zdsj" id="zdsj" class="easyui-validatebox" style="width: 200px;" value="${entity.zdsj}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
		      </td>
              </tr>

		     <tr class="dialogTr">
		  	    <td width="20%" class="dialogTd" align="right">诊断结果：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="qzjg" name="qzjg" value="${entity.qzjg}" data-options="validType:['maxLength[100]'],invalidMessage:'诊断结果长度不能超过100，请重新输入！',required:true,tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		        <td width="20%" class="dialogTd" align="right">诊断单位：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="qzdw" name="qzdw" value="${entity.qzdw}" data-options="validType:['maxLength[100]'],invalidMessage:'诊断单位长度不能超过100，请重新输入！',required:true,tipPosition:'left'" style="width: 200px;" />		       
		      </td>
    	    </tr>  
    	       <tr class="dialogTr">
		  	    <td width="20%" class="dialogTd" align="right">确诊医院：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="qzyy" name="qzyy" value="${entity.qzyy}" data-options="validType:['maxLength[100]'],invalidMessage:'确诊医院长度不能超过100，请重新输入！',required:true,tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		   
    	    </tr>
    	      <tr>
    	         <td width="20%" class="dialogTd" align="right">确诊医师：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="qzys" name="qzys" value="${entity.qzys}" data-options="validType:['maxLength[50]'],invalidMessage:'确诊医师长度不能超过50，请重新输入！',required:true,tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		           <td width="20%" class="dialogTd" align="right">确诊医师联系电话：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="qzyslxdh" name="qzyslxdh" style="width: 200px;"  value="${entity.qzyslxdh}" 
		           data-options="validType:['phone'],charSet:'half',tipPosition:'left'" /></td>
		      </td> 
    	    </tr>
    	     <tr class="dialogTr">
		  	    <td width="20%" class="dialogTd" align="right">鉴定人：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="jdr" name="jdr" value="${entity.jdr}" data-options="validType:['maxLength[50]'],invalidMessage:'鉴定人长度不能超过50，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
		      
		      <td width="20%" class="dialogTd" align="right">鉴定人联系电话：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="jdrlxdh" name="jdrlxdh" style="width: 200px;"  value="${entity.jdrlxdh}" 
		           data-options="validType:['phone'],charSet:'half',tipPosition:'left'" /></td>
		      </td>
		      
		     
    	    </tr>
    	  
    	    <tr>
		        <td width="20%" class="dialogTd" align="right">诊断过程描述：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="zdgcms" id="zdgcms" class="easyui-validatebox" style="width: 627px; height:48px;"
					data-options="required:false,validType:['maxLength[500]'],invalidMessage:'诊断过程描述长度不能超过500个汉字，请重新输入！',tipPosition:'left'">${entity.zdgcms}</textarea></td>
    	    </tr>
    	    
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 

    if("${type}"=="view"){
    	setInputReadonly("sslb", true);
    	setInputReadonly("brlb", true);
    	setInputReadonly("xszk", true);
    	setInputReadonly("bqms", true);
    	setInputReadonly("zyby", true);
    	
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