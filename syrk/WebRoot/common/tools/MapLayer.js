/*!
 * 地图图层处理类
 * znjg - v1.0.0 (2014-05-20 09:30)
 * Copyright(c) 2014 founder
 */

/**
 * @classDescription 地图图层处理类
 * @author gb
 */
var MapLayer = {
	
	/**
	 * 可存放最大业务图层数量 设置为-1 则不限制数量
	 */
	maxSize : 5,
		
	/**
	 * key值
	 */
	key : {
		ZNJG_FXYP_DSYJ : 'ZNJG_FXYP_DSYJ',
		ZNJG_FXYP_ZHCX : 'ZNJG_FXYP_ZHCX'
	},
	
	/**
	 * 描述值
	 */
	text : {
		ZNJG_FXYP_DSYJ : '分析研判-多色预警',
		ZNJG_FXYP_ZHCX : '分析研判-综合查询'
	},
		
	/**
	 * js Map对象
	 */
	map : new Map(),
	
	/**
	 * 当前地图对象
	 */
	_MapApp : MapBubble._MapApp,
	
	/**
	 * put对象
	 * @param key
	 * @param value
	 * @param text
	 * @param timer  可省略
	 */
	put : function(key, value, text, timer) {
		 this.manageMap();
		 this.map.put(key, value, text, timer);
	},
	
	/**
	 * get对象值
	 * @param key
	 * @returns
	 */
	get : function(key) {
		return this.map.get(key);
	},
	
	/**
	 * get对象文本
	 * @param key
	 * @returns
	 */
	getText : function(key) {
		return this.map.getText(key);
	},
	
	/**
	 * get对象timer
	 * @param key
	 * @returns
	 */
	getTimer : function(key) {
		return this.map.getTimer(key);
	},
	
	/**
	 * 移除对应key图层对象
	 * @param key
	 */
	remove : function(key) {
		var value = this.get(key);
		var timer = this.getTimer(key);
		if(value!="" && value!=null) {
			for ( var i = 0; i < value.length; i++) {
				_MapApp.removeOverlay(value[i]);
			}
			this.map.remove(key);
		}
		if(timer!="" && timer!=null && typeof(timer) != "undefined"){
			clearInterval(timer);
			timer = null;
		}
	},
	
	/**
	 * 移除所有图层对象
	 */
	removeAll : function() {
		for ( var i = 0; i < this.map.arr.length; i++) {
			v = this.map.arr[i].value;
			timer = this.map.arr[i].timer;
			if(v!="" && v!=null) {
				for ( var j = 0; j < v.length; j++) {
					_MapApp.removeOverlay(v[j]);
				}
			}
			if(timer!="" && timer!=null){
				clearInterval(timer);
				timer = null;
			}
		}
		this.map.removeAll();
	},
	
	/**
	 * 移除第一个图层
	 */
	removeFirst : function() {
		if(this.map.size > 0) {
			var key = this.map.arr[0].key;
			this.remove(key);
		}
	},
	
	/**
	 * 根据指定的长度管理维护map
	 */
	manageMap : function () {
		var currSize = this.map.size;
		var maxSize = this.maxSize;
		if(maxSize == -1 || currSize < maxSize) {
			return;
		}
		if(currSize == maxSize) {
			this.map.removeFirst();
			this.removeFirst();
		}
	},
	
	/**
	 * 取得所有图层列表
	 * @returns
	 */
	getList : function() {
		return this.map.arr;
	},
	
	/**
	 * 展示地图图层列表
	 * @param id
	 */
	createHtml : function(){
		var list = this.getList();
		var layer = null;
		var html = "";
		if(list.length > 0) {
			for(var i = 0; i < list.length; i++){
				layer = list[i];
				if(layer != null){
					html += '<li class="ywtolli" id="' + layer.key
							+ '" onclick="MapLayer.onclickEvent(\'' + layer.key
							+ '\');"><span class="syscheckbox2" id="'
							+ layer.key + '_cb" text="' + layer.text
							+ '" key="' + layer.key + '"></span><span>'
							+ layer.text + '</span></li>';
				}
			}
			html += '<li><span class="syscheckbox2" id="mapLayerAll" onclick="MapLayer.onclickAllEvent();">全选</span></li>';
			html += '<li><a href="javascript:void(0);" onclick="MapLayer.removeSelected();" class="btnab">移除</a>';
			html += '<a href="javascript:void(0);" onclick="MapLayer.addSelected();" class="btnab">叠加</a></li>';
		} else {
			html += '<li>暂无数据！</li>';
		}
		//alert(html);
		$("#ywtcol").html(html);
	},
	
	/**
	 * 全选事件
	 */
	onclickAllEvent : function() {
		var classCb = $("#mapLayerAll").attr("class");
		if(classCb == "syscheckbox2") {
			$("#ywtcol .ywtolli").each(function(i, e) {
				var id = $(e).attr("id");
				$("#"+id+"_cb").removeClass("syscheckbox2");
				$("#"+id+"_cb").addClass("syscheckbox1");
			});
			$("#mapLayerAll").removeClass("syscheckbox2");
			$("#mapLayerAll").addClass("syscheckbox1");
		} else {
			$("#ywtcol .ywtolli").each(function(i, e) {
				var id = $(e).attr("id");
				$("#"+id+"_cb").removeClass("syscheckbox1");
				$("#"+id+"_cb").addClass("syscheckbox2");
			});
			$("#mapLayerAll").removeClass("syscheckbox1");
			$("#mapLayerAll").addClass("syscheckbox2");
		}
	},
	
	/**
	 * 单选事件
	 */
	onclickEvent : function(id) {
		var classCb = $("#"+id+"_cb").attr("class");
		if(classCb == "syscheckbox2") {
			$("#"+id+"_cb").removeClass("syscheckbox2");
			$("#"+id+"_cb").addClass("syscheckbox1");
		} else {
			$("#"+id+"_cb").removeClass("syscheckbox1");
			$("#"+id+"_cb").addClass("syscheckbox2");
		}
	},
	
	/**
	 * 移除选择的
	 */
	removeSelected : function() {
		var itemsArray = MapLayer.getSelectedItems();
		for(var i = 0; i < itemsArray.length; i++) {
			MapLayer.remove(itemsArray[i]["key"]);
			$("#"+itemsArray[i]["key"]).remove();
		}
	},
	
	/**
	 * 叠加选择的
	 */
	addSelected : function() {
		var itemsArray = MapLayer.getSelectedItems();
		for(var i = 0; i < itemsArray.length; i++) {
			 var paramArray = MapLayer.get(itemsArray[i]["key"]);
			 MapBubble.addGeometryLayers(paramArray);
		}
	},
	
	/**
	 * 返回选择的items
	 * @returns {Array}
	 */
	getSelectedItems : function() {
		var itemsArray = new Array();
		$(".ywtolli span").each(function(i, e) {
			var classCb = $(e).attr("class");
					if (classCb != null && classCb != ""
							&& typeof (classCb) != "undefined"
							&& classCb.indexOf("syscheckbox1") >= 0) {
				var text = $(e).attr("text");
				var key = $(e).attr("key");
				itemsArray.push({text:text, key:key});
			}
		});
		return itemsArray;
	}
};

/**
 * js 实现Map对象
 * @returns {Map}
 */
function Map() {
	
	this.arr = new Array();
	
	var struct = function(key, value, text, timer) {
		this.key = key;
		this.value = value;
		this.text = text;
		this.timer = timer;
	};

	var put = function(key, value, text, timer) {
		for ( var i = 0; i < this.arr.length; i++) {
			if (this.arr[i].key === key) {
				this.arr[i].value = value;
				this.arr[i].text = text;
				this.arr[i].timer = timer;
				return;
			}
		}
		this.arr[this.arr.length] = new struct(key, value, text, timer);
	};

	var get = function(key) {
		for ( var i = 0; i < this.arr.length; i++) {
			if (this.arr[i].key === key) {
				return this.arr[i].value;
			}
		}
		return null;
	};
	
	var getText = function(key) {
		for ( var i = 0; i < this.arr.length; i++) {
			if (this.arr[i].key === key) {
				return this.arr[i].text;
			}
		}
		return null;
	};
	
	var getTimer = function(key) {
		for ( var i = 0; i < this.arr.length; i++) {
			if (this.arr[i].key === key) {
				return this.arr[i].timer;
			}
		}
		return null;
	};

	var remove = function(key) {
		var v;
		for ( var i = 0; i < this.arr.length; i++) {
			v = this.arr.pop();
			if (v.key === key) {
				continue;
			}
			this.arr.unshift(v);
		}
	};
	
	var removeAll = function() {
		this.arr = new Array();
	};

	var size = function() {
		return this.arr.length;
	};

	var isEmpty = function() {
		return this.arr.length <= 0;
	};
	
	var removeFirst = function() {
		if(this.size > 0) {
			var key = this.arr[0].key;
			this.remove(key);
		}
	};
	
	this.get = get;
	this.put = put;
	this.remove = remove;
	this.size = size;
	this.isEmpty = isEmpty;
	this.removeAll = removeAll;
	this.getTxt = getText;
	this.getTimer = getTimer;
	this.removeFirst = removeFirst;
}