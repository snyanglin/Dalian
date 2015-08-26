<%@page pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<TITLE></TITLE>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/skin/mainMenunew.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" >
// 初始化手风琴菜单
$(function() {
	//基本功能fengq加载

	var rootmenu = eval('${jsondata}')
	//有系统菜单的情况
	if(rootmenu[0].id=="ROOT"){
		for(var s=0;s<rootmenu.length;s++){
			var listmenu = eval(rootmenu[s].children);
			for(var i=0;i<listmenu.length;i++){
				var menuacc = eval(listmenu[i].children);
				for(var j = 0;j<menuacc.length;j++){
					var menunode = eval(menuacc[j].children);
					var menuone = eval(menuacc[j]);
					var aa = menuone.text;
					var ID = menuone.id;
					var Str = "";
					
					$('#westaction').accordion('add', {  	title: aa,id :ID, selected: false  });
					for(var k =0;k<menunode.length;k++){
						var menu = eval(menunode[k]);
							   //判断下面是否还有子菜单组
							   if(menu.openURL==""){
									var ss = eval(menu.children);
									for(var m =0;m<ss.length;m++){
										var menureaf = eval(ss[m]);
										
										 var text = menureaf.text;
										   var ID1 = menureaf.id +"ztree";
										   Str = Str +"<ul  class=\"ztree\" id="+ID1+">";
										   if(menureaf.openMode=="new"){
											   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menureaf.id+"><a style='margin-left: 28px;margin-top: 8px;' onclick=\"window.open('"+menureaf.openURL+"')\">";
										   }else{
											   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menu.id+"><a style='margin-left: 28px;margin-top: 8px;' onclick=\"menu_openClass('"+text+"','"+menureaf.openURL+"','"+menureaf.id+"')\">"; 
										   }

											Str = Str +menureaf.text +"";
											Str = Str +"</a></li>";
											Str = Str +"</ul>";
											$("#"+ID).html(Str);  
									}
							   }else{
								   var text = menu.text;
								   var ID1 = menu.id +"ztree";
								  
								   Str = Str +"<ul  class=\"ztree\" id="+ID1+">";
								   if(menu.openMode=="new"){
									   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menu.id+"><a style='margin-left: 28px;margin-top: 8px;' onclick=\"window.open('"+menu.openURL+"')\">";
								   }else{
									   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menu.id+"><a style='margin-left: 28px;margin-top: 8px;' onclick=\"menu_openClass('"+text+"','"+menu.openURL+"','"+menu.id+"')\">"; 
								   }

									Str = Str +menu.text +"";
									Str = Str +"</a></li>";
									Str = Str +"</ul>";
									$("#"+ID).html(Str); 
							   }
							
						}
					
				
					 
				}
				
			}
		}	
	}else{
		//只加载一个系统，例如导航或者基础管理
		var listmenu = eval('${jsondata}')
		
		for(var i=0;i<listmenu.length;i++){
			var menuacc = eval(listmenu[i].children);
			
			for(var j = 0;j<menuacc.length;j++){
				var menunode = eval(menuacc[j].children);
				var menuone = eval(menuacc[j]);
				var aa = menuone.text;
				var ID = menuone.id;
				var Str = "";
				$('#westaction').accordion('add', {  	title: aa,id :ID, selected: false  });
				for(var k =0;k<menunode.length;k++){
				var menu = eval(menunode[k]);
				 //判断是否还有子菜单组
				   if(menu.openURL==""){
						var ss = eval(menu.children);
						for(var m =0;m<ss.length;m++){
							var menureaf = eval(ss[m]);
							
							 var text = menureaf.text;
							   var ID1 = menureaf.id +"ztree";
							   Str = Str +"<ul  class=\"ztree\" id="+ID1+">";
							   if(menureaf.openMode=="new"){
								   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menureaf.id+" onclick=\"window.open('"+menureaf.openURL+"')\"><a style='margin-left: 28px;margin-top: 8px;' >";
							   }else{
								   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menureaf.id+" onclick=\"menu_openClass('"+text+"','"+menureaf.openURL+"','"+menureaf.id+"')\"><a style='margin-left: 28px;margin-top: 8px;' >"; 
							   }

								Str = Str +menureaf.text +"";
								Str = Str +"</a></li>";
								Str = Str +"</ul>";
								$("#"+ID).html(Str);  
						}
				   }else{
					   var text = menu.text;
					   var ID1 = menu.id +"ztree";
					   Str = Str +"<ul  class=\"ztree\" id="+ID1+">";
					   if(menu.openMode=="new"){
						   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menu.id+" onclick=\"window.open('"+menu.openURL+"')\"><a style='margin-left: 28px;margin-top: 8px;' >";
					   }else{
						   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menu.id+" onclick=\"menu_openClass('"+text+"','"+menu.openURL+"','"+menu.id+"')\"><a style='margin-left: 28px;margin-top: 8px;' >"; 
					   }

						Str = Str +menu.text +"";
						Str = Str +"</a></li>";
						Str = Str +"</ul>";
						$("#"+ID).html(Str);  
				   }

				}
				 
			}
			
		}
	}
	$("ul").hover( function(event){
	    $(this).addClass("dijitTreeLabelFocused ");    
	}, function(event){
	   $(this).removeClass("dijitTreeLabelFocused ");
	} );

	});

function menu_openClass(text,URL,ID){
	menu_open(text,URL);

	var itemli = document.getElementsByTagName("li");
	var itemul = document.getElementsByTagName("ul");
	for(var i = 0;i<itemul.length;i++){
		var itemu = itemul[i];
		
		itemu.className = "ztree";
	}
	for(var i =0;i<itemli.length;i++){
		var item = itemli[i];
		item.className="TreeExpandoLeaf";
		
	}
	var id = ID +"ztree";
	$("#"+ID).addClass("dijitTreeExpandoLeaf ");
	$("#"+id).addClass("dijitTreeLabelFocused1 ");

	
}
</script>
<style type="text/css">
.accordion {
	background: #ebebeb none repeat scroll 0 0;
	border-color: #ebebeb;
	margin-bottom: -999;
	padding-bottom: 999;
}

.accordion-collapse {
	background:  url("../images/arrow_02.png")
		no-repeat scroll 0 0;
}

.accordion-expand {
	background:  url('../images/arrow_01.png')
		no-repeat 0 0;
}

.accordion .accordion-header {
	background: #ebebeb;
	filter: none;
}

.accordion .accordion-header-selected {
	background: #c0dff8 none repeat scroll 0
}

.panel-body {
	background-color: #f7f7f7;
	color: red;
	font-size: 12px;
}

.panel-header,.panel-body {
	border-color: #d6d6d6;
}

.panel-title {
	height: 35px;
	line-height: 35px;
	color: #464646;
	font-weight: bold;
	margin-left:5px;
}
.TreeExpandoLeaf{
 background:  url("../images/t_08.png") no-repeat scroll 0 0;
    height: 30px;
    margin-left: 10px;
    width: 30px;
}

.dijitTreeExpandoLeaf {
    background: url("../images/t_10.png") no-repeat scroll 0 0;
  
}
.dijitTreeLabelFocused {
    background-color: #4693ff;
}
.dijitTreeLabelFocused1 {
    background-color: #4693ff;
}
</style>
</HEAD>

<BODY class="menuBody" onselectstart="return false;"  oncontextmenu="return false;">
<div class="menuTitle" height="30" width="100%"><div class="menu_text" data-options="region:'west',split:true">菜单导航</div></div>
<div class="easyui-accordion" fit="true" border="false" id="westaction" animate="false">
</div>
</BODY>
</HTML>

