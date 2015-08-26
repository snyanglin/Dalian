<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%><!-- 先引用jQuery -->
<%@ include file="/WEB-INF/pages/commonMap.jsp"%><!-- 再引用Map地图服务 -->
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        bjzbz = userInfo.getBjzbz();
    }
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v ="urn:schemas-microsoft-com:vml">
  <head>
    <title>地图调用demo2</title>
    <script type="text/javascript">
        var bjzbz = "<%=bjzbz%>";
	    if (typeof TestMap2 == "undefined" || !TestMap2) {
			var TestMap2 = {};
		};
		TestMap2.map = null;
		
        TestMap2.loadMap = function(){
        	TestMap2.map = new FrameTools.Map();
        	TestMap2.map.setMapDiv("map");
        	TestMap2.map.onloadMap();
        	TestMap2.map.addOverView();
        	
        	 TestMap2.moveMapToBjzbz();
        	 
        	 TestMap2.MapToDian();
        };
        TestMap2.moveMapToBjzbz = function(){
    	    /*清楚地图上所有的标记*/
    		TestMap2.map._MapApp.clear();
    		/*非地坐标*/
    		var bj = bjzbz.split(";");
    		var bjnum = bj.length;
    		/*记录边线中心点坐标*/
    		TestMap2.mbrArr = new Array();
    		for(var j=0;j<bjnum;j++){
    			var gArr = bj[j];
    			/*创建边界图元素*/
    			var polyline = TestMap2.map.initPolyline(gArr,"blue");
    			/*图元素添加到地图上*/
    			if(polyline){
    				TestMap2.map._MapApp.addOverlay(polyline);
    				
    				TestMap2.mbrArr.push(polyline);
    				if(TestMap2.Mbr==null){
    					TestMap2.Mbr = polyline.getMBR();
    				}else{
    					TestMap2.Mbr = MBR.union(TestMap2.Mbr,polyline.getMBR());
    				}
    			}
    		}
    		/*根据图元素将地图放到最适合的级别和位置*/
    		TestMap2.map._MapApp.centerAtMBR(TestMap2.Mbr);
    		/*新版本cliect自动适应级别有问题必须降一级*/
    		TestMap2.map._MapApp.zoomOut();
    	};
    	TestMap2.MapToDian = function(){
    		var initMarker1 = TestMap2.map.initMarker("测试点",121.46726,38.91204,"jz.png",null,null,32,54);
    		TestMap2.map._MapApp.addOverlay(initMarker1);
    		var ObjMap = new Polygon(bjzbz, "red", 3, 0.4,"#000000");
    		var pMbr = ObjMap.getMBR();
    		var cPoint = pMbr.centerPoint();
    		var _pTitle = new Title("测试辖区",12,7,"宋体","#000000","#FFFFFF","#FFFFFF","2");
    		_pTitle.setPoint(cPoint);
    		TestMap2.map._MapApp.addOverlay(ObjMap);
    		TestMap2.map._MapApp.addOverlay(_pTitle);
    		/*加载地图工具条*/
    		//TestMap2.map.buildTools("map","toolDiv","TestMap2.map");
    		//var left = $("#map").offset().left-230;
    		//var top = $("#map").height() - 40;
    		//$("#toolDiv").css({
    		//	"top" : top,
    		//	"left" : left
    		//});
    	}
    </script>
  </head>
  <body onload="TestMap2.loadMap()">
    <div id="map"></div>
    <div id="toolDiv" style="position: absolute;filter: alpha(opacity=90);"></div>
  </body>
</html>