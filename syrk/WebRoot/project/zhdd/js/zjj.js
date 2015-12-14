/*!
 * 自接警JS
 * znjg - v1.0.0 (2014-03-28 14:50)
 * Copyright(c) 2014 founder
 */

/**
 * @classDescription 自接警全局对象
 * @author yangyongfei
 */
var Zjj = {
		/**
		 * 当前自接警的警情编号
		 */
		JQBH : "",
		
		
		/**
		 * 动态展示面板id，{'boxid':[面板id]}
		 */
		PROBOXIDOBJECT : {'boxid':["zjj_jqdw_dd"]},
		
		/**
		 * 保存警情操作的类型
		 */
		ADDOPTIONTYPE : "",
		
		/**
		 * 辅助定位上一次的线
		 */
		LASTROADLAYERPOLYLINE : "",
		
		/**
		 * 辅助定位,上一次定位完成之后的marker
		 */
		LASTDWMARKER : "",
		
		/**
		 * 当前地图上显示的自接警marker
		 */
		CURRMARKER : null,
		
		/**
		 * 当前可选大队代码
		 */
		CRRENTENABLEDD : {},
		
		/**
		 * 初始化
		 */
		initZjj : function(){
			var crrentTime = SysTool.getDateTimeFormat(new Date().getTime());
			SysTool.setTxtVal("zjj_jjsj", crrentTime);
			SysTool.setTxtVal("zjj_bjsj", crrentTime);
			
			Zjj.creatLbSelect("caseType122030000","caseType122030100","");
			
			//初始化所属机构选择
			Zjj.creatZzjgSelect("","");

			Zjj.creatLxSelect("");
			
			Zjj.JQBH = SysTool.getDateTimeFormatNoSeparator(new Date().getTime()) + Math.floor(9000000*Math.random()+1000000);
			SysTool.changeIputStyle();
			
			//隐藏左边框
			LeftLayout.hideLefLayout();
		},
		
		
		/**
		 * 创建路段下拉列表
		 * @param xzqh 行政区划
		 * @param DIinitVal 道路初始化值
		 * @param LdinitVal 路段初始化值
		 */
		creatLdSelect : function(LdinitVal){
			var dddm = SysTool.getTxtVal("zjj_jqssdddm");
			var xzqh = dddm.substring(0,6);
			Dictionary.initDictionaryList({url: "dictionary/getLdDictJSON.f", data: {"zdbh": "JT_ROADSEGITEM_PL", "xzqh": xzqh}, dictShowId: "zjj_ldmc",dictContainerReferenceObjectId: "zjj_bodyid", initVal: LdinitVal}, function() {
			});
		},
		
		/**
		 * 创建警情类别下拉列表
		 * @param dllb 大类类别
		 * @param zllb 中类类别
		 * @param xllb 小类类别
		 */
		creatLbSelect : function(dllb,zllb,xllb){
			Dictionary.initDictionaryList({url: 'dictionary/jqlbDict.f', data: {'zdbh': 'D_JQLB', 'zddm': '', 'count': 1}, dictShowId: 'zjj_jqssdl',dictContainerReferenceObjectId: "zjj_bodyid", initVal: dllb}, function() {
				$("#zjj_jqsszldm").val("");
				$("#zjj_jqsszl").val("");
				$("#zjj_jqssxldm").val("");
				$("#zjj_jqssxl").val("");
				Dictionary.initDictionaryList({url: 'dictionary/jqlbDict.f', data: {'zdbh': 'D_JQLB', 'zddm': SysTool.getTxtVal('zjj_jqssdldm'), 'count': 2}, dictShowId: 'zjj_jqsszl',dictContainerReferenceObjectId: "zjj_bodyid",initVal: ""}, function() {
					$("#zjj_jqssxldm").val("");
					$("#zjj_jqssxl").val("");
					Dictionary.initDictionaryList({url: 'dictionary/jqlbDict.f', data: {'zdbh': 'D_JQLB', 'zddm': SysTool.getTxtVal('zjj_jqsszldm'), 'count': 3}, dictShowId: 'zjj_jqssxl',dictContainerReferenceObjectId: "zjj_bodyid",initVal: ""}, function() {});
				});
			});
			Dictionary.initDictionaryList({url: 'dictionary/jqlbDict.f', data: {'zdbh': 'D_JQLB', 'zddm': SysTool.getTxtVal('zjj_jqssdldm'), 'count': 2}, dictShowId: 'zjj_jqsszl',dictContainerReferenceObjectId: "zjj_bodyid",initVal: zllb}, function() {
				$("#zjj_jqssxldm").val("");
				$("#zjj_jqssxl").val("");
				Dictionary.initDictionaryList({url: 'dictionary/jqlbDict.f', data: {'zdbh': 'D_JQLB', 'zddm': SysTool.getTxtVal('zjj_jqsszldm'), 'count': 3}, dictShowId: 'zjj_jqssxl',dictContainerReferenceObjectId: "zjj_bodyid",initVal: ""}, function() {});
			});
			Dictionary.initDictionaryList({url: 'dictionary/jqlbDict.f', data: {'zdbh': 'D_JQLB', 'zddm': SysTool.getTxtVal('zjj_jqsszldm'), 'count': 3}, dictShowId: 'zjj_jqssxl',dictContainerReferenceObjectId: "zjj_bodyid",initVal: ""}, function() {});
		},
		
		/**
		 * 创建组织机构下拉列表
		 * @param dddm 大队代码
		 * @param zddm 中队代码
		 */
		creatZzjgSelect : function(dddm,zddm){
			$("#zjj_jqssdddm").val("");
			$("#zjj_jqssdd").val("");
			$("#zjj_jqsszddm").val("");
			$("#zjj_jqsszd").val("");
			Dictionary.initDictionaryList({url: "zzjg/getZzjgDd.f", data: {"zzjgdm": SysConfig.T_USER_LOGIN_ORGID_ZD}, dictShowId: "zjj_jqssdd",dictContainerReferenceObjectId: "zjj_bodyid", initVal: dddm}, function() {
				$("#zjj_jqsszddm").val("");
				$("#zjj_jqsszd").val("");
				$("#zjj_ldmc").val("");
				
				Zjj.creatZzjgZd("");
				Zjj.creatLdSelect("");
			}, function(){
				var li = $('#zjj_jqssddDiv').find('li');
				if ('' == dddm && li.length > 0)
				{
					$('#zjj_jqssdd').val(li.text().split("|")[1]);
					$('#zjj_jqssdddm').val(li.text().split("|")[0]);
					Zjj.creatZzjgZd("");
				}
				else if ('' != dddm)
				{
					Zjj.creatZzjgZd(zddm);
				}
				var span = document.getElementById("zjj_jqssddDiv").getElementsByTagName("span");
				for (var index = 0; index < span.length; index = index + 2)
				{
					var jgdm = span[index].innerText.substring(0,span[index].innerText.length - 1);
					Zjj.CRRENTENABLEDD["DD"+jgdm] = jgdm;
				}
				Zjj.creatLdSelect("");
			});
		},
		
		/**
		 * 创建中队
		 * @param zddm
		 */
		creatZzjgZd : function(zddm){
			Zjj.initZzjgDict({type: 0, zzjgdm: SysTool.getTxtVal('zjj_jqssdddm'), showId: 'zjj_jqsszd', initVal: zddm}, function(){
			});
		},
		
		/**
		 * 创建警情类型下拉列表
		 */
		creatLxSelect : function(initValue){
			// 初始化警情类型
			Dictionary.initDictionaryList({url: 'dict/getJqlxToJj.f', data: {'zdbh': '', 'zddm': ''}, dictShowId: 'zjj_jqlxmc', dictContainerReferenceObjectId: "zjj_bodyid", initVal: initValue}, function(){
				Zjj.changeProBoxByLx();
			});
		},
		
		/**
		 * 根据警情类型切换需要填写的属性框
		 */
		changeProBoxByLx : function(){
			var jqlx = SysTool.getTxtVal("zjj_jqlxdm");
			var jqlb = jqlx.split(",")[0];
			if (0 != Zjj.PROBOXIDOBJECT.boxid.length)
			{
				for (var i = 0; i < Zjj.PROBOXIDOBJECT.boxid.length; i++)
				{
					$("#" + Zjj.PROBOXIDOBJECT.boxid[i]).hide();
				}
			}
			
			if ("jqlb002" == jqlb)
			{
				$("#zjj_jqdw_dd").show();
				Zjj.PROBOXIDOBJECT = {'boxid':["zjj_jqdw_dd"]};
				Zjj.ADDOPTIONTYPE = "4";
			}
			else if ("jqlb003" == jqlb)
			{
				$("#zjj_jqdw_dd").show();
				$("#zjj_shbj_dd").show();
				Zjj.initPersonnel('sh');
				Zjj.PROBOXIDOBJECT = {'boxid':["zjj_jqdw_dd","zjj_shbj_dd"]};
				Zjj.ADDOPTIONTYPE = "3";
			}
			else if ("jqlb008" == jqlb)
			{
				$("#zjj_jqts_dd").show();
				Zjj.PROBOXIDOBJECT = {'boxid':["zjj_jqts_dd"]};
				Zjj.ADDOPTIONTYPE = "1";
				var zzjgdm = SysConfig.T_USER_LOGIN_ORGID_ZD;
				/*yichu 初始化自接警投诉单位时，加auth: "9"参数*/
				Dictionary.initDictTree({url: "dictionary/getOrganizationDictTreeJSON.f", zdbh: "D_ORG", zdmc: "组织机构", zzjgdm: zzjgdm, auth: "9", dictDataDivId: "zjj_ts_tsdwmc_data_Div"}, function(){
					Dictionary.beforeCreateDictTree({createCount: 1, zdbh: "D_ORG", treeData: data_D_ORG, dictDataDivId: "zjj_ts_tsdwmc_data_Div"});
					Dictionary.createDictTree({dictObject: D_ORG, treeData: data_D_ORG_1, isLeaf: false, dictHiddenId: "zjj_ts_tsdwdm", dictShowId: "zjj_ts_tsdwmc", dictContainerReferenceObjectId: "zjj_bodyid"});
				});
				Dictionary.initDictionaryList({
						url : "dict/queryJlnrList.f",
						data : {"zdbh" : ''},
						dictShowId : "zjj_ts_tsnr",
						dictContainerReferenceObjectId: "zjj_bodyid"
					}, function() {
				}, function() {
					$("#zjj_ts_tsnr").val("");
					$("#zjj_ts_tsnrdm").val("");
				});
			}
			else if (0 == jqlx.split(",")[1])
			{
				$("#zjj_jqdw_dd").show();
				Zjj.PROBOXIDOBJECT = {'boxid':["zjj_jqdw_dd"]};
				Zjj.ADDOPTIONTYPE = "2";
			}
			else
			{
				$("#zjj_jqjl_dd").show();
				Zjj.PROBOXIDOBJECT = {'boxid':["zjj_jqjl_dd"]};
				Zjj.ADDOPTIONTYPE = "0";
				Dictionary.initDictionaryList({
						url : "dict/queryJlnrList.f",
						data : {"zdbh" : ''},
						dictShowId : "zjj_jl_jlnr",
						dictContainerReferenceObjectId: "zjj_bodyid"
					}, function() {
				}, function() {
					$("#zjj_jl_jlnr").val("");
					$("#zjj_jl_jlnrdm").val("");
				});
			}
		},
		/**
		 * 已定位未派警数据
		 * @param lcmc 流程名称
		 */
		initPersonnel : function(lcmc){
			// [支队代码] 初始化警员信息
			var sszddm = SysConfig.T_USER_LOGIN_ORGID_ZD;
			var ssdddm = '';
			// 初始化大队
			Zjj.initZzjgDict({type: 4, zzjgdm: sszddm, showId: 'zjj_' + lcmc + '_ssddmc', initVal: ''}, function(){
				ssdddm = SysTool.getTxtVal('zjj_' + lcmc + '_ssdddm');
				// 清空下拉框组件
				Zjj.clearSelectComponet(['zjj_' + lcmc + '_sszd', 'zjj_' + lcmc + '_jjmj']);
				// 初始化中队
				Zjj.initZzjgDict({type: 0, zzjgdm: ssdddm, showId: 'zjj_' + lcmc + '_sszdmc', initVal: ''}, function(){
					sszddm = SysTool.getTxtVal('zjj_' + lcmc + '_sszddm');
					Zjj.clearSelectComponet(['zjj_' + lcmc + '_jjmj']);
					// 初始化出警人员
					Zjj.initZzjgDict({type: 2, zzjgdm: sszddm, showId: 'zjj_' + lcmc + '_jjmjmc', initVal: ''}, function(){
					});
				});
			});
		},
		
		/**
		 * 清空指定选择组件
		 * @param ids 组件ID
		 */
		clearSelectComponet: function(ids){
			$.each(ids, function(i, id){
				$('#' + id + 'mc').val('');
				$('#' + id + 'dm').val('');
			});
		},
		/**
		 * 初始化组织机构字典
		 * @param param  请求参数
		 * @param callback 回调方法
		 */
		initZzjgDict : function(param, callback){
			var url = 'zzjg/pjZzjgdm.f';
			var type = param['type'];
			if(type == 2){
				url = 'zzjg/cjmj.f';
			}else if(type == 3){
				url = 'zzjg/allPersonnel.f';
			}
			else if (4 == type)
			{
				url = 'zzjg/getZzjgDd.f';
			}
			Dictionary.initDictionaryList({url: url, data: {"zdbh": '', "zzjgdm": param['zzjgdm']}, dictContainerReferenceObjectId: "zjj_bodyid", initVal: param['initVal'],dictShowId: param['showId']}, function() {
				if(typeof(callback) === 'function'){
					callback();
				}
			});
		},
		
		/**
		 * 辅助定位
		 */
		fzdw : function(){
			var lddm = SysTool.getTxtVal("zjj_lddm");
  			if ("" == lddm)
  			{
  				_MapApp.zoomTo(SysConfig.FZDW_ZOOM_LEVEL);
  				Zjj.getDwInfo();
  				return;
  			}
			/**
			 * 1、获取道路代码、路段代码
			 * 2、根据道路、路段代码查询道路图层并获取道路坐标点：
			 * 3、算法：
			 * 3.1、坐标点个数为奇数则取中间点坐标(1/2)。
			 * 3.2、坐标点个数为偶数：
			 * 3.2.1、小于等于2时取最后一个坐标点。
			 * 3.2.2、大于2时取中间坐标点减1所在的坐标点
			 * 4、道路上图并将警情定位到算出的坐标点上，并且闪烁2次道路。
			 */ 
			var aQuery = new QueryObject();
			aQuery.queryType = 6;
			aQuery.dispField = 'objectid,dldm';
			aQuery.addSubFields('objectid,dldm');
			aQuery.tableName = SysConfig.GIS_DB_USERNAME + '.' + SysConfig.JT_ROADSEGITEM_PL;
			aQuery.where = 'lddm=' + lddm;
			_MapApp.query(aQuery,
				function(vBIsOK, vRequestObj) {
					try {
						var features = new Array();
						var dwLayers = _MapApp.getQueryResult(vRequestObj);
						for ( var j = 0; j < dwLayers.length; j++) {
							if (dwLayers[j].tableName.toUpperCase() == aQuery.tableName.toUpperCase()) {
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
							
							var polyline = new Polyline(areastr, "#000079", 3, 0.5, "blue");
							_MapApp.addOverlay(polyline);
							polyline.flash(3);
							
							var points = areastr.split(',');
							var len = points.length;
							var limit = (len /2) / 2;
							limit = Math.ceil(limit);
							if((len / 2) % 2 != 0){
								limit = limit - 1;
							}
							var cdx = limit * 2, cdy = cdx + 1;
							var centerX = points[cdx], centerY = points[cdy];
							if(centerX != '' && centerY != ''){
								_MapApp.zoomTo(SysConfig.FZDW_ZOOM_LEVEL);
								SysTool.locateByXY(centerX, centerY);
								Zjj.LASTROADLAYERPOLYLINE = polyline;
							}
							features.destroy();
							dwLayers = null;
							delete dwLayers;
							
							Zjj.getDwInfo();
						}
					} catch (e) {
						SysTool.alert('道路定位出错： ' + e.message);
					}
			});
		},
		
		/**
		 * 鼠标右击事件
		 * @param e
		 */
		clickRightM : function(e){
//			$('body').bind("contextmenu",function(e){
//		         return false;
//		    });
		     if(e.which==3){

		       alert("鼠标右键触发事件");

		     }
		},
		
		/**
		 * 获得定位信息
		 */
		getDwInfo : function(){
			SysTool.window.hide();
			//$('body').live("mousedown",Zjj.clickRightM);
			/**
			 * 1、自动辖区定位
			 * 2、获取新坐标所属大队、中队：
			 * 2.1、如当前警情为派警则需要自动更重置警员所在大队、中队并更加新定位的单位加载警员。
			 * 2.2、判断当前用户是否为管理员，如果是管理员可以定位任意区域
			 * 2.3、当前登录用户非管理员，则定位只能够定位当前用户所在大队区域如果越区则给与提示。
			 * 3、更新当前警情定位后的新坐标到客户端。
			 * 4、更新当前警情定位后的坐标到数据表
			 */ 
			SysTool.getLocateXY(function(coord){
				var coords = coord.split(',');
				var pointX = coords[0];
				var pointY = coords[1];
				// 获取定位后的组织机构代码
				SysTool.getDwZdZzjg(pointX, pointY, function(mc, dm){
					var zddm = dm;
					if ("" != $.trim(zddm))
					{
						SysTool.ajax({url:'zzjg/getTZzjg.f',data:{"zzjgdm":zddm}}, function(data){
							var dddm = data.zzjg.ssjgdm;
							Zjj.dwsfgj(pointX, pointY, dddm, zddm);
						});
					}
					else
					{
						SysTool.getDwDdZzjg(pointX, pointY, function(zzjgArry){
							var dddm = zzjgArry[0];
							Zjj.dwsfgj(pointX, pointY, dddm);
						});
					}
				});
			});
		},
		
		/**
		 * 定位后的权限判断及后续操作
		 * @param pointX
		 * @param pointY
		 * @param dddm
		 * @param zddm
		 */
		dwsfgj : function(pointX,pointY,dddm,zddm){
			zddm = undefined == zddm ? "" : zddm;
			if (undefined == Zjj.CRRENTENABLEDD["DD"+dddm])
			{
				SysTool.confirm("<font color='red'>定位超出权限范围，</font>确定将警情定位在：" + pointX + "，" + pointY + ' 吗 ?', function(r){
					if (r)
					{
						Zjj.fudwst(pointX, pointY);
					}
					SysTool.window.show();
					Zjj.removeLastLayer();
					//$('body').die("mousedown",Zjj.clickRightM);
				});
			}
			else
			{
				SysTool.confirm('确定将警情定位在：' + pointX + "，" + pointY + ' 吗 ?', function(r){
					if (r)
					{
						Zjj.creatZzjgSelect(dddm, zddm);
						Zjj.fudwst(pointX, pointY, dddm, zddm);
					}else{
						Jqcz.hideLoateButton();//影藏关闭按钮 by pan
					}
					SysTool.window.show();
					Zjj.removeLastLayer();
					//$('body').die("mousedown",Zjj.clickRightM);
				});
			}
		},
		
		/**
		 * 辅助定位图上标点
		 */
		fudwst : function(pointX,pointY,dddm,zddm){
			$("#zjj_afdzx").val(pointX);
			$("#zjj_afdzy").val(pointY);
			if (undefined != dddm)
			{
				$("#zjj_jqssdddm").val(dddm);
				$("#zjj_jqsszddm").val(zddm);
			}
			
			Zjj.deleteFzdwMarker();
			//调用Jqxx上图
			var markerData = {};
			markerData['jqbh'] = Zjj.JQBH;
			markerData['afdzx'] = pointX;
			markerData['afdzy'] = pointY;
			markerData['jqzt']  = 2;
			Zjj.loadJqxxToMap({},{'list': [markerData]},function(returnMarkerArray){
				Zjj.LASTDWMARKER = returnMarkerArray[0];
			});
		},
		
		/**
		 * 加载到地图
		 * 
		 * @param {Object}
		 *            param JSON对象（包括：mapApp 地图对象，showDivId 显示警情信息DIV id。）
		 * @param {Object}
		 *            data JSON对象
		 */
		loadJqxxToMap : function(param, data, callback) {
			MapBubble.zoomToLevel(SysConfig.LOADJQXXTOMAP_ZOOM_LEVEL);
			var markerArray = new Array();
			for ( var i = 0; i < data.list.length; i++) {
				var jqxx = data.list[i];
				if (typeof(jqxx.isBeRelated) === 'undefined' || jqxx.isBeRelated == 0) {
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
				contentValue : "",
				contentCallback : "",
				titleShowEvent : "mouseover",
				bubbleWidth : 403,
				bubbleHeight : 352,
				moveMode : "movetobubblecenter"
			};
			var returnMarkerArray = Zjj.addMarker(markerParam);
			callback(returnMarkerArray);
		},
		
		/**
		 * 在地图上添加marker
		 * @param param 构造marker需要的各种参数json
		 */
		addMarker : function(param) {
			var icon, point, title, marker, markerArray = new Array();
			for ( var i = 0; i < param.markerArray.length; i++) {
				var makerParam = param.markerArray[i];
				if (makerParam.x == null || makerParam.x == ""
						|| makerParam.y == null || makerParam.y == "") {
					continue;
				}
				icon = new Icon();
				icon.image = ("undefined" == typeof makerParam.iconUrl ? "" : makerParam.iconUrl);
				icon.width = ("undefined" == typeof makerParam.iconWidth ? 30 : makerParam.iconWidth);
				icon.height = ("undefined" == typeof makerParam.iconHeight ? 30 : makerParam.iconHeight);
				icon.leftOffset = ("undefined" == typeof makerParam.iconLeftOffset ? 0 : makerParam.iconLeftOffset);
				icon.topOffset = ("undefined" == typeof makerParam.iconTopOffset ? 0 : makerParam.iconTopOffset);
				point = new Point(makerParam.x, makerParam.y);
				title = new Title(makerParam.titleName, 12, 7,"宋体","#575757", "#EFF0F6", "#767676", 1);
				marker = new Marker(point, icon, title);
				marker.hideTitle();
				_MapApp.addOverlay(marker);
				markerArray.push(marker);
			}
			return markerArray;
		},
		
		/**
		 * 警情投诉组织机构
		 */
		jqtsZzjgTree : function() {
			// 设置投诉人员
			Zjj.clearSelectComponet(['zjj_ts_tsry']);
			var zzjgdm = SysTool.getTxtVal('zjj_ts_tsdwdm');
			Zjj.initZzjgDict({type: 3, zzjgdm: zzjgdm, showId: 'zjj_ts_tsrymc', initVal: ''}, function(){});
		},
		
		/**
		 * 获得警情基础信息
		 */
		getJqxxBaseInfo : function(){
			//验证
			if (SysTool.validator.isEmpty("zjj_bjrxm", "报警人姓名不能为空！", "zjj_bjrxm"))
			{
				return null;
			}
			if ($("#zjj_bjdh").val() != "") {
				if (SysTool.validator.mobileFormat("zjj_bjdh"))
				{
					return null;
				}
			}
			var validIsBlank = SysTool.validator.isBlank([
			    {id: 'zjj_jqssdl', msg: '警情大类不能为空！', sId: 'zjj_jqssdl'},
			    {id: 'zjj_jqsszl', msg: '警情中类不能为空！', sId: 'zjj_jqsszl'},
			    /*{id: 'zjj_jqssxl', msg: '警情小类不能为空！', sId: 'zjj_jqssxl'},*/
			    {id: 'zjj_jqssdd', msg: '所属大队不能为空！', sId: 'zjj_jqssdd'},
			    {id: 'zjj_jqsszd', msg: '所属中队不能为空！', sId: 'zjj_jqsszd'}
			]);
			if (validIsBlank)
			{
				return null;
			}
			if (SysTool.validator.isEmpty("zjj_jqafdd", "案发地址不能为空！", "zjj_jqafdd"))
			{
				return null;
			}
			else
			{
				if (SysTool.getTxtVal("zjj_jqafdd").length > 200)
				{
					SysTool.tooltips('zjj_jqafdd', '案发地址不能超过200个字符！');
					return null;
				}
			}
			if (SysTool.validator.isEmpty("zjj_jqxx", "警情信息不能为空！", "zjj_jqxx"))
			{
				return null;
			}
			if ("" == SysTool.getTxtVal("zjj_jqlxmc"))
			{
				SysTool.tooltips('zjj_jqlxmc', '警情类型不能为空！', 'top');
				return null;
			}
			
			
			
			var param = {'zzjgzddm' : SysConfig.T_USER_LOGIN_ORGID_ZD};
			var pk,type;
			
			// 设置日期时间
			param['jqJjsj'] = SysTool.getTxtVal('zjj_jjsj');
			param['jqBjsj'] = SysTool.getTxtVal('zjj_bjsj');
			
			//报警
			var ipt = $('#zjj_bj_dl :input');
			$.each(ipt, function(i,key){
				pk = (($(key).attr('id')).split('_'))[1];
				if ("bjsj" != pk)
				{
					param[pk] = $(key).val();
				}
			});
			
			//警情
			var ipt = $('#zjj_jq_dl :input');
			$.each(ipt, function(i,key){
				type = $(key).attr('type');
				if ('hidden' == type)
				{
					pk = (($(key).attr('id')).split('_'))[1];
					param[pk] = $(key).val();
				}
			});
			delete param['deadcount'];
			delete param['hurtcount'];
			param['jqbh'] = Zjj.JQBH;
			param['jjtfh'] = SysTool.getTxtVal('zjj_jjtfh');
			param['jqafdd'] = SysTool.getTxtVal('zjj_jqafdd');
			param['jqxx'] = SysTool.getTxtVal('zjj_jqxx');
			param['lddm'] = SysTool.getTxtVal('zjj_lddm');
			param['ldmc'] = SysTool.getTxtVal('zjj_ldmc');
			param['jqlxdm'] = SysTool.getTxtVal('zjj_jqlxdm').split(',')[0];
			param['jqlxmc'] = SysTool.getTxtVal('zjj_jqlxmc');
			param['optiontype'] = Zjj.ADDOPTIONTYPE;
			
			
			
			
			
//			param['dxhurtcount'] = SysTool.getTxtVal('zjj_dxhurtcount');
			// 设置选中值
			param['sfswhcl'] = $('#zjj_sfswhcl').is(':checked') ? "1" : "0";
			param['ywrysw'] = $('#zjj_ywrysw').is(':checked') ? "1" : "0";
			param['sfsjtsgdsr'] = $('#zjj_sfsjtsgdsr').is(':checked') ? "1" : "0";
			param['ywty'] = $('#zjj_ywty').is(':checked') ? "1" : "0";
			
			param['ifschool'] = $('#zjj_ifschool').is(':checked') ? "1" : "0";
			param['ifmotor'] = $('#zjj_ifmotor').is(':checked') ? "1" : "0";
			param['iftaxi'] = $('#zjj_iftaxi').is(':checked') ? "1" : "0";
			param['ifpolice'] = $('#zjj_ifpolice').is(':checked') ? "1" : "0";
			param['ifelectric'] = $('#zjj_ifelectric').is(':checked') ? "1" : "0";
			param['ifdxhurt'] = $('#zjj_ifdxhurt').is(':checked') ? "1" : "0";
			
			param['ifdead'] = $('#zjj_ifdead').is(':checked') ? "1" : "0";
			param['ifhurt'] = $('#zjj_ifhurt').is(':checked') ? "1" : "0";
			
			
			
			
			
			
			// 增加伤亡人数
			
			
			if (param['ifhurt']> 0) {
				var hurtcount= SysTool.getTxtVal('zjj_hurtcount');
				if (hurtcount== "") {
					SysTool.tooltips('zjj_hurtcount', '请输入受伤人数！');
					 return null;
				}
				if (!Zjj.isInteger(hurtcount)){
				 SysTool.tooltips('zjj_hurtcount', '受伤人数必须为正整数！');
				 return null;
				}
				else{
				param['hurtcount'] = hurtcount;
				}
				}
			
			if (param['ifdead']> 0) {
				var deadcount =SysTool.getTxtVal('zjj_deadcount');
				if (deadcount== "") {
					SysTool.tooltips('zjj_deadcount', '请输入死亡人数！');
					 return null;
				}
				if (!Zjj.isInteger(deadcount)){
				 SysTool.tooltips('zjj_deadcount', '死亡人数必须为正整数！');
				 return null;
				}
				else{
				param['deadcount'] = deadcount;
				}
				}
				
			return param;
		},
		
		/**
		 * 保存接警信息
		 */
		addJqxx : function()
		{
			
			var param = Zjj.getJqxxBaseInfo();
			if (null == param)
			{
				return;
			}
			
		
			if ("0" == Zjj.ADDOPTIONTYPE)
			{
				if(SysTool.validator.isEmpty('zjj_jl_jlnr', '记录内容不能为空!'))
				{
					return;
				}
				var jlnr = SysTool.getTxtVal('zjj_jl_jlnr');
				param['jqzt'] = 5;
				param['nr'] = jlnr;
				
				SysTool.confirm('确认完成接警吗？', function(r){
					HTTPREQPARAM = {url: 'jqxx/addZhddJqxx.f', data: param};
					SysTool.ajax(HTTPREQPARAM, function(data){
						if("success" == data.result){
							SysTool.show("成功保存警情！");
							Zjj.closeWindow();
							Jqxx.beforeShowRemind({changeCount: 1, stateControlType: 5});
						}
						else
						{
							SysTool.show('警情保存失败！');
							Zjj.JQBH = SysTool.getDateTimeFormatNoSeparator(new Date().getTime()) + Math.floor(9000000*Math.random()+1000000);
						}
					});
				});
			}
			else if ("1" == Zjj.ADDOPTIONTYPE)
			{
				var tsdwdm = SysTool.getTxtVal('zjj_ts_tsdwdm');
				var tsdwmc = SysTool.getTxtVal('zjj_ts_tsdwmc');
				var tsrydm = SysTool.getTxtVal('zjj_ts_tsrydm');
				var tsrymc = SysTool.getTxtVal('zjj_ts_tsrymc');
				var tsnr = SysTool.getTxtVal('zjj_ts_tsnr');
				
				var empty = SysTool.validator.isBlank([
				    {id: 'zjj_ts_tsdwdm', msg: '投诉单位不能为空!', sId: 'zjj_ts_tsdwmc'},
				    {id: 'zjj_ts_tsnr', msg: '投诉内容不能为空!', sId: 'zjj_ts_tsnr'}
		        ]);
				if(empty){return;}
				
				tsrydm = (tsrydm.split(','))[0];
				param['jqzt'] = 5;
				param['nr'] = tsnr;
				param['ssjgdm'] = tsdwdm;
				param['ssjgmc'] = tsdwmc;
				param['ryid'] = tsrydm;
				param['rym'] = tsrymc;
				HTTPREQPARAM = {url: 'jqxx/addZhddJqxx.f', data: param};
				SysTool.confirm('确认完成接警吗？', function(r){
					if(r){
						SysTool.ajax(HTTPREQPARAM, function(data){
							if("success" == data.result){
								SysTool.show("成功保存警情！");
								Zjj.closeWindow();
								Jqxx.beforeShowRemind({changeCount: 1, stateControlType: 5});
							}
							else
							{
								SysTool.show('警情保存失败！');
								Zjj.JQBH = SysTool.getDateTimeFormatNoSeparator(new Date().getTime()) + Math.floor(9000000*Math.random()+1000000);
							}
						});
					}
				});
			}
			else if ("2" == Zjj.ADDOPTIONTYPE || "4" == Zjj.ADDOPTIONTYPE)
			{
				HTTPREQPARAM = {url: 'jqxx/addZhddJqxx.f', data: param};
				SysTool.confirm('确认完成接警吗？', function(r){
					if(r){
						SysTool.ajax(HTTPREQPARAM, function(data){
							if("success" == data.result){
								//定位上图
								Zjj.dwst(param);
								
								SysTool.show("成功保存警情！");
								Zjj.closeWindow();
								if ('' != param.afdzx && '' != param.afdzy)
								{
									Jqxx.beforeShowRemind({changeCount: 1, stateControlType: 2});
								}
							}
							else
							{
								SysTool.show('警情保存失败！');
								Zjj.JQBH = SysTool.getDateTimeFormatNoSeparator(new Date().getTime()) + Math.floor(9000000*Math.random()+1000000);
							}
						});
					}
				});
			}
			else 
			{
				// 警员编号结构为[jybh,jysfz,jydh,sbbh]
				var cjmjdm = SysTool.getTxtVal('zjj_sh_jjmjdm');
				var cjmjArry = cjmjdm.split(',');
				var cjmjmc = SysTool.getTxtVal('zjj_sh_jjmjmc');
				
				var valid = SysTool.validator.isBlank([
				    {id: 'zjj_sh_ssdddm', msg: '所属大队不能为空!', sId: 'zjj_sh_ssddmc'},
				    {id: 'zjj_sh_sszddm', msg: '所属中队不能为空!', sId: 'zjj_sh_sszdmc'},
				    {id: 'zjj_sh_jjmjdm', msg: '出警民警不能为空!', sId: 'zjj_sh_jjmjmc'}
				]);
				if(valid){ return;}
				
				var bcsm = SysTool.getTxtVal('zjj_sh_bz');
				var czfk = SysTool.getTxtVal('zjj_sh_czfk');
				if(czfk == ''){
					SysTool.tooltips('zjj_sh_czfk', '处置反馈不能为空!');
					return;
				}
				var jqbh = Zjj.JQBH;
				var crrentparam = {
					// 派警信息
					'jqbh': jqbh, 'jqcljhsjcm' : 'JHSJ002', 'jqcljhsjct': '派警', 'jqzt' : 5,
					'jqcljhtjcm' : 'JHTJ002', 'jqcljhtjct': '对讲机',
					'sjfqrdm': SysTool.getTxtVal('zjj_jjrbh'), 'sjfqrmc' : SysTool.getTxtVal('zjj_jjrxm'), 'sjfqrdh' : '',
					'sjxyrdm': cjmjArry[0], 'sjxyrmc' : cjmjmc, 'sjxyrdh' : cjmjArry[2], 'sjxyrsbbh' : cjmjArry[3], 'sjxyrhh' : cjmjArry[3],
					'jhhm' : cjmjArry[2], 'jhnr' : czfk,
					// 警情补充信息
					'jqxxbc' : bcsm
				};
				$.each(crrentparam,function(key,value){
					param[key] = value;
				});
				HTTPREQPARAM = {url: 'jqxx/addTZhddJqxxShbj.f', data: param};
				SysTool.confirm('确认完成接警吗？', function(r){
					if(r){
						SysTool.ajax(HTTPREQPARAM, function(data){
							if(data.status > 0){
								SysTool.show('成功保存警情！');
								Zjj.closeWindow();
								Jqxx.beforeShowRemind({changeCount: 1, stateControlType: 5});
							}
							else
							{
								SysTool.show('警情保存失败！');
								Zjj.JQBH = SysTool.getDateTimeFormatNoSeparator(new Date().getTime()) + Math.floor(9000000*Math.random()+1000000);
							}
						});
					}
				});
			}
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
		 * 关闭窗口
		 */
		closeWindow : function(){
			SysTool.window.close();
			Zjj.deleteFzdwMarker();
		},
		
		/**
		 * 重置地图Marker对象
		 */
		updateJqxxIcon : function(jqxx){
			MapBubble.removeCircle();
			MapBubble.removeAroundMarker();
			var arry = new Array();
			arry.push(jqxx);
			var data = {list : arry};
			Jqxx.loadJqxxToMap({}, data, function(markerArray){ 
				var marker = markerArray[0];
				Zjj.CURRMARKER = marker;
				MapBubble.currMarker = marker;
				//Jqxx.jqMarkerClickEvent(jqxx);
				marker.onclick();
				MapBubble.addPanOverListener(function(){ 
					MapBubble.currMarker = marker;
					$("#tipsContent").load("project/zhdd/pages/jqcz.jsp",function() {
						if ("2" == jqxx.jqzt)
						{
							MapBubble.initBubbleSize(405, 352);
						}
						Jqcz.openJqxxWindow(jqxx,function() {
							MapBubble.showBubble();
							MapBubble.setBubblePositionByMarker(MapBubble.currMarker);
						});
					});
				});
			});
		},
		
		/**
		 * 定位上图
		 */
		dwst : function(jaxx){ 
			if (null != Zjj.CURRMARKER)
			{
				_MapApp.removeOverlay(Zjj.CURRMARKER);
			}
			if (undefined != jaxx['jqzt'])
			{
				Jqxx.setNotInitCroodsJq(jaxx['jqssdddm'], function(point){
					/*jaxx['afdzx'] = point.x[0];
					jaxx['afdzy'] = point.x[1];*/
					jaxx['afdzx'] = point.x;
					jaxx['afdzy'] = point.y;
					Zjj.updateJqxxIcon(jaxx);
				});
			}
			else
			{
				if ('' == jaxx['afdzx'])
				{
					Jqxx.setNotInitCroodsJq(jaxx['jqssdddm'], function(point){
						/*jaxx['afdzx'] = point.x[0];
						jaxx['afdzy'] = point.x[1];*/
						jaxx['afdzx'] = point.x;
						jaxx['afdzy'] = point.y;
						jaxx['jqzt']  = 1;
						Zjj.updateJqxxIcon(jaxx);
					});
				}
				else
				{
					jaxx['jqzt']  = 2;
					Zjj.updateJqxxIcon(jaxx);
				}
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
		 * 选中checkbox
		 * checkbox的id
		 */
		checkboxSelected : function(id){
		
			if ("checked" == $("#"+id).attr("checked"))
			{
				
				$("#"+id).attr("checked",false);
			}
			else
			{
				$("#"+id).attr("checked","checked");
			}
		},
		
		
		
		/**
		 * 选中checkbox
		 * checkbox的id
		 */
		ifcheckboxSelected : function(id){
			
			var jlCheckbox = $("#zjj_ifhurt").attr('checked');
			var dxCheckbox = $("#zjj_ifdead").attr('checked');
			if ("checked" == jlCheckbox)
			{
				$("#zjj_if_sw_hurtcount").show();
				$("#zjj_if_dxhurtcount").show();
			}
			else{
			
				$("#zjj_if_sw_hurtcount").hide();
				$("#zjj_if_dxhurtcount").hide();
				$("#zjj_hurtcount").val("");
				$("#zjj_ifdxhurt").removeAttr("checked");
			}
			if ("checked" == dxCheckbox)
			{
				$("#zjj_if_sw_deadcount").show();
			}
			else{
				$("#zjj_if_sw_deadcount").hide();
				$("#zjj_deadcount").val("");
			}
			
		},

		
		/**
		 * 删除上一次道路层对象
		 */
		removeLastLayer : function(){
			var polyline = Zjj.LASTROADLAYERPOLYLINE;
			if(polyline != ''){ _MapApp.removeOverlay(polyline); }
		},
		
		/**
		 * 删除辅助定位中用以标定位置的marker
		 */
		deleteFzdwMarker : function(){
			if ("" != Zjj.LASTDWMARKER)
			{
				_MapApp.removeOverlay(Zjj.LASTDWMARKER);
			}
		},
		
		/**
		 * 打开自接警输入框
		 */
		openZjj : function(){
			Jqcz.hideLoateButton();//影藏关闭按钮 by pan
			SysTool.window.open({
				width : 420,
				height: 'auto',
				title : '接警',
				url : 'project/zhdd/pages/jqZjj.jsp'
				/*modal:false*/
			}, function(html){
				Zjj.initZjj();
			});
			SysTool.window.closeFunBind = function(){
				Zjj.deleteFzdwMarker();
				Jqcz.hideLoateButton();//影藏关闭按钮 by pan
			};
		},
		/**新定位 by pan*/
		newFzdw:function(){
			  //Zjj.fzdw();
			 Jqcz.showLoateButton();
			 $("#newLoateButton").click(function(){
				Zjj.fzdw();
			});
			SysTool.window.hide();
		}
};

