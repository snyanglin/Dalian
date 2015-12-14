/*!
 * 警情舆情JS
 * znjg - v1.0.0 (2014-04-10 14:23)
 * Copyright(c) 2014 founder
 */

/**
 * @classDescription 警情舆情全局对象
 * @author yichu
 */
var Jqyq = {
		
	/**
	 * 显示警情舆情
	 * @param {String} jqbh 警情编号
	 */
	showJqyq : function(jqbh) {
		if ("undefined" == typeof jqbh || jqbh == "" || jqbh == null) {
			SysTool.alert("警情编号为空，不能发布舆情信息！");
		} else {
			SysTool.window.open({
				width : 408,
				height: 165,
				title : '舆情',
				url : 'project/zhdd/pages/jqyq.jsp'
			}, function(html){
				Jqyq.initJqyq(jqbh);
			});
		}
	},
	
	/**
	 * 初始化警情舆情
	 * @param {String} jqbh 警情编号
	 */
	initJqyq : function(jqbh) {
		$("#jqyq_jqbh").val(jqbh);
		// 根据警情编号查询警情舆情
		SysTool.ajax({
			url: "jqxx/queryJqyqByJqbh.f",
	  		data: {"jqbh": jqbh}
	    }, function(data) {
	    	if (data.list.length > 0) {// 有数据
	    		for (var i = 0; i < data.list.length; i++) {
		    		$("#jqyq_jqyqid").val(data.list[i].jqyqid);
		    		$("#jqyq_yqyjtzqk").val(data.list[i].yqyjtzqk);
		    		$("#jqyq_yqsj").text(SysTool.getDateTimeFormat(data.list[i].yqsj));
		    		$("#jqyq_yqsj_label").show();
		    		break;
		    	}
	    	} else {// 无数据
	    		$("#jqyq_jqyqid").val("0");
	    	}
	    });
	},
	
	/**
	 * 保存或更新警情舆情
	 */
	saveOrUpdateJqyq : function() {
		if (!this.validatorJqyq()) {// 验证舆情信息
			var jsonObject = {};// JSON对象
			// 组装警情舆情条件为JSON对象
			$("#jqyqDiv").find("input[id^='jqyq_']").each(function(i) {
				jsonObject[$(this).attr("id").split("_")[1]] = ($(this).attr("id") == "jqyq_jqyqid") ? parseInt($(this).val()) : $(this).val();
			});
			$("#jqyqDiv").find("textarea[id^='jqyq_']").each(function(i) {
				jsonObject[$(this).attr("id").split("_")[1]] = $(this).val();
			});
			SysTool.ajax({
				url: "jqxx/publicOpinionJq.f",
		  		data: jsonObject
		    }, function(data) {
		    	if (data.message == "success") {
		    		SysTool.show("成功发布舆情信息！");
		    		if (data.list.length > 0) {// 有数据
			    		for (var i = 0; i < data.list.length; i++) {
				    		$("#jqyq_jqyqid").val(data.list[i].jqyqid);
				    		$("#jqyq_yqsj").text(SysTool.getDateTimeFormat(data.list[i].yqsj));
				    		var logContent = data.list[i].yqrxm + "发布舆情信息，内容：" + data.list[i].yqyjtzqk;
				    		var param = {
								"cm" : "CZSJ008",
								"ct" : "舆情发布",
								"ms" : logContent 
							};
							// 操作日志记录
							Jqcz.jqczsjjl(param);
				    		break;
				    	}
			    	} else {// 无数据
			    		$("#jqyq_jqyqid").val("0");
			    	}
		    		Jqyq.closeWindow();
		    	} else {
		    		SysTool.show("发布舆情信息失败！");
		    	}
		    });
		}
	},
	
	/**
	 * 验证舆情信息
	 * @returns {Boolean}
	 */
	validatorJqyq : function() {
		var validatorValue = false;
		validatorValue = SysTool.validator.isBlank([{id : "jqyq_yqyjtzqk", msg: "舆情信息不能为空！"}]);
		if (!validatorValue) {
			validatorValue = SysTool.validator.maxLength("jqyq_yqyjtzqk", 500);
		}
		
		return validatorValue;
	},
	
	/**
	 * 关闭窗口
	 */
	closeWindow : function() {
		SysTool.window.close();
	}
	
};