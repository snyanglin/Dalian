<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@CreateDate:   [2015-6-3 下午14:31:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>歌舞娱乐场所信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwownsydw/saveGwylcs" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" id="dwid" name="dwid" value="${entity.dwid}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">包厢数量(间)：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="bxsl" name="bxsl" style="width:200px;" value="${entity.bxsl}" 
			    		data-options="required:false,validType:['naturalNumberRange[1,1000]'],tipPosition:'right'"/>
			    	</td>
					<td width="20%" class="dialogTd" align="right">核定消费者数(人)：</td>
			    	<td width="30%" class="dialogTd">
			    		<input class="easyui-validatebox" type="text" id="hdxfzs" name="hdxfzs" style="width:200px;" value="${entity.hdxfzs}" 
			    		data-options="required:false,validType:['naturalNumberRange[1,9999999999999]'],tipPosition:'left'"/>
			    	</td>
			    </tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">舞池数(个)：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="wcs" name="wcs" style="width:200px;" value="${entity.wcs}"
						data-options="required:false,validType:['naturalNumberRange[1,1000]'],tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">安全出口数量(个)：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="cksl" name="cksl" style="width:200px;" value="${entity.cksl}"
						data-options="required:false,validType:['naturalNumberRange[1,100]'],tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">摄像头数量(支)：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="sxtsl" name="sxtsl" style="width:200px;" value="${entity.sxtsl}"
						data-options="required:false,validType:['naturalNumberRange[1,1000]'],tipPosition:'right'"/>
					</td>
					<td width="20%" class="dialogTd" align="right">舞池面积(平方米)：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-validatebox" type="text" id="wcmj" name="wcmj" style="width:200px;" value="${entity.wcmj}"
						data-options="required:false,validType:['numeric[\'f\',2]'],invalidMessage:'舞池面积为两位小数的数字，请重新输入！',tipPosition:'left'" maxlength="10"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">是否有安检设备：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox" type="text" id="sfyajsb" name="sfyajsb" style="width:200px;" value="${entity.sfyajsb}"
						data-options="url: contextPath + '/common/dict/D_GG_YW.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
					</td>
				</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
function doInit(paramArray) {
}

function beforeSubmit(){}

function afterSubmit(arr) {
	window.parent.location.reload();
}

</script>