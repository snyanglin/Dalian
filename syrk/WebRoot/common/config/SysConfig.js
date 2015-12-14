/*!
 * 系统配置文件,包含客户端全局常量配置
 * http://jquery.com/
 * znjg - v1.0.0 (2014-03-12 09:30)
 * Copyright(c) 2014 founder
 */
/**
 * @classDescription 全局常量配置信息
 * @author lee
 */
var SysConfig = {
	// ======================以下常量根据实际部署环境修改===============================
	/**
	 * 系统名称【可修改】 EzManager中配置的系统名称必须与此一致
	 */
	SYSTEM_NAME : "智能交通管理可视化业务平台",
	
	EZSERVER_DEV_URL : "http://10.80.8.179:9080/EzServerClient/js/EzMapAPI.js",
	
	/**
	 * EzMapService地址【可修改】
	 */
	EZMAPSERVICE_URL : "http://10.80.8.178:7001/EzMapService",

	/**
	 * EzBuilder4.0开发库引入地址【可修改】POService/EzBuilderAPI/JavascriptApi
	 */
	EZBUILDER_DEV_URL : "http://10.80.8.178:7001/POService40/EzBuilderAPI/JavascriptApi/JsEzbuilder.js",

	/**
	 * 空间数据库用户名【可修改】
	 */
	GIS_DB_USERNAME : "GIS210200000000",
	//GIS_DB_USERNAME : "jwzh",
	
	/**
	 * ezspatial数据库用户名【可修改】
	 */
	EZSPATIAL_DB_USERNAME : "ezspatial",
	
	/**
	 * GPS历史轨迹对应的数据库用户名【可修改】
	 */
	GPS_DB_USERNAME : "jwzh",
 
	
	/**
	 * 视频地址IP
	 */
	VIDEO_IP : "10.66.64.201",

	/**
	 * 视频地址port
	 */
	VIDEO_PORT : "6001",

	/**
	 * EzManager数据库用户名【可修改】- 因为配置了同义词，该项配置取消
	 */
	//EZMANAGER_DB_USERNAME : "ZNJGAPP",
	
	/**
	 * 配置各个图层图标，显示顺序【可修改】- 只可修改id（图层表名）、order（排序号）、image_field（图片字段）
	 */
	GIS_LAYER_ICONS : [ {
		id : "VIDEO_PT",
		bg_url:"common/components/resource/images/layerimage/layer_bg_sp.png",
		url : "common/components/resource/images/layerimage/layer_sp2.png",
		order:1,
		/**
		 * 图片字段
		 */
		image_field:["IMAGEPATH"]
	},{
		id:"KK_PT",
		bg_url:"common/components/resource/images/layerimage/layer_bg_kk.png",
		url:"common/components/resource/images/layerimage/layer_kk2.png",
		order:2,
		image_field:["IMAGEPATH"]
	}, {
		id : "JT_HLD_PT",
		bg_url:"common/components/resource/images/layerimage/layer_bg_hld.png",
		url : "common/components/resource/images/layerimage/layer_hld2.png",
		order:3
	}, {
		id : "JT_YDP_PT",
		bg_url:"common/components/resource/images/layerimage/layer_bg_ydp.png",
		url : "common/components/resource/images/layerimage/layer_ydp2.png",
		order:4
	},{
		id : "T_ASJ_PT",
		bg_url:"common/components/resource/images/layerimage/layer_bg_asj.png",
		url : "common/components/resource/images/layerimage/layer_asj2.png",
		order:5
	},{
		id : "JT_JX_PT",
		bg_url:"common/components/resource/images/layerimage/layer_bg_jx.png",
		url : "common/components/resource/images/layerimage/layer_jx2.png",
		order:6
	},{
		id : "JT_BZ_PT",
		bg_url:"common/components/resource/images/layerimage/layer_bg_bz.png",
		url : "common/components/resource/images/layerimage/layer_bz2.png",
		order:7
	},{
		id : "JT_DX_PT",
		bg_url:"common/components/resource/images/layerimage/layer_bg_dx.png",
		url : "common/components/resource/images/layerimage/layer_dx2.png",
		order:8
	}],
	
	/**
	 * 警情周边查询图层表名【可修改】取消该配置项
	 */
	//JQXX_MARKER_AROUNDQUERY_LAYER_TABLENAME : ["GPSSTATUS"],
	
	/**
	 * 警情周边查询图层类型【可修改】取消该配置项
	 */
	//JQXX_MARKER_AROUNDQUERY_LAYER_TYPE : ["point"],
	
	/**
	 * 警情周边查询中文字段【可修改】取消该配置项
	 */
	//JQXX_MARKER_AROUNDQUERY_LAYER_NAMEFIELD : ["gpsid"],
	
	/**
	 * 机构点位查询图层表名【可修改】
	 */
	JG_DW_LAYER_TABLENAME : "JT_JJJG_PT",
	
	/**
	 * 机构点位查询中文字段【可修改】
	 */
	JG_DW_LAYER_NAMEFIELD : ["zbx", "zby"],
	
	/**
	 * 辖区查询表名(大队)【可修改】
	 */
	XQCX_DD_TABLENAME : "JJXQ_PG",
	
	/**
	 * 辖区查询表名(中队)【可修改】
	 */
	XQCX_ZD_TABLENAME : "JJXQ_ZD_PG",
	
	/**
	 * 登陆用户支队代码【可修改】
	 */
	T_USER_LOGIN_ORGID_ZD : '510600000000',
	
	/**
	 * 登陆用户支队名称【可修改】
	 */
	T_USER_LOGIN_ORGNAME_ZD : '德阳支队',
	
	
	
	/**
	 * 定位设备分组根节点【可修改】
	 */
	T_GPS_ORGNAME_ZD : '00000000',
	
	
	/**
	 * 道路表配置【可修改】
	 */
	JT_ROADITEM_PL : 'JT_ROADITEM_PL',
	
	/**
	 * 路段表配置【可修改】
	 */
	JT_ROADSEGITEM_PL : 'JT_ROADSEGITEM_PL',
	
	/**
     * 实时消息接收的timer【可修改】 一般与实时信号接收周期一致
     */
    SSXX_TIMER : 2000,
    
    /**
     * 实时统计timer【可修改】 一般与实时信号接收周期一致,最好是整数倍，降低刷新频率
     */
    SSTJ_TIMER : 10000,//4000,
    
    /**
     * 消息提醒timer【可修改】 一般不修改
     */
    XXTX_TIMER : 10000,
    
    /**
     * 警情状态timer【可修改】 一般不修改
     */
    JQZT_TIMER : 2000,
    
    /**
     * 字典过滤timer【可修改】 一般不修改
     */
    DICT_FILTER_TIMER : 500,
	
	/**
	 * 图层标准代码【可修改】
	 */
	SPATIAL_CODE:"GIS01",
	
	
	/**
	 * 基础资源图层树形根节点 code【可修改】,支持配置多个根节点code，格式如："'A','A01','A0101'"
	 */
	T_ZYGL_LAYER_CODE : "'A'",
	
	/**
	 * 基础资源各功能对应的图层code【可修改】
	 */
	JCZY_FUNCTION_LAYER_CODE : {
		JCZY : "A0101",
		PZGL : "A0102",
		XQGL : "A0203",
		DLGL : "A0106",
		JTHD : "A0108",
		ZDSG : "A0105"
	},
	
	/*************组织结构类型【可修改】(-1代表当前不可用)******************/
	/**公安部**/
	ZZJGLX_GAB : "0",
	/**交警总队**/
	ZZJGLX_JJZHONGD : "1",
	/**支队**/
	ZZJGLX_JJZHID : "11",
	/**分局**/
	ZZJGLX_JJFJ : "-1",
	/**大队**/
	ZZJGLX_JJDD : "12",
	/**中队**/
	ZZJGLX_JJZD : "13",
	/**辖区**/
	ZZJGLX_JJXQ : "14",
	/*************获取定位辖区【可修改】******************/
	/**德阳现场将数组修改为[1,2,3]获取辖区代码、名称[现在好像不需要修改了]**/
	JQDW_DWXQ : [0,1,2],//[0,1,2],
	
	
	/*子系统模块地址配置   MODE:OPEN 新页面打开，LOAD 切换保留操作痕迹 REPLACE 替换不保留操作痕迹*/
	SYS_MENU_URL_JSON : {
		FIRST_PAGE : {MODE:"OPEN",URL:""},
		JTCX_PAGE : {MODE:"REPLACE",URL:"project/jtts/jtcx.jsp"},
		ZHDD_PAGE : {MODE:"REPLACE",URL:"project/zhdd/zhdd.jsp"},
		QWGL_PAGE : {MODE:"REPLACE",URL:"project/qwgl/qwgl.jsp"},
		JJAB_PAGE : {MODE:"OPEN",URL:""},
		FXYP_PAGE : {MODE:"REPLACE",URL:"project/fxyp/fxyp.jsp"},
		JCZY_PAGE : {MODE:"REPLACE",URL:"project/jczy/jczy.jsp"},
		CLJK_PAGE : {MODE:"REPLACE",URL:"project/cljk/cljk.jsp"}
	},
	
	// ======================以下常量部署时不需要修改================================

	/**
	 * 登录用户名【不可修改】
	 */
	USERID:"admin",
	
	/**
	 * EzBuilder4.0客户端地址【不可修改】
	 */
	EZBUILDER_CLIENT_URL : "",
	
	/**
	 * 地图初始层级【不需修改】
	 */
	MAPINIT_ZOOM_LEVEL : 11,
	
	/**
	 * 画警情周边警力圈后，缩放地图的级别【不需修改】
	 */
	DRAWCIRCLE_ZOOM_LEVEL : 14,
	
	/**
	 * 警情上图后，缩放地图的级别【不需修改】
	 */
	LOADJQXXTOMAP_ZOOM_LEVEL : 14,
	
	
	/**
	 * 辅助定位地图级别
	 */
	FZDW_ZOOM_LEVEL : 14,
	
	/**
	 * 资源上图后，缩放地图的级别(暂时未用)
	 */
	//LOADRESTOMAP_ZOOM_LEVEL : 12,
	
	/**
	 * marker周边绘制圈配置【不需修改】
	 */
	/*yichu begin*/
	/*CIRCLE_CONFIG : [
	                 [500, 1000, 2000],//半径
	                 ["#ff0000", "#ff0000", "#ff0000"],//颜色
	                 ["#ffffff", "#ffffff", "#ffffff"]//填充颜色
	                 ],*/
	CIRCLE_CONFIG : [
	                 [2000, 1000, 500],//半径
	                 ["#ff0000", "#ff0000", "#ff0000"],//颜色
	                 ["none", "none", "none"]//填充颜色
	                 ],
    /*yichu end*/
	                 
	/**
	 * 配置各个状态警情图标【不需修改】
	 */
	JQXX_MARKER_ICONS:[{
		url:"project/base/images/hq_gray.png"
	},{
		url:"project/base/images/hq_red.png"
	},{
		url:"project/base/images/hq_yellow.png"
	},{
		url:"project/base/images/hq_blue.png"
	},{
		url:"project/base/images/hq_green.png"
	}],
	

	/**
	 * 图层类型【不可修改】
	 */
	LAYER_TYPE : [ "point", "polyline", "polygon" ],

	/**
	 * 图层查询类型【不可修改】
	 */
	QUERY_TYPE : [ "extent", "circle", "polygon", "pointAround", "lineAround", "polygonAround", "attribute" ],

	
	/**
	 * 基础信息气泡扩展【不可修改】
	 * @param id：图层名，content:内容，funcname:内容所对应的方法名 例 {id:"VIDEO_PT",content:["播放","其它"],funcname:["Jcxx.bofang","Jcxx.test1"]}，方法统一写到Jcxx.js
	 * 
	 */
	JCXX_BUBBLE_EXTEND : [
	                      {id:"VIDEO_PT",content:["播放视频"],funcname:["Jcxx.playVideo"]},
	                      {id:"KK_PT",content:["通过车辆查询"],funcname:["Jcxx.kkclcx"]}
	                     ],
	                     
	/**
	 * 视频通道字段【可修改】和Ezspatial中配置的一致（如果配置了中文名，此处则为中文名，否则为字段名）。
	 */
	VIDEO_TD_FIELD : "TDBH",//"TDBMBH",
	                     
	/**
	 * 消息类型【不可修改】，和字典（D_MSGTYPE）一致，可修改（MSGTYPE01：警情超时；MSGTYPE02：车辆报警；MSGTYPE03：报表；MSGTYPE04：设备；MSGTYPE99：其他。）
	 */
    MESSAGE_TYPE : ["MSGTYPE01", "MSGTYPE02", "MSGTYPE03", "MSGTYPE04", "MSGTYPE99","MSGTYPE05"],
    
    /**
     * 新警情类型（"1"：未定位；"2"：未派警。）
     */
    XJQ_TYPE : ["1"/*,"2"*/],
    
    /**
     * 使用采集工具采集的图片地址
     */
    COLLECT_LAYER_IMG_URL:"common/components/pictureshow/img/no.jpg",
    /**
     * 警情快捷周边查
     */
    JQXX_FAST_QUERY:{mode:["50","100","200"],target:["VIDEO_PT","KK_PT"],init:"50"},
    
    /**
     * 未定位警情上图地图坐标【可修改】
     */
    JQ_UNLOCATED_MAP_COORDINATES : [104.39514, 31.12927],
    
    /**
     * 分析研判图层【不可修改】
     */
    FXYP_PT : {
    	JQXX : 'T_JQXX_PT',
    	SG : 'T_SG_PT',
    	WFJL : 'T_WFJL_PT',
    	VIDEO:'VIDEO_PT'
    },
    
    /**
     * 可上传图片类型
     */
    IMGUPLOADTYPE : ["png","jpeg","gif","jpg","BMP"],
    
    /**
     * 图片展示根路径
     */
    IMAGESHOW_ROOTPATH : "http://172.29.214.199:8080/znjgShare",
    
    /**
     * GPS实时详细信息表名（用于空间查询、统计） 
     * 使用勤务系统为：V_GPS_USER_REALTIME_INFO，未使用勤务系统为：V_GPS_USER_REALTIME_INFO_NOQW
     * 本地库建立视图，空间库建立同名同义词
     */
    GPS_REALTIMEINFO_TABLENAME : "v_gps_user_realtime_info_fkqjk",
    
    GPS_REALTIMEINFO_TABLENAME_ZDCL : "V_GPS_USER_REALTIME_INFO_ZDCL",
    
    /**
     * 重点车辆--周边视频范围
     */
    ZDCL_ZBZY : {distance : 10000,
				layer : ["VIDEO_PT","KK_PT"],
				layerType : ["point","point"],
				nameField : ["MC","MC"]},
    
    /**
     * 监控点周边资源
     */
    JKD_ZBZY : {distance : 10000,
    			layer : ["VIDEO_PT","KK_PT"],
    			layerType : ["point","point"],
    			nameField : ["MC","MC"]}
};