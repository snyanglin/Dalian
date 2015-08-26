if(typeof Yjxx =="undefined" || !Yjxx){
	Yjxx = {};
}

Yjxx.indexInfoObj = null;//查看其它详情时，返回原有显示信息对象
/**
 * @method:changeDCountColor
 * @package:syrk/js/qbld	
 * @description:切换数据统计已入移出时的样式
 * @param obj
 * @author:Li_Zhenzhong
 * @date:2015-5-6下午4:28:33
 * @return:void
 */
Yjxx.changeDCountColor = function(obj){
	if($(obj).css("background-color")=="rgb(255, 255, 255)"||$(obj).css("background-color")=="#fff")
		$(obj).css("background-color","#ffff00");
	else if($(obj).css("background-color")=="rgb(255, 255, 0)"||$(obj).css("background-color")=="#ffff00")
		$(obj).css("background-color","#fff");
};
/**
 * @title:clickDcountToChangeColor
 * @description:点击改变背景颜色
 * @author:li_zhenzhong
 * @param obj
 * @date:2015-4-23上午9:08:34
 */
Yjxx.clickDcountToChangeColor = function(obj){
	$(".yjTitle").css("background-color","#fff");
	$(".yj_dqs").css("background-color","#fff");
	$(".yj_dfk").css("background-color","#fff");
	$(obj).css("background-color","#f4f4f4");
}



/**
 * @title:QueryDyjCount
 * @description:查询待处理预警数量
 * @author:li_zhenzhong
 * @date:2015-4-20下午4:46:02
 */
Yjxx.QueryDyjCount = function(){
$.post(contextPath+'/ckyj/queryYjtj', function(d){
	$.each(d,function(i, item){
		Yjxx.ShowDyjCount(item);
	});
}, 'json');
}
/**
 * 获取查询结果，并进行展示
 * @title:ShowDyjCount
 * @description:TODO
 * @author:li_zhenzhong
 * @param rsJson
 * @date:2015-4-20下午4:46:59
 */
Yjxx.ShowDyjCount = function(rsJson){
	$("#ckyj_dqs").html("待签收<br>"+(rsJson.ckyjDq>0?"<font color='red' >"+rsJson.ckyjDq+"</font>":0));
	$("#ckyj_dfk").html("待反馈<br>"+(rsJson.ckyjDf>0?"<font color='red' >"+rsJson.ckyjDf+"</font>":0));
	$("#ckzl_dqs").html("待签收<br>"+(rsJson.yjzlDq>0?"<font color='red' >"+rsJson.yjzlDq+"</font>":0));
	$("#ckzl_dfk").html("待反馈<br>"+(rsJson.yjzlDf>0?"<font color='red' >"+rsJson.yjzlDf+"</font>":0));
	$("#lkyj_dqs").html("待签收<br>"+(rsJson.lkyjDq>0?"<font color='red' >"+rsJson.lkyjDq+"</font>":0));
	$("#lkyj_dfk").html("待反馈<br>"+(rsJson.lkyjDf>0?"<font color='red' >"+rsJson.lkyjDf+"</font>":0));
	$("#lkzl_dqs").html("待签收<br>"+(rsJson.lkyjzlDq>0?"<font color='red' >"+rsJson.lkyjzlDq+"</font>":0));
	$("#lkzl_dfk").html("待反馈<br>"+(rsJson.lkyjzlDf>0?"<font color='red' >"+rsJson.lkyjzlDf+"</font>":0));
	var msg  = "常控预警：待签收"+rsJson.ckyjDq+"条，待反馈"+rsJson.ckyjDf+"条<br>"
	+"常控指令：待签收"+rsJson.yjzlDq+"条，待反馈"+rsJson.yjzlDf+"条<br>"
	+"临空预警：待签收"+rsJson.lkyjDf+"条，待反馈"+rsJson.lkyjzlDq+"条<br>"
	+"临空指令：待签收"+rsJson.lkyjzlDf+"条，待反馈"+rsJson.lkyjzlDf+"条<br>"
	$.messager.show({
		title:"提示信息",
		msg:msg,
		timeout:8000,
		showType:'slide'
	})
}
/**
 * @title:changeListColor
 * @description:改变列表移入移出颜色
 * @author:li_zhenzhong
 * @param obj
 * @date:2015-4-23上午8:53:59
 */
Yjxx.changeListColor = function(obj){
	if($(obj).css("background-color")=="rgb(255, 255, 255)"||$(obj).css("background-color")=="#fff")
		$(obj).css("background-color","#ffff00");
	else if($(obj).css("background-color")=="rgb(255, 255, 0)"||$(obj).css("background-color")=="#ffff00")
		$(obj).css("background-color","#FFF");
};
Yjxx.clickListToChangeColor = function(obj){
	$(".infoOne_tr").css("background-color","#fff");
	$(obj).css("background-color","#f4f4f4");
}
Yjxx.initChangeListColor = function(){
	$(".infoOne_tr").hover(function(){
		Yjxx.changeListColor(this);
	},function(){
		Yjxx.changeListColor(this);
	})
}


/*****************************************分页插件开始*****************************************/

/**
 * 
 * @title: getPages 
 * @description:显示分页工具 时调此函数
 * @author: li_zhenzhong
 * @param counts 记录总数
 * @param num	每页数
 * @param nowPage 当前页数
 * @param toPage 查询方法
 * @returns {String}
 * @date：2012-9-7上午11:32:47
 */
Yjxx.showfy = function (counts,num,nowPage,toPage){
	var fyCount =counts;
	var fyCountPage = Yjxx.getPages(fyCount,num);//获取总页数
	var fyBeforeButtonFlag = Yjxx.getFyBeforeButtonFlag(nowPage,fyCountPage);
	var fyNextButtonFlag = Yjxx.getFyNextButtonFlag(nowPage,fyCountPage);
	var fyGoButtonFlag = fyCountPage==1?"disabled":"";
	var fyHtml = "<table class='fyTable'>"
		+ "<tr>"
		+ "	<td align='center' ><img id='firstButton' "+fyBeforeButtonFlag+" src='"+contextPath+"/images/qbld/fenye/page-first-"+fyBeforeButtonFlag+".gif' style='cursor:hand'  onclick='Yjxx.fyFun_first("+counts+","+num+","+toPage+")' alt='首页'></img></td>"
		+ "	<td align='center' ><img id='beforeButton' "+fyBeforeButtonFlag+" src='"+contextPath+"/images/qbld/fenye/page-prev-"+fyBeforeButtonFlag+".gif' style='cursor:hand'  onclick='Yjxx.fyFun_before("+counts+","+num+","+nowPage+","+toPage+")' alt='上一页'></img></td>"
		+ "	<td align='center' ><img id='nextButton' "+fyNextButtonFlag+" src='"+contextPath+"/images/qbld/fenye/page-next-"+fyNextButtonFlag+".gif' style='cursor:hand' onclick='Yjxx.fyFun_next("+counts+","+num+","+nowPage+","+toPage+")' alt='下一页'></img></td>"
		+ "	<td align='center' ><img id='endButton' "+fyNextButtonFlag+" src='"+contextPath+"/images/qbld/fenye/page-last-"+fyNextButtonFlag+".gif' style='cursor:hand' onclick='Yjxx.fyFun_end("+counts+","+num+","+fyCountPage+","+toPage+")' alt='尾页'></img></td>"
		+ "	<td align='center' >第<input id='nowPage' " + fyGoButtonFlag + " value='"+nowPage+"' style='width:40px' >页<img src='"+contextPath+"/images/qbld/fenye/send.gif' "+fyGoButtonFlag+" style='cursor:hand' onclick='Yjxx.fyFun_go("+counts+","+num+","+fyCountPage+","+toPage+")' alt='跳转'></img></td>"
		+ "	<td align='right'>共<font color='blue'>"+fyCountPage+"</font>页</td>"
		+ "</tr>"
		+ "</table>";
	return fyHtml;
};

/**
 * 
 * @title: getPages 
 * @description:计算总页数
 * @author: li_zhenzhong
 * @param counts 记录总数
 * @param num 每页显示数
 * @returns {Number} 
 * @date：2012-9-7上午11:32:47
 */
Yjxx.getPages = function (counts,num){
	var yes =counts/num;
	if((yes+"").indexOf(".")!=-1||counts==0)
		yes=parseInt(counts/num)+1;
	return yes;
};
/**
 * 
 * @title: getFyBeforeButtonFlag 
 * @description:获取首页和上一页的显示状态
 * @author: li_zhenzhong
 * @param nowPage 当前页码
 * @param fyCountPage 总页数
 * @returns {String} 
 * @date：2012-9-7上午11:32:33
 */
Yjxx.getFyBeforeButtonFlag = function (nowPage,fyCountPage){
	if(nowPage==1||fyCountPage==1){
		return "disabled";
	}else
		return "";
};

/**
 * 
 * @title: getFyNextButtonFlag 
 * @description:获取尾页和下一页的显示状态
 * @author: li_zhenzhong
 * @param nowPage 当前页
 * @param fyCountPage 总页数
 * @returns {String} 
 * @date：2012-9-7上午11:31:59
 */
Yjxx.getFyNextButtonFlag = function (nowPage,fyCountPage){
	if(nowPage==fyCountPage||fyCountPage==1){
		return "disabled";
	}else
		return "";
};
/**
 * 
 * @title: fyFun_first 
 * @description:首页事件
 * @author: li_zhenzhong
 * @param fyCounts 总数
 * @param fyNum 每页显示行数
 * @param fun 回调函数
 * @date：2012-9-7上午11:31:28
 */
Yjxx.fyFun_first = function (fyCounts,fyNum,fun){
	fun(fyCounts,1,fyNum*1,1);
};
/**
 * 
 * @title: fyFun_before 
 * @description:上一页事件
 * @author: li_zhenzhong
 * @param fyCounts  总数
 * @param fyNum 每页显示行数
 * @param nowPage 当前页
 * @param fun    回调函数
 * @date：2012-9-7上午11:31:08
 */
Yjxx.fyFun_before = function (fyCounts,fyNum,nowPage,fun){
	fun(fyCounts,(nowPage-2)*fyNum+1,(nowPage-1)*fyNum,nowPage-1);
};
/**
 * 
 * @title: fyFun_next 
 * @description:下一页事件
 * @author: li_zhenzhong
 * @param fyCounts 总数
 * @param fyNum  每页显示数
 * @param nowPage 当前页
 * @param fun 回调函数
 * @date：2012-9-7上午11:29:05
 */
Yjxx.fyFun_next = function (fyCounts,fyNum,nowPage,fun){
	fun(fyCounts,nowPage*fyNum+1,(nowPage+1)*fyNum,nowPage+1);
};
/**
 * 
 * @title: fyFun_end 
 * @description:最后一页
 * @author: li_zhenzhong
 * @param fyCounts 总数
 * @param fyNum  每页显示数
 * @param fyCountPage 总页数
 * @param fun 
 * @date：2012-9-7上午11:28:58
 */
Yjxx.fyFun_end = function (fyCounts,fyNum,fyCountPage,fun){
	fun(fyCounts,(fyCountPage-1)*fyNum+1,fyCountPage*fyNum,fyCountPage);
};
/**
 * 
 * @title: fyFun_go 
 * @description: 跳转页数
 * @author: li_zhenzhong
 * @param fyCounts 总数
 * @param fyNum 每页显示数
 * @param fyCountPage 总页数
 * @param fun 回调函数
 * @date：2012-9-7上午11:28:51
 */
Yjxx.fyFun_go = function (fyCounts,fyNum,fyCountPage,fun){
	var goPage = $("#nowPage").val();
	if(goPage<1||goPage>fyCountPage){
		$.messager.alert("提示","跳转页数超出范围");
		$("#nowPage").val(goPage);
		return;
	}
	if(goPage==1){
		Yjxx.fyFun_first(fyCounts,fyNum,fun);
	}else if(goPage == fyCountPage){
		Yjxx.fyFun_end(fyCounts,fyNum,fyCountPage,fun);
	}
	fun(fyCounts,(goPage-1)*fyNum+1,goPage*fyNum,goPage);
};
/********************************************分页插件结束*****************************************/





/**
 * @title:changeOtherDivShow
 * @description:改变附加信息框显示状态
 * @author:li_zhenzhong
 * @date:2015-4-23上午10:42:07
 */
Yjxx.changeOtherDivShow = function(){
	if($("#otherDiv").height()>=30){
		$("#otherDiv").animate({height:'20px'},"normal")
		$(".toggleOtherDiv").html('弹出');
	}
	else{
		$("#otherDiv").animate({height:'+340px'},"normal")
		$(".toggleOtherDiv").html('收起');
	}
	$("#otherInfoDiv").toggle();
}
/**
 * @title:initOtherDivShow
 * @description:还原附加信息窗口
 * @author:li_zhenzhong
 * @date:2015-4-29上午11:12:30
 */
Yjxx.initOtherDivShow = function(){
	$("#otherDiv").animate({height:'20px'},"normal")
	$(".toggleOtherDiv").html('弹出');
	$("#otherInfoDiv").hide();
	$("#otherInfoDiv").html("<div id='otherInfoListDiv'></div>");
}

/**
 * @title:queryOtherInfo
 * @description:显示其他信息内容
 * @author:li_zhenzhong
 * @param funName
 * @date:2015-4-29上午11:05:04
 */
Yjxx.queryOtherInfo = function(funName){
	if($("#otherInfoDiv").css("display")=="none"){
		$("#otherDiv").animate({height:'+320px'},"normal",null,function(){funName()})
		$(".toggleOtherDiv").html('收起');
		$("#otherInfoDiv").toggle();
	}else{
		funName();
	}
}
/**
 * @method:changeCzfkTypeHtml
 * @package:syrk/js/qbld	
 * @description:根据反馈内容显示不同数据项
 * @param val
 * @author:Li_Zhenzhong
 * @date:2015-5-6下午4:44:57
 * @return:void
 */
Yjxx.changeCzfkTypeHtml = function(val){
	var showObj = null;
	var hideObj = null;
	if(val==0){
		showObj = $(".wfxTr");
		hideObj = $(".yfxTr");
	}else{
		showObj = $(".yfxTr");
		hideObj = $(".wfxTr");
	}
	for(var i = 0;i<showObj.length;i++){
		$(showObj[i]).show();
	}
	for(var i = 0;i<hideObj.length;i++){
		$(hideObj[i]).hide();
	}
}
/**
 * @method:countTime
 * @package:syrk/js/qbld	
 * @description:TODO
 * @param time
 * @param time2
 * @returns 时间差，时间为0时范围“已超时”。
 * @author:Li_Zhenzhong
 * @date:2015-5-6下午4:59:13
 */
Yjxx.countTime = function(time){
	if(time&&time.length==14){
		time = time.substring(0,4)+"/"+time.substring(4,6)+"/"+time.substring(6,8)+" "+time.substring(8,10)+":"+time.substring(10,12)+":"+time.substring(12,14);
		var date1 = new Date();
		var date2 = new Date(time);
		var date3 = date2.getTime()-date1.getTime();
		var hours = Math.floor(date3/(3600*1000));
		var leave = date3%(3600*1000);
		var minutes = Math.floor(leave/(60*1000));
		return hours<=0&&minutes<=0?"超时":hours+":"+minutes;
	}else
		return "时间格式错误";
}
/**
 * @method:openMapWindow
 * @package:syrk/js/qbld	
 * @description:显示地图位置
 * @param x
 * @param y
 * @author:Li_Zhenzhong
 * @date:2015-6-15下午4:24:02
 */
Yjxx.openMapWindow = function(x, y, dwmc){
	$('#bigMapDiv').show();
	$('#bigMapframe').attr("src",contextPath+"/forward/qbld|map?zbx="+x+"&zby="+y + "&dwmc=" + dwmc)
	$('#bigMapDiv').window({   
		title:'地图定位',
		top:10,
	    width:650,    
	    height:550, 
	    collapsible:false,
	    minimizable:false,
	    maximizable:true,
	    resizable:false,
	    modal:true   
	});
	
}