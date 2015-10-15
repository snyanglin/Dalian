<%@page pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<TITLE></TITLE>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/skin/mainMenunew.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/common/ztree/zTreeStyle.css" type="text/css"/>
<script type="text/javascript" src="<%=contextPath%>/common/ztree/jquery.ztree.all-3.5.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" >
// 初始化手风琴菜单
var subSystemName="";
function setSessionid(url , sessionid){
	
	return url+"?sessionid="+sessionid;
}

$(function() {
	//基本功能fengq加载

	var rootmenu = eval('${jsondata}')
	
	var sid ="";
	var arrstr = document.cookie.split("; ");
	for(var i = 0;i < arrstr.length;i ++){
		var temp = arrstr[i].split("=");
		if(temp[0] == "SESSION_KEY") 
			sid = unescape(temp[1]);
	}
	
	
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
											   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menureaf.id+"><a style='margin-left: 28px;margin-top: 8px;' onclick=\"window.open('"+setSessionid(setSessionid(menureaf.openURL,sid),sid)+"')\">";
										   }else{
											   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menu.id+"><a style='margin-left: 28px;margin-top: 8px;' onclick=\"menu_openClass('"+text+"','"+setSessionid(menureaf.openURL,sid)+"','"+menureaf.id+"')\">"; 
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
									   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menu.id+"><a style='margin-left: 28px;margin-top: 8px;' onclick=\"window.open('"+setSessionid(menu.openURL,sid)+"')\">";
								   }else{
									   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menu.id+"><a style='margin-left: 28px;margin-top: 8px;' onclick=\"menu_openClass('"+text+"','"+setSessionid(menu.openURL,sid)+"','"+menu.id+"')\">"; 
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
				subSystemName=aa;

				var ID = menuone.id;
				var Str = "";
				$('#westaction').accordion('add', {  	title: aa,id :ID, selected: false  });
				var checkUrl = getCheckSubSystemUsableURL(menuone.openURL);
				$.ajax({
					async:false,
					type:"POST",
					dataType:"json",
					url:checkUrl,
					success:function(data){
							if (data.status=='200') {
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
													   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menureaf.id+" onclick=\"window.open('"+setSessionid(menureaf.openURL,sid)+"')\"><a style='margin-left: 28px;margin-top: 8px;' >";
												   }else{
													   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menureaf.id+" onclick=\"menu_openClass('"+'text'+"','"+setSessionid(menureaf.openURL,sid)+"','"+menureaf.id+"')\"><a style='margin-left: 28px;margin-top: 8px;' >"; 
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
											   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menu.id+" onclick=\"window.open('"+setSessionid(menu.openURL,sid)+"')\"><a style='margin-left: 28px;margin-top: 8px;' >";
										   }else{
											   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menu.id+" onclick=\"menu_openClass('"+text+"','"+setSessionid(menu.openURL,sid)+"','"+menu.id+"')\"><a style='margin-left: 28px;margin-top: 8px;' >"; 
										   }

											Str = Str +menu.text +"";
											Str = Str +"</a></li>";
											Str = Str +"</ul>";
											$("#"+ID).html(Str);  
									   }

									}
								
							}else{
								$(".accordion-collapse").removeClass('accordion-collapse accordion-expand ').addClass('no-internet');

								topMessager.alert("", "子系统"+aa+"不可用哦T_T");

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
													   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menureaf.id+" onclick=\"window.open('"+setSessionid(menureaf.openURL,sid)+"')\"><a style='margin-left: 28px;margin-top: 8px;' >";
												   }else{
													   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menureaf.id+" onclick=\"menu_openClass('"+text+"','"+setSessionid(menureaf.openURL,sid)+"','"+menureaf.id+"')\"><a style='margin-left: 28px;margin-top: 8px;' >"; 
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
											   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menu.id+" onclick=\"window.open('"+setSessionid(menu.openURL,sid)+"')\"><a style='margin-left: 28px;margin-top: 8px;' >";
										   }else{
											   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menu.id+" onclick=\"menu_openClass('"+text+"','"+setSessionid(menu.openURL,sid)+"','"+menu.id+"')\"><a style='margin-left: 28px;margin-top: 8px;' >"; 
										   }

											Str = Str +menu.text +"";
											Str = Str +"</a></li>";
											Str = Str +"</ul>";
											$("#"+ID).html(Str);  
									   }

									}
								return;
							}
						},
					 error:function(XMLHttpRequest, textStatus, errorThrown){
							topMessager.alert("", "子系统"+aa+"不可用哦T_T");
							$(".accordion-collapse").removeClass('accordion-collapse accordion-expand ').addClass('no-internet');

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
												   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menureaf.id+" onclick=\"window.open('"+setSessionid(menureaf.openURL,sid)+"')\"><a style='margin-left: 28px;margin-top: 8px;color:#7F8594;' >";
											   }else{
												   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menureaf.id+" onclick=\"menu_openClass('"+'text'+"','"+setSessionid(menureaf.openURL,sid)+"','"+menureaf.id+"')\"><a style='margin-left: 28px;margin-top: 8px;color:#7F8594;' >"; 
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
										   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menu.id+" onclick=\"window.open('"+setSessionid(menu.openURL,sid)+"')\"><a style='margin-left: 28px;margin-top: 8px;color:#7F8594;' >";
									   }else{
										   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menu.id+" onclick=\"menu_openClass('"+text+"','"+setSessionid(menu.openURL,sid)+"','"+menu.id+"')\"><a style='margin-left: 28px;margin-top: 8px;color:#7F8594;' >"; 
									   }

										Str = Str +menu.text +"";
										Str = Str +"</a></li>";
										Str = Str +"</ul>";
										$("#"+ID).html(Str);  
								   }

								}
						 return;
			         },
			         complete:function(data){
			         	
			         }

					});
				
		
				 
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
	var checkUrl = getCheckSubSystemUsableURL(URL);
	$.ajax({
		async:false,
		type:"POST",
		dataType:"json",
		url:checkUrl,
		success:function(data){
				if (data.status=='200') {
					if($(".no-internet")){
						$(".no-internet").removeClass('no-internet  ').addClass('accordion-collapse accordion-expand');
					}
				

					
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
					
				}else{
					$(".accordion-collapse").removeClass('accordion-collapse accordion-expand ').addClass('no-internet');
					topMessager.alert("", "子系统"+subSystemName+"不可用哦T_T");
					

					return;
				}
			},
		 error:function(XMLHttpRequest, textStatus, errorThrown){
			 $(".accordion-collapse").removeClass('accordion-collapse accordion-expand ').addClass('no-internet');
			 topMessager.alert("", "子系统"+subSystemName+"不可用哦T_T");
				
   
			 return;
         },
         complete:function(data){
         	
         }

		});
}
function getCheckSubSystemUsableURL(URL){
	var ary=URL.split('/')
	var checkUrl="<%= basePath%>newmain/checkSubSystemUsable";
	if(URL.indexOf('http')==0){//以http开始，是其他系统		
		checkUrl=ary[0]+"/"+ary[1]+"/"+ary[2]+"/"+ary[3]+"/newmain/checkSubSystemUsable";
	}
	return checkUrl;
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
.no-internet {
	background:  url('../images/disconnect.png')
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

