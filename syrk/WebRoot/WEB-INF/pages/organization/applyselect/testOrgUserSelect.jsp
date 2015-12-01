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
	   	<td width="340">单选人员（所有数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="userid1" name="userid1" value="" style="width: 100;" />
	    <input type="text" id="username1" name="username1" style="width: 400;" value="" />
	   	<input type="text" id="usertableid1" name="usertableid1" value="" style="width: 100;" />
	   	<br/>
	   	<input type="text" id="orgcode1" name="orgcode1" value="" style="width: 100;" />
	    <input type="text" id="orgname1" name="orgname1" style="width: 400;" value="" />
	   	<input type="text" id="orgid1" name="orgid1" value="" style="width: 100;" />
	    <input type="button" id=orgbutton1" value="选择" onClick="public_singleSelectOrgUser('', '', '', '', '', '', 'userid1', 'username1', 'usertableid1', 'orgcode1', 'orgname1', 'orgid1', false, '', window, 'onOrgUserSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>单选人员（部分数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="userid2" name="userid2" value="" style="width: 100;" />
	    <input type="text" id="username2" name="username2" style="width: 400;" value="" />
	   	<input type="text" id="usertableid2" name="usertableid2" value="" style="width: 100;" />
	   	<br/>
	   	<input type="text" id="orgcode2" name="orgcode2" value="" style="width: 100;" />
	    <input type="text" id="orgname2" name="orgname2" style="width: 400;" value="" />
	   	<input type="text" id="orgid2" name="orgid2" value="" style="width: 100;" />
	    <input type="button" id=orgbutton2" value="选择" onClick="public_singleSelectOrgUser('210204000000', '', '', '', '', '', 'userid2', 'username2', 'usertableid2', 'orgcode2', 'orgname2', 'orgid2', false, '', window, 'onOrgUserSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>单选人员（所有数据，部门业务类型为派出所、刑侦）：</td>
	   	<td>
	   	<input type="text" id="userid3" name="userid3" value="" style="width: 100;" />
	    <input type="text" id="username3" name="username3" style="width: 400;" value="" />
	   	<input type="text" id="usertableid3" name="usertableid3" value="" style="width: 100;" />
	   	<br/>
	   	<input type="text" id="orgcode3" name="orgcode3" value="" style="width: 100;" />
	    <input type="text" id="orgname3" name="orgname3" style="width: 400;" value="" />
	   	<input type="text" id="orgid3" name="orgid3" value="" style="width: 100;" />
	    <input type="button" id=orgbutton3" value="选择" onClick="public_singleSelectOrgUser('', '', '', '03,04', '', '', 'userid3', 'username3', 'usertableid3', 'orgcode3', 'orgname3', 'orgid3', false, '', window, 'onOrgUserSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>单选人员（部分数据，部门业务类型为派出所）：</td>
	   	<td>
	   	<input type="text" id="userid4" name="userid4" value="" style="width: 100;" />
	    <input type="text" id="username4" name="username4" style="width: 400;" value="" />
	   	<input type="text" id="usertableid4" name="usertableid4" value="" style="width: 100;" />
	   	<br/>
	   	<input type="text" id="orgcode4" name="orgcode4" value="" style="width: 100;" />
	    <input type="text" id="orgname4" name="orgname4" style="width: 400;" value="" />
	   	<input type="text" id="orgid4" name="orgid4" value="" style="width: 100;" />
	    <input type="button" id=orgbutton4" value="选择" onClick="public_singleSelectOrgUser('210200000000', '', '', '03,04', '', '', 'userid4', 'username4', 'usertableid4', 'orgcode4', 'orgname4', 'orgid4', false, '', window, 'onOrgUserSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>    

   	<tr><td colspan="2"><hr></td></tr>
    
   	<tr height="50">
	   	<td>单选人员（不含工作组，所有数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="userid11" name="userid11" value="" style="width: 100;" />
	    <input type="text" id="username11" name="username11" style="width: 400;" value="" />
	   	<input type="text" id="usertableid11" name="usertableid11" value="" style="width: 100;" />
	   	<br/>
	   	<input type="text" id="orgcode11" name="orgcode11" value="" style="width: 100;" />
	    <input type="text" id="orgname11" name="orgname11" style="width: 400;" value="" />
	   	<input type="text" id="orgid11" name="orgid11" value="" style="width: 100;" />
	    <input type="button" id=orgbutton11" value="选择" onClick="public_singleSelectOrgUser('', '01', '', '', '', '', 'userid11', 'username11', 'usertableid11', 'orgcode11', 'orgname11', 'orgid11', false, '', window, 'onOrgUserSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>单选人员（不含工作组，部分数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="userid12" name="userid12" value="" style="width: 100;" />
	    <input type="text" id="username12" name="username12" style="width: 400;" value="" />
	   	<input type="text" id="usertableid12" name="usertableid12" value="" style="width: 100;" />
	   	<br/>
	   	<input type="text" id="orgcode12" name="orgcode12" value="" style="width: 100;" />
	    <input type="text" id="orgname12" name="orgname12" style="width: 400;" value="" />
	   	<input type="text" id="orgid12" name="orgid12" value="" style="width: 100;" />
	    <input type="button" id=orgbutton12" value="选择" onClick="public_singleSelectOrgUser('210204000000', '01', '', '', '', '', 'userid12', 'username12', 'usertableid12', 'orgcode12', 'orgname12', 'orgid12', false, '', window, 'onOrgUserSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>单选人员（不含工作组，所有数据，部门业务类型为派出所）：</td>
	   	<td>
	   	<input type="text" id="userid13" name="userid13" value="" style="width: 100;" />
	    <input type="text" id="username13" name="username13" style="width: 400;" value="" />
	   	<input type="text" id="usertableid13" name="usertableid13" value="" style="width: 100;" />
	   	<br/>
	   	<input type="text" id="orgcode13" name="orgcode13" value="" style="width: 100;" />
	    <input type="text" id="orgname13" name="orgname13" style="width: 400;" value="" />
	   	<input type="text" id="orgid13" name="orgid13" value="" style="width: 100;" />
	    <input type="button" id=orgbutton13" value="选择" onClick="public_singleSelectOrgUser('', '01', '', '03,04', '', '', 'userid13', 'username13', 'usertableid13', 'orgcode13', 'orgname13', 'orgid13', false, '', window, 'onOrgUserSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>单选人员（不含工作组，部分数据，部门业务类型为派出所）：</td>
	   	<td>
	   	<input type="text" id="userid14" name="userid14" value="" style="width: 100;" />
	    <input type="text" id="username14" name="username14" style="width: 400;" value="" />
	   	<input type="text" id="usertableid14" name="usertableid14" value="" style="width: 100;" />
	   	<br/>
	   	<input type="text" id="orgcode14" name="orgcode14" value="" style="width: 100;" />
	    <input type="text" id="orgname14" name="orgname14" style="width: 400;" value="" />
	   	<input type="text" id="orgid14" name="orgid14" value="" style="width: 100;" />
	    <input type="button" id=orgbutton14" value="选择" onClick="public_singleSelectOrgUser('210204000000', '01', '', '03,04', '', '', 'userid14', 'username14', 'usertableid14', 'orgcode14', 'orgname14', 'orgid14', false, '', window, 'onOrgUserSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>    

   	<tr><td colspan="2"><hr></td></tr>
   	
   	<tr height="50">
	   	<td>单选人员（所有数据，部门业务类型为分局）：</td>
	   	<td>
	   	<input type="text" id="userid21" name="userid21" value="" style="width: 100;" />
	    <input type="text" id="username21" name="username21" style="width: 400;" value="" />
	   	<input type="text" id="usertableid21" name="usertableid21" value="" style="width: 100;" />
	   	<br/>
	   	<input type="text" id="orgcode21" name="orgcode21" value="" style="width: 100;" />
	    <input type="text" id="orgname21" name="orgname21" style="width: 400;" value="" />
	   	<input type="text" id="orgid21" name="orgid21" value="" style="width: 100;" />
	    <input type="button" id=orgbutton21" value="选择" onClick="public_singleSelectOrgUser('', '', '21', '', '', '', 'userid21', 'username21', 'usertableid21', 'orgcode21', 'orgname21', 'orgid21', false, '', window, 'onOrgUserSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>

   	<tr><td colspan="2"><hr></td></tr>
   	<tr><td colspan="2"><hr></td></tr>

   	<tr height="50">
	   	<td>多选人员（所有数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="userid31" name="userid31" value="" style="width: 100;" />
	    <input type="text" id="username31" name="username31" style="width: 400;" value="" />
	   	<input type="text" id="usertableid31" name="usertableid31" value="" style="width: 100;" />
	   	<br/>
	   	<input type="text" id="orgcode31" name="orgcode31" value="" style="width: 100;" />
	    <input type="text" id="orgname31" name="orgname31" style="width: 400;" value="" />
	   	<input type="text" id="orgid31" name="orgid31" value="" style="width: 100;" />
	    <input type="button" id=orgbutton31" value="选择" onClick="public_multiSelectOrgUser('', '', '', '', 'JZ', '', 'userid31', 'username31', 'usertableid31', 'orgcode31', 'orgname31', 'orgid31', false, '', window, 'onOrgUserSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>多选人员（部分数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="userid32" name="userid32" value="" style="width: 100;" />
	    <input type="text" id="username32" name="username32" style="width: 400;" value="" />
	   	<input type="text" id="usertableid32" name="usertableid32" value="" style="width: 100;" />
	   	<br/>
	   	<input type="text" id="orgcode32" name="orgcode32" value="" style="width: 100;" />
	    <input type="text" id="orgname32" name="orgname32" style="width: 400;" value="" />
	   	<input type="text" id="orgid32" name="orgid32" value="" style="width: 100;" />
	    <input type="button" id=orgbutton32" value="选择" onClick="public_multiSelectOrgUser('210204000000', '', '', '', '', '', 'userid32', 'username32', 'usertableid32', 'orgcode32', 'orgname32', 'orgid32', false, '', window, 'onOrgUserSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>多选人员（所有数据，部门业务类型为派出所、刑侦）：</td>
	   	<td>
	   	<input type="text" id="userid33" name="userid33" value="" style="width: 100;" />
	    <input type="text" id="username33" name="username33" style="width: 400;" value="" />
	   	<input type="text" id="usertableid33" name="usertableid33" value="" style="width: 100;" />
	   	<br/>
	   	<input type="text" id="orgcode33" name="orgcode33" value="" style="width: 100;" />
	    <input type="text" id="orgname33" name="orgname33" style="width: 400;" value="" />
	   	<input type="text" id="orgid33" name="orgid33" value="" style="width: 100;" />
	    <input type="button" id=orgbutton33" value="选择" onClick="public_multiSelectOrgUser('', '', '', '03,04', '', '', 'userid33', 'username33', 'usertableid33', 'orgcode33', 'orgname33', 'orgid33', false, '', window, 'onOrgUserSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
   	<tr height="50">
	   	<td>多选人员（部分数据，部门业务类型为派出所）：</td>
	   	<td>
	   	<input type="text" id="userid34" name="userid34" value="" style="width: 100;" />
	    <input type="text" id="username34" name="username34" style="width: 400;" value="" />
	   	<input type="text" id="usertableid34" name="usertableid34" value="" style="width: 100;" />
	   	<br/>
	   	<input type="text" id="orgcode34" name="orgcode34" value="" style="width: 100;" />
	    <input type="text" id="orgname34" name="orgname34" style="width: 400;" value="" />
	   	<input type="text" id="orgid34" name="orgid34" value="" style="width: 100;" />
	    <input type="button" id=orgbutton34" value="选择" onClick="public_multiSelectOrgUser('210200000000', '', '', '03,04', '', '', 'userid34', 'username34', 'usertableid34', 'orgcode34', 'orgname34', 'orgid34', false, '', window, 'onOrgUserSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
    
   	<tr><td colspan="2"><hr></td></tr>
    
   	<tr height="50">
	   	<td>多选人员（只有工作组，所有数据，无部门业务类型）：</td>
	   	<td>
	   	<input type="text" id="userid41" name="userid41" value="" style="width: 100;" />
	    <input type="text" id="username41" name="username41" style="width: 400;" value="" />
	   	<input type="text" id="usertableid41" name="usertableid41" value="" style="width: 100;" />
	   	<br/>
	   	<input type="text" id="orgcode41" name="orgcode41" value="" style="width: 100;" />
	    <input type="text" id="orgname41" name="orgname41" style="width: 400;" value="" />
	   	<input type="text" id="orgid41" name="orgid41" value="" style="width: 100;" />
	    <input type="button" id=orgbutton41" value="选择" onClick="public_multiSelectOrgUser('', '02', '', '', '', '', 'userid41', 'username41', 'usertableid41', 'orgcode41', 'orgname41', 'orgid41', false, '', window, 'onOrgUserSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>

   	<tr><td colspan="2"><hr></td></tr>

   	<tr height="50">
	   	<td>多选人员（所有数据，部门业务类型为分局）：</td>
	   	<td>
	   	<input type="text" id="userid51" name="userid51" value="" style="width: 100;" />
	    <input type="text" id="username51" name="username51" style="width: 400;" value="" />
	   	<input type="text" id="usertableid51" name="usertableid51" value="" style="width: 100;" />
	   	<br/>
	   	<input type="text" id="orgcode51" name="orgcode51" value="" style="width: 100;" />
	    <input type="text" id="orgname51" name="orgname51" style="width: 400;" value="" />
	   	<input type="text" id="orgid51" name="orgid51" value="" style="width: 100;" />
	    <input type="button" id=orgbutton51" value="选择" onClick="public_multiSelectOrgUser('', '', '21', '', '', '', 'userid51', 'username51', 'usertableid51', 'orgcode51', 'orgname51', 'orgid51', false, '', window, 'onOrgUserSelected', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
	    </td>
    </tr>
    </table>

	<div data-options="region:'center', split:true" style="width:880px; border-width: 0px;">
		<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">组织机构人员选择：</td>
	    	<td width="80%" class="dialogTd" colspan="3">
	    		<table border="0" cellpadding="0" cellspacing="0">
	    		<tr>
	    			<td width="580"><textarea class="easyui-validatebox" rows="3" id="username" name="username" style="width:573px; height:48px;" readonly="readonly"></textarea></td>
	    			<td><input type="hidden" id="userid" name="userid" value="" style="width: 100;" />
	   					<input type="hidden" id="usertableid" name="usertableid" value="" style="width: 100;" />
	   					<input type="hidden" id="orgcode" name="orgcode" value="" style="width: 100;" />
	    				<input type="hidden" id="orgname" name="orgname" style="width: 400;" value="" />
	   					<input type="hidden" id="orgid" name="orgid" value="" style="width: 100;" />
	   					<input type="button" id="orgSelectButton" class="butSelect2" 
	    					onclick="public_multiSelectOrgUser('', '', '', '', '', '', 'userid', 'username', 'usertableid', 'orgcode', 'orgname', 'orgid', false, '', window, 'onOrgUserSelected', '')"/></td>
	    		</tr>
	    		</table>
	    	</td>
	    </tr>
   		</table>
    </div>

<script language="JavaScript">

function onOrgUserSelected(userIDInputID) {
	alert(userIDInputID);
}

$(document).ready(function() { // 初始化部门名称
	public_getOrgName('orgcode', 'orgname');
});

</script>

</body>
</html>
