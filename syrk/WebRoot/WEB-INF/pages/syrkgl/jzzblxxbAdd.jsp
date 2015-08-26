<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>居住证办理</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>jzzblxxb/save" id="dataForm" name="dataForm" method="post">
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
	        <input type="hidden" name="syrkid" value="${entity.syrkid}"/>
	        <input type="hidden" name="ryid" id="ryid" value="${entity.ryid}"/>
	        <input type='hidden' name='id' id="pk" value="${entity.id }" />
	        
	         <input type='hidden' name='jzzblrq' id="pk" value="${entity.jzzblrq }" />
	         <input type='hidden' name='blr_id' id="blr_id" value="${entity.blr_id }" />
	         <input type='hidden' name='blr_xm' id="blr_xm" value="${entity.blr_xm }" />
	         <input type='hidden' name='jzz_blztdm' id="jzz_blztdm" value="${entity.jzz_blztdm }" />
	        
	        
	    
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
		     <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">证件种类：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-combobox inputreadonly" type="text" id="cyzjdm" name="cyzjdm" style="width:190px;" value="${entity.cyzjdm}" maxlength="100" readonly="readonly"
						data-options="required:true,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" />
				</td>
				<td width="20%" class="dialogTd" align="right">证件号码：</td>
				<td width="30%" class="dialogTd"><input  type='text' id="zjhm" name="zjhm" value="${entity.zjhm}" class="easyui-validatebox inputreadonly" style="width:190px;" readonly="readonly"/></td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">姓名：</td>
				<td width="30%" class="dialogTd"><input type="text" name="xm" id="xm" value="${entity.xm}" class="easyui-validatebox inputreadonly" style="width:190px;" readonly="readonly"/></td>	
								<td width="20%" class="dialogTd" align="right">性别：</td>
				<td width="30%" class="dialogTd"><input type="text" name="xbdm" id="xbdm" value="${entity.xbdm}" class="easyui-combobox inputreadonly" style="width:190px;" readonly="readonly"
						data-options="required:true,url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',tipPosition:'right',selectOnNavigation:false,method:'get'" /></td>	
			</tr>

			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">民族：</td>
				<td width="30%" class="dialogTd"><input type="text" name="mzdm" id="mzdm" value="${entity.mzdm}" class="easyui-combotree inputreadonly"  style="width:190px;"  readonly="readonly"
				data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"
				 /></td>
				 
				 <td width="20%" class="dialogTd" align="right">出生日期：</td>
		    	<td width="30%" class="dialogTd">
		    	    <input class="easyui-validatebox inputreadonly" type="text" name="csrq" id="csrq" maxlength="50" value="${entity.csrq}" style="width: 190px;" readonly="readonly"/>
		    	</td>
			</tr>
			
			 <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">户籍地址：</td>
				<td width="80%" class="dialogTd" colspan="3"><input  type='text' id='hjd_dzxz' name='hjd_dzxz' class="easyui-validatebox inputreadonly" style="width:620px;" value="${entity.hjd_dzxz}" readonly="readonly"/></td>
			</tr>
			
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">居住地址：</td>
				<td width="80%" class="dialogTd" colspan="3"><input  type='text' id='jzd_dzxz' name='jzd_dzxz' class="easyui-validatebox inputreadonly" style="width:620px;" value="${entity.jzd_dzxz}" readonly="readonly"/></td>
			</tr>
			
			
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">居住证有效期：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jzz_yxqdm" name="jzz_yxqdm" style="width:190px;" value=""
					data-options="url: contextPath + '/common/dict/BD_D_JZZYXQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
		    	</td>
		    	
		    	<td width="20%" class="dialogTd" align="right">居住证领取方式：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="jzz_lqfsdm" name="jzz_lqfsdm" style="width:190px;" value="1"
					data-options="url: contextPath + '/common/dict/BD_D_JZZLQFSDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left',onChange:lqfsChange" />
		    	</td>
	    	</tr>
	    	</table>
	    	<table id="kdTbody" border="0" cellpadding="0" cellspacing="10" width="100%" align="center"  style="margin-top: -10px;display: none;">
	    	  <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">收件人：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="jzz_kdsjr" id="jzz_kdsjr" maxlength="50" style="width: 190px;"/></td>
			    	<td width="20%" class="dialogTd" align="right">收件人联系电话：</td>
			    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" name="jzz_kdlxdh" id="jzz_kdlxdh" maxlength="30" style="width: 190px;" data-options="validType:['phone']"/></td>
		    	</tr>
		    	<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">收件地址：</td>
			    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" name="jzz_kddz" id="jzz_kddz" value="" maxlength="100" style="width: 619px;"/></td>
		    	</tr>	
	    	</table>
	    	
	    </div>
    </form>
</div>

<script type="text/javascript" >
function doInit(paramArray) {
	document.getElementById("ryid").value = paramArray["ryid"];
}


function beforeSubmit() {
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(["saveID"]);
	}
	
}
function lqfsChange(){
   var jzzlqfsdm = $("#jzz_lqfsdm").val();
   if(jzzlqfsdm =="1"){
	   $("#kdTbody").show();
	   $("#jzz_kdsjr").validatebox({required:true});
	   $("#jzz_kdlxdh").validatebox({required:true});
	   $("#jzz_kddz").validatebox({required:true});
   }else{
	   $("#jzz_kdsjr").validatebox({required:false});
	   $("#jzz_kdlxdh").validatebox({required:false});
	   $("#jzz_kddz").validatebox({required:false});
	   $("#jzz_kdsjr").val("");
	   $("#jzz_kdlxdh").val("");
	   $("#jzz_kddz").val("");
	   $("#kdTbody").hide();
	  
   }
}

</script>