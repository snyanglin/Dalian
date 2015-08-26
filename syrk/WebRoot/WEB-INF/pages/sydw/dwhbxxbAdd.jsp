<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!--  
	@updateAuthor: [star]
	@updateDate:   [2015-6-2 上午8:51:54]
-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单位环保信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
	<form action="<%=basePath%>dwhbxxb/save" id="dataForm" name="dataForm" method="post">
		<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
		<div data-options="region:'center', split:true"
			style="width:500px; border-width: 0px;margin-top:10px;text-align: center;">
			<table border="0" cellpadding="0" cellspacing="5" width="100%"
				align="center">
				<input type="hidden" name="id" id="pk" value="${entity.id}" />
				<input type="hidden" name="flag" id="flag" value="${flag}" />
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">主要污染物：</td>
					<td width="30%" class="dialogTd">
				    	<input class='easyui-validatebox '
						data-options="required:true,validType:['maxLength[50]'],tipPosition:'right'"
						type='text' name='zywrw' style="width:200px;"
						value="${entity.zywrw}" />
					</td>
					<td width="20%" class="dialogTd" align="right">在册职工数：</td>
					<td width="30%" class="dialogTd">
					   <input class="easyui-validatebox"
						data-options="required:false,validType:['naturalNumberRange[1,1000]'],tipPosition:'left'"
						type="text" id="zczgs" name="zczgs" style="width:200px;"
						value="${entity.zczgs}" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">环保主管负责人姓名：</td>
					<td width="30%" class="dialogTd">
						<input	class='easyui-validatebox '
						data-options="required:true,validType:['maxLength[50]'],tipPosition:'right'"
						type='text' name='hbzgfzrxm' style="width:200px;"
						value="${entity.hbzgfzrxm}" />
					</td>
					<td width="20%" class="dialogTd" align="right">环保主管负责人身份证号：</td>
					<td width="30%" class="dialogTd" align="left">
						<input class="easyui-validatebox" type="text" id="hbzgfzrsfzh"
						name="hbzgfzrsfzh" style="width:200px;float:left;"
						value="${entity.hbzgfzrsfzh }"
						data-options="required:true,tipPosition:'left'" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">环保主管负责人职务：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-validatebox '
						data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"
						type='text' name='hbzgfzrzw' style="width:200px;"
						value="${entity.hbzgfzrzw}" />
					</td>
					<td width="20%" class="dialogTd" align="right">环保主管负责人联系方式：</td>
					<td width="30%" class="dialogTd" align="left">
						<input class="easyui-validatebox" type="text" id="hbzgfzrlxdm"
						name="hbzgfzrlxdm" style="width:200px;float:left;"
						value="${entity.hbzgfzrlxdm }"
						data-options="validType:['phone'],required:false,tipPosition:'left'" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">污染物状态：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-combobox '
						data-options="url: contextPath + '/common/dict/BD_D_WRWZTDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"
						type='text' id="wrwztdm" name='wrwztdm' style="width:200px;"
						value="${entity.wrwztdm}" />
					</td>
					<td width="20%" class="dialogTd" align="right">污染物类型：</td>
					<td width="30%" class="dialogTd" align="left">
						<input class="easyui-combobox" type="text" id="wrwlxdm" name="wrwlxdm"
						style="width:200px;float:left;" value="${entity.wrwlxdm }"
						data-options="url: contextPath + '/common/dict/BD_D_WRWLXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">排放污染物信息：</td>
					<td width="30%" class="dialogTd">
						<input class='easyui-validatebox '
						data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"
						type='text' name='pfwrwxx' style="width:200px;"
						value="${entity.pfwrwxx}" />
					</td>
					<td width="20%" class="dialogTd" align="right">污染物名称：</td>
					<td width="30%" class="dialogTd" align="left">
						<input class="easyui-validatebox" type="text" id="wrwmc" name="wrwmc"
						style="width:200px;float:left;" value="${entity.wrwmc }"
						data-options="required:false,validType:['maxLength[50]'],tipPosition:'left'" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">备注：</td>
					<td width="80%" class="dialogTd" colspan="3">
							<textarea class='easyui-validatebox '
							data-options="required:false,validType:['maxLength[500]'],tipPosition:'right'"
							type='text' name='bz' style="width: 630px;height:48px;">${entity.bz}</textarea>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
</html>
<script type="text/javascript">
	var _p;
	function doInit(paramArray) {
		_p = paramArray["_p"];
		$("#hbzgfzrsfzh").validatebox({
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