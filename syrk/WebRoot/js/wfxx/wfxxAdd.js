/**
 * 
 * @description:物防添加
 * @author: tian_chengwei@founder.com      
 * @date:2015-06-02
 * 
 *  * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
//物防种类点击给文本框赋值
function onSelect(record){
	$('#entity_wfzl').val(record.id);
}
//打开标注页面
function mapBz(){
	var url = contextPath+'/forward/zafffwqz|wfxxMapBz';
	var paramArray = [];
	openWindow(false,'win9', url, 
   		paramArray, 
   		{
	   		title:'地图标注（鼠标点击左键标注位置）',
	   		maximizable: false,
	   		width: 850,	
	   		height: 560
   		}
   	);
}
//关闭标注页面，只能在上级页面关闭，打开窗口里嵌入了Iframe,调用dialog无法关闭页面
function closeMap(){
	$('#win9').dialog('close');
}

$(function(){
	//单位选择组件
	initDepartmentSearch('dw-box', {glpcsid: ''}, 'dwid', 'dwmc', null, null);
	//小区选择组件
	SearchXq('xq-box', {glpcsid: ''}, 'xqid', 'xqmc', null, null);
	//如从单位入口进入，初始化单位信息
	$("#dwmc").val($("#crdwmc").val());
	$("#dwid").val($("#crdwid").val());
	$("#dw-box").val($("#crdwmc").val());
	var xqmc = $("#xq-box").val();
	var entity_id =  $("#entity_id").val();
	if($("#dwid").val() !=""){
	setInputReadonly("dw-box", true);
	}
	setInputReadonly('xq-box', true);
	if(entity_id!=""){
	if(xqmc!=""){
		onRadioClick(1);
		document.getElementById("dw_wflx").disabled = "disabled";
		$("input[name=wflx][value=1]").attr("checked",true);
	}else{
		onRadioClick(0);
		document.getElementById("xq_wflx").disabled = "disabled";
		$("input[name=wflx][value=0]").attr("checked",true);
	}
	}
	//管辖责任区、管辖派出所只读
	setInputReadonly("gxzrq", true);
	setInputReadonly("gxpcs", true);
	
	initAddressSearch('wfdz1', {}, 'wfdzmlpdm', 'wfdzmlpxz', 'wfdz2', {text:'wfdzxz',dzxzqh:'wfdzssxdm',id:'wfdzdm',dzzbx:'entity_zbx',dzzby:'entity_zby'}, null, null);
	$('#wfxxForm').form({  
        onSubmit:function(){
            return $(this).form('validate');  
        },  
        success:function(data){  
            var json = $.parseJSON(data);
            if(json.status != 'success'){
            	topMessagerAlert(null,json.message);
            }else{
            	topMessagerShow(null,json.message);
            	$("#entity_id").val(json.saveID); 
            	if($("#dwid").val() == ""){
	            	executeTabPageMethod(mainTabID, "reloadDg");
            	}else{
            		executeTabPageMethod(mainTabID, "child_edit_menu_complete", $("#infoUrl").val());
            	}
            	executeTabPageMethod(mainTabID, "location.reload()");
            	closeSelf();
            	locateMainPage(mainTabID);
            }
        }  
    });   
	$('#saveBotton').click(function(){
		if($('#wfxxForm').form('validate')){
			topMessager.confirm('操作确认', '您是否保存物防信息？',  function(r) {
				if (r) {
					if(isvalidDwid()==true){
						$('#wfxxForm').submit();	
					}else{
						topMessagerShow(null,"无此单位，请在单位管理进行维护！");
					}
					
				}
			});
		}
	});
	//调用标注地图页面
	$('#mapBotton').click(function(){
		mapBz();
	});
	$('#resetBotton').click(function(){
	    //$("input[id!='gxzrq'][id!='gxpcs'][id!='dw-box']").val("");
	     //单位入口进入页面后，单位下来禁止清空
	     if(document.getElementById("dw-box").readOnly == false){
	     $("#dw-box").combobox("setValue","");
	     }
	     $('#entity_wfzl').combobox("setValue","");
	     $('#wfdz1').combobox("setValue","");
	     $("#entity_sl").val("");
	     $("#entity_azrq").val("");
	     $("#wfdz2").combobox("setValue","");
	     $("#entity_zbx").val("");
	     $("#entity_zby").val("");
		 $("textarea").val("");
	});
});
	
	//刷新左页面的方法
function executeTabPageMethodLeft(mainTabID, method) {
	if (!mainTabID || mainTabID == "" || !method || method == "") {
		return;
	}
	try {
		var openFrameID = "main_tab" + mainTabID;
		if (IE) {
			var openFrame = window.top.document.frames["main_frame"].main_center.frames(openFrameID);
			openFrame =openFrame.frames['main_left'];
			eval("openFrame." + method + "()");
		}
		else {
			var main_center = window.top.document.getElementById("main_frame").contentWindow.frames.document.getElementById("main_center");
			var openFrame1 = main_center.contentWindow.frames.document.getElementById(openFrameID).contentWindow;
			var openFrame = main_center.contentWindow.frames.document.getElementById("main_left");//.contentWindow;
			eval("openFrame." + method + "()");
		}
	}
	catch (err) {}
}
var radioBz = 0; 
//获取单位ID
function isvalidDwid(){
	var flag = false;
	if($("#dwid").val() !=  ""){
		flag = true;
	}
	if(radioBz==1){
		flag = true;
	}
	return flag;
}



function onRadioClick(bz){
	 radioBz = bz;
	 if(bz==0){
		 setInputReadonly('dw-box', false);
		 setInputReadonly('xq-box', true);
		 $("#xq-box").combobox("clear");
	 }else if(bz==1){
		 setInputReadonly('dw-box', true);
		 setInputReadonly('xq-box', false);
		 $("#dw-box").combobox("clear");
	 }
};

function SearchXq(dwComboID, filterData, dwID, dwmcID, returnFieldData, onSelectAfterDw) {
	$('#' + dwComboID).combobox({
		delay: 600,
		unValidClear: false,
		url: contextPath + '/wfxxb/searchXqContext',
		loader: function(param, success, error) {
			var opts = $(this).combobox('options');
			if (!opts.url) return false;
			if ("undefined" == typeof param.q) {
				var data = [];
				success(data);
				return;
			}
			else {
				param.q = param.q.replace(/(^[\s|　]*)|([\s|　]*$)/g, "");
				if (param.q == "") {
					var data = [];
					success(data);
					// 清空
					if (dwID) {
						$('#' + dwID).val("");
					}
					if (dwmcID) {
						$('#' + dwmcID).val(param.q);
					}
					if (returnFieldData) {
						for (var item in returnFieldData) {
							$('#' + returnFieldData[item]).val("");
						}
					}
					return;
				}
			}
			// 清空
			if (dwID) {
				$('#' + dwID).val("");
			}
			if (dwmcID) {
				$('#' + dwmcID).val(param.q);
			}
			if (returnFieldData) {
				for (var item in returnFieldData) {
					$('#' + returnFieldData[item]).val("");
				}
			}
			var submitParam = {};
			for (var item in filterData) {
				submitParam[item] = filterData[item];
			}
			for (var item in submitParam) {
				var submitValue = submitParam[item];
				if (submitValue && submitValue.indexOf("#") == 0) { // 动态值
					if ($(submitValue).val()) {
						submitParam[item] = $(submitValue).val();
					}
					else {
						submitParam[item] = "";
					}
				}
			}
			submitParam['searchKey'] = param.q;
			$.ajax({
				type: opts.method,
				url: opts.url,
				data: submitParam,
				dataType: 'json',
				success: function(data) {
					opts.loaded = true;
					success(data);
				},
				error: function() {
				}
			});
		},
		onLoadSuccess: function() {
		},
		filter: function(q, row) {
			return true;
		},
		formatter: function(row) {
			var opts = $(this).combobox('options');
			if (opts.maxValueLength == 0) { // 自动调整宽度与高度
				var data = $(this).combobox('getData');
				var optionTextMaxLen = 0; // text的最大长度
				for (var i = 0; i < data.length; i++){
					var tempRow = data[i];
					var optionText = tempRow[opts.textField];
					if (tempRow['dwdz']) {
						optionText += tempRow['dwdz'];
					}
					var sLen = getGBLength(optionText) + 6;
					if (sLen > optionTextMaxLen) {
						optionTextMaxLen = sLen;
					}
				}
				opts.maxValueLength = 1;
				autoPanelWidth = (optionTextMaxLen + 8) * 6;
				autoPanelWidth = autoPanelWidth < opts.width ? opts.width : autoPanelWidth;
				var autoPanelHeight = data.length;
				if (data.length > opts.panelOptionsNumber) {
					autoPanelHeight = opts.panelOptionsNumber;
				}
				else if (autoPanelHeight < 2) {
					autoPanelHeight = 2;
				}
				var itemHeight = 20;
				if (IE && IE_VERSION <= 9) {
					itemHeight = 18;
				}
				$(this).combo('panel').panel('resize',{width:autoPanelWidth ,height: autoPanelHeight * itemHeight + 2});	
			}
			var optionText = row[opts.textField];
			if (row['dwdz']) {
				optionText += "－【"+ row['dwdz'] +"】";
			}
			return optionText;
		},
		loadFilter: function(data) {
			return data;
		},
		onSelect: function(record) {
			var opts = $(this).combobox('options');
			if (dwID) {
				$('#' + dwID).val(record['id']);
				for (var item in returnFieldData) {
					if (record[item]) {
						$('#' + returnFieldData[item]).val(record[item]);
					}
				}
			}
			if (dwmcID) {
				$('#' + dwmcID).val(record['text']);
			}
			try {
				if (onSelectAfterDw && typeof(eval(onSelectAfterDw)) == 'function') {
					eval(onSelectAfterDw + "(dwComboID)");
				}
			}
			catch (err) {
				$.messager.alert('页面错误', "执行事件 "+ onSelectAfterDw + " 有错误发生：<br/><br/>错误名称: " + err.name + "<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;错误行号:" + (err.number & 0xFFFF ) + "<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;错误信息:" + err.message, 'error'); 
			}
		},
		onHidePanel: function() {
		}
	});
	
	$(document).ready(function() {
		var comboText = $('#' + dwComboID).next(".combo").children(".combo-text");
		comboText.attr('maxlength', 50); // 设置单位选择输入框只能输入50个汉字
	});
}