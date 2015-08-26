/*!
 * 左侧layout组件
 * znjg - v1.0.0 (2014-03-27 17:30)
 * Copyright(c) 2014 founder
 */

/**
 * @classDescription 左侧layout
 * @author gb
 */

SysTool.loadComponentsFile("leftLayout", "leftLayout", ".css");

var LeftLayout = {
	id : '',
	lfwidth : '',
	cached : {
		findObj : null,
		lfTabUL : null,
		bodyLf : null,
		btnLftShow: null,
		lfCont: null,
		clear : function(){
			this.findObj = null;
			this.lfTabUL = null;
			this.bodyLf = null;
			this.btnLftShow = null;
			this.lfCont = null;
		}
	},
	/**
	 * 初始化layout
	 * @param {Object} param JSON对象
	 * @param {Function} func 回调函数
	 */
	init : function(param, callbackFunc) {
		var id = param.id;
		if(param.lfwidth){
			LeftLayout.lfwidth = param.lfwidth;
			alert(LeftLayout.lfwidth+"!!!");
		}else{
			LeftLayout.lfwidth = 275;
		}
		var html = '<div class="lf_tabemenu"><ul class="lf_tabeul"></ul></div><div class="body_lf">';
		html += '<div class="left_shadow"></div>';
		html += '<div class="lf_menu" id="lf_menu_' + id + '">';
		html += '<a href="javascript:void(0);" class="btn_lftshow"></a>';
		html += '</div>'; 
		html += '<div id="leftcont_' + id + '" class="left_cont"></div>';
		html += '</div>';
		if (typeof (id) == 'undefined') {
			$(html).appendTo('body');
		} else {
			$('#' + id).addClass("load_lf");
			SysTool.setContentHeight();
			$('#' + id).html('');
			$(html).appendTo('#' + id);
		}
		$(".body_lf").width(LeftLayout.lfwidth);
		$(".body_lf").css({left:50-LeftLayout.lfwidth});
		LeftLayout.id = id;
		// this.addlftabmenu();
		this.bindingEvent();
		// $("#leftcont").load(param.url, callbackFunc);
		if (typeof(callbackFunc) === 'function') {
			callbackFunc();
		}
	},
	/**
	 * 调整左侧宽度
	 * @param param  菜单项{lfwidth:500}
	 * @param callback  回调
	 */
	changelfwidth : function(param,callback){
		if(param.lfwidth){
			LeftLayout.lfwidth = param.lfwidth;
		}else{
			LeftLayout.lfwidth = LeftLayout.lfwidth;
		}
		$(".body_lf").width(LeftLayout.lfwidth);
		$(".body_lf").css({left:50-LeftLayout.lfwidth});
	},
	/**
	 * 调整左侧宽度并显示左侧
	 * @param param  菜单项{lfwidth:500}
	 * @param callback  回调
	 */
	changelfwidthshow : function(param,callback){
		if(param.lfwidth){
			LeftLayout.lfwidth = param.lfwidth;
		}else{
			LeftLayout.lfwidth = LeftLayout.lfwidth;
		}
		$(".body_lf").width(LeftLayout.lfwidth);
		var body_lfw=$(".body_lf").position().left;
		if(body_lfw==50){
			$(".body_lf").css({left:50});
		}else{
			$(".body_lf").css({left:50-LeftLayout.lfwidth});
		}
	},
	/**
	 * 添加功能菜单项
	 * @param param  菜单项
	 * @param callback  回调
	 */
	addlftabmenu : function(param, callback) {
		var txt = '';
		var style = '';
		var menu = param.menu;
		var idx = param.idx;
		var expand = (typeof(param.expand) === 'undefined') ? false : param.expand; 
		if (typeof(menu) !== 'undefined') {
			var len = menu.length;
			for ( var i = 0; i < len; i++) {
				var json = menu[i];
				if (idx == i) {
					style = 'lfli_on';
				} else {
					style = '';
				}
				//txt += '<li class="' + style + '"><a href="javascript:void(0);" onclick="LeftLayout.menuClick(' + i + ',\'' + json.url + '\', \'' + json.name + '\', \'' + json.param + '\' , ' + expand + ',\'\', null);">' + json.name + '</a></li>';
				txt += '<li class="' + style + '"><a href="javascript:void(0);" id="menu_'+i+'">' + json.name + '</a></li>';
			}
		}
		txt += '<li class="lfli_onrtb"></li>';
		LeftLayout.getLfTabUL().html(txt);
		LeftLayout.hoverStyle(idx);
		LeftLayout.lftabmenuBindEvent(param, callback);
		
		var url = menu[idx].url;
		if(url == ''){
			LeftLayout.getLfContent().html('');
		} else {
			LeftLayout.getLfContent().load(url,menu[idx].param, callback);
		}
	},
	
	/**
	 * 菜单绑定事件
	 * @param param
	 * @param callback
	 */
	lftabmenuBindEvent : function(param, callback) {
		var menu = param.menu;
		var idx = param.idx;
		var expand = (typeof(param.expand) === 'undefined') ? false : param.expand; 
		if (typeof(menu) !== 'undefined') {
			var len = menu.length;
			for ( var i = 0; i < len; i++) {
				var json = menu[i];
				$("#menu_"+i).bind("click",{i:i},menuClickEvent);
			}
			
			function menuClickEvent(event) {
					var i = event.data.i;
					var json = menu[i];
					LeftLayout.menuClick(i, json.url, json.name, json.showright, json.param, expand, callback,json.openNew);
					
					var lfwidth = menu[i].lfwidth;
					var showrighti = menu[i].showright;
					if(lfwidth || showrighti){
						$(".body_lf").width(lfwidth);
						ZoomMap.setZoomToolLeftPosition(lfwidth+60);
						MapTool.setMapToolLeftPosition(lfwidth+150);
					}else{
						LeftLayout.lfwidth = LeftLayout.lfwidth;
						$(".body_lf").width(LeftLayout.lfwidth);
						ZoomMap.setZoomToolLeftPosition(LeftLayout.lfwidth+60);
						MapTool.setMapToolLeftPosition(LeftLayout.lfwidth+150);
					}
				}
		}
		if(param.expand == true){ LeftLayout.showLefLayout();}
	},
	
	/**
	 * 菜单点击事件
	 * @param idx 索引位置
	 * @param url 加载地址    
	 * @param name 页面title
	 * @param param 参数
	 * @param expand 是否展开
	 * @param callback 回调函数
	 */
	menuClick : function(idx, url, name, showright, param, expand, callback , openNew) {
		/*if(expand == true){ LeftLayout.showLefLayout();	}*/
		if(typeof(openNew)!= 'undefined'){
			top.window.open(url);
		}else{
			if(showright){
				//LeftLayout.hideLefLayout();
				Resource.show_rightLayout();
			}else{
				LeftLayout.showLefLayout();
			}
			var lf_tabeul_li = LeftLayout.getLfTabUL().find("li");
			lf_tabeul_li.removeClass("lfli_on");
			lf_tabeul_li.eq(idx).addClass("lfli_on");
			LeftLayout.hoverStyle(idx);
			SysTimer.clearAllTimer();
			LeftLayout.getLfContent().html('');
			//LeftLayout.getLfContent().empty();
			LeftLayout.getLfContent().load(url, param, callback);
			MapBubble.removeAll();
		}
	},
	/**
	 * 左侧菜单背景效果
	 * @param idx  默认初始化选择位置
	 */
	hoverStyle : function(idx) {
		LeftLayout.getLeftContent(".lfli_onrtb").each(function() {
			$.dequeue(this, "fx");
		}).animate({
			top : idx * 45+10
		}, 200, "linear");
		var lf_tabeul = LeftLayout.getLfTabUL();
		lf_tabeul.find("li").find("a").css("color", "#ffffff");
		lf_tabeul.find(".lfli_on").find("a").css("color", "#005c84");
	},
	/**
	 * 绑定layout事件
	 */
	bindingEvent : function() {
		LeftLayout.getBtnLftShow().bind("click", function() {
			var lf = LeftLayout.getBodyLf().position().left;
			if (lf == 50) {
				LeftLayout.hideLefLayout();
			} else {
				LeftLayout.showLefLayout();
			}
			MapBubble.lfmove_revertbtn();/* 移动气泡框小图标 */
		});
	},
	/**
	 * 显示隐藏layout事件
	 */
	toggleLayout : function() {
		var lfbody = LeftLayout.getBodyLf();
		var lf = lfbody.position().left;
		var my_lfwidth=lfbody.width();
		if (lf == 50) {
			lfbody.animate({
				left : 50-my_lfwidth
			}, 200);
			ZoomMap.setZoomToolLeftPosition(60);
			MapTool.setMapToolLeftPosition(150);
		} else {
			lfbody.animate({
				left : "50px"
			}, 200);
			ZoomMap.setZoomToolLeftPosition(my_lfwidth+60);
			MapTool.setMapToolLeftPosition(my_lfwidth+150);
			Resource.hide_rightLayout();
		}
		LeftLayout.getBtnLftShow().toggleClass("btn_lfthide");
	},
	/**
	 * 隐藏布局
	 */
	hideLefLayout : function() {
		var lfbody = LeftLayout.getBodyLf();
		var lf = lfbody.position().left;
		var my_lfwidth=lfbody.width();
		if (lf == 50) {
			lfbody.animate({
				left : 50-my_lfwidth
			});
			ZoomMap.setZoomToolLeftPosition(60);
			MapTool.setMapToolLeftPosition(150);
			LeftLayout.getBtnLftShow().removeClass("btn_lfthide");
		}
	},
	/**
	 * 显示左边布局
	 */
	showLefLayout : function() {
		// var lfbody = $("#" + LeftLayout.id).find(".body_lf");
		var lfbody = LeftLayout.getBodyLf();
		var lf = lfbody.position().left;
		var my_lfwidth=lfbody.width();
		// alert($("#" + LeftLayout.id).attr("id"));
		if (lf != 50) {
			lfbody.animate({
				left : "50px"
			});
			ZoomMap.setZoomToolLeftPosition(my_lfwidth+60);
			MapTool.setMapToolLeftPosition(my_lfwidth+150);
			LeftLayout.getBtnLftShow().addClass("btn_lfthide");
			var rtbody = lfbody.parent().siblings().is(".load_rt");
			if (rtbody) {
				var rtbodydiv = lfbody.parent().siblings().find(".body_rt");
				var rtbodydivwd = rtbodydiv.width();
				rtbodydiv.animate({
					right : -rtbodydivwd
				});
				rtbodydiv.find("#rightsf").addClass("btn_rthide");
			}
			// Resource.hide_rightLayout();
		}
	},
	/**
	 * 获取左侧菜单内容
	 * @param elem 元素对象
	 * @returns 当前选择ID
	 */
	getLeftContent : function(elem) {
		if(LeftLayout.findObj == null){
			var myid=$('#idcenter').find(".load_div:visible").find(".load_lf").attr("id");
			LeftLayout.cached.findObj = myid;
		}
		return $("#" + LeftLayout.cached.findObj).find(elem);
	},
	/**
	 * 获取左侧显示按钮对象
	 * @returns 按钮对象
	 */
	getBtnLftShow : function(){
		if(LeftLayout.cached.btnLftShow == null){
			LeftLayout.cached.btnLftShow = LeftLayout.getLeftContent(".btn_lftshow");
		}
		return LeftLayout.cached.btnLftShow;
	},
	/**
	 * 获取左边Body
	 * @returns body对象
	 */
	getBodyLf : function(){
		if(LeftLayout.cached.bodyLf == null){
			LeftLayout.cached.bodyLf = LeftLayout.getLeftContent(".body_lf");
		}
		return LeftLayout.cached.bodyLf;
	},
	/**
	 * 获取列表UL对象
	 * @returns 获取列表UL对象
	 */
	getLfTabUL: function(){
		if(LeftLayout.cached.lfTabUL == null){
			LeftLayout.cached.lfTabUL = LeftLayout.getLeftContent(".lf_tabeul");
		}
		return LeftLayout.cached.lfTabUL;
	},
	/**
	 * 获取左侧内容对象
	 * @returns 左侧内容
	 */
	getLfContent : function(){
		if(LeftLayout.cached.lfCont == null){
			LeftLayout.cached.lfCont = $("#leftcont_" + LeftLayout.id);
		}
		return LeftLayout.cached.lfCont;
	}
};