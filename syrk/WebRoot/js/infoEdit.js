$.parser.onComplete = function() {
	$.ajax({
		type:"POST",
		url:contextPath+infoPara.mainUrl,
		dataType:"json",
		data:infoPara.mainPara,
		success:function(data){
			$.each(data,function(i,item){
				if(item.xxurl!=""){
					addInfoHtml_auto(item.xxurl,item.icon==""?"info_jzxx":item.icon,item.xxbtmc,item.cshzk,item.isEdit,item.zdryId,item.gxzrq,item.zdrylxdm,item.zdrylbdm,item.syrkId);
					var _this = $("div.lf_conta").last();
					$(_this).find("ul").each(function(i){
						if($(this).attr("url")){
						$(this).hide();
						$(this).next().hide();
						}
					});
					$.each(item.list,function(i1,item2){
						$(_this).find("ul[url='"+item2.xxurl+"']").attr({"maxNum":item2.xxzsjlzds,"sfdt":item2.sfdt});
						$(_this).find("ul[url='"+item2.xxurl+"']").show();
						$(_this).find("ul[url='"+item2.xxurl+"']").next().show();
						if(item.cshzk=="1"){
							addChildInfoHtml_auto(item2.xxurl,_this,item2.xxzsjlzds);
						}
					});
				};
			}); 
		},
		complete:function(){
		}
	});
};
/*************************************************事件方法 **/
//查询
function queryObj(_this){
	var _ul = $(_this).is("ul")?_this:$(_this).find("ul");
	if($(_ul).find("input[name='method']").val()){
		$.ajax({
			type:"get",
			async:false,
			url:contextPath+ infoPara.queryUrl + $(_ul).find("input[name='method']").val(),
			dataType:"json",
			data:infoPara.queryPara+"&syrkid="+$(_ul).parents("div.lf_conta").attr("syrkId")+"&zdryid="+$(_ul).parents("div.lf_conta").attr("zdryid"),
			success:function(data){
				if($(_ul).find("input[name='method']").attr("image")=="true"){
					if(data.entity){
						$.each(data.entity,function(i,item){
							$(_ul).append("<img src='"+contextPath+infoPara.zpUrl+ "?id="+item+"' width='162' height='200' alt=''/>");
							$(_ul).css("display","");
						});
					}
				}
				else if($(_ul).find("input[name='method']").attr("fj")=="true"){
					if(data.entity){
						$.each(data.entity,function(i,item){
							var sb = new StringBuffer();
							sb.append("<ul>");
							sb.append("<li><span class='spantitle'>附件名称：</span><span name='wjmc' class='edit_word input_w2'><a href='javascript:void(0)' class='_fjxz' id='"+item.id+"'>"+item.wjmc+"</a></span></li>");
							sb.append("<li><span class='spantitle'>上传时间：</span><span name='xt_cjsj' class='edit_word input_w2'>"+item.xt_cjsj+"</span></li>");
							sb.append("<li class='uline2'></li>");
							sb.append("<input type='hidden' name='id' />");
							sb.append("</ul>");
							$(_ul).append("<li>"+sb+"</li>");
							$(_ul).css("display","");
						});
						$(_ul).on('click','a._fjxz',function(){
							$dlfm = $("<form action='"+contextPath+"/zpfjFjxxb/download' style='display:none;margin:0px;padding:0px' method='post'><input type='hidden' name='id' value='"+this.id+"'/></form>");
							$('body').append($dlfm);
							$dlfm.submit();
							$dlfm.remove();
						});
					}
				}
				else{
					if(data.entity){
						for ( var filed in data.entity) {
							$(_ul).find("span[name='"+filed+"']").text(data.entity[filed]);
						}
						$(_ul).find("input[name='id']").val(data.entity["id"]);
					}
				}
			},
			complete:function(){
				//console.info('mainComplete');
				iterateDict(_ul);
			}
		});
	}
}
//查询子类信息
function queryChildInfo(_ul,str,isRefresh){
	childLoading($(_ul).find("a.ulrefresh_btn"));

	if(isRefresh){
		$(_ul).find("ul").remove();
	}
	$.ajax({
		type:"get",
		url:contextPath+infoPara.queryUrl + $(_ul).find("input[name='method2']").val(),
		dataType:"json",
		data:infoPara.queryPara+"&syrkid="+$(_ul).parents("div.lf_conta").attr("syrkId")+"&maxNum="+$(_ul).attr("maxNum")+"&zdryid="+$(_ul).parents("div.lf_conta").attr("zdryid"),
		success:function(data){
			if(data.entity){
				if($(_ul).find("input[name='method2']").attr("fj")=="true"){
					if(data.entity){
						$.each(data.entity,function(i,item){
							var sb = new StringBuffer();
							sb.append("<ul>");
							sb.append("<li><span class='spantitle'>附件名称：</span><span name='wjmc' class='edit_word input_w2'><a href='javascript:void(0)' class='_fjxz' id='"+item.id+"'>"+item.wjmc+"</a></span></li>");
							sb.append("<li><span class='spantitle'>上传时间：</span><span name='xt_cjsj' class='edit_word input_w2'>"+item.xt_cjsj+"</span></li>");
							sb.append("<li class='uline2'></li>");
							sb.append("<input type='hidden' name='id' />");
							sb.append("</ul>");
							$(_ul).append("<li>"+sb+"</li>");
							$(_ul).css("display","");
						});
						$(_ul).on('click','a._fjxz',function(){
							$dlfm = $("<form action='"+contextPath+"/zpfjFjxxb/download' style='display:none;margin:0px;padding:0px' method='post'><input type='hidden' name='id' value='"+this.id+"'/></form>");
							$('body').append($dlfm);
							$dlfm.submit();
							$dlfm.remove();
						});
					}
				}else{
					$.each(data.entity,function(i,item){
						$(_ul).append(str);
						var _that = $(_ul).find("ul").last();
						for ( var filed in item) {
							if(item[filed]=="" && $(_that).find("span[name='"+filed+"']").attr("nullToShow")=="false"){
							
									$(_that).find("span[name='"+filed+"']").prev().hide();

									$(_that).find("span[name='"+filed+"']").hide();
							}

							$(_that).find("span[name='"+filed+"']").text(item[filed]);
						}
						$(_that).find("input[name='id']").val(item["id"]);
						iterateDict(_that);
					});
					if(data.entity.length > 0 && $(_ul).attr("sfdt") == "1"){
						$(_ul).find("a.addfw_btn").hide();
					}
				}
			}
		},
		complete:function(){
			//console.info('chlidComplete');
			removechildLoading($(_ul).find("a.ulrefresh_btn"));
			bindChildEvents(_ul);
			if($(".savebtn").is(":visible")){
				$("ul > ul").hover(  ///鼠标经过显示按钮
					function(){
						$(this).find(".ulrt_btn").show();
					},
					function(){
						$(this).find(".ulrt_btn").hide();
					}
				);
			}
			//这里去掉小项的添加,修改，删除
			if($(_ul).parents("div.lf_conta").attr("isEdit")=="0"){
				$(_ul).find("a.addfw_btn").remove();
				$(_ul).find("a.editfw_btn").remove();
				$(_ul).find("a.delfw_btn").remove();
			}
		}
	});
	
	
}
function bindChildEvents(_ul){
	$(_ul).find("a.delfw_btn").click(del_childInfo);
	$(_ul).find("a.editfw_btn").click(edit_childInfo);
}

//缩放
function up_down(){
	if(!$(this).parents("dl").find("dd").is(":visible") && $(this).attr("cshzt")=="2"){
		var _dd = $(this).parents("dl").find("dd");
		$(_dd).find("a.ulup_btn").click(ul_up);
		$(_dd).find("a.ulrefresh_btn").click(refreshEvent);
		if($(_dd).find("input[name='method']")){
			queryObj(_dd);
		}
		$(_dd).parent().find("a.up_btn").attr("cshzt","3");
		console.info('childBegin');
		$(_dd).find("input[name='method2']").each(function(i){
			if($(this).parent().attr("maxNum"))
				queryChildInfo($(this).parent(),eval($(this).parent().attr("url")+"_()"));
		});
	};
	$(this).toggleClass("down_btn");
	$(this).parents("dl").find("dd").slideToggle("fast","linear",function(){
	});
	if($(".editbtn").is(":visible")){
		$(this).parents("dl").find("dd").find("a.addfw_btn").css("display","none");
		$("ul > ul").unbind();
	}
}

//页面编辑 状态切换
function edit_view(){
	$(this).hide();
	$(".savebtn").show();
	$(".rt_server").hide();
	$(".rt_view").show();
	$(".addfw_btn").show();
	$(".infodl").find(".info_editbtn").show();
	$("ul > ul").bind("mouseover",function(){  ///鼠标经过显示按钮
			$(this).find(".ulrt_btn").show();
	});
	$("ul > ul").bind("mouseout",function(){  ///鼠标经过显示按钮
			$(this).find(".ulrt_btn").hide();
	});
}
function save_view(){
	$(this).hide();
	$(".editbtn").show();
	$(".rt_server").show();
	$(".rt_view").hide();
	$(".addfw_btn").hide();
	$(".infodl").find(".info_editbtn").hide();
	$("ul > ul").unbind();
};
//添加大类信息——初始化增加
function addInfoHtml_auto(url,style,title,cshzt,isEdit,zdryId,gxzrq,zdrylxdm,zdrylbdm,syrkId){
	var str = "";
	try{
		str = eval(url+"_()");
	}catch(e){
		console.log("url:"+url+"js方法未找到");
	}
	if(str!=""){
		$("div.lf_conta").last().after(buildHtml(str,style ,title,isEdit,gxzrq));
		var _this = $("div.lf_conta").last();
		//if($(".editbtn").css("display") == "none")
		//	$(".infodl").find(".info_editbtn").show();
		
		$(_this).find("a.info_editbtn").click(editEnable);
		$(_this).find("a.up_btn").click(up_down);
		$(_this).find("a.up_btn").attr("cshzt",cshzt);
		$(_this).find("a.addfw_btn").click(addChildInfoHtml);	
		$(_this).attr("isEdit",isEdit);
		$(_this).attr("zdryId",zdryId);
		$(_this).attr("syrkId",syrkId);
		$(_this).attr("zdrylxdm",zdrylxdm);
		$(_this).attr("zdrylbdm",zdrylbdm);
		if(cshzt == "1"){
			$(_this).find("a.up_btn").click();
			$(_this).find("a.ulup_btn").click(ul_up);
			$(_this).find("a.ulrefresh_btn").click(refreshEvent);
			queryObj($("div.lf_conta").last());
		}else if($(_this).find("input[name='method']") && $(_this).find("input[name='method']").attr("image")!="true" && $(_this).find("input[name='method']").attr("fj")!="true"){
			queryObj($("div.lf_conta").last());
		}

		$(_this).find("ul").hover(  ///鼠标经过显示按钮
			function(){
				$(this).find(".uline_rt").show();
			},
			function(){
				$(this).find(".uline_rt").hide();
			}
		);

	}	
}
//添加小类信息——初始化增加
function addChildInfoHtml_auto(url,_this,maxNum){
	var str = "";
	try{
		str = eval(url+"_()");
	}catch(e){ }
	if(str != ""){
		queryChildInfo($(_this).find("ul[url='"+url+"']"),str);
	}
}


//添加子项信息 -导航
function addInfoHtml_nav(){
	var url = $(this).attr("url");
	if(url!=""){
		var ul = $(".lf").find("ul[url='"+url+"']");
		if (ul.length) {
		//	$('body').scrollTop($(ul).offset().top);
			if(!$(ul).is(":visible")){
				$(ul).parents("dl").find("a.up_btn").click();
			}
			$("body").animate({scrollTop:$(ul).offset().top},300,'swing',function(){
				if($(ul).attr('level')=='1'){
					$(ul).parents("dl").find("a.info_editbtn").click();
				}else{
					$(ul).find(".addfw_btn").click();
				}
			});
			//$(ul).find(".addfw_btn").click();
		}
	}
}
//完成编辑状态 
function edit_complete(){
	/*if($("#mode_").val()=="verify"){
		if($("div.lf_conta").last().find("input[name='id']").val()==""){ 
			topMessagerAlert("","请先补充核实信息！");
			return false;
		}
	}*/
	document.location.reload() ;
}

////红色字 鼠标经过效果
function sylbIcon(){
	$(".morespan").hover(  
		function(){
			$(this).find(".morespan_1").hide();
			$(this).find(".morespan_2").show();
		},
		function(){
			$(this).find(".morespan_1").show();
			$(this).find(".morespan_2").hide();
		}
	);
}
//信息编辑
function editEnable(){
	var _this = $(this).parent().parent();
	var title = $(_this).find(".dllf").text();
	var _ul = $(_this).find("ul").first();
	var zdryParam="&zdryid="+$(_ul).parents("div.lf_conta").attr("zdryid");
	var openUrl = $(_ul).find("input[name='openUrl']").val();
	if(openUrl=="")return false;
	var menuName= $(_ul).find("input[name='openUrl']").attr("menu");
	if(menuName){
		menu_open(menuName, openUrl+"?"+infoPara.editPara+"&mainTabID="+getMainTabID());
	}else{
		var temp = $(_ul).find("input[name='editUrl']").val();
		var editUrl = contextPath + openUrl+"?"+infoPara.editPara+"&mainTabID="+getMainTabID()+zdryParam;
		editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
		var id =$(_ul).find("input[name='id']").val();
		if(temp&&temp!=""&&id){
			if(temp.indexOf("{id}") > 0){
				temp = contextPath+temp.replace("{id}",id);
			}
		}else{
			temp = editUrl+ "id="+id ;
		}
		var paramArray = $.parseJSON(infoPara.editIframePara);
		paramArray["_p"]= _ul;
		
		infoOpen(temp,title,paramArray);
		
	}
}
//业务办理
function doServer(){
	
	var editUrl = contextPath +  $(this).attr("url");
	var confirmmsg = $(this).attr("confirmmsg");
	editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	editUrl = editUrl + infoPara.serverPara;
	var paramArray = $.parseJSON(infoPara.serverIframePara);
	infoOpen(editUrl,$(this).attr("title"),paramArray, confirmmsg , "edit_complete");
}
//子项信息添加
function addChildInfoHtml(){
	var _ul = $(this).parent().parent();
	var _dd = $(_ul).parents("dd");
	var _parentInfo = $(_dd).find("ul.003A");
	if(_parentInfo){
		if($(_parentInfo).find("input[name='id']").val()==""){
			$(this).tooltip({
				position:'right',
				content:'<span style="color:#fff">请先添加主项信息</span>',
				onShow:function(){
					$(this).tooltip('tip').css({
						backgroundColor:'#666',
						borderColor:'#666'
					});
				}
			});
			$(this).tooltip("show");
			return ;
		}else{
			$(this).tooltip("destroy");
		}
	}
	if($(_ul).find("input[name='openUrl']").val()!=""){
		var zdryParam="&zdryid="+$(_ul).parents("div.lf_conta").attr("zdryid")+"&syrkid="+$(_ul).parents("div.lf_conta").attr("syrkId");
		var menuName= $(_ul).find("input[name='openUrl']").attr("menu");
		if(menuName){
			menu_open(menuName, $(_ul).find("input[name='openUrl']").val()+"?"+infoPara.add_childInfo_para+"&mainTabID="+getMainTabID()+"&infoUrl="+$(_ul).attr("url")+zdryParam);
		}else{
			var editUrl = contextPath + $(_ul).find("input[name='openUrl']").val();
			editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
			editUrl = editUrl + "id=&"+ infoPara.add_childInfo_para+zdryParam;
			var paramArray = $.parseJSON(infoPara.add_childInfo_iframePara);
			
			paramArray["_p"]= _ul;
			var sfdt = $(_ul).attr("sfdt");
			if(sfdt == "1"){
				infoOpen(editUrl,$(_ul).find("li.uline").text(),paramArray, "" , "child_edit_complete",_ul);
			}else if(sfdt == "2"){
				infoOpen2(editUrl,$(_ul).find("li.uline").text(),paramArray, "" , "child_edit_complete",_ul);
			}else{
				console.info('sfdt 没有配置');
			};
		}
	};
}
//子类信息保存回调方法
function child_edit_complete(_ul,data){
	var str = eval($(_ul).attr("url")+"_()");
	$(_ul).append(str);
	var _this = $(_ul).find("ul").last();
	for ( var filed in data) {
		$(_this).find("span[name='"+filed+"']").text(data[filed]);
	}
	
	if($(_ul).parent().attr("level")=="2" && $(_ul).parent().attr("sfdt") == "1"){
		$(_ul).parent().find("a.addfw_btn").hide();
	}
	$(_this).find("input[name='id']").val(data["id"]);
	iterateDict($(_this));
	bindChildEvents(_this);
	
	$(_this).hover(  ///鼠标经过显示按钮
		function(){
			$(this).find(".ulrt_btn").show();
		},
		function(){
			$(this).find(".ulrt_btn").hide();
		});
}
function child_edit_menu_complete(url){
	$("body").find("ul[url='"+url+"']").find("a.ulrefresh_btn").click();
}
//子类信息删除
function del_childInfo(){
	
	var _ul = $(this).parent().parent();
	var editUrl = contextPath + infoPara.del_childInfo;
	editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
	editUrl = editUrl + "id="+ $(_ul).find("input[name='id']").val() + "&url=" +$(_ul).parent().attr("url");
	infoOpen(editUrl,"注销记录",null, null , "del_childInfo_callback", _ul,200);
	
}
function del_childInfo_callback(_ul,data){
	if($(_ul).parent().attr("level")=="2" && $(_ul).parent().attr("sfdt") == "1"){
		$(_ul).parent().find("a.addfw_btn").show();
	}
	$(_ul).remove();
}
//子类信息修改
function edit_childInfo(){
	var _ul = $(this).parent().parent();
	var menuName= $(_ul).parent().find("input[name='openUrl']").attr("menu");
	if(menuName){
		menu_open(menuName, $(_ul).parent().find("input[name='openUrl']").val()+"?id="+ $(_ul).find("input[name='id']").val() + "&" +infoPara.edit_childInfo_para+"&mainTabID="+getMainTabID()+"&infoUrl="+$(_ul).parent().attr("url"));
	}else{
		var temp = $(_ul).parent().find("input[name='editUrl']").val();
		if(temp&&temp!=""){
			if(temp.indexOf("{id}") > 0){
				temp = temp.replace("{id}",$(_ul).find("input[name='id']").val());
			}
		}else{
			temp = $(_ul).parent().find("input[name='openUrl']").val();
		}
		var editUrl = contextPath + temp;
		editUrl = editUrl + (editUrl.indexOf('?') != -1 ? '&' : '?');
		editUrl = editUrl + "id="+ $(_ul).find("input[name='id']").val() + "&" + infoPara.edit_childInfo_para;
		var paramArray = $.parseJSON( infoPara.edit_childInfo_iframePara);
		infoOpen(editUrl,$(_ul).parent().find("li.uline").text(),paramArray, "" , "edit_childInfo_callback",_ul);
	}
}
function edit_childInfo_callback(_this,data){
	for ( var filed in data) {

		if(data[filed]=="" && $(_this).find("span[name='"+filed+"']").attr("nullToShow")=="false"){
			
			$(_this).find("span[name='"+filed+"']").prev().hide();

			$(_this).find("span[name='"+filed+"']").hide();
		 }
		else{
		   $(_this).find("span[name='"+filed+"']").prev().show();
		   $(_this).find("span[name='"+filed+"']").show();

	    }
		
		$(_this).find("span[name='"+filed+"']").text(data[filed]);
	}
	$(_this).find("input[name='id']").val(data["id"]);
	iterateDict($(_this));
	//bindChildEvents(_this);
//	$(_this).hover(  ///鼠标经过显示按钮
//		function(){
//			$(this).find(".ulrt_btn").show();
//		},
//		function(){
//			$(this).find(".ulrt_btn").hide();
//		});
}
function view_chlidInfo(){
	console.info('coding.....');
};

///子项展开收起
function ul_up(){
	$(this).parent().parent().parent().find("ul").toggle();
	$(this).toggleClass("uldown_btn");
}
function childLoading(_this){
	$(_this).addClass("ulloding_btn");
}
function removechildLoading(_this){
	$(_this).removeClass("ulloding_btn");
}
/**
 * 回到顶部
 */
function moveTop(){
	
}
/**
 * 刷新按钮事件
 */
function refreshEvent(){
	var _ul = $(this).parents("ul");
	queryChildInfo(_ul,eval($(_ul).attr("url")+"_()"),true);
}

/**
 * 新增人员照片
 * ptryzpEdit('123456', 'RY_RYJBXXB', '123456', '人员基本信息表', '', 'ryzpSubmitSuccess', '');
 */
function addPhoto(){
	var info = $(this).attr("info");
	var arr = info.split(",");
	ptryzpEdit($("#"+arr[0]).val(), arr[1], $("#"+arr[2]).val(), arr[3], ''	, 'refreshPhoto', '') ;
}
/**
 * 新增附件，其他照片
 */
function addFile(){
	var info = $(this).attr("info");
	var arr = info.split(",");
	var dataOptions = {
		title: '附件照片信息',
		url: contextPath + '/zpfjFjxxb/editFJ?lybm='+ arr[1] + '&lyid=' + $("#"+arr[0]).val() + '&lyms=' + encodeURI(arr[2]),
		width: 820,
		height: 200
	};
	openWindowWithSave(false, "", window, null, dataOptions, "您是否要上传照片？",  'refreshPhoto', '');
}
/**
 * 更多照片查看
 */
function morePhoto(){
	
}
function refreshPhoto(){
	$(".topPhoto").attr("src",$(".topPhoto").attr("src")+"&date="+new Date());
}
/*************************************************事件方法end **/

/**
 * 查询页面字典翻译  初始方法
 */
function iterateDict(_this){
	$(_this).find("span.edit_word").each(function(){
		if($(this).attr("dict")){
		 	$(this).text(window.top.getDictName(contextPath + $(this).attr("dict")+".js", $(this).text()));
		}
	});
}

/**
 * 获取功能表 1,业务办理，2，可增加信息
 */
function getServerMenu(gnlxdm){
 	var menu= null ;
	$.ajax({
		type:"post",
		url:contextPath+infoPara.serverMenuUrl,
		dataType:"json",
		data:infoPara.serverMenuPara+"&gnlxdm="+gnlxdm,
		success:function(data){
		 	if("1" == gnlxdm){
		 	  menu = $("#serverMenu");
		 	}else if("2" == gnlxdm){
			  menu = $("#serverAddInfo");
			}
			$(menu).empty();
			$.each(data,function(i,item){
				if("1" == gnlxdm){
				  $(menu).append(serverMenuHtml(item));
				}else if("2" == gnlxdm){
				  $(menu).append(serverLXRHtml(item));
				}
			}); 
			
		},
		complete:function(){
			if(menu){
				if("1" == gnlxdm){
					$(menu).find("a.doServer").click(doServer);
				}else if("2" == gnlxdm){
					$(menu).find("a.addInfo").click(addInfoHtml_nav);
				}
			};
		}
	});
}

/**
 * 获取关系人可增加信息HTMl
 */
 function serverLXRHtml(obj){
	var sb = new StringBuffer();
	sb.append("<li><a href='javascript:void(0);' id='serverMenu_"+obj.id+"' url='"+obj.gnanurl+"' title='"+obj.gnanmc+"' confirmMsg='"+obj.bctsxx+"' class='addInfo' >"+obj.gnanmc+"</a></li>");
	return sb.toString();
}
 
 /**
 *获取业务办理HTML 
 */

function serverMenuHtml(obj){
	var sb = new StringBuffer();
	sb.append("<li><a href='javascript:void(0);' id='serverMenu_"+obj.id+"' url='"+obj.gnanurl+"' title='"+obj.gnanmc+"' confirmMsg='"+obj.bctsxx+"' class='doServer' >"+obj.gnanmc+"</a></li>");
	return sb.toString();
}
//信息新增修改
function infoOpen(editUrl,title,paramArray,confirm ,callback,dom ,height){
   	openWindowWithSave(false, null, window, 
   		paramArray, 
   		{
   		title: title,
   		url: editUrl,
   		width: 880,
   		height:height?height:500
   		}, 
   		confirm?confirm:null, callback?callback:null,dom?dom:null
   	);
}
//子项信息新增（不包含修改）
function infoOpen2(editUrl,title,paramArray,confirm ,callback,dom,height){
	openWindowWithSave(false, null, window, 
   		paramArray, 
   		{
   		title: title,
   		url: editUrl,
   		width: 880,
   		inline:true,
   		height:height?height:500
   		}, 
   		confirm?confirm:null, callback?callback:null,dom?dom:null
   	);
}

function buildHtml(str,cls,title,isEdit,gxzrq){
	var sb = new StringBuffer();
	sb.append("<div class='lf_conta cont_edit'>");
	sb.append("<div class='lf_contb'>");
	sb.append("<div class='lf_contc'>");
	sb.append("<dl class='infodl'>");
	sb.append("<dt><div class='dllf ");
	sb.append(cls);
	if(gxzrq!="" && typeof(gxzrq) != "undefined"){
		sb.append("'>"+title+"("+gxzrq+")"+"</div>");
	}
	else{
		sb.append("'>"+title+"</div>");
	}
	//sb.append("'>"+title+"</div>");
	sb.append("<a class='up_btn down_btn' href='javascript:void(0);'></a>");
	if(str.indexOf("'method'")>=0 && str.indexOf("image='true'")< 0 && str.indexOf("read='true'")< 0&& isEdit!="0")
		{
		sb.append("<a class='info_editbtn' href='javascript:void(0);'>编辑</a>");//<a class='info_savebtn' href='javascript:void(0);'>保存</a>
		}
	if(isEdit!="0")
		sb.append("</dt><dd class='infoedit'>");
	else
		sb.append("</dt><dd class='infoshow'>");
	sb.append(str);
	sb.append("</dd></dl></div></div></div>");
	return sb.toString();
};

