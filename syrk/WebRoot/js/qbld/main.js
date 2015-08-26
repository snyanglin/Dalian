if(typeof Main =="undefined" || !Main){
	Main = {};
}

/**
 * @title:changeListColor
 * @description:改变列表移入移出颜色
 * @author:li_zhenzhong
 * @param obj
 * @date:2015-4-23上午8:53:59
 */
Main.changeListColor = function(obj){
	if($(obj).css("background-color")=="rgb(255, 255, 255)"||$(obj).css("background-color")=="#fff")
		$(obj).css("background-color","#ffff00");
	else if($(obj).css("background-color")=="rgb(255, 255, 0)"||$(obj).css("background-color")=="#ffff00")
		$(obj).css("background-color","#FFF");
};
Main.clickListToChangeColor = function(obj){
	$(".infoOne_tr").css("background-color","#fff");
	$(obj).css("background-color","#f4f4f4");
}
Main.initChangeListColor = function(){
	$(".infoOne_tr").hover(function(){
		Main.changeListColor(this);
	},function(){
		Main.changeListColor(this);
	})
}
/**
 * @title:changeOtherDivShow
 * @description:改变附加信息框显示状态
 * @author:li_zhenzhong
 * @date:2015-4-23上午10:42:07
 */
Main.changeOtherDivShow = function(){
	if($("#otherDiv").height()>=30){
		$("#otherDiv").animate({height:'20px'},"normal")
		$(".toggleOtherDiv").html('弹出');
	}
	else{
		$("#otherDiv").animate({height:'+320px'},"normal")
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
Main.initOtherDivShow = function(){
	$("#otherDiv").animate({height:'20px'},"normal")
	$(".toggleOtherDiv").html('弹出');
	$("#otherInfoDiv").hide();
	$("#otherInfoDiv").html("<div id='otherInfoListDiv'></div>");
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
Main.showfy = function (counts,num,nowPage,toPage){
	var fyCount =counts;
	var fyCountPage = Main.getPages(fyCount,num);//获取总页数
	var fyBeforeButtonFlag = Main.getFyBeforeButtonFlag(nowPage,fyCountPage);
	var fyNextButtonFlag = Main.getFyNextButtonFlag(nowPage,fyCountPage);
	var fyGoButtonFlag = fyCountPage==1?"disabled":"";
	var fyHtml = "<table class='fyTable'>"
		+ "<tr>"
		+ "	<td align='center' ><img id='firstButton' "+fyBeforeButtonFlag+" src='"+contextPath+"/images/qbld/fenye/page-first-"+fyBeforeButtonFlag+".gif' style='cursor:hand'  onclick='Main.fyFun_first("+counts+","+num+","+toPage+")' alt='首页'></img></td>"
		+ "	<td align='center' ><img id='beforeButton' "+fyBeforeButtonFlag+" src='"+contextPath+"/images/qbld/fenye/page-prev-"+fyBeforeButtonFlag+".gif' style='cursor:hand'  onclick='Main.fyFun_before("+counts+","+num+","+nowPage+","+toPage+")' alt='上一页'></img></td>"
		+ "	<td align='center' ><img id='nextButton' "+fyNextButtonFlag+" src='"+contextPath+"/images/qbld/fenye/page-next-"+fyNextButtonFlag+".gif' style='cursor:hand' onclick='Main.fyFun_next("+counts+","+num+","+nowPage+","+toPage+")' alt='下一页'></img></td>"
		+ "	<td align='center' ><img id='endButton' "+fyNextButtonFlag+" src='"+contextPath+"/images/qbld/fenye/page-last-"+fyNextButtonFlag+".gif' style='cursor:hand' onclick='Main.fyFun_end("+counts+","+num+","+fyCountPage+","+toPage+")' alt='尾页'></img></td>"
		+ "	<td align='center' >第<input id='nowPage' " + fyGoButtonFlag + " value='"+nowPage+"' style='width:40px' >页<img src='"+contextPath+"/images/qbld/fenye/send.gif' "+fyGoButtonFlag+" style='cursor:hand' onclick='Main.fyFun_go("+counts+","+num+","+fyCountPage+","+toPage+")' alt='跳转'></img></td>"
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
Main.getPages = function (counts,num){
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
Main.getFyBeforeButtonFlag = function (nowPage,fyCountPage){
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
Main.getFyNextButtonFlag = function (nowPage,fyCountPage){
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
Main.fyFun_first = function (fyCounts,fyNum,fun){
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
Main.fyFun_before = function (fyCounts,fyNum,nowPage,fun){
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
Main.fyFun_next = function (fyCounts,fyNum,nowPage,fun){
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
Main.fyFun_end = function (fyCounts,fyNum,fyCountPage,fun){
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
Main.fyFun_go = function (fyCounts,fyNum,fyCountPage,fun){
	var goPage = $("#nowPage").val();
	if(goPage<1||goPage>fyCountPage){
		alert("跳转页数超出范围");
		$("#nowPage").val(goPage);
		return;
	}
	if(goPage==1){
		Main.fyFun_first(fyCounts,fyNum,fun);
	}else if(goPage == fyCountPage){
		Main.fyFun_end(fyCounts,fyNum,fyCountPage,fun);
	}
	fun(fyCounts,(goPage-1)*fyNum+1,goPage*fyNum,goPage);
};
/********************************************分页插件结束*****************************************/
Main.changeOpClass = function(obj){
	$("#zdyOpMenu div.on").removeClass("on");
	$(obj).addClass("on");
}
