/**
 * require jQuery
 * require SysTool
 */
SysTool.loadComponentsFile("stateControl", "stateControl",".css");
var StateControl={
		/**
		 * 接收传入的div id值
		 */
		div:null,
		/**
		 * 数字变化计时器
		 */
		timer:null,
		/**
		 * 我的警情和全部警情（所辖单位）切换标识
		 */
		myorallFlag:"MY",
		
		/**
		 * 当前点击的状态绑定事件的元素
		 */
		thisState:"lf_menu_1",
		
		/**
		 * 
		  * @param {String} 容器层divid
		  * @param {Function} 初始化完成后的回调函数
		 */
		init:function(divId, callbackFunc){
			StateControl.div=divId;
			$("#"+divId).find(".btn_lftshow").nextAll().remove();
			$("#"+divId).append("<div class='lf_menu_div'><ul class='lf_menu_ul'></ul></div>");
			for(var i=1;i<9;i++){
				$("#"+divId+" ul").append("<li><div class='dynamicNum' id='dynamicNum_"+i+"'></div><a class='lf_menu_"+i+"' href='javascript:;' title='"+this.getChineseByIdx(i)+" ：0 条' oldcount='0'>0</a></li>").slideDown();
			}
			$("#"+divId+" ul").append("<li class='li_onb'></li>");
			$("#"+divId).append("<a class='lf_myorall' id='idlf_myorall' title='我的警情'></a><a class='lf_myorallb' title='全部警情'></a>");
			$("#"+divId).append("<a class='lf_more' id='idlf_more'></a><a class='lf_moreb'></a>");
			
			$("#"+divId+" ul li").hover(
				function() {
					var offtop=$(this).index();
					$(".li_onb").each(function() {
			                $.dequeue(this, "fx"); }
			         ).animate({
			                top: offtop*45
			         }, 100, "linear");
		        },
		        function() {
					var onlilf=$(".lf_menu_ul").find(".li_on").index();
					if(onlilf>=0){
						$(".li_onb").each(function() {
			                $.dequeue(this, "fx"); }
			            ).animate({
			                top: onlilf*45
			            }, 100, "linear");
					}else{
						$(".li_onb").each(function() {
			                $.dequeue(this, "fx"); }
			            ).animate({
			                top: 0
			            }, 100, "linear");
					}
		        }
			);
			
			$(".lf_myorall").bind("click",function(){
				var that=this;
				$(that).hide();
				$(".lf_myorallb").show();
				StateControl.myorallFlag = "ALL";
				callbackFunc();
			});
			
			$(".lf_myorallb").bind("click",function(){
				var that=this;
				$(that).hide();
				$(".lf_myorall").show();
				StateControl.myorallFlag = "MY";
				callbackFunc();
			});
			
			$(".lf_more").bind("click",function(){
				var that=this;
				var t=$(".lf_menu_ul").position().top;
				var h=parseInt($(".lf_menu_ul").height())-parseInt($(".lf_menu_div").height()-parseInt($("#idlf_myorall").height())-parseInt($("#idlf_more").height()));
				var h0=h;
				var h_ul=parseInt($(".lf_menu_ul").height());
					if(h>(4*45)){
						h=4*45;
					}
					if(t<0){
						h=h_ul-(((-t/(4*45))+1)*225);
					}
					t=t-h;
					$(".lf_menu_ul").animate({top:t},function(){
						if(t>=-h0){
							$(that).hide();
							$(".lf_moreb").show();
						}
					});
					
			});
			$(".lf_moreb").bind("click",function(){
				var that=this;
				var tb=$(".lf_menu_ul").position().top;
				var h=parseInt($(".lf_menu_ul").height())-parseInt($(".lf_menu_div").height()-parseInt($("#idlf_myorall").height())-parseInt($("#idlf_more").height()));
				var ho=h;
				if(((tb/45)%4)!=0){
					var y=(h/45)%4;
					h=y*45;
				}else{
					h=4*45;
				}
				tb=tb+h;
				if(tb>0){
					tb=0;
				}
				$(".lf_menu_ul").animate({top:tb},function(){
					if(tb==0){
						$(".lf_moreb").hide();
						$(".lf_more").show();
					}
				});
			});
			callbackFunc();
		},
		
		/**
		 * 改变多个警情状态数量
		 * @param {Object} param JSON对象([{分隔数字，超过使用‘+’号:"9",类型:"gray",新数量:data.count.wdwCount}]) ([{splitNum:"9",type:"gray",count:data.count.wdwCount}])
		 */
		moreNumberChanage:function(param) {
			var isChanage = false;
			for(var i = 0; i < param.length; i++) {
				var type = param[i].type;
				var idx = this.getIdxByType(type);
				var oldCount = parseInt($(".lf_menu_"+idx).attr("oldcount"));
				var newCount = param[i].count;
				var changeCount = newCount - oldCount;
				if(changeCount > 0){
					$("#dynamicNum_"+idx).text("+"+changeCount);
					isChanage = true;
				}else if(changeCount<0){
					$("#dynamicNum_"+idx).text(changeCount);
					isChanage = true;
				}
				// 刷新警情列表
				Jqxx.refreshJqxxToList({isChanage: isChanage, changeCount: changeCount, stateControlType: idx, loopIndex : i, loopTotalCount: param.length});
			}
			if(isChanage){
				this.dynamicNum(function(){
					for(var i = 0; i < param.length; i++) {
						var splitNum = param[i].splitNum;
						var newCount = param[i].count;
						var type = param[i].type;
						var idx = StateControl.getIdxByType(type);
						if(newCount>splitNum){
							$(".lf_menu_"+idx).text(splitNum+"+");
						}else{
							$(".lf_menu_"+idx).text(newCount<0?0:newCount);
						}
						$(".lf_menu_"+idx).attr("title",StateControl.getChineseByIdx(idx)+"："+newCount+" 条");
						$(".lf_menu_"+idx).attr("oldcount",newCount<0?0:newCount);
						$("#dynamicNum_"+idx).text("").css("left","50px");
					}
					if (Jqxq.isClickXq) {
						StateControl.clickThisState();
						Jqxq.isClickXq = false;
					}
				});
			}
		},
		
		/**
		 * 改变单个警情状态数量
		 * @param {Object} param JSON对象({分隔数字，超过使用‘+’号:"9",类型:"gray",新数量:data.count.wdwCount}) ([{splitNum:"9",type:"gray",count:data.count.wdwCount})
		 */
		oneNumberChange:function(param){
			var isChanage = false;
			var type = param.type;
			var idx = this.getIdxByType(type);
			var splitNum = param.splitNum;
			var oldCount = parseInt($(".lf_menu_"+idx).attr("oldcount"));
			var newCount = param.count;
			var changeCount = newCount - oldCount;
			if(changeCount > 0){
				$("#dynamicNum_"+idx).text("+"+changeCount);
				isChanage = true;
			}else if(changeCount<0){
				$("#dynamicNum_"+idx).text(changeCount);
				isChanage = true;
			}
			if(isChanage){
				this.dynamicNum(function(){
					if(newCount>splitNum){
						$(".lf_menu_"+idx).text(splitNum+"+");
					}else{
						$(".lf_menu_"+idx).text(newCount<0?0:newCount);
					}
					$(".lf_menu_"+idx).attr("title",StateControl.getChineseByIdx(idx)+"："+newCount+" 条");
					$(".lf_menu_"+idx).attr("oldcount",newCount<0?0:newCount);
					$("#dynamicNum_"+idx).text("").css("left","50px");
				});
			}
		},
		/**
		 * 
		 * @param {String} type 警情状态 "gray"：未定位，"red"\ "orange" "blue" "green" "all", "favorite" "my"
		 * @param {Function} func 为每个警情状态绑定的处理事件
		 */
		setFunction:function(type,func){
			switch (type){
			case "gray" :
				$(".lf_menu_1").bind("click",function(){
					$("#"+StateControl.div+" ul").children(".li_on").removeClass();
					$(".lf_menu_1").parent().addClass("li_on");
					if (!Jqxq.isClickXq) {
						//未定位时打开列表
						LeftLayout.showLefLayout();
					}
					StateControl.thisState = "lf_menu_1";
					func();
				});
				break;
			case "red" :
				$(".lf_menu_2").bind("click",function(){
					$("#"+StateControl.div+" ul").children(".li_on").removeClass();
					$(".lf_menu_2").parent().addClass("li_on");
					StateControl.thisState = "lf_menu_2";
					func();
				});
				break;
			case "orange":
				$(".lf_menu_3").bind("click",function(){
					$("#"+StateControl.div+" ul").children(".li_on").removeClass();
					$(".lf_menu_3").parent().addClass("li_on");
					StateControl.thisState = "lf_menu_3";
					func();
				});
				break;
			case "blue":
				$(".lf_menu_4").bind("click",function(){
					$("#"+StateControl.div+" ul").children(".li_on").removeClass();
					$(".lf_menu_4").parent().addClass("li_on");
					StateControl.thisState = "lf_menu_4";
					func();
				});
				break;
			case "green":
				$(".lf_menu_5").bind("click",function(){
					$("#"+StateControl.div+" ul").children(".li_on").removeClass();
					$(".lf_menu_5").parent().addClass("li_on");
					StateControl.thisState = "lf_menu_5";
					func();
				});
				break;
			case "all":
				$(".lf_menu_6").bind("click",function(){
					$("#"+StateControl.div+" ul").children(".li_on").removeClass();
					$(".lf_menu_6").parent().addClass("li_on");
					StateControl.thisState = "lf_menu_6";
					func();
				});
				break;
			case "favorite":
				$(".lf_menu_7").bind("click",function(){
					$("#"+StateControl.div+" ul").children(".li_on").removeClass();
					$(".lf_menu_7").parent().addClass("li_on");
					StateControl.thisState = "lf_menu_7";
					func();
				});
				break;
			case "ejcj":
				$(".lf_menu_8").bind("click",function(){
					$("#"+StateControl.div+" ul").children(".li_on").removeClass();
					$(".lf_menu_8").parent().addClass("li_on");
					StateControl.thisState = "lf_menu_8";
					func();
				});
				break;
			}
			
		},
		/**
		 * @param type {String} 警情类型
		 */
		remove:function(type){
			switch (type){
			case "gray" :
				$(".lf_menu_1").parent().remove();
				break;
			case "red" :
				$(".lf_menu_2").parent().remove();
				break;
			case "orange":
				$(".lf_menu_3").parent().remove();
				break;
			case "blue":
				$(".lf_menu_4").parent().remove();
				break;
			case "green":
				$(".lf_menu_5").parent().remove();
				break;
			case "all":
				$(".lf_menu_6").parent().remove();
				break;
			case "favorite":
				$(".lf_menu_7").parent().remove();
				break;
			case "ejcj":
				$(".lf_menu_8").parent().remove();
				break;
			}
		},
		
		/**
		 * 根据状态类型取得索引号
		 * @param {String} type 状态类型
		 * @returns {Number} 索引号
		 */
		getIdxByType:function(type){
			switch (type){
			case "gray" :
				return 1;
				break;
			case "red" :
				return 2;
				break;
			case "orange":
				return 3;
				break;
			case "blue":
				return 4;
				break;
			case "green":
				return 5;
				break;
			case "all":
				return 6;
				break;
			case "favorite":
				return 7;
				break;
			case "ejcj":
				return 8;
				break;
			}
		},
		
		/**
		 * 根据索引号取得中文提示关键字
		 * @param idx
		 * @returns {String}
		 */
		getChineseByIdx:function(idx){
			switch (idx){
			case 1 :
				return "未定位";
				break;
			case 2 :
				return "未派警";
				break;
			case 3:
				return "未到达";
				break;
			case 4:
				return "未反馈";
				break;
			case 5:
				return "已完成";
				break;
			case 6:
				return "全部";
				break;
			case 7:
				return "已收藏";
				break;
			case 8:
				return "二级处警";
				break;
			}
		},
		
		/**
		 * 
		 * @param myclass {String} 自定义的class 样式名称
		 * @param func {Function} 添加绑定的事件函数
		 */
		add:function(myclass,func){
			$("#"+StateControl.div+" ul").append("<li><a class='"+myclass+"'></a></li>");
			$("."+myclass).bind("click",func);
		},
		
		/**
		 * 数量变化动画
		 * @param {Function}  callbackFunc 回调函数
		 */
		dynamicNum:function(callbackFunc){
			$(".lf_menu_div").css("width","103px");
			$(".lf_menu_ul").css("width","103px");
			$(".lf_menu_ul li").css("width","103px");
			$(".dynamicNum").animate({
				left:"0px",
				fontSize:"12pt"
			},500).css("left","50px");
			$(".dynamicNum").css("left","50px");
			timer = setTimeout(function(){
				$(".lf_menu_div").css("width","53px");
				$(".lf_menu_ul").css("width","53px");
				$(".lf_menu_ul li").css("width","53px");
				$(".dynamicNum").css("left","50px");
				$(".dynamicNum").css("font-size","16pt");
				callbackFunc();
			},500);
		},
		
		/**
		 * 单击当前状态
		 */
		clickThisState : function() {
			$("." + this.thisState).click();
		}
};