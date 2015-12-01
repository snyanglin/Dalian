/**
 *require jQuery
 * SysTool.js
 * map
 */
SysTool.loadComponentsFile("resource", "resource",".css");
SysTool.loadComponentsFile("", "ssjl",".js");
SysTool.loadComponentsFile("", "gps",".js");
SysTool.loadComponentsFile("", "xqgk",".js");
SysTool.loadComponentsFile("", "qfqz",".js");
SysTool.loadComponentsFile("", "jcxx",".js");
var Resource={
	id : '',
    /*
	 * @param div {DOMElement|String} 元素id
	 * @param options {Array(Object)} [{name:"实时警力",url:"ssjl.jsp",id:"ssjl",isInit:ture},{name:"基础信息",url:"jcxx.jsp",id:"ssjl"}]
	 */
	init:function(id, options){
		
		var options = options || [];
		var html = "<div class='body_rt'></div>";
		if(typeof (id)  == 'undefined') {
			$(html).appendTo('body');
		}else {
			$('#'+id).addClass("load_rt");
			$(html).appendTo('#'+id);
			Resource.id = id;
		}
		var rb = Resource.getRightBody();
		var txt = "<div class='right_shadow'></div><div class='rt_menu'><ul id='tab_menu' class='rt_menu_ul'></ul></div><div id='right_content' class='rt_cont'></div><div id='right_content_ssjl' class='rt_cont'></div><div id='right_content_jcxx' class='rt_cont'></div>";
//		rb.append("<div class='right_shadow'></div>");
//		rb.append("<div class='rt_menu'></div>");
//		rb.append("<div id='right_content' class='rt_cont'></div><div id='right_content_ssjl' class='rt_cont'></div><div id='right_content_jcxx' class='rt_cont'></div>");
//		rb.find(".rt_menu").append("<ul id='tab_menu' class='rt_menu_ul'></ul>");
		rb.append(txt);
		for(var i=1;i<=options.length;i++){
			rb.find(".rt_menu_ul").append("<li><a href='javascript:void(0)' class='rt_menu_"+i+"' id='"+options[(i-1)].id+"'>"+options[(i-1)].name+"</a></li>");
			if(options[(i-1)].isInit){
				rb.find("#"+options[(i-1)].id).parent().addClass("li_on");
				if(options[(i-1)].id == "jcxx"){
					rb.find("#right_content_jcxx").load(options[i-1].url);
					rb.find("#right_content_jcxx").show();
					rb.find("#right_content_ssjl").hide();
					//$("#right_content").hide();
					Resource.getRightContent().hide();
				}else if(options[(i-1)].id == "ssjl"){
					rb.find("#right_content_ssjl").load(options[i-1].url);
					rb.find("#right_content_ssjl").show();
					rb.find("#right_content_jcxx").hide();
					//$("#right_content").hide();
					Resource.getRightContent().hide();
				}else{
					//$("#right_content").load(options[i-1].url);
					Resource.getRightContent().load(options[i-1].url);
					Resource.getRightContent().show();
					rb.find("#right_content_jcxx").hide();
					rb.find("#right_content_ssjl").hide();
				}
				
				rb.find(".rt_menu_ul").find("li").find("a").css("color","#ffffff");
				rb.find(".rt_menu_ul").find(".li_on").find("a").css("color","#005c84");
			}
		}
		rb.find(".rt_menu_ul").append("<li class='li_onrtb'></li>");
		try{
			MapBubble.menuoffset = rb.find(".rt_menu").offset().left;
		}catch(e){}

		var liofftoprt = rb.find(".li_on").index();//右侧菜单背景效果-----start
		rb.find(".li_onrtb").each(function() {
            $.dequeue(this, "fx"); }
        ).animate({
            top: liofftoprt * 45
        }, 300, "linear");
		
		rb.find(".rt_menu_ul").find("li").hover(
			function() {
				var offtoprt=$(this).index();
				$(this).find("a").css("color","#71c8ff");
				rb.find(".li_onrtb").each(function() {
		                $.dequeue(this, "fx"); }
		            ).animate({
		                top: offtoprt*45
		            }, 300, "linear");
			},
			function() {
				Resource.lion_offset();
			}
		);//右侧菜单背景效果-----end 
		
		rb.find(".rt_menu").append("<a class='btn_rtshow btn_rthide' id='rightsf'></a>");	
		rb.find("#rightsf").bind("click", function(){
			Resource.show_hide_rightLayout();
			MapBubble.move_revertbtn();/*移动气泡框小图标*/
			try{
				new daoru().toggleIcon();
			}catch(e){}
		});
		Resource.bindClickFunc(options, rb);
	},
	/**
	 * 
	 * @param options
	 */
	bindClickFunc:function(options ,rb){
		var tab_menu = rb.find('#tab_menu');
		tab_menu.find("li").each(function(i){
				var that=this;
				$(that).bind("click",function(){
//						Ssjl.stopSstj();//停掉GPS的实时统计
//						Ssjl.stopSsxx();//停掉实时接收信号
					//MapBubble.removeAll();
					MapBubble.closeBubble();
					_MapApp.clearMapInstanceEventListeners("mapzoomend");
					_MapApp.addMapEventListener(EzEvent.MAP_ZOOMEND, function(e) {
						ZoomMap.setSliderPosition();
						MapBubble.setBubblePositionByMarker(MapBubble.currMarker);
					});
					rb.find(".rt_menu_ul").find("li").find("a").css("color","#ffffff");
					var my =this; 
					if($(my).hasClass("li_on")){
						rb.find(".rt_menu_ul").find(".li_on").find("a").css("color","#71c8ff");
						Resource.show_rightLayout();
//							return false;
					}else{
						
						rb.find(".rt_menu_ul").children(".li_on").removeClass();
						$(my).addClass("li_on");
						if($(my).children("a").attr("id")=="jcxx"){//基础信息
							if(rb.find("#right_content_jcxx").children("div").length==0){
								rb.find("#right_content_jcxx").load(options[i].url);
							}
							rb.find("#right_content_jcxx").show();
							rb.find("#right_content_ssjl").hide();
							Resource.getRightContent().hide();
						}else if($(my).children("a").attr("id")=="ssjl"){//实时警力
							if(rb.find("#right_content_ssjl").children("div").length==0){
								rb.find("#right_content_ssjl").load(options[i].url);
							}
							rb.find("#right_content_ssjl").show();
							rb.find("#right_content_jcxx").hide();
							//$("#right_content").hide();
							Resource.getRightContent().hide();
						}else{
							//$("#right_content").html("");
							Resource.getRightContent().html('');
							//$("#right_content").load(options[i].url);
							Resource.getRightContent().load(options[i].url);
							rb.find("#right_content_jcxx").hide();
							rb.find("#right_content_ssjl").hide();
							//$("#right_content").show();
							Resource.getRightContent().show();
						}
						
						Resource.show_rightLayout();
						MapBubble.move_revertbtn();/*移动气泡框小图标*/
						try{
							new daoru().toggleIcon();
						}catch(e){}
					}

					rb.find(".rt_menu_ul").find(".li_on").find("a").css("color","#005c84");
				});
			});
	},
	/**
	 * 模拟标签的点击事件
	 * @param id
	 * @param url
	 * @param data {Object} {name:"wanger"} 可省略
	 */
	fireClickFunc:function(id,url,data){  
		var rb = Resource.getRightBody();
		var d=data||"";
		if(d!=""){
			//$("#right_content").html("");
			Resource.getRightContent().html('');
			rb.find(".rt_menu_ul").children(".li_on").removeClass();
			$("#"+id).parent().addClass("li_on");
			//$("#right_content").load(url,data);
			Resource.getRightContent().load(url,data);
			//$("#right_content").show();
			Resource.getRightContent().show();
			rb.find("#right_content_jcxx").hide();
			rb.find("#right_content_ssjl").hide();
			if(rb.find("#rightsf").hasClass("btn_rthide")){
				Resource.show_rightLayout();
				MapBubble.move_revertbtn();/*移动气泡框小图标*/
				try{
					new daoru().toggleIcon();
				}catch(e){}
			};
			Resource.lion_offset();
		}else{
			//$("#right_content").html("");
			Resource.getRightContent().html('');
			rb.find(".rt_menu_ul").children(".li_on").removeClass();
			$("#"+id).parent().addClass("li_on");
			//$("#right_content").load(url);
			Resource.getRightContent().load(url);
			//$("#right_content").show();
			Resource.getRightContent().show();
			rb.find("#right_content_jcxx").hide();
			rb.find("#right_content_ssjl").hide();
			if(rb.find("#rightsf").hasClass("btn_rthide")){
				Resource.show_rightLayout();
				MapBubble.move_revertbtn();/*移动气泡框小图标*/
				try{
					new daoru().toggleIcon();
				}catch(e){}
			};
			Resource.hover_style();	
			Resource.lion_offset();
		}
		
	},
	lion_offset:function(){
		Resource.getRightBody().find(".rt_menu_ul").find("li").find("a").css("color","#ffffff");
		Resource.getRightBody().find(".rt_menu_ul").find(".li_on").find("a").css("color","#005c84");
		var onli=Resource.getRightBody().find(".rt_menu_ul").find(".li_on").index();
		Resource.getRightBody().find(".li_onrtb").each(function() {
            $.dequeue(this, "fx"); } 
        ).animate({
            top: onli*45
        }, 300, "linear");
	},
	/**
	 * 显示或隐藏右边区域
	 */
	show_hide_rightLayout:function(){
		if(!Resource.getRightBody().find("#rightsf").hasClass("btn_rthide")){
			Resource.hide_rightLayout();
		}else{
			Resource.show_rightLayout();
			LeftLayout.hideLefLayout();
		}
	},
	/**
	 * 隐藏右边区域
	 * @param width
	 */
	hide_rightLayout:function(){
		var objwidth=Resource.getRightBody().width();
		Resource.getRightBody().animate({right: -objwidth});
		Resource.getRightBody().find("#rightsf").addClass("btn_rthide");
	},
	/**
	 * 显示右边区域
	 */
	show_rightLayout:function(){
		Resource.getRightBody().animate({right:0});
		Resource.getRightBody().find("#rightsf").removeClass("btn_rthide");
		LeftLayout.hideLefLayout();
	},
	/**
	 * 模拟鼠标移动到标签，背景变色效果
	 */
	hover_style:function(){
		var liofftoprt=Resource.getRightBody().find(".li_on").index();//右侧菜单背景效果-----start
		Resource.getRightBody().find(".li_onrtb").each(function() {
            $.dequeue(this, "fx"); }
        ).animate({
            top: liofftoprt*45
        }, 300, "linear");
		Resource.getRightBody().find(".rt_menu_ul").find("li").find("a").css("color","#ffffff");
		Resource.getRightBody().find(".rt_menu_ul").find(".li_on").find("a").css("color","#005c84");
	},
//		/**
//		 *
//		 */
//		clearMarkers:function(){
//			var allOverlays=_MapApp.getOverlays();
//			MapBubble.closeBubble();
//			for(var i=0;i<allOverlays.length;i++){
//				var overlay=allOverlays[i];
//				if(Jqxx.currentJqMarkers.length==0){
//					_MapApp.removeOverlay(overlay);
//					continue;
//				}
//				var has=false;
//				for(var j=0;j<Jqxx.currentJqMarkers.length;j++){
//					var jqmarker=Jqxx.currentJqMarkers[j];
//					if(overlay.getPoint().x==jqmarker.getPoint().x&&overlay.getPoint().y==jqmarker.getPoint().y){
//						has=true;
//						break;
//					}
//					
//				};
//				if(!has){
//					_MapApp.removeOverlay(overlay);
//				}
//			};
//		}
	getRightContent: function(){
		return $('#' + Resource.id).find('#right_content');
	},
	getRightBody : function(){
		//var myid=$(".load_div:visible").find(".load_rt").attr("id");
		var myid = Resource.id;
		return $('#' + myid).find('.body_rt');
	}
		
};