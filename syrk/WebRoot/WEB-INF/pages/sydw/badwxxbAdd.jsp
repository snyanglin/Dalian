<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!--  
	@updateAuthor: [star]
	@updateDate:   [2015-6-2 上午8:51:54]
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>保安单位信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
	<form action="<%=basePath%>dwbadwxxb/save" id="dataForm" name="dataForm" method="post">
		<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
		<div data-options="region:'center', split:true" style="width:500px; border-width: 0px;margin-top:10px;text-align: center;">
			<table border="0" cellpadding="0" cellspacing="5" width="100%" align="center">
				<input type="hidden" name="id" id="pk" value="${entity.id}" />
				<input type="hidden" name="flag" id="flag" value="${flag}" />
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">保安主管部门名称：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<input class='easyui-validatebox' data-options="required:false,validType:['maxLength[70]'],tipPosition:'left'"
						type='text' name='bazgbmmc' style="width:630px;" value="${entity.bazgbmmc}" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">保安负责人姓名：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-validatebox' data-options="required:true,validType:['maxLength[30]'],tipPosition:'right'"
						type='text' name='bafzrxm' style="width:200px;" value="${entity.bafzrxm}" />
					</td>
					<td width="20%" class="dialogTd" align="right">保安负责人公民身份号码：</td>
					<td width="30%" class="dialogTd" align="left">
						<input class="easyui-validatebox" type="text" id="bafzrsfzh"
						name="bafzrsfzh" style="width:200px;float:left;" value="${entity.bafzrsfzh }"
						data-options="required:true,tipPosition:'left'" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">保安负责人职务：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-validatebox' data-options="required:false,validType:['maxLength[20]'],tipPosition:'right'"
						type='text' name='bafzrzw' style="width:200px;" value="${entity.bafzrzw}" />
					</td>
					<td width="20%" class="dialogTd" align="right">保安负责人联系电话：</td>
					<td width="30%" class="dialogTd" align="left">
						<input class="easyui-validatebox" type="text" id="bafzrlxdm"
						name="bafzrlxdm" style="width:200px;float:left;"
						value="${entity.bafzrlxdm }" data-options="validType:['phone'],required:false,tipPosition:'left'" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">服务区域名称：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-validatebox' data-options="required:false,validType:['maxLength[70]'],tipPosition:'right'"
						type='text' id="fwqymc" name='fwqymc' style="width:200px;" value="${entity.fwqymc}" />
					</td>
					<td width="20%" class="dialogTd" align="right">服务区域省市县（区）：</td>
					<td width="30%" class="dialogTd" align="left">
						<input class="easyui-combobox" type="text" id="fwqyssx" name="fwqyssx"
						style="width:200px;float:left;" value="${entity.fwqyssx }"
						data-options="url: contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">服务区域详址：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-validatebox ' data-options="required:false,validType:['maxLength[40]'],tipPosition:'right'"
						type='text' name='fwqyxz' style="width:200px;" value="${entity.fwqyxz}" />
					</td>
					<td width="20%" class="dialogTd" align="right">保安服务类型：</td>
					<td width="30%" class="dialogTd" align="left">
					 	<input class="easyui-combobox" type="text" id="bafwlxdm" name="bafwlxdm"
						style="width:200px;float:left;" value="${entity.bafwlxdm }" 
						data-options="url: contextPath + '/common/dict/GA_D_BAFWLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">服务区域负责人姓名：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-validatebox' data-options="required:false,validType:['maxLength[30]'],tipPosition:'right'"
						type='text' name='fwqyfzrxm' style="width:200px;" value="${entity.fwqyfzrxm}" />
					</td>
					<td width="20%" class="dialogTd" align="right">服务区域负责人公民身份号码：</td>
					<td width="30%" class="dialogTd" align="left">
						<input class="easyui-validatebox" type="text" id="fwqyfzrsfzh" name="fwqyfzrsfzh" style="width:200px;float:left;"
						value="${entity.fwqyfzrsfzh }" data-options="required:false,tipPosition:'left'" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">服务区域负责人职务：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-validatebox ' data-options="required:false,validType:['maxLength[20]'],tipPosition:'right'"
						type='text' name='fwqyfzrzw' style="width:200px;" value="${entity.fwqyfzrzw}" />
					</td>
					<td width="20%" class="dialogTd" align="right">服务区域负责人联系电话：</td>
					<td width="30%" class="dialogTd" align="left">
						<input class="easyui-validatebox" type="text" id="fwqyfzrlxdm"
						name="fwqyfzrlxdm" style="width:200px;float:left;" value="${entity.fwqyfzrlxdm }"
						data-options="validType:['phone'],required:false,tipPosition:'left'" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">受理备案公安机关：</td>
					<td width="50%" class="dialogTd" colspan="2">
						<input type="hidden" id="slbagajgid" name="slbagajgid" value="${entity.slbagajgid}"/>
						<input	class='easyui-validatebox  inputreadonly' data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"
						type='text' id='slbagajg' name='slbagajg' style="width:200px;" value="${entity.slbagajg}" readonly="readonly"/>
						<input type="button" id="orgbutton1" value="选择" onClick="public_singleSelectOrg('', '01', '32', '', 'slbagajgid', 'slbagajg', '', false, false, '', window, '', '')" style="cursor:pointer; background:#EEF2F8 ;border:1px solid #082F4F;HEIGHT: 18px; WIDTH: 48px;font-family:宋体;font-size:9pt;" />
						　　　　　　　　&nbsp;备案日期：
					</td>
					<td width="30%" class="dialogTd" align="left">
						<input class="easyui-validatebox" type="text" id="barq" name="barq"
						style="width:200px;float:left;" value="${entity.barq }"
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" />
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
</html>
<script type="text/javascript">
	function doInit(paramArray) {
		$("#bafzrsfzh").validatebox({
			validType : [ 'sfzh' ],
			charSet : 'halfUpper'
		});
		$("#fwqyfzrsfzh").validatebox({
			validType : [ 'sfzh' ],
			charSet : 'halfUpper'
		});
	}
	function beforeSubmit() {
	}

	function afterSubmit(arr) {
    	window.parent.location.reload();
	}
</script>