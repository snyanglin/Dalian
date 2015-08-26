//全局变量
var GV = {
	VERSION:"1.0.20131226",
	MESSAGER_TITLE:'信息提示',
	URL : {
		LOGIN:'' //登录页面地址
	}
};

try {
	var _a = top.location.href;
	GV.top$ = top.$;
	GV.topWindow = top.window;
} catch(err) {
	GV.top$ = $;
	GV.topWindow = window;
}

;(function(){
	$.ajaxSetup({
		cache:false, //禁用cache
		data:{}
	})
	
	//初始化easyui默认属性
	$.extend($.fn.datagrid.defaults, {
		striped:true,
		pageSize:20,
		pageList:[10,20,50,80],
		pagination:true,
		fitColumns:true,
		singleSelect:true,
		selectOnCheck:false,
		checkOnSelect:false,
		fit:true,
		onLoadError:function(data){
			/*if(data.status>=200 && data.status<300) {
				if(data.responseText.substr(0,1) == '{') {
					var responseText = eval('('+data.responseText+')');
				
					if(responseText.status!=undefined) {
						Cmessager.alert(GV.MESSAGER_TITLE, responseText.message, 'error');
					}
				}
			}*/
		}
	});
	/**
	* easyui自带下面的验证
	* email：匹配E-Mail的正则表达式规则。
	* url：匹配URL的正则表达式规则。
	* length[0,100]：允许在x到x之间个字符。
	* remote['http://.../action.do','paramName']：发送ajax请求需要验证的值，当成功时返回true。
	*/
	$.extend($.fn.validatebox.defaults.rules, {
		minLength : { // 判断最小长度
			validator : function(value, param) {
				return value.length >= param[0];
			},
			message : "最少输入 {0} 个字符。"
		},
		maxLength : { // 判断最大长度
			validator : function(value, param) {
				return value.length <= param[0];
			},
			message : "最多输入 {0} 个字符。"
		},
		phone : {// 验证电话号码
			validator : function(value) {
				return /^(((d{2,3}))|(d{3}-))?((0d{2,3})|0d{2,3}-)?[1-9]d{6,7}(-d{1,4})?$/i.test(value);
			},
			message : "格式不正确,请使用下面格式:020-88888888"
		},
		mobile : {// 验证手机号码
			validator : function(value) {
				return /^(13|15|18)d{9}$/i.test(value);
			},
			message : "手机号码格式不正确"
		},
		idcard : {// 验证身份证
			validator : function(value) {
				return /^d{15}(d{2}[A-Za-z0-9])?$/i.test(value);
			},
			message : "身份证号码格式不正确"
		},
		intOrFloat : {// 验证整数或小数
			validator : function(value) {
				return /^d+(.d+)?$/i.test(value);
			},
			message : "请输入数字，并确保格式正确"
		},
		currency : {// 验证货币
			validator : function(value) {
				return /^d+(.d+)?$/i.test(value);
			},
			message : "货币格式不正确"
		},
		qq : {// 验证QQ,从10000开始
			validator : function(value) {
				return /^[1-9]d{4,9}$/i.test(value);
			},
			message : "QQ号码格式不正确"
		},
		integer : {// 验证整数
			validator : function(value) {
				return /^[+]?[1-9]+d*$/i.test(value);
			},
			message : "请输入整数"
		},
		chinese : {// 验证中文
			validator : function(value) {
				return /^[u0391-uFFE5]+$/i.test(value);
			},
			message : "请输入中文"
		},
		english : {// 验证英语
			validator : function(value) {
				return /^[A-Za-z]+$/i.test(value);
			},
			message : "请输入英文"
		},
		unnormal : {// 验证是否包含空格和非法字符
			validator : function(value) {
				return /.+/i.test(value);
			},
			message : "输入值不能为空和包含其他非法字符"
		},
		faxno : {// 验证传真
			validator : function(value) {
	//            return /^[+]{0,1}(d){1,3}[ ]?([-]?((d)|[ ]){1,12})+$/i.test(value);
				return /^(((d{2,3}))|(d{3}-))?((0d{2,3})|0d{2,3}-)?[1-9]d{6,7}(-d{1,4})?$/i.test(value);
			},
			message : "传真号码不正确"
		},
		zip : {// 验证邮政编码
			validator : function(value) {
				return /^[1-9]d{5}$/i.test(value);
			},
			message : "邮政编码格式不正确"
		},
		ip : {// 验证IP地址
			validator : function(value) {
				return /d+.d+.d+.d+/i.test(value);
			},
			message : "IP地址格式不正确"
		},
		same:{
			validator : function(value, param){
				if($("#"+param[0]).val() != "" && value != ""){
					return $("#"+param[0]).val() == value;
				} else {
					return true;
				}
			},
			message : "两次输入的密码不一致！"   
		}
	});
	
	/*
	 * 防止浏览器不支持console报错
	 */
	if(!window.console) {
		window.console = {};
		var funs = ["profiles", "memory", "_commandLineAPI", "debug", "error", "info", "log", "warn", "dir", "dirxml", "trace", "assert", "count", "markTimeline", "profile", "profileEnd", "time", "timeEnd", "timeStamp", "group", "groupCollapsed", "groupEnd"];
		for(var i = 0;i < funs.length; i++) {
			console[funs[i]] = function() {};
		}
	}
	
	//全局ajax处理
	$(document).ajaxError(function(event, request, settings, thrownError) {
		//关闭弹出层
		var _window = GV.top$('body').children('.window');
		if(_window.length > 0) {
			_window.each(function(index, domEle) {
				var window_body = GV.top$(this).children('.window-body');
				if(window_body.length) {
					var winId = GV.top$(window_body[0]).attr('id');
					if(winId.indexOf('UUID-') === 0) {
						GV.top$('#'+winId).dialog('close');
					}
				}
			});
		}
		
		enableBtn();
		//请求失败处理
		if(request.status == 418){
			Cmessager.alert(GV.MESSAGER_TITLE, '用户操作超时,请重新登录！', 'error',function(){
				GV.topWindow.location.href = GV.topWindow.basePath+"index.jsp";
			});
		} else if(request.status == 308){
			Cmessager.alert(GV.MESSAGER_TITLE, '数据处理中或已保存,请勿重复提交！', 'error');
		} else {
			var result = parseReturn(request.responseText);
			if(!result) {
				Cmessager.alert(GV.MESSAGER_TITLE, request.status+ ' ' + (thrownError ? thrownError : '操作失败'), 'error');
			} else {
				Cmessager.alert(GV.MESSAGER_TITLE, request.status+ ' ' + (result.message ? result.message : '操作失败'), 'error');
			}
			
		}
	});
	
	/*if($.browser.msie) {
		//ie 都不缓存
		$.ajaxSetup({
			cache : false
		});
	}*/
	
	//iframe页面f5刷新
	$(document).on('keydown', function(event){
		var e = window.event || event;
		if(e.keyCode == 116) {
			e.keyCode = 0;
			var tab = GV.top$('#tt').tabs('getSelected');  // 获取选择的面板
			tab.panel('refresh');
			//!ie
			return false;
		}
	});
})();

$(function(){
	/*
	*解决ie6下不支持背景缓存
	*/
	if (!+'\v1' && !('maxHeight' in document.body.style)) {
		try{
			document.execCommand("BackgroundImageCache", false, true);
		}catch(e){}
	}
	
	/*自动提示，如输入123，则会按提供的rules提示，“权0000123”
	*<input type="text" class="easyui-prefix" value="" name="" data-options="rules:[{ID:'1',REGIONCODE:'510100',PREFIXTYPE:'查封业务件号',PREFIXLEN:'7',WIDTHFILL:'0',HEADFILL:'封,权,监证',FUNCTYPE:'字头'},{ID:'2',REGIONCODE:'510100',PREFIXTYPE:'查封业务件号',PREFIXLEN:'7',WIDTHFILL:'x',HEADFILL:'查',FUNCTYPE:'字头'}]" />
	*/
	if($('.easyui-autoprefix').length > 0) {
		$('.easyui-autoprefix').combobox({
			valueField:'text',
			panelHeight:'auto',
			filter:function(){return true},
			onChange:function(newValue, oldValue){
				_comElem = $(this);
				var opts = _comElem.combobox('options');
				var text = _comElem.combobox('getText');
				var _data = [];
				if(!isNaN(text) && opts.rules) {
					var index = 0;
					for(var i in opts.rules) {
						var rule = opts.rules[i];
						var HEADFILL_arr = rule['HEADFILL'].split(',');
						for(var j in HEADFILL_arr) {
							if(text.length < rule['PREFIXLEN']) {
								_data[index] = {
									"id":index,
									"text":""   
								}
								_data[index]['text'] = HEADFILL_arr[j];
								var k=0;
								for(;k<rule['PREFIXLEN']-text.length;k++) {
									_data[index]['text'] += rule['WIDTHFILL'];
								}
								_data[index]['text'] += text;
								index++;
							}
						}
					}
				}
				_comElem.combobox('loadData', _data);
			}
		});
	}
})

/**
 * easyui tree 第一样标题右边的刷新图标，单机事件处理函数
 * @param obj
 */
function reloadTree(obj) {
	preventBubble();
	var _ul = $(obj).parent().parent().parent();
	if(_ul && _ul.hasClass('tree')) {
		_ul.tree('reload');
	}
}

/** 通用函数库****************************/
/**
* 阻止事件冒泡
*/
function preventBubble(){
	if($.browser.mozilla){
		var $E = function(){var c=$E.caller; while(c.caller)c=c.caller; return c.arguments[0]};
		__defineGetter__("event", $E);
	}
	if (window.event) {
		event.cancelBubble = true; 
	}else if (evt){
		event.stopPropagation();
	} 
}

/**
* 将html节点元素的data-options转换为对象
*/
function parseOptions(obj) {
	var _8={};
	if(typeof obj == 'object') {
		var t = $(obj);
		var s=$.trim(t.attr("data-options"));
		if(s){
			if(s.substring(0,1)!="{"){
				s="{"+s+"}";
			}
			_8=(new Function("return "+s))();
		}
	} else if(obj.length>0) {
		if(obj.substring(0,1)!="{"){
			s="{"+obj+"}";
		}
		_8=(new Function("return "+s))();
	}
	return _8;
}

/*弹出层封装*/
var Cmessager = {
	show : function(options) {
		GV.top$.messager.show(options);
	},
	alert : function(title, msg, icon, fn) {
		if(!title) title = GV.MESSAGER_TITLE;
		if(!icon) icon = 'error';
		GV.top$.messager.alert(title, msg, icon, fn);
	},
	confirm : function(title, msg, fn) {
		if(!title) title = GV.MESSAGER_TITLE;
		GV.top$.messager.confirm(title, msg, fn);
	},
	prompt : function(title, msg, fn) {
		GV.top$.messager.prompt(title, msg, fn);
	},
	progress : function(optionsOrMethod) {
		GV.top$.messager.progress(optionsOrMethod);
	}
}
function EmessagerShow(title, msg, timeout) {
	title = title?title:GV.MESSAGER_TITLE;
	timeout = timeout?timeout:1500;
	GV.top$.messager.show({
		title:title,
		msg:msg,
		timeout:timeout
	});
}
function EmessagerAlert(title, msg, type) {
	title = title?title:GV.MESSAGER_TITLE;
	type = type?type:'error';
	GV.top$.messager.alert(title, msg, type);
}

/**
* 弹出层
*/
function openDialog(elem) {
	var _options = parseOptions(this);
	
	var _Clist = {};
	if(_options.ClistId) {
		_Clist = Clist[_options.ClistId];
	} else if ($(this).parent().hasClass('datagrid-cell')) {
		_Clist = doBeforeDatagrid(0, this);
	}

	//定义了datagrid的id
	if(_options.datagridId) {
		_Clist.id = _options.datagridId;
	}
	
	//如果没有定义buttons则默认显示保存按钮
	if(_options.buttons == undefined) {
		_options.buttons = 'formSubmit';
	}

	//默认弹出层标题
	if(_options.title == undefined || !_options.title) {
		_options.title = '信息';
	}
	
	//判断是否设置弹出层高度和高度
	if(!_options.width) {
		_options.width = (_Clist.dialogWidth?_Clist.dialogWidth:'600');
	}
	if(!_options.height) {
		_options.height = (_Clist.dialogHeight?_Clist.dialogHeight:'400');
	}
	
	_options._Clist = _Clist;
	_createWin(_options);
	
	return false; //阻止事件冒泡，同事阻止默认行为
}

/**
 * 创建弹出层窗口
 * @param _options
 */
function _createWin(_options) {
	if(!_options.url) {
		Cmessager.alert('', '弹出层缺少url参数！');
	}
	if(_options.buttons == 'formSubmit') {
		_options.buttons = [{
			text:'保存',
			handler:function(){
				if(disabledBtn(this) == false) {
					return false;
				}
				
				var _winId = GV.top$(this).parent().parent().attr('id');
				if(_options.isIframe) {
					var _window = GV.topWindow.frames[_winId+'_Iframe'].window;
					var _form = _window.$('form');
				} else {
					var _form = GV.top$(this).parent().siblings('.panel').find('form');
				}
				if(_form.length > 0) {
					if(_options.isIframe) {
						//提交前需要处理的函数
						if(_window.MybeforeSubmit && typeof(_window.MybeforeSubmit) == 'function') {
							if(_window.MybeforeSubmit() === false) {
								enableBtn();
								return false;
							}
						}
						//验证表单，如果验证通过则提交
						if(_form.form('validate')) {
							_form.submit();
						}
						return false;
					} else {
						//提交前需要处理的函数
						if(GV.topWindow.MybeforeSubmit && typeof(GV.topWindow.MybeforeSubmit) == 'function') {
							if(GV.topWindow.MybeforeSubmit() === false) {
								enableBtn();
								return false;
							}
						}						
						
						_form.form('submit',{
							dataType : 'json',
							onSubmit: function(){
								var _validate_status = GV.top$(this).form('validate');
								if(!_validate_status) enableBtn();
								return _validate_status;
							},
							success: function(result){
								enableBtn();
								
								//提交成功后需要处理的函数
								if(GV.topWindow.MyafterSubmit && typeof(GV.topWindow.MyafterSubmit) == 'function') {
									if(GV.topWindow.MyafterSubmit(result) === false) {
										return false;
									}
								}
								doFormSubmit(result, _winId, (_options._Clist?_options._Clist:null));
							}
						});
					}
				}
			}
		}];
	}
	if(_options.buttons == undefined || _options.buttons == false) {
		_options.buttons = [];
	}

	GV.top$.createWin({
		winId:(_options.winId?_options.winId:''),
		title:_options.title,
		url:_options.url,
		height:_options.height?_options.height:'auto',
		width:_options.width?_options.width:'auto',
		maximizable:(_options.maximizable?_options.maximizable:true), //是否最大化图标
		mask:(_options.mask?_options.mask:true), //遮罩层
		resizable:(_options.resizable?_options.resizable:true),
		isIframe:(_options.isIframe?_options.isIframe:false),
		//isMax:true, //最大化
		buttons:(_options.buttons?_options.buttons:[]),
		onClose:(_options.onClose?_options.onClose(targetjq):function(targetjq){
			if(!_options.isIframe && ( GV.topWindow.MybeforeSubmit || GV.topWindow.MyafterSubmit)) {
				GV.topWindow.MybeforeSubmit  = undefined;
				GV.topWindow.MyafterSubmit  = undefined;
			}
		}),
		onComplete:(_options.onComplete?_options.onComplete(targetjq):function(targetjq){})
	});
}

function enableBtn() {
	if(GV.btnObj != undefined) {
		GV.btnObj.data('disabled', false);
		GV.btnObj.find('span.l-btn-text').html(GV.btnObj.find('span.l-btn-text').html().slice(0, -4));
		GV.btnObj.css('cursor', 'Pointer');
		GV.btnObj = undefined;
	}
}
function disabledBtn(obj) {
	/*var curobj = GV.top$('body');
	curobj.append('<div class=\"datagrid-mask\" style=\"display:block;z-index:100000;\"></div><div class=\"datagrid-mask-msg\" style=\"display:block;left:50%;z-index:100000;top:40%;\">正在处理，请稍待...</div>');
	var msg = GV.top$('.datagrid-mask-msg');
	msg.outerHeight(40);
	msg.css({
	    marginLeft: ( - msg.outerWidth() / 2),
	    lineHeight: (msg.height() + "px")
	});*/
	GV.btnObj = $(obj);
	if(GV.btnObj.hasClass('l-btn')) {
		if(GV.btnObj.data('disabled')) return false;
		GV.btnObj.data('disabled', true);
		
		GV.btnObj.find('span.l-btn-text').html(GV.btnObj.find('span.l-btn-text').html()+'中...');
		GV.btnObj.css('cursor', 'wait');
	}
	
	return true;
}

$.fn.extend({
	  //getCheckedTreeReturnTree
	  gctrt:function(options){
		  var tree = $(this);
		  var nodes = tree.tree("getRoots");
		  var newTree = traverse(nodes);;
		  return newTree;
		  
		  function traverse(nodes){
			  var newNode = [];
			  $.each(nodes,function(){
				  var target = $(this.target);
				  //如果非勾选的节点及其你节点，不操作
				  if(target.find(".tree-checkbox2").length==0 && target.find(".tree-checkbox1").length==0){
					  return;
				  }
				  var cuNode = {};
				  cuNode.id = this.id;
				  cuNode.text = this.text;
				  cuNode.attributes = this.attributes;
				  cuNode.children = this.children;
				  cuNode.state = this.state;
				  cuNode.checked = this.checked;
				  if(cuNode.children){
					  var arr = [];
					  $.each(this.children,function(){
						  arr.push(tree.tree("getNode",$("#"+this.domId)[0]));	  
					  });
					  cuNode.children = traverse(arr);
					  newNode.push(cuNode);
				  }else{
					  newNode.push(cuNode);
				  }
				  	
			  });
			  return newNode;
		  }
	  }
});

/** datagrid 相关函数 *************/
function getDatagridId(isToolbar, elem) {
	if(isToolbar) {
		var _datagridId = $(elem).parents('div.datagrid-toolbar').siblings('div.datagrid-view').find('table.easyui-datagrid').attr('id');
	} else {
		var _datagridId = $(elem).parents('div.datagrid-view2').siblings('table.easyui-datagrid').attr('id');
	}
	
	return _datagridId;
}

/** tree 相关函数 *************/
/*
 * 获取easyui tree checkbox选中的值
 *treeId:树ID；pkey:父节点key，默认为pid；ckey：子节点key,默认为id
 *举例：TreeGetChecked('tt', 'pid', 'cid')
 * 返回：[{"pid":"0","cid":"1"},{"pid":"1","cid":"12"},{"pid":"12","cid":"124"}]
 */
function TreeGetChecked(treeId, keyid, pkey, ckey , vkey){
	if(keyid==undefined || !keyid) keyid = 'attributes';
	//keys = keys.split(',');
	if(pkey==undefined || !pkey) pkey = 'pid';
	if(ckey==undefined || !ckey) ckey = 'id';
	if(vkey==undefined || !vkey) vkey = 'text';
	var nodes = $("#"+treeId).tree("getRoots");
	var data = "";
	for(var i in nodes){
		var temp = _getData($("#"+treeId),nodes[i]);
		data += temp!=""?temp+",":"";
		
	}
	
	var value = null;
//	if(data!=null){
//		data = "["+data+"]";
//	}

	return data==null?'':data.substring(0, data.length-1);		//############得到的值
	//console.log($.parseJSON(data));
	
	function _getData(obj,node){
		//console.log(node.target);
		var txt = "";
		if($(node.target).find(".tree-checkbox").hasClass("tree-checkbox0")){
			return "";
		}
		//console.log(node.text+"#");
		var pid = 0;
		var cid = node[keyid];
		var text = node[vkey];
		var pNode = $("#"+treeId).tree("getParent", node.target); 
//		if(pNode){			//判断是否有父节点，没有作0处理
//			var pid = pNode[keyid];
//			txt = '{"'+pkey+'":"'+(pid.ID?pid.ID:'')+'","'+ckey+'":"'+(cid.ID?cid.ID:'')+'","'+vkey+'":"'+text+'"}';
//		} else {
//			txt = '{"'+pkey+'":"0","'+ckey+'":"'+(cid.ID?cid.ID:'')+'","'+vkey+'":"'+text+'"}';
//		}
		if(pNode){			//判断是否有父节点，没有作0处理
			var pid = pNode[keyid];
			txt = (pid.ID?pid.ID:'')+':'+(cid.ID?cid.ID:'')+':'+text ;
		} else {
			txt = '0:'+(cid.ID?cid.ID:'')+':'+text;
		}
		
		
		if(node.children){
			var cNodes = node.children;
			for(var i=0;i<cNodes.length;i++){
				var curNode = $("#"+treeId).tree("getNode",$("#"+treeId).find("#"+cNodes[i].domId));
				//console.log(curNode);
				var temp = _getData(obj, curNode);
				if(temp!=""){
					if(txt!="")txt+=",";
					txt += temp;
				}
			}
		}
		
		return txt;
	}
}
function TreeGetChecked2(treeId, keyid, pkey, ckey , vkey){
	if(keyid==undefined || !keyid) keyid = 'attributes';
	//keys = keys.split(',');
	if(pkey==undefined || !pkey) pkey = 'pid';
	if(ckey==undefined || !ckey) ckey = 'id';
	if(ckey==undefined || !vkey) vkey = 'text';

	var data = _getData($("#"+treeId), $("#"+treeId).tree("getRoots"), null);
	return data==null?'':data;		//############得到的值

	function _getData(obj, nodes, parentNode){
		var txt = '';
		if(!nodes.length) {
			return txt;
		}
		var temp = '';
		var pid=0, cid, text;
		for(var i in nodes) {
			temp = '';
			var tree_checkbox = $('#'+nodes[i].domId).children('.tree-checkbox');
			if(tree_checkbox.hasClass('tree-checkbox0') || tree_checkbox.hasClass('tree-checkbox2')) {
				if(nodes[i].children && nodes[i].children.length) {
					temp = _getData(obj, nodes[i].children, nodes[i]);
				}
			} else {
				cid = nodes[i][keyid];
				text = nodes[i][vkey];
				temp = cid.ID?cid.ID:'';
				if(parentNode){			//判断是否有父节点，没有作0处理
					pid = parentNode[keyid];
					//temp = (pid.ID?pid.ID:'')+':'+(cid.ID?cid.ID:'')+':'+text ;
				} else {
					//temp = '0:'+(cid.ID?cid.ID:'')+':'+text;
				}
			}
			if(temp) txt += (txt?',':'')+temp;
		}
		
		return txt;
	}
}
/** 通用函数库 end****************************/


/***数据列表页面 处理函数******************************************************/
//格式化操作列
function rowFormater(val,row,index) {
	return '&nbsp;<a class="listALink" href="javascript:javascript:void(0)" onclick="doEdit(this, '+index+')">编辑</a> | <a href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">删除</a>&nbsp;';
}

//获取datagrid配置信息
function doBeforeDatagrid(isToolbar, elem) {
	var _datagridId = getDatagridId(isToolbar, elem);
	
	if(!isToolbar) {
		preventBubble(); //阻止事件冒泡
	}

	if(Clist.id!=undefined && Clist.id) {
		var _Clist = Clist;
	} else {
		var _Clist = Clist[_datagridId];
		_Clist.id = _datagridId;
	}

	return _Clist;
}
//添加
function doAdd(elem){
	var _Clist = doBeforeDatagrid(1, elem);
	var _options = {};
	_options = parseOptions(elem);
	if(_options.buttons == undefined) {
		_options.buttons = 'formSubmit';
	}
	
	
	if(_options.title == undefined || !_options.title) {
		_options.title = '新增';
	}
	
	_options.url = _Clist.addUrl;
	if(!_options.width) {
		_options.width = (_Clist.dialogWidth?_Clist.dialogWidth:'auto');
	}
	if(!_options.height) {
		_options.height = (_Clist.dialogHeight?_Clist.dialogHeight:'auto');
	}
	_options._Clist = _Clist;
	_createWin(_options);
}

//编辑
function doEdit(elem, index) {
	var _Clist = doBeforeDatagrid(0, elem);
	var rows = $('#'+_Clist.id).datagrid('getData');
	var row = rows.rows[index];
	
	var _options = {};
	_options = parseOptions(elem);
	
	//弹出层编辑的url
	var _dialogUrl = (_options.url?_options.url:_Clist.editUrl);
	var _url = _dialogUrl+(_dialogUrl.indexOf('?')!=-1?'&':'?');
	var _extUrl = [];
	var _args = _Clist.idField.split('&');
	for(var i in _args) {
		_extUrl.push(_args[i]+'='+row[_args[i]]);
	}
	_url += _extUrl.join('&');

	//按钮
	if(_options.buttons == undefined) {
		_options.buttons = 'formSubmit';
	}
	
	//标题
	if(_options.title == undefined || !_options.title) {
		_options.title = '编辑';
	}
	
	_options.url = _url;
	if(!_options.width) {
		_options.width = (_Clist.dialogWidth?_Clist.dialogWidth:'auto');
	}
	if(!_options.height) {
		_options.height = (_Clist.dialogHeight?_Clist.dialogHeight:'auto');
	}
	_options._Clist = _Clist;
	
	_createWin(_options);
	return false;
}

//删除操作
function doDelete(elem, index, postType) {
	var _Clist = doBeforeDatagrid(0, elem);
	
	var row = $('#'+_Clist.id).datagrid('getRows')[index];
	postType = (postType?postType:'POST');
	Cmessager.confirm(GV.MESSAGER_TITLE, '确认要删除吗?', function(r){
		if (r){
			var _data = {};
			
			var _args = _Clist.idField.split('&');
			for(var i in _args) {
				_data[_args[i]] = row[_Clist.idField];
			}
			
			$.ajax({
					url: _Clist.deleteUrl,
					type: postType,
					data: _data
				}).done(function(result) {
					doFormSubmit(result, null, _Clist);
				});
		}
	});
}

//删除选中
function doDeleteChecked(elem) {
	var _Clist = doBeforeDatagrid(1, elem);

	var _data = {};
	var ischecked = false;
	var _args = _Clist.idField.split('&');
	var rows = $('#'+_Clist.id).datagrid('getChecked');
	for(var i=0; i<rows.length; i++){
		var row = rows[i];
		for(var j in _args) {
			ischecked = true;
			if(_data[_args[j]] == undefined) {
				_data[_args[j]] = [];
			}
			_data[_args[j]].push(row[_args[j]]);
		}
	}

	if(!ischecked) {
		Cmessager.alert(GV.MESSAGER_TITLE, '请选择要删除的项目！', 'warning');
		return false;
	}
	Cmessager.confirm(GV.MESSAGER_TITLE, '确认要删除吗?', function(r){
		if (r){
			$.ajax({
				url: _Clist.deleteUrl,
				type: "POST",
				data: _data
			}).done(function(result) {
				doFormSubmit(result, null, _Clist);
			});
		}
	});
}

//搜索
function doSearch(formId, elem) {
	var _Clist = doBeforeDatagrid(1, elem);
	
	var _url = _Clist.listUrl;
	_url += _Clist.listUrl.indexOf('?')!=-1?'&':'?';
	_url += $('#'+formId).serialize();
	$('#'+_Clist.id).datagrid({url:_url});
}

//datagrid 
function doDatagridOnDblClickRow(rowIndex, rowData) {
	preventBubble(); //阻止事件冒泡
	_datagridId = $(this).attr('id');
	if(Clist.id!=undefined && Clist.id) {
		var _Clist = Clist;
	} else {
		var _Clist = Clist[_datagridId];
		_Clist.id = _datagridId;
	}

	var rows = $('#'+_Clist.id).datagrid('getData');
	var row = rows.rows[rowIndex];
	
	var _options = {};
	
	//弹出层编辑的url
	var _dialogUrl = _Clist.viewUrl;
	var _url = _dialogUrl+(_dialogUrl.indexOf('?')!=-1?'&':'?');
	var _extUrl = [];
	var _args = _Clist.idField.split('&');
	for(var i in _args) {
		_extUrl.push(_args[i]+'='+row[_args[i]]);
	}
	_url += _extUrl.join('&');

	//按钮
	_options.buttons = false;
	
	//标题
	_options.title = '查看';
	
	_options.url = _url;
	if(!_options.width) {
		_options.width = (_Clist.dialogWidth?_Clist.dialogWidth:'auto');
	}
	if(!_options.height) {
		_options.height = (_Clist.dialogHeight?_Clist.dialogHeight:'auto');
	}
	_options._Clist = _Clist;
	_createWin(_options);
	
}
//重置
function doReset() {
	$(".searchForm").find("input").val("");
	//resetSe = $(".searchForm").find("select > option:first-child").text();
	$(".searchForm select").each(function(){
		resetSe = $(this).children("option:first-child").text();
		$(this).next("span").children("input").first().val(resetSe);
	});
}

function parseReturn(result) {
	if(typeof result == 'string') {
		try {
			result = $.parseJSON(result);
		} catch(err) {
			//Cmessager.alert('', result);
			return false;
		}
	}
	
	return result;
}
//处理弹出层form表单提交，服务端返回数据后
function doFormSubmit(result, _winId, _Clist) {
	result = parseReturn(result);
	if(!result) return false;

	if(result.callback) {
		eval(result.callback+'()');
	}
	if (result.status == 'success'){
		Cmessager.show({
			title:GV.MESSAGER_TITLE,
			msg:result.message,
			timeout:1500
		});
		if(_winId!=undefined && _winId) GV.top$('#'+_winId).dialog('close'); //关闭弹出层
		if(result.closeTab == true) {
			var tab = GV.top$('#tt').tabs('getSelected');  // 获取选择的面板
			GV.top$('#tt').tabs('close', GV.top$('#tt').tabs('getTabIndex', tab));
		} else if(result.reloadTab == true) { //刷新tab
			var tab = GV.top$('#tt').tabs('getSelected');  // 获取选择的面板
			tab.panel('refresh');
		} else {
			if(_Clist!=undefined && _Clist) $('#'+_Clist.id).datagrid('reload');
		}
	} else {
		Cmessager.alert(GV.MESSAGER_TITLE, result.message, 'error');
	}
}
/***数据列表页面 处理函数 end******************************************************/



/*** 自定义弹出层 start *******************************************************/
(function ($) {
	function S4() {
		return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
	}
	function CreateIndentityWindowId() {
		return "UUID-" + (S4() + S4() + "-" + S4() + "-" + S4() + "-" + S4() + "-" + S4() + S4() + S4());
	}
	function destroy(target) {
		$(target).dialog("destroy");
	}
	function getWindow(target) {
		if (typeof target == "string") {
			return document.getElementById(target);
		} else {
			return $(target).closest(".window-body");
		}
	}
	$.createWin = function (options) {
		if (!options.url && !options.contents) {
			$.messager.alert("提示", "缺少必要参数!(url or contents)");
			return false;
		}
		var windowId = CreateIndentityWindowId();
		if (options.winId) {
			windowId = options.winId;
		} else {
			options.winId = windowId;
		}
		if(options.buttons == 'none') {
			options.buttons = '';
		} else {
			var defaultBtn = [{
					text : '关闭',
					handler : function () {
						$("#" + windowId).dialog("close");
					}
				}
			];
			$.merge(options.buttons || [], defaultBtn);
		}
		
		options = $.extend({}, $.createWin.defaults, options || {});
		if (options.isMax) {
			options.draggable = false;
			options.closed = true;
		}
		var dialog = $('<div/>');
		if (options.target != 'body') {
			options.inline = true;
		}
		dialog.appendTo($(options.target));
		dialog.dialog($.extend({}, options, {
				onClose : function () {
					if (typeof options.onClose == "function") {
						options.onClose.call(dialog,$);
					}
					destroy(this);
				},
				onMove : function (left, top) {
					if (typeof options.onMove == "function") {
						options.onMove.call(dialog,$);
					}
					var o = $.data(this, 'panel').options;
					if (top < 0) {
						$(this).dialog("move", {
							"left" : left,
							"top" : 0
						});
					} else if (o.maximized) {
						$(this).dialog("restore");
						$(this).dialog("move", {
							"left" : left + 100,
							"top" : top
						});
					}
					if (top > ($(o.target).height() - 20)) {
						$(this).dialog("move", {
							"left" : left,
							"top" : ($(o.target).height() - 25)
						});
					}
				}
			}));
		if (options.align) {
			var w = dialog.closest(".window");
			switch (options.align) {
			case "right":
				dialog.dialog("move", {
					left : w.parent().width() - w.width() - 10
				});
				break;
			case "tright":
				dialog.dialog("move", {
					left : w.parent().width() - w.width() - 10,
					top : 0
				});
				break;
			case "bright":
				dialog.dialog("move", {
					left : w.parent().width() - w.width() - 10,
					top : w.parent().height() - w.height() - 10
				});
				break;
			case "left":
				dialog.dialog("move", {
					left : 0
				});
				break;
			case "tleft":
				dialog.dialog("move", {
					left : 0,
					top : 0
				});
				break;
			case "bleft":
				dialog.dialog("move", {
					left : 0,
					top : w.parent().height() - w.height() - 10
				});
				break;
			case "top":
				dialog.dialog("move", {
					top : 0
				});
				break;
			case "bottom":
				dialog.dialog("move", {
					top : w.parent().height() - w.height() - 10
				});
				break;
			}
		}
		if (options.isMax) {
			dialog.dialog("maximize");
			dialog.dialog("open");
		}
		if ($.fn.mask && options.mask)
			dialog.mask();
		if (options.contents) {
			ajaxSuccess(options.contents);
		} else {
			if (!options.isIframe) {
				$.ajax({
					url : options.url,
					type : options.ajaxType || "GET",
					data : options.data == null ? "" : options.data,
					success : function (date) {
						ajaxSuccess(date);
					},
					error : function () {
						//$.messager.alert("提示", "加载失败！", 'error', function(){$("#" + windowId).dialog("close");});
						if ($.fn.mask && options.mask)
							dialog.mask("hide");
					}
				});
			} else {
				ajaxSuccess();
			}
		}
		dialog.attr("id",windowId);
		return dialog;
		function ajaxSuccess(date) {
			if (options.isIframe && !date) {
				dialog.find("div.dialog-content").html('<div style="overflow:hidden;height:'+dialog.find("div.dialog-content").height()+'px"><iframe width="100%" height="100%" frameborder="0" id="'+windowId+'_Iframe" src="' + options.url + '" ></iframe></div>');
			} else {
				dialog.find("div.dialog-content").html(date);
			}
			$.parser.parse(dialog);
			options.onComplete.call(this, dialog,$);
			if ($.fn.mask && options.mask)
				dialog.mask("hide");
		}
	};
	$.fn.destroy = function () {
		destroy(this);
	};
	window.GETWIN = getWindow;
	$.createWin.defaults = $.extend({}, $.fn.dialog.defaults, {
			url : '',
			data : '',
			ajaxType:"GET",
			target : 'body',
			height : 200,
			width : 400,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			closable : true,
			modal : true,
			shadow : false,
			mask : true,
			onComplete : function (dialog,jq) {}
		});
})(jQuery);


/* 
 *  Document   : mask 1.1
 *  Created on : 2011-12-11, 14:37:38
 *  Author     : GodSon
 *  Email      : wmails@126.com
 *  Link       : www.btboys.com 
 *  
 */
 
(function($){
    function init(target,options){
        var wrap = $(target);
		if($("div.datagrid-mask",wrap).length) wrap.mask("hide");
		
        wrap.attr("position",wrap.css("position"));
		wrap.attr("overflow",wrap.css("overflow"));
        wrap.css("position", "relative");
		wrap.css("overflow", "hidden");
        
        var maskCss = {
            /*position:"absolute",
            left:0,
            top:0,
			cursor: "wait",
            background:"#ccc",
            opacity:options.opacity,
            filter:"alpha(opacity="+options.opacity*100+")",
            display:"none"*/
        };
        
        var maskMsgCss = {
            /*position:"absolute",
            width:"auto",
            padding:"10px 20px",
            border:"2px solid #ccc",
            color:"white",
			cursor: "wait",
            display:"none",
            borderRadius:5,
            background:"black",
            opacity:0.6,
            filter:"alpha(opacity=60)"*/
        };
		var width,height,left,top;
		if(target == 'body'){
			width = Math.max(document.documentElement.clientWidth, document.body.clientWidth);
			height = Math.max(document.documentElement.clientHeight, document.body.clientHeight);
		}else{
			width = wrap.outerWidth() || "100%";
			height = wrap.outerHeight() || "100%";
		}
        $('<div class="datagrid-mask"></div>').css($.extend({},maskCss,{
            display : 'block',
            width : width,
            height : height,
            zIndex:options.zIndex
        })).appendTo(wrap);

		var maskm= $('<div class="datagrid-mask-msg"></div>').html(options.maskMsg).appendTo(wrap).css(maskMsgCss);
		
		if(target == 'body'){
			left = (Math.max(document.documentElement.clientWidth,document.body.clientWidth) - $('div.datagrid-mask-msg', wrap).outerWidth())/ 2;
			if(document.documentElement.clientHeight > document.body.clientHeight){
				top = (Math.max(document.documentElement.clientHeight,document.body.clientHeight)  - $('div.datagrid-mask-msg', wrap).outerHeight())/ 2;
			}else{
				top = (Math.min(document.documentElement.clientHeight,document.body.clientHeight)  - $('div.datagrid-mask-msg', wrap).outerHeight())/ 2;
			}
			
		}else{
			left = (wrap.width() - $('div.datagrid-mask-msg', wrap).outerWidth())/ 2;
			top = (wrap.height() - $('div.datagrid-mask-msg', wrap).outerHeight())/ 2;
		}
		
        maskm.css({
            display : 'block',
            zIndex:options.zIndex+1,
            left : left,
            top :  top
        });
        
        setTimeout(function(){
            wrap.mask("hide");
        }, options.timeout);
            
        return wrap;
    }
       
    $.fn.mask = function(options){   
        if (typeof options == 'string'){
            return $.fn.mask.methods[options](this);
        }
        options = $.extend({}, $.fn.mask.defaults,options);
        return init(this,options);
    };
    $.mask = function(options){  
        if (typeof options == 'string'){
            return $.fn.mask.methods[options]("body");
        }
        options = $.extend({}, $.fn.mask.defaults,options);
        return init("body",options);
    };
	
	$.mask.hide = function(){
		$("body").mask("hide");
	};
	
    $.fn.mask.methods = {
        hide : function(jq) {
            return jq.each(function() {
                var wrap = $(this);
                $("div.datagrid-mask",wrap).fadeOut(function(){
                    $(this).remove();
                });
                $("div.datagrid-mask-msg",wrap).fadeOut(function(){
                    $(this).remove();
                    wrap.css("position",  wrap.attr("position"));
					wrap.css("overflow", wrap.attr("overflow"));
                });
            });
        }
    };
    
    $.fn.mask.defaults = {
        maskMsg:'\u52a0\u8f7d……',
        zIndex:100000,
        timeout:30000,
        opacity:0.6
    };
})(jQuery);
/*** 自定义弹出层 end *******************************************************/