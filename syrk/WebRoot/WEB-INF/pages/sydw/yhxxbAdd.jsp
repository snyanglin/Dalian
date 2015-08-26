<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@UpdateDate:   [2015-6-2 上午8:51:54]
	@updateAuthor: [star]
	@updateDate:   [2015-6-4 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>银行信息</title>
</head>

<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>yhxxb/save" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
	    <div data-options="region:'center', split:true" style="width:700px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
				<input type="hidden" id="pk" name="id" value="${entity.id}" />
			    <tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">银行类别：</td>
					<td width="30%" class="dialogTd">
						<input  type='text' id='yhlbdm' name='yhlbdm' class="easyui-combobox " style="width:200px;"
							data-options="required:true,url: contextPath + '/common/dict/D_DW_YHLB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" value="${entity.yhlbdm}" />
					</td>			
					<td width="20%" class="dialogTd" align="right">银行级别：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox"  type="text" id="yhjbdm" name="yhjbdm" maxlength="100" style="width:200px;" value="${entity.yhjbdm}"
							data-options="required:true,url: contextPath + '/common/dict/D_DW_YHJB.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">银行所有制：</td>
					<td width="30%" class="dialogTd">
						<input class="easyui-combobox"  type="text" id="yhsyz" name="yhsyz" maxlength="100" style="width:200px;" 
						data-options="required:true,url: contextPath + '/common/dict/BD_D_YHSYZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" value="${entity.yhsyz}" />
			     	</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">是否有金库：</td>
					<td width="30%" class="dialogTd">
						<input  type='text' id='sfyjkdm' name='sfyjkdm'  class="easyui-combobox" style="width:200px;" value="${entity.sfyjkdm}"
							data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'left',onSelect: fsyj" />
					</td>
					<td width="20%" class="dialogTd" align="right">金库分类：</td>
					<td width="30%" class="dialogTd">
						<input  type='text' id='jkfldm' name='jkfldm'  class="easyui-combobox" style="width:200px;" value="${entity.jkfldm}"
							data-options="url: contextPath + '/common/dict/D_BZ_JRZABWGLXXDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'" />
					</td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">风险等级：</td>
					<td width="30%" class="dialogTd">
					    <input class="easyui-combobox"  type="text" id="fxdj" name="fxdj" maxlength="100" style="width:200px;" 
					    data-options="required:true,url: contextPath + '/common/dict/BD_D_YHFXDJ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" value="${entity.fxdj}" />
					</td>
					<td width="20%" class="dialogTd" align="right">枪支数量：</td>
					<td width="30%" class="dialogTd">
						<input  type="text" id="qzsl" name="qzsl" class="easyui-validatebox" style="width:200px;"
					 		value="${entity.qzsl}" data-options="validType:['naturalNumber'],tipPosition:'left'" maxlength="8"/>
					 </td>
				</tr>
				<tr class="dialogTr">
					<td width="20%" class="dialogTd" align="right">安全防范合格证编号：</td>
					<td width="30%" class="dialogTd">
						<input  type="text" id="aqffhgzbh" name="aqffhgzbh" class="easyui-validatebox" style="width:200px;"
							maxlength="100" value="${entity.aqffhgzbh}"/>
					</td>
				</tr>
				<tr class="dialogTr">
			    	<td width="20%" class="dialogTd" align="right">备注：</td>
					<td width="80%" class="dialogTd" colspan="3">
						<textarea class="easyui-validatebox" id="bz" name="bz" style="width: 627px; height:48px;"
							data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',required:false,tipPosition:'left',required:false">${entity.bz}</textarea>
					</td>
		    	</tr>
	    	</table>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
function doInit(paramArray) {
	var s = $("#sfyjkdm").combobox("getText");
	if(s!="是"){
		setInputReadonly("jkfldm",true);
		setInputReadonly("qzsl",true);
	}else if(s=="是"){
		setInputReadonly("jkfldm",false);
		setInputReadonly("qzsl",false);
	}
}
function beforeSubmit() {
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	window.parent.location.reload();
}
function fsyj(){
	var s = $("#sfyjkdm").combobox("getText");
	if(s=="是"){
		setInputReadonly("jkfldm",false);
		setInputReadonly("qzsl",false);
	} else {
		$("#jkfldm").combobox("setValue","");
		$("#qzsl").val("");
		setInputReadonly("jkfldm",true);
		setInputReadonly("qzsl",true);
	}
}

</script>
