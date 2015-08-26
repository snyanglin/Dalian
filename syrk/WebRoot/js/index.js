$(function(){
	$('#mainLayout').layout();
	
	//改变浏览器大小
	$('#mainLayout').layout('panel', 'west').panel({
		onResize:function(){
			setHeight();
		}
	});
	
	var winHeight = $(window).height()-3;
	var bodyHeight = $("html").height();
	$(".menuListBox").css("height",winHeight+"px");
	$(".sysBox").css("height",bodyHeight+"px");
	$(window).resize(function(){
		var winHeight = $(window).height()-3;
		var bodyHeight = $("html").height();
		$(".menuListBox").css("height",winHeight+"px");
		$(".sysBox").css("height",bodyHeight+"px");
	});
	//Sidebar Accordion Menu:
	$("#main-nav li ul").hide(); // Hide all sub menus
	$("#main-nav li a.current").parent().find("ul").slideToggle("slow", function(){setHeight()}); // Slide down the current menu item's sub menu
	
	$("#main-nav").on('click', 'a.nav-top-item', function(event){
		$('#main-nav li a.nav-top-item').removeClass('current');
		$(this).addClass('current');
		$(this).parent().siblings().find("ul").slideUp("normal"); // Slide up all sub menus except the one clicked
		$(this).next().slideToggle("normal",function(){
			setHeight();
		}); // Slide down the clicked sub menu
		
		return false;
	})
	
	$("#main-nav").on('click', 'a.no-submenu', function(event){
		addTab(this);
		return false;
	})
	
	$("#main-nav").on('click', 'a.toTab', function(event) {
		addTab(this);
		$("#main-nav li ul li a").removeClass('current');
		$(this).addClass('current');
		return false;
	})
	
	$(".arBox").click(function(){
		var menuListBox = $(".menuListBox");
		if (menuListBox.css("left") == "-193px") {
				menuListBox.animate({ left: "46px" }, 500, function () {
				$(".arBox").removeClass("leftAr");
				$(".arBox").addClass("rightAr");
			})
		}
		else {
				menuListBox.animate({ left: "-193px" }, 500, function () {
				$(".arBox").removeClass("rightAr");
				$(".arBox").addClass("leftAr");
			})
		}
	});
	
	$(".closeBigBox").click(function(){
		var menuListBox = $(".menuListBox");
				menuListBox.animate({ left: "-193px" }, 500, function () {
				$(".arBox").removeClass("rightAr");
				$(".arBox").addClass("leftAr");
			})
	});

	// Sidebar Accordion Menu Hover Effect:
	$("#main-nav li .nav-top-item").hover(
		function () {
			$(this).stop().animate({ paddingRight: "25px" }, 200);
		}, 
		function () {
			$(this).stop().animate({ paddingRight: "15px" });
		}
	);
	
	//左边菜单滚动
	$("#main-menu").mCustomScrollbar({
		scrollButtons:{enable:true}	
	});
	
	$(".operArea").click(function(){
		$(this).addClass("operAreaClick");
		$(".areaBox").show();
		var obj = $(this);
		var offset = obj.offset();
		var right = offset.left;
		var down = offset.top;
		//alert(offset.left);
		$(".areaBox").css({"top":down,"left":right});
	});
	
	$(".reginTitle span").click(function(){
		$(".operArea").removeClass("operAreaClick");
		$(".areaBox").hide();
	});
	
	$(".reginList span").click(function(){
		if($(this).attr("class") == "reginSelected"){
			$(this).removeClass("reginSelected");
		}else{
			$(this).addClass("reginSelected");
		}
	});
	
	$(".reginBut input").click(function(){
		var reginName = "";
		$(".reginList span.reginSelected").each(function(){
			reginName += $(this).text() + ",";
		});
		//alert(reginName);
		$(".operArea").removeClass("operAreaClick");
		$(".areaBox").hide();
	});

});

function setHeight(){
	var c = $('#mainLayout');
	var p = c.layout('panel','west');
	var westHeight = p.panel('panel').outerHeight();
	$('#sidebar-wrapper').height(westHeight);
	
	//左边菜单高度
	var extHeight = 184;
	var mainMenuHeight = parseInt($('#main-nav').height());
	if(mainMenuHeight+extHeight > westHeight) { //高度超出了屏幕高度
		$('#main-nav').width(192);
	} else {
		$('#main-nav').width(208);
	}
	$('#main-menu').height(westHeight-extHeight);
	$("#main-menu").mCustomScrollbar("update"); //更新左边菜单滚动
}

function addTab(obj) {
	var _href = $(obj).attr('href');
	var _id = $(obj).attr('id');
	_id = _id!=undefined?_id:'default';

	var tabId = CreateIndentityTabId();
	if($(this).data('tabId')) {
		tabId = $(this).data('tabId');
	}
	if(_href != '#') {
		if ($('#tt').tabs('exists', _id)){
			$('#tt').tabs('select', _id);
		} else {
			$('#tt').tabs('add',{
				title:_id,
				id:tabId,
				content:'<iframe scrolling="auto" frameborder="0"  src="'+_href+'" style="width:100%;height:100%;background:#F0F0F0"></iframe>',	
				closable:true,
				fit:true
			});
			$('#tt').tabs('getTab', _id).panel('body').css({'overflow':'hidden'});
		}
	}
}

function S4() {
		return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
}
function CreateIndentityTabId() {
	return "TABID-" + (S4() + S4() + "-" + S4() + "-" + S4() + "-" + S4() + "-" + S4() + S4() + S4());
}