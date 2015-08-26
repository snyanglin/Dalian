/*!
 * 警情交互事件处置相关业务
 * znjg - v1.0.0 (2014-03-27 09:25)
 * Copyright(c) 2014 founder
 */

/**
 * @deprecated 警情处置业务
 * @author lee
 */
var Jqcz = {
	/**
	 * 定义请求参数
	 */
	HTTPREQPARAM : {},
	/**
	 * 存储上一次道路图层
	 */
	LASTROADLAYERMARKER : '',
	LASTROADLAYERPOLYLINE : '',
	/**
	 * 存储警情信息data
	 */
	JQXXDATA : {},
	CURRENTMARKER : null,
	/**
	 * 警情操作操作类型
	 */
	JQCZCZLX : { SEARCH : 0, UPDATE : 1 },
	JQCZCLSJ : {
		JQDW : ['CZSJ001','定位'],
		JQYJ : ['CZSJ004','警情移交'],
		EJCJ : ['CZSJ003','二级处警'],
		JQTS : ['CZSJ012','警情投诉'],
		JQDB : ['CZSJ013','警情督办'],
		JQSB : ['CZSJ014','警情上报'],
		SHBJ : ['CZSJ015','事后报警'],
		JQPJ : [['JHSJ002','派警'],['JHSJ007','增援'],['JHSJ008','改派']],
		DDXC : ['JHSJ004','到达现场'],
		CZFK : ['JHSJ005','处置反馈'],
		XSWD : ['JHSJ009','协商未到达']
	}, 
	/**
	 * 获取当前登录用户所属机构代码
	 */
	USERLOGINORGID : SysTool.getTxtVal('currentLoginUserOrgDm'),
	/**
	 * 警情处置tab
	 */
	JQCZTAB : [ 'jqdw', 'cgjq', 'jqzp', 'zdjq', 'jqdb', 'jqyj', 'ejcj', 'jqts', 'jqjl', 'shbj', 'czjg', 'ejqr','ejts', 'jqyp' ],
	/**
	 * 警情验证最大文本长度
	 */
	MAXLEN : {JQBCNR : 300, JQJHNR : 400, JQAFDD : 200, JQXXCT : 400 },
	/**
	 * 警情变更分类(常规警情现在类型)
	 */
	JQCGBGXYFL : [],
	/**
	 * 警情变更分类(重大警情现在类型)
	 */
	JQZDBGXYFL : [ '', '', '' ],
	/**
	 * 当前警员坐标
	 */
	CURRENTJYZB : ['', ''],
	/**
	 * 是否图上派警
	 */
	ISTSPJ : false,
	/**
	 * 图上派警设备编号
	 */
	tspjSbbh : '',
	/**
	 * 图上派警呼号
	 */
	tspjHh : '',
	/**
	 * 隐藏下拉字典选项html数组
	 */
	hideDictionaryListItemHtmlArray : [],
	/**
	 * 警情类型为空
	 */
	jqlxIsEmpty : false,
	/**
	 * 控制div影藏、显示
	 */
	controlDiv : function() {
		$(".menu_paijin > a").click(function() {
			var ind = $(this).index();
			$(".dl_paijin > dd").hide();
			$(".dl_paijin > dd:eq(" + ind + ")").show();
			$(".menu_paijin > a").removeClass("dtaon");
			$(this).addClass("dtaon");
			$(".show_toggle").hide();
			$(".tips_slide_up").addClass("tips_slide_dw");
		});
		$(".tips_slide_up").click(function() {
			if ($(this).attr("class") == "tips_slide_up") {
				$(".dl_paijin > dd").hide();
			} else {
				$(".menu_paijin > a").each(function(i, el) {
					var cls = $(el).attr("class");
					if (cls == "dtaon") {
						$(".dl_paijin > dd:eq(" + i + ")").show();
					}
				});
			}
		});
	},

	/**
	 * 警情状态对应交互事件
	 * @param {Number} jqstatus 警情状态
	 * @return {String} 交互事件代码
	 */
	getJqjhsj : function(jqstatus) {
		/**
		 * 1未定位 2未派警 3已派警 4处置中 5已完成
		 */
		/**
		 * JHSJ001 接警 JHSJ002 派警 JHSJ003 出警确认 JHSJ004 到达现场 JHSJ005 处置反馈 JHSJ006 督办
		 */
		var jhsj = "JHSJ001";
		switch (jqstatus) {
		case 3:
			jhsj = "JHSJ002";
			break;
		case 4:
			jhsj = "JHSJ004";
			break;
		case 5:
			jhsj = "JHSJ005";
			break;
		default:
			break;
		}
		return jhsj;
	},
	/**
	 * 获取警情编号
	 * 
	 * @returns 警情编号
	 */
	getJqbh : function() {
		return $('#jqcz_jqbh').text();
	},
	/**
	 * 获取当前登录用户信息
	 */
	getCurrentLoginUser : function(){
		return {
			userId : SysConfig.USERID,
			userName : $('#currentLoginUserName').val(),
			zzjgdm : $('#currentLoginUserOrgDm').val(),
			zzjglx : $('#currentLoginUserOrgLx').val()
		};
	},
	/**
	 * 获取警情信息
	 * @param jqbh  警情编号
	 * @param callback  回调方法
	 */
	getJqxxByJqbh : function(jqbh, callback) {
		HTTPREQPARAM = { url : 'jqcz/getJqxx.f', data : { 'jqbh' : jqbh }};
		$('#jqcz_jqbh').text(jqbh);
		SysTool.ajax(HTTPREQPARAM, function(data) {
			Jqcz.JQXXDATA = data;
			if (typeof (callback) == 'function') {
				callback(data);
			}
		});
	},
	/**
	 * 获取警情交互事件信息
	 * @param jqcljhsjcm  交互事件词码
	 * @param callback    回调交互信息
	 */
	getJqjhsjXxByJhsjcm : function(jqcljhsjcm, callback){
		HTTPREQPARAM = {url: 'jqcz/getJhsj.f', data: {'jqbh' : Jqcz.getJqbh(), 'jhsjcm': jqcljhsjcm}};
		SysTool.ajax(HTTPREQPARAM, function(jhsj){
			if(typeof(callback) === 'function'){
				callback(jhsj);
			}
		});
	},
	/**
	 * 获取警员坐标信息
	 * @param sbbh
	 * @param callback
	 */
	getJyzbBysbbh : function(sbbh, callback){
		if($.trim(sbbh) != ''){
			HTTPREQPARAM = {url: 'gps/getRealGpsInfo.f', data: {'sbid' : sbbh}};
			SysTool.ajax(HTTPREQPARAM, function(data){
				if(typeof(callback) === 'function'){
					callback(data);
				}
			});
		}
	},
	/**
	 * 根据警情编号获取警情信息
	 * @param jqxxData 警情信息
	 * @param callback 回调
	 */
	openJqxxWindow : function(jqxxData, callback) {
		Jqcz.getJqxxByJqbh(jqxxData.jqbh, function(data) {
			var jqlxdm = data['jqlxdm'];
			if (typeof (jqlxdm) === 'undefined') {
				jqlxdm = 'jhsj001,0';
				data['jqlxdm'] = jqlxdm;
			}
			for ( var key in data) {
				SysTool.setTxtVal('jqcz_' + key, data[key]);
			}
			SysTool.setTxtVal('jqcz_jjsj', SysTool.getDateTimeFormat(data['jjsj']));
			SysTool.setTxtVal('jqcz_bjsj', SysTool.getDateTimeFormat(data['bjsj']));
			// 设置警情信息复选框
			var ywty = parseInt(data['ywty']);
			(ywty > 0) ? Jqcz.setChecked('jqcz_ywty', true) : Jqcz.setChecked('jqcz_ywty', false);
			var sfsjtsgdsr = parseInt(data['sfsjtsgdsr']);
			(sfsjtsgdsr > 0) ? Jqcz.setChecked('jqcz_sfsjtsgdsr', true) : Jqcz.setChecked('jqcz_sfsjtsgdsr', false);
			var ywrysw = parseInt(data['ywrysw']);
			(ywrysw > 0) ? Jqcz.setChecked('jqcz_ywrysw', true) : Jqcz.setChecked('jqcz_ywrysw', false);
			var sfswhcl = parseInt(data['sfswhcl']);
			(sfswhcl > 0) ? Jqcz.setChecked('jqcz_sfswhcl', true) : Jqcz.setChecked('jqcz_sfswhcl', false);
			
			
			var ifdead = parseInt(data['ifdead']);
			(ifdead > 0) ? Jqcz.setChecked('jqcz_ifdead', true) : Jqcz.setChecked('jqcz_ifdead', false);
			
			
			if (ifdead > 0) {
				$("#jqcz_if_sw_deadcount").show();
			}
			else{
				$("#jqcz_if_sw_deadcount").hide();
				$("#jqcz_deadcount").val("");
			}
			
			var ifhurt = parseInt(data['ifhurt']);
			(ifhurt > 0) ? Jqcz.setChecked('jqcz_ifhurt', true) : Jqcz.setChecked('jqcz_ifhurt', false);
			
			if (ifhurt > 0) {
				$("#jqcz_if_sw_hurtcount").show();
				$("#jqcz_if_sw_ifdxhurt").show();
			}
			else{
				
				$("#jqcz_if_sw_hurtcount").hide();
				$("#jqcz_if_sw_ifdxhurt").hide();
				$("#jqcz_hurtcount").val("");
			}
				
			var ifdxhurt = parseInt(data['ifdxhurt']);
			(ifdxhurt > 0) ? Jqcz.setChecked('jqcz_ifdxhurt', true) : Jqcz.setChecked('jqcz_ifdxhurt', false);
			
			
			var ifpolice = parseInt(data['ifpolice']);
			(ifpolice > 0) ? Jqcz.setChecked('jqcz_ifpolice', true) : Jqcz.setChecked('jqcz_ifpolice', false);
			
			var iftaxi = parseInt(data['iftaxi']);
			(iftaxi > 0) ? Jqcz.setChecked('jqcz_iftaxi', true) : Jqcz.setChecked('jqcz_iftaxi', false);
			
			
			var ifmotor = parseInt(data['ifmotor']);
			(ifmotor > 0) ? Jqcz.setChecked('jqcz_ifmotor', true) : Jqcz.setChecked('jqcz_ifmotor', false);
			
			var ifschool = parseInt(data['ifschool']);
			(ifschool > 0) ? Jqcz.setChecked('jqcz_ifschool', true) : Jqcz.setChecked('jqcz_ifschool', false);
		
			
			var ifelectric = parseInt(data['ifelectric']);
			(ifelectric > 0) ? Jqcz.setChecked('jqcz_ifelectric', true) : Jqcz.setChecked('jqcz_ifelectric', false);
		
			
			
			// 根据警情类型显示不同的处理流程面板
			Jqcz.showComponetByLx(data);
			// 根据警情状态显示不同的处理流程面板
			Jqcz.showComponetByZt(data);//更换了lx和zt执行顺序 by pan
			
			// 初始化警情类别数据
			Jqcz.initJqlbData(data);
			// 初始化道路数据
			Jqcz.initRoadData(data);
			// 初始化警情类型
			Jqcz.initJqlxData(data);
			// 初始化收藏
			Jqcz.initFavorite(data);
			// 初始化警情舆情事件
			Jqcz.initJqyqEvent(data);
			// 初始化警情关联事件
			Jqcz.initJqglEvent(data);
			if(typeof(callback) === 'function'){				
				callback(data);
			}
			SysTool.changeIputStyle();
		});
	},
	/**
	 * 初始化收藏
	 * 
	 * @param {Object}
	 *            data JSON对象
	 */
	initFavorite : function(data) {
		var jqbh = data.jqbh;
		$("#favoriteId").attr("id", jqbh + "_a");
		/*if (data.jqzt == "1") {// 未定位
			$("#" + jqbh + "_a").removeClass().addClass("collect_on");
			$("#" + jqbh + "_a").attr("title", "");
			$("#" + jqbh + "_a").attr("href", "");
		} else {
			if (data.isFavorite == 0) {// 未收藏
				$("#" + jqbh + "_a").removeClass().addClass("btn_collect");
				$("#" + jqbh + "_a").attr("title", "收藏");
				$("#" + jqbh + "_a").attr("href",
						"javascript:Jqxx.favorite(\'" + jqbh + "\', \'1\');");
			} else {// 已收藏
				$("#" + jqbh + "_a").removeClass().addClass("btn_collect_no");
				$("#" + jqbh + "_a").attr("title", "取消收藏");
				$("#" + jqbh + "_a").attr("href",
						"javascript:Jqxx.favorite(\'" + jqbh + "\', \'0\');");
			}
		}*/
		if (data.isFavorite == 0) {// 未收藏
			$("#" + jqbh + "_a").removeClass().addClass("btn_collect");
			$("#" + jqbh + "_a").attr("title", "收藏");
			$("#" + jqbh + "_a").attr("href",
					"javascript:Jqxx.favorite(\'" + jqbh + "\', \'1\');");
		} else {// 已收藏
			$("#" + jqbh + "_a").removeClass().addClass("btn_collect_no");
			$("#" + jqbh + "_a").attr("title", "取消收藏");
			$("#" + jqbh + "_a").attr("href",
					"javascript:Jqxx.favorite(\'" + jqbh + "\', \'0\');");
		}
	},
	/**
	 * 初始化警情舆情事件
	 * 
	 * @param {Object}
	 *            data JSON对象
	 */
	initJqyqEvent : function(data) {
		$("#jqcz_jqyq").attr("href","javascript:Jqyq.showJqyq(\'" + data.jqbh + "\');");
	},
	/**
	 * 初始化警情关联事件
	 * 
	 * @param {Object}
	 *            data JSON对象
	 */
	initJqglEvent : function(data) {
		$("#jqcz_jqgl").attr("href","javascript:Jqgl.showJqgl(\'" + data.jqbh + "\', \'" + data.bjdh + "\', '" + data.bjsj + "\');");
		//Jqgl.settingsAndRefreshWindow();// 设置并刷新关联窗口
	},
	/**
	 * 初始化警情大中小类
	 * @param data 警情类别数据
	 */
	initJqlbData : function(data) {
		var url = 'dictionary/jqlbDict.f';
		Dictionary.initDictionaryList({url : url,data : {'zdbh' : 'D_JQLB', 'zddm' : '', 'count' : 1 },dictShowId : 'jqcz_jqssdlmc',initVal : data['jqssdldm']}, function() {
			Jqcz.clearSelectComponet([ 'jqcz_jqsszl', 'jqcz_jqssxl' ]);
			Dictionary.initDictionaryList({url : url,data : { 'zdbh' : 'D_JQLB', 'zddm' : SysTool.getTxtVal('jqcz_jqssdldm'), 'count' : 2 },dictShowId : 'jqcz_jqsszlmc'}, function() {
				Jqcz.clearSelectComponet([ 'jqcz_jqssxl' ]);
				Dictionary.initDictionaryList({url : url,data : { 'zdbh' : 'D_JQLB', 'zddm' : SysTool.getTxtVal('jqcz_jqsszldm'), 'count' : 3 },dictShowId : 'jqcz_jqssxlmc'}, function() {});
			});
		});
		Dictionary.initDictionaryList({url : url,data : { 'zdbh' : 'D_JQLB', 'zddm' : SysTool.getTxtVal('jqcz_jqssdldm'), 'count' : 2 },dictShowId : 'jqcz_jqsszlmc',initVal : data['jqsszldm']}, function() {
			Jqcz.clearSelectComponet([ 'jqcz_jqssxl' ]);
			Dictionary.initDictionaryList({url : url, data : { 'zdbh' : 'D_JQLB', 'zddm' : SysTool.getTxtVal('jqcz_jqsszldm'), 'count' : 3 }, dictShowId : 'jqcz_jqssxlmc'}, function() {});
		});
		Dictionary.initDictionaryList({url : url,data : {'zdbh' : 'D_JQLB', 'zddm' : SysTool.getTxtVal('jqcz_jqsszldm'), 'count' : 3	},dictShowId : 'jqcz_jqssxlmc',initVal : data['jqssxldm']}, function() {});
	},
	/**
	 * 初始化警情类型
	 * @param data  警情JSON数据
	 */
	initJqlxData : function(data) {
		var jqlxdm = data['jqlxdm'];
		jqlxdm = jqlxdm.split(',');
		Jqcz.JQCGBGXYFL = [ jqlxdm[0], jqlxdm[1] ];
		/*yichu begin*/
		// 初始化警情类型
		Dictionary.initDictionaryList({url : 'dict/getJqlx.f',data : { 'zdbh' : '', 'zddm' : '' },dictShowId : 'jqcz_jqlxmc',initVal : jqlxdm[0]}, function() {}, function() {
			if (SysTool.getTxtVal("jqcz_jqlxdm") == ",") {
				$("#jqcz_jqlxdm").val("");
				$("#jqcz_jqlxmc").val("");
				Jqcz.jqlxIsEmpty = true;
			}
		});
		/*yichu end*/
	},
	/**
	 * 初始化道路管理代码
	 * @param data 道路数据
	 */
	initRoadData : function(data) {
		// 道路代码初始化
		var dldm = data['dldm'];
		var orgId = data['jqssdddm'];
		var xzqh = orgId.substring(0, 6);
		if (typeof (dldm) === 'undefined') {
			dldm = '';
		}
		if(xzqh == '510601' || xzqh == '510609' || xzqh == '510600'){
			xzqh = 510603;
		}
		Dictionary.initDictionaryList({
			url : "dictionary/getDlDictionaryListJSON.f",
			data : { "zdbh" : SysConfig.JT_ROADITEM_PL, "xzqh" : xzqh },
			dictShowId : "jqcz_dlmc",
			initVal : dldm
		}, function() {
			Jqcz.clearSelectComponet([ 'jqcz_ld' ]);
			dldm = SysTool.getTxtVal('jqcz_dldm');
			Dictionary.initDictionaryList({
				url : "dictionary/getLdDictionaryListJSON.f",
				data : { "zdbh" : SysConfig.JT_ROADSEGITEM_PL, "dldm" : dldm },
				dictShowId : "jqcz_ldmc"
			}, function() {
			});
			Jqcz.lazyLoad(function() {
				var size = $('#jqcz_ldmcDiv').find("li").size();
				if (size == 0) {
					Jqcz.clearSelectComponet([ 'jqcz_ld' ]);
					SysTool.setTxtVal('jqcz_ldmc', '该道路无路段信息');
				}
			}, 200);
		});
		var lddm = data['lddm'];
		if (typeof (lddm) === 'undefined') {
			lddm = '';
			// SysTool.setTxtVal('jqcz_ldmc', '该道路无路段信息');
		}
		if(dldm != ''){			
			Dictionary.initDictionaryList({
				url : "dictionary/getLdDictionaryListJSON.f",
				data : {"zdbh" : SysConfig.JT_ROADSEGITEM_PL, "dldm" : dldm },
				dictShowId : "jqcz_ldmc",
				initVal : lddm
			}, function() {});
		}
	},
	/**
	 * 初始化警情督办信息
	 * @param data 警情信息
	 */
	initJqdbXx : function(data) {
		var dbxx = '', sms = '', jqbh = Jqcz.getJqbh();
		HTTPREQPARAM = { url : 'jqcz/getDbtx.f', data : {'jqbh' : jqbh}};
		SysTool.ajax(HTTPREQPARAM, function(data) {
			// 获取全部信息
			sms = data['xxnr'];
			if (typeof (sms) !== 'undefined') {
				var msg = sms.split(',');
				dbxx = msg[0];
				$('#jqcz_jqdb_xx').html(dbxx);
				// 格式化后的短信消息
				sms = sms.replace("<font color='red'>", "").replace("</font>","");
			} else {
				sms = '';
			}
			// 获取出警人员
			Jqcz.getJqjhsjXxByJhsjcm(Jqcz.JQCZCLSJ.JQPJ[0][0], function(jhsj){
				if(!$.isEmptyObject(jhsj)){
					if(jhsj.sfyx == 0){ // 获取改派信息
						Jqcz.getJqjhsjXxByJhsjcm(Jqcz.JQCZCLSJ.JQPJ[2][0], function(jhsj){
							if(!$.isEmptyObject(jhsj)){
								$('#jqcz_jqdb_cjjy').text('改派警员');
								jydbxx();
							}
						});
					}else{ // 获取派警信息
						jydbxx();
					}
					function jydbxx(){
						var jybh = jhsj['sjxyrdm'];
						var jymc = jhsj['sjxyrmc'];
						var jydh = jhsj['sjxyrdh'];
						var jysbbh = jhsj['sjxyrsbbh'];
						$('#jqcz_jqdb_jyxm').html(jymc);
						$('#jqcz_jqdb_lxdh').html(jydh);
						if (typeof (jysbbh) === 'undefined') {jysbbh = '';}
						// 获取警员科技设备绑定(改为最新科技设备绑定)
						var jyInfo = jybh + ',,' + jydh + ',' + jysbbh + ',' + jymc;
						SysTool.setTxtVal('jqcz_jqdb_jyxx', jyInfo);
						$('#jqcz_pj_xxnr_db').html(sms);
						Jqcz.setKjsbBindByJybh(jyInfo, 'db', function(data) {});
					}
				}
			});
		});
	},
	/**
	 * 重大警情上报
	 */
	initZdjqSb : function() {
		Jqcz.zdjqczCheck(function(data) {
			var sblbLen = data.sblb.length;
			if (sblbLen > 0) {
				var jqlx = data.jqlx;
				var jqlxTxt = jqlx['jqflmc'] + '(' + jqlx['bz'] + ')';
				var sblb = data.sblb;
				var htmlString = '';
				htmlString += "<table style='margin:5px 0 0;' align='center' border='0' width='390' cellpadding='1' cellspacing='1' bgcolor='#ffffff'>";
				htmlString += "<tr bgcolor='#badaf1'><th width='45%' align='center'>上报人员</th><th width='25%' align='center'>上报电话</th><th width='30%' align='center'>上报时间</th></tr>";
				var filterDictString = '';
				$.each(sblb,function(i, sb) {
					//var sbxx = ((sb['sbxx']).split(')'))[0] + ')';
					var sbxx = ((sb['sbxx']).split('）'))[0] + '）';
					if (filterDictString == '') {
						filterDictString += sb['sbxx'];
					} else {
						filterDictString +=  "，" + sb['sbxx'];
					}
					htmlString += '<tr bgcolor="#d7e9f7"><td align="left">'+ sbxx+ '</td><td align="center">'+ sb['jqbh']+ '</td><td align="center">'+ SysTool.getDateFormat(sb['sbsj'])+ '</td></tr>';
				});
				htmlString += "</table>";
				$('#jqcz_zdjq_jb_dd').html(jqlxTxt);
				$('#jqcz_zdjq_sb_div').html(htmlString);
				Jqcz.initZdjqsbry(jqlx['jqfldm'], null, filterDictString, jqlx['jqflpzid'] + '^' + jqlxTxt);// yichu，上报修改
				ScrollBarTool.init("scroll_main_zdjq", "scroll_content_zdjq", false);
			} else {
				Jqcz.initZdjqfl();
			}
		});
	},
	/**
	 * 初始化重大警情分类
	 */
	initZdjqfl : function() {
		HTTPREQPARAM = {url : 'zdjq/getZdflpz.f',data : { 'jqbh' : Jqcz.getJqbh(), 'glbmbm' : Jqcz.JQXXDATA.jqssjgjdm }};
		SysTool.ajax(HTTPREQPARAM, function(data) {
			var flpz = '';
			$.each(data,function(i, obj) {
				flpz += '<a style="margin:0 20px 0 0" href="javascript:void(0);" onclick="Jqcz.initZdjqsbry(\'' + obj['jqfldm'] + '\',' + i + ');"><input name="zdjqflpz" type="radio" value="'
						+ obj['jqflpzid'] + '^' + obj['jqflmc'] + '(' + obj['bz'] + ')"/>' + obj['jqflmc'] + '(' + obj['bz'] + ')</a>';
			});
			$('#jqcz_zdjq_jb_dd').html(flpz);
			Jqcz.setRadioChecked('jqcz_zdjq_jb_dd', 'zdjqflpz');
		});
	},
	/**
	 * 初始化重大警情上报人员
	 * @param fldm 警情分类代码
	 * @param idx  点击元素序号
	 */
	initZdjqsbry : function(fldm, idx, filterDictString, jqjbString) {
		var jqjb = '';
		if (idx == null) {// yichu，上报修改
			jqjb = jqjbString;
		} else {
			$('input[name="zdjqflpz"]:eq(' + idx + ')').attr('checked', 'checked');
			jqjb = $('input[name="zdjqflpz"]:checked').val();
		}
		var jqxyfl = jqjb.split('^');
		var zdjqxyfl = Jqcz.JQZDBGXYFL[0];
		if (zdjqxyfl != '') {
			if (zdjqxyfl != jqxyfl[0]) {
//				SysTool.confirm('请确认是否将警情级别变更为' + jqxyfl[1] + '？', function(r) {
//					if (r) {
						// 常规警情变更
						var param = {
							'jqlx' : 1,
							'jqxyfldm' : Jqcz.JQZDBGXYFL[2],
							'jqbgfldm' : fldm,
							'bgyy' : '重大警情变更'
						};
						Jqcz.jqczJqbgjl(param, jqxyfl[1]);
//						Jqcz.JQZDBGXYFL = [ jqxyfl[0], jqxyfl[1], fldm ];
//						loadZdjqsbry();
//					} else {
//						var resetIdx = parseInt(zdjqxyfl) - 1000000 - 1;
//						$('input[name="zdjqflpz"]').removeAttr('checked');
//						$('input[name="zdjqflpz"]:eq(' + resetIdx + ')').attr(
//								'checked', 'checked');
//						return;
//					}
//				});
				//loadZdjqsbry();// yichu，上报修改
			}
			loadZdjqsbry();// yichu，上报修改
		} else {
			Jqcz.JQZDBGXYFL = [ jqxyfl[0], jqxyfl[1], fldm ];
			loadZdjqsbry();
		}
		function loadZdjqsbry() {
			HTTPREQPARAM = {
				url : 'zdjq/getFlsbpz.f',
				data : {
					'jqbh' : Jqcz.getJqbh(),
					'glbmbm' : Jqcz.USERLOGINORGID,
					'fldm' : fldm
				}
			};
			SysTool.ajax(HTTPREQPARAM, function(data) {
				var sbryTxt = '';
				//var selectId = 'jqcz_zdjq_sbld';
				var qkArry = new Array();
				//alert(JSON.stringify(data));
				// 初始化上报单位
				$.each(data, function(i, obj) {
					var selectId = 'jqcz_zdjq_sbld_' + i;
					if (obj['bz'] == '0') {
						sbryTxt += '<label id="' + (selectId + '_label') + '"><div class="lf"><span class="tips_jqczsbld">上报' + obj['sbmc'] + '领导：</span>';
						sbryTxt += '<input id="' + (selectId + '_dm') + '" type="hidden"/>';
						sbryTxt += '<input type="text" id="' + (selectId + '_mc') + '" class="tips_slect" style="width:260px;" /></div>';
					} else {
						sbryTxt += '<label>通知' + obj['sbmc'] + '：';
					}
					qkArry.push(selectId + '_qk');
					sbryTxt += '<div style="clear:both;margin-left:5px;" id="' + selectId + '_ct"></div></label>';
				});
				if (idx == null) {// yichu，上报修改
					$('#jqcz_zdjq_sb_div table').eq(0).before(sbryTxt);
				} else {
					$('#jqcz_zdjq_sb_div').html(sbryTxt);
				}
				SysTool.changeIputStyle();
				ScrollBarTool.init("scroll_main_zdjq", "scroll_content_zdjq", false);
				// 初始化上报人员
				$.each(data, function(i, obj) {
					var selectId = 'jqcz_zdjq_sbld_' + i;
					var sbjgdm = obj['sbjgdm'];
					Dictionary.initDictionaryList({url : 'zdjq/getRyByFldm.f', data : {'zdbh' : '','ssjgdm' : sbjgdm}, dictShowId : selectId + '_mc', initVal : ''}, function() {
						var sbry = $('#' + selectId + '_mc').val();
						Jqcz.setZdjqsbld('jqcz_zdjq_sbld_', i, obj['bz'], jqjb);
						// 隐藏上报人员选项
						Dictionary.hideDictionaryListItem({dictShowId: selectId + '_mc', filter: [sbry]}, function(json) {
							Jqcz.hideDictionaryListItemHtmlArray.push(json);
						});
					}, function() {// yichu，上报修改
						if (idx == null) {
							var dictItemCount = $("#" + selectId + '_mc' + "Div").find("li").size();
							var removeCount = 0;
							$("#" + selectId + '_mc' + "Div").find("li").each(function(index) {
								if (filterDictString.indexOf($(this).text().split("|")[1]) != -1) {
									$(this).remove();
									removeCount++;
								}
							});
							if (removeCount == dictItemCount) {
								$("#" + selectId + '_label').hide();
							}
						}
					});
				});
			});
		}
	},
	
	/**
	 * 初始化组织机构字典
	 * @param param   请求参数
	 * @param callback 回调方法
	 */
	initZzjgDict : function(param, callback, success) {
		var url = 'zzjg/pjZzjgdm.f';
		var type = param['type'];
		if(type == 0){
			url = 'zzjg/getZzjgDd.f';
		}else if (type == 1) {
			url = 'zzjg/allZzjgdm.f';
		} else if (type == 2) {
			url = 'zzjg/cjmj.f';
		} else if (type == 3) {
			url = 'zzjg/allPersonnel.f';
		} else if (type == 9) {
			url = 'zzjg/xjry.f';
		}
		Dictionary.initDictionaryList({
			url : url,
			data : {
				"zdbh" : '',
				"zzjgdm" : param['zzjgdm'],
				initVal : param['initVal']
			},
			dictShowId : param['showId']
		}, function() {
			if ($.isFunction(callback)) {
				callback();
			}
		}, success);
	},
	/**
	 * 已定位未派警数据
	 * @param lcmc 流程名称
	 * @param kjsb 科技设备
	 * @param isFirst 首次派警
	 */
	initPersonnel : function(lcmc, kjsb, isFirst) {
		// [支队代码] 初始化警员信息
		var sszddm = SysConfig.T_USER_LOGIN_ORGID_ZD;
		var ssdddm = '';
//		var loginOrg = Jqcz.USERLOGINORGID;
		var jqxx = Jqcz.JQXXDATA;
		// 初始化大队
		Jqcz.initZzjgDict({ type : 0,zzjgdm : sszddm ,showId : 'jqcz_' + lcmc + '_ssddmc',initVal : jqxx.jqssdddm}, function() {
			// 清空下拉框组件
			ssdddm = SysTool.getTxtVal('jqcz_' + lcmc + '_ssdddm');
			Jqcz.clearSelectComponet([ 'jqcz_' + lcmc + '_sszd', 'jqcz_' + lcmc + '_jjmj' ]);
			$('#jqcz_pj_xxnr_pj').val('');
			// 初始化中队
			Jqcz.initZzjgDict({type : 1,zzjgdm : ssdddm,showId : 'jqcz_' + lcmc + '_sszdmc',initVal : ''}, function() {
				sszddm = SysTool.getTxtVal('jqcz_' + lcmc + '_sszddm');
				initFirstJy(sszddm);
				Jqcz.clearSelectComponet(['jqcz_' + lcmc + '_jjmj']);
				$('#jqcz_pj_xxnr_pj').val('');
			});
		}, function(){
			Dictionary.setDictionaryListValue({dictShowId: 'jqcz_' + lcmc + '_ssddmc', setVal: jqxx.jqssdddm});
		});
		// 首次派警获取警情所属大队、中队
		if(typeof(isFirst) !== 'undefined' && isFirst == true){
			if(Jqcz.ISTSPJ == false){				
				Jqcz.clearSelectComponet([ 'jqcz_' + lcmc + '_sszd', 'jqcz_' + lcmc + '_jjmj' ]);
				$('#jqcz_pj_xxnr_pj').val('');
			}
			sszddm = jqxx.jqsszddm;
			// 初始化中队
			Jqcz.initZzjgDict({type : 1, zzjgdm : jqxx.jqssdddm, showId : 'jqcz_' + lcmc + '_sszdmc', initVal : sszddm}, function() {
				sszddm = SysTool.getTxtVal('jqcz_' + lcmc + '_sszddm');
				initFirstJy(sszddm);
				Jqcz.clearSelectComponet(['jqcz_' + lcmc + '_jjmj']);
				$('#jqcz_pj_xxnr_pj').val('');
			}, function(){
				Dictionary.setDictionaryListValue({dictShowId: 'jqcz_' + lcmc + '_ssddmc', setVal: jqxx.jqssdddm});//所属大队 bypan 修改针对有所属大队未初始化出来的情况
				Dictionary.setDictionaryListValue({dictShowId: 'jqcz_' + lcmc + '_sszdmc', setVal: sszddm});
				// 初始化警员
				initFirstJy(sszddm);
			});
		}
		function initFirstJy(sszddm){
			// 初始化出警人员
			Jqcz.initZzjgDict({type: 2, zzjgdm: sszddm, showId: 'jqcz_' + lcmc + '_jjmjmc', initVal: ''}, function(){
				Jqcz.tspjSbbh = '';
				Jqcz.tspjHh = '';
				var jybh = SysTool.getTxtVal('jqcz_' + lcmc + '_jjmjdm');
				if(kjsb){
					jybh = jybh + ',' + SysTool.getTxtVal('jqcz_' + lcmc + '_jjmjmc');
					var pjlx = $('input[name=jqczPjlx]:checked').val();
					SysTool.setTxtVal('jqcz_' + lcmc + '_jjmjdm', jybh);
					if(pjlx == 0){
						Jqcz.setJqczTxxxInfo([1], jqxx, 'jqcz_' + lcmc + '_jjmjmc');
					}else if(pjlx ==1){
						Jqcz.setJqczTxxxInfo([6], jqxx, 'jqcz_' + lcmc + '_jjmjmc');
					}else{
						Jqcz.setJqczTxxxInfo([7], jqxx, 'jqcz_' + lcmc + '_jjmjmc');
					}
					Jqcz.setKjsbBindByJybh(jybh, 'pj', function(data){});
					$('input[name=pjtzfs_pj]').each(function(i) {
						$(this).click();
					});
				}
				var jysbbh = (jybh.split(','))[3];
				Jqcz.getJyzbBysbbh(jysbbh, function(zb){
					if($(zb).size() > 0){
						Jqcz.CURRENTJYZB[zb.x, zb.y];
					}
				});
			}, function(){
				if(jqxx.jqzt >= 3){
					// 隐藏增派警员中的第一次派警警员
					Jqcz.getJqjhsjXxByJhsjcm(Jqcz.JQCZCLSJ.JQPJ[0][0], function(jhsj){
						if(typeof(jhsj['sjxyrdm']) !== 'undefined'){
							var jybh = jhsj['sjxyrdm'];
							Dictionary.hideDictionaryListItem({dictShowId: 'jqcz_pj_jjmjmc', filter: [jybh]});
						}
					});
				}
			});
			// 初始化先期处置
			Jqcz.initZzjgDict({type: 9, zzjgdm: sszddm, showId: 'jqcz_' + lcmc + '_xqjymc', initVal: ''}, function(){});
		}
	},
	/**
	 * 初始化警情定位数据
	 */
	initJqdwData : function() {
		var xzqh = 510603;
		var jqssdddm = Jqcz.JQXXDATA.jqssdddm;
		var qh = jqssdddm = jqssdddm.substring(0, 6);
		if(qh == '510601' || qh == '510609' || qh == '510603'){
			xzqh = 510603;
		}else{
			xzqh = qh;
		}
		Dictionary.initDictionaryList({
			url : "dictionary/getLdDictJSON.f",
			data : {"zdbh" : SysConfig.JT_ROADSEGITEM_PL, "xzqh" : xzqh },
			dictShowId : "jqcz_fzdw_ldmc",
			initVal : ''
		}, function() {});
	},
	/**
	 * 初始化移交单位
	 */
	initJqyjData : function() {
		// var sszddm = SysConfig.T_USER_LOGIN_ORGID_ZD;
		// Jqcz.initZzjgDict({type: 0, zzjgdm: sszddm, showId: 'jqcz_yj_yjdwmc',
		// initVal: ''}, function(){});
		var zzjgdm = SysConfig.T_USER_LOGIN_ORGID_ZD;
		Dictionary.initDictTree({
			url : "dictionary/getOrganizationDictTreeJSON.f",
			zdbh : "D_ORG",
			zdmc : "组织机构",
			zzjgdm : zzjgdm,
			auth : 9,
			dictDataDivId : "jqcz_yj_yjdwmc_data_Div"
		}, function() {
			Dictionary.beforeCreateDictTree({
				createCount : 1,
				zdbh : "D_ORG",
				treeData : data_D_ORG,
				dictDataDivId : "jqcz_yj_yjdwmc_data_Div"
			});
			Dictionary.createDictTree({
				dictObject : D_ORG,
				treeData : data_D_ORG_1,
				isLeaf : false,
				dictHiddenId : "jqcz_yj_yjdwdm",
				dictShowId : "jqcz_yj_yjdwmc"
			});
		});

		Dictionary.initDictionaryList({
			url : "dict/getJqyjList.f",
			data : {"zdbh" : ''},
			dictShowId : "jqcz_yj_yjyymc"
		}, function() {
		});
	},
	/**
	 * 初始化二级出警单位
	 */
	initEjcjData : function() {
		var sszddm = SysConfig.T_USER_LOGIN_ORGID_ZD;
		Jqcz.initZzjgDict({
			type : 1,
			zzjgdm : sszddm,
			showId : 'jqcz_ej_bgddmc',
			initVal : ''
		}, function() {});
		//jqcz_ej_bgmc
		Dictionary.initDictionaryList({
			url : "dict/getJqyjList.f",
			data : {"zdbh" : ''},
			dictShowId : "jqcz_ej_bgmc"
		}, function() {});
	},
	/**
	 * 初始化警情增援、改派
	 * @param data 警情信息
	 * @param isFirst 是否首次派警
	 * @param callback 回调函数
	 */
	initJqzp : function(data, isFirst, callback){
		if(isFirst){
			// 首次派警
		}else{
			var txt = $('#pj_span').html();
			$('#pj_span').remove();
			$('#tips_jqcz_jqzp').html(txt);
			SysTool.changeIputStyle();
		}
		Jqcz.initKjsbList('jqcz_pjfs_dd' , 'pj', function(){});
		Jqcz.initPersonnel('pj',true, true);
		Jqcz.setRadioChecked('jqcz_pj_cjlx', 'jqczPjlx');
		if($.isFunction(callback)){
			callback();
		}
	},
	/**
	 * 设置警情出警类型
	 * @param idx 0、首次 1、增派 2、改派
	 */
	initJqczCjlxChecked : function(idx){
		var cjlxId = ['jqcz_pj_cjlx_sc', 'jqcz_pj_cjlx_zp', 'jqcz_pj_cjlx_gp'];
		var aIdx = [0,1,2];
		var radio = '';
		if(idx == 0){
			cjlxId = [ 'jqcz_pj_cjlx_zp', 'jqcz_pj_cjlx_gp'];
			aIdx = [1,2]; 
		}else if(idx == 1){
			cjlxId = ['jqcz_pj_cjlx_sc', 'jqcz_pj_cjlx_gp'];
			aIdx = [0, 2];
		}else if(idx == 2){
			cjlxId = ['jqcz_pj_cjlx_sc', 'jqcz_pj_cjlx_zp'];
			aIdx = [0, 1];
		}else if(idx == 3){
			aIdx = [0];
			cjlxId = ['jqcz_pj_cjlx_sc'];
			idx = 1;
		}
		$.each(cjlxId, function(i, aId){
			var index = aIdx[i];
			$('input[name=jqczPjlx]:eq(' + index + ')').removeAttr('checked');
			$('input[name=jqczPjlx]:eq(' + index + ')').attr('disabled', 'disabled');
			radio = $('#' + aId).html();
			radio = '<span style="color:#868686;margin:0 15px 0 0;">' + radio + '</span>';
			$('#' + aId).replaceWith(radio);
		});
		$('input[name=jqczPjlx]:eq(' + idx + ')').attr('checked', 'checked');
	},
	
	/**
	 * 初始化科技设备列表
	 * @param ddId     科技设备展示元素ID
	 * @param callback 回调方法
	 */
	initKjsbList : function(ddId, marker, callback) {
		if (marker == 'pj') {// 派警
			HTTPREQPARAM = { url : 'jqcz/getKjsbList.f', data : {}};
			// 消息发送类型
			var msgTypes = [ 1, 2, 3, 4, 5, 6 ], callTypes = [ 0, 3, 4, 6 ];
			var txt = '<div class="lf" style="height:80px;"><div class="tips_checkb" style="width:272px;height:48px;margin:0 5px;clear:both;" id=\'rd_' + ddId + '_' + marker + '\'>', checked = '', types = 0;
			var btnTxt = '', area = '', disabled = 'disabled=\'disabled\'';
			var lastType = 0;
			SysTool.ajax(HTTPREQPARAM, function(data){
				$.each(data, function(i,obj){
					if (btnTxt == '') {
						types = obj['tdlx'];
						if(msgTypes.isExist(types)){
							if(lastType != 1){						
								lastType = 1;
								if(marker != 'db'){
									btnTxt += '<a href="javascript:void(0);" ' + disabled + ' id="kjsb_msg_btn_' + marker + '" onclick="Jqcz.jqczKjsbSMSSend(\'jqcz_pj_jjmjdm\',\'' + marker + '\');" class="btn_tipssave btn_tipssaveb btn_tipssavee">发&nbsp;&nbsp;&nbsp;&nbsp;送</a>';
								}else{
									btnTxt += '<a href="javascript:void(0);" ' + disabled + ' id="kjsb_msg_btn_' + marker + '" onclick="Jqcz.jqczJqdbSMSSend(\'jqcz_jqdb_jyxx\',\'' + marker + '\');" class="btn_tipssave btn_tipssaveb btn_tipssavee">发&nbsp;&nbsp;&nbsp;&nbsp;送</a>';
								}
							}
						}
						if(callTypes.isExist(types)){
							if(lastType != 2){						
								lastType = 2;
								btnTxt += '<a href="javascript:void(0);" ' + disabled + ' id="kjsb_call_btn_' + marker + '" onclick="Jqcz.jqczVoiceCall(\'jqcz_pj_jjmjdm\');" class="btn_tipssave btn_tipssaveb btn_tipssavee">呼&nbsp;&nbsp;&nbsp;&nbsp;叫</a>';
							}
						}
					}
					area = '<textarea id="jqcz_pj_xxnr_' + marker + '" ' + disabled + '  style="width:260px; height:28px;margin:0 0 0 15px;"></textarea>';
					checked = (i == 0) ? 'checked=\'checked\'' : '';
					txt += '<a showchange='+ obj['dm'] +' style="width:125px;padding:0 5px 0 0;white-space: nowrap;float:left;overflow:visible;" href="javascript:void(0);" ' + disabled + '><input type="radio" name="pjtzfs_' + marker + '" ' + checked + ' value="' + obj['dm'] + ',' + obj['ct'] + ',' + obj['tdlx'] + '"/><span>' + obj['ct'] + '</span></a>';
				});
				txt += '</div><div id="jqcz_kjsb_lf_' + marker + '"></div></div>';
				txt += '<div class="rt" id="jqcz_kjsb_rt_' + marker + '">';
				txt += '</div>';
				$('#' + ddId + '_' + marker).html(txt);
				$('#' + ddId + '_' + marker).show();
				$('#jqcz_kjsb_rt_' + marker).html(btnTxt);
				$('#jqcz_kjsb_lf_' + marker).html(area);
				SysTool.changeIputStyle();
				// 注册科技设备类型点击事件
				$('#rd_' + ddId + '_' + marker + ' > a').click(function() {
					var idx = $(this).index();
					// 设置选中
					var radio = $('input[name=pjtzfs_' + marker + ']:eq(' + idx + ')');
					radio.attr('checked','checked');
					types = ((radio.val()).split(','))[2];
					Jqcz.setKjsbBingRadioEvent(types, marker);
					var kjsbDm = ((radio.val()).split(','))[0];
					Jqcz.showKjsbHm(kjsbDm, marker, radio);
				});
				callback(data);
			});
		} else {
			HTTPREQPARAM = { url : 'jqcz/getKjsbList.f', data : {}};
			// 消息发送类型
			var msgTypes = [ 1, 2, 3, 4, 5, 6 ], callTypes = [ 0, 3, 4, 6 ];
			var txt = '<div class="tips_checkb" id=\'rd_' + ddId + '_' + marker + '\'>', checked = '', types = 0;
			var btnTxt = '', area = '', disabled = 'disabled=\'disabled\'';
			var lastType = 0;
			SysTool.ajax(HTTPREQPARAM, function(data){
				$.each(data, function(i,obj){
					if (btnTxt == '') {
						types = obj['tdlx'];
						if(msgTypes.isExist(types)){
							if(lastType != 1){						
								lastType = 1;
								if(marker != 'db'){
									btnTxt += '<a href="javascript:void(0);" ' + disabled + ' id="kjsb_msg_btn_' + marker + '" onclick="Jqcz.jqczKjsbSMSSend(\'jqcz_pj_jjmjdm\',\'' + marker + '\');" class="btn_tipssave btn_tipssaveb btn_tipssavee">发&nbsp;&nbsp;&nbsp;&nbsp;送</a>';
								}else{
									btnTxt += '<a href="javascript:void(0);" ' + disabled + ' id="kjsb_msg_btn_' + marker + '" onclick="Jqcz.jqczJqdbSMSSend(\'jqcz_jqdb_jyxx\',\'' + marker + '\');" class="btn_tipssave btn_tipssaveb btn_tipssavee">发&nbsp;&nbsp;&nbsp;&nbsp;送</a>';
								}
							}
						}
						if(callTypes.isExist(types)){
							if(lastType != 2){						
								lastType = 2;
								btnTxt += '<a href="javascript:void(0);" ' + disabled + ' id="kjsb_call_btn_' + marker + '" onclick="Jqcz.jqczVoiceCall(\'jqcz_pj_jjmjdm\');" class="btn_tipssave btn_tipssaveb btn_tipssavee">呼&nbsp;&nbsp;&nbsp;&nbsp;叫</a>';
							}
						}
					}
					area = '<textarea id="jqcz_pj_xxnr_' + marker + '" ' + disabled + '  style="width:180px; height:74px;"></textarea>';
					checked = (i == 0) ? 'checked=\'checked\'' : '';
					txt += '<a href="javascript:void(0);" ' + disabled + '><input type="radio" name="pjtzfs_' + marker + '" ' + checked + ' value="' + obj['dm'] + ',' + obj['ct'] + ',' + obj['tdlx'] + '"/>' + obj['ct'] + '</a>';
				});
				txt += '</div><div class="lf" id="jqcz_kjsb_lf_' + marker + '"></div>';
				txt += '<div class="rt" id="jqcz_kjsb_rt_' + marker + '">';
				txt += '</div>';
				$('#' + ddId + '_' + marker).html(txt);
				$('#' + ddId + '_' + marker).show();
				$('#jqcz_kjsb_rt_' + marker).html(btnTxt);
				$('#jqcz_kjsb_lf_' + marker).html(area);
				SysTool.changeIputStyle();
				// 注册科技设备类型点击事件
				$('#rd_' + ddId + '_' + marker + ' > a').click(function() {
					var idx = $(this).index();
					// 设置选中
					var radio = $('input[name=pjtzfs_' + marker + ']:eq(' + idx + ')');
					radio.attr('checked','checked');
					types = ((radio.val()).split(','))[2];
					Jqcz.setKjsbBingRadioEvent(types, marker);
				});
				callback(data);
			});
		}
		
	},
	/**
	 * 显示科技设备号码
	 */
	showKjsbHm : function(kjsbDm, marker, radio) {
		var jyxx = SysTool.getTxtVal('jqcz_' + marker + '_jjmjdm');// [0：警员编号、1：身份证号码、2：警员电话、3：警员设备编号、4：警员名称]
		jyxx = jyxx.split(",");
		var targetObj = radio.next();
		if (kjsbDm == "0") {// 手机
			if ("undefined" != typeof jyxx[2] && jyxx[2] != null && jyxx[2] != "") {
				if (targetObj.text().indexOf("(") == -1) {
					targetObj.text(targetObj.text() + "(" + jyxx[2] + ")");
				} else {
					targetObj.text(targetObj.text().split("(")[0] + "(" + jyxx[2] + ")");
				}
			}
		} else {
			SysTool.ajax({ url : 'jqcz/queryKjsbBind.f', data : {"jybh": jyxx[0], "sbbh": jyxx[3], "sblb": kjsbDm}}, function(data){
				if (data.length > 0) {
					if ("undefined" != typeof data[0].ghh && data[0].ghh != null && data[0].ghh != "") {
						if (targetObj.text().indexOf("(") == -1) {
							//targetObj.text(targetObj.text() + "(238-0607)");
							targetObj.text(targetObj.text() + "(" + data[0].ghh + ")");
						} else {
							targetObj.text(targetObj.text().split("(")[0] + "(" + data[0].ghh + ")");
						}
					}
				}
			});
		}
	},
	/**
	 * 初始化现场感知
	 * @param data 警情信息
	 */
	initJqczXcgz : function(param, callback){
		HTTPREQPARAM = { url : 'jqcz/getJqczXcgz.f', data : {'jqbh' : param['jqbh'], 'jhcm': param['jhcm']}};
		SysTool.ajax(HTTPREQPARAM, function(xcgz) {
			if(!$.isEmptyObject(xcgz)){
				var list = xcgz.list;
				var pic = xcgz.pic;
				var sound = xcgz.sound;
				var video = xcgz.video;
				var countList = list.split(',');
				var id = param['id'];
				$('#' + id + '_tp_val').val(pic);
				$('#' + id + '_yy_val').val(sound);
				$('#' + id + '_sp_val').val(video);
				
				$('#' + id + '_tp').text(countList[0]);
				$('#' + id + '_yy').text(countList[1]);
				$('#' + id + '_sp').text(countList[2]);
				if($.isFunction(callback)){
					callback();
				}
			}
		});
	},
	/**
	 * 获取已派列表
	 * @param jqbh 警情编号
	 */
	getJqypList : function(jqbh) {
		SysTool.ajax({
			url : "jqcz/queryYpJqcljhsjByJqbh.f",
			data : {"jqbh": jqbh}
		}, function(data) {
			var htmlString = "<table style='margin:5px 0 0;' align='center' border='0' width='390' cellpadding='1' cellspacing='1' bgcolor='#ffffff'>";
			htmlString += "<tr bgcolor='#badaf1'>";
			htmlString += "<th width='10%' align='center'>类型</th>";
			htmlString += "<th width='25%' align='center'>时间</th>";
			/*
			htmlString += "<th width='15%' align='center'>姓名</th>";
			htmlString += "<th width='15%' align='center'>电话</th>";
			htmlString += "<th width='20%' align='center'>所属大队</th>";
			htmlString += "<th width='20%' align='center'>所属中队</th>";
			*/
			htmlString += "<th width='65%' align='center'>人员信息</th>";
			htmlString += "</tr>";
			if ("undefined" != typeof data.list && data.list != null) {
				for (var i = 0; i < data.list.length; i++) {
					htmlString += "<tr bgcolor='#d7e9f7'>";
					htmlString += "<td align='center'>" + ("undefined" != typeof data.list[i].jqcljhsjct ? (data.list[i].jqcljhsjct == "派警" ? "出警" : data.list[i].jqcljhsjct) : "") + "</td>";
					htmlString += "<td align='center'>" + ("undefined" != typeof data.list[i].sjfqsj ? SysTool.getDateTimeFormatNoSecond(data.list[i].sjfqsj) : "") + "</td>";
					/*
					htmlString += "<td align='center'>" + ("undefined" != typeof data.list[i].sjxyrmc ? data.list[i].sjxyrmc : "") + "</td>";
					htmlString += "<td align='center'>" + ("undefined" != typeof data.list[i].sjxyrdh ? data.list[i].sjxyrdh : "") + "</td>";
					htmlString += "<td align='center'>" + ("undefined" != typeof data.list[i].ssdd ? data.list[i].ssdd : "") + "</td>";
					htmlString += "<td align='center'>" + ("undefined" != typeof data.list[i].sszd ? data.list[i].sszd : "") + "</td>";
					*/
					var ryxxString = ("undefined" != typeof data.list[i].sjxyrmc ? data.list[i].sjxyrmc : "") 
					                 + "：" 
					                 + ("undefined" != typeof data.list[i].sjxyrdh ? data.list[i].sjxyrdh : "")
					                 + "（" 
					                 + ("undefined" != typeof data.list[i].ssdd ? data.list[i].ssdd : "") 
					                 + ("undefined" != typeof data.list[i].sszd ? data.list[i].sszd : "") 
					                 + "）";
					htmlString += "<td align='left'>";
					htmlString += "<span title='" + ryxxString + "' style='display:block;width:250px;height:25px;overflow:hidden;white-space:nowrap;word-break:keep-all;text-overflow:ellipsis;'>";
					htmlString += ryxxString;
					htmlString += "</span>";
					htmlString += "</td>";
					htmlString += "</tr>";
				}
			}
			htmlString += "</table>";
			$("#jqcz_jqyp_dd").html(htmlString);
			if ($("#jqcz_jqyp_dd table").find("tr").size() > 5) {
				ScrollBarTool.init("scroll_main_jqyp", "scroll_content_jqyp", false);
			}
		});
	},
	/**
	 * 根据警情类型展示不同面板
	 * @param data 警情信息
	 */
	showComponetByLx : function(data) {
		var jqzt = data['jqzt'];
		var jqlx = (data['jqlxdm'].split(','))[1];
		if (jqzt != 5) {
			setTabShow(Jqcz.JQCZTAB, false);
		}
		if(jqlx == 0 || jqlx == 1){
			// 出警
			if (jqzt == 1) {
				setTabShow([ 'jqdw', 'jqyj', 'ejcj'], true);
				Jqcz.initEjcjData();
				Jqcz.initJqyjData();
			} else if (jqzt == 2) {
				// 常规警情
				if(jqlx == 0){					
					setTabShow([ 'jqdw', 'cgjq', 'jqyj', 'ejcj', 'jqyp' ], true);
					Jqcz.initEjcjData();
				}else{
					// 重大警情上报
					setTabShow([ 'jqdw', 'cgjq', 'zdjq', 'jqyj', 'jqyp' ], true);
					Jqcz.initZdjqSb();
				}
				Jqcz.getJqypList(data['jqbh']);// 获取已派列表
				// 已派tab注册点击事件
				$("#jqcz_jqyptab").click(function() {
					Jqcz.getJqypList(data['jqbh']);// 获取已派列表
				});
				Jqcz.initJqzp(data, true, function(){
					Jqcz.initJqczCjlxChecked(0);
				});
				// 初始化移交
				Jqcz.initJqyjData();
			}else if(jqzt >= 3 && jqzt < 5){
				// 常规警情
				if(jqlx == 0){		
					setTabShow(['jqdw', 'cgjq', 'jqzp', 'jqdb', 'jqyp'], true);
				}else{
					setTabShow(['jqdw', 'cgjq', 'jqzp', 'zdjq', 'jqdb', 'jqyp'], true);
					Jqcz.initZdjqSb();
				}
				Jqcz.getJqypList(data['jqbh']);// 获取已派列表
				// 已派tab注册点击事件
				$("#jqcz_jqyptab").click(function() {
					Jqcz.getJqypList(data['jqbh']);// 获取已派列表
				});
				if(jqzt == 3){					
					SysTool.setTxtVal('jqcz_dd_bz', data.jqxxbc);
				}else{
					SysTool.setTxtVal('jqcz_cz_bcsm', data.jqxxbc);
				}
				// 增派警情
				Jqcz.initJqzp(data, false, function(){
					Jqcz.initJqczCjlxChecked(3);
				});
				// 督办信息
				Jqcz.lazyLoad(function() {
					Jqcz.initKjsbList('jqcz_pjfs_dd', 'db', function() {});
					Jqcz.initJqdbXx(data);
					// 初始化现场感知
					Jqcz.initJqczXcgz({id: 'jqcz_xcgz', jqbh: data['jqbh'], jhcm : ''}, function(){
						if(jqzt == 4){
							$('#jqcz_czz_xcgz').show();
							var xcgz = $('#jqcz_ddxc_xcgz').html();
							if(xcgz != ''){
								$('#jqcz_czz_xcgz').html(xcgz);
								$('#jqcz_ddxc_xcgz').html('');
								$('#jqcz_ddxc_xcgz_title').html('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;现场感知：');
							}
						}else{
							$('#jqcz_czz_xcgz').hide();
							$('#jqcz_czz_xcgz').html('');
						}
					});
				}, 200);
			}
		} else if (jqlx == 2 || jqlx == 4) {
			// 只做记录
			setTabShow([ 'jqjl' ], true);
			Jqcz.lazyLoad(function() {
				// 记录
				var jqlxmc = SysTool.getTxtVal('jqcz_jqlxmc');
				$('#jqcz_jqjltab').text(jqlxmc);
				Dictionary.initDictionaryList({
						url : "dict/queryJlnrList.f",
						data : {"zdbh" : ''},
						dictShowId : "jqcz_jl_jlnr"
					}, function() {
				}, function() {
					$("#jqcz_jl_jlnr").val("");
					$("#jqcz_jl_jlnrdm").val("");
				});
			}, 1200);
		} else if (jqlx == 3) {
			// 投诉
			setTabShow([ 'jqts' ], true);
			var zzjgdm = SysConfig.T_USER_LOGIN_ORGID_ZD;
			Dictionary.initDictTree({
				url : "dictionary/getOrganizationDictTreeJSON.f",
				zdbh : "D_ORG",
				zdmc : "组织机构",
				zzjgdm : zzjgdm,
				dictDataDivId : "jqcz_ts_tsdwmc_data_Div"
			}, function() {
				Dictionary.beforeCreateDictTree({
					createCount : 1,
					zdbh : "D_ORG",
					treeData : data_D_ORG,
					dictDataDivId : "jqcz_ts_tsdwmc_data_Div"
				});
				Dictionary.createDictTree({
					dictObject : D_ORG,
					treeData : data_D_ORG_1,
					isLeaf : false,
					dictHiddenId : "jqcz_ts_tsdwdm",
					dictShowId : "jqcz_ts_tsdwmc"
				});
			});
			Dictionary.initDictionaryList({
					url : "dict/queryJlnrList.f",
					data : {"zdbh" : ''},
					dictShowId : "jqcz_ts_tsnr"
				}, function() {
			}, function() {
				$("#jqcz_ts_tsnr").val("");
				$("#jqcz_ts_tsnrdm").val("");
			});
		} else if (jqlx == 5) {
			if (jqzt != 5) {
				Jqcz.initJqdwData();
				// 初始化事后报警
				Jqcz.initPersonnel('sh', false);
				setTabShow([ 'jqdw', 'shbj' ], true);
				Jqcz.setRadioChecked('jqcz_sh_jtzt', 'shbjXcjt');
				var dt = new Date();
				var date = SysTool.getDateTimeFormat(dt);
				SysTool.setTxtVal('jqcz_sh_cjsj', date);
				SysTool.setTxtVal('jqcz_sh_bz', data.jqxxbc);
			}
		}
		function setTabShow(idArry, isShow) {
			var id = '#jqcz_' + idArry[0] + 'tab';
			var tabName = '';
			var count = idArry.length;
			var size = (jqzt == 1) ? 0 : ((count > 1) ? 1 : 0);
			for ( var i = 0; i < count; i++) {
				id = '#jqcz_' + idArry[i] + 'tab';
				if (i == size) {
					tabName = idArry[i];
				}
				isShow ? $(id).show() : $(id).hide();
			}
			// 初始化tab
			if (tabName != '' && isShow == true) {
				Jqcz.setJqczTabEvent(tabName);
			}
		}
	},

	/**
	 * 根据警情状态展示不同面板
	 * 
	 * @param data
	 *            警情信息
	 */
	showComponetByZt : function(data) {
		var jqzt = data['jqzt'];
		$('#jqcz_cllc_dt').css('visibility', 'visible');
		$('.tips_slide_up').css('visibility', 'visible');
		if (jqzt < 4) {
			Jqcz.initJqdwData();
		}
		var tabName = '派警';
		if (jqzt == 1) {
			$('.tips_slide_up').bind('jqdwTabTrigger', function() {
				Jqcz.lazyLoad(function() {
					Jqcz.jqczToggle();
					$(".dl_paijin > dd").hide();
				}, 1);
			});
			$('.tips_slide_up').trigger('jqdwTabTrigger');
			$('#pj_span').show();
		} else if (jqzt == 2) {
			//Jqcz.initPersonnel('pj', true, true);
			//Jqcz.initJqyjData();
			//Jqcz.initEjcjData();
			$('#pj_span').show();
		} else if (jqzt == 3) {
			tabName = '到达';
			$('#ddxc_span').show();
			Jqcz.setRadioChecked('jqcz_ddxc_jtzt', 'jqczXcjt');
		} else if (jqzt == 4) {
			tabName = '处置';
			Jqcz.setJqczTxxxInfo([ 3 ], data, 'jqcz_pj_jjmjmc');
			$('#czz_span').show();
			Jqcz.setRadioChecked('jqcz_czz_jtzt', 'czzXcjt');
		} else if (jqzt == 5) {
			tabName = '反馈';
			Jqcz.setTabShowFunc(Jqcz.JQCZTAB, false);
			Jqcz.setTabShowFunc(["czjg"], true);
//			$('#jqcz_cllc_dt').css('visibility', 'hidden');
//			$('.dl_paijin > dd').hide();
//			$('.tips_slide_up').css('visibility', 'hidden');
//			$('.tips_slide_up').removeClass('tips_slide_dw');
			$('#jqcz_save_btn').remove();
			$('#jqcz_sqbg_btn').remove();
			$('#jqcz_jqbg_btn').remove();
			Jqcz.getCzjgnr(data["jqbh"], data['jqlxdm']);
//			Jqcz.lazyLoad(function(){
//				$('.tips_slide_up').bind('jqwcTabTrigger', function() {
//					Jqcz.jqczToggle();
//					$('#jqcz_jqlxmc').removeAttr('disabled');
//					$(".dl_paijin > dd").hide();
//				});
//				$('.tips_slide_up').trigger('jqwcTabTrigger');
//			}, 300);
		}
		// 只要定位成功后就能够查看回访
		if (jqzt != 1) {
			$('#jqcz_jqhf').show();
		}
		if (jqzt > 2) {
			$('#jqcz_jqlxmc').attr('disabled', 'disabled');
			$('#jqcz_sqbg_btn').show();
		}
		$('#jqcz_cgjqtab').text(tabName);
		/**by pan*/
		if((data["ejzt"]=="1")&&data["ssbgrid"]==SysConfig.USERID){//登录者为派发二级处警人时该警情不显示二级菜单
			Jqcz.setTabShowFunc(Jqcz.JQCZTAB, false);
			Jqcz.setTabShowFunc(["jqyp"], true);
			Jqcz.getJqypList(data['jqbh']);// 获取已派列表
			// 已派tab注册点击事件
			$("#jqcz_jqyptab").click(function() {
				Jqcz.getJqypList(data['jqbh']);// 获取已派列表
			});
		}
		if((data["ejzt"]=="1")&&data["ssejczr"]==SysConfig.USERID){//登录者为接收二级处警人时该警情不显示二级菜单
			Jqcz.setTabShowFunc(["ejcj"], false);
		}
		if(data["ejzt"]=='0'&&data["ssbgrid"]==SysConfig.USERID){
//			Jqcz.setTabShowFunc(Jqcz.JQCZTAB, false);
			Jqcz.setTabShowFunc(["ejcj"], false);
		}
		/**by pan*/
	},
	/**
	 * 修改警情信息
	 */
	updateJqxx : function() {
		if($('#tips_showdx').hasClass("tips_showdx")==true){
			$('#tips_showdx').toggleClass('tips_showdx');
		}
		var ipt = $('.tips_show_1 :input');
		var param = {
			'jqbh' : this.getJqbh()
		}, pk = '';
		$.each(ipt, function(i, key) {
			pk = (($(key).attr('id')).split('_'))[1];
			if (pk != 'jjsj' && pk != 'bjsj') {
				param[pk] = $(key).val();
			}
		});
	
		delete param['deadcount'];
		delete param['hurtcount'];
		
		// 设置日期格式时间
		param['jqJjsj'] = SysTool.getTxtVal('jqcz_jjsj');
		param['jqBjsj'] = SysTool.getTxtVal('jqcz_bjsj');
		// 设置选中值
		param['sfswhcl'] = $('#jqcz_sfswhcl').is(':checked') ? 1 : 0;
		param['ywrysw'] = $('#jqcz_ywrysw').is(':checked') ? 1 : 0;
		param['sfsjtsgdsr'] = $('#jqcz_sfsjtsgdsr').is(':checked') ? 1 : 0;
		param['ywty'] = $('#jqcz_ywty').is(':checked') ? 1 : 0;
		
		
		
		
	
		// 设置选中值
		
		param['ifschool'] = $('#jqcz_ifschool').is(':checked') ? "1" : "0";
		param['ifmotor'] = $('#jqcz_ifmotor').is(':checked') ? "1" : "0";
		param['iftaxi'] = $('#jqcz_iftaxi').is(':checked') ? "1" : "0";
		param['ifpolice'] = $('#jqcz_ifpolice').is(':checked') ? "1" : "0";
		param['ifelectric'] = $('#jqcz_ifelectric').is(':checked') ? "1" : "0";
		param['ifdxhurt'] = $('#jqcz_ifdxhurt').is(':checked') ? "1" : "0";
		
		param['ifdead'] = $('#jqcz_ifdead').is(':checked') ? "1" : "0";
		param['ifhurt'] = $('#jqcz_ifhurt').is(':checked') ? "1" : "0";
		
		
		
// 增加伤亡人数
		
		if (param['ifhurt']> 0) {
			
			var hurtcount= SysTool.getTxtVal('jqcz_hurtcount');
			if (hurtcount== "") {
				SysTool.tooltips('jqcz_hurtcount', '请输入受伤人数！');
				 return null;
			}
			if (!Jqcz.isInteger(hurtcount)){
			 SysTool.tooltips('jqcz_hurtcount', '受伤人数必须为正整数！');
			 return null;
			}
			else{
				param['hurtcount'] = hurtcount;
				}
			}
		
		
		if (param['ifdead']> 0) {
		
			var deadcount =SysTool.getTxtVal('jqcz_deadcount');
			if (deadcount== "") {
				SysTool.tooltips('jqcz_deadcount', '请输入死亡人数！');
				 return null;
			}
			if (!Jqcz.isInteger(deadcount)){
				 SysTool.tooltips('jqcz_deadcount', '死亡人数必须为正整数！');
				 return null;
				}
			else{
				param['deadcount'] = deadcount;
				}
		}
		
		
		var lddm = param['lddm'];
	
		if (lddm == '') {
			param['ldmc'] = '';
		}
		var loginOrg = Jqcz.JQXXDATA.jqssdddm;
		param['glbm'] = loginOrg;
		param['xzqh'] = loginOrg.substring(0, loginOrg.length - 6);
		// 验证警情信息
		var vail = vaildJqxx();
		if (vail) {
			var cls = 'tips_slide_up tips_slide_dw';
			var clss = $('#jqcz_window_toggle').attr('class');
			if(cls == clss){
				$('.tips_slide_up').toggleClass('tips_slide_dw');
				$('.tips_paijin').toggle(0);
				$('.show_toggle').toggle(0);
				$(".dl_paijin > dd").hide();
			}
			return;
		}
//		alert(JSON.stringify(param));
		// SysTool.alert('请求参数：' + JSON.stringify(param));
		HTTPREQPARAM = {url : 'jqcz/updateJqxx.f',data : param};
		SysTool.ajax(HTTPREQPARAM, function(data) {
			if (data.status > 0) {
				SysTool.show('成功修改警情信息！');
				Jqcz.setJqczTxxxInfo([1], Jqcz.JQXXDATA, 'jqcz_pj_jjmjmc');
				var jqzt = Jqcz.JQXXDATA['jqzt'];
				// 未定位、未派警警情
				if (jqzt <= 2) {
					jqlxdm = SysTool.getTxtVal('jqcz_jqlxdm');
					var jqxyfl = jqlxdm.split(',');
					// 进行警情变更
					var jqlx = jqxyfl[0];
					Jqcz.JQXXDATA['jqlxdm'] = jqlxdm;
					// 初始化类型
					Jqcz.showComponetByLx(Jqcz.JQXXDATA);
					HTTPREQPARAM = { url : 'jqcz/updateJqlx.f', data : {'jqbh' : Jqcz.getJqbh(), 'jqlxdm' : jqlx} };
					SysTool.ajax(HTTPREQPARAM, function(data) {});
				}
			} else {
				SysTool.show('修改警情信息失败！');
			}
			delete param;
		});

		function vaildJqxx() {
			var vail = false;
			// 报警信息验证
			vail = SysTool.validator.isBlank([ {
				id : 'jqcz_bjrxm',
				msg : '报警人姓名不能为空！'
			}, {
				id : 'jqcz_jjrxm',
				msg : '接警人姓名不能为空！'
			}, {
				id : 'jqcz_jqssdldm',
				msg : '警情大类不能为空！',
				sId : 'jqcz_jqssdlmc'
			}, {
				id : 'jqcz_jqsszldm',
				msg : '警情中类不能为空！',
				sId : 'jqcz_jqsszlmc'
			}/*, {
				id : 'jqcz_jqssxldm',
				msg : '警情小类不能为空！',
				sId : 'jqcz_jqssxlmc'
			}*/, {
				id : 'jqcz_jqafdd',
				msg : '警情案发地址不能为空！'
			}, {
				id : 'jqcz_jqxx',
				msg : '警情信息址不能为空！'
			}, {
				id : 'jqcz_jqlxdm',
				msg : '警情类型不能为空！',
				sId : 'jqcz_jqlxmc'
			} ]);
			if (vail) { return vail; }

			vail = SysTool.validator.maxLength('jqcz_jqafdd', Jqcz.MAXLEN.JQAFDD);
			if (vail) { return vail; }
			vail = SysTool.validator.maxLength('jqcz_jqxx', Jqcz.MAXLEN.JQXXCT);
			if (vail) {return vail;}
			
			if ($("#jqcz_bjdh").val() != "") {
				vail = SysTool.validator.mobileFormat('jqcz_bjdh');
			}
			if (vail) {return vail;}
			vail = SysTool.validator.dateFormater('jqcz_bjsj');
			if (vail) {return vail;}
			// 接警信息验证
			vail = SysTool.validator.dateFormater('jqcz_jjsj');
			if (vail) {return vail;}
			
			return vail;
		}
	},
	
	 /**
	 *验证是否为整数
	 * checkbox的id
	 */
	isInteger:function(str){
 
		var regu = /^[-]{0,1}[0-9]{1,}$/;

		if(str=='0'){
			return false;
		}
		return regu.test(str);

		},
	/**
	 * 警情申请上报
	 */
	updateSqbg : function(isBg) {
		if(isBg){
			$('#jqcz_jqlxmc').removeAttr('disabled');
			$('#jqcz_sqbg_btn').hide();
			$('#jqcz_jqbg_btn').show();
		}else{
			$('#jqcz_jqlxmc').attr('disabled','disabled');
			$('#jqcz_sqbg_btn').show();
			$('#jqcz_jqbg_btn').hide();
		}
	},
	/**
	 * 警情变更记录
	 */
	updateJqbg : function() {
		var jqlxdm = SysTool.getTxtVal('jqcz_jqlxdm');
		var jqlxmc = SysTool.getTxtVal('jqcz_jqlxmc');
		var jqxyfl = jqlxdm.split(',');
		var data = Jqcz.JQXXDATA;
		if (jqxyfl[0] != Jqcz.JQCGBGXYFL[0]) {
			SysTool.confirm('确认将警情类型变更为' + jqlxmc + '吗？', function(r) {
				if (r) {
					// 进行警情变更
					var jqlx = jqxyfl[0];
					Jqcz.JQXXDATA['jqlxdm'] = jqlxdm;
					// 初始化类型
					Jqcz.showComponetByLx(data);
					HTTPREQPARAM = {url : 'jqcz/updateJqlx.f',data : { 'jqbh' : data['jqbh'], 'jqlxdm' : jqlx }};
					SysTool.ajax(HTTPREQPARAM, function(data) {
						$('#jqcz_jqlxmc').attr('disabled', 'disabled');
						$('#jqcz_sqbg_btn').show();
						$('#jqcz_jqbg_btn').hide();

						// 常规警情变更
						var param = { 'jqlx' : 0, 'jqxyfldm' : Jqcz.JQCGBGXYFL[0], 'jqbgfldm' : jqlx, 'bgyy' : '常规警情变更', bgmc: jqlxmc };
						Jqcz.jqczJqbgjl(param, jqlxmc);
						Jqcz.JQCGBGXYFL = [ jqxyfl[0], jqxyfl[1] ];
					});
				} else {
					// 还原上次选择
					var cm = Jqcz.JQCGBGXYFL[0] + ',' + Jqcz.JQCGBGXYFL[1];
					Dictionary.setDictionaryListValue({ dictShowId : 'jqcz_jqlxmc', setVal : cm });
					Jqcz.updateSqbg(false);
					return;
				}
			});
		} else {
			SysTool.show('警情类型未改变，变更无效！');
			$('#jqcz_jqlxmc').attr('disabled', 'disabled');
			$('#jqcz_sqbg_btn').show();
			$('#jqcz_jqbg_btn').hide();
		}
	},

	/**
	 * 警情定位(更改警情坐标信息)
	 */
	updateJqzb : function() {
		/*yichu begin 警情类型验证*/
		var vail = false;
		vail = SysTool.validator.isBlank([ {
			id : 'jqcz_jqlxdm',
			msg : '警情类型不能为空！',
			sId : 'jqcz_jqlxmc'
		} ]);
		if (vail) { return vail; }
		/*yichu end*/
		/**
		 * 1、自动辖区定位 2、获取新坐标所属大队、中队： 2.1、如当前警情为派警则需要自动更重置警员所在大队、中队并更加新定位的单位加载警员。
		 * 2.2、判断当前用户是否为管理员，如果是管理员可以定位任意区域
		 * 2.3、当前登录用户非管理员，则定位只能够定位当前用户所在大队区域如果越区则给与提示。 3、更新当前警情定位后的新坐标到客户端。
		 * 4、更新当前警情定位后的坐标到数据表
		 */
		 /* by pan*/
		//var lddm = SysTool.getTxtVal('jqcz_fzdw_lddm'), ldmc = SysTool.getTxtVal('jqcz_fzdw_ldmc');
		//if ((lddm != '' && ldmc != '') || (lddm != '' && ldmc == '')) {
		//	Jqcz.jqxxLddw({'lddm' : lddm, 'ldmc' : ldmc	}, function() { /**/});
	//	}
		/* by pan*/
		MapBubble.hideBubble();
		SysTool.getLocateXY(function(coord) {
			var coords = coord.split(',');
			var pointX = coords[0];
			var pointY = coords[1];
			SysTool.confirm('确定将警情定位至X: ' + pointX + ', Y: ' + pointY+ '吗 ？',function(r) {
				if (r) {
					if (Jqcz.jqlxIsEmpty) {
						Jqcz.jqlxIsEmpty = false;
						Jqcz.updateJqxx();
					}
					SysTool.getDwZdZzjgNew(pointX,pointY,function(zddm, zdmc, ssjgdm) {
						// 获取定位后的组织机构代码
						//SysTool.getDwDdZzjg(pointX,pointY,function(zzjgArry) {
							var dddm = ssjgdm;//zzjgArry[0];
							//var ddmc = zzjgArry[1];
							var ddmc = '';
							var DDT_USER_LOGIN_ORGID = Jqcz.getCurrentLoginUser().zzjgdm;
							//alert('dddm: ' + dddm + '\m loginOrg: ' + DDT_USER_LOGIN_ORGID);
							// 当前用户权限不是支队管理员
							if (SysConfig.T_USER_LOGIN_ORGID_ZD != DDT_USER_LOGIN_ORGID) {
								if (DDT_USER_LOGIN_ORGID != dddm && jqssdddm.indexOf(dddm) == -1) {
									SysTool.confirm('警情定位辖区已超出你权限范围，确认继续定位吗？', function(r){
										if(r){
											updateJqdwZb(dddm, ddmc, zddm, zdmc, pointX, pointY);
											return;
										}else{										
											MapBubble.showBubble();
											return;
										}
									});
								} else {
								    updateJqdwZb(dddm, ddmc, zddm, zdmc, pointX, pointY);
								}
							} else {
							    updateJqdwZb(dddm, ddmc, zddm, zdmc, pointX, pointY);
							}
						//});
					});
					Jqcz.hideLoateButton();// by pan
				} else {
					MapBubble.showBubble();
					Jqcz.hideLoateButton();// by pan
					return;
				}
			});
		});
		
		function updateJqdwZb(dddm, ddmc, zddm, zdmc, pointX, pointY){
			HTTPREQPARAM = {url : 'jqcz/updateZb.f', data : {'jqbh' : Jqcz.getJqbh(),'jqssdddm' : dddm,'jqsszddm' : zddm,'afdzx' : pointX,'afdzy' : pointY,'jqzt' : Jqcz.JQXXDATA.jqzt}};
			SysTool.ajax(HTTPREQPARAM,function(data) {
				if (data.status > 0) {
					Jqcz.JQXXDATA.afdzx = pointX;
					Jqcz.JQXXDATA.afdzy = pointY;
					SysTool.show('成功更新警情位置坐标！');
					var jqzt = Jqcz.JQXXDATA.jqzt;
					if(jqzt < 2){
						Jqcz.JQXXDATA.jqzt = 2;
						LeftLayout.hideLefLayout();
						Jqcz.updateJqxxIcon(2, false);
					}else{
						Jqcz.updateJqxxIcon(Jqcz.JQXXDATA.jqzt);
					}
					var jqdw = Jqcz.JQCZCLSJ.JQDW;
					// 添加事件记录
					var sjpm = {'cm' : jqdw[0], 'ct' : jqdw[1], 'ms' : Jqcz.getCurrentLoginUser().userName + '将警情定位至' + ddmc + zdmc + '辖区（X：'+ pointX+ ', Y：'+ pointY + '）'};
					Jqcz.jqczsjjl(sjpm);
					Jqcz.removeLastLayer();
				}
			});
		}
	},
	/**
	 * 警情投诉组织机构
	 */
	jqtsZzjgTree : function() {
		// 设置投诉人员
		Jqcz.clearSelectComponet([ 'jqcz_ts_tsry' ]);
		var zzjgdm = SysTool.getTxtVal('jqcz_ts_tsdwdm');
		Jqcz.initZzjgDict({
			type : 3,
			zzjgdm : zzjgdm,
			showId : 'jqcz_ts_tsrymc',
			initVal : ''
		}, function() {
		});
	},
	/**
	 * 警情信息路段定位
	 */
	jqxxLddw : function(param, callback) {
		var lddm = param['lddm'];
		var ldmc = param['ldmc'];
		/**
		 * 1、获取道路代码、路段代码 2、根据道路、路段代码查询道路图层并获取道路坐标点： 3、算法：
		 * 3.1、坐标点个数为奇数则取中间点坐标(1/2)。 3.2、坐标点个数为偶数： 3.2.1、小于等于2时取最后一个坐标点。
		 * 3.2.2、大于2时取中间坐标点减1所在的坐标点 4、道路上图并将警情定位到算出的坐标点上，并且闪烁2次道路。
		 */
		if (lddm == '' || ldmc == '') {
			SysTool.alert('路段无效或不存在！');
			return;
		}
		var aQuery = new QueryObject();
		aQuery.queryType = 6;
		aQuery.dispField = 'objectid,dldm';
		aQuery.addSubFields('objectid,dldm');
		aQuery.tableName = SysConfig.GIS_DB_USERNAME + '.' + SysConfig.JT_ROADSEGITEM_PL;
		aQuery.where = 'lddm=' + lddm;
		_MapApp.query(aQuery, function(vBIsOK, vRequestObj) {
			try {
				var features = new Array();
				var dwLayers = _MapApp.getQueryResult(vRequestObj);
				for ( var j = 0; j < dwLayers.length; j++) {
					if (dwLayers[j].tableName.toUpperCase() == aQuery.tableName
							.toUpperCase()) {
						features = dwLayers[j].features;
					}
				}
				var ilength = features.length;
				var areastr = '';
				var dwftrObj = '';
				if (ilength > 0) {
					for ( var i = 0; i < ilength; i++) {
						dwftrObj = features[i];
						areastr = dwftrObj.linestr;
					}
					Jqcz.removeLastLayer();
					MapBubble.hideBubble();
					var polyline = new Polyline(areastr, "#000079", 3, 0.5, "blue");
					_MapApp.addOverlay(polyline);
					polyline.flash(3);
					// 定位路段上图后地图层级缩放
					_MapApp.zoomTo(15);
					Jqcz.LASTROADLAYERPOLYLINE = polyline;

					var points = areastr.split(',');
					var len = points.length;
					var limit = (len / 2) / 2;
					limit = Math.ceil(limit);
					if ((len / 2) % 2 != 0) {
						limit = limit - 1;
					}
					var cdx = limit * 2, cdy = cdx + 1;
					var centerX = points[cdx], centerY = points[cdy];
					if (centerX != '' && centerY != '') {
						SysTool.locateByXY(centerX, centerY);
						// var title = new Title(ldmc, 12, 7, "宋体", "000000",
						// "FFFFFF", "FF0000", "1");
						// var point = new Point(centerX, centerY);
						// var pIcon = new Icon();
						// pIcon.image = "project/zhdd/images/chart_curve.png";
						// pIcon.width = 16;
						// pIcon.height = 16;
						// var marker = new Marker(point, pIcon, null);
						// _MapApp.addOverlay(marker);
						// 设置初始值图层
						// Jqcz.LASTROADLAYERMARKER = marker;
					}
					features.destroy();
					dwLayers = null;
					delete dwLayers;
					if ($.isFunction(callback)) {
						callback(areastr);
					}
				}
			} catch (e) {
				SysTool.alert('道路定位出错： ' + e.message);
			}
		});
	},
	/**
	 * 警情处置流程[派警、到达、反馈]
	 */
	jqczPjsj : function() {
		// 警员编号结构为[jybh,jysfz,jydh,sbbh]
		var xqczdm = SysTool.getTxtVal('jqcz_pj_xqjydm');
		var xqjyArry = xqczdm.split(',');
		var xqczmc = SysTool.getTxtVal('jqcz_pj_xqjymc');
		var cjmjdm = SysTool.getTxtVal('jqcz_pj_jjmjdm');
		var cjmjArry = cjmjdm.split(',');
		var cjmjmc = SysTool.getTxtVal('jqcz_pj_jjmjmc');

		var valid = SysTool.validator.isBlank([ {
			id : 'jqcz_pj_ssdddm',
			msg : '请选择派警警员所属大队！',
			sId : 'jqcz_pj_ssddmc'
		}, {
			id : 'jqcz_pj_sszddm',
			msg : '请选择派警警员所属中队！',
			sId : 'jqcz_pj_sszdmc'
		}, {
			id : 'jqcz_pj_jjmjdm',
			msg : '请选择派警警员！',
			sId : 'jqcz_pj_jjmjmc'
		} ]);
		if (valid) {return;}

		var pjfs = $("input[name='pjtzfs_pj']:checked").val();
		var pjfsArry = pjfs.split(',');
		var pjlx = $("input[name='jqczPjlx']:checked").val();
		var xxnr = SysTool.getTxtVal('jqcz_pj_xxnr_pj');
		var jqbh = Jqcz.getJqbh();
		var nextJqzt = 3;
		if(Jqcz.JQXXDATA.jqzt == 2){
			nextJqzt = 3;
		}else{
			nextJqzt = Jqcz.JQXXDATA.jqzt;
		}
		
		var pjdm = Jqcz.JQCZCLSJ.JQPJ[pjlx];
		var param = {
			'jqbh' : jqbh,
			'jqcljhsjcm' : pjdm[0],
			'jqcljhsjct' : pjdm[1],
			'jqzt' : nextJqzt,
			'jqcljhtjcm' : pjfsArry[0],
			'jqcljhtjct' : pjfsArry[1],
			// 事件发起人
			'sjfqrdm' : SysTool.getTxtVal('jqcz_jjrbh'),
			'sjfqrmc' : SysTool.getTxtVal('jqcz_jjrxm'),
			'sjfqrdh' : '',
			// 事件响应人
			'sjxyrdm' : cjmjArry[0],
			'sjxyrmc' : cjmjmc,
			'sjxyrdh' : cjmjArry[2],
			'sjxyrsbbh' : Jqcz.tspjSbbh == '' ? cjmjArry[3] : Jqcz.tspjSbbh,
			'sjxyrhh' : Jqcz.tspjHh == '' ? cjmjArry[3] : Jqcz.tspjHh,
			'sjxyrx' : Jqcz.CURRENTJYZB[0],
			'sjxyry' : Jqcz.CURRENTJYZB[1],
			// 先期处置
			'sjxyxqrdm' : xqjyArry[0],
			'sjxyxqrmc' : xqczmc,
			'sjxyxqrdh' : xqjyArry[2],
			'sjxyxqrsbbh' : xqjyArry[3],
			'sjxyxqrhh' : xqjyArry[3],
			// 交互内容
			'jhhm' : cjmjArry[2],
			'jhnr' : xxnr,
			// 短信[发送者为登录]
			'xxnr' : xxnr,
			'xxlx' : 1,
			'jsrid' : cjmjArry[0],
			'jsrm' : cjmjmc,
			'jshm' : cjmjArry[2],
			'pjlx' : pjlx,
			'jhsjcm' : Jqcz.JQCZCLSJ.JQPJ[0][0]
		};
		// alert('派警请求参数：' + JSON.stringify(param));
		HTTPREQPARAM = {url : 'jqcz/jqpj.f',data : param};
		var msg = '确认将警情' + pjdm[1] + '给警员' + cjmjmc + '吗？';
		SysTool.confirm(msg, function(r) {
			if (r) {
				SysTool.ajax(HTTPREQPARAM, function(data) {
					if (data.status > 0) {
						//var msg = '警情已' + pjdm[1] + '成功，' + pjdm[1] + '给' + cjmjmc + '！';
						var msg = '成功将警情' + pjdm[1] + '给警员' + cjmjmc + '！';
						SysTool.show(msg);
						// 更改地图进警情ICON
						Jqcz.updateJqxxIcon(nextJqzt);
						msg = '';
						if(pjlx == 0){
							msg = Jqcz.getCurrentLoginUser().userName + '将警情派发给' + cjmjmc + '（电话：' + cjmjArry[2] + '）';
						}else if(pjlx == 1){
							msg = Jqcz.getCurrentLoginUser().userName + '安排' + cjmjmc + '（电话：' + cjmjArry[2] + '）协助警情处置';
						}else if(pjlx == 2){
							msg = Jqcz.getCurrentLoginUser().userName + '将警情改派给' + cjmjmc+ '（电话：' + cjmjArry[2] + '）';
						}
						// 添加事件记录
						var sjpm = { 'cm' : param['jqcljhsjcm'], 'ct' : param['jqcljhsjct'], 'ms' : msg};
						Jqcz.jqczsjjl(sjpm);
						Jqcz.tspjSbbh = '';
						Jqcz.tspjHh = '';
					}
				});
			}
		});
	},
	/**
	 * 警情处置确认到达
	 */
	jqczQrdd : function() {
		var xcjt = $("input[name='jqczXcjt']:checked").val();
		var bcsm = SysTool.getTxtVal('jqcz_dd_bz');
		if (typeof (xcjt) == 'undefined') {
			SysTool.tooltips('jqcz_ddxc_jtzt', '请选择现场交通状况！');
			return;
		}
		if (bcsm != '') {
			var maxLen = SysTool.validator.maxLength('jqcz_dd_bz', Jqcz.MAXLEN.JQBCNR);
			if (maxLen) {return;}
		}
		var jqbh = Jqcz.getJqbh();
		
		Jqcz.getJqjhsjXxByJhsjcm(Jqcz.JQCZCLSJ.JQPJ[0][0], function(jhsj){
			if($(jhsj).size()){
				var msg = '确认警员' + jhsj['sjxyrmc'] + '已到达警情现场吗？';
				SysTool.confirm(msg, function(r) {
					if (r) {
						Jqcz.getJyzbBysbbh(jhsj['sjxyrsbbh'], function(zb){
							if($(zb).size() > 0){
								Jqcz.CURRENTJYZB[zb.x, zb.y];
							}
						});
						jqqrdd(jhsj);
					}
				});
			}
		});

		function jqqrdd(jhsj) {
			var nextJqzt = 4;
			var ddxc = Jqcz.JQCZCLSJ.DDXC;
			var sjfqrmc = jhsj['sjxyrmc'];
			var param = {
				// 交互事件
				'jqbh' : jqbh,
				'jqzt' : nextJqzt,
				'jqcljhsjcm' : ddxc[0],
				'jqcljhsjct' : ddxc[1],
				'jqcljhtjcm' : jhsj['jqcljhtjcm'],
				'jqcljhtjct' : jhsj['jqcljhtjct'],
				'sjfqrdm' : jhsj['sjxyrdm'],
				'sjfqrmc' : sjfqrmc,
				'sjfqrdh' : jhsj['sjxyrdh'],
				'sjfqrx' : Jqcz.CURRENTJYZB[0],
				'sjfqry' : Jqcz.CURRENTJYZB[1],
				'xxlxdm' : 'MSGTYPE02',
				// 交通状态
				'ddfkrbh' : jhsj['sjxyrdm'],
				'ddfkrmc' : sjfqrmc,
				'ddfkzt' : xcjt,
				// 警情补充信息
				'jqxxbc' : bcsm
			};
			HTTPREQPARAM = {url : 'jqcz/qrdd.f',data : param};
			SysTool.ajax(HTTPREQPARAM, function(data) {
				if (data.status > 0) {
					var msg = '警员' + sjfqrmc + '已到达警情现场！';
					SysTool.show(msg);
					Jqcz.updateJqxxIcon(nextJqzt);
					// 添加事件记录
					msg = sjfqrmc + '向' + Jqcz.getCurrentLoginUser().userName + '反馈已到达现场';
					var sjpm = {
						'cm' : param['jqcljhsjcm'],
						'ct' : param['jqcljhsjct'],
						'ms' : msg
					};
					Jqcz.jqczsjjl(sjpm);
				}
			});
		}
		;
	},
	/**
	 * 满意度调查
	 */
	jqczMyddc : function() {
		var bjr = SysTool.getTxtVal('jqcz_bjrxm');
		var bjrdh = SysTool.getTxtVal('jqcz_bjdh');
		if (bjr == '' || bjrdh == '') {
			SysTool.alert('报警电话和报警人不能为空！', SysTool.MSGICON.WARNING);
			return;
		}
		var param = { 'jqbh' : Jqcz.getJqbh(), 'dcfsdm' : 0, 'bdcrm' : bjr, 'bdcrhm' : bjrdh };
		HTTPREQPARAM = { url : 'jqcz/myddc.f', data : param };
		SysTool.ajax(HTTPREQPARAM, function(data) {
			if (data.status > 0) {
				Jqcz.jqczSMSSend(bjr, bjr, bjrdh, 'jqcz_cz_myddc');
			}
		});
	},
	/**
	 * 警情协商处置
	 */
	jqczYxsWdd : function(){
		var xcjt = $("input[name='jqczXcjt']:checked").val();
		var czfk = $('#jqcz_dd_bz').val();
		var bcsm = '';
		if (typeof (xcjt) == 'undefined') { SysTool.tooltips('jqcz_czz_jtzt', '请选择现场交通状况！'); return; }
		if (czfk == '') { SysTool.tooltips('jqcz_dd_bz', '补充说明不能为空！'); return; } else { var maxLen = SysTool.validator.maxLength('jqcz_dd_bz', Jqcz.MAXLEN.JQJHNR); if (maxLen) { return; } }
		// 完成警情处置
		Jqcz.jqczWccz(xcjt, bcsm, czfk, false);
	},
	
	/**
	 * 确认完成
	 */
	jqczQrwc : function() {
		var xcjt = $("input[name='czzXcjt']:checked").val();
		var bcsm = SysTool.getTxtVal('jqcz_cz_bcsm');
		var czfk = SysTool.getTxtVal('jqcz_cz_czfk');
		if (typeof (xcjt) == 'undefined') {
			SysTool.tooltips('jqcz_czz_jtzt', '请选择现场交通状况！');
			return;
		}
		if (czfk == '') {
			SysTool.tooltips('jqcz_cz_czfk', '处置反馈不能为空！');
			return;
		} else {
			var maxLen = SysTool.validator.maxLength('jqcz_cz_czfk', Jqcz.MAXLEN.JQJHNR);
			if (maxLen) { return; }
		}
		if (bcsm != '') {
			var maxLen = SysTool.validator.maxLength('jqcz_cz_bcsm', Jqcz.MAXLEN.JQBCNR);
			if (maxLen) { return; }
		}
		// 完成警情处置
		Jqcz.jqczWccz(xcjt, bcsm, czfk, true);
	},
	/**
	 * 警情处置完成
	 * @param xcjt 现场交通
	 * @param bcsm 补充说明
	 * @param czfk 处置反馈
	 */
	jqczWccz : function(xcjt, bcsm, czfk, isCzfk){
		var jqbh = Jqcz.getJqbh();
		// 重大警情验证(验证通过，上报未上报所有之后下次继续上报未开发完成)
		var jqlxdm = Jqcz.JQXXDATA['jqlxdm'];
		var jqlx = (jqlxdm.split(','))[1];
		if (parseInt(jqlx) == 1) {
			Jqcz.zdjqczSbjlCheck(Jqcz.JQXXDATA.jqbh, function(dt){
				if (dt.status > 0) {
					SysTool.alert('重大警情未上报完成不能完成处置！');
					return;
				} else { confirmJqczwc(); }
			});
		} else { confirmJqczwc(); }

		function confirmJqczwc() {
			var msg = '确认警情已处置完成吗？';
			SysTool.confirm(msg, function(r) {
				if (r) {
					Jqcz.getJqjhsjXxByJhsjcm(Jqcz.JQCZCLSJ.JQPJ[0][0], function(jhsj){
						if(!$.isEmptyObject(jhsj)){
							if(jhsj.sfyx == 0){ 
								Jqcz.getJqjhsjXxByJhsjcm(Jqcz.JQCZCLSJ.JQPJ[2][0], function(jhsj){ jqxyrzb(jhsj); });
							}else{ jqxyrzb(jhsj); }
						}
					});
				}
			});
		}
		
		function jqxyrzb (jhsj){
			if($(jhsj).size()){
				Jqcz.getJyzbBysbbh(jhsj['sjxyrsbbh'], function(zb){
					if($(zb).size() > 0){ Jqcz.CURRENTJYZB[zb.x, zb.y]; }
				});
				jqqrwc(jhsj);
			}
		}

		function jqqrwc(jhsj) {
			var nextJqzt = 5;
			var czfksj = Jqcz.JQCZCLSJ.CZFK;
			if(!isCzfk){
				czfksj = Jqcz.JQCZCLSJ.XSWD;
			}
			
			var sjfqrmc = jhsj['sjxyrmc'];
			var param = {
				// 交互事件
				'jqbh' : jqbh,
				'jqzt' : nextJqzt,
				'jqcljhsjcm' : czfksj[0],
				'jqcljhsjct' : czfksj[1],
				'jqcljhtjcm' : jhsj['jqcljhtjcm'],
				'jqcljhtjct' : jhsj['jqcljhtjct'],
				'sjfqrdm' : jhsj['sjxyrdm'],
				'sjfqrmc' : sjfqrmc,
				'sjfqrdh' : jhsj['sjxyrdh'],
				'sjfqrx' : Jqcz.CURRENTJYZB[0],
				'sjfqry' : Jqcz.CURRENTJYZB[1],
				// 交通状态
				'czfkrbh' : jhsj['sjxyrdm'],
				'czfkrmc' : sjfqrmc,
				'czfkzt' : xcjt,
				// 警情补充信息
				'jqxxbc' : bcsm,
				// 交互事件信息
				'jhhm' : jhsj['sjxyrdh'],
				'jhnr' : czfk
			};
			HTTPREQPARAM = {url : 'jqcz/qrwc.f', data : param};
			SysTool.ajax(HTTPREQPARAM, function(data) {
				if (data.status > 0) {
					var msg = '确认完成警情处置！';
					SysTool.show(msg);
					Jqcz.updateJqxxIcon(nextJqzt);
					// 添加事件记录
					msg = sjfqrmc + '向' + Jqcz.getCurrentLoginUser().userName + '反馈警情已处置完成，' + czfksj[1] + '：' + czfk;
					var sjpm = {'cm' : param['jqcljhsjcm'], 'ct' : param['jqcljhsjct'], 'ms' : msg};
					Jqcz.jqczsjjl(sjpm);
				}
			});
		}
	},
	
	/**
	 * 确认事后报警
	 */
	jqczQrsh : function() {
		// 警员编号结构为[jybh,jysfz,jydh,sbbh]
		var xqczdm = SysTool.getTxtVal('jqcz_sh_xqjydm');
		var xqjyArry = xqczdm.split(',');
		var xqczmc = SysTool.getTxtVal('jqcz_sh_xqjymc');
		var cjmjdm = SysTool.getTxtVal('jqcz_sh_jjmjdm');
		var cjmjArry = cjmjdm.split(',');
		var cjmjmc = SysTool.getTxtVal('jqcz_sh_jjmjmc');

		var valid = SysTool.validator.isBlank([ {
			id : 'jqcz_sh_ssdddm',
			msg : '请选择派警警员所属大队！',
			sId : 'jqcz_sh_ssddmc'
		}, {
			id : 'jqcz_sh_sszddm',
			msg : '请选择派警警员所属中队！',
			sId : 'jqcz_sh_sszdmc'
		}, {
			id : 'jqcz_sh_jjmjdm',
			msg : '请选择派警警员！',
			sId : 'jqcz_sh_jjmjmc'
		} ]);
		if (valid) {return;}

		var xcjt = $("input[name='shbjXcjt']:checked").val();
		var bcsm = SysTool.getTxtVal('jqcz_sh_bz');
		var czfk = SysTool.getTxtVal('jqcz_sh_czfk');
		if (typeof (xcjt) == 'undefined') {
			SysTool.tooltips('jqcz_sh_jtzt', '请选择现场交通状况！');
			return;
		}
		if (czfk == '') {
			SysTool.tooltips('jqcz_sh_czfk', '处置反馈内不能为空！');
			return;
		} else {
			var maxLen = SysTool.validator.maxLength('jqcz_sh_czfk',Jqcz.MAXLEN.JQJHNR);
			if (maxLen) {return;}
		}
		if (bcsm != '') {
			var maxLen = SysTool.validator.maxLength('jqcz_sh_bz',Jqcz.MAXLEN.JQBCNR);
			if (maxLen) {return;}
		}
		var jqbh = Jqcz.getJqbh();
		var nextJqzt = 5;
		var sjfqsj = SysTool.getTxtVal('jqcz_sh_cjsj');
		var valid = SysTool.validator.isEmpty('jqcz_sh_cjsj', '出警时间不能为空！');
		if (valid) {return;}
		var param = {
			// 派警信息
			'jqbh' : jqbh,
			'jqcljhsjcm' : Jqcz.JQCZCLSJ.JQPJ[0][0],
			'jqcljhsjct' : Jqcz.JQCZCLSJ.JQPJ[0][1],
			'jqzt' : nextJqzt,
			'jqcljhtjcm' : 'JHTJ002',
			'jqcljhtjct' : '对讲机',
			'sjfqrdm' : SysTool.getTxtVal('jqcz_jjrbh'),
			'sjfqrmc' : SysTool.getTxtVal('jqcz_jjrxm'),
			'sjfqrdh' : '',
			'sjxyrdm' : cjmjArry[0],
			'sjxyrmc' : cjmjmc,
			'sjxyrdh' : cjmjArry[2],
			'sjxyrsbbh' : cjmjArry[3],
			'sjxyrhh' : cjmjArry[3],
			'shbjsj' : sjfqsj,
			'sjxyxqrdm' : xqjyArry[0],
			'sjxyxqrmc' : xqczmc,
			'sjxyxqrdh' : xqjyArry[2],
			'sjxyxqrsbbh' : xqjyArry[3],
			'sjxyxqrhh' : xqjyArry[3],
			'jhhm' : cjmjArry[2],
			'jhnr' : czfk,
			// 交通状态
			'czfkrbh' : cjmjArry[0],
			'czfkrmc' : cjmjmc,
			'czfkzt' : xcjt,
			// 警情补充信息
			'jqxxbc' : bcsm
		};
		// alert('事后报警请求参数：' + JSON.stringify(param));
		HTTPREQPARAM = {
			url : 'jqcz/shbj.f',
			data : param
		};
		SysTool.confirm('确认将警情处置为事后报警吗？', function(r) {
			if (r) {
				SysTool.ajax(HTTPREQPARAM, function(data) {
					if (data.status > 0) {
						var msg = '事后报警警情处置完成！';
						SysTool.show(msg);
						// 更改地图进警情ICON
						Jqcz.updateJqxxIcon(nextJqzt);
						// 添加事件记录
						var shbj = Jqcz.JQCZCLSJ.SHBJ;
						param = {'cm' : shbj[0],'ct' : shbj[1],'ms' : Jqcz.getCurrentLoginUser().userName + '将警情处置为事后报警'};
						Jqcz.jqczsjjl(param);
					}
				});
			}
		});
	},
	/**
	 * 警情移交
	 */
	jqczJqyj : function() {
		var yjdm = SysTool.getTxtVal('jqcz_yj_yjdwdm');
		var yjdw = SysTool.getTxtVal('jqcz_yj_yjdwmc');
		var yjyy = SysTool.getTxtVal('jqcz_yj_yjyymc');

		var blank = SysTool.validator.isBlank([ {
			id : 'jqcz_yj_yjdwdm',
			msg : '移交单位不能为空！',
			sId : 'jqcz_yj_yjdwmc'
		}, {
			id : 'jqcz_yj_yjyymc',
			msg : '移交原因不能为空！'
		} ]);
		if (blank) {return;}
		if (Jqcz.JQXXDATA.jqssdddm == yjdw) {
			SysTool.alert('移交单位与警情现属单位一致无需移交！');
			return;
		}
		if (yjyy != '') {
			var maxLen = SysTool.validator.maxLength('jqcz_yj_yjyymc',Jqcz.MAXLEN.JQJHNR);
			if (maxLen) {return;}
		}
		var jqbh = Jqcz.getJqbh();
		var nextJqzt = 5;
		var param = {
			'jqbh' : jqbh,
			'jqzt' : nextJqzt,
			'nr' : yjyy,
			'ssjgdm' : yjdm,
			'ssjgmc' : yjdw
		};
		HTTPREQPARAM = { url : 'jqcz/fcjljq.f', data : param };
		var msg = '确认将警情移交至' + yjdw + '吗？';
		SysTool.confirm(msg, function(r) {
			if (r) {
				SysTool.ajax(HTTPREQPARAM, function(data) {
					if (data.status > 0) {
						SysTool.show('警情已移交到' + yjdw + '！');
						MapBubble.closeBubble();
						Jqcz.updateJqxxIcon(nextJqzt);
						var jqyj = Jqcz.JQCZCLSJ.JQYJ;
						param = {'cm' : jqyj[0],'ct' : jqyj[1],'ms' : Jqcz.getCurrentLoginUser().userName + '将警情移交给' + yjdw};
						Jqcz.jqczsjjl(param);
					}
				});
			}
		});
	},
	/**
	 * 警情督办
	 */
	jqczJqdb : function() {
		var jqdb = Jqcz.JQCZCLSJ.JQDB;
		var cjry = $('#jqcz_jqdb_jyxm').text();
		if (cjry == '') {
			SysTool.alert('警员信息读取失败，无法对该警情进行督办！');
			return;
		}

		var msg = '确认督办警情吗？';
		SysTool.confirm(msg, function(r) {
			if (r) {
				var dbxx = SysTool.getTxtVal('jqcz_pj_xxnr_db');
				msg = Jqcz.getCurrentLoginUser().userName + '向' + cjry + '发送督办信息：' + dbxx;
				var param = { 'cm' : jqdb[0], 'ct' : jqdb[1], 'ms' : jqdb[1] + '：警情已督办，督办信息：' + dbxx};
				Jqcz.jqczsjjl(param, function(data) {
					SysTool.show('完成警情督办！');
					MapBubble.closeBubble();
				});
			}
		});
	},
	/**
	 * 警情投诉
	 */
	jqczJqts : function() {
		var tsdwdm = SysTool.getTxtVal('jqcz_ts_tsdwdm');
		var tsdwmc = SysTool.getTxtVal('jqcz_ts_tsdwmc');
		var tsrydm = SysTool.getTxtVal('jqcz_ts_tsrydm');
		var tsrymc = SysTool.getTxtVal('jqcz_ts_tsrymc');
		var tsnr = SysTool.getTxtVal('jqcz_ts_tsnr');

		var empty = SysTool.validator.isBlank([ {
			id : 'jqcz_ts_tsdwdm',
			msg : '投诉单位不能为空！',
			sId : 'jqcz_ts_tsdwmc'
		}, {
			id : 'jqcz_ts_tsrydm',
			msg : '投诉人员不能为空！',
			sId : 'jqcz_ts_tsrymc'
		}, {
			id : 'jqcz_ts_tsnr',
			msg : '投诉内容不能为空！'
		}]);
		if (empty) {return;}

		if (tsnr != '') {
			vail = SysTool.validator.maxLength('jqcz_ts_tsnr',Jqcz.MAXLEN.JQJHNR);
			if (vail) {return;}
		}

		var jqbh = Jqcz.getJqbh();
		var nextJqzt = 5;
		tsrydm = (tsrydm.split(','))[0];
		var param = {
			'jqbh' : jqbh,
			'jqzt' : nextJqzt,
			'nr' : tsnr,
			'ssjgdm' : tsdwdm,
			'ssjgmc' : tsdwmc,
			'ryid' : tsrydm,
			'rym' : tsrymc
		};
		HTTPREQPARAM = {
			url : 'jqcz/fcjljq.f',
			data : param
		};
		var msg = '确认完成警情处置吗？';
		SysTool.confirm(msg, function(r) {
			if (r) {
				SysTool.ajax(HTTPREQPARAM, function(data) {
					if (data.status > 0) {
						SysTool.show('完成警情处置！');
						Jqcz.updateJqxxIcon(nextJqzt);
						var jqtssj = Jqcz.JQCZCLSJ.JQTS;
						param = {'cm' : jqtssj[0], 'ct' : jqtssj[1], 'ms' : '投诉' + tsdwmc + '' + tsrymc + '警员,' + tsnr};
						Jqcz.jqczsjjl(param);
					}
				});
			}
		});
	},
	/**
	 * 警情记录
	 */
	jqczJqjl : function() {
		var jlnr = SysTool.getTxtVal('jqcz_jl_jlnr');
		var jltab = $('#jqcz_jqjltab').text();
		var vail = SysTool.validator.isEmpty('jqcz_jl_jlnr', jltab + '处置内容不能为空！');
		if (vail) { 
			return;
		} else {
			vail = SysTool.validator.maxLength('jqcz_jl_jlnr', Jqcz.MAXLEN.JQJHNR);
			if (vail) { return; }
		}

		var jqlxdm = SysTool.getTxtVal('jqcz_jqlxdm');
		var jqlx = jqlxdm.split(',');
		var lxtype = jqlx[1];
		var lxdm = jqlx[0];
		var jqlxmc = SysTool.getTxtVal('jqcz_jqlxmc');
		var jqbh = Jqcz.getJqbh();
		var nextJqzt = 5;
		var param = { 'jqbh' : jqbh, 'jqzt' : nextJqzt, 'nr' : jlnr };

		SysTool.confirm('确认完成警情处置吗？', function(r) {
			HTTPREQPARAM = { url : 'jqcz/fcjljq.f', data : param };
			SysTool.ajax(HTTPREQPARAM, function(data) {
				if (data.status > 0) {
					SysTool.show('处置' + jltab + '完成！');
					Jqcz.updateJqxxIcon(nextJqzt);
					param = { 'cm' : lxdm, 'ct' : jqlxmc, 'ms' : Jqcz.getCurrentLoginUser().userName + '处置' + jltab + '已完成，处置结果：' + jlnr};
					// 操作日志记录
					Jqcz.jqczsjjl(param);
					// 无效警情处理
					if (lxdm == 4) {
						if ('jqlb003' == lxtype) {
							// Jqcz.jqczShwx(jqbh, false);
						} else if ('jqlb010' == lxtype) {
							Jqcz.jqczShwx(jqbh, true);
						}
					}
				}
			});
		});
	},
	/**
	 * 警情变更记录
	 * @param param 变更参数
	 */
	jqczJqbgjl : function(param, bgmc) {
		param['jqbh'] = Jqcz.JQXXDATA['jqbh'];
		HTTPREQPARAM = { url : 'zdjq/jqbgjl.f', data : param };
		SysTool.ajax(HTTPREQPARAM, function(data) {
			if (data.status > 0) {
				SysTool.show('成功将警情类型变更为' + bgmc + '！');
			}
		});
	},

	/**
	 * 警情处置事后报警、无效警情
	 * @param jqbh   警情编号
	 * @param isWxjq 是否事后
	 */
	jqczShwx : function(jqbh, isWxjq) {
		var param = { 'jqbh' : jqbh, 'jqzt' : 5 };
		var url = 'jqcz/wxjq.f';
		if (!isWxjq) {
			url = 'jqcz/shbj.f';
		}
		HTTPREQPARAM = {
			url : url,
			data : param
		};
		SysTool.ajax(HTTPREQPARAM, function(data) {
			if (data.status > 0) {
			}
		});
	},
	/**
	 * 二级处警
	 */
	jqczEjcj : function() {
		var ejdm = SysTool.getTxtVal('jqcz_ej_bgdddm');
		var ejdw = SysTool.getTxtVal('jqcz_ej_bgddmc');
		var ejyy = SysTool.getTxtVal('jqcz_ej_bgmc');

		var blank = SysTool.validator.isBlank([ {
			id : 'jqcz_ej_bgdddm',
			msg : '单位不能为空！',
			sId : 'jqcz_ej_bgddmc'
		}, {
			id : 'jqcz_ej_bgmc',
			msg : '原因位不能为空！'
		}]);
		if (blank) {return;}
		if (Jqcz.JQXXDATA.jqssdddm == ejdm) {
			SysTool.alert('单位与警情现属单位一致无需发送！');
			return;
		}
		if (ejyy != '') {
			var maxLen = SysTool.validator.maxLength('jqcz_ej_bgmc', Jqcz.MAXLEN.JQJHNR);
			if (maxLen) { return; }
		}
		var jqbh = Jqcz.getJqbh();
		var nextJqzt = Jqcz.JQXXDATA.jqzt;
		var ysdwdm = Jqcz.JQXXDATA.jqssdddm;
		var pm = { 'jqbh' : jqbh, 'jqzt' : nextJqzt, 'ysdwdm' : ysdwdm, 'ssbgyy' : ejyy, 'xsdwdm' : ejdm, 'xsdwdc' : ejdw };
		HTTPREQPARAM = { url : 'jqcz/ejcj.f', data : pm };
		var msg = '确认将警情发送给' + ejdw + '吗？';
		SysTool.confirm(msg, function(r) {
			if (r) {
				SysTool.ajax(HTTPREQPARAM, function(data) {
					if (data.status > 0) {
						SysTool.show('警情已发送到' + ejdw + '！');
						MapBubble.closeBubble();
						var ejcj = Jqcz.JQCZCLSJ.EJCJ;
						pm = { 'cm' : ejcj[0], 'ct' : ejcj[1], 'ms' : Jqcz.getCurrentLoginUser().userName + '将警情发送给' + ejdw};
						Jqcz.jqczsjjl(pm);
						Jqcz.updateJqxxIcon(nextJqzt);
					}
				});
			}
		});
	},
	/**
	 * 二级处警警情接收确认
	 */
	ejjqConfirm:function(){
		var jqbh=Jqcz.getJqbh();
		var nextJqzt = Jqcz.JQXXDATA.jqzt;
		SysTool.confirm('确认要接收警情吗？', function(r){
			if(r){
				var param={'jqbh':jqbh,'jqzt':nextJqzt};
				HTTPREQPARAM = { url : 'jqcz/cmejcj.f', data : param };
				SysTool.ajax(HTTPREQPARAM, function(data) {
					if (data.status > 0) {
						var xx = '成功接收警情！';
						if(typeof(msg) !== 'undefined'){
							xx = msg;
						}
						SysTool.show(xx);
						Jqcz.setTabShowFunc(["ejqr"], false);
						if(nextJqzt=="1"){
							Jqcz.setTabShowFunc([ 'jqdw', 'jqyj'], true);
						}else if(nextJqzt=="2"){
							Jqcz.setTabShowFunc([ 'jqdw', 'jqzp','jqyj'], true);
							
						}
						Jqcz.initEjcjData();
					}
				});
			}
		});
	},
	/**
	 * 二级处警警情退回
	 */
	ejjqBack:function(){
		var vail = SysTool.validator.isEmpty("jqcz_ejqr_thyy", '退回原因不能为空');
		if (vail) { 
			return; 
		}else{
			var vail1 = SysTool.validator.maxLength("jqcz_ejqr_thyy", 200);
			if (vail1) {  return; }
		}
		
		SysTool.confirm('确认要退回警情吗？', function(r){
			if(r){				
				var thyy=$("#jqcz_ejqr_thyy").val();
				var jqbh=Jqcz.getJqbh();
				var param={'jqbh':jqbh,"thyy":thyy};
				HTTPREQPARAM = { url : 'jqcz/bkejcj.f', data : param };
				SysTool.ajax(HTTPREQPARAM, function(data) {
					if (data.status > 0) {
						var xx = '成功退回警情！';
						if(typeof(msg) !== 'undefined'){
							xx = msg;
						}
						SysTool.show(xx);
						_MapApp.removeOverlay(MapBubble.currMarker);
						MapBubble.closeBubble();
					}
				});
			}
		});
	},
	/**
	 * 删除二级警情
	 */
	ejjqDelete:function(){
		var jqbh=Jqcz.getJqbh();
		var param={'jqbh':jqbh};
		HTTPREQPARAM = { url : 'jqcz/dlejcj.f', data : param };
		SysTool.ajax(HTTPREQPARAM, function(data) {
			
		});
	},
	/**
	 * 
	 * 警情处置短信发送
	 * @param jsrid 接收人ID
	 * @param jsrm 接收人名
	 * @param jshm 接收人号码
	 */
	jqczSMSSend : function(jsrid, jsrm, jshm, nrId, msg) {
		var nr = SysTool.getTxtVal(nrId);
		var vail = SysTool.validator.isEmpty(nrId, '短信内容不能为空');
		if (vail) { return; }
		var param = { 'jqbh' : Jqcz.getJqbh(), 'xxnr' : nr, 'xxlx' : 1, 'jsrid' : jsrid, 'jsrm' : jsrm, 'jshm' : jshm};
		//alert('msgSend: ' + JSON.stringify(param));
		HTTPREQPARAM = { url : 'jqcz/msgSend.f', data : param };
		SysTool.ajax(HTTPREQPARAM, function(data) {
			if (data.status > 0) {
				var xx = '成功发送短信！';
				if(typeof(msg) !== 'undefined'){
					xx = msg;
				}
				SysTool.show(xx);
			}
		});
	},
	/**
	 * 科技设备信息发送
	 * @param id     获取内容Id
	 * @param marker 组件标记
	 */
	jqczKjsbSMSSend : function(id, marker) {
		var jyxx = SysTool.getTxtVal(id);
		var pjlx = $("input[name='jqczPjlx']:checked").val();
		if(typeof(pjlx) === 'undefined'){ pjlx = 0; }
		/**
		 * 短信发送(0 首次派警、1 警员增援、2 警员改派)：
		 * 1、派警：只发送信息给当前派警民警；
		 * 2、增援：首先发送给增援民警信息，再发给当前已经民警信息；
		 * 3、改派：首先先通知已派警员，再发送信息通知改派民警；
		 */
		var xxId = 'jqcz_pj_xxnr_' + marker;
		var msg = SysTool.getTxtVal(xxId);
		var xxnr = msg;
		var jsrid, jsrm, jshm;
		if(jyxx != ''){	
			jyxx = jyxx.split(',');
			if(pjlx == 0){
				//jsrid = jyxx[0], jsrm = jyxx[4], jshm = jyxx[3];
				jsrid = jyxx[0], jsrm = jyxx[4], jshm = jyxx[2];// 发短信
				//alert("派警:jsrid="+jsrid+",jsrm="+jsrm+",jshm="+jshm);
				Jqcz.jqczSMSSend(jsrid, jsrm, jshm, xxId);
			}else if(pjlx == 1){
				pjSmsSend(0);
			}else{
				pjSmsSend(1);
			}
			SysTool.setTxtVal(xxId , msg);
		}
		function pjSmsSend(lx){
			var jhsjcm = Jqcz.JQCZCLSJ.JQPJ[0][0];
			Jqcz.getJqjhsjXxByJhsjcm(jhsjcm, function(jhsj){
				if($(jhsj).size() > 0){					
					var jybh = jhsj['sjxyrdm'];
					var jymc = jhsj['sjxyrmc'];
					var jydh = jhsj['sjxyrdh'];
					// 给改派警员发送信息
					//jsrid = jyxx[0], jsrm = jyxx[4], jshm = jyxx[3];
					jsrid = jyxx[0], jsrm = jyxx[4], jshm = jyxx[2];// 发短信
					//alert("改派:jsrid="+jsrid+",jsrm="+jsrm+",jshm="+jshm);
					xxnr = xxnr + '(已派警员：' + jymc + '，电话：' + jydh + ')';
					SysTool.setTxtVal(xxId , xxnr);
					Jqcz.jqczSMSSend(jsrid, jsrm, jshm, xxId);
					var afdd = Jqcz.JQXXDATA['jqafdd'];
					// 给已派民警发送信息
					if(lx == 0){
						xxnr = jymc + '同志，发生在' + afdd + '的警情已增派警员' + jsrm + '(电话：' + jshm + ')，请知悉。';
					}else{
						xxnr = jymc + '同志，发生在' + afdd + '的警情已改派给警员' + jsrm + '(电话：' + jshm + ')，请知悉。';
					}
					SysTool.setTxtVal(xxId , xxnr);
					Jqcz.jqczSMSSend(jybh, jymc, jydh, xxId);
					SysTool.setTxtVal(xxId , msg);
				}
			});
		}
	},
	/**
	 * 警情督办信息发送
	 * @param id     督办人员信息
	 * @param marker 督办标记
	 */
	jqczJqdbSMSSend : function(id, marker){
		var jyxx = SysTool.getTxtVal(id);
		//alert(jyxx);
		var xxId = 'jqcz_pj_xxnr_' + marker;
		var jsrid, jsrm, jshm;
		if(jyxx != ''){	
			var vail = SysTool.validator.isEmpty(xxId, '督办信息不能为空', xxId);
			if(vail){return;}
			jyxx = jyxx.split(',');
			//jsrid = jyxx[0], jsrm = jyxx[4], jshm = jyxx[3];
			jsrid = jyxx[0], jsrm = jyxx[4], jshm = jyxx[2];// 发短信
			//alert("督办:jsrid="+jsrid+",jsrm="+jsrm+",jshm="+jshm);
			Jqcz.jqczSMSSend(jsrid, jsrm, jshm, xxId);
		}
	},
	
	/**
	 * 语言呼叫
	 * @param id 获取组件id
	 */
	jqczVoiceCall : function(id) {
		SysTool.show('暂不支持语音呼叫！');
	},
	/**
	 * 警情事件记录
	 * @param param 数据参数
	 * @param callback  回调方法
	 */
	jqczsjjl : function(param, callback) {
		var jqbh = Jqcz.JQXXDATA['jqbh'];
		var pm = {
			'jqbh' : jqbh,
			'jqclsjcm' : param.cm,
			'jqclsjct' : param.ct,
			'czlx' : Jqcz.JQCZCZLX.UPDATE,
			'czms' : param.ms
		};
		HTTPREQPARAM = { url : 'jqcz/jqsjjl.f', data : pm };
		SysTool.ajax(HTTPREQPARAM, function(data) {
			if (data.status > 0) {
				if ($.isFunction(callback)) {
					callback(data);
				}
			}
		});
	},
	/**
	 * 警情周边查询
	 */
	jqczJqzb : function() {
		MapBubble.hideBubble();
		var param = {
			id : 'jcxx',
			url : 'common/components/resource/jcxx.jsp',
			data : null
		};
		Resource.fireClickFunc(param['id'], param['url'], param['data']);
		LeftLayout.hideLefLayout();
	},
	/**
	 * 警情回放
	 */
	jqczJqhfEvent : function(){
		Jqcz.jqczJqhf(Jqcz.JQXXDATA.jqbh, Jqcz.JQXXDATA.jqafdd);
	},
	
	/**
	 * 警情回放
	 */
	jqczJqhf : function(jqbh, afdd) {
		LeftLayout.showLefLayout();
		$("#jqsjcontent").html("");
		$("#jqhf_title").text(jqbh);
		$("#jqhf_title").attr({'title': jqbh, 'onclick': 'jqxxToMap();', 'style': 'cursor:hand;'});
		SysTool.ajax({ url : 'jqsjhf/getJqsjhf.f', data : { 'jqbh' : jqbh }}, function(data) {
			$("#contentDivId").hide();
			var content = "";
			content += "<div class='timelinebody'><div class='timeliall'>";
			var tm = new Array();
			var tmTmp = '' , cm = '', jhsjid = '', jhcm = 'JHSJ';
			for ( var i = 0; i < data.length; i++) {
				var czsj = SysTool.getDateTimeFormat(data[i]["czsj"]);
				tm = czsj.split(' ');
				czsj = tm[1];
				if(tmTmp != tm[0]){
					tmTmp = tm[0];
					content += "<div class='timeyear' style='margin-bottom: -11px; margin-top:0px;'>" + tmTmp + "</div>";
				}
				var objid = "onejqsj_" + i;
				var czms = data[i]["czms"];
				content += "<div class='timelicont'><span class='timedate'>" + czsj + "</span><span class='timeicon'></span>";
				content += "<div class='timelidiv' id='" + objid + "'><div class='timesjx'></div><a class='timetitle'>"	+ data[i]["jqclsjct"] + "</a>";
				content += "<div class='jqsjmsinfo'><div><span>" + czms + "</span></div><div style='clear:both'>";
				jhsjid = data[i]['jqclsjid'];
				cm = (data[i]["jqclsjcm"]).toUpperCase();
				/**
				 * 根据词码判断展示派警及现场感知
				 * 1、获取事件记录词码：
				 * 1.1、派警、增派、改派只展示短信
				 * 1.2、到达现场可展示图片、语音、视频
				 * 1.3、处置过程可展示图片、语音、视频
				 */	
				if((cm != 'JHSJ001' && cm.substring(0, 4) == jhcm) || cm == 'CZSJ015'){
					if(cm == 'JHSJ002' || cm == 'JHSJ006' || cm == 'JHSJ007' || cm == 'JHSJ008'){
						content += "<div class='jqhf_btndiv' onclick='Jqcz.jqczXcgz(3, \"dx\", \"" + data[i]['jqclsjid'] + "\", this);'><a class='icon_btn_file' title='信息'></a><span>：</span><input type='hidden' id='" + jhsjid + "_dx_val' /><span id='" + jhsjid + "_dx'>0</span></div>";
					}
					if(cm == 'JHSJ004' || cm == 'JHSJ005'){
						if(cm == 'JHSJ005'){
							content += "<div class='jqhf_btndiv' onclick='Jqcz.jqczXcgz(4, \"cz\", \"" + data[i]['jqclsjid'] + "\", this);'><a class='icon_btn_file' title='信息'></a><span>：</span><input type='hidden' id='" + jhsjid + "_cz_val' /><span id='" + jhsjid + "_cz'>0</span></div>";
						}else{
							content += "<div class='jqhf_btndiv' onclick='Jqcz.jqczXcgz(4, \"dd\", \"" + data[i]['jqclsjid'] + "\", this);'><a class='icon_btn_file' title='信息'></a><span>：</span><input type='hidden' id='" + jhsjid + "_dd_val' /><span id='" + jhsjid + "_dd'>0</span></div>";
						}
					}
					content += "<div class='jqhf_btndiv' onclick='Jqcz.jqczXcgz(0, \"tp\", \"" + data[i]['jqclsjid'] + "\", this);'><a class='icon_btn_img' title='图片'></a><span>：</span><input type='hidden' id='" + jhsjid + "_tp_val' /><span id='" + jhsjid + "_tp'>0</span></div>";
					content += "<div class='jqhf_btndiv' onclick='Jqcz.jqczXcgz(1, \"yy\", \"" + data[i]['jqclsjid'] + "\", this);'><a class='icon_btn_voice' title='语音'></a><span>：</span><input type='hidden' id='" + jhsjid + "_yy_val' /><span id='" + jhsjid + "_yy'>0</span></div>";
					content += "<div class='jqhf_btndiv' onclick='Jqcz.jqczXcgz(2, \"sp\", \"" + data[i]['jqclsjid'] + "\", this);'><a class='icon_btn_video' title='视频'></a><span>：</span><input type='hidden' id='" + jhsjid + "_sp_val' /><span id='" + jhsjid + "_sp'>0</span></div>";
				}
				content += "</div></div>";
				content += "<div class='timeinfobg'></div>";
				content += "</div></div>";
			}
			content += "</div></div>";
			$("#jqsjcontent").html(content);// 添加事件回放内容
			$("#jqsjDiv").show();
			ScrollBarTool.init("scroll_main_jqlb", "scroll_content_jqlb", 84); // 加载滚动条
			// 进行短信、附件信息赋值
			for ( var i = 0; i < data.length; i++) {
				jhsjid = data[i]['jqclsjid'];
				cm = (data[i]["jqclsjcm"]).toUpperCase();
				(function(i){					
					if(cm == 'JHSJ002' || cm == 'JHSJ006' || cm == 'JHSJ007' || cm == 'JHSJ008'){
						loadHfInfo(cm, data[i]['jqbh'], jhsjid, 0);
					}
					if(cm == 'JHSJ004' || cm == 'JHSJ005'){
						loadHfInfo(cm, data[i]['jqbh'], jhsjid, 1);
					}
					loadHfInfo(cm, data[i]['jqbh'], jhsjid, 2);
				})(i);
			}
		});
		function jqxxToMap(){
			var jqzt = Jqcz.JQXXDATA.jqzt;
			if(jqzt > 1 && jqzt < 5){
				Jqxx.loadJqxxToMap({}, Jqcz.JQXXDATA, function(){});
			}
		}
		function loadHfInfo(cm, jqbh, jhsjid, isDx){
			if(isDx == 0){
				// 短信
				HTTPREQPARAM = { url : 'jqcz/getMsgInfo.f', data : {'jqbh' :jqbh, 'jqsjid': jhsjid, 'fsrm' : cm}};
				SysTool.ajax(HTTPREQPARAM, function(hf) {
					if(!$.isEmptyObject(hf)){
						$('#' + jhsjid + '_dx').text(hf.size);
						$('#' + jhsjid + '_dx_val').val(hf.content);
					}
				});
			}else if(isDx == 1){
				// 初始化警情处置反馈
				HTTPREQPARAM = { url : 'jqcz/getJhsjxx.f', data : {'jqbh' : jqbh, 'jhcm': cm}};
				SysTool.ajax(HTTPREQPARAM, function(hf) {
					if(!$.isEmptyObject(hf)){
						$('#' + jhsjid + '_cz').text(hf.size);
						$('#' + jhsjid + '_cz_val').val(hf.content);
					}
				});
			}else{
				// 加载现场感知
				Jqcz.initJqczXcgz({id: jhsjid, jqbh: jqbh, jhcm: cm}, function(){});
			}
		}
	},
	/**
	 * 警情事件描述
	 * @param cm 事件词码
	 * @param jqbh 警情编号
	 */
	jqsjms : function(czms, that) {
		//$(".jqsjmsinfo").remove();
		var str="<div class='jqsjmsinfo' style='display:none'>" +
				"<div><span>"+czms+"</span></div>";
		$("#"+that).parent().append(str);
		$('.jqsjmsinfo').show();
//		SysTool.ajax({//【请勿删除】
//			url : 'jqsjhf/getJqsjms.f',
//			data : {
//				'jqbh' : jqbh,
//				"jqclsjcm" : cm
//			}
//		}, function(data) {
//			var str = "<div class='jqsjmsinfo' style='display:none'>"
//					+ "<div><span class='spanbt'>发起人姓名：</span><span>"
//					+ (data["sjfqrxm"] || "空") + "</span><div>"
//					+ "<div><span class='spanbt'>发起人电话：</span><span>"
//					+ (data["sjfqrdh"] || "空") + "</span><div>"
//					+ "<div><span class='spanbt'>响应人姓名：</span><span>"
//					+ (data["sjxyrxm"] || "空") + "</span><div>"
//					+ "<div><span class='spanbt'>响应人电话：</span><span>"
//					+ (data["sjxyrdh"] || "空") + "</span><div>"
//					+ "<div><span class='spanbt'>交互途径：</span><span>"
//					+ (data["jqcljhcjct"] || "空") + "</span><div>"
//					+ "<div><span class='spanbt'>响应人设备编号：</span><span>"
//					+ (data["sjxyrsbbh"] || "空") + "</span><div>"
//					+ "<div><span class='spanbt'>响应人呼号：</span><span>"
//					+ (data["sjxyrhh"] || "空") + "</span></div>" + "</div>";
//			$("#"+that).parent().append(str);
//			$('.jqsjmsinfo').slideDown();
//		});
	},
	backTo : function() {
		$("#jqsjcontent").html("");
		$("#jqsjDiv").hide();
		$("#contentDivId").show();
		ScrollBarTool.init("scroll_main_jqlb", "scroll_content_jqlb", 84); // 加载滚动条
	},
	/**
	 * 现场感知查看
	 * @param type    查看类型
	 * @param marker  标记
	 */
	jqczXcgz : function(type, marker, id, elem){
		var elemId = 'jqcz_xcgz_' + marker;
		if(typeof(id) !== 'undefined'){
			elemId = id + '_' + marker;
		}
		var count = $('#' + elemId).text();
		if(count > 0){
			var gznr = SysTool.getTxtVal(elemId + '_val');
			if(type == 0){
				var title = $(elem).find('a').eq(0).attr('title');
				// 查看图片
				SysTool.showPicture(title, gznr);
			}else if(type == 1){
				// 查看录音	
				SysTool.show("暂不支持录音播放！");
			}else if(type == 2){
				// 查看录像
				SysTool.show("暂不支持录像播放！");
			}else if(type == 3){
				showMsg(gznr);
			}else if(type == 4){
				showMsg(gznr);
			}
		}
		
		function showMsg(nr){
			var title = $(elem).find('a').eq(0).attr('title');
			var xx = nr.split('^');
			var msg = '';
			var size = xx.length;
			for(var i = 0; i < size; i++){
				if(size > 1){
					msg += (i + 1) + ' . ';
				}
				msg +=  xx[i] + '<br/>';
			}
			$.messager.alert(title, msg);
		}
	},
	/**
	 * 图上派警
	 * @param param 派警信息
	 */
	jqczTspj : function(param) {
		var jybh = param.jybh;
		//var jymc = param.jymc;
		var pjlx = param.mark;
		var jqxx = param.jqxx;
		Jqcz.tspjSbbh = param.gpsid;
		Jqcz.tspjHh = param.callno;
		//alert("gpsid="+gpsid+"----callno="+callno);
//		var msg = '请确认将警情' + Jqcz.getJqbh() + '派给警员' + jymc + '？';
//		if(pjlx == 1){
//			msg = '请确认安排' + jymc + '协助警情处置？';
//		}else if(pjlx == 2){
//			msg = '请确认将警情' + Jqcz.getJqbh() + '改派给警员' + jymc + '？';
//		}
//		SysTool.confirm(msg, function(r) {
//			if (r) {
			SysTool.ajax({url : 'zzjg/jyxx.f', data : {	jybh : jybh}}, function(data) {
				if (data.size > 0) {
					var jyxx = data.jyxx;
					var dddm = jyxx.ssjgdm;
					var zddm = jyxx.zzjgdm;
					var marker = Jqxx.currentPointObject[0];
					if(typeof(marker) != null){
						MapBubble.addPanOverListener(function(){
							MapBubble.isClickMarker = true;
							MapBubble.initBubbleSize(400, 352);
							$("#tipsContent").load("project/zhdd/pages/jqcz.jsp",function() {
								Jqcz.initTspj(jybh, jyxx, dddm, zddm, jqxx, pjlx, function(){
									$('input[name=pjtzfs_pj]').each(function(i) {
										$(this).click();
									});
								});
								MapBubble.currMarker = marker;
								MapBubble.openBubble(null);
								MapBubble.setBubblePositionByMarker(marker);
							});
						});
					}
				}else{
					SysTool.alert('警员无效或不存在！');
				}
			});
//			}
//		});
	},
	/**
	 * 初始化图上派警
	 * @param jybh 警员编号
	 * @param jyxx 警员信息
	 * @param dddm 大队代码
	 * @param zddm 中队代码
	 * @param jqxx 警情信息
	 * @param pjlx 派警类型
	 */
	initTspj : function(jybh, jyxx, dddm, zddm, jqxx, pjlx, callback){
		Jqcz.ISTSPJ = true;
		Jqcz.openJqxxWindow(jqxx, function(dt){
			
			// 设置指定选项卡选中
			var ind = (pjlx > 0) ? 2 : 1;
			$(".dl_paijin > dd").hide();
			$(".dl_paijin > dd:eq(" + ind + ")").show();
			$(".menu_paijin > a").removeClass("dtaon");
			$(".menu_paijin > a:eq(" + ind + ")").addClass("dtaon");
			$(".show_toggle").hide();
			$(".tips_slide_up").addClass("tips_slide_dw");
			/**
			 * 1、设置大队、中队、警员默认选中
			 * 2、默认警员下来选择事件
			 */
			// 初始化中队
			Jqcz.initZzjgDict({type : 1, zzjgdm : dddm, showId : 'jqcz_pj_sszdmc', initVal : zddm}, function() {
				initKjsb(jybh);
			}, function(){
				Dictionary.setDictionaryListValue({dictShowId: 'jqcz_pj_ssddmc', setVal: dddm});
				Dictionary.setDictionaryListValue({dictShowId: 'jqcz_pj_sszdmc', setVal: zddm});
			});
			// 初始化出警人员
			Jqcz.initZzjgDict({type: 2, zzjgdm: zddm, showId: 'jqcz_pj_jjmjmc', initVal: ''}, function(){
				initKjsb(jybh);
			}, function(){
				Dictionary.setDictionaryListValue({dictShowId: 'jqcz_pj_jjmjmc', setVal: jybh});
				// 隐藏增派警员中的第一次派警警员
				Jqcz.getJqjhsjXxByJhsjcm(Jqcz.JQCZCLSJ.JQPJ[0][0], function(jhsj){
					if(typeof(jhsj['sjxyrdm']) !== 'undefined'){	
						Dictionary.hideDictionaryListItem({dictShowId: 'jqcz_pj_jjmjmc', filter: [jhsj['sjxyrdm']]});
					}
				});
				//alert('jyxx='+JSON.stringify(jyxx));
				jybh = jybh + ',' + jyxx.jysfz + ',' + jyxx.jydh + ',' + jyxx.sbbh + ',' + SysTool.getTxtVal('jqcz_pj_jjmjmc');
				//alert('2jybh='+jybh);
				Jqcz.setKjsbBindByJybh(jybh, 'pj', function(data){
					initPjxx(pjlx);
				});
				SysTool.setTxtVal('jqcz_pj_jjmjdm', jybh);
				if(typeof(callback) === 'function'){
					callback(dt);
				}
			});
			Jqcz.initJqczCjlxChecked(pjlx);
			
		});
		function initKjsb(jybh){
			var jybh = SysTool.getTxtVal('jqcz_pj_jjmjdm');
			jybh = jybh + ',' + SysTool.getTxtVal('jqcz_pj_jjmjmc');
			var pjlx = $('input[name=jqczPjlx]:checked').val();
			initPjxx(pjlx);
			Jqcz.setKjsbBindByJybh(jybh, 'pj', function(data){});
			var jysbbh = (jybh.split(','))[3];
			Jqcz.getJyzbBysbbh(jysbbh, function(zb){
				if($(zb).size() > 0){
					Jqcz.CURRENTJYZB[zb.x, zb.y];
				}
			});
		}
		function initPjxx(pjlx){
			if(pjlx == 0){
				Jqcz.setJqczTxxxInfo([1], Jqcz.JQXXDATA, 'jqcz_pj_jjmjmc');
			}else if(pjlx ==1){
				Jqcz.setJqczTxxxInfo([6], Jqcz.JQXXDATA, 'jqcz_pj_jjmjmc');
			}else{
				Jqcz.setJqczTxxxInfo([7], Jqcz.JQXXDATA, 'jqcz_pj_jjmjmc');
			}
		}
	},
	
	/**
	 * 重大警情处置验证
	 * @param callback 回调方法
	 */
	zdjqczCheck : function(callback) {
		HTTPREQPARAM = { url : 'zdjq/getZdjqsb.f', data : { 'jqbh' : Jqcz.JQXXDATA.jqbh } };
		SysTool.ajax(HTTPREQPARAM, function(data) {
			callback(data);
		});
	},
	/**
	 * 重大警情处置验证
	 * @param callback 回调方法
	 */
	zdjqczSbjlCheck : function(jqbh, callback){
		HTTPREQPARAM = { url : 'zdjq/getJqsbjl.f', data : { 'jqbh' : jqbh } };
		SysTool.ajax(HTTPREQPARAM, function(data) {
			callback(data);
		});
	},
	/**
	 * 重大警情上报通知
	 * @param idx  通知顺序
	 * @param type 通知类型
	 * @param jqlb 警情类别
	 */
	zdjqsbtz : function(idx, type, jqlb, gt) {
		var selectId = 'jqcz_zdjq_sbld_' + idx;
		/* yichu，上报修改
		var tzdx = SysTool.getTxtVal(selectId + '_dm');
		tzdx = tzdx.split(',');
		var tzhm = tzdx[1];
		var tzmc = SysTool.getTxtVal(selectId + '_mc');
		tzmc = (tzmc.split('|'))[0];
		var vail = SysTool.validator.isEmpty(selectId + '_dm', '请先选择上报领导！', selectId + '_mc');
		if (vail) { return; }
		*/
		var sbqkId = selectId + '_qk_' + gt;
		vail = SysTool.validator.isEmpty(sbqkId, '上报情况不能为空！');
		if (vail) { return; } else {
			vail = SysTool.validator.maxLength(sbqkId, 200);
			if (vail) { return; }
		}
		var sbqk = SysTool.getTxtVal(sbqkId);
		/* yichu，上报修改begin */
		var tzdx = "";
		var tzhm = "";
		var tzmc = "";
		for (var i = 0; i < Jqcz.hideDictionaryListItemHtmlArray.length; i++) {
			if (sbqk.indexOf(Jqcz.hideDictionaryListItemHtmlArray[i].text.split("|")[1]) != -1) {
				tzdx = Jqcz.hideDictionaryListItemHtmlArray[i].text.split("|")[0];
				tzdx = tzdx.split(',');
				tzhm = tzdx[1];
				tzmc = Jqcz.hideDictionaryListItemHtmlArray[i].text.split("|")[1];
				tzmc = (tzmc.split('|'))[0];
				break;
			}
		}
		/* yichu，上报修改end */
		
		var ryid = tzdx[0];
		var sbpz = $('input[name=\'zdjqflpz\']:checked').val() || jqlb;// yichu，上报修改
		sbpz = sbpz.split('^');
		var jqbh = Jqcz.getJqbh();
		/**
		 * 1、通知领导时需发送短信 1.1、type=0时才发送短信 1.2、type=1时为人为通知无需发送短信
		 * 2、通知领导后添加事件操作记录(写入日志) 3、写入重大警情记录
		 */
		var msg = '确认已通知' + tzmc + '？';
		SysTool.confirm(msg, function(r) {
			if (r) {
				var jqxx = Jqcz.JQXXDATA;
				if (type == 0) {
					var jsrid = ryid;
					var nrId = 'jqcz_zdjq_jqnr';
					msg = jqxx.jqafdd + ', 发生' + jqxx.jqxx + '。当前被定义为：' + sbpz[1];
					SysTool.setTxtVal(nrId, msg);
					Jqcz.jqczSMSSend(jsrid, tzmc, tzhm, nrId, '成功通知' + tzmc);
				}
				var username = $('#currentLoginUserName').val();
				// 记录操作日志
				var jqczsj = Jqcz.JQCZCLSJ.JQSB;
				msg = username + '向' + tzmc + '上报' + jqxx.jqafdd + ',发送' + jqxx.jqxx + '。当前被定义为：' + sbpz[1];
				// msg : 谁什么时候将哪个警情上报给哪位领导（单位）
				var param = {'cm' : jqczsj[0], 'ct' : jqczsj[1], 'ms' : jqczsj[1] + '：' + msg};
				Jqcz.jqczsjjl(param);
				// 写入重大警情上报记录
				param = {'jqbh' : jqbh, 'jqflpzid' : sbpz[0], 'sbrypzid' : ryid, 'sbzt' : 1, 'sbxx' : sbqk };
				Jqcz.zdjqsbjl(param, function(data) {
					// 处置完成禁用按钮、下拉
					//$('#' + selectId + '_mc').attr('disabled', 'disabled');
					$('#' + selectId + '_qk_' + gt).attr('disabled', 'disabled');
					$('#' + selectId + '_btn_' + gt).attr('disabled', 'disabled');
					$('#' + selectId + '_rm_' + gt).remove();
					$('#' + selectId + '_call_' + gt).remove();
				});
				var msg = SysTool.getTxtVal(sbqkId);
				SysTool.show(msg);
			}
		});
	},

	/**
	 * 重大警情上报记录
	 */
	zdjqsbjl : function(param, callback) {
		HTTPREQPARAM = {url : 'zdjq/jqsbjl.f', data : param	};
		SysTool.ajax(HTTPREQPARAM, function(data) {
			if (data.status > 0) {callback(data);}
		});
	},
	/**
	 * 根据警员编号设置科技设备绑定
	 * @param jyInfo    警员信息
	 * @param callback  回调方法
	 */
	setKjsbBindByJybh : function(jyInfo, marker, callback) {
		// [0：警员编号、1：身份证号码、2：警员电话、3：警员设备编号、4：警员名称]
		var jyxx = jyInfo.split(',');
		// 科技设备获取参数设置
		HTTPREQPARAM = { url : 'jqcz/getKjsb.f', data : { 'jybh' : jyxx[0] } };
		SysTool.ajax(HTTPREQPARAM, function(data) {
			var size = data.length;
			if (size > 0) {
				$('#jqcz_kjsb_rt_' + marker + ' > a').removeAttr('disabled');
				$('#jqcz_kjsb_rt_' + marker + ' > a').removeClass("btn_tipssavee");
				$('#jqcz_pj_xxnr_' + marker).removeAttr('disabled');
				$('#rd_jqcz_pjfs_dd_' + marker + ' > a').attr('disabled', 'disabled');
				//$('#rd_jqcz_pjfs_dd_' + marker + ' > a').removeAttr('disabled');
				$.each(data, function(i, kjsb) {
					$('#rd_jqcz_pjfs_dd_' + marker + ' > a').each(function(){
						var showchangenb=$(this).attr('showchange');
						if(data[i].dm==showchangenb){
							$(this).removeAttr('disabled');
						}
					});
					if (i == 0) {
						$('input[name=pjtzfs_' + marker + ']:eq('+ i + ')').attr('checked','checked');
						Jqcz.setKjsbBingRadioEvent(kjsb['tdlx'],marker);
					}
				});
			} else {
				$('#jqcz_kjsb_rt_' + marker + ' > a').attr('disabled','disabled');
				$('#jqcz_pj_xxnr_' + marker).attr('disabled','disabled');
				$('#rd_jqcz_pjfs_dd_' + marker + ' > a').attr('disabled', 'disabled');
				$('#jqcz_kjsb_rt_' + marker + ' > a').addClass("btn_tipssavee");
				$('input[name=pjtzfs_' + marker + ']').removeAttr('checked');
				$('input[name=pjtzfs_' + marker + ']:eq(0)').attr('checked','checked');
			}
			callback(data);
		});
	},

	/**
	 * 设置科技设备绑定
	 * @param types 科技设备类型
	 */
	setKjsbBingRadioEvent : function(types, marker) {
		var count = 0, type = '';
		// 消息发送类型
		var msgTypes = [ 1, 2, 3, 4, 5, 6 ], callTypes = [ 0, 3, 4, 6 ];
		if (msgTypes.isExist(types)) {
			count++;
			type = 'msg';
		}
		if (callTypes.isExist(types)) {
			count++;
			type = 'call';
		}
		if (count > 1) {
			if (type == 'call') {
				$('#kjsb_call_btn_' + marker).removeAttr('disabled');
				$('#kjsb_msg_btn_' + marker).removeAttr('disabled');
				$('#jqcz_pj_xxnr_' + marker).removeAttr('disabled');
				$('#jqcz_kjsb_rt_' + marker + ' > a').removeClass("btn_tipssavee");
			}
		} else {
			if (type == 'msg') {
				$('#kjsb_call_btn_' + marker).attr('disabled', 'disabled');
				$('#kjsb_msg_btn_' + marker).removeAttr('disabled');
				$('#jqcz_pj_xxnr_' + marker).removeAttr('disabled');
				$('#kjsb_msg_btn_' + marker).removeClass("btn_tipssavee");
				$('#kjsb_call_btn_' + marker).addClass("btn_tipssavee");
			} else {
				$('#kjsb_msg_btn_' + marker).attr('disabled', 'disabled');
				$('#jqcz_pj_xxnr_' + marker).attr('disabled', 'disabled');
				$('#kjsb_call_btn_' + marker).removeAttr('disabled');
				$('#kjsb_call_btn_' + marker).removeClass("btn_tipssavee");
				$('#kjsb_msg_btn_' + marker).addClass("btn_tipssavee");
			}
		}
	},

	/**
	 * 获取提醒信息
	 * @param types 提醒信息类型
	 * 		1、派警短信 2、群众互动短信 3、满意度调查短信 4、到达超时提醒短信 5、回馈超时提醒短信 6、警情增援 7、警情改派
	 * @param record 当前记录信息
	 */
	setJqczTxxxInfo : function(types, data, id) {
		var msg = '', type = 0;
		var jjmjmc = SysTool.getTxtVal(id);
		var afdd = data['jqafdd'];
		var bjdh = data['bjdh'];
		for ( var i = 0; i < types.length; i++) {
			type = types[i];
			if (type == 1) {
				if ("undefined" == typeof bjdh) {
					msg = jjmjmc + '同志，于' + SysTool.getDateTimeFormat(data['bjsj'])
					+ '在' + afdd + '发生警情，请速前往。';
				} else {
					msg = jjmjmc + '同志，于' + SysTool.getDateTimeFormat(data['bjsj'])
					+ '在' + afdd + '发生警情，请速前往。报警电话为' + bjdh;
				}
				SysTool.setTxtVal('jqcz_pj_xxnr_pj', msg);
			} else if (type == 2) {
				if ("undefined" == typeof bjdh) {
					msg = "";
				} else {
					msg = bjdh + "机主您好！指挥中心已派人员赶往现场。请注意交通安全，防止发生次生安全事故。";
				}
			} else if (type == 3) {
				if ("undefined" == typeof bjdh) {
					msg = '';
				} else {
					msg = bjdh + '机主您好！请对本次警务合作进行评价，回复数字0、1(0不满意，1满意)，谢谢！';
				}
				SysTool.setTxtVal('jqcz_cz_myddc', msg);
			} else if (type == 4) {
				msg = jjmjmc + '同志，案发地点：' + afdd
						+ '发生警情，到达现场已超过规定时间，请速前往；如有特殊情况请向派警部门说明。';
			} else if (type == 5) {
				msg = jjmjmc + '同志，案发地点：' + afdd
						+ '发生警情，你的回馈已经超过规定时间，请立即回馈；如有特殊情况请向派警部门说明。';
			} else if (type == 6) {
				if ("undefined" == typeof bjdh) {
					msg = jjmjmc + '同志，于' + SysTool.getDateTimeFormat(data['bjsj']) + '在' + afdd + '发生警情，请速前往增援。';
				} else {
					msg = jjmjmc + '同志，于' + SysTool.getDateTimeFormat(data['bjsj']) + '在' + afdd + '发生警情，请速前往增援。报警电话为' + bjdh;
				}
				SysTool.setTxtVal('jqcz_pj_xxnr_pj', msg);
			} else if (type == 7) {
				if ("undefined" == typeof bjdh) {
					msg = jjmjmc + '同志，于' + SysTool.getDateTimeFormat(data['bjsj']) + '在' + afdd + '发生警情，现改派您为警情处置人员，请速前往。';
				} else {
					msg = jjmjmc + '同志，于' + SysTool.getDateTimeFormat(data['bjsj']) + '在' + afdd + '发生警情，现改派您为警情处置人员，请速前往。报警电话为' + bjdh;
				}
				SysTool.setTxtVal('jqcz_pj_xxnr_pj', msg);
			}
			
		}
	},
	/**
	 * 重大警情上报领导
	 * @param sid 元素ID
	 * @param i  序号
	 * @param bz 备注
	 * @param jqjb 警情级别
	 */
	setZdjqsbld : function(sid, i, bz, jqjb){
		//var isExists = false;
		var selectId = sid + i;
//		$('#' + selectId + '_ct > span').each(function(i, el){
//			if(selectId + '_lf' == $(el).attr('class')){
//				isExists = true;
//			}
//		});
		// 重复不好判断if(!isExists){
		var gt = new Date().getTime();
		var ct = $('#' + selectId + '_ct').html();
		var sbryTxt = '<span class="' + selectId + '_lf"><input type="hidden" id="' + selectId + '_hd_' + gt + '" /><textarea id="' + selectId + '_qk_' + gt + '" style="width:250px;height:16px;float:left"></textarea><span class="sclose_btn" id="' + selectId + '_rm_' + gt + '" title="删除" onclick="Jqcz.setZdjqsbldDelete(\'' + selectId + '\', \'' + $('#' + selectId + '_mc').val() + '\');"></span><span class="sphone_btn" id="' + selectId + '_call_' + gt + '" title="呼叫"></span>';
		sbryTxt += '<div class="lf"><a href="javascript:void(0);" id="' + selectId + '_btn_' + gt + '" onclick="Jqcz.zdjqsbtz(' + i + ', ' + bz + ', \'' + jqjb + '\', \'' + gt + '\');" class="btn_tipsdw" style="margin-right:5px;">确定</a></div></span>';
		ct += sbryTxt;
		$('#' + selectId + '_ct').html(ct);
		SysTool.changeIputStyle();
		var txt = $('#' + selectId + '_mc').val();
		//var content = txt;
		//txt = (txt.split('（'))[0];
		var content = '已成功通知' + txt;
		$('#' + selectId + '_qk_' + gt).val(content);	
		$('#' + selectId + '_hd_' + gt).val($('#' + selectId + "_dm").val());
//		$('#' + selectId + '_ct > span').each(function(i, elem){
//			//alert(i + '\t ' + $(elem).html());
//			if(i != 0){
//				$(elem).find('a').remove();
//			}
//		});
		//}
	},
	/**
	 * 删除重大警情上报
	 * @param selectId
	 * @param dictItemCt 字典项词条
	 */
	setZdjqsbldDelete : function(selectId, dictItemCt){
		$('#' + selectId + '_ct > span').click(function(){
			for (var i = 0; i < Jqcz.hideDictionaryListItemHtmlArray.length; i++) {
				if (Jqcz.hideDictionaryListItemHtmlArray[i].html.indexOf(dictItemCt) != -1) {
					Dictionary.showDictionaryListItem({"dictShowId": (selectId + '_mc'), "html": Jqcz.hideDictionaryListItemHtmlArray[i].html});
					Jqcz.hideDictionaryListItemHtmlArray.splice(i, 1);
					break;
				}
			}
			$(this).remove();
		});
	},
	/**
	 * 设置组件是选中
	 * @param id 组件id
	 * @param isChecked  true选中 false未选中
	 * @param marker true设置选中
	 */
	setChecked : function(id, isChecked, marker) {
		var checked = false;
		if (typeof (isChecked) === 'undefined') {
			checked = $('#' + id).is(':checked');
			checked = !checked;
		} else {
			checked = isChecked;
			if (typeof (marker) !== 'undefined') {
				checked = $('#' + id).is(':checked');
			}
		}
		if (checked) {
			$('#' + id).attr("checked", true);
		} else {
			$('#' + id).removeAttr("checked");
		}
	},
	
	/**
	 * 选中checkbox
	 * checkbox的id
	 */
	ifcheckboxSelected : function(id){
		
		var jlCheckbox = $("#jqcz_ifhurt").attr('checked');
		var dxCheckbox = $("#jqcz_ifdead").attr('checked');
		if ("checked" == jlCheckbox)
		{
			$("#jqcz_if_sw_hurtcount").show();
			$("#jqcz_if_sw_ifdxhurt").show();
		}
		else{
		
			$("#jqcz_if_sw_hurtcount").hide();
			$("#jqcz_if_sw_ifdxhurt").hide();
			$("#jqcz_hurtcount").val("");
			$("#jqcz_ifdxhurt").removeAttr("checked");
		}
		if ("checked" == dxCheckbox)
		{
			$("#jqcz_if_sw_deadcount").show();
		}
		else{
			$("#jqcz_if_sw_deadcount").hide();
			$("#jqcz_deadcount").val("");
		}
		
	},

	/**
	 * 设置单选效果样式
	 * @param id 外层元素ID
	 * @param name 单选组名称
	 */
	setRadioChecked : function(id, name) {
		$('#' + id + ' > a').bind('click',function() {
			$('input[name=' + name + ']:eq(' + $(this).index() + ')').attr('checked', 'checked');
		});
	},
	/**
	 * 设置警情处置选项卡加载
	 * @param tabName 选项卡名称
	 */
	setJqczTabEvent : function(tabName) {
		var idx = 0;
		var arry = Jqcz.JQCZTAB;
		for ( var i = 0; i < arry.length; i++) {
			if (tabName === arry[i]) {
				idx = i;
				break;
			}
		}
		var elemId = '#jqcz_' + tabName + 'tab';
		var eventName = tabName + 'Click';
		$(elemId).bind(eventName, function() {
			$(".dl_paijin > dd").hide();
			$(".dl_paijin > dd:eq(" + idx + ")").show();
			$(".menu_paijin > a").removeClass("dtaon");
			$(".menu_paijin > a:eq(" + idx + ")").addClass("dtaon");
			$(".show_toggle").hide();
			$(".tips_slide_up").addClass("tips_slide_dw");
		});
		$(elemId).trigger(eventName);
	},
	/**
	 * 重置地图Marker对象
	 */
	updateJqxxIcon : function(jqzt, isShow) {
		// 更新当前警情状态Icon
		var jqxx = Jqcz.JQXXDATA;
		jqxx['jqzt'] = jqzt;
		if (null != MapBubble.currMarker) {
			_MapApp.removeOverlay(MapBubble.currMarker);
		}
		MapBubble.removeCircle();
		MapBubble.removeAroundMarker();
		var arry = new Array();
		arry.push(jqxx);

		var data = {list : arry};
		Jqxx.loadJqxxToMap({}, data, function(markerArray) {
			if(markerArray.length==0){//如果没有定位 by pan
				MapBubble.closeBubble();
			}
			// 重新添加警力圈
			var marker = markerArray[0];
			MapBubble.currMarker = marker;
			Jqxx.jqMarkerClickEvent(jqxx);
			if(typeof(isShow) === 'undefined' || isShow == true){
				MapBubble.closeBubble();
			}else{
				MapBubble.closeBubble();
			}
			
		});
	},
	/**
	 * 清空指定选择组件
	 * @param ids 组件ID
	 */
	clearSelectComponet : function(ids) {
		$.each(ids, function(i, id) {
			$('#' + id + 'mc').val('');
			$('#' + id + 'dm').val('');
			$('#' + id + 'mcDiv').html('');
		});
		var marker = 'pj';
		$('#jqcz_kjsb_rt_' + marker + ' > a').attr('disabled','disabled');
		$('#jqcz_pj_xxnr_' + marker).attr('disabled','disabled');
		$('#rd_jqcz_pjfs_dd_' + marker + ' > a').attr('disabled', 'disabled');
		$('#jqcz_kjsb_rt_' + marker + ' > a').addClass("btn_tipssavee");
		$('input[name=pjtzfs_' + marker + ']').removeAttr('checked');
		$('input[name=pjtzfs_' + marker + ']:eq(0)').attr('checked','checked');
	},
	/**
	 * 删除上一次道路层对象
	 */
	removeLastLayer : function() {
		var marker = Jqcz.LASTROADLAYERMARKER;
		if (marker !== '') {
			_MapApp.removeOverlay(marker);
		}
		var polyline = Jqcz.LASTROADLAYERPOLYLINE;
		if (polyline !== '') {
			_MapApp.removeOverlay(polyline);
		}
	},
	/**
	 * 警情处置窗口设置
	 */
	jqczToggle : function() {
		$('.tips_slide_up').toggleClass('tips_slide_dw');
		$('.tips_paijin').toggle(0);
		$('.show_toggle').toggle(0);
		$(".dl_paijin > dd").hide();
		$('#tips_showdx').toggleClass('tips_showdx');
		$(".menu_paijin > a").each(function(i, el) {
			var cls = $(el).attr("class");
			if (cls == "dtaon") {
				$(".dl_paijin > dd:eq(" + i + ")").show();
			}
		});
		ScrollBarTool.init("scroll_main_zdjq", "scroll_content_zdjq", false);
	},
	/**
	 * 延迟加载
	 * @param callback 回调方法
	 * @param time 延迟时间(毫秒)
	 */
	lazyLoad : function(callback, time) {
		var ms = time;
		if (typeof (ms) === 'undefined') { ms = 10; }
		setTimeout(function() { callback(); }, ms);
	},
	/**
	 * 车辆布控
	 */
	showClbk : function() {
		Resource.fireClickFunc("clbk", "project/busiapp/jkd/clbk.jsp", {
			"jqbh" : Jqcz.getJqbh(),
			"isLoad" : "yes"
		});
	},
	/**
	 * 显示面板公共方法
	 * @param idArry
	 * @param isShow
	 */
	setTabShowFunc:function(idArry, isShow,idx) {
		var id = '#jqcz_' + idArry[0] + 'tab';
		var tabName = '';
		var count = idArry.length;
		var index=idx||0;
		for ( var i = 0; i < count; i++) {
			id = '#jqcz_' + idArry[i] + 'tab';
			if(i==index){
				tabName = idArry[i];
			}
			isShow ? $(id).show() : $(id).hide();
		}
		// 初始化tab
		if (tabName != '' && isShow == true) {
			Jqcz.setJqczTabEvent(tabName);
		}
	},
	/**
	 * 获取处置结果内容
	 * @param jqbh 警情编号
	 * @param jqlxdm 警情类型代码
	 */
	getCzjgnr:function(jqbh,jqlxdm){
		var HTTPREQPARAM={url:"jqcz/getCzjgnr.f",data:{jqbh:jqbh,jqlxdm:jqlxdm}};
		var jqlx = (jqlxdm.split(','))[1];
		SysTool.ajax(HTTPREQPARAM, function(data) {
			$("#jqcz_jqczjg").empty();
			Jqcz.showCzjgnr(data,jqlx);
			
		});
	},
	/**
	 * 
	 * @param data 处置结果集 如data["cjxx"]\data["sbxx"]\data["zxtswsxx"]
	 * @param jqlx 警情类型
	 */
	showCzjgnr:function(data,jqlx){
		if(jqlx=="0"||jqlx=="5"){//出警类
			var cjxx=data["cjxx"];
			var cjdiv="";
			var jgdiv="";
			for(var i=0;i<cjxx.length;i++){
				if(cjxx[i]["jqcljhsjcm"]=="JHSJ002"){
					cjdiv+="<div><span>出警人员：</span><span class='color_blank'>"+(cjxx[i]["sjxyrmc"]||"空")+"</span>";
					cjdiv+="&nbsp;&nbsp;&nbsp;&nbsp;<span>联系方式：</span><span class='color_blank'>"+(cjxx[i]["sjxyrdh"]||"空")+"</span>";
					cjdiv+="&nbsp;&nbsp;&nbsp;&nbsp;<span>呼号：</span><span class='color_blank'>"+(cjxx[i]["sjxyrhh"]||"空")+"</span></div>";
				}else if(cjxx[i]["jqcljhsjcm"]=="JHSJ005"){
					jgdiv="<div><span>处置结果：</span><span class='color_blank'>"+(cjxx[i]["jhnr"]||"空")+"</span></div>";
				}
			}
			$("#jqcz_jqczjg").append(cjdiv+jgdiv);
		}else if(jqlx=="1"){//上报类
			var cjxx=data["cjxx"];
			var sbxx=data["sbxx"];
			var cjdiv="";
			var sbrydiv="";
			var jgdiv="";
			var sbjbdiv="";
			var sbdiv="";
			for(var i=0;i<cjxx.length;i++){
				if(cjxx[i]["jqcljhsjcm"]=="JHSJ002"){//派警
					cjdiv+="<div><span>出警人员：</span><span class='color_blank'>"+(cjxx[i]["sjxyrmc"]||"空")+"</span>";
					cjdiv+="&nbsp;&nbsp;&nbsp;&nbsp;<span>联系方式：</span><span class='color_blank'>"+(cjxx[i]["sjxyrdh"]||"空")+"</span>";
					cjdiv+="&nbsp;&nbsp;&nbsp;&nbsp;<span>呼号：</span><span class='color_blank'>"+(cjxx[i]["sjxyrhh"]||"空")+"</span></div>";
				}else if(cjxx[i]["jqcljhsjcm"]=="JHSJ005"){//处置反馈
					jgdiv="<div><span>处置结果：</span><span class='color_blank'>"+(cjxx[i]["jhnr"]||"空")+"</span></div>";
				}
			};
			for(var j=0;j<sbxx.length;j++){//上报信息
				sbjbdiv="<div><span>警情级别：</span><span class='color_blank'>"+(sbxx[j]["jqflmc"]||"空")+"</span></div>";
				sbrydiv+="<div><span>上报人员：</span><span class='color_blank'>"+(sbxx[j]["sbryxm"]||"空")+"</span>";
				sbrydiv+="&nbsp;&nbsp;&nbsp;&nbsp;<span>联系方式：</span><span class='color_blank'>"+(sbxx[j]["sbrydh"]||"空")+"</span></div>";
			}
			sbdiv=sbjbdiv+sbrydiv;
			$("#jqcz_jqczjg").append(cjdiv+sbdiv+jgdiv);
		}else if(jqlx=="3"){//投诉
			var tsxx=data["zxtswsxx"];
			var tsdiv="";
			var bzdiv="";
				tsdiv="<div><span>投诉人员：</span><span class='color_blank'>"+(tsxx[0]["rym"]||"空")+"</span>";
				tsdiv+="&nbsp;&nbsp;&nbsp;&nbsp;<span>投诉单位：</span><span class='color_blank'>"+(tsxx[0]["ssjgmc"]||"空")+"</span></div>";
				bzdiv="<div><span>备注：</span><span class='color_blank'>"+(tsxx[0]["nr"]||"空")+"</span></div>";
			$("#jqcz_jqczjg").append(tsdiv+bzdiv);
		}else if(jqlx=="2"||jqlx=="4"){//咨询、无效
			var zxwsxx=data["zxtswsxx"];
			if(jqlx=="2"){
				var zxdiv="";
					zxdiv="<div><span>备注：</span><span class='color_blank'>"+(zxwsxx[0]["nr"]||"空")+"</span></div>";
			 $("#jqcz_jqczjg").append(zxdiv);
			}else if(jqlx=="4"){
				var wxdiv="";
					wxdiv="<div><span>无效原因：</span><span class='color_blank'>"+(zxwsxx[0]["nr"]||"空")+"</span></div>";
				$("#jqcz_jqczjg").append(wxdiv);
			}
		}
	},
	/** 
		新定位方法
	*/
	
	newLoateXY:function(){//by pan
		var vail = false;
		vail = SysTool.validator.isBlank([ {
			id : 'jqcz_jqlxdm',
			msg : '警情类型不能为空！',
			sId : 'jqcz_jqlxmc'
		} ]);
		if (vail) { return vail; }
			Jqcz.showLoateButton();
			MapBubble.hideBubble();
		var lddm = SysTool.getTxtVal('jqcz_fzdw_lddm'), ldmc = SysTool.getTxtVal('jqcz_fzdw_ldmc');
		if ((lddm != '' && ldmc != '') || (lddm != '' && ldmc == '')) {
			Jqcz.jqxxLddw({'lddm' : lddm, 'ldmc' : ldmc	}, function() { /**/});
		}
		$("#newLoateButton").click(function(){
			Jqcz.locateButtonClick();
		});
	},
	/**
		定位按钮触发事件
	*/
	locateButtonClick:function(lx){
			Jqcz.updateJqzb();
	},
	/**
	初始化定位按钮
	*/
	initLocateButton:function(){
			var buttonHtml='<a href="javascript:void(0);" class="newloate_button" id="newLoateButton"></a>';
			$("#mapContainer").after(buttonHtml);
	},
		/**
	隐藏定位按钮
	*/
	hideLoateButton:function(){
		$("#newLoateButton").hide();
	},
	/**
	显示定位按钮
	*/
	showLoateButton:function(){
		$("#newLoateButton").show();
	}
};
Array.prototype.destroy = function() {
	var array = this;
	array = null;
	delete array;
};
Array.prototype.isExist = function(val) {
	var isComprise = false;
	var newArr = this;
	for ( var i = newArr.length - 1; i >= 0; i--) {
		if (val == newArr[i]) {
			isComprise = true;
		}
	}
	return isComprise;
};