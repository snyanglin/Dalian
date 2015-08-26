/*!
 * 字典组件
 * znjg - v1.0.0 (2014-03-14 08:36)
 * Copyright(c) 2014 founder
 * 
 * 本组件下拉列表字典依赖jquery.min.js及SysTool.js；下拉树字典依赖jquery.min.js、SysTool.js及MzTree插件，页面需要引入MzTree插件的jsframework.js
 */

/**
 * 加载字典组件相关CSS
 */
SysTool.loadComponentsFile("dictionary", "dictionary", ".css");

/**
 * @classDescription 字典全局对象
 * @author yichu
 */
var Dictionary = {
	
	/**
	 * 树数组
	 */
	treeObjectArray : [], 
	
	/**
	 * 字典列表选择div class
	 */
	dictSelectDivClass: "selct_div",
	
	/**
	 * 字典树选择div class
	 */
	dictTreeDivClass: "selct_tree",
	
	/**
	 * 显示字典词条的控件宽度偏移像素
	 */
	dictShowWidthOffsetPx : 9,
	
	/**
	 * 是否隐藏字典树
	 */
	isHiddenDictTree : false,
	
	/**
	 * 字典过滤timer
	 */
	dictFilterTimer : {},
	
	/**
	 * 调用树插件
	 */
	usingTreePlugin : function() {
		Using("System.Web.UI.WebControls.MzTreeView");
	},
	
	/**
	 * 初始化字典树
	 * @param {Object} param JSON对象（包括：url 请求url，zdbh 字典编号（字典表名），zdmc 字典名称，dictDataDivId 放字典数据的DIV id。）
	 * @param {Function} callback 回调函数
	 */
	initDictTree : function(param, callback) {
		SysTool.ajax({
  			url: param.url,
      		data: {"zdbh": param.zdbh, "zdmc": param.zdmc, "zzjgdm": ("undefined" == typeof param.zzjgdm ? "" : param.zzjgdm), "auth": ("undefined" == typeof param.auth ? "0" : param.auth)}		
	    }, function(jsonData) {
      		$("#" + param.dictDataDivId).html(jsonData[param.zdbh] + jsonData[param.zdbh + "_DATA"]);
      		callback();
		});
	},
	
	/**
	 * 生成字典树前
	 * @param {Object} param JSON对象（包括：createCount 生成树次数，zdbh 字典编号（字典表名），treeData 树数据对象，dictDataDivId 放字典数据的DIV id)
	 * 
	 */
	beforeCreateDictTree : function(param) {
		var javascriptString = "<script type='text/javascript'>";
		javascriptString += "\r\n";
		javascriptString += "var data_" + param.zdbh + "_" + param.createCount + " = {};";
		javascriptString += "\r\n";
		for (var index in param.treeData) {
			javascriptString += "data_" + param.zdbh + "_" + param.createCount + "['" + index + "'] = '" + (param.treeData[index] + "").substring((param.treeData[index] + "").indexOf("text")) + "';";
			javascriptString += "\r\n";
		}
		javascriptString += "</script>";
		$("#" + param.dictDataDivId).html(javascriptString);
	},
	
	/**
	 * 生成字典树
	 * @param {Object} param JSON对象（包括：dictObject 字典对象，treeData 树数据对象，isLeaf 是否只选叶子节点，dictHiddenId 隐藏字典代码的控件id，dictShowId 显示字典词条的控件id，dictSelectDivId 字典选择DIV id，dictContainerReferenceObjectId 字典下拉容器参照物id，initVal 初始值。）
	 * @param {Function} afterCreateCallback 字典生成完成后的回调函数
	 */
	createDictTree : function (param, afterCreateCallback) {
		if ("undefined" == typeof param.dictContainerReferenceObjectId) {
    		param.dictContainerReferenceObjectId = "tips";
    	}
		if ("undefined" != typeof $("#" + param.dictShowId + "Div") && $("#" + param.dictShowId + "Div") != null) {
			$("#" + param.dictShowId + "Div").remove();
		}
		$("#" + param.dictContainerReferenceObjectId).append("<div id='" + param.dictShowId + "Div' class='selct_tree'></div>");
		param.dictSelectDivId = param.dictShowId + "Div";
		var listWidth = param.dictObject.listWidth;// 列表宽度
		var dictShowWidth = $("#" + param.dictShowId).width();// 显示字典词条的input控件宽度
		//listWidth = (listWidth >= (dictShowWidth + this.dictShowWidthOffsetPx) ? listWidth : (dictShowWidth + this.dictShowWidthOffsetPx));
		listWidth = dictShowWidth + this.dictShowWidthOffsetPx;
		$("#" + param.dictSelectDivId).width(listWidth);
	    var treeObject = new MzTreeView();
	    treeObject.dataSource = param.treeData;
	    treeObject.setJsDataPath("common/components/dictionary/");
	    treeObject.autoSort = false; 
	    treeObject.useCheckbox = param.useCheckbox||false;
	    treeObject.autoFocused = true;
	    treeObject.canOperate = false;
	    this.treeObjectArray.push(treeObject);
	    $("#" + param.dictSelectDivId).html(treeObject.render());
	    this.setSelectedNode("", param.dictObject, treeObject);
	    if ("undefined" != typeof treeObject.rootNode.childNodes[0] && treeObject.rootNode.childNodes[0] != null) {
	    	treeObject.rootNode.childNodes[0].set("isLeaf", param.isLeaf);
		    treeObject.rootNode.childNodes[0].set("inputIdString", param.dictShowId + "■" + param.dictSelectDivId);
	    }
	    if ("undefined" != typeof treeObject.rootNode.childNodes[0].childNodes[0] && treeObject.rootNode.childNodes[0].childNodes[0] != null) {
	    	treeObject.expandLevel(2);
	    }
	    if ("undefined" != typeof param.initVal && param.initVal != "" && param.initVal != null) {
	    	for (var index in param.treeData) {
				if (param.initVal == index.split("_")[1]) {
					$("#" + param.dictShowId).val((param.treeData[index] + "").substring((param.treeData[index] + "").indexOf("text") + 5, (param.treeData[index] + "").length - 1));
					$("#" + param.dictHiddenId).val(param.initVal);
					break;
				}
			}
	    }
	  
	    $("#" + param.dictShowId).focus(function(e) {
	    	var isShow = $("#" + param.dictSelectDivId).is(":visible");
	    	Dictionary.hideExpand(Dictionary.dictSelectDivClass);
	    	if (isShow) {
	    		Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, param.dictContainerReferenceObjectId, function() {});
	    		Dictionary.isHiddenDictTree = true;
	    		e.preventDefault();
	    	}
		});
		$("#" + param.dictShowId).change(function() {
    		$("#" + param.dictHiddenId).val("");
    	});
	    $("#" + param.dictShowId).keyup(function(e) {
			if (Dictionary.dictFilterTimer[param.dictShowId]) {
		        window.clearTimeout(Dictionary.dictFilterTimer[param.dictShowId]);
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }
			Dictionary.dictFilterTimer[param.dictShowId] = window.setTimeout(function() {
				Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, param.dictContainerReferenceObjectId, function() {});
				Dictionary.isHiddenDictTree = true;
				Dictionary.locateNode($("#" + param.dictShowId).val(), param.dictObject, treeObject, param.dictShowId);
				e.preventDefault();
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }, SysConfig.DICT_FILTER_TIMER);
		});
	    $("#" + param.dictShowId).click(function(e) {
	    	/*if (Dictionary.dictFilterTimer[param.dictShowId]) {
		        window.clearTimeout(Dictionary.dictFilterTimer[param.dictShowId]);
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }
			Dictionary.dictFilterTimer[param.dictShowId] = window.setTimeout(function() {
				Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, param.dictContainerReferenceObjectId, function() {});
				Dictionary.isHiddenDictTree = true;
				Dictionary.setSelectedNode($("#" + param.dictHiddenId).val(), param.dictObject, treeObject);
				e.preventDefault();
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }, SysConfig.DICT_FILTER_TIMER);*/
	    	if (Dictionary.dictFilterTimer[param.dictShowId]) {
		        window.clearTimeout(Dictionary.dictFilterTimer[param.dictShowId]);
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }
			Dictionary.dictFilterTimer[param.dictShowId] = window.setTimeout(function() {
				Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, param.dictContainerReferenceObjectId, function() {});
				Dictionary.isHiddenDictTree = true;
				Dictionary.locateNode($("#" + param.dictShowId).val(), param.dictObject, treeObject, param.dictShowId);
				e.preventDefault();
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }, SysConfig.DICT_FILTER_TIMER);
    	});
	    
	    $("#" + param.dictSelectDivId).mousemove(function() {
			if ($("#" + param.dictSelectDivId).is(":visible")) {
				Dictionary.isHiddenDictTree = false;
			}
		}).mouseout(function() {
			if ($("#" + param.dictSelectDivId).is(":visible")) {
				Dictionary.isHiddenDictTree = true;
			}
		});
	    
	    if ($.isFunction(afterCreateCallback)) {
	    	afterCreateCallback();// 执行字典生成完成后的回调函数
    	}
	},
	
	
	
	
	
	/**
	 * 生成字典树  GPS专用
	 * @param {Object} param JSON对象（包括：dictObject 字典对象，treeData 树数据对象，isLeaf 是否只选叶子节点，dictHiddenId 隐藏字典代码的控件id，dictShowId 显示字典词条的控件id，dictSelectDivId 字典选择DIV id，dictContainerReferenceObjectId 字典下拉容器参照物id，initVal 初始值。）
	 * @param {Function} afterCreateCallback 字典生成完成后的回调函数
	 */
	createGpsDictTree : function (param, afterCreateCallback) {
		if ("undefined" == typeof param.dictContainerReferenceObjectId) {
    		param.dictContainerReferenceObjectId = "tips";
    	}
		if ("undefined" != typeof $("#" + param.dictShowId + "Div") && $("#" + param.dictShowId + "Div") != null) {
			$("#" + param.dictShowId + "Div").remove();
		}
		$("#" + param.dictContainerReferenceObjectId).append("<div id='" + param.dictShowId + "Div'></div>");
		param.dictSelectDivId = param.dictShowId + "Div";
		var listWidth = param.dictObject.listWidth;// 列表宽度
		var dictShowWidth = $("#" + param.dictShowId).width();// 显示字典词条的input控件宽度
		//listWidth = (listWidth >= (dictShowWidth + this.dictShowWidthOffsetPx) ? listWidth : (dictShowWidth + this.dictShowWidthOffsetPx));
		listWidth = dictShowWidth + this.dictShowWidthOffsetPx;
		$("#" + param.dictSelectDivId).width(listWidth);
	    var treeObject = new MzTreeView();
	    treeObject.dataSource = param.treeData;
	    treeObject.setJsDataPath("common/components/dictionary/");
	    treeObject.autoSort = false; 
	    treeObject.useCheckbox = param.useCheckbox||false;
	    treeObject.autoFocused = true;
	    treeObject.canOperate = false;
	    this.treeObjectArray.push(treeObject);
	    $("#" + param.dictSelectDivId).html(treeObject.render());
	    this.setSelectedNode("", param.dictObject, treeObject);
	    if ("undefined" != typeof treeObject.rootNode.childNodes[0] && treeObject.rootNode.childNodes[0] != null) {
	    	treeObject.rootNode.childNodes[0].set("isLeaf", param.isLeaf);
	    	treeObject.rootNode.childNodes[0].set("isDisplay", param.isDisplay);
		    treeObject.rootNode.childNodes[0].set("inputIdString", param.dictShowId + "■" + param.dictSelectDivId);
	    }
	    if ("undefined" != typeof treeObject.rootNode.childNodes[0].childNodes[0] && treeObject.rootNode.childNodes[0].childNodes[0] != null) {
	    	treeObject.expandLevel(2);
	    }
	    
	    if ("undefined" != typeof param.initVal && param.initVal != "" && param.initVal != null) {
	    	for (var i = 0; i < param.dictObject.dictArray.length; i++) {
    			if (param.initVal==param.dictObject.dictArray[i][1]) {
    		    break;
    			}	
    		}
			
	    	for (var index in param.treeData) {
				if (param.initVal == index.split("_")[1]) {
					$("#" + param.dictShowId).val((param.treeData[index] + "").substring((param.treeData[index] + "").indexOf("text") + 5, (param.treeData[index] + "").length - 1));
					$("#" + param.dictHiddenId).val(param.initVal+";"+param.dictObject.dictArray[i][7]);
					break;
				}
			}
	    	
	    }
	  
	    $("#" + param.dictShowId).focus(function(e) {
	    	var isShow = $("#" + param.dictSelectDivId).is(":visible");
	    	Dictionary.hideExpand(Dictionary.dictSelectDivClass);
	    	if (isShow) {
	    		Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, param.dictContainerReferenceObjectId, function() {});
	    		Dictionary.isHiddenDictTree = true;
	    		e.preventDefault();
	    	}
		});
		$("#" + param.dictShowId).change(function() {
    		$("#" + param.dictHiddenId).val("");
    	});
	    $("#" + param.dictShowId).keyup(function(e) {
			if (Dictionary.dictFilterTimer[param.dictShowId]) {
		        window.clearTimeout(Dictionary.dictFilterTimer[param.dictShowId]);
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }
			Dictionary.dictFilterTimer[param.dictShowId] = window.setTimeout(function() {
				Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, param.dictContainerReferenceObjectId, function() {});
				Dictionary.isHiddenDictTree = true;
				Dictionary.locateNode($("#" + param.dictShowId).val(), param.dictObject, treeObject, param.dictShowId);
				e.preventDefault();
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }, SysConfig.DICT_FILTER_TIMER);
		});
	    $("#" + param.dictShowId).click(function(e) {
	    	/*if (Dictionary.dictFilterTimer[param.dictShowId]) {
		        window.clearTimeout(Dictionary.dictFilterTimer[param.dictShowId]);
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }
			Dictionary.dictFilterTimer[param.dictShowId] = window.setTimeout(function() {
				Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, param.dictContainerReferenceObjectId, function() {});
				Dictionary.isHiddenDictTree = true;
				Dictionary.setSelectedNode($("#" + param.dictHiddenId).val(), param.dictObject, treeObject);
				e.preventDefault();
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }, SysConfig.DICT_FILTER_TIMER);*/
	    	if (Dictionary.dictFilterTimer[param.dictShowId]) {
		        window.clearTimeout(Dictionary.dictFilterTimer[param.dictShowId]);
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }
			Dictionary.dictFilterTimer[param.dictShowId] = window.setTimeout(function() {
				Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, param.dictContainerReferenceObjectId, function() {});
				Dictionary.isHiddenDictTree = true;
				Dictionary.locateNode($("#" + param.dictShowId).val(), param.dictObject, treeObject, param.dictShowId);
				e.preventDefault();
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }, SysConfig.DICT_FILTER_TIMER);
    	});
	    
	    $("#" + param.dictSelectDivId).mousemove(function() {
			if ($("#" + param.dictSelectDivId).is(":visible")) {
				Dictionary.isHiddenDictTree = false;
			}
		}).mouseout(function() {
			if ($("#" + param.dictSelectDivId).is(":visible")) {
				Dictionary.isHiddenDictTree = true;
			}
		});
	    
	    if ($.isFunction(afterCreateCallback)) {
	    	afterCreateCallback();// 执行字典生成完成后的回调函数
    	}
	},
	
	
	/**
	 * 生成字典树  zygl专用
	 * @param {Object} param JSON对象（包括：dictObject 字典对象，treeData 树数据对象，isLeaf 是否只选叶子节点，dictHiddenId 隐藏字典代码的控件id，dictShowId 显示字典词条的控件id，dictSelectDivId 字典选择DIV id，dictContainerReferenceObjectId 字典下拉容器参照物id，initVal 初始值。）
	 * @param {Function} afterCreateCallback 字典生成完成后的回调函数
	 */
	createZyglDictTree : function (param, afterCreateCallback) {
		if ("undefined" == typeof param.dictContainerReferenceObjectId) {
    		param.dictContainerReferenceObjectId = "tips";
    	}
		if ("undefined" != typeof $("#" + param.dictShowId + "Div") && $("#" + param.dictShowId + "Div") != null) {
			$("#" + param.dictShowId + "Div").remove();
		}
		$("#" + param.dictContainerReferenceObjectId).append("<div id='" + param.dictShowId + "Div'></div>");
		param.dictSelectDivId = param.dictShowId + "Div";
		var listWidth = param.dictObject.listWidth;// 列表宽度
		var dictShowWidth = $("#" + param.dictShowId).width();// 显示字典词条的input控件宽度
		//listWidth = (listWidth >= (dictShowWidth + this.dictShowWidthOffsetPx) ? listWidth : (dictShowWidth + this.dictShowWidthOffsetPx));
		listWidth = dictShowWidth + this.dictShowWidthOffsetPx;
		$("#" + param.dictSelectDivId).width(listWidth);
	    var treeObject = new MzTreeView();
	    treeObject.dataSource = param.treeData;
	    treeObject.setJsDataPath("common/components/dictionary/");
	    treeObject.autoSort = false; 
	    treeObject.useCheckbox = param.useCheckbox||false;
	    treeObject.autoFocused = true;
	    treeObject.canOperate = false;
	    this.treeObjectArray.push(treeObject);
	    $("#" + param.dictSelectDivId).html(treeObject.render());
	 
	    if ("undefined" != typeof treeObject.rootNode.childNodes[0] && treeObject.rootNode.childNodes[0] != null) {
	    	treeObject.rootNode.childNodes[0].set("isLeaf", param.isLeaf);
	    	treeObject.rootNode.childNodes[0].set("isDisplay", param.isDisplay);
		    treeObject.rootNode.childNodes[0].set("inputIdString", param.dictShowId + "■" + param.dictSelectDivId);
	    }
	    if ("undefined" != typeof treeObject.rootNode.childNodes[0].childNodes[0] && treeObject.rootNode.childNodes[0].childNodes[0] != null) {
	    	treeObject.expandLevel(1);
	    }
	
	    if ("undefined" != typeof param.initVal && param.initVal != "" && param.initVal != null) {
	    	for (var i = 0; i < param.dictObject.dictArray.length; i++) {
    			if (param.initVal==param.dictObject.dictArray[i][1]) {
    		    break;
    			}	
    		}
			
	    	for (var index in param.treeData) {
				if (param.initVal == index.split("_")[1]) {
					$("#" + param.dictShowId).val((param.treeData[index] + "").substring((param.treeData[index] + "").indexOf("text") + 5, (param.treeData[index] + "").length - 1));
					$("#" + param.dictHiddenId).val(param.initVal+";"+param.dictObject.dictArray[i][7]);
					break;
				}
			}
	    	
	    }
	    else{
	    	for (var i = 0; i < param.dictObject.dictArray.length; i++) {
    			if (1 == param.dictObject.dictArray[i][5]) {
    			   param.initVal=param.dictObject.dictArray[i][1];
    	    	    break;
    			}	
    			}
			
	    	for (var index in param.treeData) {
				if (param.initVal == index.split("_")[1]) {
					$("#" + param.dictShowId).val((param.treeData[index] + "").substring((param.treeData[index] + "").indexOf("text") + 5, (param.treeData[index] + "").length - 1));
					$("#" + param.dictHiddenId).val(param.initVal+";"+param.dictObject.dictArray[i][7]);
					break;
				}
			}
	    }
	    $("#" + param.dictShowId).focus(function(e) {
	    	var isShow = $("#" + param.dictSelectDivId).is(":visible");
	    	Dictionary.hideExpand(Dictionary.dictSelectDivClass);
	    	if (isShow) {
	    		Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, param.dictContainerReferenceObjectId, function() {});
	    		Dictionary.isHiddenDictTree = true;
	    		e.preventDefault();
	    	}
		});
		$("#" + param.dictShowId).change(function() {
    		$("#" + param.dictHiddenId).val("");
    	});
	    $("#" + param.dictShowId).keyup(function(e) {
			if (Dictionary.dictFilterTimer[param.dictShowId]) {
		        window.clearTimeout(Dictionary.dictFilterTimer[param.dictShowId]);
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }
			Dictionary.dictFilterTimer[param.dictShowId] = window.setTimeout(function() {
				Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, param.dictContainerReferenceObjectId, function() {});
				Dictionary.isHiddenDictTree = true;
				Dictionary.locateNode($("#" + param.dictShowId).val(), param.dictObject, treeObject, param.dictShowId);
				e.preventDefault();
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }, SysConfig.DICT_FILTER_TIMER);
		});
	    this.setSelectedZyglNode(param.initVal, param.dictObject, treeObject);
	    $("#" + param.dictShowId).click(function(e) {
	    	/*if (Dictionary.dictFilterTimer[param.dictShowId]) {
		        window.clearTimeout(Dictionary.dictFilterTimer[param.dictShowId]);
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }
			Dictionary.dictFilterTimer[param.dictShowId] = window.setTimeout(function() {
				Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, param.dictContainerReferenceObjectId, function() {});
				Dictionary.isHiddenDictTree = true;
				Dictionary.setSelectedNode($("#" + param.dictHiddenId).val(), param.dictObject, treeObject);
				e.preventDefault();
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }, SysConfig.DICT_FILTER_TIMER);*/
	    	if (Dictionary.dictFilterTimer[param.dictShowId]) {
		        window.clearTimeout(Dictionary.dictFilterTimer[param.dictShowId]);
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }
			Dictionary.dictFilterTimer[param.dictShowId] = window.setTimeout(function() {
				Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, param.dictContainerReferenceObjectId, function() {});
				Dictionary.isHiddenDictTree = true;
				Dictionary.locateNode($("#" + param.dictShowId).val(), param.dictObject, treeObject, param.dictShowId);
				e.preventDefault();
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }, SysConfig.DICT_FILTER_TIMER);
    	});
	    
	    $("#" + param.dictSelectDivId).mousemove(function() {
			if ($("#" + param.dictSelectDivId).is(":visible")) {
				Dictionary.isHiddenDictTree = false;
			}
		}).mouseout(function() {
			if ($("#" + param.dictSelectDivId).is(":visible")) {
				Dictionary.isHiddenDictTree = true;
			}
		});
	    
	    if ($.isFunction(afterCreateCallback)) {
	    	afterCreateCallback();// 执行字典生成完成后的回调函数
    	}
	},
	
	
	/**
	 * 生成字典树  巡区管理专用
	 * @param {Object} param JSON对象（包括：dictObject 字典对象，treeData 树数据对象，isLeaf 是否只选叶子节点，dictHiddenId 隐藏字典代码的控件id，dictShowId 显示字典词条的控件id，dictSelectDivId 字典选择DIV id，dictContainerReferenceObjectId 字典下拉容器参照物id，initVal 初始值。）
	 * @param {Function} afterCreateCallback 字典生成完成后的回调函数
	 */
	createXqglDictTree : function (param, afterCreateCallback) {
		if ("undefined" == typeof param.dictContainerReferenceObjectId) {
    		param.dictContainerReferenceObjectId = "tips";
    	}
		if ("undefined" != typeof $("#" + param.dictShowId + "Div") && $("#" + param.dictShowId + "Div") != null) {
			$("#" + param.dictShowId + "Div").remove();
		}
		$("#" + param.dictContainerReferenceObjectId).append("<div id='" + param.dictShowId + "Div' class='selct_tree'></div>");
		param.dictSelectDivId = param.dictShowId + "Div";
		
		var listWidth = param.dictObject.listWidth;// 列表宽度
		var dictShowWidth = $("#" + param.dictShowId).width();// 显示字典词条的input控件宽度
		//listWidth = (listWidth >= (dictShowWidth + this.dictShowWidthOffsetPx) ? listWidth : (dictShowWidth + this.dictShowWidthOffsetPx));
		listWidth = dictShowWidth + this.dictShowWidthOffsetPx;
		$("#" + param.dictSelectDivId).width(listWidth);
	    var treeObject = new MzTreeView();
	    treeObject.dataSource = param.treeData;
	    treeObject.setJsDataPath("common/components/dictionary/");
	    treeObject.autoSort = false; 
	    treeObject.useCheckbox = param.useCheckbox||false;
	    treeObject.autoFocused = true;
	    treeObject.canOperate = false;
	    this.treeObjectArray.push(treeObject);
	    $("#" + param.dictSelectDivId).html(treeObject.render());
	 
	    if ("undefined" != typeof treeObject.rootNode.childNodes[0] && treeObject.rootNode.childNodes[0] != null) {
	    	treeObject.rootNode.childNodes[0].set("isLeaf", param.isLeaf);
	    	treeObject.rootNode.childNodes[0].set("isDisplay", param.isDisplay);
		    treeObject.rootNode.childNodes[0].set("inputIdString", param.dictShowId + "■" + param.dictSelectDivId);
	    }
	    if ("undefined" != typeof treeObject.rootNode.childNodes[0].childNodes[0] && treeObject.rootNode.childNodes[0].childNodes[0] != null) {
	    	treeObject.expandLevel(1);
	    }
	
	    if ("undefined" != typeof param.initVal && param.initVal != "" && param.initVal != null) {
	    	for (var i = 0; i < param.dictObject.dictArray.length; i++) {
    			if (param.initVal==param.dictObject.dictArray[i][1]) {
    		    break;
    			}	
    		}
			
	    	for (var index in param.treeData) {
				if (param.initVal == index.split("_")[1]) {
					$("#" + param.dictShowId).val((param.treeData[index] + "").substring((param.treeData[index] + "").indexOf("text") + 5, (param.treeData[index] + "").length - 1));
					$("#" + param.dictHiddenId).val(param.initVal+";"+param.dictObject.dictArray[i][7]);
					break;
				}
			}
	    	
	    }
	    else{
	    	for (var i = 0; i < param.dictObject.dictArray.length; i++) {
    			if (1 == param.dictObject.dictArray[i][5]) {
    			   param.initVal=param.dictObject.dictArray[i][1];
    	    	    break;
    			}	
    			}
			
	    	for (var index in param.treeData) {
				if (param.initVal == index.split("_")[1]) {
					$("#" + param.dictShowId).val((param.treeData[index] + "").substring((param.treeData[index] + "").indexOf("text") + 5, (param.treeData[index] + "").length - 1));
					$("#" + param.dictHiddenId).val(param.initVal+";"+param.dictObject.dictArray[i][7]);
					break;
				}
			}
	    }
	    $("#" + param.dictShowId).focus(function(e) {
	    	var isShow = $("#" + param.dictSelectDivId).is(":visible");
	    	Dictionary.hideExpand(Dictionary.dictSelectDivClass);
	    	if (isShow) {
	    		Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, param.dictContainerReferenceObjectId, function() {});
	    		Dictionary.isHiddenDictTree = true;
	    		e.preventDefault();
	    	}
		});
		$("#" + param.dictShowId).change(function() {
    		$("#" + param.dictHiddenId).val("");
    	});
	    $("#" + param.dictShowId).keyup(function(e) {
			if (Dictionary.dictFilterTimer[param.dictShowId]) {
		        window.clearTimeout(Dictionary.dictFilterTimer[param.dictShowId]);
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }
			Dictionary.dictFilterTimer[param.dictShowId] = window.setTimeout(function() {
				Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, param.dictContainerReferenceObjectId, function() {});
				Dictionary.isHiddenDictTree = true;
				Dictionary.locateNode($("#" + param.dictShowId).val(), param.dictObject, treeObject, param.dictShowId);
				e.preventDefault();
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }, SysConfig.DICT_FILTER_TIMER);
		});
	    this.setSelectedXqghNode(param.initVal, param.dictObject, treeObject);
	    $("#" + param.dictShowId).click(function(e) {
	    	/*if (Dictionary.dictFilterTimer[param.dictShowId]) {
		        window.clearTimeout(Dictionary.dictFilterTimer[param.dictShowId]);
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }
			Dictionary.dictFilterTimer[param.dictShowId] = window.setTimeout(function() {
				Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, param.dictContainerReferenceObjectId, function() {});
				Dictionary.isHiddenDictTree = true;
				Dictionary.setSelectedNode($("#" + param.dictHiddenId).val(), param.dictObject, treeObject);
				e.preventDefault();
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }, SysConfig.DICT_FILTER_TIMER);*/
	    	if (Dictionary.dictFilterTimer[param.dictShowId]) {
		        window.clearTimeout(Dictionary.dictFilterTimer[param.dictShowId]);
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }
			Dictionary.dictFilterTimer[param.dictShowId] = window.setTimeout(function() {
				Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, param.dictContainerReferenceObjectId, function() {});
				Dictionary.isHiddenDictTree = true;
				Dictionary.locateNode($("#" + param.dictShowId).val(), param.dictObject, treeObject, param.dictShowId);
				e.preventDefault();
		        delete Dictionary.dictFilterTimer[param.dictShowId];
		    }, SysConfig.DICT_FILTER_TIMER);
    	});
	    
	    $("#" + param.dictSelectDivId).mousemove(function() {
			if ($("#" + param.dictSelectDivId).is(":visible")) {
				Dictionary.isHiddenDictTree = false;
			}
		}).mouseout(function() {
			if ($("#" + param.dictSelectDivId).is(":visible")) {
				Dictionary.isHiddenDictTree = true;
			}
		});
	    
	    if ($.isFunction(afterCreateCallback)) {
	    	afterCreateCallback();// 执行字典生成完成后的回调函数
    	}
	},
	/**
	 * 设置选中的树节点
	 * @param {String} selectedValue 树节点选中的值
	 * @param {Object} dictObject 字典对象
	 * @param {Object} treeObject 树对象
	 */
	setSelectedNode : function(selectedValue, dictObject, treeObject) {
		treeObject.expandLevel(1);
	    var found = false;
	    try {
	    	if (("undefined" != typeof selectedValue) && (selectedValue != "")) {
	    		if ("undefined" != typeof treeObject.currentNode && treeObject.currentNode != null) {
	    			if (treeObject.currentNode.id != selectedValue) {
	    				for (var i = 0; i < dictObject.dictArray.length; i++) {
	    	    			if (selectedValue == dictObject.dictArray[i][1]) {
	    	    				found = true;
	    					    var focusNodePath = dictObject.dictArray[i][6] + "_" + dictObject.dictArray[i][1];
	    					    var upperNodeIds = dictObject.dictArray[i][6].split("_");// 上层节点id数组
	    					    for (var j = 0; j < upperNodeIds.length; j++) {
	    					    	var upperNode = treeObject.getNodeById(upperNodeIds[j]);
	    					    	upperNode.expandLevel(1);
	    					    }
	    					    treeObject.focusNodeByPath(focusNodePath);
	    					 
	    					    break;
	    				    }
	    			    }
	    			} else {
	    				found = true;
	    			}
	    		}
	    	}
	    	if (!found) {
	        	if ("undefined" != typeof treeObject.rootNode.childNodes[0] && treeObject.rootNode.childNodes[0] != null 
		        		&& "undefined" != typeof treeObject.rootNode.childNodes[0].childNodes[0] && treeObject.rootNode.childNodes[0].childNodes[0] != null) {
	        		treeObject.focusNodeByPath("RO" + "_" + treeObject.rootNode.childNodes[0].childNodes[0].id);
	        	} else {
	        		treeObject.focusNodeByPath("-1_RO");
	        	}
        	}
	    	//setTimeout("$('#" + dictShowId + "').focus();", 1500);
	    }
	  
	    catch (err) {}
	},
	
	
	
	
	
	/**
	 * 设置选中的树节点
	 * @param {String} selectedValue 树节点选中的值
	 * @param {Object} dictObject 字典对象
	 * @param {Object} treeObject 树对象
	 */
	setSelectedZyglNode : function(selectedValue, dictObject, treeObject) {
		treeObject.expandLevel(1);
		treeObject.expandAll(dictObject.dictArray[0][1]);
	    var found = false;
	    var focusNodePath ="";
	    try {
	    	treeObject.focusNodeByPath(focusNodePath);
	    	if (("undefined" != typeof selectedValue) && (selectedValue != "")) {
	    		if ("undefined" != typeof treeObject.currentNode && treeObject.currentNode != null) {
	    			if (treeObject.currentNode.id != selectedValue) {
	    				for (var i = 0; i < dictObject.dictArray.length; i++) {
	    	    			if (selectedValue == dictObject.dictArray[i][1]) {
	    	    				found = true;
	    					     focusNodePath = dictObject.dictArray[i][6] + "_" + dictObject.dictArray[i][1];
	    					    var upperNodeIds = dictObject.dictArray[i][6].split("_");// 上层节点id数组
	    					    for (var j = 0; j < upperNodeIds.length; j++) {
	    					    	var upperNode = treeObject.getNodeById(upperNodeIds[j]);
	    					    	upperNode.expandLevel(1);
	    					    }
//	    					    alert("wo:"+focusNodePath);
	    					 
	    					    break;
	    				    }
	    	    			
	    			    }
//	    				alert(focusNodePath);
   	    			   treeObject.focusNodeByPath(focusNodePath);
	    			} else {
	    				found = true;
	    			}
	    		}
	    	}
//	    	alert(found);
	    	if (!found) {
	        	if ("undefined" != typeof treeObject.rootNode.childNodes[0] && treeObject.rootNode.childNodes[0] != null 
		        		&& "undefined" != typeof treeObject.rootNode.childNodes[0].childNodes[0] && treeObject.rootNode.childNodes[0].childNodes[0] != null) {
	        		treeObject.focusNodeByPath("RO" + "_" + treeObject.rootNode.childNodes[0].childNodes[0].id);
	        	} else {
	        		treeObject.focusNodeByPath("-1_RO");
	        	}
        	}
	    	//setTimeout("$('#" + dictShowId + "').focus();", 1500);
	    }
	  
	    catch (err) {}
	},
	
	
	

	/**
	 * 设置选中的树节点
	 * @param {String} selectedValue 树节点选中的值
	 * @param {Object} dictObject 字典对象
	 * @param {Object} treeObject 树对象
	 */
	setSelectedXqghNode : function(selectedValue, dictObject, treeObject) {
//		treeObject.expandLevel(1);
//		treeObject.expandAll(dictObject.dictArray[0][1]);
	    var found = false;
	    var focusNodePath ="";
	    try {
	    	treeObject.focusNodeByPath(focusNodePath);
	    	if (("undefined" != typeof selectedValue) && (selectedValue != "")) {
	    		if ("undefined" != typeof treeObject.currentNode && treeObject.currentNode != null) {
	    			if (treeObject.currentNode.id != selectedValue) {
	    				for (var i = 0; i < dictObject.dictArray.length; i++) {
	    	    			if (selectedValue == dictObject.dictArray[i][1]) {
	    	    				found = true;
	    					     focusNodePath = dictObject.dictArray[i][6] + "_" + dictObject.dictArray[i][1];
	    					    var upperNodeIds = dictObject.dictArray[i][6].split("_");// 上层节点id数组
	    					    for (var j = 0; j < upperNodeIds.length; j++) {
	    					    	var upperNode = treeObject.getNodeById(upperNodeIds[j]);
	    					    	upperNode.expandLevel(1);
	    					    }
//	    					    alert("wo:"+focusNodePath);
	    					 
	    					    break;
	    				    }
	    	    			
	    			    }
//	    				alert(focusNodePath);
   	    			   treeObject.focusNodeByPath(focusNodePath);
	    			} else {
	    				found = true;
	    			}
	    		}
	    	}
//	    	alert(found);
	    	if (!found) {
	        	if ("undefined" != typeof treeObject.rootNode.childNodes[0] && treeObject.rootNode.childNodes[0] != null 
		        		&& "undefined" != typeof treeObject.rootNode.childNodes[0].childNodes[0] && treeObject.rootNode.childNodes[0].childNodes[0] != null) {
	        		treeObject.focusNodeByPath("RO" + "_" + treeObject.rootNode.childNodes[0].childNodes[0].id);
	        	} else {
	        		treeObject.focusNodeByPath("-1_RO");
	        	}
        	}
	    	//setTimeout("$('#" + dictShowId + "').focus();", 1500);
	    }
	  
	    catch (err) {}
	},
	/**
	 * 设置树节点选中的值
	 * @param {Object} nodeObject 树节点
	 * @param {String} dictShowId 显示字典词条的控件id
	 * @param {String} dictSelectDivId 字典选择div id
	 */
	setSelectedValue : function(nodeObject, dictShowId, dictSelectDivId) {
		if (nodeObject.id != "RO") {// 非根节点
	        var target = $("#" + dictShowId);
	        var expand = $("#" + dictSelectDivId);
	        target.val(nodeObject.text);
	        target.prev().val(nodeObject.id);
            expand.hide();
	        this.exitTree(dictShowId);// 退出树事件
		}
	},
	
	
	/**
	 * 设置树节点选中的值
	 * @param {Object} nodeObject 树节点
	 * @param {String} dictShowId 显示字典词条的控件id
	 * @param {String} dictSelectDivId 字典选择div id
	 */
	setZyglSelectedValue : function(nodeObject, dictShowId, dictSelectDivId) {
		if (nodeObject.id != "RO") {// 非根节点
	        var target = $("#" + dictShowId);
	        var expand = $("#" + dictSelectDivId);
	        target.val(nodeObject.text);
	        target.prev().val(nodeObject.id);
	        if ("undefined" != typeof EZ_STD_LAYERS_LAYER.dictArray && EZ_STD_LAYERS_LAYER.dictArray != null && EZ_STD_LAYERS_LAYER.dictArray != "") {
	        for (var i = 0; i < EZ_STD_LAYERS_LAYER.dictArray.length; i++) {
	    			if (nodeObject.id == EZ_STD_LAYERS_LAYER.dictArray[i][1]) {
	    				target.prev().val(nodeObject.id+";"+EZ_STD_LAYERS_LAYER.dictArray[i][7]);
	    		 break;
	    			}	
	    			}
	        }	   	
	        this.exitTree(dictShowId);// 退出树事件
		}
	},
	
	
	/**
	 * 设置树节点选中的值
	 * @param {Object} nodeObject 树节点
	 * @param {String} dictShowId 显示字典词条的控件id
	 * @param {String} dictSelectDivId 字典选择div id
	 */
	setGpsSelectedValue : function(nodeObject, dictShowId, dictSelectDivId) {
		if (nodeObject.id != "RO") {// 非根节点
	        var target = $("#" + dictShowId);
	        var expand = $("#" + dictSelectDivId);
	        target.val(nodeObject.text);
	        target.prev().val(nodeObject.id);
	        if ("undefined" != typeof T_GPS_ZZJG.dictArray && T_GPS_ZZJG.dictArray != null && T_GPS_ZZJG.dictArray != "") {
		        for (var i = 0; i < T_GPS_ZZJG.dictArray.length; i++) {
		    			if (nodeObject.id == T_GPS_ZZJG.dictArray[i][1]) {
		    				target.prev().val(nodeObject.id+";"+T_GPS_ZZJG.dictArray[i][7]);
		    		 break;
		    			}	
		    			}
		        }   	
	        this.exitTree(dictShowId);// 退出树事件
		}
	},
	/**
	 * 退出树事件
	 * @param {String} dictShowId 显示字典词条的控件id
	 */
	exitTree : function(dictShowId) {
		var realOnExit = $("#" + dictShowId).attr("onExit");
		try {
			if ("undefined" != typeof realOnExit && realOnExit != null && realOnExit != "") {
				eval(realOnExit);
			}
		} catch(err) {
			alert("执行事件 " + realOnExit + " 有错误发生: \n" + "\n错误名称: " + err.name + " \n错误行号: " + (err.number & 0xFFFF) + " \n错误信息: " + err.message);
		}
	},
	
	/**
	 * 根据输入的值定位树节点
	 * @param {String} enterValue 字典input输入的值
	 * @param {Object} dictObject 字典对象
	 * @param {Object} treeObject 树对象
	 * @param {String} dictShowId 显示字典词条的控件id
	 */
	locateNode : function(enterValue, dictObject, treeObject, dictShowId) {
		treeObject.expandLevel(1);
	
	    var found = false;
	    try {
	    	if (("undefined" != typeof enterValue) && (enterValue != "")) {
	    		enterValue = enterValue.toUpperCase();
	    		if ("undefined" != typeof treeObject.currentNode && treeObject.currentNode != null) {
	    			if (treeObject.currentNode.text.indexOf(enterValue) == -1) {
	    				found = true;
	    				for (var i = 0; i < dictObject.dictArray.length; i++) {
	    					var dm = dictObject.dictArray[i][1];
	    					var ct = dictObject.dictArray[i][2];
	    					var py = dictObject.dictArray[i][3];
	    					var wb = dictObject.dictArray[i][4];
	    					var dmLength = (enterValue.length > dm.length ? dm.length : enterValue.length);
	    	        		var ctLength = (enterValue.length > ct.length ? ct.length : enterValue.length);
	    	        		var pyLength = (enterValue.length > py.length ? py.length : enterValue.length);
	    	        		var wbLength = (enterValue.length > wb.length ? wb.length : enterValue.length);
	    	        		if (py.substring(0, pyLength).toUpperCase() == enterValue || dm.substring(0, dmLength).toUpperCase() == enterValue 
	    	    				|| ct.substring(0, ctLength).toUpperCase() == enterValue || wb.substring(0, wbLength).toUpperCase() == enterValue) {
	    	    			
	    					    var focusNodePath = dictObject.dictArray[i][6] + "_" + dictObject.dictArray[i][1];
	    					    var upperNodeIds = dictObject.dictArray[i][6].split("_");// 上层节点id数组
	    					    for (var j = 0; j < upperNodeIds.length; j++) {
	    					    	var upperNode = treeObject.getNodeById(upperNodeIds[j]);
	    					    	upperNode.expandLevel(1);
	    					    }
//	    					    alert(focusNodePath);
	    					    treeObject.focusNodeByPath(focusNodePath);
	    					    break;
	    				    }
	    			    }
	    			} else {
	    				found = true;
	    			}
	    		}
	    	}
	    	if (!found) {
	        	if ("undefined" != typeof treeObject.rootNode.childNodes[0] && treeObject.rootNode.childNodes[0] != null 
	        		&& "undefined" != typeof treeObject.rootNode.childNodes[0].childNodes[0] && treeObject.rootNode.childNodes[0].childNodes[0] != null) {
	        		treeObject.focusNodeByPath("RO" + "_" + treeObject.rootNode.childNodes[0].childNodes[0].id);
	        	} else {
	        		treeObject.focusNodeByPath("-1_RO");
	        	}
	        }
	    	setTimeout("$('#" + dictShowId + "').focus();", 1500);
	    }
	    catch (err) {}
	},
	
	/**
	  * 树节点单击事件
	  * @param {Object} nodeObject 树节点
	  * @param useCheckbox 是否是有checkbox的树
	  */
	treeNodeClick : function(nodeObject,useCheckbox) {
		if(!useCheckbox){
			var tempNode = nodeObject.parentNode;
			var flag = true;
			while (flag) {
				if (tempNode.id != "RO") {
					tempNode = tempNode.parentNode;
				} else {
					flag = false;
				}
			}
			var isLeaf = tempNode.get("isLeaf");
			var idArray = tempNode.get("inputIdString").split("■");
			var isDisplay = tempNode.get("isDisplay");
			if (isLeaf == "true") {
			 	if (!nodeObject.hasChild) {// 只能选叶子节点
			 		if (isDisplay == "true") {
			 			this.setZyglSelectedValue(nodeObject, idArray[0], idArray[1]);
			 		}
			 		if (isDisplay == "GPS") {
			 			this.setZyglSelectedValue(nodeObject, idArray[0], idArray[1]);
			 		}
			 		else{
			 			this.setGpsSelectedValue(nodeObject, idArray[0], idArray[1]);
			 		}
					
			    }
			} else {
				
				if (isDisplay == "true") {
		 			this.setZyglSelectedValue(nodeObject, idArray[0], idArray[1]);
		 		}
				if (isDisplay == "GPS") {
		 			this.setGpsSelectedValue(nodeObject, idArray[0], idArray[1]);
		 		}
		 		else{
		 			this.setSelectedValue(nodeObject, idArray[0], idArray[1]);
		 		}
			}
		}else{//checkbox树单击
			if(nodeObject.checked){
				nodeObject.check(false);//checkbox status cancel checked
				nodeObject.unfocus();
			}else{
				nodeObject.check(true);
			}
		}
		
	},
    /**
     * 复选框树选中后事件
     * @param {Object} treeNode 树节点
     */
    treeNodeChecked:function(treeNode){
    	if(typeof Jqxq.checkXqPolygon[treeNode.id] != "undefined"){ //已存在辖区   		
    		if(treeNode.expanded){//展开父节点时删除已有辖区
    			Jqxq.remove_xq(treeNode.id);
    		}
    		return false;
    	}
    	if(typeof treeNode.childNodes !="undefined"&&treeNode.childNodes.length>0){//有子节点时
    		return false; //不对父节点的边界上图
    	}
		GeoQuery.getOrganizationBoundaryCoordinates(treeNode.id, function(data){
				var zzjgdm=treeNode.id;
				Jqxq.add_xq(zzjgdm,data);//边界上图
		});
    },
    /**
     * 复选框取消选中后事件
     * @param treeNode
     */
    treeNodeUnChecked:function(treeNode){
    	if(typeof Jqxq.checkXqPolygon[treeNode.id] != "undefined"){//删除辖区
    		Jqxq.remove_xq(treeNode.id);
    	}
    },

	/**
	 * 初始化字典列表
	 * @param {Object} param JSON对象（包括：url 请求url，data请求得参数（包括：zdbh 字典编号（字典表名）。），dictShowId 显示字典词条的input控件id，dictContainerReferenceObjectId 字典下拉容器参照物id，initVal 初始值。）
	 * @param {Function} callback 字典选择退出后的回调函数
	 * @param {Function} afterInitCallback 字典初始化完成的回调函数
	 */
	initDictionaryList : function(param, callback, afterInitCallback) {
		SysTool.ajax({
  			url: param.url,
      		data: param.data		
	    }, function(data) {
	    	Dictionary.createDictionaryList(param.dictShowId, param.dictContainerReferenceObjectId, param.initVal, data, callback);
	    	if ($.isFunction(afterInitCallback)) {
	    		afterInitCallback(data);
	    	}
		});
	},
	
	/**
	 * 生成字典列表
	 * @param {String} dictShowId 显示字典词条的input控件id
	 * @param {String} dictContainerReferenceObjectId 字典下拉容器参照物id
	 * @param {String} initVal 初始值
	 * @param {Object} data JSON对象
	 * @param {Function} callback 回调函数
	 */
	createDictionaryList : function (dictShowId, dictContainerReferenceObjectId, initVal, data, callback) {
		if ("undefined" === typeof dictContainerReferenceObjectId) {
    		dictContainerReferenceObjectId = "tips";
    	}
		var htmlStr = "<div id='" + dictShowId + "Div'  class='selct_div' style='max-width:200px;overflow:auto;'>";
		htmlStr += "<ul class='selct_ul'>";
		for (var i = 0; i < data.list.length; i++) {
			var dictItem = data.list[i];
			if ("undefined" != typeof initVal && initVal != null && initVal != "") {
				if (dictItem.dm.split(",")[0] == initVal) {
					$("#" + dictShowId).val(dictItem.ct);
					$("#" + dictShowId).prev().val(dictItem.dm);
				}
			}
			htmlStr += "<li class='li1'><span class='clear_span'>" + dictItem.dm + "|</span>" + dictItem.ct + "<span class='clear_span'>|" + dictItem.py + "|" + dictItem.wb + "</span>" + "</li>";
		}
		htmlStr += "</ul>";
		htmlStr += "</div>";
		if ("undefined" != typeof $("#" + dictShowId + "Div") && $("#" + dictShowId + "Div") != null) {
			$("#" + dictShowId + "Div").remove();
		}
		$("#" + dictContainerReferenceObjectId).append(htmlStr);
		//此段原来为下拉框宽度大小和下拉框中值最大的长度一致。  现在样式变更为滚动条，屏蔽掉! 
//		var listWidth = this.calculateListWidth(data.list);// 计算列表宽度
//		var dictShowWidth = $("#" + dictShowId).width();// 显示字典词条的input控件宽度
//		listWidth = (listWidth >= (dictShowWidth + this.dictShowWidthOffsetPx) ? listWidth : (dictShowWidth + this.dictShowWidthOffsetPx));
//		$("#" + dictShowId + "Div").width(listWidth);
		
		$("#" + dictShowId).focus(function() {
			var isShow = $("#" + dictShowId + "Div").is(":visible");
			Dictionary.hideExpand(Dictionary.dictSelectDivClass);
	    	if (isShow) {
	    		Dictionary.showExpand(dictShowId, dictShowId + "Div", Dictionary.dictSelectDivClass, dictContainerReferenceObjectId, callback);
	    	}
		});
		$("#" + dictShowId).keyup(function() {
			if (Dictionary.dictFilterTimer[dictShowId]) {
		        window.clearTimeout(Dictionary.dictFilterTimer[dictShowId]);
		        delete Dictionary.dictFilterTimer[dictShowId];
		    }
			Dictionary.dictFilterTimer[dictShowId] = window.setTimeout(function() {
		    	Dictionary.showExpand(dictShowId, dictShowId + "Div", Dictionary.dictSelectDivClass, dictContainerReferenceObjectId, callback);
				Dictionary.search(dictShowId, dictShowId + "Div");
		        delete Dictionary.dictFilterTimer[dictShowId];
		    }, SysConfig.DICT_FILTER_TIMER);
		});
		$("#" + dictShowId).keydown(function(e) {
	        switch(e.which) {    
	            // user presses the "↑"    
	            case 38: Dictionary.focusExpand(dictShowId + "Div");
	            	     e.preventDefault();
	                     break; 
	            
	            // user presses the "↓"    
	            case 40: Dictionary.focusExpand(dictShowId + "Div");
	            		 e.preventDefault();
	                     break; 
	        }    
    	});
    	$("#" + dictShowId).change(function() {
    		$("#" + dictShowId).prev().val("");
    	});
    	$("#" + dictShowId).click(function(e) {
    		Dictionary.showExpand(dictShowId, dictShowId + "Div", Dictionary.dictSelectDivClass, dictContainerReferenceObjectId, callback);
    	});
		$("#" + dictShowId + "Div").keydown(function(e) {
	        switch(e.which) {    
	        	// user presses the "Enter"    
	            case 13: Dictionary.pressEnterkeyEvent(dictShowId, dictShowId + "Div", Dictionary.dictSelectDivClass, callback);    
	                     break; 
	                        
	            // user presses the "↑"    
	            case 38: Dictionary.pressUpkeyOrDownkeyEvent(dictShowId + "Div", 1);
	            		 e.preventDefault();
	            		 break; 
	            
	            // user presses the "↓"    
	            case 40: Dictionary.pressUpkeyOrDownkeyEvent(dictShowId + "Div", 0);
	                     e.preventDefault();
	                     break; 
	        }    
    	});
	},
	
	/**
	 * 设置下拉字典值
	 * @param {Object} param JSON对象（dictShowId 显示字典词条的input控件id，setVal 设置的值。）
	 */
	setDictionaryListValue : function(param) {
		$("#" + param.dictShowId + "Div").find("li").each(function(i) {
			if ($(this).text().indexOf(param.setVal) != -1) {
				$("#" + param.dictShowId).val($(this).text().split("|")[1]);
				$("#" + param.dictShowId).prev().val($(this).text().split("|")[0]);
				return false;
			}
		});
	},
	/**
	 * 清理字典组件
	 * @param ids 清理组件ID
	 */
    clearDictionaryListValue : function(ids){
    	$.each(ids, function(i, id) {
			$('#' + id + 'mc').val('');
			$('#' + id + 'dm').val('');
			$('#' + id + 'mcDiv').html('');
		});
    },
	
	/**
	 * 隐藏下拉字典选项
	 * @param {Object} param JSON对象（dictShowId 显示字典词条的input控件id，filter 过滤器。）
	 * @param {Function} afterHideCallback 回调函数
	 */
	hideDictionaryListItem : function(param, afterHideCallback) {
		$("#" + param.dictShowId + "Div").find("li").each(function(index) {
			for (var i = 0; i < param.filter.length; i++) {
				if ($(this).text().indexOf(param.filter[i]) != -1) {
					var hideDictionaryListItemHtml ="<li class='li1'>" + $(this).html() + "</li>";
					var hideDictionaryListItemText = $(this).text();
					$(this).remove();
					if ($.isFunction(afterHideCallback)) {
						afterHideCallback({"html": hideDictionaryListItemHtml, "text": hideDictionaryListItemText});
			    	}
					break;
				}
			}
		});
	},
	
	/**
	 * 显示下拉字典选项
	 * @param {Object} param JSON对象（dictShowId 显示字典词条的input控件id，html 下拉字典选项html。）
	 */
	showDictionaryListItem : function(param) {
		$("#" + param.dictShowId + "Div").find("ul").eq(0).append(param.html);
	},

	/**
	 * 计算列表宽度
	 * @param {Object} list 字典数据列表
	 */
	calculateListWidth : function(list) {
		var listWidth = 0;// 列表宽度
		if ("undefined" != typeof list && list != null) {
			var mcMaxLength = 0;// 字典词条最大长度
			var tempLength = 0;// 字典词条长度临时变量
			for (var i = 0; i < list.length; i++) {
		    	// 获取字符串实际长度（一个中文为两个字符长度，一个英文或数字为一个字符长度）
		    	tempLength = this.getStringRealLength(list[i].ct);
				if (tempLength > mcMaxLength) {
					mcMaxLength = tempLength;
				}
		    }
		    // 字体大小为12px,滚动条加30px
			listWidth = (mcMaxLength + 3) * 6 + 30;
		}
		
		return listWidth;
	},
	
	/**
	 * 获取字符串实际长度（一个中文为两个字符长度，一个英文或数字为一个字符长度）
	 * @param {String} sourceStr 需要处理的字符串
	 */
	getStringRealLength : function(sourceStr) {
	    var realLength = 0;
	    if ("undefined" != typeof sourceStr && sourceStr != null && sourceStr != "") {
		    var charCode = -1;
		    for (var i = 0; i < sourceStr.length; i++) {
		        charCode = sourceStr.charCodeAt(i);
		        if (charCode >= 0 && charCode <= 128) {// 英文或数字
		        	realLength += 1;
		        } else {// 中文
		        	realLength += 2;
		        }
		    }
		}
	    
	    return realLength;
	},
	
	/**
	 * 初始化字典列表
	 * @param {Object} param JSON对象（包括：zdbh 字典编号（字典表名），zdmc 字典名称，dictDataDivId 放字典数据的DIV id）
	 * @param {Function} callback 回调函数
	 */
	initDictList : function(param, callback) {
		SysTool.ajax({
  			url: "dictionary/getDictListJSON.f",
      		data: { "zdbh": param.zdbh, "zdmc": param.zdmc, "xzqh": ("undefined" == typeof param.xzqh ? "" : param.xzqh), "dldm": ("undefined" == typeof param.dldm ? "" : param.dldm) }		
	    }, function(data) {
      		$("#" + param.dictDataDivId).html(data[param.zdbh]);
      		callback();
		});
	},
	
	/**
	 * 生成字典列表
	 * @param {Object} param JSON对象（包括：dictArray 字典数据数组，listWidth 字典列表宽度，dictShowId 显示字典词条的控件id，dictSelectDivId 字典选择DIV id。）
	 * @param {Function} callback 回调函数
	 */
	createDictList : function (param, callback) {
		var htmlStr = "<ul class='selct_ul'>";
		for (var i = 0; i < param.dictArray.length; i++) {
			var dictItem = param.dictArray[i];//[0,'1','一级','YJ','','1\xA0|\xA0']
			htmlStr += "<li class='li1'><span class='clear_span'>" + dictItem[1] + "|</span>" + dictItem[2] + "<span class='clear_span'>|" + dictItem[3] + "</span>" + "</li>";
		}
		htmlStr += "</ul>";
		$("#" + param.dictSelectDivId).width(param.listWidth);
		$("#" + param.dictSelectDivId).html(htmlStr);
		
		$("#" + param.dictShowId).focus(function() {
			var isShow = $("#" + param.dictSelectDivId).is(":visible");
			Dictionary.hideExpand(Dictionary.dictSelectDivClass);
	    	if (isShow) {
	    		Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, callback);
	    	}
		});
		$("#" + param.dictShowId).keyup(function() {
			Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, callback);
			Dictionary.search(param.dictShowId, param.dictSelectDivId);
		});
		$("#" + param.dictShowId).keydown(function(e) {
	        switch(e.which) {    
	            // user presses the "↑"    
	            case 38: Dictionary.focusExpand(param.dictSelectDivId);    
	                     break; 
	            
	            // user presses the "↓"    
	            case 40: Dictionary.focusExpand(param.dictSelectDivId);    
	                     break; 
	        }    
    	});
    	$("#" + param.dictShowId).change(function() {
    		$("#" + param.dictShowId).prev().val("");
    	});
    	$("#" + param.dictShowId).click(function(e) {
    		Dictionary.showExpand(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, callback);
    	});
		$("#" + param.dictSelectDivId).keydown(function(e) {
	        switch(e.which) {    
	        	// user presses the "Enter"    
	            case 13: Dictionary.pressEnterkeyEvent(param.dictShowId, param.dictSelectDivId, Dictionary.dictSelectDivClass, callback);    
	                     break; 
	                        
	            // user presses the "↑"    
	            case 38: Dictionary.pressUpkeyOrDownkeyEvent(param.dictSelectDivId, 1);    
	                     break; 
	            
	            // user presses the "↓"    
	            case 40: Dictionary.pressUpkeyOrDownkeyEvent(param.dictSelectDivId, 0);    
	                     break; 
	        }    
    	});
	},
	
	/**
	 * 显示展开
	 * @param {String} dictShowId 显示字典词条的控件id
	 * @param {String} dictSelectDivId 字典选择div id
	 * @param {String} dictSelectDivClass 字典选择div class
	 * @param {String} dictContainerReferenceObjectId 字典下拉容器参照物id
	 * @param {Function} callback 回调函数
	 */
	showExpand : function(dictShowId, dictSelectDivId, dictSelectDivClass, dictContainerReferenceObjectId, callback) {
        // 关掉其它弹出的层
		this.hideExpand(dictSelectDivClass);
		this.hideExpand(Dictionary.dictTreeDivClass);

        //判断是否为IE
        var isIE = (! +[1, ]);
        
        var dictContainerReferenceObject = $("#" + dictContainerReferenceObjectId);
        var expand = $("#" + dictSelectDivId);
        var target = $("#" + dictShowId);
        var dictContainerReferenceObjectTop = dictContainerReferenceObject.offset().top;
        var dictContainerReferenceObjectLeft = dictContainerReferenceObject.offset().left;
        var targetTop = target.offset().top;
        var targetLeft = target.offset().left;
        var dx = 0;
        if (isIE) {
            dx = -2;
        }
        else {
            dx = 0;
        }
        expand.css("left", targetLeft-dictContainerReferenceObjectLeft + dx);
        if (isIE) {
            dx = 4;
        }
        else {
            dx = 6;
        }
        expand.css("top", targetTop-dictContainerReferenceObjectTop + target.height() + dx);
        expand.show();

        // 每个li点击时赋值
        $("#" + dictSelectDivId).find("li").each(function(i) {
        	$(this).unbind("click"); //移除绑定的click事件
        	$(this).unbind("mouseover"); //移除绑定的mouseover事件
        	$(this).unbind("mouseout"); //移除绑定的mouseout事件
            $(this).show().click(function () {
        		target.val($(this).text().split('|')[1]);
                target.prev().val($(this).text().split('|')[0]);
                expand.hide();
                callback();// 字典选择退出后回调函数
            });
            if (target.val() == "") {
            	if (i == 0) {
                	$(this).removeClass("li1");
                	$(this).addClass("li2");
                } else {
                	if ($(this).attr("class") == "li2") {
                		$(this).removeClass("li2");
                    	$(this).addClass("li1");
                	}
                }
            	$(this).mouseover(function() {
        			$(this).addClass("li2");
        		});
        		$(this).mouseout(function() {
        			$(this).removeClass("li2");
        			$(this).addClass("li1");
        		});
            } else {
            	if ($(this).text().split('|')[1].toUpperCase() == target.val().toUpperCase()) {
                	$(this).removeClass("li1");
                	$(this).addClass("li2");
                } else {
                	if ($(this).attr("class") == "li2") {
                		$(this).removeClass("li2");
                    	$(this).addClass("li1");
                	}
                	$(this).mouseover(function() {
            			$(this).addClass("li2");
            		});
            		$(this).mouseout(function() {
            			$(this).removeClass("li2");
            			$(this).addClass("li1");
            		});
                }
            }
        });
    },
    
    /**
	 * 隐藏展开
	 * @param {String} dictSelectDivClass 字典选择div class
	 */
	hideExpand : function(dictSelectDivClass) {
        // 关掉其它弹出的层
        if (dictSelectDivClass != undefined) {
            $("." + dictSelectDivClass).hide();
        }
    },
    
    /**
	 * 收索过滤字典项
	 * @param {String} dictShowId 显示字典词条的控件id
	 * @param {String} dictSelectDivId 字典选择div id
	 */
    search : function(dictShowId, dictSelectDivId) {
        var expand = $("#" + dictSelectDivId);
        var src = $("#" + dictShowId);

        var li = expand.find("li");
        var v = src.val().toUpperCase();

        li.each(function (i) {
        	if (v.length >= 1) {
        		var dm = $(this).text().split("|")[0];
        		var ct = $(this).text().split("|")[1];
        		var py = $(this).text().split("|")[2];
        		var dmLength = (v.length > dm.length ? dm.length : v.length);
        		var ctLength = (v.length > ct.length ? ct.length : v.length);
        		var pyLength = (v.length > py.length ? py.length : v.length);
                if (py.substring(0, pyLength).toUpperCase() == v || dm.substring(0, dmLength).toUpperCase() == v || ct.substring(0, ctLength).toUpperCase() == v) {
                    $(this).show();
                } else {
                	$(this).hide();
                }
            }
            if (v.length <= 0) {
                $(this).show();
            }
        });
        expand.find("li:visible").each(function(i) {
    		if (i == 0) {
    			if ($(this).attr("class") == "li1") {
    				$(this).removeClass("li1");
                	$(this).addClass("li2");
    			}
    		} else {
    			if ($(this).attr("class") == "li2") {
    				$(this).removeClass("li2");
                	$(this).addClass("li1");
    			}
    		}
        });
        expand.find("li:hidden").each(function(i) {
			if ($(this).attr("class") == "li2") {
				$(this).removeClass("li2");
	        	$(this).addClass("li1");
			}
        });
    },
    
    /**
	 * 按键盘向上向下键事件
	 * @param {String} dictSelectDivId 字典选择div id
	 * @param {int} upOrDown 上或下（0：下，1：上。）
	 */
    pressUpkeyOrDownkeyEvent : function(dictSelectDivId, upOrDown) {
    	var liHeight = 0;
        $("#" + dictSelectDivId).find("li:visible").each(function(i) {
        	if ($(this).attr("class") == "li2") {
            	if (upOrDown == 1) {// 向上
            		if (i > 0) {
            			if (liHeight == 0) {
            				liHeight = $(this).height();
            			}
            			if (i > 0) {
        					$("#" + dictSelectDivId).scrollTop(liHeight * (i - 1));
            			} else {
            				$("#" + dictSelectDivId).scrollTop(0);
            			}
            			$(this).removeClass("li2");
                    	$(this).addClass("li1");
            			$(this).prev().removeClass("li1");
                		$(this).prev().addClass("li2");
            		}
            	} else {// 向下
            		if (i < ($("#" + dictSelectDivId).find("li:visible").size() - 1)) {
            			if (liHeight == 0) {
            				liHeight = $(this).height();
            			}
            			if (i < ($("#" + dictSelectDivId).find("li:visible").size() - 1)) {
            				$("#" + dictSelectDivId).scrollTop(liHeight * (i + 1));
            			} else {
            				$("#" + dictSelectDivId).scrollTop(liHeight * ($("#" + dictSelectDivId).find("li:visible").size() - 1));
            			}
            			$(this).removeClass("li2");
                    	$(this).addClass("li1");
            			$(this).next().removeClass("li1");
                		$(this).next().addClass("li2");
            		}
            	}
            	return false;
        	}
        });
    },
    
    /**
	 * 按键盘Enter键事件
	 * @param {String} dictShowId 显示字典词条的控件id
	 * @param {String} dictSelectDivId 字典选择div id
	 * @param {String} dictSelectDivClass 字典选择div class
	 * @param {Function} callback 回调函数
	 */
    pressEnterkeyEvent : function(dictShowId, dictSelectDivId, dictSelectDivClass, callback) {
    	var expand = $("#" + dictSelectDivId);
        var target = $("#" + dictShowId);
    	
    	// 每个li点击时赋值
        $("#" + dictSelectDivId).find("li").each(function(i) {
        	if ($(this).attr("class") == "li2") {
                target.val($(this).text().split('|')[1]);
                target.prev().val($(this).text().split('|')[0]);
                expand.hide();
            }
        });
        
        // 关掉弹出的层
        if (dictSelectDivClass != undefined) {
            $("." + dictSelectDivClass).hide();
        }
        callback();
    },
    
    /**
	 * 聚焦展开
	 * @param {String} dictSelectDivId 字典选择div id
	 */
    focusExpand : function(dictSelectDivId) {
    	$("#" + dictSelectDivId).focus();
    },
    
    /**
     * 隐藏字典
     */
    hideDictionary : function() {
    	this.hideExpand(this.dictSelectDivClass);// 隐藏字典选择DIV
		if (this.isHiddenDictTree) {// 是否隐藏字典树
			this.hideExpand(this.dictTreeDivClass);// 隐藏字典选择DIV
			this.isHiddenDictTree = false;
		}
    },
    
    checkbox : {
    	/**
         * 改变复选框
         * @param id 复选框id
         * @param zdbh 字典类别编号
         * @param moduleName 模块名
         */
        changeCheckBoxStatus : function(id,zdbh,moduleName){
			 if ('checked' == $('#' + id).attr('checked')) {
				$('#' + id).attr('checked', false);
				this.deleteValue2ZhfxHidden(zdbh, $('#' + id).val(), moduleName);
			} else {
				$('#' + id).attr('checked', true);
				this.addValue2ZhfxHidden(zdbh, $('#' + id).val(), moduleName);
			}
        },
        
        /**
         * 改变隐藏域的值
         * @param id 复选框id
         * @param zdbh 字典类别编号
         * @param moduleName 模块名
         */
        changeValue2ZhfxHidden : function(id,zdbh,moduleName){
        	if ('checked' == $('#'+id).attr('checked')){
				this.addValue2ZhfxHidden(zdbh, $('#' + id).val(), moduleName);
			} else {
				this.deleteValue2ZhfxHidden(zdbh, $('#' + id).val(), moduleName);
			}
        },
        
        /**
         * 添加隐藏域的值
         * @param zdbh 字典类别编号
         * @param dm 选中checkbox的值
         * @param moduleName 模块名
         */
        addValue2ZhfxHidden : function(zdbh,dm,moduleName){
        	var value = $('#'+moduleName+'_hidden_'+zdbh).val();
        	value = value + dm + ',';
        	$('#'+moduleName+'_hidden_'+zdbh).val(value);
        },
        
        /**
         * 删除隐藏域的值
         * @param zdbh 字典类别编号
         * @param dm 选中checkbox的值
         * @param moduleName 模块名
         */
        deleteValue2ZhfxHidden : function(zdbh,dm,moduleName){
        	var value = $('#'+moduleName+'_hidden_'+zdbh).val();
        	value = value.replace(dm + ',','');
        	$('#'+moduleName+'_hidden_'+zdbh).val(value);
        },
        
        /**
         * 创建分析研判复选字典
         * @param id 需要添加如复选框的div的ID
         * @param zdbh 字典编号
         * @param moduleName 模块名 
         * @param selectedValue 默认选中的值
         * @param selectedValue 排序条件（sql规则）
         */
        creatCheckboxDic2Fxyp : function(id, zdbh, moduleName, selectedValue, orderBy){
        	var url = "dictionary/getDictListJSONOrderBy.f";
        	if (undefined == orderBy)
        	{
        		url = "dictionary/getDictionaryListJSON.f";
        	}
        	var data = {'zdbh': zdbh,'bz':orderBy};
        	if (undefined == orderBy)
        	{
        		data = {'zdbh': zdbh};
        	}
    		var param = {url : url,data:data};
    		SysTool.ajax(param, function(data){
    			var selectedValueJson = {};
    			var selectedValueArray = selectedValue.split(",");
    			for (var index = 0; index < selectedValueArray.length; index++){
    				selectedValueJson[selectedValueArray[index]] = selectedValueArray[index];
    			}
    			var checkBoxHtml = "";
    			$.each(data.list,function(key,value){
    				checkBoxHtml = checkBoxHtml + Dictionary.checkbox.creatCheckBoxHtml(moduleName, zdbh, value, selectedValueJson);
    			});
    			checkBoxHtml = checkBoxHtml + '<input type="hidden" id="'+moduleName+'_hidden_'+zdbh+'" value=""/>';
    			$("#"+id).html(checkBoxHtml);
    		});
        },
        
        /**
         * 创建警情类别和警情类型复选字典
         * @param id 需要添加如复选框的div的ID
         * @param zddm 字典代码
         * @param type 1:警情类别,2:警情类型
         * @param moduleName 模块名称
         */
        creatCheckboxFromJqxx : function(id, zddm, type, moduleName, selectedValue){
        	var url = "dictionary/jqlbDict.f";
        	if ("1" == type){
        		var data = {'zdbh': 'D_JQLB', 'zddm': zddm, 'count': 3};
        		var param = {url : url,data:data};
        		SysTool.ajax(param, function(data){
        			var selectedValueJson = {};
        			var selectedValueArray = selectedValue.split(",");
        			for (var index = 0; index < selectedValueArray.length; index++)
        			{
        				selectedValueJson[selectedValueArray[index]] = selectedValueArray[index];
        			}
        			var checkBoxHtml = "";
        			$.each(data.list,function(key,value){
        				checkBoxHtml = checkBoxHtml + Dictionary.checkbox.creatCheckBoxHtml(moduleName, 'jqlb3', value, selectedValueJson);
        			});
        			checkBoxHtml = checkBoxHtml + '<input type="hidden" id="'+moduleName+'_hidden_jqlb3" value=""/>';
        			$("#"+id).html(checkBoxHtml);
        		});
        	}else if ("2" == type){
        		url = "dict/getJqlxToJj.f";
        		var data = {'zdbh': '', 'zddm': ''};
        		var param = {url : url,data:data};
        		SysTool.ajax(param, function(data){
        			var selectedValueJson = {};
        			var selectedValueArray = selectedValue.split(",");
        			for (var index = 0; index < selectedValueArray.length; index++)
        			{
        				selectedValueJson[selectedValueArray[index]] = selectedValueArray[index];
        			}
        			var checkBoxHtml = "";
        			$.each(data.list,function(key,value){
        				value.dm = value.dm.split(",")[0];
        				checkBoxHtml = checkBoxHtml + Dictionary.checkbox.creatCheckBoxHtml(moduleName, 'jqlx', value, selectedValueJson);
        			});
        			checkBoxHtml = checkBoxHtml + '<input type="hidden" id="'+moduleName+'_hidden_jqlx" value=""/>';
        			$("#"+id).html(checkBoxHtml);
        		});
        	}
        },
        
        /**
         * 创建复选框
         * @param paramJson json对象，参数：divId, title, zdbh, moduleName, isexpand, selectedValue(xx,xx,xx),orderBy
         */
        creatCheckBox2Div : function(paramJson){
        	var checkboxId = paramJson.moduleName + '_' + paramJson.zdbh + '_div';
        	var html = this.getFieldsetHtml(checkboxId, paramJson.title, paramJson.isexpand);
        	$("#"+paramJson.divId).html(html);
        	this.creatCheckboxDic2Fxyp(checkboxId, paramJson.zdbh, paramJson.moduleName
        			, paramJson.selectedValue, paramJson.orderBy);
        },
        
        /**
         * 创建复选框（需要自写后台实现）
         * @param paramJson json对象，参数：url,data,divId, title, zdbh, moduleName, isexpand, selectedValue(xx,xx,xx)
         */
        creatCheckBox2DivByUrl : function(paramJson){
        	var param = {url:paramJson.url,data:paramJson.data};
        	SysTool.ajax(param, function(data){
        		var checkboxId = paramJson.moduleName + '_' + paramJson.zdbh + '_div';
            	var html = Dictionary.checkbox.getFieldsetHtml(checkboxId, paramJson.title, paramJson.isexpand);
            	$("#"+paramJson.divId).html(html);
            	var selectedValueJson = {};
    			var selectedValueArray = paramJson.selectedValue.split(",");
    			for (var index = 0; index < selectedValueArray.length -1; index++){
    				selectedValueJson[selectedValueArray[index]] = selectedValueArray[index];
    			}
    			var checkBoxHtml = "";
    			$.each(data.list,function(key,value){
    				checkBoxHtml = checkBoxHtml + Dictionary.checkbox.creatCheckBoxHtml(paramJson.moduleName, paramJson.zdbh, value, selectedValueJson);
    			});
    			checkBoxHtml = checkBoxHtml + '<input type="hidden" id="'+paramJson.moduleName+'_hidden_'+paramJson.zdbh+'" value=""/>';
    			$("#"+checkboxId).html(checkBoxHtml);
        	});
        },
        
        /**
         * 创建复选框
         * @param paramJson json对象，参数：divId, title, zddm, moduleName, type 1:警情类别,2:警情类型, isexpand, selectedValue(xx,xx,xx)
         */
        creatJqlbOrJqlxCheckBox2Div : function(paramJson){
        	var checkboxId = paramJson.moduleName + '_' + paramJson.zddm + '_div';
        	var html = this.getFieldsetHtml(checkboxId, paramJson.title, paramJson.isexpand);
        	$("#"+paramJson.divId).html(html);
        	this.creatCheckboxFromJqxx(checkboxId, paramJson.zddm, paramJson.type, paramJson.moduleName, paramJson.selectedValue);
        },
        
        /**
    	 * 隐藏和展开复选框DIV
    	 * @param obj 展开图标对象
    	 * @param divId 复选狂DIVID
    	 */
    	changeCheckBoxDivStauts : function(obj,divId){
    		var Jobj = $(obj);
    		if ("fieldbtn_show" == Jobj.attr("class")){
    			Jobj.addClass("fieldbtn_hide");
    			$("#"+divId).css("display","block");
    		}else if ("fieldbtn_show fieldbtn_hide" == Jobj.attr("class")){
    			Jobj.removeClass("fieldbtn_hide");
    			$("#"+divId).css("display","none");
    		}
    	},
        
        /**
         * 创建checkbox
         * @param moduleName 模块名称
         * @param zdlb 字典类别
         * @param value 构建checkbox的json对象
         * @returns {String}
         */
        creatCheckBoxHtml : function(moduleName,zdlb,value,selectedValueJson){
        	var checkBoxHtml = '';
        	var checked = "";
        	if (selectedValueJson[value.dm]){
        		checked = 'checked="checked"';
        	}
        	var checkBoxId = moduleName + "_checkBox_" + zdlb+'_'+value.dm;
    		checkBoxHtml = checkBoxHtml + '<span class="checkbox_span"><input type="checkbox" value="'
    									+ value.dm+'" id="'+checkBoxId+'" onclick="Dictionary.checkbox.changeValue2ZhfxHidden(\''
    									+checkBoxId+'\',\''+zdlb+'\',\''+moduleName+'\');" '
    									+ checked + ' />'
    									+ '<a href="javascript:;" onclick="Dictionary.checkbox.changeCheckBoxStatus(\''
    									+checkBoxId+'\',\''+zdlb+'\',\''+moduleName+'\');"><font color="black">'+value.ct+'</font></a></span>';
    		return checkBoxHtml;
        },
        
        /**
         * 获得选中的复选框的值
         * @param id 复选框DIV的id
         */
        getSelectedCheckBoxValue : function(id){
        	var inputArray =  $("#"+id).find("input");
        	for (var index = inputArray.length - 1; index >= 0; index--){
        		if ("hidden" == $(inputArray[index]).attr("type")){
        			var value = $(inputArray[index]).val();
        			return value.substring(0,value.length-1);
        		}
        	}
        },
        
        /**
         * 获得Fieldset的Html
         * @param id checkbox的DIV的id
         * @param title 复选框的标题
         * @param isexpand 是否展开
         * @returns {String}
         */
        getFieldsetHtml : function(id,title,isexpand) {
        	var classV = "fieldbtn_show";
        	var displayV = "none";
        	if (true == isexpand){
        		classV = "fieldbtn_show fieldbtn_hide";
        		displayV = "block";
        	}
        	var html = '<fieldset><legend><span>'
   			 + title + '</span><a onclick="Dictionary.checkbox.changeCheckBoxDivStauts(this,\''
   			 + id + '\');" class="'+classV+'"></a></legend>' 
   			 + '<div id="' + id + '" style="display:'+displayV+';"></div></fieldset>';
        	
        	return html;
        },
        
        /**
         * 选中复选框中的值
         * @param id 复选框所的div的id
         * @param value 需要选中的值，（xx,xx,xx）
         */
        selectCheckBox : function(id,value){
        	var selectedValueJson = {};
			var selectedValueArray = value.split(",");
			for (var index = 0; index < selectedValueArray.length; index++){
				selectedValueJson[selectedValueArray[index]] = selectedValueArray[index];
			}
			var inputArray =  $("#"+id).find("input");
        	for (var index = 0; index < inputArray.length; index++){
        		if ("checkbox" == $(inputArray[index]).attr("type")){
        			if (selectedValueJson[$(inputArray[index]).val()]){
        				$(inputArray[index]).attr('checked',true);
        			}
        		}
        	}
        },
        
        /**
         * 取消所有选中复选框中的值
         * @param id 复选框所的div的id
         */
        cacelSelectedCheckBox : function(id){
			var inputArray =  $("#"+id).find("input");
        	for (var index = 0; index < inputArray.length; index++){
        		if ("checkbox" == $(inputArray[index]).attr("type")){
        			$(inputArray[index]).attr('checked',false);
        		}
        	}
        }
    }
};