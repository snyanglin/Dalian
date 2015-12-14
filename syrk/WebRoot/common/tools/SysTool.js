/*!
 * 系统通用工具方法
 * http://jquery.com/
 * znjg - v1.0.0 (2014-03-12 09:30)
 * Copyright(c) 2014 founder
 */

/**
 * @classDescription 系统通用工具
 * @author lee
 */
var _MapApp;
var SysTool = {
		
	MSGICON : {
		INFO : 'info',
		ERROR: 'error',
		QUESTION: 'question',
		WARNING: 'warning'
	}, 
	
	/**
	 * jQuery ajax异步调用
	 * @param {Object} param JSON对象
	 * @param {Function} callback 回调方法
	 * 调用示例：
	 *     SysTool.ajax({
	 *     		url: 'getjqxx.f',
	 *     		data: {'jqbh':'123456'}		
	 *     }, function(data){
	 *     		// alert data
	 *     });
	 */
	ajax: function(param, callback){
		$.ajax({
		   type: "POST",
		   url: param.url,
		   data: param.data,
		   dataType: "JSON",
		   timeout: 50000,
		   success: function(data, status){
			   if($.isFunction(callback)){					   
				   callback(data, status);
			   }
		   },
		   error: function(request, status, err){
			   /*SysTool.alert("请求服务器超时!", SysTool.MSGICON.ERROR);
			   SysTimer.clearAllTimer();
			   MapBubble.removeAll();
			   SysTool.loading.unmask();*/
		   },
		   complete: function (XHR, TS) {
			   XHR = null;
			   TS = null;
			   try{
				   CollectGarbage();
			   }catch(e){}
			 } 
		});
	},
	
	/**
	 * getMapWidth 获取地图div框的宽度
	 * @param {String} mapDivId 地图div的id
	 */
	getMapWidth:function(mapDivId){
		return parseInt(document.getElementById(mapDivId).clientWidth);
	},
	
	/**
	 * 获取当前视窗的边框所对应的地图全图范围坐标
	 * @param map 地图对象
	 * @returns {String}
	 */
	getMapExtent:function(map){
		var bound=map.getBoundsLatLng();
		var extent=bound.minX+","+bound.minY+","+bound.maxX+","+bound.maxY;
		return extent;
	},
	
	/**
	 * 加载js
	 * @param src
	 * @param charset
	 */
	loadJs:function(src, charset){
		if(charset==null || charset=="" || typeof charset == undefined){
			charset = "utf-8";
		}
		document.writeln("<script type='text/javascript' src='"+src+"' charset='"+charset+"'></script>"); 
	},
	
	/**
	 * 自动加载公共组件文件（css或js）
	 * @param components {String} 组件名称
	 * @param name {String}或者{Array} 要调用的css文件名
	 * @param type {String} 文件扩展名
	 */
	loadComponentsFile:function(components,name,type){
		var str_css,str_js,componentsSrc;
        componentsSrc=$("script").eq(-1).attr("src").substr(0,$("script").eq(-1).attr("src").indexOf("js/"+components));
		if(type==".css"){
		if(typeof name ==="string"){
				if(componentsSrc!=""){
					str_css = "@import url("+componentsSrc+"css/"+name+type+");";
				}else{
					str_css = "@import url(css/"+name+type+");";
				}
			try { 
				var style = document.createStyleSheet();
				style.cssText = str_css;
				}catch (e) { 
					$("HEAD").append("<style type='text/css'>"+str_css+"</style>");
				}
		}else{
			str_css = new Array();
			for(var i=0;i<name.length;i++){
				if(componentsSrc!=""){
					str_css.push("@import url("+componentsSrc+"css/"+name[i]+type+");");
				}else{
					str_css = "@import url(css/"+name[i]+type+");";
				}
				try { 
					var style = document.createStyleSheet();
					style.cssText = str_css[i];
					}catch (e) { 
						$("HEAD").append("<style type='text/css'>"+str_css[i]+"</style>");
					}
			}
		} 
		
		}else{
			if(typeof name ==="string"){
				if(componentsSrc!=""){
					str_js = componentsSrc+"js/"+name+type;
				}else{
					str_js = "js/"+name+type;
				}
				
				try { 
					$("HEAD").append("<script type='text/javascript' src='"+str_js+"'></script>");
				}catch (e) { 
						SysTool.alert("引入"+name+" js文件失败");
					}
			}else{
				str_js = new Array();
				for(var i=0;i<name.length;i++){
					if(componentsSrc!=""){
						str_js.push(componentsSrc+"js/"+name[i]+type);
					}else{
						str_js.push("js/"+name[i]+type);
					}
					
					try { 
						$("HEAD").append("<script type='text/javascript' src='"+str_js[i]+"'></script>");
					}catch (e) { 
							SysTool.alert("引入"+name+" js文件失败");
						}
				}
			} 
		}
	},
	
	/**
	 * 获取Input输入框的值
	 * @param id 组件Id
	 * @returns 值(去空格之后)
	 */
	getTxtVal : function(id){
		return $.trim($('#'+id).val());
	},
	
	/**
	 * 设置指定组件值(txt)
	 * @param id   组件ID
	 * @param val  值
	 */
	setTxtVal : function(id, val){
		$('#' + id).val(val);
	},
	
	/**
	 * 获取当前日期
	 * @param dt 日期
	 * @returns {String} 年月日字符串
	 */
	getDateFormat : function(dt){
		var date = new Date(dt);
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		return year + "-" + month + "-" + day;
	},
	
	/**
	 * 通过毫秒数获取日期字符串（格式：2014-3-9 1:01）
	 * 
	 * @param milliseconds 毫秒数
	 * @returns {String} 年月日时分字符串
	 */
	getDateTimeFormatNoSecond : function(milliseconds) {
		var date = new Date(milliseconds);
		var dateString = date.getFullYear() + "-";// 获取年
		dateString += (date.getMonth() + 1) + "-";// 获取月
		dateString += date.getDate();// 获取日
		dateString += " " + date.getHours() + ":";// 获取时
		dateString += date.getMinutes() < 10 ? ("0" + date.getMinutes()) : date
				.getMinutes();// 获取分

		return dateString;
	},
	
	/**
	 * 获取当前时间
	 * @param dt 日期
	 * @param isNeedYear 是否需要显示年月日
	 * @returns {String} 年月日时分秒字符串
	 */
	getDateTimeFormat : function(dt,isNeedYear){
		var date = new Date();
		if(dt != null){
			date = new Date(dt);
		}
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		if(month < 10){ month = '0' + month;}
		var day = date.getDate();
		if(day < 10){ day = '0' + day; }
		var hh = date.getHours();
		if(parseInt(hh) < 10){hh = '0' + hh;}
		var mm = date.getMinutes();
		if(parseInt(mm) < 10){mm = '0' + mm;}
		var ss = date.getSeconds();
		if(parseInt(ss) < 10){ss = '0' + ss;}
		if(arguments.length>1)
			return hh + ":" + mm + ":" + ss;
		else
			return year + "-" + month + "-" + day + " " + hh + ":" + mm + ":" + ss;
			
	},
	
	/**
	 * 获取当前时间
	 * @param dt 日期
	 * @returns {String} 年月日时分秒字符串
	 */
	getCurrentMonthDateTime: function(dt){
		var date = new Date();
		if(dt != null){
			date = new Date(dt);
		}
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		if(month < 10){ month = '0' + month;}
		return year + "-" + month + "-01 00:00:01";
	},
	
	/**
	 * 获取当前日期
	 * @param dt 日期
	 * @returns {String} 年月日
	 */
	getDateFormat : function(dt){
		var date = new Date();
		if(dt != null){
			date = new Date(dt);
		}
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		if(month < 10){ month = '0' + month;}
		var day = date.getDate();
		if(day < 10){ day = '0' + day; }
		return year + "-" + month + "-" + day;
	},
	/**
	 * 获取同比日期。
	 * 如2015-4-16同比日期为2015-4-15
	 * @param dt
	 */
	getTbDate:function(dt) { 
	  var arr = dt.split('-');
      var year = arr[0]; //获取当前日期的年份
      var month = arr[1]; //获取当前日期的月份
      var day = arr[2]; //获取当前日期的日
      var yesterday_milliseconds=new Date(year,month,day).getTime()-1000*60*60*24;        
	  var yesterday = new Date();        
      yesterday.setTime(yesterday_milliseconds);        
		         
	    var strYear = yesterday.getFullYear();     
	    var strDay = yesterday.getDate();
	    strDay=strDay<10?"0"+strDay:strDay;
	    var strMonth = yesterday.getMonth();   
	    if(strMonth<10)     
	    {     
	        strMonth="0"+strMonth;     
	    }     
	    var datastr = strYear+"-"+strMonth+"-"+strDay;   
	    return datastr; 
	},
	/**
	 * 获取环比日期
	 * 如2015-4-16同比日期为2015-3-16
	 * @param dt
	 */
	getHbDate:function(dt) {
	  var arr = dt.split('-');
      var year = arr[0]; //获取当前日期的年份
      var month = arr[1]; //获取当前日期的月份
      var day = arr[2]; //获取当前日期的日
      var days = new Date(year, month, 0);
      days = days.getDate(); //获取当前日期中月的天数
      var year2 = year;
      var month2 = parseInt(month) - 1;
      if (month2 == 0) {
          year2 = parseInt(year2) - 1;
          month2 = 12;
      }
      var day2 = day;
      var days2 = new Date(year2, month2, 0);
      days2 = days2.getDate();
      if (day2 > days2) {
          day2 = days2;
      }
      if (month2 < 10) {
          month2 = '0' + month2;
      }
      var t2 = year2 + '-' + month2 + '-' + day2;
      return t2;
	},
	/**
	 * 时间字符串转换为时间，格式：2013-3-3 10:12:12
	 * @param dateStr 时间字符串
	 * @returns {Date}
	 */
	getDateToString : function (dateStr)
	{
		var arraystart1 = dateStr.split(" ")[0].split("-");
		var arraystart2 = dateStr.split(" ")[1].split(":");
		var date = new Date(arraystart1[0],parseInt(arraystart1[1],10)-1,arraystart1[2],arraystart2[0],arraystart2[1],arraystart2[2]);
		return new Date(date.getTime());
	},
	
	/**
	 * 地图初始化
	 * @param {Object} param JSON对象（包括：mapContainerId 地图容器id和当前登录者的组织机构代码）
	 * @param {Function} 回调函数
	 */
	initMap:function(param, callbackFunc) {
		if (typeof EzMap == "undefined") {
			window.setTimeout(function(){
				this.initMap();
			}, 100);
			return;
		}
		if (_compatIE()) {
			$("#" + param.mapContainerId).append('<div class="div_map" id="pgis_map"></div>');
			_MapApp = new EzMap(document.getElementById("pgis_map"));
			if (_MapApp.initialize) {
				_MapApp.initialize();
			}
			var pOverview = new OverView();
			pOverview.height = 200;
			pOverview.width = 200;
			pOverview.minLevel = 8;
			pOverview.maxLevel = 10;
			_MapApp.addOverView(pOverview);
			_MapApp.zoomTo(SysConfig.MAPINIT_ZOOM_LEVEL);
			_MapApp.hideMapServer();
			_MapApp.hideCopyright();
			/*yichu begin*/
			_MapApp.addMapEventListener(EzEvent.MAP_MOUSEMOVE, function(e) {
				window.status = "X:" + e.mapPoint.x + "  Y:" + e.mapPoint.y;
			});
			/*yichu end*/
		} else if (_MapApp == null) {
			var pEle=document.getElementById("pgis_map");
			pEle.innerHTML = "<p>EzMap地图引擎不支持您使用的浏览器!</p>";
		}
		callbackFunc(_MapApp);
	},
	/*initMap:function(param, callbackFunc) {
		if (typeof EzMap == "undefined") {
			window.setTimeout(function(){
				this.initMap();
			}, 100);
			return;
		}
		
		if (_compatIE()) {
			$("#" + param.mapContainerId).append('<div class="div_map" id="pgis_map"></div>');
			_MapApp = new EzMap(document.getElementById("pgis_map"));
			if (_MapApp.initialize) {
				_MapApp.initialize();
			}
			var pOverview = new OverView();
			pOverview.height = 200;
			pOverview.width = 200;
			pOverview.minLevel = 8;
			pOverview.maxLevel = 10;
			_MapApp.addOverView(pOverview);
			_MapApp.hideMapServer();
			_MapApp.hideCopyright();
			//组织机构代码
			 var zzjgdm=param.zzjgdm;
		  //获取机构边界坐标
			GeoQuery.getOrganizationBoundaryCoordinates(zzjgdm, function(returnData) {
				//通过组织机构边界坐标,定位辖区
				 (function xqdw(zzjgdm,xqzb) {  
					 if(zzjgdm.indexOf("00000000")>0) {  
						 //登录者为支队人员，调整地图等级为11
						_MapApp.zoomTo(11); 
					 }else if(zzjgdm.indexOf("000000")>0){ 
						 //登录者为大队，调整地图等级为14
						 _MapApp.zoomTo(14);
						 if(xqzb) { 
							 var pPolygon=new Polygon(xqzb,"#ff00FF", 3,0.5,"blue");  
							 //获取包络中点
							 var center=pPolygon. getMBR().centerPoint(); 
							 //地图对中
							 _MapApp.centerAtLatLng(center);
						 }
					 }else if(zzjgdm.indexOf("00")>0){ 
						 //登录者为中队，调整地图等级为17
						 _MapApp.zoomTo(17);
						 if(xqzb) { 
							 var pPolygon=new Polygon(xqzb,"#ff00FF", 3,0.5,"blue");
							 //获取包络中点
							 var center=pPolygon. getMBR().centerPoint(); 
							 //地图对中
							 _MapApp.centerAtLatLng(center);
						 }
					 }
				 })(zzjgdm,returnData);
			});
		} else if (_MapApp == null) {
			var pEle=document.getElementById("pgis_map");
			pEle.innerHTML = "<p>EzMap地图引擎不支持您使用的浏览器!</p>";
		}
		callbackFunc(_MapApp);
	},*/
	/**
	 * alert提示框
	 * @param msg 提示信息
	 * @param icon 提示图标
	 */
	alert: function(msg, icon){var ic = SysTool.MSGICON.INFO; if(typeof(icon) !== 'undefined'){ ic = icon; } $.messager.alert('系统提示', msg, ic); },
	/**
	 * confirm 提示框
	 * @param msg 提示信息
	 * @param fn 回调函数
	 */
	confirm : function(msg, fn){$.messager.confirm('系统提示', msg, function(r){fn(r);});},
	/**
	 * alert提示框
	 * @param msg 提示信息
	 */
	show : function(msg){ $.messager.show({title: '系统提示', msg: msg, timeout: 5000, showType: 'slide' });},
	/**
	 * 提示工具
	 * @param id  组件ID
	 * @param msg 提示消息
	 * @param pos 显示位置[pos可省略，默认为right]
	 */
	tooltips : function(id, msg, pos, isFocus){
		var position = 'right';
		if (typeof (pos) !== 'undefined') { position = pos; }
		$('#' + id).tooltip({
			position : position,
			content : '<span style="padding:0 3px;color:#000">' + msg + '</span>',
			onShow : function() {
				$(this).tooltip('tip').css({
					backgroundColor : '#fffcf6',
					borderColor : '#ff7c00',
					boxShadow : '1px 1px 3px #292929'
				});
				setTimeout(function() { $('.tooltip, .tooltip-right').hide(); }, 3000);
			}
		});
		var focus = (typeof (isFocus) === 'undefined') ? true : isFocus;
		if (focus) { $('#' + id).focus(); }
		$('#' + id).tooltip('show');
	},
	/**
	 * 获取当前时间 20130303121212
	 * @param dt 日期
	 * @returns {String} 年月日时分秒字符串
	 */
	getDateTimeFormatNoSeparator : function(dt){
		var date = new Date(dt);
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		var hh = date.getHours();
		if (month < 10) { month = '0' + month; }
		if (hh < 10) { hh = '0' + hh; }
		var mm = date.getMinutes();
		if (mm < 10) { mm = '0' + mm; }
		var ss = date.getSeconds();
		if (ss < 10) { ss = '0' + ss; }
		return "" + year + month + day + hh + mm + ss;
	},
	/**
	 * 客户端验证器
	 */
	validator : {
		REG_DATE : /^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)\s(([01]?[0-9])|(2[0-3])):[0-5]?[0-9]:[0-5]?[0-9]$/,
		isEmpty : function(id, msg, showId){
			var txt = SysTool.getTxtVal(id);
			var message = '内容不能为空！';
			if (typeof (msg) !== 'undefined') { message = msg; }
			if (typeof (showId) !== 'undefined') { id = showId; }
			if (txt == '') { SysTool.tooltips(id, message); return true; }
			return false;
		},
		isBlank : function(els){
			var isBlank = false;
			var json = {};
			for ( var i = 0; i < els.length; i++) {
				json = els[i];
				isBlank = SysTool.validator.isEmpty(json.id, json.msg, json.sId);
				if (isBlank) { return isBlank; }
			}
			return isBlank;
		},
		mobileFormat : function(id){
			var vaild = false;
			var reg = /^(1(3|5|8)[\d]{9})|(^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)$/;
			var val = SysTool.getTxtVal(id);
			if(!reg.test(val)){ vaild = true; SysTool.tooltips(id, '电话号码格式错误(支持手机、座机)！'); }
			return vaild;
		},
		maxLength : function(id, max){
			var txt = SysTool.getTxtVal(id);
			if(txt.length > max){ SysTool.tooltips(id, '内容长度不能超过' + max + '个字符！'); $('#' + id).focus(); return true;} else { return false; }
		},
		dateFormater: function(id){
			var vaild = false;
			// 格式为 年-月-日 时:分:秒
			var txt = SysTool.getTxtVal(id);
			if(!SysTool.validator.REG_DATE.test(txt)){ SysTool.tooltips(id, '日期格式有误(格式为：yyyy-mm-dd hh:mm:ss)！');  vaild = true; }
			return vaild;
		},
		isNumber : function(els){
			var vaild = false;
			var reg = /^[0-9]*[1-9][0-9]*$/;
			var json = {};
			var message = '必须为正整数！';
			for (var i = 0; i < els.length; i++){
				json = els[i];
				var val = SysTool.getTxtVal(json["id"]);
				if(!reg.test(val)){
					vaild = true;
					if(typeof(json["msg"]) !== 'undefined'){ message = json["msg"]; }
					SysTool.tooltips(json["id"], message);
					return vaild;
				}
			}
			return vaild;
		}
	},
	/**
	 * 获取点定位的xy坐标
	 * @param fn 回调函数
	 */
	getLocateXY : function(fn) {
		if (typeof fn == 'function') {
			_MapApp.changeDragMode('drawPoint', null, null, fn);
		} else {
			SysTool.alert('函数getLocateXY的参数必须是一个方法!');   
		}
	},
	/**
	 * 根据XY坐标进行定位
	 * @param pointX X坐标
	 * @param pointY Y坐标
	 */
	locateByXY : function(pointX, pointY) {
		if (pointX && pointY) {
			_MapApp.centerAtLatLng(Number(pointX), Number(pointY));
		} else {
			SysTool.alert('传入坐标有误!');
		}
	},
	/**
	 * 获取大队组织机构
	 * @param pointX   x坐标
	 * @param pointY   y坐标
	 * @param callback 回调
	 */
	getDwDdZzjg : function(pointX, pointY, callback){
		SysTool.getXqDm(pointX, pointY, function(vok, vRequestObj) {
			var zzjg = SysTool.getZzjgDm(vok, vRequestObj);
			if (zzjg && zzjg != null) {
				// var display = zzjg[1];// 警局
				// var sharp = zzjg[2];// 范围
				// 画出辖区
				//SysTool.drawXqfw(display, sharp, vRequestObj);
				if(typeof(callback) == 'function'){
					callback(zzjg);
				}
			}
		});		
	},
	/**
	 * 获取中队组织机构
	 * @param pointX   x坐标
	 * @param pointY   y坐标
	 * @param callback 回调
	 */
	getDwZdZzjg : function(pointX, pointY, callback) {
		var zdQuery = new QueryObject();
		zdQuery.queryType = 5;
		zdQuery.tableName = SysConfig.GIS_DB_USERNAME + '.' + SysConfig.XQCX_ZD_TABLENAME;
		zdQuery.dispField = 'objectid';
		zdQuery.addSubFields('objectid,mc,dm');
		zdQuery.coords = pointX + "," + pointY;
		zdQuery.radius = "1";
		zdQuery.unit = "meter";
		zdQuery.coordsType = "point";
		_MapApp.clearLayers();
		_MapApp.query(zdQuery, function(vBIsOK, vRequestObj) {
			var features = new Array();
			var mc = null;
			var dm = null;
			var zddwLayers = _MapApp.getQueryResult(vRequestObj);
			for ( var j = 0; j < zddwLayers.length; j++) {
				if (zddwLayers[j].tableName.toUpperCase() == zdQuery.tableName.toUpperCase()) {
					features = zddwLayers[j].features;
				}
			}
			var ilength = features.length;
			if (ilength >0){
				for ( var i = 0; i < ilength; i++) {
					var zddwftrObj = features[i];
					mc = zddwftrObj.fieldValues[SysConfig.JQDW_DWXQ[0]];
					dm = zddwftrObj.fieldValues[SysConfig.JQDW_DWXQ[1]];
				}
			}
			if(typeof(callback) == 'function'){
				callback(mc, dm);
			}
		});
	},
	
	/**
	 * 获取中队组织机构
	 * @param pointX   x坐标
	 * @param pointY   y坐标
	 * @param callback 回调
	 */
	getDwZdZzjgNew : function(pointX, pointY, callback) {
		var zdQuery = new QueryObject();
		zdQuery.queryType = 5;
		zdQuery.tableName = SysConfig.GIS_DB_USERNAME + '.' + SysConfig.XQCX_ZD_TABLENAME;
		zdQuery.dispField = 'objectid';
		zdQuery.addSubFields('objectid,mc,dm,ssjgdm');
		zdQuery.coords = pointX + "," + pointY;
		zdQuery.radius = "1";
		zdQuery.unit = "meter";
		zdQuery.coordsType = "point";
		_MapApp.clearLayers();
		_MapApp.query(zdQuery, function(vBIsOK, vRequestObj) {
			var features = new Array();
			var mc = null;
			var dm = null;
			var ssjgdm = null;
			var zddwLayers = _MapApp.getQueryResult(vRequestObj);
			for ( var j = 0; j < zddwLayers.length; j++) {
				if (zddwLayers[j].tableName.toUpperCase() == zdQuery.tableName.toUpperCase()) {
					features = zddwLayers[j].features;
				}
			}
			var ilength = features.length;
			if (ilength >0){
				for ( var i = 0; i < ilength; i++) {
					var zddwftrObj = features[i];
					mc = zddwftrObj.fieldValues[SysConfig.JQDW_DWXQ[0]];
					dm = zddwftrObj.fieldValues[SysConfig.JQDW_DWXQ[1]];
					ssjgdm = zddwftrObj.fieldValues[SysConfig.JQDW_DWXQ[2]];
				}
			}
			if(typeof(callback) == 'function'){
				callback(dm, mc, ssjgdm);
			}
		});
	},
	
	/**
	 * 获取辖区代码
	 * @param pointX  x坐标
	 * @param pointY  y坐标
	 * @param fn      回调
	 */
	getXqDm : function(pointX, pointY, fn) {
		var pQuery = new QueryObject();
		pQuery.queryType = 3;
		pQuery.tableName = SysConfig.GIS_DB_USERNAME + '.' + SysConfig.XQCX_DD_TABLENAME;
		pQuery.filtershape = 'shape';
		pQuery.layerName = "ssxq";
		pQuery.beginrecord = 1;
		pQuery.featurelimit = 10;
		pQuery.dispField = "MC";
		pQuery.coords = pointX + "," + pointY + ",0.00001";
		pQuery.addSubFields("MC:MC;DM:DM;SHAPE:SHAPE;");
		_MapApp.clearLayers();
		_MapApp.query(pQuery, fn);
	},
	/**
	 * 获取组织机构代码
	 * @param vok  
	 * @param vRequestObj
	 * @returns
	 */
	getZzjgDm : function(vok, vRequestObj) {
		var pLayers = _MapApp.getQueryResult(vRequestObj);
		var policeAreaName = "0";
		var policeAreaCode = "0";
		var sharp = null;
		for ( var i = 0; i < pLayers.length; i++) {
			var features = pLayers[i].features;
			for ( var j = 0; j < features.length; j++) {
				var ftrObj = features[j];
				policeAreaName = ftrObj.dispname;
				policeAreaCode = ftrObj.fieldValues[1];
				sharp = ftrObj.linestr;
			}
		}
		// 设置警情任务时的所属辖区名称
		var array = new Array();
		if (policeAreaCode != 0 && policeAreaCode) {
			array.push(policeAreaCode);
			array.push(policeAreaName);
			array.push(sharp);
			return array;
		}
		return null;
	},
	
	/**
	 * 图片展示
	 * @param srcStr 图片地址字符串，多个以英文“;”隔开
	 * @param titleStr 图片名称字符串，多个以英文“;”隔开，需要与地址一一对应
	 */
	showPicture : function(windowTitle,srcStr,titleStr){
		if (undefined == windowTitle || "" == $.trim(windowTitle))
		{
			windowTitle = "照片";
		}
		if (undefined == srcStr || "" == $.trim(srcStr))
		{
			srcStr = "common/components/pictureshow/img/notfound.png";
		}
		if (undefined == titleStr || "" == $.trim(titleStr))
		{
			titleStr = "没有照片";
		}
		
		SysTool.window.open({
			width : 807,
			height: 527,
			title : windowTitle,
			modal : false,
			url : 'common/components/pictureshow/pictureshow.jsp?srcStr='+srcStr+'&titleStr='+titleStr,
			style : 'overflow: hidden;'
		}, function(html){
			PicShow.initFun(srcStr, titleStr);
		});
	},
	
	changeIputStyle : function(){
		$(".all_inputtext,.all_slect,textarea").bind("focus", function() {
			$(this).addClass("all_inputfocus");
		}).focusout(function() {
			$(this).removeClass("all_inputfocus");
		});
		$(".tips .tips_showdl dd textarea").bind("focus", function() {
			$(this).addClass("textareafocus");
		}).focusout(function() {
			$(this).removeClass("textareafocus");
		});
		$(".inputtext,.tips_slect,textarea").bind("focus", function() {
			$(this).addClass("inputfocus");
		}).focusout(function() {
			$(this).removeClass("inputfocus");
		});
	},
	/**
	 * 数据加载中提示
	 */
	loading : {
		mask : function(id, left, top){
			var lt = (undefined == left) ? '50%' : left;
			var tp = (undefined == top) ? '50%' : top;
			var div = $("#" + id);
			div.append($("<div id='datagrid-mask' class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:'100%'}));
		    $("<div id='datagrid-mask-msg' class=\"datagrid-mask-msg\"></div>").html("请稍后,数据加载中...").appendTo(div).css({display:"block",left:lt,top:tp});
		},
		unmask : function(){
			$("#datagrid-mask").remove();
			$("#datagrid-mask-msg").remove(); 
		}
	},
	/**
	 * 弹出窗口
	 */
	window : {
		/**
		 * 关闭窗口时执行的方法，如需设值，请务必在调用open方法之后
		 */
		closeFunBind : '',
		
		/**
		 * 打开窗口
		 */
		open : function(param, callback){
			try{$('#allwindowshadow').remove();}catch(e){}
			var contaniner=$("#tips_allwindow");
			var txt = '<a href="javascript:void(0);" title="关闭" onclick="SysTool.window.close();"  class="tips_close" id="close_allwindow"></a>';
			txt += '<div class="tips_top"><div class="tips_title" id="title_allwindow"><strong style="padding:0 5px;" id="text_allwindow">' + param.title + '</strong></div></div>';
			txt += '<div class="tips" id="Content_allwindow"></div>';
			txt += '<div class="tips_bt"></div>';
			contaniner.html(txt);
			contaniner.attr({ "class":"easyui-draggable tipsbdy", "data-options":"handle:'#title_allwindow'"});
			var height = (param.height === 'auto') ? 385 : param.height;
			contaniner.css({
				width:param.width,
				height:height,
				top:($(window).height() - height) / 2,
				left:($(window).width() - param.width) / 2,
				"max-width":900,
				"z-index":1999
			});
			var modal = SysTool.tool.isUndefined(param.modal) ? true : false;
			if(modal){				
				contaniner.after('<div class="allwindowshadow" id="allwindowshadow"></div>');
				$("#allwindowshadow").css({ width:$(window).width(), height:$(window).height() });
			}
			contaniner.show();
			if(SysTool.tool.isUndefined(param.url)){
				$("#Content_allwindow").html(param.html);
				if(SysTool.tool.isFunction(callback)){ callback(); }
				try{
					jQuery.parser.parse();
				}catch(e){}
			}else{
				var width = parseInt($('#Content_allwindow').width() / 2) - 50;
				SysTool.loading.mask('Content_allwindow', width, 20);
				$("#Content_allwindow").load(param.url,function(html){
					if(SysTool.tool.isFunction(callback)){
						callback(html); 
						SysTool.loading.unmask();
					} else {
						SysTool.loading.unmask();
					}
					try{
						jQuery.parser.parse();
					}catch(e){}
				});
			}
			//初始化关闭窗口时执行的方法
			this.closeFunBind = '';
		},
		close : function(){
			//$("#Content_allwindow").empty();
			$("#Content_allwindow").html('');
			$("#tips_allwindow").hide();
			//MapBubble.removeAll();
			try{$('#allwindowshadow').remove();}catch(e){}
			if (SysTool.tool.isFunction(this.closeFunBind)) {this.closeFunBind();}
		},
		show : function(){ $("#tips_allwindow").show();	try{$("#allwindowshadow").show();}catch(e){}},
		hide : function(){ $("#tips_allwindow").hide();	try{$("#allwindowshadow").hide();}catch(e){}}
	},
	tool : {
		/**
		 * 设置组件是选中
		 * @param id 组件id
		 * @param isChecked  true选中 false未选中
		 * @param marker true设置选中
		 */
		setChecked : function(id, isChecked, marker) {
			var checked = false;
			if (SysTool.tool.isUndefined(isChecked)) {
				checked = $('#' + id).is(':checked');
				checked = !checked;
			} else {
				checked = isChecked;
				checked = $('#' + id).is(':checked');
				// if (SysTool.tool.isUndefined(marker)) {
				// }
			}
			if (checked) {
				$('#' + id).attr("checked", true);
				$('#' + id).val(1);
			} else {
				$('#' + id).removeAttr("checked");
				$('#' + id).val(0);
			}
		},
		/**
		 * 判断是否为undeinfed
		 * @param obj         验证对象
		 * @returns {Boolean} 验证结果 
		 */
		isUndefined : function(obj){
			var isUndefined = false;
			if (typeof (obj) === 'undefined') { isUndefined = true; }
			return isUndefined;
		},
		/**
		 * 判断是否为function
		 * @param func        验证对象
		 * @returns {Boolean} 验证结果 
		 */
		isFunction : function(func){
			var isFunction = false;
			if (typeof (func) === 'function') { isFunction = true; }
			return isFunction;
		}
		
	},
	setContentHeight : function() {
		var bodyerht = $("body").height();
		$(".load_lf").height(bodyerht);
		$(".load_rt").height(bodyerht);
	},
	detailWindow:{
		/**
		 * 关闭窗口时执行的方法，如需设值，请务必在调用open方法之后
		 */
		closeFunBind : '',
		
		/**
		 * 打开窗口
		 */
		open : function(param, callback){
			var contaniner=$("#tips_infowindow");
			var txt = '<a href="javascript:void(0);" title="关闭" onclick="SysTool.detailWindow.close();"  class="tips_close" id="close_infowindow"></a>';
			txt += '<div class="tips_top"><div class="tips_title" id="title_infowindow"><strong style="padding:0 5px;" id="text_infowindow">' + param.title + '</strong></div></div>';
			txt += '<div class="tips" id="Content_infowindow"></div>';
			txt += '<div class="tips_bt"></div>';
			contaniner.html(txt);
			contaniner.attr({ "class":"easyui-draggable tipsbdy", "data-options":"handle:'#title_infowindow'"});
			var height = (param.height === 'auto') ? 385 : param.height;
			contaniner.css({
				width:param.width,
				height:param.height,
				top:($(window).height() - height) / 2,
				left:($(window).width() - param.width) / 2,
				"max-width":900,
				"z-index":1999
			});
			var modal = (typeof(param.modal) === 'undefined') ? true : false;
			if(modal){				
				contaniner.after('<div class="allwindowshadow" id="infowindowshadow"></div>');
				$("#infowindowshadow").css({
					width:$(window).width(),
					height:$(window).height()
				});
			}
			if(SysTool.tool.isUndefined(param.url)){
				$("#Content_infowindow").html(param.html);
				if(SysTool.tool.isFunction(callback)){
					callback();
				}
				contaniner.show();
			}else{
				$("#Content_infowindow").load(param.url,function(html){
					if($.isFunction(callback)){
						callback(html);
					}
					contaniner.show();
				});
			}
			//初始化关闭窗口时执行的方法
			this.closeFunBind = '';
		},
		close : function(){
//			$("#Content_infowindow").empty();
			$("#Content_infowindow").html('');
			$("#tips_infowindow").hide();
			try{$("#infowindowshadow").remove();}catch(e){}
			if ($.isFunction(this.closeFunBind)) {
				this.closeFunBind();
	    	}
		},
		show : function(){
			$("#tips_infowindow").show();
			try{$("#infowindowshadow").show();}catch(e){}
		},
		hide : function(){
			$("#tips_infowindow").hide();
			try{$("#infowindowshadow").hide();}catch(e){}
		}
	},
	/**
	 * 取得机构点位
	 * @param jgdm
	 * @param callback
	 */
	getJgPoint : function(jgdm, callback){
		var extent = SysTool.getMapExtent(_MapApp);
		var width = SysTool.getMapWidth("pgis_map");
		var where = ["GXDWDM = '" + jgdm + "'"];
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
			}
			callback(point);
		});
	},
	
	/**
	 * 分页
	 */
	pagination : {
		total : 0,
		pnum : 1,
		pages : 0,
		paginationObj : null,
		init : function(total, count, showId, callback){			
			SysTool.pagination.total = total;
			SysTool.pagination.pnum = 1;
			var curtPage = 1;
			var txt = '', min = 0, max = count;
			var json = {};
			if(total > 0){
				SysTool.pagination.pages = Math.ceil(parseInt(total) / count);
				txt += '<div class="new_alarm" style="height:20px;padding:2px 4px;margin-top:-10px;padding-bottom: 15px;">';
				txt += '<span class="pageCount" id="fxyp_zhcx_cxzj">共有' + total + '条</span><a class="btn_pagego">跳转</a><span style="float:right;">共&nbsp;' + SysTool.pagination.pages + '&nbsp;页，当前<input type="text" class="all_inputtext" id="pagination_go_topage" style="width:30px;text-align:center;" value="' + curtPage + '" /> 页</span>';
				txt += '</div>';
				txt += '<div class="listpage"><a href="javascript:void(0);">首页</a><a href="javascript:void(0);">上一页</a><a href="javascript:void(0);">下一页</a><a href="javascript:void(0);">尾页</a></div>';
			}
			var paginationObj = $('#' + showId);
			paginationObj.html(txt);
			paginationObj.find('.all_inputtext').val(1);
			if(total <= count){
				paginationObj.find('.listpage').hide();
				paginationObj.find('.btn_pagego').hide();
			}else{
				paginationObj.find('.listpage').show();
				paginationObj.find('.btn_pagego').show();
				var goNumObj = paginationObj.find('.all_inputtext');
				var listpage = paginationObj.find('.listpage').find('a');
				// 首页事件注册
				listpage.eq(0).click(function(){
					var pnum = SysTool.pagination.pnum;
					if(pnum == 1){ SysTool.tooltips('pagination_go_topage', '当前已经是第一页！'); return; }
					goNumObj.val(1);
					SysTool.pagination.pnum = 1;
					json = {min : 0, max : count - 1, num : SysTool.pagination.pnum};
					if(typeof(callback) === 'function'){ callback(json); }
				});
				// 上一页事件注册
				listpage.eq(1).click(function(){
					var num = SysTool.pagination.pnum;
					num --;
					if(num < 1){
						num = 1;
						SysTool.tooltips('pagination_go_topage', '当前已经是第一页！');
						return;
					}
					min = (num - 1)  * count;
					max = count * num - 1;
					SysTool.pagination.pnum = num;
					goNumObj.val(num);
					json = {min : min, max : max, num : num};
					if(typeof(callback) === 'function'){ callback(json); }
				});
				// 下一页事件注册
				listpage.eq(2).click(function(){
					var num = SysTool.pagination.pnum;
					num ++;
					if(num > SysTool.pagination.pages){
						num = SysTool.pagination.pages;
						SysTool.tooltips('pagination_go_topage', '当前已经是最后一页！');
						return;
					}
					goNumObj.val(num);
					min = (num - 1)  * count;
					max = count * num - 1;
					SysTool.pagination.pnum = num;
					json = {min : min, max : max, num : num};
					if(typeof(callback) === 'function'){ callback(json); }
				});
				// 尾页事件注册
				listpage.eq(3).click(function(){
					var pgs = SysTool.pagination.pages;
					var pnum = SysTool.pagination.pnum;
					if(pnum == pgs){ SysTool.tooltips('pagination_go_topage', '当前已经是最后一页！'); return; }
					goNumObj.val(pgs);
					SysTool.pagination.pnum = pgs;
					min = count * (pgs - 1);
					json = {min : min, max : total, num : pgs};
					if(typeof(callback) === 'function'){ callback(json); }
				});
				// 跳转至多是页事件注册
				paginationObj.find('.btn_pagego').click(function(){
					var nm = goNumObj.val();
					var pgs = SysTool.getTxtVal("pagination_go_topage");
					var numreg = /^\d+$/;
					if((!numreg.test(nm)) || (nm < 1 || nm > pgs)){
						SysTool.tooltips('pagination_go_topage', '请输入整页数1~' + pgs);
						return;
					}
					min = (nm - 1) * count;
					max = count * nm - 1;
					SysTool.pagination.pnum = nm;
					json = {min : min, max : max, num : pgs};
					if(typeof(callback) === 'function'){callback(json); }
				});
			}
		}
	},
	
	/**
	 * sleep
	 * @param numberMillis
	 */
	sleep : function (numberMillis) {
	    var now = new Date();
	    var exitTime = now.getTime() + numberMillis;
	    while (true) {
	        now = new Date();
	        if (now.getTime() > exitTime)
	            return;
	    }
	},
	
	/**
	 * 取得坐标串中间的点
	 * @param areastr
	 * @returns {Point}
	 */
	getCenterPoint : function(areastr) {
		var points = areastr.split(',');
		var len = points.length;
		var limit = (len / 2) / 2;
		limit = Math.ceil(limit);
		if ((len / 2) % 2 != 0) {
			limit = limit - 1;
		}
		var cdx = limit * 2, cdy = cdx + 1;
		var centerX = points[cdx], centerY = points[cdy];
		var point = new Point(centerX, centerY);
		return point;
	},
	
	/**
	 * 获得点坐标字符串
	 * @param pointArray 点对象数组
	 */
	getPointsStr : function(pointArray){
		var pointStr = "";
		$.each(pointArray,function(key,value){
			pointStr = pointStr + "," + value.x + "," + value.y;
		});
		return pointStr.substring(1, pointStr.length);
	},
	
	/**
	 * 创建文件保存XML字符串
	 * @param param 参数数组[{}]
	 */
	creatFileXml : function(param){
		var xml = "<?xml version='1.0' encoding='UTF-8'?>";
		xml = xml + "<fileroot>"
			+ "<total>" + param.length + "</total>"
			+ "<files>";
		$.each(param,function(key,value){
			xml = xml + "<file>"
				+ "<type>" + value.type + "</type>"
				+ "<oldname>" + value.oldname + "</oldname>"
				+ "<newname>" + value.newname + "</newname>"
				+ "<path>" + value.path + "</path>"
				+ "<content>" + value.content + "</content>"
				+ "<orderseq>" + value.orderseq + "</orderseq>"
				+ "</file>";
		});
		xml = xml + "</files></fileroot>";
		return xml;
	},
	/**
	 * 打开人员选择页面
	 * 传入参数param样式
	 * {
				 			tablename:"T_PERSONNEL",//表名
				 			colums:{"姓名":"jyxm","警号":"jybh","单位":"zzjgmc"},//其中jyxm，jybh，zzjgmc均为表T_PERSONNEL中字段
				 			pk:"guuid",//表中主键字段
				 			dw:"zzjgmc",//如果colums中没有单位字段，则dw为空，如果存在单位字段，则此处填写单位字段,此标记作用是是否显示单位查询输入框
				 			dwdm:"zzjgdm",//如果colums中没有单位字段，则dwdm为空，如果存在单位字段，则此处填写单位代码字段，此标记作用查询数据
				 			data:{},//获取右边框已存在数据
				 			/*data表示已选择数据，如果不为空，初始化方法的时候，右边确认框应该出现这些数据
		 					 * data例子：
		 					 *  data={
		 			  						total:10;
		 			 						rows:[{JYXM:"王梅",JYBH:"P5485",ZZJGMC:"三中队",ZZJGDM:"51000000",GUUID:"CC099693716C42A5BCE6D6C904F6ACBA"},{},{},...{}];
		 								}
				 			xzlx:"XLXZ_XLXZ",//小组类型
				 			map:{"jyxm":"name","jybh":"policenum","zzjgmc":"orgname","guuid":"id"},//匹配字段,map和xzlx都是同时存在或同时不存在
				 			commitFun : "getData",//点击确认之后，处理选中数据
				 			rywhere:"guuid not in(select id from t_qwgl_pzgl_xlxzcy)"//sql语句，过滤已选中的人员
		*/					
	openRyxz : function(param){
		var url = "common/components/ryxz/ryxz.jsp?param1="+JSON.stringify(param);
		url = encodeURI(url);
		url = encodeURI(url);
		SysTool.window.open({
			width : 725,
			height : 566,
			title : "成员设置",
			url : url
		}, function(html){});
	},
	/**
	 * 打开装备关联页面
	 * 参数示例
	 * param={
	 * jybh:[];//警员编号
	 * jybh示例:["FXG090","FXG100","080544","026442","FX3520","FX3518","FXS007","FXS005"]
	 * data:"",//获取已经存在的数据
	 * 	data示例:[
			      	{"jybh":"FXG100","id":1},
	                 {"jybh":"080544","id":2}
		      		],
	 *	commitFun : "",//获取到返回值之后执行的方法
	 *zbwhere:""//拼装的sql语句，为了过滤装备。示例：zbwhere:"and id !=1",ps:必须有"and"
	 * } 
	 */
	openZbgl:function(param) {
		var url = "common/components/zbgl/zbgl.jsp?param1="+JSON.stringify(param);
		url = encodeURI(url);
		url = encodeURI(url);
		SysTool.window.open({
			width : 800,
			height : 594,
			title : "关联装备",
			url : url
		}, function(html){});
	},
	
	/**
	 * 说明：去掉代码末尾的00（必须为偶数长度)
	 * @param dm
	 * @returns {String}
	 */
	getSplitJgdm : function(dm) {
		var returnValue = "";
		var temp = "";
		if(dm == null || dm == ""){
			returnValue = "";
		}
		var len = dm.length;
		if(len <= 2){
			returnValue = dm;
		}
		var idx = len - 1;
		for(var i = len - 1; i >= 0; i = i - 2) {
			temp = dm.substring(i - 1, i + 1);
			if(temp != "00") {
				break;
			}
			idx = i - 2;
		}
		returnValue = dm.substring(0, idx + 1);
		return returnValue;
	},
	
	/**
	 * 去掉代码末尾的00（必须为偶数长度）
	 * @param dwdmArray
	 * @returns {Array}
	 */
	getSplitDmArray : function(dwdmArray) {
		var splitDmArray = new Array();
		for(var i = 0; i < dwdmArray.length; i++){
			splitDmArray.push(SysTool.getSplitJgdm(dwdmArray[i]));
		}
		return splitDmArray;
	},
	/**
	 * 给数组对象增加方法
	 */
	addArrayFn:(function() {
		/**
		 * @param b 数组
		 * return 交集
		 */
		Array.prototype.intersect=function(b) {
			var res=[];
			 res=this.uniquelize().each(function(x) {
				 return b.contains(x)?x:null;
			 });
			return res;
		};
		/**
		 * 数组的并集
		 */
		Array.prototype.union=function(b) {
			return this.concat(b).uniquelize();
		};
		/**
		 * 数组差集-减去数组相交部分，剩下的元素
		 */
		Array.prototype.minus=function(b) {
			var res=[];
			res=this.uniquelize().each(function(x) {
				return b.contains(x)?null:x;
			}); 
			return res;
		};
		/**
		 * 判断数组是否包含某元素
		 */
		Array.prototype.contains=function(a) { 
			for(var i=0;i<this.length;i++) {
				if(this[i] === a )
					return true;
			}
			return false;
		};
		/**
		 * 获取数组不重复集合
		 */
		Array.prototype.uniquelize=function() {
			var res=[]//返回对象   
			,temp={}//临时对象
			,arr//临时元素
			;
			for(var i=0,len=this.length;i<len;i++) {
				arr=this[i];
				if(!temp[arr]) {//如果元素不在临时对象中
					//存放返回数组
					res.push(arr);
					//添加重复标记
					temp[arr]=true;
				}
			}
			return res;
		};
		/**
		 * 遍历数组
		 * @param fn 回调函数
		 */
		Array.prototype.each=function(fn) {
			 fn=fn||Function.READ;
			 var res=[];
			 if(this.length>0)
				 for(var i=0;i<this.length;i++) {
					 var a=fn.call(this,this[i]);
					 if(a)
						 res.push(a);
				 }
			 return res;
		};
		/**
		 * 数组化简
		 * @param initValue 初始值
		 * @parm fn 化简函数
		 */
		Array.prototype.reduce=function(fn,initValue) {
			//如果该方法存在就直接使用
			if(Array.prototype.reduce) {
				return Array.prototype.reduce.call(this,fn,initValue);
			}
			//从新创建
			else {
				var previous=initValue,
					k=0,
					length=this.length;
				if(!previous) {
					//initValue不存在或者为空
					previous=this[0];
					k=1;
				}else {
					if(typeof fn === "function") {
						for(k;k<length;k++) {
							previous=fn.call(this,previous,this[k]);
						}
					}
				}
				return previous;
			}
		};
		/**
		 * 快速排序算法实现的排序(如果原序列排序程度越高，它越慢；反之，如果原序列越乱，它越快)
		 * 原理：
		 * 1、从数列中挑出一个元素，称为 “基准”（pivot），
		 * 2、重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
		 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
		 * 3、递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
		 * @param fun
		 */
		Array.prototype.fastSort=function() {
			var firstNum//基准数据
			,i//从左往右算子
			,j//从右往左算子
			,that=this//数组
			,temp//临时值
			;
			(function(left,right) {
				if(left>=right) {//当left 大于或等于right时，停止迭代 
					return;
				}
				//将数组第一个元素设置为基准值
				firstNum=that[left];
				i=left;
				j=right;
				while(i!=j) {
					//从右往左计数，找到小于或等于firstNum的数
					while(that[j] > firstNum && i < j) {
						j--;
					}
					//从左往右计数，找到大于firstNum的数
					while(that[i] <= firstNum && i < j) {
						i++;
					}
					if(i < j) {
						//交换位置
						temp=that[i];
						that[i]=that[j];
						that[j]=temp;
					}
				}
				//交换基准值位置，使左边的数都小于或等于基准值，右边的数都大于基准值
				that[left]=that[i];
				that[i]=firstNum;
				//迭代左边部分
				arguments.callee(left,i-1);
				//迭代右边部分
				arguments.callee(i+1,right);
			})(0,that.length-1);
			return that;
		};
		/**
		* 冒泡排序算法实现
		* 原理：元素两两重复比较
		* ，如果位置错误则将其纠正
		*/
		Array.prototype.bubleSort=function() {
		   var that=this
		    ,temp
		    ;
		    for(var i=0,len=that.length;i<len;i++) {
		        for(var j=i+1;j<len;j++) {
		            if(that[i]>that[j]) {
		                temp=that[i];
		                that[i]=that[j];
		                that[j]=temp;
		            }
		        }
		    }
		};
		/**
		* 选择排序算法实现
		*原理：从未有排序的数列中找到选择最小值，存放到另一数组中
		*，在未排序的序列中删掉已经选择的最小值。
		*重复以上步骤即可。
		*/
		Array.prototype.selectSort=function() { 
		    var re=[]//返回排序数组
		    ,temp={}//临时对像
		    ;
		    while(this.length) {
		        temp= min(this);
		        re.push(temp.min);
		        this.splice(temp.j,1);
		    }
		    return re;
		    //找到数组中的最小值
		    function min(arr) {
		        var j=0//最小值序号
		        ,min=arr[0]//最小值
		        ;
		        for(var i=0,len=arr.length;i<len;i++) {//循环所有，找到最小值
		            if(min>arr[i]) {
		                j=i;
		                min=arr[i];
		            }
		        }
		        return {j:j,min:min};
		    }
		};
		/**
		* 插入排序算法实现
		*  原理：1.从第一个元素开始，该元素可以认为已经被排序
			2.取出下一个元素，在已经排序的元素序列中从后向前扫描
			3.如果该元素（已排序）大于新元素，将该元素移到下一位置
			4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
			5.将新元素插入到该位置中
			6.重复步骤2
		*/
		Array.prototype.insertSort=function() { debugger;
		    var t//临时变量
		    ,temp//临时元素
		    ;
		    //循环遍历
		    for(var i=1,len=this.length;i<len;i++) {
		        if(this[i] < this[i-1]) {//如果发现当前小于前一个数
		            //将i-1赋值给临时变量
		            t=i-1;
		            while(t >= 0) {
		                //在i-1这些已经排好序的数列中找到小于或等于a的数
		                if(this[t--] <= this[i]) {
		                    temp=this[i];
		                    //删除当前元素
		                    this.splice(i,1);
		                    //将当前元素插入t位置
		                    this.splice(t+2,0,temp);
		                    //跳出while循环
		                    break;
		                }
		                if (t == -1) {
		                    temp=this[i];
		                    //删除当前元素
		                    this.splice(i,1);
		                    //将当前元素插入t位置
		                    this.splice(0,0,temp);
		                }
		            }
		        }
		    }
		    return this;
		};
	})()
};




















