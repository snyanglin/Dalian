<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>会员卡编辑</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>ryRyhykxxb/update" id="dataForm" name="dataForm" method="post" >
    	<input type="hidden" id="id" name="id" value="${entity.id}" />
    	<input type="hidden" id="ryid" name="ryid" value="${entity.ryid}" />
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr class="dialogTr">
			   	<td width="20%" class="dialogTd" align="right">卡号：</td>
		    	<td width="80%"  colspan="3" class="dialogTd">
		    	    <input class="easyui-validatebox" type="text"  id="hyk_kh" name="hyk_kh" style="width:200px;"  value="${entity.hyk_kh}" data-options="validType:['maxLength[50]'],invalidMessage:'卡号不能超过50个字符，请重新输入！',tipPosition:'right'" />
		    	 </td>
		    </tr>
		    <tr>
		    <td width="20%" class="dialogTd" align="right">发卡单位：</td>
			<td width="80%" class="dialogTd" colspan="3">
				    	<input type="hidden" id="fkdwid" name="fkdwid" value="${entity.fkdwid}" />
				    	<input type="hidden" id="fkdwmc" name="fkdwmc" value="${entity.fkdwmc}" />				         
						<input class="easyui-combobox" type="text" id="dwjbxxb_dwmc" data-options="required:true,tipPosition:'left',mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false" value="${entity.fkdwmc}" maxlength="50" style="width:610px;"/>
             </td>
		    </tr>
		     <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">获取时间：</td>
		    	<td width="30%" class="dialogTd"><input type="text" name="hyk_hqsj" id="hyk_hqsj" class="easyui-validatebox" style="width: 200px;" value="${entity.hyk_hqsj}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
		    	</td>
			    <td width="20%" class="dialogTd" align="right">截止时间：</td>
	            <td width="30%" class="dialogTd"><input type="text" name="hyk_yxqjzrq" id="hyk_yxqjzrq" class="easyui-validatebox" style="width: 200px;" value="${entity.hyk_yxqjzrq}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'hyk_hqsj\')}'})"/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">消费方式：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-combobox" type="text"  id="hyk_xffsdm" name="hyk_xffsdm"   style="width:200px;" value="${entity.hyk_xffsdm}"
					data-options="url: contextPath +  '/common/dict/BD_D_HYKXFFSDM.js',dataFilter:'${filterZdStr}',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		    	</td>
				<td width="20%" class="dialogTd" align="right">原价值：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="hyk_yjz" name="hyk_yjz" value="${entity.hyk_yjz}" style="width:200px;" data-options="validType:['money']"/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">现价值：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="hyk_xjz" name="hyk_xjz" value="${entity.hyk_xjz}" style="width:200px;" data-options="validType:['money']"/>
		    	</td>
		    	<td width="20%" class="dialogTd" align="right">注册人：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text"  id="hyk_zcr" name="hyk_zcr" style="width:200px;" value="${entity.hyk_zcr}" data-options="validType:['maxLength[50]'],invalidMessage:'注册人不能超过50个字符，请重新输入！',tipPosition:'right'"/></td>
		    	
		    </tr>
    	   <tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">是否实名代码：</td>
		    	<td width="30%">
			        <input type="text" name="sfsmdm" id="sfsmdm" value="${entity.sfsmdm}" class="easyui-combobox" style="width:200px;" 
				     data-options="url: contextPath + '/common/dict/D_BZ_SF.js',dataFilter: '0|1',required:true,method:'get',
					valueField:'id',textField:'text',selectOnNavigation:false">
		        </td>
		    </tr>
		    <%--
	        <tr class="dialogTr">
	        	<td width="20%" class="dialogTd" align="right">备注：</td>	        
	          	<td width="80%" class="dialogTd"  colspan="3">
		    		<textarea class="easyui-validatebox" id="bz" name="bz" style="width: 430px; height:48px;overflow: auto;">${entity.bz}</textarea>
		    	</td>
	        </tr>
		    
	    	--%>
	    	
	    	</table>
	    </div>
    </form>
</div>
<script type="text/javascript" >
function doInit(paramArray) { 
	
	initDepartmentSearch('dwjbxxb_dwmc', {glpcsid: ''}, 'fkdwid', 'fkdwmc', null, null);
	initDepartmentSearch('dwjbxxb_dwmc', {glpcsid: ''}, 'fkdwid', 'fkdwmc', null, null);

}
function beforeSubmit(){
	if ($("#hyk_hqsj").val() != "" && $("#hyk_yxqjzrq").val() != "" && $("#hyk_hqsj").val() >  $("#hyk_yxqjzrq").val()) {
		topMessager.alert("", "获取时间不能小于截止时间，请重新输入！");
		$("#hyk_hqsj").focus();
		return false;
	}
}


</script>
</html>