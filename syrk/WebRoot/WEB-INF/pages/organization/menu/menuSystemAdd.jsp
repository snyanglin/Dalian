<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>orgMenu/saveSystem" id="dataForm" name="dataForm" method="post">
		<input type="hidden" name="id"/>
		<div data-options="region:'center', split:true" id="formDiv" style="border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="816" align="center">
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">资源系统代码：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="systemcode" name="systemcode" style="width:200px;" maxlength="50"
		    		data-options="validType:['variable'],charSet:'half',required:true,tipPosition:'right'"/></td>
		    	<td width="20%" class="dialogTd" align="right"></td>
		    	<td width="30%" class="dialogTd"></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">资源系统名称：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="systemname" name="systemname" style="width:200px;" maxlength="50"
		    		data-options="validType:['noMark'],required:true,tipPosition:'right'"/></td>
		    	<td width="20%" class="dialogTd" align="right">资源系统简称：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="systemnamejc" name="systemnamejc" style="width:200px;" maxlength="50"
		    		data-options="validType:['noMark'],required:true,tipPosition:'left'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">资源系统根访问URL：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="systemcontexturl" name="systemcontexturl" style="width:603px;" maxlength="200" 
		    		data-options="validType:['url'],charSet:'half',invalidMessage:'资源系统根访问URL必须是有效的URL地址，请重新输入！',tipPosition:'bottom'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">资源系统登陆URL：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="systemloginurl" name="systemloginurl" style="width:603px;" maxlength="200" 
		    		data-options="validType:['url'],charSet:'half',invalidMessage:'资源系统登陆URL必须是有效的URL地址，请重新输入！',tipPosition:'bottom'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">大图标样式：</td>
		    	<td width="30%" class="dialogTd">
		    		<table border="0" cellpadding="0" cellspacing="0" width="210">
		    		<tr>
		    			<td width="180"><input class="easyui-combobox" type="text" id="systemiconbig" name="systemiconbig" style="width:180px;"
							data-options="url: contextPath + '/common/dict/D_ORG_MENUICONBIG.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',onChange:systemiconbigOnchange,formatter:comboboxFormatter"/></td>
						<td width="30" align="center"><div id="div_systemiconbig" style="width:16px; height:16px;"></div></td>
					</tr>
					</table>
				</td>
		    	<td width="20%" class="dialogTd" align="right">图标样式：</td>
		    	<td width="30%" class="dialogTd">
		    		<table border="0" cellpadding="0" cellspacing="0" width="210">
		    		<tr>
		    			<td width="180"><input class="easyui-combobox" type="text" id="systemicon" name="systemicon" style="width:180px;"
							data-options="url: contextPath + '/common/dict/D_ORG_MENUICON.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left',onChange:systemiconOnchange,formatter:comboboxFormatter"/></td>
						<td width="30" align="center"><div id="div_systemicon" class="icon-favorite" style="width:16px; height:16px;"></div></td>
					</tr>
					</table>
		    	</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz" class="easyui-validatebox" style="width: 603px; height:48px;"
					data-options="validType:['maxLength[200]'],invalidMessage:'备注不能超过200个汉字，请重新输入！',tipPosition:'left'"></textarea></td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >
function doInit(paramArray) {
}

function beforeSubmit() {
}

function afterSubmit(submitData) {
}

function systemiconbigOnchange() {
	var systemiconbigValue = $("#systemiconbig").combobox("getValue");
	if (systemiconbigValue == "") {
		$("#div_systemiconbig").attr('class', '');
	}
	else {
		$("#div_systemiconbig").attr('class', systemiconbigValue);
	}
}

function systemiconOnchange() {
	var systemiconValue = $("#systemicon").combobox("getValue");
	if (systemiconValue == "") {
		$("#div_systemicon").attr('class', 'icon-favorite');
	}
	else {
		$("#div_systemicon").attr('class', systemiconValue);
	}
}

function comboboxFormatter(row) {
	var opts = $(this).combobox('options');
	if (opts.maxValueLength == 0) { 
		var data = $(this).combobox('getData');
		var maxValueLen = 0; 
		var optionTextMaxLen = 0;
		for (var i = 0; i < data.length; i++) {
			var tempRow = data[i];
			var vLen = (tempRow[opts.valueField] + '').length;
			var sLen = getGBLength(tempRow[opts.textField]);
			if (vLen > maxValueLen) {
				maxValueLen = vLen;
			}
			if (sLen > optionTextMaxLen) {
				optionTextMaxLen = sLen;
			}
		}
		opts.maxValueLength = maxValueLen;
		autoPanelWidth = (maxValueLen + optionTextMaxLen + 8) * 6 + 24;
		autoPanelWidth = autoPanelWidth < opts.width ? opts.width : autoPanelWidth;
		var autoPanelHeight = data.length;
		if (data.length > 8) {
			autoPanelHeight = 8;
		}
		else if (autoPanelHeight < 2) {
			autoPanelHeight = 2;
		}
		var itemHeight = 21;
		if (IE && IE_VERSION <= 9) {
			itemHeight = 19;
		}
		$(this).combo('panel').panel('resize',{width:autoPanelWidth ,height: autoPanelHeight * itemHeight + 2});	
	}
	var emptyString = getReapeatString("\xA0", opts.maxValueLength - row[opts.valueField].length);
	return row[opts.valueField] + emptyString + "\xA0|\xA0<span class='" + row[opts.valueField] + "' style='width:16px; height:16px; font-size:16px;'>&nbsp;&nbsp;</span>\xA0" + row[opts.textField];
}

</script>

</body>
</html>