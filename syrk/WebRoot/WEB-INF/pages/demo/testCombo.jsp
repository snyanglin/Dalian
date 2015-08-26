<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JeasyUI测试</title>
</head>

<body>
	<table width="100%" border="0">
	<tr><td align="left" style="padding-left:6px;">	

		<div style="margin:20px 0;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#xb1').combobox('reload', contextPath + '/common/dict/D_BZ_XB.js')">LoadData</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#xb1').combobox('setValue','9,3')">SetValue</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="alert($('#xb1').combobox('getValues'));">GetValue</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="alert(document.getElementById('xb1').value);">GetInputValue</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="alert($('#xb1').combobox('getDataFilter'));">GetDataFilter</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#xb1').combobox('setDataFilter', '1|2');">SetDataFilter('1|2')</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#xb1').combobox('setDataFilter', '');">SetDataFilter('')</a>
		</div>
		
		<table width="100%"><tr>
		<td align="left">
			<input style="width:200px;" class="easyui-combobox" id="xb1" value="1,2" name="xb1"
					data-options="url: '<%=contextPath%>/common/dict/D_BZ_XB.js',dataFilter: '^(?!2|3|9).*',
						valueField:'id',textField:'text',selectOnNavigation:false,method:'get'">
		    <input/>
		    <textarea >dsfsfsdfsd</textarea>
		    <input type="text" id="date1" style="width:180px;" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})">
		</td>
		</tr>
		</table>
	    
	    <br/>
	    <br/>
	    
	    <div style="margin:20px 0;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#xb2').combobox('reload', contextPath + '/common/dict/D_BZ_XB.js')">LoadData</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#xb2').combobox('setValue','9,3')">SetValue</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="alert($('#xb2').combobox('getValues'));">GetValue</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="alert(document.getElementById('xb2').value);">GetInputValue</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="alert($('#xb2').combobox('getDataFilter'));">GetDataFilter</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#xb2').combobox('setDataFilter', '1|2');">SetDataFilter('1|2')</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#xb2').combobox('setDataFilter', '');">SetDataFilter('')</a>
		</div>			
	
	    <input style="width:200px;" class="easyui-combobox" id="xb2"  name="xb2" value="1,2"
	     			data-options="url: '<%=contextPath%>/common/dict/D_BZ_XB.js',multiple:true, width: 300,method:'get',
					valueField:'id',textField:'text',selectOnNavigation:false"/>
	
		<input value="D_BZ_CYZJ" style="font-family:宋体;" readonly="readonly"/>
		<input value="" disabled="disabled"/>
		<input value=""/>
		<br/><br/>
		
	    <div style="margin:20px 0;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#myTree').combotree('reload', contextPath + '/common/dict/D_BZ_XZQH_PROVINCE.js')">Load本省</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#myTree').combotree('reload', contextPath + '/common/dict/D_BZ_XZQH_MUNICIPAL.js')">Load本市</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="myTreeAppend();">AppendData</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="getSelected();">getSelected</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#myTree').combotree('setValue','510107,510108')">SetValue</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="alert($('#myTree').combotree('getValues'));">GetValue</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="alert(document.getElementById('myTree').value);">GetInputValue</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="alert($('#myTree').combotree('tree').tree('getDataFilter'));">GetDataFilter</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#myTree').combotree('tree').tree('setDataFilter', '5101');">SetDataFilter('5101')</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#myTree').combotree('tree').tree('setDataFilter', '');">SetDataFilter('')</a>
		</div>			
	    
	    <input id="myTree" class="easyui-combotree" value="510104,510106" name="myTree"
	    		data-options="url:'<%=contextPath%>/common/dict/D_BZ_XZQH_MUNICIPAL.js',onlyLeaf:true,dataFilter:'',multiple:false,required:true,panelWidth:320,
							method:'get',editable:true,lines:true" style="width:200px;">
	    <input/>
	    <input id="myTree2" class="easyui-combotree" value="ROOT,510100" 
	    		data-options="url:'<%=contextPath%>/common/dict/D_BZ_XZQH.js',onlyLeaf:false,dataFilter:'',multiple:false,required:true,panelWidth:320,
							method:'get',editable:true,lines:true" style="width:200px;">
	    
	 	<div style="margin:20px 0;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="loadDict();">top load dict</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="removeDict();">top remove dict</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="getDictText();">top get dict text</a>
		</div>
		
		<input id="xzqh" value="510104,510105"/>
		<textarea id="xzqh_mc" cols="50"></textarea>
		<input type="button" value="树形顶层页面选择" onclick="window.top.dict_multiSelectTree(false, 'topwww', window, contextPath + '/common/dict/D_BZ_XZQH_PROVINCE.js', 'xzqh', 'xzqh_mc', true, false, '', 'onOk');"/>
		<input type="button" value="顶层窗口清除" onclick="destroyTopWindow();"/>
		<input type="button" value="树形本页面选择" onclick="dict_multiSelectTree(false, 'www', window, contextPath + '/common/dict/D_BZ_XZQH.js', 'xzqh', 'xzqh_mc', false, true, '', 'onOk')"/>
		
		<br/></br/>
		
		<input id="xzqhList" value="510104,510105"/>
		<textarea id="xzqhList_mc" cols="50"></textarea>
		<input type="button" value="列表顶层页面选择" onclick="window.top.dict_multiSelectList(false, 'dictList', window, contextPath + '/common/dict/D_BZ_XZQHLIST.js', 'xzqhList', 'xzqhList_mc', '', 'onOk2');"/>
		<input type="button" value="列表本页面选择" onclick="dict_multiSelectList(false, 'dictList', window, contextPath + '/common/dict/D_BZ_XZQHLIST.js', 'xzqhList', 'xzqhList_mc', '', 'onOk');"/>

		<br/></br/>
		<input class="easyui-combogrid" style="width:250px" value="EST-10" data-options="
				panelWidth: 500,
				idField: 'itemid',
				textField: 'productname',
				url: contextPath + '/common/jeasyui/demo/datagrid_data1.js',
				method: 'get',
				multiple: true,
				columns: [[
					{field:'itemid',title:'Item ID',width:80,checkbox:true},
					{field:'productname',title:'Product',width:120},
					{field:'listprice',title:'List Price',width:80,align:'right'},
					{field:'unitcost',title:'Unit Cost',width:80,align:'right'},
					{field:'attr1',title:'Attribute',width:200},
					{field:'status',title:'Status',width:60,align:'center'}
				]],
				fitColumns: true,selectOnNavigation:false
			">
		
		<textarea id="text1" rows="30" cols="40" style="position:absolute;top:20px;left:880px;"></textarea>

	</td></tr>
	</table> 	
	
<script type="text/javascript">

function validate1() {
}

/*
$('#xb1').combobox({
	onSelect: function(record){
    alert(record.value);
    alert(record.text);
    alert(record['value']);
    alert(record['text']);
    var opts = $(this).combobox('options');
    alert(record[opts.valueField]);
    alert(record[opts.textField]);
	}
});
*/

function body_onload() {
	initDict();
   /*
   $('#xb1').combobox({ // 重新定义formatter
		formatter: function(row){
			var opts = $(this).combobox('options');
			return row[opts.textField];
		}
	});
   */
	//alert("onload");
	//parentParam.getElementById("text1").value += "body_onload" + "\n";
} 


$.parser.onComplete = function() {
	//alert("complete");
	//initDict();
}

function initDict() {
  	//$('#xb1').combobox('setValue', '3,4');
  	$('#myTree').combotree('setValue', '650102,510104');
  	var xzqhMc = window.top.getDictName(contextPath + '/common/dict/D_BZ_XZQH.js', document.getElementById("xzqh").value);
  	document.getElementById("xzqh_mc").value = xzqhMc;
}

function aaa() {
   alert("aaa");
}

function myTreeAppend() {
	var node = $('#myTree').combotree('tree').tree('find', "510100");
	if (node != null) {
		$('#myTree').combotree('tree').tree('append', {
			parent: node.target,
			data: [{
				id: '510199',
				text: '增加的结点',
				py: 'ROOT',
				biz: '增加的属性'
			}]
		});
	}	
}

function getSelected() {
	var node = $('#myTree').combotree('tree').tree("getSelected");
	if (node != null) {
	   alert("id = " + node.id + "\n" + "text = " + node.text + "\n" + "py = " + node.py + "\n" + "biz = " + node.biz);
	}
}

function loadDict() {
	top.getPublicDict(contextPath + '/common/dict/D_BZ_XB.js');
	top.getPublicDict(contextPath + '/common/dict/D_BZ_XZQH.js');
}

function removeDict() {
	top.removePublicDict(contextPath + '/common/dict/D_BZ_XB.js');
}

function getDictText() {
	var dictText = window.top.getDictName(contextPath + '/common/dict/D_BZ_XB.js', "1,122,123,4");
	alert(dictText);
	dictText = window.top.getDictName(contextPath + '/common/dict/D_BZ_XZQH.js', "510104,510105,4");
	alert(dictText);
}

var parentParam = null;
function doInit(param) {
	alert("doInit");
	alert(param);
	parentParam = param;
	parentParam.getElementById("text1").value += "doInit" + "\n";
	initDict();
}

function onOk() {
	alert(document.getElementById("xzqh").value);
}

function onOk2() {
	alert(document.getElementById("xzqhList").value);
}

$(document).ready(function() {
	//initDict();
	//alert("ready");
	//parentParam.getElementById("text1").value += "ready" + "\n";
  	//$('#xb1').combobox('setValues', ['3']);
	//$('#myTree').combotree('setValues', ['650102']);
});
/*
$.ajax({
  url: "../combotree/tree_data1.json",
  cache: false,
  success: function(html){
    alert(html);
  }
});

$.getJSON("../combotree/tree_data1.json", function(json){
  alert("JSON Data: " + json);
});
*/

function destroyTopWindow() {
	try {
		window.top.destroyWindow('topwww');
	}
	catch (err) {}
}

// 页面加载完成事件
window.onload  = function() {
	destroyTopWindow();
	initDict();
}

// 页面退出事件
window.onbeforeunload = function() {
	destroyTopWindow();
}
</script>
  
</body>
</html>