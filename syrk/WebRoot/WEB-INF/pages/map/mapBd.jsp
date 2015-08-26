<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String bjzbz = "";
    if(userInfo!=null){
        bjzbz = userInfo.getBjzbz();
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
  <head>
    <title>地图标点【返回X、Y坐标并且所属责任区、所属派出所信息】</title>
    <script type="text/javascript">
    	var bjzbz = "<%=bjzbz%>"; 
    	var ezMap = null;
    	var ezMbr = null;
    	var markerObj = null;
    	document.oncontextmenu = shuBiaoYouji;
	    /**
	      * @title:loadMapBd
	      * @description:加载地图
	      * @author: zhang_guoliang@founder.com
	      * @param：加载边界、点击进入标点状态     
	      * @date:2015-03-11 10:23:32
	      */
         function loadMapBd(){
	    	 ezMap = new FrameTools.Map();
	    	 ezMap.setProxy(contextPath + "/Proxy");
	    	 ezMap.setMapDiv("mapDiv");
	    	 ezMap.onloadMap();
	    	 ezMap.addOverView();
	    	 ezMap._MapApp.hideMapServer();
	    	 ezMap.showNewMapServer("mapDiv","ezMap");
	    	 if(bjzbz!="" && bjzbz!='null'){
	    		 moveMapToBjzbz();
	 	     }
	    	 ezMap._MapApp.addMapEventListener(EzEvent.MAP_CLICK,function(obj){moveMapToDrawPoint();});
	    	 queryButton();
	      };  
         /**
 	       * @title:loadMapBd
 	       * @description:加载当前用户所属机构的边界
 	       * @author: zhang_guoliang@founder.com
 	       * @param：bjzbz【边界坐标值】     
 	       * @date:2015-03-11 14:45:53
 	       */
         function moveMapToBjzbz(){
        	 ezMap._MapApp.clear();
        	 var bj = bjzbz.split(";");
        	 var bjnum = bj.length;
        	 for(var j=0;j<bjnum;j++){
        		 var gArr = bj[j];
        		 var polyline = ezMap.initPolyline(gArr,"blue");
        		 if(polyline){
        			 ezMap._MapApp.addOverlay(polyline);
        			 if(ezMbr==null){
        				 ezMbr = polyline.getMBR();
        			 }else{
        				 ezMbr = MBR.union(ezMbr,polyline.getMBR());
        			 }
        		 }
        	 }
        	 ezMap._MapApp.centerAtMBR(ezMbr);
        	 ezMap._MapApp.zoomOut();
         };
         /**
	       * @title:moveMapToDrawPoint
	       * @description:点击进入地图标注状态
	       * @author: zhang_guoliang@founder.com
	       * @param：    
	       * @date:2015-03-11 14:52:21
	       */
         function moveMapToDrawPoint(){
        	 ezMap._MapApp.changeDragMode("drawPoint",null,null,function(obj){
        		 var pointArray = obj.split(",");
        		 if(markerObj!=null){
        			 ezMap._MapApp.removeOverlay(markerObj);
 				 }
        		 markerObj = ezMap.initMarker("",pointArray[0],pointArray[1],"jzw2.png",null,null,43,37);
        		 ezMap._MapApp.addOverlay(markerObj);
        		 //返回调用标点的页面【调用页面需要定义：entity_zbx、entity_zby】
        		 parent.document.getElementById("entity_zbx").value = pointArray[0];
 				 parent.document.getElementById("entity_zby").value = pointArray[1];
        	 });
         };
         /**
	       * @title:shuBiaoYouji
	       * @description:右键退出标注模式
	       * @author: zhang_guoliang@founder.com
	       * @param：    
	       * @date:2015-03-11 15:05:24
	       */
         function shuBiaoYouji(){
	    	 ezMap._MapApp.changeDragMode("pan", null, null, null);
         };
         /**
	       * @title:queryButton
	       * @description:加载标点按钮
	       * @author: zhang_guoliang@founder.com
	       * @param：    
	       * @date:2015-03-11 15:11:32
	       */
         function queryButton(){
        	 var html = "<div style='position:absolute;right:8px;top:80px;width:40px;'>" +
	                    "<img id='img2' onclick='moveMapToDrawPoint()' style='cursor:hand;' title='点编辑模式' src='../images/map/icons/icon_ellip_select01.png'>&nbsp;&nbsp;" +
	                    "</div>";
			 $("#mapDiv").append(html);
         };
    </script>
  </head>
  <body onload="loadMapBd();" style="overflow: hidden;">
     <div id="mapDiv" style="width:100%;height:100%;"></div>
  </body>
</html>