<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JeasyUI测试</title>
<style type="text/css">
.divMessage {
	border: 1px solid #000000;
	width : 500px;
	/*height: 200px;*/
	word-break: break-all;
	padding: 2px;
}
.divLocate {
	background-color: #cccccc;
}

</style>

</head>
<body scroll="auto"> 

<form id="dataform" method="post">
<div id="div0" style="background-color: #ff0000; border: 1px solid #000000; height: 200px; width: 400px;">
</div>

<div id="div1" class="divMessage">1相关内容1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111</div>
<div id="div2" class="divMessage">2相关内容</div>
<div id="div3" class="divMessage">3相关内容<input style='width:200px;' class='easyui-combobox' id='xb1' value='1,2' name='xb1' data-options="url: contextPath + '/common/dict/D_BZ_XB.js',dataFilter: '2|3|4',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></div>
<div id="div4" class="divMessage">4相关内容</div>
<div id="div5" class="divMessage">5相关内容
<A class="l-btn l-btn-small" href="javascript:void(0)" onclick="submitMethod(this,'dataform')"><SPAN class="l-btn-left l-btn-icon-left"><SPAN class="l-btn-text">保存</SPAN><SPAN class="l-btn-icon icon-save">&nbsp;&nbsp;</SPAN></SPAN></A>
</div>
<table id="div6" class="divMessage" border="0" cellpadding="0" cellspacing="0"><tr><td id="td11">dfgdfgdfg</td></tr></table>

</form>	

定位可以根据id，但不能根据name
<table>
<tr>
<td><a href="#div1" onclick="locateDiv(this)">定位到1相关处</a></td>
<td><a href="#div2" onclick="locateDiv(this)">定位到2相关处</a></td>
<td><a href="#div3" onclick="locateDiv(this)">定位到3相关处</a></td>
<td><a href="#div4" onclick="locateDiv(this)">定位到4相关处</a></td>
<td><a href="#div5" onclick="locateDiv(this)">定位到5相关处</a></td>
<td><a href="#div6" onclick="locateDiv(this)">定位到6相关处</a></td>
</tr>
</table>

<br><br>

<input type="button" value="test" onclick="test();"/>

<input type="button" value="addHTML" onclick="addHTML();"/>

<input type="button" value="addHTML2" onclick="addHTML2();"/>

<input type="button" value="addHTML3" onclick="addHTML3();"/>
	
<input type="button" value="notReadonly" onclick="formReadonly('dataform', false)"/>


<script type="text/javascript">

var selectDiv = "";

function body_onload() {
} 

function locateDiv(locateObject) {
	var locateID = locateObject.href;
	locateID = locateID.substr(locateID.lastIndexOf('#') + 1);
	if (selectDiv != "") {
		$('#' + selectDiv).removeClass('divLocate');
	}
	$('#' + locateID).addClass('divLocate');
	selectDiv = locateID;
	//$('div.divMessage').removeClass('divLocate');
}

function test() {
	var divObject = $("div.divMessage");
	alert(divObject.length)
	for (var i = 0; i < divObject.length; i++) {
		alert(divObject[i].innerHTML);
    }
}

function addHTML() {
	$("#div2").append("<input style='width:200px;' class='easyui-combobox' id='xb2' value='1,2' name='xb2' data-options=\"url: contextPath + '/common/dict/D_BZ_XB.js',dataFilter: '2|3|4',	valueField:'id',textField:'text',selectOnNavigation:false,method:'get'\">");
	$.parser.parse('#div2');
}

function addHTML2() {
	$("#div2").append("<input style='width:200px;' class='easyui-combobox' id='xb3' value='3' name='xb3' data-options=\"url: contextPath + '/common/dict/D_BZ_XB.js',dataFilter: '2|3|4',	valueField:'id',textField:'text',selectOnNavigation:false,method:'get'\">");
	$.parser.parse('#div2');
}

function addHTML3() {
	$("#td11").append("<input style='width:200px;' class='easyui-combobox' id='xb4' value='4' name='xb4' data-options=\"url: contextPath + '/common/dict/D_BZ_XB.js',dataFilter: '2|3|4',	valueField:'id',textField:'text',selectOnNavigation:false,method:'get'\">");
	$.parser.parse('#td11');
}


function submitMethod(buttonObject, formID) {
	buttonDisabled(buttonObject);
	alert(formID);
	buttonEnabled(buttonObject);
}
</script>
  
</body>
</html>