<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!--  
	@updateAuthor: [star]
	@updateDate:   [2015-6-2 上午8:51:54]
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单位处罚信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
	<form action="<%=basePath%>dwcfxxb/save" id="dataForm" name="dataForm" method="post">
		<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
		<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" name="id" id="pk" value="${entity.id}" />
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">单位名称：</td>
					<td width="80%" class="dialogTd" colspan="3">
					 	<input	class="easyui-validatebox inputreadonly" type="text" id="dwmc" style="width:625px;" readonly="readonly" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">处罚类型：</td>
					<td width="30%" class="dialogTd">
					 	<input class="easyui-combobox" type="text" name="cflxdm" id="cflxdm"
						value="${entity.cflxdm}" style="width:200px"
						data-options="required:true,url: contextPath + '/common/dict/D_DW_CFLX.js',valueField:'id',textField:'text',dataFilter:'202|208|209|210|212|213|217|315|316|317|318|319|320|321|SFJY|108',selectOnNavigation:false,method:'get',tipPosition:'right'" />
					</td>
					<td width="20%" class="dialogTd" align="right">处罚日期：</td>
					<td width="30%" class="dialogTd">
					 	<input class="easyui-validatebox" type="text" name="cfrq" id="cfrq" style="width:210px" value="${entity.cfrq}"
						data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'"
						onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="25%" class="dialogTd" align="right">处罚决定书字号：</td>
					<td width="25%" class="dialogTd">
						<input class="easyui-validatebox" type="text" name="xzcfjdszh" id="xzcfjdszh" style="width:200px" value="${entity.xzcfjdszh}"
						data-options="charSet:'halfUpper',tipPosition:'right'" maxlength="32" />
					</td>
					<td width="20%" class="dialogTd" align="right">案件编号：</td>
					<td width="30%" class="dialogTd">
					  	<input class="easyui-validatebox" type="text" name="ajbh" id="ajbh" value="${entity.ajbh}" style="width:210px" maxlength="32"
						data-options="charSet:'halfUpper',validType:['upperLetterOrNum'],tipPosition:'left'" />
					</td>
				</tr>
				<tr>
					<td width="20%" class="dialogTd" align="right">经办单位：</td>
						<input type="hidden" name="jbdwid" id="jbdwid" value="${entity.jbdwid}" />
					<td width="80%" class="dialogTd" colspan='3'>
					 	 <input class="easyui-validatebox" type="text" name="jbdw" id="jbdw"
						 value="${entity.jbdw}" data-options="charSet:'halfUpper',tipPosition:'left'"
						 maxlength="50" style="width:625px;" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">经办人：</td>
					<input type="hidden" name="jbrid" id="jbrid" value="${entity.jbrid}" />
					<td width="80%" class="dialogTd" colspan="3">
					 	<input class="easyui-validatebox" type="text" name="jbr" id="jbr" value="${entity.jbr}"
						data-options="charSet:'halfUpper',tipPosition:'left'" maxlength="50" style="width:625px;" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">处罚情况：</td>
					<td width="80%" class="dialogTd" colspan='3'>
				 		<textarea id="cfqk" name="cfqk" class="easyui-validatebox" style="width: 625px; height:48px;"
						data-options="validType:['maxLength[4000]'],invalidMessage:'处罚情况不能超过4000个汉字，请重新输入！',tipPosition:'left'">${entity.cfqk}</textarea>
					</td>
				</tr>
				<tr>
					<td width="20%" class="dialogTd" align="right">处罚结果：</td>
					<td width="80%" class="dialogTd" colspan='3'>
						<textarea id="cfjg" name="cfjg" class="easyui-validatebox" style="width:625px; height:48px;"
						data-options="validType:['maxLength[4000]'],invalidMessage:'处罚结果不能超过4000个汉字，请重新输入！',tipPosition:'left'">${entity.cfjg}</textarea>
					</td>
				</tr>
				<tr>
					<td width="20%" class="dialogTd" align="right">备注：</td>
					<td width="80%" class="dialogTd" colspan='3'>
						<textarea id="bz" name="bz" class="easyui-validatebox" style="width:625px; height:48px;"
						data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
</html>
<script type="text/javascript">
	function doInit(paramArray) {
		$("#dwmc").val(paramArray["dwmc"]);
		if(paramArray["mode"]=='view'){
			$('#dataForm').find('input[type="text"]').each(function(i,o){
				$(o).attr('readonly','readonly');
				$(o).addClass('inputReadonly');
				$(o).next(".combo").addClass("inputReadonly");
			});
			$('#dataForm').find('textarea').each(function(i,o){
				$(o).attr('readonly','readonly');
				$(o).addClass('inputReadonly');
			});
			$('#dataForm').find('input[type="checkbox"]').each(function(i,o){
				$(o).attr('disabled','disabled');
			});
		}
	}
	function beforeSubmit() {
	}

	function afterSubmit(arr) {
		if (arr["saveID"]) {
			$("#pk").val(arr["saveID"]);
		}
	}
</script>