<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>服务群众</title>
</head>
<body>  
	<br>
    <input type="button" id="btn1" value="出生证明" onclick="cszm()" /> 	
    <br>
    <input type="button" id="btn1" value="社区警务室" onclick="sqjws()" /> 
    <input type="button" id="btn1" value="社区民警" onclick="sqmj()" /> 
	<input type="button" id="btn1" value="社区治保会" onclick="sqzbh()" /> 
	<input type="button" id="btn1" value="保安组织" onclick="bazzb()" /> 
    <br/>
    <input type="button" id="btn7" value="社区基本信息" onclick="sqjbxxb()"/>
    <input type="button" id="btn8" value="社区委员会成员" onclick="sqwyhcyb()"/>
    <input type="button" id="btn9" value="社区重点部位" onclick="sqzdbwb()"/>
	<input type="button" id="btn9" value="治安组织人员" onclick="zazzryxxb()"/>
	<input type="button" id="btn9" value="物防信息" onclick="wfxxb()"/>
	<input type="button" id="btn9" value="人防信息" onclick="rfxxb()"/>
</body>
<script type="text/javascript">
function infoOpen(editUrl,title,paramArray){
	var editUrl = contextPath + editUrl;
   	openWindowWithSave(false, null,this.Window, 
   		paramArray, 
   		{
   		title: title,
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height:600
   		}, 
   		null, null
   	);
}

//sqjbxxb
function sqjbxxb(){ 
	var id='b1d8950d1aee4981b58918b5dad1b129';
	var editUrl = contextPath + '/sqjbxxb/addSqjbxxb?id='+id;
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var paramArray = [];
   	openWindowWithSave(false, null, this.Window, 
   		paramArray, 
   		{
   		title: '社区基本信息',
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height: 620
   		}, 
   		'您是否要保存？', null
   	);
}

//sqwyhcyb
function sqwyhcyb(){ 
	var id='b7e8e0b497a148c980e694c6d0bc98f3';
	var editUrl = contextPath + '/sqwyhcyb/addSqwyhcyb?sqid=000111&id='+id;
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var paramArray = [];
   	openWindowWithSave(false, null, this.Window, 
   		paramArray, 
   		{
   		title: '社区委员会成员',
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height: 620
   		}, 
   		'您是否要保存？', null
   	);
}

//sqzdbwb
function sqzdbwb(){ 
	var id='7566978950304b16bb66c28ddd883877';
	var editUrl = contextPath + '/sqzdbwb/addSqzdbwb?sqid=000111&id='+id;
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var paramArray = [];
   	openWindowWithSave(false, null, this.Window, 
   		paramArray, 
   		{
   		title: '社区重点部位',
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height: 620
   		}, 
   		'您是否要保存？', null
   	);
}

//出生证明
function cszm(){ 
	var ryid ='3816DA268C154570AA11FD5B0A42933F';
	var editUrl = contextPath + '/cszmb/addCszmb?ryid='+ryid;
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var paramArray = [];
   	openWindowWithSave(false, null, this.Window, 
   		paramArray, 
   		{
   		title: '出生证明',
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height: 620
   		}, 
   		'您是否要保存？', null
   	);
}

//社区警务室
function sqjws(){ 
	var id ='8d96faca352640d586d1a3bd4746dfe4';
	var editUrl = contextPath + '/sqjwsxxb/addSqjwsxxb?id='+id;
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var paramArray = [];
   	openWindowWithSave(false, null, this.Window, 
   		paramArray, 
   		{
   		title: '社区警务室',
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height: 620
   		}, 
   		'您是否要保存社区警务室信息？', null
   	);
}
function sqmj(){
	var id ='fabef0e10fdf423ebd0db2c37462db5d';
	var editUrl = contextPath + '/sqmjxxb/addSqmjxxb?id='+id;
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var paramArray = [];
   	openWindowWithSave(false, null, this.Window, 
   		paramArray, 
   		{
   		title: '社区民警',
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height: 620
   		}, 
   		'您是否要保存社区民警信息？', null
   	);
}
function sqzbh(){
	var editUrl = contextPath + '/sqzbhb/addSqzbhb?id=bd783549a5db41bc9d5f7d17de05e589&sqid=b1d8950d1aee4981b58918b5dad1b129';
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var paramArray = [];
   	openWindowWithSave(false, null, this.Window, 
   		paramArray, 
   		{
   		title: '社区民警',
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height: 620
   		}, 
   		'您是否要保存社区民警信息？', null
   	);
}
function bazzb(){
var editUrl = contextPath + '/bazzb/addBazzb?id=4739376dc2f3474eab74e2a599dce45a&sqid=b1d8950d1aee4981b58918b5dad1b129';
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var paramArray = [];
   	openWindowWithSave(false, null, this.Window, 
   		paramArray, 
   		{
   		title: '保安组织',
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height: 620
   		}, 
   		'您是否要保存保安组织信息？', null
   	);
}
function zazzryxxb(){
var editUrl = contextPath + '/zazzryxxb/addZazzryxxb?id=2ddbab67bbce4cd0a333eec5ba0206f1&sqid=b1d8950d1aee4981b58918b5dad1b129';
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var paramArray = [];
   	openWindowWithSave(false, null, this.Window, 
   		paramArray, 
   		{
   		title: '治安组织人员信息',
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height: 620
   		}, 
   		'您是否要保存治安组织人员信息？', null
   	);
}
function wfxxb(){
	var editUrl = contextPath+'/wfxxb/addWfxxb?id=a3c43fc08a724b92b1746c5e0e78d2e1';
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var paramArray = [];
	openWindowWithSave(false, null, this.Window, 
   		paramArray, 
   		{
   		title: '物防信息',
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height: 620
   		}, 
   		'您是否保存物防信息？', null
   	);
}

function rfxxb(){
	var editUrl = contextPath+'/rfxxb/addRfxx?id=a3c43fc08a724b92b1746c5e0e78d2e1';
	var editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	var paramArray = [];
	openWindowWithSave(false, null, this.Window, 
   		paramArray, 
   		{
   		title: '物防信息',
   		url: editUrl,
   		maximizable: false,
   		width: 850,
   		height: 620
   		}, 
   		'您是否保存物防信息？', null
   	);
}

</script>
</html>
