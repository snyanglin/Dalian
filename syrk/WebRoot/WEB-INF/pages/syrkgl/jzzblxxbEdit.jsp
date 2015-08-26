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

<body class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>jzzblxxb/saveEdit" id="dataForm" name="dataForm" method="post">
    
         <div data-options="region:'west',border:false" style="width:170px;">
			<img  id="topPhotoid" width="160" height="200" alt="" />
		</div>
	    <div data-options="region:'center',border:false">
	        <input type="hidden" name="syrkid" value="${entity.syrkid}"/>
	        <input type="hidden" name="ryid" id="ryid" value="${entity.ryid}"/>
	        <input type='hidden' name='id' id="pk" value="${entity.id }" />
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
		     <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">办理分局：</td>
				<td width="30%" class="dialogTd">
					<input class="easyui-validatebox inputreadonly" type="text" name="bl_fjmc" id="bl_fjmc" maxlength="50" value="${entity.bl_fjmc}" style="width: 190px;" readonly="readonly"/>
				</td>
				<td width="20%" class="dialogTd" align="right">办理派出所：</td>
				<td width="30%" class="dialogTd">
				  <input class="easyui-validatebox inputreadonly" type="text" name="bl_pcsmc" id="bl_pcsmc" maxlength="50" value="${entity.bl_pcsmc}" style="width: 190px;" readonly="readonly"/>
				</td>
			</tr>
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">办理责任区：</td>
				<td width="30%" class="dialogTd">
			       <input class="easyui-validatebox inputreadonly" type="text" name="bl_zrqmc" id="bl_zrqmc" maxlength="50" value="${entity.bl_zrqmc}" style="width: 190px;" readonly="readonly"/>
			    </td>	
				<td width="20%" class="dialogTd" align="right">办理人：</td>
				<td width="30%" class="dialogTd">
				   <input class="easyui-validatebox inputreadonly" type="text" name="blr_xm" id="blr_xm" maxlength="50" value="${entity.blr_xm}" style="width: 190px;" readonly="readonly"/>
				</td>	
			</tr>

			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">居住人员证件种类：</td>
				<td width="30%" class="dialogTd">
				   <input class="easyui-combobox inputreadonly" type="text" id="cyzjdm" name="cyzjdm" style="width:190px;" value="${entity.cyzjdm}" maxlength="100" disabled="disabled"
						data-options="required:true,url: contextPath + '/common/dict/KX_D_CYZJDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" />
				</td>
				 
				<td width="20%" class="dialogTd" align="right">居住人员证件号码：</td>
		    	<td width="30%" class="dialogTd">
		    	    <input  type='text' id="zjhm" name="zjhm" value="${entity.zjhm}" class="easyui-validatebox inputreadonly" style="width:190px;" readonly="readonly"/>
		    	</td>
			</tr>
			
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">居住人员姓名：</td>
				<td width="30%" class="dialogTd">
				   <input  type='text' id="xm" name="xm" value="${entity.xm}" class="easyui-validatebox inputreadonly" style="width:190px;" readonly="readonly"/>
				 </td>
				 
				 <td width="20%" class="dialogTd" align="right">居住人员性别：</td>
		    	<td width="30%" class="dialogTd">
		    	    <input type="text" name="xbdm" id="xbdm" value="${entity.xbdm}" class="easyui-combobox inputreadonly" style="width:190px;" disabled="disabled"
						data-options="required:true,url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',tipPosition:'right',selectOnNavigation:false,method:'get'" />
		    	</td>
			</tr>
			
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">居住人员民族：</td>
				<td width="30%" class="dialogTd"><input type="text" name="mzdm" id="mzdm" value="${entity.mzdm}" class="easyui-combotree inputreadonly"  style="width:190px;"  disabled="disabled"
				data-options="url: contextPath + '/common/dict/GB_D_MZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"
				 /></td>
				 
				 <td width="20%" class="dialogTd" align="right">居住人员出生日期：</td>
		    	<td width="30%" class="dialogTd">
		    	    <input class="easyui-validatebox inputreadonly" type="text" name="csrq" id="csrq" maxlength="50" value="${entity.csrq}" style="width: 190px;" readonly="readonly"/>
		    	</td>
			</tr>
			
			 <tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">居住人员户籍地址：</td>
				<td width="80%" class="dialogTd" colspan="3"><input  type='text' id='hjd_dzxz' name='hjd_dzxz' class="easyui-validatebox inputreadonly" style="width:525px;" value="${entity.hjd_dzxz}" readonly="readonly"/></td>
			</tr>
			
			<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">居住人员居住地址：</td>
				<td width="80%" class="dialogTd" colspan="3"><input  type='text' id='jzd_dzxz' name='jzd_dzxz' class="easyui-validatebox inputreadonly" style="width:525px;" value="${entity.jzd_dzxz}" readonly="readonly"/></td>
			</tr>
			
			
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">居住人员办理日期：</td>
		    	<td width="30%" class="dialogTd">
		    	   <input class="easyui-validatebox inputreadonly" type="text" name="jzzblrq" id="jzzblrq" maxlength="50" value="${entity.jzzblrq}" style="width: 190px;" readonly="readonly"/>
		    	</td>
		    	
		    	<td width="20%" class="dialogTd" align="right">居住证有效期：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox inputreadonly" type="text" id="jzz_yxqdm" name="jzz_yxqdm" style="width:190px;" value="${entity.jzz_yxqdm}" disabled="disabled"
					data-options="url: contextPath + '/common/dict/BD_D_JZZYXQDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
		    	</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">居住证领取方式：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox inputreadonly" type="text" id="jzz_lqfsdm" name="jzz_lqfsdm" style="width:190px;" value="${entity.jzz_lqfsdm}" disabled="disabled"
					data-options="url: contextPath + '/common/dict/BD_D_JZZLQFSDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'left'"
		    	</td>
		    	
		    	
	    	</tr>
	    	
	    	<tr class="dialogTr" id="jzz_kd_td">
	    	<td width="20%" class="dialogTd" align="right">居住证收件人：</td>
		    	<td width="30%" class="dialogTd">
		    	    <input class="easyui-validatebox inputreadonly" type="text" name="jzz_kdsjr" id="jzz_kdsjr" readonly="readonly" value="${entity.jzz_kdsjr}" maxlength="50" style="width: 190px;"/> 
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">收件人联系电话：</td>
		    	<td width="30%" class="dialogTd">
		    	    <input class="easyui-validatebox inputreadonly" type="text" name="jzz_kdlxdh" id="jzz_kdlxdh" value="${entity.jzz_kdlxdh}" maxlength="30" style="width: 190px;" readonly="readonly"/>
		    	</td>
	    	</tr>
	    	
	    	
	    	<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">收件地址：</td>
				<td width="80%" class="dialogTd" colspan="3"><input  type='text' id='jzd_dzxz' class="easyui-validatebox inputreadonly" style="width:525px;" value="${entity.jzd_dzxz}" readonly="readonly"/></td>
			</tr>
			
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">领取日期：</td>
		    	<td width="30%" class="dialogTd"> 
		    	   <input type="text" name="jzz_lqrq" id ="jzz_lqrq" class="easyui-validatebox" value="${entity.jzz_lqrq}" data-options="required:false" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d'})" 
										style="width:190px"  /> 
		    	</td>
		    	
		    	<td width="20%" class="dialogTd" align="right">居住证快递单号：</td>
		    	<td width="30%" class="dialogTd">
		    	    <input  type='text' id="jzz_kddh" name="jzz_kddh" value="${entity.jzz_kddh}" class="easyui-validatebox" maxlength="40" style="width:190px;"/>
		    	</td>
	    	</tr>
	    	
	    	<tr class="dialogTr">
				<td width="20%" class="dialogTd" align="right">居住证快递公司：</td>
				<td width="80%" class="dialogTd" colspan="3">
				   <input  type='text' id='jzz_kdgs' name='jzz_kdgs' class="easyui-validatebox" style="width:525px;" maxlength="50" value="${entity.jzz_kdgs}"/>
				</td>
			</tr>
			
			
			<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">制证人：</td>
		    	<td width="30%" class="dialogTd">
		    	    <input type='hidden' name="zzr_id" id="zzr_id" value="${entity.zzr_id}" />
		    	    <input  type='text' id="zzr_xm" name="zzr_xm" value="${entity.zzr_xm}" class="easyui-validatebox inputreadonly" style="width:190px;" readonly="readonly"/>
		    	</td>
	    	</tr>
	    	
	    	</table>
	    </div>
    </form>
</body>

<script type="text/javascript" >
var lqfsdm ='${entity.jzz_lqfsdm}';
function doInit(paramArray) {
	document.getElementById("topPhotoid").src = contextPath+"/zpfjPtryzp/queryPtryzpSingle.jpg?ryid=${entity.ryid}&zjhm=${entity.zjhm}&cyzjdm=${entity.cyzjdm}";
	if(lqfsdm=='1'){
		setInputReadonly("jzz_kddh", true);
		setInputReadonly("jzz_kdgs", true);
		$("#jzz_kd_td").hide();
		
	}else{
		$("#jzz_kddh").validatebox({required:true});
		$("#jzz_kdgs").validatebox({required:true});
	}
}


function beforeSubmit() {
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(["saveID"]);
	}
	
}

</script>