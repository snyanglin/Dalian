<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<!--  
	@updateAuthor: [star]
	@updateDate:   [2015-6-2 上午8:51:54]
-->
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>按摩服务场所信息</title>
 </head>
<div class="easyui-layout" data-options="fit:true">
	<form action="<%=basePath%>dwownsydw/saveAmfwcs" id="dataForm" name="dataForm" method="post">

		<input type="hidden" id="dwid" name="dwid" value="${entity.dwid}" />
        <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">按摩服务场所经营许可证：</td>
					<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="amcsjyxkz"
						   name="amcsjyxkz" style="width:200px;" value="${entity.amcsjyxkz}"
						   data-options="required:false,validType:['maxLength[50]'],invalidMessage:'按摩服务场所经营许可证不能超过50个汉字，请重新输入！',tipPosition:'right'" />
					</td>
					<td width="20%" class="dialogTd" align="right">按摩服务场所卫生许可证：</td>
					<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="amcsfwxkz"
						   name="amcsfwxkz" style="width:200px;" value="${entity.amcsfwxkz}"
						   data-options="required:false,validType:['maxLength[50]'],invalidMessage:'按摩服务场所卫生许可证不能超过50个汉字，请重新输入！',tipPosition:'left'" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">按摩间数(间)：</td>
					<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="amrsl" name="amrsl"
						   style="width:200px;" value="${entity.amrsl}"
						   data-options="required:false,validType:['naturalNumberRange[1,1000]'],tipPosition:'right'" />
					</td>
					<!--  
					<td width="20%" class="dialogTd" align="right">按摩床(椅)数量：</td>
					<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="amcsl" name="amcsl"
						   style="width:200px;" value="${entity.amcsl}"
						   data-options="required:false,validType:['naturalNumberRange[1,1000]'],tipPosition:'left'" />
					</td>
					-->
					<td width="20%" class="dialogTd" align="right">安全出口数量(个)：</td>
					<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="cksl" name="cksl"
						   style="width:200px;" value="${entity.cksl}"
						   data-options="required:false,validType:['naturalNumberRange[1,1000]'],tipPosition:'left'" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">按摩师数量(人)：</td>
					<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="amssl" name="amssl"
						   style="width:200px;" value="${entity.amssl}"
						   data-options="required:false,validType:['naturalNumberRange[1,1000]'],tipPosition:'right'" />
					</td>
					<td width="20%" class="dialogTd" align="right">休闲大厅面积(平方米)：</td>
					<td width="30%" class="dialogTd">
					<input class="easyui-validatebox" type="text" id="xxdtmj" name="xxdtmj"
						   style="width:200px;" value="${entity.xxdtmj}"
						   data-options="required:false,validType:['numeric[\'f\',2]'],invalidMessage:'休闲大厅面积为两位小数的数字，请重新输入！',tipPosition:'right'"
						   maxlength="10" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">是否具有住宿许可：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text" id="sfjyzxxk" name="sfjyzxxk" style="width:200px;" value="${entity.sfjyzxxk}"
						data-options="url: contextPath + '/common/dict/D_GG_YW.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
</html>
<script type="text/javascript">
	function doInit(paramArray) {
	}

	function beforeSubmit() {
	}

	function afterSubmit(arr) {
		window.parent.location.reload();
	}
</script>