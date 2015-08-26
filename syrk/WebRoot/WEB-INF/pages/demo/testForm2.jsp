<%@page language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JeasyUI测试</title>
</head>

<body scroll="auto"> 

<form name="dataform" id="dataform" method="post">
<table cellpadding="2" cellspacing="2" border="0" width="100%">
	<tr>
		<td align="right" width="20%" valign="top">性别：</td>	
		<td width="80%">
			<input type="text" name="xb" id="xb" value="1,2" class="easyui-combobox" style="width:200px;" 
				data-options="url: contextPath + '/common/dict/D_BZ_XB.js',dataFilter: '2|3|4',required:true,method:'get',
					valueField:'id',textField:'text',selectOnNavigation:false, onChange: xbOnchange">
			<span class="edit_word"></span>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%" valign="top">行政区划列表（本市）：</td>	
		<td width="80%">
	    	<input type="text" name="xzqh11" id="xzqh11" class="easyui-combobox" style="width:200px;"
	    		data-options="url: contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',dataFilter:'.*[^00]$',required:true,
							method:'get',valueField:'id',textField:'text',selectOnNavigation:false">（不能以00结尾 ）
			<span class="edit_word"></span>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%" valign="top">行政区划列表（本省）：</td>	
		<td width="80%">
	    	<input type="text" name="xzqh12" id="xzqh12" class="easyui-combobox" style="width:200px;"
	    		data-options="url: contextPath + '/common/dict/D_BZ_XZQHLIST_PROVINCE.js',dataFilter:'.*[^00]$',required:true,
							method:'get',valueField:'id',textField:'text',selectOnNavigation:false">（不能以00结尾 ）
			<span class="edit_word"></span>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%" valign="top">行政区划列表（全国）：</td>	
		<td width="80%">
	    	<input type="text" name="xzqh13" id="xzqh13" class="easyui-combobox" style="width:200px;"
	    		data-options="mode:'remote',method:'post',dataFilter:'.*[^00]$',required:true,
							valueField:'id',textField:'text',selectOnNavigation:false">（不能以00结尾 ）
			<span class="edit_word"></span>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%" valign="top">行政区划列表（全国）：</td>	
		<td width="80%">
	    	<input type="text" name="xzqh14" id="xzqh14" class="easyui-combobox" style="width:200px;"
	    		data-options="mode:'remote',method:'post',dataFilter:'^51.*[^00]$',required:true,
							valueField:'id',textField:'text',selectOnNavigation:false">（以51开始并且不能以00结尾 ）
			<span class="edit_word"></span>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%" valign="top">行政区划列表（全国）：</td>	
		<td width="80%">
	    	<input type="text" name="xzqh15" id="xzqh15" class="easyui-combobox" style="width:200px;"
	    		data-options="mode:'remote',method:'post',dataFilter:'',required:true,
							valueField:'id',textField:'text',selectOnNavigation:false">（无过滤条件 ）
			<span class="edit_word"></span>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%" valign="top">行政区划树状（本市）：</td>	
		<td width="80%">
	    	<input type="text" name="xzqh21" id="xzqh21" class="easyui-combotree" style="width:200px;"
	    		data-options="url: contextPath + '/common/dict/D_BZ_XZQH_MUNICIPAL.js',onlyLeaf:true,dataFilter:'',multiple:false,required:true,panelWidth:320,
							method:'get',editable:true,lines:true">
			<span class="edit_word"></span>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%" valign="top">行政区划树状（本省）：</td>	
		<td width="80%">
	    	<input type="text" name="xzqh22" id="xzqh22" class="easyui-combotree" style="width:200px;"
	    		data-options="url: contextPath + '/common/dict/D_BZ_XZQH_PROVINCE.js',onlyLeaf:true,dataFilter:'',multiple:false,required:true,panelWidth:320,
							method:'get',editable:true,lines:true">
			<span class="edit_word"></span>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%" valign="top">行政区划树状（全国）：</td>	
		<td width="80%" id="delayTd">
	    	<input type="text" name="xzqh23" id="xzqh23" class="easyui-validatebox" style="width:200px;"
	    		data-options="url: contextPath + '/common/dict/D_BZ_XZQH.js',onlyLeaf:true,dataFilter:'',multiple:false,required:true,panelWidth:320,
							method:'get',editable:true,lines:true">（点击延时解析）
			<span class="edit_word"></span>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%" valign="top">选择处所（重定向）：</td>	
		<td width="80%">
	    	<input type="text" name="xzcs" id="xzcs" class="easyui-combotree" style="width:200px;"
	    		data-options="url: contextPath + '/forward/demo|testForward?dictName=D_BZ_XZCS',onlyLeaf:true,dataFilter:'',multiple:false,required:true,panelWidth:320,
							method:'get',editable:true,lines:true">
			<span class="edit_word"></span>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%" valign="top">无引号：</td>	
		<td width="80%">
			<input type="text" name="noMark" id="noMark" class="easyui-validatebox" style="width: 200px;" 
				data-options="required:true,charSet:'upper',validType:['noMark','maxLength[10]']"/>
			<span class="edit_word"></span>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%" valign="top">图片文件上传：</td>	
		<td width="80%">
			<input type="file" name="uploadFile" id="uploadFile" class="easyui-validatebox" style="width: 200px;" 
				data-options="validType:['imgFile']"/>（后辍为：JPG,JPEG,GIF,PNG,BMP）
			<span class="edit_word"></span>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%" valign="top">文本框：</td>	
		<td width="80%">
			<textarea name="textarea" class="easyui-validatebox" cols="20" rows="3" style="width: 200px; height:48px;"
			data-options="validType:['maxLength[10]']"></textarea>
			<span class="edit_word"></span>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%" valign="top">combogrid：</td>	
		<td width="80%">
			<input class="easyui-combogrid" name="combogrid" style="width:250px" name="combogrid" value="EST-10" data-options="
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
			<span class="edit_word"></span>
		</td>
	</tr>
	<tr>
		<td align="right" width="20%" valign="top">测试复选：</td>	
		<td width="80%">
			<input type="checkbox" name="checkbox" value="checkbox1" id="checkbox1"/>checkbox1
			<input type="checkbox" name="checkbox" value="checkbox2" id="checkbox2"/>checkbox2
			<input type="checkbox" name="checkbox" value="checkbox3" id="checkbox3"/>checkbox3
			<input type="radio" name="rad" value="radio1" id="radio1"/>radio1
			<input type="radio" name="rad" value="radio2" id="radio2"/>radio2
			<input type="radio" name="rad" value="radio3" id="radio3"/>radio3
		</td>
	</tr>	
	<tr>
		<td align="right" width="20%" valign="top">测试提交：</td>	
		<td width="80%">
			<input type="button" id="button1" value="button"/>
			<input type="reset" id="button2" value="reset"/>
			<input type="submit" id="button3" value="submit"/>
			<input type="button" value="取得表单内的显示数据" onclick="getFormDataToSpan('dataform')"/>
		</td>
	</tr>	

</table>
</form>	

<br><br>

<input type="button" value="validate" onclick="alert($('#dataform').form('validate'));"/>

<input type="button" value="enableValidation" onclick="$('#dataform').form('enableValidation');$('#dataform').form('validate');"/>

<input type="button" value="disableValidation" onclick="$('#dataform').form('disableValidation')"/>

<input type="button" value="readonly" onclick="formReadonly('dataform', true)"/>
	
<input type="button" value="notReadonly" onclick="formReadonly('dataform', false)"/>

<input type="button" value="getFormData" onclick="getFormData(document.forms['dataform'])"/>

<input type="button" value="getFormData2" onclick="getFormDataByID('dataform')"/>

<input type="button" value="validateNoMark" onclick="$('#noMark').val('123456');$('#noMark').validatebox('validate')"/>

<br/><br/>

<input type="button" value="性别 readonly" onclick="setInputReadonly('xb', true)"/>
	
<input type="button" value="性别 notReadonly" onclick="setInputReadonly('xb', false)"/>

<input type="button" value="行政区划 readonly" onclick="setInputReadonly('xzqh11', true)"/>
	
<input type="button" value="行政区划 notReadonly" onclick="setInputReadonly('xzqh11', false)"/>

<input type="button" value="无引号 readonly" onclick="setInputReadonly('noMark', true)"/>
	
<input type="button" value="无引号 notReadonly" onclick="setInputReadonly('noMark', false)"/>

<input type="button" value="无引号改变校验规则" onclick="changeValidation()"/>

<input type="button" value="单个校验是否通过" onclick="customValidation()"/>

<br/><br/>

<input type="button" value="性别 disabled" onclick="setInputDisabled('xb', true)"/>
	
<input type="button" value="性别 enable" onclick="setInputDisabled('xb', false)"/>

<input type="button" value="行政区划 disabled" onclick="setInputDisabled('xzqh11', true)"/>
	
<input type="button" value="行政区划 enable" onclick="setInputDisabled('xzqh11', false)"/>

<input type="button" value="无引号 disabled" onclick="setInputDisabled('noMark', true)"/>
	
<input type="button" value="无引号 enable" onclick="setInputDisabled('noMark', false)"/>

<input type="button" value="button disabled" onclick="setInputDisabled('button1', true)"/>
	
<input type="button" value="button enable" onclick="setInputDisabled('button1', false)"/>

<br/><br/>

<input type="button" value="性别必填 " onclick="setComboRequired('xb', true)"/>
	
<input type="button" value="性别不必填" onclick="setComboRequired('xb', false)"/>

<input type="button" value="行政区划必填 " onclick="setComboRequired('xzqh11', true)"/>
	
<input type="button" value="行政区划不必填" onclick="setComboRequired('xzqh11', false)"/>

<input type="button" value="行政区划清除列表" onclick="comboBoxClear()"/>

<input type="button" value="行政区划重新加载" onclick="comboBoxReload()"/>


<br/><br/>

<a id="" class="l-btn l-btn-small" href="javascript:void(0)" group="">
	<span class="l-btn-left l-btn-icon-left">
		<span class="l-btn-text">保存</span>
		<span class="l-btn-icon icon-save"></span>
	</span>
</a>
<a id="" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="dealyParse()">
	<span class="l-btn-left l-btn-icon-left">
		<span class="l-btn-text">延时解析</span>
		<span class="l-btn-icon icon-time"></span>
	</span>
</a>
<a id="" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="uploadFileEdit('TEST', '12345678', '测试', '', '0', '')">
	<span class="l-btn-left l-btn-icon-left">
		<span class="l-btn-text">附件管理</span>
		<span class="l-btn-icon icon-attach"></span>
	</span>
</a>
<a id="" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="uploadFileView('TEST', '12345678', '')">
	<span class="l-btn-left l-btn-icon-left">
		<span class="l-btn-text">附件查看</span>
		<span class="l-btn-icon icon-attach"></span>
	</span>
</a>
<a id="" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="ptryzpEdit('123456', 'RK_RYJBXXB', '123456', '人员基本信息表', '', 'ryzpSubmitSuccess', '');">
	<span class="l-btn-left l-btn-icon-left">
		<span class="l-btn-text">人员照片</span>
		<span class="l-btn-icon icon-attach"></span>
	</span>
</a>

<br/><br/>

<a id="" class="l-btn l-btn-small" href="javascript:void(0)" group="" onclick="uploadFileEdit('TESTImage', '88888888', '测试图片', 'img', '0', '')">
	<span class="l-btn-left l-btn-icon-left">
		<span class="l-btn-text">附件图片管理</span>
		<span class="l-btn-icon icon-attach"></span>
	</span>
</a>

<div id="uploadFileImageDiv" style="width: 300px; height: 400px; border: 1px solid #86B6CF; text-align: center;"></div>

<br/><br/>

<script type="text/javascript">

initComboBox('xzqh13', contextPath + '/common/dict/D_BZ_XZQHLIST.js'); 
initComboBox('xzqh14', contextPath + '/common/dict/D_BZ_XZQHLIST.js'); 
initComboBox('xzqh15', contextPath + '/common/dict/D_BZ_XZQHLIST.js'); 

function body_onload() {
	uploadFileImageView('TESTImage', '8888888811', 'uploadFileImageDiv', 300, 375, contextPath + '/images/bzdz/building/building.jpg'); // 附件图片多张显示
	//uploadFileImageView('TESTImage', '8888888811', 'uploadFileImageDiv', 300, 375, contextPath + '/common/skin/images/empty_ryzp.jpg'); // 附件图片多张显示
	//uploadFileImageView('TESTImage', '88888888', 'uploadFileImageDiv', 300, 375); // 附件图片多张显示
	$('#dataform').form({  
        onSubmit:function(){
        	alert($(this).form('validate'));
        	alert("111")
            return $(this).form('validate');  
        },  
        success:function(data){  
            alert(data);  
        }  
    }); 
}

function comboBoxClear() {
	$('#xzqh11').combobox('loadData', []);
}


function comboBoxReload() {
	$('#xzqh11').combobox('reload', contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js')
}

function getFormDataToSpan(formID) {
	var inputSelector = $('#'+ formID +' input:not(:button)');
	$.each(inputSelector, function(index, object) {
		var element = $(object);
		var _type = element.attr('type');
		var _name = element.attr('name');
		var _comboname = element.attr('comboname');
		var _span = null;
		if (_name) {
			if (_type == "text") {
				var _class = element.attr('class');
				if (_class != 'combo-value') {
					_span = element.next("span.edit_word");
					if (_span) {
						_span.html(element.val());
					}
				}
			}
		}
		if (_comboname) {
			var comboText = element.combo("getText");
			_span = element.parent().find("span.edit_word").first();
			if (_span) {
				_span.html(comboText);
			}
		}
	});
	var textareaSelector = $('#'+ formID +' textarea');
	$.each(textareaSelector, function(index, object) {
		var element = $(object);
		var _name = element.attr('name');
		if (_name) {
			_span = element.next("span.edit_word");
			if (_span) {
				var spanHtml = element.val();
				spanHtml = spanHtml.replace(/\n/g, "<br>");
				_span.html(spanHtml);
			}
		}
	});
}

function xbOnchange(newValue, oldValue) {
	if ("undefined" == typeof lybm || lybm == null) {
		return;
	}
	alert("性别值由：" + oldValue + " 变为：" + newValue);
}

function changeValidation() {
	$('#noMark').validatebox({required:false,validType:['phone']});
}

function customValidation() {
	var a = $('#xb').combo("isValid");
	var b = $('#xzqh').combo("isValid");
	var c = $('#noMark').validatebox("isValid");
	alert("性别校验 = " + a);
	alert("行政区划校验 = " + b);
	alert("无引号校验 = " + c);
}

function dealyParse() {
	$('#xzqh23').addClass('easyui-combotree');
	$.parser.parse('#delayTd');
	$.parser.onComplete = function(e) {
		alert("comlpete2");
	}
}

function beforeSubmit() {
	alert("beforeSubmit");
	return true;
}

function ryzpSubmitSuccess() {
	alert("人员照片保存完成回到原页面事件！");
}

function destroyTopWindow() {
	try {
		window.top.destroyWindow('www');
	}
	catch (err) {}
}

// 页面加载完成事件
window.onload = function() {
	body_onload();
	destroyTopWindow();
}

// 页面退出事件
window.onbeforeunload = function() {
	destroyTopWindow();
}
</script>
  
</body>
</html>