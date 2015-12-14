    	var ezMap = null;
    	var ezMbr = null;
    	var markerObj = null;
    	var pointArray = null;
    	document.oncontextmenu = shuBiaoYouji;
	    /**
	      * @title:loadMap
	      * @description:加载地图
	      * @author: xu_haibo@founder.com
	      * @param：加载边界、点击进入标点状态     
	      * @date:2015-03-11 10:23:32
	      */
         function loadMap(){
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
	    	 if(bz!=2){
		    	 //ezMap._MapApp.addMapEventListener(EzEvent.MAP_CLICK,function(obj){moveMapToDrawPoint();});
		    	 //queryButton();
	    	 }
	    	 var title ='';
	    	 //if(xldx!=""&&xldy!=""){
	    	 //var points = new Point(xldx,xldy);
        	 //markerObjs = ezMap.initMarker(title,xldx,xldy,"jzw2.png",null,null,43,37);
    		 //ezMap._MapApp.addOverlay(markerObjs);
    		 //ezMap._MapApp.centerAtLatLng(points);
	    	 //}
	    	 if(xldx!=""&&xldy!=""){
	    		 initMarker(xldx,xldy);
	    	 }
	      };  
         /**
 	       * @title:loadMapBd
 	       * @description:加载当前用户所属机构的边界
 	       * @author: xu_haibo@founder.com
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
	       * @author: xu_haibo@founder.com
	       * @param：    
	       * @date:2015-03-11 14:52:21
	       */
         function moveMapToDrawPoint(){
        	 ezMap._MapApp.changeDragMode("drawPoint",null,null,function(obj){
        		 pointArray = obj.split(",");
        		 if(markerObj!=null){
        			 ezMap._MapApp.removeOverlay(markerObj);
 				 }
        		 markerObj = ezMap.initMarker("",pointArray[0],pointArray[1],"jzw2.png",null,null,43,37);
        		 ezMap._MapApp.addOverlay(markerObj);
        			 //$(document.body).mask("正在获取所属责任区、派出所信息...");
        			 //查询坐标点所属的派出所、责任区信息
					var judge = ezMap.AreaInPolygon(obj,bjzbz);
					if(judge){
						topMessager.confirm('','您确认要保存坐标数据吗？',function(r) {    
							if (r){
								parent.document.getElementById("xldx").value = pointArray[0];
	     				 		parent.document.getElementById("xldy").value = pointArray[1]; 
								$('#areabiaozhu').window('close');
							}else{
								ezMap._MapApp.removeOverlay(markerObj);
							}
						});
					}else{
						ezMap._MapApp.removeOverlay(markerObj);
						topMessager.show({
						title: MESSAGER_TITLE,
						msg: '坐标超出边界,请重新标点！',
						timeout:2500
						});
					}
        	 });
         };
         /**
	       * @title:moveMapToDrawPoint_back
	       * @description:标点_回调函数
	       * @author: xu_haibo@founder.com
	       * @param：    
	       * @date:2015-03-11 19:56:11
	       */
         function moveMapToDrawPoint_back(json){
        	 if(json){
        		 var message = ""
        		 if(json.pcsdm==null||json.pcsdm==""){
        			 message = "该坐标点暂无所属责任区、派出所信息，<br><br>请重新标注！";
        		 }else{
     				 //返回调用标点的页面【调用页面需要定义：entity_xldx、entity_xldy】
            		 parent.document.getElementById("xldx").value = pointArray[0];
     				 parent.document.getElementById("xldy").value = pointArray[1];
     				 message = "所属责任区："+json.zrqmc+"<br><br>所属派出所："+json.pcsmc;
        		 }
 				 topMessager.show({
					title: MESSAGER_TITLE,
					msg: message,
					timeout:3500
				 });
 				 $(document.body).unmask();
        	 }
         };
         /**
	       * @title:shuBiaoYouji
	       * @description:右键退出标注模式
	       * @author: xu_haibo@founder.com
	       * @param：pan【地图漫游模式】    
	       * @date:2015-03-11 15:05:24
	       */
         function shuBiaoYouji(){
	    	 ezMap._MapApp.changeDragMode("pan", null, null, null);
         };
         /**
	       * @title:queryButton
	       * @description:加载标点按钮
	       * @author: xu_haibo@founder.com
	       * @param：    
	       * @date:2015-03-11 15:11:32
	       */
         function queryButton(){
        	 var html = "<div style='position:absolute;right:8px;top:80px;width:40px;'>" +
	                    "<img id='img2' onclick='moveMapToDrawPoint()' style='cursor:hand;' title='点编辑模式' src='../images/map/icons/icon_ellip_select01.png'>&nbsp;&nbsp;" +
	                    "</div>";
			 $("#mapDiv").append(html);
         };
         /**
	       * @title:initMarker
	       * @description:坐标X、坐标Y不为空情况下展现已标点
	       * @author: xu_haibo@founder.com
	       * @param：    
	       * @date:2015-03-11 20:29:56
	       */
         function initMarker(xldx,xldy){
	    	 var point = new Point(xldx,xldy);
        	 markerObj = ezMap.initMarker(title,xldx,xldy,"jzw2.png",null,null,43,37);
    		 ezMap._MapApp.addOverlay(markerObj);
    		 ezMap._MapApp.centerAtLatLng(point);
         };