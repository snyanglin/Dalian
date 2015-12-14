/*!
 * itemselector工具类
 * http://jquery.com/
 * znjg - v1.0.0 (2014-03-12 09:30)
 * Copyright(c) 2014 founder
 */

/**
 * @classDescription itemselector工具类
 * @author gb
 */

//SysTool.loadComponentsFile("itemselector", "itemselector", ".css");

var ItemSelector = {
	
	/**
	 * 初始化
	 * @param containerId
	 * @param items_n_array
	 * @param items_y_array
	 */
	init : function(containerId, items_n_array, items_y_array) {
		ItemSelector.createInitHtml(containerId);
		ItemSelector.createInitItems(items_n_array, items_y_array);
	},
	
	/**
	 * 创建基础html
	 * @param containerId
	 */
	createInitHtml : function(containerId) {
		var html = "";
		html += '<dl>';
		html += '<dt><span class="checkbox2" id="items_n_all" onclick="ItemSelector.onclickAllEvent(\'items_n\')"></span>可选项</dt>';
		html += '<dd id="items_n">';
		html += '</dd>';
		html += '</dl>';
		html += '<div class="itemselectorbtn">';
		html += '<a title="加入" href="javascript:void(0);" class="itemselectorbtna" onclick="ItemSelector.moveItems(\'items_y\',ItemSelector.getItems(\'items_n\'));"></a>';
		html += '<a title="移除" href="javascript:void(0);" class="itemselectorbtnb" onclick="ItemSelector.moveItems(\'items_n\',ItemSelector.getItems(\'items_y\'));"></a>';
		html += '</div>';
		html += '<dl>';
		html += '<dt><span class="checkbox2" id="items_y_all" onclick="ItemSelector.onclickAllEvent(\'items_y\')"></span>已选项</dt>';
		html += '<dd id="items_y">';
		html += '</dd>';
		html += '</dl>';
		$("#"+containerId).addClass("itemselector");
		//$("#"+containerId).html(html);
		document.getElementById(containerId).innerHTML=html;
	},
	
	/**
	 * 初始items
	 * @param items_n_array
	 * @param items_y_array
	 */
	createInitItems : function(items_n_array, items_y_array) {
		var itemJson;
		for(var i = 0; i < items_n_array.length; i++) {
			itemJson = items_n_array[i];
			$("#items_n")
					.append(
							ItemSelector.getItemHtml("items_y",itemJson["text"], itemJson["value"]));
		}
		
		for(var i = 0; i < items_y_array.length; i++) {
			itemJson = items_y_array[i];
			$("#items_y")
					.append(
							ItemSelector.getItemHtml("items_n",itemJson["text"], itemJson["value"]));
		}
	},
	
	/**
	 * 返回单个item div html
	 * @param itemsPos
	 * @param text
	 * @param value
	 * @returns {String}
	 */
	getItemHtml : function(itemsPos, text, value) {
		var html = '<div id="'
			+ value
		+ '" text="'
		+ text
		+ '" value="'
		+ value
		+ '"  class="itemdiv"  onclick="ItemSelector.onclickEvent('
		+ value
		+ ')" ondblclick="ItemSelector.ondblclickEvent(\''+itemsPos+'\','
		+ value
		+ ')"><span class="checkbox2" id="'
		+ value + '_cb"></span><span>'
		+ text + '</span></div>';
		return html;
	},
	
	/**
	 * item单击事件
	 * @param itemV
	 */
	onclickEvent : function(itemV) {
		var classCb = $("#"+itemV+"_cb").attr("class");
		if(classCb == "checkbox2") {
			$("#"+itemV).addClass("itemselect");
			$("#"+itemV+"_cb").removeClass("checkbox2");
			$("#"+itemV+"_cb").addClass("checkbox1");
		} else {
			$("#"+itemV).removeClass("itemselect");
			$("#"+itemV+"_cb").removeClass("checkbox1");
			$("#"+itemV+"_cb").addClass("checkbox2");
		}
	},
	
	/**
	 * 全选事件
	 * @param itemsPos
	 */
	onclickAllEvent : function(itemsPos) {
		var classCb = $("#"+itemsPos+"_all").attr("class");
		if(classCb == "checkbox2") {
			$("#"+itemsPos+" div").each(function(i, e) {
				var itemV = $(e).attr("value");
				$("#"+itemV).addClass("itemselect");
				$("#"+itemV+"_cb").removeClass("checkbox2");
				$("#"+itemV+"_cb").addClass("checkbox1");
			});
			$("#"+itemsPos+"_all").removeClass("checkbox2");
			$("#"+itemsPos+"_all").addClass("checkbox1");
		} else {
			$("#"+itemsPos+" div").each(function(i, e) {
				var itemV = $(e).attr("value");
				$("#"+itemV).removeClass("itemselect");
				$("#"+itemV+"_cb").removeClass("checkbox1");
				$("#"+itemV+"_cb").addClass("checkbox2");
			});
			$("#"+itemsPos+"_all").removeClass("checkbox1");
			$("#"+itemsPos+"_all").addClass("checkbox2");
		}
		
	},
	
	/**
	 * item双击事件
	 * @param itemV
	 */
	ondblclickEvent : function(itemsPos, itemV) {
		var itemsArray = new Array();
		var text = $("#"+itemV).attr("text");
		var value = $("#"+itemV).attr("value");
		itemsArray.push({text:text, value:value});
		ItemSelector.moveItems(itemsPos, itemsArray);
	},
	
	/**
	 * 按指定位置返回选择的items
	 * @param itemsPos
	 * @returns {Array}
	 */
	getItems : function(itemsPos) {
		var itemsArray = new Array();
		$("#"+itemsPos+" div").each(function(i, e) {
			var classCb = $(e).attr("class");
			if(classCb.indexOf("itemselect") > 0) {
				var text = $(e).attr("text");
				var value = $(e).attr("value");
				itemsArray.push({text:text, value:value});
			}
		});
		return itemsArray;
	},
	
	/**
	 * 按指定位置返回已经选择的items
	 * @param itemsPos
	 * @returns {Array}
	 */
	getSelectedItems : function(itemsPos) {
		var itemsArray = new Array();
		var items_value = "";
		var items_text = "";
		$("#"+itemsPos+" div").each(function(i, e) {
			items_value += $(e).attr("value") + ",";
			items_text += $(e).attr("text") + ",";
		});
		if(items_value != "" && items_text != "") {
			items_value = items_value.substring(0, items_value.length - 1);
			items_text = items_text.substring(0, items_text.length - 1);
			itemsArray.push(items_value);
			itemsArray.push(items_text);
		}
		return itemsArray;
	},
	
	/**
	 * item移动事件
	 * @param itemsPos
	 * @param itemsArray
	 */
	moveItems: function(itemsPos, itemsArray) {
		var itemsPos_new="";
		if(itemsPos.indexOf("_n")>0) {
			itemsPos_new = "items_y";
		} else {
			itemsPos_new = "items_n";
		}
		var itemJson;
		for(var i = 0; i < itemsArray.length; i++) {
			itemJson = itemsArray[i];
			$("#"+itemJson["value"]).remove();
		}
		for(var i = 0; i < itemsArray.length; i++) {
			itemJson = itemsArray[i];
			$("#" + itemsPos)
					.append(
							ItemSelector.getItemHtml(itemsPos_new,itemJson["text"], itemJson["value"]));
		}
		$("#items_n_all").removeClass("checkbox1");
		$("#items_n_all").addClass("checkbox2");
		$("#items_y_all").removeClass("checkbox1");
		$("#items_y_all").addClass("checkbox2");
	}

};