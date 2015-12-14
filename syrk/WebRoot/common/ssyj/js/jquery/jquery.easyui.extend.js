/**
 * jQuery EasyUI 1.3.6 Copyright (c) 2009-2014 www.jeasyui.com. All rights reserved.
 * 
 * Licensed under the GPL or commercial licenses To use it on other terms please
 * contact author: info@jeasyui.com http://www.gnu.org/licenses/gpl.txt
 * http://www.jeasyui.com/license_commercial.php
 * 
 * jQuery EasyUI 1.3.6 扩展 
 * author : redstorm 
 * create time : 2014-05-01
 * 
 */

var IE = window.navigator.appVersion.toUpperCase().indexOf('MSIE') == -1 ? false : true;
var IE_VERSION = getIEVersion();
var MESSAGER_TITLE = '系统信息';

// 获取 IE 的版本号
function getIEVersion() {
	if (IE) {
		var nAppVersion = window.navigator.appVersion.toUpperCase();
		var fromAt = nAppVersion.indexOf('MSIE');
		if (fromAt != -1) {
			nAppVersion = nAppVersion.substring(fromAt + 4, nAppVersion.indexOf(";", fromAt + 4));
			nAppVersion = nAppVersion.replace(/(^\s*)|(\s*$)/g, "");
			nAppVersion = parseInt(nAppVersion);
			return nAppVersion;
		}
	}
	return 0;
}

function parseReturn(result) {
	if (typeof result == 'string') {
		try {
			result = $.parseJSON(result);
		} catch(err) {
			return false;
		}
	}
	return result;
}

(function() {
	$.ajaxSetup({
		cache:false, // 禁用cache
		data:{}
	})
	
	// 初始化 datagrid 默认属性
	$.extend($.fn.datagrid.defaults, {
		striped: true,
		pageSize: 20,
		pageList: [10,20,40,80],
		pagination: true,
		fitColumns: true,
		singleSelect: true,
		selectOnCheck: false,
		checkOnSelect: false,
		fit: true,
		resizeHandle: 'right'
	});

	if (!window.console) { // 防止浏览器不支持console报错
		window.console = {};
		var funs = ["profiles", "memory", "_commandLineAPI", "debug", "error", "info", "log", "warn", "dir", "dirxml", "trace", "assert", "count", "markTimeline", "profile", "profileEnd", "time", "timeEnd", "timeStamp", "group", "groupCollapsed", "groupEnd"];
		for (var i = 0; i < funs.length; i++) {
			console[funs[i]] = function() {};
		}
	}
	
	// 全局ajax处理
	$(document).ajaxError(function(event, request, settings, thrownError) { // 请求失败处理
		var result = parseReturn(request.responseText);
		if (!result) {
			topMessager.alert(MESSAGER_TITLE, request.status+ ' ' + (thrownError ? thrownError : '操作失败'), 'error');
		} else {
			topMessager.alert(MESSAGER_TITLE, request.status+ ' ' + (result.message ? result.message : '操作失败'), 'error');
		}
	});
	
})();

// 顶层页面的 message 封装
var topMessager = {
	show : function(options) {
		window.top.$.messager.show(options);
	},
	alert : function(title, msg, icon, fn) {
		if (!title) title = MESSAGER_TITLE;
		if (!icon) icon = 'error';
		window.top.$.messager.alert(title, msg, icon, fn);
	},
	confirm : function(title, msg, fn) {
		if(!title) title = MESSAGER_TITLE;
		window.top.$.messager.confirm(title, msg, fn);
	},
	prompt : function(title, msg, fn) {
		window.top.$.messager.prompt(title, msg, fn);
	},
	progress : function(optionsOrMethod) {
		window.top.$.messager.progress(optionsOrMethod);
	}
}

// 顶层页面弹出消息窗口
function topMessagerShow(title, msg, timeout) {
	title = title ? title : MESSAGER_TITLE;
	timeout = timeout ? timeout : 1500;
	window.top.$.messager.show({
		title: title,
		msg: msg,
		timeout: timeout
	});
}

// 顶层页面弹出警告窗口
function topMessagerAlert(title, msg, type) {
	title = title ? title : MESSAGER_TITLE;
	type = type ? type : 'error';
	window.top.$.messager.alert(title, msg, type);
}

function cancelBubble() {
}
 
// 动态弹出一个窗口
// isCache     是否缓存页面（默认为false不缓存）
// windowID    窗口的ID（isCache=true，windowID确保在同一个页面中唯一；isCache=false，windowID可以不指定；）
// openURL     打开的URL地址
// paramArray  传入的参数数组（作为打开页面的doInit()方法的参数）
// dataOptions jquery.window中的data-options定义参数
var publicWindowArray = new Array(); // 窗口管理数组
function openWindow(isCache, windowID, openURL, paramArray, dataOptions) {
	if ("undefined" == typeof isCache || isCache == null || isCache == "") {
		isCache = false;
	}
	if ("undefined" == typeof paramArray || paramArray == null) {
		paramArray = [];
	}
	var windowObject;
	if (isCache) { 
		if (windowID == null || windowID == "") {
			$.messager.alert('页面错误','打开窗口openWindow()方法中：<br><br>参数 windowID 不能为空！','error');
			return;
		}
		windowObject = publicWindowArray[windowID];
		if (windowObject == null) {
			var hasBind = false;
			var iframe;
			if ( $("#" + windowID).length == 0 ) {
				$("body").append("<div id='"+ windowID +"' style='z-index:300;'></div>");
				iframe = $("<iframe id='"+ windowID +"_iframe'></iframe>") 
					.attr('height', '100%') 
					.attr('width', '100%') 
					.attr('marginheight', '0') 
					.attr('marginwidth', '0') 
					.attr('frameborder','0')
					.attr('scrolling','auto');
				$('#' + windowID).append(iframe);
				hasBind = true;
			}
			windowObject = $("#" + windowID).dialog(dataOptions);
			windowObject.dialog({
				onBeforeDestroy: function() { 
					var iframeObject = iframe.get(0).contentWindow;
					iframeObject.document.write("");
					iframeObject.close();
				}
			});
			var opts = windowObject.dialog('options');
			paramArray['windowID'] = windowID;
			if (hasBind) {
				iframe.attr('src', openURL);
			}
			windowObject.dialog('open');
			publicWindowArray[windowID] = windowObject;
		}
		else {
			windowObject.dialog('open');
		}
	}
	else {
		if ("undefined" == typeof windowID || windowID == null || windowID == "") {
			var myTime = (new Date()).getTime();
			windowID = "win_" + myTime;
		}
		$("body").append("<div id='"+ windowID +"' style='z-index:300;'></div>");
		var iframe = $("<iframe id='"+ windowID +"_iframe'></iframe>") 
				.attr('height', '100%') 
				.attr('width', '100%') 
				.attr('marginheight', '0') 
				.attr('marginwidth', '0') 
				.attr('frameborder','0')
				.attr('scrolling','auto');
		$('#' + windowID).append(iframe);
		windowObject = $("#" + windowID).dialog(dataOptions);
		windowObject.dialog({
			onClose: function() {
				$(this).dialog('destroy');
			},
			onBeforeDestroy: function() { 
				var iframeObject = iframe.get(0).contentWindow;
				iframeObject.document.write("");
				iframeObject.close();
			}
		});
		var opts = windowObject.dialog('options');
		paramArray['windowID'] = windowID;
		iframe.attr('src', openURL);
		windowObject.dialog('open');
	}
}

// datagrid中的编辑与删除操作生成，用法（formatter: datagridProcessFormater）
var datagridProcessFormater = function(val, row, index) {
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit(this, '+index+')">编辑</a>&nbsp;'+
		   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">删除</a>&nbsp;';
}

// 获取 datagrid的id
function getDatagrid_ID(isToolbar, elem) {
	var datagrid_ID;
	if (isToolbar) {
		datagrid_ID = $(elem).parents('div.datagrid-toolbar').siblings('div.datagrid-view').find('table.easyui-datagrid').attr('id');
	} else {
		datagrid_ID = $(elem).parents('div.datagrid-view2').siblings('table.easyui-datagrid').attr('id');
	}
	return datagrid_ID;
}

// 按钮屏蔽并且改变显示
function buttonDisabled(buttonObject) {
	var obj = $(buttonObject);
	if (obj.hasClass('l-btn')) {
		if (obj.data('disabled')) {
			return false;
		}
		obj.data('disabled', true);
		obj.find('span.l-btn-text').html(obj.find('span.l-btn-text').html() + '中...');
		obj.css('cursor', 'wait');
	}
	return true;
}

// 按钮解除屏蔽
function buttonEnabled(buttonObject) {
	var obj = $(buttonObject);
	obj.data('disabled', false);
	obj.find('span.l-btn-text').html(obj.find('span.l-btn-text').html().slice(0, -4));
	obj.css('cursor', 'Pointer');
}

// datagrid 查询条件（默认在本页面中弹出，而且缓存页面）
// paramArray  传入打开页面的参数（如：{document:document, param1: 'test1', param2: 2}）
// dataOptions jquery.window中的data-options定义参数
function datagridQuery(toolbarButton, windowID, paramArray, dataOptions) {
	if (!dataOptions.url) {
		topMessagerAlert('', '弹出层缺少 url 参数！');
		return;
	}
	var datagrid_ID = getDatagrid_ID(1, toolbarButton);
	dataOptions.datagrid_ID = datagrid_ID;
	if (!dataOptions.title) {
		dataOptions.title = '查询条件';
	}
	dataOptions.title = '&nbsp;' + dataOptions.title;
	if (!dataOptions.width) {
		dataOptions.width = 850;
	}
	if (!dataOptions.height) {
		dataOptions.height = 420;
	}
	if (!windowID) {
		windowID = "queryWindow";
	}
	dataOptions.collapsible = dataOptions.collapsible ? dataOptions.collapsible : false;
	dataOptions.minimizable = dataOptions.minimizable ? dataOptions.minimizable : false;
	dataOptions.maximizable = dataOptions.maximizable ? dataOptions.maximizable : false; // 是否最大化图标
	dataOptions.closable = true;
	dataOptions.closed = false;   
	dataOptions.cache = false;
	dataOptions.inline = false;
	dataOptions.modal = true;
	dataOptions.buttons = [
		{
			text: '确定',
			iconCls: 'icon-ok',
			handler: function() {
				var iframeObject = window.frames[windowID + '_iframe'];
				if (iframeObject.contentWindow) {
					iframeObject = iframeObject.contentWindow;
				}
				var formObject = iframeObject.$('form');
				if (formObject) {
					if (formObject.form('validate')) { // 表单的验证
						$('#' + windowID).dialog('close');
						$('#' + datagrid_ID).datagrid('reload');
					}
				}
			}
		},
		{
			text: '重置',
			iconCls: 'icon-reset',
			handler: function() {
				var iframeObject = window.frames[windowID + '_iframe'];
				if (iframeObject.contentWindow) {
					iframeObject = iframeObject.contentWindow;
				}
				var formObject = iframeObject.$('form');
				if (formObject) {
					formObject.form('reset');
				}
			}
		},
		{
			text: '关闭',
			iconCls: 'icon-cancel',
			handler: function() {
				$('#' + windowID).dialog('close');
			}
		}
	];
	openWindow(true, windowID, dataOptions.url, paramArray, dataOptions);
}

// datagrid 新增（默认在本页面中弹出，不缓存页面）
// paramArray    传入打开页面的参数（如：{document:document, param1: 'test1', param2: 2}）
// dataOptions   jquery.window中的data-options定义参数
// submitConfirm 提交确认提示信息（为空则不出现确认框）
function datagridAdd(toolbarButton, windowID, paramArray, dataOptions, submitConfirm) {
	if (!dataOptions.url) {
		topMessagerAlert('', '弹出层缺少 url 参数！');
		return;
	}
	var datagrid_ID = getDatagrid_ID(1, toolbarButton);
	dataOptions.datagrid_ID = datagrid_ID;
	if (!dataOptions.title) {
		dataOptions.title = '新增';
	}
	dataOptions.title = '&nbsp;' + dataOptions.title;
	if (!dataOptions.width) {
		dataOptions.width = 850;
	}
	if (!dataOptions.height) {
		dataOptions.height = 420;
	}
	if (!windowID) {
		windowID = "addWindow";
	}
	dataOptions.collapsible = dataOptions.collapsible ? dataOptions.collapsible : false;
	dataOptions.minimizable = dataOptions.minimizable ? dataOptions.minimizable : false;
	dataOptions.maximizable = dataOptions.maximizable ? dataOptions.maximizable : false; // 是否最大化图标
	dataOptions.closable = true;
	dataOptions.closed = false;   
	dataOptions.cache = false;
	dataOptions.inline = false;
	dataOptions.modal = true;
	dataOptions.buttons = [
		{
			text: '保存',
			iconCls: 'icon-save',
			handler: function() {
				var bottonObject = this;
				if (buttonDisabled(bottonObject) == false) {
					return false;
				}
				var iframeObject = window.frames[windowID + '_iframe'];
				if (iframeObject.contentWindow) {
					iframeObject = iframeObject.contentWindow;
				}
				var formObject = iframeObject.$('form');
				if (formObject) {
					if (formObject.form('validate')) { // 表单的验证
						buttonEnabled(bottonObject);
						$('#' + windowID).dialog('close');
					}
					else {
						buttonEnabled(bottonObject);
					}
				}
			}
		},
		{
			text: '关闭',
			iconCls: 'icon-cancel',
			handler: function() {
				$('#' + windowID).dialog('close');
			}
		}
	];
	openWindow(false, windowID, dataOptions.url, paramArray, dataOptions);
}

// datagrid 批量删除
// submitFields  除主键之外需要提交的字段（多个用逗号分隔）
// dataOptions   jquery.window中的data-options定义参数
// submitConfirm 提交确认提示信息（为空则不出现确认框）
function datagridDeletePatch(toolbarButton, windowID, submitFields, dataOptions, submitConfirm) {
	if (!dataOptions.url) {
		topMessagerAlert('', '弹出层缺少 url 参数！');
		return;
	}
	var datagrid_ID = getDatagrid_ID(1, toolbarButton);
	dataOptions.datagrid_ID = datagrid_ID;
	var selections = $('#' + datagrid_ID).datagrid('getSelections');
	if (selections.length == 0) {
		topMessagerAlert('', '请先选择需要处理的数据！');
		return;
	}
	if (!submitConfirm) {
		submitConfirm = '您确认要删除数据吗？';
	}
	topMessager.confirm('', submitConfirm, function(r) {    
		if (r) {	
		}
	});
}

// datagrid 修改（默认在本页面中弹出，不缓存页面）
// paramArray    可以传入参数（如：{document:document, param1: 'test1', param2: 2}）
// dataOptions   jquery.window中的data-options定义参数
// submitConfirm 提交确认提示信息（为空则不出现确认框）
function datagridEdit(datagrid_ID, windowID, paramArray, dataOptions, submitConfirm) {
	if (!dataOptions.url) {
		topMessagerAlert('', '弹出层缺少 url 参数！');
		return;
	}
	dataOptions.datagrid_ID = datagrid_ID;
	if (!dataOptions.title) {
		dataOptions.title = '修改';
	}
	dataOptions.title = '&nbsp;' + dataOptions.title;
	if (!dataOptions.width) {
		dataOptions.width = 850;
	}
	if (!dataOptions.height) {
		dataOptions.height = 420;
	}
	if (!windowID) {
		windowID = "editWindow";
	}
	dataOptions.collapsible = dataOptions.collapsible ? dataOptions.collapsible : false;
	dataOptions.minimizable = dataOptions.minimizable ? dataOptions.minimizable : false;
	dataOptions.maximizable = dataOptions.maximizable ? dataOptions.maximizable : false; // 是否最大化图标
	dataOptions.closable = true;
	dataOptions.closed = false;   
	dataOptions.cache = false;
	dataOptions.inline = false;
	dataOptions.modal = true;
	dataOptions.buttons = [
		{
			text: '保存',
			iconCls: 'icon-save',
			handler: function() {
				var bottonObject = this;
				if (buttonDisabled(bottonObject) == false) {
					return false;
				}
				var iframeObject = window.frames[windowID + '_iframe'];
				if (iframeObject.contentWindow) {
					iframeObject = iframeObject.contentWindow;
				}
				var formObject = iframeObject.$('form');
				if (formObject) {
					if (formObject.form('validate')) { // 表单的验证
						buttonEnabled(bottonObject);
						$('#' + windowID).dialog('close');
					}
					else {
						buttonEnabled(bottonObject);
					}
				}
			}
		},
		{
			text: '关闭',
			iconCls: 'icon-cancel',
			handler: function() {
				$('#' + windowID).dialog('close');
			}
		}
	];
	openWindow(false, windowID, dataOptions.url, paramArray, dataOptions);
}
