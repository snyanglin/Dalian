<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
</head>

<script language="JavaScript">
var windowID = null;
var select_unvalidObj = null;
var select_validObj = null;
var parentWindow = null;
var dictName = null;
var dictInputID = null;
var dictShowID = null;
var onOkMethod = null;
var selectedIDString = "";

function doInit(paramArray) {
	
	select_unvalidObj = document.getElementById("select_unvalid");
	select_validObj = document.getElementById("select_valid");
	if (IE && IE_VERSION <= 9) {
		select_unvalidObj.style.height = "292px";
		select_validObj.style.height = "292px";
	}
	
	parentWindow = paramArray['parentWindow'];
	windowID = paramArray['windowID'];
	dictName = paramArray['dictName'];
	dictInputID = paramArray['dictInputID'];
	dictShowID = paramArray['dictShowID'];
	onOkMethod = paramArray['onOkMethod'];
	
	selectedIDString = parentWindow.document.getElementById(dictInputID).value;
	$.ajax({
		type: 'get',
		url: dictName,
		dataType: 'json',
		success: function(data) {
			success(data);
		},
		error: function() {
			error.apply(this, arguments);
		}
	});	
	
}

function success(data) {
	if ("undefined" == typeof selectedIDString || selectedIDString == null) {
		selectedIDString = "";
	}
	if (selectedIDString == "") {
		var unvalidHTML = [];
		for (var i = 0; i < data.length; i++) {
			var node = data[i];
			unvalidHTML.push(getOptionString(node['id'], node['text']));
		}
		if (unvalidHTML.length > 0) {
			$('#select_unvalid').append(unvalidHTML.join(''));
		}	
	}
	else {
		selectedIDString = "," + selectedIDString + ",";
		var unvalidHTML = [];
		var validHTML = [];
		for (var i = 0; i < data.length; i++) {
			var node = data[i];
			if (selectedIDString.indexOf(',' + node['id'] + ',') == -1) {
				unvalidHTML.push(getOptionString(node['id'], node['text']));
			}
			else {
				validHTML.push(getOptionString(node['id'], node['text']));
			}
		}
		if (unvalidHTML.length > 0) {
			$('#select_unvalid').append(unvalidHTML.join(''));
		}	
		if (validHTML.length > 0) {
			$('#select_valid').append(validHTML.join(''));
		}	
	}
}

function ok_execute() {
	var returnIDArray = [];
	var returnNameArray = [];
	for (var i = 0; i <= select_validObj.length - 1; i++) {
		returnIDArray.push(select_validObj.options[i].value);
		returnNameArray.push(select_validObj.options[i].getAttribute("optionName"));
	}
	if (parentWindow.contentWindow) {
		parentWindow = parentWindow.contentWindow;
	}
	if (dictInputID) {
		parentWindow.document.getElementById(dictInputID).value = returnIDArray.join(",");
		parentWindow.$('#' + dictInputID).validatebox('validate');
	}
	if (dictShowID) {
		parentWindow.document.getElementById(dictShowID).value = returnNameArray.join(",");
		parentWindow.$('#' + dictShowID).validatebox('validate');
	}
}

function closeWindow() {
	window.parent.$('#' + windowID).window('close');
}

function body_onunload() {
   document.getElementById("treeDiv").innerHTML = "";
}

// 单条增加到列表
function addOptions(optionValue, optionText) {
	if (selectedIDString.indexOf(',' + optionValue + ',') == -1) {
		selectedIDString += optionValue + ",";
		$('#select_valid').append(getOptionString(optionValue, optionText));
	}
}

function button1_onclick() {
	if (select_unvalidObj.length > 0) {
		var validHTML = [];
		for (var i = 0; i < select_unvalidObj.length; i++) {        
			validHTML.push(getOptionString(select_unvalidObj.options[i].value, select_unvalidObj.options[i].getAttribute("optionName")));
		}
		$('#select_valid').append(validHTML.join(''));
		select_unvalidObj.length = 0;
	}
}

function button2_onclick() {
	var i = select_unvalidObj.selectedIndex;
	var validHTML = [];
	while (i >= 0) {
		validHTML.push(getOptionString(select_unvalidObj.options[i].value, select_unvalidObj.options[i].getAttribute("optionName")));
		select_unvalidObj.remove(i);
		i = select_unvalidObj.selectedIndex;  
	}
	if (validHTML.length > 0) {
		$('#select_valid').append(validHTML.join(''));
	}		
}

function button3_onclick() {
	var i = select_validObj.selectedIndex;
	var unvalidHTML = [];
	while (i >= 0) {
		unvalidHTML.push(getOptionString(select_validObj.options[i].value, select_validObj.options[i].getAttribute("optionName")));
		select_validObj.remove(i);
		i = select_validObj.selectedIndex;  
	}
	if (unvalidHTML.length > 0) {
		$('#select_unvalid').append(unvalidHTML.join(''));
	}	
}

function button4_onclick() {
	if (select_validObj.length > 0) {
		var unvalidHTML = [];
		for (var i = 0; i < select_validObj.length; i++) {        
			unvalidHTML.push(getOptionString(select_validObj.options[i].value, select_validObj.options[i].getAttribute("optionName")));
		}
		$('#select_unvalid').append(unvalidHTML.join(''));
		select_validObj.length = 0;
	}
}

function left_ondblclick() {
	var cur_sele = 0;
	if (select_unvalidObj.length > 0) {
		cur_sele = select_unvalidObj.selectedIndex;
		if (cur_sele >= 0) {
			var moveHTML = getOptionString(select_unvalidObj.options[cur_sele].value, select_unvalidObj.options[cur_sele].getAttribute("optionName")); 
			$('#select_valid').append(moveHTML);
			select_unvalidObj.remove(cur_sele);
		}
	}
}

function right_ondblclick() {
	var cur_sele = 0;
	if (select_validObj.length > 0) {
		cur_sele = select_validObj.selectedIndex;
		if (cur_sele >= 0) {
			var moveHTML = getOptionString(select_validObj.options[cur_sele].value, select_validObj.options[cur_sele].getAttribute("optionName")); 
			$('#select_unvalid').append(moveHTML);
			select_validObj.remove(cur_sele);
		}		
	}
}

// 取提单条列表option的html字符串
function getOptionString(optionValue, optionText) {
	var optionString = '<option value="' + optionValue + '" optionName="' + optionText + '">';
	optionString += '\xA0' + optionValue + '\xA0|\xA0' + optionText + '</options>';
	return optionString;
}

</script>

<body style="margin:20px 10px 10px 10px; overflow: hidden;" onunload="body_onunload();">

<div data-options="region:'center',split:true" style="width:760px; border-width: 0px;">
<table border="0" cellspacing="0" cellpadding="0" width="760" align="center">
<tbody>
	<tr><td>
		<table border="0" cellpadding="2" cellspacing="0" width="100%">
		<tr>
			<td align="left" id="tdunvalid" valign="top" width="340">
				<select id="select_unvalid" size="10" tabindex="10" class="multiSelect" style="width: 340px; height: 288px;" multiple ondblclick="left_ondblclick()">
				</select>
			</td>
			<td align="center" width="80">
				<table border="0" cellspacing="0" cellpadding="0">
				<tr><td align="center" height="60"><button onclick="button1_onclick()" tabindex="5" class="buttonMultiSelect" TYPE="button"><table border="0" cellspacing="0" cellpadding="0" width="23"><tr><td align="center" class="buttonAddAll"      ></td></tr><tr><td height="2"></td></tr></table></button></td></tr>
				<tr><td align="center" height="60"><button onclick="button2_onclick()" tabindex="5" class="buttonMultiSelect" TYPE="button"><table border="0" cellspacing="0" cellpadding="0" width="23"><tr><td align="center" class="buttonAddSelect"   ></td></tr><tr><td height="2"></td></tr></table></button></td></tr>
				<tr><td align="center" height="60"><button onclick="button3_onclick()" tabindex="7" class="buttonMultiSelect" TYPE="button"><table border="0" cellspacing="0" cellpadding="0" width="23"><tr><td align="center" class="buttonRemoveSelect"></td></tr><tr><td height="2"></td></tr></table></button></td></tr>
				<tr><td align="center" height="60"><button onclick="button4_onclick()" tabindex="8" class="buttonMultiSelect" TYPE="button"><table border="0" cellspacing="0" cellpadding="0" width="23"><tr><td align="center" class="buttonRemoveAll"   ></td></tr><tr><td height="2"></td></tr></table></button></td></tr>
				</table>
			</td>
			<td align="right" id="tdvalid" valign="top" width="340">
				<select id="select_valid" size="10" tabindex="10" class="multiSelect" style="width: 340px; height: 288px;" multiple ondblclick="right_ondblclick()">
				</select>
			</td>
		</tr>
		</table>
	</td></tr>
	<tr><td align="center" id="descTd" valign="bottom">
	</td></tr>
</tbody>
</table>
</div>

</body>
</html>