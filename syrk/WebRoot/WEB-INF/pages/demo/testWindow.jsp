<%@page language="java" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/easyloader.js"></script>
<script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JeasyUI测试</title>
</head>

<body>
	<table width="100%" border="0">
	<tr><td align="left" style="padding-left:6px;">
		<h2>Modal Window</h2>
		<p>Click the open button below to open the modal window.</p>
		<div style="margin:20px 0;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="topMessagerShow(null,'我的提示消息！')">顶层消息窗口</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="topMessagerAlert(null,'我的警告消息！')">顶层警告窗口</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="myConfirm();">顶层确认窗口</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="getWindowWidthHeight()">取窗口宽度与高度</a>
		</div>
		
		<div style="margin:20px 0;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('open')">Open</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#w').window('close')">Close</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="ab()">ab</a>
		</div>
	
		<div style="height:1800px;"></div>
		
		<div style="margin:20px 0;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="topMessagerShow(null,'我的提示消息！')">顶层消息窗口</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="topMessagerAlert(null,'我的警告消息！')">顶层警告窗口</a>
		</div>
		<div style="margin:20px 0;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="window.top.openWindow(true,'test1', contextPath + '/forward/demo|testCombo', {document: document}, {title: '测试combo',    
		    width: 860,   
		    height: 500,  
			collapsible: false, 
			minimizable: false, 
			maximizable: false,
			closable: true,
		    closed: false,    
		    cache: false,
		    inline: false,
			resizable: false, 
		    modal: true})">test 顶层缓存combo</a>
		</div>
	
		<div style="margin:20px 0;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="window.top.openWindow(false,'', contextPath + '/forward/demo|testCombo', {document: document}, {title: '测试combo',    
		    width: 860,   
		    height: 500,  
			collapsible: false, 
			minimizable: false, 
			maximizable: false,
			closable: true,
		    closed: false,    
		    cache: false,
		    inline: false,
			resizable: false, 
		    modal: true})">test 顶层不缓存combo</a>
		</div>
	
		<div style="margin:20px 0;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="openWindow(false,'', contextPath + '/forward/demo|testForm2', {document: document}, {title: '测试combo',    
		    width: 860,   
		    height: 500,  
			collapsible: false, 
			minimizable: false, 
			maximizable: false,
			closable: true,
		    closed: false,    
		    cache: false,
		    inline: false,
			resizable: false, 
		    modal: true})">test 本页面不缓存form2</a>
		</div>	
		
		<div id="w" class="easyui-dialog" title=" Modal Window" data-options="title:'对话框标题', href: contextPath + '/forward/demo|testCombo' ,modal:true,closed:true,iconCls:'icon-save', buttons: [
			{
				text: '确定',
				iconCls: 'icon-ok',
				handler: function() {
				}
			},
			{
				text: '取消',
				iconCls: 'icon-cancel',
				handler: function() {
				}
			}
		]" style="width:800px;height:500px;padding:10px;">
		</div>
		<div id="w2" class="easyui-window" title=" Modal Window" data-options="href:'<%=contextPath%>/login.jsp',modal:true,closed:true,iconCls:'icon-save'" style="width:800px;height:500px;padding:10px;">
		</div>
	
		<textarea id="text1" rows="30" cols="50" style="position:absolute;top:20px;left:800px;"></textarea>
		
		<input type="button" onclick="aaa()" value="test">
		<iframe width="100" height="100" style="border: 1px;"></iframe>
	
		<input/>
		
	</td></tr>
	</table>		

<script type="text/javascript">

/*
window.using('../js/aaa.js', function(){ // 加载路径相对于 easyloader.js 目录  
	alert("loaded");
}); 
*/

function myConfirm() {
	topMessager.confirm('', '是否确认？',  function(r) {
		if (r) {
			alert('ok');
		}
		else {
			alert('cancel');
		}
	});
}

$('#w').window({
	onOpen: function(){
    alert("open aaa");
	}
});

function fff() {
   return "It's fff";
}

function aaa() {
	window.top.aaa();
}

function ab() {
	topMessager.alert('', '弹出层缺少url参数！');
}

function getWindowWidthHeight() {
	var _winWidth = window.innerWidth;
	var _winHeight = window.innerHeight; 
	if (typeof _winWidth != "number"){ 
		if(document.compatMode == "number"){ 
			_winWidth = document.documentElement.clientWidth; 
			_winHeight = document.documentElement.clientHeight; 
		}else{ 
			_winWidth = document.body.clientWidth; 
			_winHeight = document.body.clientHeight; 
		} 
	}
	alert("窗口宽度 = "+  _winWidth + "\n\n窗口高度 = " + _winHeight);
}

function destroyTopWindow() {
	try {
		window.top.destroyWindow('test1,test2');
	}
	catch (err) {}
}

// 页面加载完成事件
window.onload  = function() {
	destroyTopWindow();
}

// 页面退出事件
window.onbeforeunload = function() {
	destroyTopWindow();
}

</script>

</body>
</html>