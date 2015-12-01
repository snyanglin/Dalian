<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>动态管理纪实</title>
</head>

<body>

<form action="" id="dataForm" name="dataForm" method="post">
    
	<input type="hidden" id="_method" name="_method" value=""/>
  	<input type='hidden' name='id' id="pk" value="${entity.id}" />
	<input type="hidden" id="zdryid" name="zdryid" value="${entity.zdryid}"/>
	<input type="hidden" id="jslxdm" name="jslxdm" value="${entity.jslxdm}"/>
   
   	<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
		<tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">姓名：</td>
	    	<td width="30%" class="dialogTd">
	    		<input class="easyui-validatebox inputreadonly" type="text" id="xm" name="xm" style="width:200px;" readonly="readonly"/>
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">公民身份号码：</td>
	    	<td width="30%" class="dialogTd">
	    		<input class="easyui-validatebox inputreadonly" type="text" id="sfzh" name="sfzh" style="width:200px;" readonly="readonly"/>
	    	</td>
   		</tr>
		<tr class="dialogTr">
			<td width="20%" class="dialogTd" align="right">纪实模板：</td>
	    	<td width="30%" class="dialogTd">
	    		<input id="jsmb" class="easyui-combobox" style="width:200px;" data-options="valueField:'id',textField:'text',
	    			isTopLoad:false, onChange:jsmb_onchange,
	    			formatter: function(row) {
						var opts = $(this).combobox('options');
						return row[opts.textField];
					}"/>
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">是否在控：</td>
	    	<td width="30%" class="dialogTd">
	    		<input name="sfzkdm" id="sfzkdm" value="${entity.sfzkdm}" class="easyui-combobox" style="width:200px;" maxlength="1"
					data-options="url: contextPath + '/common/dict/BD_D_SFDM.js',valueField:'id',textField:'text',selectOnNavigation:false,
					tipPosition:'left',required:true"/>
	    	</td>
		</tr>
		<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">纪实内容：</td>
	    	<td width="80%" class="dialogTd" colspan="3"><textarea name="dtjs" id="dtjs" class="easyui-validatebox" style="width: 618px; height:96px;"
				data-options="validType:['maxLength[1000]'],invalidMessage:'纪实内容不能超过1000个汉字，请重新输入！',tipPosition:'left',required:true">${entity.dtjs}</textarea></td>
    	</tr>
		<tr class="dialogTr">
    		<td width="20%" class="dialogTd" align="right">纪实时间：</td>
	    	<td width="30%" class="dialogTd">
	    		<input class="easyui-validatebox inputreadonly" type="text" id="js_sj" name="js_sj" value="${entity.js_sj}" style="width:200px;" readonly="readonly"/>
	    	</td>
	    	<td width="20%" class="dialogTd" align="right">纪实民警：</td>
	    	<td width="30%" class="dialogTd">
	    		<input type='hidden' name='dtjsmj_id' id="dtjsmj_id" value="${entity.dtjsmj_id}" />
	    		<input class="easyui-validatebox inputreadonly" type="text" id="dtjsmj_xm" name="dtjsmj_xm" value="${entity.dtjsmj_xm}" style="width:200px;" readonly="readonly"/>
	    	</td>
   		</tr>
    	<tr class="dialogTr">
	    	<td width="20%" class="dialogTd" align="right">备注：</td>
	    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz" id="bz" class="easyui-validatebox" style="width: 618px; height:48px;"
				data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea></td>
    	</tr>
    </table>
</form>
    
</body>

<script type="text/javascript"> 


function doInit(paramArray) {
	$('#sfzh').val(paramArray["sfzh"]);
	$('#xm').val(paramArray["xm"]);
	$('#jsmb').combobox({data: ${listJson}});
	if ($('#pk').val() != "") {
		formReadonly('dataForm', true);
	}
}

function beforeSubmit() {
	if ($("#pk").val() == "") {
		$("#_method").val('');
		$("#dataForm").attr('action', contextPath + '/zdryDtgljsxxb/save');
	}
	else {
		$("#_method").val('PUT');
		$("#dataForm").attr('action', contextPath + '/zdryDtgljsxxb/' + $("#pk").val());
	}
}

function afterSubmit(arr) {
	if (arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}

function jsmb_onchange(newValue, oldValue) {
	var jsmbValue = $("#jsmb").combobox("getValue");
	if (jsmbValue != "") {
		var data = $("#jsmb").combobox("getData");
		var mbnr = "";
		for (var i = 0; i < data.length; i++) {
			var tempRow = data[i];
			if (tempRow['id'] == jsmbValue) {
				mbnr = tempRow['mbnr'];
				break;
			}
		}
		if (mbnr != "") {
			$("#dtjs").val(mbnr);
			$('#dtjs').validatebox('validate');
		}
	}
}
</script>

</html>
