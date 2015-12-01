<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"  xmlns:v="urn:schemas-microsoft-com:vml">
<head>
<%
	String contextPath = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgName = "";
    String userId = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName = userInfo.getUserOrgName();
        userId = userInfo.getUserId();
    }
%>
<title></title>
	<meta http-equiv="X-UA-Compatible" content="IE=7"/>
	<!-- <META http-equiv="X-UA-Compatible" content="IE=5" > </META> -->
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>project/base/css/body.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>framework/easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>framework/easyui/themes/icon.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>framework/easyui/demo/demo.css"/>
	<!-- jquery类库 -->
	<script type="text/javascript" src="<%=basePath%>framework/jquery-1.8.1.min.js"></script>
	<!-- easyUI类库 -->
	<script type="text/javascript" src="<%=basePath%>framework/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>framework/easyui/jquery.easyui.extend.js"></script>
	<script type="text/javascript" src="<%=basePath%>framework/easyui/mainFrame.js"></script>
	
	<!-- 系统全局配置类 -->
	<script type="text/javascript" src="<%=basePath%>common/config/SysConfig.js"></script>
	<script type="text/javascript">
		var path = "<%=basePath%>";
		path = path.substring(0, path.length-1);
		//设置EzBuilder客户端地址
		SysConfig.EZBUILDER_CLIENT_URL = "http://10.80.8.178:7001/POService40";
	</script>
	<!-- 系统公共工具类 -->
	<script type="text/javascript" src="<%=basePath%>common/tools/SysTool.js"></script>
	<!-- 系统权限工具类
	<script type="text/javascript" src="<%=basePath%>common/tools/SysPrivilege.js"></script> -->
	<!-- EzServerClient -->
	<script type="text/javascript">SysTool.loadJs(SysConfig.EZSERVER_DEV_URL,"GB2312");</script>
	
	<script type="text/javascript">SysTool.loadJs(SysConfig.EZBUILDER_DEV_URL,"UTF-8");</script> 
	<!-- EzBuilder4.0
		<script type="text/javascript" src="http://10.66.122.2:7002/POService/EzBuilderAPI/JavascriptApi/JsEzbuilder.js" charset="UTF-8"></script>-->
	
	<!-- 地理信息空间查询组件 -->
	<script type="text/javascript" src="<%=basePath%>common/tools/GeoQuery.js"></script>
	<!-- 地图工具组件 -->
	<script type="text/javascript" src="<%=basePath%>common/components/mapTool/js/mapTool.js"></script>
	<!-- 地图缩放组件 -->
	<script type="text/javascript" src="<%=basePath%>common/components/zoomMap/js/zoomMap.js"></script>
	<!-- 警情状态分类组件 -->
	<script type="text/javascript" src="<%=basePath%>common/components/stateControl/js/stateControl.js"></script>
	<!-- 地图气泡组件 -->
	<!-- <script type="text/javascript" src="<%=basePath%>common/components/mapBalloon/js/mapBalloon.js"></script> -->
	<script type="text/javascript" src="<%=basePath%>common/components/mapBubble/js/mapBubble.js"></script>
	<!-- 左侧layout组件 -->
	<script type="text/javascript" src="<%=basePath%>common/components/leftLayout/js/leftLayout.js"></script>
	<!-- mztreeview控件 -->
	<script type="text/javascript" src="<%=basePath%>framework/tree/scripts/jsframework.js"></script>
	<!-- 字典组件 -->
	<script type="text/javascript" src="<%=basePath%>common/components/dictionary/js/dictionary.js"></script>
    <script type="text/javascript" src="<%=basePath%>common/components/resource/js/resource.js"></script>
	<!-- 日期控件 -->
	<script type="text/javascript" src="<%=basePath%>framework/My97DatePicker/WdatePicker.js"></script>
	<!-- 滚动条控件 -->
	<script type="text/javascript" src="<%=basePath%>common/components/scrollBarTool/js/scrollBarTool.js"></script>
	<!-- 消息提醒 -->
	<script type="text/javascript" src="<%=basePath%>project/base/js/xxtx.js"></script>
	<!-- 警情信息 -->
	<script type='text/javascript' src="<%=basePath%>project/zhdd/js/jqxx.js"></script>
	<!-- 车辆布控 
	<script type="text/javascript" src="<%=basePath%>project/busiapp/jkd/js/clbk.js"></script>-->
	<!-- 多色预警配置 
	<script type="text/javascript" src="<%=basePath%>project/fxyp/js/dsyjpz.js"></script>-->
	<!-- 业务图层管理 -->
	<!-- <script type="text/javascript" src="<%=basePath%>common/tools/MapLayer.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/tools/MapLayerManager.js"></script> -->
	<!-- 系统timer -->
	<script type="text/javascript" src="<%=basePath%>common/tools/SysTimer.js"></script>
	<!-- highcharts类库 -->
	<script type="text/javascript" src="<%=basePath%>common/components/highcharts/highcharts.js"></script>
	<script type="text/javascript"><!--
			//操作人员组织机构代码
		    var zzjgdm = "<%=userOrgCode%>";
		    var jjrbh = "<%=userId%>";
			//dom加载完成，执行函数
			$(function() { 
			//设置系统名称
			//document.title = SysConfig.SYSTEM_NAME;
			// 初始化消息提醒
			//Xxtx.initXxtx("xxtxUl");
			//交通态势路况报警消息提醒
			//jtts.lkbjxxtx();
			//setInterval(function(){
				//Xxtx.initXxtx('xxtxUl');
				//jtts.lkbjxxtx();
			//}, 1000*30);// 初始化消息提醒（30秒钟执行一次）
			//load布局center部分内容
			//$("#idcenter").load("project/zhdd/index.jsp");
			//加载组织机构
			//$(".jigou").mouseover(function(){$(this).addClass('jigou_show');});
			//$(".jigou").mouseout(function(){$(this).removeClass('jigou_show');});
	  		//初始始化地图
			SysTool.initMap({mapContainerId:"mapContainer",zzjgdm:zzjgdm}, function(MapApp){
				//初始化缩放组件
				ZoomMap.init({mapApp: MapApp, mapContainerId: "mapContainer",zoomMinLevel:10});
				//初始化工具组件
				MapTool.init({mapApp: MapApp, mapContainerId: "mapContainer"});
				//初始化气泡框组件
				MapBubble.init({mapApp: MapApp, mapContainerId: "mapContainer"});
				
				_MapApp.centerAndZoom(new Point("121.59619","38.90576"),12);
			});
			//初始化页面
			//$(".load_div").load("project/zhdd/zhdd.jsp");
			// 调用树mztreeview插件
			Dictionary.usingTreePlugin();
			$(document).mouseup(function() { 
				Dictionary.hideDictionary();// 隐藏字典
				//$(".sysset_div").hide();
		    	//$(".ywtcdiv").hide();
			});
			//初始化系统权限
			//SysPrivilege.init(JSON.parse('${UserSession.funcJson}'), function(){
			//	SysPrivilege.dealWithModule();//处理模块权限（作用范围是base主页）
			//	SysPrivilege.dealWithFunction();//处理功能权限（作用范围是base主页）
			//});
			
			//初始化系统首页
			changeMenu(null,'load_div','ZHDD_PAGE');
			
		    //业务图层
		  //  $(".ywtc").click(function(){ 
		  //  	$(".ywtcdiv").show();
		  ///  	MapLayer.createHtml();
		  ////  });
		  //  $(".ywtcdiv").click(function(event){ 
		  //  	event.stopPropagation();
		  //  	$(".ywtcdiv").show();
		 ////   });
		    
	    });
	    
	    //退出系统
	    function logout() {
	        SysTool.confirm("您确定要退出系统吗？", function(r){
	        	if(r) {
	        		location.href = "logout.f";
	        	}
	        });
	    }
	    
	    //切换模块
	    function changeMenu(thisObj,divid, key) {     
	        var url = "/syrk/"+SysConfig.SYS_MENU_URL_JSON[key]["URL"];
	        var mode = SysConfig.SYS_MENU_URL_JSON[key]["MODE"];
	        if(mode == "LOAD" && url != null && url != "") {
	        	$("#idcenter").find(".load_div").hide();
	        	$("#"+divid).show();
	        	var html = $("#"+divid).html();
	        	SysTimer.clearAllTimer();
		        if(html == "") {
		        	$("#"+divid).load(url,function(){
		        		//处理功能权限（暂时无需控制）modify by gb 20141120
		        		//SysPrivilege.dealWithFunction();
		        		ZoomMap.setZoomToolLeftPosition(60); 
						MapTool.setMapToolLeftPosition(150);
						MapBubble.removeAll();
		        	});
		        }
	        	changeMenuStyle(thisObj);
	        	LeftLayout.cached.clear();
	        } else if(mode == "OPEN" && url != null && url != "") {
	        	window.open(url);
	        } else if(mode == "REPLACE" && url != null && url != ""){
	        	$("#idcenter").find(".load_div").hide();
	        	$("#load_div").empty();
	        	$("#load_div").show();
	        	SysTimer.clearAllTimer();
		        ZoomMap.setZoomToolLeftPosition(60);
				MapTool.setMapToolLeftPosition(150);
		        $("#load_div").load(url,function(){
		        	//处理功能权限（暂时无需控制）modify by gb 20141120
		        	//SysPrivilege.dealWithFunction();
					MapBubble.removeAll();
		        });
	        	changeMenuStyle(thisObj);
	        	LeftLayout.cached.clear();
	        }
	    }
	    
	    //切换模块样式
	    function changeMenuStyle(thisObj) {
	    	if(thisObj != null) {
		    	$(".top_menuul").find("a").removeClass("aon");
		    	$(thisObj).addClass("aon");
	    	}
	    }
	    
	    //修改系统配置菜单显示或隐藏
	    function toggleConfigMenu() {
	    	//$(".sysset_div").toggle();
	    }
	    
	    //EzMap.registerProx("${basePath}" + "/Proxy");
	    EzMap.registerProx("<%=basePath%>" + "Proxy");
	    
	--></script>
</head>

<body class="easyui-layout" style="overflow:visible">
	<input type="hidden" id="currentLoginUserOrgDm" value="${UserSession.zzjgdm}" />
	<input type="hidden" id="currentLoginUserOrgLx" value="${UserSession.zzjglx}" />
	<input type="hidden" id="currentLoginUserName" value="${userSession.userName}" />

	<!-- 布局center -->
	<div id="idcenter" data-options="region:'center',border:false" style="overflow:hidden;">
		<div class="nav_shadow"></div><!-- 阴影效果 -->
		<div class="body_map" id="mapContainer"></div><!-- 地图容器 -->
		<div class="load_div" id="load_div"></div><!-- 子系统操作页面容器 加载MODE为REPLACE才使用 -->
		<div class="load_div" id="load_div_0"></div><!-- 子系统操作页面容器 加载MODE为LOAD才使用-->
		<div class="load_div" id="load_div_1"></div>
		<div class="load_div" id="load_div_2"></div>
		<div class="load_div" id="load_div_3"></div>
		<div class="load_div" id="load_div_4"></div>
		<div class="load_div" id="load_div_5"></div>
		<div class="load_div" id="load_div_6"></div>
		<div class="load_div" id="load_div_7"></div>
		<div class="load_div" id="load_div_8"></div>
		<div class="load_div" id="load_div_9"></div>
	</div>
	<!-- 布局center -->
	<!-- 公用弹出窗口div -->
	<div id="tips_allwindow" style="display:none;"></div>
	<div id="tips_infowindow" style="display:none;"></div>
	<!-- /公用弹出窗口div -->
</body>
</html>
