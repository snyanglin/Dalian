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
   	
   	<tr height="50">
	   	<td width="340">单选岗位（所有数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="posid1" name="posid1" value="" style="width: 100;" />
	    <input type="text" id="posname1" name="posname1" style="width: 400;" value="" />
	   	<br/>
	   	<input type="text" id="orgcode1" name="orgcode1" value="" style="width: 100;" />
	    <input type="text" id="orgname1" name="orgname1" style="width: 400;" value="" />
	   	<input type="text" id="orgid1" name="orgid1" value="" style="width: 100;" />
	    <input type="button" id=orgbutton1" value="选择" onClick="public_singleSelectOrgPos('', '', '', '', '', '', 'posid1', 'posname1', 'orgcode1', 'orgname1', 'orgid1', false, '', window, 'onOrgPosSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>单选岗位（部分数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="posid2" name="posid2" value="" style="width: 100;" />
	    <input type="text" id="posname2" name="posname2" style="width: 400;" value="" />
	   	<br/>
	   	<input type="text" id="orgcode2" name="orgcode2" value="" style="width: 100;" />
	    <input type="text" id="orgname2" name="orgname2" style="width: 400;" value="" />
	   	<input type="text" id="orgid2" name="orgid2" value="" style="width: 100;" />
	    <input type="button" id=orgbutton2" value="选择" onClick="public_singleSelectOrgPos('210204000000', '', '', '', '', '', 'posid2', 'posname2', 'orgcode2', 'orgname2', 'orgid2', false, '', window, 'onOrgPosSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>单选岗位（所有数据，部门业务类型为派出所、刑侦）：</td>
	   	<td>
	   	<input type="text" id="posid3" name="posid3" value="" style="width: 100;" />
	    <input type="text" id="posname3" name="posname3" style="width: 400;" value="" />
	   	<br/>
	   	<input type="text" id="orgcode3" name="orgcode3" value="" style="width: 100;" />
	    <input type="text" id="orgname3" name="orgname3" style="width: 400;" value="" />
	   	<input type="text" id="orgid3" name="orgid3" value="" style="width: 100;" />
	    <input type="button" id=orgbutton3" value="选择" onClick="public_singleSelectOrgPos('', '', '', '03,04', '', '', 'posid3', 'posname3', 'orgcode3', 'orgname3', 'orgid3', false, '', window, 'onOrgPosSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>单选岗位（部分数据，部门业务类型为派出所）：</td>
	   	<td>
	   	<input type="text" id="posid4" name="posid4" value="" style="width: 100;" />
	    <input type="text" id="posname4" name="posname4" style="width: 400;" value="" />
	   	<br/>
	   	<input type="text" id="orgcode4" name="orgcode4" value="" style="width: 100;" />
	    <input type="text" id="orgname4" name="orgname4" style="width: 400;" value="" />
	   	<input type="text" id="orgid4" name="orgid4" value="" style="width: 100;" />
	    <input type="button" id=orgbutton4" value="选择" onClick="public_singleSelectOrgPos('210200000000', '', '', '03,04', '', '', 'posid4', 'posname4', 'orgcode4', 'orgname4', 'orgid4', false, '', window, 'onOrgPosSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>    

   	<tr><td colspan="2"><hr></td></tr>
    
   	<tr height="50">
	   	<td>单选岗位（不含工作组，所有数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="posid11" name="posid11" value="" style="width: 100;" />
	    <input type="text" id="posname11" name="posname11" style="width: 400;" value="" />
	   	<br/>
	   	<input type="text" id="orgcode11" name="orgcode11" value="" style="width: 100;" />
	    <input type="text" id="orgname11" name="orgname11" style="width: 400;" value="" />
	   	<input type="text" id="orgid11" name="orgid11" value="" style="width: 100;" />
	    <input type="button" id=orgbutton11" value="选择" onClick="public_singleSelectOrgPos('', '01', '', '', '', '', 'posid11', 'posname11', 'orgcode11', 'orgname11', 'orgid11', false, '', window, 'onOrgPosSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>单选岗位（不含工作组，部分数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="posid12" name="posid12" value="" style="width: 100;" />
	    <input type="text" id="posname12" name="posname12" style="width: 400;" value="" />
	   	<br/>
	   	<input type="text" id="orgcode12" name="orgcode12" value="" style="width: 100;" />
	    <input type="text" id="orgname12" name="orgname12" style="width: 400;" value="" />
	   	<input type="text" id="orgid12" name="orgid12" value="" style="width: 100;" />
	    <input type="button" id=orgbutton12" value="选择" onClick="public_singleSelectOrgPos('210204000000', '01', '', '', '', '', 'posid12', 'posname12', 'orgcode12', 'orgname12', 'orgid12', false, '', window, 'onOrgPosSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>单选岗位（不含工作组，所有数据，部门业务类型为派出所）：</td>
	   	<td>
	   	<input type="text" id="posid13" name="posid13" value="" style="width: 100;" />
	    <input type="text" id="posname13" name="posname13" style="width: 400;" value="" />
	   	<br/>
	   	<input type="text" id="orgcode13" name="orgcode13" value="" style="width: 100;" />
	    <input type="text" id="orgname13" name="orgname13" style="width: 400;" value="" />
	   	<input type="text" id="orgid13" name="orgid13" value="" style="width: 100;" />
	    <input type="button" id=orgbutton13" value="选择" onClick="public_singleSelectOrgPos('', '01', '', '03,04', '', '', 'posid13', 'posname13', 'orgcode13', 'orgname13', 'orgid13', false, '', window, 'onOrgPosSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>单选岗位（不含工作组，部分数据，部门业务类型为派出所）：</td>
	   	<td>
	   	<input type="text" id="posid14" name="posid14" value="" style="width: 100;" />
	    <input type="text" id="posname14" name="posname14" style="width: 400;" value="" />
	   	<br/>
	   	<input type="text" id="orgcode14" name="orgcode14" value="" style="width: 100;" />
	    <input type="text" id="orgname14" name="orgname14" style="width: 400;" value="" />
	   	<input type="text" id="orgid14" name="orgid14" value="" style="width: 100;" />
	    <input type="button" id=orgbutton14" value="选择" onClick="public_singleSelectOrgPos('210204000000', '01', '', '03,04', '', '', 'posid14', 'posname14', 'orgcode14', 'orgname14', 'orgid14', false, '', window, 'onOrgPosSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>    

   	<tr><td colspan="2"><hr></td></tr>
   	
   	<tr height="50">
	   	<td>单选岗位（所有数据，部门业务类型为分局）：</td>
	   	<td>
	   	<input type="text" id="posid21" name="posid21" value="" style="width: 100;" />
	    <input type="text" id="posname21" name="posname21" style="width: 400;" value="" />
	   	<br/>
	   	<input type="text" id="orgcode21" name="orgcode21" value="" style="width: 100;" />
	    <input type="text" id="orgname21" name="orgname21" style="width: 400;" value="" />
	   	<input type="text" id="orgid21" name="orgid21" value="" style="width: 100;" />
	    <input type="button" id=orgbutton21" value="选择" onClick="public_singleSelectOrgPos('', '', '21', '', '', '', 'posid21', 'posname21', 'orgcode21', 'orgname21', 'orgid21', false, '', window, 'onOrgPosSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>

   	<tr><td colspan="2"><hr></td></tr>
   	<tr><td colspan="2"><hr></td></tr>

   	<tr height="50">
	   	<td>多选岗位（所有数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="posid31" name="posid31" value="" style="width: 100;" />
	    <input type="text" id="posname31" name="posname31" style="width: 400;" value="" />
	   	<br/>
	   	<input type="text" id="orgcode31" name="orgcode31" value="" style="width: 100;" />
	    <input type="text" id="orgname31" name="orgname31" style="width: 400;" value="" />
	   	<input type="text" id="orgid31" name="orgid31" value="" style="width: 100;" />
	    <input type="button" id=orgbutton31" value="选择" onClick="public_multiSelectOrgPos('', '', '', '', '', '', 'posid31', 'posname31', 'orgcode31', 'orgname31', 'orgid31', false, '', window, 'onOrgPosSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>多选岗位（部分数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="posid32" name="posid32" value="" style="width: 100;" />
	    <input type="text" id="posname32" name="posname32" style="width: 400;" value="" />
	   	<br/>
	   	<input type="text" id="orgcode32" name="orgcode32" value="" style="width: 100;" />
	    <input type="text" id="orgname32" name="orgname32" style="width: 400;" value="" />
	   	<input type="text" id="orgid32" name="orgid32" value="" style="width: 100;" />
	    <input type="button" id=orgbutton32" value="选择" onClick="public_multiSelectOrgPos('210204000000', '', '', '', '', '', 'posid32', 'posname32', 'orgcode32', 'orgname32', 'orgid32', false, '', window, 'onOrgPosSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>多选岗位（所有数据，部门业务类型为派出所、刑侦）：</td>
	   	<td>
	   	<input type="text" id="posid33" name="posid33" value="" style="width: 100;" />
	    <input type="text" id="posname33" name="posname33" style="width: 400;" value="" />
	   	<br/>
	   	<input type="text" id="orgcode33" name="orgcode33" value="" style="width: 100;" />
	    <input type="text" id="orgname33" name="orgname33" style="width: 400;" value="" />
	   	<input type="text" id="orgid33" name="orgid33" value="" style="width: 100;" />
	    <input type="button" id=orgbutton33" value="选择" onClick="public_multiSelectOrgPos('', '', '', '03,04', '', '', 'posid33', 'posname33', 'orgcode33', 'orgname33', 'orgid33', false, '', window, 'onOrgPosSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>多选岗位（部分数据，部门业务类型为派出所）：</td>
	   	<td>
	   	<input type="text" id="posid34" name="posid34" value="" style="width: 100;" />
	    <input type="text" id="posname34" name="posname34" style="width: 400;" value="" />
	   	<br/>
	   	<input type="text" id="orgcode34" name="orgcode34" value="" style="width: 100;" />
	    <input type="text" id="orgname34" name="orgname34" style="width: 400;" value="" />
	   	<input type="text" id="orgid34" name="orgid34" value="" style="width: 100;" />
	    <input type="button" id=orgbutton34" value="选择" onClick="public_multiSelectOrgPos('210200000000', '', '', '03,04', '', '', 'posid34', 'posname34', 'orgcode34', 'orgname34', 'orgid34', false, '', window, 'onOrgPosSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
    
   	<tr><td colspan="2"><hr></td></tr>
    
   	<tr height="50">
	   	<td>多选岗位（只有工作组，所有数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="posid41" name="posid41" value="" style="width: 100;" />
	    <input type="text" id="posname41" name="posname41" style="width: 400;" value="" />
	   	<br/>
	   	<input type="text" id="orgcode41" name="orgcode41" value="" style="width: 100;" />
	    <input type="text" id="orgname41" name="orgname41" style="width: 400;" value="" />
	   	<input type="text" id="orgid41" name="orgid41" value="" style="width: 100;" />
	    <input type="button" id=orgbutton41" value="选择" onClick="public_multiSelectOrgPos('', '02', '', '', '', '', 'posid41', 'posname41', 'orgcode41', 'orgname41', 'orgid41', false, '', window, 'onOrgPosSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>

   	<tr><td colspan="2"><hr></td></tr>

   	<tr height="50">
	   	<td>多选岗位（所有数据，部门业务类型为分局）：</td>
	   	<td>
	   	<input type="text" id="posid51" name="posid51" value="" style="width: 100;" />
	    <input type="text" id="posname51" name="posname51" style="width: 400;" value="" />
	   	<br/>
	   	<input type="text" id="orgcode51" name="orgcode51" value="" style="width: 100;" />
	    <input type="text" id="orgname51" name="orgname51" style="width: 400;" value="" />
	   	<input type="text" id="orgid51" name="orgid51" value="" style="width: 100;" />
	    <input type="button" id=orgbutton51" value="选择" onClick="public_multiSelectOrgPos('', '', '21', '', '', '', 'posid51', 'posname51', 'orgcode51', 'orgname51', 'orgid51', false, '', window, 'onOrgPosSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
    </table>

	<div data-options="region:'center', split:true" style="width:880px; border-width: 0px;">
		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">组织机构岗位选择：</td>
	    	<td width="80%" class="dialogTd" colspan="3">
	    		<table border="0" cellpadding="0" cellspacing="0">
	    		<tr>
	    			<td width="580"><textarea class="easyui-validatebox" rows="3" id="posname" name="posname" style="width:573px; height:48px;" readonly="readonly"></textarea></td>
	    			<td><input type="hidden" id="posid" name="posid" value="" style="width: 100;" />
	   					<input type="hidden" id="orgcode" name="orgcode" value="" style="width: 100;" />
	    				<input type="hidden" id="orgname" name="orgname" style="width: 400;" value="" />
	   					<input type="hidden" id="orgid" name="orgid" value="" style="width: 100;" />
	   					<input type="button" id="orgSelectButton" class="butSelect2" 
	    					onclick="public_multiSelectOrgPos('', '', '', '', '', '', 'posid', 'posname', 'orgcode', 'orgname', 'orgid', false, '', window, 'onOrgPosSelected', '')"/></td>
	    		</tr>
	    		</table>
	    	</td>
	    </tr>
   		</table>
    </div>

<script language="JavaScript">

function onOrgPosSelected(posidInputID) {
	alert(posidInputID);
}

</script>

</body>
</html>
