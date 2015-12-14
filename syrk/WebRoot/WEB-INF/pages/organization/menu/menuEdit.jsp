<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>orgMenu/saveMenu" id="dataForm" name="dataForm" method="post">
		<input type="hidden" name="id" value="${entity.id}"/>
		<input type="hidden" name="systemid" value="${entity.systemid}"/>
		<input type="hidden" name="parentid" value="${entity.parentid}"/>
		<div data-options="region:'center', split:true" id="formDiv" style="border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="816" align="center">
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">所属系统：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="systemname" value="${systemname}" style="width:200px;"/></td>
		    	<td width="20%" class="dialogTd" align="right">菜单类型：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="menutype" name="menutype" value="${entity.menutype}" style="width:200px;"
					data-options="url: contextPath + '/common/dict/D_ORG_MENUTYPE.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">菜单名称：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="menuname" name="menuname" value="${entity.menuname}" style="width:200px;" maxlength="50" onblur="menuname_onblur()"
		    		data-options="validType:['noMark'],required:true,tipPosition:'right'"/></td>
		    	<td width="20%" class="dialogTd" align="right">菜单级别：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="menulevel" name="menulevel" value="${entity.menulevel}" style="width:200px;"
					data-options="url: contextPath + '/common/dict/D_ORG_MENULEVEL.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">菜单URL：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><input class="easyui-validatebox" type="text" id="menuurl" name="menuurl" value="${entity.menuurl}" style="width:490px;" maxlength="200" 
		    		data-options="charSet:'half',tipPosition:'bottom'"/>
					<input type="button" id="menuurl_process_but" value="转 换" onclick="menuurl_process()" class="dictSearchButton" title="当菜单地址中有特殊字符或中文字符时请转换！"/>
            		<input type="button" id="menuurl_comeback_but" value="还 原" onclick="menuurl_comeback()" class="dictSearchButton" title="已转换过的还原成原字符，提供修改！"/>		    		
		    	</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">打开方式：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-combobox" type="text" id="menuopenmode" name="menuopenmode" value="${entity.menuopenmode}" style="width:200px;"
					data-options="url: contextPath + '/common/dict/D_ORG_MENUOPENMODE.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
		    	<td width="20%" class="dialogTd" align="right">图标样式：</td>
		    	<td width="30%" class="dialogTd">
		    		<table border="0" cellpadding="0" cellspacing="0" width="210">
		    		<tr>
		    			<td width="180"><input class="easyui-combobox" type="text" id="menuicon" name="menuicon" value="${entity.menuicon}" style="width:180px;"
							data-options="url: contextPath + '/common/dict/D_ORG_MENUICON.js',valueField:'id',textField:'text',
							selectOnNavigation:false,method:'get',tipPosition:'left',onChange:menuiconOnchange,formatter:comboboxFormatter"/></td>
						<td width="30" align="center"><div id="div_menuicon" style="width:16px; height:16px;"></div></td>
					</tr>
					</table>
		    	</td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">大图标图片1：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="bigiconimg1" name="bigiconimg1" value="${entity.bigiconimg1}" style="width:200px;" maxlength="100"
		    		data-options="validType:['imgFile'],tipPosition:'right'"/></td>
		    	<td width="20%" class="dialogTd" align="right">大图标说明1：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="bigicontext1" name="bigicontext1" value="${entity.bigicontext1}" style="width:200px;" maxlength="50"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">大图标图片2：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="bigiconimg2" name="bigiconimg2" value="${entity.bigiconimg2}" style="width:200px;" maxlength="100"
		    		data-options="validType:['imgFile'],tipPosition:'right'"/></td>
		    	<td width="20%" class="dialogTd" align="right">大图标说明2：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="bigicontext2" name="bigicontext2" value="${entity.bigicontext2}" style="width:200px;" maxlength="50"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">大图标图片3：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="bigiconimg3" name="bigiconimg3" value="${entity.bigiconimg3}" style="width:200px;" maxlength="100"
		    		data-options="validType:['imgFile'],tipPosition:'right'"/></td>
		    	<td width="20%" class="dialogTd" align="right">大图标说明3：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="bigicontext3" name="bigicontext3" value="${entity.bigicontext3}" style="width:200px;" maxlength="50"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">大图标图片4：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="bigiconimg4" name="bigiconimg4" value="${entity.bigiconimg4}" style="width:200px;" maxlength="100"
		    		data-options="validType:['imgFile'],tipPosition:'right'"/></td>
		    	<td width="20%" class="dialogTd" align="right">大图标说明4：</td>
		    	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="bigicontext4" name="bigicontext4" value="${entity.bigicontext4}" style="width:200px;" maxlength="50"/></td>
	    	</tr>
	    	<tr class="dialogTr">
		    	<td width="20%" class="dialogTd" align="right">备注：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bz" class="easyui-validatebox" style="width: 603px; height:48px;"
					data-options="validType:['maxLength[200]'],invalidMessage:'备注不能超过200个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea></td>
	    	</tr>
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >
var menutypeValue = "${entity.menutype}"; 
	
function doInit(paramArray) {
	setInputReadonly('systemname', true);
	setInputReadonly('menutype', true);
	if (menutypeValue == "1") {
		setInputReadonly('menulevel', true);
		setInputReadonly('menuurl', true);
		setInputReadonly('menuopenmode', true);
		setInputDisabled('menuurl_process_but', true);
		setInputDisabled('menuurl_comeback_but', true);
		setInputReadonly('bigiconimg1', true);
		setInputReadonly('bigicontext1', true);
		setInputReadonly('bigiconimg2', true);
		setInputReadonly('bigicontext2', true);
		setInputReadonly('bigiconimg3', true);
		setInputReadonly('bigicontext3', true);
		setInputReadonly('bigiconimg4', true);
		setInputReadonly('bigicontext4', true);
	}
	menuiconOnchange();
}

function beforeSubmit() {
}

function afterSubmit(submitData) {
}

function menuname_onblur() {
	var menunameValue = $('#menuname').val();
	if (menunameValue != "") {
		if ($('#bigicontext1').val() == "") {
			$('#bigicontext1').val(menunameValue);
		}
		if ($('#bigicontext2').val() == "") {
			$('#bigicontext2').val(menunameValue);
		}
		if ($('#bigicontext3').val() == "") {
			$('#bigicontext3').val(menunameValue);
		}
		if ($('#bigicontext4').val() == "") {
			$('#bigicontext4').val(menunameValue);
		}
	}
}

function menuiconOnchange() {
	var menuiconValue = $("#menuicon").combobox("getValue");
	if ("undefined" == typeof menuiconValue || menuiconValue == "") {
		if (menutypeValue == "1") {
			$("#div_menuicon").attr('class', 'tree-org');
		}
		else {
			$("#div_menuicon").attr('class', 'tree-leaf');
		}
	}
	else {
		$("#div_menuicon").attr('class', menuiconValue);
	}
}

//还原URL
function menuurl_comeback() {
   var tempURL = $('#menuurl').val();
   if (tempURL != "") {
      try {
	     $('#menuurl').val(decodeURI(tempURL));
      }
      catch (err) {}
   }
}

// 转换URL
function menuurl_process() {
   var tempURL = $('#menuurl').val();
   if (tempURL != "") {
      try {
	     $('#menuurl').val(encodeURI(tempURL));
      }
      catch (err) {}
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