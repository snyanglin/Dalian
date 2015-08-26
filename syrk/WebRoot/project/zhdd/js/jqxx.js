/*!
 * 警情信息JS
 * znjg - v1.0.0 (2014-03-26 16:50)
 * Copyright(c) 2014 founder
 */

/**
 * @classDescription 警情信息全局对象
 * @author yichu
 */
var Jqxx = {

	/**
	 * 警情信息marker数组
	 */
	markerArray : [],

	/**
	 * 警情信息以marker为中心的圆数组
	 */
	circleArray : [],

	/**
	 * 警情周边marker数组
	 */
	aroundMarkerArray : [],

	/**
	 * 输入关键字的input控件的提示
	 */
	keywordInputPrompt : "请输入关键字查询",

	/**
	 * 是否隐藏高级检索div
	 */
	isHidden : false,

	/**
	 * 显示更多的条数
	 */
	showMoreCount : 10,
	
	/**
	 * 显示更多时的请求JSON对象
	 */
	requestJsonObject : {},
	
	/**
	 * 当前Marker title属性
	 */
	currentMarkerTitle : '',
	
	// 当前点警情信息
	currentPointObject : [null,{}],
	
	/**
	 * 初始化关键字及高级检索
	 */
	initKeywordAndAdvancedSearch : function() {
		Jqxx.initKeywordInput("keyword");// 初始化输入关键字的input控件
		// 关键字检索按钮绑定点击事件
		$("#keywordBtn").click(function() {
			Jqcz.backTo();//返回列表
			Jqxx.keywordSearch({keywordInputId: "keyword"}, function(data, requestParamObj) {// 关键字检索
				Jqxx.loadJqxxToList({
					mapApp : _MapApp,
					showDivId : "contentDivId",
					showTotalCountSpanId : "totalCountSpan"
				}, data, requestParamObj);
				/*
				 * Jqxx.loadJqxxToMap({mapApp: _MapApp, showDivId:
				 * "contentDivId"}, data, function(jsonObject) { var param =
				 * {mapToolId: "mapTool", marker: jsonObject.marker, htmlPath:
				 * "project/zhdd/pages/jqcz.jsp", isCenter: false, enevtType:
				 * "dblclick"}; MapBalloon.bindingMarkerEvent(param, function(){
				 * Jqcz.openJqxxWindow(jsonObject.jqbh, jsonObject.marker); });
				 * });
				 */
				MapBubble.removeAll();
				Jqxx.loadJqxxToMap({}, data, function() {
				});
			});
		}).mousemove(function() {
			$("#keywordDiv").addClass("input_search_on");
		}).mouseout(function() {
			$("#keywordDiv").removeClass("input_search_on");
		});
		/*$("#keyword").focus(function() {
			$("#keywordDiv").addClass("input_search_on");
		}).focusout(function() {
			$("#keywordDiv").removeClass("input_search_on");
		});*/
		// 高级检索按钮绑定点击、鼠标移动及鼠标移出事件
		$("#advancedSearchBtn").click(function() {
			Jqxx.resetKeywordInput("keyword");// 重置输入关键字的input控件
			Jqxx.showAdvancedSearch({
				advancedSearchDivId : "advancedSearchDiv"
			});// 显示高级检索
			Jqxx.initAdvancedSearchZzjg();
		}).mousemove(function() {
			if ($("#advancedSearchDiv").is(":visible")) {
				Jqxx.isHidden = false;
			}
		}).mouseout(function() {
			if ($("#advancedSearchDiv").is(":visible")) {
				Jqxx.isHidden = true;
			}
		});
		// 高级检索DIV中查询按钮绑定点击事件
		$("#doAdvancedSearchBtn").click(function() {
			Jqcz.backTo();
			Jqxx.advancedSearch({
				advancedSearchDivId : "advancedSearchDiv"
			}, function(data, requestParamObj) {// 高级检索
				Jqxx.loadJqxxToList({
					mapApp : _MapApp,
					showDivId : "contentDivId",
					showTotalCountSpanId : "totalCountSpan"
				}, data, requestParamObj);
				MapBubble.removeAll();
				Jqxx.loadJqxxToMap({}, data, function() {});
				/*$(".lf_dllict").mCustomScrollbar({
					scrollButtons : {
						enable : true
					}
				});*/
			});
		});
		// 高级检索DIV中重置按钮绑定点击事件
		$("#doAdvancedResetBtn").click(function() {
			Jqxx.resetAdvancedSearch({
				advancedSearchDivId : "advancedSearchDiv"
			});
		});
		this.initJqlxDictionary({
			data : {
				zdbh : ""
			},
			dictShowId : "advancedSearch_jqlxmc",
			initVal : ""
		});// 高级检索，初始化警情类型字典
		this.initJqlbDictionary({
			dlDictShowId : "advancedSearch_jqssdlmc",
			dlInitVal : "caseType122030000",
			zlDictShowId : "advancedSearch_jqsszlmc",
			zlInitVal : "caseType122030100",
			xlDictShowId : "advancedSearch_jqssxlmc",
			xlInitVal : ""
		});// 高级检索，初始化警情类别（大中小类）字典
		this.initBjsjDictionary({
			url : "dictionary/getDictionaryListJSON.f",
			data : {
				"zdbh" : "D_GQSJ"
			},
			dictShowId : "advancedSearch_bjsjqmc",
			dictContainerReferenceObjectId : "advancedSearchDiv",
			initVal : "0"
		});
		SysTool.changeIputStyle();
	},

	/**
	 * 获取警情信息
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：myorallFlag 我的警情和全部警情标识,jqssdddm 警情单位编号，jjrbh
	 *            接警人编号，jqzt
	 *            警情状态（空字符串：所有，1：未定位，2：未派警，3：已派警，4：处置中，5：已完成。)，favoriteFlag
	 *            获取收藏的警情标志，
	 *            begin 当前页从第几行开始，
	 *            end 当前页从第几行结束。）
	 * @param {Function}
	 *            callbackFunc 回调函数
	 */
	getJqxxList : function(param, callbackFunc) {
		var requestUrl = "";
		var requestData = {};
		var favoriteFlag = ("undefined" == typeof param.favoriteFlag ? false
				: param.favoriteFlag);// 收藏
		if (favoriteFlag) {
			requestUrl = "jqxx/getFavoriteJqxxList.f";
			requestData = {
				"begin": ("undefined" == typeof param.begin ? 0 : param.begin),
				"end": ("undefined" == typeof param.end ? 10 : param.end),
				"requestSource": "2"
			};
		} else {
			var jqssdddm = param.jqssdddm;
			var jjrbh = param.jjrbh;
			var myorallFlag = param.myorallFlag;
			var xqdm = $("#jqxq_dm").val();
			if (myorallFlag == "ALL") {
				jjrbh = "";
				jqssdddm = (jqssdddm.indexOf(xqdm) != -1 && xqdm != SysConfig.T_USER_LOGIN_ORGID_ZD) ? xqdm : jqssdddm;
			} else if (myorallFlag == "ORG") {
				jjrbh = "";
				jqssdddm = (jqssdddm.indexOf(xqdm) != -1 && xqdm != SysConfig.T_USER_LOGIN_ORGID_ZD) ? xqdm : jqssdddm;
			} else {
				jqssdddm = (jqssdddm.indexOf(xqdm) != -1 && xqdm != SysConfig.T_USER_LOGIN_ORGID_ZD) ? xqdm : "";
			}
			requestUrl = "jqxx/getJqxxList.f";
			requestData = {
				"jqssdddm" : jqssdddm,
				"jjrbh" : jjrbh,
				"jqzt" : param.jqzt,
				"begin": ("undefined" == typeof param.begin ? 0 : param.begin),
				"end": ("undefined" == typeof param.end ? 10 : param.end),
				"requestSource": "1"
			};
		}
		var requestParamObj = {
			url : requestUrl,
			data : requestData
		};
		SysTool.ajax(requestParamObj, function(data) {
			callbackFunc(data, requestParamObj);
		});
	},

	/**
	 * 获取警情状态数量
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：myorallFlag 我的警情和全部警情标识,jqssdddm 警情单位编号，jjrbh
	 *            接警人编号。)。）
	 * @param {Function}
	 *            callbackFunc 回调函数
	 */
	getJqxxZtCountFromCache : function(param, callbackFunc) {
		var xqdm = $("#jqxq_dm").val();
		var jqssdddm = (param.jqssdddm.indexOf(xqdm) != -1 && xqdm != SysConfig.T_USER_LOGIN_ORGID_ZD) ? xqdm : "";
		SysTool.ajax({
			url : "jqxx/getJqxxZtCountFromCache.f",
			data : {
				"myorallFlag" : param.myorallFlag,
				"jqssdddm" : jqssdddm,
				"jjrbh" : param.jjrbh
			}
		}, function(data) {
			callbackFunc(data);
		});
	},
	
	/**
	 * 刷新警情列表
	 * @param {Object}
	 *            refreshParam JSON对象(包括：isChanage 统计数是否变化标志，changeCount 变化数量，
	 *                                 stateControlType 状态图标类型（1：未定位；2：未派警；3：已派警未到达；4：已到达处置中；5：处置完成并反馈；""：全部。），
	 *                                 loopIndex 状态图标索引，loopTotalCount 状态图标总数。)
	 */
	refreshJqxxToList : function(refreshParam) {
		if (refreshParam.changeCount != 0) {
			if (this.requestJsonObject.data.requestSource == "1") {// 状态列表
				if (this.requestJsonObject.data.jqzt == refreshParam.stateControlType) {// 警情状态（1：未定位；2：未派警；3：已派警未到达；4：已到达处置中；5：处置完成并反馈。）统计数变化
					this.getJqxxList4Refresh();
				} else if (this.requestJsonObject.data.jqzt == "" && refreshParam.stateControlType == 6) {// 警情状态（全部）统计数变化
					this.getJqxxList4Refresh();
				}
			} else if (this.requestJsonObject.data.requestSource == "2") {// 收藏列表
				if (refreshParam.stateControlType == 7) {// 收藏统计数变化
					this.getJqxxList4Refresh();
				}
			}
		}
		if (refreshParam.isChanage && refreshParam.loopIndex == refreshParam.loopTotalCount - 1) {
			if (this.requestJsonObject.data.requestSource == "3" || this.requestJsonObject.data.requestSource == "4") {// 关键字或高级检索列表
				this.getJqxxList4Refresh();
			}
		}
		if (refreshParam.changeCount > 0 
			&& ("undefined" != typeof SysConfig.XJQ_TYPE[0] && refreshParam.stateControlType == SysConfig.XJQ_TYPE[0])) {// 未定位的警情数量发生变化
			if (!Jqxq.isClickXq) {
				this.showRemind({changeCount: refreshParam.changeCount, stateControlType: refreshParam.stateControlType});
			}
		}
	},
	
	/**
	 * 显示警情信息提醒前
	 * @param {Object}
	 *            param JSON对象(包括：changeCount 变化数量，
	 *                                 stateControlType 状态图标类型（1：未定位；2：未派警；3：已派警未到达；4：已到达处置中；5：处置完成并反馈；""：全部。）。)
	 */ 
	beforeShowRemind : function(param) {
		if ("undefined" != typeof SysConfig.XJQ_TYPE[1] && SysConfig.XJQ_TYPE[1] == "2") {
			this.showRemind(param);
		}
	},
	
	/**
	 * 显示警情信息提醒
	 * @param {Object}
	 *            param JSON对象(包括：changeCount 变化数量，
	 *                                 stateControlType 状态图标类型（1：未定位；2：未派警；3：已派警未到达；4：已到达处置中；5：处置完成并反馈；""：全部。）。)
	 */                                 
	showRemind : function(param) {
		var jqssdddmTemp = jqssdddm;
		var jjrbhTemp = jjrbh;
		var myorallFlag = StateControl.myorallFlag;
		var xqdm = $("#jqxq_dm").val();
		if (myorallFlag == "ALL") {
			jjrbhTemp = "";
			jqssdddmTemp = (jqssdddmTemp.indexOf(xqdm) != -1 && xqdm != SysConfig.T_USER_LOGIN_ORGID_ZD) ? xqdm : jqssdddmTemp;
		} else if (myorallFlag == "ORG") {
			jjrbhTemp = "";
			jqssdddmTemp = (jqssdddmTemp.indexOf(xqdm) != -1 && xqdm != SysConfig.T_USER_LOGIN_ORGID_ZD) ? xqdm : jqssdddmTemp;
		} else {
			jqssdddmTemp = (jqssdddmTemp.indexOf(xqdm) != -1 && xqdm != SysConfig.T_USER_LOGIN_ORGID_ZD) ? xqdm : "";
		}
		param.changeCount = (param.changeCount <= Jqxx.showMoreCount ? param.changeCount : Jqxx.showMoreCount);
		var requestUrl = "jqxx/getJqxxList.f";
		var requestData = {
			"jqssdddm" : jqssdddmTemp,
			"jjrbh" : jjrbhTemp,
			"jqzt" : param.stateControlType,
			"begin": 0,
			"end": param.changeCount,
			"requestSource": "1"
		};
		var requestParamObj = {
			url : requestUrl,
			data : requestData
		};
		SysTool.ajax(requestParamObj, function(data) {
			if (data.count.totalCount > 0) {
				for (var i = param.changeCount - 1; i >= 0; i--) {
					var jqxx = data.list[i];
					var messageRemindString = "<span id='" + jqxx.jqbh + "_jqxxRemind_span' style='cursor:pointer;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;' onclick='javascript:Jqxx.jqxxRemind(\"" + jqxx.jqbh + "\");'>警情编号：" + jqxx.jqbh + "<br/>案发地点：" + ("undefined" == typeof jqxx.jqafdd ? "" : jqxx.jqafdd)  + "<br/>警情信息：" + ("undefined" == typeof jqxx.jqxx ? "" : jqxx.jqxx) + "</span>";
					$.messager.show({title: '新警情', msg: messageRemindString, height: 120, timeout: 5000, showType: 'slide'	});
				}
			}
		});
	},
	
	/**
	 * 警情信息提醒
	 * @param {String} jqbh 警情编号
	 */
	jqxxRemind : function(jqbh) {
		$("#" + jqbh + "_jqxxRemind_span").attr("onclick", "");// 移除click事件
		$("#" + jqbh + "_jqxxRemind_span").css("cursor", "");// 移除手型样式
		var requestUrl = "jqcz/getJqxx.f";
		var requestData = {"jqbh": jqbh};
		var requestParamObj = {
			url : requestUrl,
			data : requestData
		};
		SysTool.ajax(requestParamObj, function(data) {
			if ("undefined" != typeof data && "undefined" != typeof data.jqbh && data.jqbh != null && data.jqbh != "") {
				var jqxx = data;
				if(jqxx['jqzt'] == 1) {
					MapBubble.removeAll();
				}
				var array = new Array();
				var param = {mapApp: _MapApp, showDivId: "contentDivId"};
				if (typeof(jqxx.afdzx) === 'undefined') {
					Jqxx.setNotInitCroodsJq(jqxx.ssdddm, function(point) {
						jqxx['afdzx'] = point.x;
						jqxx['afdzy'] = point.y;
						MapBubble.removeNotFirstLoadLayer();
						array.push(jqxx);
						Jqxx.loadJqxxToMap(param, {
							"list" : array
						}, function(returnMarkerArray) {
							MapBubble.currMarker = returnMarkerArray[0];
							Jqxx.jqListClickEvent(jqxx,false);
						});
					});
				} else {
					MapBubble.removeNotFirstLoadLayer();
					array.push(jqxx);
					Jqxx.loadJqxxToMap(param, {
						"list" : array
					}, function(returnMarkerArray) {
						MapBubble.currMarker = returnMarkerArray[0];
						Jqxx.jqListClickEvent(jqxx,false);
					});
				}
			}
		});
	},
	
	/**
	 * 获取刷新的警情信息
	 */
	getJqxxList4Refresh : function() {
		SysTool.ajax(this.requestJsonObject, function(data) {
			var param = {mapApp: _MapApp, showDivId: "contentDivId", showTotalCountSpanId: "totalCountSpan"};
			Jqxx.loadJqxxToList(param, data, Jqxx.requestJsonObject);
		});
	},

	/**
	 * 加载到列表
	 * 
	 * @param {Object}
	 *            param JSON对象(包括：mapApp 地图对象，showDivId 显示警情信息DIV
	 *            id，showTotalCountSpanId 显示总数的span id。)
	 * @param {Object}
	 *            data JSON对象。
	 * @param {Object}
	 *            requestParamObj JSON对象。
	 */
	loadJqxxToList : function(param, data, requestParamObj) {
		var htmlString = Jqxx.createHtml(data, param.showDivId, requestParamObj);
		$("#" + param.showTotalCountSpanId).html(
				"共有" + data.count.totalCount + "条");
		$("#" + param.showDivId).html(htmlString);
		ScrollBarTool.init("scroll_main_jqlb", "scroll_content_jqlb", 84); // 加载滚动条
		this.beforeLoadJqxxToMap(param, data);
	},
	
	/**
	 * 加载到地图之前的处理
	 * @param {Object}
	 *            param JSON对象(包括：mapApp 地图对象，showDivId 显示警情信息DIV
	 *            id，showTotalCountSpanId 显示总数的span id。)
	 * @param {Object}
	 *            data JSON对象。
	 */
	beforeLoadJqxxToMap : function(param, data) {
		$("#" + param.showDivId).find("dl").each(function(i) {
			$(this).click(function() {
				$("#" + param.showDivId).find("dl").each(function(j) {
					$(this).css("background-color", "");
				});
				$(this).css("background-color", "#aad8ff");
				var jqxx = {};
				for ( var i = 0; i < data.list.length; i++) {
					jqxx = data.list[i];
					if (jqxx.jqbh == $(this).attr("id")) {
						if (jqxx.isBeRelated > "0") {// 被关联的警情
							SysTool.ajax({
								url : "jqxx/getJqxxByBgljqbh.f",
								data : {"bgljqbh" : jqxx.jqbh}
							}, function(data) {
								if ("undefined" != typeof data.jqxx && data.jqxx != null) {
									var zjqxx = data.jqxx;// 主关联警情
									if(zjqxx['jqzt'] == 1) {
										MapBubble.removeAll();
									}
									var array = new Array();
									if(typeof(zjqxx.afdzx) === 'undefined'){
										if (typeof(jqxx.zjqxx_afdzx) === 'undefined') {
											Jqxx.setNotInitCroodsJq(zjqxx.ssdddm, function(point){
												jqxx['zjqxx_afdzx'] = point.x;
												jqxx['zjqxx_afdzy'] = point.y;
												zjqxx['afdzx'] = point.x;
												zjqxx['afdzy'] = point.y;
												MapBubble.removeNotFirstLoadLayer();
												array.push(zjqxx);
												Jqxx.loadJqxxToMap(param, {
													"list" : array
												}, function(returnMarkerArray) {
													MapBubble.currMarker = returnMarkerArray[0];
													Jqxx.jqListClickEvent(zjqxx,false);
												});
											});
										} else {
											zjqxx['afdzx'] = jqxx.zjqxx_afdzx;
											zjqxx['afdzy'] = jqxx.zjqxx_afdzy;
											MapBubble.removeNotFirstLoadLayer();
											array.push(zjqxx);
											Jqxx.loadJqxxToMap(param, {
												"list" : array
											}, function(returnMarkerArray) {
												MapBubble.currMarker = returnMarkerArray[0];
												Jqxx.jqListClickEvent(zjqxx,false);
											});
										}
									}else{
										MapBubble.removeNotFirstLoadLayer();
										array.push(zjqxx);
										Jqxx.loadJqxxToMap(param, {
											"list" : array
										}, function(returnMarkerArray) {
											MapBubble.currMarker = returnMarkerArray[0];
											Jqxx.jqListClickEvent(zjqxx,false);
										});
									}
									SysTool.show("此警情已被关联（警情编号：" + zjqxx.jqbh + "）！");
								}
							});
						} else {
							if(jqxx['jqzt'] == 1) {
								MapBubble.removeAll();
								Jqxq.keep_xq();//保留辖区
							}
							var array = new Array();
							if(typeof(jqxx.afdzx) === 'undefined'){
								Jqxx.setNotInitCroodsJq(jqxx.jqssdddm, function(point){
									jqxx['afdzx'] = point.x;
									jqxx['afdzy'] = point.y;
									MapBubble.removeNotFirstLoadLayer();
									array.push(jqxx);
									Jqxx.loadJqxxToMap(param, {
										"list" : array
									}, function(returnMarkerArray) {
										MapBubble.currMarker = returnMarkerArray[0];
										Jqxx.jqListClickEvent(jqxx,false);
									});
								});
							}else{
								MapBubble.removeNotFirstLoadLayer();
								array.push(jqxx);
								Jqxx.loadJqxxToMap(param, {
									"list" : array
								}, function(returnMarkerArray) {
									MapBubble.currMarker = returnMarkerArray[0];
									Jqxx.jqListClickEvent(jqxx,false);
								});
							}
						}
						break;
					}
				}
			});
			$(this).dblclick(function(){//双击事件

				$("#" + param.showDivId).find("dl").each(function(j) {
					$(this).css("background-color", "");
				});
				$(this).css("background-color", "#aad8ff");
				var jqxx = {};
				for ( var i = 0; i < data.list.length; i++) {
					jqxx = data.list[i];
					if (jqxx.jqbh == $(this).attr("id")) {
						if (jqxx.isBeRelated > "0") {// 被关联的警情
							SysTool.ajax({
								url : "jqxx/getJqxxByBgljqbh.f",
								data : {"bgljqbh" : jqxx.jqbh}
							}, function(data) {
								if ("undefined" != typeof data.jqxx && data.jqxx != null) {
									var zjqxx = data.jqxx;// 主关联警情
									if(zjqxx['jqzt'] == 1) {
										MapBubble.removeAll();
									}
									var array = new Array();
									if(typeof(zjqxx.afdzx) === 'undefined'){
										if (typeof(jqxx.zjqxx_afdzx) === 'undefined') {
											Jqxx.setNotInitCroodsJq(zjqxx.ssdddm, function(point){
												jqxx['zjqxx_afdzx'] = point.x;
												jqxx['zjqxx_afdzy'] = point.y;
												zjqxx['afdzx'] = point.x;
												zjqxx['afdzy'] = point.y;
												MapBubble.removeNotFirstLoadLayer();
												array.push(zjqxx);
												Jqxx.loadJqxxToMap(param, {
													"list" : array
												}, function(returnMarkerArray) {
													MapBubble.currMarker = returnMarkerArray[0];
													Jqxx.jqListClickEvent(zjqxx,false);
													Jqxx.jqlistDbClick(zjqxx, returnMarkerArray[0]);
												});
											});
										} else {
											zjqxx['afdzx'] = jqxx.zjqxx_afdzx;
											zjqxx['afdzy'] = jqxx.zjqxx_afdzy;
											MapBubble.removeNotFirstLoadLayer();
											array.push(zjqxx);
											Jqxx.loadJqxxToMap(param, {
												"list" : array
											}, function(returnMarkerArray) {
												MapBubble.currMarker = returnMarkerArray[0];
												Jqxx.jqListClickEvent(zjqxx,false);
												Jqxx.jqlistDbClick(zjqxx, returnMarkerArray[0]);
											});
										}
									}else{
										MapBubble.removeNotFirstLoadLayer();
										array.push(zjqxx);
										Jqxx.loadJqxxToMap(param, {
											"list" : array
										}, function(returnMarkerArray) {
											MapBubble.currMarker = returnMarkerArray[0];
											Jqxx.jqListClickEvent(zjqxx,false);
											Jqxx.jqlistDbClick(zjqxx, returnMarkerArray[0]);
										});
									}
									SysTool.show("此警情已被关联（警情编号：" + zjqxx.jqbh + "）！");
								}
							});
						} else {
							if(jqxx['jqzt'] == 1) {
								MapBubble.removeAll();
							}
							var array = new Array();
							if(typeof(jqxx.afdzx) === 'undefined'){
								Jqxx.setNotInitCroodsJq(jqxx.ssdddm, function(point){
									jqxx['afdzx'] = point.x;
									jqxx['afdzy'] = point.y;
									MapBubble.removeNotFirstLoadLayer();
									array.push(jqxx);
									Jqxx.loadJqxxToMap(param, {
										"list" : array
									}, function(returnMarkerArray) {
										MapBubble.currMarker = returnMarkerArray[0];
										Jqxx.jqListClickEvent(jqxx,false);
										Jqxx.jqlistDbClick(jqxx, returnMarkerArray[0]);
									});
								});
							}else{
								MapBubble.removeNotFirstLoadLayer();
								array.push(jqxx);
								Jqxx.loadJqxxToMap(param, {
									"list" : array
								}, function(returnMarkerArray) {
									MapBubble.currMarker = returnMarkerArray[0];
									Jqxx.jqListClickEvent(jqxx,false);
									Jqxx.jqlistDbClick(jqxx, returnMarkerArray[0]);
								});
							}
						}
						break;
					}
				}
			
			});
		});
	},

	/*
	 * loadJqxxToList : function(param, data) { var htmlString =
	 * Jqxx.createHtml(data, param.showDivId); $("#" +
	 * param.showTotalCountSpanId).html("共有" + data.count.totalCount + "条");
	 * $("#" + param.showDivId).html(htmlString); $("#" +
	 * param.showDivId).find("dl").each(function(i) { $(this).click(function() {
	 * $("#" + param.showDivId).find("dl").each(function(j) {
	 * $(this).css("background-color", ""); }); $(this).css("background-color",
	 * "#aad8ff"); MapBalloon.closeBalloon();// 关闭气泡框
	 * Jqxx.removeMarker({"mapApp": param.mapApp});//
	 * 叠加marker前，在地图上删除所有的叠加的警情marker对象 Jqxx.removeCircle({"mapApp":
	 * param.mapApp});// 删除叠加在地图上的以警情marker对象为圆心的圆
	 * Jqxx.removeAroundMarker({"mapApp": param.mapApp});//
	 * 删除叠加在地图上的警情周边marker对象 var mapApp = param.mapApp; var showDivId =
	 * param.showDivId; for (var i = 0; i < data.list.length; i++) { var jqbh =
	 * data.list[i].jqbh; if (jqbh == $(this).attr("id")) {
	 * Jqxx.loadSingleJqxxToMap({"mapApp": param.mapApp, "iconUrl":
	 * SysConfig.JQXX_MARKER_ICONS[parseInt(data.list[i].jqzt) - 1].url,
	 * "iconWidth": 30, "iconHeight": 30, "x": data.list[i].afdzx, "y":
	 * data.list[i].afdzy, "titleName": jqbh, "jqssdddm":data.list[i].jqssdddm},
	 * function(marker) { mapApp.recenterOrPanToLatLng(marker.getPoint());
	 * Jqxx.bindingMarkerEvent({"mapApp": mapApp, "marker": marker,
	 * "radiusArray": SysConfig.CIRCLE_RADIUS, "showDivId": showDivId, "jqbh":
	 * jqbh}); //marker.onclick();// 单击marker var param = {mapToolId: "mapTool",
	 * marker: marker, htmlPath: "project/zhdd/pages/jqcz.jsp", isCenter: false,
	 * enevtType: "dblclick"}; MapBalloon.bindingMarkerEvent(param, function() {
	 * Jqcz.openJqxxWindow(jqbh, marker); }); }); break; } } }); });
	 * //ScrollBar.init({id: "contentDivId", topheight: 85, resize: true}); },
	 */

	/**
	 * 加载到地图
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：mapApp 地图对象，showDivId 显示警情信息DIV id。）
	 * @param {Object}
	 *            data JSON对象
	 */
	loadJqxxToMap : function(param, data, callback) {
		var zoomLevel = MapBubble._MapApp.getZoomLevel();
		var zoomLevel_hope = SysConfig.LOADJQXXTOMAP_ZOOM_LEVEL;
		if(zoomLevel < zoomLevel_hope) {
			//MapBubble.zoomToLevel(SysConfig.DRAWCIRCLE_ZOOM_LEVEL);
		}
		//MapBubble.zoomToLevel(SysConfig.LOADJQXXTOMAP_ZOOM_LEVEL);
		var markerArray = new Array();
		// 当前选择点对象清空
		Jqxx.currentPointObject = [null, {}];
//		Jcxx.showOrHideFastQuery();
		Jcxx.disableFunc(); 
		//Ssjl.showOrHideXqnw(); //modify by gb 20141111
		for ( var i = 0; i < data.list.length; i++) {
			var jqxx = data.list[i];
			if (typeof(jqxx.isBeRelated) === 'undefined' || jqxx.isBeRelated == 0) {// 没有被关联的警情
				var iconUrl = Jqxx.getJqxxIconByJqzt(jqxx["jqzt"]);
				var marker = {
					dataJson : jqxx,
					id : jqxx["jqbh"],
					titleName : jqxx["jqbh"],
					x : jqxx["afdzx"],
					y : jqxx["afdzy"],
					iconUrl : iconUrl,
					iconWidth : 30,
					iconHeight : 30,
					iconLeftOffset : 13,
					iconTopOffset : -14
				};
				markerArray.push(marker);
			}
		}
		var markerParam = {
			markerArray : markerArray,
			contentType : "url",
			contentValue : "project/zhdd/pages/jqcz.jsp",
			contentCallback : "Jqcz.openJqxxWindow",
			eventFuncJson : {
				"click" : "Jqxx.jqMarkerClickEvent"
			},
			bubbleShowEvent : "dblclick",
			titleShowEvent : "mouseover",
			bubbleWidth : 403,
			bubbleHeight : 352,
			moveMode : "movetobubblecenter"
		};
	    var returnMarkerArray = MapBubble.addMarker(markerParam);
		callback(returnMarkerArray);
	},
	/**
	 * 根据警情状态取得icon
	 * 
	 * @param jqzt
	 * @returns
	 */
	getJqxxIconByJqzt : function(jqzt) {
		return SysConfig.JQXX_MARKER_ICONS[jqzt - 1]["url"];
	},

	/**
	 * 加载单个到地图
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：mapApp 地图对象，iconUrl 图标路径（不传则，必须传警情状态），jqzt
	 *            警情状态（不传则，必须传图标路径）， iconWidth 图标宽度（不传默认30）， iconHeight
	 *            图标高度（不传默认30），x 地图x坐标，y 地图y坐标，titleName marker标题名，jqssdddm
	 *            警情所属大队代码）
	 * @param {Function}
	 *            callback 回调函数
	 */
	loadSingleJqxxToMap : function(param, callback) {
		if ("undefined" == typeof param.x || "undefined" == typeof param.y) {
			GeoQuery
					.getOrganizationBoundaryCoordinates(
							param.jqssdddm,
							function(boundaryCoordinates) {// 获取机构边界坐标
								if ("undefined" != typeof boundaryCoordinates
										&& boundaryCoordinates != null
										&& boundaryCoordinates != "") {
									var orgBoundaryCoordinatesArray = boundaryCoordinates
											.split(",");
									for ( var i = 0; i < orgBoundaryCoordinatesArray.length; i++) {
										if (i == 0) {
											param.x = orgBoundaryCoordinatesArray[i];
										} else if (i == 1) {
											param.y = orgBoundaryCoordinatesArray[i];
										} else {
											break;
										}
									}
									var icon = new Icon();
									icon.image = ("undefined" == typeof param.iconUrl ? SysConfig.JQXX_MARKER_ICONS[parseInt(param.jqzt) - 1].url
											: param.iconUrl);
									icon.width = ("undefined" == typeof param.iconWidth ? 30
											: param.iconWidth);
									icon.height = ("undefined" == typeof param.iconHeight ? 30
											: param.iconHeight);
									var point = new Point(param.x, param.y);
									var title = new Title(param.titleName, 12,
											7);
									var marker = new Marker(point, icon, title);
									param.mapApp.addOverlay(marker);
									Jqxx.markerArray.push(marker);
									callback(marker);
								}
							});
		} else {
			var icon = new Icon();
			icon.image = ("undefined" == typeof param.iconUrl ? SysConfig.JQXX_MARKER_ICONS[parseInt(param.jqzt) - 1].url
					: param.iconUrl);
			;
			icon.width = ("undefined" == typeof param.iconWidth ? 30
					: param.iconWidth);
			icon.height = ("undefined" == typeof param.iconHeight ? 30
					: param.iconHeight);
			var point = new Point(param.x, param.y);
			var title = new Title(param.titleName, 12, 7);
			var marker = new Marker(point, icon, title);
			param.mapApp.addOverlay(marker);
			this.markerArray.push(marker);
			callback(marker);
		}
	},

	/**
	 * 删除叠加在地图上的警情marker对象
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：mapApp 地图对象。）
	 */
	removeMarker : function(param) {
		for ( var i = 0; i < this.markerArray.length; i++) {
			param.mapApp.removeOverlay(this.markerArray[i]);
			if (i == this.markerArray - 1) {
				this.markerArray = [];
			}
		}
	},

	/**
	 * 删除叠加在地图上的以警情marker对象为圆心的圆
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：mapApp 地图对象。）
	 */
	removeCircle : function(param) {
		for ( var i = 0; i < this.circleArray.length; i++) {
			param.mapApp.removeOverlay(this.circleArray[i]);
			if (i == this.circleArray - 1) {
				this.circleArray = [];
			}
		}
	},

	/**
	 * 删除叠加在地图上的警情周边marker对象
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：mapApp 地图对象。）
	 */
	removeAroundMarker : function(param) {
		for ( var i = 0; i < this.aroundMarkerArray.length; i++) {
			param.mapApp.removeOverlay(this.aroundMarkerArray[i]);
			if (i == this.aroundMarkerArray - 1) {
				this.aroundMarkerArray = [];
			}
		}
	},

	/**
	 * 地图上警情单击事件
	 */
	
	jqMarkerClickEvent : function(dataJson) {
		Jqxx.jqClickEvent(dataJson, true);
	},
	
	jqListClickEvent : function(dataJson,isHideLeftLayout) {
		Jqxx.jqClickEvent(dataJson,isHideLeftLayout);
	},
	
	jqClickEvent : function(dataJson,isHideLeftLayout) {
		var mapApp = MapBubble._MapApp;
		var marker = MapBubble.currMarker;
		var point = marker.getPoint();
		if(Jqxx.currentPointObject[0]==marker){
			return;
		}else{
			//Jcxx.fastQueryRemove();
			Jcxx.disableFunc();
		}
		Jqxx.currentPointObject = [marker, dataJson];
		MapBubble.removeCircle();
		MapBubble.removeAroundMarker();
		var zoomLevel = mapApp.getZoomLevel();
		var zoomLevel_hope = SysConfig.DRAWCIRCLE_ZOOM_LEVEL;
		if(zoomLevel < zoomLevel_hope) {
			mapApp.zoomTo(SysConfig.DRAWCIRCLE_ZOOM_LEVEL);
		}
		var mapWidth = parseInt(document.getElementById(MapBubble.mapDivId).clientWidth);
		var mapHeight = parseInt(document.getElementById(MapBubble.mapDivId).clientHeight);
		var bubbleHeight = parseInt($("#tips").height()) + 35;
		var pointXY = mapApp.mapCoord2Container(point);
		var markerY = pointXY.y;
		var markerX = pointXY.x;
		var moveX = mapWidth / 2 - markerX;
		//var moveY = ((mapHeight - bubbleHeight) / 2) + markerY - mapHeight;
		var moveY = markerY - (bubbleHeight +10);
		mapApp.pan(moveX, moveY);
		//MapBubble.pan(moveX, moveY, function(){
			//marker.flash(3);
			var jqzt = dataJson['jqzt'];
			var jqssdddm=dataJson['jqssdddm'];//警情所属大队代码 by pan
			if(jqzt != 1 && jqzt != 5){ // 未定位警情
				var radiusArray = SysConfig.CIRCLE_CONFIG[0];
				var colorArray = SysConfig.CIRCLE_CONFIG[1];
				var fillcolorArray = SysConfig.CIRCLE_CONFIG[2];
				// 画圈
				MapBubble.addManyCircle(marker, radiusArray, colorArray, fillcolorArray, false);
				// 查询警力、周边资源
				//var maxCirclePoint = MapBubble.getMaxCirclePointFromManyCircle(marker, radiusArray);
				//var maxCircleDegree = MapBubble.getDegree(marker, radiusArray[radiusArray.length - 1]);
				
				//Jqxx.aroundQuery({ "mapApp" : mapApp, "strCoods" : maxCirclePoint, "radius" : maxCircleDegree,"jqssdddm":jqssdddm});
				gps.aroundQuery2(point.x+","+point.y, radiusArray[0], "point", false);
				
				Jcxx.showJqfunc();
				//Ssjl.showOrHideXqnw(); //modify by gb 20141111
			}
		//});
		// 设置列表选中
		this.setListSelected(dataJson['jqbh']);
		// 收起左边列表
		if(isHideLeftLayout) {
			LeftLayout.hideLefLayout();
		}
	},
	
	/**
	 * 设置列表选中
	 * @param {String} jqbh 警情编号
	 */
	setListSelected : function(jqbh) {
		$("#contentDivId").find("dl").each(function(i) {
			if ($(this).attr("id") == jqbh) {
				$(this).css("background-color", "#aad8ff");
			} else {
				$(this).css("background-color", "");
			}
		});
	},
	
	/**
	 * 设置处置状态没有警情坐标的警情
	 * 
	 * @param ssdddm
	 * @param callback
	 */
	setNotInitCroodsJq : function(ssdddm, callback){
		/*GeoQuery.getOrganizationBoundaryCoordinates(ssdddm,
			function(boundaryCoordinates) {
			// 获取机构边界坐标
			if ("undefined" !== typeof(boundaryCoordinates)
					&& boundaryCoordinates != null
					&& boundaryCoordinates != "") {
				var obca = boundaryCoordinates.split(",");
				point = new Point(obca[0], obca[1]);					
			}else{
				// 获取屏幕中间点
				point = MapBubble._MapApp.getCenterLatLng();					
			}
			callback(point);			
		});*/
		
		var extent = SysTool.getMapExtent(_MapApp);
		var width = SysTool.getMapWidth("pgis_map");
		//ssdddm = "510600000000";
		var where = ["GXDWDM = '" + ssdddm + "'"];
		var options = {
			tablename : SysConfig.JG_DW_LAYER_TABLENAME,
			layertype : SysConfig.LAYER_TYPE[0],
			nameField : SysConfig.JG_DW_LAYER_NAMEFIELD,
			mapWidth : width,
			where : where,
			querytype : SysConfig.QUERY_TYPE[6],
			extent : extent,
			iscluster:false
		};
		GeoQuery.attributeQuery(options, function(resultSet) {
			var zbx = "";
			var zby = "";
			for (var i = 0; i < resultSet.length; i++) { 
				var sResult = eval("(" + resultSet[i].result + ")");
				if (sResult.count == 0) {
					continue;
				} else {
					var jsonlist = eval("(" + sResult.jsonlist + ")");
//					alert(JSON.stringify(jsonlist))
					if (jsonlist.length > 0) {
						var json = jsonlist[0];
						zbx = json.X;
						zby = json.Y;
						break;
					}
				}
			}
			var point = null;
			if ("undefined" != typeof zbx && zbx != null && zbx != "" && "undefined" != typeof zby && zby != null && zby != "") {
				point = new Point(zbx, zby);
			} else {
				point = new Point(SysConfig.JQ_UNLOCATED_MAP_COORDINATES[0], SysConfig.JQ_UNLOCATED_MAP_COORDINATES[1]);
			}
			callback(point);
		});
	},
	
	/**
	 * 警情列表上图
	 */
	jqListClickToMapEvent : function(mapApp, marker, point){
		var radiusArray = SysConfig.CIRCLE_CONFIG[0];
		var colorArray = SysConfig.CIRCLE_CONFIG[1];
		var fillcolorArray = SysConfig.CIRCLE_CONFIG[2];

		MapBubble.removeCircle();
		MapBubble.removeAroundMarker();

		mapApp.zoomTo(SysConfig.DRAWCIRCLE_ZOOM_LEVEL);
		var mapWidth = parseInt(document.getElementById(MapBubble.mapDivId).clientWidth);
		var mapHeight = parseInt(document.getElementById(MapBubble.mapDivId).clientHeight);
		var bubbleHeight = parseInt($("#tips").height());
		
		var pointXY = mapApp.mapCoord2Container(point);
		var markerY = pointXY.y;
		var markerX = pointXY.x;
		var moveX = mapWidth / 2 - markerX;
		var moveY = ((mapHeight - bubbleHeight) / 2) + markerY - mapHeight;
		mapApp.pan(moveX, moveY);
		MapBubble.addManyCircle(marker, radiusArray, colorArray, fillcolorArray, false);
	},
	
	/**
	 * 绑定marker事件
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：mapApp 地图对象，marker marker对象，radiusArray
	 *            半径数组，showDivId 显示警情信息DIV id，jqbh 警情编号。）
	 */
	bindingMarkerEvent : function(param) {

	},

	/**
	 * 周边查询  [该方法废除]//modify by gb 20141111
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：mapApp 地图对象，strCoods 周边查询的坐标串如"x,y,r"，radius
	 *            周边查询距离，单位为度，实际距离需用map的getDegree方法转换。）
	 */
	aroundQuery : function(param) {
		Ssjl.clearZbjlMarker();//清除已存在的周边警力
		MapBubble.aroundMarkerArray = [];
		var options = {
			tablename : SysConfig.JQXX_MARKER_AROUNDQUERY_LAYER_TABLENAME,
			layertype : SysConfig.JQXX_MARKER_AROUNDQUERY_LAYER_TYPE,
			coords : param.strCoods,
			radius : param.radius,
			nameField : SysConfig.JQXX_MARKER_AROUNDQUERY_LAYER_NAMEFIELD,
			mapWidth : SysTool.getMapWidth("pgis_map"),
			extent : SysTool.getMapExtent(param.mapApp),
			querytype : SysConfig.QUERY_TYPE[3],
			subFields : "callno:callno,carno:carno,uim:uim,policeid:policeid,policename:policename,orgname:orgname,speed:speed,dir:dir,jllx:jllx,statusid:statusid,ywbh:ywbh",
			where:"statusid!='000' and path like '%"+param.jqssdddm+"%'",
			x : "x",
			y : "y",
			iscluster : false
		};
		GeoQuery.aroundQuery(options,function(resultSet) {
							Ssjl.zbJlReasult(resultSet,"all","all");
//							for ( var i = 0; i < resultSet.length; i++) {
//								var sResult = eval("(" + resultSet[i].result
//										+ ")");
//								if (sResult.count == 0) {
//									continue;
//								} else {
//									var jsonlist = eval("(" + sResult.jsonlist
//											+ ")");
//									for ( var k = 0; k < SysConfig.GIS_LAYER_ICONS.length; k++) {
//										if ((resultSet[i].id).toUpperCase() == ((SysConfig.GIS_LAYER_ICONS)[k].id)
//												.toUpperCase()) {
//											imageUrl = (SysConfig.GIS_LAYER_ICONS)[k].url;
//											break;
//										}
//									}
//									/*
//									 * for (var j = 0; j < jsonlist.length; j++) {
//									 * var clusterPoint =
//									 * jsonlist[j].centerpoint; var clusterCount =
//									 * jsonlist[j].count; var clusterList =
//									 * jsonlist[j].clusterlist;
//									 * //GeoQuery.createMarker(clusterPoint,
//									 * clusterList, clusterCount, param.mapApp,
//									 * imageUrl, function(marker) {
//									 * GeoQuery.createMarker({resultSet :
//									 * resultSet[i]}, jsonlist,function(){
//									 * MapBubble.aroundMarkerArray.push(marker);
//									 * }); }
//									 */
//									GeoQuery
//											.createMarker(
//													{
//														resultSet : resultSet[i]
//													},
//													jsonlist,
//													function(returnMarkerArray) {
//														MapBubble.aroundMarkerArray = returnMarkerArray;
//													});
//								}
//							}
						});
	},

	/**
	 * 生成html
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：count 数量统计（count包括：totalCount 总数，wdwCount
	 *            未定位数，wpjCount 未派警数，ypjCount 已派警数，czzCount 处置中数，ywcCount
	 *            已完成数。），list 警情信息列表。）
	 * @param {String}
	 *            showDivId 显示警情信息DIV id
	 * @param {Object} 
	 *            requestParamObj JSON对象（请求的JSON对象）
	 */
	createHtml : function(param, showDivId, requestParamObj) {
		var htmlString = "";
		if (param.count.totalCount == 0) {
			htmlString = "<dl><dt style='cursor:auto;text-align:center;color:#999999;'>查询无返回结果！</dt></dl>";
		} else {
			var count = Jqxx.showMoreCount > param.list.length ? param.list.length : Jqxx.showMoreCount;
			for (var j = 0; j < count; j++) {
				htmlString += '<dl id="'
						+ ("undefined" == typeof param.list[j].jqbh ? ""
								: param.list[j].jqbh) + '">';
				htmlString += '<dt>';
				var jqzt = "undefined" == typeof param.list[j].jqzt ? "" : param.list[j].jqzt;
				/*if (jqzt == "1") {// 未定位警情
					htmlString += '<span class="'
							+ Jqxx.getColorClassName(jqzt)
							+ '"></span><strong>'
							+ ("undefined" == typeof param.list[j].jqafdd ? ""
									: param.list[j].jqafdd)
							+ '</strong><a href="" class="collect_on" title=""></a>';
				} else {
					var isFavorite = "undefined" == typeof param.list[j].isFavorite ? ""
							: param.list[j].isFavorite;
					if (isFavorite == "0") {
						htmlString += '<span class="'
								+ Jqxx.getColorClassName(jqzt)
								+ '"></span><strong>'
								+ ("undefined" == typeof param.list[j].jqafdd ? ""
										: param.list[j].jqafdd)
								+ '</strong><a href="javascript:void(0);" onclick="Jqcz.jqczJqhf(\'' + param.list[j].jqbh + '\',\'' + param.list[j].jqafdd + '\');" class="btn_playback" title="回放警情"></a><a href="javascript:Jqxx.favorite(\''
								+ ("undefined" == typeof param.list[j].jqbh ? ""
										: param.list[j].jqbh)
								+ '\', \'1\');" class="btn_collect" title="收藏" id="'
								+ ("undefined" == typeof param.list[j].jqbh ? ""
										: param.list[j].jqbh) + '_a"></a>';
					} else {
						htmlString += '<span class="'
								+ Jqxx.getColorClassName(jqzt)
								+ '"></span><strong>'
								+ ("undefined" == typeof param.list[j].jqafdd ? ""
										: param.list[j].jqafdd)
								+ '</strong><a href="javascript:void(0);" onclick="Jqcz.jqczJqhf(\'' + param.list[j].jqbh + '\',\'' + param.list[j].jqafdd + '\');" class="btn_playback" title="回放警情"></a><a href="javascript:Jqxx.favorite(\''
								+ ("undefined" == typeof param.list[j].jqbh ? ""
										: param.list[j].jqbh)
								+ '\', \'0\');" class="btn_collect_no" title="取消收藏" id="'
								+ ("undefined" == typeof param.list[j].jqbh ? ""
										: param.list[j].jqbh) + '_a"></a>';
					}
				}*/
				var isFavorite = "undefined" == typeof param.list[j].isFavorite ? "" : param.list[j].isFavorite;
				var isRelated = "undefined" == typeof param.list[j].isRelated ? "" : param.list[j].isRelated;
				var isBeRelated = "undefined" == typeof param.list[j].isBeRelated ? "" : param.list[j].isBeRelated;
				if (isFavorite == "0") {
					htmlString += '<span class="'
							+ Jqxx.getColorClassName(jqzt)
							+ '"></span><strong>'
							+ ("undefined" == typeof param.list[j].jqafdd ? "" : param.list[j].jqafdd)
							+ (isRelated > "0" ? "（主警情）" : (isBeRelated > "0" ? "（子警情）" : ""))
							+ '</strong><a href="javascript:void(0);" onclick="Jqcz.jqczJqhf(\'' + param.list[j].jqbh + '\',\'' + param.list[j].jqafdd + '\');" class="btn_playback" title="回放警情"></a><a href="javascript:Jqxx.favorite(\''
							+ ("undefined" == typeof param.list[j].jqbh ? ""
									: param.list[j].jqbh)
							+ '\', \'1\');" class="btn_collect" title="收藏" id="'
							+ ("undefined" == typeof param.list[j].jqbh ? ""
									: param.list[j].jqbh) + '_a"></a>';
				} else {
					htmlString += '<span class="'
							+ Jqxx.getColorClassName(jqzt)
							+ '"></span><strong>'
							+ ("undefined" == typeof param.list[j].jqafdd ? "" : param.list[j].jqafdd)
							+ (isRelated > "0" ? "（主警情）" : (isBeRelated > "0" ? "（子警情）" : ""))
							+ '</strong><a href="javascript:void(0);" onclick="Jqcz.jqczJqhf(\'' + param.list[j].jqbh + '\',\'' + param.list[j].jqafdd + '\');" class="btn_playback" title="回放警情"></a><a href="javascript:Jqxx.favorite(\''
							+ ("undefined" == typeof param.list[j].jqbh ? ""
									: param.list[j].jqbh)
							+ '\', \'0\');" class="btn_collect_no" title="取消收藏" id="'
							+ ("undefined" == typeof param.list[j].jqbh ? ""
									: param.list[j].jqbh) + '_a"></a>';
				}
				htmlString += '</dt>';
				htmlString += '<dd>';
				htmlString += '<div class="dd_cont">'
						+ ("undefined" == typeof param.list[j].jqxx ? ""
								: param.list[j].jqxx) + '</div>';
				htmlString += '<div class="txt_time">';
				htmlString += ("undefined" == typeof param.list[j].bjrxm ? ""
						: param.list[j].bjrxm)
						+ '<span>'
						+ ("undefined" == typeof param.list[j].bjdh ? ""
								: param.list[j].bjdh)
						+ '</span><span>'
						+ Jqxx
								.getDateStringByMilliseconds("undefined" == typeof param.list[j].bjsj ? 0
										: param.list[j].bjsj) + '</span>';
				htmlString += '</div>';
				htmlString += '</dd>';
				htmlString += '</dl>';

			}
			if ((param.count.totalCount - requestParamObj.data.begin) > this.showMoreCount) {
				htmlString += '<a id="jqxxListMore_a" class="loadmore" href="javascript:Jqxx.showMoreJqxx(\'' + showDivId + '\');">加载更多>></a>';
			}
		}
		this.requestJsonObject = requestParamObj;

		return htmlString;
	},

	/**
	 * 显示更多的警情信息
	 * 
	 * @param {String}
	 *            showDivId 显示警情信息DIV id
	 */
	showMoreJqxx : function(showDivId) {
		if ("undefined" != typeof this.requestJsonObject.data.end && this.requestJsonObject.data.end != null && this.requestJsonObject.data.end != "") {
			this.requestJsonObject["data"]["begin"] = parseInt(this.requestJsonObject.data.end);
			this.requestJsonObject["data"]["end"] = parseInt(this.requestJsonObject.data.end) + this.showMoreCount;
			SysTool.ajax(this.requestJsonObject, function(data) {
				var htmlString = Jqxx.createHtml(data, showDivId, Jqxx.requestJsonObject);
				if ("undefined" != typeof $("#jqxxListMore_a") && $("#jqxxListMore_a") != null) {
					$("#jqxxListMore_a").remove();
				}
				$("#" + showDivId).append(htmlString);
				ScrollBarTool.init("scroll_main_jqlb", "scroll_content_jqlb", 84); // 加载滚动条
				var param = {mapApp : _MapApp, showDivId : showDivId};
				Jqxx.beforeLoadJqxxToMap(param, data);
			});
		}
	},

	/**
	 * 获取颜色class名
	 * 
	 * @param status
	 *            状态（1：未定位，2：未派警，3：已派警，4：处置中，5：已完成。)
	 */
	getColorClassName : function(status) {
		var colorClassName = "";
		if (status == "1") {
			colorClassName = "color_gray";
		} else if (status == "2") {
			colorClassName = "color_red";
		} else if (status == "3") {
			colorClassName = "color_yellow";
		} else if (status == "4") {
			colorClassName = "color_blue";
		} else if (status == "5") {
			colorClassName = "color_green";
		}

		return colorClassName;
	},

	/**
	 * 通过毫秒数获取日期字符串（格式：2014-3-9 1:01）
	 * 
	 * @param milliseconds
	 *            毫秒数
	 */
	getDateStringByMilliseconds : function(milliseconds) {
		var date = new Date(milliseconds);
		var dateString = date.getFullYear() + "-";// 获取年
		dateString += (date.getMonth() + 1) + "-";// 获取月
		dateString += date.getDate();// 获取日
		dateString += "&nbsp;&nbsp;" + date.getHours() + ":";// 获取时
		dateString += date.getMinutes() < 10 ? ("0" + date.getMinutes()) : date
				.getMinutes();// 获取分

		return dateString;
	},

	/**
	 * 收藏警情
	 * 
	 * @param {String}
	 *            jqbh 警情编号
	 * @param {String}
	 *            type 类型（0：取消收藏；1：收藏。）
	 */
	favorite : function(jqbh, type) {
		SysTool.ajax({
			url : "jqxx/favoriteJq.f",
			data : {
				"jqbh" : jqbh,
				"type" : type
			}
		}, function(data) {
			if (data.message == "success") {
				StateControl.oneNumberChange({
					splitNum : "20",
					type : "favorite",
					count : data.count.favoriteCount
				});
				if (type == "1") {
					$("#contentDivId").find("a[id$='_a']").each(
							function(i) {
								if ($(this).attr("id") == (jqbh + "_a")) {
									$(this).removeClass().addClass(
											"btn_collect_no");
									$(this).attr("title", "取消收藏");
									$(this).attr(
											"href",
											"javascript:Jqxx.favorite(\'"
													+ jqbh + "\', \'0\');");
									return false;
								}
							});
					$("#mapBalloonTitle").find("a[id$='_a']").each(
							function(i) {
								if ($(this).attr("id") == (jqbh + "_a")) {
									$(this).removeClass().addClass(
											"btn_collect_no");
									$(this).attr("title", "取消收藏");
									$(this).attr(
											"href",
											"javascript:Jqxx.favorite(\'"
													+ jqbh + "\', \'0\');");
									return false;
								}
							});
					SysTool.show("收藏成功！");
				} else if (type == "0") {
					$("#contentDivId").find("a[id$='_a']").each(
							function(i) {
								if ($(this).attr("id") == (jqbh + "_a")) {
									$(this).removeClass().addClass(
											"btn_collect");
									$(this).attr("title", "收藏");
									$(this).attr(
											"href",
											"javascript:Jqxx.favorite(\'"
													+ jqbh + "\', \'1\');");
									return false;
								}
							});
					$("#mapBalloonTitle").find("a[id$='_a']").each(
							function(i) {
								if ($(this).attr("id") == (jqbh + "_a")) {
									$(this).removeClass().addClass(
											"btn_collect");
									$(this).attr("title", "收藏");
									$(this).attr(
											"href",
											"javascript:Jqxx.favorite(\'"
													+ jqbh + "\', \'1\');");
									return false;
								}
							});
					SysTool.show("取消收藏成功！");
				}
			} else {
				if (type == "1") {
					SysTool.show("收藏失败！");
				} else if (type == "0") {
					SysTool.show("取消收藏失败！");
				}
			}
		});
	},

	/**
	 * 初始化输入关键字的input控件
	 * 
	 * @param {String}
	 *            keywordInputId 输入关键字的input控件id
	 */
	initKeywordInput : function(keywordInputId) {
		$("#" + keywordInputId).val(this.keywordInputPrompt);
		this.bindingKeywordInputEvent(keywordInputId);
	},
	
	/**
	 * 重置输入关键字的input控件
	 * 
	 * @param {String}
	 *            keywordInputId 输入关键字的input控件id
	 */
	resetKeywordInput : function(keywordInputId) {
		$("#" + keywordInputId).css("color", "#999999");
		$("#" + keywordInputId).val(this.keywordInputPrompt);
	},

	/**
	 * 绑定输入关键字的input控件的事件
	 * 
	 * @param {String}
	 *            keywordInputId 输入关键字的input控件id
	 */
	bindingKeywordInputEvent : function(keywordInputId) {
		$("#" + keywordInputId).blur(function() {
			if ($("#" + keywordInputId).val() == "") {
				Jqxx.resetKeywordInput(keywordInputId);
			}
		});
		$("#" + keywordInputId).focus(function() {
			if ($("#" + keywordInputId).val() == Jqxx.keywordInputPrompt
					&& $("#" + keywordInputId).css("color") == "#999999") {
				$("#" + keywordInputId).val("");
				$("#" + keywordInputId).css("color", "#000000");
			}
		});
		$("#" + keywordInputId).keydown(function(e) {
	        switch(e.which) {    
        	// user presses the "Enter"    
            case 13: Jqxx.keywordSearch({keywordInputId: "keyword"}, function(data, requestParamObj) {// 关键字检索
            				Jqcz.backTo();//返回列表
            				Jqxx.loadJqxxToList({
						     mapApp : _MapApp,
						     showDivId : "contentDivId",
						     showTotalCountSpanId : "totalCountSpan"
					 	     }, data, requestParamObj);
							/*
							 * Jqxx.loadJqxxToMap({mapApp: _MapApp, showDivId:
							 * "contentDivId"}, data, function(jsonObject) { var param =
							 * {mapToolId: "mapTool", marker: jsonObject.marker, htmlPath:
							 * "project/zhdd/pages/jqcz.jsp", isCenter: false, enevtType:
							 * "dblclick"}; MapBalloon.bindingMarkerEvent(param, function(){
							 * Jqcz.openJqxxWindow(jsonObject.jqbh, jsonObject.marker); });
							 * });
							 */
					         MapBubble.removeAll();
					     	 Jqxx.loadJqxxToMap({}, data, function() {});
					 });    
                     break; 
	        	 }    
		});
	},

	/**
	 * 关键字检索
	 * 
	 * @param {Object} param JSON对象（包括：keywordInputId 输入关键字的input控件id，begin 当前页从第几行开始，end 当前页从第几行结束。）
	 * @param {Function}
	 *            callbackFunc 回调函数
	 */
	keywordSearch : function(param, callbackFunc) {
		var keyword = $.trim($("#" + param.keywordInputId).val());// 关键字
		if (keyword == "") {
			this.resetKeywordInput(param.keywordInputId);
			SysTool.tooltips(param.keywordInputId, this.keywordInputPrompt, "bottom");
		} else {
			if ($("#" + param.keywordInputId).css("color") == "#000000") {
				var requestParamObj = {
					url : "jqxx/keywordSearchJqxxList.f",
					data : {
						"keyword" : keyword,
						"begin": ("undefined" == typeof param.begin ? 0 : param.begin),
						"end": ("undefined" == typeof param.end ? 10 : param.end),
						"requestSource": "3"
					}
				};
				SysTool.ajax(requestParamObj, function(data) {
					callbackFunc(data, requestParamObj);
				});
			} else {
				SysTool.tooltips(param.keywordInputId, this.keywordInputPrompt, "bottom");
			}
		}
	},

	/**
	 * 显示高级检索
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：advancedSearchDivId 高级查询DIV id。）
	 */
	showAdvancedSearch : function(param) {
		if ($("#" + param.advancedSearchDivId).is(":hidden")) {
			$("#" + param.advancedSearchDivId).show("300", function() {
				Jqxx.isHidden = true;
				// 注册所有高级检索条件输入框聚焦事件
				$("#" + param.advancedSearchDivId).find("input[id^='advancedSearch_']").each(function(i) {
					$(this).focus(function() {
						Dictionary.hideExpand(Dictionary.dictSelectDivClass);
					});
					if ($(this).attr("id").indexOf("advancedSearch_jjsj") != -1) {
						$(this).bind("propertychange", function() {
							Jqxx.isHidden = false;
						}); 
					}
				});
				$("#" + param.advancedSearchDivId).focus(function() {
					Dictionary.hideExpand(Dictionary.dictSelectDivClass);
				});
				$("#" + param.advancedSearchDivId).mousemove(function() {
					Jqxx.isHidden = false;
				});
				$("#" + param.advancedSearchDivId).mouseout(function() {
					Jqxx.isHidden = true;
				});
				$(document).click(function() {
					var isVisible = $("#" + param.advancedSearchDivId).is(":visible");
					if (isVisible) {
						if ($dp) {
							$dp.hide();// 隐藏日期选择框
						}
					}
					if (isVisible && Jqxx.isHidden) {
						$("#" + param.advancedSearchDivId).hide("300", function() {
							// 重置所有高级检索条件输入框
							$("#" + param.advancedSearchDivId).find("input[id^='advancedSearch_']").each(function(i) {
								if ($(this).attr("id").indexOf("advancedSearch_jqssdl") == -1 && $(this).attr("id").indexOf("advancedSearch_jqsszl") == -1 && $(this).attr("id").indexOf("advancedSearch_bjsjq") == -1) {
									$(this).val("");
								} else {
									if ($("#advancedSearch_jqssdldm").val() != "caseType122030000") {
										$("#advancedSearch_jqssdldm").val("caseType122030000");
										$("#advancedSearch_jqssdlmc").val("交通类警情");
									}
									if ($("#advancedSearch_jqsszldm").val() != "caseType122030100") {
										$("#advancedSearch_jqsszldm").val("caseType122030100");
										$("#advancedSearch_jqsszlmc").val("道路交通事故");
									}
									if ($("#advancedSearch_bjsjq").val() != "0") {
										$("#advancedSearch_bjsjq").val("0");
										$("#advancedSearch_bjsjqmc").val("1小时内");
									}
								}
							});
						});
						Jqxx.isHidden = false;
					}
				});
		});
		
		}
	},

	/**
	 * 高级检索
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：advancedSearchDivId 高级查询DIV id，begin 当前页从第几行开始，end 当前页从第几行结束。）
	 * @param {Function}
	 *            callbackFunc 回调函数
	 */
	advancedSearch : function(param, callbackFunc) {
		Dictionary.hideExpand(Dictionary.dictSelectDivClass);
		var jsonObject = {};// JSON对象
		// 组装高级检索条件为JSON对象
		$("#" + param.advancedSearchDivId).find("input[id^='advancedSearch_']").each(function(i) {
			jsonObject[$(this).attr("id").split("_")[1]] = $(this).val();
		});
		jsonObject["begin"] = ("undefined" == typeof param.begin ? 0 : param.begin);
		jsonObject["end"] = ("undefined" == typeof param.end ? 10 : param.end);
		jsonObject["requestSource"] = "4";
		var requestParamObj = {
			url : "jqxx/advancedSearchJqxxList.f",
			data : jsonObject
		};
		SysTool.ajax(requestParamObj, function(data) {
			callbackFunc(data, requestParamObj);
		});
	},

	/**
	 * 重置高级检索查询条件
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：advancedSearchDivId 高级查询DIV id。）
	 */
	resetAdvancedSearch : function(param) {
		Dictionary.hideExpand(Dictionary.dictSelectDivClass);
		// 重置
		$("#" + param.advancedSearchDivId).find("input[id^='advancedSearch_']").each(function(i) {
			if ($(this).attr("id").indexOf("advancedSearch_jqssdl") == -1 && $(this).attr("id").indexOf("advancedSearch_jqsszl") == -1 && $(this).attr("id").indexOf("advancedSearch_bjsjq") == -1) {
				var value = $(this).val();
				if (value != "") {
					$(this).val("");
				}
			} else {
				if ($("#advancedSearch_jqssdldm").val() != "caseType122030000") {
					$("#advancedSearch_jqssdldm").val("caseType122030000");
					$("#advancedSearch_jqssdlmc").val("交通类警情");
				}
				if ($("#advancedSearch_jqsszldm").val() != "caseType122030100") {
					$("#advancedSearch_jqsszldm").val("caseType122030100");
					$("#advancedSearch_jqsszlmc").val("道路交通事故");
				}
				if ($("#advancedSearch_bjsjq").val() != "0") {
					$("#advancedSearch_bjsjq").val("0");
					$("#advancedSearch_bjsjqmc").val("1小时内");
				}
			}
		});
	},

	/**
	 * 初始化警情类型字典
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：data 请求的JSON数据，dictShowId 显示字典词条的input控件id,
	 *            initVal 初始化字典的值）
	 */
	initJqlxDictionary : function(param) {
		// 初始化警情类型
		Dictionary.initDictionaryList({
			"url" : "dict/getJqlx.f",
			"data" : param.data,
			"dictShowId" : param.dictShowId,
			"dictContainerReferenceObjectId" : "advancedSearchDiv",
			"initVal" : param.initVal
		}, function() {
			var dm = $("#" + param.dictShowId).prev().val();
			$("#" + param.dictShowId).prev().val(dm.split(',')[0]);
		});
	},

	/**
	 * 初始化警情类别（大中小类）字典
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：dlDictShowId 显示大类字典词条的input控件id，dlInitVal
	 *            初始化大类字典的值，zlDictShowId 显示中类字典词条的input控件id，zlInitVal
	 *            初始化中类字典的值，xlDictShowId 显示小类字典词条的input控件id，xlInitVal
	 *            初始化小类字典的值。）
	 */
	initJqlbDictionary : function(param) {
		Dictionary.initDictionaryList({
			"url" : "dictionary/jqlbDict.f",
			"data" : {
				"zdbh" : "D_JQLB",
				"zddm" : "",
				"count" : 1
			},
			"dictShowId" : param.dlDictShowId,
			"dictContainerReferenceObjectId" : "advancedSearchDiv",
			"initVal" : param.dlInitVal
		}, function() {
			$("#" + param.zlDictShowId).val("");
			$("#" + param.zlDictShowId).prev().val("");
			$("#" + param.xlDictShowId).val("");
			$("#" + param.xlDictShowId).prev().val("");
			Dictionary.initDictionaryList({
				"url" : "dictionary/jqlbDict.f",
				"data" : {
					"zdbh" : "D_JQLB",
					"zddm" : $("#" + param.dlDictShowId).prev().val(),
					"count" : 2
				},
				"dictShowId" : param.zlDictShowId,
				"dictContainerReferenceObjectId" : "advancedSearchDiv"
			}, function() {
				$("#" + param.xlDictShowId).val("");
				$("#" + param.xlDictShowId).prev().val("");
				Dictionary.initDictionaryList({
					"url" : "dictionary/jqlbDict.f",
					"data" : {
						"zdbh" : "D_JQLB",
						"zddm" : $("#" + param.zlDictShowId).prev().val(),
						"count" : 3
					},
					"dictShowId" : param.xlDictShowId,
					"dictContainerReferenceObjectId" : "advancedSearchDiv"
				}, function() {

				});
			});
		});
		Dictionary.initDictionaryList({
			"url" : "dictionary/jqlbDict.f",
			"data" : {
				"zdbh" : "D_JQLB",
				"zddm" : $("#" + param.dlDictShowId).prev().val(),
				"count" : 2
			},
			"dictShowId" : param.zlDictShowId,
			"dictContainerReferenceObjectId" : "advancedSearchDiv",
			"initVal" : param.zlInitVal
		}, function() {
			$("#" + param.xlDictShowId).val("");
			$("#" + param.xlDictShowId).prev().val("");
			Dictionary.initDictionaryList({
				"url" : "dictionary/jqlbDict.f",
				"data" : {
					"zdbh" : "D_JQLB",
					"zddm" : $("#" + param.zlDictShowId).prev().val(),
					"count" : 3
				},
				"dictShowId" : param.xlDictShowId,
				"dictContainerReferenceObjectId" : "advancedSearchDiv"
			}, function() {
			});
		});
		Dictionary.initDictionaryList({
			"url" : "dictionary/jqlbDict.f",
			"data" : {
				"zdbh" : "D_JQLB",
				"zddm" : $("#" + param.zlDictShowId).prev().val(),
				"count" : 3
			},
			"dictShowId" : param.xlDictShowId,
			"dictContainerReferenceObjectId" : "advancedSearchDiv",
			"initVal" : param.xlInitVal
		}, function() {
		});
	},

	/**
	 * 初始化警情时间字典
	 * 
	 * @param {Object}
	 *            param JSON对象（包括：url 请求的url，data 请求的JSON数据，dictShowId
	 *            显示字典词条的input控件id, initVal 初始化字典的值）
	 */
	initBjsjDictionary : function(param) {
		Dictionary.initDictionaryList(param, function() {
		});
		$("#" + param.dictShowId).blur(function() {
			if ($("#" + param.dictShowId).prev().val() == "") {
				$("#" + param.dictShowId).prev().val("0");
				$("#" + param.dictShowId).val("1小时内");
			}
		});
	},
	/**
	 * 获取二级处警警情列表
	 * @param userid 接警人编号
	 * @param callback 回调
	 */
	getEjcjList:function(param,callback){
		var jqssdddm = param.jqssdddm;
		var jjrbh = param.jjrbh;
		var myorallFlag = param.myorallFlag;
		var requestParamObj = {
				url : "jqxx/getEjJqxxByjjrid.f",
				data : {"jjrbh":jjrbh,"jqssdddm":jqssdddm,"myorallFlag":myorallFlag,
					"begin": ("undefined" == typeof param.begin ? 0 : param.begin),
					"end": ("undefined" == typeof param.end ? 10 : param.end)
					}
			};
		SysTool.ajax(requestParamObj, function(data){
			callback(data,requestParamObj);
		});
	},
	/**
	 * 二级处警警情上图
	 */
	loadEjcjToMap:function(data,callback){
		
		var zoomLevel = MapBubble._MapApp.getZoomLevel();
		var zoomLevel_hope = SysConfig.LOADJQXXTOMAP_ZOOM_LEVEL;
		if(zoomLevel < zoomLevel_hope) {
			MapBubble.zoomToLevel(SysConfig.DRAWCIRCLE_ZOOM_LEVEL);
		}
		// 当前选择点对象清空
		Jqxx.currentPointObject = [null, {}];
		Jcxx.disableFunc();
		//Ssjl.showOrHideXqnw(); //modify by gb 20141111
		var markerArray = [];
		for ( var i = 0; i < data.list.length; i++) {
				var jqxx = data.list[i];
				if ('' == jqxx['afdzx']||jqxx['afdzx']==undefined){
					continue;
				}
			if (typeof(jqxx.isBeRelated) === 'undefined' || jqxx.isBeRelated == 0) {// 没有被关联的警情
					var iconUrl = Jqxx.getJqxxIconByJqzt(jqxx["jqzt"]);
					var marker = {
						dataJson : jqxx,
						id : jqxx["jqbh"],
						titleName : jqxx["jqbh"],
						x : jqxx["afdzx"],
						y : jqxx["afdzy"],
						iconUrl : iconUrl,
						iconWidth : 30,
						iconHeight : 30,
						iconLeftOffset : 13,
						iconTopOffset : -14
					};
					markerArray.push(marker);
				}
			}
			var markerParam = {
				markerArray : markerArray,
				contentType : "url",
				contentValue : "project/zhdd/pages/jqcz.jsp",
				contentCallback : "Jqcz.openJqxxWindow",
				eventFuncJson : {
					"click" : "Jqxx.jqMarkerClickEvent"
				},
				bubbleShowEvent : "dblclick",
				titleShowEvent : "mouseover",
				bubbleWidth : 403,
				bubbleHeight : 352,
				moveMode : "movetobubblecenter"
			};
			var returnMarkerArray = MapBubble.addMarker(markerParam);
			if(typeof callback!="undefined"||typeof callback=="function"||callback!=null){
					callback(returnMarkerArray);
			}
	},
	/**
	 * 二级处警提醒信息上图所用
	 * @param data 警情信息
	 * @param callback 回调
	 */
	ejtxToMap:function(data,callback){
		var zoomLevel = MapBubble._MapApp.getZoomLevel();
		var zoomLevel_hope = SysConfig.LOADJQXXTOMAP_ZOOM_LEVEL;
		if(zoomLevel < zoomLevel_hope) {
			MapBubble.zoomToLevel(SysConfig.DRAWCIRCLE_ZOOM_LEVEL);
		}
		var markerArray = [];
		var jqxx=data;
		if (undefined == jqxx['afdzx']||"" == jqxx['afdzx'])//未定位
		{
			Jqxx.setNotInitCroodsJq(jqxx['jqssdddm'], function(point){
				jqxx['afdzx'] = point.x;
				jqxx['afdzy'] = point.y;
				if (typeof(jqxx.isBeRelated) === 'undefined' || jqxx.isBeRelated == 0) {// 没有被关联的警情
					var iconUrl = Jqxx.getJqxxIconByJqzt(jqxx["jqzt"]);
					var marker = {
						dataJson : jqxx,
						id : jqxx["jqbh"],
						titleName : jqxx["jqbh"],
						x : jqxx["afdzx"],
						y : jqxx["afdzy"],
						iconUrl : iconUrl,
						iconWidth : 30,
						iconHeight : 30,
						iconLeftOffset : 13,
						iconTopOffset : -14
					};
					markerArray.push(marker);
				}
				var markerParam = {
						markerArray : markerArray,
						contentType : "url",
						contentValue : "project/zhdd/pages/jqcz.jsp",
						contentCallback : "Jqcz.openJqxxWindow",
						eventFuncJson : {
							"click" : "Jqxx.jqMarkerClickEvent"
						},
						bubbleShowEvent : "dblclick",
						titleShowEvent : "mouseover",
						bubbleWidth : 403,
						bubbleHeight : 352,
						moveMode : "movetobubblecenter"
					};
				var returnMarkerArray = MapBubble.addMarker(markerParam);
				if(typeof callback!="undefined"||typeof callback=="function"||callback!=null){
						callback(returnMarkerArray[0]);
				}
			});
		}else{//有坐标
			if (typeof(jqxx.isBeRelated) === 'undefined' || jqxx.isBeRelated == 0) {// 没有被关联的警情
				var iconUrl = Jqxx.getJqxxIconByJqzt(jqxx["jqzt"]);
				var marker = {
					dataJson : jqxx,
					id : jqxx["jqbh"],
					titleName : jqxx["jqbh"],
					x : jqxx["afdzx"],
					y : jqxx["afdzy"],
					iconUrl : iconUrl,
					iconWidth : 30,
					iconHeight : 30,
					iconLeftOffset : 13,
					iconTopOffset : -14
				};
				markerArray.push(marker);
			}
			var markerParam = {
					markerArray : markerArray,
					contentType : "url",
					contentValue : "project/zhdd/pages/jqcz.jsp",
					contentCallback : "Jqcz.openJqxxWindow",
					eventFuncJson : {
						"click" : "Jqxx.jqMarkerClickEvent"
					},
					bubbleShowEvent : "dblclick",
					titleShowEvent : "mouseover",
					bubbleWidth : 403,
					bubbleHeight : 352,
					moveMode : "movetobubblecenter"
				};
			var returnMarkerArray = MapBubble.addMarker(markerParam);
			if(typeof callback!="undefined"||typeof callback=="function"||callback!=null){
					callback(returnMarkerArray[0]);
			}
		}
		
	},
	jqlistDbClick:function(data,marker){
		MapBubble.currMarker = marker;
		MapBubble.addPanOverListener(function(){
			$("#tipsContent").load("project/zhdd/pages/jqcz.jsp",function() {
				MapBubble.initBubbleSize(403, 352);	
				Jqcz.openJqxxWindow(data,function() {
					MapBubble.showBubble();
					MapBubble.setBubblePositionByMarker(MapBubble.currMarker);
				});
			});
		});
	},
	initAdvancedSearchZzjg:function(){
		Dictionary.initDictionaryList({
			url : "zzjg/getZzjgDd.f",
			data : {
				"zdbh" : '',
				"zzjgdm" : ywjgdm,
				initVal : ""
			},
			dictShowId : "advancedSearch_zzjgmc",
			"dictContainerReferenceObjectId": "advancedSearchDiv" 
		}, function() {
		});
	}
};