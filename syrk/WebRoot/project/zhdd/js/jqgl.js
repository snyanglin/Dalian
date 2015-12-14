/*!
 * 警情关联JS
 * znjg - v1.0.0 (2014-04-09 18:50)
 * Copyright(c) 2014 founder
 */

/**
 * @classDescription 警情关联全局对象
 * @author yichu
 */
var Jqgl = {
		
	/**
	 * 主警情编号
	 */
	jqbh : "",
	
	/**
	 * 被关联警情编号（多个用“,”隔开）
	 */
	bgljqbh : "",
		
	/**
	 * 显示警情关联
	 * @param {String} jqbh 警情编号
	 * @param {String} bjdh 报警电话
	 * @param {String} bjsj 报警时间
	 */
	showJqgl : function(jqbh, bjdh, bjsj) {
		if ("undefined" == typeof jqbh || jqbh == "" || jqbh == null) {
			SysTool.show("当前警情的警情编号为空，不能进行关联！");
		} else {
			SysTool.window.open({
				width : 590,
				height: 380,
				title : '警情关联',
				url : 'project/zhdd/pages/jqgl.jsp'
			}, function(html){
				Jqgl.initJqgl(jqbh, bjdh, bjsj);// 初始化警情关联
			});
		}
	},

	/**
	 * 初始化警情关联
	 * @param {String} jqbh 警情编号
	 * @param {String} bjdh 报警电话
	 * @param {String} bjsj 报警时间
	 */
	initJqgl : function(jqbh, bjdh, bjsj) {
		this.jqbh = jqbh;
		this.initJqztDictionary();// 初始化警情状态字典
		this.initBjsjDictionary();// 初始化报警时间字典
		$(".tips_jqgl_input,.tips_jqgl_input_select,textarea").bind("focus",function(){
			$(this).addClass("inputfocus");
		}).focusout(function(){
			$(this).removeClass("inputfocus");
		});
		var bjsjq = (("undefined" == typeof bjsj || bjsj == "" || bjsj == null) ? "0" : bjsj);
		SysTool.ajax({
  			url: "jqxx/getBeRelatedJqxxList.f",
      		data: {"jqbh": jqbh, "bjdh": bjdh, "bjsjq": bjsjq}
	    }, function(data) {
    		var htmlString = "";
    		htmlString += "<table align='center' border='0' width='800' cellpadding='1' cellspacing='1' bgcolor='#ffffff' id='jqglTable'>";
	    	htmlString += "<tr bgcolor='#badaf1'><th width='20' align='center'>" 
	    				  + "<input type='checkbox' title='全选' class='tips_jqgl_hand' onclick='javascript:Jqgl.beRelatedAll(\"jqglListDiv\", \"checkbox_" + jqbh + "\");' value='" + jqbh + "' id='checkbox_" + jqbh + "'/>" 
	    				  + "</th><th width='30' align='center' nowrap>序号</th>"
	    				  + "<th width='155' align='center'>警情编号</th>" 
	    				  + "<th width='55' align='center'>关系</th>" 
	    				  + "<th width='160' align='center'>案发地点</th>" 
	    				  + "<th width='160' align='center'>警情信息</th>"
	    				  + "<th width='80' align='center'>报警电话</th>" 
	    				  + "<th width='120' align='center' nowrap>报警时间</th>" 
	    				  + "<th width='80' align='center' nowrap></th></tr>";
	    	for (var i = 0; i < data.list.length; i++) {
	    		var isBeRelated = "undefined" == typeof data.list[i].isBeRelated ? 0 : data.list[i].isBeRelated;// 是否被关联（0：否，大于0：是。扩展属性，对应表无此字段。）
	    		var xh = i + 1;// 序号
				var bgljqbh = "undefined" == typeof data.list[i].jqbh ? "" : data.list[i].jqbh;// 被关联警情编号
				var relation = "undefined" == typeof data.list[i].relation ? "" : data.list[i].relation;// 关系
				var jqafdd = "undefined" == typeof data.list[i].jqafdd ? "" : data.list[i].jqafdd;// 案发地点
				var jqxx = "undefined" == typeof data.list[i].jqxx ? "" : data.list[i].jqxx;// 警情信息
				var bgljqbjdh = "undefined" == typeof data.list[i].bjdh ? "" : data.list[i].bjdh;// 报警电话
				var bjsj = "undefined" == typeof data.list[i].bjsj ? "" : SysTool.getDateTimeFormat(data.list[i].bjsj);// 报警时间
				var color = "";
				if (relation == "同号同天") {
					color = "#e40000";
				} else if (relation == "同号异天") {
					color = "#ff7e00";
				} else if (relation == "异号同天") {
					color = "#003ce9";
				} else if (relation == "异号异天") {
					color = "#309e00";
				}
				htmlString += "<tr bgcolor='#d7e9f7'>" 
					          + "<td width='20' align='center'>" 
					          + "<input type='checkbox' class='tips_jqgl_hand' " + (isBeRelated > "0" ? "checked='checked'" : "") + " onclick='javascript:Jqgl.setBeRelatedSelectAllCheckboxAndGls(\"checkbox_" + jqbh + "\");' value='" + jqbh + "' id='checkbox_" + bgljqbh + "'/>" 
					          + "</td><td width='30' align='center' nowrap>" + xh + "</td>" 
					          + "<td width='155' align='center'><a style='color:" + color + "' onclick ='Jqgl.bgljqxxInfo(\""+bgljqbh+"\")'>"+bgljqbh+"</a></td>" 
					          + "<td width='55' align='center' style='color:" + color + "'>" + relation + "</td>" 
					          + "<td width='160'><span title='" + jqafdd + "'>" + jqafdd + "</span></td>" 
					          + "<td width='160'><span title='" + jqxx + "'>" + jqxx + "</span></td>" 
					          + "<td width='80' align='center'>" + bgljqbjdh + "</td>" 
					          + "<td width='120' align='center' nowrap>" + bjsj + "</td>"
					          + "<td width='80' align='center'><a style='color:" + color + "' onclick='Jqgl.bgljqxxInfo(\""+bgljqbh+"\")'>详细信息</a></td></tr>";
	    	}
	    	htmlString += "</table>";
	    	$("#jqglListDiv").html(htmlString);
	    	$("#jqglListDiv").show();
	    	Jqgl.setBeRelatedSelectAllCheckboxAndGls("checkbox_" + jqbh);// 设置全选复选框和关联数
	    	$("#doJqglQueryBtn").attr("href", "javascript:Jqgl.queryJqxxByJqglQueryCondition({jqglDivId: 'jqglDiv', jqbh: '" + jqbh + "', bjdh: '" + bjdh + "', bjsjq: '" + bjsjq + "'});");
	    });
	},
	
	/**
	 * 初始化警情状态字典
	 */
	initJqztDictionary : function() {
		// 初始化警情状态
		Dictionary.initDictionaryList({"url": "dictionary/getDictionaryListJSON.f", "data": {"zdbh": "D_JQZT"}, "dictShowId": "jqgl_jqztmc", "dictContainerReferenceObjectId": "jqglDiv", "initVal": ""}, function() {
		});
	},
	
	/**
	 * 初始化报警时间字典
	 */
	initBjsjDictionary : function() {
		Dictionary.initDictionaryList({"url": "dictionary/getDictionaryListJSON.f", "data": {"zdbh": "D_GQSJ"}, "dictShowId": "jqgl_bjsjqmc", "dictContainerReferenceObjectId": "jqglDiv", "initVal": "0"}, function() {
		});
		$("#jqgl_bjsjqmc").blur(function() {
			if ($("#jqgl_bjsjq").val() == "") {
				$("#jqgl_bjsjq").val("0");
				$("#jqgl_bjsjqmc").val("1小时内");
			}
		});
	},
	
	/**
	 * 设置全选复选框和关联数
	 * @param {String} checkboxId 全选复选框id
	 */
	setBeRelatedSelectAllCheckboxAndGls : function(checkboxId) {
		this.bgljqbh = "";
		var isbeRelatedAll = true;// 是否选中全选复选框
		var number = 0;
		if ($("#jqglListDiv").find("input[type='checkbox']").size() > 1) {
			$("#jqglListDiv").find("input[type='checkbox']").each(function(i) {
				if (checkboxId != $(this).attr("id")) {// 非全选复选框
					if (!$(this).is(":checked")) {
						isbeRelatedAll = false;
					} else {
						number++;
						if (Jqgl.bgljqbh == "") {
							Jqgl.bgljqbh = $(this).attr("id").split("_")[1];
						} else {
							Jqgl.bgljqbh += "," + $(this).attr("id").split("_")[1];
						}
					}
				}
			});
		} else {
			isbeRelatedAll = false;
		}
		if (isbeRelatedAll) {
			$("#" + checkboxId).attr("checked", true);
		} else {
			$("#" + checkboxId).attr("checked", false);
		}
		$("#jqglNumberSpan").text(number);
	},
	
	/**
	 * 关联警情
	 */
	beRelated : function() {
		SysTool.ajax({
			url: "jqxx/beRelatedJq.f",
	  		data: {"jqbh": this.jqbh, "bgljqbh": this.bgljqbh}
	    }, function(data) {
	    	if (data.message == "success") {
	    		var logContent = "";
	    		if(Jqgl.bgljqbh != "" && Jqgl.bgljqbh != null) {
	    			SysTool.show("成功完成警情关联！");
	    			logContent = data.userName + "将警情" + Jqgl.bgljqbh.replace(/,/g, "、") + "关联到此警情";
	    		} else {
	    			SysTool.show("成功解除警情关联！");
	    			logContent = data.userName + "解除关联的警情";
	    		}
	    		var param = {
					"cm" : "CZSJ002",
					"ct" : "警情关联",
					"ms" : logContent
				};
				// 操作日志记录
				Jqcz.jqczsjjl(param);
				Jqgl.closeWindow();
	    	} else {
	    		SysTool.show("关联警情失败！");
	    	}
	    });
	},
	
	/**
	 * 关闭窗口
	 */
	closeWindow : function() {
		SysTool.window.close();
	},
	
	/**
	 * 关联所有警情
	 * @param {String} jqglListDivId 警情关联中警情列表DIV id
	 * @param {String} checkboxId 全选复选框id
	 */
	beRelatedAll : function(jqglListDivId, checkboxId) {
		$("#" + jqglListDivId).find("input[type='checkbox']").each(function(i) {
			if (checkboxId != $(this).attr("id")) {// 非全选复选框
				if ($("#" + checkboxId).is(":checked")) {
					if (!$(this).is(":checked")) {
						$(this).attr("checked", true);
					}
				} else {
					if ($(this).is(":checked")) {
						$(this).attr("checked", false);
					}
				}
			}
		});
		this.setBeRelatedSelectAllCheckboxAndGls(checkboxId);
	},
	
	/**
	 * 根据警情关联查询条件查询警情信息
	 * @param {Object} param JSON对象 （包括：jqglDivId 警情关联DIV id，jqbh 主警情编号，bjdh 主警情报警电话，bjsjq 主警情报警时间。）
	 */
	queryJqxxByJqglQueryCondition : function(param) {
		Dictionary.hideExpand(Dictionary.dictSelectDivClass);
		var jsonObject = {};// JSON对象
		// 组装警情关联条件为JSON对象
		$("#" + param.jqglDivId).find("input[id^='jqgl_']").each(function(i) {
			jsonObject[$(this).attr("id").split("_")[1]] = $(this).val();
		});
		jsonObject["zjqjqbh"] = param.jqbh;
		jsonObject["zjqbjdh"] = param.bjdh;
		jsonObject["zjqbjsj"] = param.bjsjq;
		SysTool.ajax({
			url: "jqxx/getBeRelatedJqxxListByCondition.f",
	  		data: jsonObject
	    }, function(data) {
			var jqbh = param.jqbh;
			var htmlString = "";
	    	htmlString += "<table align='center' border='0' width='800' cellpadding='1' cellspacing='1' bgcolor='#ffffff' id='jqglTable' style='float:left'>";
	    	htmlString += "<tr bgcolor='#badaf1'><th width='20' align='center'>"
	    				  + "<input type='checkbox' title='全选' class='tips_jqgl_hand' onclick='javascript:Jqgl.beRelatedAll(\"jqglListDiv\", \"checkbox_" + jqbh + "\");' value='" + jqbh + "' id='checkbox_" + jqbh + "'/>" 
	    				  + "</th><th width='30' align='center' nowrap>序号</th>" 
	    				  + "<th width='155' align='center'>警情编号</th>" 
	    				  + "<th width='55' align='center'>关系</th>" 
	    				  + "<th width='160' align='center'>案发地点</th>" 
	    				  + "<th width='160' align='center'>警情信息</th>" 
	    				  + "<th width='80' align='center'>报警电话</th>" 
	    				  + "<th width='120' align='center' nowrap>报警时间</th>" 
	    				  + "<th width='80' align='center' nowrap></th></tr>";
	    	for (var i = 0; i < data.list.length; i++) {
				var isBeRelated = "undefined" == typeof data.list[i].isBeRelated ? 0 : data.list[i].isBeRelated;// 是否被关联（0：否，大于0：是。扩展属性，对应表无此字段。）
	    		var xh = i + 1;// 序号
				var bgljqbh = "undefined" == typeof data.list[i].jqbh ? "" : data.list[i].jqbh;// 被关联警情编号
				var relation = "undefined" == typeof data.list[i].relation ? "" : data.list[i].relation;// 关系
				var jqafdd = "undefined" == typeof data.list[i].jqafdd ? "" : data.list[i].jqafdd;// 案发地点
				var jqxx = "undefined" == typeof data.list[i].jqxx ? "" : data.list[i].jqxx;// 警情信息
				var bgljqbjdh = "undefined" == typeof data.list[i].bjdh ? "" : data.list[i].bjdh;// 报警电话
				var bjsj = "undefined" == typeof data.list[i].bjsj ? "" : SysTool.getDateTimeFormat(data.list[i].bjsj);// 报警时间
				
				var color = "";
				if (relation == "同号同天") {
					color = "#e40000";
				} else if (relation == "同号异天") {
					color = "#ff7e00";
				} else if (relation == "异号同天") {
					color = "#003ce9";
				} else if (relation == "异号异天") {
					color = "#309e00";
				}
				htmlString += "<tr bgcolor='#d7e9f7'>" 
						      + "<td width='20' align='center'>" 
						      + "<input type='checkbox' class='tips_jqgl_hand' " + (isBeRelated > "0" ? "checked='checked'" : "") + " onclick='javascript:Jqgl.setBeRelatedSelectAllCheckboxAndGls(\"checkbox_" + jqbh + "\");' value='" + jqbh + "' id='checkbox_" + bgljqbh + "'/>" 
						      + "</td><td width='30' align='center' nowrap>" + xh + "</td>" 
						      + "<td width='155' align='center'><a style='color:" + color + "' onclick ='Jqgl.bgljqxxInfo(\""+bgljqbh+"\")'>"+bgljqbh+"</a></td>" 
						      + "<td width='55' align='center' style='color:" + color + "'>" + relation + "</td>" 
						      + "<td width='160'><span title='" + jqafdd + "'>" + jqafdd + "</span></td>" 
						      + "<td width='160'><span title='" + jqxx + "'>" + jqxx + "</span></td>" 
						      + "<td width='80' align='center'>" + bgljqbjdh + "</td>" 
						      + "<td width='120' align='center' nowrap>" + bjsj + "</td>" 
						      + "<td width='80' align='center'><a style='color:" + color + "' onclick='Jqgl.bgljqxxInfo(\""+bgljqbh+"\")'>详细信息</a></td></tr>";
			}
	    	htmlString += "</table>";
	    	$("#jqglListDiv").html(htmlString);
	    	Jqgl.setBeRelatedSelectAllCheckboxAndGls("checkbox_" + jqbh);// 设置全选复选框和关联数
	    });
	},
	
	/**
	 * 重置警情关联查询条件
	 * @param {String} jqglDivId 警情关联DIV id
	 */
	resetJqglQueryCondition : function(jqglDivId) {
		Dictionary.hideExpand(Dictionary.dictSelectDivClass);
		// 重置
		$("#" + jqglDivId).find("input[id^='jqgl_']").each(function(i) {
			if ($(this).attr("id").indexOf("jqgl_bjsjq") == -1) {
				var value = $(this).val();
				if (value != "") {
					$(this).val("");
				}
			} else {
				if ($("#jqgl_bjsjq").val() != "0") {
					$("#jqgl_bjsjq").val("0");
					$("#jqgl_bjsjqmc").val("1小时内");
				}
			}
		});
	},
	
	/**
	 * 清空已关联警情
	 * @param {String} jqglListDivId 警情关联中警情列表DIV id
	 */
	clearBeRelated : function(jqglListDivId) {
		$("#" + jqglListDivId).find("input[type='checkbox']").each(function(i) {
			if ($(this).is(":checked")) {
				$(this).attr("checked", false);
			}
		});
		this.setBeRelatedSelectAllCheckboxAndGls("checkbox_" + this.jqbh);
	},
	/**
	 * 被关联警情详细信息
	 * @param jqbh 警情编号
	 */
	bgljqxxInfo:function(jqbh){
		SysTool.ajax({
			url: "jqxx/bgljqxx.f",
	  		data: {"jqbh":jqbh}
	    },function(data){
	    	var jqxx=data["jqxx"];
	    	var info="";
	    	SysTool.detailWindow.open({
				width : 410,
				height: 320,
				title : "详细信息",
				url : 'project/zhdd/pages/jqxxxx.jsp'
			}, function(){			
				for ( var key in jqxx) {
					SysTool.setTxtVal('jqxxxx_' + key, jqxx[key]);
				}
				SysTool.setTxtVal('jqxxxx_jjsj', SysTool.getDateTimeFormat(jqxx['jjsj']));
				SysTool.setTxtVal('jqxxxx_bjsj', SysTool.getDateTimeFormat(jqxx['bjsj']));
				// 设置警情信息复选框
				var ywty = parseInt(jqxx['ywty']);
				(ywty > 0) ? Jqcz.setChecked('jqxxxx_ywty', true) : Jqcz.setChecked('jqxxxx_ywty', false);
				var sfsjtsgdsr = parseInt(jqxx['sfsjtsgdsr']);
				(sfsjtsgdsr > 0) ? Jqcz.setChecked('jqxxxx_sfsjtsgdsr', true) : Jqcz.setChecked('jqxxxx_sfsjtsgdsr', false);
				var ywrysw = parseInt(jqxx['ywrysw']);
				(ywrysw > 0) ? Jqcz.setChecked('jqxxxx_ywrysw', true) : Jqcz.setChecked('jqxxxx_ywrysw', false);
				var sfswhcl = parseInt(jqxx['sfswhcl']);
				(sfswhcl > 0) ? Jqcz.setChecked('jqxxxx_sfswhcl', true) : Jqcz.setChecked('jqxxxx_sfswhcl', false);
			});
	    });
	}
	
};