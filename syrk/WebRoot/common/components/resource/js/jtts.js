/**
 * 交通态势构造函数
 *  @author liuc
 */ 

var jttsbl = {
		/**
		 * 当前地图层级
		 */
		currlevel : '14',
		roadstate :  {},
		roadids :  '',
		roads : '',
		mkArray:null,
		makecnterArray:null,
		roadzb: '',
		/**
		 * 状态对应颜色
		 */
		
		ztys : {'1':'#17bf00','2':'#ff9f19','3':'#f23030','4':'#bb0000'},
		timeId:'',
		ploylines:[],
		flag:'',
		crrentLevel :4,
		crrentSslkCxLevel :4,
		zoomLkycLevel:4
};

function Jtts() {
	
	/**
	 * 实时路况，刷新时间，每五分钟改变一次
	 */
	this.sslkSxsj=function() {
		//关闭上一次时钟
		Jtts.sslkSxsjPrevious && window.clearInterval(Jtts.sslkSxsjPrevious);
		//设置时间,每五分钟刷新一次
		jttsbl.timeId=window.setInterval('jtts.sslkSx();', 1000*60*5);
		//保存上一次时钟
		Jtts.sslkSxsjPrevious=jttsbl.timeId;
		//将本次时钟赋值给公共清除方法，以便在其他模块中防止加载本方法
		PrivateTimer.jtts.sslkTimer=jttsbl.timeId;
	};
	/**
	 * 实时路况，刷新方法 
	 */
	this.sslkSx=function() { 
		//当再一次调用sslkSx时，关掉上一次地图缩放时钟
		Jtts.zoomSslkTimerPrevious && window.clearInterval(Jtts.zoomSslkTimerPrevious);
		//实时路况地图缩放监控
		PrivateTimer.jtts.zoomSslkTimer=window.setInterval(function() { 
			if(jttsbl.crrentLevel !== _MapApp.getZoomLevel()) { 
				wrap();
				jttsbl.crrentLevel=_MapApp.getZoomLevel();
			} 
			//500ms监控一次
		}, 500);
		//保存前一次
		Jtts.zoomSslkTimerPrevious=PrivateTimer.jtts.zoomSslkTimer;
		wrap();
		function wrap() { 
			//显示时间
			var time=new Date();
			//格式化当前时间
			var current=SysTool.getDateTimeFormat(time,false);
			var timeSpan=document.getElementById("jtts_sslk_sx_gxsj");
			timeSpan.innerHTML="<span>"+current+"</span>&nbsp;&nbsp;";
			//路况统计
			jtts.jttsSslkTj();
			//给地图上图
			getldinfo();
		}
	};
	/**
	 * 实时路况查询方法
	 */
	this.queryJtts=function() {
		//显示查询结果容器
		jtts.showSeachResult(false);
		//在查询面板中模拟地图缩放事件
//		PrivateTimer.jtts.zoomSslkCxTimer=window.setInterval(function() {
//			if(jttsbl.crrentSslkCxLevel !== _MapApp.getZoomLevel()) { 
//				jtts.queryJttsMb();
//				jttsbl.crrentSslkCxLevel=_MapApp.getZoomLevel();
//			} 
//		}, 500);
		SysTool.loading.mask('jtts_cxzs_content', 60, 200);
		window.clearInterval(jttsbl.timeId);
		window.clearInterval(PrivateTimer.jtts.zoomSslkTimer);
		var level_new = _MapApp.getZoomLevel();//获取地图等级
		var dlmc=SysTool.getTxtVal("jtts_ldmc");//获取路段名称
		var param1={};
		var page=1;//初始化查询时,查询数据为第一页
		var rows=10;//每页显示数据条数
		//需要在图上上图的路段状态参数
		var ct=$("#jtts_sslk_sx_zt_ct_cx1").attr("checked")?'1':null;
		var hx=$("#jtts_sslk_sx_zt_hx_cx1").attr("checked")?'2':null;
		var yd=$("#jtts_sslk_sx_zt_yd_cx1").attr("checked")?'3':null;
		var yzyd=$("#jtts_sslk_sx_zt_yzyd_cx1").attr("checked")?'4':null;
		var flowlevel="";
	
		if(ct) {
			flowlevel+="'"+ct+"',";
			$( "#jtts_sslk_sx_zt_ct_cx" ).prop("checked", true);
		}
		if(hx) {
			flowlevel+="'"+hx+"',";
			$( "#jtts_sslk_sx_zt_hx_cx" ).prop("checked", true);
		}
		if(yd) {
			flowlevel+="'"+yd+"',";
			$( "#jtts_sslk_sx_zt_yd_cx" ).prop("checked", true);
		}
		if(yzyd) {
			flowlevel+="'"+yzyd+"',";
			$( "#jtts_sslk_sx_zt_yzyd_cx" ).prop("checked", true);
		}
		//去掉字符串尾部逗号
		if(flowlevel !== "") {
			flowlevel=flowlevel.substring(0,flowlevel.length-1);
		}
		else {
			//如果没有勾选状态，查不出来
			flowlevel="'5'";
		}
		//param1['dtcj'] =level_new;  //地图层级
		param1['flowlevel'] = flowlevel;//路段状态 (1：畅通,2;缓行,3:拥堵,4:严重拥堵)
		param1['roadName'] = dlmc;//路段名称
		param1['page']=page;
		param1['rows']=rows;
		//跳转到查询面板时，给查询条件赋默认值
		SysTool.setTxtVal("jtts_ldmc_cx", dlmc);
		//ajax查询参数
		var param={};
		param.url='jtts/queryRoadNowInfo.f';
		param.data=param1;
		SysTool.ajax(param, function(data) {
			var total=data.total;
			//初始化分页
			SysTool.pagination.init(total, rows, 'jtts_pagination', function(json){
				//分页操作注册事件函数
				param1['page']=json.num;
				SysTool.ajax(param, function(reData) { 
					Jtts.initResultList(reData,{callback:Jtts.scrollBar,p1:'jtts_cxzs_content',p2:'jtts_result'});
				});
			});
			Jtts.initResultList(data,{callback:Jtts.scrollBar,p1:'jtts_cxzs_content',p2:'jtts_result'});
		});
		//查询结果上图
		this.sslkcxForSt(param1);
	};
	/**
	 * 查询面板上的查询方法
	 */
	this.queryJttsMb=function() {
		 //在数据加载之前遮挡
		SysTool.loading.mask('jtts_cxzs_content', 60, 200);
		var level_new = _MapApp.getZoomLevel();//获取地图等级
		var dlmc=SysTool.getTxtVal("jtts_ldmc_cx");//获取路段名称
		//删除实时路况定时刷新
		window.clearInterval(jttsbl.timeId);
		window.clearInterval(PrivateTimer.jtts.zoomSslkTimer);
		var param1={};
		var page=1;//初始化查询时,查询数据为第一页
		var rows=10;//每页显示数据条数
		
		//需要在图上上图的路段状态参数
		var ct=$("#jtts_sslk_sx_zt_ct_cx").attr("checked")?'1':null;
		var hx=$("#jtts_sslk_sx_zt_hx_cx").attr("checked")?'2':null;
		var yd=$("#jtts_sslk_sx_zt_yd_cx").attr("checked")?'3':null;
		var yzyd=$("#jtts_sslk_sx_zt_yzyd_cx").attr("checked")?'4':null;
		var flowlevel="";
	
		if(ct) {
			flowlevel+="'"+ct+"',";
			$("#jtts_sslk_sx_zt_ct_cx1").attr({checked:"checked"});
		}
		if(hx) {
			flowlevel+="'"+hx+"',";
			$("#jtts_sslk_sx_zt_hx_cx1").attr({checked:"checked"});
		}
		if(yd) {
			flowlevel+="'"+yd+"',";
			$("#jtts_sslk_sx_zt_yd_cx1").attr({checked:"checked"});
		}
		if(yzyd) {
			flowlevel+="'"+yzyd+"',";
			$("#jtts_sslk_sx_zt_yzyd_cx1").attr({checked:"checked"});
		}
		//去掉字符串尾部逗号
		if(flowlevel !== "") {
			flowlevel=flowlevel.substring(0,flowlevel.length-1);
		}
		else {
			//如果没有勾选，那么查不出来数据
			flowlevel="'5'";
		}
		//param1['dtcj'] =level_new;  //地图层级
		param1['flowlevel'] = flowlevel;//路段状态 (1：畅通,2;缓行,3:拥堵,4:严重拥堵)
		param1['roadName'] = dlmc;//路段名称
		param1['page']=page;
		param1['rows']=rows;
	
		//ajax查询参数
		var param={};
		param.url='jtts/queryRoadNowInfo.f';
		param.data=param1;
		SysTool.ajax(param, function(data) {
			var total=data.total;
			
			//初始化分页
			SysTool.pagination.init(total, rows, 'jtts_pagination', function(json){
				//分页操作注册事件函数
				param1['page']=json.num;
				SysTool.ajax(param, function(reData) { 
					Jtts.initResultList(reData,{callback:Jtts.scrollBar,p1:'jtts_cxzs_content',p2:'jtts_result'});
				});
			});
			Jtts.initResultList(data,{callback:Jtts.scrollBar,p1:'jtts_cxzs_content',p2:'jtts_result'});
		});
		//查询结果上图
		this.sslkcxForSt(param1);
	};
	/**
	 * 加载滚动条
	 */
	 Jtts.scrollBar=function(param1,param2) { 
		SysTool.loading.unmask();
		try{
			ScrollBarTool.init(param1, param2, 260,true); // 加载滚动条
		}catch(e){alert(e);}
	};
	/**
	 * 初始化数据列表
	 * @param data 需要展现的数据
	 * @param param 参数包装对象
	 * @return
	 */
	 Jtts.initResultList=function(data,param) { 
		var list=data.rows;
		var size=list.length;
		var html="";
		var background_color="";
		var flowlevel="";
		if(size>0) { 
			//如果是实时路况查询，则对其进行按照分页数据上图
			if(!param.lkbj) {
				//对本页的查询结果上图
				//jtts.showdl(list, "no");//无需分页上图
			}
			//查询结果有值
			for(var i=0;i<size;i++) {
				flowlevel=list[i].flowlevel;
				
				if(flowlevel==1) {
					background_color=jttsbl.ztys['1'];
				}else if(flowlevel==2) {
					background_color=jttsbl.ztys['2'];
				}else if(flowlevel==3) {
					background_color=jttsbl.ztys['3'];
				}else{
					background_color=jttsbl.ztys['4'];
				}
				html+="<div class='lk' style='margin:0;'>";
				html+="<dl>";
				html+="<dt><strong>"+list[i].roadName+"</strong></dt>";
				html+="<dd><span>流&nbsp;&nbsp;&nbsp;&nbsp;量：</span>"+list[i].carRunoff+"&nbsp;辆/分钟&nbsp;&nbsp;&nbsp;<span>流速：</span>"+list[i].avgVelocity+"&nbsp;千米/小时</dd>";
				html+="<dd><span>车间距：</span>"+list[i].carDistance+"&nbsp;米&nbsp;&nbsp;&nbsp;<span>&nbsp;车辆密度：</span>"+list[i].carDensity+"&nbsp;辆/千米</dd>";
				switch(list[i].levelname){
				case "严重拥堵":
					html+="<dd><span>当前状态：</span><span style='display:inline-block;width:55px;color:#ffffff;text-align:center;background:#bb0000'>"+list[i].levelname+"</span><input type='hidden' value='"+flowlevel+"'/>";
					break;
				case "拥堵":
					html+="<dd><span>当前状态：</span><span style='display:inline-block;width:55px;color:#ffffff;text-align:center;background:#f23030'>"+list[i].levelname+"</span><input type='hidden' value='"+flowlevel+"'/>";
					break;
				case "缓行":
					html+="<dd><span>当前状态：</span><span style='display:inline-block;width:55px;color:#ffffff;text-align:center;background:#ff9f19'>"+list[i].levelname+"</span><input type='hidden' value='"+flowlevel+"'/>";
					break;
				case "畅通":
					html+="<dd><span>当前状态：</span><span style='display:inline-block;width:55px;color:#ffffff;text-align:center;background:#17bf00'>"+list[i].levelname+"</span><input type='hidden' value='"+flowlevel+"'/>";
					break;
				}
				if(Jtts.mode === 'sslk') {
					html+="</dd>";
				}
				if(Jtts.mode === 'lkbj') {
					switch(parseInt(list[i].oldFlowlevel)) {
					case 1:
						html+="<span>上一状态：</span><span style='display:inline-block;width:55px;color:#ffffff;text-align:center;background:#17bf00'>畅通</span>";
						break;
					case 2:
						html+="<span>上一状态：</span><span style='display:inline-block;width:55px;color:#ffffff;text-align:center;background:#ff9f19'>缓行</span>";
						break;
					case 3:
						html+="<span>上一状态：</span><span style='display:inline-block;width:55px;color:#ffffff;text-align:center;background:#f23030'>拥堵</span>";
						break;
					case 4:
						html+="<span>上一状态：</span><span style='display:inline-block;width:55px;color:#ffffff;text-align:center;background:#bb0000'>严重拥堵</span>";
						break;
					}
					html+="</dd>";
				}
				html+="<dd><span>时&nbsp;&nbsp;&nbsp;&nbsp;间：</span>"+list[i].dealTime+"</dd>";
				html+="<dd><a class='rtminbtn' style='margin-left:0;' href='javascript:void(0);' title='定位' onclick='jtts.dw(\""+list[i].roadId+"\")'>定位</a>" +
						"<a class='rtminbtn'  href='javascript:void(0);' onclick='jtts.pj(\""+list[i].roadId+"\",\""+list[i].roadName+"\");' title='派警'>派警</a>" +
						"<a class='rtminbtn' href='javascript:jtts.getRoadLslk(\""+list[i].roadId+"\",1);' title='当日路况'>当日路况</a></dd>";
				html+="</dl>";
				html+="</div>";
			}
		}else{
			//清空图层
			_MapApp.clearLayers();
			MapBubble.removeAll();
			//查询结果无值
			html="<dl style='background-color:#aad8ff'><dt style='cursor:auto;color:#999999;text-align:center'>查询无返回结果！</dt></dl>";
		}
		var ele=document.getElementById(param.p2);
		ele.innerHTML=html;
		//给每个div注册事件
		$(".lk").mouseover(function(){
			$(this).css({background:'#d5e2ed'});
		}).mouseout(function() {
			$(this).css({background:'#e8f8ff'});
		});
		if(typeof(param.callback)=="function") { 
			param.callback(param.p1,param.p2);
		}
	};
	/**
	 * 获取图片地址
	 * @param i 图片索引
	 * @return url 图片地址
	 */
	function getIconUrl(i) {
		var baseUrl="common/components/resource/images/jtts/";
		var index="jq0"+i+".png";
		var url=baseUrl+index;
		
		return url;
	}
	 /**
	  * 隐藏查询结果
	  * @param isHiden 是否隐藏查询结果
	  * @return
	  */
	 this.showSeachResult=function(isHiden) {
		if(isHiden){
			$('#body_jtts_table').show();//展现主操作面板
			$('#jjts_cxzs').hide();//隐藏查询结果
			$('#jtts_lslk').hide();//隐藏当日路况
		}else{
			//$('#jtts_result').empty();//清空查询结果容器
			$('#jtts_result').html('');
			$('#body_jtts_table').hide();//隐藏主操作面板
			$('#jtts_lslk').hide();//隐藏当日路况
			$('#jjts_cxzs').show();//展现查询结果
		}
	};
	/**
	 * 实时路况查询条件重置
	 */
	this.resetJtts=function() {
		document.forms[0].reset();
		//jtts.ztInit();//初始化查询条件状态
	};
	/**
	 * 实时路况派警
	 * @param roadId 路段代码
	 * @param roadName 路段名称
	 */
	this.pj=function(roadId,roadName) {
		
		 pj(roadId,roadName);//派警
		// _MapApp.zoomTo(4);
//		 SysTool.confirm("确认完成派警吗？",function(r) { 
//			 if(r) 
//				 pj(roadId,roadName);//派警
//		 });
	};
	/**
	 * 加载气泡内容
	 */
	this.loadBubbleContent = function(data){
		loadBubbleContent(data);
	};
	/**
	 * 当日路况
	 */
	this.getRoadLslk = function(roadid,flag) {
		getRoadLslk(roadid,flag);
	};
	/**
	 * 周边警力
	 */
	this.getRoadZbjl = function(roadid) {
		getRoadZbjl(roadid);
	};
	/**
	 * 周边资源
	 */
	this.getRoadZbzy = function(roadid) {
		getRoadZbzy(roadid);
	};
	/**
	 * 派警私有方法
	 * @param roadId 路段代码
	 * @param roadName 路段名称
	 * @return
	 */
	function pj(roadId,roadName) {
		var where = "";//查询条件
		var areastr="";//路段的坐标
		var aQuery = new QueryObject();
		aQuery.featurelimit = 10000;
		aQuery.queryType = 6;
		aQuery.dispField = 'objectid,lddm,ldmc';
		aQuery.addSubFields('objectid,lddm,ldmc');
		aQuery.tableName = SysConfig.GIS_DB_USERNAME + '.' + SysConfig.JT_ROADSEGITEM_PL;
		var lddm =roadId;
		if(lddm != "" && lddm != null) {
			where += " lddm ="+lddm;
		} else {
			where += " lddm = 'noshow'";
		}
		aQuery.where = where;
		_MapApp.query(aQuery, function(vBIsOK, vRequestObj) {
			try{
				var features =[];
				var dwLayers = _MapApp.getQueryResult(vRequestObj);
				for ( var j = 0; j < dwLayers.length; j++) {
					if (dwLayers[j].tableName.toUpperCase() == aQuery.tableName.toUpperCase()) {
						features = dwLayers[j].features;
					}
				}
				var ldObj=features[0];//路段对象
				areastr=ldObj.linestr;
				var ldqdzb= getldqdzb(areastr);//路段起点坐标
				var param={};//派警查询参数
				var date=new Date();
				param['zzjgzddm']=ywjgdm;
				param['jqJjsj']=SysTool.getDateTimeFormat(date.getTime());
				param['jqBjsj']=SysTool.getDateTimeFormat(date.getTime());
				param['bjryxm']=jjrbh;
				param['jqssdldm']='caseType122030000';
				param['jqsszldm']='caseType122030500';
				param['jqssxldm']='';
				param['jqssdddm']='510601000000';
				param['jqsszddm']='510601005300';
				param['afdzx']=ldqdzb.split(',')[0];
				param['afdzy']=ldqdzb.split(',')[1];
				param['jqbh'] = SysTool.getDateTimeFormatNoSeparator(date.getTime()) + Math.floor(9000000*Math.random()+1000000);
				param['jjtfh'] = '';
				param['jqafdd'] =roadName ;
				param['jqxx'] = '交通堵塞等突发情况';
				param['lddm'] =roadId;
				param['ldmc'] = roadName;
				param['jqlxdm'] ='jqlb004';
				param['jqlxmc'] = '交通堵塞等突发情况';
				param['optiontype'] ='2';
				param['sfswhcl'] = "0";
				param['ywrysw'] = "0";
				param['sfsjtsgdsr'] = "0";
				param['ywty'] = "0";
				param['ifschool'] =  "0";
				param['ifmotor'] ="0";
				param['iftaxi'] ="0";
				param['ifpolice'] ="0";
				param['ifelectric'] ="0";
				param['ifdxhurt'] ="0";
				param['ifdead'] ="0";
				param['ifhurt'] ="0";
				var HTTPREQPARAM = {url: 'jqxx/addZhddJqxx.f', data: param};//拼装派警参数
				//调用警情方法
				SysTool.ajax(HTTPREQPARAM, function(data){
					if("success" == data.result) {
						Zjj.dwst(param);//定位上图
						 
						if ('' != param.afdzx && '' != param.afdzy) {
							Jqxx.beforeShowRemind({changeCount: 1, stateControlType: 2});
						}
						_MapApp.zoomTo(4);
						//将路段移到可视范围内
						_MapApp.centerAtLatLng(new Point(ldqdzb));
					}
					else {
						SysTool.show('派警失败!');
					}
				});
			}catch (e) {
				SysTool.loading.unmask();
				SysTool.alert('路段定位出错： ' + e.message);
			}
		});
	}
	/**
	 * 获取路段起点坐标
	 * @param areastr 路段坐标
	 * @return
	 */
	function getldqdzb(areastr) {
		var ldqdzb="";
		var pointXYs=[];
		
		pointXYs=areastr.split(",");
		ldqdzb=pointXYs[0]+","+pointXYs[1];
		return ldqdzb;
	}
	
	/**
	 * 初始气泡内容
	 */
	function initBubbleContent(){
		var msg = "";
		msg += "<div id='sslk_info' value='' class='tips_top'><div class='tips_title'><strong style='padding:0 10px;'>路况信息</strong></div></div>";
		msg += "<div class='tips_jlct'><div class='tipsjili'>路段名称：<span style='color:#000' id='roadName'></span></div><div class='tipsjili'>路段状态：<span style='color:#000' id='levelname' title=''></span></div>";
		msg += "<div class='tipsjili'><span style='margin-right:19px;color:#004180;'>流</span> 量：<span style='color:#000' id='carRunoff'></span>辆/分钟</div><div class='tipsjili'><span style='margin-right:23px;color:#004180;'>流</span>速：<span style='color:#000' id='avgVelocity'></span>千米/小时</div>";
		msg += "<div class='tipsjili'>车<span style='margin:0 6px 0 6px;;color:#004180;'>间</span>距：<span style='color:#000' id='carDistance'></span>米</div><div class='tipsjili'>车辆密度：<span style='color:#000' id='carDensity'></span>辆/千米</div>";
			
		msg += "<div class='bubllebtn'><a id='road_historay' href='javascript:void(0);' class='btn_tipsdw'>当日路况</a>";
		msg += "<a id='road_zy' href='javascript:void(0);' class='btn_tipsdw'>周边资源</a>";
		msg += "<a class='btn_tipsdw' id='road_gj' href='javascript:void(0);'>周边警力</a>";
		msg +=	"<div class='clear'></div></div>";
		return msg;
	}
	
	
	/**
	 * 加载气泡数据内容
	 * @param data
	 */
	function loadBubbleContent(data){
		var roadid = data["roadid"];

		function roadInfoDetail(data) { 

			//设置当前点击的GPS警力数据
			$("#roadName").text(data["ROAD_NAME"]|| "未知");
			$("#levelname").text(data["LEVELNAME"] || "未知");
			$("#carRunoff").text(data["CAR_RUNOFF"] || "未知");
			$("#avgVelocity").text(data["AVG_VELOCITY"] || "未知");
			$("#carDistance").text(data["CAR_DISTANCE"] || "未知");
			$("#carDensity").text(data["CAR_DENSITY"] || "未知");
			//绑定当日路况事件
			$("#road_historay").attr("href","javascript:jtts.getRoadLslk('"+data["ROAD_ID"]+"',2)");
			//绑定周边资源事件
			$("#road_zy").attr("href","javascript:jtts.getRoadZbzy('"+data["ROAD_ID"]+"')");
			//绑定周边警力事件
			$("#road_gj").attr("href","javascript:jtts.getRoadZbjl('"+data["ROAD_ID"]+"')");
		}
		//根据roadid取得详细信息
		getRoadInfoDetail(roadid, roadInfoDetail);
	}	
	/**
	 * 当日路况
	 * @param roadid 路段编码 
	 * @param flag 标记从哪个入口进入当日路况面板||1:从气泡进入2：从面板进入
	 */
	function getRoadLslk(roadid,flag) {  
		if(jttsbl.flag != 'lkbj') {
			jttsbl.flag=flag;
		}
		$('#body_jtts_table').hide();//隐藏主操作面板
		$('#jjts_cxzs').hide();//隐藏查询结果面板
		$('#jtts_lkbj').hide();
		$('#jtts_lslk').show();//展现当日路况面板
		SysTool.loading.mask('jtts_lslk_content', 60, 200);
		
		var param1={};
		var day=new Date;
		day=SysTool.getDateFormat(day);
		
		param1['roadid']=roadid;
		param1['day']=day;
		
		var param={};
		param.data=param1;
		param.url="jtts/getRoadLs.f";
		 
		SysTool.ajax(param, function(data) {
			var list=data;
			var size=list.length;
			var roadname="";//路段名称
			var jsonObject="";//查询结果某对象
			var contentHtml="";//生成的html,会写入容器中
			var dayTime="";//日期—天
			var dateTime="";//时间—时：分：秒
			var flowlevel="";
			
			if(size>0) {
				roadname=list[0].roadName;
				dayTime=list[0].dealTime.split(" ")[0];
				contentHtml+="<div style='color:#999999'>共有"+size+"条</div>";
				contentHtml+="<div style='text-align:center;background:#b5cbde'><strong >"+roadname+"</strong></div>";
				contentHtml+="<div class='lslk_timelinebody'>";
				contentHtml+="<div class='lslk_timeyear'>"+dayTime+"</div>";
				for(var i=0;i<size;i++) {
					jsonObject=list[i];
					flowlevel=jsonObject.flowlevel;
					if(flowlevel==1) {
						background_color=jttsbl.ztys['1'];
					}else if(flowlevel==2) {
						background_color=jttsbl.ztys['2'];
					}else if(flowlevel==3) {
						background_color=jttsbl.ztys['3'];
					}else{
						background_color=jttsbl.ztys['4'];
					}
					dateTime=jsonObject.dealTime.split(" ")[1].split(".")[0];
					contentHtml+="<div class='lslk_time'>"+dateTime+"</div>";
					contentHtml+="<div class='lslk_table'>";
					contentHtml+="<div class='lslk_time_yxj'></div>";
					
					switch(jsonObject.levelname){
					case "严重拥堵":
						contentHtml+="<div class='lslk_coin_yzyd'></div>";
						break;
					case "拥堵":
						contentHtml+="<div class='lslk_coin_yd'></div>";
						break;
					case "缓行":
						contentHtml+="<div class='lslk_coin_hx'></div>";
						break;
					case "畅通":
						contentHtml+="<div class='lslk_coin_ct'></div>";
						break;
					}
					
					contentHtml+="<div class='lslk_jt'></div>";
					contentHtml+="<div class='lslk_zt'>"+jsonObject.levelname+"<a class='togglebtn_show'></a></div>";
					contentHtml+="<ul  class='lslk_ul'>";
					contentHtml+="<li><span style='margin-right:24px'>流</span>量："+jsonObject.carRunoff+"辆/分钟</li>" +
							"<li><span style='margin-right:24px'>流</span>速："+jsonObject.avgVelocity+"千米/小时</li>";
					contentHtml+="<li>车<span style='margin:0 6px 0 6px'>间</span>距："+jsonObject.carDistance+"米</li>" +
							"<li>车辆密度："+jsonObject.carDensity+"辆/千米</li>";
					contentHtml+="</ul>";
					contentHtml+="</div>";
				}
				contentHtml+="</div>";
			}else {
				contentHtml+="<dl style='background-color:#aad8ff'><dt style='cursor:auto;color:#999999;text-align:center'>查询无返回结果！</dt></dl>";
			}
			var ele=document.getElementById("jtts_lslk_content");
			
			SysTool.loading.unmask();
			ele.innerHTML=contentHtml;
			try{
				ScrollBarTool.init("jtts_lslk_content_div", "jtts_lslk_content", 30); // 加载滚动条
				$(".lslk_zt").click(function(){
					$(this).parent(".lslk_table").siblings().find(".lslk_ul").hide();
					$(this).parent(".lslk_table").siblings().find(".lslk_time_yxj").hide();
					$(this).parent(".lslk_table").siblings().find(".togglebtn_show").removeClass("togglebtn_hide");
					$(this).next(".lslk_ul").toggle();
					$(this).children(".togglebtn_show").toggleClass("togglebtn_hide");
					$(this).siblings(".lslk_time_yxj").toggle();
				});
			}catch(e){alert(e);}
		});
	}
	/**
	 * 周边警力
	 * @param gpsid
	 */
	function getRoadZbjl(roadid) {
		MapBubble.hideBubble();
		var param = {
			id : 'jtts_load_rt',
			url : 'common/components/resource/gps.jsp',
			data : {
				"roadid" : roadid,
				"isLoad" : "yes"
			}
		};
		Resource.fireClickFunc(param['id'], param['url'], param['data']);
		LeftLayout.hideLefLayout();
	}
	
	/**
	 * 周边资源
	 * @param gpsid
	 */
	function getRoadZbzy(roadid) {

		MapBubble.hideBubble();
		var param = {
			id : 'jtts_load_rt',
			url : 'common/components/resource/jcxx.jsp',
			data : {
				"roadid" : roadid,
				"isLoad" : "yes"
			}
		}; 
		Resource.fireClickFunc(param['id'], param['url'], param['data']);
		LeftLayout.hideLefLayout();

	}
	
	
	/**
	 * 根据roadid取得详细信息
	 * @param roadid
	 * @param callback
	 */
	function getRoadInfoDetail(roadid, callback) { 
		var param={};
		
		param.url='jtts/getRoadInfoDetail.f';
		param.data={'roadid':roadid};
		SysTool.ajax(param, function(data) {
			callback(data);
		});
	}
	
	/**
	 * 获取路段的相关信息
	 * @param jsonDsyjArray
	 */ 
	function getldinfo() { 
		//需要在图上上图的路段状态参数
		var ct=$("#jtts_sslk_sx_zt_ct").attr("checked")?'1':null;
		var hx=$("#jtts_sslk_sx_zt_hx").attr("checked")?'2':null;
		var yd=$("#jtts_sslk_sx_zt_yd").attr("checked")?'3':null;
		var yzyd=$("#jtts_sslk_sx_zt_yzyd").attr("checked")?'4':null;
		var flowlevel="";
		if(ct)
			flowlevel+="'"+ct+"',";
		if(hx)
			flowlevel+="'"+hx+"',";
		if(yd)
			flowlevel+="'"+yd+"',";
		if(yzyd)
			flowlevel+="'"+yzyd+"',";
		//去掉字符串尾部逗号
		if(flowlevel !== "")
			flowlevel=flowlevel.substring(0,flowlevel.length-1);
		else {
			flowlevel="'"+0+"'";
		}
		//查询参数
		var param2 = {};
		param2['dtcj'] = _MapApp.getZoomLevel();
		param2['flowlevel']=flowlevel; 
		
		SysTool.ajax({
			url : "jtts/jttsSslk.f",
			data : {param:JSON.stringify(param2)}
		}, function(returnData) {  
			jtts.showdl(returnData,"no");
		});
	}
	/**
	 * 根据指定key取出值组合为sql语句in条件字符串
	 * @param jsonArray
	 * @param key
	 * @returns {String}
	 */
	this.getSqlWhereIn = function(jsonArray, key) {
		var sqlWhereIn = "";
		var json;
		var v;
		for(var i = 0; i < jsonArray.length; i++) {
			json = jsonArray[i];
			v = json[key];
			if(v != null && v != "") {
				sqlWhereIn += "'"+v+"'"+",";
			}
		}
		if(sqlWhereIn != null && sqlWhereIn != "") {
			sqlWhereIn = sqlWhereIn.substring(0, sqlWhereIn.length - 1);
		}
		return sqlWhereIn;
	};
	
	/**
	 * 路段状态上图
	 * @param jsonDsyjArray
	 * @param ifbj 是否闪烁
	 * @param iflkyc 是否是路况预测上图标记
	 */
	this.showdl=function(jsonDsyjArray,ifbj,iflkyc) { 
		var aQuery = new QueryObject();
		//实参对象
		var arg=arguments; 
		aQuery.featurelimit = 10000;
		aQuery.queryType = 6;
		aQuery.dispField = 'objectid,lddm,ldmc';
		aQuery.addSubFields('objectid,lddm,ldmc');
		aQuery.tableName = SysConfig.GIS_DB_USERNAME + '.' + SysConfig.JT_ROADSEGITEM_PL;
		var where = "";
		var lddm = jtts.getSqlWhereIn(jsonDsyjArray, "roadId");
 
    	if(lddm != "" && lddm != null) {
			where += " lddm in ("+lddm+")";
		} else {
			where += " lddm = 'noshow'";
		}
		aQuery.where = where;
		_MapApp.clearLayers();
		MapBubble.removeAll();
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
				var dxdm = "";
				var dxmc = "";
				var yjys = "";
				var levename = "";
				var polyline;
				if (ilength > 0) {
					var markerArray = new Array();
					
					jttsbl.ploylines.length=0;//清空数组内容
					for ( var i = 0; i < ilength; i++) {
						dwftrObj = features[i];
						areastr = dwftrObj.linestr;
						dxdm = dwftrObj.getFieldValue("LDDM");
						dxmc = dwftrObj.getFieldValue("LDMC");
						yjys = jtts.getYjys(jsonDsyjArray, dxdm);
						levename = jtts.getLevelname(jsonDsyjArray, dxdm);
						polyline = jtts.getLine(areastr,yjys, 3, 9, 0.5, dxdm, "", 1);
						jttsbl.ploylines.push(polyline);
						_MapApp.addOverlay(polyline);
						if("yes"==ifbj){
							polyline.flash(3);
						}
						if(arg.length < 3) {//在这里阻止路况预测的marker上图
							  var marker  = getMarker(dxdm, dxmc, levename, areastr);
							  markerArray.push(marker);
						}
					}
					var markerParam = {
							    markerArray : markerArray,
							    contentType:"html",
							    contentValue:initBubbleContent(),
								contentCallback:"jtts.loadBubbleContent",
								eventFuncJson : {'click' : 'jtts.loadBubbleContent'},
								bubbleShowEvent : "click",
								titleShowEvent : 'mouseover',
								bubbleWidth:400,
								bubbleHeight:155,
								moveMode : "movetoshow",
								geometryType:"polyline"
						};
					jttsbl.mkArray = MapBubble.addJttsMarker(markerParam);
					
					function getMarker(dxdm, dxmc, levename, areastr){
						var point =SysTool.getCenterPoint(areastr);
						var param = {};
						param['roadid'] = dxdm;
						var marker = {dataJson:param,
								id:dxdm,
								titleName:dxmc+"："+levename,
								x:point.x,
								y:point.y,
								iconUrl:"project/jtts/images/tm.png",
								iconWidth:1,
								iconHeight:1,
								iconLeftOffset:0,
								iconTopOffset:-1
							};
						return marker;
					}
				}
				SysTool.loading.unmask(); 
		} catch (e) { 
			SysTool.loading.unmask();
			SysTool.alert('路段定位出错： ' + e.message);
		}
		});
	};
	
	
	

	
	/**
	 * 根据指定对象代码返回对应的状态颜色
	 * @param jsonArray
	 * @param dxdm
	 * @returns {String}
	 */
	this.getYjys = function(jsonArray, dxdm) {
		var yjys = "";
		var json;
		
		for(var i = 0; i < jsonArray.length; i++) {
			json = jsonArray[i];
			if(json["roadId"] == dxdm) {
				yjys = json["flowlevel"];
				break;
			}
		}
		return jttsbl.ztys[yjys];
	};
	/**
	 * 根据指定对象代码返回对应的路段状态
	 * @param jsonArray
	 * @param dxdm
	 * @returns {String}
	 */
	this.getLevelname= function(jsonArray, dxdm) {
		var levelname = "";
		var json;
		
		for(var i = 0; i < jsonArray.length; i++) {
			json = jsonArray[i];
			if(json["roadId"] == dxdm) {
				levelname = json["levelname"];
				break;
			}
		}
		return levelname;
	};
	/**
	 * 获得line
	 * @param linezb 线坐标
	 * @param ys 颜色
	 * @param width 宽度
	 * @param opacity 透明度
	 * @param arrow 是否有方向
	 * @param lh 路号
	 */
	this.getLine= function(linezb,ys,width,opacity,arrow,lh){ 
		var line = new Polyline(linezb, ys, width, opacity, arrow);	 
		line.addListener("click",function(){
			jtts.showMarkerFromClickLine(linezb,lh);
		});
		line.addListener("mouseover",function(){
		//	line.flash();
			//jtts.showMarkerFromLine(linezb,lh);
		});
		return line;
	};
	/**
	 * 实时路况统计
	 */
	this.jttsSslkTj=function() { 
		var url="jtts/jttstj.f";
		var param1={flowlevel:'1'};
		var param={};//ajax查询参数
		
		param.url=url;
		param.data=param1;
		SysTool.ajax(param, function(data) {
			createResultListTj(data,"jtts_sslk_tj");
		});
	};
	/**
	 * 生成路况统计结果
	 * @param param 展现数据封装参数
	 * @param tjId 展现统计数据的divId
	 * @return
	 */
	function createResultListTj(param,tjDivId) { 
		var list=param;
		var length=param.length;
		var roadTotal=list[0]['tjsl']+list[1]['tjsl']+list[2]['tjsl']+list[3]['tjsl'];//路段总数
		var html="";
		var num=0;
		var _num=0;
		  
		if(length>0) {
			html+="<dl class='table_tj'>";
			html+="<dt><span style='text-align:center'>路况状态</span><a>数量</a><span>占比</span></dt>";
			for(var i=0;i<length;i++) {
				num=list[i]['tjsl'];
				 
				if(i==0) {
					if(num==0)
						html+="<dd><span style='background-color:#bb0000;color:#ffffff;text-align:center'>"+list[i]['levelname']+"</span><a onmouseup='jtts.resetJtts();' onclick='$(&quot;#jtts_sslk_sx_zt_yzyd_cx1&quot; ).prop(&quot;checked&quot;, true);jtts.queryJtts();'>"+num+"</a><span>"+0+"</span></dd>";
					else {
					     _num=(num*100/roadTotal).toFixed(2);
						html+="<dd><span style='background-color:#bb0000;color:#ffffff;text-align:center'>"+list[i]['levelname']+"</span><a onmouseup='jtts.resetJtts();' onclick='$( &quot;#jtts_sslk_sx_zt_yzyd_cx1&quot; ).prop(&quot;checked&quot;, true);jtts.queryJtts();'>"+num+"</a><span>"+_num+"%</span></dd>";
					}
				}else if(i==1) {
					if(num==0)
						html+="<dd><span style='background-color:#f23030;color:#ffffff;text-align:center'>"+list[i]['levelname']+"</span><a onmouseup='jtts.resetJtts();' onclick='$( &quot;#jtts_sslk_sx_zt_yd_cx1&quot; ).prop(&quot;checked&quot;, true);jtts.queryJtts();'>"+num+"</a><span>"+0+"</span></dd>";
					else {
					     _num=(num*100/roadTotal).toFixed(2);
						html+="<dd><span style='background-color:#f23030;color:#ffffff;text-align:center'>"+list[i]['levelname']+"</span><a onmouseup='jtts.resetJtts();' onclick='$( &quot;#jtts_sslk_sx_zt_yd_cx1&quot; ).prop(&quot;checked&quot;, true);jtts.queryJtts();'>"+num+"</a><span>"+_num+"%</span></dd>";
					}
				}else if(i==2) {
					if(num==0)
						html+="<dd><span style='background-color:#ff9f19;color:#ffffff;text-align:center'>"+list[i]['levelname']+"</span><a onmouseup='jtts.resetJtts();' onclick='$( &quot;#jtts_sslk_sx_zt_hx_cx1&quot; ).prop(&quot;checked&quot;, true);jtts.queryJtts();'>"+num+"</a><span>"+0+"</span></dd>";
					else {
					     _num=(num*100/roadTotal).toFixed(2);
						html+="<dd><span style='background-color:#ff9f19;color:#ffffff;text-align:center'>"+list[i]['levelname']+"</span><a onmouseup='jtts.resetJtts();' onclick='$(&quot;#jtts_sslk_sx_zt_hx_cx1&quot; ).prop(&quot;checked&quot;, true);jtts.queryJtts();'>"+num+"</a><span>"+_num+"%</span></dd>";
					}
				}else {
					if(num==0)
						html+="<dd><span style='background-color:#17bf00;color:#ffffff;text-align:center'>"+list[i]['levelname']+"</span><a onmouseup='jtts.resetJtts();' onclick='$( &quot;#jtts_sslk_sx_zt_ct_cx1&quot; ).prop(&quot;checked&quot;, true);jtts.queryJtts();'>"+num+"</a><span>"+0+"</span></dd>";
					else {
					     _num=(num*100/roadTotal).toFixed(2);
						html+="<dd><span style='background-color:#17bf00;color:#ffffff;text-align:center'>"+list[i]['levelname']+"</span><a  onmouseup='jtts.resetJtts();' onclick='$( &quot;#jtts_sslk_sx_zt_ct_cx1&quot; ).prop(&quot;checked&quot;, true);jtts.queryJtts();'>"+num+"</a><span>"+_num+"%</span></dd>";
					}
				}
			}
			html+="</dl>";
		}else{
			
		} 
		var ele=document.getElementById(tjDivId);
		ele.innerHTML=html;
	}
	/**
	 * 返回站位符
	 * @param num 个数
	 * @return
	 */
	function returnZwf(num) {
		var str="";
		var size=num;
		
		for(var i=0;i<size;i++) {
			str+="&nbsp;";
		}
		return str;
	}
	/**
	 * 点击道路显示道路上信息
	 * @param lh 路段号
	 */
	this.showMarkerFromClickLine = function(linezb,lh){
		var point1 = SysTool.getCenterPoint(linezb);
		var markerArray = jttsbl.mkArray, marker = null, point = null;
		if(markerArray != null){				
			for(var i = 0; i < markerArray.length; i++){
				marker = markerArray[i];
//				alert(marker);
     			point = marker.getPoint();
//				alert(point+point1);
				if(point.equals(point1)){
					marker.onclick();
					break;
				}
			}
		}
	};
	
	
	/**
	 * 鼠标放置显示道路名称信息
	 * @param lh 路段号
	 */
	this.showMarkerFromLine = function(linezb,lh){
		var point1 = SysTool.getCenterPoint(linezb);
//		jttsbl.makecnterArray.hideTitle();
		var markerArray = jttsbl.mkArray, marker = null, point = null;
		if(markerArray != null){				
			for(var i = 0; i < markerArray.length; i++){
				marker = markerArray[i];
//				alert(marker);
     			point = marker.getPoint();
				if(point.equals(point1)){
//					jttsbl.makecnterArray=marker;
					marker.showTitle();
    				break;
				}
			}
		}
	};
	
	/**
	 * 定位某个路段
	 * @param roadId 路段编号
	 */
	this.dw=function(roadId) {
		var where = "";//查询条件
		var areastr="";//路段的坐标
		var aQuery = new QueryObject();
		aQuery.featurelimit = 10000;
		aQuery.queryType = 6;
		aQuery.dispField = 'objectid,lddm,ldmc';
		aQuery.addSubFields('objectid,lddm,ldmc');
		aQuery.tableName = SysConfig.GIS_DB_USERNAME + '.' + SysConfig.JT_ROADSEGITEM_PL;
		var lddm =roadId;
		if(lddm != "" && lddm != null) {
			where += " lddm ="+lddm;
		} else {
			where += " lddm = 'noshow'";
		}
		aQuery.where = where;
		_MapApp.query(aQuery, function(vBIsOK, vRequestObj) {
			try{
				var features =[];
				var dwLayers = _MapApp.getQueryResult(vRequestObj);
				for ( var j = 0; j < dwLayers.length; j++) {
					if (dwLayers[j].tableName.toUpperCase() == aQuery.tableName.toUpperCase()) {
						features = dwLayers[j].features;
					}
				}
				var ldObj=features[0];//路段对象
				areastr=ldObj.linestr;//路段坐标坐标
				var ldqdzb=getldqdzb(areastr);//路段起点坐标
				var lines=jttsbl.ploylines;//已上图的线的集合
				var line="";//线对象
				var points=[];//点坐标空集合
				var strLine="";//线坐标字符串
			 
				//找到定位的那条线的对象
				for(var i=0;i<lines.length;i++) {
					 line=lines[i];
					 points=line.getPoints();
					 for(var j=0;j<points.length;j++) {
						 strLine+=points[j].getCoordSequence()+",";
					 }
					 strLine=strLine.substring(0,strLine.length-1);
					 var tempArray=strLine.split(",");
					 var tempstr="";
					 
					 for(var k=0;k<tempArray.length;k++) {
						 tempstr+=window.parseFloat(tempArray[k]).toFixed(6)+",";
					 }
					 tempstr=tempstr.substring(0,tempstr.length-1);
					 strLine=tempstr;
					 if(areastr==strLine) {
						 break;
					 }
					 strLine="";
				}
				//将路段移到可视范围内
				_MapApp.centerAtLatLng(new Point(ldqdzb));
				//调整地图级别为4
				//_MapApp.zoomTo(4);
				line.flash();
				line.onclick();
			}catch(e) {
				alert(e);
			}
		});
	};
	/**
	 * @param ele 元素对象
	 */
	this.changeModel=function(ele) {
		//获取被点击元素的样式类
		var classname=ele.className;
		 //判断是否有jttstable_on样式类
		var flag=classname.indexOf("jttstable_on");
		//获取class=jttstable元素
		var eles=$(".jttstable"); 
		var title="";
		
		//获取点击元素的子元素的title值
		title=ele.firstChild.getAttribute("title");
		switch(title) {
			case '实时路况' :jjtsInit.sslkInit();break;
			case '路况预测' :jjtsInit.lkycInit();break;
			case '路况报警' :jjtsInit.lkbjInit();break;
		}
		//切换点击样式
		for(var i=0;i<eles.length;i++) {
			var temp=eles[i];
			//找到其它两个元素对象,切换样式为非点击状态
			if(ele!==temp) {
				temp.className="jttstable";
				temp.firstChild.className="btnab";
			}else{
				//点击元素如果存在class=jttstable_on，则不处理，如果不存在则添加该样式
				if(flag<0) {
					ele.className="jttstable jttstable_on";
					ele.firstChild.className="btnab btnab_onb";
				}
			}
		}
	};
	/**
	 * 路况报警设置方法
	 */
	this.lkbjSz=function() { 
		var arg=arguments;
		//获取userId值
		var userId=jjrbh;
		//获取设置的状态值
		var ct=$("#jtts_lkbj_zt_ct").attr("checked")?1:null;
		var hx=$("#jtts_lkbj_zt_hx").attr("checked")?2:null;
		var yd=$("#jtts_lkbj_zt_yd").attr("checked")?3:null;
		var yzyd=$("#jtts_lkbj_zt_yzyd").attr("checked")?4:null;
		var flowlevel="";
		if(ct) {
			flowlevel+=ct+",";
		}
		if(hx) {
			flowlevel+=hx+",";
		}
		if(yd) {
			flowlevel+=yd+",";
		}
		if(yzyd) {
			flowlevel+=yzyd+",";
		}
		//去掉字符串尾部逗号
		if(flowlevel) {
			flowlevel="'"+flowlevel.substring(0,flowlevel.length-1)+"'";
		}
		else {
			flowlevel="'5'";
		}
		//时段-开始时间
		var kssj=SysTool.getTxtVal("jtts_lkbj_kssj");
		//时段-结束时间
		var jssj=SysTool.getTxtVal("jtts_lkbj_jssj");
		//验证输入时间有效性
		//开始时间和结束时间可以都为空
		//也可以都不为空
		//都不为空时，结束时间必须大于开始时间
		if(kssj&&jssj) {
			if(jssj<=kssj) {
				SysTool.tooltips("jtts_lkbj_jssj", "结束时间许须大于开始始时间",'left');
				return;
			}
		}else if(kssj&&!jssj) {
			SysTool.tooltips("jtts_lkbj_jssj", "结束时间不能为空",'left');
			return;
		}else if(!kssj&&jssj) {
			SysTool.tooltips("jtts_lkbj_kssj", "开始时间不能为空");
			return;
		}else if(!kssj&&!jssj){
			SysTool.tooltips("jtts_lkbj_kssj", "这里需要填写时间");
			return;
		}
		//向后台传递参数的过程
		var param={};
		param.userid=userId;
		param.flowlevel=flowlevel;
		param.bjkssj=kssj;
		param.bjjssj=jssj;
		 
		//构造ajax参数
		var param1={};
		param1.url="jtbj/setbjtj.f";
		param1.data=param;
		SysTool.ajax(param1, function(returnData){
			if(returnData.status>0){
				if(arg.length === 0) {
					SysTool.show("路况报警条件设置成功");
					//路况报警上图
					jtts.lkbjst();
					// 初始化消息提醒
					Xxtx.initXxtx("xxtxUl");
				}
				/*报警路况查询*/
				jtts.bjldxqck();
			}
			else
				SysTool.show("路况报警条件设置失败");
		});
	};
	/**
	 * 路况报警条件检查
	 */
	this.lkbjTjCheck=function() { 
		//用户id
		var userid=jjrbh;
		//构造请求主体
		var param={};
		param.userid=userid;
		//构造ajax参数
		var param1={};
		param1.url="jtbj/getbjtj.f";
		param1.data=param; 
		//ajax请求过程
		SysTool.ajax(param1, function(returnData) { 
			//获取目标对象 
			var jsonObject=returnData[0]; 
			//获取状态值
			var flowlevel=jsonObject['flowlevel'];
			//flowlevel有值时处理它，勾选条件设置复选框，若没有值，不处理 
			if(flowlevel) {
				 //获取name=jtts_lkbj_zt的元素
				 var eles=doc.getElementsByName("jtts_lkbj_zt");
				 var size=eles.length;
				 //遍历eles
				 for(var i=0;i<size;i++) {
					 var ele=eles[i];
					 //获取元素的value值
					 var value=ele.getAttribute("value"); 
					 //如果元素的value值在flowlevel中，则勾选复选框，否则不作处理
					 if(flowlevel.indexOf(value)>-1)
					 	ele.setAttribute("checked","checked");
				 }
			 }
			//复填设定的时间
			$("#jtts_lkbj_kssj").val(jsonObject.bjkssj);/*开始时间*/
			$("#jtts_lkbj_jssj").val(jsonObject.bjjssj);/*endtime*/
		});
	};
}
//构造交通态势操作对象
var jtts=new Jtts();
var jjtsInit={};
//交通态势实时路况初始化方法
jjtsInit.sslkInit=function() {
	//初始化地图层级为4
	_MapApp.zoomTo(4);
	//实时路况菜单标记
	jttsbl.flag=1;
	//隐藏路况预测
	 $("#jtts_lkyc").hide();
	 //隐藏路况报警
	 $("#jtts_lkbj").hide();
	 //显示实时路况
	 $("#jtts_sslk").show();
	//每隔五分钟，触发刷新方法
	jtts.sslkSxsj();
	//实时路况刷新
	jtts.sslkSx();
	//隐藏查询结果div
	jtts.showSeachResult(true);
	SysTool.changeIputStyle();
	//实时路况菜单标记
	Jtts.mode="sslk";
	//关闭路况预测地图缩放监控
	PrivateTimer.jtts.zoomLkycTimer && window.clearInterval(PrivateTimer.jtts.zoomLkycTimer);
	//关闭路况报警时钟
	PrivateTimer.jtts.lkbjTimer && window.clearInterval(PrivateTimer.jtts.lkbjTimer);
};
//交通态势路况预测初始化方法
jjtsInit.lkycInit=function() {
 	//关闭实时路况定时刷新
	 window.clearInterval(jttsbl.timeId);
	 //关闭实时路况地图缩放监控
	 PrivateTimer.jtts.zoomSslkTimer && window.clearInterval(PrivateTimer.jtts.zoomSslkTimer);
	 //关闭路况报警时钟
	 PrivateTimer.jtts.lkbjTimer && window.clearInterval(PrivateTimer.jtts.lkbjTimer);
	//隐藏实时路况
	 $("#jtts_sslk").hide();
	 //隐藏路况报警
	 $("#jtts_lkbj").hide();
	 //显示路况预测
	 $("#jtts_lkyc").show();
	 var date=new Date();
	//当前星期
	 var xq=["星期日","星期一","星期二","星期三","星期四","星期五","星期六"][date.getDay()];
	 //更改初始化时，星期和时间
	 $(".lkyc_xq").html(xq);
	 //初始化预测时间,规则为当前时间的下一个小时
	 var temp=date.getHours()+1;
	 //处理时间超过边界问题
	 if(temp>23)
		 temp=0;
	 var time=temp>9?(temp)+":00":"0"+(temp)+":00";
	 $(".lkyc_time").html(time);
	 //为路况预测选择星期注册事件
	 $(".lkyc_time_chose tr:eq(0)>td:gt(0)>span").click(function() {
		 $(".lkyc_time_chose tr:eq(0)>td:gt(0)>span").css({background:'#f3faff'});
		 $(".lkyc_xq").html("星期"+$(this).css({background:'#d5e2ed'}).html());
		 //路况预测上图
		 jtts.lkycst();
	 });
	 $('#ss').slider({    
	    mode: 'h',  
	    showTip:true,
	    min:0,
	    max:24,
	    step:0.25,
	    rule:['|',"<span style='color:#1c84d1'>6</span>",'|',"<span style='color:#1c84d1'>12</span>",'|',"<span style='color:#1c84d1'>18</span>",'|'],
	    tipFormatter: function(value){
	    	//表示一个个位数的正则表达式
	    	var p=/^\d$/;
	    	if(p.test(value))
	    		return '0'+value + ':00';
	    	else
	    		return value + ':00';
	    },
	    onChange:function(newValue,oldValue) {
	    	$('.lkyc_time').html(/^\d$/.test(newValue)?("0"+newValue+":00"):newValue+":00");
	    },
	    onComplete:function() {
	    	//路况预测上图
	    	jtts.lkycst();
	    }
	}).slider("setValue",temp); 
	//路况预测上图
 	jtts.lkycst();
 	//路况预测路段查询
 	jtts.lkycCxInit();
};
//交通态势路况报警初始化方法
jjtsInit.lkbjInit=function() {
	//路况报警菜单标记
	 jttsbl.flag="lkbj";
	 Jtts.mode="lkbj";
	//隐藏实时路况
	 $("#jtts_sslk").hide();
	//隐藏路况预测
	 $("#jtts_lkyc").hide();
	 //显示路况报警
	 $("#jtts_lkbj").show();
	 //查询路况报警条件
	 //保证已设置的报警条件勾选
	 jtts.lkbjTjCheck();
	 //报警路段详情查看
	 jtts.bjldxqck();
	 //路况报警上图
	 jtts.lkbjst();
	 //关闭上一次定时刷新时钟
	 Jtts.lkbjTimerPrevious && window.clearInterval(Jtts.lkbjTimerPrevious);
	 //每5分钟定时刷新
	 PrivateTimer.jtts.lkbjTimer=window.setInterval(function() {
		 //报警路段详情查看
		 jtts.bjldxqck();
		 //路况报警上图
		 jtts.lkbjst();
	 }, 1000*60*5);
	 //保存上一次时钟
	 Jtts.lkbjTimerPrevious=PrivateTimer.jtts.lkbjTimer;
	 //关闭实时路况定时刷新
	 window.clearInterval(jttsbl.timeId);
	 //关闭实时路况地图缩放监控
	 PrivateTimer.jtts.zoomSslkTimer && window.clearInterval(PrivateTimer.jtts.zoomSslkTimer);
	//关闭路况预测地图缩放监控
	 PrivateTimer.jtts.zoomLkycTimer && window.clearInterval(PrivateTimer.jtts.zoomLkycTimer);
};
//报警路段详情查看
Jtts.prototype.bjldxqck=function(){ 
	var arg=arguments//实参对象
	,page=1/*初始化页码*/
	,rows=10/**/
	,param={}/*构造请求主体*/
	,param1={}/*构造ajax参数*/
	,userid=jjrbh
	,lbkjxqckRadioMemory=0//radio计数器
	,param3={}/*ajax参数*/
	,param4={}/*传递参数*/
	,lkbjxq=""/*路况报警详情*/
	;/*用户编号*/
	param['page']=page;/*分页初始化-显示第一页*/
	param['rows']=rows;/*init paged number*/
	param['userid']=userid;
	//组织机构代码
	param['ssjgdm']=jjrdwbh;
	if(arg.length == 0){
		param1.url="lkbj/queryRoadBJInfo.f";
	}else{
		param1.url="lkbj/queryRoadBJTxInfo.f";
		param['flowlevel']=arg[0];
	}
	param1.data=param;
	SysTool.ajax(param1, function(returnData){ 
		var total=returnData.total;/*Total number*/
		//初始化分页
		SysTool.pagination.init(total, rows, 'jtts_lkbj_pagination', function(json){
			//分页操作注册事件函数
			param['page']=json.num;
			SysTool.ajax(param1, function(reData) { 
				Jtts.initResultList(reData,{p1:'jtts_lkbj_content',p2:'jtts_lkbj_result',lkbj:'yes'});
			});
		});
		Jtts.initResultList(returnData,{p1:'jtts_lkbj_content',p2:'jtts_lkbj_result',lkbj:'yes'});

		try{
			ScrollBarTool.init("jtts_lkbj_content", "jtts_lkbj_result", 360); // 加载滚动条
		}catch(e){alert(e);}
	});
	//路况报警消息提醒
	//组织机构代码
	param4['ssjgdm']=jjrdwbh;
	param4['userid']=jjrbh;
	param3.url="lkbj/lkbjCount.f";
	param3.data=param4;
	SysTool.ajax(param3,function(reDa) { 
		//清除多余input
		for(var i=0,len=reDa.length;i<len;i++) {
			lkbjxq+="<li><label for='jttsLkbjXqckCx"+reDa[i].flowlevel+"'><input type='radio' name='jttsLkbjXqckCx'" 
					+"id='jttsLkbjXqckCx"+reDa[i].flowlevel+"'"
					+" onclick='jtts.queryLdxxByflowlevel("+reDa[i].flowlevel+");'/>"
					+reDa[i].levelname+"</label></li>";
		}
		$(".jtts_lkbj_xqck_cx>ul>li:eq(0)").nextAll().remove();
		//追加到ul中
		$(".jtts_lkbj_xqck_cx>ul").append(lkbjxq);
		//重新将点击之后的radio赋值
		lbkjxqckRadioMemory=parseInt($("#lbkjxqckRadioMemory").val());
		switch(lbkjxqckRadioMemory) {
			case 4:
				$("#jttsLkbjXqckCx4").attr("checked","checked");
				break;
			case 3:
				$("#jttsLkbjXqckCx3").attr("checked","checked");
				break;
			case 2:
				$("#jttsLkbjXqckCx2").attr("checked","checked");
				break;
			case 1:
				$("#jttsLkbjXqckCx1").attr("checked","checked");
				break;
			case 0:
				$("#jttsLkbjXqckCx0").attr("checked","checked");
				break;
		}
	});
};
//当日路况返回方法
Jtts.prototype.lslkback=function() { 
	if(jttsbl.flag==1) {
		this.showSeachResult(false);
		this.queryJttsMb();
	}
	else if(jttsbl.flag == 2){
		this.showSeachResult(true);
		this.sslkSx();
		this.resetJtts();
	}else{
		this.showSeachResult(true);
		$(".rt_titleb:eq(0) .jttstable:eq(2)>a").click();
	}
};
//通过flowlevel查询路段详细信息
Jtts.prototype.queryLdxxByflowlevel=function(flowlevel) {
	//在页面记录点击的是哪个输入radio
	$("#lbkjxqckRadioMemory").val(flowlevel);
	if(flowlevel == 0) {//点击“全部”
		this.lkbjSz('all');
	}else {
		this.bjldxqck(flowlevel);
	}
};
//路况报警上图
Jtts.prototype.lkbjst=function() { 
	//查询对象
	var param={};
	//ajax封装对象
	var param1={};
	//地图层级
	//param['dtcj']=_MapApp.getZoomLevel();
	//路段状态
	//param['flowlevel']=flowlevel;
	param['userid']=jjrbh;
	//组织机构代码
	param['ssjgdm']=jjrdwbh;
	param1.url="lkbj/lkbjinfo.f";
	param1.data=param;
	SysTool.ajax(param1,function(reData) {
		 reData.toString() && SysTool.show('当前有'+reData.length+"条路段状态发生变化!");
		 jtts.showdl(reData, "yes");
	});
};
//路况预测上图
Jtts.prototype.lkycst=function() {
	var that=this;
	//每次调用lkycst方法时，关闭上一次zoomLkycTimer时钟
	Jtts.zoomLkycTimerPrevious && window.clearInterval(Jtts.zoomLkycTimerPrevious);
	//在路况预测时，模拟注册地图缩放事件处理函数
	PrivateTimer.jtts.zoomLkycTimer=window.setInterval(function() {
		if(jttsbl.zoomLkycLevel !== _MapApp.getZoomLevel()) {
			wrap();
			jttsbl.zoomLkycLevel=_MapApp.getZoomLevel();
		}
	}, 500);
	//保存本次调用lkycst方法生成的时钟
	Jtts.zoomLkycTimerPrevious=PrivateTimer.jtts.zoomLkycTimer;
	(function wrap() {
		var date=$('.lkyc_xq').html();
		var time=$('.lkyc_time').html();
		var dtcj=_MapApp.getZoomLevel();
		var param1={
				url:"jtts/futureRoadState.f",
				data:{week:date,time:time,dtcj:dtcj}
		};
		//清除当前图层
		_MapApp.clearLayers();
		MapBubble.removeAll();
		//ajax过程
		SysTool.ajax(param1, function(reDa) {  
			that.showdl(reDa, "no","yes");
		});
	})();
};
//路况预测查询初始化
Jtts.prototype.lkycCxInit=function() {
	var dddm = "510601000000"//直属一大队单位代码
	,xzqh = dddm.substring(0,6)//截取字符串
	,week//周
	,time//时间
	,minute=30//查询时间精度
	,name//陆地名称
	,html//拼装字符串
	;
	//初始化查询输入框
	Dictionary.initDictionaryList({url: "dictionary/getLdDictJSON.f", data: {"zdbh": "JT_ROADSEGITEM_PL", "xzqh": xzqh}, dictShowId: "lkycLdmc",dictContainerReferenceObjectId: "lkycLdcxSr", initVal:""}, function(){},function(){});
	//解除id=lkycLdmc的click事件绑定，避免重复绑定
	$("#lkycLdmc").next().unbind("click");
	//为查询按钮注册事件处理函数
	$("#lkycLdmc").next().click(function() { 
		//遮盖ul
		SysTool.loading.mask("lkycLdcxJgUl",65,190);
		//删除存在的li
		$(".lkycLdcxJg ul").html("");
		week=$(".lkyc_xq").html();
		time=$(".lkyc_time").html();
		name=$("#lkycLdmc").val();
		//ajax请求
		SysTool.ajax({url:"jtts/futureRoadNameState.f",data:{week:week,
			time:time,minute:minute,name:name}}, function(re) {
				//解除遮盖
				SysTool.loading.unmask();
				if(re==""){
					$(".lkycLdcxJg ul").append("<li><span class='ldmc'>暂无查询结果！</span></li>");
				}else{
					re.each(function(obj) {
						html="<li><span class='ldmc' title='"+obj.roadName+"'><input type='hidden' value='"+obj.roadId+"'/>"+obj.roadName+"</span>";
						switch(obj.levelname){
						case "严重拥堵":
							html+="<span class='ldzt' style='background-color:#bb0000'>"+obj.levelname+"</span>";
							break;
						case "拥堵":
							html+="<span class='ldzt' style='background-color:#f23030'>"+obj.levelname+"</span>";
							break;
						case "缓行":
							html+="<span class='ldzt' style='background-color:#ff9f19'>"+obj.levelname+"</span>";
							break;
						case "畅通":
							html+="<span class='ldzt' style='background-color:#17bf00'>"+obj.levelname+"</span>";
							break;
						default:
							html+="<span>查询无返回结果！</span>";
							break;
						}
						html+="</li>";
						//追加到ul中
						$(".lkycLdcxJg ul").append(html);
					});
				}
			});
	});
};
//实时路况分页查询上图
Jtts.prototype.sslkcxForSt=function(param1) {
	//ajax查询参数
	var param={};
	param.url='jtts/sslkcxForSt.f';
	param.data=param1;
	SysTool.ajax(param, function(re) {
		jtts.showdl(re, "no");//无需分页上图
	});
};













