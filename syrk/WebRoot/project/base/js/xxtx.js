/*!
 * 消息提醒JS
 * znjg - v1.0.0 (2014-04-18 14:22)
 * Copyright(c) 2014 founder
 */

/**
 * @classDescription 消息提醒全局对象
 * @author yichu
 */
var Xxtx = {
	
	/**
	 * 是否隐藏消息提醒div
	 */
	isHidden : false,
	
	/**
	 * 当前消息类型代码
	 */
	currXxlxdm : "",
	
	/**
	 * 不出滚动条能显示的消息条数
	 */
	showCount : 10,
	
	/**
	 * 消息提醒div宽度
	 */
	messageContainerDivWidth : 820,
	
	/**
	 * 消息提醒div高度
	 */
	messageContainerDivHeight : 276,
	
	/**
	 * 消息提醒内容div高度
	 */
	messageContainerContentDivHeight : 232,
	
	/**
	 * 消息提醒div修正宽度
	 */
	offsetWidth : 18,
	
	/**
	 * 消息提醒div修正高度
	 */
	offsetHeight : 2,
	
	/**
	 * 初始化消息提醒
	 * @param {String} xxtxContainerId 消息提醒容器id
	 */
	initXxtx : function(xxtxContainerId) {
		//Clbk.showJkd('123156626');
		SysTool.ajax({
			url: "xxtxtj/queryXxtxtjByJsrid.f",
	  		data: {}
	    }, function(data) {
	    	var htmlString = "";
	    	if ("undefined" != typeof data.list && data.list != null) {
	    		if (data.list.length > 0) {
	    			for (var i = 0; i < data.list.length; i++) {
	    				if (data.list[i].xxts == 0) {
	    					htmlString += "<li class='linot'>" + data.list[i].xxlxmc + "：<span id='" + data.list[i].xxlxdm + "_xxts'>" + data.list[i].xxts + "</span>条</li>";
	    				} else {
	    					htmlString += "<li style='cursor:pointer;' onclick='javascript:Xxtx.showList(\"" + data.list[i].xxlxdm + "\", \"" + data.list[i].xxlxmc + "\");'>" + data.list[i].xxlxmc + "：<span id='" + data.list[i].xxlxdm + "_xxts'>" + data.list[i].xxts + "</span>条</li>";
	    				}
	    				if ("undefined" != typeof $("#" + data.list[i].xxlxdm + "_xxts")) {
	    					var oldCount = parseInt($("#" + data.list[i].xxlxdm + "_xxts").text());
	    					if (oldCount < data.list[i].xxts) {
	    						SysTool.ajax({
		    						url: "xxtx/queryXxtxListByJsridAndXxlxdm.f",
		    				  		data: {"xxlxdm": data.list[i].xxlxdm}
		    				    }, function(data1) {
		    				    	if ("undefined" != typeof data1.list && data1.list != null) {
		    				    		for (var j = data1.list.length - 1; j >= oldCount; j--) {
		    				    			var xxtxid = "undefined" == typeof data1.list[j].xxtxid ? "" : data1.list[j].xxtxid;// 消息提醒ID
			    				    		var ywbh = "undefined" == typeof data1.list[j].ywbh ? "" : data1.list[j].ywbh;// 业务编号
			    							var clzt = "undefined" == typeof data1.list[j].clzt ? "" : data1.list[j].clzt;// 处理状态（0未读、1已读未处理、2已处理）
			    							var xxlxdm = "undefined" == typeof data1.list[j].xxlxdm ? "" : data1.list[j].xxlxdm;// 消息类型代码
			    				    		var xxnr = "undefined" == typeof data1.list[j].xxnr ? "" : data1.list[j].xxnr;// 消息内容
			    				    		var messageRemindString = "<span style='cursor:pointer;' onclick='javascript:Xxtx.dealWithXxtx(\"" + xxlxdm + "\", \"" + xxtxid + "\", \"" + ywbh + "\", \"" + clzt + "\", 1);'>" + xxnr + "</span>";
			    				    		$.messager.show({title: '系统提示', 	msg: messageRemindString, height: 150, timeout: 5000, showType: 'slide'	});
		    				    		}
		    				    	}
		    				    });
	    					}
    					}
		    		}
	    			// 消息提醒li绑定鼠标移动及鼠标移出事件
	    			$("#" + xxtxContainerId).find("li").each(function(i) {
	    				$(this).mousemove(function() {
    	    				if ($("#messageContainerDiv").is(":visible")) {
    	    					Xxtx.isHidden = false;
    	    				}
    	    			}).mouseout(function() {
    	    				if ($("#messageContainerDiv").is(":visible")) {
    	    					Xxtx.isHidden = true;
    	    				}
    	    			});
	    			});
	    		}
	    	}
	    	//路况报警消息提醒
	    	var param={};/*ajax参数*/
	    	var param1={};/*传递参数*/
	    	//组织机构代码
	    	param1['ssjgdm']=jjrdwbh;
	    	param1['userid']=jjrbh;
	    	param.url="lkbj/lkbjCount.f";
	    	param.data=param1;
	    	SysTool.ajax(param,function(reDa) {  
	    		var bjzs=0;/*报警总数*/
	    		var lkbjxq="";/*路况报警详情*/
	    		for(var i=0,len=reDa.length;i<len;i++) {
	    			bjzs+=parseInt(reDa[i].tjsl);
	    			lkbjxq+="<li class='lkbjxq' style='cursor:pointer;display:none;' " +
	    					"onclick='javascript:jtts.queryLdxxByflowlevel("+reDa[i].flowlevel+");'>" +
	    							"<span>"+reDa[i].levelname+"："+reDa[i].tjsl+"</span>条</li>";
	    		}
	    		if(bjzs === 0)
	    			htmlString+="<ul class='navul'><li class='linot'><span>路况报警："+bjzs+"</span>条</li>";
	    		else{
	    			htmlString+="<ul class='navul'><li class='lione' id='lkbj' style='cursor:pointer;'><span>路况报警："+bjzs+"</span>条</li>";
	    			htmlString+=lkbjxq;
	    			htmlString+="</ul>"; 
	    			if(bjzs != $("#bjzs").val()) {//如果上一次数量和本次不相等
	    				$("#bjzs").val(bjzs);
	    				SysTool.show('当前有<a>'+bjzs+"</a>条路段状态发生变化!");
	    			}
	    		}
	    			
	    		$("#" + xxtxContainerId).html(htmlString);
	    		//移除click
	    		$('#lkbj').unbind("click"); 
	    		//事件注册
	    		$("#lkbj").click(function() {
	    			//报警路段详情查看
	    			if($('#module_交通秩序>a').attr('class') !== 'aon') {
	    				$('#module_交通秩序>a').click();
	    			} 
	    			var tempClock=window.setInterval(function() {
	    				if($("#jttsTableSslk").length && $("#jttsTableLkbj").length) {
	    					$("#jttsTableLkbj").click();
		    				window.clearInterval(tempClock);
	    				}
	    			}, 1000);
	    		});
	    	});
	    });
	},
	
	/**
	 * 显示列表
	 * @param {String} xxlxdm 消息类型代码
	 * @param {String} xxlxmc 消息类型名称
	 */
	showList : function(xxlxdm, xxlxmc) {
		if (this.currXxlxdm == xxlxdm) {
			if ($("#messageContainerDiv").is(":visible")) {
				$("#messageContainerDiv").hide("300", function() {
					Xxtx.isHidden = false;
					Xxtx.currXxlxdm = "";
					$("#messageContainerDiv").html("");
					$("#messageContainerDiv").width(Xxtx.messageContainerDivWidth);
					$("#messageContainerDiv").height(Xxtx.messageContainerDivHeight);
				});
			}
		} else {
			if ($("#messageContainerDiv").is(":visible")) {
				$("#messageContainerDiv").hide("300", function() {
					Xxtx.isHidden = false;
					Xxtx.currXxlxdm = "";
					$("#messageContainerDiv").html("");
					$("#messageContainerDiv").width(Xxtx.messageContainerDivWidth);
					$("#messageContainerDiv").height(Xxtx.messageContainerDivHeight);
					
					Xxtx.createList(xxlxdm, xxlxmc);
				});
			} else {
				this.createList(xxlxdm, xxlxmc);
			}
		}
	},
	
	/**
	 * 生成列表
	 * @param {String} xxlxdm 消息类型代码
	 * @param {String} xxlxmc 消息类型名称
	 */
	createList : function(xxlxdm, xxlxmc) {
		SysTool.ajax({
			url: "xxtx/queryXxtxListByJsridAndXxlxdm.f",
	  		data: {"xxlxdm": xxlxdm}
	    }, function(data) {
	    	if ("undefined" != typeof data.list && data.list != null) {
	    		if (data.list.length > Xxtx.showCount) {
    				$("#messageContainerDiv").width(Xxtx.messageContainerDivWidth + Xxtx.offsetWidth);
	    		} else {
	    			$("#messageContainerDiv").height($("#messageContainerDiv").height() - (Xxtx.messageContainerContentDivHeight / (Xxtx.showCount + 1) + Xxtx.offsetHeight) * (Xxtx.showCount - data.list.length));
	    		}
	    		var htmlString = "";
	    		//htmlString += "<div class='xxtx_divtitle'><strong>消息提醒：</strong>" + xxlxmc + "</div><div class='xxtx_divct'><table align='center' border='0' width='800' cellpadding='1' cellspacing='1' bgcolor='#e1f1ff' id='zhdd_xxtxTable'>";
	    		htmlString += "<div class='xxtx_divct'><table align='center' border='0' width='800' cellpadding='1' cellspacing='1' bgcolor='#e1f1ff' id='zhdd_xxtxTable'>";
    	    	htmlString += "<tr bgcolor='#badaf1'><th width='30' align='center'>序号</th><th align='center'>消息内容</th><th width='70' align='center'>发送人</th><th width='120' align='center'>接收时间</th></tr>";
    	    	for (var i = 0; i < data.list.length; i++) {
		    		var xh = i + 1;// 序号
		    		var xxtxid = "undefined" == typeof data.list[i].xxtxid ? "" : data.list[i].xxtxid;// 消息提醒ID
		    		var ywbh = "undefined" == typeof data.list[i].ywbh ? "" : data.list[i].ywbh;// 业务编号
		    		var xxnr = "undefined" == typeof data.list[i].xxnr ? "" : data.list[i].xxnr;// 消息内容
					var fsrm = "undefined" == typeof data.list[i].fsrm ? "" : data.list[i].fsrm;// 发送人
					var jssj = "undefined" == typeof data.list[i].jssj ? "" : SysTool.getDateTimeFormat(data.list[i].jssj);// 接收时间
					var clzt = "undefined" == typeof data.list[i].clzt ? "" : data.list[i].clzt;// 处理状态（0未读、1已读未处理、2已处理）
					var clztTranslation = "";
					var color = "";
					if (clzt == "0") {
						clztTranslation = "<div class='xxwd' title='未读'></div>";
						color = "#000000";
					} else if (clzt == "1") {
						clztTranslation = "<div class='xxyd' title='已读未处理'></div>";
						color = "#999999";
					} else if (clzt == "2") {
						clztTranslation = "已处理";
						color = "#cccccc";
					}
					htmlString += "<tr style='color:" + color + "' id='" + xxtxid + "_tr'>";
					htmlString += "<td width='30' align='center'>" + xh + "</td>";
					htmlString += "<td><div class='trhover'>";
					if (clzt == "0") {
						htmlString += "<div class='xxtx_xf' onclick='javascript:Xxtx.dealWithXxtx(\"" + xxlxdm + "\", \"" + xxtxid + "\", \"" + ywbh + "\", \"" + clzt + "\", 0);' id='" + xxtxid + "_xfDiv'>"+ clztTranslation +"</div>";
					} else {
						htmlString += "<div class='xxtx_xf_open' id='" + xxtxid + "_xfDiv'>"+ clztTranslation +"</div>";
					}
					htmlString += "<div class='xxtx_text' style='padding:0 5px;' onclick='javascript:Xxtx.dealWithXxtx(\"" + xxlxdm + "\", \"" + xxtxid + "\", \"" + ywbh + "\", \"" + clzt + "\", 1);' title='" + xxnr + "'>" + xxnr + "</div></div></td>";
					htmlString += "<td width='70' align='center'>" + fsrm + "</td>";
					htmlString += "<td width='120' align='center'>" + jssj + "</td></tr>";
		    	}
		    	htmlString += "</table></div>";
		    	$("#messageContainerDiv").html(htmlString);
		    	$("#messageContainerDiv").show("300", function() {
					Xxtx.isHidden = true;
					Xxtx.currXxlxdm = xxlxdm;
					$("#messageContainerDiv").mousemove(function() {
						Xxtx.isHidden = false;
					}).mouseout(function() {
						Xxtx.isHidden = true;
					});
					$(document).click(function() {
						if ($("#messageContainerDiv").is(":visible") && Xxtx.isHidden) {
							$("#messageContainerDiv").hide("300", function() {
								Xxtx.isHidden = false;
								Xxtx.currXxlxdm = "";
								$("#messageContainerDiv").html("");
								$("#messageContainerDiv").width(Xxtx.messageContainerDivWidth);
								$("#messageContainerDiv").height(Xxtx.messageContainerDivHeight);
							});
						}
					});
				});
	    	}
	    });
	},
	
	/**
	 * 处理消息提醒
	 * @param {String} xxlxdm 消息类型代码
	 * @param {String} xxtxid 消息提醒ID
	 * @param {String} ywbh 业务编号
	 * @param {String} clzt 处理状态（0未读、1已读未处理、2已处理）
	 * @param {String} type（0：改变处理状态为1；1：改变处理状态为2，并且处理业务。）
	 */
	dealWithXxtx : function(xxlxdm, xxtxid, ywbh, clzt, type) {
		if (type == 1) {// 改变处理状态为2，并且处理业务
			if (clzt != "2") {
				if (xxtxid == "") {
					SysTool.show("当前消息提醒ID为空，不能进行处理！");
				} else {
					SysTool.ajax({
						url: "xxtx/updateXxztClztByXxtxid.f",
				  		data: {"xxtxid": xxtxid, "clzt": 2}
				    }, function(data) {
				    	if (data.message == "success") {
				    		if ("undefined" != typeof $("#" + xxtxid + "_tr")) {
				    			$("#" + xxtxid + "_tr").remove();
				    		}
				    		if ("undefined" != typeof $("#" + xxlxdm + "_xxts")) {
				    			$("#" + xxlxdm + "_xxts").text(parseInt($("#" + xxlxdm + "_xxts").text()) - 1);
				    		}
				    		if ("undefined" != typeof $("#zhdd_xxtxTable")) {
				    			if (($("#zhdd_xxtxTable").find("tr").size() - 1) < Xxtx.showCount) {
					    			$("#messageContainerDiv").height($("#messageContainerDiv").height() - (Xxtx.messageContainerContentDivHeight / (Xxtx.showCount + 1)  + Xxtx.offsetHeight));
					    		} else if (($("#zhdd_xxtxTable").find("tr").size() - 1) == Xxtx.showCount) {
					    			$("#messageContainerDiv").width(Xxtx.messageContainerDivWidth);
					    		}
					    		$("#zhdd_xxtxTable").find("tr").each(function(i) {
					    			if (i > 0) {
					    				$(this).find("td:eq(0)").text(i);
					    			}
					    		});
				    		}
				    		Xxtx.dealWithYw(xxlxdm, ywbh);// 处理业务
				    		//SysTool.show("处理成功！");
				    	} else {
				    		//SysTool.show("处理失败！");
				    	}
				    });
				}
			}
		} else {// 改变处理状态为1
			if (clzt != "1") {
				if (xxtxid == "") {
					SysTool.show("当前消息提醒ID为空，不能进行处理！");
				} else {
					SysTool.ajax({
						url: "xxtx/updateXxztClztByXxtxid.f",
				  		data: {"xxtxid": xxtxid, "clzt": 1}
				    }, function(data) {
				    	if (data.message == "success") {
				    		$("#" + xxtxid + "_xfDiv").html("<div class='xxyd' title='已读未处理'></div>");
				    		$("#" + xxtxid + "_xfDiv").removeClass("xxtx_xf");
				    		$("#" + xxtxid + "_xfDiv").addClass("xxtx_xf_open");
				    		$("#" + xxtxid + "_xfDiv").attr("onclick", "");
				    		$("#" + xxtxid + "_tr").css("color", "#999999");
				    		//SysTool.show("处理成功！");
				    	} else {
				    		//SysTool.show("处理失败！");
				    	}
				    });
				}
			}
		}
		
	},
	
	/**
	 * 处理业务
	 * @param {String} xxlxdm 消息类型代码
	 * @param {int} ywbh 业务编号（PK）
	 */
	dealWithYw : function(xxlxdm, ywbh) {
		if (xxlxdm == SysConfig.MESSAGE_TYPE[0]) {// 警情超时
    		var jqbh = ywbh;// 警情编号
    		if ("undefined" != typeof jqbh && jqbh != null && jqbh != "") {
    			Clbk.jqxxShowInnerMap(jqbh);
    		}
		} else if (xxlxdm == SysConfig.MESSAGE_TYPE[1]) {// 车辆报警
			SysTool.ajax({
				url: "clbkgj/queryTJkdClbkgjByClbkgjid.f",
		  		data: {"clbkgjid": ywbh}
		    }, function(data) {
		    	if (data.count.totalCount == 1) {
		    		var clbkszid = data.list[0].clbkszid;// 车辆布控设置ID
		    		var jqbh = data.list[0].jqbh;// 警情编号
		    		var jkdbm = data.list[0].jkdbm;// 监控点编码
		    		var cpzldm = data.list[0].cpzldm;//车牌种类代码
		    		var cphm = data.list[0].cphm;//车牌号码
//		    		if ("undefined" != typeof clbkszid && clbkszid != null && clbkszid != "") {
//		    			Resource.fireClickFunc("clbk", "project/busiapp/jkd/clbk.jsp", {"jqbh": jqbh, "isLoad": "no"});
//		    			Clbk.showClbkByClbkId(clbkszid);
//		    		}
		    		if ("undefined" != typeof jkdbm && jkdbm != null && jkdbm != "") {
		    			Clbk.showJkd(jkdbm,cpzldm,cphm);
		    		}
		    	}
		    });
		} else if (xxlxdm == SysConfig.MESSAGE_TYPE[2]) {// 报表
			SysTool.show("报表消息【"+ ywbh +"】处理！");
		} else if (xxlxdm == SysConfig.MESSAGE_TYPE[3]) {// 设备
			SysTool.show("设备消息【"+ ywbh +"】处理！");
		} else if (xxlxdm == SysConfig.MESSAGE_TYPE[4]) {// 其他
			SysTool.show("其他消息【"+ ywbh +"】处理！");
		}else if(xxlxdm == SysConfig.MESSAGE_TYPE[5]){//二级处警
			var jqbh = ywbh;// 警情编号
    		if ("undefined" != typeof jqbh && jqbh != null && jqbh != "") {
    			Jqcz.getJqxxByJqbh(jqbh, function(data){
    				Jqxx.ejtxToMap(data,function(marker){
    					MapBubble.currMarker = marker;
    					_MapApp.centerAndZoom(marker.getPoint(),_MapApp.getZoomLevel());
    					MapBubble.addPanOverListener(function(){
    						$("#tipsContent").load("project/zhdd/pages/jqcz.jsp",function() {
    							MapBubble.initBubbleSize(405, 352);
    							
	    						Jqcz.openJqxxWindow(data,function() {
	    							
	    							MapBubble.showBubble();
	    							MapBubble.setBubblePositionByMarker(MapBubble.currMarker);
	    							if(data.ejzt==0){//接收派发消息时
	    								Jqcz.setTabShowFunc(Jqcz.JQCZTAB, false);
	        							Jqcz.setTabShowFunc(["ejqr"], true);
	    							}else if(data.ejzt==2){//派发者接收退回消息时
//	    								Jqcz.ejjqDelete();
//	    								Jqcz.setTabShowFunc(Jqcz.JQCZTAB, false);
//	    								Jqcz.setTabShowFunc(["jqdw","jqyj","ejcj"], true);
	    							}
	    							
	    						});
    						});
    					});
    					
    				});
    			});
    		}
		}
	}
	
};