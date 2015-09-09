<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>当事人详情</title>
</head>
<div class="easyui-layout" data-options="fit:true">
<form action="<%=basePath%>dsrxxzb/saveDsrxxzb" id="dataForm" name="dataForm" method="post">
    		<input type="hidden" name="mdjfxxid" id="mdjfxxid" value="${entity.mdjfxxid}" />
    		<input type="hidden" name="ryid" id="ryid" value="${entity.ryid}" />
    		<input type="hidden" name="flag" id="flag" value="${flag}"/>
	    <div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<input type="hidden" id="pk" name="id" value="${entity.id}" />
			<tr class="dialogTr">
			 <td width="20%" class="dialogTd" align="right">证件种类：</td>
				<td width="30%" class="dialogTd">
				<input type="text" name="cyzjdm" id="zjlx"  value="${entity.cyzjdm}" class="easyui-combobox" style="width:200px;"
	    			data-options="required:true,url: contextPath + '/common/dict/D_BZ_CYZJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" /></td> 
				<td width="20%" class="dialogTd" align="right">证件号码：</td>
				<td width="30%" class="dialogTd" align="left"><input class="easyui-validatebox" type="text" id="zjhm" name="zjhm" style="width:200px;float:left;" value="${entity.zjhm}" maxlength="30" 
		    		data-options="required:true,tipPosition:'left'"/><div class="lodingimg" id="yrjbxxDiv"></div>
				</td>
			</tr>
			<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">姓名：</td>
				<td width="30%" class="dialogTd"><input type="text" name="xm" id="xm" value="${entity.xm}" class="easyui-validatebox" data-options="required:true,validType:['maxLength[20]']" style="width:200px;" maxlength="20"/></td>
				<td width="20%" class="dialogTd" align="right">性别：</td>
				<td width="30%" class="dialogTd"><input type="text" name="xbdm" id="xb" value="${entity.xbdm}" class="easyui-combobox " style="width:200px;"
						data-options="required:true,url: contextPath + '/common/dict/D_BZ_XB.js',valueField:'id',textField:'text',tipPosition:'left',selectOnNavigation:false,method:'get'"/></td>
			</tr>
			<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">出生日期：</td>
				<td width="30%" class="dialogTd"><input type="text" name="csrq" id="csrq" value="${entity.csrq}" class="easyui-validatebox"   style="width:200px;"
					data-options="required:true,validType:['date[\'yyyy-MM-dd\']']" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/></td>
				<td width="20%" class="dialogTd" align="right">联系电话：</td>
				<td width="30%" class="dialogTd" >
				<input type="text" id="lxdh" name="lxdh" value="${entity.lxdh}" class="easyui-validatebox inputxtext " maxlength="18" style="width:200px;" 
				data-options="required:false,validType:['phone'],tipPosition:'left' "   />
				</td>
			</tr>			
			<tr class="dialogTr" id="jzdz">
				<td width="20%" class="dialogTd" align="right">居住地址：</td>
				<td width="50%" class="dialogTd" colspan="2">
				<input class="easyui-combobox" id="jzd1" style="width:400px;" value="${entity.dz_jzdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				<input type='hidden' name='dz_jzdzmlpdm' id="dz_jzdzmlpdm" value="${entity.dz_jzdzmlpdm}"/>
				<input type='hidden' name='dz_jzdzmlpxz' id="dz_jzdzmlpxz" value="${entity.dz_jzdzmlpxz}"/></td>
				<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="jzd2" style="width:200px;" value='${fn:replace(entity.dz_jzdzxz, entity.dz_jzdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_jzdzdm' id='dz_jzdzdm' value="${entity.dz_jzdzdm}" />
				    	<input type='hidden' name='dz_jzdzssxdm' id='dz_jzdzssxdm' value="${entity.dz_jzdzssxdm}" />
				    	<input type='hidden' name='dz_jzdzxz' id='dz_jzdzxz' value="${entity.dz_jzdzxz}" /> 
			    </td>	
			</tr>
			<tr class="dialogTr" id="jzdz">
				<td width="20%" class="dialogTd" align="right">户籍地址：</td>
				<td width="50%" class="dialogTd" colspan="2">
				<input class="easyui-combobox" id="hjd1" style="width:400px;" value="${entity.dz_hjdzmlpxz}" data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				<input type='hidden' name='dz_hjdzmlpdm' id="dz_hjdzmlpdm" value="${entity.dz_hjdzmlpdm}"/>
				<input type='hidden' name='dz_hjdzmlpxz' id="dz_hjdzmlpxz" value="${entity.dz_hjdzmlpxz}"/></td>
				<td width="30%" class="dialogTd">
				    	<input class="easyui-combobox" id="hjd2" style="width:200px;" value='${fn:replace(entity.dz_hjdzxz, entity.dz_hjdzmlpxz, "")}' data-options="required:false,mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
				    	<input type='hidden' name='dz_hjdzdm' id='dz_hjdzdm' value="${entity.dz_hjdzdm}" />
				    	<input type='hidden' name='dz_hjdzssxdm' id='dz_hjdzssxdm' value="${entity.dz_hjdzssxdm}" />
				    	<input type='hidden' name='dz_hjdzxz' id='dz_hjdzxz' value="${entity.dz_hjdzxz}" /> 
			    </td>	
			</tr>
			<tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">工作单位：</td>
		    	<td width="80%" class="dialogTd" colspan="3" ><input type="text" name="dwmc" id="dwmc" class="easyui-combobox" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:false" style="width: 613px;" value="${entity.gzdw }"
		   maxlength="100"><input type="hidden" name="gzdw" id="gzdw" value="${entity.gzdw }"/></td>
    		</tr>
	    	</table>
	    </div>
    </form>
</div>

</html>
<script type="text/javascript" >

function doInit(paramArray) {

        setInputReadonly("xm", true);
		setInputReadonly("xb", true);
		setInputReadonly("csrq", true);
		setInputReadonly("zjlx", true);
		setInputReadonly("zjhm", true);
		setInputReadonly("zjhm", true);
		setInputReadonly("xb", true);
		setInputReadonly("csrq", true);
		setInputReadonly("lxdh", true);
		setInputReadonly("ZJHM", true);
		setInputReadonly("xb", true);
		setInputReadonly("dwmc", true);
		setInputReadonly("jzd2", true);
		setInputReadonly("jzd1", true);
		setInputReadonly("hjd1", true);
		setInputReadonly("hjd2", true);

}
</script>
