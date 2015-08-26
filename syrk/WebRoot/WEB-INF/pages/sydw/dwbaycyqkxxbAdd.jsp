<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>保安员从业情况信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwbaycyqkxxb/save" id="dataForm" name="dataForm" method="post">
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="14" width="100%" align="center">
				<input type="hidden" id="dwxh" name="dwxh" value="${entity.dwxh}" />
				<input type="hidden" id="baybm" name="baybm" value="${entity.baybm}" />
				<input type="hidden" id="id" name="id" value="${entity.id}" />
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">是否签订劳动合同：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="sfqdldht" name="sfqdldht" style="width:200px;" value="${entity.sfqdldht }"
			    		data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:true,method:'get'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">缴纳社保险种：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="jnsbxz" name="jnsbxz" style="width:200px;" value="${entity.jnsbxz}" maxlength="20" 
					    data-options="required:false,url: contextPath + '/common/dict/BD_D_JNSBXZDM.js',
			    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">是否重点岗位：</td>
			    	<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text" id="sfzdgw" name="sfzdgw" style="width:200px;" value="${entity.sfzdgw}"
			    		data-options="url: contextPath + '/common/dict/D_GG_SF.js',
			    		valueField:'id',textField:'text',selectOnNavigation:false,required:false,tipPosition:'left',method:'get'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">是否个人会员：</td>
			    	<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text" id="sfgrhy" name="sfgrhy" style="width:200px;" value="${entity.sfgrhy}"
			    		data-options="url: contextPath + '/common/dict/D_GG_SF.js',
			    		valueField:'id',textField:'text',selectOnNavigation:false,required:false,tipPosition:'left',method:'get'"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">着装情况：</td>
			    	<td width="30%" class="dialogTd">
						<input class="easyui-combobox" id="zzqk" name="zzqk" value="${entity.zzqk}" 
			    		style="width:200px;" data-options="required:false,url: contextPath + '/common/dict/BD_D_ZZQKDM.js',
			    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
					</td>
			    	<td width="20%" class="dialogTd" align="right">入职日期：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="rzrq" name="rzrq" style="width:200px;" value="${entity.rzrq}" maxlength="20" 
			    		data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">离职日期：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="lzrq" name="lzrq" style="width:200px;" value="${entity.lzrq}" maxlength="20" 
			    		data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'right'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">离职原因：</td>
			    	<td width="30%" class="dialogTd">
						<input class="easyui-combobox" id="lzyy" name="lzyy" value="${entity.lzyy}" 
			    		style="width:200px;" data-options="required:false,url: contextPath + '/common/dict/BD_D_LZYYDM.js',
			    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">因公伤亡情况：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-combobox" type="text" id="ygswqk" name="ygswqk" style="width:200px;" value="${entity.ygswqk}" maxlength="20" 
			    		data-options="required:false,url: contextPath + '/common/dict/BD_D_YGSWQKDM.js',
			    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">保安从业信息编码：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="bacyxxbm" name="bacyxxbm" style="width:200px;" value="${entity.bacyxxbm}" readonly maxlength="20"
						data-options="required:false,tipPosition:'left'"/>
					</td>
			    </tr>
			    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">填报人：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="tbr" name="tbr" style="width:200px;" value="${entity.tbr}" maxlength="20" 
			    		data-options="required:false,tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">填报时间：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="tbsj" name="tbsj" style="width:200px;" value="${entity.tbsj}" maxlength="20" 
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
					</td>
			    </tr>
	    	    <tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">所属地市公安机关：</td>
			    	<td width="50%" class="dialogTd" colspan="2">
			    		<input type="hidden" id="ssdsgajgdmid" name="ssdsgajgdmid" value="${entity.ssdsgajgdmid}"/>
			    		<input class="easyui-validatebox  inputreadonly" type="text" id="ssdsgajgdm" name=ssdsgajgdm style="width:200px;" value="${entity.ssdsgajgdm}" maxlength="20" 
			    		data-options="required:false,tipPosition:'right'" readonly="readonly"/>
			    		<input type="button" id="orgbutton1" value="选择" onClick="public_singleSelectOrg('', '01', '32', '', 'ssdsgajgdmid', 'ssdsgajgdm', '', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
			    		　　　　　　&nbsp;&nbsp;&nbsp;单位名称：
			    	</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="dwmc" name="dwmc" style="width:200px;" value="${entity.dwmc}" maxlength="20" 
						data-options="required:false,tipPosition:'left'"/>
					</td>
			    </tr>
	    	</table>
	    </div>
    </form>
</div>
</html>