<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
</head>

<html>
<head>
<title>组织机构选择测试页面</title>
</head>
  
<body> 
   	
   	<table width="100%">
   	
   	<tr>
	   	<td>单选部门（所有数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="orgcode1" name="orgcode1" value="" style="width: 100;" />
	    <input type="text" id="orgname1" name="orgname1" style="width: 400;" value="" />
	   	<input type="text" id="orgid1" name="orgid1" value="" style="width: 100;" />
	    <input type="button" id="orgbutton1" value="选择" onClick="public_singleSelectOrg('', '01', '', '', 'orgcode1', 'orgname1', 'orgid1', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr>
	   	<td>单选部门（部分数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="orgcode2" name="orgcode2" value="" style="width: 100;" />
	    <input type="text" id="orgname2" name="orgname2" style="width: 400;" value="" />
	   	<input type="text" id="orgid2" name="orgid2" value="" style="width: 100;" />
	    <input type="button" id="orgbutton2" value="选择" onClick="public_singleSelectOrg('210204000000', '01', '', '', 'orgcode2', 'orgname2', 'orgid2', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr>
	   	<td>单选部门（所有数据，部门业务类型为派出所、刑侦）：</td>
	   	<td>
	   	<input type="text" id="orgcode3" name="orgcode3" value="" style="width: 100;" />
	    <input type="text" id="orgname3" name="orgname3" style="width: 400;" value="" />
	   	<input type="text" id="orgid3" name="orgid3" value="" style="width: 100;" />
	    <input type="button" id="orgbutton3" value="选择" onClick="public_singleSelectOrg('', '01', '', '03,04', 'orgcode3', 'orgname3', 'orgid3', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr>
	   	<td>单选部门（部分数据，部门业务类型为派出所）：</td>
	   	<td>
	   	<input type="text" id="orgcode4" name="orgcode4" value="" style="width: 100;" />
	    <input type="text" id="orgname4" name="orgname4" style="width: 400;" value="" />
	   	<input type="text" id="orgid4" name="orgid4" value="" style="width: 100;" />
	    <input type="button" id="orgbutton4" value="选择" onClick="public_singleSelectOrg('210204000000', '01', '32', '', 'orgcode4', 'orgname4', 'orgid4', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>    

   	<tr><td colspan="2"><hr></td></tr>
    
   	<tr>
	   	<td>单选部门或工作组（所有数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="orgcode11" name="orgcode11" value="" style="width: 100;" />
	    <input type="text" id="orgname11" name="orgname11" style="width: 400;" value="" />
	   	<input type="text" id="orgid11" name="orgid11" value="" style="width: 100;" />
	    <input type="button" id="orgbutton11" value="选择" onClick="public_singleSelectOrg('', '', '', '', 'orgcode11', 'orgname11', 'orgid11', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr>
	   	<td>单选部门或工作组（部分数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="orgcode12" name="orgcode12" value="" style="width: 100;" />
	    <input type="text" id="orgname12" name="orgname12" style="width: 400;" value="" />
	   	<input type="text" id="orgid12" name="orgid12" value="" style="width: 100;" />
	    <input type="button" id="orgbutton12" value="选择" onClick="public_singleSelectOrg('210204000000', '', '', '', 'orgcode12', 'orgname12', 'orgid12', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr>
	   	<td>单选部门或工作组（所有数据，部门业务类型为派出所）：</td>
	   	<td>
	   	<input type="text" id="orgcode13" name="orgcode13" value="" style="width: 100;" />
	    <input type="text" id="orgname13" name="orgname13" style="width: 400;" value="" />
	   	<input type="text" id="orgid13" name="orgid13" value="" style="width: 100;" />
	    <input type="button" id="orgbutton13" value="选择" onClick="public_singleSelectOrg('', '', '', '03,04', 'orgcode13', 'orgname13', 'orgid13', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr>
	   	<td>单选部门或工作组（部分数据，部门业务类型为派出所）：</td>
	   	<td>
	   	<input type="text" id="orgcode14" name="orgcode14" value="" style="width: 100;" />
	    <input type="text" id="orgname14" name="orgname14" style="width: 400;" value="" />
	   	<input type="text" id="orgid14" name="orgid14" value="" style="width: 100;" />
	    <input type="button" id="orgbutton14" value="选择" onClick="public_singleSelectOrg('210204000000', '', '', '03,04', 'orgcode14', 'orgname14', 'orgid14', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>    
   	<tr>
	   	<td>单选工作组（所有数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="orgcode22" name="orgcode22" value="" style="width: 100;" />
	    <input type="text" id="orgname22" name="orgname22" style="width: 400;" value="" />
	   	<input type="text" id="orgid22" name="orgid22" value="" style="width: 100;" />
	    <input type="button" id="orgbutton22" value="选择" onClick="public_singleSelectOrg('', '02', '', '', 'orgcode22', 'orgname22', 'orgid22', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>    

   	<tr><td colspan="2"><hr></td></tr>
   	
   	<tr>
	   	<td>单选部门（所有数据，部门业务类型为分局）：</td>
	   	<td>
	   	<input type="text" id="orgcode23" name="orgcode23" value="" style="width: 100;" />
	    <input type="text" id="orgname23" name="orgname23" style="width: 400;" value="" />
	   	<input type="text" id="orgid23" name="orgid23" value="" style="width: 100;" />
	    <input type="button" id="orgbutton23" value="选择" onClick="public_singleSelectOrg('', '01', '21', '', 'orgcode23', 'orgname23', 'orgid23', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>

   	<tr><td colspan="2"><hr></td></tr>
   	<tr><td colspan="2"><hr></td></tr>

   	<tr>
	   	<td>多选部门（所有数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="orgcode31" name="orgcode31" value="" style="width: 100;" />
	    <input type="text" id="orgname31" name="orgname31" style="width: 400;" value="" />
	   	<input type="text" id="orgid31" name="orgid31" value="" style="width: 100;" />
	    <input type="button" id="orgbutton31" value="选择" onClick="public_multiSelectOrg('', '01', '', '', 'orgcode31', 'orgname31', 'orgid31', true, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr>
	   	<td>多选部门（部分数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="orgcode32" name="orgcode32" value="" style="width: 100;" />
	    <input type="text" id="orgname32" name="orgname32" style="width: 400;" value="" />
	   	<input type="text" id="orgid32" name="orgid32" value="" style="width: 100;" />
	    <input type="button" id="orgbutton32" value="选择" onClick="public_multiSelectOrg('210200000000', '01', '', '', 'orgcode32', 'orgname32', 'orgid32', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr>
	   	<td>多选部门（所有数据，部门业务类型为派出所、刑侦）：</td>
	   	<td>
	   	<input type="text" id="orgcode33" name="orgcode33" value="" style="width: 100;" />
	    <input type="text" id="orgname33" name="orgname33" style="width: 400;" value="" />
	   	<input type="text" id="orgid33" name="orgid33" value="" style="width: 100;" />
	    <input type="button" id="orgbutton33" value="选择" onClick="public_multiSelectOrg('', '01', '', '01,04', 'orgcode33', 'orgname33', 'orgid33', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr>
	   	<td>多选部门（部分数据，部门业务类型为派出所）：</td>
	   	<td>
	   	<input type="text" id="orgcode34" name="orgcode34" value="" style="width: 100;" />
	    <input type="text" id="orgname34" name="orgname34" style="width: 400;" value="" />
	   	<input type="text" id="orgid34" name="orgid34" value="" style="width: 100;" />
	    <input type="button" id="orgbutton34" value="选择" onClick="public_multiSelectOrg('210200000000', '01', '32', '01,04', 'orgcode34', 'orgname34', 'orgid34', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
    
   	<tr><td colspan="2"><hr></td></tr>
    
   	<tr>
	   	<td>多选部门或工作组（所有数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="orgcode41" name="orgcode41" value="" style="width: 100;" />
	    <input type="text" id="orgname41" name="orgname41" style="width: 400;" value="" />
	   	<input type="text" id="orgid41" name="orgid41" value="" style="width: 100;" />
	    <input type="button" id="orgbutton41" value="选择" onClick="public_multiSelectOrg('', '', '', '', 'orgcode41', 'orgname41', 'orgid41', true, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr>
	   	<td>多选工作组（所有数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="orgcode42" name="orgcode42" value="" style="width: 100;" />
	    <input type="text" id="orgname42" name="orgname42" style="width: 400;" value="" />
	   	<input type="text" id="orgid42" name="orgid42" value="" style="width: 100;" />
	    <input type="button" id="orgbutton42" value="选择" onClick="public_multiSelectOrg('', '02', '32', '', 'orgcode42', 'orgname42', 'orgid42', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr>
	   	<td>多选工作组（所有数据，部门业务类型为法制）：</td>
	   	<td>
	   	<input type="text" id="orgcode43" name="orgcode43" value="" style="width: 100;" />
	    <input type="text" id="orgname43" name="orgname43" style="width: 400;" value="" />
	   	<input type="text" id="orgid43" name="orgid43" value="" style="width: 100;" />
	    <input type="button" id="orgbutton43" value="选择" onClick="public_multiSelectOrg('', '02', '32', '02', 'orgcode43', 'orgname43', 'orgid43', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>

   	<tr><td colspan="2"><hr></td></tr>

   	<tr>
	   	<td>多选部门（所有数据，部门业务类型为分局）：</td>
	   	<td>
	   	<input type="text" id="orgcode51" name="orgcode51" value="" style="width: 100;" onExit="alert(document.getElementById('orgname53').value);"/>
	    <input type="text" id="orgname51" name="orgname51" style="width: 400;" value="" />
	   	<input type="text" id="orgid51" name="orgid51" value="" style="width: 100;" />
	    <input type="button" id="orgbutton51" value="选择" onClick="public_multiSelectOrg('', '01', '21', '', 'orgcode51', 'orgname51', 'orgid51', false, false, '', window, 'onOrgSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>

    </table>

	<div data-options="region:'center', split:true" style="width:880px; border-width: 0px;">
		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">组织机构选择：</td>
	    	<td width="80%" class="dialogTd" colspan="3">
	    		<table border="0" cellpadding="0" cellspacing="0">
	    		<tr>
	    			<td width="580"><textarea class="easyui-validatebox" rows="3" id="orgname" name="orgname" style="width:573px; height:48px;" readonly="readonly"></textarea></td>
	    			<td><input type="hidden" name="orgcode" id="orgcode" value="510401000000"/><input type="hidden" name="orgid" id="orgid" value="${orgid}"/><input type="button" id="orgSelectButton" class="butSelect2" 
	    					onclick="public_multiSelectOrg('', '', '', '', 'orgcode', 'orgname', 'orgid', false, false, '', window, 'onOrgSelected', '')"/></td>
	    		</tr>
	    		</table>
	    	</td>
	    </tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right" style="color:#FF0000">二级级联选择例子：</td>
	    	<td width="80%" class="dialogTd" align="right"></td>
	    </tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">分市县局选择：</td>
	    	<td width="80%" class="dialogTd" colspan="3">
				<input type="text" name="orgList11" id="orgList11" value="210204000000" class="easyui-combobox" style="width:200px;" 
					data-options="url: contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=21',required:true,method:'get',
						valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:orgList11_onChange">
	    	</td>
	    </tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">所属派出所选择：</td>
	    	<td width="80%" class="dialogTd" colspan="3">
				<input type="text" name="orgList12" id="orgList12" value="210204410000" class="easyui-combobox" style="width:200px;" 
					data-options="required:true,method:'get',
						valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false">
	    	</td>
	    </tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right" style="color:#FF0000">三级级联选择例子：</td>
	    	<td width="80%" class="dialogTd" align="right"></td>
	    </tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">分市县局选择：</td>
	    	<td width="80%" class="dialogTd" colspan="3">
				<input type="text" name="orgList21" id="orgList21" value="210204000000" class="easyui-combobox" style="width:200px;" 
					data-options="url: contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=21',required:true,method:'get',
						valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:orgList21_onChange">
	    	</td>
	    </tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">所属派出所选择：</td>
	    	<td width="80%" class="dialogTd" colspan="3">
				<input type="text" name="orgList22" id="orgList22" value="210204410000" class="easyui-combobox" style="width:200px;" 
					data-options="required:true,method:'get',
						valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false,onChange:orgList22_onChange">
	    	</td>
	    </tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">所属责任区选择：</td>
	    	<td width="80%" class="dialogTd" colspan="3">
				<input type="text" name="orgList23" id="orgList23" value="210204410102" class="easyui-combobox" style="width:200px;" 
					data-options="required:true,method:'get',
						valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false">
	    	</td>
	    </tr>
   		</table>
    </div>
    
    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

<script language="JavaScript">

function onOrgSelected(orgCodeInputID) {
	alert(orgCodeInputID);
}

$(document).ready(function() { // 初始化部门名称
	public_getOrgName('orgcode', 'orgname');
	orgList11_onChange(); // 二级级联选择例子初始化
	orgList21_onChange(); // 三级级联选择例子初始化
	orgList22_onChange(); // 三级级联选择例子初始化
});

function orgList11_onChange(newValue, oldValue) {
	var parentOrgCode = $('#orgList11').combobox('getValue');
	if (parentOrgCode == "") {
		$('#orgList12').combobox('loadData', []);
	}
	else {
		var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=32&parentOrgCode=' + parentOrgCode;    
	    $('#orgList12').combobox('reload', url);
	}
}

function orgList21_onChange(newValue, oldValue) {
	var parentOrgCode = $('#orgList21').combobox('getValue');
	if (parentOrgCode == "") {
		$('#orgList22').combobox('loadData', []);
		$('#orgList23').combobox('loadData', []);
	}
	else {
		var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=32&parentOrgCode=' + parentOrgCode;    
	    $('#orgList22').combobox('reload', url);
	}
}

function orgList22_onChange(newValue, oldValue) {
	var parentOrgCode = $('#orgList22').combobox('getValue');
	if (parentOrgCode == "") {
		$('#orgList23').combobox('loadData', []);
	}
	else {
		var url = contextPath + '/orgPublicSelect/queryComboBoxList?orgLevel=50&parentOrgCode=' + parentOrgCode;    
	    $('#orgList23').combobox('reload', url);
	}
}
</script>

</body>
</html>
